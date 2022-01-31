package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.setting.a.c;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class UnfamiliarContactDetailUI$7
  implements View.OnClickListener
{
  UnfamiliarContactDetailUI$7(UnfamiliarContactDetailUI paramUnfamiliarContactDetailUI) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.nWX.mController.uMN, true, this.nWX.mController.uMN.getString(a.i.unfamiliar_delete_contact_tip), this.nWX.mController.uMN.getString(a.i.contact_info_delete_contact), this.nWX.mController.uMN.getString(a.i.app_delete), this.nWX.mController.uMN.getString(a.i.app_cancel), new UnfamiliarContactDetailUI.7.1(this), null, a.c.alert_btn_color_warn, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.7
 * JD-Core Version:    0.7.0.1
 */