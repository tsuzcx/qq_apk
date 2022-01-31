package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.R.l;
import com.tencent.mm.ai.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class c$19
  implements n.c
{
  c$19(c paramc) {}
  
  public final void a(l paraml)
  {
    if ((this.mWY.mVy != null) && (this.mWY.mVy.Ly()))
    {
      paraml.fq(1, R.l.contact_info_send_card_biz);
      paraml.fq(3, R.l.biz_report_text);
      paraml.fq(4, R.l.contact_info_biz_remove);
      paraml.fq(5, R.l.contact_info_add_shortcut);
      return;
    }
    if ((this.mWY.mVy != null) && (this.mWY.mVy.Lz()))
    {
      paraml.fq(5, R.l.contact_info_add_shortcut);
      return;
    }
    paraml.fq(1, R.l.contact_info_send_card_biz);
    paraml.fq(2, R.l.contact_info_biz_clear_msg);
    if (!s.ic(this.mWY.dnp.field_username))
    {
      paraml.fq(3, R.l.biz_report_text);
      paraml.fq(4, R.l.contact_info_biz_remove);
    }
    paraml.fq(5, R.l.contact_info_add_shortcut);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.19
 * JD-Core Version:    0.7.0.1
 */