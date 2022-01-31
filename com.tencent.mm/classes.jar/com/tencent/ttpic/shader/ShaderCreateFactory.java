package com.tencent.ttpic.shader;

import android.text.TextUtils;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;

public class ShaderCreateFactory
{
  private static final String FRAGMENT_SHADER_IMAGE_FILE;
  private static final String FRAGMENT_SHADER_VIDEO_FILE = "MCCommonFragmentShaderVideo.dat";
  private static final String SHADER_DIR = "camera/camera_video/shader/";
  
  static
  {
    if (VideoModule.es_GL_EXT_shader_framebuffer_fetch) {}
    for (String str = "MCCommonFragmentShaderImageExt.dat";; str = "MCCommonFragmentShaderImage.dat")
    {
      FRAGMENT_SHADER_IMAGE_FILE = str;
      return;
    }
  }
  
  public static Shader createShader(ShaderCreateFactory.PROGRAM_TYPE paramPROGRAM_TYPE)
  {
    if (paramPROGRAM_TYPE == null) {
      return null;
    }
    String str1 = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/" + paramPROGRAM_TYPE.vertexShaderFile);
    String str2 = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/" + paramPROGRAM_TYPE.fragmentShaderFile);
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
      new StringBuilder("can't find shader file: ").append(paramPROGRAM_TYPE.vertexShaderFile).append(" or ").append(paramPROGRAM_TYPE.fragmentShaderFile);
    }
    return new Shader(str1, str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.shader.ShaderCreateFactory
 * JD-Core Version:    0.7.0.1
 */