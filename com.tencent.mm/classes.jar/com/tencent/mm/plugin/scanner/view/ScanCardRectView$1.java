package com.tencent.mm.plugin.scanner.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class ScanCardRectView$1
  implements View.OnClickListener
{
  ScanCardRectView$1(ScanCardRectView paramScanCardRectView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(118378);
    paramView = View.inflate(this.wbN.getContext(), 2131495286, null);
    h.a(this.wbN.getContext(), this.wbN.getContext().getString(2131762796), this.wbN.getContext().getString(2131762795), paramView, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(118377);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(118377);
      }
    });
    AppMethodBeat.o(118378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanCardRectView.1
 * JD-Core Version:    0.7.0.1
 */