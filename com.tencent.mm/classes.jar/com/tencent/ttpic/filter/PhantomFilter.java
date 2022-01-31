package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.model.PhantomItem;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhantomFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER;
  private static final String TAG;
  public static final String VERTEX_SHADER;
  private final int MAX_ITEM_SIZE;
  private List<Bitmap> bitmaps;
  private List<PhantomItem> items;
  private long mLastTimestamp;
  private List<String> maskNames;
  
  static
  {
    AppMethodBeat.i(82730);
    TAG = PhantomFilter.class.getSimpleName();
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/PhantomVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/PhantomFragmentShader.dat");
    AppMethodBeat.o(82730);
  }
  
  public PhantomFilter(List<PhantomItem> paramList)
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(82727);
    this.MAX_ITEM_SIZE = 8;
    this.maskNames = new ArrayList();
    this.bitmaps = new ArrayList();
    this.items = null;
    this.mLastTimestamp = 0L;
    this.items = paramList;
    initParams();
    AppMethodBeat.o(82727);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82728);
    float[] arrayOfFloat1 = new float[8];
    float[] arrayOfFloat2 = new float[8];
    float[] arrayOfFloat3 = new float[8];
    float[] arrayOfFloat4 = new float[8];
    float[] arrayOfFloat5 = new float[8];
    Iterator localIterator = this.items.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      PhantomItem localPhantomItem = (PhantomItem)localIterator.next();
      if (i <= 8)
      {
        label100:
        int j;
        Object localObject;
        if (localPhantomItem.getScale() != 0.0D)
        {
          arrayOfFloat2[(i - 1)] = ((float)(1.0D / localPhantomItem.getScale()));
          arrayOfFloat3[(i - 1)] = ((float)localPhantomItem.getOpacity());
          arrayOfFloat1[(i - 1)] = localPhantomItem.getBlendMode();
          arrayOfFloat4[(i - 1)] = ((float)localPhantomItem.getxOffset());
          arrayOfFloat5[(i - 1)] = ((float)localPhantomItem.getyOffset());
          localPhantomItem.setXtime(localPhantomItem.getxRange()[0]);
          localPhantomItem.setYtime(localPhantomItem.getyRange()[0]);
          j = this.maskNames.indexOf(localPhantomItem.getMaskImage());
          if (j >= 0) {
            break label367;
          }
          localObject = localPhantomItem.getDataPath() + File.separator + localPhantomItem.getMaskImage();
          if (!((String)localObject).startsWith("assets://")) {
            break label353;
          }
          localObject = BitmapUtils.decodeSampledBitmapFromAssets(VideoGlobalContext.getContext(), FileUtils.getRealPath((String)localObject), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
          label250:
          if (BitmapUtils.isLegal((Bitmap)localObject))
          {
            this.maskNames.add(localPhantomItem.getMaskImage());
            this.bitmaps.add(localObject);
            addParam(new m.k("inputImageTexture_".concat(String.valueOf(i)), (Bitmap)localObject, 33985 + i, true));
            new StringBuilder("PhantomFitler inputImageTexuture_").append(i).append(" mask bitmap loaded. ").append(localPhantomItem.getMaskImage());
          }
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfFloat2[(i - 1)] = 1.0F;
          break label100;
          label353:
          localObject = BitmapUtils.decodeSampledBitmapFromFile((String)localObject, MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
          break label250;
          label367:
          addParam(new m.k("inputImageTexture_".concat(String.valueOf(i)), (Bitmap)this.bitmaps.get(j), 33985 + i, true));
          new StringBuilder("PhantomFitler inputImageTexuture_").append(i).append(" mask bitmap already loaded. ").append(localPhantomItem.getMaskImage());
        }
      }
    }
    addParam(new m.i("itemCount", this.items.size()));
    addParam(new m.g("scale", arrayOfFloat2));
    addParam(new m.g("opacity", arrayOfFloat3));
    addParam(new m.g("blendMode", arrayOfFloat1));
    addParam(new m.g("offsetX", arrayOfFloat4));
    addParam(new m.g("offsetY", arrayOfFloat5));
    AppMethodBeat.o(82728);
  }
  
  public void updatePreview(long paramLong)
  {
    AppMethodBeat.i(82729);
    if (this.mLastTimestamp == 0L) {
      this.mLastTimestamp = paramLong;
    }
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    long l;
    for (paramLong = 0L;; paramLong -= l)
    {
      arrayOfFloat1 = new float[8];
      arrayOfFloat2 = new float[8];
      Iterator localIterator = this.items.iterator();
      int i = 1;
      while (localIterator.hasNext())
      {
        PhantomItem localPhantomItem = (PhantomItem)localIterator.next();
        localPhantomItem.makeXStep(paramLong);
        double d1 = Math.toRadians(localPhantomItem.getXtime());
        double d2 = localPhantomItem.getxK();
        double d3 = localPhantomItem.getxAsin();
        double d4 = Math.sin(localPhantomItem.getxPhase() + d1);
        double d5 = localPhantomItem.getxBcos();
        arrayOfFloat1[(i - 1)] = ((float)(Math.cos(d1 + localPhantomItem.getyPhase()) * d5 + (d2 * d1 + d3 * d4) + localPhantomItem.getxOffset()));
        localPhantomItem.makeYStep(paramLong);
        d1 = Math.toRadians(localPhantomItem.getYtime());
        d2 = localPhantomItem.getyK();
        d3 = localPhantomItem.getyAsin();
        d4 = Math.sin(localPhantomItem.getyPhase() + d1);
        d5 = localPhantomItem.getyBcos();
        arrayOfFloat2[(i - 1)] = ((float)(Math.cos(d1 + localPhantomItem.getyPhase()) * d5 + (d2 * d1 + d3 * d4) + localPhantomItem.getyOffset()));
        i += 1;
      }
      l = this.mLastTimestamp;
      this.mLastTimestamp = paramLong;
    }
    addParam(new m.g("offsetX", arrayOfFloat1));
    addParam(new m.g("offsetY", arrayOfFloat2));
    AppMethodBeat.o(82729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.PhantomFilter
 * JD-Core Version:    0.7.0.1
 */