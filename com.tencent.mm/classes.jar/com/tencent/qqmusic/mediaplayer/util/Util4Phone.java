package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Util4Phone
{
  private static final String TAG = "Util4Phone";
  
  public static boolean isSupportNeon()
  {
    AppMethodBeat.i(114158);
    boolean bool1 = false;
    try
    {
      boolean bool2 = Util4NativeCommon.isSupportNeon();
      bool1 = bool2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Logger.e("Util4Phone", "isSupportNeon", localThrowable);
      }
    }
    AppMethodBeat.o(114158);
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.Util4Phone
 * JD-Core Version:    0.7.0.1
 */