package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ac$1
  implements View.OnClickListener
{
  ac$1(ac paramac) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112459);
    if (ac.a(this.zeO) != null) {
      ac.a(this.zeO).onClickBackBtn(paramView);
    }
    AppMethodBeat.o(112459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.ac.1
 * JD-Core Version:    0.7.0.1
 */