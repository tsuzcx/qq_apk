package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.h;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.e.e;

final class SettingsPrivacyUI$2
  implements View.OnClickListener
{
  SettingsPrivacyUI$2(SettingsPrivacyUI paramSettingsPrivacyUI, LinearLayout paramLinearLayout) {}
  
  public final void onClick(View paramView)
  {
    int i = 0;
    while (i < this.nTq.getChildCount())
    {
      localObject = (TextView)this.nTq.getChildAt(i);
      if (a.f.tips_tv != ((TextView)localObject).getId()) {
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(a.h.radio_off, 0, 0, 0);
      }
      i += 1;
    }
    ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(a.h.radio_on, 0, 0, 0);
    Object localObject = new but();
    if (n.omD != null) {
      localObject = n.omD.MN(SettingsPrivacyUI.b(this.nVz));
    }
    if (localObject == null)
    {
      y.e("MicroMsg.SettingPrivacy", "userinfo is null");
      return;
    }
    i = ((Integer)paramView.getTag()).intValue();
    y.d("MicroMsg.SettingPrivacy", "settings_silence_update_mode choice: %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      if (SettingsPrivacyUI.c(this.nVz) == e.e.uHS) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(14090, new Object[] { Integer.valueOf(4) });
      }
      SettingsPrivacyUI.a(this.nVz, false);
      SettingsPrivacyUI.b(this.nVz, true);
      SettingsPrivacyUI.d(this.nVz);
      if (n.omD != null) {
        n.omD.a(SettingsPrivacyUI.b(this.nVz), SettingsPrivacyUI.e(this.nVz), SettingsPrivacyUI.f(this.nVz), SettingsPrivacyUI.g(this.nVz));
      }
      if (n.omD != null)
      {
        localObject = n.omD.b(SettingsPrivacyUI.b(this.nVz), SettingsPrivacyUI.e(this.nVz), SettingsPrivacyUI.f(this.nVz), SettingsPrivacyUI.g(this.nVz));
        n.omD.a(SettingsPrivacyUI.b(this.nVz), (but)localObject);
        if (localObject == null)
        {
          y.e("MicroMsg.SettingPrivacy", "userinfo in null !");
          return;
        }
        y.d("MicroMsg.SettingPrivacy", "dancy userinfo " + localObject.toString());
        ((j)g.r(j.class)).Fv().b(new i.a(51, (a)localObject));
      }
    }
    for (;;)
    {
      paramView.post(new SettingsPrivacyUI.2.1(this));
      return;
      if (i == 1)
      {
        if (SettingsPrivacyUI.c(this.nVz) == e.e.uHS) {
          com.tencent.mm.plugin.report.service.h.nFQ.f(14090, new Object[] { Integer.valueOf(5) });
        }
        SettingsPrivacyUI.a(this.nVz, true);
        SettingsPrivacyUI.b(this.nVz, false);
        SettingsPrivacyUI.d(this.nVz);
        if (n.omD != null) {
          n.omD.a(SettingsPrivacyUI.b(this.nVz), SettingsPrivacyUI.e(this.nVz), SettingsPrivacyUI.f(this.nVz), SettingsPrivacyUI.g(this.nVz));
        }
        if (n.omD != null)
        {
          localObject = n.omD.b(SettingsPrivacyUI.b(this.nVz), SettingsPrivacyUI.e(this.nVz), SettingsPrivacyUI.f(this.nVz), SettingsPrivacyUI.g(this.nVz));
          n.omD.a(SettingsPrivacyUI.b(this.nVz), (but)localObject);
          if (localObject == null)
          {
            y.e("MicroMsg.SettingPrivacy", "userinfo in null !");
            return;
          }
          y.d("MicroMsg.SettingPrivacy", "dancy userinfo " + localObject.toString());
          ((j)g.r(j.class)).Fv().b(new i.a(51, (a)localObject));
        }
      }
      else
      {
        if (SettingsPrivacyUI.c(this.nVz) == e.e.uHS) {
          com.tencent.mm.plugin.report.service.h.nFQ.f(14090, new Object[] { Integer.valueOf(6) });
        }
        SettingsPrivacyUI.a(this.nVz, false);
        SettingsPrivacyUI.b(this.nVz, false);
        SettingsPrivacyUI.d(this.nVz);
        if (n.omD != null) {
          n.omD.a(SettingsPrivacyUI.b(this.nVz), SettingsPrivacyUI.e(this.nVz), SettingsPrivacyUI.f(this.nVz), SettingsPrivacyUI.g(this.nVz));
        }
        if (n.omD != null)
        {
          localObject = n.omD.b(SettingsPrivacyUI.b(this.nVz), SettingsPrivacyUI.e(this.nVz), SettingsPrivacyUI.f(this.nVz), SettingsPrivacyUI.g(this.nVz));
          n.omD.a(SettingsPrivacyUI.b(this.nVz), (but)localObject);
          if (localObject == null)
          {
            y.e("MicroMsg.SettingPrivacy", "userinfo in null !");
            return;
          }
          y.d("MicroMsg.SettingPrivacy", "dancy userinfo " + localObject.toString());
          ((j)g.r(j.class)).Fv().b(new i.a(51, (a)localObject));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI.2
 * JD-Core Version:    0.7.0.1
 */