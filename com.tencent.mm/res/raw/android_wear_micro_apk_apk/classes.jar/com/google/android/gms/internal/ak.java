package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

final class ak
  extends au
{
  private WeakReference<ai> PV;
  
  ak(ai paramai)
  {
    this.PV = new WeakReference(paramai);
  }
  
  public final void in()
  {
    ai localai = (ai)this.PV.get();
    if (localai == null) {
      return;
    }
    ai.a(localai);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.ak
 * JD-Core Version:    0.7.0.1
 */