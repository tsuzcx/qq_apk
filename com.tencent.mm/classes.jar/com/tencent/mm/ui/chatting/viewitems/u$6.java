package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

final class u$6
  implements View.OnClickListener
{
  u$6(u paramu, String paramString1, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(this.val$url))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", this.val$url);
      d.b(u.b(this.vDZ).vtz.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      h.nFQ.f(11608, new Object[] { u.d(this.vDZ), this.rzx, Integer.valueOf(2) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.6
 * JD-Core Version:    0.7.0.1
 */