package com.tencent.mm.plugin.radar.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.f.e;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class RadarMemberView$g
  implements View.OnClickListener
{
  RadarMemberView$g(RadarMemberView paramRadarMemberView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(138598);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    localObject = new Intent();
    paramView = RadarMemberView.c(this.Hvj);
    if (paramView != null) {}
    for (paramView = paramView.getUsername();; paramView = null)
    {
      ((Intent)localObject).putExtra("k_username", paramView);
      ((Intent)localObject).putExtra("showShare", false);
      paramView = af.aaBG;
      paramView = f.e.VRX;
      p.j(paramView, "ConstantsUI.ExposeUI.KExposeH5Url");
      paramView = String.format(paramView, Arrays.copyOf(new Object[] { Integer.valueOf(38) }, 1));
      p.j(paramView, "java.lang.String.format(format, *args)");
      ((Intent)localObject).putExtra("rawUrl", paramView);
      c.b(this.Hvj.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      a.a(this, "com/tencent/mm/plugin/radar/ui/RadarMemberView$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(138598);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.g
 * JD-Core Version:    0.7.0.1
 */