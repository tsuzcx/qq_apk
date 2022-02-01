package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bn;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;

final class TextPreviewUI$15
  implements View.OnClickListener
{
  TextPreviewUI$15(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(187192);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    localObject = new Intent(this.JZD, WebViewUI.class);
    ((Intent)localObject).putExtra("rawUrl", bn.D(TextPreviewUI.b(this.JZD)));
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("show_bottom", false);
    ((Intent)localObject).putExtra("needRedirect", false);
    paramView = this.JZD;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/TextPreviewUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/TextPreviewUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(187192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.15
 * JD-Core Version:    0.7.0.1
 */