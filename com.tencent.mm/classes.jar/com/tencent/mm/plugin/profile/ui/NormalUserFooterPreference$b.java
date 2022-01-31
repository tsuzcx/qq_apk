package com.tencent.mm.plugin.profile.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.q;
import com.tencent.mm.n.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;

final class NormalUserFooterPreference$b
  extends NormalUserFooterPreference.c
{
  public NormalUserFooterPreference$b(NormalUserFooterPreference paramNormalUserFooterPreference)
  {
    super(paramNormalUserFooterPreference);
  }
  
  protected final void bsI()
  {
    NormalUserFooterPreference.r(this.mYC).setVisibility(8);
    if ((!a.gR(NormalUserFooterPreference.a(this.mYC).field_type)) || ((a.gR(NormalUserFooterPreference.a(this.mYC).field_type)) && (ad.hd(NormalUserFooterPreference.a(this.mYC).field_username))))
    {
      NormalUserFooterPreference.s(this.mYC).setVisibility(0);
      NormalUserFooterPreference.f(this.mYC).setVisibility(8);
      NormalUserFooterPreference.g(this.mYC).setVisibility(8);
      NormalUserFooterPreference.h(this.mYC).setVisibility(8);
    }
    for (;;)
    {
      NormalUserFooterPreference.t(this.mYC).setVisibility(8);
      NormalUserFooterPreference.k(this.mYC).setVisibility(8);
      NormalUserFooterPreference.q(this.mYC).setVisibility(8);
      if (NormalUserFooterPreference.B(this.mYC))
      {
        NormalUserFooterPreference.s(this.mYC).setVisibility(8);
        NormalUserFooterPreference.t(this.mYC).setVisibility(0);
        NormalUserFooterPreference.t(this.mYC).setOnClickListener(new NormalUserFooterPreference.b.1(this));
      }
      NormalUserFooterPreference.A(this.mYC).setOnClickListener(new NormalUserFooterPreference.b.2(this));
      return;
      NormalUserFooterPreference.s(this.mYC).setVisibility(8);
      NormalUserFooterPreference.f(this.mYC).setVisibility(0);
      if ((this.mYC.bsF()) || (NormalUserFooterPreference.a(this.mYC).field_username.equals(q.Gj()))) {
        break;
      }
      NormalUserFooterPreference.h(this.mYC).setVisibility(0);
    }
  }
  
  protected final void bsK()
  {
    if (NormalUserFooterPreference.a(this.mYC) == null)
    {
      y.e("MicroMsg.NormalUserFooterPreference", "contact is null in NearByFriendHandler");
      return;
    }
    if ((!a.gR(NormalUserFooterPreference.a(this.mYC).field_type)) || ((a.gR(NormalUserFooterPreference.a(this.mYC).field_type)) && (ad.hd(NormalUserFooterPreference.a(this.mYC).field_username))))
    {
      if (ad.hd(NormalUserFooterPreference.a(this.mYC).field_username))
      {
        B(true, true);
        return;
      }
      B(false, true);
      return;
    }
    bsJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.b
 * JD-Core Version:    0.7.0.1
 */