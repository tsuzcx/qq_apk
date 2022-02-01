package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.n;

public final class a
  extends al
{
  int KN;
  
  public static Account a(ak paramak)
  {
    Account localAccount = null;
    long l;
    if (paramak != null) {
      l = Binder.clearCallingIdentity();
    }
    try
    {
      localAccount = paramak.gi();
      return localAccount;
    }
    catch (RemoteException paramak)
    {
      Log.w("AccountAccessor", "Remote account accessor probably died");
      return null;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof a)) {
      return false;
    }
    throw new NullPointerException();
  }
  
  public final Account gi()
  {
    int i = Binder.getCallingUid();
    if (i == this.KN) {
      return null;
    }
    if (n.bC(i))
    {
      this.KN = i;
      return null;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.a
 * JD-Core Version:    0.7.0.1
 */