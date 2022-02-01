package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.bu;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  extends q
  implements m
{
  public com.tencent.mm.an.i callback;
  private d rr;
  
  public f(long paramLong1, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, String paramString3, int paramInt5, b paramb1, b paramb2, long paramLong2, String paramString4, String paramString5, a parama)
  {
    AppMethodBeat.i(261340);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bt();
    ((d.a)localObject).lBV = new bu();
    int i = p.JPi.Qr(paramLong1);
    if (i != 2)
    {
      ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/click";
      ((d.a)localObject).funcId = 1232;
    }
    for (;;)
    {
      ((d.a)localObject).lBW = 0;
      ((d.a)localObject).respCmdId = 0;
      this.rr = ((d.a)localObject).bgN();
      Log.i("MicroMsg.NetSceneAdClick", "source %d, uri %s", new Object[] { Integer.valueOf(i), this.rr.getUri() });
      localObject = (bt)d.b.b(this.rr.lBR);
      ((bt)localObject).RHc = paramInt1;
      ((bt)localObject).JFg = paramString1;
      ((bt)localObject).scene = paramInt3;
      ((bt)localObject).RHd = paramString2;
      ((bt)localObject).RHe = System.currentTimeMillis();
      ((bt)localObject).RHg = paramInt4;
      ((bt)localObject).RHh = paramInt2;
      ((bt)localObject).source = i;
      ((bt)localObject).RHi = paramString3;
      ((bt)localObject).RHj = paramInt5;
      ((bt)localObject).RHm = paramLong2;
      ((bt)localObject).JyL = com.tencent.mm.plugin.sns.ad.a.a.auQ();
      ((bt)localObject).imei = com.tencent.mm.plugin.sns.ad.a.a.fJH();
      ((bt)localObject).RGZ = paramString4;
      ((bt)localObject).RGY = paramString5;
      if (paramb2 != null) {
        ((bt)localObject).RHl = paramb2;
      }
      if (paramb1 != null) {
        ((bt)localObject).RHk = paramb1;
      }
      ((bt)localObject).RHn = parama.JDP;
      ((bt)localObject).RHo = parama.JDO;
      ((bt)localObject).RHp = parama.JDN;
      ((bt)localObject).RGX = com.tencent.mm.plugin.sns.ad.a.a.fJF();
      ((bt)localObject).RGW = com.tencent.mm.plugin.sns.ad.i.g.fLT();
      ((bt)localObject).RHq = parama.mbe;
      try
      {
        parama = new StringBuilder();
        paramString2 = parama.append("##snsId:").append(paramLong1).append(", clickPos:").append(paramInt1).append(", clickAction:").append(paramInt2).append(", sceneType:").append(paramInt3).append(", descXml:").append(paramString2).append(", adtype:").append(paramInt4).append(", snsStatStr:").append(paramString3).append(", flipStatus:").append(paramInt5).append(", remind_source_info.length:");
        if (paramb1 == null)
        {
          paramInt1 = 0;
          label431:
          paramString2 = paramString2.append(paramInt1).append(", remind_self_info.length:");
          if (paramb2 != null) {
            break label692;
          }
          paramInt1 = 0;
          label453:
          paramString2.append(paramInt1).append(", exposure_start_time:").append(paramLong2).append(", followStatus:").append(((bt)localObject).RHo).append(", installStatus:").append(((bt)localObject).RHp).append(", videoCurTime:").append(((bt)localObject).RHn).append(", oaid:").append(((bt)localObject).JyL).append(", imei:").append(((bt)localObject).imei).append(", waidPkg:").append(paramString4).append(", waid:").append(paramString5).append(", ua:").append(((bt)localObject).RGW).append(", common_device_id:").append(((bt)localObject).RGX).append(", sub_clickpos:").append(((bt)localObject).RHq);
          Log.i("MicroMsg.NetSceneAdClick", parama.toString());
          paramString2 = new StringBuilder("viewId.length=");
          if (paramString1 != null) {
            break label703;
          }
        }
        label692:
        label703:
        for (paramInt1 = 0;; paramInt1 = paramString1.length())
        {
          Log.i("MicroMsg.NetSceneAdClick", paramInt1 + ", viewId=" + paramString1);
          AppMethodBeat.o(261340);
          return;
          ((d.a)localObject).uri = "/cgi-bin/mmux-bin/adclick";
          ((d.a)localObject).funcId = 1817;
          break;
          paramInt1 = paramb1.UH.length;
          break label431;
          paramInt1 = paramb2.UH.length;
          break label453;
        }
        return;
      }
      catch (Throwable paramString1)
      {
        Log.e("MicroMsg.NetSceneAdClick", paramString1.toString());
        AppMethodBeat.o(261340);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(125683);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(125683);
    return i;
  }
  
  public final int getType()
  {
    return 1232;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(125684);
    Log.d("MicroMsg.NetSceneAdClick", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(125684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.f
 * JD-Core Version:    0.7.0.1
 */