package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.sdk.platformtools.y;

public final class o$12
  implements DialogInterface.OnClickListener
{
  public o$12(o paramo, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.Voip.VoipMgr", "show Permission settings");
    b.bf(this.pSZ);
    if (!o.b(this.pSP))
    {
      if (o.e(this.pSP))
      {
        this.pSP.bQu();
        return;
      }
      this.pSP.bQx();
      return;
    }
    if (o.e(this.pSP))
    {
      this.pSP.bQz();
      return;
    }
    this.pSP.bQA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.o.12
 * JD-Core Version:    0.7.0.1
 */