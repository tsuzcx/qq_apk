package com.tencent.mm.plugin.remittance.mobile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.Iterator;
import java.util.List;

final class MobileRemittanceUI$18
  implements View.OnClickListener
{
  MobileRemittanceUI$18(MobileRemittanceUI paramMobileRemittanceUI, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(213718);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = this.CnX.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((View)((Iterator)localObject).next()).findViewById(2131304765).setVisibility(8);
    }
    paramView = (ImageView)paramView.getTag();
    this.CnV.CnN = ((Integer)paramView.getTag()).intValue();
    paramView.setVisibility(0);
    a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(213718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.18
 * JD-Core Version:    0.7.0.1
 */