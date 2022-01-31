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
  private NetworkInfo dhI = null;
  private WifiInfo dhJ = null;
  private int wFT = 1;
  
  public final boolean vW()
  {
    Object localObject1 = null;
    int i;
    for (;;)
    {
      try
      {
        localObject3 = (ConnectivityManager)d.pZI.getSystemService("connectivity");
        if (localObject3 != null) {
          continue;
        }
        c.x("NetworkChangeMgr", new Object[] { "can't get ConnectivityManager" });
        this.wFT = 1;
        this.dhJ = null;
        this.dhI = null;
        bool = true;
      }
      catch (Exception localException)
      {
        Object localObject3;
        label122:
        c.x("NetworkChangeMgr", new Object[] { localException });
        this.wFT = 1;
        this.dhJ = null;
        this.dhI = null;
        bool = true;
        continue;
        if (((NetworkInfo)localObject3).getType() != 1) {
          break label456;
        }
        localWifiInfo = ((WifiManager)d.pZI.getSystemService("wifi")).getConnectionInfo();
        i = 2;
        continue;
        if (i != 2) {
          continue;
        }
        if ((localWifiInfo == null) || (this.dhJ == null) || (!this.dhJ.getBSSID().equals(localWifiInfo.getBSSID())) || (!this.dhJ.getSSID().equals(localWifiInfo.getSSID())) || (this.dhJ.getNetworkId() != localWifiInfo.getNetworkId())) {
          break label461;
        }
        bool = false;
        continue;
        if ((this.dhI == null) || (this.dhI.getExtraInfo() == null) || (((NetworkInfo)localObject3).getExtraInfo() == null) || (!this.dhI.getExtraInfo().equals(((NetworkInfo)localObject3).getExtraInfo())) || (this.dhI.getSubtype() != ((NetworkInfo)localObject3).getSubtype()) || (this.dhI.getType() != ((NetworkInfo)localObject3).getType())) {
          continue;
        }
        bool = false;
        continue;
        if ((this.dhI == null) || (this.dhI.getExtraInfo() != null) || (((NetworkInfo)localObject3).getExtraInfo() != null) || (this.dhI.getSubtype() != ((NetworkInfo)localObject3).getSubtype())) {
          continue;
        }
        j = this.dhI.getType();
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
        this.wFT = 1;
        this.dhJ = null;
        this.dhI = null;
        bool = true;
      }
      else
      {
        c.d("NetworkChangeMgr", new Object[] { "NetworkChangeMgr ", localObject3 });
        if (!((NetworkInfo)localObject3).isConnected())
        {
          i = 1;
          if (i != this.wFT) {
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
      this.wFT = i;
      this.dhJ = localObject1;
      this.dhI = ((NetworkInfo)localObject3);
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