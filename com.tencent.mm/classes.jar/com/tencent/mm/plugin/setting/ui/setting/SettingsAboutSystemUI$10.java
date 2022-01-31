package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;

final class SettingsAboutSystemUI$10
  implements View.OnClickListener
{
  SettingsAboutSystemUI$10(SettingsAboutSystemUI paramSettingsAboutSystemUI, LinearLayout paramLinearLayout) {}
  
  public final void onClick(View paramView)
  {
    int k = 0;
    AppMethodBeat.i(127121);
    int i = 0;
    Object localObject;
    while (i < this.qHq.getChildCount())
    {
      localObject = (TextView)this.qHq.getChildAt(i);
      if (2131823916 != ((TextView)localObject).getId()) {
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(2131231905, 0, 0, 0);
      }
      i += 1;
    }
    ((TextView)paramView).setCompoundDrawablesWithIntrinsicBounds(2131231906, 0, 0, 0);
    int m = ((Integer)g.RL().Ru().get(7, Integer.valueOf(0))).intValue();
    int n = ((Integer)paramView.getTag()).intValue();
    ab.d("MicroMsg.SettingsAboutSystemUI", "settings_silence_update_mode choice: %d", new Object[] { Integer.valueOf(n) });
    if (n == 0)
    {
      i = 1;
      if ((m & 0x1000000) != 0) {
        break label160;
      }
    }
    label160:
    for (int j = 1;; j = 0)
    {
      if (i != j) {
        break label165;
      }
      AppMethodBeat.o(127121);
      return;
      i = 0;
      break;
    }
    label165:
    i = k;
    if (n == 0) {
      i = 1;
    }
    if (i != 0)
    {
      j = 0xFEFFFFFF & m;
      if (i != 0) {
        break label293;
      }
    }
    label293:
    for (i = 1;; i = 2)
    {
      g.RL().Ru().set(7, Integer.valueOf(j));
      localObject = new aek();
      ((aek)localObject).wXn = 35;
      ((aek)localObject).pKC = i;
      ((j)g.E(j.class)).Yz().c(new j.a(23, (a)localObject));
      b.gmP.BO();
      paramView.post(new SettingsAboutSystemUI.10.1(this));
      AppMethodBeat.o(127121);
      return;
      j = m | 0x1000000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI.10
 * JD-Core Version:    0.7.0.1
 */