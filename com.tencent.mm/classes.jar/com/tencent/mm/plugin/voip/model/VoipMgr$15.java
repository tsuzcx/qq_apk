package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.sdk.platformtools.ab;

final class VoipMgr$15
  implements DialogInterface.OnClickListener
{
  VoipMgr$15(VoipMgr paramVoipMgr, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(4476);
    ab.i("MicroMsg.Voip.VoipMgr", "show Permission settings");
    b.bJ(this.tyz);
    if (!VoipMgr.b(this.tyo))
    {
      if (VoipMgr.e(this.tyo))
      {
        this.tyo.cMK();
        AppMethodBeat.o(4476);
        return;
      }
      this.tyo.cMN();
      AppMethodBeat.o(4476);
      return;
    }
    if (VoipMgr.e(this.tyo))
    {
      this.tyo.cMP();
      AppMethodBeat.o(4476);
      return;
    }
    this.tyo.cMQ();
    AppMethodBeat.o(4476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr.15
 * JD-Core Version:    0.7.0.1
 */