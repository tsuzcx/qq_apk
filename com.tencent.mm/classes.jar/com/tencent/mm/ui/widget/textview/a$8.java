package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;

final class a$8
  implements ViewTreeObserver.OnScrollChangedListener
{
  a$8(a parama) {}
  
  public final void onScrollChanged()
  {
    AppMethodBeat.i(113125);
    if (this.ANs.AMU != null)
    {
      this.ANs.AMT.removeCallbacks(this.ANs.ANp);
      this.ANs.AMT.getLocationInWindow(this.ANs.zzX);
      ak.d("SelectableTextHelper", "onScrollChanged, old-y: %d, y: %d.", new Object[] { Integer.valueOf(this.ANs.sfd[1]), Integer.valueOf(this.ANs.zzX[1]) });
      if (this.ANs.ANl)
      {
        if ((this.ANs.ANm) || (this.ANs.ANn)) {
          break label260;
        }
        if (this.ANs.sfd[1] == this.ANs.zzX[1]) {
          break label238;
        }
        this.ANs.ANm = true;
        this.ANs.ANl = false;
        ak.d("SelectableTextHelper", "judge result, inScrolling.", new Object[0]);
      }
    }
    for (;;)
    {
      this.ANs.sfd[1] = this.ANs.zzX[1];
      if ((!this.ANs.ANi) && ((!this.ANs.ANj) || (!this.ANs.ANk)))
      {
        this.ANs.ANi = true;
        this.ANs.dPP();
      }
      AppMethodBeat.o(113125);
      return;
      label238:
      this.ANs.ANn = true;
      ak.d("SelectableTextHelper", "need delay judge.", new Object[0]);
      continue;
      label260:
      if (this.ANs.ANn)
      {
        this.ANs.ANn = false;
        this.ANs.ANl = false;
        if (this.ANs.sfd[1] != this.ANs.zzX[1])
        {
          this.ANs.ANm = true;
          ak.d("SelectableTextHelper", "judge result(delay), inScrolling.", new Object[0]);
        }
        else
        {
          this.ANs.ANm = false;
          ak.d("SelectableTextHelper", "judge result, click outside.", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.8
 * JD-Core Version:    0.7.0.1
 */