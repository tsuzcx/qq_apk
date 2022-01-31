package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.platformtools.ah;
import java.lang.ref.WeakReference;

final class n$5
  implements View.OnClickListener
{
  n$5(n paramn) {}
  
  public final void onClick(View paramView)
  {
    if (!ah.I((Context)this.vVt.sdy.get(), this.vVt.vVj))
    {
      paramView = new Intent();
      paramView.putExtra("title", ((Context)this.vVt.sdy.get()).getString(R.l.net_warn_server_failed));
      paramView.putExtra("rawUrl", ((Context)this.vVt.sdy.get()).getString(R.l.net_warn_detail_doc));
      paramView.putExtra("showShare", false);
      d.b((Context)this.vVt.sdy.get(), "webview", ".ui.tools.WebViewUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.n.5
 * JD-Core Version:    0.7.0.1
 */