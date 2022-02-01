package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.y;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class ImageGalleryUI$24
  implements View.OnClickListener
{
  ImageGalleryUI$24(ImageGalleryUI paramImageGalleryUI, y paramy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(194169);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if ((this.JSy == null) || (bt.isNullOrNil(this.JSy.doK)))
    {
      ad.w("MicroMsg.ImageGalleryUI", "srcUserName is null");
      a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(194169);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.JSy.doK);
    paramView.putExtra("Contact_Scene", 163);
    paramView.putExtra("force_get_contact", true);
    paramView.putExtra("key_use_new_contact_profile", true);
    d.b(this.JSq.JPj.JPk, "profile", ".ui.ContactInfoUI", paramView);
    g.yhR.f(18589, new Object[] { Integer.valueOf(1), Integer.valueOf(ImageGalleryUI.H(this.JSq)) });
    a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(194169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.24
 * JD-Core Version:    0.7.0.1
 */