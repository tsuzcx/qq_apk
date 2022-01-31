package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class ReaderAppUI$2
  implements n.d
{
  ReaderAppUI$2(ReaderAppUI paramReaderAppUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    paramInt = paramMenuItem.getGroupId();
    switch (paramMenuItem.getItemId())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = (String)ReaderAppUI.b(this.noS).getItem(paramInt);
            if (!com.tencent.mm.sdk.platformtools.bk.bl((String)localObject1))
            {
              g.cl((String)localObject1, ReaderAppUI.a(this.noS));
              paramMenuItem = g.buZ();
              paramInt = ReaderAppUI.a(this.noS);
              localObject1 = "delete from " + com.tencent.mm.model.bk.hT(paramInt) + " where reserved3 = " + h.fA((String)localObject1);
              y.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", new Object[] { localObject1 });
              if (paramMenuItem.dXo.gk(com.tencent.mm.model.bk.hT(paramInt), (String)localObject1))
              {
                paramMenuItem.hW(paramInt);
                paramMenuItem.doNotify();
              }
            }
            this.noS.refresh();
            return;
          } while (ReaderAppUI.a(this.noS) != 20);
          paramMenuItem = (String)ReaderAppUI.b(this.noS).getItem(paramInt);
          paramMenuItem = g.buZ().I(paramMenuItem, ReaderAppUI.a(this.noS));
        } while (paramMenuItem.size() <= 0);
        paramMenuItem = (bj)paramMenuItem.get(0);
        localObject1 = new g.a();
        ((g.a)localObject1).title = paramMenuItem.getTitle();
        ((g.a)localObject1).description = paramMenuItem.getDigest();
        ((g.a)localObject1).action = "view";
        ((g.a)localObject1).type = 5;
        ((g.a)localObject1).url = paramMenuItem.getUrl();
        localObject2 = g.a.a((g.a)localObject1, null, null);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Retr_Msg_content", (String)localObject2);
        ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
        ((Intent)localObject1).putExtra("Retr_Msg_thumb_path", q.y(paramMenuItem.Ia(), paramMenuItem.type, "@T"));
        ((Intent)localObject1).putExtra("Retr_Msg_Id", 7377812);
        localObject2 = u.ij(paramMenuItem.dXl);
        ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
        localObject2 = u.Hc().v((String)localObject2, true);
        ((u.b)localObject2).h("prePublishId", "msg_" + paramMenuItem.dXl);
        ((u.b)localObject2).h("preUsername", "newsapp");
        ((u.b)localObject2).h("preChatName", "newsapp");
        ((u.b)localObject2).h("preMsgIndex", Integer.valueOf(0));
        ((u.b)localObject2).h("sendAppMsgScene", Integer.valueOf(1));
        com.tencent.mm.plugin.readerapp.b.a.eUR.l((Intent)localObject1, this.noS);
        return;
      } while (ReaderAppUI.a(this.noS) != 20);
      paramMenuItem = (String)ReaderAppUI.b(this.noS).getItem(paramInt);
      localObject1 = g.buZ().I(paramMenuItem, ReaderAppUI.a(this.noS));
    } while (((List)localObject1).isEmpty());
    y.i("MicroMsg.ReaderAppUI", "fav functionId %s, index %d, size %d", new Object[] { paramMenuItem, Integer.valueOf(ReaderAppUI.c(this.noS)), Integer.valueOf(((List)localObject1).size()) });
    if (ReaderAppUI.c(this.noS) >= ((List)localObject1).size()) {
      ReaderAppUI.a(this.noS, 0);
    }
    paramMenuItem = (bj)((List)localObject1).get(ReaderAppUI.c(this.noS));
    Object localObject1 = new cj();
    Object localObject2 = u.ij(paramMenuItem.dXl);
    u.b localb = u.Hc().v((String)localObject2, true);
    localb.h("prePublishId", "msg_" + paramMenuItem.dXl);
    localb.h("preUsername", "newsapp");
    localb.h("preChatName", "newsapp");
    localb.h("preMsgIndex", Integer.valueOf(0));
    localb.h("sendAppMsgScene", Integer.valueOf(1));
    ((cj)localObject1).bIw.bIB = ((String)localObject2);
    com.tencent.mm.plugin.readerapp.c.b.a((cj)localObject1, paramMenuItem, ReaderAppUI.c(this.noS));
    ((cj)localObject1).bIw.bID = 7;
    ((cj)localObject1).bIw.activity = this.noS;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.2
 * JD-Core Version:    0.7.0.1
 */