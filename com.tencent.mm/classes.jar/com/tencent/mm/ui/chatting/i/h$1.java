package com.tencent.mm.ui.chatting.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
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
    AppMethodBeat.i(32641);
    LinkedList localLinkedList = new LinkedList();
    aw.aaz();
    Cursor localCursor = com.tencent.mm.model.c.YC().cE(this.zPF.ejr, this.zPF.elr);
    if (localCursor == null)
    {
      ab.e("MicroMsg.UrlHistoryListPresenter", "[loadData] cursor is null!");
      AppMethodBeat.o(32641);
      return;
    }
    u localu;
    long l1;
    if (t.lA(this.zPF.ejr))
    {
      aw.aaz();
      localu = com.tencent.mm.model.c.YJ().oU(this.zPF.ejr);
      l1 = 0L;
    }
    label614:
    for (;;)
    {
      try
      {
        if (localCursor.moveToNext())
        {
          bi localbi = new bi();
          localbi.convertFrom(localCursor);
          Object localObject1 = localbi.field_content;
          if (localObject1 == null) {
            continue;
          }
          j.b localb = j.b.mY((String)localObject1);
          if (localb == null) {
            continue;
          }
          localObject1 = this.zPF;
          int i = localb.type;
          ((h)localObject1).getType();
          if (!((h)localObject1).zPE.contains(Integer.valueOf(i))) {
            continue;
          }
          localObject1 = new Date(localbi.field_createTime);
          long l2 = a.dNj().b((Date)localObject1);
          if (l1 != l2)
          {
            localLinkedList.add(new c.c(localbi.field_createTime));
            localObject1 = this.zPF;
            ((h)localObject1).zPk += 1;
          }
          localObject1 = h.b(localbi, t.lA(this.zPF.ejr));
          ad localad1 = ((j)g.E(j.class)).YA().arw((String)localObject1);
          Object localObject3 = "";
          if (localu != null) {
            localObject3 = localu.nE((String)localObject1);
          }
          i = com.tencent.mm.plugin.fav.ui.c.NV(localb.fgx);
          localObject1 = b.getAppName(this.zPF.mContext, localb.cGN);
          aw.aaz();
          ad localad2 = com.tencent.mm.model.c.YA().arw(localb.cGN);
          if ((localad2 == null) || (!localad2.field_username.equals(localb.cGN)))
          {
            ao.a.flI.a(localb.cGN, "", null);
            localObject3 = new h.a(this.zPF, localbi.field_createTime, localb.type, localb.title, localbi.field_msgId, localad1.field_username, localad1.Oe(), localad1.field_conRemark, (String)localObject3);
            if (!bo.isNullOrNil((String)localObject1)) {
              break label614;
            }
            localObject1 = localb.description;
            ((h.a)localObject3).source = ((String)localObject1);
            ((h.a)localObject3).appId = localb.appId;
            if (bo.isNullOrNil(localbi.field_imgPath))
            {
              ((h.a)localObject3).imagePath = localb.thumburl;
              ((h.a)localObject3).iconRes = i;
              localLinkedList.add(localObject3);
              l1 = l2;
            }
          }
          else
          {
            localObject1 = localad2.Of();
            continue;
          }
          ((h.a)localObject3).imagePath = localbi.field_imgPath;
          continue;
        }
        localCursor.close();
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(32641);
      }
      this.zPF.iVH.addAll(localLinkedList);
      this.zPF.zPe = this.zPF.iVH;
      localLinkedList.clear();
      al.d(new h.1.1(this));
      AppMethodBeat.o(32641);
      return;
      localu = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.h.1
 * JD-Core Version:    0.7.0.1
 */