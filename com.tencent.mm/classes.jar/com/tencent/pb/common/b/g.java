package com.tencent.pb.common.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;

public final class g
{
  private WifiInfo McN = null;
  private NetworkInfo fGr = null;
  private int lastNetType = 1;
  
  public final boolean WO()
  {
    Object localObject1 = null;
    int i;
    for (;;)
    {
      try
      {
        localObject3 = (ConnectivityManager)c.CDp.getSystemService("connectivity");
        if (localObject3 != null) {
          continue;
        }
        b.w("NetworkChangeMgr", new Object[] { "can't get ConnectivityManager" });
        this.lastNetType = 1;
        this.McN = null;
        this.fGr = null;
        bool = true;
      }
      catch (Exception localException)
      {
        Object localObject3;
        label122:
        b.w("NetworkChangeMgr", new Object[] { localException });
        this.lastNetType = 1;
        this.McN = null;
        this.fGr = null;
        bool = true;
        continue;
        if (((NetworkInfo)localObject3).getType() != 1) {
          break label456;
        }
        localWifiInfo = ((WifiManager)c.CDp.getSystemService("wifi")).getConnectionInfo();
        i = 2;
        continue;
        if (i != 2) {
          continue;
        }
        if ((localWifiInfo == null) || (this.McN == null) || (!this.McN.getBSSID().equals(localWifiInfo.getBSSID())) || (!this.McN.getSSID().equals(localWifiInfo.getSSID())) || (this.McN.getNetworkId() != localWifiInfo.getNetworkId())) {
          break label461;
        }
        bool = false;
        continue;
        if ((this.fGr == null) || (this.fGr.getExtraInfo() == null) || (((NetworkInfo)localObject3).getExtraInfo() == null) || (!this.fGr.getExtraInfo().equals(((NetworkInfo)localObject3).getExtraInfo())) || (this.fGr.getSubtype() != ((NetworkInfo)localObject3).getSubtype()) || (this.fGr.getType() != ((NetworkInfo)localObject3).getType())) {
          continue;
        }
        bool = false;
        continue;
        if ((this.fGr == null) || (this.fGr.getExtraInfo() != null) || (((NetworkInfo)localObject3).getExtraInfo() != null) || (this.fGr.getSubtype() != ((NetworkInfo)localObject3).getSubtype())) {
          continue;
        }
        j = this.fGr.getType();
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
        this.lastNetType = 1;
        this.McN = null;
        this.fGr = null;
        bool = true;
      }
      else
      {
        b.d("NetworkChangeMgr", new Object[] { "NetworkChangeMgr ", localObject3 });
        if (!((NetworkInfo)localObject3).isConnected())
        {
          i = 1;
          if (i != this.lastNetType) {
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
      this.lastNetType = i;
      this.McN = localObject1;
      this.fGr = ((NetworkInfo)localObject3);
      break;
      WifiInfo localWifiInfo;
      int j;
      int k;
      i = 3;
      break label122;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.pb.common.b.g
 * JD-Core Version:    0.7.0.1
 */