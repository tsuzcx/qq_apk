package com.tencent.mm.plugin.webview.ui.tools;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class i$3
  implements View.OnLongClickListener
{
  i$3(i parami) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(153198);
    ab.v("MicroMsg.WebViewLongClickHelper", "registerForContextMenu normal view long click");
    i locali = this.vcB;
    locali.igX = null;
    locali.vcz = null;
    locali.ihc = null;
    locali.ihb = null;
    boolean bool = this.vcB.ev(paramView);
    AppMethodBeat.o(153198);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.i.3
 * JD-Core Version:    0.7.0.1
 */