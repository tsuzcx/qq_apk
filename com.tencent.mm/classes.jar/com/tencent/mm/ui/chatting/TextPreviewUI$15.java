package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bl;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;

final class TextPreviewUI$15
  implements View.OnClickListener
{
  TextPreviewUI$15(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(193885);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    localObject = new Intent(this.JEM, WebViewUI.class);
    ((Intent)localObject).putExtra("rawUrl", bl.D(TextPreviewUI.b(this.JEM)));
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("show_bottom", false);
    ((Intent)localObject).putExtra("needRedirect", false);
    paramView = this.JEM;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/TextPreviewUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/TextPreviewUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(193885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.15
 * JD-Core Version:    0.7.0.1
 */