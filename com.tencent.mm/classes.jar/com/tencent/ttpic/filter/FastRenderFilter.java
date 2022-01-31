package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.h;
import com.tencent.filter.m;
import com.tencent.filter.m.b;
import com.tencent.filter.m.i;
import com.tencent.filter.m.j;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.shader.Shader;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FastRenderFilter
{
  private static final String FRAGMENT_SHADER;
  private static final int MAX_DRAW_PER_RENDER = 8;
  private static final String VERTEX_SHADER;
  private boolean hasBlendMode;
  protected int height;
  private Map<String, AttributeParam> mAttrParams;
  private int mCoordNum;
  private Map<String, m> mParamList;
  protected double mScreenScale;
  private Shader shader;
  protected int width;
  
  static
  {
    AppMethodBeat.i(82515);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FastRenderVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FastRenderFragmentShader.dat");
    AppMethodBeat.o(82515);
  }
  
  public FastRenderFilter()
  {
    this(new Shader(VERTEX_SHADER, FRAGMENT_SHADER));
    AppMethodBeat.i(82489);
    AppMethodBeat.o(82489);
  }
  
  private FastRenderFilter(Shader paramShader)
  {
    AppMethodBeat.i(82490);
    this.hasBlendMode = false;
    this.shader = paramShader;
    this.mAttrParams = new HashMap();
    this.mParamList = new HashMap();
    AppMethodBeat.o(82490);
  }
  
  private boolean mergeRenderParams(List<RenderParam> paramList)
  {
    AppMethodBeat.i(82501);
    boolean bool = mergeRenderParams(paramList, false);
    AppMethodBeat.o(82501);
    return bool;
  }
  
  private boolean mergeRenderParams(List<RenderParam> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(82502);
    int i;
    Object localObject;
    int j;
    int k;
    int m;
    if (!paramList.isEmpty())
    {
      i = paramList.size();
      localObject = new float[((RenderParam)paramList.get(0)).position.length * i];
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        while (j < ((RenderParam)paramList.get(i)).position.length)
        {
          localObject[(((RenderParam)paramList.get(i)).position.length * i + j)] = ((RenderParam)paramList.get(i)).position[j];
          j += 1;
        }
        i += 1;
      }
      setPositions((float[])localObject);
      localObject = new float[paramList.size() * GlUtil.ORIGIN_TEX_COORDS_TRIANGLES.length];
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        while (j < ((RenderParam)paramList.get(i)).texCords.length)
        {
          localObject[(((RenderParam)paramList.get(i)).texCords.length * i + j)] = ((RenderParam)paramList.get(i)).texCords[j];
          j += 1;
        }
        i += 1;
      }
      setTexCords((float[])localObject);
      localObject = new float[paramList.size() * 6];
      if (paramBoolean)
      {
        k = ((RenderParam)paramList.get(0)).texture;
        i = 0;
        j = 0;
        if (j >= localObject.length) {
          break label384;
        }
        m = j / 6;
        if (((RenderParam)paramList.get(m)).texture == k) {
          break label963;
        }
        k = ((RenderParam)paramList.get(m)).texture;
        i += 1;
      }
    }
    label384:
    label963:
    for (;;)
    {
      localObject[j] = (i + 0.5F);
      j += 1;
      break;
      i = 0;
      while (i < localObject.length)
      {
        localObject[i] = (i / 6 + 0.5F);
        i += 1;
      }
      addAttribParam(new AttributeParam("a_stickerIndex", (float[])localObject, 1));
      localObject = new float[paramList.size() * 6 * 2];
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        while (j < 12)
        {
          localObject[(i * 6 * 2 + j)] = ((RenderParam)paramList.get(i)).texAnchor[(j % 2)];
          j += 1;
        }
        i += 1;
      }
      addAttribParam(new AttributeParam("texAnchor", (float[])localObject, 2));
      localObject = new float[paramList.size() * 6 * 1];
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        while (j < 6)
        {
          localObject[(i * 6 + j)] = ((RenderParam)paramList.get(i)).texScale;
          j += 1;
        }
        i += 1;
      }
      addAttribParam(new AttributeParam("texScale", (float[])localObject, 1));
      localObject = new float[paramList.size() * 6 * 3];
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        while (j < 18)
        {
          localObject[(i * 6 * 3 + j)] = ((RenderParam)paramList.get(i)).texRotate[(j % 3)];
          j += 1;
        }
        i += 1;
      }
      addAttribParam(new AttributeParam("texRotate", (float[])localObject, 3));
      if (paramBoolean)
      {
        int n = ((RenderParam)paramList.get(0)).texture;
        i = 0;
        m = 0;
        if (i < paramList.size())
        {
          k = n;
          j = m;
          if (((RenderParam)paramList.get(i)).texture != n)
          {
            j = m + 1;
            k = ((RenderParam)paramList.get(i)).texture;
          }
          localObject = "inputImageTexture".concat(String.valueOf(j));
          n = ((RenderParam)paramList.get(i)).texture;
          if (this.hasBlendMode) {}
          for (m = 1;; m = 0)
          {
            addParam(new m.n((String)localObject, n, m + (33984 + j)));
            i += 1;
            n = k;
            m = j;
            break;
          }
        }
      }
      else
      {
        i = 0;
        if (i < paramList.size())
        {
          localObject = "inputImageTexture".concat(String.valueOf(i));
          k = ((RenderParam)paramList.get(i)).texture;
          if (this.hasBlendMode) {}
          for (j = 1;; j = 0)
          {
            addParam(new m.n((String)localObject, k, j + (33984 + i)));
            i += 1;
            break;
          }
        }
      }
      setCoordNum(paramList.size() * 6);
      AppMethodBeat.o(82502);
      return true;
      AppMethodBeat.o(82502);
      return false;
    }
  }
  
  private List<List<RenderParam>> splitRenderParams(List<RenderParam> paramList)
  {
    AppMethodBeat.i(82508);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size() / 8 + 1)
    {
      int m = i * 8;
      int k = m + 8;
      int j = k;
      if (k > paramList.size()) {
        j = paramList.size();
      }
      localArrayList.add(paramList.subList(m, j));
      i += 1;
    }
    AppMethodBeat.o(82508);
    return localArrayList;
  }
  
  private List<List<RenderParam>> splitRenderParams(List<RenderParam> paramList, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(82507);
    int k;
    if (paramBoolean)
    {
      ArrayList localArrayList = new ArrayList();
      k = ((RenderParam)paramList.get(0)).texture;
      localObject1 = new ArrayList();
      i = 1;
      if (j < paramList.size())
      {
        RenderParam localRenderParam = (RenderParam)paramList.get(j);
        if (localRenderParam.texture == k) {
          ((List)localObject1).add(localRenderParam);
        }
        for (;;)
        {
          j += 1;
          break;
          k = i + 1;
          i = k;
          Object localObject2 = localObject1;
          if (k > 8)
          {
            localArrayList.add(localObject1);
            localObject2 = new ArrayList();
            i = 1;
          }
          ((List)localObject2).add(localRenderParam);
          k = localRenderParam.texture;
          localObject1 = localObject2;
        }
      }
      localArrayList.add(localObject1);
      AppMethodBeat.o(82507);
      return localArrayList;
    }
    Object localObject1 = new ArrayList();
    while (i < paramList.size() / 8 + 1)
    {
      int m = i * 8;
      k = m + 8;
      j = k;
      if (k > paramList.size()) {
        j = paramList.size();
      }
      ((List)localObject1).add(paramList.subList(m, j));
      i += 1;
    }
    AppMethodBeat.o(82507);
    return localObject1;
  }
  
  public void OnDrawFrameGLSL()
  {
    AppMethodBeat.i(82509);
    this.shader.bind();
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).setParams(this.shader.getShaderProgram());
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext())
    {
      AttributeParam localAttributeParam = (AttributeParam)localIterator.next();
      if (localAttributeParam.handle >= 0) {
        localAttributeParam.setParams(this.shader.getShaderProgram());
      }
    }
    AppMethodBeat.o(82509);
  }
  
  public void addAttribParam(AttributeParam paramAttributeParam)
  {
    AppMethodBeat.i(82497);
    if (paramAttributeParam == null)
    {
      AppMethodBeat.o(82497);
      return;
    }
    AttributeParam localAttributeParam2 = (AttributeParam)this.mAttrParams.get(paramAttributeParam.name);
    AttributeParam localAttributeParam1 = localAttributeParam2;
    if (localAttributeParam2 == null)
    {
      localAttributeParam1 = new AttributeParam(paramAttributeParam.name, paramAttributeParam.vertices, paramAttributeParam.perVertexFloat, false);
      this.mAttrParams.put(paramAttributeParam.name, localAttributeParam1);
    }
    localAttributeParam1.setVertices(paramAttributeParam.vertices);
    localAttributeParam1.perVertexFloat = paramAttributeParam.perVertexFloat;
    AppMethodBeat.o(82497);
  }
  
  public void addAttribParam(String paramString, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(82495);
    addAttribParam(paramString, paramArrayOfFloat, false);
    AppMethodBeat.o(82495);
  }
  
  public void addAttribParam(String paramString, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(82496);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(82496);
      return;
    }
    AttributeParam localAttributeParam2 = (AttributeParam)this.mAttrParams.get(paramString);
    AttributeParam localAttributeParam1 = localAttributeParam2;
    if (localAttributeParam2 == null)
    {
      localAttributeParam1 = new AttributeParam(paramString, paramArrayOfFloat, paramBoolean);
      this.mAttrParams.put(paramString, localAttributeParam1);
    }
    localAttributeParam1.setVertices(paramArrayOfFloat);
    AppMethodBeat.o(82496);
  }
  
  public void addParam(m paramm)
  {
    AppMethodBeat.i(82499);
    if (paramm == null)
    {
      AppMethodBeat.o(82499);
      return;
    }
    m localm = (m)this.mParamList.get(paramm.name);
    if (localm == null)
    {
      this.mParamList.put(paramm.name, paramm);
      AppMethodBeat.o(82499);
      return;
    }
    paramm.handle = localm.handle;
    this.mParamList.put(paramm.name, paramm);
    AppMethodBeat.o(82499);
  }
  
  public void applyGLSLFilter()
  {
    AppMethodBeat.i(82491);
    initAttribParams();
    this.shader.compile();
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).initialParams(this.shader.getShaderProgram());
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).initialParams(this.shader.getShaderProgram());
    }
    AppMethodBeat.o(82491);
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(82514);
    this.shader.clear();
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).clear();
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).clear();
    }
    AppMethodBeat.o(82514);
  }
  
  public AttributeParam getAttribParam(String paramString)
  {
    AppMethodBeat.i(82498);
    paramString = (AttributeParam)this.mAttrParams.get(paramString);
    AppMethodBeat.o(82498);
    return paramString;
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82492);
    setPositions(GlUtil.ORIGIN_TEX_COORDS_TRIANGLES);
    setTexCords(new float[] { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    setCoordNum(4);
    addAttribParam(new AttributeParam("a_stickerIndex", new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F }, 1));
    addAttribParam(new AttributeParam("texAnchor", new float[] { 0.0F, 0.0F }, 2));
    addAttribParam(new AttributeParam("texScale", new float[] { 0.0F }, 1));
    addAttribParam(new AttributeParam("texRotate", new float[] { 0.0F, 0.0F, 0.0F }, 3));
    initParams();
    AppMethodBeat.o(82492);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82500);
    addParam(new m.i("texNeedTransform", 1));
    addParam(new m.i("blendMode", 0));
    addParam(new m.b("canvasSize", 0.0F, 0.0F));
    addParam(new m.j("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
    addParam(new m.n("canvas", 0, 33986));
    int i = 0;
    while (i <= 7)
    {
      addParam(new m.n("inputImageTexture".concat(String.valueOf(i)), 0, 33986));
      i += 1;
    }
    AppMethodBeat.o(82500);
  }
  
  public void render(int paramInt, List<RenderParam> paramList, h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(82504);
    if (paramInt > 0) {
      addParam(new m.n("canvas", paramInt, 33984));
    }
    render(paramList, paramh, paramBoolean);
    AppMethodBeat.o(82504);
  }
  
  public void render(List<RenderParam> paramList, h paramh)
  {
    AppMethodBeat.i(82506);
    render(paramList, paramh, false);
    AppMethodBeat.o(82506);
  }
  
  public void render(List<RenderParam> paramList, h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(82505);
    if (paramList.size() > 0)
    {
      if (paramh != null)
      {
        addParam(new m.b("canvasSize", paramh.width, paramh.height));
        paramh.a(-1, paramh.width, paramh.height, 0.0D);
      }
      while (paramBoolean)
      {
        Collections.sort(paramList, new FastRenderFilter.1(this));
        paramList = splitRenderParams(paramList, true).iterator();
        for (;;)
        {
          if (paramList.hasNext()) {
            if (mergeRenderParams((List)paramList.next(), true))
            {
              OnDrawFrameGLSL();
              renderTexture();
              continue;
              addParam(new m.b("canvasSize", this.width, this.height));
              break;
            }
          }
        }
        AppMethodBeat.o(82505);
        return;
      }
      paramList = splitRenderParams(paramList).iterator();
      while (paramList.hasNext()) {
        if (mergeRenderParams((List)paramList.next()))
        {
          OnDrawFrameGLSL();
          renderTexture();
        }
      }
    }
    AppMethodBeat.o(82505);
  }
  
  public void renderTexture()
  {
    AppMethodBeat.i(82503);
    GLES20.glDrawArrays(4, 0, this.mCoordNum);
    GLES20.glFlush();
    AppMethodBeat.o(82503);
  }
  
  public void setBlendMode(int paramInt)
  {
    AppMethodBeat.i(82493);
    addParam(new m.i("blendMode", paramInt));
    this.hasBlendMode = true;
    AppMethodBeat.o(82493);
  }
  
  public boolean setCoordNum(int paramInt)
  {
    this.mCoordNum = paramInt;
    return true;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(82510);
    addAttribParam("position", paramArrayOfFloat);
    AppMethodBeat.o(82510);
    return true;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(82512);
    addAttribParam("position", paramArrayOfFloat, paramBoolean);
    AppMethodBeat.o(82512);
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(82511);
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat);
    AppMethodBeat.o(82511);
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(82513);
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat, paramBoolean);
    AppMethodBeat.o(82513);
    return true;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82494);
    this.width = paramInt1;
    this.height = paramInt2;
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
    AppMethodBeat.o(82494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.FastRenderFilter
 * JD-Core Version:    0.7.0.1
 */