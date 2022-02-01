package com.tencent.mm.plugin.sns.ad.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.ad.a.a;
import com.tencent.mm.plugin.sns.ad.e.c;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.protocal.protobuf.bu;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.sdk.platformtools.ad;

public final class f
  extends n
  implements k
{
  public com.tencent.mm.al.f callback;
  private com.tencent.mm.al.b rr;
  
  public f(String paramString1, int paramInt1, int paramInt2, int paramInt3, com.tencent.mm.protocal.protobuf.bt parambt, bw parambw, int paramInt4, String paramString2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, com.tencent.mm.bx.b paramb1, com.tencent.mm.bx.b paramb2, String paramString3, b paramb)
  {
    AppMethodBeat.i(197601);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bu();
    ((b.a)localObject).hNN = new bv();
    if (paramInt6 != 2)
    {
      ((b.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/exposure";
      ((b.a)localObject).funcId = 1231;
    }
    for (;;)
    {
      ((b.a)localObject).hNO = 0;
      ((b.a)localObject).respCmdId = 0;
      this.rr = ((b.a)localObject).aDC();
      ad.i("MicroMsg.NetSceneAdExposure", "uri %s", new Object[] { this.rr.getUri() });
      localObject = (bu)this.rr.hNK.hNQ;
      ((bu)localObject).Fug = paramInt3;
      ((bu)localObject).type = paramInt2;
      ((bu)localObject).scene = paramInt1;
      ((bu)localObject).yYY = paramString1;
      ((bu)localObject).Fuj = paramInt5;
      ((bu)localObject).Fuk = paramInt7;
      ((bu)localObject).Ful = paramInt8;
      ((bu)localObject).FtR = paramInt9;
      ((bu)localObject).yWM = a.aaC();
      ((bu)localObject).imei = a.ftk();
      paramString3 = com.tencent.mm.sdk.platformtools.bt.nullAsNil(paramString3);
      ((bu)localObject).FtI = paramString3;
      ((bu)localObject).FtH = com.tencent.mm.plugin.sns.waid.b.aBl(paramString3);
      if (parambt != null)
      {
        ((bu)localObject).Fuh = parambt;
        ad.i("MicroMsg.NetSceneAdExposure", "exposure_info " + parambt.Fue);
      }
      if (parambw != null)
      {
        ((bu)localObject).Fui = parambw;
        ad.i("MicroMsg.NetSceneAdExposure", "social_info " + parambw.Fuu + " " + parambw.Fut);
      }
      ((bu)localObject).FtM = System.currentTimeMillis();
      ((bu)localObject).FtO = paramInt4;
      if (paramString2 != null) {
        ((bu)localObject).FtL = paramString2;
      }
      if (paramb2 != null) {
        ((bu)localObject).FtT = paramb2;
      }
      if (paramb1 != null) {
        ((bu)localObject).FtS = paramb1;
      }
      if (paramb != null)
      {
        ((bu)localObject).Fum = b.getScreenWidth();
        ((bu)localObject).Fun = b.getScreenHeight();
        ((bu)localObject).Fuo = paramb.yXG;
        ((bu)localObject).Fup = b.dRw();
        ((bu)localObject).Fuq = paramb.yXH;
        ((bu)localObject).Fur = paramb.yXI;
        ((bu)localObject).FtW = j.k(paramb.yXF);
        ((bu)localObject).FtX = j.j(paramb.yXF);
        ((bu)localObject).Fus = paramb.yXE;
      }
      ((bu)localObject).FtG = a.dRf();
      ((bu)localObject).FtF = c.dSd();
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
          parambw = parambw.append(paramInt1).append(", screen.w=").append(((bu)localObject).Fum).append(", screen.h=").append(((bu)localObject).Fun).append(", adView.h=").append(((bu)localObject).Fuo).append(", darkMode=").append(((bu)localObject).Fup).append(", halfDuration=").append(((bu)localObject).Fuq).append(", fullDuration=").append(((bu)localObject).Fur).append(", followStatus=").append(((bu)localObject).FtW).append(", installStatus=").append(((bu)localObject).FtX).append(", timelineIdx=").append(((bu)localObject).Fus).append(", oaid=").append(((bu)localObject).yWM).append(", imei=").append(((bu)localObject).imei).append(", waidPkg=").append(paramString3).append(", waid=").append(((bu)localObject).FtH).append(", req.ua.length=");
          if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(((bu)localObject).FtF)) {
            break label948;
          }
          paramInt1 = 0;
          label817:
          parambw = parambw.append(paramInt1).append(", req.common_device_id.length=");
          if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(((bu)localObject).FtG)) {
            break label960;
          }
          paramInt1 = 0;
          label844:
          parambw.append(paramInt1);
          ad.i("MicroMsg.NetSceneAdExposure", parambt.toString());
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
          ad.i("MicroMsg.NetSceneAdExposure", paramInt1 + ", viewId=" + paramString1);
          AppMethodBeat.o(197601);
          return;
          ((b.a)localObject).uri = "/cgi-bin/mmux-bin/adexposure";
          ((b.a)localObject).funcId = 1875;
          break;
          paramInt1 = paramb2.zr.length;
          break label590;
          paramInt1 = paramb1.zr.length;
          break label611;
          paramInt1 = ((bu)localObject).FtF.length();
          break label817;
          paramInt1 = ((bu)localObject).FtG.length();
          break label844;
        }
        return;
      }
      catch (Throwable paramString1)
      {
        ad.e("MicroMsg.NetSceneAdExposure", paramString1.toString());
        AppMethodBeat.o(197601);
      }
    }
  }
  
  public f(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, com.tencent.mm.bx.b paramb1, com.tencent.mm.bx.b paramb2, String paramString3)
  {
    this(paramString1, paramInt1, 2, paramInt2, null, null, 2, paramString2, -1, paramInt3, paramInt4, paramInt5, 0, paramb1, paramb2, paramString3, null);
  }
  
  public f(String paramString1, int paramInt1, bw parambw, int paramInt2, int paramInt3, int paramInt4, com.tencent.mm.bx.b paramb1, com.tencent.mm.bx.b paramb2, String paramString2, b paramb)
  {
    this(paramString1, paramInt1, 1, 0, null, parambw, paramInt2, "", paramInt3, paramInt4, 0, 0, 0, paramb1, paramb2, paramString2, paramb);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
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
    ad.i("MicroMsg.NetSceneAdExposure", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (bv)this.rr.hNL.hNQ;
    ad.i("MicroMsg.NetSceneAdExposure", "resp " + paramq.ret + " msg: " + paramq.msg);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.f
 * JD-Core Version:    0.7.0.1
 */