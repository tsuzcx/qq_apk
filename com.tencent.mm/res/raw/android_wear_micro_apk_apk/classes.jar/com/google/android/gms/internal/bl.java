package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.c;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.internal.x;
import java.util.HashSet;
import java.util.Set;

public final class bl
  extends cv
  implements r, s
{
  private static f<? extends cr, cs> Pj = cp.Qu;
  private Set<Scope> GR;
  private final f<? extends cr, cs> Hn;
  private x Kf;
  private cr NA;
  private final boolean Pk;
  private bm Pl;
  private final Context mContext;
  private final Handler mHandler;
  
  public bl(Context paramContext, Handler paramHandler)
  {
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.Hn = Pj;
    this.Pk = true;
  }
  
  public bl(Context paramContext, Handler paramHandler, x paramx, f<? extends cr, cs> paramf)
  {
    this.mContext = paramContext;
    this.mHandler = paramHandler;
    this.Kf = paramx;
    this.GR = paramx.hn();
    this.Hn = paramf;
    this.Pk = false;
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    this.Pl.k(paramConnectionResult);
  }
  
  public final void a(bm parambm)
  {
    if (this.NA != null) {
      this.NA.disconnect();
    }
    if (this.Pk)
    {
      localObject = c.c(this.mContext).gk();
      if (localObject != null) {
        break label128;
      }
    }
    label128:
    for (Object localObject = new HashSet();; localObject = new HashSet(((GoogleSignInOptions)localObject).fW()))
    {
      this.GR = ((Set)localObject);
      this.Kf = new x(null, this.GR, null, 0, null, null, null, cs.Qz);
      this.NA = ((cr)this.Hn.a(this.mContext, this.mHandler.getLooper(), this.Kf, this.Kf.hs(), this, this));
      this.Pl = parambm;
      this.NA.connect();
      return;
    }
  }
  
  public final void a(final zzbaw paramzzbaw)
  {
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        bl.a(bl.this, paramzzbaw);
      }
    });
  }
  
  public final void bd(int paramInt)
  {
    this.NA.disconnect();
  }
  
  public final void h(Bundle paramBundle)
  {
    this.NA.a(this);
  }
  
  public final cr iW()
  {
    return this.NA;
  }
  
  public final void je()
  {
    this.NA.disconnect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bl
 * JD-Core Version:    0.7.0.1
 */