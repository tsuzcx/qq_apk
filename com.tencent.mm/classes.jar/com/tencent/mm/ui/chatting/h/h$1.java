package com.tencent.mm.ui.chatting.h;

import android.database.Cursor;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.af;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.a.b;
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
import java.util.HashSet;
import java.util.LinkedList;

final class h$1
  implements Runnable
{
  h$1(h paramh) {}
  
  public final void run()
  {
    LinkedList localLinkedList = new LinkedList();
    au.Hx();
    Cursor localCursor = com.tencent.mm.model.c.Fy().bO(this.vzi.drJ, this.vzi.hkM);
    if (localCursor == null)
    {
      y.e("MicroMsg.UrlHistoryListPresenter", "[loadData] cursor is null!");
      return;
    }
    u localu;
    long l1;
    if (s.fn(this.vzi.drJ))
    {
      au.Hx();
      localu = com.tencent.mm.model.c.FF().in(this.vzi.drJ);
      l1 = 0L;
    }
    label590:
    for (;;)
    {
      try
      {
        if (localCursor.moveToNext())
        {
          bi localbi = new bi();
          localbi.d(localCursor);
          Object localObject1 = localbi.field_content;
          if (localObject1 == null) {
            continue;
          }
          g.a locala = g.a.gp((String)localObject1);
          if (locala == null) {
            continue;
          }
          localObject1 = this.vzi;
          int i = locala.type;
          ((h)localObject1).getType();
          if (!((h)localObject1).vzh.contains(Integer.valueOf(i))) {
            continue;
          }
          localObject1 = new Date(localbi.field_createTime);
          long l2 = a.cIz().b((Date)localObject1);
          if (l1 != l2)
          {
            localLinkedList.add(new c.c(localbi.field_createTime));
            localObject1 = this.vzi;
            ((h)localObject1).vyN += 1;
          }
          localObject1 = h.j(localbi, s.fn(this.vzi.drJ));
          ad localad1 = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl((String)localObject1);
          Object localObject3 = "";
          if (localu != null) {
            localObject3 = localu.gV((String)localObject1);
          }
          i = com.tencent.mm.plugin.fav.ui.c.CT(locala.dQw);
          localObject1 = b.getAppName(this.vzi.mContext, locala.bYG);
          au.Hx();
          ad localad2 = com.tencent.mm.model.c.Fw().abl(locala.bYG);
          if ((localad2 == null) || (!localad2.field_username.equals(locala.bYG)))
          {
            am.a.dVy.a(locala.bYG, "", null);
            localObject3 = new h.a(this.vzi, localbi.field_createTime, locala.type, locala.title, localbi.field_msgId, localad1.field_username, localad1.Bp(), localad1.field_conRemark, (String)localObject3);
            if (!bk.bl((String)localObject1)) {
              break label590;
            }
            localObject1 = locala.description;
            ((h.a)localObject3).aWf = ((String)localObject1);
            ((h.a)localObject3).appId = locala.appId;
            if (bk.bl(localbi.field_imgPath))
            {
              ((h.a)localObject3).imagePath = locala.thumburl;
              ((h.a)localObject3).iconRes = i;
              localLinkedList.add(localObject3);
              l1 = l2;
            }
          }
          else
          {
            localObject1 = localad2.Bq();
            continue;
          }
          ((h.a)localObject3).imagePath = localbi.field_imgPath;
          continue;
        }
      }
      finally
      {
        localCursor.close();
      }
      this.vzi.hka.addAll(localLinkedList);
      this.vzi.vyF = this.vzi.hka;
      localLinkedList.clear();
      ai.d(new h.1.1(this));
      return;
      localu = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.h.1
 * JD-Core Version:    0.7.0.1
 */