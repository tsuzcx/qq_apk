package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.filter.DynamicNumFilter;
import com.tencent.ttpic.filter.DynamicStickerFilter;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.StaticNumFilter;
import com.tencent.ttpic.filter.StaticStickerFilter;
import com.tencent.ttpic.filter.WatermarkDynamicFilter;
import com.tencent.ttpic.filter.WatermarkStaticFilter;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;

public class VideoFilterFactory
{
  public static final String FRAGMENT_SHADER_IMAGE;
  public static final String FRAGMENT_SHADER_MASK;
  public static final String LEFT_RIGHT_VERTEX_SHADER;
  public static final String UP_DOWN_VERTEX_SHADER;
  public static final String VERTEX_SHADER_COMMON;
  
  static
  {
    AppMethodBeat.i(83986);
    LEFT_RIGHT_VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonLRVertexShader.dat");
    UP_DOWN_VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonUDVertexShader.dat");
    if (VideoModule.es_GL_EXT_shader_framebuffer_fetch) {}
    for (String str = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonFragmentShaderImageExt.dat");; str = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonFragmentShaderImage.dat"))
    {
      FRAGMENT_SHADER_IMAGE = str;
      VERTEX_SHADER_COMMON = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonVertexShader.dat");
      FRAGMENT_SHADER_MASK = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/OrigFragmentShader.dat");
      AppMethodBeat.o(83986);
      return;
    }
  }
  
  public static NormalVideoFilter createFilter(StickerItem paramStickerItem, String paramString)
  {
    AppMethodBeat.i(83985);
    if (paramStickerItem == null)
    {
      AppMethodBeat.o(83985);
      return null;
    }
    if (paramStickerItem.markMode == 0) {
      if ((paramStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.NORMAL.type) || (paramStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_LEFT_RIGHT.type) || (paramStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) || (paramStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.FACE_FEATURE.type) || (paramStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.ETC.type)) {
        if ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type)) {
          paramString = new StaticStickerFilter(paramStickerItem, paramString);
        }
      }
    }
    for (;;)
    {
      if (paramString == null)
      {
        AppMethodBeat.o(83985);
        return null;
        if ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.GESTURE.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.BODY.type))
        {
          paramString = new DynamicStickerFilter(paramStickerItem, paramString);
          continue;
          if ((paramStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.WATERMARK.type) && (paramStickerItem.transition == null))
          {
            if ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type))
            {
              paramString = new WatermarkStaticFilter(paramStickerItem, paramString);
              continue;
            }
            if ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.GESTURE.type))
            {
              paramString = new WatermarkDynamicFilter(paramStickerItem, paramString);
              continue;
              if (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type)
              {
                paramString = new StaticNumFilter(paramStickerItem, paramString);
                continue;
              }
              if (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) {
                paramString = new DynamicNumFilter(paramStickerItem, paramString);
              }
            }
          }
        }
      }
      else
      {
        if (paramStickerItem.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN) {
          paramString.updateFilterShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_UP_DOWN);
        }
        for (;;)
        {
          if (paramStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.ETC.type) {
            paramString.updateFilterShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_ETC);
          }
          AppMethodBeat.o(83985);
          return paramString;
          if (paramStickerItem.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT) {
            paramString.updateFilterShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_LEFT_RIGHT);
          }
        }
      }
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoFilterFactory
 * JD-Core Version:    0.7.0.1
 */