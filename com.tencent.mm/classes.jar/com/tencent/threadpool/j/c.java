package com.tencent.threadpool.j;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.d.e;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.j;
import com.tencent.threadpool.i.k;
import com.tencent.threadpool.l.b;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class c
  implements com.tencent.threadpool.d.a
{
  private static final String TAG = "SerialHandler";
  private final Handler.Callback callback;
  private boolean hasDefaultLooper;
  private boolean isLogging;
  private AtomicBoolean isQuit;
  private final Handler proxyHandler;
  private b recycleMethod;
  private final a serial;
  private final String serialTag;
  
  public c(a parama)
  {
    this(parama, null);
  }
  
  public c(a parama, Handler.Callback paramCallback)
  {
    AppMethodBeat.i(183430);
    this.isLogging = true;
    this.isQuit = new AtomicBoolean();
    this.proxyHandler = new Handler(Looper.getMainLooper())
    {
      public final void dispatchMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(183411);
        c.this.dispatchMessage(paramAnonymousMessage);
        AppMethodBeat.o(183411);
      }
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(183412);
        c.this.handleMessage(paramAnonymousMessage);
        AppMethodBeat.o(183412);
      }
      
      public final boolean sendMessageAtTime(Message paramAnonymousMessage, long paramAnonymousLong)
      {
        AppMethodBeat.i(183413);
        paramAnonymousMessage.setTarget(c.this.proxyHandler);
        boolean bool = c.this.sendMessageAtTime(paramAnonymousMessage, paramAnonymousLong);
        AppMethodBeat.o(183413);
        return bool;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(183414);
        String str = c.this.toString();
        AppMethodBeat.o(183414);
        return str;
      }
    };
    this.recycleMethod = new b(Message.class, "recycleUnchecked", new Class[0]);
    Objects.requireNonNull(parama);
    this.serial = parama;
    this.serialTag = parama.tag;
    this.callback = paramCallback;
    try
    {
      parama = this.proxyHandler;
      new com.tencent.threadpool.l.a(Handler.class, "mLooper").hi(parama);
      AppMethodBeat.o(183430);
      return;
    }
    catch (Exception parama)
    {
      parama = new RuntimeException(parama);
      AppMethodBeat.o(183430);
      throw parama;
    }
  }
  
  public c(String paramString)
  {
    this(a.bFV(paramString), null);
    AppMethodBeat.i(226923);
    AppMethodBeat.o(226923);
  }
  
  public c(String paramString, Handler.Callback paramCallback)
  {
    this(a.bFV(paramString), paramCallback);
    AppMethodBeat.i(226924);
    AppMethodBeat.o(226924);
  }
  
  private void cancelAll()
  {
    AppMethodBeat.i(226925);
    this.serial.ahCy.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool = false;
        AppMethodBeat.i(183425);
        paramAnonymouse = paramAnonymouse.ahCo;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          if (paramAnonymouse.token == c.this) {
            bool = true;
          }
          if (bool) {
            paramAnonymouse.cancel();
          }
          AppMethodBeat.o(183425);
          return bool;
        }
        AppMethodBeat.o(183425);
        return false;
      }
    });
    AppMethodBeat.o(226925);
  }
  
  public static c create(String paramString)
  {
    AppMethodBeat.i(226920);
    paramString = new c(paramString);
    AppMethodBeat.o(226920);
    return paramString;
  }
  
  private void recycleMessage(Message paramMessage)
  {
    AppMethodBeat.i(226926);
    if (paramMessage == null)
    {
      AppMethodBeat.o(226926);
      return;
    }
    try
    {
      this.recycleMethod.a(paramMessage, new Object[0]);
      AppMethodBeat.o(226926);
      return;
    }
    catch (Exception paramMessage)
    {
      paramMessage = new RuntimeException(paramMessage);
      AppMethodBeat.o(226926);
      throw paramMessage;
    }
  }
  
  protected a createRunnable(Message paramMessage)
  {
    AppMethodBeat.i(227135);
    paramMessage = new a(paramMessage);
    AppMethodBeat.o(227135);
    return paramMessage;
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    AppMethodBeat.i(183451);
    if (paramMessage.getCallback() != null)
    {
      paramMessage.getCallback().run();
      AppMethodBeat.o(183451);
      return;
    }
    if ((this.callback != null) && (this.callback.handleMessage(paramMessage)))
    {
      AppMethodBeat.o(183451);
      return;
    }
    handleMessage(paramMessage);
    AppMethodBeat.o(183451);
  }
  
  public void dump(Printer paramPrinter, String paramString)
  {
    AppMethodBeat.i(183461);
    paramPrinter.println(paramString + this.serial.ahCy.jZD().toString());
    AppMethodBeat.o(183461);
  }
  
  public boolean executeOrSendMessage(Message paramMessage)
  {
    AppMethodBeat.i(183449);
    if (a.jZA() == this.serial)
    {
      dispatchMessage(paramMessage);
      AppMethodBeat.o(183449);
      return true;
    }
    boolean bool = sendMessage(paramMessage);
    AppMethodBeat.o(183449);
    return bool;
  }
  
  public Looper getLooper()
  {
    return null;
  }
  
  public String getMessageName(Message paramMessage)
  {
    AppMethodBeat.i(183431);
    paramMessage = this.proxyHandler.getMessageName(paramMessage);
    AppMethodBeat.o(183431);
    return paramMessage;
  }
  
  public Handler getSelf()
  {
    return null;
  }
  
  public a getSerial()
  {
    return this.serial;
  }
  
  public String getSerialTag()
  {
    return this.serialTag;
  }
  
  public void handleMessage(Message paramMessage) {}
  
  public boolean hasMessages(final int paramInt)
  {
    AppMethodBeat.i(183457);
    boolean bool = this.serial.ahCy.a(new d.a()
    {
      public final boolean d(e paramAnonymouse)
      {
        AppMethodBeat.i(183423);
        paramAnonymouse = paramAnonymouse.ahCo;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          if ((paramAnonymouse.token == c.this) && (c.a.a(paramAnonymouse).what == paramInt))
          {
            AppMethodBeat.o(183423);
            return true;
          }
          AppMethodBeat.o(183423);
          return false;
        }
        AppMethodBeat.o(183423);
        return false;
      }
    });
    AppMethodBeat.o(183457);
    return bool;
  }
  
  public boolean hasMessages(int paramInt, final Object paramObject)
  {
    AppMethodBeat.i(183458);
    boolean bool = this.serial.ahCy.a(new d.a()
    {
      public final boolean d(e paramAnonymouse)
      {
        AppMethodBeat.i(183424);
        paramAnonymouse = paramAnonymouse.ahCo;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          if ((paramAnonymouse.token == c.this) && (c.a.a(paramAnonymouse).obj == paramObject))
          {
            AppMethodBeat.o(183424);
            return true;
          }
          AppMethodBeat.o(183424);
          return false;
        }
        AppMethodBeat.o(183424);
        return false;
      }
    });
    AppMethodBeat.o(183458);
    return bool;
  }
  
  public boolean isQuit()
  {
    AppMethodBeat.i(183459);
    boolean bool = this.isQuit.get();
    AppMethodBeat.o(183459);
    return bool;
  }
  
  public Message obtainMessage()
  {
    AppMethodBeat.i(183432);
    Message localMessage = this.proxyHandler.obtainMessage();
    AppMethodBeat.o(183432);
    return localMessage;
  }
  
  public Message obtainMessage(int paramInt)
  {
    AppMethodBeat.i(183433);
    Message localMessage = this.proxyHandler.obtainMessage(paramInt);
    AppMethodBeat.o(183433);
    return localMessage;
  }
  
  public Message obtainMessage(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(183435);
    Message localMessage = this.proxyHandler.obtainMessage(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(183435);
    return localMessage;
  }
  
  public Message obtainMessage(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(183436);
    paramObject = this.proxyHandler.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject);
    AppMethodBeat.o(183436);
    return paramObject;
  }
  
  public Message obtainMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(183434);
    paramObject = this.proxyHandler.obtainMessage(paramInt, paramObject);
    AppMethodBeat.o(183434);
    return paramObject;
  }
  
  public boolean post(Runnable paramRunnable)
  {
    AppMethodBeat.i(183437);
    boolean bool = this.proxyHandler.post(paramRunnable);
    AppMethodBeat.o(183437);
    return bool;
  }
  
  public boolean postAtFrontOfQueue(Runnable paramRunnable)
  {
    AppMethodBeat.i(183442);
    boolean bool = this.proxyHandler.sendMessageAtTime(Message.obtain(this.proxyHandler, paramRunnable), -9223372036854775808L);
    AppMethodBeat.o(183442);
    return bool;
  }
  
  public boolean postAtTime(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(183438);
    boolean bool = this.proxyHandler.postAtTime(paramRunnable, paramLong);
    AppMethodBeat.o(183438);
    return bool;
  }
  
  public boolean postAtTime(Runnable paramRunnable, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(183439);
    boolean bool = this.proxyHandler.postAtTime(paramRunnable, paramObject, paramLong);
    AppMethodBeat.o(183439);
    return bool;
  }
  
  public boolean postDelayed(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(183440);
    boolean bool = this.proxyHandler.postDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(183440);
    return bool;
  }
  
  public boolean postDelayed(Runnable paramRunnable, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(183441);
    paramRunnable = Message.obtain(this.proxyHandler, paramRunnable);
    paramRunnable.obj = paramObject;
    boolean bool = sendMessageDelayed(paramRunnable, paramLong);
    AppMethodBeat.o(183441);
    return bool;
  }
  
  public boolean quit()
  {
    AppMethodBeat.i(183460);
    if (this.isQuit.compareAndSet(false, true))
    {
      cancelAll();
      AppMethodBeat.o(183460);
      return true;
    }
    AppMethodBeat.o(183460);
    return false;
  }
  
  public boolean quitSafely()
  {
    AppMethodBeat.i(227115);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(226917);
        c.this.quit();
        AppMethodBeat.o(226917);
      }
    });
    AppMethodBeat.o(227115);
    return true;
  }
  
  public void removeCallbacks(final Runnable paramRunnable)
  {
    AppMethodBeat.i(183452);
    this.serial.ahCy.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183418);
        paramAnonymouse = paramAnonymouse.ahCo;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.token == c.this)
          {
            bool1 = bool2;
            if (c.a.a(paramAnonymouse).getCallback() == paramRunnable) {
              bool1 = true;
            }
          }
          if (bool1) {
            paramAnonymouse.cancel();
          }
          AppMethodBeat.o(183418);
          return bool1;
        }
        AppMethodBeat.o(183418);
        return false;
      }
    });
    AppMethodBeat.o(183452);
  }
  
  public void removeCallbacks(final Runnable paramRunnable, final Object paramObject)
  {
    AppMethodBeat.i(183453);
    this.serial.ahCy.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183419);
        paramAnonymouse = paramAnonymouse.ahCo;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.token == c.this)
          {
            bool1 = bool2;
            if (c.a.a(paramAnonymouse).getCallback() == paramRunnable)
            {
              bool1 = bool2;
              if (c.a.a(paramAnonymouse).obj == paramObject) {
                bool1 = true;
              }
            }
          }
          if (bool1) {
            paramAnonymouse.cancel();
          }
          AppMethodBeat.o(183419);
          return bool1;
        }
        AppMethodBeat.o(183419);
        return false;
      }
    });
    AppMethodBeat.o(183453);
  }
  
  public void removeCallbacksAndMessages(final Object paramObject)
  {
    AppMethodBeat.i(183456);
    this.serial.ahCy.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183422);
        paramAnonymouse = paramAnonymouse.ahCo;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.token == c.this) {
            if (paramObject != null)
            {
              bool1 = bool2;
              if (c.a.a(paramAnonymouse).obj != paramObject) {}
            }
            else
            {
              bool1 = true;
            }
          }
          if (bool1) {
            paramAnonymouse.cancel();
          }
          AppMethodBeat.o(183422);
          return bool1;
        }
        AppMethodBeat.o(183422);
        return false;
      }
    });
    AppMethodBeat.o(183456);
  }
  
  public void removeMessages(final int paramInt)
  {
    AppMethodBeat.i(183454);
    this.serial.ahCy.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183420);
        paramAnonymouse = paramAnonymouse.ahCo;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.token == c.this)
          {
            bool1 = bool2;
            if (c.a.a(paramAnonymouse).what == paramInt) {
              bool1 = true;
            }
          }
          if (bool1) {
            paramAnonymouse.cancel();
          }
          AppMethodBeat.o(183420);
          return bool1;
        }
        AppMethodBeat.o(183420);
        return false;
      }
    });
    AppMethodBeat.o(183454);
  }
  
  public void removeMessages(final int paramInt, final Object paramObject)
  {
    AppMethodBeat.i(183455);
    this.serial.ahCy.a(new d.b()
    {
      public final boolean c(e paramAnonymouse)
      {
        boolean bool2 = false;
        AppMethodBeat.i(183421);
        paramAnonymouse = paramAnonymouse.ahCo;
        if ((paramAnonymouse instanceof c.a))
        {
          paramAnonymouse = (c.a)paramAnonymouse;
          boolean bool1 = bool2;
          if (paramAnonymouse.token == c.this)
          {
            bool1 = bool2;
            if (c.a.a(paramAnonymouse).what == paramInt)
            {
              bool1 = bool2;
              if (c.a.a(paramAnonymouse).obj == paramObject) {
                bool1 = true;
              }
            }
          }
          if (bool1) {
            paramAnonymouse.cancel();
          }
          AppMethodBeat.o(183421);
          return bool1;
        }
        AppMethodBeat.o(183421);
        return false;
      }
    });
    AppMethodBeat.o(183455);
  }
  
  public boolean sendEmptyMessage(int paramInt)
  {
    AppMethodBeat.i(183444);
    boolean bool = this.proxyHandler.sendEmptyMessage(paramInt);
    AppMethodBeat.o(183444);
    return bool;
  }
  
  public boolean sendEmptyMessageAtTime(int paramInt, long paramLong)
  {
    AppMethodBeat.i(183446);
    boolean bool = this.proxyHandler.sendEmptyMessageAtTime(paramInt, paramLong);
    AppMethodBeat.o(183446);
    return bool;
  }
  
  public boolean sendEmptyMessageDelayed(int paramInt, long paramLong)
  {
    AppMethodBeat.i(183445);
    boolean bool = this.proxyHandler.sendEmptyMessageDelayed(paramInt, paramLong);
    AppMethodBeat.o(183445);
    return bool;
  }
  
  public boolean sendMessage(Message paramMessage)
  {
    AppMethodBeat.i(183443);
    boolean bool = this.proxyHandler.sendMessage(paramMessage);
    AppMethodBeat.o(183443);
    return bool;
  }
  
  public boolean sendMessageAtFrontOfQueue(Message paramMessage)
  {
    AppMethodBeat.i(183448);
    boolean bool = this.proxyHandler.sendMessageAtTime(paramMessage, -9223372036854775808L);
    AppMethodBeat.o(183448);
    return bool;
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(183450);
    paramMessage = createRunnable(paramMessage);
    if (isQuit())
    {
      com.tencent.threadpool.d.ahAo.h(paramMessage.getKey(), 0, this.serialTag);
      AppMethodBeat.o(183450);
      return false;
    }
    if (h.ahAA.isShutdown())
    {
      com.tencent.threadpool.d.ahAo.h(paramMessage.getKey(), 0, this.serialTag);
      AppMethodBeat.o(183450);
      return false;
    }
    if (paramLong == -9223372036854775808L) {
      if (a.jZz() == this.serial) {
        h.ahAA.bl(paramMessage);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(183450);
      return true;
      h.ahAA.h(paramMessage, this.serialTag);
      continue;
      paramLong -= SystemClock.uptimeMillis();
      if (a.jZz() == this.serial) {
        h.ahAA.o(paramMessage, paramLong);
      } else {
        h.ahAA.a(paramMessage, paramLong, this.serialTag);
      }
    }
  }
  
  public boolean sendMessageDelayed(Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(183447);
    boolean bool = this.proxyHandler.sendMessageDelayed(paramMessage, paramLong);
    AppMethodBeat.o(183447);
    return bool;
  }
  
  public void setHasDefaultLooper(boolean paramBoolean)
  {
    this.hasDefaultLooper = paramBoolean;
  }
  
  public void setLogging(boolean paramBoolean)
  {
    this.isLogging = paramBoolean;
  }
  
  public String toString()
  {
    AppMethodBeat.i(183462);
    String str = String.format("SerialHandler(%s) %s", new Object[] { getSerialTag(), getClass().getName() });
    AppMethodBeat.o(183462);
    return str;
  }
  
  class a
    implements com.tencent.threadpool.i.e, j
  {
    private Message ahCE;
    private String ahCF;
    private Future<?> dBj;
    Object token;
    
    a(Message paramMessage)
    {
      AppMethodBeat.i(183426);
      if (paramMessage == null)
      {
        this$1 = new NullPointerException("msg is null");
        AppMethodBeat.o(183426);
        throw c.this;
      }
      this.ahCE = paramMessage;
      this.ahCF = (c.this.serialTag + "#" + c.this.getMessageName(paramMessage));
      this.token = c.this;
      AppMethodBeat.o(183426);
    }
    
    public final void c(Future paramFuture)
    {
      this.dBj = paramFuture;
    }
    
    public final boolean cancel()
    {
      AppMethodBeat.i(183428);
      c.access$400(c.this, this.ahCE);
      boolean bool = this.dBj.cancel(false);
      AppMethodBeat.o(183428);
      return bool;
    }
    
    public String getKey()
    {
      return this.ahCF;
    }
    
    public boolean isLogging()
    {
      AppMethodBeat.i(183429);
      boolean bool = c.this.isLogging;
      AppMethodBeat.o(183429);
      return bool;
    }
    
    public void run()
    {
      AppMethodBeat.i(183427);
      if (c.this.isQuit.get())
      {
        this.dBj.cancel(false);
        com.tencent.threadpool.d.ahAq.w("SerialHandler", String.format("this handler has quit! %s", new Object[] { this.ahCF }), new Object[0]);
        AppMethodBeat.o(183427);
        return;
      }
      if ((this.ahCE.getTarget() == null) && (this.ahCE.obj == null) && (this.ahCE.what == 0))
      {
        this.dBj.cancel(false);
        com.tencent.threadpool.d.ahAq.w("SerialHandler", String.format("maybe it's removed before! %s", new Object[] { this.ahCF }), new Object[0]);
        AppMethodBeat.o(183427);
        return;
      }
      ((Handler)Objects.requireNonNull(this.ahCE.getTarget(), "target is null!")).dispatchMessage(this.ahCE);
      c.access$400(c.this, this.ahCE);
      AppMethodBeat.o(183427);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.j.c
 * JD-Core Version:    0.7.0.1
 */