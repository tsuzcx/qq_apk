package com.tencent.mm.vending.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.base.Vending.h;
import com.tencent.mm.vending.h.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
  implements com.tencent.mm.vending.e.b
{
  public com.tencent.mm.vending.e.c<Vending> agtB = new com.tencent.mm.vending.e.c();
  private Map<Class, a> agtC = new ConcurrentHashMap();
  byte[] agtD = new byte[0];
  private com.tencent.mm.vending.base.a<Object> agtE = new com.tencent.mm.vending.base.a()
  {
    public final Object cu(Class<?> paramAnonymousClass)
    {
      AppMethodBeat.i(74889);
      a.a locala = (a.a)a.a(a.this).get(paramAnonymousClass);
      Object localObject;
      if (locala != null)
      {
        locala.agtL = true;
        localObject = locala.bVp();
        locala.agtL = false;
        if (locala.agtK) {
          locala.agtM = defer(paramAnonymousClass);
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
  private AtomicBoolean agtF = new AtomicBoolean(false);
  volatile boolean agtG = false;
  private Map<Class, com.tencent.mm.vending.b.c<b>> agtH = new HashMap();
  public com.tencent.mm.vending.d.a agtI;
  Context mContext;
  private com.tencent.mm.vending.e.c xRu = new com.tencent.mm.vending.e.c();
  
  public a()
  {
    this.agtB.keep(this.agtE);
    this.agtE.addVendingDataResolvedCallback(new com.tencent.mm.vending.base.b() {});
  }
  
  private void jJC()
  {
    if ((Looper.myLooper() == this.agtE.getLooper()) && (!this.agtF.get())) {
      com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", new Object[] { this });
    }
  }
  
  protected final <_Struct> void a(Class<_Struct> paramClass, a<_Struct> parama)
  {
    jJC();
    this.agtC.put(paramClass, parama);
  }
  
  public final <_Struct> void a(Class<_Struct> paramClass, b<_Struct> paramb)
  {
    com.tencent.mm.vending.b.c localc = (com.tencent.mm.vending.b.c)this.agtH.get(paramClass);
    Object localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.vending.b.c(d.UI) {};
      this.agtH.put(paramClass, localObject);
    }
    ((com.tencent.mm.vending.b.c)localObject).add(paramb);
    paramClass = this.agtE.peek(paramClass);
    if (paramClass != null) {
      paramb.dF(paramClass);
    }
  }
  
  public final void ct(Class<?> paramClass)
  {
    jJC();
    this.agtE.request(paramClass);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.xRu.keep(parama);
  }
  
  protected void onCreate()
  {
    this.agtF.set(true);
  }
  
  protected void onDestroy()
  {
    this.xRu.dead();
    this.agtB.dead();
  }
  
  public final <_Struct> _Struct v(Class<_Struct> paramClass)
  {
    jJC();
    if ((Looper.myLooper() == Looper.getMainLooper()) && (!this.agtG)) {}
    synchronized (this.agtD)
    {
      boolean bool = this.agtG;
      if (!bool) {}
      try
      {
        this.agtD.wait();
        return this.agtE.get(paramClass);
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
    boolean agtK = false;
    boolean agtL = false;
    Vending.h agtM;
    
    public a() {}
    
    protected abstract _Struct bVp();
  }
  
  public static abstract interface b<_Struct>
  {
    public abstract void dF(_Struct param_Struct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.app.a
 * JD-Core Version:    0.7.0.1
 */