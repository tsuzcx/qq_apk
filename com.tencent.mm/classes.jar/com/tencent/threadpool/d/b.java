package com.tencent.threadpool.d;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.d;
import com.tencent.threadpool.d.a;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b
  implements a
{
  private AtomicBoolean isQuit;
  private final Handler proxyHandler;
  
  public b(Handler paramHandler)
  {
    AppMethodBeat.i(183245);
    this.isQuit = new AtomicBoolean();
    this.proxyHandler = paramHandler;
    AppMethodBeat.o(183245);
  }
  
  public final void dispatchMessage(Message paramMessage)
  {
    AppMethodBeat.i(183270);
    this.proxyHandler.dispatchMessage(paramMessage);
    AppMethodBeat.o(183270);
  }
  
  public final void dump(Printer paramPrinter, String paramString)
  {
    AppMethodBeat.i(183276);
    this.proxyHandler.dump(paramPrinter, paramString);
    AppMethodBeat.o(183276);
  }
  
  public final boolean executeOrSendMessage(Message paramMessage)
  {
    AppMethodBeat.i(183267);
    if (isQuit())
    {
      AppMethodBeat.o(183267);
      return false;
    }
    if (getLooper() == Looper.myLooper())
    {
      this.proxyHandler.dispatchMessage(paramMessage);
      AppMethodBeat.o(183267);
      return true;
    }
    boolean bool = sendMessage(paramMessage);
    AppMethodBeat.o(183267);
    return bool;
  }
  
  public final Looper getLooper()
  {
    AppMethodBeat.i(183274);
    Looper localLooper = this.proxyHandler.getLooper();
    AppMethodBeat.o(183274);
    return localLooper;
  }
  
  public final String getMessageName(Message paramMessage)
  {
    AppMethodBeat.i(183246);
    paramMessage = this.proxyHandler.getMessageName(paramMessage);
    AppMethodBeat.o(183246);
    return paramMessage;
  }
  
  public final Handler getSelf()
  {
    return this.proxyHandler;
  }
  
  public final com.tencent.threadpool.j.a getSerial()
  {
    return null;
  }
  
  public final String getSerialTag()
  {
    return null;
  }
  
  public final boolean hasMessages(int paramInt)
  {
    AppMethodBeat.i(183272);
    boolean bool = this.proxyHandler.hasMessages(paramInt);
    AppMethodBeat.o(183272);
    return bool;
  }
  
  public final boolean hasMessages(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(183273);
    boolean bool = this.proxyHandler.hasMessages(paramInt, paramObject);
    AppMethodBeat.o(183273);
    return bool;
  }
  
  public final boolean isQuit()
  {
    AppMethodBeat.i(183277);
    boolean bool = this.isQuit.get();
    AppMethodBeat.o(183277);
    return bool;
  }
  
  public final Message obtainMessage()
  {
    AppMethodBeat.i(183247);
    Message localMessage = this.proxyHandler.obtainMessage();
    AppMethodBeat.o(183247);
    return localMessage;
  }
  
  public final Message obtainMessage(int paramInt)
  {
    AppMethodBeat.i(183248);
    Message localMessage = this.proxyHandler.obtainMessage(paramInt);
    AppMethodBeat.o(183248);
    return localMessage;
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(183250);
    Message localMessage = this.proxyHandler.obtainMessage(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(183250);
    return localMessage;
  }
  
  public final Message obtainMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(183251);
    paramObject = this.proxyHandler.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject);
    AppMethodBeat.o(183251);
    return paramObject;
  }
  
  public final Message obtainMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(183249);
    paramObject = this.proxyHandler.obtainMessage(paramInt, paramObject);
    AppMethodBeat.o(183249);
    return paramObject;
  }
  
  public final boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(183252);
    boolean bool = this.proxyHandler.post(paramRunnable);
    AppMethodBeat.o(183252);
    return bool;
  }
  
  public final boolean postAtFrontOfQueue(Runnable paramRunnable)
  {
    AppMethodBeat.i(183257);
    boolean bool = this.proxyHandler.postAtFrontOfQueue(paramRunnable);
    AppMethodBeat.o(183257);
    return bool;
  }
  
  public final boolean postAtTime(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(183253);
    boolean bool = this.proxyHandler.postAtTime(paramRunnable, paramLong);
    AppMethodBeat.o(183253);
    return bool;
  }
  
  public final boolean postAtTime(Runnable paramRunnable, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(183254);
    boolean bool = this.proxyHandler.postAtTime(paramRunnable, paramObject, paramLong);
    AppMethodBeat.o(183254);
    return bool;
  }
  
  public final boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(183255);
    boolean bool = this.proxyHandler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(183255);
    return bool;
  }
  
  public final boolean postDelayed(Runnable paramRunnable, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(183256);
    if (Build.VERSION.SDK_INT >= 28)
    {
      boolean bool = this.proxyHandler.postDelayed(paramRunnable, paramObject, paramLong);
      AppMethodBeat.o(183256);
      return bool;
    }
    paramRunnable = new RuntimeException("Call requires API level 28 (current min is 19): android.os.Handler#postDelayed");
    AppMethodBeat.o(183256);
    throw paramRunnable;
  }
  
  public final boolean quit()
  {
    AppMethodBeat.i(183275);
    if (this.isQuit.compareAndSet(false, true))
    {
      removeCallbacksAndMessages(null);
      if (getLooper() != null) {
        d.ahAq.w("WrapperHandler", "Do you want to quit this looper thread? You'd better get this Looper to quit.", new Object[0]);
      }
      AppMethodBeat.o(183275);
      return true;
    }
    AppMethodBeat.o(183275);
    return false;
  }
  
  public final void removeCallbacks(Runnable paramRunnable)
  {
    AppMethodBeat.i(183258);
    this.proxyHandler.removeCallbacks(paramRunnable);
    AppMethodBeat.o(183258);
  }
  
  public final void removeCallbacks(Runnable paramRunnable, Object paramObject)
  {
    AppMethodBeat.i(183259);
    this.proxyHandler.removeCallbacks(paramRunnable, paramObject);
    AppMethodBeat.o(183259);
  }
  
  public final void removeCallbacksAndMessages(Object paramObject)
  {
    AppMethodBeat.i(183271);
    this.proxyHandler.removeCallbacksAndMessages(paramObject);
    AppMethodBeat.o(183271);
  }
  
  public final void removeMessages(int paramInt)
  {
    AppMethodBeat.i(183268);
    this.proxyHandler.removeMessages(paramInt);
    AppMethodBeat.o(183268);
  }
  
  public final void removeMessages(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(183269);
    this.proxyHandler.removeMessages(paramInt, paramObject);
    AppMethodBeat.o(183269);
  }
  
  public final boolean sendEmptyMessage(int paramInt)
  {
    AppMethodBeat.i(183261);
    boolean bool = this.proxyHandler.sendEmptyMessage(paramInt);
    AppMethodBeat.o(183261);
    return bool;
  }
  
  public final boolean sendEmptyMessageAtTime(int paramInt, long paramLong)
  {
    AppMethodBeat.i(183263);
    boolean bool = this.proxyHandler.sendEmptyMessageAtTime(paramInt, paramLong);
    AppMethodBeat.o(183263);
    return bool;
  }
  
  public final boolean sendEmptyMessageDelayed(int paramInt, long paramLong)
  {
    AppMethodBeat.i(183262);
    boolean bool = this.proxyHandler.sendEmptyMessageDelayed(paramInt, paramLong);
    AppMethodBeat.o(183262);
    return bool;
  }
  
  public final boolean sendMessage(Message paramMessage)
  {
    AppMethodBeat.i(183260);
    boolean bool = this.proxyHandler.sendMessage(paramMessage);
    AppMethodBeat.o(183260);
    return bool;
  }
  
  public final boolean sendMessageAtFrontOfQueue(Message paramMessage)
  {
    AppMethodBeat.i(183266);
    boolean bool = this.proxyHandler.sendMessageAtFrontOfQueue(paramMessage);
    AppMethodBeat.o(183266);
    return bool;
  }
  
  public final boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(183265);
    if (isQuit())
    {
      AppMethodBeat.o(183265);
      return false;
    }
    boolean bool = this.proxyHandler.sendMessageAtTime(paramMessage, paramLong);
    AppMethodBeat.o(183265);
    return bool;
  }
  
  public final boolean sendMessageDelayed(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(183264);
    boolean bool = this.proxyHandler.sendMessageDelayed(paramMessage, paramLong);
    AppMethodBeat.o(183264);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(183278);
    String str = this.proxyHandler.toString();
    AppMethodBeat.o(183278);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.d.b
 * JD-Core Version:    0.7.0.1
 */