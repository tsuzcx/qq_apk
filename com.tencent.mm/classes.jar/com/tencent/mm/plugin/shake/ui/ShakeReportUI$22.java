package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.ProfileHdHeadImg;

final class ShakeReportUI$22
  implements View.OnClickListener
{
  ShakeReportUI$22(ShakeReportUI paramShakeReportUI)
  {
    AppMethodBeat.i(161436);
    AppMethodBeat.o(161436);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(273546);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/shake/ui/ShakeReportUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    if (ShakeReportUI.g(this.PEm) != 4)
    {
      localObject = new Intent(this.PEm.getContext(), ProfileHdHeadImg.class);
      ((Intent)localObject).putExtra("username", (String)ShakeReportUI.h(this.PEm).getTag());
      paramView = this.PEm;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/shake/ui/ShakeReportUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView = com.tencent.mm.plugin.shake.a.PyM;
      com.tencent.mm.plugin.shake.a.a(5, null);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakeReportUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(273546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeReportUI.22
 * JD-Core Version:    0.7.0.1
 */