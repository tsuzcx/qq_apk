package com.tencent.mm.plugin.profile.ui;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.profile.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class NormalUserFooterPreference$a$1$2
  implements n.c
{
  NormalUserFooterPreference$a$1$2(NormalUserFooterPreference.a.1 param1) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(23675);
    h.qsU.e(16055, new Object[] { Integer.valueOf(c.al(NormalUserFooterPreference.b(this.pCg.pCf.pCe).getIntent())), Integer.valueOf(7), Integer.valueOf(1), NormalUserFooterPreference.a(this.pCg.pCf.pCe).field_username });
    if (ad.arf(NormalUserFooterPreference.a(this.pCg.pCf.pCe).field_username))
    {
      paraml.aw(1, 2131298849, 2131231033);
      if (!NormalUserFooterPreference.a(this.pCg.pCf.pCe).NY()) {
        break label318;
      }
      str = NormalUserFooterPreference.b(this.pCg.pCf.pCe).getResources().getString(2131298822);
      label151:
      paraml.a(2, str, 2131231036);
      if (!ad.arf(NormalUserFooterPreference.a(this.pCg.pCf.pCe).field_username)) {
        paraml.aw(3, 2131298685, 2131231024);
      }
      paraml.aw(4, 2131298745, 2131231038);
      paraml.aw(9, 2131297684, 2131231006);
      if (!NormalUserFooterPreference.a(this.pCg.pCf.pCe).NW()) {
        break label343;
      }
    }
    label318:
    label343:
    for (String str = NormalUserFooterPreference.b(this.pCg.pCf.pCe).getString(2131298680);; str = NormalUserFooterPreference.b(this.pCg.pCf.pCe).getString(2131298675))
    {
      paraml.a(5, str, 2131231002);
      if (!NormalUserFooterPreference.c(this.pCg.pCf.pCe)) {
        paraml.aw(6, 2131297565, 2131231009);
      }
      paraml.aw(7, 2131298519, 2131231010);
      AppMethodBeat.o(23675);
      return;
      paraml.aw(1, 2131298670, 2131231033);
      break;
      str = NormalUserFooterPreference.b(this.pCg.pCf.pCe).getResources().getString(2131298604);
      break label151;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.1.2
 * JD-Core Version:    0.7.0.1
 */