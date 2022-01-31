package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public enum i
{
  private boolean qRe = false;
  private boolean qRf = false;
  private Object qRg = new Object();
  public HashSet<WeakReference<Activity>> qRh = new HashSet();
  
  private i() {}
  
  public final void b(WeakReference<Activity> paramWeakReference)
  {
    if (this.qRh != null)
    {
      if (paramWeakReference.get() != null) {
        y.v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", new Object[] { ((Activity)paramWeakReference.get()).getClass().getName() });
      }
      this.qRh.add(paramWeakReference);
    }
  }
  
  public final boolean bYE()
  {
    synchronized (this.qRg)
    {
      boolean bool = this.qRe;
      return bool;
    }
  }
  
  public final boolean bYF()
  {
    synchronized (this.qRg)
    {
      boolean bool = this.qRf;
      return bool;
    }
  }
  
  public final void bYG()
  {
    synchronized (this.qRg)
    {
      this.qRf = true;
      return;
    }
  }
  
  public final void bYH()
  {
    Iterator localIterator = this.qRh.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
      if ((localActivity != null) && (!localActivity.isFinishing()))
      {
        y.v("MicroMsg.WalletLockStatusManager", "alvinluo finish %s", new Object[] { localActivity.getClass().getName() });
        localActivity.finish();
      }
      localIterator.remove();
    }
  }
  
  public final void kV(boolean paramBoolean)
  {
    synchronized (this.qRg)
    {
      this.qRe = paramBoolean;
      return;
    }
  }
  
  public final void kW(boolean paramBoolean)
  {
    synchronized (this.qRg)
    {
      this.qRf = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.i
 * JD-Core Version:    0.7.0.1
 */