package com.tencent.mm.plugin.u.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.pluginsdk.n;

final class c$1
  implements DialogInterface.OnClickListener
{
  c$1(Intent paramIntent, j paramj, int paramInt1, int paramInt2, c.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(80757);
    this.val$intent.putExtra("title", this.pPx.getTitle());
    this.val$intent.putExtra("rawUrl", this.pPx.ajl());
    if (this.pPy == 2) {
      this.val$intent.putExtra("stastic_scene", 13);
    }
    for (;;)
    {
      this.val$intent.putExtra("pay_channel", c.Cd(this.jWF));
      this.val$intent.putExtra("geta8key_session_id", this.pPx.ajt());
      this.val$intent.putExtra("geta8key_cookie", this.pPx.ajv());
      com.tencent.mm.plugin.scanner.c.gmO.i(this.val$intent, this.pPz.getContext());
      AppMethodBeat.o(80757);
      return;
      if (this.pPy == 1) {
        this.val$intent.putExtra("stastic_scene", 14);
      } else {
        this.val$intent.putExtra("stastic_scene", 11);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.u.a.c.1
 * JD-Core Version:    0.7.0.1
 */