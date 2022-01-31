package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.n.a;

final class NormalUserFooterPreference$f
  extends NormalUserFooterPreference.a
{
  public NormalUserFooterPreference$f(NormalUserFooterPreference paramNormalUserFooterPreference)
  {
    super(paramNormalUserFooterPreference);
  }
  
  protected final void bsI()
  {
    NormalUserFooterPreference.r(this.mYC).setVisibility(8);
    NormalUserFooterPreference.s(this.mYC).setVisibility(0);
    NormalUserFooterPreference.t(this.mYC).setVisibility(8);
    NormalUserFooterPreference.f(this.mYC).setVisibility(8);
    NormalUserFooterPreference.g(this.mYC).setVisibility(8);
    NormalUserFooterPreference.h(this.mYC).setVisibility(8);
    NormalUserFooterPreference.k(this.mYC).setVisibility(8);
    NormalUserFooterPreference.q(this.mYC).setVisibility(8);
    NormalUserFooterPreference.A(this.mYC).setOnClickListener(new NormalUserFooterPreference.f.1(this));
  }
  
  protected final void bsK()
  {
    if ((NormalUserFooterPreference.a(this.mYC) != null) && (a.gR(NormalUserFooterPreference.a(this.mYC).field_type)))
    {
      bsJ();
      return;
    }
    B(false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.f
 * JD-Core Version:    0.7.0.1
 */