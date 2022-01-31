package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.h;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaptureActItem
  extends FrameSourceItem
{
  private static final String TAG = CaptureActItem.class.getSimpleName();
  private int[] captureTimes;
  private BaseFilter copyFilter = new BaseFilter(GLSLRender.bcE);
  private h[] copyFrames;
  private String dataPath;
  private List<ExpressionItem> expressionList;
  private String imageId;
  private int lastCaptureIndex = -1;
  private int[] numTextures = new int[10];
  private final Random random;
  private CaptureActItem.ScoreTag[] scores;
  private List<float[]> starFaceAngles;
  private List<List<PointF>> starFacePoints;
  
  public CaptureActItem(List<ExpressionItem> paramList, String paramString1, String paramString2, BaseFilter paramBaseFilter)
  {
    super(paramBaseFilter);
    this.expressionList = paramList;
    this.dataPath = paramString1;
    this.imageId = paramString2;
    this.starFacePoints = new ArrayList(paramList.size());
    this.starFaceAngles = new ArrayList(paramList.size());
    this.captureTimes = new int[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      paramString1 = (ExpressionItem)paramList.get(i);
      this.starFacePoints.add(paramString1.expressionFeat);
      this.starFaceAngles.add(paramString1.expressionAngle);
      this.captureTimes[i] = paramString1.expressionTime;
      i += 1;
    }
    this.scores = new CaptureActItem.ScoreTag[paramList.size()];
    i = 0;
    while (i < this.scores.length)
    {
      this.scores[i] = new CaptureActItem.ScoreTag(null);
      i += 1;
    }
    this.copyFrames = new h[paramList.size()];
    i = j;
    while (i < this.copyFrames.length)
    {
      this.copyFrames[i] = new h();
      i += 1;
    }
    this.random = new Random(System.currentTimeMillis());
  }
  
  private int getCaptureIndex(long paramLong)
  {
    if ((this.lastCaptureIndex + 1 < this.captureTimes.length) && (paramLong >= this.captureTimes[(this.lastCaptureIndex + 1)]))
    {
      this.lastCaptureIndex += 1;
      return this.lastCaptureIndex;
    }
    return -1;
  }
  
  public void clear()
  {
    this.copyFilter.ClearGLSL();
    Object localObject1 = this.copyFrames;
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.clear();
      }
      i += 1;
    }
    localObject1 = this.scores;
    j = localObject1.length;
    i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (localObject2.texId != null)
      {
        GLES20.glDeleteTextures(localObject2.texId.length, localObject2.texId, 0);
        localObject2.texId = null;
      }
      i += 1;
    }
  }
  
  public int getOrigHeight(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.copyFrames.length)) {
      return -1;
    }
    return this.copyFrames[paramInt].height;
  }
  
  public int getOrigWidth(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.copyFrames.length)) {
      return -1;
    }
    return this.copyFrames[paramInt].width;
  }
  
  public int getScore(CanvasItem paramCanvasItem)
  {
    this.scores[paramCanvasItem.index].hasShowed = true;
    return this.scores[paramCanvasItem.index].score;
  }
  
  public int[] getScoreTexture(CanvasItem paramCanvasItem)
  {
    if (this.scores[paramCanvasItem.index].texId != null) {
      return this.scores[paramCanvasItem.index].texId;
    }
    return this.numTextures;
  }
  
  public int getTexture(CanvasItem paramCanvasItem, long paramLong)
  {
    return this.copyFrames[paramCanvasItem.index].texture[0];
  }
  
  public int getTotalScore()
  {
    CaptureActItem.ScoreTag[] arrayOfScoreTag = this.scores;
    int m = arrayOfScoreTag.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      CaptureActItem.ScoreTag localScoreTag = arrayOfScoreTag[i];
      k = j;
      if (localScoreTag.hasShowed) {
        k = j + localScoreTag.score;
      }
      i += 1;
    }
    return j;
  }
  
  public int[] getTotalScoreTexture()
  {
    return this.numTextures;
  }
  
  public void init()
  {
    this.copyFilter.ApplyGLSLFilter();
    GLES20.glGenTextures(this.numTextures.length, this.numTextures, 0);
    int i = 0;
    Object localObject;
    while (i < 10)
    {
      localObject = VideoBitmapUtil.decodeSampleBitmap(VideoGlobalContext.getContext(), this.dataPath + File.separator + "expression" + File.separator + this.imageId + File.separator + this.imageId + "_" + i + ".png", 720, 1280);
      if (VideoBitmapUtil.isLegal((Bitmap)localObject))
      {
        GlUtil.loadTexture(this.numTextures[i], (Bitmap)localObject);
        ((Bitmap)localObject).recycle();
      }
      i += 1;
    }
    i = 0;
    while (i < this.expressionList.size())
    {
      localObject = ((ExpressionItem)this.expressionList.get(i)).scoreImageID;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int[] arrayOfInt = new int[10];
        GLES20.glGenTextures(10, arrayOfInt, 0);
        int j = 0;
        while (j < 10)
        {
          Bitmap localBitmap = VideoBitmapUtil.decodeSampleBitmap(VideoGlobalContext.getContext(), this.dataPath + File.separator + "expression" + File.separator + (String)localObject + File.separator + (String)localObject + "_" + j + ".png", 720, 1280);
          if (VideoBitmapUtil.isLegal(localBitmap))
          {
            GlUtil.loadTexture(arrayOfInt[j], localBitmap);
            localBitmap.recycle();
          }
          j += 1;
        }
        this.scores[i].texId = arrayOfInt;
      }
      i += 1;
    }
  }
  
  public void reset()
  {
    this.lastCaptureIndex = -1;
    int i = 0;
    while (i < this.scores.length)
    {
      this.scores[i].score = 0;
      this.scores[i].hasShowed = false;
      i += 1;
    }
  }
  
  public void update(h paramh, long paramLong, List<List<PointF>> paramList, List<float[]> paramList1, double paramDouble, int paramInt)
  {
    super.update(paramh, paramLong, paramList, paramList1, paramDouble, paramInt);
    int i = getCaptureIndex(paramLong);
    if (i >= 0)
    {
      BenchUtil.benchStart(TAG + "[update]");
      this.copyFilter.RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, this.copyFrames[i]);
      BenchUtil.benchEnd(TAG + "[update]");
      if ((paramList.size() > 0) && (paramInt == 0))
      {
        BenchUtil.benchStart(TAG + "[calculate score]");
        this.scores[i].score = ((int)ActUtil.getExpressionSimilarity((List)this.starFacePoints.get(i), (List)paramList.get(0), (float[])this.starFaceAngles.get(i), (float[])paramList1.get(0), ((ExpressionItem)this.expressionList.get(i)).expressionWeight));
        BenchUtil.benchEnd(TAG + "[calculate score]");
      }
    }
    else
    {
      return;
    }
    this.scores[i].score = (this.random.nextInt(5) + 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.model.CaptureActItem
 * JD-Core Version:    0.7.0.1
 */