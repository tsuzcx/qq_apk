package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.n.d;

final class g$1
  implements n.d
{
  g$1(g paramg) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = 4;
    AppMethodBeat.i(34260);
    label58:
    label243:
    Object localObject1;
    label156:
    Object localObject2;
    switch (paramMenuItem.getItemId())
    {
    default: 
      paramInt = -1;
      if (paramInt > 0)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(11090, new Object[] { Integer.valueOf(paramInt) });
        ab.d("MicroMsg.ConversationClickListener", "jacks kv long click: %d", new Object[] { Integer.valueOf(paramInt) });
      }
      AppMethodBeat.o(34260);
      return;
    case 4: 
      if (t.lA(g.a(this.AiS)))
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(14553, new Object[] { Integer.valueOf(1), Integer.valueOf(1), g.a(this.AiS) });
        paramMenuItem = g.b(this.AiS).yMq;
        if (paramMenuItem == null) {
          break label474;
        }
        ab.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg[%s, %s, %s]", new Object[] { g.a(this.AiS), g.c(this.AiS), g.b(this.AiS).field_username, Long.valueOf(paramMenuItem.field_msgId), paramMenuItem.field_content, Long.valueOf(paramMenuItem.field_createTime) });
        if (f.rT(g.a(this.AiS)))
        {
          localObject1 = z.aft();
          paramInt = g.d(this.AiS);
          int i = g.b(this.AiS).field_unReadCount;
          localObject2 = g.a(this.AiS);
          ((k)localObject1).fwz = new caf();
          ((k)localObject1).fwz.xLM = paramInt;
          ((k)localObject1).fwz.xLK = i;
          if (paramMenuItem != null) {
            break label1125;
          }
          paramMenuItem = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().Tm((String)localObject2);
        }
      }
      break;
    }
    label474:
    label1125:
    for (;;)
    {
      if (paramMenuItem != null)
      {
        ((k)localObject1).fwz.xLL = paramMenuItem.getType();
        if (((k)localObject1).fwz.xLK > 0) {
          ((k)localObject1).fwz.xLJ = ((int)(System.currentTimeMillis() - paramMenuItem.field_createTime) / 1000);
        }
      }
      k.a(((k)localObject1).fwz, (String)localObject2);
      c.a(g.a(this.AiS), g.c(this.AiS), g.b(this.AiS), null, true, false);
      paramInt = 1;
      break label58;
      com.tencent.mm.plugin.report.service.h.qsU.e(14553, new Object[] { Integer.valueOf(0), Integer.valueOf(1), g.a(this.AiS) });
      break label156;
      ab.i("MicroMsg.ConversationClickListener", "summerdel talker[%s] activity[%s] username[%s] latestInsertMsg is null", new Object[] { g.a(this.AiS), g.c(this.AiS), g.b(this.AiS).field_username });
      break label243;
      ab.d("MicroMsg.ConversationClickListener", "placed to the top");
      t.x(g.a(this.AiS), true);
      aw.aaz();
      paramMenuItem = com.tencent.mm.model.c.YA().arw(g.a(this.AiS));
      if ((paramMenuItem != null) && (paramMenuItem.dwz())) {
        com.tencent.mm.plugin.report.service.h.qsU.e(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1) });
      }
      com.tencent.mm.ui.base.h.bO(g.c(this.AiS), g.c(this.AiS).getString(2131301407));
      com.tencent.mm.modelstat.b.fRu.c(true, g.a(this.AiS), true);
      break label58;
      ab.d("MicroMsg.ConversationClickListener", "unplaced to the top");
      t.y(g.a(this.AiS), true);
      aw.aaz();
      paramMenuItem = com.tencent.mm.model.c.YA().arw(g.a(this.AiS));
      if ((paramMenuItem != null) && (paramMenuItem.dwz())) {
        com.tencent.mm.plugin.report.service.h.qsU.e(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1) });
      }
      com.tencent.mm.ui.base.h.bO(g.c(this.AiS), g.c(this.AiS).getString(2131301408));
      com.tencent.mm.modelstat.b.fRu.c(true, g.a(this.AiS), false);
      paramInt = 5;
      break label58;
      ab.d("MicroMsg.ConversationClickListener", "jacks mark read: %s", new Object[] { g.a(this.AiS) });
      aw.aaz();
      com.tencent.mm.model.c.YF().arJ(g.a(this.AiS));
      MMAppMgr.cancelNotification(g.a(this.AiS));
      aa.ab(g.a(this.AiS), 1);
      com.tencent.mm.modelstat.b.fRu.R(g.a(this.AiS), false);
      com.tencent.mm.aq.b.agX();
      com.tencent.mm.aq.b.sS(g.a(this.AiS));
      paramInt = 3;
      break label58;
      ab.d("MicroMsg.ConversationClickListener", "jacks set unread: %s", new Object[] { g.a(this.AiS) });
      aw.aaz();
      com.tencent.mm.model.c.YF().arL(g.a(this.AiS));
      com.tencent.mm.modelstat.b.fRu.R(g.a(this.AiS), true);
      paramInt = 2;
      break label58;
      ab.d("MicroMsg.ConversationClickListener", "jacks clear history: %s", new Object[] { g.a(this.AiS) });
      t.lA(g.a(this.AiS));
      paramMenuItem = g.a(this.AiS);
      localObject1 = g.c(this.AiS);
      localObject2 = new PBool();
      ((PBool)localObject2).value = false;
      ((Context)localObject1).getString(2131297087);
      bf.a(paramMenuItem, new c.6((PBool)localObject2, com.tencent.mm.ui.base.h.b((Context)localObject1, ((Context)localObject1).getString(2131297112), true, new c.5((PBool)localObject2))));
      paramInt = -1;
      break label58;
      ab.d("MicroMsg.ConversationClickListener", "delete biz service: %s", new Object[] { g.a(this.AiS) });
      aw.aaz();
      paramMenuItem = com.tencent.mm.model.c.YA().arw(g.a(this.AiS));
      com.tencent.mm.ui.tools.b.a(f.rS(g.a(this.AiS)), g.c(this.AiS), paramMenuItem, 1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.g.1
 * JD-Core Version:    0.7.0.1
 */