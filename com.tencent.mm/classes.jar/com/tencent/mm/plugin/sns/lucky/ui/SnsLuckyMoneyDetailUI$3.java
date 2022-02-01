package com.tencent.mm.plugin.sns.lucky.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SnsLuckyMoneyDetailUI$3
  implements AdapterView.OnItemClickListener
{
  SnsLuckyMoneyDetailUI$3(SnsLuckyMoneyDetailUI paramSnsLuckyMoneyDetailUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(213844);
    b localb = new b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    a.b("com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyMoneyDetailUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    a.a(this, "com/tencent/mm/plugin/sns/lucky/ui/SnsLuckyMoneyDetailUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(213844);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI.3
 * JD-Core Version:    0.7.0.1
 */