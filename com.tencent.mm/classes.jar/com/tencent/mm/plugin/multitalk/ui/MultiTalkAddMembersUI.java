package com.tencent.mm.plugin.multitalk.ui;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;

public class MultiTalkAddMembersUI
  extends MultiTalkSelectContactUI
{
  private boolean uYO = false;
  
  public final void dax()
  {
    AppMethodBeat.i(178894);
    this.uZb = false;
    super.dax();
    AppMethodBeat.o(178894);
  }
  
  public void initView()
  {
    AppMethodBeat.i(114651);
    super.initView();
    this.uFo.setBackgroundResource(2131100208);
    MultiSelectContactView localMultiSelectContactView = this.uFo;
    int i = com.tencent.mm.plugin.multitalk.ui.widget.f.vat;
    localMultiSelectContactView.setPadding(i, i, com.tencent.mm.plugin.multitalk.ui.widget.f.vat, 0);
    AppMethodBeat.o(114651);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(178895);
    super.onPause();
    KeyguardManager localKeyguardManager = (KeyguardManager)ai.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)ai.getContext().getSystemService("power");
    boolean bool1 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool2 = hasWindowFocus();
    boolean bool3 = localPowerManager.isScreenOn();
    if (((bool2) || (!bool1)) && (bool3)) {}
    for (bool1 = true;; bool1 = false)
    {
      this.uYO = bool1;
      AppMethodBeat.o(178895);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(178896);
    super.onStop();
    if (this.uZb)
    {
      this.uZb = false;
      dax();
      p.dgx().ow(false);
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