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
  public com.tencent.mm.vending.e.c<Vending> Yzd = new com.tencent.mm.vending.e.c();
  private Map<Class, a> Yze = new ConcurrentHashMap();
  byte[] Yzf = new byte[0];
  private com.tencent.mm.vending.base.a<Object> Yzg = new com.tencent.mm.vending.base.a()
  {
    public final Object bH(Class<?> paramAnonymousClass)
    {
      AppMethodBeat.i(74889);
      a.a locala = (a.a)a.a(a.this).get(paramAnonymousClass);
      Object localObject;
      if (locala != null)
      {
        locala.Yzn = true;
        localObject = locala.bwx();
        locala.Yzn = false;
        if (locala.Yzm) {
          locala.Yzo = defer(paramAnonymousClass);
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
  private AtomicBoolean Yzh = new AtomicBoolean(false);
  volatile boolean Yzi = false;
  private Map<Class, com.tencent.mm.vending.b.c<b>> Yzj = new HashMap();
  public com.tencent.mm.vending.d.a Yzk;
  Context mContext;
  private com.tencent.mm.vending.e.c uIE = new com.tencent.mm.vending.e.c();
  
  public a()
  {
    this.Yzd.keep(this.Yzg);
    this.Yzg.addVendingDataResolvedCallback(new com.tencent.mm.vending.base.b() {});
  }
  
  private void iev()
  {
    if ((Looper.myLooper() == this.Yzg.getLooper()) && (!this.Yzh.get())) {
      com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", new Object[] { this });
    }
  }
  
  protected final <_Struct> void a(Class<_Struct> paramClass, a<_Struct> parama)
  {
    iev();
    this.Yze.put(paramClass, parama);
  }
  
  public final <_Struct> void a(Class<_Struct> paramClass, b<_Struct> paramb)
  {
    com.tencent.mm.vending.b.c localc = (com.tencent.mm.vending.b.c)this.Yzj.get(paramClass);
    Object localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.vending.b.c(d.UI) {};
      this.Yzj.put(paramClass, localObject);
    }
    ((com.tencent.mm.vending.b.c)localObject).add(paramb);
    paramClass = this.Yzg.peek(paramClass);
    if (paramClass != null) {
      paramb.cn(paramClass);
    }
  }
  
  public final void bG(Class<?> paramClass)
  {
    iev();
    this.Yzg.request(paramClass);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.uIE.keep(parama);
  }
  
  public final <_Struct> _Struct m(Class<_Struct> paramClass)
  {
    iev();
    if ((Looper.myLooper() == Looper.getMainLooper()) && (!this.Yzi)) {}
    synchronized (this.Yzf)
    {
      boolean bool = this.Yzi;
      if (!bool) {}
      try
      {
        this.Yzf.wait();
        return this.Yzg.get(paramClass);
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
  
  protected void onCreate()
  {
    this.Yzh.set(true);
  }
  
  protected void onDestroy()
  {
    this.uIE.dead();
    this.Yzd.dead();
  }
  
  public abstract class a<_Struct>
  {
    boolean Yzm = false;
    boolean Yzn = false;
    Vending.h Yzo;
    
    public a() {}
    
    protected abstract _Struct bwx();
  }
  
  public static abstract interface b<_Struct>
  {
    public abstract void cn(_Struct param_Struct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.vending.app.a
 * JD-Core Version:    0.7.0.1
 */