package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;

final class SettingsAliasUI$5$1
  implements Runnable
{
  SettingsAliasUI$5$1(SettingsAliasUI.5 param5, m paramm, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(127189);
    if (SettingsAliasUI.h(this.qIc.qIa) != null)
    {
      SettingsAliasUI.h(this.qIc.qIa).dismiss();
      SettingsAliasUI.i(this.qIc.qIa);
    }
    SettingsAliasUI.j(this.qIc.qIa);
    if (this.ckS.getType() == 255) {
      if ((this.val$errCode == -3) && (this.val$errType == 4)) {
        break label137;
      }
    }
    label137:
    for (boolean bool = true;; bool = false)
    {
      Intent localIntent = new Intent(this.qIc.qIa, SettingsAliasResultUI.class);
      localIntent.putExtra("has_pwd", bool);
      this.qIc.qIa.startActivity(localIntent);
      this.qIc.qIa.finish();
      AppMethodBeat.o(127189);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAliasUI.5.1
 * JD-Core Version:    0.7.0.1
 */