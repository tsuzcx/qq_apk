package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class av
  extends ap
{
  private static int EUr;
  private final int EUs;
  private long EVe;
  private final a EVf;
  private final boolean knj;
  private boolean mStop;
  
  public av(Looper paramLooper, a parama, boolean paramBoolean)
  {
    super(paramLooper);
    AppMethodBeat.i(157716);
    this.EVe = 0L;
    this.mStop = false;
    this.EVf = parama;
    this.EUs = eFW();
    this.knj = paramBoolean;
    if ((Thread.currentThread().getName().equals("initThread")) || ("initThread".equals(a.fon()))) {
      ad.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread, stack %s", new Object[] { bt.eGN() });
    }
    AppMethodBeat.o(157716);
  }
  
  public av(a parama, a parama1, boolean paramBoolean)
  {
    super(parama);
    AppMethodBeat.i(182966);
    this.EVe = 0L;
    this.mStop = false;
    this.EVf = parama1;
    this.EUs = eFW();
    this.knj = paramBoolean;
    AppMethodBeat.o(182966);
  }
  
  public av(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(157715);
    this.EVe = 0L;
    this.mStop = false;
    this.EVf = parama;
    this.EUs = eFW();
    this.knj = paramBoolean;
    if ((Thread.currentThread().getName().equals("initThread")) || ("initThread".equals(a.fon()))) {
      ad.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread, stack %s", new Object[] { bt.eGN() });
    }
    AppMethodBeat.o(157715);
  }
  
  public av(String paramString, a parama, boolean paramBoolean)
  {
    super(paramString);
    AppMethodBeat.i(182965);
    this.EVe = 0L;
    this.mStop = false;
    this.EVf = parama;
    this.EUs = eFW();
    this.knj = paramBoolean;
    AppMethodBeat.o(182965);
  }
  
  private static int eFW()
  {
    if (EUr >= 8192) {
      EUr = 0;
    }
    int i = EUr + 1;
    EUr = i;
    return i;
  }
  
  public final void av(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(157721);
    this.EVe = paramLong2;
    stopTimer();
    this.mStop = false;
    sendEmptyMessageDelayed(this.EUs, paramLong1);
    AppMethodBeat.o(157721);
  }
  
  public final boolean eFX()
  {
    AppMethodBeat.i(157722);
    if ((this.mStop) || (!hasMessages(this.EUs)))
    {
      AppMethodBeat.o(157722);
      return true;
    }
    AppMethodBeat.o(157722);
    return false;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(157717);
    stopTimer();
    super.finalize();
    AppMethodBeat.o(157717);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(157718);
    if (paramMessage.what == this.EUs)
    {
      if (this.EVf == null)
      {
        AppMethodBeat.o(157718);
        return;
      }
      if (!this.EVf.onTimerExpired())
      {
        AppMethodBeat.o(157718);
        return;
      }
      if ((this.knj) && (!this.mStop)) {
        sendEmptyMessageDelayed(this.EUs, this.EVe);
      }
    }
    AppMethodBeat.o(157718);
  }
  
  public final void stopTimer()
  {
    AppMethodBeat.i(157720);
    removeMessages(this.EUs);
    this.mStop = true;
    AppMethodBeat.o(157720);
  }
  
  public String toString()
  {
    AppMethodBeat.i(157723);
    if (this.EVf == null)
    {
      str = "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
      AppMethodBeat.o(157723);
      return str;
    }
    String str = "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.EVf.getClass().getName() + "}";
    AppMethodBeat.o(157723);
    return str;
  }
  
  public final void vE(long paramLong)
  {
    AppMethodBeat.i(202376);
    av(paramLong, paramLong);
    AppMethodBeat.o(202376);
  }
  
  public static abstract interface a
  {
    public abstract boolean onTimerExpired();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.av
 * JD-Core Version:    0.7.0.1
 */