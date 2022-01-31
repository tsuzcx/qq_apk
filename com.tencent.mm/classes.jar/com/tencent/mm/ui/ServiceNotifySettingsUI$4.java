package com.tencent.mm.ui;

import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.nh;
import com.tencent.mm.h.a.su;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.bwq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.s;
import java.util.Iterator;
import java.util.LinkedList;

final class ServiceNotifySettingsUI$4
  implements f
{
  ServiceNotifySettingsUI$4(ServiceNotifySettingsUI paramServiceNotifySettingsUI, boolean paramBoolean1, boolean paramBoolean2, LinkedList paramLinkedList, int paramInt) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.Dk().b(1176, this);
    y.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      s.makeText(this.uQG, R.l.notify_message_settings_revert_ban_failed_tips, 0).show();
      if (this.uQH)
      {
        au.Hx();
        c.Dz().c(ac.a.uty, Boolean.valueOf(this.uQI));
        a.udP.m(new nh());
      }
      paramString = this.dri.iterator();
      while (paramString.hasNext())
      {
        paramm = (bwq)paramString.next();
        su localsu = new su();
        localsu.ccq.bFn = paramm.tMX;
        localsu.ccq.action = 1;
        localsu.ccq.ccs = this.uQJ;
        a.udP.m(localsu);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI.4
 * JD-Core Version:    0.7.0.1
 */