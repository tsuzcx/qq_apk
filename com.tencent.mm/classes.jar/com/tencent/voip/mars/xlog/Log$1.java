package com.tencent.voip.mars.xlog;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class Log$1
  implements Log.LogImp
{
  private Handler handler;
  
  Log$1()
  {
    AppMethodBeat.i(92809);
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(92809);
  }
  
  public final void appenderClose() {}
  
  public final void appenderFlush(boolean paramBoolean) {}
  
  public final int getLogLevel()
  {
    AppMethodBeat.i(92816);
    int i = Log.access$000();
    AppMethodBeat.o(92816);
    return i;
  }
  
  public final void logD(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(92812);
    Log.access$000();
    AppMethodBeat.o(92812);
  }
  
  public final void logE(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(92814);
    Log.access$000();
    AppMethodBeat.o(92814);
  }
  
  public final void logF(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(92815);
    if (Log.access$000() > 5)
    {
      AppMethodBeat.o(92815);
      return;
    }
    if (Log.toastSupportContext != null) {
      this.handler.post(new Log.1.1(this, paramString4));
    }
    AppMethodBeat.o(92815);
  }
  
  public final void logI(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(92811);
    Log.access$000();
    AppMethodBeat.o(92811);
  }
  
  public final void logV(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(92810);
    Log.access$000();
    AppMethodBeat.o(92810);
  }
  
  public final void logW(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString4)
  {
    AppMethodBeat.i(92813);
    Log.access$000();
    AppMethodBeat.o(92813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.voip.mars.xlog.Log.1
 * JD-Core Version:    0.7.0.1
 */