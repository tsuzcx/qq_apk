package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class n$7
  implements View.OnClickListener
{
  n$7(n paramn, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    try
    {
      aq.startSettingItent((Context)this.vVt.sdy.get(), this.bns);
      return;
    }
    catch (Exception paramView)
    {
      y.printErrStackTrace("MicroMsg.NetWarnView", paramView, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.n.7
 * JD-Core Version:    0.7.0.1
 */