package com.tencent.mm.vending.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.base.Vending.h;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.vending.h.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
  implements b
{
  public com.tencent.mm.vending.e.c<Vending> HOQ = new com.tencent.mm.vending.e.c();
  Map<Class, a> HOR = new ConcurrentHashMap();
  byte[] HOS = new byte[0];
  com.tencent.mm.vending.base.a<Object> HOT = new com.tencent.mm.vending.base.a()
  {
    public final Object bg(Class<?> paramAnonymousClass)
    {
      AppMethodBeat.i(74889);
      a.a locala = (a.a)a.this.HOR.get(paramAnonymousClass);
      Object localObject;
      if (locala != null)
      {
        locala.HPa = true;
        localObject = locala.aHl();
        locala.HPa = false;
        if (locala.HOZ) {
          locala.HPb = defer(paramAnonymousClass);
        }
      }
      else
      {
        AppMethodBeat.o(74889);
        return null;
      }
      AppMethodBeat.o(74889);
      return localObject;
    }
  };
  private AtomicBoolean HOU = new AtomicBoolean(false);
  volatile boolean HOV = false;
  Map<Class, com.tencent.mm.vending.b.c<b>> HOW = new HashMap();
  public com.tencent.mm.vending.d.a HOX;
  Context mContext;
  private com.tencent.mm.vending.e.c oBq = new com.tencent.mm.vending.e.c();
  
  public a()
  {
    this.HOQ.keep(this.HOT);
    this.HOT.addVendingDataResolvedCallback(new com.tencent.mm.vending.base.a.a() {});
  }
  
  private void fha()
  {
    if ((Looper.myLooper() == this.HOT.getLooper()) && (!this.HOU.get())) {
      com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", new Object[] { this });
    }
  }
  
  protected final <_Struct> void a(Class<_Struct> paramClass, a<_Struct> parama)
  {
    fha();
    this.HOR.put(paramClass, parama);
  }
  
  public final <_Struct> void a(Class<_Struct> paramClass, b<_Struct> paramb)
  {
    com.tencent.mm.vending.b.c localc = (com.tencent.mm.vending.b.c)this.HOW.get(paramClass);
    Object localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.vending.b.c(d.HQL) {};
      this.HOW.put(paramClass, localObject);
    }
    ((com.tencent.mm.vending.b.c)localObject).bv(paramb);
    paramClass = this.HOT.peek(paramClass);
    if (paramClass != null) {
      paramb.cf(paramClass);
    }
  }
  
  public final void bf(Class<?> paramClass)
  {
    fha();
    this.HOT.request(paramClass);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.oBq.keep(parama);
  }
  
  protected void onCreate()
  {
    this.HOU.set(true);
  }
  
  protected void onDestroy()
  {
    this.oBq.dead();
    this.HOQ.dead();
  }
  
  public final <_Struct> _Struct w(Class<_Struct> paramClass)
  {
    fha();
    if ((Looper.myLooper() == Looper.getMainLooper()) && (!this.HOV)) {}
    synchronized (this.HOS)
    {
      boolean bool = this.HOV;
      if (!bool) {}
      try
      {
        this.HOS.wait();
        return this.HOT.get(paramClass);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          com.tencent.mm.vending.f.a.printErrStackTrace("Vending.Interactor", localInterruptedException, "", new Object[0]);
        }
      }
    }
  }
  
  public abstract class a<_Struct>
  {
    boolean HOZ = false;
    boolean HPa = false;
    Vending.h HPb;
    
    public a() {}
    
    protected abstract _Struct aHl();
  }
  
  public static abstract interface b<_Struct>
  {
    public abstract void cf(_Struct param_Struct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.app.a
 * JD-Core Version:    0.7.0.1
 */