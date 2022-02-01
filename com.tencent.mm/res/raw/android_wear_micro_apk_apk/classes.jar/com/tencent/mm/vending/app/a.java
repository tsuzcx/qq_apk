package com.tencent.mm.vending.app;

import android.content.Context;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
{
  private com.tencent.mm.vending.e.b abY = new com.tencent.mm.vending.e.b();
  private com.tencent.mm.vending.e.b<com.tencent.mm.vending.a.c> abZ = new com.tencent.mm.vending.e.b();
  private Map<Class, b> aca = new ConcurrentHashMap();
  private byte[] acb = new byte[0];
  private com.tencent.mm.vending.a.a<Object> acc = new com.tencent.mm.vending.a.a()
  {
    protected final Object h(Class<?> paramAnonymousClass)
    {
      b localb = (b)a.a(a.this).get(paramAnonymousClass);
      Object localObject;
      if (localb != null)
      {
        b.a(localb, true);
        localObject = localb.mb();
        b.a(localb, false);
        if (b.a(localb)) {
          b.a(localb, S(paramAnonymousClass));
        }
      }
      else
      {
        return null;
      }
      return localObject;
    }
  };
  private AtomicBoolean acd = new AtomicBoolean(false);
  private volatile boolean ace = false;
  private Map<Class, com.tencent.mm.vending.b.c<Object>> acf = new HashMap();
  private com.tencent.mm.vending.d.a acg;
  private Context ach;
  
  public a()
  {
    this.abZ.a(this.acc);
    this.acc.a(new com.tencent.mm.vending.a.b() {});
  }
  
  public final void c(Intent paramIntent)
  {
    this.acg = com.tencent.mm.vending.d.a.d(paramIntent);
  }
  
  final void ma()
  {
    synchronized (this.acb)
    {
      this.ace = true;
      this.acb.notify();
      return;
    }
  }
  
  protected final void onCreate()
  {
    this.acd.set(true);
  }
  
  protected final void onDestroy()
  {
    this.abY.md();
    this.abZ.md();
  }
  
  public final void setContext(Context paramContext)
  {
    this.ach = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.app.a
 * JD-Core Version:    0.7.0.1
 */