package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class aw
  extends aq
{
  private static int IxE;
  private final int IxF;
  private long Iyq;
  private final a Iyr;
  private final boolean lpC;
  private boolean mStop;
  
  public aw(Looper paramLooper, a parama, boolean paramBoolean)
  {
    super(paramLooper);
    AppMethodBeat.i(157716);
    this.Iyq = 0L;
    this.mStop = false;
    this.Iyr = parama;
    this.IxF = foT();
    this.lpC = paramBoolean;
    if ((Thread.currentThread().getName().equals("initThread")) || ("initThread".equals(a.gau()))) {
      ae.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread, stack %s", new Object[] { bu.fpN() });
    }
    AppMethodBeat.o(157716);
  }
  
  public aw(a parama, a parama1, boolean paramBoolean)
  {
    super(parama);
    AppMethodBeat.i(182966);
    this.Iyq = 0L;
    this.mStop = false;
    this.Iyr = parama1;
    this.IxF = foT();
    this.lpC = paramBoolean;
    AppMethodBeat.o(182966);
  }
  
  public aw(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(157715);
    this.Iyq = 0L;
    this.mStop = false;
    this.Iyr = parama;
    this.IxF = foT();
    this.lpC = paramBoolean;
    if ((Thread.currentThread().getName().equals("initThread")) || ("initThread".equals(a.gau()))) {
      ae.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread, stack %s", new Object[] { bu.fpN() });
    }
    AppMethodBeat.o(157715);
  }
  
  public aw(String paramString, a parama, boolean paramBoolean)
  {
    super(paramString);
    AppMethodBeat.i(182965);
    this.Iyq = 0L;
    this.mStop = false;
    this.Iyr = parama;
    this.IxF = foT();
    this.lpC = paramBoolean;
    AppMethodBeat.o(182965);
  }
  
  private static int foT()
  {
    if (IxE >= 8192) {
      IxE = 0;
    }
    int i = IxE + 1;
    IxE = i;
    return i;
  }
  
  public final void Dv(long paramLong)
  {
    AppMethodBeat.i(224552);
    ay(paramLong, paramLong);
    AppMethodBeat.o(224552);
  }
  
  public final void ay(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(157721);
    this.Iyq = paramLong2;
    stopTimer();
    this.mStop = false;
    sendEmptyMessageDelayed(this.IxF, paramLong1);
    AppMethodBeat.o(157721);
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(157717);
    stopTimer();
    super.finalize();
    AppMethodBeat.o(157717);
  }
  
  public final boolean foU()
  {
    AppMethodBeat.i(157722);
    if ((this.mStop) || (!hasMessages(this.IxF)))
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
    if (paramMessage.what == this.IxF)
    {
      if (this.Iyr == null)
      {
        AppMethodBeat.o(157718);
        return;
      }
      if (!this.Iyr.onTimerExpired())
      {
        AppMethodBeat.o(157718);
        return;
      }
      if ((this.lpC) && (!this.mStop)) {
        sendEmptyMessageDelayed(this.IxF, this.Iyq);
      }
    }
    AppMethodBeat.o(157718);
  }
  
  public final void stopTimer()
  {
    AppMethodBeat.i(157720);
    removeMessages(this.IxF);
    this.mStop = true;
    AppMethodBeat.o(157720);
  }
  
  public String toString()
  {
    AppMethodBeat.i(157723);
    if (this.Iyr == null)
    {
      str = "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
      AppMethodBeat.o(157723);
      return str;
    }
    String str = "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.Iyr.getClass().getName() + "}";
    AppMethodBeat.o(157723);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract boolean onTimerExpired();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.aw
 * JD-Core Version:    0.7.0.1
 */