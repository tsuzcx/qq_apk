package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bm;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.readerapp.c.g;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class ReaderAppUI$2
  implements n.d
{
  ReaderAppUI$2(ReaderAppUI paramReaderAppUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(76814);
    paramInt = paramMenuItem.getGroupId();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(76814);
      return;
      Object localObject1 = (String)ReaderAppUI.b(this.pUg).getItem(paramInt);
      if (!bo.isNullOrNil((String)localObject1))
      {
        g.de((String)localObject1, ReaderAppUI.a(this.pUg));
        paramMenuItem = g.cfl();
        paramInt = ReaderAppUI.a(this.pUg);
        localObject1 = "delete from " + bm.kG(paramInt) + " where reserved3 = " + h.escape((String)localObject1);
        ab.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", new Object[] { localObject1 });
        if (paramMenuItem.fnw.execSQL(bm.kG(paramInt), (String)localObject1))
        {
          paramMenuItem.kJ(paramInt);
          paramMenuItem.doNotify();
        }
      }
      this.pUg.refresh();
      AppMethodBeat.o(76814);
      return;
      if (ReaderAppUI.a(this.pUg) == 20)
      {
        paramMenuItem = (String)ReaderAppUI.b(this.pUg).getItem(paramInt);
        paramMenuItem = g.cfl().Q(paramMenuItem, ReaderAppUI.a(this.pUg));
        Object localObject2;
        if (paramMenuItem.size() > 0)
        {
          paramMenuItem = (bl)paramMenuItem.get(0);
          localObject1 = new j.b();
          ((j.b)localObject1).title = paramMenuItem.getTitle();
          ((j.b)localObject1).description = paramMenuItem.getDigest();
          ((j.b)localObject1).action = "view";
          ((j.b)localObject1).type = 5;
          ((j.b)localObject1).url = paramMenuItem.getUrl();
          localObject2 = j.b.a((j.b)localObject1, null, null);
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("Retr_Msg_content", (String)localObject2);
          ((Intent)localObject1).putExtra("Retr_Msg_Type", 2);
          ((Intent)localObject1).putExtra("Retr_Msg_thumb_path", p.aln(paramMenuItem.aaZ()));
          ((Intent)localObject1).putExtra("Retr_Msg_Id", 7377812);
          localObject2 = v.oQ(paramMenuItem.fnt);
          ((Intent)localObject1).putExtra("reportSessionId", (String)localObject2);
          localObject2 = v.aae().z((String)localObject2, true);
          ((v.b)localObject2).i("prePublishId", "msg_" + paramMenuItem.fnt);
          ((v.b)localObject2).i("preUsername", "newsapp");
          ((v.b)localObject2).i("preChatName", "newsapp");
          ((v.b)localObject2).i("preMsgIndex", Integer.valueOf(0));
          ((v.b)localObject2).i("sendAppMsgScene", Integer.valueOf(1));
          com.tencent.mm.plugin.readerapp.b.a.gmO.k((Intent)localObject1, this.pUg);
        }
        AppMethodBeat.o(76814);
        return;
        if (ReaderAppUI.a(this.pUg) == 20)
        {
          paramMenuItem = (String)ReaderAppUI.b(this.pUg).getItem(paramInt);
          localObject1 = g.cfl().Q(paramMenuItem, ReaderAppUI.a(this.pUg));
          if (!((List)localObject1).isEmpty())
          {
            ab.i("MicroMsg.ReaderAppUI", "fav functionId %s, index %d, size %d", new Object[] { paramMenuItem, Integer.valueOf(ReaderAppUI.c(this.pUg)), Integer.valueOf(((List)localObject1).size()) });
            if (ReaderAppUI.c(this.pUg) >= ((List)localObject1).size()) {
              ReaderAppUI.a(this.pUg, 0);
            }
            paramMenuItem = (bl)((List)localObject1).get(ReaderAppUI.c(this.pUg));
            localObject1 = new cm();
            localObject2 = v.oQ(paramMenuItem.fnt);
            v.b localb = v.aae().z((String)localObject2, true);
            localb.i("prePublishId", "msg_" + paramMenuItem.fnt);
            localb.i("preUsername", "newsapp");
            localb.i("preChatName", "newsapp");
            localb.i("preMsgIndex", Integer.valueOf(0));
            localb.i("sendAppMsgScene", Integer.valueOf(1));
            ((cm)localObject1).cpR.cpW = ((String)localObject2);
            ReaderAppUI.c(this.pUg);
            com.tencent.mm.plugin.readerapp.c.b.a((cm)localObject1, paramMenuItem);
            ((cm)localObject1).cpR.cpY = 7;
            ((cm)localObject1).cpR.activity = this.pUg;
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderAppUI.2
 * JD-Core Version:    0.7.0.1
 */