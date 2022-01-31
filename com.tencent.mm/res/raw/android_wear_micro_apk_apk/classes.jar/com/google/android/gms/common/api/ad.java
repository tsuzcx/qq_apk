package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.internal.aq;
import com.google.android.gms.internal.ar;
import com.google.android.gms.internal.at;
import com.google.android.gms.internal.bl;
import com.google.android.gms.internal.bn;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.ef;

public abstract class ad<O extends b>
{
  private final Account GJ;
  private final Looper HE;
  private final a<O> HU;
  private final O HV;
  private final ef<O> HW;
  private final p HX;
  private final bn HY;
  protected final aq HZ;
  private final int de;
  private final Context mContext;
  
  protected ad(Context paramContext, a<O> parama, Looper paramLooper)
  {
    d.e(paramContext, "Null context is not permitted.");
    d.e(parama, "Api must not be null.");
    d.e(paramLooper, "Looper must not be null.");
    this.mContext = paramContext.getApplicationContext();
    this.HU = parama;
    this.HV = null;
    this.HE = paramLooper;
    this.HW = ef.b(parama);
    this.HX = new at(this);
    this.HZ = aq.s(this.mContext);
    this.de = this.HZ.iI();
    this.HY = new ee();
    this.GJ = null;
  }
  
  private <A extends g, T extends com.google.android.gms.internal.g<? extends w, A>> T a(int paramInt, T paramT)
  {
    paramT.ih();
    this.HZ.a(this, paramInt, paramT);
    return paramT;
  }
  
  public j a(Looper paramLooper, ar<O> paramar)
  {
    x localx = new q(this.mContext).a(this.GJ).gz();
    return this.HU.gq().a(this.mContext, paramLooper, localx, this.HV, paramar, paramar);
  }
  
  public bl a(Context paramContext, Handler paramHandler)
  {
    return new bl(paramContext, paramHandler);
  }
  
  public final <A extends g, T extends com.google.android.gms.internal.g<? extends w, A>> T c(T paramT)
  {
    return a(0, paramT);
  }
  
  public final <A extends g, T extends com.google.android.gms.internal.g<? extends w, A>> T d(T paramT)
  {
    return a(1, paramT);
  }
  
  public final a<O> gI()
  {
    return this.HU;
  }
  
  public final ef<O> gJ()
  {
    return this.HW;
  }
  
  public final int getInstanceId()
  {
    return this.de;
  }
  
  public final Looper getLooper()
  {
    return this.HE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.ad
 * JD-Core Version:    0.7.0.1
 */