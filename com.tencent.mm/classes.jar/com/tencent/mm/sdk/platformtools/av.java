package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class av
  extends ap
{
  private static int Idt;
  private final int Idu;
  private long Ief;
  private final a Ieg;
  private final boolean lle;
  private boolean mStop;
  
  public av(Looper paramLooper, a parama, boolean paramBoolean)
  {
    super(paramLooper);
    AppMethodBeat.i(157716);
    this.Ief = 0L;
    this.mStop = false;
    this.Ieg = parama;
    this.Idu = fkY();
    this.lle = paramBoolean;
    if ((Thread.currentThread().getName().equals("initThread")) || ("initThread".equals(a.fVV()))) {
      ad.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread, stack %s", new Object[] { bt.flS() });
    }
    AppMethodBeat.o(157716);
  }
  
  public av(a parama, a parama1, boolean paramBoolean)
  {
    super(parama);
    AppMethodBeat.i(182966);
    this.Ief = 0L;
    this.mStop = false;
    this.Ieg = parama1;
    this.Idu = fkY();
    this.lle = paramBoolean;
    AppMethodBeat.o(182966);
  }
  
  public av(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(157715);
    this.Ief = 0L;
    this.mStop = false;
    this.Ieg = parama;
    this.Idu = fkY();
    this.lle = paramBoolean;
    if ((Thread.currentThread().getName().equals("initThread")) || ("initThread".equals(a.fVV()))) {
      ad.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread, stack %s", new Object[] { bt.flS() });
    }
    AppMethodBeat.o(157715);
  }
  
  public av(String paramString, a parama, boolean paramBoolean)
  {
    super(paramString);
    AppMethodBeat.i(182965);
    this.Ief = 0L;
    this.mStop = false;
    this.Ieg = parama;
    this.Idu = fkY();
    this.lle = paramBoolean;
    AppMethodBeat.o(182965);
  }
  
  private static int fkY()
  {
    if (Idt >= 8192) {
      Idt = 0;
    }
    int i = Idt + 1;
    Idt = i;
    return i;
  }
  
  public final void CX(long paramLong)
  {
    AppMethodBeat.i(221723);
    az(paramLong, paramLong);
    AppMethodBeat.o(221723);
  }
  
  public final void az(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(157721);
    this.Ief = paramLong2;
    stopTimer();
    this.mStop = false;
    sendEmptyMessageDelayed(this.Idu, paramLong1);
    AppMethodBeat.o(157721);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(157717);
    stopTimer();
    super.finalize();
    AppMethodBeat.o(157717);
  }
  
  public final boolean fkZ()
  {
    AppMethodBeat.i(157722);
    if ((this.mStop) || (!hasMessages(this.Idu)))
    {
      AppMethodBeat.o(157722);
      return true;
    }
    AppMethodBeat.o(157722);
    return false;
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(157718);
    if (paramMessage.what == this.Idu)
    {
      if (this.Ieg == null)
      {
        AppMethodBeat.o(157718);
        return;
      }
      if (!this.Ieg.onTimerExpired())
      {
        AppMethodBeat.o(157718);
        return;
      }
      if ((this.lle) && (!this.mStop)) {
        sendEmptyMessageDelayed(this.Idu, this.Ief);
      }
    }
    AppMethodBeat.o(157718);
  }
  
  public final void stopTimer()
  {
    AppMethodBeat.i(157720);
    removeMessages(this.Idu);
    this.mStop = true;
    AppMethodBeat.o(157720);
  }
  
  public String toString()
  {
    AppMethodBeat.i(157723);
    if (this.Ieg == null)
    {
      str = "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
      AppMethodBeat.o(157723);
      return str;
    }
    String str = "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.Ieg.getClass().getName() + "}";
    AppMethodBeat.o(157723);
    return str;
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