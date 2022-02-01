package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.fap;
import com.tencent.mm.protocal.protobuf.faq;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama, fap paramfap) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(187647);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/applet/AddContact$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.ReW.UAE.UAI);
    c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/applet/AddContact$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(187647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.a.2
 * JD-Core Version:    0.7.0.1
 */