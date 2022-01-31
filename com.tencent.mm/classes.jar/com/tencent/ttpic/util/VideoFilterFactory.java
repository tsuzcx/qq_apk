package com.tencent.ttpic.util;

import com.tencent.ttpic.VideoModule;
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
  public static final String LEFT_RIGHT_VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonLRVertexShader.dat");
  public static final String UP_DOWN_VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonUDVertexShader.dat");
  public static final String VERTEX_SHADER_COMMON;
  
  static
  {
    if (VideoModule.es_GL_EXT_shader_framebuffer_fetch) {}
    for (String str = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonFragmentShaderImageExt.dat");; str = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonFragmentShaderImage.dat"))
    {
      FRAGMENT_SHADER_IMAGE = str;
      VERTEX_SHADER_COMMON = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonVertexShader.dat");
      FRAGMENT_SHADER_MASK = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/OrigFragmentShader.dat");
      return;
    }
  }
  
  public static NormalVideoFilter createFilter(StickerItem paramStickerItem, String paramString)
  {
    if (paramStickerItem == null) {}
    for (;;)
    {
      return null;
      if (paramStickerItem.markMode == 0) {
        if ((paramStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.NORMAL.type) || (paramStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_LEFT_RIGHT.type) || (paramStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type)) {
          if ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type)) {
            paramString = new StaticStickerFilter(paramStickerItem, paramString);
          }
        }
      }
      while (paramString != null)
      {
        if (paramStickerItem.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN) {
          paramString.updateFilterShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_UP_DOWN);
        }
        for (;;)
        {
          return paramString;
          if ((paramStickerItem.type != VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) && (paramStickerItem.type != VideoFilterFactory.POSITION_TYPE.GESTURE.type)) {
            break label313;
          }
          paramString = new DynamicStickerFilter(paramStickerItem, paramString);
          break;
          if (paramStickerItem.stickerType != VideoFilterFactory.STICKER_TYPE.WATERMARK.type) {
            break label313;
          }
          if ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type))
          {
            paramString = new WatermarkStaticFilter(paramStickerItem, paramString);
            break;
          }
          if ((paramStickerItem.type != VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) && (paramStickerItem.type != VideoFilterFactory.POSITION_TYPE.GESTURE.type)) {
            break label313;
          }
          paramString = new WatermarkDynamicFilter(paramStickerItem, paramString);
          break;
          if (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type)
          {
            paramString = new StaticNumFilter(paramStickerItem, paramString);
            break;
          }
          if (paramStickerItem.type != VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) {
            break label313;
          }
          paramString = new DynamicNumFilter(paramStickerItem, paramString);
          break;
          if (paramStickerItem.sourceType == VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT) {
            paramString.updateFilterShader(ShaderCreateFactory.PROGRAM_TYPE.STICKER_LEFT_RIGHT);
          }
        }
        label313:
        paramString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoFilterFactory
 * JD-Core Version:    0.7.0.1
 */