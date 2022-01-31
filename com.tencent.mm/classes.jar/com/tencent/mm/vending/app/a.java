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
import junit.framework.Assert;

public abstract class a
  implements b
{
  Map<Class, a.a> c = new ConcurrentHashMap();
  byte[] d = new byte[0];
  private AtomicBoolean f = new AtomicBoolean(false);
  boolean g = false;
  Context j;
  private com.tencent.mm.vending.e.c wsJ = new com.tencent.mm.vending.e.c();
  public com.tencent.mm.vending.e.c<Vending> wsK = new com.tencent.mm.vending.e.c();
  com.tencent.mm.vending.base.a<Object> wsO = new a.1(this);
  Map<Class, com.tencent.mm.vending.b.c<a.b>> wsP = new HashMap();
  public com.tencent.mm.vending.d.a wsQ;
  
  public a()
  {
    this.wsK.keep(this.wsO);
    this.wsO.addVendingDataResolvedCallback(new a.2(this));
  }
  
  private void c()
  {
    if ((Looper.myLooper() == this.wsO.getLooper()) && (!this.f.get())) {
      com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", new Object[] { this });
    }
  }
  
  public final <_Struct> void a(Class<_Struct> paramClass, a.a<_Struct> parama)
  {
    c();
    this.c.put(paramClass, parama);
  }
  
  public final <_Struct> void a(Class<_Struct> paramClass, a.b<_Struct> paramb)
  {
    com.tencent.mm.vending.b.c localc = (com.tencent.mm.vending.b.c)this.wsP.get(paramClass);
    Object localObject = localc;
    if (localc == null)
    {
      localObject = new a.3(this, d.wtY);
      this.wsP.put(paramClass, localObject);
    }
    ((com.tencent.mm.vending.b.c)localObject).aj(paramb);
    paramClass = this.wsO.peek(paramClass);
    if (paramClass != null) {
      paramb.aF(paramClass);
    }
  }
  
  public final <_Struct> _Struct ad(Class<_Struct> paramClass)
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
        return this.wsO.get(paramClass);
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
  
  public final void ae(Class<?> paramClass)
  {
    c();
    this.wsO.request(paramClass);
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    Assert.assertTrue("target must be a ILifeCycle", parama instanceof com.tencent.mm.vending.e.a);
    this.wsJ.keep(parama);
  }
  
  public void onCreate()
  {
    this.f.set(true);
  }
  
  public void onDestroy()
  {
    this.wsJ.dead();
    this.wsK.dead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.vending.app.a
 * JD-Core Version:    0.7.0.1
 */