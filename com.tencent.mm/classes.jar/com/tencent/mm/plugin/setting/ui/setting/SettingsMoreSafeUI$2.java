package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;

final class SettingsMoreSafeUI$2
  implements h.b
{
  SettingsMoreSafeUI$2(SettingsMoreSafeUI paramSettingsMoreSafeUI) {}
  
  public final boolean onFinish(final CharSequence paramCharSequence)
  {
    AppMethodBeat.i(127326);
    if (!bo.apH(paramCharSequence.toString()))
    {
      h.bO(this.qJl.getContext(), this.qJl.getString(2131304496));
      AppMethodBeat.o(127326);
      return false;
    }
    b.gmP.BO();
    paramCharSequence = new d(d.gAM, paramCharSequence.toString());
    g.Rc().a(paramCharSequence, 0);
    SettingsMoreSafeUI localSettingsMoreSafeUI = this.qJl;
    AppCompatActivity localAppCompatActivity = this.qJl.getContext();
    this.qJl.getString(2131297087);
    SettingsMoreSafeUI.a(localSettingsMoreSafeUI, h.b(localAppCompatActivity, this.qJl.getString(2131303220), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(127325);
        g.Rc().a(paramCharSequence);
        AppMethodBeat.o(127325);
      }
    }));
    AppMethodBeat.o(127326);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI.2
 * JD-Core Version:    0.7.0.1
 */