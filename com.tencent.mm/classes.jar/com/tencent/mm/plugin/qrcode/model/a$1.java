package com.tencent.mm.plugin.qrcode.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.n;

final class a$1
  implements DialogInterface.OnClickListener
{
  a$1(Intent paramIntent, n paramn, int paramInt1, int paramInt2, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(51538);
    this.val$intent.putExtra("title", this.Nqa.getTitle());
    this.val$intent.putExtra("rawUrl", this.Nqa.bLT());
    if (this.Nqb == 2) {
      this.val$intent.putExtra("stastic_scene", 13);
    }
    for (;;)
    {
      this.val$intent.putExtra("pay_channel", a.agh(this.vHo));
      this.val$intent.putExtra("geta8key_session_id", this.Nqa.bMc());
      this.val$intent.putExtra("geta8key_cookie", this.Nqa.bMe());
      this.val$intent.putExtra("key_enable_teen_mode_check", true);
      a.b(this.val$intent, this.Nqa);
      com.tencent.mm.plugin.scanner.m.dFc().h(this.val$intent, this.val$context);
      AppMethodBeat.o(51538);
      return;
      if (this.Nqb == 1) {
        this.val$intent.putExtra("stastic_scene", 14);
      } else {
        this.val$intent.putExtra("stastic_scene", 11);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qrcode.model.a.1
 * JD-Core Version:    0.7.0.1
 */