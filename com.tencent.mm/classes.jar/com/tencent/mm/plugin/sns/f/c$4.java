package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.sdk.platformtools.y;

final class c$4
  implements DialogInterface.OnClickListener
{
  c$4(c paramc, Context paramContext, bto parambto, d.a parama, d.b paramb, a.c paramc1, d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.SnSABTestMgr", "onClick alert2");
    c.a(this.owp, this.val$context, this.oqw, this.owr, this.owm, this.own, this.owo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.c.4
 * JD-Core Version:    0.7.0.1
 */