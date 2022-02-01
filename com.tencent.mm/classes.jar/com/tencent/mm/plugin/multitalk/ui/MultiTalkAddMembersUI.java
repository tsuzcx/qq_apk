package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;

public class MultiTalkAddMembersUI
  extends MultiTalkSelectContactUI
{
  private boolean zPH = false;
  
  public final void egJ()
  {
    AppMethodBeat.i(178894);
    this.zQc = false;
    super.egJ();
    AppMethodBeat.o(178894);
  }
  
  public void initView()
  {
    AppMethodBeat.i(114651);
    super.initView();
    this.zoy.setBackgroundResource(2131100241);
    MultiSelectContactView localMultiSelectContactView = this.zoy;
    int i = f.zSe;
    localMultiSelectContactView.setPadding(i, i, f.zSe, 0);
    AppMethodBeat.o(114651);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(178895);
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
    boolean bool1 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool2 = hasWindowFocus();
    boolean bool3 = localPowerManager.isScreenOn();
    if (((bool2) || (!bool1)) && (bool3)) {}
    for (bool1 = true;; bool1 = false)
    {
      this.zPH = bool1;
      AppMethodBeat.o(178895);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(178896);
    super.onStop();
    if (this.zQc)
    {
      this.zQc = false;
      egJ();
      ac.eom().rI(false);
    }
    AppMethodBeat.o(178896);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkAddMembersUI
 * JD-Core Version:    0.7.0.1
 */