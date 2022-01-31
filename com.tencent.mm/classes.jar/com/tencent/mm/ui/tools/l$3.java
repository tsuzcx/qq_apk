package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class l$3
  implements View.OnLongClickListener
{
  l$3(l paraml, View.OnCreateContextMenuListener paramOnCreateContextMenuListener) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(107703);
    ab.v("MicroMsg.MMSubMenuHelper", "registerForContextMenu normal view long click");
    l.a(this.Awb).clear();
    this.Awa.onCreateContextMenu(l.a(this.Awb), paramView, null);
    this.Awb.cwt();
    AppMethodBeat.o(107703);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.l.3
 * JD-Core Version:    0.7.0.1
 */