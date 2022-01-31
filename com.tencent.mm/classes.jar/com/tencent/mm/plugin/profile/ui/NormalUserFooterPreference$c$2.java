package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

final class NormalUserFooterPreference$c$2
  implements View.OnClickListener
{
  NormalUserFooterPreference$c$2(NormalUserFooterPreference.c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23700);
    if (NormalUserFooterPreference.b(this.pCn.pCe).getIntent() != null)
    {
      paramView = NormalUserFooterPreference.b(this.pCn.pCe).getIntent().getStringExtra("key_ww_add_session_id");
      if (!bo.isNullOrNil(paramView))
      {
        w localw = new w();
        localw.fr(paramView);
        localw.cTG = 0L;
        localw.cTI = 1L;
        localw.ake();
      }
    }
    this.pCn.ccC();
    if (NormalUserFooterPreference.E(this.pCn.pCe) != 0) {
      h.qsU.e(11263, new Object[] { Integer.valueOf(NormalUserFooterPreference.E(this.pCn.pCe)), NormalUserFooterPreference.a(this.pCn.pCe).field_username });
    }
    AppMethodBeat.o(23700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c.2
 * JD-Core Version:    0.7.0.1
 */