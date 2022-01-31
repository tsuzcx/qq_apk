package com.tencent.pb.common.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;

public final class g
{
  private WifiInfo Bdt = null;
  private int Bdu = 1;
  private NetworkInfo dYZ = null;
  
  public final boolean Ik()
  {
    Object localObject1 = null;
    int i;
    for (;;)
    {
      try
      {
        localObject3 = (ConnectivityManager)d.tFk.getSystemService("connectivity");
        if (localObject3 != null) {
          continue;
        }
        c.w("NetworkChangeMgr", new Object[] { "can't get ConnectivityManager" });
        this.Bdu = 1;
        this.Bdt = null;
        this.dYZ = null;
        bool = true;
      }
      catch (Exception localException)
      {
        Object localObject3;
        label122:
        c.w("NetworkChangeMgr", new Object[] { localException });
        this.Bdu = 1;
        this.Bdt = null;
        this.dYZ = null;
        bool = true;
        continue;
        if (((NetworkInfo)localObject3).getType() != 1) {
          break label456;
        }
        localWifiInfo = ((WifiManager)d.tFk.getSystemService("wifi")).getConnectionInfo();
        i = 2;
        continue;
        if (i != 2) {
          continue;
        }
        if ((localWifiInfo == null) || (this.Bdt == null) || (!this.Bdt.getBSSID().equals(localWifiInfo.getBSSID())) || (!this.Bdt.getSSID().equals(localWifiInfo.getSSID())) || (this.Bdt.getNetworkId() != localWifiInfo.getNetworkId())) {
          break label461;
        }
        bool = false;
        continue;
        if ((this.dYZ == null) || (this.dYZ.getExtraInfo() == null) || (((NetworkInfo)localObject3).getExtraInfo() == null) || (!this.dYZ.getExtraInfo().equals(((NetworkInfo)localObject3).getExtraInfo())) || (this.dYZ.getSubtype() != ((NetworkInfo)localObject3).getSubtype()) || (this.dYZ.getType() != ((NetworkInfo)localObject3).getType())) {
          continue;
        }
        bool = false;
        continue;
        if ((this.dYZ == null) || (this.dYZ.getExtraInfo() != null) || (((NetworkInfo)localObject3).getExtraInfo() != null) || (this.dYZ.getSubtype() != ((NetworkInfo)localObject3).getSubtype())) {
          continue;
        }
        j = this.dYZ.getType();
        k = ((NetworkInfo)localObject3).getType();
        if (j != k) {
          continue;
        }
        bool = false;
        continue;
        bool = true;
        continue;
      }
      finally {}
      return bool;
      localObject3 = ((ConnectivityManager)localObject3).getActiveNetworkInfo();
      if (localObject3 == null)
      {
        this.Bdu = 1;
        this.Bdt = null;
        this.dYZ = null;
        bool = true;
      }
      else
      {
        c.d("NetworkChangeMgr", new Object[] { "NetworkChangeMgr ", localObject3 });
        if (!((NetworkInfo)localObject3).isConnected())
        {
          i = 1;
          if (i != this.Bdu) {
            continue;
          }
          if (i != 1) {
            continue;
          }
        }
      }
    }
    label456:
    label461:
    for (boolean bool = false;; bool = true)
    {
      this.Bdu = i;
      this.Bdt = localObject1;
      this.dYZ = ((NetworkInfo)localObject3);
      break;
      WifiInfo localWifiInfo;
      int j;
      int k;
      i = 3;
      break label122;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.g
 * JD-Core Version:    0.7.0.1
 */