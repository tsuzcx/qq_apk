package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

public final class u
  implements r
{
  public u(l paraml) {}
  
  public final void c(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.gm()) {
      this.JK.a(null, this.JK.hi());
    }
    while (l.d(this.JK) == null) {
      return;
    }
    l.d(this.JK).a(paramConnectionResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.u
 * JD-Core Version:    0.7.0.1
 */