package com.tencent.pb.common.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;

public final class g
{
  private WifiInfo ahdh = null;
  private int lastNetType = 1;
  private NetworkInfo lrD = null;
  
  public final boolean aKw()
  {
    Object localObject1 = null;
    int i;
    for (;;)
    {
      try
      {
        localObject3 = (ConnectivityManager)c.UMe.getSystemService("connectivity");
        if (localObject3 != null) {
          continue;
        }
        b.w("NetworkChangeMgr", new Object[] { "can't get ConnectivityManager" });
        this.lastNetType = 1;
        this.ahdh = null;
        this.lrD = null;
        bool = true;
      }
      catch (Exception localException)
      {
        Object localObject3;
        label122:
        b.w("NetworkChangeMgr", new Object[] { localException });
        this.lastNetType = 1;
        this.ahdh = null;
        this.lrD = null;
        bool = true;
        continue;
        if (((NetworkInfo)localObject3).getType() != 1) {
          break label471;
        }
        localWifiInfo = (WifiInfo)a.a((WifiManager)c.UMe.getSystemService("wifi"), "com/tencent/pb/common/network/NetworkChangeMgr", "isNetWorkChange", "()Z", "android/net/wifi/WifiManager", "getConnectionInfo", "()Landroid/net/wifi/WifiInfo;");
        i = 2;
        continue;
        if (i != 2) {
          continue;
        }
        if ((localWifiInfo == null) || (this.ahdh == null) || (!this.ahdh.getBSSID().equals(localWifiInfo.getBSSID())) || (!this.ahdh.getSSID().equals(localWifiInfo.getSSID())) || (this.ahdh.getNetworkId() != localWifiInfo.getNetworkId())) {
          break label476;
        }
        bool = false;
        continue;
        if ((this.lrD == null) || (this.lrD.getExtraInfo() == null) || (((NetworkInfo)localObject3).getExtraInfo() == null) || (!this.lrD.getExtraInfo().equals(((NetworkInfo)localObject3).getExtraInfo())) || (this.lrD.getSubtype() != ((NetworkInfo)localObject3).getSubtype()) || (this.lrD.getType() != ((NetworkInfo)localObject3).getType())) {
          continue;
        }
        bool = false;
        continue;
        if ((this.lrD == null) || (this.lrD.getExtraInfo() != null) || (((NetworkInfo)localObject3).getExtraInfo() != null) || (this.lrD.getSubtype() != ((NetworkInfo)localObject3).getSubtype())) {
          continue;
        }
        j = this.lrD.getType();
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
        this.ahdh = null;
        this.lrD = null;
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
    label471:
    label476:
    for (boolean bool = false;; bool = true)
    {
      this.lastNetType = i;
      this.ahdh = localObject1;
      this.lrD = ((NetworkInfo)localObject3);
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