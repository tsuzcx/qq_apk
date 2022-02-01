package com.tencent.mm.plugin.sns.ad.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.ad.a.a;
import com.tencent.mm.plugin.sns.ad.f.d;
import com.tencent.mm.protocal.protobuf.bt;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.sdk.platformtools.ae;

public final class f
  extends n
  implements com.tencent.mm.network.k
{
  public com.tencent.mm.ak.f callback;
  private com.tencent.mm.ak.b rr;
  
  public f(String paramString1, int paramInt1, int paramInt2, int paramInt3, bt parambt, bw parambw, int paramInt4, String paramString2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, com.tencent.mm.bw.b paramb1, com.tencent.mm.bw.b paramb2, String paramString3, b paramb)
  {
    AppMethodBeat.i(219063);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new com.tencent.mm.protocal.protobuf.bu();
    ((b.a)localObject).hQG = new bv();
    if (paramInt6 != 2)
    {
      ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/exposure";
      ((b.a)localObject).funcId = 1231;
    }
    for (;;)
    {
      ((b.a)localObject).hQH = 0;
      ((b.a)localObject).respCmdId = 0;
      this.rr = ((b.a)localObject).aDS();
      ae.i("MicroMsg.NetSceneAdExposure", "uri %s", new Object[] { this.rr.getUri() });
      localObject = (com.tencent.mm.protocal.protobuf.bu)this.rr.hQD.hQJ;
      ((com.tencent.mm.protocal.protobuf.bu)localObject).FME = paramInt3;
      ((com.tencent.mm.protocal.protobuf.bu)localObject).type = paramInt2;
      ((com.tencent.mm.protocal.protobuf.bu)localObject).scene = paramInt1;
      ((com.tencent.mm.protocal.protobuf.bu)localObject).zpz = paramString1;
      ((com.tencent.mm.protocal.protobuf.bu)localObject).FMH = paramInt5;
      ((com.tencent.mm.protocal.protobuf.bu)localObject).FMI = paramInt7;
      ((com.tencent.mm.protocal.protobuf.bu)localObject).FMJ = paramInt8;
      ((com.tencent.mm.protocal.protobuf.bu)localObject).FMp = paramInt9;
      ((com.tencent.mm.protocal.protobuf.bu)localObject).zmV = a.aaL();
      ((com.tencent.mm.protocal.protobuf.bu)localObject).imei = a.dUD();
      paramString3 = com.tencent.mm.sdk.platformtools.bu.nullAsNil(paramString3);
      ((com.tencent.mm.protocal.protobuf.bu)localObject).FMg = paramString3;
      ((com.tencent.mm.protocal.protobuf.bu)localObject).FMf = com.tencent.mm.plugin.sns.waid.b.aCC(paramString3);
      if (parambt != null)
      {
        ((com.tencent.mm.protocal.protobuf.bu)localObject).FMF = parambt;
        ae.i("MicroMsg.NetSceneAdExposure", "exposure_info " + parambt.FMC);
      }
      if (parambw != null)
      {
        ((com.tencent.mm.protocal.protobuf.bu)localObject).FMG = parambw;
        ae.i("MicroMsg.NetSceneAdExposure", "socialInfo, commentCount=" + parambw.FMS + ", likeCount=" + parambw.FMR);
      }
      ((com.tencent.mm.protocal.protobuf.bu)localObject).FMk = System.currentTimeMillis();
      ((com.tencent.mm.protocal.protobuf.bu)localObject).FMm = paramInt4;
      if (paramString2 != null) {
        ((com.tencent.mm.protocal.protobuf.bu)localObject).FMj = paramString2;
      }
      if (paramb2 != null) {
        ((com.tencent.mm.protocal.protobuf.bu)localObject).FMr = paramb2;
      }
      if (paramb1 != null) {
        ((com.tencent.mm.protocal.protobuf.bu)localObject).FMq = paramb1;
      }
      if (paramb != null)
      {
        ((com.tencent.mm.protocal.protobuf.bu)localObject).FMK = b.getScreenWidth();
        ((com.tencent.mm.protocal.protobuf.bu)localObject).FML = b.getScreenHeight();
        ((com.tencent.mm.protocal.protobuf.bu)localObject).FMM = paramb.zoh;
        ((com.tencent.mm.protocal.protobuf.bu)localObject).FMN = b.dUU();
        ((com.tencent.mm.protocal.protobuf.bu)localObject).FMO = paramb.zoi;
        ((com.tencent.mm.protocal.protobuf.bu)localObject).FMP = paramb.zoj;
        ((com.tencent.mm.protocal.protobuf.bu)localObject).FMu = com.tencent.mm.plugin.sns.data.k.l(paramb.znm);
        ((com.tencent.mm.protocal.protobuf.bu)localObject).FMv = com.tencent.mm.plugin.sns.data.k.k(paramb.znm);
        ((com.tencent.mm.protocal.protobuf.bu)localObject).FMQ = paramb.zog;
      }
      ((com.tencent.mm.protocal.protobuf.bu)localObject).FMe = a.dUB();
      ((com.tencent.mm.protocal.protobuf.bu)localObject).FMd = d.dVE();
      try
      {
        parambt = new StringBuilder();
        parambw = parambt.append("##scene:").append(paramInt1).append(", exposureScene:").append(paramInt2).append(", duration:").append(paramInt3).append(", feed_duration:").append(paramInt7).append(", feed_full_duration:").append(paramInt8).append(", ad_type:").append(paramInt4).append(", exposureCount:").append(paramInt5).append(", descXml:").append(paramString2).append(", flip_status:").append(paramInt9).append(", self_info.length:");
        if (paramb2 == null)
        {
          paramInt1 = 0;
          label590:
          parambw = parambw.append(paramInt1).append(", source_info.length:");
          if (paramb1 != null) {
            break label938;
          }
          paramInt1 = 0;
          label611:
          parambw = parambw.append(paramInt1).append(", screen.w=").append(((com.tencent.mm.protocal.protobuf.bu)localObject).FMK).append(", screen.h=").append(((com.tencent.mm.protocal.protobuf.bu)localObject).FML).append(", adView.h=").append(((com.tencent.mm.protocal.protobuf.bu)localObject).FMM).append(", darkMode=").append(((com.tencent.mm.protocal.protobuf.bu)localObject).FMN).append(", halfDuration=").append(((com.tencent.mm.protocal.protobuf.bu)localObject).FMO).append(", fullDuration=").append(((com.tencent.mm.protocal.protobuf.bu)localObject).FMP).append(", followStatus=").append(((com.tencent.mm.protocal.protobuf.bu)localObject).FMu).append(", installStatus=").append(((com.tencent.mm.protocal.protobuf.bu)localObject).FMv).append(", timelineIdx=").append(((com.tencent.mm.protocal.protobuf.bu)localObject).FMQ).append(", oaid=").append(((com.tencent.mm.protocal.protobuf.bu)localObject).zmV).append(", imei=").append(((com.tencent.mm.protocal.protobuf.bu)localObject).imei).append(", waidPkg=").append(paramString3).append(", waid=").append(((com.tencent.mm.protocal.protobuf.bu)localObject).FMf).append(", req.ua.length=");
          if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(((com.tencent.mm.protocal.protobuf.bu)localObject).FMd)) {
            break label948;
          }
          paramInt1 = 0;
          label817:
          parambw = parambw.append(paramInt1).append(", req.common_device_id.length=");
          if (!com.tencent.mm.sdk.platformtools.bu.isNullOrNil(((com.tencent.mm.protocal.protobuf.bu)localObject).FMe)) {
            break label960;
          }
          paramInt1 = 0;
          label844:
          parambw.append(paramInt1);
          ae.i("MicroMsg.NetSceneAdExposure", parambt.toString());
          parambt = new StringBuilder("viewId.length=");
          if (paramString1 != null) {
            break label972;
          }
        }
        label938:
        label948:
        label960:
        label972:
        for (paramInt1 = 0;; paramInt1 = paramString1.length())
        {
          ae.i("MicroMsg.NetSceneAdExposure", paramInt1 + ", viewId=" + paramString1);
          AppMethodBeat.o(219063);
          return;
          ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adexposure";
          ((b.a)localObject).funcId = 1875;
          break;
          paramInt1 = paramb2.zr.length;
          break label590;
          paramInt1 = paramb1.zr.length;
          break label611;
          paramInt1 = ((com.tencent.mm.protocal.protobuf.bu)localObject).FMd.length();
          break label817;
          paramInt1 = ((com.tencent.mm.protocal.protobuf.bu)localObject).FMe.length();
          break label844;
        }
        return;
      }
      catch (Throwable paramString1)
      {
        ae.e("MicroMsg.NetSceneAdExposure", paramString1.toString());
        AppMethodBeat.o(219063);
      }
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
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(94980);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(94980);
    return i;
  }
  
  public final int getType()
  {
    return 1231;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94981);
    ae.i("MicroMsg.NetSceneAdExposure", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (bv)this.rr.hQE.hQJ;
    ae.i("MicroMsg.NetSceneAdExposure", "resp " + paramq.ret + " msg: " + paramq.msg);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.f
 * JD-Core Version:    0.7.0.1
 */