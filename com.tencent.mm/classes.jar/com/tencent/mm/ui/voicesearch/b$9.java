package com.tencent.mm.ui.voicesearch;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
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
    AppMethodBeat.i(35336);
    Object localObject2;
    Object localObject3;
    if ((b.g(this.ABH) != null) && (b.g(this.ABH).length != 0))
    {
      localObject1 = new ArrayList();
      localObject2 = b.g(this.ABH);
      int j = localObject2.length;
      while (i < j)
      {
        localObject3 = localObject2[i];
        if (this.ABH.avi((String)localObject3)) {
          ((List)localObject1).add(localObject3);
        }
        i += 1;
      }
      if (((List)localObject1).size() > 0)
      {
        localObject2 = this.ABH;
        aw.aaz();
        b.a((b)localObject2, c.YA().a((String[])((List)localObject1).toArray(new String[((List)localObject1).size()]), b.h(this.ABH), b.a(this.ABH)));
        AppMethodBeat.o(35336);
        return;
      }
      localObject1 = this.ABH;
      aw.aaz();
      b.b((b)localObject1, c.YA().dwZ());
      AppMethodBeat.o(35336);
      return;
    }
    if (b.i(this.ABH) != null)
    {
      if (!b.h(this.ABH).equals("@all.chatroom.contact"))
      {
        localObject1 = aw.aaz().fkr.a(b.i(this.ABH), b.h(this.ABH), b.a(this.ABH), true);
        b.c(this.ABH, (Cursor)localObject1);
        AppMethodBeat.o(35336);
        return;
      }
      if (this.ABJ)
      {
        localObject1 = aw.aaz().fkr.a(b.i(this.ABH), "@micromsg.with.all.biz.qq.com.openim", b.a(this.ABH), false);
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
      }
      for (;;)
      {
        if (!((Cursor)localObject1).moveToNext()) {
          break label393;
        }
        String str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("username"));
        if (!t.nI(str))
        {
          ((ArrayList)localObject2).add(str);
          continue;
          localObject1 = aw.aaz().fkr.a(b.i(this.ABH), "@micromsg.with.all.biz.qq.com", b.a(this.ABH), false);
          break;
        }
        ((ArrayList)localObject3).add(str);
      }
      label393:
      if (!((Cursor)localObject1).isClosed()) {
        ((Cursor)localObject1).close();
      }
      if ((((ArrayList)localObject2).size() != 0) || (((ArrayList)localObject3).size() != 0)) {}
      for (localObject1 = aw.aaz().fkr.a(b.i(this.ABH), (ArrayList)localObject2, null, (ArrayList)localObject3, b.a(this.ABH));; localObject1 = c.YA().dwZ())
      {
        b.d(this.ABH, (Cursor)localObject1);
        AppMethodBeat.o(35336);
        return;
        aw.aaz();
      }
    }
    Object localObject1 = this.ABH;
    aw.aaz();
    b.e((b)localObject1, c.YA().dwZ());
    AppMethodBeat.o(35336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b.9
 * JD-Core Version:    0.7.0.1
 */