package com.tencent.mm.sdk.platformtools;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.e.d.b;
import com.tencent.e.j.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Objects;

public class aq
  implements com.tencent.e.d.a
{
  private static final long SLOW_DURATION = 5000L;
  private static final long SLOW_UI_DURATION = 300L;
  private static final Handler UIHandler;
  private final Object lock;
  private final com.tencent.e.d.a realHandler;
  private volatile Message runningMsg;
  
  static
  {
    AppMethodBeat.i(182962);
    UIHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(182962);
  }
  
  public aq()
  {
    AppMethodBeat.i(157623);
    this.lock = new Object();
    this.realHandler = createHandler(Looper.myLooper(), com.tencent.e.j.a.gat(), null);
    AppMethodBeat.o(157623);
  }
  
  public aq(Looper paramLooper)
  {
    AppMethodBeat.i(157624);
    this.lock = new Object();
    Objects.requireNonNull(paramLooper);
    this.realHandler = createHandler(paramLooper, null, null);
    AppMethodBeat.o(157624);
  }
  
  public aq(Looper paramLooper, a parama)
  {
    AppMethodBeat.i(157626);
    this.lock = new Object();
    Objects.requireNonNull(paramLooper);
    this.realHandler = createHandler(paramLooper, null, parama);
    AppMethodBeat.o(157626);
  }
  
  public aq(com.tencent.e.j.a parama)
  {
    AppMethodBeat.i(182942);
    this.lock = new Object();
    Objects.requireNonNull(parama);
    this.realHandler = createHandler(null, parama, null);
    AppMethodBeat.o(182942);
  }
  
  public aq(com.tencent.e.j.a parama, a parama1)
  {
    AppMethodBeat.i(182943);
    this.lock = new Object();
    Objects.requireNonNull(parama);
    this.realHandler = createHandler(null, parama, parama1);
    AppMethodBeat.o(182943);
  }
  
  public aq(a parama)
  {
    AppMethodBeat.i(157625);
    this.lock = new Object();
    this.realHandler = createHandler(Looper.myLooper(), com.tencent.e.j.a.gat(), parama);
    AppMethodBeat.o(157625);
  }
  
  public aq(String paramString)
  {
    AppMethodBeat.i(157628);
    this.lock = new Object();
    this.realHandler = createHandler(null, com.tencent.e.j.a.bbi(paramString), null);
    AppMethodBeat.o(157628);
  }
  
  public aq(String paramString, a parama)
  {
    AppMethodBeat.i(157627);
    this.lock = new Object();
    Objects.requireNonNull(paramString);
    this.realHandler = createHandler(null, com.tencent.e.j.a.bbi(paramString), parama);
    AppMethodBeat.o(157627);
  }
  
  public static Handler createFreeHandler(Looper paramLooper)
  {
    AppMethodBeat.i(182957);
    paramLooper = new Handler(paramLooper);
    AppMethodBeat.o(182957);
    return paramLooper;
  }
  
  private com.tencent.e.d.a createHandler(Looper paramLooper, com.tencent.e.j.a parama, a parama1)
  {
    AppMethodBeat.i(182958);
    if ((paramLooper == Looper.getMainLooper()) || (parama == com.tencent.e.j.a.gas()))
    {
      paramLooper = createLooperHandler(Looper.getMainLooper(), parama1);
      AppMethodBeat.o(182958);
      return paramLooper;
    }
    if (parama != null)
    {
      paramLooper = createSerialHandler(parama, parama1);
      AppMethodBeat.o(182958);
      return paramLooper;
    }
    if (paramLooper != null)
    {
      paramLooper = createLooperHandler(paramLooper, parama1);
      AppMethodBeat.o(182958);
      return paramLooper;
    }
    paramLooper = new RuntimeException("looper and serial is null!");
    AppMethodBeat.o(182958);
    throw paramLooper;
  }
  
  private com.tencent.e.d.a createLooperHandler(Looper paramLooper, a parama)
  {
    AppMethodBeat.i(182959);
    paramLooper = new b(new Handler(paramLooper, parama)
    {
      public final void dispatchMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(182938);
        long l = System.currentTimeMillis();
        aq.access$002(aq.this, paramAnonymousMessage);
        super.dispatchMessage(paramAnonymousMessage);
        aq.access$002(aq.this, null);
        l = System.currentTimeMillis() - l;
        Thread localThread = Thread.currentThread();
        if (this.IxX == localThread.getId()) {
          if (l < 300L) {}
        }
        for (;;)
        {
          ae.w("Handler#Monitor", "This msg handle so slow[%sms]! runnable=%s callback=%s thread=%s", new Object[] { Long.valueOf(l), paramAnonymousMessage.getCallback(), this.IxY, localThread.getName() });
          do
          {
            AppMethodBeat.o(182938);
            return;
          } while (l < 5000L);
        }
      }
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(182939);
        aq.this.handleMessage(paramAnonymousMessage);
        AppMethodBeat.o(182939);
      }
    });
    AppMethodBeat.o(182959);
    return paramLooper;
  }
  
  @SuppressLint({"HandlerLeak"})
  private com.tencent.e.d.a createSerialHandler(com.tencent.e.j.a parama, a parama1)
  {
    AppMethodBeat.i(182960);
    parama = new c(parama, parama1)
    {
      public final void dispatchMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(182940);
        long l = System.currentTimeMillis();
        aq.access$002(aq.this, paramAnonymousMessage);
        super.dispatchMessage(paramAnonymousMessage);
        aq.access$002(aq.this, null);
        l = System.currentTimeMillis() - l;
        Thread localThread = Thread.currentThread();
        if (this.IxX == localThread.getId()) {
          if (l < 300L) {}
        }
        for (;;)
        {
          ae.w("Handler#Monitor", "This msg handle so slow[%sms]! runnable=%s callback=%s thread=%s", new Object[] { Long.valueOf(l), paramAnonymousMessage.getCallback(), this.IxY, localThread.getName() });
          do
          {
            AppMethodBeat.o(182940);
            return;
          } while (l < 5000L);
        }
      }
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(182941);
        aq.this.handleMessage(paramAnonymousMessage);
        AppMethodBeat.o(182941);
      }
    };
    AppMethodBeat.o(182960);
    return parama;
  }
  
  public final void dispatchMessage(Message paramMessage)
  {
    AppMethodBeat.i(182946);
    this.realHandler.dispatchMessage(paramMessage);
    AppMethodBeat.o(182946);
  }
  
  public void dump(Printer paramPrinter, String paramString)
  {
    AppMethodBeat.i(157656);
    this.realHandler.dump(paramPrinter, paramString);
    AppMethodBeat.o(157656);
  }
  
  public boolean executeOrSendMessage(Message paramMessage)
  {
    AppMethodBeat.i(182945);
    boolean bool = this.realHandler.executeOrSendMessage(paramMessage);
    AppMethodBeat.o(182945);
    return bool;
  }
  
  public Looper getLooper()
  {
    AppMethodBeat.i(157655);
    Looper localLooper = this.realHandler.getLooper();
    AppMethodBeat.o(157655);
    return localLooper;
  }
  
  public String getMessageName(Message paramMessage)
  {
    AppMethodBeat.i(157629);
    paramMessage = this.realHandler.getMessageName(paramMessage);
    AppMethodBeat.o(157629);
    return paramMessage;
  }
  
  public Message getRunningMessage()
  {
    return this.runningMsg;
  }
  
  public final Handler getSelf()
  {
    AppMethodBeat.i(182952);
    Handler localHandler = this.realHandler.getSelf();
    AppMethodBeat.o(182952);
    return localHandler;
  }
  
  public com.tencent.e.j.a getSerial()
  {
    AppMethodBeat.i(182948);
    com.tencent.e.j.a locala = this.realHandler.getSerial();
    AppMethodBeat.o(182948);
    return locala;
  }
  
  public String getSerialTag()
  {
    AppMethodBeat.i(182947);
    String str = this.realHandler.getSerialTag();
    AppMethodBeat.o(182947);
    return str;
  }
  
  public void handleMessage(Message paramMessage) {}
  
  public boolean hasMessages(int paramInt)
  {
    AppMethodBeat.i(157653);
    boolean bool = this.realHandler.hasMessages(paramInt);
    AppMethodBeat.o(157653);
    return bool;
  }
  
  public boolean hasMessages(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(157654);
    boolean bool = this.realHandler.hasMessages(paramInt, paramObject);
    AppMethodBeat.o(157654);
    return bool;
  }
  
  public boolean isQuit()
  {
    AppMethodBeat.i(182949);
    boolean bool = this.realHandler.isQuit();
    AppMethodBeat.o(182949);
    return bool;
  }
  
  public void join()
  {
    AppMethodBeat.i(182955);
    join(0L);
    AppMethodBeat.o(182955);
  }
  
  public void join(long paramLong)
  {
    AppMethodBeat.i(182956);
    long l2;
    synchronized (this.lock)
    {
      l2 = System.currentTimeMillis();
      if (paramLong < 0L)
      {
        IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("timeout value is negative");
        AppMethodBeat.o(182956);
        throw localIllegalArgumentException;
      }
    }
    if (paramLong == 0L) {
      while (!isQuit()) {
        this.lock.wait(paramLong);
      }
    }
    for (;;)
    {
      if (!isQuit())
      {
        Object localObject1;
        l1 = paramLong - localObject1;
        if (l1 > 0L)
        {
          this.lock.wait(l1);
          l1 = System.currentTimeMillis() - l2;
          continue;
        }
      }
      AppMethodBeat.o(182956);
      return;
      long l1 = 0L;
    }
  }
  
  public Message obtainMessage()
  {
    AppMethodBeat.i(157630);
    Message localMessage = this.realHandler.obtainMessage();
    AppMethodBeat.o(157630);
    return localMessage;
  }
  
  public Message obtainMessage(int paramInt)
  {
    AppMethodBeat.i(157631);
    Message localMessage = this.realHandler.obtainMessage(paramInt);
    AppMethodBeat.o(157631);
    return localMessage;
  }
  
  public Message obtainMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(157633);
    Message localMessage = this.realHandler.obtainMessage(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(157633);
    return localMessage;
  }
  
  public Message obtainMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(157634);
    paramObject = this.realHandler.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject);
    AppMethodBeat.o(157634);
    return paramObject;
  }
  
  public Message obtainMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(157632);
    paramObject = this.realHandler.obtainMessage(paramInt, paramObject);
    AppMethodBeat.o(157632);
    return paramObject;
  }
  
  public boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(157635);
    boolean bool = this.realHandler.post(paramRunnable);
    AppMethodBeat.o(157635);
    return bool;
  }
  
  public boolean postAtFrontOfQueue(Runnable paramRunnable)
  {
    AppMethodBeat.i(157639);
    boolean bool = this.realHandler.postAtFrontOfQueue(paramRunnable);
    AppMethodBeat.o(157639);
    return bool;
  }
  
  public boolean postAtTime(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(157636);
    boolean bool = this.realHandler.postAtTime(paramRunnable, paramLong);
    AppMethodBeat.o(157636);
    return bool;
  }
  
  public boolean postAtTime(Runnable paramRunnable, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(157637);
    boolean bool = this.realHandler.postAtTime(paramRunnable, paramObject, paramLong);
    AppMethodBeat.o(157637);
    return bool;
  }
  
  public boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(157638);
    boolean bool = this.realHandler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(157638);
    return bool;
  }
  
  public boolean postDelayed(Runnable paramRunnable, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(182944);
    boolean bool = this.realHandler.postDelayed(paramRunnable, paramObject, paramLong);
    AppMethodBeat.o(182944);
    return bool;
  }
  
  @Deprecated
  public final boolean postToWorker(Runnable paramRunnable)
  {
    AppMethodBeat.i(182961);
    boolean bool = this.realHandler.post(paramRunnable);
    AppMethodBeat.o(182961);
    return bool;
  }
  
  public void postUI(Runnable paramRunnable)
  {
    AppMethodBeat.i(182953);
    UIHandler.post(paramRunnable);
    AppMethodBeat.o(182953);
  }
  
  public void postUIDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(182954);
    UIHandler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(182954);
  }
  
  public boolean quit()
  {
    AppMethodBeat.i(182950);
    synchronized (this.lock)
    {
      boolean bool = this.realHandler.quit();
      this.lock.notifyAll();
      AppMethodBeat.o(182950);
      return bool;
    }
  }
  
  public boolean quitSafely()
  {
    AppMethodBeat.i(182951);
    this.realHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(182937);
        aq.this.quit();
        AppMethodBeat.o(182937);
      }
    });
    AppMethodBeat.o(182951);
    return true;
  }
  
  public void removeCallbacks(Runnable paramRunnable)
  {
    AppMethodBeat.i(157641);
    this.realHandler.removeCallbacks(paramRunnable);
    AppMethodBeat.o(157641);
  }
  
  public void removeCallbacks(Runnable paramRunnable, Object paramObject)
  {
    AppMethodBeat.i(157642);
    this.realHandler.removeCallbacks(paramRunnable, paramObject);
    AppMethodBeat.o(157642);
  }
  
  public void removeCallbacksAndMessages(Object paramObject)
  {
    AppMethodBeat.i(157652);
    this.realHandler.removeCallbacksAndMessages(paramObject);
    AppMethodBeat.o(157652);
  }
  
  public void removeMessages(int paramInt)
  {
    AppMethodBeat.i(157650);
    this.realHandler.removeMessages(paramInt);
    AppMethodBeat.o(157650);
  }
  
  public void removeMessages(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(157651);
    this.realHandler.removeMessages(paramInt, paramObject);
    AppMethodBeat.o(157651);
  }
  
  public boolean sendEmptyMessage(int paramInt)
  {
    AppMethodBeat.i(157644);
    boolean bool = this.realHandler.sendEmptyMessage(paramInt);
    AppMethodBeat.o(157644);
    return bool;
  }
  
  public boolean sendEmptyMessageAtTime(int paramInt, long paramLong)
  {
    AppMethodBeat.i(157646);
    boolean bool = this.realHandler.sendEmptyMessageAtTime(paramInt, paramLong);
    AppMethodBeat.o(157646);
    return bool;
  }
  
  public boolean sendEmptyMessageDelayed(int paramInt, long paramLong)
  {
    AppMethodBeat.i(157645);
    boolean bool = this.realHandler.sendEmptyMessageDelayed(paramInt, paramLong);
    AppMethodBeat.o(157645);
    return bool;
  }
  
  public boolean sendMessage(Message paramMessage)
  {
    AppMethodBeat.i(157643);
    boolean bool = this.realHandler.sendMessage(paramMessage);
    AppMethodBeat.o(157643);
    return bool;
  }
  
  public boolean sendMessageAtFrontOfQueue(Message paramMessage)
  {
    AppMethodBeat.i(157649);
    boolean bool = this.realHandler.sendMessageAtFrontOfQueue(paramMessage);
    AppMethodBeat.o(157649);
    return bool;
  }
  
  public final boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(157648);
    boolean bool = this.realHandler.sendMessageAtTime(paramMessage, paramLong);
    AppMethodBeat.o(157648);
    return bool;
  }
  
  public boolean sendMessageDelayed(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(157647);
    boolean bool = this.realHandler.sendMessageDelayed(paramMessage, paramLong);
    AppMethodBeat.o(157647);
    return bool;
  }
  
  public void setHasDefaultLooper(boolean paramBoolean)
  {
    if ((this.realHandler instanceof c)) {
      ((c)this.realHandler).MsC = paramBoolean;
    }
  }
  
  public void setLogging(boolean paramBoolean)
  {
    if ((this.realHandler instanceof c)) {
      ((c)this.realHandler).Msi = paramBoolean;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(157657);
    String str = this.realHandler.toString();
    AppMethodBeat.o(157657);
    return str;
  }
  
  public static abstract interface a
    extends Handler.Callback
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.aq
 * JD-Core Version:    0.7.0.1
 */