package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63194);
    paramView = com.tencent.mm.ay.a.aGy();
    if ((paramView != null) && (paramView.hOr) && (!TextUtils.isEmpty(paramView.hOs)))
    {
      paramView = paramView.hOs;
      ac.i("MusicBanner", "barBackToWebView is true, start to jump Url:%s", new Object[] { paramView });
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView);
      d.b((Context)this.vhD.Dsc.get(), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(63194);
      return;
    }
    paramView = new Intent();
    h.wUl.f(11992, new Object[] { Integer.valueOf(1) });
    paramView.putExtra("key_scene", 1);
    d.b((Context)this.vhD.Dsc.get(), "music", ".ui.MusicMainUI", paramView);
    AppMethodBeat.o(63194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.a.1
 * JD-Core Version:    0.7.0.1
 */