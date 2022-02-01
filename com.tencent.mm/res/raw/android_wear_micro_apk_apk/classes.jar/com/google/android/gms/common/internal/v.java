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
  public final IBinder LE;
  
  public v(l paraml, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    super(paraml, paramInt, paramBundle);
    this.LE = paramIBinder;
  }
  
  protected final void b(ConnectionResult paramConnectionResult)
  {
    if (l.d(this.Lz) != null) {
      l.d(this.Lz).a(paramConnectionResult);
    }
    this.Lz.a(paramConnectionResult);
  }
  
  protected final boolean ht()
  {
    IInterface localIInterface;
    do
    {
      try
      {
        String str1 = this.LE.getInterfaceDescriptor();
        if (!this.Lz.gG().equals(str1))
        {
          String str2 = String.valueOf(this.Lz.gG());
          Log.e("GmsClient", String.valueOf(str2).length() + 34 + String.valueOf(str1).length() + "service descriptor mismatch: " + str2 + " vs. " + str1);
          return false;
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("GmsClient", "service probably died");
        return false;
      }
      localIInterface = this.Lz.e(this.LE);
    } while ((localIInterface == null) || (!l.a(this.Lz, 2, 3, localIInterface)));
    if (l.b(this.Lz) != null) {
      l.b(this.Lz).h(null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.v
 * JD-Core Version:    0.7.0.1
 */