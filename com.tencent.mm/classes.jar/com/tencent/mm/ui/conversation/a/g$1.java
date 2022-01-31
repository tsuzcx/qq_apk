package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.ref.WeakReference;

final class g$1
  implements View.OnClickListener
{
  g$1(g paramg, String paramString) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("k_username", this.vUG.vUC);
    int i = 39;
    if (this.vUG.vgB) {
      i = 36;
    }
    paramView.putExtra("showShare", false);
    if (!bk.bl(this.vUF)) {
      paramView.putExtra("rawUrl", this.vUF);
    }
    for (;;)
    {
      if (this.vUG.sdy.get() != null) {
        com.tencent.mm.br.d.b((Context)this.vUG.sdy.get(), "webview", ".ui.tools.WebViewUI", paramView);
      }
      au.Hx().FY().je(this.vUG.vUC);
      au.Hx().FY().je(this.vUG.vUD);
      return;
      paramView.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(i) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.g.1
 * JD-Core Version:    0.7.0.1
 */