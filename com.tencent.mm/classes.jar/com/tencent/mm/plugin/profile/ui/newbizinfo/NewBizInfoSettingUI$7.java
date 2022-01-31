package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.base.model.b;

final class NewBizInfoSettingUI$7
  implements Runnable
{
  NewBizInfoSettingUI$7(NewBizInfoSettingUI paramNewBizInfoSettingUI) {}
  
  public final void run()
  {
    if (this.nad.isFinishing()) {
      return;
    }
    b.T(this.nad, NewBizInfoSettingUI.a(this.nad).field_username);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.7
 * JD-Core Version:    0.7.0.1
 */