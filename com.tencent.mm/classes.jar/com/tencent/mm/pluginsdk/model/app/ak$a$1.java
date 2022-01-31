package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

final class ak$a$1
  implements z.a
{
  ak$a$1(ak.a parama, b paramb, bi parambi, long paramLong, String paramString) {}
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    AppMethodBeat.i(27394);
    if (bo.isNullOrNil(paramString3))
    {
      AppMethodBeat.o(27394);
      return;
    }
    this.vLS.field_signature = paramString3;
    this.vLS.field_fakeAeskey = paramString4;
    this.vLS.field_fakeSignature = paramString5;
    this.vLS.field_lastModifyTime = bo.aoy();
    paramString4 = this.fkQ.field_content;
    paramString3 = paramString4;
    if (t.lA(this.fkQ.field_talker))
    {
      int i = bf.pt(this.fkQ.field_content);
      paramString3 = paramString4;
      if (i != -1) {
        paramString3 = (this.fkQ.field_content + " ").substring(i + 2).trim();
      }
    }
    paramString3 = j.b.mY(bo.apU(paramString3));
    if (paramString3 != null)
    {
      paramString3.filemd5 = paramString1;
      paramString3.ewj = paramString2;
      paramString3.fgw = ((int)paramLong);
      aw.aaz();
      paramString1 = com.tencent.mm.model.c.YC().kB(this.vLS.field_msgInfoId);
      paramString1.setContent(j.b.a(paramString3, null, null));
      aw.aaz();
      com.tencent.mm.model.c.YC().a(paramString1.field_msgId, paramString1);
    }
    al.aUJ().a(this.vLS, new String[0]);
    paramString1 = new ah(this.vLT, null, this.hpi);
    aw.Rc().a(paramString1, 0);
    AppMethodBeat.o(27394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ak.a.1
 * JD-Core Version:    0.7.0.1
 */