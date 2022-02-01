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
  public com.tencent.mm.vending.e.c<Vending> LgQ = new com.tencent.mm.vending.e.c();
  Map<Class, a> LgR = new ConcurrentHashMap();
  byte[] LgS = new byte[0];
  com.tencent.mm.vending.base.a<Object> LgT = new com.tencent.mm.vending.base.a()
  {
    public final Object bl(Class<?> paramAnonymousClass)
    {
      AppMethodBeat.i(74889);
      a.a locala = (a.a)a.this.LgR.get(paramAnonymousClass);
      Object localObject;
      if (locala != null)
      {
        locala.Lha = true;
        localObject = locala.aRl();
        locala.Lha = false;
        if (locala.LgZ) {
          locala.Lhb = defer(paramAnonymousClass);
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
  private AtomicBoolean LgU = new AtomicBoolean(false);
  volatile boolean LgV = false;
  Map<Class, com.tencent.mm.vending.b.c<b>> LgW = new HashMap();
  public com.tencent.mm.vending.d.a LgX;
  Context mContext;
  private com.tencent.mm.vending.e.c pIs = new com.tencent.mm.vending.e.c();
  
  public a()
  {
    this.LgQ.keep(this.LgT);
    this.LgT.addVendingDataResolvedCallback(new com.tencent.mm.vending.base.a.a() {});
  }
  
  private void fNP()
  {
    if ((Looper.myLooper() == this.LgT.getLooper()) && (!this.LgU.get())) {
      com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", new Object[] { this });
    }
  }
  
  protected final <_Struct> void a(Class<_Struct> paramClass, a<_Struct> parama)
  {
    fNP();
    this.LgR.put(paramClass, parama);
  }
  
  public final <_Struct> void a(Class<_Struct> paramClass, b<_Struct> paramb)
  {
    com.tencent.mm.vending.b.c localc = (com.tencent.mm.vending.b.c)this.LgW.get(paramClass);
    Object localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.vending.b.c(d.LiL) {};
      this.LgW.put(paramClass, localObject);
    }
    ((com.tencent.mm.vending.b.c)localObject).bu(paramb);
    paramClass = this.LgT.peek(paramClass);
    if (paramClass != null) {
      paramb.cf(paramClass);
    }
  }
  
  public final void bk(Class<?> paramClass)
  {
    fNP();
    this.LgT.request(paramClass);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.pIs.keep(parama);
  }
  
  protected void onCreate()
  {
    this.LgU.set(true);
  }
  
  protected void onDestroy()
  {
    this.pIs.dead();
    this.LgQ.dead();
  }
  
  public final <_Struct> _Struct w(Class<_Struct> paramClass)
  {
    fNP();
    if ((Looper.myLooper() == Looper.getMainLooper()) && (!this.LgV)) {}
    synchronized (this.LgS)
    {
      boolean bool = this.LgV;
      if (!bool) {}
      try
      {
        this.LgS.wait();
        return this.LgT.get(paramClass);
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
    boolean LgZ = false;
    boolean Lha = false;
    Vending.h Lhb;
    
    public a() {}
    
    protected abstract _Struct aRl();
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