package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXLog
{
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65991);
    wrietLogMessage(1, paramString1, paramString2);
    AppMethodBeat.o(65991);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65994);
    wrietLogMessage(4, paramString1, paramString2);
    AppMethodBeat.o(65994);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65992);
    wrietLogMessage(2, paramString1, paramString2);
    AppMethodBeat.o(65992);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65993);
    wrietLogMessage(3, paramString1, paramString2);
    AppMethodBeat.o(65993);
  }
  
  private static void wrietLogMessage(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(65995);
    TXCLog.log(paramInt, paramString1, "thread ID:" + Thread.currentThread().getId() + "|line:-1|" + paramString2);
    AppMethodBeat.o(65995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.TXLog
 * JD-Core Version:    0.7.0.1
 */