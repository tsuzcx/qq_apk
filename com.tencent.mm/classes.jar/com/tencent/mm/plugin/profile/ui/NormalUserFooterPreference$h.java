package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;

final class NormalUserFooterPreference$h
  extends NormalUserFooterPreference.a
{
  public NormalUserFooterPreference$h(NormalUserFooterPreference paramNormalUserFooterPreference)
  {
    super(paramNormalUserFooterPreference);
  }
  
  protected final void bsI()
  {
    NormalUserFooterPreference.r(this.mYC).setVisibility(8);
    NormalUserFooterPreference.f(this.mYC).setVisibility(0);
    if ((!this.mYC.bsF()) && (!NormalUserFooterPreference.a(this.mYC).field_username.equals(q.Gj())) && (!s.hU(NormalUserFooterPreference.a(this.mYC).field_username)) && (!s.hN(NormalUserFooterPreference.a(this.mYC).field_username))) {
      NormalUserFooterPreference.h(this.mYC).setVisibility(0);
    }
    for (;;)
    {
      NormalUserFooterPreference.f(this.mYC).setText(R.l.contact_info_send_privatemsg);
      NormalUserFooterPreference.t(this.mYC).setVisibility(8);
      NormalUserFooterPreference.s(this.mYC).setVisibility(8);
      NormalUserFooterPreference.q(this.mYC).setVisibility(8);
      return;
      NormalUserFooterPreference.h(this.mYC).setVisibility(8);
    }
  }
  
  protected final void bsK() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.h
 * JD-Core Version:    0.7.0.1
 */