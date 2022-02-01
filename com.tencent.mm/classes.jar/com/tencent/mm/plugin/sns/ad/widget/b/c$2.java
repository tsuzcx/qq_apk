package com.tencent.mm.plugin.sns.ad.widget.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public final class c$2
  implements View.OnClickListener
{
  public c$2(c paramc, a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(265268);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ad/widget/semidialog/SemiDialogManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    try
    {
      if (this.JNt != null) {
        this.JNt.a(this.JNs, paramView, this.JNs.Jws);
      }
      label63:
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ad/widget/semidialog/SemiDialogManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265268);
      return;
    }
    catch (Throwable paramView)
    {
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.b.c.2
 * JD-Core Version:    0.7.0.1
 */