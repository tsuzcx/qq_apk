package com.tencent.mm.ui.chatting.gallery;

import android.content.res.Resources;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.b.a.m;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;

final class ImageGalleryUI$13
  implements n.d
{
  ImageGalleryUI$13(ImageGalleryUI paramImageGalleryUI, bu parambu) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(194154);
    paraml.clear();
    if (!bl.A(this.hED))
    {
      paraml.a(0, this.JSq.getString(2131762566), 2131690478, this.JSq.getResources().getColor(2131099699));
      if ((this.hED != null) && (this.hED.cxg()) && (x.ffw())) {
        paraml.a(10, this.JSq.getString(2131762164), 2131689817, 0);
      }
    }
    if (d.aIu("favorite")) {
      paraml.a(2, this.JSq.getString(2131761941), 2131689808, 0);
    }
    if ((((c)com.tencent.mm.kernel.g.ad(c.class)).isOpenImageSearch()) && (b.j(this.hED)))
    {
      paraml.a(11, this.JSq.getString(2131762922), 2131690474, this.JSq.getResources().getColor(2131099803));
      h.LTJ.aR(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194153);
          m localm1 = new m();
          m localm2 = localm1.gI("").gJ(String.valueOf(ImageGalleryUI.13.this.hED.field_msgSvrId));
          localm2.dSf = 2;
          localm2.dPT = 1;
          localm2.dSg = 67;
          if (w.vF(ImageGalleryUI.13.this.hED.field_talker))
          {
            localm1.gK(bj.Bk(ImageGalleryUI.13.this.hED.field_content));
            localm1.gL(ImageGalleryUI.13.this.hED.field_talker);
            localm1.dSj = 2;
            localm1.gM(com.tencent.mm.b.g.getMD5(ImageGalleryUI.a(ImageGalleryUI.13.this.JSq)));
            localm1.aLk();
            am.a(localm1);
            AppMethodBeat.o(194153);
            return;
          }
          if (ImageGalleryUI.13.this.hED.field_isSend == 1) {
            localm1.gK(u.aAm());
          }
          for (;;)
          {
            localm1.gL("");
            localm1.dSj = 1;
            break;
            localm1.gK(ImageGalleryUI.13.this.hED.field_talker);
          }
        }
      });
    }
    AppMethodBeat.o(194154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.13
 * JD-Core Version:    0.7.0.1
 */