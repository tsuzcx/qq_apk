package com.tencent.mm.ui.chatting.h;

import android.database.Cursor;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.gridviewheaders.a;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

final class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public final void run()
  {
    LinkedList localLinkedList = new LinkedList();
    au.Hx();
    Cursor localCursor = com.tencent.mm.model.c.Fy().bO(this.vyO.drJ, this.vyO.hkM);
    if (localCursor == null)
    {
      y.e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
      return;
    }
    if (s.fn(this.vyO.drJ)) {
      au.Hx();
    }
    Object localObject2;
    for (u localu = com.tencent.mm.model.c.FF().in(this.vyO.drJ);; localObject2 = null)
    {
      long l1 = 0L;
      try
      {
        while (localCursor.moveToNext())
        {
          bi localbi = new bi();
          localbi.d(localCursor);
          Object localObject3 = localbi.field_content;
          if (localObject3 != null)
          {
            g.a locala = g.a.gp((String)localObject3);
            if (locala != null)
            {
              if (6 == locala.type) {}
              for (int i = 1; i != 0; i = 0)
              {
                localObject3 = new Date(localbi.field_createTime);
                long l2 = a.cIz().b((Date)localObject3);
                if (l1 != l2)
                {
                  localLinkedList.add(new c.c(localbi.field_createTime));
                  localObject3 = this.vyO;
                  ((d)localObject3).vyN += 1;
                }
                String str = d.j(localbi, s.fn(this.vyO.drJ));
                ad localad = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(str);
                localObject3 = "";
                if (localu != null) {
                  localObject3 = localu.gV(str);
                }
                i = com.tencent.mm.plugin.fav.ui.c.CT(locala.dQw);
                localObject3 = new d.a(this.vyO, localbi.field_createTime, locala.type, locala.title, localbi.field_msgId, localad.field_username, localad.Bp(), localad.field_conRemark, (String)localObject3);
                ((d.a)localObject3).iconRes = i;
                ((d.a)localObject3).desc = bk.cm(locala.dQv);
                localLinkedList.add(localObject3);
                l1 = l2;
                break;
              }
            }
          }
        }
        localCursor.close();
        this.vyO.hka.addAll(localLinkedList);
        this.vyO.vyF = this.vyO.hka;
        localLinkedList.clear();
        y.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", new Object[] { Integer.valueOf(this.vyO.hka.size()) });
        ai.d(new d.1.1(this));
        return;
      }
      finally
      {
        localCursor.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.d.1
 * JD-Core Version:    0.7.0.1
 */