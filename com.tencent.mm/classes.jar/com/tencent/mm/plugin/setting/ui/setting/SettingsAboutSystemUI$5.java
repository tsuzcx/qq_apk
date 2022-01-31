package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.b;
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
    AppMethodBeat.i(127116);
    SettingsAboutSystemUI.a(this.qHp, false);
    paramDialogInterface = this.qHp;
    Object localObject = this.qHp;
    this.qHp.getString(2131297087);
    SettingsAboutSystemUI.a(paramDialogInterface, h.b((Context)localObject, this.qHp.getString(2131297112), true, new SettingsAboutSystemUI.5.1(this)));
    paramDialogInterface = ((j)g.E(j.class)).YF().dxi();
    if (paramDialogInterface.size() > 0)
    {
      localObject = com.tencent.mm.model.m.P(paramDialogInterface);
      if (localObject != null) {
        while (paramInt < ((List)localObject).size())
        {
          if (((Boolean)((List)localObject).get(paramInt)).booleanValue()) {
            b.gmP.dH((String)paramDialogInterface.get(paramInt));
          }
          paramInt += 1;
        }
      }
    }
    bf.a(new SettingsAboutSystemUI.5.2(this));
    AppMethodBeat.o(127116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.5
 * JD-Core Version:    0.7.0.1
 */