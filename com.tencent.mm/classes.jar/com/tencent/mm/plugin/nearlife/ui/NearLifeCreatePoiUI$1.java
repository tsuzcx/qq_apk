package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelgeo.Addr;

final class NearLifeCreatePoiUI$1
  implements View.OnClickListener
{
  NearLifeCreatePoiUI$1(NearLifeCreatePoiUI paramNearLifeCreatePoiUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(26597);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = new Intent();
    paramView.putExtra("ui_title", 2131761615);
    if (NearLifeCreatePoiUI.a(this.wrB) != null)
    {
      paramView.putExtra("extra_province", NearLifeCreatePoiUI.a(this.wrB).hWZ);
      paramView.putExtra("extra_city", NearLifeCreatePoiUI.a(this.wrB).hXa);
    }
    d.b(this.wrB.getContext(), "address", ".ui.WalletMultiRcptSelectUI", paramView, 1);
    a.a(this, "com/tencent/mm/plugin/nearlife/ui/NearLifeCreatePoiUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(26597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.1
 * JD-Core Version:    0.7.0.1
 */