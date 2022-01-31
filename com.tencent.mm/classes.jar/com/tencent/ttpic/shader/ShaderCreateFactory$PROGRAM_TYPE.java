package com.tencent.ttpic.shader;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ShaderCreateFactory$PROGRAM_TYPE
{
  public final String fragmentShaderFile;
  public final String vertexShaderFile;
  
  static
  {
    AppMethodBeat.i(83731);
    STICKER_NORMAL = new PROGRAM_TYPE("STICKER_NORMAL", 0, "MCCommonVertexShader.dat", ShaderCreateFactory.access$000());
    STICKER_UP_DOWN = new PROGRAM_TYPE("STICKER_UP_DOWN", 1, "MCCommonUDVertexShader.dat", ShaderCreateFactory.access$100());
    STICKER_LEFT_RIGHT = new PROGRAM_TYPE("STICKER_LEFT_RIGHT", 2, "MCCommonLRVertexShader.dat", ShaderCreateFactory.access$100());
    STICKER_ETC = new PROGRAM_TYPE("STICKER_ETC", 3, "MCCommonVertexShader.dat", ShaderCreateFactory.access$200());
    FAST_STICKER = new PROGRAM_TYPE("FAST_STICKER", 4, "FastRenderVertexShader.dat", "FastRenderFragmentShader.dat");
    TRANSFORM = new PROGRAM_TYPE("TRANSFORM", 5, "TransformVertexShader.dat", "TransformFragmentShader.dat");
    FACEOFF = new PROGRAM_TYPE("FACEOFF", 6, "FaceOffVertexShader.dat", "FaceOffFragmentShader.dat");
    CFFACEOFF = new PROGRAM_TYPE("CFFACEOFF", 7, "CFFaceOffVertexShader.dat", "CFFaceOffFragmentShader.dat");
    SNAKE_FACE = new PROGRAM_TYPE("SNAKE_FACE", 8, "SnakeFaceVertexShader.dat", "SimpleFragmentShader.dat");
    DOODLE = new PROGRAM_TYPE("DOODLE", 9, "DoodleVertexShader.dat", "DoodleFragmentShader.dat");
    FACE_CROP = new PROGRAM_TYPE("FACE_CROP", 10, "FaceCropVertexShader.dat", "FaceCropFragmentShader.dat");
    HEAD_CROP = new PROGRAM_TYPE("HEAD_CROP", 11, "HeadCropVertexShader.dat", "HeadCropFragmentShader.dat");
    LOOKUP = new PROGRAM_TYPE("LOOKUP", 12, "LookupVertexShader.dat", "LookupFragmentShader.dat");
    ROTATE_SCALE = new PROGRAM_TYPE("ROTATE_SCALE", 13, "RotateScaleVertexShader.dat", "RotateScaleFragmentShader.dat");
    SHAKA_TRIPLE_FACE_TRANSFORM = new PROGRAM_TYPE("SHAKA_TRIPLE_FACE_TRANSFORM", 14, "SimpleVertexShader.dat", "TripleFadeTransformFragmentShader.dat");
    SHAKA_OFFSET_ALPHA_BLEND = new PROGRAM_TYPE("SHAKA_OFFSET_ALPHA_BLEND", 15, "SimpleVertexShader.dat", "OffsetAlphaBlendFragmentShader.dat");
    SHAKA_NINE_TILE = new PROGRAM_TYPE("SHAKA_NINE_TILE", 16, "SimpleVertexShader.dat", "NineTileFragmentShader.dat");
    SHAKA_FLIP = new PROGRAM_TYPE("SHAKA_FLIP", 17, "SimpleVertexShader.dat", "FlipFragmentShader.dat");
    SHAKA_UP_DOWN = new PROGRAM_TYPE("SHAKA_UP_DOWN", 18, "SimpleVertexShader.dat", "UpDownFragmentShader.dat");
    SHAKA_HORIZONTAL_SKEW = new PROGRAM_TYPE("SHAKA_HORIZONTAL_SKEW", 19, "SimpleVertexShader.dat", "HorizontalSkewFragmentShader.dat");
    EMOJI = new PROGRAM_TYPE("EMOJI", 20, "EmojiVertexShader.dat", "EmojiFragmentShader.dat");
    GIF_FRAME = new PROGRAM_TYPE("GIF_FRAME", 21, "GifFrameVertexShader.dat", "EmojiFragmentShader.dat");
    $VALUES = new PROGRAM_TYPE[] { STICKER_NORMAL, STICKER_UP_DOWN, STICKER_LEFT_RIGHT, STICKER_ETC, FAST_STICKER, TRANSFORM, FACEOFF, CFFACEOFF, SNAKE_FACE, DOODLE, FACE_CROP, HEAD_CROP, LOOKUP, ROTATE_SCALE, SHAKA_TRIPLE_FACE_TRANSFORM, SHAKA_OFFSET_ALPHA_BLEND, SHAKA_NINE_TILE, SHAKA_FLIP, SHAKA_UP_DOWN, SHAKA_HORIZONTAL_SKEW, EMOJI, GIF_FRAME };
    AppMethodBeat.o(83731);
  }
  
  private ShaderCreateFactory$PROGRAM_TYPE(String paramString1, String paramString2)
  {
    this.vertexShaderFile = paramString1;
    this.fragmentShaderFile = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE
 * JD-Core Version:    0.7.0.1
 */