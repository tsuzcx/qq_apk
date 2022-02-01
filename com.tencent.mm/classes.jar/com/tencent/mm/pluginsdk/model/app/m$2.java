package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.h;
import com.tencent.mm.plugin.record.a.k;
import com.tencent.mm.pluginsdk.g.a.a;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import java.util.Random;

final class m$2
  implements a.a
{
  m$2(long paramLong, bu parambu1, String paramString, k.b paramb, akd paramakd, c paramc, bu parambu2) {}
  
  public final void bE(int paramInt, String paramString)
  {
    AppMethodBeat.i(193410);
    if (paramInt == 0)
    {
      paramString = new k();
      paramString.field_msgId = this.cWB;
      paramString.field_oriMsgId = this.ENa.field_msgId;
      paramString.field_toUser = this.cWl;
      paramString.field_title = this.liN.title;
      paramString.field_desc = this.liN.description;
      paramString.field_dataProto = this.xrj;
      paramString.field_type = 0;
      paramString.field_favFrom = this.xri.xqw;
      paramString.field_localId = (new Random().nextInt(2147483645) + 1);
      ad.i("MicroMsg.AppMsgLogic", "summerrecord needNetScene insert ret:%b, id:%d, localid:%d", new Object[] { Boolean.valueOf(((a)g.ad(a.class)).getRecordMsgStorage().insert(paramString)), Long.valueOf(this.cWB), Integer.valueOf(paramString.field_localId) });
      ((a)g.ad(a.class)).getRecordMsgService().a(paramString);
      AppMethodBeat.o(193410);
      return;
    }
    if (-3200 == paramInt) {
      ad.e("MicroMsg.AppMsgLogic", "why errCode equals %s", new Object[] { Integer.valueOf(paramInt) });
    }
    this.hED.setStatus(5);
    ((l)g.ab(l.class)).dlK().a(this.cWB, this.hED);
    bu localbu = new bu();
    localbu.qA(this.hED.field_createTime + 1L);
    localbu.tN(this.hED.field_talker);
    localbu.setContent(paramString);
    localbu.setType(10000);
    localbu.setStatus(6);
    localbu.kr(0);
    ((l)g.ab(l.class)).dlK().as(localbu);
    AppMethodBeat.o(193410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.m.2
 * JD-Core Version:    0.7.0.1
 */