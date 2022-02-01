package com.tencent.mm.plugin.webwx.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class WebWXLogoutUI$7
  implements View.OnClickListener
{
  WebWXLogoutUI$7(WebWXLogoutUI paramWebWXLogoutUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(30219);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.d("MicroMsg.WebWXLogoutUI", "logout webwx");
    WebWXLogoutUI.g(this.JFH);
    a.a(this, "com/tencent/mm/plugin/webwx/ui/WebWXLogoutUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(30219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.WebWXLogoutUI.7
 * JD-Core Version:    0.7.0.1
 */