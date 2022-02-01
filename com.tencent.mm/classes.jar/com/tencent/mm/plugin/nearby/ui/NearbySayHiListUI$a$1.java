package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class NearbySayHiListUI$a$1
  implements View.OnClickListener
{
  NearbySayHiListUI$a$1(NearbySayHiListUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(89906);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.v("MicroMsg.SayHiAdapter", "on delView clicked");
    this.AAB.plb.ebp();
    if (this.AAB.AAA != null) {
      this.AAB.AAA.cZ(paramView.getTag());
    }
    a.a(this, "com/tencent/mm/plugin/nearby/ui/NearbySayHiListUI$SayHiAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(89906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.a.1
 * JD-Core Version:    0.7.0.1
 */