package com.tencent.mm.plugin.nearby.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.mj;
import com.tencent.mm.f.a.mk;
import com.tencent.mm.f.a.mk.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.nearby.b.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;

final class f$1
  extends IListener<mk>
{
  f$1(f paramf)
  {
    AppMethodBeat.i(160509);
    this.__eventId = mk.class.getName().hashCode();
    AppMethodBeat.o(160509);
  }
  
  private static boolean a(mk parammk)
  {
    int i = 3;
    AppMethodBeat.i(89776);
    Object localObject = parammk.fKv.fKw;
    parammk = parammk.fKv.fvt;
    if ((((bq.b)localObject).luy != null) && (((bq.b)localObject).scene == 1))
    {
      h.aHG().aHp().i(73729, Integer.valueOf(1));
      bx localbx = new bx();
      localbx.field_content = parammk.field_content;
      localbx.field_createtime = Util.nowSecond();
      localbx.field_imgpath = "";
      localbx.field_sayhicontent = MMApplicationContext.getContext().getString(b.g.nearby_say_hi_type_voice);
      localbx.field_sayhiuser = parammk.field_talker;
      localbx.field_scene = 18;
      if (parammk.field_status > 3) {
        i = parammk.field_status;
      }
      localbx.field_status = i;
      localbx.field_svrid = parammk.field_msgSvrId;
      localbx.field_talker = parammk.field_talker;
      localbx.field_type = 34;
      localbx.field_isSend = 0;
      localbx.field_sayhiencryptuser = parammk.field_talker;
      localbx.field_ticket = ((bq.b)localObject).luy;
      h.aHE().aGH();
      ((by)((n)h.ae(n.class)).eSb()).a(localbx);
      localObject = new mj();
      ((mj)localObject).fKt.fKu = parammk.field_talker;
      EventCenter.instance.publish((IEvent)localObject);
    }
    AppMethodBeat.o(89776);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.f.1
 * JD-Core Version:    0.7.0.1
 */