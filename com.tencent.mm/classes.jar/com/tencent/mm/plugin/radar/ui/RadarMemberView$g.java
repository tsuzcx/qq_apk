package com.tencent.mm.plugin.radar.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.storage.af;
import d.g.b.k;
import d.g.b.z;
import d.l;
import java.util.Arrays;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class RadarMemberView$g
  implements View.OnClickListener
{
  RadarMemberView$g(RadarMemberView paramRadarMemberView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138598);
    Intent localIntent = new Intent();
    paramView = RadarMemberView.c(this.uTs);
    if (paramView != null) {}
    for (paramView = paramView.getUsername();; paramView = null)
    {
      localIntent.putExtra("k_username", paramView);
      localIntent.putExtra("showShare", false);
      paramView = z.Jhz;
      paramView = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", Arrays.copyOf(new Object[] { Integer.valueOf(38) }, 1));
      k.g(paramView, "java.lang.String.format(format, *args)");
      localIntent.putExtra("rawUrl", paramView);
      d.b(this.uTs.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(138598);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.g
 * JD-Core Version:    0.7.0.1
 */