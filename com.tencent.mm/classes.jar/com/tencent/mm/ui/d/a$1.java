package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(29989);
    this.zhh.Ox(1);
    paramView = this.zhh;
    String str = this.zhh.mUrl;
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
      AppMethodBeat.o(29989);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", str);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    d.b((Context)paramView.vUD.get(), "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(29989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.d.a.1
 * JD-Core Version:    0.7.0.1
 */