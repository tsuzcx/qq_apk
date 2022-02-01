package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.f;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

final class ab$4
  implements g.a
{
  ab$4(ab paramab) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(95700);
    if (paramInt == -21005)
    {
      ad.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.wGE.hhN, Integer.valueOf(paramInt), paramc, paramd });
      this.wGE.wGA.pJ(true);
      AppMethodBeat.o(95700);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode == 0))
    {
      ad.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.wGE.hhN, Integer.valueOf(paramInt), paramc, paramd });
      this.wGE.at(paramd.field_fileUrl, paramd.field_thumbUrl, "upload_" + this.wGE.hhN);
      new h(a.s(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.wGE.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.wGE.fLB), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.fns })).aBj();
      n localn = n.aCG();
      paramInt = this.wGE.dzf;
      int i = this.wGE.hzJ;
      if (paramd != null)
      {
        String str1 = paramd.field_fileUrl;
        String str2 = String.valueOf(paramInt);
        paramc = (n.a)localn.hzs.get(str2);
        paramString = paramc;
        if (paramc == null) {
          paramString = new n.a(localn);
        }
        paramString.esh = "";
        paramString.toUser = "";
        paramString.hzF = "";
        paramString.hzJ = i;
        paramString.hzI = 1;
        paramString.dpz = str1;
        paramString.hyW = paramd;
        paramString.startTime = bt.eGO();
        localn.hzs.put(str2, paramString);
        ad.i("MicroMsg.SubCoreMediaRpt", "note sns video sendScene %d snsKey[%s] url[%s]", new Object[] { Integer.valueOf(i), str2, str1 });
      }
      this.wGE.wGA.pJ(true);
      AppMethodBeat.o(95700);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode != 0))
    {
      ad.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.wGE.hhN, Integer.valueOf(paramInt), paramc, paramd });
      this.wGE.Mf(0);
      paramString = a.s(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.wGE.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.wGE.fLB), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.fns });
      new h(paramString).aBj();
      new f(paramString).aBj();
      this.wGE.wGA.pJ(false);
      AppMethodBeat.o(95700);
      return 0;
    }
    if (paramInt != 0)
    {
      ad.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.wGE.hhN, Integer.valueOf(paramInt), paramc, paramd });
      this.wGE.Mf(0);
      if (paramd != null) {
        new h(a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.wGE.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(this.wGE.fLB), Long.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.fns })).aBj();
      }
      this.wGE.wGA.pJ(false);
      AppMethodBeat.o(95700);
      return 0;
    }
    ad.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.wGE.hhN, Integer.valueOf(paramInt), paramc, paramd });
    AppMethodBeat.o(95700);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ab.4
 * JD-Core Version:    0.7.0.1
 */