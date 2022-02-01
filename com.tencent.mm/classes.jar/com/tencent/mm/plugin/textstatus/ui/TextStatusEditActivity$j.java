package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TextStatusEditActivity$j
  implements View.OnClickListener
{
  TextStatusEditActivity$j(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216497);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$locationClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = g.aAh();
    p.g(paramView, "MMKernel.storage()");
    paramView = paramView.azQ().get(274436);
    if (paramView == null)
    {
      paramView = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(216497);
      throw paramView;
    }
    if (com.tencent.mm.aw.b.Pi((String)paramView))
    {
      if ((com.tencent.mm.pluginsdk.permission.b.n((Context)this.GeQ.getContext(), "android.permission.ACCESS_FINE_LOCATION")) && (com.tencent.mm.pluginsdk.permission.b.n((Context)this.GeQ.getContext(), "android.permission.ACCESS_COARSE_LOCATION"))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label348;
        }
        paramView = g.aAh();
        p.g(paramView, "MMKernel.storage()");
        paramView = paramView.azQ().get(ar.a.Oho, Boolean.FALSE);
        if (paramView != null) {
          break;
        }
        paramView = new t("null cannot be cast to non-null type kotlin.Boolean");
        AppMethodBeat.o(216497);
        throw paramView;
      }
      if (!((Boolean)paramView).booleanValue()) {
        com.tencent.mm.plugin.account.a.b.a.b((Context)this.GeQ.getContext(), this.GeQ.getString(2131762481, new Object[] { LocaleUtil.getApplicationLanguage() }), 30764, true);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$locationClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216497);
        return;
        com.tencent.mm.pluginsdk.permission.b.a((Activity)this.GeQ.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 64);
      }
    }
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)this.GeQ.getContext(), new String[] { "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION" }, 64, null, null);
    Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$locationClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216497);
      return;
    }
    label348:
    this.GeQ.fwB();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$locationClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(216497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.j
 * JD-Core Version:    0.7.0.1
 */