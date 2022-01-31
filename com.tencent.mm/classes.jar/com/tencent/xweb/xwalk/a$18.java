package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.k;

final class a$18
  implements View.OnClickListener
{
  a$18(a parama) {}
  
  public final void onClick(View paramView)
  {
    k.cSk().a("tools", WebView.d.xhp);
    k.cSk().a("toolsmp", WebView.d.xhp);
    k.cSk().a("appbrand", WebView.d.xhp);
    k.cSk().a("support", WebView.d.xhp);
    k.cSk().a("mm", WebView.d.xhp);
    if (WebView.getInstalledTbsCoreVersion(this.xlg.xgK) <= 0)
    {
      this.xlg.bU("已切换x5，但是x5未ready，点任意位置重启进程生效\n", true);
      return;
    }
    this.xlg.ahe("已使用x5，点任意位置重启进程生效\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.18
 * JD-Core Version:    0.7.0.1
 */