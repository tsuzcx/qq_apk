package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class l$1
  implements Runnable
{
  public l$1(l paraml) {}
  
  public final void run()
  {
    AppMethodBeat.i(126865);
    l locall = this.qEX;
    long l = System.currentTimeMillis();
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = ((j)g.E(j.class)).YA();
    Object localObject2 = new ArrayList();
    ((List)localObject2).add("tmessage");
    ((List)localObject2).add("officialaccounts");
    ((List)localObject2).add("filehelper");
    ((List)localObject2).add("helper_entry");
    ((List)localObject2).add(r.Zn());
    bq localbq = ((j)g.E(j.class)).YI().TL("@t.qq.com");
    if (localbq != null) {
      ((List)localObject2).add(localbq.name);
    }
    ((List)localObject2).add("blogapp");
    localObject1 = ((bd)localObject1).a("@all.contact.without.chatroom", null, (List)localObject2, null, false, false);
    if (localObject1 != null)
    {
      ((Cursor)localObject1).moveToFirst();
      while (!((Cursor)localObject1).isAfterLast())
      {
        localObject2 = new ad();
        ((ad)localObject2).convertFrom((Cursor)localObject1);
        localLinkedList.add(((aq)localObject2).field_username);
        ((Cursor)localObject1).moveToNext();
      }
      ((Cursor)localObject1).close();
    }
    ab.i("MicroMsg.UnfamiliarContactEngine", "[getQuery] cost:%sms list size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localLinkedList.size()) });
    l.a(locall, localLinkedList);
    AppMethodBeat.o(126865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l.1
 * JD-Core Version:    0.7.0.1
 */