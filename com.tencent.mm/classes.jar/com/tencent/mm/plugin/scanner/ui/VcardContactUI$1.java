package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h.c;

final class VcardContactUI$1
  implements h.c
{
  VcardContactUI$1(VcardContactUI paramVcardContactUI, String paramString) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(81345);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(81345);
      return;
      Intent localIntent = new Intent("android.intent.action.DIAL");
      localIntent.setFlags(268435456);
      localIntent.setData(Uri.parse("tel:" + this.kyt));
      this.qBL.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.VcardContactUI.1
 * JD-Core Version:    0.7.0.1
 */