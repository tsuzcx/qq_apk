package com.tencent.mm.plugin.subapp.ui.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.b.d;
import java.util.HashSet;

final class GestureGalleryUI$15
  implements n.c
{
  GestureGalleryUI$15(GestureGalleryUI paramGestureGalleryUI) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(25394);
    GestureGalleryUI.i(this.sYB).setFooterView(null);
    paraml.clear();
    paraml.hx(1, 2131302282);
    paraml.hx(2, 2131302869);
    paraml.hx(3, 2131302102);
    if (GestureGalleryUI.j(this.sYB)) {
      GestureGalleryUI.i(this.sYB).setFooterView(GestureGalleryUI.k(this.sYB));
    }
    if ((GestureGalleryUI.l(this.sYB)) && (bo.isNullOrNil(GestureGalleryUI.m(this.sYB))) && (aw.Rc().adt() != 0))
    {
      paraml = new nw();
      paraml.cEv.filePath = GestureGalleryUI.c(this.sYB);
      paraml.cEv.cEw = new HashSet(GestureGalleryUI.n(this.sYB));
      GestureGalleryUI.b(this.sYB, GestureGalleryUI.c(this.sYB));
      a.ymk.l(paraml);
    }
    AppMethodBeat.o(25394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.15
 * JD-Core Version:    0.7.0.1
 */