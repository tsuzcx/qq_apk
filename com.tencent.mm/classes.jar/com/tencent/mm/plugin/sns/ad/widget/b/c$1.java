package com.tencent.mm.plugin.sns.ad.widget.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class c$1
  implements View.OnClickListener
{
  public c$1(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(265579);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/sns/ad/widget/semidialog/SemiDialogManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.JNs.dismiss();
    a.a(this, "com/tencent/mm/plugin/sns/ad/widget/semidialog/SemiDialogManager$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(265579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.b.c.1
 * JD-Core Version:    0.7.0.1
 */