package com.tencent.mm.ui;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

final class HomeUI$18
  implements View.OnClickListener
{
  HomeUI$18(HomeUI paramHomeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153779);
    if (SystemClock.elapsedRealtime() - HomeUI.v(this.yYw) < 300L)
    {
      paramView = HomeUI.w(this.yYw).iterator();
      while (paramView.hasNext()) {
        ((Runnable)paramView.next()).run();
      }
    }
    HomeUI.b(this.yYw, SystemClock.elapsedRealtime());
    AppMethodBeat.o(153779);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.18
 * JD-Core Version:    0.7.0.1
 */