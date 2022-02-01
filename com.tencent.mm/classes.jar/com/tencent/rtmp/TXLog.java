package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXLog
{
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(13999);
    wrietLogMessage(1, paramString1, paramString2);
    AppMethodBeat.o(13999);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14002);
    wrietLogMessage(4, paramString1, paramString2);
    AppMethodBeat.o(14002);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14000);
    wrietLogMessage(2, paramString1, paramString2);
    AppMethodBeat.o(14000);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14001);
    wrietLogMessage(3, paramString1, paramString2);
    AppMethodBeat.o(14001);
  }
  
  private static void wrietLogMessage(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(14003);
    TXCLog.log(paramInt, paramString1, "thread ID:" + Thread.currentThread().getId() + "|line:-1|" + paramString2);
    AppMethodBeat.o(14003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.rtmp.TXLog
 * JD-Core Version:    0.7.0.1
 */