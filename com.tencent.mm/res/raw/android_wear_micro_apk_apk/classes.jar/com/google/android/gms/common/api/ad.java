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
  private final Account Iy;
  private final a<O> JJ;
  private final O JK;
  private final ef<O> JL;
  private final p JM;
  private final bn JN;
  protected final aq JO;
  private final Looper Jt;
  private final int eS;
  private final Context mContext;
  
  protected ad(Context paramContext, a<O> parama, Looper paramLooper)
  {
    d.g(paramContext, "Null context is not permitted.");
    d.g(parama, "Api must not be null.");
    d.g(paramLooper, "Looper must not be null.");
    this.mContext = paramContext.getApplicationContext();
    this.JJ = parama;
    this.JK = null;
    this.Jt = paramLooper;
    this.JL = ef.b(parama);
    this.JM = new at(this);
    this.JO = aq.t(this.mContext);
    this.eS = this.JO.iQ();
    this.JN = new ee();
    this.Iy = null;
  }
  
  private <A extends g, T extends com.google.android.gms.internal.g<? extends w, A>> T a(int paramInt, T paramT)
  {
    paramT.ip();
    this.JO.a(this, paramInt, paramT);
    return paramT;
  }
  
  public j a(Looper paramLooper, ar<O> paramar)
  {
    x localx = new q(this.mContext).a(this.Iy).gJ();
    return this.JJ.gA().a(this.mContext, paramLooper, localx, this.JK, paramar, paramar);
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
  
  public final a<O> gS()
  {
    return this.JJ;
  }
  
  public final ef<O> gT()
  {
    return this.JL;
  }
  
  public final int getInstanceId()
  {
    return this.eS;
  }
  
  public final Looper getLooper()
  {
    return this.Jt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.ad
 * JD-Core Version:    0.7.0.1
 */