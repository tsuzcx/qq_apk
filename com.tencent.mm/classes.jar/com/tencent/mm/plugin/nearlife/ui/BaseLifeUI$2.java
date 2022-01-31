package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.sdk.platformtools.y;

final class BaseLifeUI$2
  implements View.OnClickListener
{
  BaseLifeUI$2(BaseLifeUI paramBaseLifeUI) {}
  
  public final void onClick(View paramView)
  {
    if (this.mEV.mEG == null)
    {
      y.e("MicroMsg.BaseLifeUI", "Location is null");
      return;
    }
    h.nFQ.f(11138, new Object[] { "1", Integer.valueOf(BaseLifeUI.b(this.mEV).getCount() + 1), this.mEV.fTF });
    paramView = new Intent();
    paramView.setClass(this.mEV, NearLifeCreatePoiUI.class);
    paramView.putExtra("get_lat", this.mEV.mEG.sGK);
    paramView.putExtra("get_lng", this.mEV.mEG.sGJ);
    paramView.putExtra("get_preci", this.mEV.mEG.sUn);
    paramView.putExtra("get_poi_name", BaseLifeUI.b(this.mEV).bok());
    paramView.putExtra("get_cur_lat", this.mEV.mEH);
    paramView.putExtra("get_cur_lng", this.mEV.mEI);
    paramView.putExtra("get_accuracy", this.mEV.mEK);
    paramView.putExtra("get_loctype", this.mEV.mEJ);
    paramView.putExtra("search_id", this.mEV.fTF);
    paramView.putExtra("get_is_mars", this.mEV.elu);
    this.mEV.startActivityForResult(paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.BaseLifeUI.2
 * JD-Core Version:    0.7.0.1
 */