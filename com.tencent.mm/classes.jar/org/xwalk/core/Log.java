package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.IXWebLogClient;

public class Log
{
  private static IXWebLogClient m_log_callback = null;
  
  public static void SetLogCallBack(IXWebLogClient paramIXWebLogClient)
  {
    m_log_callback = paramIXWebLogClient;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157210);
    if (m_log_callback != null)
    {
      m_log_callback.d(paramString1, paramString2);
      AppMethodBeat.o(157210);
      return;
    }
    AppMethodBeat.o(157210);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157206);
    if (m_log_callback != null)
    {
      m_log_callback.e(paramString1, paramString2);
      AppMethodBeat.o(157206);
      return;
    }
    AppMethodBeat.o(157206);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(157205);
    if (m_log_callback != null)
    {
      m_log_callback.e(paramString1, paramString2);
      AppMethodBeat.o(157205);
      return;
    }
    AppMethodBeat.o(157205);
  }
  
  public static void f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157204);
    if (m_log_callback != null)
    {
      m_log_callback.e(paramString1, paramString2);
      AppMethodBeat.o(157204);
      return;
    }
    AppMethodBeat.o(157204);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157209);
    if (m_log_callback != null)
    {
      m_log_callback.i(paramString1, paramString2);
      AppMethodBeat.o(157209);
      return;
    }
    AppMethodBeat.o(157209);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157211);
    if (m_log_callback != null)
    {
      m_log_callback.v(paramString1, paramString2);
      AppMethodBeat.o(157211);
      return;
    }
    AppMethodBeat.o(157211);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(157207);
    if (m_log_callback != null)
    {
      m_log_callback.w(paramString1, paramString2);
      AppMethodBeat.o(157207);
      return;
    }
    AppMethodBeat.o(157207);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(157208);
    if (m_log_callback != null)
    {
      m_log_callback.w(paramString1, paramString2);
      AppMethodBeat.o(157208);
      return;
    }
    AppMethodBeat.o(157208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.xwalk.core.Log
 * JD-Core Version:    0.7.0.1
 */