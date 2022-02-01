package com.tencent.mm.plugin.textstatus.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.ba;
import com.tencent.mm.plugin.finder.report.live.s.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TextStatusEditActivity$v
  implements View.OnClickListener
{
  TextStatusEditActivity$v(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(216512);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if (!this.GeQ.fwu().isEnabled())
    {
      this.GeQ.Tx(null);
      a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216512);
      return;
    }
    com.tencent.mm.ui.tools.b.c.f(this.GeQ.fwr()).a(f.a.Qui).lv(1, 64).CN(false).a((c.a)this.GeQ);
    paramView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
    if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOJ() != null)
    {
      paramView = com.tencent.mm.plugin.finder.utils.m.vVH;
      if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
        break label210;
      }
      paramView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.Hf(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOK() + 1);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOK();
      JSONObject localJSONObject = new JSONObject();
      paramView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOJ();
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
      localJSONObject.put("5", paramView);
      paramView = k.vkd;
      k.a(s.c.vmT, localJSONObject.toString());
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216512);
      return;
      label210:
      paramView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.Hf(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOK() + 1);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOK();
      paramView = com.tencent.mm.plugin.finder.report.live.m.vli;
      paramView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
      com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOJ(), s.ba.vta);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.v
 * JD-Core Version:    0.7.0.1
 */