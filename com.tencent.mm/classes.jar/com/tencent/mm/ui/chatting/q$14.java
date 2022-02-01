package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider;
import com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider.a;
import com.tencent.mm.sdk.platformtools.Log;

final class q$14
  implements DialogInterface.OnClickListener
{
  q$14(q paramq, boolean paramBoolean1, String paramString1, int paramInt, String paramString2, boolean paramBoolean2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(163295);
    paramDialogInterface = WeSeeProvider.HIQ;
    WeSeeProvider.a.frW();
    if (this.WAx)
    {
      Log.d("MicroMsg.ChattingFooterEventImpl", "weishiSchema: %s", new Object[] { this.WAM });
      q.Q(11, this.WAy, q.l(this.WAw));
      Object localObject = new Intent();
      ((Intent)localObject).setAction("android.intent.action.VIEW");
      ((Intent)localObject).setData(Uri.parse(this.WAM));
      ((Intent)localObject).setPackage("com.tencent.weishi");
      ((Intent)localObject).setFlags(268435456);
      paramDialogInterface = q.e(this.WAw).WQv.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/ChattingFooterEventImpl$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramDialogInterface, "com/tencent/mm/ui/chatting/ChattingFooterEventImpl$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(163295);
      return;
    }
    Log.d("MicroMsg.ChattingFooterEventImpl", "weishiUrl: %s", new Object[] { this.WAN });
    paramDialogInterface = WeSeeProvider.HIQ;
    WeSeeProvider.a.bi(this.WAM, System.currentTimeMillis());
    paramDialogInterface = new Intent();
    if (!this.WAO) {
      paramDialogInterface.putExtra("KRightBtn", true);
    }
    paramDialogInterface.putExtra("rawUrl", this.WAN);
    c.b(q.e(this.WAw).WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramDialogInterface);
    q.Q(8, this.WAy, q.l(this.WAw));
    AppMethodBeat.o(163295);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.q.14
 * JD-Core Version:    0.7.0.1
 */