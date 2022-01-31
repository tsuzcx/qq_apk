package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class e$18
  implements View.OnClickListener
{
  e$18(e parame) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
    if ((aq.isWifi(this.pYP.getActivity())) || ((q.bQY()) && (!aq.is2G(this.pYP.getActivity()))))
    {
      e.e(this.pYP);
      return;
    }
    h.a(this.pYP.getActivity(), a.e.voip_not_wifi_warnning_message, a.e.voip_not_wifi_warnning_title, new e.18.1(this), new e.18.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e.18
 * JD-Core Version:    0.7.0.1
 */