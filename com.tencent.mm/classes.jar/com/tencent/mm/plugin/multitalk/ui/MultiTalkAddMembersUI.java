package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;

public class MultiTalkAddMembersUI
  extends MultiTalkSelectContactUI
{
  private boolean wtp = false;
  
  public final void dmJ()
  {
    AppMethodBeat.i(178894);
    this.wtG = false;
    super.dmJ();
    AppMethodBeat.o(178894);
  }
  
  public void initView()
  {
    AppMethodBeat.i(114651);
    super.initView();
    this.vUs.setBackgroundResource(2131100208);
    MultiSelectContactView localMultiSelectContactView = this.vUs;
    int i = f.wvf;
    localMultiSelectContactView.setPadding(i, i, f.wvf, 0);
    AppMethodBeat.o(114651);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(178895);
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)ak.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)ak.getContext().getSystemService("power");
    boolean bool1 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool2 = hasWindowFocus();
    boolean bool3 = localPowerManager.isScreenOn();
    if (((bool2) || (!bool1)) && (bool3)) {}
    for (bool1 = true;; bool1 = false)
    {
      this.wtp = bool1;
      AppMethodBeat.o(178895);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(178896);
    super.onStop();
    if (this.wtG)
    {
      this.wtG = false;
      dmJ();
      z.dtK().pa(false);
    }
    AppMethodBeat.o(178896);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkAddMembersUI
 * JD-Core Version:    0.7.0.1
 */