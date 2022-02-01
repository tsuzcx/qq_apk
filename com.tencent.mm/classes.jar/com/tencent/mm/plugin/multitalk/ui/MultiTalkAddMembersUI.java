package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;

public class MultiTalkAddMembersUI
  extends MultiTalkSelectContactUI
{
  private boolean tQo = false;
  
  public final void cMR()
  {
    AppMethodBeat.i(178894);
    this.tQB = false;
    super.cMR();
    AppMethodBeat.o(178894);
  }
  
  public void initView()
  {
    AppMethodBeat.i(114651);
    super.initView();
    this.twW.setBackgroundResource(2131100208);
    MultiSelectContactView localMultiSelectContactView = this.twW;
    int i = com.tencent.mm.plugin.multitalk.ui.widget.f.tRM;
    localMultiSelectContactView.setPadding(i, i, com.tencent.mm.plugin.multitalk.ui.widget.f.tRM, 0);
    AppMethodBeat.o(114651);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(178895);
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)aj.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)aj.getContext().getSystemService("power");
    boolean bool1 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool2 = hasWindowFocus();
    boolean bool3 = localPowerManager.isScreenOn();
    if (((bool2) || (!bool1)) && (bool3)) {}
    for (bool1 = true;; bool1 = false)
    {
      this.tQo = bool1;
      AppMethodBeat.o(178895);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(178896);
    super.onStop();
    if (this.tQB)
    {
      this.tQB = false;
      cMR();
      p.cSO().nC(false);
    }
    AppMethodBeat.o(178896);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkAddMembersUI
 * JD-Core Version:    0.7.0.1
 */