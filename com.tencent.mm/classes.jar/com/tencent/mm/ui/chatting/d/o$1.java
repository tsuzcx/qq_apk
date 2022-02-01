package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.a;

final class o$1
  implements com.tencent.f.i.h
{
  o$1(o paramo, ca paramca) {}
  
  public final String getKey()
  {
    return "ChattingUI.adVideoExposeReport";
  }
  
  public final void run()
  {
    AppMethodBeat.i(35234);
    ((j)g.af(j.class)).aO(this.iBF);
    ca localca = this.iBF;
    boolean bool1 = this.PoF;
    Object localObject2 = new PString();
    Object localObject1 = new PString();
    boolean bool2;
    m localm;
    if (a.a(localca, (PString)localObject2, (PString)localObject1))
    {
      Object localObject3 = ((PString)localObject2).value;
      String str = ((PString)localObject1).value;
      localObject2 = localca.field_talker;
      bool2 = ab.Iw((String)localObject2);
      if (localca.field_isSend != 1) {
        break label530;
      }
      localObject1 = z.aTY();
      localm = new m();
      localm.n("20source_publishid", (String)localObject3 + ",");
      localm.n("21uxinfo", str + ",");
      localm.n("22clienttime", Util.nowMilliSecond() + ",");
      localObject3 = new StringBuilder();
      if (localca.getType() != 62) {
        break label554;
      }
      i = 1;
      label216:
      localm.n("23source_type", i + ",");
      localObject3 = new StringBuilder();
      if (!bool2) {
        break label559;
      }
      i = 4;
      label252:
      localm.n("24scene", i + ",");
      localm.n("25scene_chatname", (String)localObject2 + ",");
      localm.n("26scene_username", (String)localObject1 + ",");
      localm.n("27curr_publishid", ",");
      localm.n("28curr_msgid", localca.field_msgSvrId + ",");
      localm.n("29curr_favid", "0,");
      localObject1 = new StringBuilder();
      if (!bool1) {
        break label564;
      }
      i = 1;
      label390:
      localm.n("30isdownload", i + ",");
      localObject1 = new StringBuilder();
      if (!bool2) {
        break label569;
      }
    }
    label530:
    label554:
    label559:
    label564:
    label569:
    for (int i = v.Ie((String)localObject2);; i = 0)
    {
      localm.n("31chatroom_membercount", i + ",");
      ((j)g.af(j.class)).b(((j)g.af(j.class)).ag(localca), localm);
      Log.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + localm.abW());
      com.tencent.mm.plugin.report.service.h.CyF.a(12989, new Object[] { localm });
      AppMethodBeat.o(35234);
      return;
      if (bool2)
      {
        localObject1 = bp.Ks(localca.field_content);
        break;
      }
      localObject1 = localObject2;
      break;
      i = 2;
      break label216;
      i = 3;
      break label252;
      i = 0;
      break label390;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.o.1
 * JD-Core Version:    0.7.0.1
 */