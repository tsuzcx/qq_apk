package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ap
  extends ak
{
  private static int ynB;
  private final boolean icK;
  private boolean mStop;
  private final int ynC;
  private long yoj;
  private final a yok;
  
  public ap(Looper paramLooper, a parama, boolean paramBoolean)
  {
    super(paramLooper);
    AppMethodBeat.i(52158);
    this.yoj = 0L;
    this.mStop = false;
    this.yok = parama;
    this.ynC = dti();
    this.icK = paramBoolean;
    if (paramLooper.getThread().getName().equals("initThread")) {
      ab.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", new Object[] { bo.dtY() });
    }
    AppMethodBeat.o(52158);
  }
  
  public ap(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(52157);
    this.yoj = 0L;
    this.mStop = false;
    this.yok = parama;
    this.ynC = dti();
    this.icK = paramBoolean;
    if (getLooper().getThread().getName().equals("initThread")) {
      ab.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", new Object[] { bo.dtY() });
    }
    AppMethodBeat.o(52157);
  }
  
  private static int dti()
  {
    if (ynB >= 8192) {
      ynB = 0;
    }
    int i = ynB + 1;
    ynB = i;
    return i;
  }
  
  public final void ag(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(52163);
    this.yoj = paramLong2;
    stopTimer();
    this.mStop = false;
    sendEmptyMessageDelayed(this.ynC, paramLong1);
    AppMethodBeat.o(52163);
  }
  
  public final boolean dtj()
  {
    AppMethodBeat.i(52164);
    if ((this.mStop) || (!hasMessages(this.ynC)))
    {
      AppMethodBeat.o(52164);
      return true;
    }
    AppMethodBeat.o(52164);
    return false;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(52159);
    stopTimer();
    super.finalize();
    AppMethodBeat.o(52159);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(52160);
    if (paramMessage.what == this.ynC)
    {
      if (this.yok == null)
      {
        AppMethodBeat.o(52160);
        return;
      }
      if (!this.yok.onTimerExpired())
      {
        AppMethodBeat.o(52160);
        return;
      }
      if ((this.icK) && (!this.mStop)) {
        sendEmptyMessageDelayed(this.ynC, this.yoj);
      }
    }
    AppMethodBeat.o(52160);
  }
  
  public final void nP(long paramLong)
  {
    AppMethodBeat.i(156810);
    ag(paramLong, paramLong);
    AppMethodBeat.o(156810);
  }
  
  public final void stopTimer()
  {
    AppMethodBeat.i(52162);
    removeMessages(this.ynC);
    this.mStop = true;
    AppMethodBeat.o(52162);
  }
  
  public String toString()
  {
    AppMethodBeat.i(52165);
    if (this.yok == null)
    {
      str = "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
      AppMethodBeat.o(52165);
      return str;
    }
    String str = "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.yok.getClass().getName() + "}";
    AppMethodBeat.o(52165);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract boolean onTimerExpired();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ap
 * JD-Core Version:    0.7.0.1
 */