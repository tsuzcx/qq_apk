package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.platformtools.Log;

final class SnsMsgUI$1
  implements View.OnClickListener
{
  SnsMsgUI$1(SnsMsgUI paramSnsMsgUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98853);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/SnsMsgUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((paramView.getTag() instanceof bf)) {
      SnsMsgUI.a(this.RtY).C(paramView, -1, 1);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98853);
      return;
      if ((paramView.getTag() instanceof o)) {
        SnsMsgUI.a(this.RtY, (o)paramView.getTag());
      } else {
        Log.w("MicroMsg.SnsMsgUI", "v.getTag():" + paramView.getTag());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.1
 * JD-Core Version:    0.7.0.1
 */