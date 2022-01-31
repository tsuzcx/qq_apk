package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.filter.m.d;
import com.tencent.filter.m.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.glmodel.Sphere;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;

public class ThreeDimFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER;
  private static final String VERTEX_SHADER;
  private StickerItem item;
  private Sphere mSphere;
  private String materialId;
  
  static
  {
    AppMethodBeat.i(83010);
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/ThreeDimVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleFragmentShader.dat");
    AppMethodBeat.o(83010);
  }
  
  public ThreeDimFilter(StickerItem paramStickerItem, String paramString)
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    AppMethodBeat.i(83004);
    this.item = paramStickerItem;
    this.mSphere = new Sphere(3, 1.0F);
    this.dataPath = paramString;
    this.materialId = VideoMaterialUtil.getMaterialId(paramString);
    initParams();
    AppMethodBeat.o(83004);
  }
  
  private Bitmap getNextFrame(int paramInt)
  {
    AppMethodBeat.i(83009);
    new StringBuilder().append(this.materialId).append(File.separator).append(this.item.id).append("_").append(paramInt).append(".png");
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    AppMethodBeat.o(83009);
    return localBitmap;
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(83006);
    super.initAttribParams();
    addAttribParam(new AttributeParam("color", new float[1], 3));
    AppMethodBeat.o(83006);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(83005);
    addParam(new m.d("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new m.j("u_MVPMatrix", MatrixUtil.getMVPMatrix(2.0F, 1.0F, 3.0F)));
    AppMethodBeat.o(83005);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(83008);
    GLES20.glDisable(3042);
    GLES20.glEnable(2929);
    GLES20.glDepthFunc(515);
    GLES20.glDepthMask(true);
    GLES20.glClear(256);
    this.mSphere.draw(getAttribParam("position").handle, getAttribParam("inputTextureCoordinate").handle, getAttribParam("color").handle, this.mSTextureHandle);
    GLES20.glDisable(2929);
    AppMethodBeat.o(83008);
    return true;
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(83007);
    if ((paramPTDetectInfo.faceAngles == null) || (paramPTDetectInfo.faceAngles.length < 3))
    {
      AppMethodBeat.o(83007);
      return;
    }
    addParam(new m.d("texRotate", paramPTDetectInfo.faceAngles[0] * 2.0F, paramPTDetectInfo.faceAngles[1] * 2.0F, paramPTDetectInfo.faceAngles[2]));
    this.mSphere.loadGLTexture(getNextFrame(0));
    AppMethodBeat.o(83007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.ThreeDimFilter
 * JD-Core Version:    0.7.0.1
 */