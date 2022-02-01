package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsOnlineVideoActivity$1
  implements View.OnClickListener
{
  SnsOnlineVideoActivity$1(SnsOnlineVideoActivity paramSnsOnlineVideoActivity) {}
  
  public final void onClick(View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(98938);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = this.Rvr;
    if (SnsOnlineVideoActivity.a(this.Rvr)) {}
    for (int i = 8;; i = 0)
    {
      paramView.setTitleVisibility(i);
      paramView = this.Rvr;
      if (!SnsOnlineVideoActivity.a(this.Rvr)) {
        bool = true;
      }
      SnsOnlineVideoActivity.a(paramView, bool);
      a.a(this, "com/tencent/mm/plugin/sns/ui/SnsOnlineVideoActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98938);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity.1
 * JD-Core Version:    0.7.0.1
 */