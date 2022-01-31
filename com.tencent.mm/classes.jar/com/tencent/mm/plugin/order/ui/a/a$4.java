package com.tencent.mm.plugin.order.ui.a;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.wallet_core.ui.c;

final class a$4
  implements View.OnClickListener
{
  a$4(a parama, Bitmap paramBitmap, MallTransactionObject paramMallTransactionObject) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43888);
    if (this.prv.prt != null)
    {
      a locala = this.prv;
      Bitmap localBitmap = this.val$bmp;
      String str = this.poX.ppm;
      if (locala.prt != null)
      {
        locala.prt.iJ(str, str);
        locala.prt.pmD = localBitmap;
        locala.prt.pmE = localBitmap;
        locala.prt.dSP();
      }
      this.prv.prt.H(paramView, true);
    }
    AppMethodBeat.o(43888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.a.4
 * JD-Core Version:    0.7.0.1
 */