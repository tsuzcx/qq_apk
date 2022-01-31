package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.s;

final class SettingsMoreSafeUI$2
  implements h.b
{
  SettingsMoreSafeUI$2(SettingsMoreSafeUI paramSettingsMoreSafeUI) {}
  
  public final boolean m(final CharSequence paramCharSequence)
  {
    if (!bk.ZC(paramCharSequence.toString()))
    {
      h.bC(this.nVg.mController.uMN, this.nVg.getString(a.i.verify_email_err_tip));
      return false;
    }
    b.eUS.tk();
    paramCharSequence = new d(d.fju, paramCharSequence.toString());
    g.Dk().a(paramCharSequence, 0);
    SettingsMoreSafeUI localSettingsMoreSafeUI = this.nVg;
    AppCompatActivity localAppCompatActivity = this.nVg.mController.uMN;
    this.nVg.getString(a.i.app_tip);
    SettingsMoreSafeUI.a(localSettingsMoreSafeUI, h.b(localAppCompatActivity, this.nVg.getString(a.i.settings_binding), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        g.Dk().c(paramCharSequence);
      }
    }));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI.2
 * JD-Core Version:    0.7.0.1
 */