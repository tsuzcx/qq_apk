package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.aj.y;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ImageGalleryUI$33
  implements View.OnClickListener
{
  ImageGalleryUI$33(ImageGalleryUI paramImageGalleryUI, y paramy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(285326);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = new Intent();
    int i = this.WUq.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
    paramView.putExtra("srcUsername", this.WQS.fzT);
    paramView.putExtra("srcDisplayname", this.WQS.lpC);
    localObject = m.e(this.WQS.ROZ, 139, i, (int)(System.currentTimeMillis() / 1000L));
    if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(139)) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(this.WUq, (String)localObject, -1, 139, i, paramView))) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramView.putExtra("rawUrl", (String)localObject);
        com.tencent.mm.by.c.b(this.WUq, "webview", ".ui.tools.WebViewUI", paramView);
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(18589, new Object[] { Integer.valueOf(15), Integer.valueOf(ImageGalleryUI.ac(this.WUq)) });
      a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285326);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.33
 * JD-Core Version:    0.7.0.1
 */