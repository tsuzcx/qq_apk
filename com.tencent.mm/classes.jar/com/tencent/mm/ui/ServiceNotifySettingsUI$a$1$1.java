package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

final class ServiceNotifySettingsUI$a$1$1
  implements DialogInterface.OnClickListener
{
  ServiceNotifySettingsUI$a$1$1(ServiceNotifySettingsUI.a.1 param1, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(29855);
    paramInt = 0;
    while (paramInt < ServiceNotifySettingsUI.a.a(this.zfa.zeZ).size())
    {
      paramDialogInterface = (ServiceNotifySettingsUI.a.a)ServiceNotifySettingsUI.a.a(this.zfa.zeZ).get(paramInt);
      if ((paramDialogInterface != null) && (this.efI.equals(paramDialogInterface.username)))
      {
        ServiceNotifySettingsUI.a.b(this.zfa.zeZ).add(ServiceNotifySettingsUI.a.a(this.zfa.zeZ).remove(paramInt));
        this.zfa.zeZ.notifyDataSetChanged();
        paramDialogInterface = ((i)g.E(i.class)).Ae(this.efI);
        if (paramDialogInterface == null) {}
        for (paramDialogInterface = ""; this.zfa.zeY == 1; paramDialogInterface = paramDialogInterface.field_appId)
        {
          ab.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(4), paramDialogInterface, ServiceNotifySettingsUI.a.c(this.zfa.zeZ) });
          h.qsU.e(13798, new Object[] { Integer.valueOf(4), paramDialogInterface, Integer.valueOf(0), ServiceNotifySettingsUI.a.c(this.zfa.zeZ), Long.valueOf(bo.aox()) });
          AppMethodBeat.o(29855);
          return;
        }
        h.qsU.e(13796, new Object[] { Integer.valueOf(12), paramDialogInterface, "", Integer.valueOf(0), Long.valueOf(bo.aox()) });
        AppMethodBeat.o(29855);
        return;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(29855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI.a.1.1
 * JD-Core Version:    0.7.0.1
 */