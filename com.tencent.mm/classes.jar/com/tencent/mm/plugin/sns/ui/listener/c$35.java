package com.tencent.mm.plugin.sns.ui.listener;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;

final class c$35
  implements View.OnClickListener
{
  c$35(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163134);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    this.RQM.hlM();
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof i)))
    {
      paramView = al.hgB().aZL(((i)paramView.getTag()).hES);
      if (paramView != null)
      {
        localObject = j.QFS;
        j.aZp(paramView.getUserName());
        paramView = new com.tencent.mm.plugin.sns.model.s(paramView.field_snsId, 9);
        h.baF();
        h.baD().mCm.a(paramView, 0);
      }
    }
    a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(163134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.listener.c.35
 * JD-Core Version:    0.7.0.1
 */