package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

final class e$12
  implements View.OnClickListener
{
  e$12(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(1897);
    if ((e.e(this.tkq) != null) && (!bo.isNullOrNil(e.f(this.tkq).puE)))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", e.g(this.tkq).puE);
      d.b(this.tkq.getFSVideoUIComponent().bMN().getApplicationContext(), "webview", ".ui.tools.WebViewUI", paramView);
    }
    AppMethodBeat.o(1897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.12
 * JD-Core Version:    0.7.0.1
 */