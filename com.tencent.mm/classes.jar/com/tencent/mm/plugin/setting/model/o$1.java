package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cj;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class o$1
  implements Runnable
{
  public o$1(o paramo) {}
  
  public final void run()
  {
    AppMethodBeat.i(73787);
    o localo = this.JdN;
    long l = System.currentTimeMillis();
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = ((n)h.ae(n.class)).bbL();
    Object localObject2 = new ArrayList();
    ((List)localObject2).add("tmessage");
    ((List)localObject2).add("officialaccounts");
    ((List)localObject2).add("filehelper");
    ((List)localObject2).add("helper_entry");
    ((List)localObject2).add(z.bcZ());
    cj localcj = ((n)h.ae(n.class)).bbU().aPi("@t.qq.com");
    if (localcj != null) {
      ((List)localObject2).add(localcj.name);
    }
    ((List)localObject2).add("blogapp");
    localObject1 = ((bv)localObject1).a("@all.contact.without.chatroom", null, (List)localObject2, null, false, false);
    if (localObject1 != null)
    {
      ((Cursor)localObject1).moveToFirst();
      while (!((Cursor)localObject1).isAfterLast())
      {
        localObject2 = new as();
        ((as)localObject2).convertFrom((Cursor)localObject1);
        localLinkedList.add(((ax)localObject2).field_username);
        ((Cursor)localObject1).moveToNext();
      }
      ((Cursor)localObject1).close();
    }
    Log.i("MicroMsg.UnfamiliarContactEngine", "[getQuery] cost:%sms list size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(localLinkedList.size()) });
    o.a(localo, localLinkedList);
    AppMethodBeat.o(73787);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.o.1
 * JD-Core Version:    0.7.0.1
 */