package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public enum i
{
  private boolean DNK;
  private boolean DNL;
  private Object DNM;
  public HashSet<WeakReference<Activity>> DNN;
  
  static
  {
    AppMethodBeat.i(129945);
    DNJ = new i("INSTANCE");
    DNO = new i[] { DNJ };
    AppMethodBeat.o(129945);
  }
  
  private i()
  {
    AppMethodBeat.i(129942);
    this.DNK = false;
    this.DNL = false;
    this.DNM = new Object();
    this.DNN = new HashSet();
    AppMethodBeat.o(129942);
  }
  
  public final boolean eNQ()
  {
    synchronized (this.DNM)
    {
      boolean bool = this.DNK;
      return bool;
    }
  }
  
  public final boolean eNR()
  {
    synchronized (this.DNM)
    {
      boolean bool = this.DNL;
      return bool;
    }
  }
  
  public final void eNS()
  {
    synchronized (this.DNM)
    {
      this.DNL = true;
      return;
    }
  }
  
  public final void eNT()
  {
    AppMethodBeat.i(129944);
    Iterator localIterator = this.DNN.iterator();
    while (localIterator.hasNext())
    {
      Activity localActivity = (Activity)((WeakReference)localIterator.next()).get();
      if ((localActivity != null) && (!localActivity.isFinishing()))
      {
        ae.v("MicroMsg.WalletLockStatusManager", "alvinluo finish %s", new Object[] { localActivity.getClass().getName() });
        localActivity.finish();
      }
      localIterator.remove();
    }
    AppMethodBeat.o(129944);
  }
  
  public final void i(WeakReference<Activity> paramWeakReference)
  {
    AppMethodBeat.i(129943);
    if (this.DNN != null)
    {
      if (paramWeakReference.get() != null) {
        ae.v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", new Object[] { ((Activity)paramWeakReference.get()).getClass().getName() });
      }
      this.DNN.add(paramWeakReference);
    }
    AppMethodBeat.o(129943);
  }
  
  public final void uS(boolean paramBoolean)
  {
    synchronized (this.DNM)
    {
      this.DNK = paramBoolean;
      return;
    }
  }
  
  public final void uT(boolean paramBoolean)
  {
    synchronized (this.DNM)
    {
      this.DNL = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.c.i
 * JD-Core Version:    0.7.0.1
 */