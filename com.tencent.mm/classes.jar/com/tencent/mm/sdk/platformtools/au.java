package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class au
  extends ao
{
  private static int GrD;
  private final int GrE;
  private long Gsq;
  private final a Gsr;
  private final boolean kOB;
  private boolean mStop;
  
  public au(Looper paramLooper, a parama, boolean paramBoolean)
  {
    super(paramLooper);
    AppMethodBeat.i(157716);
    this.Gsq = 0L;
    this.mStop = false;
    this.Gsr = parama;
    this.GrE = eVr();
    this.kOB = paramBoolean;
    if ((Thread.currentThread().getName().equals("initThread")) || ("initThread".equals(a.fED()))) {
      ac.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread, stack %s", new Object[] { bs.eWi() });
    }
    AppMethodBeat.o(157716);
  }
  
  public au(a parama, a parama1, boolean paramBoolean)
  {
    super(parama);
    AppMethodBeat.i(182966);
    this.Gsq = 0L;
    this.mStop = false;
    this.Gsr = parama1;
    this.GrE = eVr();
    this.kOB = paramBoolean;
    AppMethodBeat.o(182966);
  }
  
  public au(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(157715);
    this.Gsq = 0L;
    this.mStop = false;
    this.Gsr = parama;
    this.GrE = eVr();
    this.kOB = paramBoolean;
    if ((Thread.currentThread().getName().equals("initThread")) || ("initThread".equals(a.fED()))) {
      ac.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread, stack %s", new Object[] { bs.eWi() });
    }
    AppMethodBeat.o(157715);
  }
  
  public au(String paramString, a parama, boolean paramBoolean)
  {
    super(paramString);
    AppMethodBeat.i(182965);
    this.Gsq = 0L;
    this.mStop = false;
    this.Gsr = parama;
    this.GrE = eVr();
    this.kOB = paramBoolean;
    AppMethodBeat.o(182965);
  }
  
  private static int eVr()
  {
    if (GrD >= 8192) {
      GrD = 0;
    }
    int i = GrD + 1;
    GrD = i;
    return i;
  }
  
  public final void Ah(long paramLong)
  {
    AppMethodBeat.i(210342);
    au(paramLong, paramLong);
    AppMethodBeat.o(210342);
  }
  
  public final void au(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(157721);
    this.Gsq = paramLong2;
    stopTimer();
    this.mStop = false;
    sendEmptyMessageDelayed(this.GrE, paramLong1);
    AppMethodBeat.o(157721);
  }
  
  public final boolean eVs()
  {
    AppMethodBeat.i(157722);
    if ((this.mStop) || (!hasMessages(this.GrE)))
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
    if (paramMessage.what == this.GrE)
    {
      if (this.Gsr == null)
      {
        AppMethodBeat.o(157718);
        return;
      }
      if (!this.Gsr.onTimerExpired())
      {
        AppMethodBeat.o(157718);
        return;
      }
      if ((this.kOB) && (!this.mStop)) {
        sendEmptyMessageDelayed(this.GrE, this.Gsq);
      }
    }
    AppMethodBeat.o(157718);
  }
  
  public final void stopTimer()
  {
    AppMethodBeat.i(157720);
    removeMessages(this.GrE);
    this.mStop = true;
    AppMethodBeat.o(157720);
  }
  
  public String toString()
  {
    AppMethodBeat.i(157723);
    if (this.Gsr == null)
    {
      str = "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
      AppMethodBeat.o(157723);
      return str;
    }
    String str = "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.Gsr.getClass().getName() + "}";
    AppMethodBeat.o(157723);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract boolean onTimerExpired();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.au
 * JD-Core Version:    0.7.0.1
 */