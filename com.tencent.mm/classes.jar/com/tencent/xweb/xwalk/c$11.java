package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkEnvironment;

final class c$11
  implements View.OnClickListener
{
  c$11(c paramc, Button paramButton) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(85132);
    paramView = XWalkEnvironment.getPluginTestConfigUrl();
    if ((paramView != null) && (!paramView.isEmpty()))
    {
      if (XWalkEnvironment.setPluginTestConfigUrl(""))
      {
        this.BIT.setText("切换插件配置，当前使用正式版");
        AppMethodBeat.o(85132);
        return;
      }
      this.BIO.cz("切换失败", true);
      AppMethodBeat.o(85132);
      return;
    }
    if (XWalkEnvironment.setPluginTestConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml"))
    {
      this.BIT.setText("切换插件配置，当前使用默认测试版");
      AppMethodBeat.o(85132);
      return;
    }
    this.BIO.cz("切换失败", true);
    AppMethodBeat.o(85132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.11
 * JD-Core Version:    0.7.0.1
 */