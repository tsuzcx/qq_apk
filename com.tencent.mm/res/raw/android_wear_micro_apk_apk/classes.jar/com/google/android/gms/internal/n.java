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
  public final a<?> JJ;
  private final boolean Ow;
  private o Ox;
  
  public n(a<?> parama, boolean paramBoolean)
  {
    this.JJ = parama;
    this.Ow = paramBoolean;
  }
  
  private void ir()
  {
    d.g(this.Ox, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    ir();
    this.Ox.a(paramConnectionResult, this.JJ, this.Ow);
  }
  
  public final void a(o paramo)
  {
    this.Ox = paramo;
  }
  
  public final void bx(int paramInt)
  {
    ir();
    this.Ox.bx(paramInt);
  }
  
  public final void h(Bundle paramBundle)
  {
    ir();
    this.Ox.h(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.n
 * JD-Core Version:    0.7.0.1
 */