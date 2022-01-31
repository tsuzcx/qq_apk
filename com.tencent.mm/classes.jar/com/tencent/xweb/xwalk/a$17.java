package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.k;
import org.xwalk.core.XWalkEnvironment;

final class a$17
  implements View.OnClickListener
{
  a$17(a parama) {}
  
  public final void onClick(View paramView)
  {
    XWalkEnvironment.setGrayValueForTest(1);
    if (!XWalkEnvironment.hasAvailableVersion())
    {
      if (XWalkEnvironment.isIaDevice())
      {
        this.xlg.agV("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml&check_xwalk_update");
        return;
      }
      this.xlg.agV("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml&check_xwalk_update");
      return;
    }
    k.cSk().a("tools", WebView.d.xho);
    k.cSk().a("toolsmp", WebView.d.xho);
    k.cSk().a("appbrand", WebView.d.xho);
    k.cSk().a("support", WebView.d.xho);
    k.cSk().a("mm", WebView.d.xho);
    this.xlg.ahe("已使用XWeb，点任意位置重启进程生效\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.17
 * JD-Core Version:    0.7.0.1
 */