package com.tencent.ttpic.shader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class ShaderCreateFactory
{
  private static final String FRAGMENT_SHADER_ETC_FILE;
  private static final String FRAGMENT_SHADER_IMAGE_FILE;
  private static final String FRAGMENT_SHADER_VIDEO_FILE;
  private static final String SHADER_DIR = "camera/camera_video/shader/";
  
  static
  {
    if (VideoModule.es_GL_EXT_shader_framebuffer_fetch)
    {
      str = "MCCommonFragmentShaderImageExt.dat";
      FRAGMENT_SHADER_IMAGE_FILE = str;
      if (!VideoModule.es_GL_EXT_shader_framebuffer_fetch) {
        break label46;
      }
      str = "MCCommonFragmentShaderVideoExt.dat";
      label22:
      FRAGMENT_SHADER_VIDEO_FILE = str;
      if (!VideoModule.es_GL_EXT_shader_framebuffer_fetch) {
        break label52;
      }
    }
    label46:
    label52:
    for (String str = "MCCommonFragmentShaderETCExt.dat";; str = "MCCommonFragmentShaderETC.dat")
    {
      FRAGMENT_SHADER_ETC_FILE = str;
      return;
      str = "MCCommonFragmentShaderImage.dat";
      break;
      str = "MCCommonFragmentShaderVideo.dat";
      break label22;
    }
  }
  
  public static Shader createShader(ShaderCreateFactory.PROGRAM_TYPE paramPROGRAM_TYPE)
  {
    AppMethodBeat.i(83732);
    if (paramPROGRAM_TYPE == null)
    {
      AppMethodBeat.o(83732);
      return null;
    }
    paramPROGRAM_TYPE = new Shader(FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/" + paramPROGRAM_TYPE.vertexShaderFile), FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/" + paramPROGRAM_TYPE.fragmentShaderFile));
    AppMethodBeat.o(83732);
    return paramPROGRAM_TYPE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.shader.ShaderCreateFactory
 * JD-Core Version:    0.7.0.1
 */