package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.at;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.event.EventCenter;

final class w$12
  implements View.OnClickListener
{
  w$12(w paramw, String paramString, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(141341);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/MMActivityController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new at();
    paramView.fwm.type = 1;
    paramView.fwm.event = this.lrr;
    paramView.fwm.position = this.bFI;
    EventCenter.instance.publish(paramView);
    w.b(this.Wad).setVisibility(8);
    a.a(this, "com/tencent/mm/ui/MMActivityController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(141341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.w.12
 * JD-Core Version:    0.7.0.1
 */