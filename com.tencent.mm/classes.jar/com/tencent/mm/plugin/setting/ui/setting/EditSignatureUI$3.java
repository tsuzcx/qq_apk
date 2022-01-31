package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.m.b;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText;

final class EditSignatureUI$3
  implements MenuItem.OnMenuItemClickListener
{
  EditSignatureUI$3(EditSignatureUI paramEditSignatureUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = EditSignatureUI.a(this.nRN).getText().toString().trim();
    Object localObject = b.Ak();
    if ((!bk.bl((String)localObject)) && (paramMenuItem.matches(".*[" + (String)localObject + "].*")))
    {
      h.b(this.nRN.mController.uMN, this.nRN.getString(a.i.invalid_input_character_toast, new Object[] { localObject }), this.nRN.getString(a.i.app_tip), true);
      return false;
    }
    localObject = this.nRN;
    AppCompatActivity localAppCompatActivity = this.nRN.mController.uMN;
    this.nRN.getString(a.i.app_tip);
    EditSignatureUI.a((EditSignatureUI)localObject, h.b(localAppCompatActivity, this.nRN.getString(a.i.contact_info_change_remarkimage_save), false, null));
    EditSignatureUI.a(this.nRN, q.n(18, paramMenuItem));
    EditSignatureUI.f(this.nRN);
    this.nRN.XM();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI.3
 * JD-Core Version:    0.7.0.1
 */