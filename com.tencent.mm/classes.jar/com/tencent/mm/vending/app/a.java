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
  public com.tencent.mm.vending.e.c<Vending> LDs = new com.tencent.mm.vending.e.c();
  Map<Class, a> LDt = new ConcurrentHashMap();
  byte[] LDu = new byte[0];
  com.tencent.mm.vending.base.a<Object> LDv = new com.tencent.mm.vending.base.a()
  {
    public final Object bl(Class<?> paramAnonymousClass)
    {
      AppMethodBeat.i(74889);
      a.a locala = (a.a)a.this.LDt.get(paramAnonymousClass);
      Object localObject;
      if (locala != null)
      {
        locala.LDC = true;
        localObject = locala.aRK();
        locala.LDC = false;
        if (locala.LDB) {
          locala.LDD = defer(paramAnonymousClass);
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
  private AtomicBoolean LDw = new AtomicBoolean(false);
  volatile boolean LDx = false;
  Map<Class, com.tencent.mm.vending.b.c<b>> LDy = new HashMap();
  public com.tencent.mm.vending.d.a LDz;
  Context mContext;
  private com.tencent.mm.vending.e.c pOX = new com.tencent.mm.vending.e.c();
  
  public a()
  {
    this.LDs.keep(this.LDv);
    this.LDv.addVendingDataResolvedCallback(new com.tencent.mm.vending.base.a.a() {});
  }
  
  private void fSk()
  {
    if ((Looper.myLooper() == this.LDv.getLooper()) && (!this.LDw.get())) {
      com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", new Object[] { this });
    }
  }
  
  protected final <_Struct> void a(Class<_Struct> paramClass, a<_Struct> parama)
  {
    fSk();
    this.LDt.put(paramClass, parama);
  }
  
  public final <_Struct> void a(Class<_Struct> paramClass, b<_Struct> paramb)
  {
    com.tencent.mm.vending.b.c localc = (com.tencent.mm.vending.b.c)this.LDy.get(paramClass);
    Object localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.vending.b.c(d.LFn) {};
      this.LDy.put(paramClass, localObject);
    }
    ((com.tencent.mm.vending.b.c)localObject).bu(paramb);
    paramClass = this.LDv.peek(paramClass);
    if (paramClass != null) {
      paramb.cf(paramClass);
    }
  }
  
  public final void bk(Class<?> paramClass)
  {
    fSk();
    this.LDv.request(paramClass);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.pOX.keep(parama);
  }
  
  protected void onCreate()
  {
    this.LDw.set(true);
  }
  
  protected void onDestroy()
  {
    this.pOX.dead();
    this.LDs.dead();
  }
  
  public final <_Struct> _Struct w(Class<_Struct> paramClass)
  {
    fSk();
    if ((Looper.myLooper() == Looper.getMainLooper()) && (!this.LDx)) {}
    synchronized (this.LDu)
    {
      boolean bool = this.LDx;
      if (!bool) {}
      try
      {
        this.LDu.wait();
        return this.LDv.get(paramClass);
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
    boolean LDB = false;
    boolean LDC = false;
    Vending.h LDD;
    
    public a() {}
    
    protected abstract _Struct aRK();
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