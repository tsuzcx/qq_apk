package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.h;
import com.tencent.mm.plugin.record.a.k;
import com.tencent.mm.pluginsdk.g.a.a;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import java.util.Random;

final class m$3
  implements a.a
{
  m$3(long paramLong, bv parambv1, String paramString, k.b paramb, akn paramakn, c paramc, bv parambv2) {}
  
  public final void bE(int paramInt, String paramString)
  {
    AppMethodBeat.i(186690);
    if (paramInt == 0)
    {
      paramString = new k();
      paramString.field_msgId = this.cXy;
      paramString.field_oriMsgId = this.Ffx.field_msgId;
      paramString.field_toUser = this.cXi;
      paramString.field_title = this.lmz.title;
      paramString.field_desc = this.lmz.description;
      paramString.field_dataProto = this.xHg;
      paramString.field_type = 0;
      paramString.field_favFrom = this.xHf.xGt;
      paramString.field_localId = (new Random().nextInt(2147483645) + 1);
      ae.i("MicroMsg.AppMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((a)g.ad(a.class)).getRecordMsgStorage().insert(paramString)), Long.valueOf(this.cXy), Integer.valueOf(paramString.field_localId) });
      ((a)g.ad(a.class)).getRecordMsgService().a(paramString);
      AppMethodBeat.o(186690);
      return;
    }
    if (-3200 == paramInt) {
      ae.e("MicroMsg.AppMsgLogic", "why errCode equals %s", new Object[] { Integer.valueOf(paramInt) });
    }
    this.hHv.setStatus(5);
    ((l)g.ab(l.class)).doJ().a(this.cXy, this.hHv);
    bv localbv = new bv();
    localbv.qN(this.hHv.field_createTime + 1L);
    localbv.ui(this.hHv.field_talker);
    localbv.setContent(paramString);
    localbv.setType(10000);
    localbv.setStatus(6);
    localbv.kt(0);
    ((l)g.ab(l.class)).doJ().ar(localbv);
    AppMethodBeat.o(186690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.m.3
 * JD-Core Version:    0.7.0.1
 */