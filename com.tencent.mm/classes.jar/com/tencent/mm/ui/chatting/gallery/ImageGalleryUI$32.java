package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.message.m;
import com.tencent.mm.message.y;

final class ImageGalleryUI$32
  implements View.OnClickListener
{
  ImageGalleryUI$32(ImageGalleryUI paramImageGalleryUI, y paramy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(254530);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    paramView = new Intent();
    int i = this.aeDZ.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
    paramView.putExtra("srcUsername", this.aeAy.hEE);
    paramView.putExtra("srcDisplayname", this.aeAy.nUF);
    localObject = m.e(this.aeAy.YMm, 139, i, (int)(System.currentTimeMillis() / 1000L));
    if ((((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(139)) && (((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(this.aeDZ, (String)localObject, -1, 139, i, paramView))) {}
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramView.putExtra("rawUrl", (String)localObject);
        com.tencent.mm.br.c.b(this.aeDZ, "webview", ".ui.tools.WebViewUI", paramView);
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(18589, new Object[] { Integer.valueOf(15), Integer.valueOf(ImageGalleryUI.ad(this.aeDZ)) });
      a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(254530);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.32
 * JD-Core Version:    0.7.0.1
 */