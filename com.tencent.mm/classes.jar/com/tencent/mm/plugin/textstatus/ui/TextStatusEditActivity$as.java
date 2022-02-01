package com.tencent.mm.plugin.textstatus.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bo;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.g.a;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class TextStatusEditActivity$as
  implements View.OnClickListener
{
  TextStatusEditActivity$as(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(233509);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    if (!this.MMz.gmN().isEnabled())
    {
      this.MMz.abd(null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(233509);
      return;
    }
    com.tencent.mm.ui.tools.b.c.i((EditText)this.MMz.gmI()).b(g.a.XSu).mM(0, 64).Hh(false).a((c.a)this.MMz);
    paramView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
    if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddC() != null)
    {
      paramView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (!com.tencent.mm.plugin.finder.live.utils.a.dEy()) {
        break label213;
      }
      paramView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KP(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddD() + 1);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddD();
      JSONObject localJSONObject = new JSONObject();
      paramView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddC();
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
      localJSONObject.put("5", paramView);
      paramView = k.yBj;
      k.a(s.c.yEn, localJSONObject.toString());
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(233509);
      return;
      label213:
      paramView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.KP(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddD() + 1);
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddD();
      paramView = m.yCt;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
      paramView.a(com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddC(), s.bo.yNh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.as
 * JD-Core Version:    0.7.0.1
 */