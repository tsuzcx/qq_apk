package com.tencent.thumbplayer.core.common;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TPNativeLog
{
  public static final int LEVEL_DEBUG = 1;
  public static final int LEVEL_ERROR = 4;
  public static final int LEVEL_INFO = 2;
  public static final int LEVEL_VERBOSE = 0;
  public static final int LEVEL_WARN = 3;
  private static final String TAG = "PlayerCore";
  private static ITPNativeLogCallback mLogCallback = null;
  
  @TPMethodCalledByNative
  private static void onPrintLog(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(220460);
    for (;;)
    {
      try
      {
        paramArrayOfByte1 = new String(paramArrayOfByte1, 0, paramInt2, "UTF-8");
        paramArrayOfByte2 = new String(paramArrayOfByte2, 0, paramInt3, "UTF-8");
        paramInt2 = i;
        switch (paramInt1)
        {
        case 4: 
          printLog(paramInt2, paramArrayOfByte1, paramArrayOfByte2);
          AppMethodBeat.o(220460);
          return;
        }
      }
      catch (Exception paramArrayOfByte1)
      {
        printLog(4, paramArrayOfByte1.getMessage());
        AppMethodBeat.o(220460);
        return;
      }
      paramInt2 = 4;
      continue;
      paramInt2 = 3;
      continue;
      paramInt2 = 2;
      continue;
      paramInt2 = 1;
      continue;
      paramInt2 = i;
    }
  }
  
  public static void printLog(int paramInt, String paramString)
  {
    AppMethodBeat.i(220458);
    printLog(paramInt, "PlayerCore", paramString);
    AppMethodBeat.o(220458);
  }
  
  public static void printLog(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(220459);
    if (mLogCallback != null)
    {
      mLogCallback.onPrintLog(paramInt, paramString1, paramString2);
      AppMethodBeat.o(220459);
      return;
    }
    printLogDefault(paramInt, paramString1, paramString2);
    AppMethodBeat.o(220459);
  }
  
  public static void printLogDefault(int paramInt, String paramString1, String paramString2) {}
  
  public static void setLogCallback(ITPNativeLogCallback paramITPNativeLogCallback)
  {
    mLogCallback = paramITPNativeLogCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPNativeLog
 * JD-Core Version:    0.7.0.1
 */