package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider.a;
import com.tencent.mm.sdk.platformtools.Log;

final class q$13
  implements DialogInterface.OnClickListener
{
  q$13(q paramq, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, boolean paramBoolean2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(163295);
    paramDialogInterface = WeSeeProvider.BME;
    WeSeeProvider.a.delete();
    if (this.Phe)
    {
      Log.d("MicroMsg.ChattingFooterEventImpl", "weishiSchema: %s", new Object[] { this.Phm });
      q.S(11, this.gMP, q.l(this.Phd));
      Object localObject = new Intent();
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      ((Intent)localObject).setData(Uri.parse(this.Phm));
      ((Intent)localObject).setPackage("com.tencent.weishi");
      ((Intent)localObject).setFlags(268435456);
      paramDialogInterface = q.e(this.Phd).Pwc.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/ChattingFooterEventImpl$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramDialogInterface, "com/tencent/mm/ui/chatting/ChattingFooterEventImpl$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(163295);
      return;
    }
    Log.d("MicroMsg.ChattingFooterEventImpl", "weishiUrl: %s", new Object[] { this.Phn });
    paramDialogInterface = WeSeeProvider.BME;
    WeSeeProvider.a.bg(this.Phm, System.currentTimeMillis());
    paramDialogInterface = new Intent();
    if (!this.Pho) {
      paramDialogInterface.putExtra("KRightBtn", true);
    }
    paramDialogInterface.putExtra("rawUrl", this.Phn);
    c.b(q.e(this.Phd).Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    q.S(8, this.gMP, q.l(this.Phd));
    AppMethodBeat.o(163295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.13
 * JD-Core Version:    0.7.0.1
 */