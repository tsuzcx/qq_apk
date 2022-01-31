package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.h;
import com.tencent.filter.m;
import com.tencent.filter.m.b;
import com.tencent.filter.m.i;
import com.tencent.filter.m.j;
import com.tencent.filter.m.n;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.model.RenderParam;
import com.tencent.ttpic.shader.Shader;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FastRenderFilter
{
  private static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FastRenderFragmentShader.dat");
  private static final int MAX_DRAW_PER_RENDER = 8;
  private static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FastRenderVertexShader.dat");
  protected int height;
  private Map<String, AttributeParam> mAttrParams;
  private int mCoordNum;
  private Map<String, m> mParamList;
  protected double mScreenScale;
  private Shader shader;
  protected int width;
  
  public FastRenderFilter()
  {
    this(new Shader(VERTEX_SHADER, FRAGMENT_SHADER));
  }
  
  private FastRenderFilter(Shader paramShader)
  {
    this.shader = paramShader;
    this.mAttrParams = new HashMap();
    this.mParamList = new HashMap();
  }
  
  private boolean mergeRenderParams(List<RenderParam> paramList)
  {
    boolean bool = false;
    int k = 0;
    if (!paramList.isEmpty())
    {
      int i = paramList.size();
      float[] arrayOfFloat = new float[((RenderParam)paramList.get(0)).position.length * i];
      i = 0;
      int j;
      while (i < paramList.size())
      {
        j = 0;
        while (j < ((RenderParam)paramList.get(i)).position.length)
        {
          arrayOfFloat[(((RenderParam)paramList.get(i)).position.length * i + j)] = ((RenderParam)paramList.get(i)).position[j];
          j += 1;
        }
        i += 1;
      }
      setPositions(arrayOfFloat);
      arrayOfFloat = new float[paramList.size() * VideoFilterUtil.ORIGIN_TEX_COORDS_TRIANGLES.length];
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        while (j < ((RenderParam)paramList.get(i)).texCords.length)
        {
          arrayOfFloat[(((RenderParam)paramList.get(i)).texCords.length * i + j)] = ((RenderParam)paramList.get(i)).texCords[j];
          j += 1;
        }
        i += 1;
      }
      setTexCords(arrayOfFloat);
      arrayOfFloat = new float[paramList.size() * 6];
      i = 0;
      while (i < arrayOfFloat.length)
      {
        arrayOfFloat[i] = (i / 6 + 0.5F);
        i += 1;
      }
      addAttribParam(new AttributeParam("a_stickerIndex", arrayOfFloat, 1));
      arrayOfFloat = new float[paramList.size() * 6 * 2];
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        while (j < 12)
        {
          arrayOfFloat[(i * 6 * 2 + j)] = ((RenderParam)paramList.get(i)).texAnchor[(j % 2)];
          j += 1;
        }
        i += 1;
      }
      addAttribParam(new AttributeParam("texAnchor", arrayOfFloat, 2));
      arrayOfFloat = new float[paramList.size() * 6 * 1];
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        while (j < 6)
        {
          arrayOfFloat[(i * 6 + j)] = ((RenderParam)paramList.get(i)).texScale;
          j += 1;
        }
        i += 1;
      }
      addAttribParam(new AttributeParam("texScale", arrayOfFloat, 1));
      arrayOfFloat = new float[paramList.size() * 6 * 3];
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        while (j < 18)
        {
          arrayOfFloat[(i * 6 * 3 + j)] = ((RenderParam)paramList.get(i)).texRotate[(j % 3)];
          j += 1;
        }
        i += 1;
      }
      addAttribParam(new AttributeParam("texRotate", arrayOfFloat, 3));
      i = k;
      while (i < paramList.size())
      {
        addParam(new m.n("inputImageTexture" + i, ((RenderParam)paramList.get(i)).texture, 33984 + i));
        i += 1;
      }
      setCoordNum(paramList.size() * 6);
      bool = true;
    }
    return bool;
  }
  
  private List<List<RenderParam>> splitRenderParams(List<RenderParam> paramList)
  {
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
    return localArrayList;
  }
  
  public void OnDrawFrameGLSL()
  {
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
  }
  
  public void addAttribParam(AttributeParam paramAttributeParam)
  {
    if (paramAttributeParam == null) {
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
  }
  
  public void addAttribParam(String paramString, float[] paramArrayOfFloat)
  {
    addAttribParam(paramString, paramArrayOfFloat, false);
  }
  
  public void addAttribParam(String paramString, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
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
  }
  
  public void addParam(m paramm)
  {
    if (paramm == null) {
      return;
    }
    m localm = (m)this.mParamList.get(paramm.name);
    if (localm == null)
    {
      this.mParamList.put(paramm.name, paramm);
      return;
    }
    paramm.handle = localm.handle;
    this.mParamList.put(paramm.name, paramm);
  }
  
  public void applyGLSLFilter()
  {
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
  }
  
  public void clearGLSLSelf()
  {
    this.shader.clear();
    Iterator localIterator = this.mParamList.values().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).clear();
    }
    localIterator = this.mAttrParams.values().iterator();
    while (localIterator.hasNext()) {
      ((AttributeParam)localIterator.next()).clear();
    }
  }
  
  public AttributeParam getAttribParam(String paramString)
  {
    return (AttributeParam)this.mAttrParams.get(paramString);
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
  
  public void render(List<RenderParam> paramList, h paramh)
  {
    if (paramList.size() > 0)
    {
      addParam(new m.b("canvasSize", paramh.width, paramh.height));
      paramh.a(-1, paramh.width, paramh.height, 0.0D);
      paramList = splitRenderParams(paramList).iterator();
      while (paramList.hasNext()) {
        if (mergeRenderParams((List)paramList.next()))
        {
          OnDrawFrameGLSL();
          renderTexture();
        }
      }
    }
  }
  
  public void renderTexture()
  {
    GLES20.glDrawArrays(4, 0, this.mCoordNum);
    GLES20.glFlush();
  }
  
  public boolean setCoordNum(int paramInt)
  {
    this.mCoordNum = paramInt;
    return true;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat)
  {
    addAttribParam("position", paramArrayOfFloat);
    return true;
  }
  
  public boolean setPositions(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    addAttribParam("position", paramArrayOfFloat, paramBoolean);
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat)
  {
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat);
    return true;
  }
  
  public boolean setTexCords(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    addAttribParam("inputTextureCoordinate", paramArrayOfFloat, paramBoolean);
    return true;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.filter.FastRenderFilter
 * JD-Core Version:    0.7.0.1
 */