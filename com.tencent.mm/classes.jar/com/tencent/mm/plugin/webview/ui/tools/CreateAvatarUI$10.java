package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.R.l;
import com.tencent.mm.m.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.a.c;

final class CreateAvatarUI$10
  implements View.OnClickListener
{
  CreateAvatarUI$10(CreateAvatarUI paramCreateAvatarUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = CreateAvatarUI.b(this.rkL).getText().toString();
    String str = b.Ak();
    if ((!bk.bl(str)) && (paramView.matches(".*[" + str + "].*")))
    {
      h.b(this.rkL.mController.uMN, this.rkL.getString(R.l.invalid_input_character_toast, new Object[] { str }), this.rkL.getString(R.l.app_tip), true);
      return;
    }
    c.d(CreateAvatarUI.b(this.rkL)).fJ(1, 32).a(this.rkL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.10
 * JD-Core Version:    0.7.0.1
 */