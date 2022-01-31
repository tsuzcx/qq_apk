package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MMTagPanel$8
  implements View.OnClickListener
{
  MMTagPanel$8(MMTagPanel paramMMTagPanel) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(106820);
    if (((Integer)paramView.getTag()).intValue() == 0)
    {
      this.zmE.a((TextView)paramView, true, false);
      if (MMTagPanel.e(this.zmE) != null)
      {
        paramView.post(new MMTagPanel.8.1(this, paramView));
        AppMethodBeat.o(106820);
      }
    }
    else if ((!MMTagPanel.f(this.zmE)) || (MMTagPanel.c(this.zmE)))
    {
      this.zmE.a((TextView)paramView, false, false);
      if (MMTagPanel.e(this.zmE) != null)
      {
        paramView.post(new MMTagPanel.8.2(this, paramView));
        AppMethodBeat.o(106820);
      }
    }
    else if (MMTagPanel.d(this.zmE) == null)
    {
      MMTagPanel.a(this.zmE, MMTagPanel.a(this.zmE, ((TextView)paramView).getText().toString()));
      if (MMTagPanel.d(this.zmE) != null)
      {
        this.zmE.a(MMTagPanel.d(this.zmE).zmP, false, true);
        AppMethodBeat.o(106820);
      }
    }
    else if (MMTagPanel.d(this.zmE).zmP == paramView)
    {
      MMTagPanel.a(this.zmE, null);
      this.zmE.a((TextView)paramView, false, false);
      if (MMTagPanel.e(this.zmE) != null)
      {
        paramView.post(new MMTagPanel.8.3(this, paramView));
        AppMethodBeat.o(106820);
      }
    }
    else
    {
      this.zmE.dEq();
      MMTagPanel.a(this.zmE, MMTagPanel.a(this.zmE, ((TextView)paramView).getText().toString()));
      if (MMTagPanel.d(this.zmE) != null) {
        this.zmE.a(MMTagPanel.d(this.zmE).zmP, false, true);
      }
    }
    AppMethodBeat.o(106820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTagPanel.8
 * JD-Core Version:    0.7.0.1
 */