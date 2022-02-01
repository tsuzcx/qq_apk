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
  private final f<? extends cr, cs> Jv;
  private final x LU;
  private final j OL;
  private final n OM;
  
  public s(Context paramContext, a<O> parama, Looper paramLooper, j paramj, n paramn, x paramx, f<? extends cr, cs> paramf)
  {
    super(paramContext, parama, paramLooper);
    this.OL = paramj;
    this.OM = paramn;
    this.LU = paramx;
    this.Jv = paramf;
    this.JO.b(this);
  }
  
  public final j a(Looper paramLooper, ar<O> paramar)
  {
    this.OM.a(paramar);
    return this.OL;
  }
  
  public final bl a(Context paramContext, Handler paramHandler)
  {
    return new bl(paramContext, paramHandler, this.LU, this.Jv);
  }
  
  public final j iw()
  {
    return this.OL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.s
 * JD-Core Version:    0.7.0.1
 */