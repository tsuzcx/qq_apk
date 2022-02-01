package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;

final class TextPreviewUI$13
  implements View.OnClickListener
{
  TextPreviewUI$13(TextPreviewUI paramTextPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34943);
    Object localObject = new Intent(this.HQW, WebViewUI.class);
    ((Intent)localObject).putExtra("rawUrl", bk.B(TextPreviewUI.b(this.HQW)));
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("show_bottom", false);
    ((Intent)localObject).putExtra("needRedirect", false);
    paramView = this.HQW;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/TextPreviewUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/TextPreviewUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(34943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI.13
 * JD-Core Version:    0.7.0.1
 */