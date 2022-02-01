package com.tencent.thumbplayer.core.common;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TPDrm
{
  public static int[] getDRMCapabilities()
  {
    AppMethodBeat.i(197352);
    Object localObject = null;
    try
    {
      int[] arrayOfInt = native_getDRMCapabilities();
      localObject = arrayOfInt;
    }
    catch (Exception localException)
    {
      label13:
      break label13;
    }
    if (localObject == null)
    {
      AppMethodBeat.o(197352);
      return new int[0];
    }
    AppMethodBeat.o(197352);
    return localObject;
  }
  
  static native int[] native_getDRMCapabilities();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPDrm
 * JD-Core Version:    0.7.0.1
 */