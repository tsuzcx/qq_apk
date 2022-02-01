package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
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
    AppMethodBeat.i(250020);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new Intent();
    paramView.putExtra("rawUrl", PrepareBindXMailUI.d(this.Hrj));
    paramView.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
    paramView.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
    c.b(this.Hrj, "webview", ".ui.tools.WebViewUI", paramView, 293);
    a.a(this, "com/tencent/mm/plugin/qqmail/ui/PrepareBindXMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(250020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.PrepareBindXMailUI.3
 * JD-Core Version:    0.7.0.1
 */