package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.a;

final class k$1
  implements Runnable
{
  k$1(k paramk, bi parambi) {}
  
  public final void run()
  {
    AppMethodBeat.i(31344);
    ((i)g.E(i.class)).ai(this.fkH);
    bi localbi = this.fkH;
    boolean bool1 = this.zFn;
    Object localObject2 = new PString();
    Object localObject1 = new PString();
    boolean bool2;
    d locald;
    if (a.a(localbi, (PString)localObject2, (PString)localObject1))
    {
      Object localObject3 = ((PString)localObject2).value;
      String str = ((PString)localObject1).value;
      localObject2 = localbi.field_talker;
      bool2 = t.nI((String)localObject2);
      if (localbi.field_isSend != 1) {
        break label532;
      }
      localObject1 = r.Zn();
      locald = new d();
      locald.k("20source_publishid", (String)localObject3 + ",");
      locald.k("21uxinfo", str + ",");
      locald.k("22clienttime", bo.aoy() + ",");
      localObject3 = new StringBuilder();
      if (localbi.getType() != 62) {
        break label556;
      }
      i = 1;
      label217:
      locald.k("23source_type", i + ",");
      localObject3 = new StringBuilder();
      if (!bool2) {
        break label561;
      }
      i = 4;
      label253:
      locald.k("24scene", i + ",");
      locald.k("25scene_chatname", (String)localObject2 + ",");
      locald.k("26scene_username", (String)localObject1 + ",");
      locald.k("27curr_publishid", ",");
      locald.k("28curr_msgid", localbi.field_msgSvrId + ",");
      locald.k("29curr_favid", "0,");
      localObject1 = new StringBuilder();
      if (!bool1) {
        break label566;
      }
      i = 1;
      label391:
      locald.k("30isdownload", i + ",");
      localObject1 = new StringBuilder();
      if (!bool2) {
        break label571;
      }
    }
    label532:
    label556:
    label561:
    label566:
    label571:
    for (int i = n.nv((String)localObject2);; i = 0)
    {
      locald.k("31chatroom_membercount", i + ",");
      ((i)g.E(i.class)).b(((i)g.E(i.class)).I(localbi), locald);
      ab.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + locald.Fg());
      h.qsU.e(12989, new Object[] { locald });
      AppMethodBeat.o(31344);
      return;
      if (bool2)
      {
        localObject1 = bf.pu(localbi.field_content);
        break;
      }
      localObject1 = localObject2;
      break;
      i = 2;
      break label217;
      i = 3;
      break label253;
      i = 0;
      break label391;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.k.1
 * JD-Core Version:    0.7.0.1
 */