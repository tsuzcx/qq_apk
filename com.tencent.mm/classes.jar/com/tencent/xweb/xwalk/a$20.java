package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.k;
import org.xwalk.core.XWalkEnvironment;

final class a$20
  implements View.OnClickListener
{
  a$20(a parama) {}
  
  public final void onClick(View paramView)
  {
    XWalkEnvironment.setGrayValueForTest(0);
    XWalkEnvironment.setTestDownLoadUrl(this.xlg.xgK, "");
    k.cSk().a("tools", WebView.d.xhn);
    k.cSk().a("toolsmp", WebView.d.xhn);
    k.cSk().a("appbrand", WebView.d.xhn);
    k.cSk().a("support", WebView.d.xhn);
    k.cSk().a("mm", WebView.d.xhn);
    this.xlg.ahe("已使用AUTO，点任意位置重启进程生效\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.20
 * JD-Core Version:    0.7.0.1
 */