package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.y;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class ImageGalleryUI$26
  implements View.OnClickListener
{
  ImageGalleryUI$26(ImageGalleryUI paramImageGalleryUI, y paramy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(36129);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if ((this.KnX == null) || (bu.isNullOrNil(this.KnX.dpP)))
    {
      ae.w("MicroMsg.ImageGalleryUI", "srcUserName is null");
      a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(36129);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.KnX.dpP);
    paramView.putExtra("Contact_Scene", 163);
    paramView.putExtra("force_get_contact", true);
    paramView.putExtra("key_use_new_contact_profile", true);
    d.b(this.KnP.Kkv.Kkw, "profile", ".ui.ContactInfoUI", paramView);
    g.yxI.f(18589, new Object[] { Integer.valueOf(1), Integer.valueOf(ImageGalleryUI.J(this.KnP)) });
    a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(36129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.26
 * JD-Core Version:    0.7.0.1
 */