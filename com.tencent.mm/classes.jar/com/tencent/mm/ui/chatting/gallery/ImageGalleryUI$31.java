package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.message.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class ImageGalleryUI$31
  implements View.OnClickListener
{
  ImageGalleryUI$31(ImageGalleryUI paramImageGalleryUI, y paramy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(254540);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((this.aeAy == null) || (Util.isNullOrNil(this.aeAy.hEE)))
    {
      Log.w("MicroMsg.ImageGalleryUI", "srcUserName is null");
      a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(254540);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.aeAy.hEE);
    paramView.putExtra("Contact_Scene", 163);
    paramView.putExtra("force_get_contact", true);
    paramView.putExtra("key_use_new_contact_profile", true);
    c.b(this.aeDZ.aeAg.aeAB, "profile", ".ui.ContactInfoUI", paramView);
    com.tencent.mm.plugin.report.service.h.OAn.b(18589, new Object[] { Integer.valueOf(1), Integer.valueOf(ImageGalleryUI.ad(this.aeDZ)) });
    a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(254540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.31
 * JD-Core Version:    0.7.0.1
 */