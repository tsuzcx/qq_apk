package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.ad.b.a;
import com.tencent.mm.plugin.sns.ad.i.f;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.protocal.protobuf.cc;
import com.tencent.mm.protocal.protobuf.cd;
import com.tencent.mm.protocal.protobuf.ce;
import com.tencent.mm.protocal.protobuf.cf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends q
  implements m
{
  public i callback;
  private d rr;
  
  public g(String paramString1, int paramInt1, int paramInt2, int paramInt3, cc paramcc, cf paramcf, int paramInt4, String paramString2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, com.tencent.mm.bw.b paramb1, com.tencent.mm.bw.b paramb2, String paramString3, b paramb)
  {
    AppMethodBeat.i(202034);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cd();
    ((d.a)localObject).iLO = new ce();
    if (paramInt6 != 2)
    {
      ((d.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/exposure";
      ((d.a)localObject).funcId = 1231;
    }
    for (;;)
    {
      ((d.a)localObject).iLP = 0;
      ((d.a)localObject).respCmdId = 0;
      this.rr = ((d.a)localObject).aXF();
      Log.i("MicroMsg.NetSceneAdExposure", "uri %s", new Object[] { this.rr.getUri() });
      localObject = (cd)this.rr.iLK.iLR;
      ((cd)localObject).KGj = paramInt3;
      ((cd)localObject).type = paramInt2;
      ((cd)localObject).scene = paramInt1;
      ((cd)localObject).DvI = paramString1;
      ((cd)localObject).KGm = paramInt5;
      ((cd)localObject).KGn = paramInt7;
      ((cd)localObject).KGo = paramInt8;
      ((cd)localObject).KFR = paramInt9;
      ((cd)localObject).Dsg = a.aoK();
      ((cd)localObject).imei = a.eWE();
      paramString3 = Util.nullAsNil(paramString3);
      ((cd)localObject).KFI = paramString3;
      ((cd)localObject).KFH = com.tencent.mm.plugin.sns.waid.b.aRy(paramString3);
      if (paramcc != null)
      {
        ((cd)localObject).KGk = paramcc;
        Log.i("MicroMsg.NetSceneAdExposure", "exposure_info " + paramcc.KGh);
      }
      if (paramcf != null)
      {
        ((cd)localObject).KGl = paramcf;
        Log.i("MicroMsg.NetSceneAdExposure", "socialInfo, commentCount=" + paramcf.KGx + ", likeCount=" + paramcf.KGw);
      }
      ((cd)localObject).KFM = System.currentTimeMillis();
      ((cd)localObject).KFO = paramInt4;
      if (paramString2 != null) {
        ((cd)localObject).KFL = paramString2;
      }
      if (paramb2 != null) {
        ((cd)localObject).KFT = paramb2;
      }
      if (paramb1 != null) {
        ((cd)localObject).KFS = paramb1;
      }
      if (paramb != null)
      {
        ((cd)localObject).KGp = b.getScreenWidth();
        ((cd)localObject).KGq = b.getScreenHeight();
        ((cd)localObject).KGr = paramb.Dut;
        ((cd)localObject).KGs = b.eXn();
        ((cd)localObject).KGt = paramb.Duu;
        ((cd)localObject).KGu = paramb.Duv;
        ((cd)localObject).KFW = k.s(paramb.DsC);
        ((cd)localObject).KFX = k.r(paramb.DsC);
        ((cd)localObject).KGv = paramb.Dus;
      }
      ((cd)localObject).KFG = a.eWC();
      ((cd)localObject).KFF = f.eYk();
      try
      {
        paramcc = new StringBuilder();
        paramcf = paramcc.append("##scene:").append(paramInt1).append(", exposureScene:").append(paramInt2).append(", duration:").append(paramInt3).append(", feed_duration:").append(paramInt7).append(", feed_full_duration:").append(paramInt8).append(", ad_type:").append(paramInt4).append(", exposureCount:").append(paramInt5).append(", descXml:").append(paramString2).append(", flip_status:").append(paramInt9).append(", self_info.length:");
        if (paramb2 == null)
        {
          paramInt1 = 0;
          label590:
          paramcf = paramcf.append(paramInt1).append(", source_info.length:");
          if (paramb1 != null) {
            break label938;
          }
          paramInt1 = 0;
          label611:
          paramcf = paramcf.append(paramInt1).append(", screen.w=").append(((cd)localObject).KGp).append(", screen.h=").append(((cd)localObject).KGq).append(", adView.h=").append(((cd)localObject).KGr).append(", darkMode=").append(((cd)localObject).KGs).append(", halfDuration=").append(((cd)localObject).KGt).append(", fullDuration=").append(((cd)localObject).KGu).append(", followStatus=").append(((cd)localObject).KFW).append(", installStatus=").append(((cd)localObject).KFX).append(", timelineIdx=").append(((cd)localObject).KGv).append(", oaid=").append(((cd)localObject).Dsg).append(", imei=").append(((cd)localObject).imei).append(", waidPkg=").append(paramString3).append(", waid=").append(((cd)localObject).KFH).append(", req.ua.length=");
          if (!Util.isNullOrNil(((cd)localObject).KFF)) {
            break label948;
          }
          paramInt1 = 0;
          label817:
          paramcf = paramcf.append(paramInt1).append(", req.common_device_id.length=");
          if (!Util.isNullOrNil(((cd)localObject).KFG)) {
            break label960;
          }
          paramInt1 = 0;
          label844:
          paramcf.append(paramInt1);
          Log.i("MicroMsg.NetSceneAdExposure", paramcc.toString());
          paramcc = new StringBuilder("viewId.length=");
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
          AppMethodBeat.o(202034);
          return;
          ((d.a)localObject).uri = "/cgi-bin/mmux-bin/adexposure";
          ((d.a)localObject).funcId = 1875;
          break;
          paramInt1 = paramb2.zy.length;
          break label590;
          paramInt1 = paramb1.zy.length;
          break label611;
          paramInt1 = ((cd)localObject).KFF.length();
          break label817;
          paramInt1 = ((cd)localObject).KFG.length();
          break label844;
        }
        return;
      }
      catch (Throwable paramString1)
      {
        Log.e("MicroMsg.NetSceneAdExposure", paramString1.toString());
        AppMethodBeat.o(202034);
      }
    }
  }
  
  public g(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, com.tencent.mm.bw.b paramb1, com.tencent.mm.bw.b paramb2, String paramString3)
  {
    this(paramString1, paramInt1, 2, paramInt2, null, null, 2, paramString2, -1, paramInt3, paramInt4, paramInt5, 0, paramb1, paramb2, paramString3, null);
  }
  
  public g(String paramString1, int paramInt1, cf paramcf, int paramInt2, int paramInt3, int paramInt4, com.tencent.mm.bw.b paramb1, com.tencent.mm.bw.b paramb2, String paramString2, b paramb)
  {
    this(paramString1, paramInt1, 1, 0, null, paramcf, paramInt2, "", paramInt3, paramInt4, 0, 0, 0, paramb1, paramb2, paramString2, paramb);
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
    params = (ce)this.rr.iLL.iLR;
    Log.i("MicroMsg.NetSceneAdExposure", "resp " + params.ret + " msg: " + params.msg);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.g
 * JD-Core Version:    0.7.0.1
 */