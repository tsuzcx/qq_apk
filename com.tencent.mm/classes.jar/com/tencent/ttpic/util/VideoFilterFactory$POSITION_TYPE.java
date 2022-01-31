package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoFilterFactory$POSITION_TYPE
{
  public final int type;
  
  static
  {
    AppMethodBeat.i(83981);
    STATIC = new POSITION_TYPE("STATIC", 0, 1);
    DYNAMIC = new POSITION_TYPE("DYNAMIC", 1, 2);
    RELATIVE = new POSITION_TYPE("RELATIVE", 2, 3);
    GESTURE = new POSITION_TYPE("GESTURE", 3, 4);
    BODY = new POSITION_TYPE("BODY", 4, 5);
    $VALUES = new POSITION_TYPE[] { STATIC, DYNAMIC, RELATIVE, GESTURE, BODY };
    AppMethodBeat.o(83981);
  }
  
  private VideoFilterFactory$POSITION_TYPE(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoFilterFactory.POSITION_TYPE
 * JD-Core Version:    0.7.0.1
 */