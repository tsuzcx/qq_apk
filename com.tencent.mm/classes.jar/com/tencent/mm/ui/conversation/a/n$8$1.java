package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class n$8$1
  implements DialogInterface.OnClickListener
{
  n$8$1(n.8 param8) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      this.vVv.vVt.hNa.setVisibility(8);
      this.vVv.vVt.vVs = true;
      aq.startSettingItent((Context)this.vVv.vVt.sdy.get(), this.vVv.bns);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      y.printErrStackTrace("MicroMsg.NetWarnView", paramDialogInterface, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.n.8.1
 * JD-Core Version:    0.7.0.1
 */