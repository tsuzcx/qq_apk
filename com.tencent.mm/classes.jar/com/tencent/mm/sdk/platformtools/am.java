package com.tencent.mm.sdk.platformtools;

import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public class am
  extends Handler
  implements aq.a
{
  private String toStringResult;
  private Looper ynU;
  private Handler.Callback ynV;
  public a ynW;
  
  public am(Handler.Callback paramCallback, a parama)
  {
    super(paramCallback);
    AppMethodBeat.i(52144);
    this.toStringResult = null;
    this.ynU = getLooper();
    this.ynV = paramCallback;
    this.ynW = parama;
    AppMethodBeat.o(52144);
  }
  
  public am(Looper paramLooper, Handler.Callback paramCallback, a parama)
  {
    super(paramLooper, paramCallback);
    AppMethodBeat.i(52145);
    this.toStringResult = null;
    this.ynU = getLooper();
    this.ynV = paramCallback;
    this.ynW = parama;
    AppMethodBeat.o(52145);
  }
  
  public am(Looper paramLooper, a parama)
  {
    super(paramLooper);
    AppMethodBeat.i(52143);
    this.toStringResult = null;
    this.ynU = getLooper();
    this.ynW = parama;
    AppMethodBeat.o(52143);
  }
  
  public am(a parama)
  {
    AppMethodBeat.i(52142);
    this.toStringResult = null;
    this.ynU = getLooper();
    this.ynW = parama;
    AppMethodBeat.o(52142);
  }
  
  public final void a(Runnable paramRunnable, aq paramaq)
  {
    AppMethodBeat.i(52150);
    if (this.ynW != null) {
      this.ynW.onTaskRunEnd(paramRunnable, paramaq);
    }
    AppMethodBeat.o(52150);
  }
  
  public final void a(Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, long paramLong3, float paramFloat)
  {
    AppMethodBeat.i(52151);
    if (this.ynW != null) {
      this.ynW.onLog(null, paramRunnable, paramThread, paramLong1, paramLong2, paramLong3, paramFloat);
    }
    AppMethodBeat.o(52151);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    AppMethodBeat.i(52147);
    if ((paramMessage.getCallback() != null) || (this.ynV != null))
    {
      super.dispatchMessage(paramMessage);
      AppMethodBeat.o(52147);
      return;
    }
    long l1 = System.currentTimeMillis();
    Bundle localBundle = paramMessage.getData();
    long l2 = localBundle.getLong("addTime");
    long l3 = localBundle.getLong("delay");
    localBundle = localBundle.getBundle("tmp");
    long l4 = Debug.threadCpuTimeNanos();
    paramMessage.setData(localBundle);
    handleMessage(paramMessage);
    if (this.ynW != null) {
      this.ynW.onLog(paramMessage, null, this.ynU.getThread(), System.currentTimeMillis() - l1, Debug.threadCpuTimeNanos() - l4, l1 - l2 - l3, -1.0F);
    }
    AppMethodBeat.o(52147);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(52148);
    if (this.ynW != null) {
      this.ynW.handleMessage(paramMessage);
    }
    AppMethodBeat.o(52148);
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(52146);
    if (paramMessage != null) {}
    Runnable localRunnable;
    long l;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("msg is null", bool);
      localRunnable = paramMessage.getCallback();
      l = paramLong - SystemClock.uptimeMillis();
      if (localRunnable != null) {
        break;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putBundle("tmp", paramMessage.getData());
      ((Bundle)localObject).putLong("delay", l);
      ((Bundle)localObject).putLong("addTime", System.currentTimeMillis());
      paramMessage.setData((Bundle)localObject);
      bool = super.sendMessageAtTime(paramMessage, paramLong);
      AppMethodBeat.o(52146);
      return bool;
    }
    if (paramMessage.getTarget() == null) {}
    Message localMessage;
    for (Object localObject = this;; localObject = paramMessage.getTarget())
    {
      localObject = new aq(this.ynU.getThread(), (Handler)localObject, localRunnable, paramMessage.obj, this);
      if (l > 0L) {
        ((aq)localObject).yoo = l;
      }
      localMessage = Message.obtain(paramMessage.getTarget(), (Runnable)localObject);
      localMessage.what = paramMessage.what;
      localMessage.arg1 = paramMessage.arg1;
      localMessage.arg2 = paramMessage.arg2;
      localMessage.obj = paramMessage.obj;
      localMessage.replyTo = paramMessage.replyTo;
      localMessage.setData(paramMessage.getData());
      paramMessage.recycle();
      if ((getLooper() == null) || (getLooper().getThread().isAlive())) {
        break;
      }
      ab.w("MicroMsg.MMInnerHandler", "sendMessageAtTime but thread[%d, %s] is dead so return false!", new Object[] { Long.valueOf(getLooper().getThread().getId()), getLooper().getThread().getName() });
      AppMethodBeat.o(52146);
      return false;
    }
    if (this.ynW != null) {
      this.ynW.onTaskAdded(localRunnable, (aq)localObject);
    }
    bool = super.sendMessageAtTime(localMessage, paramLong);
    if ((!bool) && (this.ynW != null)) {
      this.ynW.onTaskRunEnd(localRunnable, (aq)localObject);
    }
    AppMethodBeat.o(52146);
    return bool;
  }
  
  public String toString()
  {
    AppMethodBeat.i(52149);
    if (this.toStringResult == null) {
      this.toStringResult = ("MMInnerHandler{listener = " + this.ynW + "}");
    }
    String str = this.toStringResult;
    AppMethodBeat.o(52149);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void handleMessage(Message paramMessage);
    
    public abstract void onLog(Message paramMessage, Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, long paramLong3, float paramFloat);
    
    public abstract void onTaskAdded(Runnable paramRunnable, aq paramaq);
    
    public abstract void onTaskRunEnd(Runnable paramRunnable, aq paramaq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.am
 * JD-Core Version:    0.7.0.1
 */