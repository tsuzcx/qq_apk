package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.j.e;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.p;

final class c$37
  implements View.OnClickListener
{
  c$37(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163134);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    this.AQE.edk();
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof f)))
    {
      paramView = ah.dXE().aBr(((f)paramView.getTag()).dqc);
      if (paramView != null)
      {
        localObject = e.zKO;
        e.aAW(paramView.field_userName);
        paramView = new r(paramView.field_snsId, 9);
        g.ajS();
        g.ajQ().gDv.a(paramView, 0);
      }
    }
    a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(163134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c.37
 * JD-Core Version:    0.7.0.1
 */