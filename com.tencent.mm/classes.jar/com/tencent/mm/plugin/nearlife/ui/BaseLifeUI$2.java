package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.sdk.platformtools.ab;

final class BaseLifeUI$2
  implements View.OnClickListener
{
  BaseLifeUI$2(BaseLifeUI paramBaseLifeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22937);
    if (this.pfa.peJ == null)
    {
      ab.e("MicroMsg.BaseLifeUI", "Location is null");
      AppMethodBeat.o(22937);
      return;
    }
    h.qsU.e(11138, new Object[] { "1", Integer.valueOf(BaseLifeUI.b(this.pfa).getCount() + 1), this.pfa.hng });
    paramView = new Intent();
    paramView.setClass(this.pfa, NearLifeCreatePoiUI.class);
    paramView.putExtra("get_lat", this.pfa.peJ.wDi);
    paramView.putExtra("get_lng", this.pfa.peJ.wDh);
    paramView.putExtra("get_preci", this.pfa.peJ.wSk);
    paramView.putExtra("get_poi_name", BaseLifeUI.b(this.pfa).bWJ());
    paramView.putExtra("get_cur_lat", this.pfa.peK);
    paramView.putExtra("get_cur_lng", this.pfa.peL);
    paramView.putExtra("get_accuracy", this.pfa.peN);
    paramView.putExtra("get_loctype", this.pfa.peM);
    paramView.putExtra("search_id", this.pfa.hng);
    paramView.putExtra("get_is_mars", this.pfa.fBM);
    this.pfa.startActivityForResult(paramView, 1);
    AppMethodBeat.o(22937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.2
 * JD-Core Version:    0.7.0.1
 */