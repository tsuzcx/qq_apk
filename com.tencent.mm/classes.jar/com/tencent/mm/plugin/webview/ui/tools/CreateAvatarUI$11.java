package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.b.c;

final class CreateAvatarUI$11
  implements View.OnClickListener
{
  CreateAvatarUI$11(CreateAvatarUI paramCreateAvatarUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(7363);
    paramView = CreateAvatarUI.b(this.vam).getText().toString();
    String str = b.MZ();
    if ((!bo.isNullOrNil(str)) && (paramView.matches(".*[" + str + "].*")))
    {
      h.b(this.vam.getContext(), this.vam.getString(2131300749, new Object[] { str }), this.vam.getString(2131297087), true);
      AppMethodBeat.o(7363);
      return;
    }
    c.d(CreateAvatarUI.b(this.vam)).hR(1, 32).a(this.vam);
    AppMethodBeat.o(7363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.11
 * JD-Core Version:    0.7.0.1
 */