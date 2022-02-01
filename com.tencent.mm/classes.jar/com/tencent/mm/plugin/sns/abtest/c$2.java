package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Util;

final class c$2
  implements View.OnClickListener
{
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(94955);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/sns/abtest/SellerABTestManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    if ((paramView.getTag() instanceof SnsInfo))
    {
      localObject = (SnsInfo)paramView.getTag();
      if ((localObject != null) && (!Util.isNullOrNil(((SnsInfo)localObject).getSnsId()))) {
        c.Z(paramView.getContext(), ((SnsInfo)localObject).getSnsId());
      }
    }
    a.a(this, "com/tencent/mm/plugin/sns/abtest/SellerABTestManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(94955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.c.2
 * JD-Core Version:    0.7.0.1
 */