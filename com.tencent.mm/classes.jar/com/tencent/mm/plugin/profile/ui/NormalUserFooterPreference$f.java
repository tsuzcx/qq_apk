package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.n.a;

final class NormalUserFooterPreference$f
  extends NormalUserFooterPreference.a
{
  public NormalUserFooterPreference$f(NormalUserFooterPreference paramNormalUserFooterPreference)
  {
    super(paramNormalUserFooterPreference);
  }
  
  protected final void ccx()
  {
    AppMethodBeat.i(23713);
    NormalUserFooterPreference.r(this.pCe).setVisibility(8);
    NormalUserFooterPreference.s(this.pCe).setVisibility(0);
    NormalUserFooterPreference.t(this.pCe).setVisibility(8);
    NormalUserFooterPreference.f(this.pCe).setVisibility(8);
    NormalUserFooterPreference.g(this.pCe).setVisibility(8);
    NormalUserFooterPreference.h(this.pCe).setVisibility(8);
    NormalUserFooterPreference.k(this.pCe).setVisibility(8);
    NormalUserFooterPreference.q(this.pCe).setVisibility(8);
    NormalUserFooterPreference.A(this.pCe).setOnClickListener(new NormalUserFooterPreference.f.1(this));
    AppMethodBeat.o(23713);
  }
  
  protected final void ccz()
  {
    AppMethodBeat.i(23712);
    if ((NormalUserFooterPreference.a(this.pCe) != null) && (a.je(NormalUserFooterPreference.a(this.pCe).field_type)))
    {
      ccy();
      AppMethodBeat.o(23712);
      return;
    }
    F(false, true);
    AppMethodBeat.o(23712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.f
 * JD-Core Version:    0.7.0.1
 */