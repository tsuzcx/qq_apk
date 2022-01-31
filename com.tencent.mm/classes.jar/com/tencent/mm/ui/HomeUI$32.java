package com.tencent.mm.ui;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Map;

final class HomeUI$32
  implements o
{
  HomeUI$32(HomeUI paramHomeUI) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, e.a parama)
  {
    AppMethodBeat.i(153785);
    if ((ah.nullAsNil(paramString).equals("showprivacypolicy")) && (paramMap != null))
    {
      paramString = (String)paramMap.get(".sysmsg.showprivacypolicy.device_id");
      HomeUI.a(this.yYw, (String)paramMap.get(".sysmsg.showprivacypolicy.doublecheck_content"));
      HomeUI.b(this.yYw, (String)paramMap.get(".sysmsg.showprivacypolicy.doublecheck_ok"));
      HomeUI.c(this.yYw, (String)paramMap.get(".sysmsg.showprivacypolicy.doublecheck_cancel"));
      boolean bool1 = "yes".equals(paramMap.get(".sysmsg.showprivacypolicy.needbirthday"));
      boolean bool2 = "yes".equals(paramMap.get(".sysmsg.showprivacypolicy.needopenplatform"));
      boolean bool3 = "yes".equals(paramMap.get(".sysmsg.showprivacypolicy.needconfirm"));
      g.RL().Ru().set(ac.a.yJW, Boolean.valueOf(bool1));
      g.RL().Ru().set(ac.a.yJX, Boolean.valueOf(bool2));
      g.RL().Ru().set(ac.a.yJY, Boolean.valueOf(bool3));
      paramMap = com.tencent.mm.bv.b.bL(q.LK().getBytes());
      paramMap.Mz(16);
      paramMap = Base64.encodeToString(paramMap.toByteArray(), 2);
      ab.i("MicroMsg.LauncherUI.HomeUI", "deviceId:%s, localDeviceId:%s, doubleCheckContent:%s, doubleCheckOk:%s, doubleCheckCancel:%s, needBirthday:%s, needOpenPlatform:%s, needConfirm:%s", new Object[] { paramString, paramMap, HomeUI.y(this.yYw), HomeUI.A(this.yYw), HomeUI.z(this.yYw), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((ah.isNullOrNil(paramString)) || (paramString.equals(paramMap)))
      {
        paramString = g.RL().Ru().get(274436, "").toString();
        paramMap = HomeUI.b(this.yYw);
        parama = aa.dsG();
        int i;
        if (bool2)
        {
          i = 1;
          paramMap = paramMap.getString(2131306182, new Object[] { parama, paramString, "login", Integer.valueOf(1), Integer.valueOf(i) });
          if (!com.tencent.mm.au.b.tM(paramString)) {
            break label534;
          }
          ab.i("MicroMsg.LauncherUI.HomeUI", "eu true, needconfirm: %s", new Object[] { Boolean.valueOf(bool3) });
          if (bool3) {
            break label498;
          }
          paramString = new Bundle();
          paramString.putString("close_dialog_msg", HomeUI.y(this.yYw));
          paramString.putString("close_dialog_cancel", HomeUI.z(this.yYw));
          paramString.putString("close_dialog_ok", HomeUI.A(this.yYw));
          paramString.putBoolean("close_dialog_ok_close", false);
          HomeUI.a(this.yYw, paramMap, 22722, paramString);
        }
        for (;;)
        {
          com.tencent.mm.ui.base.b.ih(HomeUI.b(this.yYw));
          AppMethodBeat.o(153785);
          return;
          i = 0;
          break;
          label498:
          HomeUI.a(this.yYw, paramMap, 22722, HomeUI.b(this.yYw).getString(2131306172, new Object[] { aa.dsG() }));
          continue;
          label534:
          ab.i("MicroMsg.LauncherUI.HomeUI", "eu false");
          paramString = new Bundle();
          paramString.putString("close_dialog_msg", HomeUI.b(this.yYw).getString(2131301062));
          paramString.putString("close_dialog_cancel", HomeUI.b(this.yYw).getString(2131301171));
          paramString.putString("close_dialog_ok", HomeUI.b(this.yYw).getString(2131301064));
          paramString.putBoolean("close_dialog_ok_close", false);
          HomeUI.a(this.yYw, paramMap, 22722, paramString);
        }
      }
      ab.i("MicroMsg.LauncherUI.HomeUI", "device id not match");
    }
    AppMethodBeat.o(153785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.32
 * JD-Core Version:    0.7.0.1
 */