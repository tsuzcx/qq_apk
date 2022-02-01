package com.tencent.mm.plugin.webwx.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;

final class WebWXLogoutUI$6
  implements View.OnClickListener
{
  WebWXLogoutUI$6(WebWXLogoutUI paramWebWXLogoutUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30218);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Intent();
    paramView.putExtra("Chat_User", "filehelper");
    paramView.putExtra("key_show_bottom_app_panel", true);
    com.tencent.mm.plugin.webwx.a.jRt.d(paramView, this.JFH);
    Log.d("MicroMsg.WebWXLogoutUI", "clicked file transfer bt, start filehelper");
    this.JFH.finish();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(30218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.6
 * JD-Core Version:    0.7.0.1
 */