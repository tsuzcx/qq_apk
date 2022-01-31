package com.tencent.mm.plugin.sight.draft.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.l;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.ab;

final class b$c
  implements View.OnClickListener
{
  private b$c(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25000);
    if (!(paramView.getTag() instanceof b.e))
    {
      AppMethodBeat.o(25000);
      return;
    }
    b.f(this.qUZ).cmW();
    paramView = (b.e)paramView.getTag();
    if (paramView.qVg == null)
    {
      ab.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
      AppMethodBeat.o(25000);
      return;
    }
    paramView.qVg.field_fileStatus = 6;
    o.alI().update(paramView.qVg, new String[] { "localId" });
    this.qUZ.a(null, null);
    if (b.d(this.qUZ) != null) {
      b.d(this.qUZ);
    }
    AppMethodBeat.o(25000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b.c
 * JD-Core Version:    0.7.0.1
 */