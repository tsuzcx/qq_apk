package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public enum i
{
  private boolean ADq;
  private boolean ADr;
  private Object ADs;
  public HashSet<WeakReference<Activity>> ADt;
  
  static
  {
    AppMethodBeat.i(129945);
    ADp = new i("INSTANCE");
    ADu = new i[] { ADp };
    AppMethodBeat.o(129945);
  }
  
  private i()
  {
    AppMethodBeat.i(129942);
    this.ADq = false;
    this.ADr = false;
    this.ADs = new Object();
    this.ADt = new HashSet();
    AppMethodBeat.o(129942);
  }
  
  public final void d(WeakReference<Activity> paramWeakReference)
  {
    AppMethodBeat.i(129943);
    if (this.ADt != null)
    {
      if (paramWeakReference.get() != null) {
        ad.v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", new Object[] { ((Activity)paramWeakReference.get()).getClass().getName() });
      }
      this.ADt.add(paramWeakReference);
    }
    AppMethodBeat.o(129943);
  }
  
  public final boolean egI()
  {
    synchronized (this.ADs)
    {
      boolean bool = this.ADq;
      return bool;
    }
  }
  
  public final boolean egJ()
  {
    synchronized (this.ADs)
    {
      boolean bool = this.ADr;
      return bool;
    }
  }
  
  public final void egK()
  {
    synchronized (this.ADs)
    {
      this.ADr = true;
      return;
    }
  }
  
  public final void egL()
  {
    AppMethodBeat.i(129944);
    Iterator localIterator = this.ADt.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
      if ((localActivity != null) && (!localActivity.isFinishing()))
      {
        ad.v("MicroMsg.WalletLockStatusManager", "alvinluo finish %s", new Object[] { localActivity.getClass().getName() });
        localActivity.finish();
      }
      localIterator.remove();
    }
    AppMethodBeat.o(129944);
  }
  
  public final void sZ(boolean paramBoolean)
  {
    synchronized (this.ADs)
    {
      this.ADq = paramBoolean;
      return;
    }
  }
  
  public final void ta(boolean paramBoolean)
  {
    synchronized (this.ADs)
    {
      this.ADr = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.i
 * JD-Core Version:    0.7.0.1
 */