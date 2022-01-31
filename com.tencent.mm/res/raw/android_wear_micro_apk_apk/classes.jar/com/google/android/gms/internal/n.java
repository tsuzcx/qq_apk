package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.internal.d;

public final class n
  implements r, s
{
  public final a<?> HU;
  private final boolean MH;
  private o MI;
  
  public n(a<?> parama, boolean paramBoolean)
  {
    this.HU = parama;
    this.MH = paramBoolean;
  }
  
  private void ij()
  {
    d.e(this.MI, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    ij();
    this.MI.a(paramConnectionResult, this.HU, this.MH);
  }
  
  public final void a(o paramo)
  {
    this.MI = paramo;
  }
  
  public final void bd(int paramInt)
  {
    ij();
    this.MI.bd(paramInt);
  }
  
  public final void h(Bundle paramBundle)
  {
    ij();
    this.MI.h(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.n
 * JD-Core Version:    0.7.0.1
 */