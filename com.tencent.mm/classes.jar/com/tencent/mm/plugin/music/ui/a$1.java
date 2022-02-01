package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63194);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/music/ui/MusicBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = com.tencent.mm.bb.a.bnA();
    if ((paramView != null) && (paramView.lVS) && (!TextUtils.isEmpty(paramView.lVT)))
    {
      paramView = paramView.lVT;
      Log.i("MusicBanner", "barBackToWebView is true, start to jump Url:%s", new Object[] { paramView });
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramView);
      c.b((Context)this.FUm.Rhc.get(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(63194);
      return;
      paramView = new Intent();
      h.IzE.a(11992, new Object[] { Integer.valueOf(1) });
      paramView.putExtra("key_scene", 1);
      c.b((Context)this.FUm.Rhc.get(), "music", ".ui.MusicMainUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.a.1
 * JD-Core Version:    0.7.0.1
 */