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
  private b HPh;
  private a HPi;
  private com.tencent.mm.vending.c.b<? extends a> HPj;
  private int HPk;
  private com.tencent.mm.vending.e.c oBq;
  
  public c()
  {
    AppMethodBeat.i(74876);
    this.HPh = b.fhb();
    this.HPk = 0;
    this.oBq = new com.tencent.mm.vending.e.c();
    AppMethodBeat.o(74876);
  }
  
  private void A(Intent paramIntent, Context paramContext)
  {
    try
    {
      AppMethodBeat.i(177469);
      Assert.assertNotNull("You must pair this presenter with a interactor!", this.HPi);
      this.HPi.mContext = paramContext;
      this.HPi.HOX = new com.tencent.mm.vending.d.a(paramIntent);
      AppMethodBeat.o(177469);
      return;
    }
    finally
    {
      paramIntent = finally;
      throw paramIntent;
    }
  }
  
  private <T extends com.tencent.mm.vending.c.b<? extends a>> T bh(Class<? extends com.tencent.mm.vending.c.b<? extends a>> paramClass)
  {
    try
    {
      AppMethodBeat.i(74877);
      if (this.HPj == null) {
        break label78;
      }
      if (!paramClass.isInstance(this.HPj))
      {
        paramClass = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + paramClass.toString());
        AppMethodBeat.o(74877);
        throw paramClass;
      }
    }
    finally {}
    paramClass = this.HPj;
    AppMethodBeat.o(74877);
    for (;;)
    {
      return paramClass;
      try
      {
        label78:
        this.HPj = ((com.tencent.mm.vending.c.b)paramClass.newInstance());
        if (this.HPi == null) {
          this.HPi = ((a)this.HPj.aGZ());
        }
        fhc();
        com.tencent.mm.vending.c.b localb = this.HPj;
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
  
  private <T extends a> T bi(Class<? extends a> paramClass)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(74878);
        if (this.HPj != null)
        {
          paramClass = (a)this.HPj.aGZ();
          AppMethodBeat.o(74878);
          return paramClass;
        }
        if (this.HPi == null) {
          break label106;
        }
        if (!paramClass.isInstance(this.HPi))
        {
          paramClass = new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + paramClass.toString());
          AppMethodBeat.o(74878);
          throw paramClass;
        }
      }
      finally {}
      paramClass = this.HPi;
      AppMethodBeat.o(74878);
      continue;
      try
      {
        label106:
        this.HPi = ((a)paramClass.newInstance());
        fhc();
        a locala = this.HPi;
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
  
  private void fhc()
  {
    AppMethodBeat.i(177468);
    if (this.HPh != null) {
      this.HPh.a(this, this.HPi);
    }
    AppMethodBeat.o(177468);
  }
  
  public final void B(Intent paramIntent, Context paramContext)
  {
    AppMethodBeat.i(74885);
    A(paramIntent, paramContext);
    abd(1);
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
    paramActivity = bh(paramClass);
    AppMethodBeat.o(74882);
    return paramActivity;
  }
  
  public final void abd(int paramInt)
  {
    AppMethodBeat.i(177470);
    this.HPk = paramInt;
    b localb = this.HPh;
    a locala = (a)localb.HPd.get(this);
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
      localb.HPf.sendMessage(localb.HPf.obtainMessage(paramInt, locala));
      localb.HPe.put(hashCode(), paramInt);
      AppMethodBeat.o(177470);
      return;
      com.tencent.mm.vending.f.a.i("Vending.InteractorManager", "onDestroy interactor %s activity %s %s %s", new Object[] { locala, this, Integer.valueOf(hashCode()), Looper.myLooper() });
      localb.HPd.remove(this);
    }
  }
  
  public final a agy()
  {
    try
    {
      AppMethodBeat.i(74881);
      if ((this.HPi == null) && (this.HPh != null)) {
        this.HPi = ((a)this.HPh.HPd.get(this));
      }
      Assert.assertNotNull("You must pair this presenter with a interactor!", this.HPi);
      a locala = this.HPi;
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
    paramActivity = bi(paramClass);
    AppMethodBeat.o(74883);
    return paramActivity;
  }
  
  public final void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(74886);
    Assert.assertTrue("target must be a ILifeCycle", parama instanceof com.tencent.mm.vending.e.a);
    this.oBq.keep(parama);
    AppMethodBeat.o(74886);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(74887);
    this.oBq.dead();
    abd(4);
    AppMethodBeat.o(74887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.app.c
 * JD-Core Version:    0.7.0.1
 */