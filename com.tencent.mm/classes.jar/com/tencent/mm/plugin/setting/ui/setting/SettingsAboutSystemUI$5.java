package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.h;
import java.util.List;

final class SettingsAboutSystemUI$5
  implements DialogInterface.OnClickListener
{
  SettingsAboutSystemUI$5(SettingsAboutSystemUI paramSettingsAboutSystemUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = 0;
    SettingsAboutSystemUI.a(this.nTp, false);
    paramDialogInterface = this.nTp;
    Object localObject = this.nTp;
    this.nTp.getString(a.i.app_tip);
    SettingsAboutSystemUI.a(paramDialogInterface, h.b((Context)localObject, this.nTp.getString(a.i.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        SettingsAboutSystemUI.a(SettingsAboutSystemUI.5.this.nTp, true);
      }
    }));
    paramDialogInterface = ((j)g.r(j.class)).FB().cuI();
    if (paramDialogInterface.size() > 0)
    {
      localObject = l.I(paramDialogInterface);
      if (localObject != null) {
        while (paramInt < ((List)localObject).size())
        {
          if (((Boolean)((List)localObject).get(paramInt)).booleanValue()) {
            paramDialogInterface.get(paramInt);
          }
          paramInt += 1;
        }
      }
    }
    bd.a(new SettingsAboutSystemUI.5.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.5
 * JD-Core Version:    0.7.0.1
 */