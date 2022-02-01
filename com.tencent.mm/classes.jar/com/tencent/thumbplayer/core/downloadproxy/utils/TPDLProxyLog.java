package com.tencent.thumbplayer.core.downloadproxy.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;

public class TPDLProxyLog
{
  private static ITPDLProxyLogListener mLogListener;
  private static int mServiceType;
  
  public static void d(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(227944);
    if (mLogListener != null)
    {
      mLogListener.d(paramString1, paramInt, paramString2, paramString3);
      AppMethodBeat.o(227944);
      return;
    }
    new StringBuilder("[").append(paramString2).append("][").append(paramString1).append(":").append(paramInt).append("]");
    AppMethodBeat.o(227944);
  }
  
  public static void e(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(227977);
    if (mLogListener != null)
    {
      mLogListener.e(paramString1, paramInt, paramString2, paramString3);
      AppMethodBeat.o(227977);
      return;
    }
    new StringBuilder("[").append(paramString2).append("][").append(paramString1).append(":").append(paramInt).append("]");
    AppMethodBeat.o(227977);
  }
  
  public static void i(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(227954);
    if (mLogListener != null)
    {
      mLogListener.i(paramString1, paramInt, paramString2, paramString3);
      AppMethodBeat.o(227954);
      return;
    }
    new StringBuilder("[").append(paramString2).append("][").append(paramString1).append(":").append(paramInt).append("]");
    AppMethodBeat.o(227954);
  }
  
  public static void setLogListener(int paramInt, ITPDLProxyLogListener paramITPDLProxyLogListener)
  {
    mServiceType = paramInt;
    mLogListener = paramITPDLProxyLogListener;
  }
  
  public static void w(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(227968);
    if (mLogListener != null)
    {
      mLogListener.w(paramString1, paramInt, paramString2, paramString3);
      AppMethodBeat.o(227968);
      return;
    }
    new StringBuilder("[").append(paramString2).append("][").append(paramString1).append(":").append(paramInt).append("]");
    AppMethodBeat.o(227968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog
 * JD-Core Version:    0.7.0.1
 */