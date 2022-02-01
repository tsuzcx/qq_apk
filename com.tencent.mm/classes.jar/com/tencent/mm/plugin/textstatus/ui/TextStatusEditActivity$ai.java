package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TextStatusEditActivity$ai
  implements View.OnClickListener
{
  TextStatusEditActivity$ai(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(237184);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$locationClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = h.aHG();
    p.j(paramView, "MMKernel.storage()");
    paramView = paramView.aHp().get(274436);
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(237184);
      throw paramView;
    }
    if (com.tencent.mm.az.b.WF((String)paramView))
    {
      if ((com.tencent.mm.pluginsdk.permission.b.o((Context)this.MMz.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.o((Context)this.MMz.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label349;
        }
        paramView = h.aHG();
        p.j(paramView, "MMKernel.storage()");
        paramView = paramView.aHp().get(ar.a.VvE, Boolean.FALSE);
        if (paramView != null) {
          break;
        }
        paramView = new t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(237184);
        throw paramView;
      }
      if (!((Boolean)paramView).booleanValue()) {
        com.tencent.mm.plugin.account.sdk.b.a.b((Context)this.MMz.getContext(), this.MMz.getString(b.h.location_use_scene_gdpr_url, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$locationClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(237184);
        return;
        com.tencent.mm.pluginsdk.permission.b.a((Activity)this.MMz.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 64);
      }
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this.MMz.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 64, null, null);
    Log.i("MicroMsg.TextStatus.TextStatusEditActivity", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$locationClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(237184);
      return;
    }
    label349:
    this.MMz.gnd();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$locationClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(237184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.ai
 * JD-Core Version:    0.7.0.1
 */