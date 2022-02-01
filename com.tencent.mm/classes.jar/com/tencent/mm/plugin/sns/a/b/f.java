package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.waid.h;
import com.tencent.mm.protocal.protobuf.br;
import com.tencent.mm.protocal.protobuf.bs;
import com.tencent.mm.protocal.protobuf.bu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.ai;

public final class f
  extends n
  implements k
{
  public com.tencent.mm.al.g callback;
  private com.tencent.mm.al.b rr;
  
  public f(String paramString1, int paramInt1, int paramInt2, int paramInt3, br parambr, bu parambu, int paramInt4, String paramString2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, com.tencent.mm.bx.b paramb1, com.tencent.mm.bx.b paramb2, String paramString3, b paramb)
  {
    AppMethodBeat.i(187232);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bs();
    ((b.a)localObject).gUV = new com.tencent.mm.protocal.protobuf.bt();
    String str;
    if (paramInt6 != 2)
    {
      ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/exposure";
      ((b.a)localObject).funcId = 1231;
      ((b.a)localObject).reqCmdId = 0;
      ((b.a)localObject).respCmdId = 0;
      this.rr = ((b.a)localObject).atI();
      ad.i("MicroMsg.NetSceneAdExposure", "uri %s", new Object[] { this.rr.getUri() });
      localObject = (bs)this.rr.gUS.gUX;
      ((bs)localObject).CwA = paramInt3;
      ((bs)localObject).type = paramInt2;
      ((bs)localObject).scene = paramInt1;
      ((bs)localObject).wyi = paramString1;
      ((bs)localObject).CwD = paramInt5;
      ((bs)localObject).CwE = paramInt7;
      ((bs)localObject).CwF = paramInt8;
      ((bs)localObject).Cwj = paramInt9;
      ((bs)localObject).Cwn = com.tencent.mm.compatible.deviceinfo.q.getOAID();
      str = com.tencent.mm.sdk.platformtools.bt.nullAsNil(paramString3);
      ((bs)localObject).Cwo = str;
      paramString3 = com.tencent.mm.plugin.sns.waid.g.aqU(str);
      if (paramString3 != null) {
        break label899;
      }
      paramString3 = "";
      label213:
      ((bs)localObject).xZu = paramString3;
      if (parambr != null)
      {
        ((bs)localObject).CwB = parambr;
        ad.i("MicroMsg.NetSceneAdExposure", "exposure_info " + parambr.Cwy);
      }
      if (parambu != null)
      {
        ((bs)localObject).CwC = parambu;
        ad.i("MicroMsg.NetSceneAdExposure", "social_info " + parambu.CwO + " " + parambu.CwN);
      }
      ((bs)localObject).bssid = ay.iB(aj.getContext());
      ((bs)localObject).ssid = ay.iA(aj.getContext());
      ((bs)localObject).Cwe = System.currentTimeMillis();
      ((bs)localObject).Cwg = paramInt4;
      if (paramString2 != null) {
        ((bs)localObject).Cwd = paramString2;
      }
      if (paramb2 != null) {
        ((bs)localObject).Cwl = paramb2;
      }
      if (paramb1 != null) {
        ((bs)localObject).Cwk = paramb1;
      }
      if (paramb != null)
      {
        if (b.kvn == 0)
        {
          parambr = al.fU(aj.getContext());
          b.kvn = parambr[0];
          b.kvo = parambr[1];
        }
        ((bs)localObject).CwG = b.kvn;
        if (b.kvo == 0)
        {
          parambr = al.fU(aj.getContext());
          b.kvn = parambr[0];
          b.kvo = parambr[1];
        }
        ((bs)localObject).CwH = b.kvo;
        ((bs)localObject).CwI = paramb.wwQ;
        if (!ai.Eq()) {
          break label909;
        }
        paramInt6 = 2;
        label479:
        ((bs)localObject).CwJ = paramInt6;
        ((bs)localObject).CwK = paramb.wwR;
        ((bs)localObject).CwL = paramb.wwS;
        ((bs)localObject).Cwq = j.j(paramb.wwP);
        ((bs)localObject).Cwr = j.i(paramb.wwP);
        ((bs)localObject).CwM = paramb.wwO;
      }
      parambr = new StringBuilder();
      paramString1 = parambr.append("##viewid:").append(paramString1).append(", scene:").append(paramInt1).append(", exposureScene:").append(paramInt2).append(", duration:").append(paramInt3).append(", feed_duration:").append(paramInt7).append(", feed_full_duration:").append(paramInt8).append(", ad_type:").append(paramInt4).append(", exposureCount:").append(paramInt5).append(", descXml:").append(paramString2).append(", flip_status:").append(paramInt9).append(", self_info.length:");
      if (paramb2 != null) {
        break label915;
      }
      paramInt1 = 0;
      label674:
      paramString1 = paramString1.append(paramInt1).append(", source_info.length:");
      if (paramb1 != null) {
        break label925;
      }
    }
    label899:
    label909:
    label915:
    label925:
    for (paramInt1 = 0;; paramInt1 = paramb1.wA.length)
    {
      paramString1.append(paramInt1).append(", oaid=").append(((bs)localObject).Cwn).append(", waidPkg=").append(str).append(", waid=").append(((bs)localObject).xZu).append(", screen.w=").append(((bs)localObject).CwG).append(", screen.h=").append(((bs)localObject).CwH).append(", adView.h=").append(((bs)localObject).CwI).append(", darkMode=").append(((bs)localObject).CwJ).append(", halfDuration=").append(((bs)localObject).CwK).append(", fullDuration=").append(((bs)localObject).CwL).append(", followStatus=").append(((bs)localObject).Cwq).append(", installStatus=").append(((bs)localObject).Cwr).append(", timelineIdx=").append(((bs)localObject).CwM);
      ad.i("MicroMsg.NetSceneAdExposure", parambr.toString());
      AppMethodBeat.o(187232);
      return;
      ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adexposure";
      ((b.a)localObject).funcId = 1875;
      break;
      paramString3 = paramString3.xZu;
      break label213;
      paramInt6 = 1;
      break label479;
      paramInt1 = paramb2.wA.length;
      break label674;
    }
  }
  
  public f(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, com.tencent.mm.bx.b paramb1, com.tencent.mm.bx.b paramb2, String paramString3)
  {
    this(paramString1, paramInt1, 2, paramInt2, null, null, 2, paramString2, -1, paramInt3, paramInt4, paramInt5, 0, paramb1, paramb2, paramString3, null);
  }
  
  public f(String paramString1, int paramInt1, bu parambu, int paramInt2, int paramInt3, int paramInt4, com.tencent.mm.bx.b paramb1, com.tencent.mm.bx.b paramb2, String paramString2, b paramb)
  {
    this(paramString1, paramInt1, 1, 0, null, parambu, paramInt2, "", paramInt3, paramInt4, 0, 0, 0, paramb1, paramb2, paramString2, paramb);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(94980);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(94980);
    return i;
  }
  
  public final int getType()
  {
    return 1231;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94981);
    ad.i("MicroMsg.NetSceneAdExposure", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (com.tencent.mm.protocal.protobuf.bt)this.rr.gUT.gUX;
    ad.i("MicroMsg.NetSceneAdExposure", "resp " + paramq.ret + " msg: " + paramq.bLg);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.b.f
 * JD-Core Version:    0.7.0.1
 */