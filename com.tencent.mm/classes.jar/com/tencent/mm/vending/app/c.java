package com.tencent.mm.vending.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import java.util.Map;
import junit.framework.Assert;

public final class c
  implements com.tencent.mm.vending.e.b
{
  private int d = 0;
  private b wsT = b.cKP();
  private a wsV;
  private com.tencent.mm.vending.c.b<? extends a> wsW;
  private com.tencent.mm.vending.e.c wsX = new com.tencent.mm.vending.e.c();
  
  private void A(Intent paramIntent, Context paramContext)
  {
    try
    {
      Assert.assertNotNull("You must pair this presenter with a interactor!", this.wsV);
      this.wsV.j = paramContext;
      this.wsV.wsQ = new com.tencent.mm.vending.d.a(paramIntent);
      return;
    }
    finally
    {
      paramIntent = finally;
      throw paramIntent;
    }
  }
  
  private void a()
  {
    if (this.wsT != null)
    {
      b localb = this.wsT;
      a locala = this.wsV;
      if (localb.b.containsKey(this)) {
        break label187;
      }
      localb.b.put(this, locala);
      com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "presenter %s hash %s interactor %s looper %s", new Object[] { this, Integer.valueOf(hashCode()), locala, Looper.myLooper() });
      int i = localb.wsU.get(hashCode(), 0);
      if ((i > 0) && (i < 4))
      {
        if (i > 0) {
          localb.d.sendMessage(localb.d.obtainMessage(1, locala));
        }
        if (i >= 2) {
          localb.d.sendMessage(localb.d.obtainMessage(2, locala));
        }
        if (i >= 3) {
          localb.d.sendMessage(localb.d.obtainMessage(3, locala));
        }
        if (i >= 4) {
          localb.d.sendMessage(localb.d.obtainMessage(4, locala));
        }
      }
    }
    return;
    label187:
    com.tencent.mm.vending.f.a.e("Vending.InteractorManager", "duplicate activity and interactor.", new Object[0]);
  }
  
  private <T extends com.tencent.mm.vending.c.b<? extends a>> T ag(Class<? extends com.tencent.mm.vending.c.b<? extends a>> paramClass)
  {
    try
    {
      if (this.wsW == null) {
        break label61;
      }
      if (!paramClass.isInstance(this.wsW)) {
        throw new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + paramClass.toString());
      }
    }
    finally {}
    paramClass = this.wsW;
    for (;;)
    {
      return paramClass;
      try
      {
        label61:
        this.wsW = ((com.tencent.mm.vending.c.b)paramClass.newInstance());
        if (this.wsV == null) {
          this.wsV = ((a)this.wsW.Vm());
        }
        a();
        com.tencent.mm.vending.c.b localb = this.wsW;
        paramClass = localb;
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new InternalError("Could not create interactor api instance : " + paramClass.toString());
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label110:
        break label110;
      }
    }
  }
  
  private <T extends a> T ah(Class<? extends a> paramClass)
  {
    for (;;)
    {
      try
      {
        if (this.wsW != null)
        {
          paramClass = (a)this.wsW.Vm();
          return paramClass;
        }
        if (this.wsV == null) {
          break label84;
        }
        if (!paramClass.isInstance(this.wsV)) {
          throw new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + paramClass.toString());
        }
      }
      finally {}
      paramClass = this.wsV;
      continue;
      try
      {
        label84:
        this.wsV = ((a)paramClass.newInstance());
        a();
        a locala = this.wsV;
        paramClass = locala;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new InternalError("Could not create interactor instance : " + paramClass.toString());
      }
      catch (InstantiationException localInstantiationException)
      {
        label110:
        break label110;
      }
    }
  }
  
  public final void B(Intent paramIntent, Context paramContext)
  {
    A(paramIntent, paramContext);
    a(1);
  }
  
  public final a EB()
  {
    try
    {
      if ((this.wsV == null) && (this.wsT != null)) {
        this.wsV = ((a)this.wsT.b.get(this));
      }
      Assert.assertNotNull("You must pair this presenter with a interactor!", this.wsV);
      a locala = this.wsV;
      return locala;
    }
    finally {}
  }
  
  public final <T extends com.tencent.mm.vending.c.b<? extends a>> T a(Activity paramActivity, Class<? extends com.tencent.mm.vending.c.b<? extends a>> paramClass)
  {
    if ((paramActivity.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramActivity.isDestroyed())))
    {
      com.tencent.mm.vending.f.a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", new Object[] { paramActivity });
      return null;
    }
    return ag(paramClass);
  }
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
    b localb = this.wsT;
    a locala = (a)localb.b.get(this);
    if (locala != null) {
      switch (paramInt)
      {
      default: 
        com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "Unknow phase %s, interactor %s activity %s %s %s", new Object[] { Integer.valueOf(paramInt), locala, this, Integer.valueOf(hashCode()), Looper.myLooper() });
        return;
      case 1: 
        com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "onCreate interactor %s presenter %s %s %s", new Object[] { locala, this, Integer.valueOf(hashCode()), Looper.myLooper() });
      }
    }
    for (;;)
    {
      localb.d.sendMessage(localb.d.obtainMessage(paramInt, locala));
      localb.wsU.put(hashCode(), paramInt);
      return;
      com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "onDestroy interactor %s activity %s %s %s", new Object[] { locala, this, Integer.valueOf(hashCode()), Looper.myLooper() });
      localb.b.remove(this);
    }
  }
  
  public final <T extends a> T b(Activity paramActivity, Class<? extends a> paramClass)
  {
    if ((paramActivity.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramActivity.isDestroyed())))
    {
      com.tencent.mm.vending.f.a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", new Object[] { paramActivity });
      return null;
    }
    return ah(paramClass);
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    Assert.assertTrue("target must be a ILifeCycle", parama instanceof com.tencent.mm.vending.e.a);
    this.wsX.keep(parama);
  }
  
  public final void onDestroy()
  {
    this.wsX.dead();
    a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.app.c
 * JD-Core Version:    0.7.0.1
 */