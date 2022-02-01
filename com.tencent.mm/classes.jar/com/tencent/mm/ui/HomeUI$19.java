package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.multitask.ui.panel.MultiTaskContainerView;
import com.tencent.mm.plugin.multitask.ui.uic.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.g.b.s;

final class HomeUI$19
  implements View.OnClickListener
{
  HomeUI$19(HomeUI paramHomeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(249457);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    a.c("com/tencent/mm/ui/HomeUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    paramView = k.aeZF;
    paramView = (c)k.d(HomeUI.j(this.adBf)).q(c.class);
    Log.i(c.TAG, s.X("showPanel, smoothScrool:", Boolean.TRUE));
    paramView.LHr = 2;
    paramView.glf();
    localObject = paramView.LHz;
    if (localObject != null) {
      ((MultiTaskContainerView)localObject).acx(0);
    }
    paramView = paramView.LHn;
    if (paramView != null) {
      paramView.setCurrentItem(0, true);
    }
    a.a(this, "com/tencent/mm/ui/HomeUI$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(249457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.19
 * JD-Core Version:    0.7.0.1
 */