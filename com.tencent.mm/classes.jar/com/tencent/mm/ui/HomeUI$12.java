package com.tencent.mm.ui;

import android.support.v7.app.ActionBar;
import android.view.View;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

final class HomeUI$12
  implements Runnable
{
  HomeUI$12(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    HomeUI.a(this.uKu);
    au.Hx();
    c.Dz().setInt(327947, HomeUI.b(this.uKu).getHeight());
    y.i("MicroMsg.LauncherUI.HomeUI", "contentView.post then setFullScreenAfterSetContentView, padding: %s", new Object[] { Integer.valueOf(HomeUI.c(this.uKu).getPaddingTop()) });
    e.b(HomeUI.d(this.uKu), HomeUI.c(this.uKu));
  }
  
  public final String toString()
  {
    return super.toString() + "|updateTitle";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.12
 * JD-Core Version:    0.7.0.1
 */