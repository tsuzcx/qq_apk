package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.c.j;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.protocal.protobuf.cd;
import com.tencent.mm.protocal.protobuf.ce;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.math.BigInteger;

public final class f
  extends p
  implements m
{
  public com.tencent.mm.am.h callback;
  private c rr;
  
  public f(long paramLong1, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4, String paramString3, int paramInt5, com.tencent.mm.bx.b paramb1, com.tencent.mm.bx.b paramb2, long paramLong2, String paramString4, String paramString5, a parama)
  {
    AppMethodBeat.i(309918);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cd();
    ((c.a)localObject).otF = new ce();
    int i = q.Qko.uw(paramLong1);
    if (i != 2)
    {
      ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/click";
      ((c.a)localObject).funcId = 1232;
    }
    for (;;)
    {
      ((c.a)localObject).otG = 0;
      ((c.a)localObject).respCmdId = 0;
      this.rr = ((c.a)localObject).bEF();
      Log.i("MicroMsg.NetSceneAdClick", "source %d, uri %s", new Object[] { Integer.valueOf(i), this.rr.getUri() });
      localObject = (cd)c.b.b(this.rr.otB);
      ((cd)localObject).YEd = paramInt1;
      ((cd)localObject).PWh = paramString1;
      ((cd)localObject).scene = paramInt3;
      ((cd)localObject).YEe = paramString2;
      ((cd)localObject).YEf = System.currentTimeMillis();
      ((cd)localObject).YEh = paramInt4;
      ((cd)localObject).YEi = paramInt2;
      ((cd)localObject).source = i;
      ((cd)localObject).YEj = paramString3;
      ((cd)localObject).YEk = paramInt5;
      ((cd)localObject).YEn = paramLong2;
      ((cd)localObject).PNk = com.tencent.mm.plugin.sns.ad.a.a.aPk();
      ((cd)localObject).imei = com.tencent.mm.plugin.sns.ad.a.a.gZB();
      ((cd)localObject).YEb = paramString4;
      ((cd)localObject).YEa = paramString5;
      if (paramb2 != null) {
        ((cd)localObject).YEm = paramb2;
      }
      if (paramb1 != null) {
        ((cd)localObject).YEl = paramb1;
      }
      ((cd)localObject).YEo = parama.PUP;
      ((cd)localObject).YEp = parama.PUO;
      ((cd)localObject).YEq = parama.PUN;
      ((cd)localObject).YDZ = com.tencent.mm.plugin.sns.ad.a.a.gZz();
      ((cd)localObject).YDY = com.tencent.mm.plugin.sns.ad.j.g.hcn();
      ((cd)localObject).YEr = parama.oTY;
      if (com.tencent.mm.ce.b.iRp())
      {
        i = 1;
        label335:
        ((cd)localObject).YEs = i;
        ((cd)localObject).YEt = com.tencent.mm.cd.a.mm(MMApplicationContext.getContext());
        ((cd)localObject).PUQ = parama.PUQ;
      }
      try
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1612, 53);
        parama = new StringBuilder();
        paramString2 = parama.append("##snsId:").append(new BigInteger(Long.toBinaryString(paramLong1), 2).toString()).append(", clickPos:").append(paramInt1).append(", clickAction:").append(paramInt2).append(", sceneType:").append(paramInt3).append(", descXml:").append(paramString2).append(", adtype:").append(paramInt4).append(", snsStatStr:").append(paramString3).append(", flipStatus:").append(paramInt5).append(", remind_source_info.length:");
        if (paramb1 == null)
        {
          paramInt1 = 0;
          label501:
          paramString2 = paramString2.append(paramInt1).append(", remind_self_info.length:");
          if (paramb2 != null) {
            break label841;
          }
          paramInt1 = 0;
          label524:
          paramString2.append(paramInt1).append(", exposure_start_time:").append(paramLong2).append(", followStatus:").append(((cd)localObject).YEp).append(", installStatus:").append(((cd)localObject).YEq).append(", videoCurTime:").append(((cd)localObject).YEo).append(", oaid:").append(((cd)localObject).PNk).append(", imei:").append(((cd)localObject).imei).append(", waidPkg:").append(paramString4).append(", waid:").append(paramString5).append(", ua:").append(((cd)localObject).YDY).append(", relieved_buy_show:").append(((cd)localObject).PUQ).append(", common_device_id:").append(((cd)localObject).YDZ).append(", sub_clickpos:").append(((cd)localObject).YEr).append(", elder_mode:").append(((cd)localObject).YEs).append(", font_level:").append(((cd)localObject).YEt);
          Log.i("MicroMsg.NetSceneAdClick", parama.toString());
          paramString2 = new StringBuilder("viewId.length=");
          if (paramString1 != null) {
            break label852;
          }
        }
        label841:
        label852:
        for (paramInt1 = 0;; paramInt1 = paramString1.length())
        {
          Log.i("MicroMsg.NetSceneAdClick", paramInt1 + ", viewId=" + paramString1);
          AppMethodBeat.o(309918);
          return;
          ((c.a)localObject).uri = "/cgi-bin/mmux-bin/adclick";
          ((c.a)localObject).funcId = 1817;
          break;
          i = 0;
          break label335;
          paramInt1 = paramb1.Op.length;
          break label501;
          paramInt1 = paramb2.Op.length;
          break label524;
        }
        return;
      }
      finally
      {
        Log.e("MicroMsg.NetSceneAdClick", paramString1.toString());
        AppMethodBeat.o(309918);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(125683);
    this.callback = paramh;
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
    Log.i("MicroMsg.NetSceneAdClick", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1612, 54);
    }
    try
    {
      params = (ce)c.c.b(this.rr.otC);
      Log.i("MicroMsg.NetSceneAdClick", "resp=" + params.ret + ", msg=" + params.msg);
      label133:
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(125684);
      return;
    }
    catch (Exception params)
    {
      break label133;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.f
 * JD-Core Version:    0.7.0.1
 */