package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class VoipMgr$7
  implements DialogInterface.OnClickListener
{
  VoipMgr$7(VoipMgr paramVoipMgr, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(140146);
    if (this.tyr != null) {
      VoipMgr.g(this.tyo).getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", this.tyr.isChecked()).commit();
    }
    if (4096 != VoipMgr.D(this.tyo))
    {
      VoipMgr.f(this.tyo, VoipMgr.D(this.tyo));
      VoipMgr.E(this.tyo);
    }
    if (VoipMgr.F(this.tyo) != null) {
      VoipMgr.F(this.tyo).post(new VoipMgr.7.1(this));
    }
    AppMethodBeat.o(140146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.7
 * JD-Core Version:    0.7.0.1
 */