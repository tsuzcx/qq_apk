package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ai.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;

final class NewBizInfoSettingUI$2
  implements DialogInterface.OnClickListener
{
  NewBizInfoSettingUI$2(NewBizInfoSettingUI paramNewBizInfoSettingUI, d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.byp.field_hadAlert = 1;
    this.byp.field_brandFlag |= 0x4;
    NewBizInfoSettingUI.a(this.nad, this.byp, true);
    c.cg(NewBizInfoSettingUI.a(this.nad).field_username, 906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoSettingUI.2
 * JD-Core Version:    0.7.0.1
 */