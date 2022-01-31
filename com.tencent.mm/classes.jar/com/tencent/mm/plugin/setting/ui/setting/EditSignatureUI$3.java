package com.tencent.mm.plugin.setting.ui.setting;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.b;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;

final class EditSignatureUI$3
  implements MenuItem.OnMenuItemClickListener
{
  EditSignatureUI$3(EditSignatureUI paramEditSignatureUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(126946);
    paramMenuItem = EditSignatureUI.a(this.qFL).getText().toString().trim();
    Object localObject = b.MZ();
    if ((!bo.isNullOrNil((String)localObject)) && (paramMenuItem.matches(".*[" + (String)localObject + "].*")))
    {
      h.b(this.qFL.getContext(), this.qFL.getString(2131300749, new Object[] { localObject }), this.qFL.getString(2131297087), true);
      AppMethodBeat.o(126946);
      return false;
    }
    localObject = this.qFL;
    AppCompatActivity localAppCompatActivity = this.qFL.getContext();
    this.qFL.getString(2131297087);
    EditSignatureUI.a((EditSignatureUI)localObject, h.b(localAppCompatActivity, this.qFL.getString(2131298567), false, null));
    EditSignatureUI.a(this.qFL, r.u(18, paramMenuItem));
    EditSignatureUI.f(this.qFL);
    this.qFL.hideVKB();
    AppMethodBeat.o(126946);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.EditSignatureUI.3
 * JD-Core Version:    0.7.0.1
 */