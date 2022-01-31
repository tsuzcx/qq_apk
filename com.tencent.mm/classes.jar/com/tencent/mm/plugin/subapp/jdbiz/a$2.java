package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.z;

final class a$2
  implements Runnable
{
  a$2(a parama, b paramb) {}
  
  public final void run()
  {
    Object localObject = this.puX;
    b localb = this.puY;
    au.Hx();
    int i = ((Integer)com.tencent.mm.model.c.Dz().get(15, Integer.valueOf(0))).intValue();
    if ((au.Dk().foreground) && (1 == i))
    {
      localObject = c.cz(localb.jumpUrl, 5);
      JDRemindDialog.a(ae.getContext(), localb.pvk, localb.pvl, localb.pvm, (String)localObject, localb.pva);
      h.nFQ.f(11178, new Object[] { localObject, c.bLK().bLP().pva, Integer.valueOf(5) });
      return;
    }
    String str = c.cz(localb.jumpUrl, 4);
    Bundle localBundle = new Bundle();
    localBundle.putString("activity_id", localb.pva);
    localBundle.putString("jump_url", str);
    ((ao)au.getNotification()).a(37, ae.getContext().getString(R.l.app_pushcontent_title), localb.pvj, str, "bizjd", localBundle);
    com.tencent.mm.sdk.b.a.udP.c(((a)localObject).puW);
    h.nFQ.f(11178, new Object[] { str, c.bLK().bLP().pva, Integer.valueOf(4) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.a.2
 * JD-Core Version:    0.7.0.1
 */