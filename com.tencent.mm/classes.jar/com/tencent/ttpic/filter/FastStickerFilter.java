package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.h;
import com.tencent.filter.m.b;
import com.tencent.filter.m.i;
import com.tencent.filter.m.j;
import com.tencent.filter.m.n;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.FastDynamicSticker;
import com.tencent.ttpic.model.FastStaticSticker;
import com.tencent.ttpic.model.FastSticker;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoFilterUtil.RATIO_MODE;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FastStickerFilter
  extends VideoFilterBase
{
  private String TAG = FastStickerFilter.class.getSimpleName();
  private int faceCount;
  private List<RenderParam> renderParams = new ArrayList();
  private RenderParam srcRenderParam;
  private List<FastSticker> stickerList = new ArrayList();
  
  public FastStickerFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.FAST_STICKER);
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLES);
  }
  
  private void mergeRenderParam(RenderParam paramRenderParam, List<RenderParam> paramList)
  {
    BenchUtil.benchStart("mergeRenderParam");
    if (paramRenderParam != null) {}
    float[] arrayOfFloat1;
    float[] arrayOfFloat2;
    float[] arrayOfFloat3;
    float[] arrayOfFloat4;
    float[] arrayOfFloat5;
    float[] arrayOfFloat6;
    for (int j = 1;; j = 0)
    {
      arrayOfFloat1 = new float[(paramList.size() + j) * VideoFilterUtil.EMPTY_POSITIONS_TRIANGLES.length];
      arrayOfFloat2 = new float[(paramList.size() + j) * VideoFilterUtil.ORIGIN_TEX_COORDS_TRIANGLES.length];
      arrayOfFloat3 = new float[(paramList.size() + j) * 6];
      arrayOfFloat4 = new float[(paramList.size() + j) * 6 * 2];
      arrayOfFloat5 = new float[(paramList.size() + j) * 6 * 1];
      arrayOfFloat6 = new float[(paramList.size() + j) * 6 * 3];
      if (paramRenderParam == null) {
        break label1004;
      }
      i = 0;
      while (i < paramRenderParam.position.length)
      {
        arrayOfFloat1[i] = paramRenderParam.position[i];
        i += 1;
      }
    }
    int i = 0;
    while (i < VideoFilterUtil.ORIGIN_TEX_COORDS_TRIANGLES.length)
    {
      arrayOfFloat2[i] = VideoFilterUtil.ORIGIN_TEX_COORDS_TRIANGLES[i];
      i += 1;
    }
    i = 0;
    while (i < 6)
    {
      arrayOfFloat3[i] = 0.5F;
      i += 1;
    }
    i = 0;
    while (i < 12)
    {
      arrayOfFloat4[i] = paramRenderParam.texAnchor[(i % 2)];
      i += 1;
    }
    i = 0;
    while (i < 6)
    {
      arrayOfFloat5[i] = paramRenderParam.texScale;
      i += 1;
    }
    i = 0;
    while (i < 18)
    {
      arrayOfFloat6[i] = paramRenderParam.texRotate[(i % 3)];
      i += 1;
    }
    addParam(new m.n("inputImageTexture0", paramRenderParam.texture, 33985));
    label1004:
    for (i = 1;; i = 0)
    {
      if (!paramList.isEmpty())
      {
        int k = i;
        int m = 0;
        int n;
        while (m < paramList.size())
        {
          n = 0;
          while (n < ((RenderParam)paramList.get(m)).position.length)
          {
            arrayOfFloat1[(((RenderParam)paramList.get(m)).position.length * k + n)] = ((RenderParam)paramList.get(m)).position[n];
            n += 1;
          }
          m += 1;
          k += 1;
        }
        k = 0;
        m = i;
        while (k < paramList.size())
        {
          n = 0;
          while (n < VideoFilterUtil.ORIGIN_TEX_COORDS_TRIANGLES.length)
          {
            arrayOfFloat2[(VideoFilterUtil.ORIGIN_TEX_COORDS_TRIANGLES.length * m + n)] = VideoFilterUtil.ORIGIN_TEX_COORDS_TRIANGLES[n];
            n += 1;
          }
          m += 1;
          k += 1;
        }
        m = 0;
        k = i;
        while (m < this.faceCount)
        {
          n = 0;
          while (n < paramList.size() * 6 / this.faceCount)
          {
            arrayOfFloat3[(k * 6 + n)] = ((i * 6 + n) / 6 + 0.5F);
            n += 1;
          }
          m += 1;
          k += paramList.size() / this.faceCount;
        }
        k = i;
        m = 0;
        while (m < paramList.size())
        {
          n = 0;
          while (n < 12)
          {
            arrayOfFloat4[(k * 6 * 2 + n)] = ((RenderParam)paramList.get(m)).texAnchor[(n % 2)];
            n += 1;
          }
          m += 1;
          k += 1;
        }
        k = i;
        m = 0;
        while (m < paramList.size())
        {
          n = 0;
          while (n < 6)
          {
            arrayOfFloat5[(k * 6 + n)] = ((RenderParam)paramList.get(m)).texScale;
            n += 1;
          }
          m += 1;
          k += 1;
        }
        k = i;
        m = 0;
        while (m < paramList.size())
        {
          n = 0;
          while (n < 18)
          {
            arrayOfFloat6[(k * 6 * 3 + n)] = ((RenderParam)paramList.get(m)).texRotate[(n % 3)];
            n += 1;
          }
          m += 1;
          k += 1;
        }
        k = 0;
        while (k < paramList.size() / this.faceCount)
        {
          addParam(new m.n("inputImageTexture" + i, ((RenderParam)paramList.get(k)).texture, 33985 + i));
          i += 1;
          k += 1;
        }
      }
      setPositions(arrayOfFloat1);
      setTexCords(arrayOfFloat2);
      setCoordNum((paramList.size() + j) * 6);
      addAttribParam(new AttributeParam("a_stickerIndex", arrayOfFloat3, 1));
      addAttribParam(new AttributeParam("texAnchor", arrayOfFloat4, 2));
      addAttribParam(new AttributeParam("texScale", arrayOfFloat5, 1));
      addAttribParam(new AttributeParam("texRotate", arrayOfFloat6, 3));
      BenchUtil.benchEnd("mergeRenderParam");
      return;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).ApplyGLSLFilter();
    }
  }
  
  public void addSrcTexture(int paramInt)
  {
    if (paramInt > 0)
    {
      this.srcRenderParam = new RenderParam();
      this.srcRenderParam.texture = paramInt;
      this.srcRenderParam.position = AlgoUtils.calPositionsTriangles(0.0F, this.height, this.width, 0.0F, this.width, this.height);
      this.srcRenderParam.texScale = 1.0F;
    }
  }
  
  public void addSticker(StickerItem paramStickerItem, String paramString)
  {
    if ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type)) {
      this.stickerList.add(new FastStaticSticker(paramStickerItem, paramString));
    }
    while ((paramStickerItem.type != VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) && (paramStickerItem.type != VideoFilterFactory.POSITION_TYPE.GESTURE.type)) {
      return;
    }
    this.stickerList.add(new FastDynamicSticker(paramStickerItem, paramString));
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).destroy();
    }
  }
  
  public void destroyAudio()
  {
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).destroyAudio();
    }
  }
  
  public int getStickerListSize()
  {
    return this.stickerList.size();
  }
  
  public void initAttribParams()
  {
    setPositions(VideoFilterUtil.ORIGIN_TEX_COORDS_TRIANGLES);
    setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    setCoordNum(4);
    addAttribParam(new AttributeParam("a_stickerIndex", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 1));
    addAttribParam(new AttributeParam("texAnchor", new float[] { 0.0F, 0.0F }, 2));
    addAttribParam(new AttributeParam("texScale", new float[] { 0.0F }, 1));
    addAttribParam(new AttributeParam("texRotate", new float[] { 0.0F, 0.0F, 0.0F }, 3));
    initParams();
  }
  
  public void initParams()
  {
    addParam(new m.i("texNeedTransform", 1));
    addParam(new m.b("canvasSize", 0.0F, 0.0F));
    addParam(new m.j("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
    int i = 0;
    while (i <= 7)
    {
      addParam(new m.n("inputImageTexture" + i, 0, 33986));
      i += 1;
    }
  }
  
  public void render(h paramh)
  {
    if (((!this.renderParams.isEmpty()) && (this.faceCount > 0)) || (this.srcRenderParam != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        mergeRenderParam(this.srcRenderParam, this.renderParams);
        RenderProcess(paramh.texture[0], paramh.width, paramh.height, -1, 0.0D, paramh);
      }
      this.renderParams.clear();
      this.srcRenderParam = null;
      return;
    }
  }
  
  public void setFaceCount(int paramInt)
  {
    this.faceCount = paramInt;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    addAttribParam("position", paramArrayOfFloat);
    return true;
  }
  
  public void setRatioMode(VideoFilterUtil.RATIO_MODE paramRATIO_MODE)
  {
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext())
    {
      FastSticker localFastSticker = (FastSticker)localIterator.next();
      if ((localFastSticker instanceof FastStaticSticker)) {
        ((FastStaticSticker)localFastSticker).setRatioMode(paramRATIO_MODE);
      }
    }
  }
  
  public void setRenderParams(int paramInt)
  {
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext())
    {
      FastSticker localFastSticker = (FastSticker)localIterator.next();
      if (localFastSticker.needRender(paramInt)) {
        this.renderParams.add(localFastSticker.getRenderParam().copy());
      }
    }
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat);
    return true;
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong)
  {
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).updatePreview(paramList1, paramArrayOfFloat, paramMap, paramList2, paramMap1, paramSet, paramFloat, paramLong);
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.filter.FastStickerFilter
 * JD-Core Version:    0.7.0.1
 */