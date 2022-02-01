package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bn;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;

final class ImageGalleryUI$15
  implements n.d
{
  ImageGalleryUI$15(ImageGalleryUI paramImageGalleryUI, bv parambv) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(187513);
    paraml.clear();
    Object localObject;
    if (!bn.A(this.hHv))
    {
      localObject = null;
      if ((!b.j(this.hHv)) && (!b.bZ(this.hHv))) {
        break label261;
      }
      localObject = this.KnP.getString(2131762781);
    }
    for (;;)
    {
      if (!this.hHv.cyH()) {
        paraml.a(1, (CharSequence)localObject, 2131690560);
      }
      if ((b.j(this.hHv)) && (ImageGalleryUI.E(this.KnP))) {
        paraml.a(6, this.KnP.getString(2131757183), 2131690634);
      }
      if ((ImageGalleryUI.F(this.KnP)) && (!ImageGalleryUI.G(this.KnP)) && (!an.aUx(this.KnP.talker))) {
        paraml.a(5, this.KnP.getString(2131757182), 2131690532);
      }
      if ((b.j(this.hHv)) || (b.bX(this.hHv)))
      {
        localObject = new ec();
        ((ec)localObject).dql.msgId = this.hHv.field_msgId;
        a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        if ((((ec)localObject).dqm.dpK) || (h.ap(this.KnP.getContext(), this.hHv.getType()))) {
          paraml.a(4, this.KnP.getString(2131757228), 2131691607);
        }
      }
      AppMethodBeat.o(187513);
      return;
      label261:
      if ((b.m(this.hHv)) || (b.bX(this.hHv)))
      {
        if (!this.hHv.cyH()) {
          localObject = this.KnP.getString(2131762784);
        }
      }
      else {
        localObject = this.KnP.getString(2131762783);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.15
 * JD-Core Version:    0.7.0.1
 */