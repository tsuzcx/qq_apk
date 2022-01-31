package com.tencent.qqmusic.mediaplayer.util;

public class Util4Phone
{
  private static final String TAG = "Util4Phone";
  
  public static boolean isSupportNeon()
  {
    try
    {
      boolean bool = Util4NativeCommon.isSupportNeon();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Logger.e("Util4Phone", "isSupportNeon", localThrowable);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.Util4Phone
 * JD-Core Version:    0.7.0.1
 */