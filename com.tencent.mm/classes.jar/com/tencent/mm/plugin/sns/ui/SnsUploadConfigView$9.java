package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsUploadConfigView$9
  implements View.OnClickListener
{
  SnsUploadConfigView$9(SnsUploadConfigView paramSnsUploadConfigView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99526);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = this.RDA;
    if (SnsUploadConfigView.f(this.RDA)) {}
    for (boolean bool = false;; bool = true)
    {
      SnsUploadConfigView.c(paramView, bool);
      if (SnsUploadConfigView.f(this.RDA)) {
        SnsUploadConfigView.g(this.RDA);
      }
      SnsUploadConfigView.h(this.RDA);
      a.a(this, "com/tencent/mm/plugin/sns/ui/SnsUploadConfigView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(99526);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadConfigView.9
 * JD-Core Version:    0.7.0.1
 */