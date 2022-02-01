package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.sns.c.h;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;

public final class e
  extends n
  implements k
{
  public g callback;
  private com.tencent.mm.al.b rr;
  
  public e(long paramLong1, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, String paramString3, int paramInt5, com.tencent.mm.bx.b paramb1, com.tencent.mm.bx.b paramb2, long paramLong2, String paramString4, String paramString5, a parama)
  {
    AppMethodBeat.i(192554);
    Object localObject1 = new b.a();
    ((b.a)localObject1).gUU = new bn();
    ((b.a)localObject1).gUV = new bo();
    int j = o.wzM.sq(paramLong1);
    Object localObject2;
    if (j != 2)
    {
      ((b.a)localObject1).uri = "/cgi-bin/mmoc-bin/ad/click";
      ((b.a)localObject1).funcId = 1232;
      ((b.a)localObject1).reqCmdId = 0;
      ((b.a)localObject1).respCmdId = 0;
      this.rr = ((b.a)localObject1).atI();
      localObject1 = com.tencent.mm.compatible.deviceinfo.q.getOAID();
      ad.i("MicroMsg.NetSceneAdClick", "source %d, uri %s", new Object[] { Integer.valueOf(j), this.rr.getUri() });
      localObject2 = new StringBuilder("snsId:").append(paramLong1).append(", viewId:").append(paramString1).append(", clickPos:").append(paramInt1).append(", clickAction:").append(paramInt2).append(", sceneType:").append(paramInt3).append(", descXml:").append(paramString2).append(", adtype:").append(paramInt4).append(", snsStatStr:").append(paramString3).append(", flipStatus:").append(paramInt5).append(", remind_source_info.length:");
      if (paramb1 == null) {
        break label582;
      }
      i = paramb1.wA.length;
      label241:
      localObject2 = ((StringBuilder)localObject2).append(String.valueOf(i)).append(", remind_self_info.length:");
      if (paramb2 == null) {
        break label588;
      }
    }
    label582:
    label588:
    for (int i = paramb2.wA.length;; i = 0)
    {
      ad.i("MicroMsg.NetSceneAdClick", String.valueOf(i) + ", exposure_start_time:" + paramLong2 + ", oaid:" + (String)localObject1 + ", waidPkg:" + paramString4 + ", waid:" + paramString5 + ", followStatus:" + parama.wwM + ", installStatus:" + parama.wwL + ", videoCurTime:" + parama.wwN);
      localObject2 = (bn)this.rr.gUS.gUX;
      ((bn)localObject2).Cwc = paramInt1;
      ((bn)localObject2).wyi = paramString1;
      ((bn)localObject2).scene = paramInt3;
      ((bn)localObject2).Cwd = paramString2;
      ((bn)localObject2).bssid = ay.iB(aj.getContext());
      ((bn)localObject2).ssid = ay.iA(aj.getContext());
      ((bn)localObject2).Cwe = System.currentTimeMillis();
      ((bn)localObject2).Cwg = paramInt4;
      ((bn)localObject2).Cwh = paramInt2;
      ((bn)localObject2).dep = j;
      ((bn)localObject2).Cwi = paramString3;
      ((bn)localObject2).Cwj = paramInt5;
      ((bn)localObject2).Cwm = paramLong2;
      ((bn)localObject2).Cwn = ((String)localObject1);
      ((bn)localObject2).Cwo = paramString4;
      ((bn)localObject2).xZu = paramString5;
      if (paramb2 != null) {
        ((bn)localObject2).Cwl = paramb2;
      }
      if (paramb1 != null) {
        ((bn)localObject2).Cwk = paramb1;
      }
      ((bn)localObject2).Cwp = parama.wwN;
      ((bn)localObject2).Cwq = parama.wwM;
      ((bn)localObject2).Cwr = parama.wwL;
      AppMethodBeat.o(192554);
      return;
      ((b.a)localObject1).uri = "/cgi-bin/mmux-bin/adclick";
      ((b.a)localObject1).funcId = 1817;
      break;
      i = 0;
      break label241;
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
    ad.d("MicroMsg.NetSceneAdClick", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.e
 * JD-Core Version:    0.7.0.1
 */