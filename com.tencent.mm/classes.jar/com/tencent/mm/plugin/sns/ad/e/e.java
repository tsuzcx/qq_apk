package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.ad.f.d;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.protocal.protobuf.bq;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends n
  implements k
{
  public f callback;
  private com.tencent.mm.ak.b rr;
  
  public e(long paramLong1, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, String paramString3, int paramInt5, com.tencent.mm.bw.b paramb1, com.tencent.mm.bw.b paramb2, long paramLong2, String paramString4, String paramString5, a parama)
  {
    AppMethodBeat.i(218283);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bp();
    ((b.a)localObject).hQG = new bq();
    int i = o.zsB.zS(paramLong1);
    if (i != 2)
    {
      ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/click";
      ((b.a)localObject).funcId = 1232;
    }
    for (;;)
    {
      ((b.a)localObject).hQH = 0;
      ((b.a)localObject).respCmdId = 0;
      this.rr = ((b.a)localObject).aDS();
      ae.i("MicroMsg.NetSceneAdClick", "source %d, uri %s", new Object[] { Integer.valueOf(i), this.rr.getUri() });
      localObject = (bp)this.rr.hQD.hQJ;
      ((bp)localObject).FMi = paramInt1;
      ((bp)localObject).zpz = paramString1;
      ((bp)localObject).scene = paramInt3;
      ((bp)localObject).FMj = paramString2;
      ((bp)localObject).FMk = System.currentTimeMillis();
      ((bp)localObject).FMm = paramInt4;
      ((bp)localObject).FMn = paramInt2;
      ((bp)localObject).doj = i;
      ((bp)localObject).FMo = paramString3;
      ((bp)localObject).FMp = paramInt5;
      ((bp)localObject).FMs = paramLong2;
      ((bp)localObject).zmV = com.tencent.mm.plugin.sns.ad.a.a.aaL();
      ((bp)localObject).imei = com.tencent.mm.plugin.sns.ad.a.a.dUD();
      ((bp)localObject).FMg = paramString4;
      ((bp)localObject).FMf = paramString5;
      if (paramb2 != null) {
        ((bp)localObject).FMr = paramb2;
      }
      if (paramb1 != null) {
        ((bp)localObject).FMq = paramb1;
      }
      ((bp)localObject).FMt = parama.zof;
      ((bp)localObject).FMu = parama.zoe;
      ((bp)localObject).FMv = parama.zod;
      ((bp)localObject).FMe = com.tencent.mm.plugin.sns.ad.a.a.dUB();
      ((bp)localObject).FMd = d.dVE();
      try
      {
        parama = new StringBuilder();
        paramString2 = parama.append("##snsId:").append(paramLong1).append(", clickPos:").append(paramInt1).append(", clickAction:").append(paramInt2).append(", sceneType:").append(paramInt3).append(", descXml:").append(paramString2).append(", adtype:").append(paramInt4).append(", snsStatStr:").append(paramString3).append(", flipStatus:").append(paramInt5).append(", remind_source_info.length:");
        if (paramb1 == null)
        {
          paramInt1 = 0;
          label421:
          paramString2 = paramString2.append(paramInt1).append(", remind_self_info.length:");
          if (paramb2 != null) {
            break label665;
          }
          paramInt1 = 0;
          label443:
          paramString2.append(paramInt1).append(", exposure_start_time:").append(paramLong2).append(", followStatus:").append(((bp)localObject).FMu).append(", installStatus:").append(((bp)localObject).FMv).append(", videoCurTime:").append(((bp)localObject).FMt).append(", oaid:").append(((bp)localObject).zmV).append(", imei:").append(((bp)localObject).imei).append(", waidPkg:").append(paramString4).append(", waid:").append(paramString5).append(", ua:").append(((bp)localObject).FMd).append(", common_device_id:").append(((bp)localObject).FMe);
          ae.i("MicroMsg.NetSceneAdClick", parama.toString());
          paramString2 = new StringBuilder("viewId.length=");
          if (paramString1 != null) {
            break label676;
          }
        }
        label665:
        label676:
        for (paramInt1 = 0;; paramInt1 = paramString1.length())
        {
          ae.i("MicroMsg.NetSceneAdClick", paramInt1 + ", viewId=" + paramString1);
          AppMethodBeat.o(218283);
          return;
          ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adclick";
          ((b.a)localObject).funcId = 1817;
          break;
          paramInt1 = paramb1.zr.length;
          break label421;
          paramInt1 = paramb2.zr.length;
          break label443;
        }
        return;
      }
      catch (Throwable paramString1)
      {
        ae.e("MicroMsg.NetSceneAdClick", paramString1.toString());
        AppMethodBeat.o(218283);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(125683);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(125683);
    return i;
  }
  
  public final int getType()
  {
    return 1232;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125684);
    ae.d("MicroMsg.NetSceneAdClick", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.e
 * JD-Core Version:    0.7.0.1
 */