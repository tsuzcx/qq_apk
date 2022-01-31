package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class SnsAdNativeLandingPagesUI$17$1
  implements n.c
{
  SnsAdNativeLandingPagesUI$17$1(SnsAdNativeLandingPagesUI.17 param17) {}
  
  public final void a(l paraml)
  {
    if ((SnsAdNativeLandingPagesUI.t(this.oVc.oUU) == 0) || ((SnsAdNativeLandingPagesUI.t(this.oVc.oUU) & 0x2) == 0)) {
      paraml.a(1, this.oVc.oUU.getString(i.j.retransmits), i.i.bottomsheet_icon_transmit);
    }
    if ((SnsAdNativeLandingPagesUI.t(this.oVc.oUU) == 0) || ((SnsAdNativeLandingPagesUI.t(this.oVc.oUU) & 0x1) == 0)) {
      paraml.a(2, this.oVc.oUU.getString(i.j.sns_ad_video_right_menu_share_sns), i.i.bottomsheet_icon_moment);
    }
    if (((SnsAdNativeLandingPagesUI.t(this.oVc.oUU) == 0) || ((SnsAdNativeLandingPagesUI.t(this.oVc.oUU) & 0x4) == 0)) && (SnsAdNativeLandingPagesUI.u(this.oVc.oUU) != 7)) {
      paraml.a(3, this.oVc.oUU.getString(i.j.chatting_fav), i.i.bottomsheet_icon_fav);
    }
    if (((SnsAdNativeLandingPagesUI.t(this.oVc.oUU) == 0) || (SnsAdNativeLandingPagesUI.v(this.oVc.oUU))) && (SnsAdNativeLandingPagesUI.w(this.oVc.oUU) == 2) && (SnsAdNativeLandingPagesUI.x(this.oVc.oUU))) {
      if (SnsAdNativeLandingPagesUI.y(this.oVc.oUU) == null) {
        break label251;
      }
    }
    label251:
    for (String str = SnsAdNativeLandingPagesUI.y(this.oVc.oUU);; str = "")
    {
      paraml.a(4, str, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.17.1
 * JD-Core Version:    0.7.0.1
 */