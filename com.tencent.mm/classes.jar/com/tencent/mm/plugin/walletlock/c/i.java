package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public enum i
{
  private boolean uGm;
  private boolean uGn;
  private Object uGo;
  public HashSet<WeakReference<Activity>> uGp;
  
  static
  {
    AppMethodBeat.i(51743);
    uGl = new i("INSTANCE");
    uGq = new i[] { uGl };
    AppMethodBeat.o(51743);
  }
  
  private i()
  {
    AppMethodBeat.i(51740);
    this.uGm = false;
    this.uGn = false;
    this.uGo = new Object();
    this.uGp = new HashSet();
    AppMethodBeat.o(51740);
  }
  
  public final void c(WeakReference<Activity> paramWeakReference)
  {
    AppMethodBeat.i(51741);
    if (this.uGp != null)
    {
      if (paramWeakReference.get() != null) {
        ab.v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", new Object[] { ((Activity)paramWeakReference.get()).getClass().getName() });
      }
      this.uGp.add(paramWeakReference);
    }
    AppMethodBeat.o(51741);
  }
  
  public final boolean cYo()
  {
    synchronized (this.uGo)
    {
      boolean bool = this.uGm;
      return bool;
    }
  }
  
  public final boolean cYp()
  {
    synchronized (this.uGo)
    {
      boolean bool = this.uGn;
      return bool;
    }
  }
  
  public final void cYq()
  {
    synchronized (this.uGo)
    {
      this.uGn = true;
      return;
    }
  }
  
  public final void cYr()
  {
    AppMethodBeat.i(51742);
    Iterator localIterator = this.uGp.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
      if ((localActivity != null) && (!localActivity.isFinishing()))
      {
        ab.v("MicroMsg.WalletLockStatusManager", "alvinluo finish %s", new Object[] { localActivity.getClass().getName() });
        localActivity.finish();
      }
      localIterator.remove();
    }
    AppMethodBeat.o(51742);
  }
  
  public final void oe(boolean paramBoolean)
  {
    synchronized (this.uGo)
    {
      this.uGm = paramBoolean;
      return;
    }
  }
  
  public final void of(boolean paramBoolean)
  {
    synchronized (this.uGo)
    {
      this.uGn = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.i
 * JD-Core Version:    0.7.0.1
 */