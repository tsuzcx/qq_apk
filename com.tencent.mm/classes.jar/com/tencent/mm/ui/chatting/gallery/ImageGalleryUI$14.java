package com.tencent.mm.ui.chatting.gallery;

import android.content.res.Resources;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.b.a.m;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;

final class ImageGalleryUI$14
  implements n.d
{
  ImageGalleryUI$14(ImageGalleryUI paramImageGalleryUI, bv parambv) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(187512);
    paraml.clear();
    if (!bn.A(this.hHv))
    {
      paraml.a(0, this.KnP.getString(2131762566), 2131690478, this.KnP.getResources().getColor(2131099699));
      if ((this.hHv != null) && (this.hHv.cyH()) && (com.tencent.mm.pluginsdk.ui.tools.x.fjm())) {
        paraml.a(10, this.KnP.getString(2131762164), 2131689817, 0);
      }
    }
    if (d.aJN("favorite")) {
      paraml.a(2, this.KnP.getString(2131761941), 2131689808, 0);
    }
    if ((((c)com.tencent.mm.kernel.g.ad(c.class)).isOpenImageSearch()) && (b.j(this.hHv)))
    {
      paraml.a(11, this.KnP.getString(2131762922), 2131690474, this.KnP.getResources().getColor(2131099803));
      h.MqF.aO(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187511);
          m localm1 = new m();
          m localm2 = localm1.gO("").gP(String.valueOf(ImageGalleryUI.14.this.hHv.field_msgSvrId));
          localm2.dTv = 2;
          localm2.dRj = 1;
          localm2.dTw = 67;
          if (com.tencent.mm.model.x.wb(ImageGalleryUI.14.this.hHv.field_talker))
          {
            localm1.gQ(bl.BM(ImageGalleryUI.14.this.hHv.field_content));
            localm1.gR(ImageGalleryUI.14.this.hHv.field_talker);
            localm1.dTz = 2;
            localm1.gS(com.tencent.mm.b.g.getMD5(ImageGalleryUI.a(ImageGalleryUI.14.this.KnP)));
            localm1.aLH();
            am.a(localm1);
            AppMethodBeat.o(187511);
            return;
          }
          if (ImageGalleryUI.14.this.hHv.field_isSend == 1) {
            localm1.gQ(v.aAC());
          }
          for (;;)
          {
            localm1.gR("");
            localm1.dTz = 1;
            break;
            localm1.gQ(ImageGalleryUI.14.this.hHv.field_talker);
          }
        }
      });
    }
    AppMethodBeat.o(187512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.14
 * JD-Core Version:    0.7.0.1
 */