package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import junit.framework.Assert;

final class k
  extends Handler
  implements o
{
  private String Xw = null;
  private Looper Xx = getLooper();
  private Handler.Callback Xy;
  l Xz;
  
  k(Looper paramLooper, l paraml)
  {
    super(paramLooper);
    this.Xz = paraml;
  }
  
  k(l paraml)
  {
    this.Xz = paraml;
  }
  
  public final void c(Runnable paramRunnable, n paramn)
  {
    if (this.Xz != null) {
      this.Xz.b(paramRunnable, paramn);
    }
  }
  
  public final void dispatchMessage(Message paramMessage)
  {
    if ((paramMessage.getCallback() != null) || (this.Xy != null)) {
      super.dispatchMessage(paramMessage);
    }
    do
    {
      return;
      System.currentTimeMillis();
      Debug.threadCpuTimeNanos();
      handleMessage(paramMessage);
    } while (this.Xz == null);
    this.Xx.getThread();
    System.currentTimeMillis();
    Debug.threadCpuTimeNanos();
  }
  
  public final void handleMessage(Message paramMessage) {}
  
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
          localObject = new n(this.Xx.getThread(), (Handler)localObject, localRunnable, paramMessage.obj, this);
          if (l > 0L) {
            ((n)localObject).XI = l;
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
          f.b("MicroMsg.MMInnerHandler", "sendMessageAtTime but thread[%d, %s] is dead so return false!", new Object[] { Long.valueOf(getLooper().getThread().getId()), getLooper().getThread().getName() });
          return false;
        }
        if (this.Xz != null) {
          this.Xz.a(localRunnable, (n)localObject);
        }
        bool2 = super.sendMessageAtTime(localMessage, paramLong);
        bool1 = bool2;
      } while (bool2);
      bool1 = bool2;
    } while (this.Xz == null);
    this.Xz.b(localRunnable, (n)localObject);
    return bool2;
  }
  
  public final String toString()
  {
    if (this.Xw == null) {
      this.Xw = ("MMInnerHandler{listener = " + this.Xz + "}");
    }
    return this.Xw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.k
 * JD-Core Version:    0.7.0.1
 */