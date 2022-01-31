package com.tencent.mm.ui;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.Iterator;
import java.util.LinkedList;

final class HomeUI$8
  implements View.OnClickListener
{
  HomeUI$8(HomeUI paramHomeUI) {}
  
  public final void onClick(View paramView)
  {
    if (SystemClock.elapsedRealtime() - HomeUI.o(this.uKu) < 300L)
    {
      paramView = HomeUI.p(this.uKu).iterator();
      while (paramView.hasNext()) {
        ((Runnable)paramView.next()).run();
      }
    }
    HomeUI.b(this.uKu, SystemClock.elapsedRealtime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.8
 * JD-Core Version:    0.7.0.1
 */