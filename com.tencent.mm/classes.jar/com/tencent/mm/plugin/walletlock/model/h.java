package com.tencent.mm.plugin.walletlock.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public enum h
{
  private boolean WhR;
  private boolean WhS;
  private Object WhT;
  public HashSet<WeakReference<Activity>> WhU;
  
  static
  {
    AppMethodBeat.i(129945);
    WhQ = new h("INSTANCE");
    WhV = new h[] { WhQ };
    AppMethodBeat.o(129945);
  }
  
  private h()
  {
    AppMethodBeat.i(129942);
    this.WhR = false;
    this.WhS = false;
    this.WhT = new Object();
    this.WhU = new HashSet();
    AppMethodBeat.o(129942);
  }
  
  public final void Ih(boolean paramBoolean)
  {
    synchronized (this.WhT)
    {
      this.WhR = paramBoolean;
      return;
    }
  }
  
  public final void Ii(boolean paramBoolean)
  {
    synchronized (this.WhT)
    {
      this.WhS = paramBoolean;
      return;
    }
  }
  
  public final boolean inu()
  {
    synchronized (this.WhT)
    {
      boolean bool = this.WhR;
      return bool;
    }
  }
  
  public final boolean inv()
  {
    synchronized (this.WhT)
    {
      boolean bool = this.WhS;
      return bool;
    }
  }
  
  public final void inw()
  {
    synchronized (this.WhT)
    {
      this.WhS = true;
      return;
    }
  }
  
  public final void inx()
  {
    AppMethodBeat.i(129944);
    Iterator localIterator = this.WhU.iterator();
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
  
  public final void n(WeakReference<Activity> paramWeakReference)
  {
    AppMethodBeat.i(129943);
    if (this.WhU != null)
    {
      if (paramWeakReference.get() != null) {
        Log.v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", new Object[] { ((Activity)paramWeakReference.get()).getClass().getName() });
      }
      this.WhU.add(paramWeakReference);
    }
    AppMethodBeat.o(129943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.model.h
 * JD-Core Version:    0.7.0.1
 */