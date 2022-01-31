package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.y;
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
    l locall = this.nRa;
    long l = System.currentTimeMillis();
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw();
    Object localObject2 = new ArrayList();
    ((List)localObject2).add("tmessage");
    ((List)localObject2).add("officialaccounts");
    ((List)localObject2).add("filehelper");
    ((List)localObject2).add("helper_entry");
    ((List)localObject2).add(q.Gj());
    bq localbq = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().Ic("@t.qq.com");
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
        ((ad)localObject2).d((Cursor)localObject1);
        localLinkedList.add(((ao)localObject2).field_username);
        ((Cursor)localObject1).moveToNext();
      }
      ((Cursor)localObject1).close();
    }
    y.i("MicroMsg.UnfamiliarContactEngine", "[getQuery] cost:%sms list size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localLinkedList.size()) });
    l.a(locall, localLinkedList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l.1
 * JD-Core Version:    0.7.0.1
 */