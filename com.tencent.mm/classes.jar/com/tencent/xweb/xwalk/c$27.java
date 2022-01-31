package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.q;

final class c$27
  implements View.OnClickListener
{
  c$27(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(85148);
    q.dYn().a("tools", WebView.d.BEs);
    q.dYn().a("toolsmp", WebView.d.BEs);
    q.dYn().a("appbrand", WebView.d.BEs);
    q.dYn().a("support", WebView.d.BEs);
    q.dYn().a("mm", WebView.d.BEs);
    this.BIO.cA("已使用system，点任意位置重启进程生效\n", true);
    AppMethodBeat.o(85148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.27
 * JD-Core Version:    0.7.0.1
 */