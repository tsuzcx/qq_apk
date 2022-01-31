package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.f;
import com.tencent.mm.i.g.a;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.n.a;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;

final class ac$4
  implements g.a
{
  ac$4(ac paramac) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(36374);
    if (paramInt == -21005)
    {
      ab.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.rfZ.fFo, Integer.valueOf(paramInt), paramc, paramd });
      this.rfZ.rfV.lb(true);
      AppMethodBeat.o(36374);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode == 0))
    {
      ab.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.rfZ.fFo, Integer.valueOf(paramInt), paramc, paramd });
      this.rfZ.ai(paramd.field_fileUrl, paramd.field_thumbUrl, "upload_" + this.rfZ.fFo);
      new f(a.s(new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.rfZ.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.rfZ.fFp), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb })).ake();
      n localn = n.alC();
      paramInt = this.rfZ.fWX;
      if (paramd != null)
      {
        String str1 = paramd.field_fileUrl;
        String str2 = str1.hashCode();
        paramc = (n.a)localn.fWG.get(str2);
        paramString = paramc;
        if (paramc == null) {
          paramString = new n.a(localn);
        }
        paramString.dns = "";
        paramString.toUser = "";
        paramString.fWT = "";
        paramString.fWX = paramInt;
        paramString.fWW = 1;
        paramString.czt = str1;
        paramString.fWk = paramd;
        paramString.startTime = bo.aoy();
        localn.fWG.put(str2, paramString);
        ab.i("MicroMsg.SubCoreMediaRpt", "note sns video sendScene %d snsKey[%s] url[%s]", new Object[] { Integer.valueOf(paramInt), str2, str1 });
      }
      this.rfZ.rfV.lb(true);
      AppMethodBeat.o(36374);
      return 0;
    }
    if ((paramd != null) && (paramd.field_retCode != 0))
    {
      ab.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.rfZ.fFo, Integer.valueOf(paramInt), paramc, paramd });
      this.rfZ.DF(0);
      paramString = a.s(new Object[] { Integer.valueOf(paramd.field_retCode), Integer.valueOf(1), Long.valueOf(this.rfZ.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.rfZ.fFp), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb });
      new f(paramString).ake();
      new com.tencent.mm.g.b.a.d(paramString).ake();
      this.rfZ.rfV.lb(false);
      AppMethodBeat.o(36374);
      return 0;
    }
    if (paramInt != 0)
    {
      ab.i("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.rfZ.fFo, Integer.valueOf(paramInt), paramc, paramd });
      this.rfZ.DF(0);
      if (paramd != null) {
        new f(a.s(new Object[] { Integer.valueOf(paramInt), Integer.valueOf(1), Long.valueOf(this.rfZ.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(this.rfZ.fFp), Integer.valueOf(paramd.field_fileLength), paramd.field_transInfo, "", "", "", "", "", "", "", paramd.edb })).ake();
      }
      this.rfZ.rfV.lb(false);
      AppMethodBeat.o(36374);
      return 0;
    }
    ab.d("MicroMsg.SightCdnUpload", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { this.rfZ.fFo, Integer.valueOf(paramInt), paramc, paramd });
    AppMethodBeat.o(36374);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ac.4
 * JD-Core Version:    0.7.0.1
 */