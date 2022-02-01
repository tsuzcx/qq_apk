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
  public com.tencent.mm.vending.e.c<Vending> QYN = new com.tencent.mm.vending.e.c();
  Map<Class, a> QYO = new ConcurrentHashMap();
  byte[] QYP = new byte[0];
  com.tencent.mm.vending.base.a<Object> QYQ = new com.tencent.mm.vending.base.a()
  {
    public final Object bl(Class<?> paramAnonymousClass)
    {
      AppMethodBeat.i(74889);
      a.a locala = (a.a)a.this.QYO.get(paramAnonymousClass);
      Object localObject;
      if (locala != null)
      {
        locala.QYX = true;
        localObject = locala.bmp();
        locala.QYX = false;
        if (locala.QYW) {
          locala.QYY = defer(paramAnonymousClass);
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
  private AtomicBoolean QYR = new AtomicBoolean(false);
  volatile boolean QYS = false;
  Map<Class, com.tencent.mm.vending.b.c<b>> QYT = new HashMap();
  public com.tencent.mm.vending.d.a QYU;
  Context mContext;
  private com.tencent.mm.vending.e.c rfv = new com.tencent.mm.vending.e.c();
  
  public a()
  {
    this.QYN.keep(this.QYQ);
    this.QYQ.addVendingDataResolvedCallback(new com.tencent.mm.vending.base.a.a() {});
  }
  
  private void hdo()
  {
    if ((Looper.myLooper() == this.QYQ.getLooper()) && (!this.QYR.get())) {
      com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", new Object[] { this });
    }
  }
  
  protected final <_Struct> void a(Class<_Struct> paramClass, a<_Struct> parama)
  {
    hdo();
    this.QYO.put(paramClass, parama);
  }
  
  public final <_Struct> void a(Class<_Struct> paramClass, b<_Struct> paramb)
  {
    com.tencent.mm.vending.b.c localc = (com.tencent.mm.vending.b.c)this.QYT.get(paramClass);
    Object localObject = localc;
    if (localc == null)
    {
      localObject = new com.tencent.mm.vending.b.c(d.UI) {};
      this.QYT.put(paramClass, localObject);
    }
    ((com.tencent.mm.vending.b.c)localObject).add(paramb);
    paramClass = this.QYQ.peek(paramClass);
    if (paramClass != null) {
      paramb.co(paramClass);
    }
  }
  
  public final void bk(Class<?> paramClass)
  {
    hdo();
    this.QYQ.request(paramClass);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.rfv.keep(parama);
  }
  
  protected void onCreate()
  {
    this.QYR.set(true);
  }
  
  protected void onDestroy()
  {
    this.rfv.dead();
    this.QYN.dead();
  }
  
  public final <_Struct> _Struct y(Class<_Struct> paramClass)
  {
    hdo();
    if ((Looper.myLooper() == Looper.getMainLooper()) && (!this.QYS)) {}
    synchronized (this.QYP)
    {
      boolean bool = this.QYS;
      if (!bool) {}
      try
      {
        this.QYP.wait();
        return this.QYQ.get(paramClass);
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
    boolean QYW = false;
    boolean QYX = false;
    Vending.h QYY;
    
    public a() {}
    
    protected abstract _Struct bmp();
  }
  
  public static abstract interface b<_Struct>
  {
    public abstract void co(_Struct param_Struct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.app.a
 * JD-Core Version:    0.7.0.1
 */