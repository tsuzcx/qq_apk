package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class VoipMgr$6
  implements DialogInterface.OnClickListener
{
  VoipMgr$6(VoipMgr paramVoipMgr) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(4465);
    paramDialogInterface = VoipMgr.g(this.tyo).getSharedPreferences("voip_plugin_prefs", 0);
    VoipMgr.a(this.tyo, paramDialogInterface);
    if (4096 != VoipMgr.D(this.tyo))
    {
      VoipMgr.f(this.tyo, VoipMgr.D(this.tyo));
      VoipMgr.E(this.tyo);
    }
    if (VoipMgr.F(this.tyo) != null) {
      VoipMgr.F(this.tyo).post(new VoipMgr.6.1(this));
    }
    AppMethodBeat.o(4465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.6
 * JD-Core Version:    0.7.0.1
 */