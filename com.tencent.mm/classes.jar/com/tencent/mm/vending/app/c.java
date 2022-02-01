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
  private b QZe;
  private a QZf;
  private com.tencent.mm.vending.c.b<? extends a> QZg;
  private int QZh;
  private com.tencent.mm.vending.e.c rfv;
  
  public c()
  {
    AppMethodBeat.i(74876);
    this.QZe = b.hdp();
    this.QZh = 0;
    this.rfv = new com.tencent.mm.vending.e.c();
    AppMethodBeat.o(74876);
  }
  
  private <T extends com.tencent.mm.vending.c.b<? extends a>> T bm(Class<? extends com.tencent.mm.vending.c.b<? extends a>> paramClass)
  {
    try
    {
      AppMethodBeat.i(74877);
      if (this.QZg == null) {
        break label78;
      }
      if (!paramClass.isInstance(this.QZg))
      {
        paramClass = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + paramClass.toString());
        AppMethodBeat.o(74877);
        throw paramClass;
      }
    }
    finally {}
    paramClass = this.QZg;
    AppMethodBeat.o(74877);
    for (;;)
    {
      return paramClass;
      try
      {
        label78:
        this.QZg = ((com.tencent.mm.vending.c.b)paramClass.newInstance());
        if (this.QZf == null) {
          this.QZf = ((a)this.QZg.bmc());
        }
        hdq();
        com.tencent.mm.vending.c.b localb = this.QZg;
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
  
  private <T extends a> T bn(Class<? extends a> paramClass)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(74878);
        if (this.QZg != null)
        {
          paramClass = (a)this.QZg.bmc();
          AppMethodBeat.o(74878);
          return paramClass;
        }
        if (this.QZf == null) {
          break label106;
        }
        if (!paramClass.isInstance(this.QZf))
        {
          paramClass = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + paramClass.toString());
          AppMethodBeat.o(74878);
          throw paramClass;
        }
      }
      finally {}
      paramClass = this.QZf;
      AppMethodBeat.o(74878);
      continue;
      try
      {
        label106:
        this.QZf = ((a)paramClass.newInstance());
        hdq();
        a locala = this.QZf;
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
  
  private void hdq()
  {
    AppMethodBeat.i(177468);
    if (this.QZe != null) {
      this.QZe.a(this, this.QZf);
    }
    AppMethodBeat.o(177468);
  }
  
  private void z(Intent paramIntent, Context paramContext)
  {
    try
    {
      AppMethodBeat.i(177469);
      Assert.assertNotNull("You must pair this presenter with a interactor!", this.QZf);
      this.QZf.mContext = paramContext;
      this.QZf.QYU = new com.tencent.mm.vending.d.a(paramIntent);
      AppMethodBeat.o(177469);
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
    AppMethodBeat.i(74885);
    z(paramIntent, paramContext);
    apB(1);
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
    paramActivity = bm(paramClass);
    AppMethodBeat.o(74882);
    return paramActivity;
  }
  
  public final a aBf()
  {
    try
    {
      AppMethodBeat.i(74881);
      if ((this.QZf == null) && (this.QZe != null)) {
        this.QZf = ((a)this.QZe.QZa.get(this));
      }
      Assert.assertNotNull("You must pair this presenter with a interactor!", this.QZf);
      a locala = this.QZf;
      AppMethodBeat.o(74881);
      return locala;
    }
    finally {}
  }
  
  public final void apB(int paramInt)
  {
    AppMethodBeat.i(177470);
    this.QZh = paramInt;
    b localb = this.QZe;
    a locala = (a)localb.QZa.get(this);
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
      localb.QZc.sendMessage(localb.QZc.obtainMessage(paramInt, locala));
      localb.QZb.put(hashCode(), paramInt);
      AppMethodBeat.o(177470);
      return;
      com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "onDestroy interactor %s activity %s %s %s", new Object[] { locala, this, Integer.valueOf(hashCode()), Looper.myLooper() });
      localb.QZa.remove(this);
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
    paramActivity = bn(paramClass);
    AppMethodBeat.o(74883);
    return paramActivity;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(74886);
    Assert.assertTrue("target must be a ILifeCycle", parama instanceof com.tencent.mm.vending.e.a);
    this.rfv.keep(parama);
    AppMethodBeat.o(74886);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(74887);
    this.rfv.dead();
    apB(4);
    AppMethodBeat.o(74887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.vending.app.c
 * JD-Core Version:    0.7.0.1
 */