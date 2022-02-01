package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import org.xwalk.core.XWalkEnvironment;

final class d$13
  implements View.OnClickListener
{
  d$13(d paramd, Button paramButton) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154164);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = XWalkEnvironment.getPluginTestConfigUrl();
    if ((paramView != null) && (!paramView.isEmpty())) {
      if (XWalkEnvironment.setPluginTestConfigUrl("")) {
        this.SGk.setText("切换插件配置，当前使用正式版");
      }
    }
    for (;;)
    {
      a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(154164);
      return;
      this.SGe.dQ("切换失败", true);
      continue;
      if (XWalkEnvironment.setPluginTestConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml")) {
        this.SGk.setText("切换插件配置，当前使用默认测试版");
      } else {
        this.SGe.dQ("切换失败", true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.13
 * JD-Core Version:    0.7.0.1
 */