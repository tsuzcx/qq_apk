package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bio;

final class RadarMemberView$e
  implements View.OnClickListener
{
  RadarMemberView$e(RadarMemberView paramRadarMemberView, bio parambio) {}
  
  public final void onClick(View paramView)
  {
    if ((this.nmh.getState() == null) || (RadarMemberView.a(this.nmh) == null)) {
      return;
    }
    paramView = RadarMemberView.a(this.nmh);
    if (paramView != null) {
      paramView.a(this.nmi, this.nmh.getState());
    }
    this.nmh.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.e
 * JD-Core Version:    0.7.0.1
 */