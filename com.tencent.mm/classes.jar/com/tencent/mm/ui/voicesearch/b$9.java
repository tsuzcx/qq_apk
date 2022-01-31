package com.tencent.mm.ui.voicesearch;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.List;

final class b$9
  implements Runnable
{
  b$9(b paramb, boolean paramBoolean) {}
  
  public final void run()
  {
    int i = 0;
    Object localObject2;
    Object localObject3;
    if ((b.g(this.wiQ) != null) && (b.g(this.wiQ).length != 0))
    {
      localObject1 = new ArrayList();
      localObject2 = b.g(this.wiQ);
      int j = localObject2.length;
      while (i < j)
      {
        localObject3 = localObject2[i];
        if (this.wiQ.aev((String)localObject3)) {
          ((List)localObject1).add(localObject3);
        }
        i += 1;
      }
      if (((List)localObject1).size() > 0)
      {
        localObject2 = this.wiQ;
        au.Hx();
        b.a((b)localObject2, c.Fw().a((String[])((List)localObject1).toArray(new String[((List)localObject1).size()]), b.h(this.wiQ), b.a(this.wiQ)));
        return;
      }
      localObject1 = this.wiQ;
      au.Hx();
      b.b((b)localObject1, c.Fw().cuz());
      return;
    }
    if (b.i(this.wiQ) != null)
    {
      if (!b.h(this.wiQ).equals("@all.chatroom.contact"))
      {
        localObject1 = au.Hx().dUi.a(b.i(this.wiQ), b.h(this.wiQ), b.a(this.wiQ), true);
        b.c(this.wiQ, (Cursor)localObject1);
        return;
      }
      if (this.wuD)
      {
        localObject1 = au.Hx().dUi.a(b.i(this.wiQ), "@micromsg.with.all.biz.qq.com.openim", b.a(this.wiQ), false);
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
      }
      for (;;)
      {
        if (!((Cursor)localObject1).moveToNext()) {
          break label373;
        }
        String str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("username"));
        if (!s.gZ(str))
        {
          ((ArrayList)localObject2).add(str);
          continue;
          localObject1 = au.Hx().dUi.a(b.i(this.wiQ), "@micromsg.with.all.biz.qq.com", b.a(this.wiQ), false);
          break;
        }
        ((ArrayList)localObject3).add(str);
      }
      label373:
      if (!((Cursor)localObject1).isClosed()) {
        ((Cursor)localObject1).close();
      }
      if ((((ArrayList)localObject2).size() != 0) || (((ArrayList)localObject3).size() != 0)) {}
      for (localObject1 = au.Hx().dUi.a(b.i(this.wiQ), (ArrayList)localObject2, null, (ArrayList)localObject3, b.a(this.wiQ));; localObject1 = c.Fw().cuz())
      {
        b.d(this.wiQ, (Cursor)localObject1);
        return;
        au.Hx();
      }
    }
    Object localObject1 = this.wiQ;
    au.Hx();
    b.e((b)localObject1, c.Fw().cuz());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b.9
 * JD-Core Version:    0.7.0.1
 */