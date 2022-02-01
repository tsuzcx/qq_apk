package com.tencent.mm.plugin.scanner.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.h;

final class ScanCardRectView$1
  implements View.OnClickListener
{
  ScanCardRectView$1(ScanCardRectView paramScanCardRectView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(118378);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/scanner/view/ScanCardRectView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = View.inflate(this.CVi.getContext(), 2131496136, null);
    h.a(this.CVi.getContext(), this.CVi.getContext().getString(2131764884), this.CVi.getContext().getString(2131764883), paramView, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(118377);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(118377);
      }
    });
    a.a(this, "com/tencent/mm/plugin/scanner/view/ScanCardRectView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(118378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanCardRectView.1
 * JD-Core Version:    0.7.0.1
 */