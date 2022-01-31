package com.tencent.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Coffee
{
  public static String dWY()
  {
    AppMethodBeat.i(86576);
    String str = getDESSignKey();
    AppMethodBeat.o(86576);
    return str;
  }
  
  private static native String getDESSignKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.util.Coffee
 * JD-Core Version:    0.7.0.1
 */