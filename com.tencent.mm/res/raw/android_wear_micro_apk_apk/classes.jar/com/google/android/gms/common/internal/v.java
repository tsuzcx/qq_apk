package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

public final class v
  extends m
{
  public final IBinder JP;
  
  public v(l paraml, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    super(paraml, paramInt, paramBundle);
    this.JP = paramIBinder;
  }
  
  protected final void b(ConnectionResult paramConnectionResult)
  {
    if (l.d(this.JK) != null) {
      l.d(this.JK).a(paramConnectionResult);
    }
    this.JK.a(paramConnectionResult);
  }
  
  protected final boolean hj()
  {
    IInterface localIInterface;
    do
    {
      try
      {
        String str1 = this.JP.getInterfaceDescriptor();
        if (!this.JK.gw().equals(str1))
        {
          String str2 = String.valueOf(this.JK.gw());
          Log.e("GmsClient", String.valueOf(str2).length() + 34 + String.valueOf(str1).length() + "service descriptor mismatch: " + str2 + " vs. " + str1);
          return false;
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("GmsClient", "service probably died");
        return false;
      }
      localIInterface = this.JK.e(this.JP);
    } while ((localIInterface == null) || (!l.a(this.JK, 2, 3, localIInterface)));
    if (l.b(this.JK) != null) {
      l.b(this.JK).h(null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.v
 * JD-Core Version:    0.7.0.1
 */