package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import junit.framework.Assert;

final class NormalUserFooterPreference$g
  extends NormalUserFooterPreference.a
{
  public NormalUserFooterPreference$g(NormalUserFooterPreference paramNormalUserFooterPreference)
  {
    super(paramNormalUserFooterPreference);
  }
  
  protected final void bsI()
  {
    boolean bool2 = true;
    if (!q.gS(NormalUserFooterPreference.a(this.mYC).field_username))
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      if (s.hU(NormalUserFooterPreference.a(this.mYC).field_username)) {
        break label136;
      }
    }
    label136:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      NormalUserFooterPreference.r(this.mYC).setVisibility(8);
      NormalUserFooterPreference.s(this.mYC).setVisibility(8);
      NormalUserFooterPreference.f(this.mYC).setText(R.l.contact_info_send_to_room);
      NormalUserFooterPreference.f(this.mYC).setVisibility(0);
      NormalUserFooterPreference.h(this.mYC).setVisibility(8);
      NormalUserFooterPreference.t(this.mYC).setVisibility(8);
      NormalUserFooterPreference.q(this.mYC).setVisibility(8);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void bsK() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.g
 * JD-Core Version:    0.7.0.1
 */