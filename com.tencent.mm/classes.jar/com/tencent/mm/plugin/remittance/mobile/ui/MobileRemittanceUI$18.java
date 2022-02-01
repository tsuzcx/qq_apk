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
    AppMethodBeat.i(189974);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    localObject = this.ynh.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((View)((Iterator)localObject).next()).findViewById(2131302368).setVisibility(8);
    }
    paramView = (ImageView)paramView.getTag();
    this.yne.ymV = ((Integer)paramView.getTag()).intValue();
    paramView.setVisibility(0);
    a.a(this, "com/tencent/mm/plugin/remittance/mobile/ui/MobileRemittanceUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(189974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.mobile.ui.MobileRemittanceUI.18
 * JD-Core Version:    0.7.0.1
 */