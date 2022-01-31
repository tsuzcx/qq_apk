package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(105055);
    paramView = com.tencent.mm.aw.a.aiz();
    if ((paramView != null) && (paramView.fKI) && (!TextUtils.isEmpty(paramView.fKJ)))
    {
      paramView = paramView.fKJ;
      ab.i("MusicBanner", "barBackToWebView is true, start to jump Url:%s", new Object[] { paramView });
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView);
      d.b((Context)this.pbw.vUD.get(), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(105055);
      return;
    }
    paramView = new Intent();
    h.qsU.e(11992, new Object[] { Integer.valueOf(1) });
    paramView.putExtra("key_scene", 1);
    d.b((Context)this.pbw.vUD.get(), "music", ".ui.MusicMainUI", paramView);
    AppMethodBeat.o(105055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.a.1
 * JD-Core Version:    0.7.0.1
 */