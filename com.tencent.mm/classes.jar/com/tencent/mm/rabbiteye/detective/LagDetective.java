package com.tencent.mm.rabbiteye.detective;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.Printer;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.rabbiteye.a.a;
import com.tencent.mm.rabbiteye.a.b;
import com.tencent.mm.rabbiteye.a.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LagDetective
  extends a
{
  private static volatile LagDetective NAQ;
  private static Handler NAR;
  private static Runnable NAS;
  private static Runnable NAT;
  private static a.b NAU;
  private static a.a NAV;
  private static long b;
  private static HandlerThread c;
  private static HandlerThread d;
  private static Handler e;
  private static boolean i;
  private static long l;
  private static boolean m;
  
  static
  {
    AppMethodBeat.i(186301);
    NAQ = new LagDetective();
    b = 5000L;
    c = new HandlerThread("LooperLagThread");
    d = new HandlerThread("IdleHandlerLagThread");
    e = null;
    NAR = null;
    NAS = new b();
    NAT = new a();
    i = false;
    l = 0L;
    AppMethodBeat.o(186301);
  }
  
  public static LagDetective b(a.b paramb, a.a parama)
  {
    try
    {
      NAU = paramb;
      NAV = parama;
      b = parama.h;
      paramb = NAQ;
      return paramb;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  private static native void nativeInitTouchDetective(int paramInt);
  
  public static native void nativeTestSleep();
  
  @Keep
  private static void onTouchDumped(int paramInt)
  {
    AppMethodBeat.i(186299);
    if (System.currentTimeMillis() - l > NAV.i * 2L)
    {
      String str1 = b.gut();
      boolean bool = com.tencent.mm.rabbiteye.a.a.gus();
      String str2 = com.tencent.mm.rabbiteye.a.a.RF();
      NAU.a("Touch", paramInt, str1, bool, str2);
    }
    l = System.currentTimeMillis();
    AppMethodBeat.o(186299);
  }
  
  public final void start()
  {
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      try
      {
        AppMethodBeat.i(186302);
        if (m)
        {
          AppMethodBeat.o(186302);
          return;
        }
        m = true;
        if (NAV.f) {
          nativeInitTouchDetective((int)NAV.i);
        }
        boolean bool = NAV.g;
        if (!bool) {}
      }
      finally {}
      try
      {
        localObject1 = Looper.getMainLooper().getQueue();
        localObject3 = MessageQueue.class.getDeclaredField("mIdleHandlers");
        ((Field)localObject3).setAccessible(true);
        ((Field)localObject3).set(localObject1, new d());
        d.start();
        NAR = new Handler(d.getLooper());
      }
      catch (Throwable localThrowable)
      {
        continue;
      }
      if (NAV.e)
      {
        c.start();
        e = new Handler(c.getLooper());
        localObject1 = Looper.getMainLooper();
        try
        {
          if (!i)
          {
            localObject3 = localObject1.getClass();
            localObject3 = ((Class)localObject3).getDeclaredField("mLogging");
            ((Field)localObject3).setAccessible(true);
            ((Looper)localObject1).setMessageLogging(new c((Printer)((Field)localObject3).get(localObject1)));
            AppMethodBeat.o(186302);
          }
        }
        catch (Exception localException)
        {
          i = true;
        }
      }
      else
      {
        AppMethodBeat.o(186302);
      }
    }
  }
  
  static final class a
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(186291);
      String str1 = b.gut();
      boolean bool = com.tencent.mm.rabbiteye.a.a.gus();
      String str2 = com.tencent.mm.rabbiteye.a.a.RF();
      LagDetective.guo().a("IdleHandler", 0L, str1, bool, str2);
      AppMethodBeat.o(186291);
    }
  }
  
  static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(186292);
      boolean bool = com.tencent.mm.rabbiteye.a.a.gus();
      String str = com.tencent.mm.rabbiteye.a.a.RF();
      LagDetective.guo().a("Looper", 0L, "", bool, str);
      AppMethodBeat.o(186292);
    }
  }
  
  static final class c
    implements Printer
  {
    public Printer NAW;
    boolean b;
    boolean c;
    
    c(Printer paramPrinter)
    {
      AppMethodBeat.i(186293);
      this.b = false;
      this.c = false;
      this.NAW = paramPrinter;
      AppMethodBeat.o(186293);
    }
    
    public final void println(String paramString)
    {
      boolean bool2 = true;
      AppMethodBeat.i(186294);
      Printer localPrinter = this.NAW;
      if (localPrinter != null) {
        localPrinter.println(paramString);
      }
      if (!this.b)
      {
        if ((paramString.charAt(0) != '>') && (paramString.charAt(0) != '<'))
        {
          bool1 = false;
          this.c = bool1;
          this.b = true;
        }
      }
      else if (this.c) {
        if (paramString.charAt(0) != '>') {
          break label99;
        }
      }
      label99:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        LagDetective.a(bool1);
        AppMethodBeat.o(186294);
        return;
        bool1 = true;
        break;
      }
    }
  }
  
  static final class d<T>
    extends ArrayList
  {
    Map<MessageQueue.IdleHandler, LagDetective.e> a;
    
    d()
    {
      AppMethodBeat.i(186295);
      this.a = new HashMap();
      AppMethodBeat.o(186295);
    }
    
    public final boolean add(Object paramObject)
    {
      AppMethodBeat.i(186296);
      if ((paramObject instanceof MessageQueue.IdleHandler))
      {
        MessageQueue.IdleHandler localIdleHandler = (MessageQueue.IdleHandler)paramObject;
        paramObject = new LagDetective.e(localIdleHandler);
        this.a.put(localIdleHandler, paramObject);
        bool = super.add(paramObject);
        AppMethodBeat.o(186296);
        return bool;
      }
      boolean bool = super.add(paramObject);
      AppMethodBeat.o(186296);
      return bool;
    }
    
    public final boolean remove(Object paramObject)
    {
      AppMethodBeat.i(186297);
      if ((paramObject instanceof LagDetective.e))
      {
        localObject = LagDetective.e.a((LagDetective.e)paramObject);
        this.a.remove(localObject);
        bool = super.remove(paramObject);
        AppMethodBeat.o(186297);
        return bool;
      }
      Object localObject = (LagDetective.e)this.a.remove(paramObject);
      if (localObject != null)
      {
        bool = super.remove(localObject);
        AppMethodBeat.o(186297);
        return bool;
      }
      boolean bool = super.remove(paramObject);
      AppMethodBeat.o(186297);
      return bool;
    }
  }
  
  static final class e
    implements MessageQueue.IdleHandler
  {
    private MessageQueue.IdleHandler NAX;
    
    e(MessageQueue.IdleHandler paramIdleHandler)
    {
      this.NAX = paramIdleHandler;
    }
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(186298);
      LagDetective.gur().postDelayed(LagDetective.gup(), LagDetective.guq().j);
      boolean bool = this.NAX.queueIdle();
      LagDetective.gur().removeCallbacks(LagDetective.gup());
      AppMethodBeat.o(186298);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.rabbiteye.detective.LagDetective
 * JD-Core Version:    0.7.0.1
 */