package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.waid.h;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.bu;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;

public final class f
  extends n
  implements k
{
  public com.tencent.mm.ak.g callback;
  private com.tencent.mm.ak.b rr;
  
  public f(String paramString1, int paramInt1, int paramInt2, int paramInt3, bt parambt, bw parambw, int paramInt4, String paramString2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, com.tencent.mm.bw.b paramb1, com.tencent.mm.bw.b paramb2, String paramString3, b paramb)
  {
    AppMethodBeat.i(199958);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bu();
    ((b.a)localObject).hvu = new bv();
    String str;
    if (paramInt6 != 2)
    {
      ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/exposure";
      ((b.a)localObject).funcId = 1231;
      ((b.a)localObject).reqCmdId = 0;
      ((b.a)localObject).respCmdId = 0;
      this.rr = ((b.a)localObject).aAz();
      ac.i("MicroMsg.NetSceneAdExposure", "uri %s", new Object[] { this.rr.getUri() });
      localObject = (bu)this.rr.hvr.hvw;
      ((bu)localObject).DOW = paramInt3;
      ((bu)localObject).type = paramInt2;
      ((bu)localObject).scene = paramInt1;
      ((bu)localObject).xJJ = paramString1;
      ((bu)localObject).DOZ = paramInt5;
      ((bu)localObject).DPa = paramInt7;
      ((bu)localObject).DPb = paramInt8;
      ((bu)localObject).DOG = paramInt9;
      ((bu)localObject).DOw = com.tencent.mm.compatible.deviceinfo.q.getOAID();
      ((bu)localObject).imei = com.tencent.mm.compatible.deviceinfo.q.cF(false);
      str = bs.nullAsNil(paramString3);
      ((bu)localObject).DOK = str;
      paramString3 = com.tencent.mm.plugin.sns.waid.g.awd(str);
      if (paramString3 != null) {
        break label858;
      }
      paramString3 = "";
      label222:
      ((bu)localObject).zmu = paramString3;
      if (parambt != null)
      {
        ((bu)localObject).DOX = parambt;
        ac.i("MicroMsg.NetSceneAdExposure", "exposure_info " + parambt.DOU);
      }
      if (parambw != null)
      {
        ((bu)localObject).DOY = parambw;
        ac.i("MicroMsg.NetSceneAdExposure", "social_info " + parambw.DPk + " " + parambw.DPj);
      }
      ((bu)localObject).bssid = ax.iM(ai.getContext());
      ((bu)localObject).ssid = ax.iL(ai.getContext());
      ((bu)localObject).DOB = System.currentTimeMillis();
      ((bu)localObject).DOD = paramInt4;
      if (paramString2 != null) {
        ((bu)localObject).DOA = paramString2;
      }
      if (paramb2 != null) {
        ((bu)localObject).DOI = paramb2;
      }
      if (paramb1 != null) {
        ((bu)localObject).DOH = paramb1;
      }
      if (paramb != null)
      {
        ((bu)localObject).DPc = b.getScreenWidth();
        ((bu)localObject).DPd = b.getScreenHeight();
        ((bu)localObject).DPe = paramb.xIr;
        ((bu)localObject).DPf = b.dFE();
        ((bu)localObject).DPg = paramb.xIs;
        ((bu)localObject).DPh = paramb.xIt;
        ((bu)localObject).DOM = j.j(paramb.xIq);
        ((bu)localObject).DON = j.i(paramb.xIq);
        ((bu)localObject).DPi = paramb.xIp;
      }
      parambt = new StringBuilder();
      paramString1 = parambt.append("##viewid:").append(paramString1).append(", scene:").append(paramInt1).append(", exposureScene:").append(paramInt2).append(", duration:").append(paramInt3).append(", feed_duration:").append(paramInt7).append(", feed_full_duration:").append(paramInt8).append(", ad_type:").append(paramInt4).append(", exposureCount:").append(paramInt5).append(", descXml:").append(paramString2).append(", flip_status:").append(paramInt9).append(", self_info.length:");
      if (paramb2 != null) {
        break label868;
      }
      paramInt1 = 0;
      label619:
      paramString1 = paramString1.append(paramInt1).append(", source_info.length:");
      if (paramb1 != null) {
        break label878;
      }
    }
    label858:
    label868:
    label878:
    for (paramInt1 = 0;; paramInt1 = paramb1.xy.length)
    {
      paramString1.append(paramInt1).append(", oaid=").append(((bu)localObject).DOw).append(", imei=").append(((bu)localObject).imei).append(", waidPkg=").append(str).append(", waid=").append(((bu)localObject).zmu).append(", screen.w=").append(((bu)localObject).DPc).append(", screen.h=").append(((bu)localObject).DPd).append(", adView.h=").append(((bu)localObject).DPe).append(", darkMode=").append(((bu)localObject).DPf).append(", halfDuration=").append(((bu)localObject).DPg).append(", fullDuration=").append(((bu)localObject).DPh).append(", followStatus=").append(((bu)localObject).DOM).append(", installStatus=").append(((bu)localObject).DON).append(", timelineIdx=").append(((bu)localObject).DPi);
      ac.i("MicroMsg.NetSceneAdExposure", parambt.toString());
      AppMethodBeat.o(199958);
      return;
      ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adexposure";
      ((b.a)localObject).funcId = 1875;
      break;
      paramString3 = paramString3.zmu;
      break label222;
      paramInt1 = paramb2.xy.length;
      break label619;
    }
  }
  
  public f(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, com.tencent.mm.bw.b paramb1, com.tencent.mm.bw.b paramb2, String paramString3)
  {
    this(paramString1, paramInt1, 2, paramInt2, null, null, 2, paramString2, -1, paramInt3, paramInt4, paramInt5, 0, paramb1, paramb2, paramString3, null);
  }
  
  public f(String paramString1, int paramInt1, bw parambw, int paramInt2, int paramInt3, int paramInt4, com.tencent.mm.bw.b paramb1, com.tencent.mm.bw.b paramb2, String paramString2, b paramb)
  {
    this(paramString1, paramInt1, 1, 0, null, parambw, paramInt2, "", paramInt3, paramInt4, 0, 0, 0, paramb1, paramb2, paramString2, paramb);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
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
    ac.i("MicroMsg.NetSceneAdExposure", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (bv)this.rr.hvs.hvw;
    ac.i("MicroMsg.NetSceneAdExposure", "resp " + paramq.ret + " msg: " + paramq.bIO);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.f
 * JD-Core Version:    0.7.0.1
 */