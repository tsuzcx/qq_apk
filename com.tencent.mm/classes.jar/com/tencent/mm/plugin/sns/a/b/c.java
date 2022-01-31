package com.tencent.mm.plugin.sns.a.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.bb;
import com.tencent.mm.protocal.c.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  public f dmL;
  
  public c(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, String paramString3, int paramInt5, com.tencent.mm.bv.b paramb1, com.tencent.mm.bv.b paramb2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bb();
    ((b.a)localObject).ecI = new bc();
    int j = n.omI.fK(paramLong);
    if (j != 2)
    {
      ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/click";
      ((b.a)localObject).ecG = 1232;
      ((b.a)localObject).ecJ = 0;
      ((b.a)localObject).ecK = 0;
      this.dmK = ((b.a)localObject).Kt();
      y.i("MicroMsg.NetSceneAdClick", "source %d, uri %s", new Object[] { Integer.valueOf(j), this.dmK.uri });
      localObject = new StringBuilder("snsId:").append(paramLong).append(" viewId:").append(paramString1).append(" clickPos:").append(paramInt1).append(" clickAction:").append(paramInt2).append(" sceneType:").append(paramInt3).append(" descXml:").append(paramString2).append(" adtype:").append(paramInt4).append(" snsStatStr:").append(paramString3).append(" flipStatus:").append(paramInt5).append(" remind_source_info.length:");
      if (paramb1 == null) {
        break label460;
      }
      i = paramb1.oY.length;
      label231:
      localObject = ((StringBuilder)localObject).append(String.valueOf(i)).append(" remind_self_info.length:");
      if (paramb2 == null) {
        break label466;
      }
    }
    label460:
    label466:
    for (int i = paramb2.oY.length;; i = 0)
    {
      y.i("MicroMsg.NetSceneAdClick", String.valueOf(i));
      localObject = (bb)this.dmK.ecE.ecN;
      ((bb)localObject).suB = paramInt1;
      ((bb)localObject).olm = paramString1;
      ((bb)localObject).scene = paramInt3;
      ((bb)localObject).suC = paramString2;
      paramString1 = (WifiManager)ae.getContext().getSystemService("wifi");
      if (paramString1 != null)
      {
        paramString1 = paramString1.getConnectionInfo();
        if (paramString1 != null)
        {
          ((bb)localObject).bssid = bk.aM(paramString1.getBSSID(), "");
          ((bb)localObject).ssid = bk.aM(paramString1.getSSID(), "");
        }
      }
      ((bb)localObject).suD = System.currentTimeMillis();
      ((bb)localObject).suF = paramInt4;
      ((bb)localObject).suG = paramInt2;
      ((bb)localObject).source = j;
      ((bb)localObject).suH = paramString3;
      ((bb)localObject).suI = paramInt5;
      if (paramb2 != null) {
        ((bb)localObject).suK = paramb2;
      }
      if (paramb1 != null) {
        ((bb)localObject).suJ = paramb1;
      }
      return;
      ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adclick";
      ((b.a)localObject).ecG = 1817;
      break;
      i = 0;
      break label231;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneAdClick", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1232;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.c
 * JD-Core Version:    0.7.0.1
 */