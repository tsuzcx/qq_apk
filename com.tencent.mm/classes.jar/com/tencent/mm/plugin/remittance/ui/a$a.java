package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a
  implements Runnable
{
  private View view;
  
  a$a(View paramView)
  {
    this.view = paramView;
  }
  
  public final void run()
  {
    AppMethodBeat.i(67914);
    View localView = this.view;
    for (boolean bool = localView.performLongClick(); !bool; bool = localView.performLongClick())
    {
      localView = (View)localView.getParent();
      if (localView == null) {
        break;
      }
    }
    AppMethodBeat.o(67914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.a.a
 * JD-Core Version:    0.7.0.1
 */