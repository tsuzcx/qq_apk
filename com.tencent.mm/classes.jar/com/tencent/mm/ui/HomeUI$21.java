package com.tencent.mm.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

final class HomeUI$21
  implements Runnable
{
  HomeUI$21(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    y.i("MicroMsg.LauncherUI.HomeUI", "contentView.post, padding: %s", new Object[] { Integer.valueOf(HomeUI.c(this.uKu).getPaddingTop()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.21
 * JD-Core Version:    0.7.0.1
 */