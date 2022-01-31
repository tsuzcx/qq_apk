package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.mm.R.l;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.n.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class b$2$1
  implements n.c
{
  b$2$1(b.2 param2) {}
  
  public final void a(l paraml)
  {
    if (a.gR(this.mZB.mZA.dnp.field_type))
    {
      if (!this.mZB.mZA.dnp.Bl()) {
        break label128;
      }
      if ((!s.ctL()) || (!f.kZ(this.mZB.mZA.dnp.field_username))) {
        break label116;
      }
      paraml.fq(5, R.l.contact_info_biz_new_remove_star);
    }
    for (;;)
    {
      paraml.fq(1, R.l.contact_info_biz_more);
      if (a.gR(this.mZB.mZA.dnp.field_type))
      {
        paraml.fq(2, R.l.contact_info_send_card_biz);
        paraml.fq(3, R.l.contact_info_biz_setting);
      }
      return;
      label116:
      paraml.fq(5, R.l.main_conversation_longclick_unplacedtop);
      continue;
      label128:
      if ((s.ctL()) && (f.kZ(this.mZB.mZA.dnp.field_username))) {
        paraml.fq(4, R.l.contact_info_biz_new_add_star);
      } else {
        paraml.fq(4, R.l.contact_info_stick_biz);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.2.1
 * JD-Core Version:    0.7.0.1
 */