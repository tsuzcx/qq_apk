package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;

public class TXLog
{
  public static void d(String paramString1, String paramString2)
  {
    wrietLogMessage(1, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    wrietLogMessage(4, paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    wrietLogMessage(2, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    wrietLogMessage(3, paramString1, paramString2);
  }
  
  private static void wrietLogMessage(int paramInt, String paramString1, String paramString2)
  {
    TXCLog.log(paramInt, paramString1, "thread ID:" + Thread.currentThread().getId() + "|line:-1|" + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.TXLog
 * JD-Core Version:    0.7.0.1
 */