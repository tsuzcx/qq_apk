package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.a;

final class k$1
  implements Runnable
{
  k$1(k paramk, bi parambi) {}
  
  public final void run()
  {
    ((i)g.r(i.class)).Z(this.dUy);
    bi localbi = this.dUy;
    boolean bool1 = this.gHu;
    Object localObject2 = new PString();
    Object localObject1 = new PString();
    boolean bool2;
    d locald;
    if (a.a(localbi, (PString)localObject2, (PString)localObject1))
    {
      Object localObject3 = ((PString)localObject2).value;
      String str = ((PString)localObject1).value;
      localObject2 = localbi.field_talker;
      bool2 = s.gZ((String)localObject2);
      if (localbi.field_isSend != 1) {
        break label520;
      }
      localObject1 = q.Gj();
      locald = new d();
      locald.j("20source_publishid", (String)localObject3 + ",");
      locald.j("21uxinfo", str + ",");
      locald.j("22clienttime", bk.UY() + ",");
      localObject3 = new StringBuilder();
      if (localbi.getType() != 62) {
        break label544;
      }
      i = 1;
      label211:
      locald.j("23source_type", i + ",");
      localObject3 = new StringBuilder();
      if (!bool2) {
        break label549;
      }
      i = 4;
      label247:
      locald.j("24scene", i + ",");
      locald.j("25scene_chatname", (String)localObject2 + ",");
      locald.j("26scene_username", (String)localObject1 + ",");
      locald.j("27curr_publishid", ",");
      locald.j("28curr_msgid", localbi.field_msgSvrId + ",");
      locald.j("29curr_favid", "0,");
      localObject1 = new StringBuilder();
      if (!bool1) {
        break label554;
      }
      i = 1;
      label385:
      locald.j("30isdownload", i + ",");
      localObject1 = new StringBuilder();
      if (!bool2) {
        break label559;
      }
    }
    label520:
    label544:
    label549:
    label554:
    label559:
    for (int i = m.gM((String)localObject2);; i = 0)
    {
      locald.j("31chatroom_membercount", i + ",");
      ((i)g.r(i.class)).b(((i)g.r(i.class)).C(localbi), locald);
      y.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + locald.uJ());
      h.nFQ.f(12989, new Object[] { locald });
      return;
      if (bool2)
      {
        localObject1 = bd.iI(localbi.field_content);
        break;
      }
      localObject1 = localObject2;
      break;
      i = 2;
      break label211;
      i = 3;
      break label247;
      i = 0;
      break label385;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.k.1
 * JD-Core Version:    0.7.0.1
 */