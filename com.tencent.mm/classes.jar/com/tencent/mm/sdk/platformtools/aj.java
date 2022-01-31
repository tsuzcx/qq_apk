package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import junit.framework.Assert;

final class aj
  extends Handler
  implements ao.a
{
  private String toStringResult = null;
  private Looper ufu = getLooper();
  private Handler.Callback ufv;
  a ufw;
  
  aj(Handler.Callback paramCallback, a parama)
  {
    super(paramCallback);
    this.ufv = paramCallback;
    this.ufw = parama;
  }
  
  aj(Looper paramLooper, Handler.Callback paramCallback, a parama)
  {
    super(paramLooper, paramCallback);
    this.ufv = paramCallback;
    this.ufw = parama;
  }
  
  aj(Looper paramLooper, a parama)
  {
    super(paramLooper);
    this.ufw = parama;
  }
  
  aj(a parama)
  {
    this.ufw = parama;
  }
  
  public final void a(Runnable paramRunnable, ao paramao)
  {
    if (this.ufw != null) {
      this.ufw.onTaskRunEnd(paramRunnable, paramao);
    }
  }
  
  public final void a(Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, float paramFloat)
  {
    if (this.ufw != null) {
      this.ufw.onLog(null, paramRunnable, paramThread, paramLong1, paramLong2, paramFloat);
    }
  }
  
  public final void dispatchMessage(Message paramMessage)
  {
    if ((paramMessage.getCallback() != null) || (this.ufv != null)) {
      super.dispatchMessage(paramMessage);
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = System.currentTimeMillis();
      l2 = Debug.threadCpuTimeNanos();
      handleMessage(paramMessage);
    } while (this.ufw == null);
    this.ufw.onLog(paramMessage, null, this.ufu.getThread(), System.currentTimeMillis() - l1, Debug.threadCpuTimeNanos() - l2, -1.0F);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (this.ufw != null) {
      this.ufw.handleMessage(paramMessage);
    }
  }
  
  public final boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    boolean bool1;
    Runnable localRunnable;
    if (paramMessage != null)
    {
      bool1 = true;
      Assert.assertTrue("msg is null", bool1);
      localRunnable = paramMessage.getCallback();
      if (localRunnable != null) {
        break label42;
      }
      bool1 = super.sendMessageAtTime(paramMessage, paramLong);
    }
    label42:
    Object localObject;
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        bool1 = false;
        break;
        long l = paramLong - SystemClock.uptimeMillis();
        if (paramMessage.getTarget() == null) {}
        Message localMessage;
        for (localObject = this;; localObject = paramMessage.getTarget())
        {
          localObject = new ao(this.ufu.getThread(), (Handler)localObject, localRunnable, paramMessage.obj, this);
          if (l > 0L) {
            ((ao)localObject).ugs = l;
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
          y.w("MicroMsg.MMInnerHandler", "sendMessageAtTime but thread[%d, %s] is dead so return false!", new Object[] { Long.valueOf(getLooper().getThread().getId()), getLooper().getThread().getName() });
          return false;
        }
        if (this.ufw != null) {
          this.ufw.onTaskAdded(localRunnable, (ao)localObject);
        }
        bool2 = super.sendMessageAtTime(localMessage, paramLong);
        bool1 = bool2;
      } while (bool2);
      bool1 = bool2;
    } while (this.ufw == null);
    this.ufw.onTaskRunEnd(localRunnable, (ao)localObject);
    return bool2;
  }
  
  public final String toString()
  {
    if (this.toStringResult == null) {
      this.toStringResult = ("MMInnerHandler{listener = " + this.ufw + "}");
    }
    return this.toStringResult;
  }
  
  public static abstract interface a
  {
    public abstract void handleMessage(Message paramMessage);
    
    public abstract void onLog(Message paramMessage, Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, float paramFloat);
    
    public abstract void onTaskAdded(Runnable paramRunnable, ao paramao);
    
    public abstract void onTaskRunEnd(Runnable paramRunnable, ao paramao);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.aj
 * JD-Core Version:    0.7.0.1
 */