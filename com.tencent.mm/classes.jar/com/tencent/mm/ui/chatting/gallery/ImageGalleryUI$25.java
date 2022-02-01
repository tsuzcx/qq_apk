package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.y;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;

final class ImageGalleryUI$25
  implements View.OnClickListener
{
  ImageGalleryUI$25(ImageGalleryUI paramImageGalleryUI, y paramy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(194170);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    paramView = new Intent();
    int i = this.JSq.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
    paramView.putExtra("srcUsername", this.JSy.doK);
    paramView.putExtra("srcDisplayname", this.JSy.hDe);
    localObject = m.d(this.JSy.FCb, 139, i, (int)(System.currentTimeMillis() / 1000L));
    if (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.JSq, (String)localObject, -1, 139, i, paramView))
    {
      paramView.putExtra("rawUrl", (String)localObject);
      d.b(this.JSq, "webview", ".ui.tools.WebViewUI", paramView);
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(18589, new Object[] { Integer.valueOf(15), Integer.valueOf(ImageGalleryUI.H(this.JSq)) });
    a.a(this, "com/tencent/mm/ui/chatting/gallery/ImageGalleryUI$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(194170);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.25
 * JD-Core Version:    0.7.0.1
 */