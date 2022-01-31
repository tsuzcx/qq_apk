package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import java.lang.ref.WeakReference;

final class o$3
  implements View.OnClickListener
{
  o$3(o paramo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34712);
    paramView = new Intent();
    paramView.putExtra("title", ((Context)this.Anv.vUD.get()).getString(2131301788));
    paramView.putExtra("rawUrl", ((Context)this.Anv.vUD.get()).getString(2131301785));
    paramView.putExtra("showShare", false);
    d.b((Context)this.Anv.vUD.get(), "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(34712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o.3
 * JD-Core Version:    0.7.0.1
 */