package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public class MMLogHandler
  extends Handler
  implements MessageTask.MessageTaskCallback
{
  private static final String TAG = "MicroMsg.MMLogHandler";
  private MMHandler.Callback callback;
  public MessageTaskListener listener;
  private Looper looper;
  private String toStringResult;
  
  public MMLogHandler(Looper paramLooper, MMHandler.Callback paramCallback, MessageTaskListener paramMessageTaskListener)
  {
    super(paramLooper, paramCallback);
    AppMethodBeat.i(193974);
    this.toStringResult = null;
    this.looper = getLooper();
    this.callback = paramCallback;
    this.listener = paramMessageTaskListener;
    AppMethodBeat.o(193974);
  }
  
  public MMLogHandler(Looper paramLooper, MessageTaskListener paramMessageTaskListener)
  {
    super(paramLooper);
    AppMethodBeat.i(193972);
    this.toStringResult = null;
    this.looper = getLooper();
    this.listener = paramMessageTaskListener;
    AppMethodBeat.o(193972);
  }
  
  public MMLogHandler(MMHandler.Callback paramCallback, MessageTaskListener paramMessageTaskListener)
  {
    super(paramCallback);
    AppMethodBeat.i(193973);
    this.toStringResult = null;
    this.looper = getLooper();
    this.callback = paramCallback;
    this.listener = paramMessageTaskListener;
    AppMethodBeat.o(193973);
  }
  
  public MMLogHandler(MessageTaskListener paramMessageTaskListener)
  {
    AppMethodBeat.i(193970);
    this.toStringResult = null;
    this.looper = getLooper();
    this.listener = paramMessageTaskListener;
    AppMethodBeat.o(193970);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    AppMethodBeat.i(193978);
    if ((paramMessage.getCallback() != null) || (this.callback != null))
    {
      super.dispatchMessage(paramMessage);
      AppMethodBeat.o(193978);
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = Debug.threadCpuTimeNanos();
    handleMessage(paramMessage);
    if (this.listener != null) {
      this.listener.onLog(paramMessage, null, this.looper.getThread(), System.currentTimeMillis() - l1, Debug.threadCpuTimeNanos() - l2, -1.0F);
    }
    AppMethodBeat.o(193978);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(193979);
    if (this.listener != null) {
      this.listener.handleMessage(paramMessage);
    }
    AppMethodBeat.o(193979);
  }
  
  public void onLog(Message paramMessage, Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, float paramFloat)
  {
    AppMethodBeat.i(193985);
    if (this.listener != null) {
      this.listener.onLog(paramMessage, paramRunnable, paramThread, paramLong1, paramLong2, paramFloat);
    }
    AppMethodBeat.o(193985);
  }
  
  public void onRunEnd(Runnable paramRunnable, MessageTask paramMessageTask)
  {
    AppMethodBeat.i(193983);
    if (this.listener != null) {
      this.listener.onTaskRunEnd(paramRunnable, paramMessageTask);
    }
    AppMethodBeat.o(193983);
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(193977);
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
      bool = super.sendMessageAtTime(paramMessage, paramLong);
      AppMethodBeat.o(193977);
      return bool;
    }
    if (paramMessage.getTarget() == null) {}
    Message localMessage;
    for (Object localObject = this;; localObject = paramMessage.getTarget())
    {
      localObject = new MessageTask(this.looper.getThread(), (Handler)localObject, localRunnable, paramMessage.obj, this);
      if (l > 0L) {
        ((MessageTask)localObject).delayTime = l;
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
      Log.w("MicroMsg.MMLogHandler", "sendMessageAtTime but thread[%d, %s] is dead so return false!", new Object[] { Long.valueOf(getLooper().getThread().getId()), getLooper().getThread().getName() });
      AppMethodBeat.o(193977);
      return false;
    }
    if (this.listener != null) {
      this.listener.onTaskAdded(localRunnable, (MessageTask)localObject);
    }
    bool = super.sendMessageAtTime(localMessage, paramLong);
    if ((!bool) && (this.listener != null)) {
      this.listener.onTaskRunEnd(localRunnable, (MessageTask)localObject);
    }
    AppMethodBeat.o(193977);
    return bool;
  }
  
  public String toString()
  {
    AppMethodBeat.i(193980);
    if (this.toStringResult == null) {
      this.toStringResult = ("MMLogHandler{listener = " + this.listener + "}");
    }
    String str = this.toStringResult;
    AppMethodBeat.o(193980);
    return str;
  }
  
  public static abstract interface MessageTaskListener
  {
    public abstract void handleMessage(Message paramMessage);
    
    public abstract void onLog(Message paramMessage, Runnable paramRunnable, Thread paramThread, long paramLong1, long paramLong2, float paramFloat);
    
    public abstract void onTaskAdded(Runnable paramRunnable, MessageTask paramMessageTask);
    
    public abstract void onTaskRunEnd(Runnable paramRunnable, MessageTask paramMessageTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMLogHandler
 * JD-Core Version:    0.7.0.1
 */