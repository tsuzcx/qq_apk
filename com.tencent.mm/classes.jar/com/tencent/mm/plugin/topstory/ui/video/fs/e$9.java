package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.protocal.c.byg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;

final class e$9
  implements View.OnClickListener
{
  e$9(e parame) {}
  
  public final void onClick(View paramView)
  {
    if ((e.d(this.pGX) != null) && (!bk.bl(e.e(this.pGX).mSy)))
    {
      paramView = new Intent();
      paramView.putExtra("rawUrl", e.f(this.pGX).mSy);
      d.b(this.pGX.getFSVideoUIComponent().bfn().getApplicationContext(), "webview", ".ui.tools.WebViewUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.e.9
 * JD-Core Version:    0.7.0.1
 */