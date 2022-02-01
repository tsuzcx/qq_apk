package com.tencent.mm.plugin.radar.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.storage.an;
import d.g.b.ad;
import d.g.b.p;
import d.l;
import java.util.Arrays;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class RadarMemberView$g
  implements View.OnClickListener
{
  RadarMemberView$g(RadarMemberView paramRadarMemberView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138598);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    localObject = new Intent();
    paramView = RadarMemberView.c(this.xzN);
    if (paramView != null) {}
    for (paramView = paramView.getUsername();; paramView = null)
    {
      ((Intent)localObject).putExtra("k_username", paramView);
      ((Intent)localObject).putExtra("showShare", false);
      paramView = ad.Njc;
      paramView = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[] { Integer.valueOf(38) }, 1));
      p.g(paramView, "java.lang.String.format(format, *args)");
      ((Intent)localObject).putExtra("rawUrl", paramView);
      d.b(this.xzN.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(138598);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.g
 * JD-Core Version:    0.7.0.1
 */