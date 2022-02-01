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
  private Integer LI;
  private final x LU;
  private final Bundle Sn;
  private final boolean Sy;
  
  public de(Context paramContext, Looper paramLooper, x paramx, r paramr, s params)
  {
    this(paramContext, paramLooper, true, paramx, localBundle, paramr, params);
  }
  
  public de(Context paramContext, Looper paramLooper, boolean paramBoolean, x paramx, Bundle paramBundle, r paramr, s params)
  {
    super(paramContext, paramLooper, 44, paramx, paramr, params);
    this.Sy = paramBoolean;
    this.LU = paramx;
    this.Sn = paramBundle;
    this.LI = paramx.hD();
  }
  
  public final void a(ak paramak, boolean paramBoolean)
  {
    try
    {
      ((da)hr()).a(paramak, this.LI.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException paramak)
    {
      Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
    }
  }
  
  public final void a(cx paramcx)
  {
    d.g(paramcx, "Expecting a valid ISignInCallbacks");
    try
    {
      Account localAccount = this.LU.hw();
      Object localObject = null;
      if ("<<default account>>".equals(localAccount.name)) {
        localObject = c.c(getContext()).gt();
      }
      localObject = new zzad(localAccount, this.LI.intValue(), (GoogleSignInAccount)localObject);
      ((da)hr()).a(new zzbau((zzad)localObject), paramcx);
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
  
  public final boolean gC()
  {
    return this.Sy;
  }
  
  protected final String gF()
  {
    return "com.google.android.gms.signin.service.START";
  }
  
  protected final String gG()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }
  
  protected final Bundle hq()
  {
    String str = this.LU.hA();
    if (!getContext().getPackageName().equals(str)) {
      this.Sn.putString("com.google.android.gms.signin.internal.realClientPackageName", this.LU.hA());
    }
    return this.Sn;
  }
  
  public final void jN()
  {
    try
    {
      ((da)hr()).bI(this.LI.intValue());
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