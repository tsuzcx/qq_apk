package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.av.e;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    paramView = com.tencent.mm.av.a.Pw();
    if ((paramView != null) && (paramView.euW) && (!TextUtils.isEmpty(paramView.euX)))
    {
      paramView = paramView.euX;
      y.i("MusicBanner", "barBackToWebView is true, start to jump Url:%s", new Object[] { paramView });
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramView);
      d.b((Context)this.mBr.sdy.get(), "webview", ".ui.tools.WebViewUI", localIntent);
      return;
    }
    paramView = new Intent();
    h.nFQ.f(11992, new Object[] { Integer.valueOf(1) });
    paramView.putExtra("key_scene", 1);
    d.b((Context)this.mBr.sdy.get(), "music", ".ui.MusicMainUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.a.1
 * JD-Core Version:    0.7.0.1
 */