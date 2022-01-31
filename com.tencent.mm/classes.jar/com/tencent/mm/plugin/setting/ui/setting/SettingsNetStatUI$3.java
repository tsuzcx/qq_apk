package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedHashMap;

final class SettingsNetStatUI$3
  implements DialogInterface.OnClickListener
{
  SettingsNetStatUI$3(SettingsNetStatUI paramSettingsNetStatUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(127343);
    paramDialogInterface = q.akL();
    paramInt = (int)(bo.dtT() / 86400000L);
    synchronized (paramDialogInterface.fUg)
    {
      ((bb)???).evq.trimToSize(-1);
      ((bb)???).ypJ.clear();
      ((bb)???).caS.stopTimer();
      ((bb)???).ypL.stopTimer();
      ((bb)???).caV = true;
      paramDialogInterface.fnw.delete("netstat", null, null);
      ??? = new k();
      ((k)???).fTt = paramInt;
      ((k)???).id = -1;
      paramDialogInterface.b((k)???);
      SettingsNetStatUI.b(this.qJn);
      AppMethodBeat.o(127343);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI.3
 * JD-Core Version:    0.7.0.1
 */