package mqq.os;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.util.Printer;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.qphone.base.util.QLog;

public class MqqMessageQueue
  implements Handler.Callback, MessageQueue.IdleHandler
{
  private static boolean DEBUG_QUEUE = false;
  private static final int MSG_HOOK = 1000;
  private static final int MSG_IDLE_TIMEOUT = 1001;
  private static final String TAG = "MqqMessage.Queue";
  public static boolean sRemoveIdleTimeOutMsg = true;
  private static MqqMessageQueue sSubMainQueue;
  private volatile boolean hookReqeusted = false;
  private volatile boolean idleHandlerAttached = false;
  Handler mHandler = new MqqMessageQueue.1(this, paramLooper, this);
  Printer mLogging;
  MqqMessage mMessages;
  long msgCount = 0L;
  long totalCost = 0L;
  
  private MqqMessageQueue(Looper paramLooper) {}
  
  private void cancelHookReq()
  {
    this.mHandler.removeMessages(1000);
    this.hookReqeusted = false;
  }
  
  private boolean dequeue(boolean paramBoolean)
  {
    Object localObject1;
    if ((DEBUG_QUEUE) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("enter dequeue, idle = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("MqqMessage.Queue", 2, ((StringBuilder)localObject1).toString());
    }
    MqqMessage localMqqMessage = next();
    if (localMqqMessage != null) {
      localObject1 = localMqqMessage.toString();
    } else {
      localObject1 = "null";
    }
    if (localMqqMessage != null)
    {
      int i;
      try
      {
        Object localObject2 = this.mLogging;
        if (localObject2 != null)
        {
          localObject2 = new StringBuilder(256);
          ((StringBuilder)localObject2).append(">>>>> Dispatching to ");
          ((StringBuilder)localObject2).append(localMqqMessage.target);
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(localMqqMessage.wrappedMsg.getCallback());
          ((StringBuilder)localObject2).append(": ");
          ((StringBuilder)localObject2).append(localMqqMessage.wrappedMsg.what);
          this.mLogging.println(((StringBuilder)localObject2).toString());
        }
        long l = SystemClock.uptimeMillis();
        localMqqMessage.target.dispatchMessage(localMqqMessage.wrappedMsg);
        this.totalCost += SystemClock.uptimeMillis() - l;
        this.msgCount += 1L;
        if (this.mLogging != null)
        {
          localObject2 = new StringBuilder(256);
          ((StringBuilder)localObject2).append("<<<<< Finished to ");
          ((StringBuilder)localObject2).append(localMqqMessage.target);
          ((StringBuilder)localObject2).append(" ");
          ((StringBuilder)localObject2).append(localMqqMessage.wrappedMsg.getCallback());
          this.mLogging.println(((StringBuilder)localObject2).toString());
        }
        try
        {
          localMqqMessage.recycle();
        }
        catch (Throwable localThrowable1)
        {
          i = 1;
        }
        if (localMqqMessage.wrappedMsg == null) {
          break label418;
        }
      }
      catch (Throwable localThrowable2)
      {
        i = 0;
      }
      if (i != 0)
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("current message: ");
        ((StringBuilder)localObject3).append(localMqqMessage.wrappedMsg.toString());
        localObject3 = ((StringBuilder)localObject3).toString();
        QLog.e("MqqMessage.Queue", 1, (String)localObject3);
        Thread localThread = Thread.currentThread();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ExtraMessage: ");
        localStringBuilder.append((String)localObject3);
        CrashReport.handleCatchException(localThread, localThrowable2, localStringBuilder.toString(), null);
      }
      else
      {
        label418:
        throwException(localThrowable2);
      }
    }
    if ((DEBUG_QUEUE) && (this.msgCount % 100L == 0L) && (QLog.isColorLevel())) {
      QLog.d("MqqMessage.Queue", 2, new Object[] { "dequeue|", Long.valueOf(this.msgCount), "|", Long.valueOf(this.totalCost) });
    }
    if (localMqqMessage != null)
    {
      if ((DEBUG_QUEUE) && (QLog.isColorLevel())) {
        QLog.d("MqqMessage.Queue", 2, new Object[] { "dequeue, msg = ", localObject1 });
      }
      return true;
    }
    if ((DEBUG_QUEUE) && (QLog.isColorLevel())) {
      QLog.d("MqqMessage.Queue", 2, "dequeue, msg = null");
    }
    return false;
  }
  
  public static MqqMessageQueue getSubMainThreadQueue()
  {
    try
    {
      if (sSubMainQueue == null) {
        sSubMainQueue = new MqqMessageQueue(Looper.getMainLooper());
      }
      MqqMessageQueue localMqqMessageQueue = sSubMainQueue;
      return localMqqMessageQueue;
    }
    finally {}
  }
  
  private final void onQueueIdleTimeout()
  {
    if (dequeue(false))
    {
      this.mHandler.sendEmptyMessage(1001);
      return;
    }
    if (sRemoveIdleTimeOutMsg)
    {
      QLog.d("MqqMessage.Queue", 1, "onQueueIdleTimeout,remove all MSG_IDLE_TIMEOUT");
      this.mHandler.removeMessages(1001);
    }
  }
  
  private void printDeletionLog(MqqMessage paramMqqMessage)
  {
    if ((DEBUG_QUEUE) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeMsg: ");
      localStringBuilder.append(paramMqqMessage.toString());
      QLog.d("MqqMessage.Queue", 2, localStringBuilder.toString());
    }
  }
  
  private void reqHookIdleHandler()
  {
    if ((DEBUG_QUEUE) && (QLog.isColorLevel())) {
      QLog.d("MqqMessage.Queue", 2, new Object[] { "reqHook, attached = ", Boolean.valueOf(this.idleHandlerAttached), ", requested = ", Boolean.valueOf(this.hookReqeusted) });
    }
    if ((!this.idleHandlerAttached) && (!this.hookReqeusted))
    {
      this.hookReqeusted = true;
      this.mHandler.sendEmptyMessage(1000);
      return;
    }
    this.mHandler.sendEmptyMessageDelayed(1001, 1000L);
  }
  
  private void throwException(Throwable paramThrowable)
  {
    new MqqMessageQueue.2(this, paramThrowable).start();
  }
  
  boolean enqueueMessage(MqqMessage paramMqqMessage, long paramLong)
  {
    Object localObject1;
    if ((DEBUG_QUEUE) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("enqueueMessage: ");
      ((StringBuilder)localObject1).append(paramMqqMessage.toString());
      QLog.d("MqqMessage.Queue", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        paramMqqMessage.when = paramLong;
        localObject1 = this.mMessages;
        if ((localObject1 == null) || (paramLong == 0L)) {
          continue;
        }
        if (paramLong >= ((MqqMessage)localObject1).when) {
          continue;
        }
      }
      finally
      {
        Object localObject3;
        continue;
        throw paramMqqMessage;
        continue;
        Object localObject2 = null;
        continue;
      }
      localObject3 = localObject2;
      localObject2 = localObject1;
      if ((localObject2 == null) || (localObject2.when > paramLong)) {
        continue;
      }
      localObject1 = localObject2.next;
    }
    paramMqqMessage.next = localObject3.next;
    localObject3.next = paramMqqMessage;
    break label150;
    paramMqqMessage.next = ((MqqMessage)localObject1);
    this.mMessages = paramMqqMessage;
    label150:
    reqHookIdleHandler();
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((DEBUG_QUEUE) && (QLog.isColorLevel())) {
      QLog.d("MqqMessage.Queue", 2, new Object[] { "handleMessage, what = ", Integer.valueOf(paramMessage.what), ", attached = ", Boolean.valueOf(this.idleHandlerAttached) });
    }
    if (paramMessage.what == 1000)
    {
      if (!this.idleHandlerAttached)
      {
        cancelHookReq();
        this.idleHandlerAttached = true;
        this.mHandler.getLooper().getQueue().addIdleHandler(this);
      }
      this.mHandler.sendEmptyMessageDelayed(1001, 1000L);
      return true;
    }
    if (paramMessage.what == 1001) {
      onQueueIdleTimeout();
    }
    return true;
  }
  
  final MqqMessage next()
  {
    try
    {
      long l1 = SystemClock.uptimeMillis();
      MqqMessage localMqqMessage = this.mMessages;
      if (localMqqMessage != null)
      {
        long l2 = localMqqMessage.when;
        if (l1 >= l2)
        {
          this.mMessages = localMqqMessage.next;
          localMqqMessage.next = null;
          return localMqqMessage;
        }
        int i = (int)Math.min(l2 - l1, 2147483647L);
        this.mHandler.removeMessages(1000);
        this.mHandler.sendEmptyMessageDelayed(1000, i);
      }
      return null;
    }
    finally {}
  }
  
  public boolean queueIdle()
  {
    this.mHandler.removeMessages(1001);
    boolean bool = dequeue(true);
    if (bool)
    {
      this.mHandler.sendEmptyMessage(1000);
      return bool;
    }
    this.idleHandlerAttached = false;
    return bool;
  }
  
  void removeCallbacksAndMessages(MqqHandler paramMqqHandler, Object paramObject)
  {
    for (;;)
    {
      try
      {
        localObject1 = this.mMessages;
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((MqqMessage)localObject1).target == paramMqqHandler) {
            if (paramObject != null)
            {
              localObject2 = localObject1;
              if (((MqqMessage)localObject1).wrappedMsg.obj != paramObject) {}
            }
            else
            {
              localObject2 = ((MqqMessage)localObject1).next;
              this.mMessages = ((MqqMessage)localObject2);
              printDeletionLog((MqqMessage)localObject1);
              ((MqqMessage)localObject1).recycle();
              localObject1 = localObject2;
              continue;
            }
          }
        }
      }
      finally
      {
        Object localObject1;
        MqqMessage localMqqMessage;
        continue;
        throw paramMqqHandler;
        continue;
        Object localObject2 = localObject1;
        continue;
      }
      if (localObject2 == null) {
        continue;
      }
      localObject1 = ((MqqMessage)localObject2).next;
      if ((localObject1 == null) || (((MqqMessage)localObject1).target != paramMqqHandler) || ((paramObject != null) && (((MqqMessage)localObject1).wrappedMsg.obj != paramObject))) {
        continue;
      }
      localMqqMessage = ((MqqMessage)localObject1).next;
      printDeletionLog((MqqMessage)localObject1);
      ((MqqMessage)localObject1).recycle();
      ((MqqMessage)localObject2).next = localMqqMessage;
    }
  }
  
  final void removeMessages(MqqHandler paramMqqHandler, Runnable paramRunnable, Object paramObject)
  {
    if (paramRunnable == null) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = this.mMessages;
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((MqqMessage)localObject1).target == paramMqqHandler)
          {
            localObject2 = localObject1;
            if (((MqqMessage)localObject1).wrappedMsg.getCallback() == paramRunnable) {
              if (paramObject != null)
              {
                localObject2 = localObject1;
                if (((MqqMessage)localObject1).wrappedMsg.obj != paramObject) {}
              }
              else
              {
                localObject2 = ((MqqMessage)localObject1).next;
                this.mMessages = ((MqqMessage)localObject2);
                printDeletionLog((MqqMessage)localObject1);
                ((MqqMessage)localObject1).recycle();
                localObject1 = localObject2;
                continue;
              }
            }
          }
        }
      }
      finally
      {
        Object localObject1;
        MqqMessage localMqqMessage;
        continue;
        throw paramMqqHandler;
        continue;
        Object localObject2 = localObject1;
        continue;
      }
      if (localObject2 == null) {
        continue;
      }
      localObject1 = ((MqqMessage)localObject2).next;
      if ((localObject1 == null) || (((MqqMessage)localObject1).target != paramMqqHandler) || (((MqqMessage)localObject1).wrappedMsg.getCallback() != paramRunnable) || ((paramObject != null) && (((MqqMessage)localObject1).wrappedMsg.obj != paramObject))) {
        continue;
      }
      localMqqMessage = ((MqqMessage)localObject1).next;
      printDeletionLog((MqqMessage)localObject1);
      ((MqqMessage)localObject1).recycle();
      ((MqqMessage)localObject2).next = localMqqMessage;
    }
  }
  
  boolean removeMessages(MqqHandler paramMqqHandler, int paramInt, Object paramObject, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        localObject1 = this.mMessages;
        boolean bool1 = false;
        localObject2 = localObject1;
        bool2 = bool1;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          bool2 = bool1;
          if (((MqqMessage)localObject1).target == paramMqqHandler)
          {
            localObject2 = localObject1;
            bool2 = bool1;
            if (((MqqMessage)localObject1).wrappedMsg.what == paramInt) {
              if (paramObject != null)
              {
                localObject2 = localObject1;
                bool2 = bool1;
                if (((MqqMessage)localObject1).wrappedMsg.obj != paramObject) {}
              }
              else
              {
                if (!paramBoolean) {
                  return true;
                }
                localObject2 = ((MqqMessage)localObject1).next;
                this.mMessages = ((MqqMessage)localObject2);
                printDeletionLog((MqqMessage)localObject1);
                ((MqqMessage)localObject1).recycle();
                localObject1 = localObject2;
                bool1 = true;
                continue;
              }
            }
          }
        }
      }
      finally
      {
        Object localObject1;
        boolean bool2;
        MqqMessage localMqqMessage;
        continue;
        throw paramMqqHandler;
        continue;
        Object localObject2 = localObject1;
        continue;
      }
      if (localObject2 == null) {
        continue;
      }
      localObject1 = ((MqqMessage)localObject2).next;
      if ((localObject1 == null) || (((MqqMessage)localObject1).target != paramMqqHandler) || (((MqqMessage)localObject1).wrappedMsg.what != paramInt) || ((paramObject != null) && (((MqqMessage)localObject1).wrappedMsg.obj != paramObject))) {
        continue;
      }
      if (!paramBoolean) {
        return true;
      }
      localMqqMessage = ((MqqMessage)localObject1).next;
      printDeletionLog((MqqMessage)localObject1);
      ((MqqMessage)localObject1).recycle();
      ((MqqMessage)localObject2).next = localMqqMessage;
      bool2 = true;
    }
    return bool2;
  }
  
  public void setDetailLogging(boolean paramBoolean)
  {
    DEBUG_QUEUE = paramBoolean;
    MqqMessage.DEBUG_MESSAGE = paramBoolean;
  }
  
  public void setMessageLogging(Printer paramPrinter)
  {
    this.mLogging = paramPrinter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.os.MqqMessageQueue
 * JD-Core Version:    0.7.0.1
 */