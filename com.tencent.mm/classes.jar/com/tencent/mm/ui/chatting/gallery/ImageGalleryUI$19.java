package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.y;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class ImageGalleryUI$19
  implements View.OnClickListener
{
  ImageGalleryUI$19(ImageGalleryUI paramImageGalleryUI, y paramy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(36129);
    if ((this.IcX == null) || (bs.isNullOrNil(this.IcX.ddo)))
    {
      ac.w("MicroMsg.ImageGalleryUI", "srcUserName is null");
      AppMethodBeat.o(36129);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.IcX.ddo);
    paramView.putExtra("Contact_Scene", 163);
    paramView.putExtra("force_get_contact", true);
    paramView.putExtra("key_use_new_contact_profile", true);
    d.b(ImageGalleryUI.i(this.IcP).HZV, "profile", ".ui.ContactInfoUI", paramView);
    h.wUl.f(18589, new Object[] { Integer.valueOf(1), Integer.valueOf(ImageGalleryUI.B(this.IcP)) });
    AppMethodBeat.o(36129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.19
 * JD-Core Version:    0.7.0.1
 */