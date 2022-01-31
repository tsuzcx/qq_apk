package com.tencent.mm.ui.chatting.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.a.c.c;
import com.tencent.mm.ui.chatting.e.b.b;
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
    AppMethodBeat.i(32538);
    LinkedList localLinkedList = new LinkedList();
    aw.aaz();
    Cursor localCursor = com.tencent.mm.model.c.YC().cE(this.zPl.ejr, this.zPl.elr);
    if (localCursor == null)
    {
      ab.e("MicroMsg.FileHistoryListPresenter", "[loadData] cursor is null!");
      AppMethodBeat.o(32538);
      return;
    }
    if (t.lA(this.zPl.ejr)) {
      aw.aaz();
    }
    Object localObject2;
    for (u localu = com.tencent.mm.model.c.YJ().oU(this.zPl.ejr);; localObject2 = null)
    {
      long l1 = 0L;
      try
      {
        while (localCursor.moveToNext())
        {
          bi localbi = new bi();
          localbi.convertFrom(localCursor);
          Object localObject3 = localbi.field_content;
          if (localObject3 != null)
          {
            j.b localb = j.b.mY((String)localObject3);
            if (localb != null)
            {
              if (6 == localb.type) {}
              for (int i = 1; i != 0; i = 0)
              {
                localObject3 = new Date(localbi.field_createTime);
                long l2 = a.dNj().b((Date)localObject3);
                if (l1 != l2)
                {
                  localLinkedList.add(new c.c(localbi.field_createTime));
                  localObject3 = this.zPl;
                  ((d)localObject3).zPk += 1;
                }
                String str = d.b(localbi, t.lA(this.zPl.ejr));
                ad localad = ((j)g.E(j.class)).YA().arw(str);
                localObject3 = "";
                if (localu != null) {
                  localObject3 = localu.nE(str);
                }
                i = com.tencent.mm.plugin.fav.ui.c.NV(localb.fgx);
                localObject3 = new d.a(this.zPl, localbi.field_createTime, localb.type, localb.title, localbi.field_msgId, localad.field_username, localad.Oe(), localad.field_conRemark, (String)localObject3);
                ((d.a)localObject3).iconRes = i;
                ((d.a)localObject3).desc = bo.hk(localb.fgw);
                localLinkedList.add(localObject3);
                l1 = l2;
                break;
              }
            }
          }
        }
        localCursor.close();
        this.zPl.iVH.addAll(localLinkedList);
        this.zPl.zPe = this.zPl.iVH;
        localLinkedList.clear();
        ab.i("MicroMsg.FileHistoryListPresenter", "[loadData] data:%s", new Object[] { Integer.valueOf(this.zPl.iVH.size()) });
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(32537);
            if (d.1.this.zPl.zPc != null) {
              d.1.this.zPl.zPc.s(d.1.this.kFC, d.1.this.zPl.iVH.size());
            }
            AppMethodBeat.o(32537);
          }
        });
        AppMethodBeat.o(32538);
        return;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(32538);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.d.1
 * JD-Core Version:    0.7.0.1
 */