package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.platformtools.ah;
import java.lang.ref.WeakReference;

final class o$5
  implements View.OnClickListener
{
  o$5(o paramo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34714);
    if (!ah.M((Context)this.Anv.vUD.get(), this.Anv.Anl))
    {
      paramView = new Intent();
      paramView.putExtra("title", ((Context)this.Anv.vUD.get()).getString(2131301791));
      paramView.putExtra("rawUrl", ((Context)this.Anv.vUD.get()).getString(2131301785));
      paramView.putExtra("showShare", false);
      d.b((Context)this.Anv.vUD.get(), "webview", ".ui.tools.WebViewUI", paramView);
    }
    AppMethodBeat.o(34714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.o.5
 * JD-Core Version:    0.7.0.1
 */