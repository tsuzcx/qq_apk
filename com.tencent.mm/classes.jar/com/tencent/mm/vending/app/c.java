package com.tencent.mm.vending.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import junit.framework.Assert;

public final class c
  implements com.tencent.mm.vending.e.b
{
  private b ANO;
  private a ANQ;
  private com.tencent.mm.vending.c.b<? extends a> ANR;
  private com.tencent.mm.vending.e.c ANS;
  private int d;
  
  public c()
  {
    AppMethodBeat.i(126081);
    this.ANO = b.dQf();
    this.d = 0;
    this.ANS = new com.tencent.mm.vending.e.c();
    AppMethodBeat.o(126081);
  }
  
  private void a()
  {
    AppMethodBeat.i(126084);
    if (this.ANO != null) {
      this.ANO.a(this, this.ANQ);
    }
    AppMethodBeat.o(126084);
  }
  
  private <T extends com.tencent.mm.vending.c.b<? extends a>> T aB(Class<? extends com.tencent.mm.vending.c.b<? extends a>> paramClass)
  {
    try
    {
      AppMethodBeat.i(126082);
      if (this.ANR == null) {
        break label78;
      }
      if (!paramClass.isInstance(this.ANR))
      {
        paramClass = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + paramClass.toString());
        AppMethodBeat.o(126082);
        throw paramClass;
      }
    }
    finally {}
    paramClass = this.ANR;
    AppMethodBeat.o(126082);
    for (;;)
    {
      return paramClass;
      try
      {
        label78:
        this.ANR = ((com.tencent.mm.vending.c.b)paramClass.newInstance());
        if (this.ANQ == null) {
          this.ANQ = ((a)this.ANR.aoK());
        }
        a();
        com.tencent.mm.vending.c.b localb = this.ANR;
        AppMethodBeat.o(126082);
        paramClass = localb;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        break label131;
      }
      catch (InstantiationException localInstantiationException)
      {
        label131:
        break label131;
      }
    }
    paramClass = new InternalError("Could not create interactor api instance : " + paramClass.toString());
    AppMethodBeat.o(126082);
    throw paramClass;
  }
  
  private <T extends a> T aC(Class<? extends a> paramClass)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(126083);
        if (this.ANR != null)
        {
          paramClass = (a)this.ANR.aoK();
          AppMethodBeat.o(126083);
          return paramClass;
        }
        if (this.ANQ == null) {
          break label106;
        }
        if (!paramClass.isInstance(this.ANQ))
        {
          paramClass = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + paramClass.toString());
          AppMethodBeat.o(126083);
          throw paramClass;
        }
      }
      finally {}
      paramClass = this.ANQ;
      AppMethodBeat.o(126083);
      continue;
      try
      {
        label106:
        this.ANQ = ((a)paramClass.newInstance());
        a();
        a locala = this.ANQ;
        AppMethodBeat.o(126083);
        paramClass = locala;
      }
      catch (InstantiationException localInstantiationException)
      {
        break label136;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label136:
        break label136;
      }
    }
    paramClass = new InternalError("Could not create interactor instance : " + paramClass.toString());
    AppMethodBeat.o(126083);
    throw paramClass;
  }
  
  private void z(Intent paramIntent, Context paramContext)
  {
    try
    {
      AppMethodBeat.i(126085);
      Assert.assertNotNull("You must pair this presenter with a interactor!", this.ANQ);
      this.ANQ.j = paramContext;
      this.ANQ.ANL = new com.tencent.mm.vending.d.a(paramIntent);
      AppMethodBeat.o(126085);
      return;
    }
    finally
    {
      paramIntent = finally;
      throw paramIntent;
    }
  }
  
  public final void A(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(126090);
    z(paramIntent, paramContext);
    a(1);
    AppMethodBeat.o(126090);
  }
  
  public final a SF()
  {
    try
    {
      AppMethodBeat.i(126086);
      if ((this.ANQ == null) && (this.ANO != null)) {
        this.ANQ = ((a)this.ANO.b.get(this));
      }
      Assert.assertNotNull("You must pair this presenter with a interactor!", this.ANQ);
      a locala = this.ANQ;
      AppMethodBeat.o(126086);
      return locala;
    }
    finally {}
  }
  
  public final <T extends com.tencent.mm.vending.c.b<? extends a>> T a(Activity paramActivity, Class<? extends com.tencent.mm.vending.c.b<? extends a>> paramClass)
  {
    AppMethodBeat.i(126087);
    if ((paramActivity.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramActivity.isDestroyed())))
    {
      com.tencent.mm.vending.f.a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", new Object[] { paramActivity });
      AppMethodBeat.o(126087);
      return null;
    }
    paramActivity = aB(paramClass);
    AppMethodBeat.o(126087);
    return paramActivity;
  }
  
  public final void a(int paramInt)
  {
    AppMethodBeat.i(126089);
    this.d = paramInt;
    b localb = this.ANO;
    a locala = (a)localb.b.get(this);
    if (locala != null) {
      switch (paramInt)
      {
      default: 
        com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "Unknow phase %s, interactor %s activity %s %s %s", new Object[] { Integer.valueOf(paramInt), locala, this, Integer.valueOf(hashCode()), Looper.myLooper() });
        AppMethodBeat.o(126089);
        return;
      case 1: 
        com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "onCreate interactor %s presenter %s %s %s", new Object[] { locala, this, Integer.valueOf(hashCode()), Looper.myLooper() });
      }
    }
    for (;;)
    {
      localb.d.sendMessage(localb.d.obtainMessage(paramInt, locala));
      localb.ANP.put(hashCode(), paramInt);
      AppMethodBeat.o(126089);
      return;
      com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "onDestroy interactor %s activity %s %s %s", new Object[] { locala, this, Integer.valueOf(hashCode()), Looper.myLooper() });
      localb.b.remove(this);
    }
  }
  
  public final <T extends a> T b(Activity paramActivity, Class<? extends a> paramClass)
  {
    AppMethodBeat.i(126088);
    if ((paramActivity.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramActivity.isDestroyed())))
    {
      com.tencent.mm.vending.f.a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", new Object[] { paramActivity });
      AppMethodBeat.o(126088);
      return null;
    }
    paramActivity = aC(paramClass);
    AppMethodBeat.o(126088);
    return paramActivity;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(126091);
    Assert.assertTrue("target must be a ILifeCycle", parama instanceof com.tencent.mm.vending.e.a);
    this.ANS.keep(parama);
    AppMethodBeat.o(126091);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(126092);
    this.ANS.dead();
    a(4);
    AppMethodBeat.o(126092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.app.c
 * JD-Core Version:    0.7.0.1
 */