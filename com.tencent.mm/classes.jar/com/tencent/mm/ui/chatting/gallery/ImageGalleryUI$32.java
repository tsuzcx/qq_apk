package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.y;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class ImageGalleryUI$32
  implements View.OnClickListener
{
  ImageGalleryUI$32(ImageGalleryUI paramImageGalleryUI, y paramy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(287621);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if ((this.WQS == null) || (Util.isNullOrNil(this.WQS.fzT)))
    {
      Log.w("MicroMsg.ImageGalleryUI", "srcUserName is null");
      a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287621);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.WQS.fzT);
    paramView.putExtra("Contact_Scene", 163);
    paramView.putExtra("force_get_contact", true);
    paramView.putExtra("key_use_new_contact_profile", true);
    c.b(this.WUq.WQM.WQV, "profile", ".ui.ContactInfoUI", paramView);
    h.IzE.a(18589, new Object[] { Integer.valueOf(1), Integer.valueOf(ImageGalleryUI.ac(this.WUq)) });
    a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287621);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.32
 * JD-Core Version:    0.7.0.1
 */