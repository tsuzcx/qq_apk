package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$FACE_SWAP_TYPE
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(84101);
    FACE_SWITCH = new FACE_SWAP_TYPE("FACE_SWITCH", 0, 0);
    FACE_COPY = new FACE_SWAP_TYPE("FACE_COPY", 1, 1);
    $VALUES = new FACE_SWAP_TYPE[] { FACE_SWITCH, FACE_COPY };
    AppMethodBeat.o(84101);
  }
  
  private VideoMaterialUtil$FACE_SWAP_TYPE(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.FACE_SWAP_TYPE
 * JD-Core Version:    0.7.0.1
 */