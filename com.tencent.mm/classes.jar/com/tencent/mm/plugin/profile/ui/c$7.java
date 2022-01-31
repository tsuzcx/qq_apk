package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

final class c$7
  implements DialogInterface.OnClickListener
{
  c$7(c paramc, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(23463);
    paramDialogInterface = new Intent("android.intent.action.DIAL");
    paramDialogInterface.setFlags(268435456);
    paramDialogInterface.setData(Uri.parse("tel:" + this.kyt));
    if (bo.k(this.pzT.cmc, paramDialogInterface)) {
      this.pzT.cmc.startActivity(paramDialogInterface);
    }
    AppMethodBeat.o(23463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.c.7
 * JD-Core Version:    0.7.0.1
 */