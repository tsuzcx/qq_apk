package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class PrepareBindXMailUI$3
  implements View.OnClickListener
{
  PrepareBindXMailUI$3(PrepareBindXMailUI paramPrepareBindXMailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(266968);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new Intent();
    paramView.putExtra("rawUrl", PrepareBindXMailUI.d(this.NoW));
    paramView.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
    paramView.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
    c.b(this.NoW, "webview", ".ui.tools.WebViewUI", paramView, 293);
    a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(266968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.PrepareBindXMailUI.3
 * JD-Core Version:    0.7.0.1
 */