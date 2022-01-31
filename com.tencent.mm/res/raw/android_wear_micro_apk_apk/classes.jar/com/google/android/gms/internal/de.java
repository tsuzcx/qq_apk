package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.c;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.internal.ac;
import com.google.android.gms.common.internal.ak;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.common.internal.zzad;

public final class de
  extends ac<da>
  implements cr
{
  private Integer JT;
  private final x Kf;
  private final boolean QJ;
  private final Bundle Qy;
  
  public de(Context paramContext, Looper paramLooper, x paramx, r paramr, s params)
  {
    this(paramContext, paramLooper, true, paramx, localBundle, paramr, params);
  }
  
  public de(Context paramContext, Looper paramLooper, boolean paramBoolean, x paramx, Bundle paramBundle, r paramr, s params)
  {
    super(paramContext, paramLooper, 44, paramx, paramr, params);
    this.QJ = paramBoolean;
    this.Kf = paramx;
    this.Qy = paramBundle;
    this.JT = paramx.ht();
  }
  
  public final void a(ak paramak, boolean paramBoolean)
  {
    try
    {
      ((da)hh()).a(paramak, this.JT.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException paramak)
    {
      Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
    }
  }
  
  public final void a(cx paramcx)
  {
    d.e(paramcx, "Expecting a valid ISignInCallbacks");
    try
    {
      Account localAccount = this.Kf.hm();
      Object localObject = null;
      if ("<<default account>>".equals(localAccount.name)) {
        localObject = c.c(getContext()).gj();
      }
      localObject = new zzad(localAccount, this.JT.intValue(), (GoogleSignInAccount)localObject);
      ((da)hh()).a(new zzbau((zzad)localObject), paramcx);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
      try
      {
        paramcx.a(new zzbaw());
        return;
      }
      catch (RemoteException paramcx)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", localRemoteException);
      }
    }
  }
  
  public final void connect()
  {
    a(new u(this));
  }
  
  public final boolean gs()
  {
    return this.QJ;
  }
  
  protected final String gv()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  protected final String gw()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  protected final Bundle hg()
  {
    String str = this.Kf.hq();
    if (!getContext().getPackageName().equals(str)) {
      this.Qy.putString("com.google.android.gms.signin.internal.realClientPackageName", this.Kf.hq());
    }
    return this.Qy;
  }
  
  public final void jE()
  {
    try
    {
      ((da)hh()).bo(this.JT.intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.de
 * JD-Core Version:    0.7.0.1
 */