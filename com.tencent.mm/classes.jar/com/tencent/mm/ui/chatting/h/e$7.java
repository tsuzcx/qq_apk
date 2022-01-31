package com.tencent.mm.ui.chatting.h;

import android.database.Cursor;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.o;
import com.tencent.mm.ui.chatting.a.b.c;
import com.tencent.mm.ui.gridviewheaders.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

final class e$7
  implements Runnable
{
  e$7(e parame, boolean paramBoolean, int paramInt) {}
  
  public final void run()
  {
    label90:
    LinkedList localLinkedList;
    if (this.kik)
    {
      if (e.i(this.vyV) == -1L)
      {
        localObject1 = this.vyV;
        au.Hx();
        e.b((e)localObject1, c.Fy().HS(e.j(this.vyV)));
      }
    }
    else
    {
      if ((this.ejr < 0) || (e.k(this.vyV) - this.ejr <= 200)) {
        break label233;
      }
      i = e.k(this.vyV) - this.ejr;
      y.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", new Object[] { Integer.valueOf(this.ejr), Integer.valueOf(i) });
      localLinkedList = new LinkedList();
      if (e.i(this.vyV) != -1L) {
        break label240;
      }
      au.Hx();
    }
    for (Object localObject1 = c.Fy().X(e.j(this.vyV), e.a(this.vyV).size() - e.l(this.vyV), i);; localObject1 = c.Fz().b(e.j(this.vyV), e.i(this.vyV), e.a(this.vyV).size() - e.l(this.vyV), i))
    {
      if (localObject1 != null) {
        break label288;
      }
      y.e("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] NULL == cursor ");
      return;
      localObject1 = this.vyV;
      au.Hx();
      e.b((e)localObject1, c.Fz().az(e.j(this.vyV), e.i(this.vyV)));
      break;
      label233:
      i = 200;
      break label90;
      label240:
      au.Hx();
    }
    label288:
    long l1 = 0L;
    Object localObject3;
    for (;;)
    {
      try
      {
        Date localDate1;
        if (((Cursor)localObject1).moveToNext())
        {
          localObject3 = new bi();
          ((bi)localObject3).d((Cursor)localObject1);
          localDate1 = new Date(((cs)localObject3).field_createTime);
          l2 = a.cIz().b(localDate1);
          if (l1 != l2)
          {
            localLinkedList.add(new b.c(((cs)localObject3).field_createTime));
            e.m(this.vyV);
          }
          localLinkedList.add(new b.c((bi)localObject3));
          l1 = l2;
          continue;
        }
        ((Cursor)localObject1).close();
        localObject3 = new LinkedList();
        if (localLinkedList.size() - e.l(this.vyV) != i) {
          break label780;
        }
        l1 = ((b.c)localLinkedList.get(0)).timeStamp;
        a.cIz();
        l2 = a.ig(l1);
        y.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] list size:%s start:%s end:%s", new Object[] { Integer.valueOf(localLinkedList.size()), Long.valueOf(l2), Long.valueOf(l1) });
        if (e.i(this.vyV) == -1L)
        {
          au.Hx();
          localObject1 = c.Fy().p(e.j(this.vyV), l2, l1);
          localDate1 = new Date(l1);
          l1 = a.cIz().b(localDate1);
          if (localObject1 == null) {
            break;
          }
          try
          {
            if (!((Cursor)localObject1).moveToNext()) {
              break;
            }
            bi localbi = new bi();
            localbi.d((Cursor)localObject1);
            Date localDate2 = new Date(localbi.field_createTime);
            l2 = a.cIz().b(localDate2);
            if ((l1 == l2) || (a.cIz().b(localDate1) == l2)) {
              break label728;
            }
            ((LinkedList)localObject3).add(new b.c(localbi.field_createTime));
            e.m(this.vyV);
            ((LinkedList)localObject3).add(new b.c(localbi));
            l1 = l2;
            continue;
          }
          finally
          {
            if (localObject1 == null) {}
          }
        }
        au.Hx();
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
      localObject1 = c.Fz().b(e.j(this.vyV), e.i(this.vyV), l2, l1);
      continue;
      label728:
      long l2 = l1;
      if (localCollection.size() > 0)
      {
        l2 = l1;
        if (((LinkedList)localObject3).size() == 0)
        {
          ((LinkedList)localObject3).add(0, localCollection.remove(0));
          l2 = l1;
        }
      }
    }
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    label780:
    int i = localCollection.size();
    int j = ((LinkedList)localObject3).size();
    e.a(this.vyV).addAll(0, (Collection)localObject3);
    e.a(this.vyV).addAll(((LinkedList)localObject3).size(), localCollection);
    localCollection.clear();
    ((LinkedList)localObject3).clear();
    e.n(this.vyV);
    y.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", new Object[] { Integer.valueOf(e.a(this.vyV).size()) });
    ai.d(new e.7.1(this, i + j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.e.7
 * JD-Core Version:    0.7.0.1
 */