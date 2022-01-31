package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.q;

final class c$26
  implements View.OnClickListener
{
  c$26(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(85147);
    q.dYn().a("tools", WebView.d.BEr);
    q.dYn().a("toolsmp", WebView.d.BEr);
    q.dYn().a("appbrand", WebView.d.BEr);
    q.dYn().a("support", WebView.d.BEr);
    q.dYn().a("mm", WebView.d.BEr);
    if (WebView.getInstalledTbsCoreVersion(this.BIO.BDH) <= 0)
    {
      this.BIO.cz("已切换x5，但是x5未ready，点任意位置重启进程生效\n", true);
      AppMethodBeat.o(85147);
      return;
    }
    this.BIO.cA("已使用x5，点任意位置重启进程生效\n", true);
    AppMethodBeat.o(85147);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.26
 * JD-Core Version:    0.7.0.1
 */