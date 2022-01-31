package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.t;
import junit.framework.Assert;

final class NormalUserFooterPreference$d
  extends NormalUserFooterPreference.a
{
  public NormalUserFooterPreference$d(NormalUserFooterPreference paramNormalUserFooterPreference)
  {
    super(paramNormalUserFooterPreference);
  }
  
  protected final void ccx()
  {
    AppMethodBeat.i(23710);
    Assert.assertTrue(t.og(NormalUserFooterPreference.a(this.pCe).field_username));
    NormalUserFooterPreference.r(this.pCe).setVisibility(8);
    NormalUserFooterPreference.s(this.pCe).setVisibility(8);
    NormalUserFooterPreference.t(this.pCe).setVisibility(8);
    NormalUserFooterPreference.f(this.pCe).setVisibility(0);
    NormalUserFooterPreference.g(this.pCe).setVisibility(8);
    NormalUserFooterPreference.h(this.pCe).setVisibility(8);
    NormalUserFooterPreference.k(this.pCe).setVisibility(8);
    NormalUserFooterPreference.q(this.pCe).setVisibility(8);
    AppMethodBeat.o(23710);
  }
  
  protected final void ccz() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.d
 * JD-Core Version:    0.7.0.1
 */