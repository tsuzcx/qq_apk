package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import org.xwalk.core.XWalkEnvironment;

final class a$11
  implements View.OnClickListener
{
  a$11(a parama, Button paramButton) {}
  
  public final void onClick(View paramView)
  {
    if (XWalkEnvironment.hasPluginTestConfigUrl())
    {
      if (XWalkEnvironment.setPluginTestConfigUrl(""))
      {
        this.xll.setText("切换插件config，当前使用正式版");
        return;
      }
      this.xlg.bU("切换失败", true);
      return;
    }
    if (XWalkEnvironment.setPluginTestConfigUrl("http://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml"))
    {
      this.xll.setText("切换插件config，当前使用测试版");
      return;
    }
    this.xlg.bU("切换失败", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.11
 * JD-Core Version:    0.7.0.1
 */