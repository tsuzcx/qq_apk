package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;

final class c$37
  implements View.OnClickListener
{
  c$37(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163134);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    this.Fbj.ffz();
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.g)))
    {
      paramView = aj.faO().aQm(((com.tencent.mm.plugin.sns.data.g)paramView.getTag()).dHp);
      if (paramView != null)
      {
        localObject = e.DUQ;
        e.aPQ(paramView.getUserName());
        paramView = new s(paramView.field_snsId, 9);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(paramView, 0);
      }
    }
    a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(163134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c.37
 * JD-Core Version:    0.7.0.1
 */