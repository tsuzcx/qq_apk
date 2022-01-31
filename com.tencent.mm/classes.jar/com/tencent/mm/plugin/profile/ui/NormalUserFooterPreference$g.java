package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import junit.framework.Assert;

final class NormalUserFooterPreference$g
  extends NormalUserFooterPreference.a
{
  public NormalUserFooterPreference$g(NormalUserFooterPreference paramNormalUserFooterPreference)
  {
    super(paramNormalUserFooterPreference);
  }
  
  protected final void ccx()
  {
    boolean bool2 = true;
    AppMethodBeat.i(23714);
    if (!r.nB(NormalUserFooterPreference.a(this.pCe).field_username))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (t.oD(NormalUserFooterPreference.a(this.pCe).field_username)) {
        break label147;
      }
    }
    label147:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      NormalUserFooterPreference.r(this.pCe).setVisibility(8);
      NormalUserFooterPreference.s(this.pCe).setVisibility(8);
      NormalUserFooterPreference.f(this.pCe).setText(2131298750);
      NormalUserFooterPreference.f(this.pCe).setVisibility(0);
      NormalUserFooterPreference.h(this.pCe).setVisibility(8);
      NormalUserFooterPreference.t(this.pCe).setVisibility(8);
      NormalUserFooterPreference.q(this.pCe).setVisibility(8);
      AppMethodBeat.o(23714);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void ccz() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.g
 * JD-Core Version:    0.7.0.1
 */