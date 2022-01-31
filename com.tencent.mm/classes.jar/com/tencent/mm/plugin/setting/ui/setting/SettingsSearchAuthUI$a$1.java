package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.c;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.ui.base.h;

final class SettingsSearchAuthUI$a$1
  implements View.OnClickListener
{
  SettingsSearchAuthUI$a$1(SettingsSearchAuthUI.a parama, int paramInt) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(127451);
    if (this.qJY.Db(this.lU) != null)
    {
      paramView = new c(this.qJY.Db(this.lU).cwc, 2);
      if (SettingsSearchAuthUI.j(this.qJY.qJW) != null) {
        SettingsSearchAuthUI.j(this.qJY.qJW).dismiss();
      }
      g.Rc().a(paramView, 0);
      SettingsSearchAuthUI.a(this.qJY.qJW, h.b(this.qJY.qJW, this.qJY.qJW.getString(2131297069), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(127450);
          g.Rc().a(paramView);
          AppMethodBeat.o(127450);
        }
      }));
    }
    AppMethodBeat.o(127451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSearchAuthUI.a.1
 * JD-Core Version:    0.7.0.1
 */