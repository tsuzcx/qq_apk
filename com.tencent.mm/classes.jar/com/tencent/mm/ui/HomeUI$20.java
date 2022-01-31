package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;

final class HomeUI$20
  implements Runnable
{
  HomeUI$20(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    y.d("MicroMsg.LauncherUI.HomeUI", "onMainTabCreate, send refresh broadcast");
    HomeUI.d(this.uKu).sendBroadcast(new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP"));
  }
  
  public final String toString()
  {
    return super.toString() + "|sendBroadcast";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.20
 * JD-Core Version:    0.7.0.1
 */