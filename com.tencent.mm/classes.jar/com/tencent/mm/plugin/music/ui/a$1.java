package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63194);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/MusicBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    paramView = com.tencent.mm.az.a.aJJ();
    if ((paramView != null) && (paramView.ihF) && (!TextUtils.isEmpty(paramView.ihG)))
    {
      paramView = paramView.ihG;
      ad.i("MusicBanner", "barBackToWebView is true, start to jump Url:%s", new Object[] { paramView });
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", paramView);
      d.b((Context)this.wmY.EXg.get(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/MusicBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(63194);
      return;
      paramView = new Intent();
      g.yhR.f(11992, new Object[] { Integer.valueOf(1) });
      paramView.putExtra("key_scene", 1);
      d.b((Context)this.wmY.EXg.get(), "music", ".ui.MusicMainUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.a.1
 * JD-Core Version:    0.7.0.1
 */