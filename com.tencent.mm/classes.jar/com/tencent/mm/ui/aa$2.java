package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.y;

final class aa$2
  implements m.b
{
  aa$2(aa paramaa) {}
  
  public final void a(int paramInt, m paramm, Object paramObject)
  {
    int i = ah.aD(paramObject);
    y.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange event:%d obj:%d stg:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), paramm });
    au.Hx();
    if ((paramm != c.Dz()) || (i <= 0)) {
      y.e("MicroMsg.LauncherUI.MainTabUnreadMgr", "onNotifyChange error obj:%d stg:%s", new Object[] { Integer.valueOf(i), paramm });
    }
    do
    {
      return;
      this.uPf.czO();
      if (i == 143618)
      {
        aa.a(this.uPf);
        return;
      }
    } while ((i != 204817) && (i != 204820));
    aa.b(this.uPf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.aa.2
 * JD-Core Version:    0.7.0.1
 */