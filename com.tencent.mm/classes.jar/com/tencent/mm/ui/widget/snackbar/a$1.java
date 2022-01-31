package com.tencent.mm.ui.widget.snackbar;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112973);
    if ((this.AKw.AKt != null) && (this.AKw.AKs.isShowing())) {
      this.AKw.AKt.aVA();
    }
    this.AKw.mHandler.postDelayed(new a.1.1(this), 100L);
    AppMethodBeat.o(112973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.a.1
 * JD-Core Version:    0.7.0.1
 */