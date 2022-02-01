package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63194);
    paramView = com.tencent.mm.az.a.azI();
    if ((paramView != null) && (paramView.hnO) && (!TextUtils.isEmpty(paramView.hnP)))
    {
      paramView = paramView.hnP;
      ad.i("MusicBanner", "barBackToWebView is true, start to jump Url:%s", new Object[] { paramView });
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView);
      d.b((Context)this.tYK.BZM.get(), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(63194);
      return;
    }
    paramView = new Intent();
    h.vKh.f(11992, new Object[] { Integer.valueOf(1) });
    paramView.putExtra("key_scene", 1);
    d.b((Context)this.tYK.BZM.get(), "music", ".ui.MusicMainUI", paramView);
    AppMethodBeat.o(63194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.a.1
 * JD-Core Version:    0.7.0.1
 */