package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MTimerHandler
  extends MMHandler
{
  private static final int MAX_TIMERID = 8192;
  private static final String TAG = "MicroMsg.MTimerHandler";
  private static int timerID;
  private final CallBack mCallBack;
  private final boolean mLoop;
  private long mLoopInterval;
  private boolean mStop;
  private final int myTimerID;
  
  public MTimerHandler(Looper paramLooper, CallBack paramCallBack, boolean paramBoolean)
  {
    super(paramLooper);
    AppMethodBeat.i(157716);
    this.mLoopInterval = 0L;
    this.mStop = false;
    this.mCallBack = paramCallBack;
    this.myTimerID = incTimerID();
    this.mLoop = paramBoolean;
    if ((Thread.currentThread().getName().equals("initThread")) || ("initThread".equals(a.hmF()))) {
      Log.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread, stack %s", new Object[] { Util.getStack() });
    }
    AppMethodBeat.o(157716);
  }
  
  public MTimerHandler(a parama, CallBack paramCallBack, boolean paramBoolean)
  {
    super(parama);
    AppMethodBeat.i(182966);
    this.mLoopInterval = 0L;
    this.mStop = false;
    this.mCallBack = paramCallBack;
    this.myTimerID = incTimerID();
    this.mLoop = paramBoolean;
    AppMethodBeat.o(182966);
  }
  
  public MTimerHandler(CallBack paramCallBack, boolean paramBoolean)
  {
    AppMethodBeat.i(157715);
    this.mLoopInterval = 0L;
    this.mStop = false;
    this.mCallBack = paramCallBack;
    this.myTimerID = incTimerID();
    this.mLoop = paramBoolean;
    if ((Thread.currentThread().getName().equals("initThread")) || ("initThread".equals(a.hmF()))) {
      Log.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread, stack %s", new Object[] { Util.getStack() });
    }
    AppMethodBeat.o(157715);
  }
  
  public MTimerHandler(String paramString, CallBack paramCallBack, boolean paramBoolean)
  {
    super(paramString);
    AppMethodBeat.i(182965);
    this.mLoopInterval = 0L;
    this.mStop = false;
    this.mCallBack = paramCallBack;
    this.myTimerID = incTimerID();
    this.mLoop = paramBoolean;
    AppMethodBeat.o(182965);
  }
  
  private static int incTimerID()
  {
    if (timerID >= 8192) {
      timerID = 0;
    }
    int i = timerID + 1;
    timerID = i;
    return i;
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
    if (paramMessage.what == this.myTimerID)
    {
      if (this.mCallBack == null)
      {
        AppMethodBeat.o(157718);
        return;
      }
      if (!this.mCallBack.onTimerExpired())
      {
        AppMethodBeat.o(157718);
        return;
      }
      if ((this.mLoop) && (!this.mStop)) {
        sendEmptyMessageDelayed(this.myTimerID, this.mLoopInterval);
      }
    }
    AppMethodBeat.o(157718);
  }
  
  public void startTimer(long paramLong)
  {
    AppMethodBeat.i(186051);
    startTimer(paramLong, paramLong);
    AppMethodBeat.o(186051);
  }
  
  public void startTimer(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(157721);
    this.mLoopInterval = paramLong2;
    stopTimer();
    this.mStop = false;
    sendEmptyMessageDelayed(this.myTimerID, paramLong1);
    AppMethodBeat.o(157721);
  }
  
  public void stopTimer()
  {
    AppMethodBeat.i(157720);
    removeMessages(this.myTimerID);
    this.mStop = true;
    AppMethodBeat.o(157720);
  }
  
  public boolean stopped()
  {
    AppMethodBeat.i(157722);
    if ((this.mStop) || (!hasMessages(this.myTimerID)))
    {
      AppMethodBeat.o(157722);
      return true;
    }
    AppMethodBeat.o(157722);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(157723);
    if (this.mCallBack == null)
    {
      str = "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
      AppMethodBeat.o(157723);
      return str;
    }
    String str = "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.mCallBack.getClass().getName() + "}";
    AppMethodBeat.o(157723);
    return str;
  }
  
  public static abstract interface CallBack
  {
    public abstract boolean onTimerExpired();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MTimerHandler
 * JD-Core Version:    0.7.0.1
 */