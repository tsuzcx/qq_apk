package com.tencent.thumbplayer.core.downloadproxy.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;

public class TPDLProxyLog
{
  private static ITPDLProxyLogListener mLogListener;
  private static int mServiceType;
  
  public static void d(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(256223);
    if (mLogListener != null)
    {
      mLogListener.d(paramString1, paramInt, paramString2, paramString3);
      AppMethodBeat.o(256223);
      return;
    }
    new StringBuilder("[").append(paramString2).append("][").append(paramString1).append(":").append(paramInt).append("]");
    AppMethodBeat.o(256223);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(256226);
    if (mLogListener != null)
    {
      mLogListener.e(paramString1, paramInt, paramString2, paramString3);
      AppMethodBeat.o(256226);
      return;
    }
    new StringBuilder("[").append(paramString2).append("][").append(paramString1).append(":").append(paramInt).append("]");
    AppMethodBeat.o(256226);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(256224);
    if (mLogListener != null)
    {
      mLogListener.i(paramString1, paramInt, paramString2, paramString3);
      AppMethodBeat.o(256224);
      return;
    }
    new StringBuilder("[").append(paramString2).append("][").append(paramString1).append(":").append(paramInt).append("]");
    AppMethodBeat.o(256224);
  }
  
  public static void setLogListener(int paramInt, ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    mServiceType = paramInt;
    mLogListener = paramITPDLProxyLogListener;
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(256225);
    if (mLogListener != null)
    {
      mLogListener.w(paramString1, paramInt, paramString2, paramString3);
      AppMethodBeat.o(256225);
      return;
    }
    new StringBuilder("[").append(paramString2).append("][").append(paramString1).append(":").append(paramInt).append("]");
    AppMethodBeat.o(256225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog
 * JD-Core Version:    0.7.0.1
 */