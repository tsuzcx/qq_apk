package com.tencent.mm.plugin.setting.ui.qrcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.s;

final class ShareToQQUI$2
  implements MenuItem.OnMenuItemClickListener
{
  ShareToQQUI$2(ShareToQQUI paramShareToQQUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    ShareToQQUI.a(this.nRC);
    boolean bool1;
    boolean bool2;
    if ((ShareToQQUI.b(this.nRC) == 2) || (ShareToQQUI.b(this.nRC) == 1))
    {
      paramMenuItem = ShareToQQUI.c(this.nRC).getText().toString();
      if (ShareToQQUI.b(this.nRC) == 1)
      {
        bool1 = true;
        if (ShareToQQUI.b(this.nRC) != 2) {
          break label157;
        }
        bool2 = true;
      }
    }
    label70:
    for (paramMenuItem = new w(paramMenuItem, bool1, bool2);; paramMenuItem = new w(ShareToQQUI.c(this.nRC).getText().toString()))
    {
      com.tencent.mm.kernel.g.Dk().a(paramMenuItem, 0);
      Object localObject = this.nRC;
      AppCompatActivity localAppCompatActivity = this.nRC.mController.uMN;
      this.nRC.getString(a.i.app_tip);
      ShareToQQUI.a((ShareToQQUI)localObject, com.tencent.mm.ui.base.h.b(localAppCompatActivity, this.nRC.getString(a.i.app_sending), true, new ShareToQQUI.2.2(this, paramMenuItem)));
      return true;
      bool1 = false;
      break;
      bool2 = false;
      break label70;
      if (ShareToQQUI.b(this.nRC) != 4) {
        break label292;
      }
      long l = bk.c((Long)com.tencent.mm.kernel.g.DP().Dz().get(65831, null));
      paramMenuItem = bk.pm((String)com.tencent.mm.kernel.g.DP().Dz().get(65830, null));
      if ((bk.co(l) > 86400000L) && (paramMenuItem.length() > 0))
      {
        localObject = new c("290293790992170");
        ((c)localObject).aea(paramMenuItem);
        new com.tencent.mm.plugin.account.model.g((c)localObject, new com.tencent.mm.plugin.account.model.h()
        {
          public final void l(Bundle paramAnonymousBundle)
          {
            super.l(paramAnonymousBundle);
          }
          
          public final void onError(int paramAnonymousInt, String paramAnonymousString)
          {
            super.onError(paramAnonymousInt, paramAnonymousString);
          }
        }).Xx();
      }
    }
    label157:
    label292:
    com.tencent.mm.ui.base.h.h(this.nRC.mController.uMN, a.i.share_at_least_one_item, a.i.app_tip);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.qrcode.ShareToQQUI.2
 * JD-Core Version:    0.7.0.1
 */