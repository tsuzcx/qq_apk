package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.ad;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.x;

public final class s<O extends b>
  extends ad<O>
{
  private final f<? extends cr, cs> HG;
  private final x Kf;
  private final j MW;
  private final n MX;
  
  public s(Context paramContext, a<O> parama, Looper paramLooper, j paramj, n paramn, x paramx, f<? extends cr, cs> paramf)
  {
    super(paramContext, parama, paramLooper);
    this.MW = paramj;
    this.MX = paramn;
    this.Kf = paramx;
    this.HG = paramf;
    this.HZ.b(this);
  }
  
  public final j a(Looper paramLooper, ar<O> paramar)
  {
    this.MX.a(paramar);
    return this.MW;
  }
  
  public final bl a(Context paramContext, Handler paramHandler)
  {
    return new bl(paramContext, paramHandler, this.Kf, this.HG);
  }
  
  public final j io()
  {
    return this.MW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.s
 * JD-Core Version:    0.7.0.1
 */