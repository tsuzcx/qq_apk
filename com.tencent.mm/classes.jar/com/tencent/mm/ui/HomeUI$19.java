package com.tencent.mm.ui;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;

final class HomeUI$19
  implements o
{
  HomeUI$19(HomeUI paramHomeUI) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    int i;
    if ((ah.pm(paramString).equals("showprivacypolicy")) && (paramMap != null))
    {
      paramString = (String)paramMap.get(".sysmsg.showprivacypolicy.device_id");
      HomeUI.a(this.uKu, (String)paramMap.get(".sysmsg.showprivacypolicy.doublecheck_content"));
      HomeUI.b(this.uKu, (String)paramMap.get(".sysmsg.showprivacypolicy.doublecheck_ok"));
      HomeUI.c(this.uKu, (String)paramMap.get(".sysmsg.showprivacypolicy.doublecheck_cancel"));
      boolean bool1 = "yes".equals(paramMap.get(".sysmsg.showprivacypolicy.needbirthday"));
      boolean bool2 = "yes".equals(paramMap.get(".sysmsg.showprivacypolicy.needopenplatform"));
      boolean bool3 = "yes".equals(paramMap.get(".sysmsg.showprivacypolicy.needconfirm"));
      g.DP().Dz().c(ac.a.uzi, Boolean.valueOf(bool1));
      g.DP().Dz().c(ac.a.uzj, Boolean.valueOf(bool2));
      g.DP().Dz().c(ac.a.uzk, Boolean.valueOf(bool3));
      paramMap = com.tencent.mm.bv.b.bk(q.zg().getBytes());
      paramMap.EB(16);
      paramMap = Base64.encodeToString(paramMap.toByteArray(), 2);
      y.i("MicroMsg.LauncherUI.HomeUI", "deviceId:%s, localDeviceId:%s, doubleCheckContent:%s, doubleCheckOk:%s, doubleCheckCancel:%s, needBirthday:%s, needOpenPlatform:%s, needConfirm:%s", new Object[] { paramString, paramMap, HomeUI.r(this.uKu), HomeUI.t(this.uKu), HomeUI.s(this.uKu), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((!ah.bl(paramString)) && (!paramString.equals(paramMap))) {
        break label624;
      }
      paramString = g.DP().Dz().get(274436, "").toString();
      paramMap = HomeUI.d(this.uKu);
      int j = R.l.license_read_url;
      parama = x.cqJ();
      if (!bool2) {
        break label487;
      }
      i = 1;
      paramMap = paramMap.getString(j, new Object[] { parama, paramString, "login", Integer.valueOf(1), Integer.valueOf(i) });
      if (!com.tencent.mm.at.b.mC(paramString)) {
        break label530;
      }
      y.i("MicroMsg.LauncherUI.HomeUI", "eu true, needconfirm: %s", new Object[] { Boolean.valueOf(bool3) });
      if (bool3) {
        break label493;
      }
      paramString = new Bundle();
      paramString.putString("close_dialog_msg", HomeUI.r(this.uKu));
      paramString.putString("close_dialog_cancel", HomeUI.s(this.uKu));
      paramString.putString("close_dialog_ok", HomeUI.t(this.uKu));
      paramString.putBoolean("close_dialog_ok_close", false);
      HomeUI.a(this.uKu, paramMap, 22722, paramString);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.b.gL(HomeUI.d(this.uKu));
      return;
      label487:
      i = 0;
      break;
      label493:
      HomeUI.a(this.uKu, paramMap, 22722, HomeUI.d(this.uKu).getString(R.l.gdpr_warn_privacy_url, new Object[] { x.cqJ() }));
      continue;
      label530:
      y.i("MicroMsg.LauncherUI.HomeUI", "eu false");
      paramString = new Bundle();
      paramString.putString("close_dialog_msg", HomeUI.d(this.uKu).getString(R.l.license_disagree_tip));
      paramString.putString("close_dialog_cancel", HomeUI.d(this.uKu).getString(R.l.logout_menu_logout));
      paramString.putString("close_dialog_ok", HomeUI.d(this.uKu).getString(R.l.license_read_again));
      paramString.putBoolean("close_dialog_ok_close", false);
      HomeUI.a(this.uKu, paramMap, 22722, paramString);
    }
    label624:
    y.i("MicroMsg.LauncherUI.HomeUI", "device id not match");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.19
 * JD-Core Version:    0.7.0.1
 */