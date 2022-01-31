package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.ai.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class BizContactEntranceView$3
  implements Runnable
{
  BizContactEntranceView$3(BizContactEntranceView paramBizContactEntranceView) {}
  
  public final void run()
  {
    long l1 = 0L;
    Object localObject1 = com.tencent.mm.ai.z.My();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select updateTime from BizInfo where type = 1");
    ((StringBuilder)localObject2).append(" and status = 1 ORDER BY updateTime DESC");
    localObject2 = ((StringBuilder)localObject2).toString();
    y.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", new Object[] { localObject2 });
    localObject1 = ((e)localObject1).rawQuery((String)localObject2, new String[0]);
    if (localObject1 == null) {}
    for (;;)
    {
      au.Hx();
      long l2 = bk.bU(c.Dz().get(233473, null));
      y.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
      ai.d(new BizContactEntranceView.3.1(this, l1, l2));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.BizContactEntranceView.3
 * JD-Core Version:    0.7.0.1
 */