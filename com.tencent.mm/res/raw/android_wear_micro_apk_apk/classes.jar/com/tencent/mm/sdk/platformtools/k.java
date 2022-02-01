package com.tencent.mm.sdk.platformtools;

import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import junit.framework.Assert;

public class k
  extends Handler
  implements o
{
  private Handler.Callback ZA;
  public l ZB;
  private String Zy = null;
  private Looper Zz = getLooper();
  
  public k(Looper paramLooper, Handler.Callback paramCallback, l paraml)
  {
    super(paramLooper, null);
    this.ZA = null;
    this.ZB = paraml;
  }
  
  public k(Looper paramLooper, l paraml)
  {
    super(paramLooper);
    this.ZB = paraml;
  }
  
  public k(l paraml)
  {
    this.ZB = paraml;
  }
  
  public final void c(Runnable paramRunnable, n paramn)
  {
    if (this.ZB != null) {
      this.ZB.b(paramRunnable, paramn);
    }
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    if ((paramMessage.getCallback() != null) || (this.ZA != null)) {
      super.dispatchMessage(paramMessage);
    }
    do
    {
      return;
      System.currentTimeMillis();
      Bundle localBundle = paramMessage.getData();
      localBundle.getLong("addTime");
      localBundle.getLong("delay");
      localBundle = localBundle.getBundle("tmp");
      Debug.threadCpuTimeNanos();
      paramMessage.setData(localBundle);
      handleMessage(paramMessage);
    } while (this.ZB == null);
    this.Zz.getThread();
    System.currentTimeMillis();
    Debug.threadCpuTimeNanos();
  }
  
  public void handleMessage(Message paramMessage) {}
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    boolean bool1;
    Runnable localRunnable;
    long l;
    Object localObject;
    if (paramMessage != null)
    {
      bool1 = true;
      Assert.assertTrue("msg is null", bool1);
      localRunnable = paramMessage.getCallback();
      l = paramLong - SystemClock.uptimeMillis();
      if (localRunnable != null) {
        break label94;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putBundle("tmp", paramMessage.getData());
      ((Bundle)localObject).putLong("delay", l);
      ((Bundle)localObject).putLong("addTime", System.currentTimeMillis());
      paramMessage.setData((Bundle)localObject);
      bool1 = super.sendMessageAtTime(paramMessage, paramLong);
    }
    label94:
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        bool1 = false;
        break;
        if (paramMessage.getTarget() == null) {}
        Message localMessage;
        for (localObject = this;; localObject = paramMessage.getTarget())
        {
          localObject = new n(this.Zz.getThread(), (Handler)localObject, localRunnable, paramMessage.obj, this);
          if (l > 0L) {
            ((n)localObject).ZJ = l;
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
        if (this.ZB != null) {
          this.ZB.a(localRunnable, (n)localObject);
        }
        bool2 = super.sendMessageAtTime(localMessage, paramLong);
        bool1 = bool2;
      } while (bool2);
      bool1 = bool2;
    } while (this.ZB == null);
    this.ZB.b(localRunnable, (n)localObject);
    return bool2;
  }
  
  public String toString()
  {
    if (this.Zy == null) {
      this.Zy = ("MMInnerHandler{listener = " + this.ZB + "}");
    }
    return this.Zy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.k
 * JD-Core Version:    0.7.0.1
 */