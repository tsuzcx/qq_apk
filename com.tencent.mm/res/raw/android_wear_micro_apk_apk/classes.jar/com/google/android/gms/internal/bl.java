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
  private static f<? extends cr, cs> QY = cp.Sj;
  private Set<Scope> IG;
  private final f<? extends cr, cs> Jc;
  private x LU;
  private cr Pp;
  private final boolean QZ;
  private bm Ra;
  private final Handler dG;
  private final Context mContext;
  
  public bl(Context paramContext, Handler paramHandler)
  {
    this.mContext = paramContext;
    this.dG = paramHandler;
    this.Jc = QY;
    this.QZ = true;
  }
  
  public bl(Context paramContext, Handler paramHandler, x paramx, f<? extends cr, cs> paramf)
  {
    this.mContext = paramContext;
    this.dG = paramHandler;
    this.LU = paramx;
    this.IG = paramx.hx();
    this.Jc = paramf;
    this.QZ = false;
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    this.Ra.l(paramConnectionResult);
  }
  
  public final void a(bm parambm)
  {
    if (this.Pp != null) {
      this.Pp.disconnect();
    }
    if (this.QZ)
    {
      localObject = c.c(this.mContext).gu();
      if (localObject != null) {
        break label128;
      }
    }
    label128:
    for (Object localObject = new HashSet();; localObject = new HashSet(((GoogleSignInOptions)localObject).gh()))
    {
      this.IG = ((Set)localObject);
      this.LU = new x(null, this.IG, null, 0, null, null, null, cs.So);
      this.Pp = ((cr)this.Jc.a(this.mContext, this.dG.getLooper(), this.LU, this.LU.hC(), this, this));
      this.Ra = parambm;
      this.Pp.connect();
      return;
    }
  }
  
  public final void a(final zzbaw paramzzbaw)
  {
    this.dG.post(new Runnable()
    {
      public final void run()
      {
        bl.a(bl.this, paramzzbaw);
      }
    });
  }
  
  public final void bx(int paramInt)
  {
    this.Pp.disconnect();
  }
  
  public final void h(Bundle paramBundle)
  {
    this.Pp.a(this);
  }
  
  public final cr jf()
  {
    return this.Pp;
  }
  
  public final void jn()
  {
    this.Pp.disconnect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.bl
 * JD-Core Version:    0.7.0.1
 */