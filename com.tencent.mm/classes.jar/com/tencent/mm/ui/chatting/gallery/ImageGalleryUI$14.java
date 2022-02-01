package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;

final class ImageGalleryUI$14
  implements n.d
{
  ImageGalleryUI$14(ImageGalleryUI paramImageGalleryUI, bu parambu) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(194155);
    paraml.clear();
    Object localObject;
    if (!bl.A(this.hED))
    {
      localObject = null;
      if ((!b.j(this.hED)) && (!b.bZ(this.hED))) {
        break label251;
      }
      localObject = this.JSq.getString(2131762781);
    }
    for (;;)
    {
      paraml.a(1, (CharSequence)localObject, 2131690560);
      if ((b.j(this.hED)) && (ImageGalleryUI.C(this.JSq))) {
        paraml.a(6, this.JSq.getString(2131757183), 2131690634);
      }
      if ((ImageGalleryUI.D(this.JSq)) && (!ImageGalleryUI.E(this.JSq)) && (!am.ail(this.JSq.talker))) {
        paraml.a(5, this.JSq.getString(2131757182), 2131690532);
      }
      if ((b.j(this.hED)) || (b.bX(this.hED)))
      {
        localObject = new eb();
        ((eb)localObject).dpg.msgId = this.hED.field_msgId;
        a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        if ((((eb)localObject).dph.doF) || (h.ap(this.JSq.getContext(), this.hED.getType()))) {
          paraml.a(4, this.JSq.getString(2131757228), 2131691607);
        }
      }
      AppMethodBeat.o(194155);
      return;
      label251:
      if ((b.m(this.hED)) || (b.bX(this.hED)))
      {
        if (!this.hED.cxg()) {
          localObject = this.JSq.getString(2131762784);
        }
      }
      else {
        localObject = this.JSq.getString(2131762783);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.14
 * JD-Core Version:    0.7.0.1
 */