package com.tencent.ttpic.filter;

import com.tencent.filter.h;
import com.tencent.filter.m.b;
import com.tencent.filter.m.i;
import com.tencent.filter.m.j;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.FastDynamicSticker;
import com.tencent.ttpic.model.FastStaticSticker;
import com.tencent.ttpic.model.FastSticker;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE;
import com.tencent.ttpic.util.VideoFilterUtil.RATIO_MODE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FastStickerFilter
  extends VideoFilterBase
{
  private String TAG;
  private int faceCount;
  private List<RenderParam> renderParams;
  private RenderParam srcRenderParam;
  private List<FastSticker> stickerList;
  
  public FastStickerFilter()
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.FAST_STICKER);
    AppMethodBeat.i(82516);
    this.TAG = FastStickerFilter.class.getSimpleName();
    this.stickerList = new ArrayList();
    this.renderParams = new ArrayList();
    initParams();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLES);
    AppMethodBeat.o(82516);
  }
  
  private void mergeRenderParam(RenderParam paramRenderParam, List<RenderParam> paramList)
  {
    AppMethodBeat.i(82522);
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
      arrayOfFloat1 = new float[(paramList.size() + j) * GlUtil.EMPTY_POSITIONS_TRIANGLES.length];
      arrayOfFloat2 = new float[(paramList.size() + j) * GlUtil.ORIGIN_TEX_COORDS_TRIANGLES.length];
      arrayOfFloat3 = new float[(paramList.size() + j) * 6];
      arrayOfFloat4 = new float[(paramList.size() + j) * 6 * 2];
      arrayOfFloat5 = new float[(paramList.size() + j) * 6 * 1];
      arrayOfFloat6 = new float[(paramList.size() + j) * 6 * 3];
      if (paramRenderParam == null) {
        break label1019;
      }
      i = 0;
      while (i < paramRenderParam.position.length)
      {
        arrayOfFloat1[i] = paramRenderParam.position[i];
        i += 1;
      }
    }
    int i = 0;
    while (i < GlUtil.ORIGIN_TEX_COORDS_TRIANGLES.length)
    {
      arrayOfFloat2[i] = GlUtil.ORIGIN_TEX_COORDS_TRIANGLES[i];
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
    label1019:
    for (i = 1;; i = 0)
    {
      if (!paramList.isEmpty())
      {
        paramRenderParam = new HashMap();
        int k = 0;
        int m = i;
        int n;
        while (k < paramList.size())
        {
          RenderParam localRenderParam = (RenderParam)paramList.get(k);
          if (!paramRenderParam.containsKey(localRenderParam.id))
          {
            paramRenderParam.put(localRenderParam.id, Integer.valueOf(m));
            addParam(new m.n("inputImageTexture".concat(String.valueOf(m)), ((RenderParam)paramList.get(k)).texture, 33985 + m));
          }
          n = 0;
          while (n < 6)
          {
            arrayOfFloat3[(m * 6 + n)] = (((Integer)paramRenderParam.get(((RenderParam)paramList.get(k)).id)).intValue() + 0.5F);
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
          while (n < ((RenderParam)paramList.get(k)).position.length)
          {
            arrayOfFloat1[(((RenderParam)paramList.get(k)).position.length * m + n)] = ((RenderParam)paramList.get(k)).position[n];
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
          while (n < GlUtil.ORIGIN_TEX_COORDS_TRIANGLES.length)
          {
            arrayOfFloat2[(GlUtil.ORIGIN_TEX_COORDS_TRIANGLES.length * m + n)] = GlUtil.ORIGIN_TEX_COORDS_TRIANGLES[n];
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
          while (n < 12)
          {
            arrayOfFloat4[(m * 6 * 2 + n)] = ((RenderParam)paramList.get(k)).texAnchor[(n % 2)];
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
          while (n < 6)
          {
            arrayOfFloat5[(m * 6 + n)] = ((RenderParam)paramList.get(k)).texScale;
            n += 1;
          }
          m += 1;
          k += 1;
        }
        k = 0;
        while (k < paramList.size())
        {
          m = 0;
          while (m < 18)
          {
            arrayOfFloat6[(i * 6 * 3 + m)] = ((RenderParam)paramList.get(k)).texRotate[(m % 3)];
            m += 1;
          }
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
      AppMethodBeat.o(82522);
      return;
    }
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82517);
    super.ApplyGLSLFilter();
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).ApplyGLSLFilter();
    }
    AppMethodBeat.o(82517);
  }
  
  public void addSrcTexture(int paramInt)
  {
    AppMethodBeat.i(82519);
    if (paramInt > 0)
    {
      this.srcRenderParam = new RenderParam();
      this.srcRenderParam.texture = paramInt;
      this.srcRenderParam.position = AlgoUtils.calPositionsTriangles(0.0F, this.height, this.width, 0.0F, this.width, this.height);
      this.srcRenderParam.texScale = 1.0F;
    }
    AppMethodBeat.o(82519);
  }
  
  public void addSticker(StickerItem paramStickerItem, String paramString)
  {
    AppMethodBeat.i(82529);
    if ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type))
    {
      this.stickerList.add(new FastStaticSticker(paramStickerItem, paramString));
      AppMethodBeat.o(82529);
      return;
    }
    if ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.BODY.type)) {
      this.stickerList.add(new FastDynamicSticker(paramStickerItem, paramString));
    }
    AppMethodBeat.o(82529);
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(82532);
    super.clearGLSLSelf();
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).destroy();
    }
    AppMethodBeat.o(82532);
  }
  
  public void destroyAudio()
  {
    AppMethodBeat.i(82531);
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).destroyAudio();
    }
    AppMethodBeat.o(82531);
  }
  
  public int getStickerListSize()
  {
    AppMethodBeat.i(82530);
    int i = this.stickerList.size();
    AppMethodBeat.o(82530);
    return i;
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82528);
    setPositions(GlUtil.ORIGIN_TEX_COORDS_TRIANGLES);
    setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    setCoordNum(4);
    addAttribParam(new AttributeParam("a_stickerIndex", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 1));
    addAttribParam(new AttributeParam("texAnchor", new float[] { 0.0F, 0.0F }, 2));
    addAttribParam(new AttributeParam("texScale", new float[] { 0.0F }, 1));
    addAttribParam(new AttributeParam("texRotate", new float[] { 0.0F, 0.0F, 0.0F }, 3));
    AppMethodBeat.o(82528);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82523);
    addParam(new m.i("texNeedTransform", 1));
    addParam(new m.b("canvasSize", 0.0F, 0.0F));
    addParam(new m.j("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
    int i = 0;
    while (i <= 7)
    {
      addParam(new m.n("inputImageTexture".concat(String.valueOf(i)), 0, 33986));
      i += 1;
    }
    AppMethodBeat.o(82523);
  }
  
  public void render(h paramh)
  {
    AppMethodBeat.i(82521);
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
      AppMethodBeat.o(82521);
      return;
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(82533);
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).reset();
    }
    AppMethodBeat.o(82533);
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    AppMethodBeat.i(82534);
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).setAudioPause(paramBoolean);
    }
    AppMethodBeat.o(82534);
  }
  
  public void setFaceCount(int paramInt)
  {
    this.faceCount = paramInt;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(82526);
    addAttribParam("position", paramArrayOfFloat);
    AppMethodBeat.o(82526);
    return true;
  }
  
  public void setRatioMode(VideoFilterUtil.RATIO_MODE paramRATIO_MODE)
  {
    AppMethodBeat.i(82525);
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext())
    {
      FastSticker localFastSticker = (FastSticker)localIterator.next();
      if ((localFastSticker instanceof FastStaticSticker)) {
        ((FastStaticSticker)localFastSticker).setRatioMode(paramRATIO_MODE);
      }
    }
    AppMethodBeat.o(82525);
  }
  
  public void setRenderParams(int paramInt)
  {
    AppMethodBeat.i(82520);
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext())
    {
      FastSticker localFastSticker = (FastSticker)localIterator.next();
      if (localFastSticker.needRender(paramInt)) {
        this.renderParams.add(localFastSticker.getRenderParam().copy());
      }
    }
    AppMethodBeat.o(82520);
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(82527);
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat);
    AppMethodBeat.o(82527);
    return true;
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(82518);
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).updatePreview(paramPTDetectInfo);
    }
    AppMethodBeat.o(82518);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(82524);
    this.width = paramInt1;
    this.height = paramInt2;
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
    Iterator localIterator = this.stickerList.iterator();
    while (localIterator.hasNext()) {
      ((FastSticker)localIterator.next()).updateVideoSize(paramInt1, paramInt2, paramDouble);
    }
    AppMethodBeat.o(82524);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.filter.FastStickerFilter
 * JD-Core Version:    0.7.0.1
 */