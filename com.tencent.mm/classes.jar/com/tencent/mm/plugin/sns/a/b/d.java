package com.tencent.mm.plugin.sns.a.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bf;
import com.tencent.mm.protocal.c.bg;
import com.tencent.mm.protocal.c.bh;
import com.tencent.mm.protocal.c.bi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  public f dmL;
  
  public d(String paramString1, int paramInt1, int paramInt2, int paramInt3, bf parambf, bi parambi, int paramInt4, String paramString2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, com.tencent.mm.bv.b paramb1, com.tencent.mm.bv.b paramb2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bg();
    ((b.a)localObject).ecI = new bh();
    if (paramInt6 != 2)
    {
      ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/exposure";
      ((b.a)localObject).ecG = 1231;
      ((b.a)localObject).ecJ = 0;
      ((b.a)localObject).ecK = 0;
      this.dmK = ((b.a)localObject).Kt();
      y.i("MicroMsg.NetSceneAdExposure", "uri %s", new Object[] { this.dmK.uri });
      localObject = (bg)this.dmK.ecE.ecN;
      ((bg)localObject).suT = paramInt3;
      ((bg)localObject).type = paramInt2;
      ((bg)localObject).scene = paramInt1;
      ((bg)localObject).olm = paramString1;
      ((bg)localObject).suW = paramInt5;
      ((bg)localObject).suX = paramInt7;
      ((bg)localObject).suY = paramInt8;
      ((bg)localObject).suI = paramInt9;
      if (parambf != null)
      {
        ((bg)localObject).suU = parambf;
        y.i("MicroMsg.NetSceneAdExposure", "exposure_info " + parambf.suR);
      }
      if (parambi != null)
      {
        ((bg)localObject).suV = parambi;
        y.i("MicroMsg.NetSceneAdExposure", "social_info " + parambi.suZ + " " + parambi.like_count);
      }
      parambf = (WifiManager)ae.getContext().getSystemService("wifi");
      if (parambf != null)
      {
        parambf = parambf.getConnectionInfo();
        if (parambf != null)
        {
          ((bg)localObject).bssid = bk.aM(parambf.getBSSID(), "");
          ((bg)localObject).ssid = bk.aM(parambf.getSSID(), "");
        }
      }
      ((bg)localObject).suD = System.currentTimeMillis();
      ((bg)localObject).suF = paramInt4;
      if (paramString2 != null) {
        ((bg)localObject).suC = paramString2;
      }
      if (paramb2 != null) {
        ((bg)localObject).suK = paramb2;
      }
      if (paramb1 != null) {
        ((bg)localObject).suJ = paramb1;
      }
      paramString1 = new StringBuilder("##viewid:").append(paramString1).append(" scene:").append(paramInt1).append(" exposureScene:").append(paramInt2).append(" duration:").append(paramInt3).append(" feed_duration:").append(paramInt7).append(" feed_full_duration:").append(paramInt8).append(" ad_type:").append(paramInt4).append(" exposureCount:").append(paramInt5).append(" descXml:").append(paramString2).append(" flip_status:").append(paramInt9).append(" self_info.length:");
      if (paramb2 != null) {
        break label530;
      }
      paramInt1 = 0;
      label480:
      paramString1 = paramString1.append(paramInt1).append(" source_info.length:");
      if (paramb1 != null) {
        break label540;
      }
    }
    label530:
    label540:
    for (paramInt1 = 0;; paramInt1 = paramb1.oY.length)
    {
      y.i("MicroMsg.NetSceneAdExposure", paramInt1);
      return;
      ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adexposure";
      ((b.a)localObject).ecG = 1875;
      break;
      paramInt1 = paramb2.oY.length;
      break label480;
    }
  }
  
  public d(String paramString, int paramInt1, bi parambi, int paramInt2, int paramInt3, int paramInt4, com.tencent.mm.bv.b paramb1, com.tencent.mm.bv.b paramb2)
  {
    this(paramString, paramInt1, 1, 0, null, parambi, paramInt2, "", paramInt3, paramInt4, 0, 0, 0, paramb1, paramb2);
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneAdExposure", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (bh)this.dmK.ecF.ecN;
    y.i("MicroMsg.NetSceneAdExposure", "resp " + paramq.ret + " msg: " + paramq.bHk);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1231;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.d
 * JD-Core Version:    0.7.0.1
 */