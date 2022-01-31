package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

final class SwitchPhoneItemGroupView$1
  implements View.OnClickListener
{
  SwitchPhoneItemGroupView$1(SwitchPhoneItemGroupView paramSwitchPhoneItemGroupView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47880);
    Iterator localIterator = this.uwB.uwy.iterator();
    while (localIterator.hasNext()) {
      ((SwitchPhoneItemView)localIterator.next()).uwE.setImageResource(2131231905);
    }
    ((SwitchPhoneItemView)paramView).uwE.setImageResource(2131231906);
    if (SwitchPhoneItemGroupView.a(this.uwB) != null) {
      SwitchPhoneItemGroupView.a(this.uwB).eu(paramView);
    }
    AppMethodBeat.o(47880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView.1
 * JD-Core Version:    0.7.0.1
 */