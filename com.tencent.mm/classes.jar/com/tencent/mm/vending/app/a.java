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
  public com.tencent.mm.vending.e.c<Vending> Jpl = new com.tencent.mm.vending.e.c();
  Map<Class, a> Jpm = new ConcurrentHashMap();
  byte[] Jpn = new byte[0];
  com.tencent.mm.vending.base.a<Object> Jpo = new com.tencent.mm.vending.base.a()
  {
    public final Object bj(Class<?> paramAnonymousClass)
    {
      AppMethodBeat.i(74889);
      a.a locala = (a.a)a.this.Jpm.get(paramAnonymousClass);
      Object localObject;
      if (locala != null)
      {
        locala.Jpv = true;
        localObject = locala.aNZ();
        locala.Jpv = false;
        if (locala.Jpu) {
          locala.Jpw = defer(paramAnonymousClass);
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
  private AtomicBoolean Jpp = new AtomicBoolean(false);
  volatile boolean Jpq = false;
  Map<Class, com.tencent.mm.vending.b.c<b>> Jpr = new HashMap();
  public com.tencent.mm.vending.d.a Jps;
  Context mContext;
  private com.tencent.mm.vending.e.c peQ = new com.tencent.mm.vending.e.c();
  
  public a()
  {
    this.Jpl.keep(this.Jpo);
    this.Jpo.addVendingDataResolvedCallback(new com.tencent.mm.vending.base.a.a() {});
  }
  
  private void fxc()
  {
    if ((Looper.myLooper() == this.Jpo.getLooper()) && (!this.Jpp.get())) {
      com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", new Object[] { this });
    }
  }
  
  protected final <_Struct> void a(Class<_Struct> paramClass, a<_Struct> parama)
  {
    fxc();
    this.Jpm.put(paramClass, parama);
  }
  
  public final <_Struct> void a(Class<_Struct> paramClass, b<_Struct> paramb)
  {
    com.tencent.mm.vending.b.c localc = (com.tencent.mm.vending.b.c)this.Jpr.get(paramClass);
    Object localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.vending.b.c(d.Jrg) {};
      this.Jpr.put(paramClass, localObject);
    }
    ((com.tencent.mm.vending.b.c)localObject).bs(paramb);
    paramClass = this.Jpo.peek(paramClass);
    if (paramClass != null) {
      paramb.cd(paramClass);
    }
  }
  
  public final void bi(Class<?> paramClass)
  {
    fxc();
    this.Jpo.request(paramClass);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.peQ.keep(parama);
  }
  
  protected void onCreate()
  {
    this.Jpp.set(true);
  }
  
  protected void onDestroy()
  {
    this.peQ.dead();
    this.Jpl.dead();
  }
  
  public final <_Struct> _Struct w(Class<_Struct> paramClass)
  {
    fxc();
    if ((Looper.myLooper() == Looper.getMainLooper()) && (!this.Jpq)) {}
    synchronized (this.Jpn)
    {
      boolean bool = this.Jpq;
      if (!bool) {}
      try
      {
        this.Jpn.wait();
        return this.Jpo.get(paramClass);
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
    boolean Jpu = false;
    boolean Jpv = false;
    Vending.h Jpw;
    
    public a() {}
    
    protected abstract _Struct aNZ();
  }
  
  public static abstract interface b<_Struct>
  {
    public abstract void cd(_Struct param_Struct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.app.a
 * JD-Core Version:    0.7.0.1
 */