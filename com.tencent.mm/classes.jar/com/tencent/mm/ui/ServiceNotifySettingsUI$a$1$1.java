package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class ServiceNotifySettingsUI$a$1$1
  implements DialogInterface.OnClickListener
{
  ServiceNotifySettingsUI$a$1$1(ServiceNotifySettingsUI.a.1 param1, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 0;
    for (;;)
    {
      if (paramInt < ServiceNotifySettingsUI.a.a(this.uQQ.uQP).size())
      {
        paramDialogInterface = (ServiceNotifySettingsUI.a.a)ServiceNotifySettingsUI.a.a(this.uQQ.uQP).get(paramInt);
        if ((paramDialogInterface == null) || (!this.dol.equals(paramDialogInterface.username))) {
          break label282;
        }
        ServiceNotifySettingsUI.a.b(this.uQQ.uQP).add(ServiceNotifySettingsUI.a.a(this.uQQ.uQP).remove(paramInt));
        this.uQQ.uQP.notifyDataSetChanged();
        paramDialogInterface = ((c)g.r(c.class)).so(this.dol);
        if (paramDialogInterface != null) {
          break label227;
        }
      }
      label227:
      for (paramDialogInterface = ""; this.uQQ.uQO == 1; paramDialogInterface = paramDialogInterface.field_appId)
      {
        y.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(4), paramDialogInterface, ServiceNotifySettingsUI.a.c(this.uQQ.uQP) });
        h.nFQ.f(13798, new Object[] { Integer.valueOf(4), paramDialogInterface, Integer.valueOf(0), ServiceNotifySettingsUI.a.c(this.uQQ.uQP), Long.valueOf(bk.UX()) });
        return;
      }
      h.nFQ.f(13796, new Object[] { Integer.valueOf(12), paramDialogInterface, "", Integer.valueOf(0), Long.valueOf(bk.UX()) });
      return;
      label282:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI.a.1.1
 * JD-Core Version:    0.7.0.1
 */