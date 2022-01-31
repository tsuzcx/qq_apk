package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;

public class am
  extends ah
{
  private static int ufa;
  private final boolean gDH;
  private boolean mStop = false;
  private long ufJ = 0L;
  private final a ufK;
  private final int ufb;
  
  public am(Looper paramLooper, a parama, boolean paramBoolean)
  {
    super(paramLooper);
    this.ufK = parama;
    this.ufb = crk();
    this.gDH = paramBoolean;
    if (paramLooper.getThread().getName().equals("initThread")) {
      y.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", new Object[] { bk.csb() });
    }
  }
  
  public am(a parama, boolean paramBoolean)
  {
    this.ufK = parama;
    this.ufb = crk();
    this.gDH = paramBoolean;
    if (getLooper().getThread().getName().equals("initThread")) {
      y.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", new Object[] { bk.csb() });
    }
  }
  
  private static int crk()
  {
    if (ufa >= 8192) {
      ufa = 0;
    }
    int i = ufa + 1;
    ufa = i;
    return i;
  }
  
  public final void S(long paramLong1, long paramLong2)
  {
    this.ufJ = paramLong2;
    stopTimer();
    this.mStop = false;
    sendEmptyMessageDelayed(this.ufb, paramLong1);
  }
  
  public final boolean crl()
  {
    return (this.mStop) || (!hasMessages(this.ufb));
  }
  
  protected void finalize()
  {
    stopTimer();
    super.finalize();
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what != this.ufb) || (this.ufK == null)) {}
    while ((!this.ufK.tC()) || (!this.gDH) || (this.mStop)) {
      return;
    }
    sendEmptyMessageDelayed(this.ufb, this.ufJ);
  }
  
  public final void hq(long paramLong)
  {
    S(paramLong, paramLong);
  }
  
  public final void stopTimer()
  {
    removeMessages(this.ufb);
    this.mStop = true;
  }
  
  public String toString()
  {
    if (this.ufK == null) {
      return "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
    }
    return "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.ufK.getClass().getName() + "}";
  }
  
  public static abstract interface a
  {
    public abstract boolean tC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.am
 * JD-Core Version:    0.7.0.1
 */