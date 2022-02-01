package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.p;

final class a$3
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(94920);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    if ((paramView.getTag() instanceof p))
    {
      localObject = (p)paramView.getTag();
      a.a(paramView, paramView.getContext(), (p)localObject);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(94920);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.a.3
 * JD-Core Version:    0.7.0.1
 */