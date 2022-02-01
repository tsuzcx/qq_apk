package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public enum i
{
  private boolean Dwf;
  private boolean Dwg;
  private Object Dwh;
  public HashSet<WeakReference<Activity>> Dwi;
  
  static
  {
    AppMethodBeat.i(129945);
    Dwe = new i("INSTANCE");
    Dwj = new i[] { Dwe };
    AppMethodBeat.o(129945);
  }
  
  private i()
  {
    AppMethodBeat.i(129942);
    this.Dwf = false;
    this.Dwg = false;
    this.Dwh = new Object();
    this.Dwi = new HashSet();
    AppMethodBeat.o(129942);
  }
  
  public final void e(WeakReference<Activity> paramWeakReference)
  {
    AppMethodBeat.i(129943);
    if (this.Dwi != null)
    {
      if (paramWeakReference.get() != null) {
        ad.v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", new Object[] { ((Activity)paramWeakReference.get()).getClass().getName() });
      }
      this.Dwi.add(paramWeakReference);
    }
    AppMethodBeat.o(129943);
  }
  
  public final boolean eKi()
  {
    synchronized (this.Dwh)
    {
      boolean bool = this.Dwf;
      return bool;
    }
  }
  
  public final boolean eKj()
  {
    synchronized (this.Dwh)
    {
      boolean bool = this.Dwg;
      return bool;
    }
  }
  
  public final void eKk()
  {
    synchronized (this.Dwh)
    {
      this.Dwg = true;
      return;
    }
  }
  
  public final void eKl()
  {
    AppMethodBeat.i(129944);
    Iterator localIterator = this.Dwi.iterator();
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
  
  public final void uK(boolean paramBoolean)
  {
    synchronized (this.Dwh)
    {
      this.Dwf = paramBoolean;
      return;
    }
  }
  
  public final void uL(boolean paramBoolean)
  {
    synchronized (this.Dwh)
    {
      this.Dwg = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.i
 * JD-Core Version:    0.7.0.1
 */