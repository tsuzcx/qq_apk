package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.r;
import com.tencent.mm.n.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;

final class NormalUserFooterPreference$b
  extends NormalUserFooterPreference.c
{
  public NormalUserFooterPreference$b(NormalUserFooterPreference paramNormalUserFooterPreference)
  {
    super(paramNormalUserFooterPreference);
  }
  
  protected final void ccx()
  {
    AppMethodBeat.i(23698);
    NormalUserFooterPreference.r(this.pCe).setVisibility(8);
    if ((!a.je(NormalUserFooterPreference.a(this.pCe).field_type)) || ((a.je(NormalUserFooterPreference.a(this.pCe).field_type)) && (ad.nM(NormalUserFooterPreference.a(this.pCe).field_username))))
    {
      NormalUserFooterPreference.s(this.pCe).setVisibility(0);
      NormalUserFooterPreference.f(this.pCe).setVisibility(8);
      NormalUserFooterPreference.g(this.pCe).setVisibility(8);
      NormalUserFooterPreference.h(this.pCe).setVisibility(8);
    }
    for (;;)
    {
      NormalUserFooterPreference.t(this.pCe).setVisibility(8);
      NormalUserFooterPreference.k(this.pCe).setVisibility(8);
      NormalUserFooterPreference.q(this.pCe).setVisibility(8);
      if (NormalUserFooterPreference.B(this.pCe))
      {
        NormalUserFooterPreference.s(this.pCe).setVisibility(8);
        NormalUserFooterPreference.t(this.pCe).setVisibility(0);
        NormalUserFooterPreference.t(this.pCe).setOnClickListener(new NormalUserFooterPreference.b.1(this));
      }
      NormalUserFooterPreference.A(this.pCe).setOnClickListener(new NormalUserFooterPreference.b.2(this));
      AppMethodBeat.o(23698);
      return;
      NormalUserFooterPreference.s(this.pCe).setVisibility(8);
      NormalUserFooterPreference.f(this.pCe).setVisibility(0);
      if ((this.pCe.ccu()) || (NormalUserFooterPreference.a(this.pCe).field_username.equals(r.Zn()))) {
        break;
      }
      NormalUserFooterPreference.h(this.pCe).setVisibility(0);
    }
  }
  
  protected final void ccz()
  {
    AppMethodBeat.i(23697);
    if (NormalUserFooterPreference.a(this.pCe) == null)
    {
      ab.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
      AppMethodBeat.o(23697);
      return;
    }
    if ((!a.je(NormalUserFooterPreference.a(this.pCe).field_type)) || ((a.je(NormalUserFooterPreference.a(this.pCe).field_type)) && (ad.nM(NormalUserFooterPreference.a(this.pCe).field_username))))
    {
      if (ad.nM(NormalUserFooterPreference.a(this.pCe).field_username))
      {
        F(true, true);
        AppMethodBeat.o(23697);
        return;
      }
      F(false, true);
      AppMethodBeat.o(23697);
      return;
    }
    ccy();
    AppMethodBeat.o(23697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.b
 * JD-Core Version:    0.7.0.1
 */