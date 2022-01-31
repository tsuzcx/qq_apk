package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.util.a;

public final class x
  extends i
{
  private aq HZ;
  private final a<ef<?>> Nq;
  
  protected final void a(ConnectionResult paramConnectionResult, int paramInt)
  {
    this.HZ.a(paramConnectionResult, paramInt);
  }
  
  protected final void hY()
  {
    this.HZ.hY();
  }
  
  final a<ef<?>> is()
  {
    return this.Nq;
  }
  
  public final void onStart()
  {
    super.onStart();
    if (!this.Nq.isEmpty()) {
      this.HZ.a(this);
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    this.HZ.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.x
 * JD-Core Version:    0.7.0.1
 */