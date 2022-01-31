package com.tencent.mm.vending.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.vending.h.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
  implements b
{
  private com.tencent.mm.vending.e.c ANE = new com.tencent.mm.vending.e.c();
  public com.tencent.mm.vending.e.c<Vending> ANF = new com.tencent.mm.vending.e.c();
  com.tencent.mm.vending.base.a<Object> ANJ = new a.1(this);
  Map<Class, com.tencent.mm.vending.b.c<a.b>> ANK = new HashMap();
  public com.tencent.mm.vending.d.a ANL;
  Map<Class, a.a> c = new ConcurrentHashMap();
  byte[] d = new byte[0];
  private AtomicBoolean f = new AtomicBoolean(false);
  volatile boolean g = false;
  Context j;
  
  public a()
  {
    this.ANF.keep(this.ANJ);
    this.ANJ.addVendingDataResolvedCallback(new a.2(this));
  }
  
  private void c()
  {
    if ((Looper.myLooper() == this.ANJ.getLooper()) && (!this.f.get())) {
      com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", new Object[] { this });
    }
  }
  
  protected final <_Struct> void a(Class<_Struct> paramClass, a.a<_Struct> parama)
  {
    c();
    this.c.put(paramClass, parama);
  }
  
  public final <_Struct> void a(Class<_Struct> paramClass, a.b<_Struct> paramb)
  {
    com.tencent.mm.vending.b.c localc = (com.tencent.mm.vending.b.c)this.ANK.get(paramClass);
    Object localObject = localc;
    if (localc == null)
    {
      localObject = new a.3(this, d.AOW);
      this.ANK.put(paramClass, localObject);
    }
    ((com.tencent.mm.vending.b.c)localObject).at(paramb);
    paramClass = this.ANJ.peek(paramClass);
    if (paramClass != null) {
      paramb.aY(paramClass);
    }
  }
  
  public final void az(Class<?> paramClass)
  {
    c();
    this.ANJ.request(paramClass);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.ANE.keep(parama);
  }
  
  public final <_Struct> _Struct m(Class<_Struct> paramClass)
  {
    c();
    if ((Looper.myLooper() == Looper.getMainLooper()) && (!this.g)) {}
    synchronized (this.d)
    {
      boolean bool = this.g;
      if (!bool) {}
      try
      {
        this.d.wait();
        return this.ANJ.get(paramClass);
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
    this.f.set(true);
  }
  
  protected void onDestroy()
  {
    this.ANE.dead();
    this.ANF.dead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.vending.app.a
 * JD-Core Version:    0.7.0.1
 */