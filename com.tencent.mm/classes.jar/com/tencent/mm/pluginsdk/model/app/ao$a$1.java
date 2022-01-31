package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bi;

final class ao$a$1
  implements aa.a
{
  ao$a$1(ao.a parama, b paramb, bi parambi, long paramLong, String paramString) {}
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    if (bk.bl(paramString3)) {
      return;
    }
    this.rVf.field_signature = paramString3;
    this.rVf.field_fakeAeskey = paramString4;
    this.rVf.field_fakeSignature = paramString5;
    this.rVf.field_lastModifyTime = bk.UY();
    paramString4 = this.dUH.field_content;
    paramString3 = paramString4;
    if (s.fn(this.dUH.field_talker))
    {
      int i = bd.iH(this.dUH.field_content);
      paramString3 = paramString4;
      if (i != -1) {
        paramString3 = (this.dUH.field_content + " ").substring(i + 2).trim();
      }
    }
    paramString3 = g.a.gp(bk.ZQ(paramString3));
    if (paramString3 != null)
    {
      paramString3.filemd5 = paramString1;
      paramString3.dQR = paramString2;
      paramString3.dQv = ((int)paramLong);
      au.Hx();
      paramString1 = com.tencent.mm.model.c.Fy().fd(this.rVf.field_msgInfoId);
      paramString1.setContent(g.a.a(paramString3, null, null));
      au.Hx();
      com.tencent.mm.model.c.Fy().a(paramString1.field_msgId, paramString1);
    }
    ap.avh().c(this.rVf, new String[0]);
    paramString1 = new al(this.rVg, null, this.fVG);
    au.Dk().a(paramString1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ao.a.1
 * JD-Core Version:    0.7.0.1
 */