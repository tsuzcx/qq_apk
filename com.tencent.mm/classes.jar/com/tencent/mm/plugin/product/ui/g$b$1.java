package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class g$b$1
  implements View.OnClickListener
{
  g$b$1(g.b paramb, g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(44069);
    ab.i("MicroMsg.MallProductImageAdapter", "henryyr user: clicked the ImageView");
    if (this.pwc.pwa.pvZ != null) {
      this.pwc.pwa.pvZ.cbr();
    }
    AppMethodBeat.o(44069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.g.b.1
 * JD-Core Version:    0.7.0.1
 */