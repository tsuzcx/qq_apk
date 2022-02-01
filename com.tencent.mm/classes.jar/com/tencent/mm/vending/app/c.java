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
  private b agtS;
  private a agtT;
  private com.tencent.mm.vending.c.b<? extends a> agtU;
  private int agtV;
  private com.tencent.mm.vending.e.c xRu;
  
  public c()
  {
    AppMethodBeat.i(74876);
    this.agtS = b.jJD();
    this.agtV = 0;
    this.xRu = new com.tencent.mm.vending.e.c();
    AppMethodBeat.o(74876);
  }
  
  private <T extends com.tencent.mm.vending.c.b<? extends a>> T cv(Class<? extends com.tencent.mm.vending.c.b<? extends a>> paramClass)
  {
    try
    {
      AppMethodBeat.i(74877);
      if (this.agtU == null) {
        break label78;
      }
      if (!paramClass.isInstance(this.agtU))
      {
        paramClass = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + paramClass.toString());
        AppMethodBeat.o(74877);
        throw paramClass;
      }
    }
    finally {}
    paramClass = this.agtU;
    AppMethodBeat.o(74877);
    for (;;)
    {
      return paramClass;
      try
      {
        label78:
        this.agtU = ((com.tencent.mm.vending.c.b)paramClass.newInstance());
        if (this.agtT == null) {
          this.agtT = ((a)this.agtU.bVd());
        }
        jJE();
        com.tencent.mm.vending.c.b localb = this.agtU;
        AppMethodBeat.o(74877);
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
    AppMethodBeat.o(74877);
    throw paramClass;
  }
  
  private <T extends a> T cw(Class<? extends a> paramClass)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(74878);
        if (this.agtU != null)
        {
          paramClass = (a)this.agtU.bVd();
          AppMethodBeat.o(74878);
          return paramClass;
        }
        if (this.agtT == null) {
          break label106;
        }
        if (!paramClass.isInstance(this.agtT))
        {
          paramClass = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + paramClass.toString());
          AppMethodBeat.o(74878);
          throw paramClass;
        }
      }
      finally {}
      paramClass = this.agtT;
      AppMethodBeat.o(74878);
      continue;
      try
      {
        label106:
        this.agtT = ((a)paramClass.newInstance());
        jJE();
        a locala = this.agtT;
        AppMethodBeat.o(74878);
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
    AppMethodBeat.o(74878);
    throw paramClass;
  }
  
  private void jJE()
  {
    AppMethodBeat.i(177468);
    if (this.agtS != null) {
      this.agtS.a(this, this.agtT);
    }
    AppMethodBeat.o(177468);
  }
  
  private void y(Intent paramIntent, Context paramContext)
  {
    try
    {
      AppMethodBeat.i(177469);
      Assert.assertNotNull("You must pair this presenter with a interactor!", this.agtT);
      this.agtT.mContext = paramContext;
      this.agtT.agtI = new com.tencent.mm.vending.d.a(paramIntent);
      AppMethodBeat.o(177469);
      return;
    }
    finally
    {
      paramIntent = finally;
      throw paramIntent;
    }
  }
  
  public final <T extends com.tencent.mm.vending.c.b<? extends a>> T a(Activity paramActivity, Class<? extends com.tencent.mm.vending.c.b<? extends a>> paramClass)
  {
    AppMethodBeat.i(74882);
    if ((paramActivity.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramActivity.isDestroyed())))
    {
      com.tencent.mm.vending.f.a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", new Object[] { paramActivity });
      AppMethodBeat.o(74882);
      return null;
    }
    paramActivity = cv(paramClass);
    AppMethodBeat.o(74882);
    return paramActivity;
  }
  
  public final void aFE(int paramInt)
  {
    AppMethodBeat.i(177470);
    this.agtV = paramInt;
    b localb = this.agtS;
    a locala = (a)localb.agtO.get(this);
    if (locala != null) {
      switch (paramInt)
      {
      default: 
        com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "Unknow phase %s, interactor %s activity %s %s %s", new Object[] { Integer.valueOf(paramInt), locala, this, Integer.valueOf(hashCode()), Looper.myLooper() });
        AppMethodBeat.o(177470);
        return;
      case 1: 
        com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "onCreate interactor %s presenter %s %s %s", new Object[] { locala, this, Integer.valueOf(hashCode()), Looper.myLooper() });
      }
    }
    for (;;)
    {
      localb.agtQ.sendMessage(localb.agtQ.obtainMessage(paramInt, locala));
      localb.agtP.put(hashCode(), paramInt);
      AppMethodBeat.o(177470);
      return;
      com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "onDestroy interactor %s activity %s %s %s", new Object[] { locala, this, Integer.valueOf(hashCode()), Looper.myLooper() });
      localb.agtO.remove(this);
    }
  }
  
  public final <T extends a> T b(Activity paramActivity, Class<? extends a> paramClass)
  {
    AppMethodBeat.i(74883);
    if ((paramActivity.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramActivity.isDestroyed())))
    {
      com.tencent.mm.vending.f.a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", new Object[] { paramActivity });
      AppMethodBeat.o(74883);
      return null;
    }
    paramActivity = cw(paramClass);
    AppMethodBeat.o(74883);
    return paramActivity;
  }
  
  public final a bbE()
  {
    try
    {
      AppMethodBeat.i(74881);
      if ((this.agtT == null) && (this.agtS != null)) {
        this.agtT = ((a)this.agtS.agtO.get(this));
      }
      Assert.assertNotNull("You must pair this presenter with a interactor!", this.agtT);
      a locala = this.agtT;
      AppMethodBeat.o(74881);
      return locala;
    }
    finally {}
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(74886);
    Assert.assertTrue("target must be a ILifeCycle", parama instanceof com.tencent.mm.vending.e.a);
    this.xRu.keep(parama);
    AppMethodBeat.o(74886);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(74887);
    this.xRu.dead();
    aFE(4);
    AppMethodBeat.o(74887);
  }
  
  public final void z(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(74885);
    y(paramIntent, paramContext);
    aFE(1);
    AppMethodBeat.o(74885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vending.app.c
 * JD-Core Version:    0.7.0.1
 */