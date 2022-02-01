package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public enum i
{
  private boolean IwZ;
  private boolean Ixa;
  private Object Ixb;
  public HashSet<WeakReference<Activity>> Ixc;
  
  static
  {
    AppMethodBeat.i(129945);
    IwY = new i("INSTANCE");
    Ixd = new i[] { IwY };
    AppMethodBeat.o(129945);
  }
  
  private i()
  {
    AppMethodBeat.i(129942);
    this.IwZ = false;
    this.Ixa = false;
    this.Ixb = new Object();
    this.Ixc = new HashSet();
    AppMethodBeat.o(129942);
  }
  
  public final boolean fVA()
  {
    synchronized (this.Ixb)
    {
      boolean bool = this.Ixa;
      return bool;
    }
  }
  
  public final void fVB()
  {
    synchronized (this.Ixb)
    {
      this.Ixa = true;
      return;
    }
  }
  
  public final void fVC()
  {
    AppMethodBeat.i(129944);
    Iterator localIterator = this.Ixc.iterator();
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
  
  public final boolean fVz()
  {
    synchronized (this.Ixb)
    {
      boolean bool = this.IwZ;
      return bool;
    }
  }
  
  public final void j(WeakReference<Activity> paramWeakReference)
  {
    AppMethodBeat.i(129943);
    if (this.Ixc != null)
    {
      if (paramWeakReference.get() != null) {
        Log.v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", new Object[] { ((Activity)paramWeakReference.get()).getClass().getName() });
      }
      this.Ixc.add(paramWeakReference);
    }
    AppMethodBeat.o(129943);
  }
  
  public final void yH(boolean paramBoolean)
  {
    synchronized (this.Ixb)
    {
      this.IwZ = paramBoolean;
      return;
    }
  }
  
  public final void yI(boolean paramBoolean)
  {
    synchronized (this.Ixb)
    {
      this.Ixa = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.i
 * JD-Core Version:    0.7.0.1
 */