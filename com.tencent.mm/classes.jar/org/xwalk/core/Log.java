package org.xwalk.core;

import com.tencent.xweb.util.b;

public class Log
{
  private static b m_log_callback = null;
  
  public static void SetLogCallBack(b paramb)
  {
    m_log_callback = paramb;
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (m_log_callback != null) {
      m_log_callback.d(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (m_log_callback != null) {
      m_log_callback.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (m_log_callback != null) {
      m_log_callback.e(paramString1, paramString2);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    if (m_log_callback != null) {
      m_log_callback.e(paramString1, paramString2);
    }
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (m_log_callback != null) {
      m_log_callback.i(paramString1, paramString2);
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    if (m_log_callback != null) {
      m_log_callback.v(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (m_log_callback != null) {
      m_log_callback.w(paramString1, paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (m_log_callback != null) {
      m_log_callback.w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.Log
 * JD-Core Version:    0.7.0.1
 */