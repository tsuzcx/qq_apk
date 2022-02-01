package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.util.a;

public final class x
  extends i
{
  private aq JO;
  private final a<ef<?>> Pf;
  
  protected final void a(ConnectionResult paramConnectionResult, int paramInt)
  {
    this.JO.a(paramConnectionResult, paramInt);
  }
  
  final a<ef<?>> iA()
  {
    return this.Pf;
  }
  
  protected final void ig()
  {
    this.JO.ig();
  }
  
  public final void onStart()
  {
    super.onStart();
    if (!this.Pf.isEmpty()) {
      this.JO.a(this);
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    this.JO.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.x
 * JD-Core Version:    0.7.0.1
 */