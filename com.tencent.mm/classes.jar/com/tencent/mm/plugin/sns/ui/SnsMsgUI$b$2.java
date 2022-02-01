package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class SnsMsgUI$b$2
  implements View.OnClickListener
{
  SnsMsgUI$b$2(SnsMsgUI.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98878);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/SnsMsgUI$SnsMsgAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.v("MicroMsg.SnsMsgUI", "on delView clicked");
    this.Ruf.vzi.fSn();
    if (this.Ruf.Rue != null) {
      this.Ruf.Rue.es(paramView.getTag());
    }
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$SnsMsgAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(98878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.b.2
 * JD-Core Version:    0.7.0.1
 */