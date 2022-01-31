package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.pluginsdk.ui.applet.t.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

final class SnsTransparentUI$1
  implements MMActivity.a
{
  SnsTransparentUI$1(SnsTransparentUI paramSnsTransparentUI, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if (paramIntent == null) {}
      for (paramIntent = null; (paramIntent == null) || (paramIntent.length() == 0); paramIntent = paramIntent.getStringExtra("Select_Conv_User"))
      {
        y.e("SnsTransparentUI", "mmOnActivityResult fail, toUser is null");
        this.pif.finish();
        return;
      }
      y.i("SnsTransparentUI", "doTransimt snsAdNativeLadingPagesUI is ok");
      String str = this.phY;
      SnsTransparentUI localSnsTransparentUI = this.pif;
      t.a.sdu.a(((MMActivity)localSnsTransparentUI).mController, this.phZ, this.pia, this.pib, true, localSnsTransparentUI.getResources().getString(i.j.app_send), new SnsTransparentUI.1.1(this, str, localSnsTransparentUI, paramIntent));
      return;
    }
    this.pif.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTransparentUI.1
 * JD-Core Version:    0.7.0.1
 */