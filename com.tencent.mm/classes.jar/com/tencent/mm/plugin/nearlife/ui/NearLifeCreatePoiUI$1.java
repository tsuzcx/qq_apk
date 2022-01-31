package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.modelgeo.Addr;

final class NearLifeCreatePoiUI$1
  implements View.OnClickListener
{
  NearLifeCreatePoiUI$1(NearLifeCreatePoiUI paramNearLifeCreatePoiUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22971);
    paramView = new Intent();
    paramView.putExtra("ui_title", 2131301855);
    if (NearLifeCreatePoiUI.a(this.pfL) != null)
    {
      paramView.putExtra("extra_province", NearLifeCreatePoiUI.a(this.pfL).fBr);
      paramView.putExtra("extra_city", NearLifeCreatePoiUI.a(this.pfL).fBs);
    }
    d.b(this.pfL.getContext(), "address", ".ui.WalletMultiRcptSelectUI", paramView, 1);
    AppMethodBeat.o(22971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.1
 * JD-Core Version:    0.7.0.1
 */