package com.tencent.mm.plugin.multitalk.ui;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;

public class MultiTalkAddMembersUI
  extends MultiTalkSelectContactUI
{
  private boolean Lrq = false;
  
  public final void fYZ()
  {
    AppMethodBeat.i(178894);
    this.LrP = false;
    super.fYZ();
    AppMethodBeat.o(178894);
  }
  
  public void initView()
  {
    AppMethodBeat.i(114651);
    super.initView();
    this.KOt.setBackgroundResource(a.b.default_bg_color);
    MultiSelectContactView localMultiSelectContactView = this.KOt;
    int i = f.LtS;
    localMultiSelectContactView.setPadding(i, i, f.LtS, 0);
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
      this.Lrq = bool1;
      AppMethodBeat.o(178895);
      return;
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(178896);
    super.onStop();
    if (this.LrP)
    {
      this.LrP = false;
      fYZ();
      ac.ggS().za(false);
    }
    AppMethodBeat.o(178896);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkAddMembersUI
 * JD-Core Version:    0.7.0.1
 */