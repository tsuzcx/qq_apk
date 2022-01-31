package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

final class BizContactEntranceView$3
  implements Runnable
{
  BizContactEntranceView$3(BizContactEntranceView paramBizContactEntranceView) {}
  
  public final void run()
  {
    long l1 = 0L;
    AppMethodBeat.i(33542);
    Object localObject1 = com.tencent.mm.aj.z.afi();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select updateTime from BizInfo where type = 1");
    ((StringBuilder)localObject2).append(" and status = 1 ORDER BY updateTime DESC");
    localObject2 = ((StringBuilder)localObject2).toString();
    ab.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", new Object[] { localObject2 });
    localObject1 = ((e)localObject1).rawQuery((String)localObject2, new String[0]);
    if (localObject1 == null) {}
    for (;;)
    {
      aw.aaz();
      long l2 = bo.cx(c.Ru().get(233473, null));
      ab.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      al.d(new BizContactEntranceView.3.1(this, l1, l2));
      AppMethodBeat.o(33542);
      return;
      if (!((Cursor)localObject1).moveToFirst())
      {
        ((Cursor)localObject1).close();
      }
      else
      {
        l1 = ((Cursor)localObject1).getLong(0);
        ((Cursor)localObject1).close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.BizContactEntranceView.3
 * JD-Core Version:    0.7.0.1
 */