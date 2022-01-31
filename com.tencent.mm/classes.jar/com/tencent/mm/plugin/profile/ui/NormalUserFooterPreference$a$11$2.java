package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class NormalUserFooterPreference$a$11$2
  implements n.c
{
  NormalUserFooterPreference$a$11$2(NormalUserFooterPreference.a.11 param11) {}
  
  public final void a(l paraml)
  {
    if (!this.mYL.mYJ)
    {
      if (ad.aaU(NormalUserFooterPreference.a(this.mYL.mYE.mYC).field_username)) {
        paraml.ak(1, R.l.contact_set_des_only, R.k.bottomsheet_icon_remarks);
      }
    }
    else if (!this.mYL.mYK)
    {
      if (!NormalUserFooterPreference.a(this.mYL.mYE.mYC).Bg()) {
        break label102;
      }
      paraml.ak(8, R.l.contact_info_moveout_blacklist, R.k.bottomsheet_icon_blacklist);
    }
    label102:
    while (s.hj(NormalUserFooterPreference.a(this.mYL.mYE.mYC).field_username))
    {
      return;
      paraml.ak(1, R.l.contact_info_mod_remark_labelinfo, R.k.bottomsheet_icon_remarks);
      break;
    }
    paraml.ak(5, R.l.contact_info_movein_blacklist, R.k.bottomsheet_icon_blacklist);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.11.2
 * JD-Core Version:    0.7.0.1
 */