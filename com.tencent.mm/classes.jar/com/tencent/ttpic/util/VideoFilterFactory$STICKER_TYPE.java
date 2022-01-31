package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoFilterFactory$STICKER_TYPE
{
  public final int type;
  
  static
  {
    AppMethodBeat.i(83984);
    NORMAL = new STICKER_TYPE("NORMAL", 0, 0);
    WATERMARK = new STICKER_TYPE("WATERMARK", 1, 1);
    VIDEO_UP_DOWN = new STICKER_TYPE("VIDEO_UP_DOWN", 2, 3);
    VIDEO_LEFT_RIGHT = new STICKER_TYPE("VIDEO_LEFT_RIGHT", 3, 4);
    FACE_FEATURE = new STICKER_TYPE("FACE_FEATURE", 4, 5);
    ETC = new STICKER_TYPE("ETC", 5, 6);
    $VALUES = new STICKER_TYPE[] { NORMAL, WATERMARK, VIDEO_UP_DOWN, VIDEO_LEFT_RIGHT, FACE_FEATURE, ETC };
    AppMethodBeat.o(83984);
  }
  
  private VideoFilterFactory$STICKER_TYPE(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE
 * JD-Core Version:    0.7.0.1
 */