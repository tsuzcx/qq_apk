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
  private static volatile LagDetective UOt;
  private static Handler UOu;
  private static Runnable UOv;
  private static Runnable UOw;
  private static a.b UOx;
  private static a.a UOy;
  private static long b;
  private static HandlerThread c;
  private static HandlerThread d;
  private static Handler e;
  private static boolean i;
  private static long l;
  private static boolean m;
  
  static
  {
    AppMethodBeat.i(231773);
    UOt = new LagDetective();
    b = 5000L;
    c = new HandlerThread("LooperLagThread");
    d = new HandlerThread("IdleHandlerLagThread");
    e = null;
    UOu = null;
    UOv = new b();
    UOw = new a();
    i = false;
    l = 0L;
    AppMethodBeat.o(231773);
  }
  
  public static LagDetective b(a.b paramb, a.a parama)
  {
    try
    {
      UOx = paramb;
      UOy = parama;
      b = parama.j;
      paramb = UOt;
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
    AppMethodBeat.i(231762);
    if (System.currentTimeMillis() - l > UOy.k * 2L)
    {
      String str1 = b.hpR();
      boolean bool = com.tencent.mm.rabbiteye.a.a.hpQ();
      String str2 = com.tencent.mm.rabbiteye.a.a.Vs();
      UOx.a("Touch", paramInt, str1, bool, str2);
    }
    l = System.currentTimeMillis();
    AppMethodBeat.o(231762);
  }
  
  public final void start()
  {
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      try
      {
        AppMethodBeat.i(231776);
        if (m)
        {
          AppMethodBeat.o(231776);
          return;
        }
        m = true;
        if (UOy.h) {
          nativeInitTouchDetective((int)UOy.k);
        }
        boolean bool = UOy.i;
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
        UOu = new Handler(d.getLooper());
      }
      catch (Throwable localThrowable)
      {
        continue;
      }
      if (UOy.g)
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
            AppMethodBeat.o(231776);
          }
        }
        catch (Exception localException)
        {
          i = true;
        }
      }
      else
      {
        AppMethodBeat.o(231776);
      }
    }
  }
  
  static final class a
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(231742);
      String str1 = b.hpR();
      boolean bool = com.tencent.mm.rabbiteye.a.a.hpQ();
      String str2 = com.tencent.mm.rabbiteye.a.a.Vs();
      LagDetective.hpM().a("IdleHandler", 0L, str1, bool, str2);
      AppMethodBeat.o(231742);
    }
  }
  
  static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(231743);
      boolean bool = com.tencent.mm.rabbiteye.a.a.hpQ();
      String str = com.tencent.mm.rabbiteye.a.a.Vs();
      LagDetective.hpM().a("Looper", 0L, "", bool, str);
      AppMethodBeat.o(231743);
    }
  }
  
  static final class c
    implements Printer
  {
    public Printer UOz;
    boolean b;
    boolean c;
    
    c(Printer paramPrinter)
    {
      AppMethodBeat.i(231745);
      this.b = false;
      this.c = false;
      this.UOz = paramPrinter;
      AppMethodBeat.o(231745);
    }
    
    public final void println(String paramString)
    {
      boolean bool2 = true;
      AppMethodBeat.i(231746);
      Printer localPrinter = this.UOz;
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
        AppMethodBeat.o(231746);
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
      AppMethodBeat.i(231747);
      this.a = new HashMap();
      AppMethodBeat.o(231747);
    }
    
    public final boolean add(Object paramObject)
    {
      AppMethodBeat.i(231748);
      if ((paramObject instanceof MessageQueue.IdleHandler))
      {
        MessageQueue.IdleHandler localIdleHandler = (MessageQueue.IdleHandler)paramObject;
        paramObject = new LagDetective.e(localIdleHandler);
        this.a.put(localIdleHandler, paramObject);
        bool = super.add(paramObject);
        AppMethodBeat.o(231748);
        return bool;
      }
      boolean bool = super.add(paramObject);
      AppMethodBeat.o(231748);
      return bool;
    }
    
    public final boolean remove(Object paramObject)
    {
      AppMethodBeat.i(231750);
      if ((paramObject instanceof LagDetective.e))
      {
        localObject = LagDetective.e.a((LagDetective.e)paramObject);
        this.a.remove(localObject);
        bool = super.remove(paramObject);
        AppMethodBeat.o(231750);
        return bool;
      }
      Object localObject = (LagDetective.e)this.a.remove(paramObject);
      if (localObject != null)
      {
        bool = super.remove(localObject);
        AppMethodBeat.o(231750);
        return bool;
      }
      boolean bool = super.remove(paramObject);
      AppMethodBeat.o(231750);
      return bool;
    }
  }
  
  static final class e
    implements MessageQueue.IdleHandler
  {
    private MessageQueue.IdleHandler UOA;
    
    e(MessageQueue.IdleHandler paramIdleHandler)
    {
      this.UOA = paramIdleHandler;
    }
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(231753);
      LagDetective.hpP().postDelayed(LagDetective.hpN(), LagDetective.hpO().l);
      boolean bool = this.UOA.queueIdle();
      LagDetective.hpP().removeCallbacks(LagDetective.hpN());
      AppMethodBeat.o(231753);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.rabbiteye.detective.LagDetective
 * JD-Core Version:    0.7.0.1
 */