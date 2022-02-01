package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public enum i
{
  private boolean Pre;
  private boolean Prf;
  private Object Prg;
  public HashSet<WeakReference<Activity>> Prh;
  
  static
  {
    AppMethodBeat.i(129945);
    Prd = new i("INSTANCE");
    Pri = new i[] { Prd };
    AppMethodBeat.o(129945);
  }
  
  private i()
  {
    AppMethodBeat.i(129942);
    this.Pre = false;
    this.Prf = false;
    this.Prg = new Object();
    this.Prh = new HashSet();
    AppMethodBeat.o(129942);
  }
  
  public final void CC(boolean paramBoolean)
  {
    synchronized (this.Prg)
    {
      this.Pre = paramBoolean;
      return;
    }
  }
  
  public final void CD(boolean paramBoolean)
  {
    synchronized (this.Prg)
    {
      this.Prf = paramBoolean;
      return;
    }
  }
  
  public final boolean gOf()
  {
    synchronized (this.Prg)
    {
      boolean bool = this.Pre;
      return bool;
    }
  }
  
  public final boolean gOg()
  {
    synchronized (this.Prg)
    {
      boolean bool = this.Prf;
      return bool;
    }
  }
  
  public final void gOh()
  {
    synchronized (this.Prg)
    {
      this.Prf = true;
      return;
    }
  }
  
  public final void gOi()
  {
    AppMethodBeat.i(129944);
    Iterator localIterator = this.Prh.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
      if ((localActivity != null) && (!localActivity.isFinishing()))
      {
        Log.v("MicroMsg.WalletLockStatusManager", "alvinluo finish %s", new Object[] { localActivity.getClass().getName() });
        localActivity.finish();
      }
      localIterator.remove();
    }
    AppMethodBeat.o(129944);
  }
  
  public final void i(WeakReference<Activity> paramWeakReference)
  {
    AppMethodBeat.i(129943);
    if (this.Prh != null)
    {
      if (paramWeakReference.get() != null) {
        Log.v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", new Object[] { ((Activity)paramWeakReference.get()).getClass().getName() });
      }
      this.Prh.add(paramWeakReference);
    }
    AppMethodBeat.o(129943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.i
 * JD-Core Version:    0.7.0.1
 */