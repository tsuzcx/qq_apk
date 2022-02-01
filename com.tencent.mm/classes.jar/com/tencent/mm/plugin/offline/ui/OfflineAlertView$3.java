package com.tencent.mm.plugin.offline.ui;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.d;

final class OfflineAlertView$3
  implements View.OnClickListener
{
  OfflineAlertView$3(OfflineAlertView paramOfflineAlertView, CheckBox paramCheckBox, View.OnClickListener paramOnClickListener, ViewGroup paramViewGroup) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(272198);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/offline/ui/OfflineAlertView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (this.GDG.isChecked())
    {
      this.GDH.onClick(paramView);
      h.IzE.a(22805, new Object[] { Integer.valueOf(2) });
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/offline/ui/OfflineAlertView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(272198);
      return;
      int i = this.GDE.getResources().getDimensionPixelOffset(a.d.Edge_A);
      paramView = ObjectAnimator.ofFloat(this.GDI, "translationX", new float[] { 0.0F, -i, i, -i, 0.0F }).setDuration(300L);
      paramView.setInterpolator(new LinearInterpolator());
      paramView.start();
      h.IzE.a(22805, new Object[] { Integer.valueOf(1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.OfflineAlertView.3
 * JD-Core Version:    0.7.0.1
 */