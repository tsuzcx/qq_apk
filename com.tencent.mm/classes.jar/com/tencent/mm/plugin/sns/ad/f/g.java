package com.tencent.mm.plugin.sns.ad.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.ad.a.a;
import com.tencent.mm.protocal.protobuf.ca;
import com.tencent.mm.protocal.protobuf.cb;
import com.tencent.mm.protocal.protobuf.cc;
import com.tencent.mm.protocal.protobuf.cd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends q
  implements com.tencent.mm.network.m
{
  public i callback;
  private d rr;
  
  public g(String paramString1, int paramInt1, int paramInt2, int paramInt3, ca paramca, cd paramcd, int paramInt4, String paramString2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, com.tencent.mm.cd.b paramb1, com.tencent.mm.cd.b paramb2, String paramString3, b paramb)
  {
    AppMethodBeat.i(269633);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cb();
    ((d.a)localObject).lBV = new cc();
    if (paramInt6 != 2)
    {
      ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/exposure";
      ((d.a)localObject).funcId = 1231;
    }
    for (;;)
    {
      ((d.a)localObject).lBW = 0;
      ((d.a)localObject).respCmdId = 0;
      this.rr = ((d.a)localObject).bgN();
      Log.i("MicroMsg.NetSceneAdExposure", "uri %s", new Object[] { this.rr.getUri() });
      localObject = (cb)d.b.b(this.rr.lBR);
      ((cb)localObject).RHC = paramInt3;
      ((cb)localObject).type = paramInt2;
      ((cb)localObject).scene = paramInt1;
      ((cb)localObject).JFg = paramString1;
      ((cb)localObject).RHF = paramInt5;
      ((cb)localObject).RHG = paramInt7;
      ((cb)localObject).RHH = paramInt8;
      ((cb)localObject).RHj = paramInt9;
      ((cb)localObject).JyL = a.auQ();
      ((cb)localObject).imei = a.fJH();
      paramString3 = Util.nullAsNil(paramString3);
      ((cb)localObject).RGZ = paramString3;
      ((cb)localObject).RGY = com.tencent.mm.plugin.sns.waid.b.bcD(paramString3);
      if (paramca != null)
      {
        ((cb)localObject).RHD = paramca;
        Log.i("MicroMsg.NetSceneAdExposure", "exposure_info " + paramca.RHA);
      }
      if (paramcd != null)
      {
        ((cb)localObject).RHE = paramcd;
        Log.i("MicroMsg.NetSceneAdExposure", "socialInfo, commentCount=" + paramcd.RHP + ", likeCount=" + paramcd.CkG);
      }
      ((cb)localObject).RHe = System.currentTimeMillis();
      ((cb)localObject).RHg = paramInt4;
      if (paramString2 != null) {
        ((cb)localObject).RHd = paramString2;
      }
      if (paramb2 != null) {
        ((cb)localObject).RHl = paramb2;
      }
      if (paramb1 != null) {
        ((cb)localObject).RHk = paramb1;
      }
      if (paramb != null)
      {
        ((cb)localObject).RHI = b.getScreenWidth();
        ((cb)localObject).RHJ = b.getScreenHeight();
        ((cb)localObject).RHK = paramb.JDR;
        ((cb)localObject).RHL = b.fKO();
        ((cb)localObject).RHM = paramb.JDS;
        ((cb)localObject).RHN = paramb.JDT;
        ((cb)localObject).RHo = com.tencent.mm.plugin.sns.data.m.s(paramb.Jzk);
        ((cb)localObject).RHp = com.tencent.mm.plugin.sns.data.m.r(paramb.Jzk);
        ((cb)localObject).RHO = paramb.JDQ;
      }
      ((cb)localObject).RGX = a.fJF();
      ((cb)localObject).RGW = com.tencent.mm.plugin.sns.ad.i.g.fLT();
      try
      {
        paramca = new StringBuilder();
        paramcd = paramca.append("##scene:").append(paramInt1).append(", exposureScene:").append(paramInt2).append(", duration:").append(paramInt3).append(", feed_duration:").append(paramInt7).append(", feed_full_duration:").append(paramInt8).append(", ad_type:").append(paramInt4).append(", exposureCount:").append(paramInt5).append(", descXml:").append(paramString2).append(", flip_status:").append(paramInt9).append(", self_info.length:");
        if (paramb2 == null)
        {
          paramInt1 = 0;
          label590:
          paramcd = paramcd.append(paramInt1).append(", source_info.length:");
          if (paramb1 != null) {
            break label938;
          }
          paramInt1 = 0;
          label611:
          paramcd = paramcd.append(paramInt1).append(", screen.w=").append(((cb)localObject).RHI).append(", screen.h=").append(((cb)localObject).RHJ).append(", adView.h=").append(((cb)localObject).RHK).append(", darkMode=").append(((cb)localObject).RHL).append(", halfDuration=").append(((cb)localObject).RHM).append(", fullDuration=").append(((cb)localObject).RHN).append(", followStatus=").append(((cb)localObject).RHo).append(", installStatus=").append(((cb)localObject).RHp).append(", timelineIdx=").append(((cb)localObject).RHO).append(", oaid=").append(((cb)localObject).JyL).append(", imei=").append(((cb)localObject).imei).append(", waidPkg=").append(paramString3).append(", waid=").append(((cb)localObject).RGY).append(", req.ua.length=");
          if (!Util.isNullOrNil(((cb)localObject).RGW)) {
            break label948;
          }
          paramInt1 = 0;
          label817:
          paramcd = paramcd.append(paramInt1).append(", req.common_device_id.length=");
          if (!Util.isNullOrNil(((cb)localObject).RGX)) {
            break label960;
          }
          paramInt1 = 0;
          label844:
          paramcd.append(paramInt1);
          Log.i("MicroMsg.NetSceneAdExposure", paramca.toString());
          paramca = new StringBuilder("viewId.length=");
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
          Log.i("MicroMsg.NetSceneAdExposure", paramInt1 + ", viewId=" + paramString1);
          AppMethodBeat.o(269633);
          return;
          ((d.a)localObject).uri = "/cgi-bin/mmux-bin/adexposure";
          ((d.a)localObject).funcId = 1875;
          break;
          paramInt1 = paramb2.UH.length;
          break label590;
          paramInt1 = paramb1.UH.length;
          break label611;
          paramInt1 = ((cb)localObject).RGW.length();
          break label817;
          paramInt1 = ((cb)localObject).RGX.length();
          break label844;
        }
        return;
      }
      catch (Throwable paramString1)
      {
        Log.e("MicroMsg.NetSceneAdExposure", paramString1.toString());
        AppMethodBeat.o(269633);
      }
    }
  }
  
  public g(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, com.tencent.mm.cd.b paramb1, com.tencent.mm.cd.b paramb2, String paramString3)
  {
    this(paramString1, paramInt1, 2, paramInt2, null, null, 2, paramString2, -1, paramInt3, paramInt4, paramInt5, 0, paramb1, paramb2, paramString3, null);
  }
  
  public g(String paramString1, int paramInt1, cd paramcd, int paramInt2, int paramInt3, int paramInt4, com.tencent.mm.cd.b paramb1, com.tencent.mm.cd.b paramb2, String paramString2, b paramb)
  {
    this(paramString1, paramInt1, 1, 0, null, paramcd, paramInt2, "", paramInt3, paramInt4, 0, 0, 0, paramb1, paramb2, paramString2, paramb);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(94980);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(94980);
    return i;
  }
  
  public final int getType()
  {
    return 1231;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94981);
    Log.i("MicroMsg.NetSceneAdExposure", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    params = (cc)d.c.b(this.rr.lBS);
    Log.i("MicroMsg.NetSceneAdExposure", "resp " + params.ret + " msg: " + params.msg);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.f.g
 * JD-Core Version:    0.7.0.1
 */