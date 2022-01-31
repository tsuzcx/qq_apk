package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

final class g$1
  implements View.OnClickListener
{
  g$1(g paramg, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34652);
    paramView = new Intent();
    paramView.putExtra("k_username", this.AmD.zwh);
    int i = 39;
    if (this.AmD.zvB) {
      i = 36;
    }
    paramView.putExtra("showShare", false);
    if (!bo.isNullOrNil(this.AmC)) {
      paramView.putExtra("rawUrl", this.AmC);
    }
    for (;;)
    {
      if (this.AmD.vUD.get() != null) {
        com.tencent.mm.bq.d.b((Context)this.AmD.vUD.get(), "webview", ".ui.tools.WebViewUI", paramView);
      }
      aw.aaz().YZ().pS(this.AmD.zwh);
      aw.aaz().YZ().pS(this.AmD.AmA);
      AppMethodBeat.o(34652);
      return;
      paramView.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(i) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.g.1
 * JD-Core Version:    0.7.0.1
 */