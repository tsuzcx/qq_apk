package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.network.ab;
import com.tencent.mm.pluginsdk.ui.j;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.List;

class NormalUserFooterPreference$i
  extends NormalUserFooterPreference.c
  implements f
{
  private ProgressDialog dnm;
  
  public NormalUserFooterPreference$i(NormalUserFooterPreference paramNormalUserFooterPreference)
  {
    super(paramNormalUserFooterPreference);
  }
  
  private void AH()
  {
    NormalUserFooterPreference localNormalUserFooterPreference = this.mYC;
    au.Hx();
    ad localad2 = c.Fw().abl(NormalUserFooterPreference.a(this.mYC).field_username);
    if (localad2 != null)
    {
      localad1 = localad2;
      if ((int)localad2.dBe != 0) {}
    }
    else
    {
      localad1 = NormalUserFooterPreference.a(this.mYC);
      au.Hx();
      if (c.Fw().U(localad1)) {
        break label119;
      }
      y.e("MicroMsg.NormalUserFooterPreference", "insert contact failed, username = " + localad1.field_username);
    }
    for (ad localad1 = null;; localad1 = c.Fw().abl(NormalUserFooterPreference.a(this.mYC).field_username))
    {
      NormalUserFooterPreference.a(localNormalUserFooterPreference, localad1);
      if (NormalUserFooterPreference.a(this.mYC) != null) {
        s.q(NormalUserFooterPreference.a(this.mYC));
      }
      return;
      label119:
      au.Hx();
    }
  }
  
  protected void bsI()
  {
    onDetach();
    onStop();
    au.Dk().a(30, this);
    au.Dk().a(667, this);
    au.Dk().a(853, this);
    super.bsI();
  }
  
  protected void bsO()
  {
    if (NormalUserFooterPreference.u(this.mYC) != null) {
      NormalUserFooterPreference.u(this.mYC).onDetach();
    }
    NormalUserFooterPreference.a(this.mYC, new NormalUserFooterPreference.c(this.mYC));
    NormalUserFooterPreference.u(this.mYC).Fj();
  }
  
  protected void onDetach()
  {
    if (this.dnm != null)
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if (NormalUserFooterPreference.r(this.mYC) != null) {
      NormalUserFooterPreference.r(this.mYC).setVisibility(8);
    }
    if (NormalUserFooterPreference.s(this.mYC) != null) {
      NormalUserFooterPreference.s(this.mYC).setVisibility(0);
    }
    if (NormalUserFooterPreference.f(this.mYC) != null) {
      NormalUserFooterPreference.f(this.mYC).setVisibility(8);
    }
    if (NormalUserFooterPreference.g(this.mYC) != null) {
      NormalUserFooterPreference.g(this.mYC).setVisibility(8);
    }
    if (NormalUserFooterPreference.h(this.mYC) != null) {
      NormalUserFooterPreference.h(this.mYC).setVisibility(8);
    }
    if (NormalUserFooterPreference.t(this.mYC) != null) {
      NormalUserFooterPreference.t(this.mYC).setVisibility(8);
    }
    if (NormalUserFooterPreference.q(this.mYC) != null) {
      NormalUserFooterPreference.q(this.mYC).setVisibility(8);
    }
    onStop();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    int j = 0;
    y.d("MicroMsg.NormalUserFooterPreference", "onSceneEnd, errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((paramm.getType() != 30) && (paramm.getType() != 667) && (paramm.getType() != 853)) {}
    do
    {
      do
      {
        do
        {
          return;
          onStop();
          if (this.dnm != null)
          {
            this.dnm.dismiss();
            this.dnm = null;
          }
        } while (!bk.bU(this.mYC.mContext));
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label322;
        }
        if (paramm.getType() != 30) {
          break;
        }
        paramInt1 = ((com.tencent.mm.pluginsdk.model.m)paramm).bNb;
        y.d("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, opCode = " + paramInt1);
      } while ((paramInt1 != 1) && (paramInt1 != 3));
      paramString = ((com.tencent.mm.pluginsdk.model.m)paramm).rTv;
    } while ((paramString == null) || (!paramString.contains(NormalUserFooterPreference.a(this.mYC).field_username)));
    NormalUserFooterPreference.v(this.mYC);
    AH();
    bsO();
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      b.bh((String)paramString.next(), NormalUserFooterPreference.l(this.mYC));
    }
    au.getNotification().wp();
    return;
    if ((paramm.getType() == 667) || (paramm.getType() == 853))
    {
      NormalUserFooterPreference.v(this.mYC);
      AH();
      bsO();
      b.bh(NormalUserFooterPreference.a(this.mYC).field_username, NormalUserFooterPreference.l(this.mYC));
      au.getNotification().wp();
      return;
    }
    label322:
    if ((paramInt1 == 4) && (paramInt2 == -302)) {
      if (paramm.getType() != 30) {
        break label829;
      }
    }
    label829:
    for (paramInt1 = ((com.tencent.mm.pluginsdk.model.m)paramm).bNb;; paramInt1 = 0)
    {
      y.w("MicroMsg.NormalUserFooterPreference", "VerifyBaseHandler onSceneEnd, verify relation out of date, opCode = %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 != 3) && (paramm.getType() != 853)) {
        break;
      }
      h.a(NormalUserFooterPreference.b(this.mYC), NormalUserFooterPreference.b(this.mYC).getString(R.l.contact_info_verify_outofdate_msg), NormalUserFooterPreference.b(this.mYC).getString(R.l.app_tip), NormalUserFooterPreference.b(this.mYC).getString(R.l.app_add), NormalUserFooterPreference.b(this.mYC).getString(R.l.app_cancel), new NormalUserFooterPreference.i.3(this), null);
      return;
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!bk.bl(paramString)))
      {
        Toast.makeText(NormalUserFooterPreference.b(this.mYC), paramString, 1).show();
        return;
      }
      int i = j;
      switch (paramInt1)
      {
      default: 
        i = j;
      }
      while (i != 0)
      {
        return;
        if (au.Dk().KH())
        {
          au.Dk().getNetworkServerIp();
          new StringBuilder().append(paramInt2);
          i = 1;
        }
        else
        {
          i = j;
          if (ab.bG(this.mYC.mContext))
          {
            j.eY(this.mYC.mContext);
            i = 1;
            continue;
            Toast.makeText(this.mYC.mContext, this.mYC.mContext.getString(R.l.fmt_iap_err, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
            i = 1;
            continue;
            if (paramInt2 != -100) {
              break label718;
            }
            h.a(this.mYC.mContext, au.CM(), com.tencent.mm.cb.a.ac(this.mYC.mContext, R.l.app_tip), new NormalUserFooterPreference.i.1(this), new NormalUserFooterPreference.i.2(this));
            i = 1;
          }
        }
      }
      label718:
      if ((paramInt1 == 4) && (paramInt2 == -34)) {
        paramm = NormalUserFooterPreference.b(this.mYC).getString(R.l.fmessage_request_too_offen);
      }
      for (;;)
      {
        Toast.makeText(NormalUserFooterPreference.b(this.mYC), paramm, 1).show();
        i = j;
        break;
        if ((paramInt1 == 4) && (paramInt2 == -94))
        {
          paramm = NormalUserFooterPreference.b(this.mYC).getString(R.l.fmessage_user_not_support);
        }
        else if (paramInt1 == 4)
        {
          paramm = paramString;
          if (!bk.bl(paramString)) {}
        }
        else
        {
          paramm = NormalUserFooterPreference.b(this.mYC).getString(R.l.sendrequest_send_fail);
        }
      }
    }
  }
  
  final void onStop()
  {
    au.Dk().b(30, this);
    au.Dk().b(667, this);
    au.Dk().b(853, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.i
 * JD-Core Version:    0.7.0.1
 */