package com.tencent.mm.plugin.webview.luggage;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.api.c;

final class DownloadProgressImageView$3
  implements View.OnClickListener
{
  DownloadProgressImageView$3(DownloadProgressImageView paramDownloadProgressImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(175719);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/webview/luggage/DownloadProgressImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Intent();
    paramView.putExtra("view_task", true);
    paramView.putExtra("from_scene", 3);
    ((c)g.af(c.class)).a(this.ISH.getContext(), paramView, null);
    a.a(this, "com/tencent/mm/plugin/webview/luggage/DownloadProgressImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(175719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.DownloadProgressImageView.3
 * JD-Core Version:    0.7.0.1
 */