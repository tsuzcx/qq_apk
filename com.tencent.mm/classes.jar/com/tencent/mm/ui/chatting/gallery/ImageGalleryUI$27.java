package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.y;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;

final class ImageGalleryUI$27
  implements View.OnClickListener
{
  ImageGalleryUI$27(ImageGalleryUI paramImageGalleryUI, y paramy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(187528);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    paramView = new Intent();
    int i = this.KnP.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
    paramView.putExtra("srcUsername", this.KnX.dpP);
    paramView.putExtra("srcDisplayname", this.KnX.hFW);
    localObject = m.d(this.KnX.FUw, 139, i, (int)(System.currentTimeMillis() / 1000L));
    if (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.KnP, (String)localObject, -1, 139, i, paramView))
    {
      paramView.putExtra("rawUrl", (String)localObject);
      d.b(this.KnP, "webview", ".ui.tools.WebViewUI", paramView);
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(18589, new Object[] { Integer.valueOf(15), Integer.valueOf(ImageGalleryUI.J(this.KnP)) });
    a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(187528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.27
 * JD-Core Version:    0.7.0.1
 */