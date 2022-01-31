package com.tencent.mm.plugin.profile.ui;

import android.content.res.Resources;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class NormalUserFooterPreference$a$1$2
  implements n.c
{
  NormalUserFooterPreference$a$1$2(NormalUserFooterPreference.a.1 param1) {}
  
  public final void a(l paraml)
  {
    h.nFQ.f(16055, new Object[] { Integer.valueOf(7), Integer.valueOf(b.S(NormalUserFooterPreference.b(this.mYF.mYE.mYC).getIntent())) });
    if (ad.aaU(NormalUserFooterPreference.a(this.mYF.mYE.mYC).field_username))
    {
      paraml.ak(1, R.l.contact_set_des_only, R.k.bottomsheet_icon_remarks);
      if (!NormalUserFooterPreference.a(this.mYF.mYE.mYC).Bi()) {
        break label298;
      }
      str = NormalUserFooterPreference.b(this.mYF.mYE.mYC).getResources().getString(R.l.contact_info_unset_favour_start_biz);
      label122:
      paraml.a(2, str, R.k.bottomsheet_icon_star);
      if (!ad.aaU(NormalUserFooterPreference.a(this.mYF.mYE.mYC).field_username)) {
        paraml.ak(3, R.l.contact_info_op_sns_permission, R.k.bottomsheet_icon_moment);
      }
      paraml.ak(4, R.l.contact_info_send_card_normal, R.k.bottomsheet_icon_transmit);
      paraml.ak(9, R.l.biz_report_text, R.k.bottomsheet_icon_complain);
      if (!NormalUserFooterPreference.a(this.mYF.mYE.mYC).Bg()) {
        break label324;
      }
    }
    label298:
    label324:
    for (String str = NormalUserFooterPreference.b(this.mYF.mYE.mYC).getString(R.l.contact_info_moveout_blacklist);; str = NormalUserFooterPreference.b(this.mYF.mYE.mYC).getString(R.l.contact_info_movein_blacklist))
    {
      paraml.a(5, str, R.k.bottomsheet_icon_blacklist);
      if (!NormalUserFooterPreference.c(this.mYF.mYE.mYC)) {
        paraml.ak(6, R.l.bind_mcontact_del_btn_text, R.k.bottomsheet_icon_del);
      }
      paraml.ak(7, R.l.contact_info_add_shortcut, R.k.bottomsheet_icon_desktop);
      return;
      paraml.ak(1, R.l.contact_info_mod_remark_labelinfo, R.k.bottomsheet_icon_remarks);
      break;
      str = NormalUserFooterPreference.b(this.mYF.mYE.mYC).getResources().getString(R.l.contact_info_favour_start_biz);
      break label122;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.1.2
 * JD-Core Version:    0.7.0.1
 */