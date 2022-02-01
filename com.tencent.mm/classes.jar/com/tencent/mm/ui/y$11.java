package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ay;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class y$11
  implements View.OnClickListener
{
  y$11(y paramy, String paramString, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(141341);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/MMActivityController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new ay();
    paramView.hAK.type = 1;
    paramView.hAK.event = this.oiS;
    paramView.hAK.position = this.dyI;
    paramView.publish();
    y.b(this.adEy).setVisibility(8);
    a.a(this, "com/tencent/mm/ui/MMActivityController$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(141341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.y.11
 * JD-Core Version:    0.7.0.1
 */