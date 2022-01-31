package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.e.g;

final class SettingsPrivacyUI$2
  implements View.OnClickListener
{
  SettingsPrivacyUI$2(SettingsPrivacyUI paramSettingsPrivacyUI, LinearLayout paramLinearLayout) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(127409);
    int i = 0;
    while (i < this.qHq.getChildCount())
    {
      localObject = (TextView)this.qHq.getChildAt(i);
      if (2131823916 != ((TextView)localObject).getId()) {
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2131231905, 0, 0, 0);
      }
      i += 1;
    }
    ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(2131231906, 0, 0, 0);
    Object localObject = new cfj();
    if (n.raR != null) {
      localObject = n.raR.Zu(SettingsPrivacyUI.b(this.qJI));
    }
    if (localObject == null)
    {
      ab.e("MicroMsg.SettingPrivacy", "userinfo is null");
      AppMethodBeat.o(127409);
      return;
    }
    i = ((Integer)paramView.getTag()).intValue();
    ab.i("MicroMsg.SettingPrivacy", "settings_silence_update_mode choice: %d", new Object[] { Integer.valueOf(i) });
    if (i == 0)
    {
      if (SettingsPrivacyUI.c(this.qJI) == e.g.yVf) {
        h.qsU.e(14090, new Object[] { Integer.valueOf(4) });
      }
      SettingsPrivacyUI.a(this.qJI, false);
      SettingsPrivacyUI.b(this.qJI, true);
      SettingsPrivacyUI.c(this.qJI, false);
      SettingsPrivacyUI.d(this.qJI);
    }
    for (;;)
    {
      if (n.raR != null) {
        n.raR.a(SettingsPrivacyUI.b(this.qJI), SettingsPrivacyUI.e(this.qJI), SettingsPrivacyUI.f(this.qJI), SettingsPrivacyUI.g(this.qJI), SettingsPrivacyUI.h(this.qJI));
      }
      if (n.raR == null) {
        break label575;
      }
      localObject = n.raR.b(SettingsPrivacyUI.b(this.qJI), SettingsPrivacyUI.e(this.qJI), SettingsPrivacyUI.f(this.qJI), SettingsPrivacyUI.g(this.qJI), SettingsPrivacyUI.h(this.qJI));
      if (localObject != null) {
        break;
      }
      ab.e("MicroMsg.SettingPrivacy", "userinfo in null !");
      AppMethodBeat.o(127409);
      return;
      if (i == 1)
      {
        if (SettingsPrivacyUI.c(this.qJI) == e.g.yVf) {
          h.qsU.e(14090, new Object[] { Integer.valueOf(5) });
        }
        SettingsPrivacyUI.a(this.qJI, true);
        SettingsPrivacyUI.b(this.qJI, false);
        SettingsPrivacyUI.c(this.qJI, false);
        SettingsPrivacyUI.d(this.qJI);
      }
      else if (i == 3)
      {
        SettingsPrivacyUI.a(this.qJI, false);
        SettingsPrivacyUI.b(this.qJI, false);
        SettingsPrivacyUI.c(this.qJI, true);
        SettingsPrivacyUI.d(this.qJI);
      }
      else
      {
        if (SettingsPrivacyUI.c(this.qJI) == e.g.yVf) {
          h.qsU.e(14090, new Object[] { Integer.valueOf(6) });
        }
        SettingsPrivacyUI.a(this.qJI, false);
        SettingsPrivacyUI.b(this.qJI, false);
        SettingsPrivacyUI.c(this.qJI, false);
        SettingsPrivacyUI.d(this.qJI);
      }
    }
    ab.d("MicroMsg.SettingPrivacy", "dancy userinfo " + localObject.toString());
    ((j)g.E(j.class)).Yz().c(new j.a(51, (a)localObject));
    label575:
    paramView.post(new SettingsPrivacyUI.2.1(this));
    AppMethodBeat.o(127409);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsPrivacyUI.2
 * JD-Core Version:    0.7.0.1
 */