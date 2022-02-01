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
  private b JpC;
  private a JpD;
  private com.tencent.mm.vending.c.b<? extends a> JpE;
  private int JpF;
  private com.tencent.mm.vending.e.c peQ;
  
  public c()
  {
    AppMethodBeat.i(74876);
    this.JpC = b.fxd();
    this.JpF = 0;
    this.peQ = new com.tencent.mm.vending.e.c();
    AppMethodBeat.o(74876);
  }
  
  private void A(Intent paramIntent, Context paramContext)
  {
    try
    {
      AppMethodBeat.i(177469);
      Assert.assertNotNull("You must pair this presenter with a interactor!", this.JpD);
      this.JpD.mContext = paramContext;
      this.JpD.Jps = new com.tencent.mm.vending.d.a(paramIntent);
      AppMethodBeat.o(177469);
      return;
    }
    finally
    {
      paramIntent = finally;
      throw paramIntent;
    }
  }
  
  private <T extends com.tencent.mm.vending.c.b<? extends a>> T bk(Class<? extends com.tencent.mm.vending.c.b<? extends a>> paramClass)
  {
    try
    {
      AppMethodBeat.i(74877);
      if (this.JpE == null) {
        break label78;
      }
      if (!paramClass.isInstance(this.JpE))
      {
        paramClass = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + paramClass.toString());
        AppMethodBeat.o(74877);
        throw paramClass;
      }
    }
    finally {}
    paramClass = this.JpE;
    AppMethodBeat.o(74877);
    for (;;)
    {
      return paramClass;
      try
      {
        label78:
        this.JpE = ((com.tencent.mm.vending.c.b)paramClass.newInstance());
        if (this.JpD == null) {
          this.JpD = ((a)this.JpE.aNN());
        }
        fxe();
        com.tencent.mm.vending.c.b localb = this.JpE;
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
  
  private <T extends a> T bl(Class<? extends a> paramClass)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(74878);
        if (this.JpE != null)
        {
          paramClass = (a)this.JpE.aNN();
          AppMethodBeat.o(74878);
          return paramClass;
        }
        if (this.JpD == null) {
          break label106;
        }
        if (!paramClass.isInstance(this.JpD))
        {
          paramClass = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + paramClass.toString());
          AppMethodBeat.o(74878);
          throw paramClass;
        }
      }
      finally {}
      paramClass = this.JpD;
      AppMethodBeat.o(74878);
      continue;
      try
      {
        label106:
        this.JpD = ((a)paramClass.newInstance());
        fxe();
        a locala = this.JpD;
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
  
  private void fxe()
  {
    AppMethodBeat.i(177468);
    if (this.JpC != null) {
      this.JpC.a(this, this.JpD);
    }
    AppMethodBeat.o(177468);
  }
  
  public final void B(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(74885);
    A(paramIntent, paramContext);
    adp(1);
    AppMethodBeat.o(74885);
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
    paramActivity = bk(paramClass);
    AppMethodBeat.o(74882);
    return paramActivity;
  }
  
  public final void adp(int paramInt)
  {
    AppMethodBeat.i(177470);
    this.JpF = paramInt;
    b localb = this.JpC;
    a locala = (a)localb.Jpy.get(this);
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
      localb.JpA.sendMessage(localb.JpA.obtainMessage(paramInt, locala));
      localb.Jpz.put(hashCode(), paramInt);
      AppMethodBeat.o(177470);
      return;
      com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "onDestroy interactor %s activity %s %s %s", new Object[] { locala, this, Integer.valueOf(hashCode()), Looper.myLooper() });
      localb.Jpy.remove(this);
    }
  }
  
  public final a ahP()
  {
    try
    {
      AppMethodBeat.i(74881);
      if ((this.JpD == null) && (this.JpC != null)) {
        this.JpD = ((a)this.JpC.Jpy.get(this));
      }
      Assert.assertNotNull("You must pair this presenter with a interactor!", this.JpD);
      a locala = this.JpD;
      AppMethodBeat.o(74881);
      return locala;
    }
    finally {}
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
    paramActivity = bl(paramClass);
    AppMethodBeat.o(74883);
    return paramActivity;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(74886);
    Assert.assertTrue("target must be a ILifeCycle", parama instanceof com.tencent.mm.vending.e.a);
    this.peQ.keep(parama);
    AppMethodBeat.o(74886);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(74887);
    this.peQ.dead();
    adp(4);
    AppMethodBeat.o(74887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.app.c
 * JD-Core Version:    0.7.0.1
 */