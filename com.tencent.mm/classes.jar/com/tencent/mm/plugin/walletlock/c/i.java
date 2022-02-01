package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public enum i
{
  private boolean BVL;
  private boolean BVM;
  private Object BVN;
  public HashSet<WeakReference<Activity>> BVO;
  
  static
  {
    AppMethodBeat.i(129945);
    BVK = new i("INSTANCE");
    BVP = new i[] { BVK };
    AppMethodBeat.o(129945);
  }
  
  private i()
  {
    AppMethodBeat.i(129942);
    this.BVL = false;
    this.BVM = false;
    this.BVN = new Object();
    this.BVO = new HashSet();
    AppMethodBeat.o(129942);
  }
  
  public final void d(WeakReference<Activity> paramWeakReference)
  {
    AppMethodBeat.i(129943);
    if (this.BVO != null)
    {
      if (paramWeakReference.get() != null) {
        ac.v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", new Object[] { ((Activity)paramWeakReference.get()).getClass().getName() });
      }
      this.BVO.add(paramWeakReference);
    }
    AppMethodBeat.o(129943);
  }
  
  public final boolean ewc()
  {
    synchronized (this.BVN)
    {
      boolean bool = this.BVL;
      return bool;
    }
  }
  
  public final boolean ewd()
  {
    synchronized (this.BVN)
    {
      boolean bool = this.BVM;
      return bool;
    }
  }
  
  public final void ewe()
  {
    synchronized (this.BVN)
    {
      this.BVM = true;
      return;
    }
  }
  
  public final void ewf()
  {
    AppMethodBeat.i(129944);
    Iterator localIterator = this.BVO.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
      if ((localActivity != null) && (!localActivity.isFinishing()))
      {
        ac.v("MicroMsg.WalletLockStatusManager", "alvinluo finish %s", new Object[] { localActivity.getClass().getName() });
        localActivity.finish();
      }
      localIterator.remove();
    }
    AppMethodBeat.o(129944);
  }
  
  public final void ua(boolean paramBoolean)
  {
    synchronized (this.BVN)
    {
      this.BVL = paramBoolean;
      return;
    }
  }
  
  public final void ub(boolean paramBoolean)
  {
    synchronized (this.BVN)
    {
      this.BVM = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.i
 * JD-Core Version:    0.7.0.1
 */