package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.cf.h;
import com.tencent.mm.modelstat.k;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.LinkedHashMap;

final class SettingsNetStatUI$3
  implements DialogInterface.OnClickListener
{
  SettingsNetStatUI$3(SettingsNetStatUI paramSettingsNetStatUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = q.RC();
    paramInt = (int)(bk.crW() / 86400000L);
    synchronized (paramDialogInterface.eEp)
    {
      ((ax)???).luc.trimToSize(-1);
      ((ax)???).uhE.clear();
      ((ax)???).byQ.stopTimer();
      ((ax)???).uhG.stopTimer();
      ((ax)???).byT = true;
      paramDialogInterface.dXo.delete("netstat", null, null);
      ??? = new k();
      ((k)???).eDC = paramInt;
      ((k)???).id = -1;
      paramDialogInterface.b((k)???);
      SettingsNetStatUI.b(this.nVi);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsNetStatUI.3
 * JD-Core Version:    0.7.0.1
 */