package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.b;
import com.google.android.gms.common.zzc;
import java.util.Set;

public abstract class ac<T extends IInterface>
  extends l<T>
  implements j, ae
{
  private final Set<Scope> IG;
  private final Account Iy;
  private final x LU;
  
  protected ac(Context paramContext, Looper paramLooper, int paramInt, x paramx, r paramr, s params)
  {
    this(paramContext, paramLooper, af.i(paramContext), b.gz(), paramInt, paramx, (r)d.D(paramr), (s)d.D(params));
  }
  
  private ac(Context paramContext, Looper paramLooper, af paramaf, b paramb, int paramInt, x paramx, r paramr, s params) {}
  
  public final Account gi()
  {
    return this.Iy;
  }
  
  public final zzc[] hp()
  {
    return new zzc[0];
  }
  
  protected final Set<Scope> hs()
  {
    return this.IG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.ac
 * JD-Core Version:    0.7.0.1
 */