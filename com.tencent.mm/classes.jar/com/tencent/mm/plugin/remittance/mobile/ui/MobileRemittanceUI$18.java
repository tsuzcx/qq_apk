package com.tencent.mm.plugin.remittance.mobile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wxpay.a.f;
import java.util.Iterator;
import java.util.List;

final class MobileRemittanceUI$18
  implements View.OnClickListener
{
  MobileRemittanceUI$18(MobileRemittanceUI paramMobileRemittanceUI, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(273015);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    localObject = this.IkQ.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((View)((Iterator)localObject).next()).findViewById(a.f.mobile_remit_delay_option_choosw).setVisibility(8);
    }
    paramView = (ImageView)paramView.getTag();
    this.IkO.IkG = ((Integer)paramView.getTag()).intValue();
    paramView.setVisibility(0);
    a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(273015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.18
 * JD-Core Version:    0.7.0.1
 */