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
  private WifiInfo RDc = null;
  private NetworkInfo glA = null;
  private int lastNetType = 1;
  
  public final boolean akC()
  {
    Object localObject1 = null;
    int i;
    for (;;)
    {
      try
      {
        localObject3 = (ConnectivityManager)c.Hhs.getSystemService("connectivity");
        if (localObject3 != null) {
          continue;
        }
        b.w("NetworkChangeMgr", new Object[] { "can't get ConnectivityManager" });
        this.lastNetType = 1;
        this.RDc = null;
        this.glA = null;
        bool = true;
      }
      catch (Exception localException)
      {
        Object localObject3;
        label122:
        b.w("NetworkChangeMgr", new Object[] { localException });
        this.lastNetType = 1;
        this.RDc = null;
        this.glA = null;
        bool = true;
        continue;
        if (((NetworkInfo)localObject3).getType() != 1) {
          break label456;
        }
        localWifiInfo = ((WifiManager)c.Hhs.getSystemService("wifi")).getConnectionInfo();
        i = 2;
        continue;
        if (i != 2) {
          continue;
        }
        if ((localWifiInfo == null) || (this.RDc == null) || (!this.RDc.getBSSID().equals(localWifiInfo.getBSSID())) || (!this.RDc.getSSID().equals(localWifiInfo.getSSID())) || (this.RDc.getNetworkId() != localWifiInfo.getNetworkId())) {
          break label461;
        }
        bool = false;
        continue;
        if ((this.glA == null) || (this.glA.getExtraInfo() == null) || (((NetworkInfo)localObject3).getExtraInfo() == null) || (!this.glA.getExtraInfo().equals(((NetworkInfo)localObject3).getExtraInfo())) || (this.glA.getSubtype() != ((NetworkInfo)localObject3).getSubtype()) || (this.glA.getType() != ((NetworkInfo)localObject3).getType())) {
          continue;
        }
        bool = false;
        continue;
        if ((this.glA == null) || (this.glA.getExtraInfo() != null) || (((NetworkInfo)localObject3).getExtraInfo() != null) || (this.glA.getSubtype() != ((NetworkInfo)localObject3).getSubtype())) {
          continue;
        }
        j = this.glA.getType();
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
        this.RDc = null;
        this.glA = null;
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
      this.RDc = localObject1;
      this.glA = ((NetworkInfo)localObject3);
      break;
      WifiInfo localWifiInfo;
      int j;
      int k;
      i = 3;
      break label122;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.pb.common.b.g
 * JD-Core Version:    0.7.0.1
 */