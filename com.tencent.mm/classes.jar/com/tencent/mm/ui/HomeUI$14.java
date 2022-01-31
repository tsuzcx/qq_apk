package com.tencent.mm.ui;

import android.os.Bundle;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.b;

final class HomeUI$14
  implements Runnable
{
  HomeUI$14(HomeUI paramHomeUI) {}
  
  public final void run()
  {
    String str = HomeUI.d(this.uKu).getString(R.l.gdpr_login_verifybirthday_url, new Object[] { x.cqJ() });
    if (!g.DP().Dz().getBoolean(ac.a.uzk, false))
    {
      y.i("MicroMsg.LauncherUI.HomeUI", "needconfirm false");
      Bundle localBundle = new Bundle();
      localBundle.putString("close_dialog_msg", HomeUI.r(this.uKu));
      localBundle.putString("close_dialog_cancel", HomeUI.s(this.uKu));
      localBundle.putString("close_dialog_ok", HomeUI.t(this.uKu));
      localBundle.putBoolean("close_dialog_ok_close", false);
      HomeUI.a(this.uKu, str, 22723, localBundle);
    }
    for (;;)
    {
      b.gL(HomeUI.d(this.uKu));
      return;
      HomeUI.a(this.uKu, str, 22723, HomeUI.d(this.uKu).getString(R.l.gdpr_warn_privacy_url, new Object[] { x.cqJ() }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.14
 * JD-Core Version:    0.7.0.1
 */