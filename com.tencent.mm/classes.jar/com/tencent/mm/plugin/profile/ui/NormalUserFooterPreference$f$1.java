package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e.b;

final class NormalUserFooterPreference$f$1
  implements View.OnClickListener
{
  NormalUserFooterPreference$f$1(NormalUserFooterPreference.f paramf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(23711);
    com.tencent.mm.plugin.normsg.a.b.pgQ.ad(1, 1, 5);
    paramView = new Intent();
    paramView.putExtra("Contact_User", NormalUserFooterPreference.a(this.pCo.pCe).field_username);
    paramView.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.pCo.pCe));
    paramView.putExtra(e.b.yUZ, NormalUserFooterPreference.a(this.pCo.pCe).dra);
    com.tencent.mm.plugin.profile.b.gmO.a(paramView, this.pCo.pCe.mContext);
    AppMethodBeat.o(23711);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.f.1
 * JD-Core Version:    0.7.0.1
 */