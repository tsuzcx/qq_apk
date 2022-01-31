package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.q;
import org.xwalk.core.XWalkEnvironment;

final class c$28
  implements View.OnClickListener
{
  c$28(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(85149);
    XWalkEnvironment.setGrayValueForTest(0);
    XWalkEnvironment.setTestDownLoadUrl(this.BIO.BDH, "");
    q.dYn().a("tools", WebView.d.BEp);
    q.dYn().a("toolsmp", WebView.d.BEp);
    q.dYn().a("appbrand", WebView.d.BEp);
    q.dYn().a("support", WebView.d.BEp);
    q.dYn().a("mm", WebView.d.BEp);
    this.BIO.cA("已使用AUTO，点任意位置重启进程生效\n", true);
    AppMethodBeat.o(85149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.28
 * JD-Core Version:    0.7.0.1
 */