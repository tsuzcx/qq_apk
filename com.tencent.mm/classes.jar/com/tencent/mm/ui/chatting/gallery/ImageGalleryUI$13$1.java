package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qd.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;

final class ImageGalleryUI$13$1
  implements Runnable
{
  ImageGalleryUI$13$1(ImageGalleryUI.13 param13, qd paramqd) {}
  
  public final void run()
  {
    AppMethodBeat.i(156714);
    if (ImageGalleryUI.h(this.zMJ.zME) == this.zMI.cGG.cnU)
    {
      ImageGalleryUI.g(this.zMJ.zME);
      if (this.zMI.cGG.cnz)
      {
        if (!e.cN(this.zMI.cGG.cGH)) {
          break label207;
        }
        String str = ImageGalleryUI.F(this.zMJ.zME);
        Intent localIntent = new Intent();
        localIntent.putExtra("original_file_path", str);
        localIntent.putExtra("msg_id", ImageGalleryUI.j(this.zMJ.zME).Pz(ImageGalleryUI.G(this.zMJ.zME)).field_msgId);
        ImageGalleryUI.b(this.zMJ.zME, TranslationResultUI.class, localIntent);
        this.zMJ.zME.finish();
        this.zMJ.zME.overridePendingTransition(2131034130, 2131034130);
      }
    }
    for (;;)
    {
      ImageGalleryUI.i(this.zMJ.zME);
      h.a(this.zMJ.zME, this.zMJ.zME.getString(2131302944), "", false, null);
      AppMethodBeat.o(156714);
      return;
      label207:
      ab.w("MicroMsg.ImageGalleryUI", "trans result path %s not exist!", new Object[] { this.zMI.cGG.cGH });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.13.1
 * JD-Core Version:    0.7.0.1
 */