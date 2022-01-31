package com.tencent.mm.vending.app;

import android.content.Context;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
{
  private Map<Class, b> YA = new ConcurrentHashMap();
  private byte[] YB = new byte[0];
  private com.tencent.mm.vending.a.a<Object> YC = new com.tencent.mm.vending.a.a()
  {
    protected final Object b(Class<?> paramAnonymousClass)
    {
      b localb = (b)a.a(a.this).get(paramAnonymousClass);
      Object localObject;
      if (localb != null)
      {
        b.a(localb, true);
        localObject = localb.lu();
        b.a(localb, false);
        if (b.a(localb)) {
          b.a(localb, J(paramAnonymousClass));
        }
      }
      else
      {
        return null;
      }
      return localObject;
    }
  };
  private AtomicBoolean YD = new AtomicBoolean(false);
  private boolean YE = false;
  private Map<Class, com.tencent.mm.vending.b.c<Object>> YF = new HashMap();
  private com.tencent.mm.vending.d.a YG;
  private Context YH;
  private com.tencent.mm.vending.e.b Yy = new com.tencent.mm.vending.e.b();
  private com.tencent.mm.vending.e.b<com.tencent.mm.vending.a.c> Yz = new com.tencent.mm.vending.e.b();
  
  public a()
  {
    this.Yz.a(this.YC);
    this.YC.a(new com.tencent.mm.vending.a.b() {});
  }
  
  public final void a(Intent paramIntent)
  {
    this.YG = com.tencent.mm.vending.d.a.b(paramIntent);
  }
  
  final void lt()
  {
    synchronized (this.YB)
    {
      this.YE = true;
      this.YB.notify();
      return;
    }
  }
  
  protected final void onCreate()
  {
    this.YD.set(true);
  }
  
  protected final void onDestroy()
  {
    this.Yy.lw();
    this.Yz.lw();
  }
  
  public final void setContext(Context paramContext)
  {
    this.YH = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.app.a
 * JD-Core Version:    0.7.0.1
 */