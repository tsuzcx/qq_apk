package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.protocal.protobuf.bq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;

public final class e
  extends n
  implements k
{
  public g callback;
  private com.tencent.mm.ak.b rr;
  
  public e(long paramLong1, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, String paramString3, int paramInt5, com.tencent.mm.bw.b paramb1, com.tencent.mm.bw.b paramb2, long paramLong2, String paramString4, String paramString5, a parama)
  {
    AppMethodBeat.i(198624);
    Object localObject1 = new b.a();
    ((b.a)localObject1).hvt = new bp();
    ((b.a)localObject1).hvu = new bq();
    int j = o.xMg.wT(paramLong1);
    String str;
    Object localObject2;
    if (j != 2)
    {
      ((b.a)localObject1).uri = "/cgi-bin/mmoc-bin/ad/click";
      ((b.a)localObject1).funcId = 1232;
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      this.rr = ((b.a)localObject1).aAz();
      localObject1 = com.tencent.mm.compatible.deviceinfo.q.getOAID();
      str = com.tencent.mm.compatible.deviceinfo.q.cF(false);
      ac.i("MicroMsg.NetSceneAdClick", "source %d, uri %s", new Object[] { Integer.valueOf(j), this.rr.getUri() });
      localObject2 = new StringBuilder("snsId:").append(paramLong1).append(", viewId:").append(paramString1).append(", clickPos:").append(paramInt1).append(", clickAction:").append(paramInt2).append(", sceneType:").append(paramInt3).append(", descXml:").append(paramString2).append(", adtype:").append(paramInt4).append(", snsStatStr:").append(paramString3).append(", flipStatus:").append(paramInt5).append(", remind_source_info.length:");
      if (paramb1 == null) {
        break label605;
      }
      i = paramb1.xy.length;
      label247:
      localObject2 = ((StringBuilder)localObject2).append(String.valueOf(i)).append(", remind_self_info.length:");
      if (paramb2 == null) {
        break label611;
      }
    }
    label605:
    label611:
    for (int i = paramb2.xy.length;; i = 0)
    {
      ac.i("MicroMsg.NetSceneAdClick", String.valueOf(i) + ", exposure_start_time:" + paramLong2 + ", oaid:" + (String)localObject1 + ", imei:" + str + ", waidPkg:" + paramString4 + ", waid:" + paramString5 + ", followStatus:" + parama.xIn + ", installStatus:" + parama.xIm + ", videoCurTime:" + parama.xIo);
      localObject2 = (bp)this.rr.hvr.hvw;
      ((bp)localObject2).DOz = paramInt1;
      ((bp)localObject2).xJJ = paramString1;
      ((bp)localObject2).scene = paramInt3;
      ((bp)localObject2).DOA = paramString2;
      ((bp)localObject2).bssid = ax.iM(ai.getContext());
      ((bp)localObject2).ssid = ax.iL(ai.getContext());
      ((bp)localObject2).DOB = System.currentTimeMillis();
      ((bp)localObject2).DOD = paramInt4;
      ((bp)localObject2).DOE = paramInt2;
      ((bp)localObject2).dbL = j;
      ((bp)localObject2).DOF = paramString3;
      ((bp)localObject2).DOG = paramInt5;
      ((bp)localObject2).DOJ = paramLong2;
      ((bp)localObject2).DOw = ((String)localObject1);
      ((bp)localObject2).imei = str;
      ((bp)localObject2).DOK = paramString4;
      ((bp)localObject2).zmu = paramString5;
      if (paramb2 != null) {
        ((bp)localObject2).DOI = paramb2;
      }
      if (paramb1 != null) {
        ((bp)localObject2).DOH = paramb1;
      }
      ((bp)localObject2).DOL = parama.xIo;
      ((bp)localObject2).DOM = parama.xIn;
      ((bp)localObject2).DON = parama.xIm;
      AppMethodBeat.o(198624);
      return;
      ((b.a)localObject1).uri = "/cgi-bin/mmux-bin/adclick";
      ((b.a)localObject1).funcId = 1817;
      break;
      i = 0;
      break label247;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(125683);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(125683);
    return i;
  }
  
  public final int getType()
  {
    return 1232;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125684);
    ac.d("MicroMsg.NetSceneAdClick", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.e
 * JD-Core Version:    0.7.0.1
 */