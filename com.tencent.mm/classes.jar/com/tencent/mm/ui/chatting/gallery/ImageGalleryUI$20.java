package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.y;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.h;

final class ImageGalleryUI$20
  implements View.OnClickListener
{
  ImageGalleryUI$20(ImageGalleryUI paramImageGalleryUI, y paramy) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(36130);
    paramView = new Intent();
    int i = this.IcP.getIntent().getIntExtra("KOpenArticleSceneFromScene", 1);
    paramView.putExtra("srcUsername", this.IcX.ddo);
    paramView.putExtra("srcDisplayname", this.IcX.hkV);
    String str = m.d(this.IcX.DWF, 139, i, (int)(System.currentTimeMillis() / 1000L));
    if (!((b)g.ab(b.class)).a(this.IcP, str, -1, 139, i, paramView))
    {
      paramView.putExtra("rawUrl", str);
      d.b(this.IcP, "webview", ".ui.tools.WebViewUI", paramView);
    }
    h.wUl.f(18589, new Object[] { Integer.valueOf(15), Integer.valueOf(ImageGalleryUI.B(this.IcP)) });
    AppMethodBeat.o(36130);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.ImageGalleryUI.20
 * JD-Core Version:    0.7.0.1
 */