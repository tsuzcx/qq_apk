package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ck;
import com.tencent.mm.protocal.protobuf.cl;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends p
  implements com.tencent.mm.network.m
{
  public com.tencent.mm.am.h callback;
  private c rr;
  
  public g(String paramString1, int paramInt1, int paramInt2, int paramInt3, ck paramck, cn paramcn, int paramInt4, String paramString2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, com.tencent.mm.bx.b paramb1, com.tencent.mm.bx.b paramb2, String paramString3, b paramb)
  {
    AppMethodBeat.i(309898);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cl();
    ((c.a)localObject).otF = new cm();
    if (paramInt6 != 2)
    {
      ((c.a)localObject).uri = "/cgi-bin/mmoc-bin/ad/exposure";
      ((c.a)localObject).funcId = 1231;
    }
    for (;;)
    {
      ((c.a)localObject).otG = 0;
      ((c.a)localObject).respCmdId = 0;
      this.rr = ((c.a)localObject).bEF();
      Log.i("MicroMsg.NetSceneAdExposure", "uri %s", new Object[] { this.rr.getUri() });
      localObject = (cl)c.b.b(this.rr.otB);
      ((cl)localObject).YEF = paramInt3;
      ((cl)localObject).type = paramInt2;
      ((cl)localObject).scene = paramInt1;
      ((cl)localObject).PWh = paramString1;
      ((cl)localObject).YEI = paramInt5;
      ((cl)localObject).YEJ = paramInt7;
      ((cl)localObject).YEK = paramInt8;
      ((cl)localObject).YEk = paramInt9;
      ((cl)localObject).PNk = com.tencent.mm.plugin.sns.ad.a.a.aPk();
      ((cl)localObject).imei = com.tencent.mm.plugin.sns.ad.a.a.gZB();
      paramString3 = Util.nullAsNil(paramString3);
      ((cl)localObject).YEb = paramString3;
      ((cl)localObject).YEa = com.tencent.mm.plugin.sns.waid.b.bbr(paramString3);
      if (paramck != null)
      {
        ((cl)localObject).YEG = paramck;
        Log.i("MicroMsg.NetSceneAdExposure", "exposure_info " + paramck.YED);
      }
      if (paramcn != null)
      {
        ((cl)localObject).YEH = paramcn;
        Log.i("MicroMsg.NetSceneAdExposure", "socialInfo, commentCount=" + paramcn.YES + ", likeCount=" + paramcn.HWO);
      }
      ((cl)localObject).YEf = System.currentTimeMillis();
      ((cl)localObject).YEh = paramInt4;
      if (paramString2 != null) {
        ((cl)localObject).YEe = paramString2;
      }
      if (paramb2 != null) {
        ((cl)localObject).YEm = paramb2;
      }
      if (paramb1 != null) {
        ((cl)localObject).YEl = paramb1;
      }
      if (paramb != null)
      {
        ((cl)localObject).YEL = b.getScreenWidth();
        ((cl)localObject).YEM = b.getScreenHeight();
        ((cl)localObject).YEN = paramb.PUS;
        ((cl)localObject).YEO = b.hbf();
        ((cl)localObject).YEP = paramb.PUU;
        ((cl)localObject).YEQ = paramb.PUV;
        ((cl)localObject).YEp = com.tencent.mm.plugin.sns.data.m.u(paramb.PNI);
        ((cl)localObject).YEq = com.tencent.mm.plugin.sns.data.m.t(paramb.PNI);
        ((cl)localObject).YER = paramb.PUR;
        ((cl)localObject).PUQ = paramb.PUQ;
      }
      ((cl)localObject).YDZ = com.tencent.mm.plugin.sns.ad.a.a.gZz();
      ((cl)localObject).YDY = com.tencent.mm.plugin.sns.ad.j.g.hcn();
      if (com.tencent.mm.ce.b.iRp())
      {
        paramInt6 = 1;
        label486:
        ((cl)localObject).YEs = paramInt6;
        ((cl)localObject).YEt = com.tencent.mm.cd.a.mm(MMApplicationContext.getContext());
      }
      try
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1612, 55);
        paramck = new StringBuilder();
        paramcn = paramck.append("##scene:").append(paramInt1).append(", exposureScene:").append(paramInt2).append(", duration:").append(paramInt3).append(", feed_duration:").append(paramInt7).append(", feed_full_duration:").append(paramInt8).append(", ad_type:").append(paramInt4).append(", exposureCount:").append(paramInt5).append(", descXml:").append(paramString2).append(", flip_status:").append(paramInt9).append(", self_info.length:");
        if (paramb2 == null)
        {
          paramInt1 = 0;
          label638:
          paramcn = paramcn.append(paramInt1).append(", source_info.length:");
          if (paramb1 != null) {
            break label1060;
          }
          paramInt1 = 0;
          label659:
          paramcn = paramcn.append(paramInt1).append(", screen.w=").append(((cl)localObject).YEL).append(", screen.h=").append(((cl)localObject).YEM).append(", adView.h=").append(((cl)localObject).YEN).append(", darkMode=").append(((cl)localObject).YEO).append(", halfDuration=").append(((cl)localObject).YEP).append(", fullDuration=").append(((cl)localObject).YEQ).append(", followStatus=").append(((cl)localObject).YEp).append(", installStatus=").append(((cl)localObject).YEq).append(", timelineIdx=").append(((cl)localObject).YER).append(", oaid=").append(((cl)localObject).PNk).append(", imei=").append(((cl)localObject).imei).append(", waidPkg=").append(paramString3).append(", waid=").append(((cl)localObject).YEa).append(", relieved_buy_show=").append(((cl)localObject).PUQ).append(", req.ua.length=");
          if (!Util.isNullOrNil(((cl)localObject).YDY)) {
            break label1070;
          }
          paramInt1 = 0;
          label879:
          paramcn = paramcn.append(paramInt1).append(", req.common_device_id.length=");
          if (!Util.isNullOrNil(((cl)localObject).YDZ)) {
            break label1082;
          }
          paramInt1 = 0;
          label906:
          paramcn.append(paramInt1).append(", elder_mode:").append(((cl)localObject).YEs).append(", font_level:").append(((cl)localObject).YEt);
          Log.i("MicroMsg.NetSceneAdExposure", paramck.toString());
          paramck = new StringBuilder("viewId.length=");
          if (paramString1 != null) {
            break label1094;
          }
        }
        label1060:
        label1070:
        label1082:
        label1094:
        for (paramInt1 = 0;; paramInt1 = paramString1.length())
        {
          Log.i("MicroMsg.NetSceneAdExposure", paramInt1 + ", viewId=" + paramString1);
          AppMethodBeat.o(309898);
          return;
          ((c.a)localObject).uri = "/cgi-bin/mmux-bin/adexposure";
          ((c.a)localObject).funcId = 1875;
          break;
          paramInt6 = 0;
          break label486;
          paramInt1 = paramb2.Op.length;
          break label638;
          paramInt1 = paramb1.Op.length;
          break label659;
          paramInt1 = ((cl)localObject).YDY.length();
          break label879;
          paramInt1 = ((cl)localObject).YDZ.length();
          break label906;
        }
        return;
      }
      finally
      {
        Log.e("MicroMsg.NetSceneAdExposure", paramString1.toString());
        AppMethodBeat.o(309898);
      }
    }
  }
  
  public g(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5, com.tencent.mm.bx.b paramb1, com.tencent.mm.bx.b paramb2, String paramString3)
  {
    this(paramString1, paramInt1, 2, paramInt2, null, null, 2, paramString2, -1, paramInt3, paramInt4, paramInt5, 0, paramb1, paramb2, paramString3, null);
  }
  
  public g(String paramString1, int paramInt1, cn paramcn, int paramInt2, int paramInt3, int paramInt4, com.tencent.mm.bx.b paramb1, com.tencent.mm.bx.b paramb2, String paramString2, b paramb)
  {
    this(paramString1, paramInt1, 1, 0, null, paramcn, paramInt2, "", paramInt3, paramInt4, 0, 0, 0, paramb1, paramb2, paramString2, paramb);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(94980);
    this.callback = paramh;
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
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1612, 56);
    }
    params = (cm)c.c.b(this.rr.otC);
    Log.i("MicroMsg.NetSceneAdExposure", "resp=" + params.ret + ", msg=" + params.msg);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(94981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.g.g
 * JD-Core Version:    0.7.0.1
 */