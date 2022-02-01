package com.tencent.mm.ui;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Map;

final class HomeUI$38
  implements p
{
  HomeUI$38(HomeUI paramHomeUI) {}
  
  public final void onNewXmlReceived(String paramString, Map<String, String> paramMap, f.a parama)
  {
    AppMethodBeat.i(204896);
    if ((bt.nullAsNil(paramString).equals("showprivacypolicy")) && (paramMap != null))
    {
      paramString = (String)paramMap.get(".sysmsg.showprivacypolicy.device_id");
      HomeUI.a(this.FLD, (String)paramMap.get(".sysmsg.showprivacypolicy.doublecheck_content"));
      HomeUI.b(this.FLD, (String)paramMap.get(".sysmsg.showprivacypolicy.doublecheck_ok"));
      HomeUI.c(this.FLD, (String)paramMap.get(".sysmsg.showprivacypolicy.doublecheck_cancel"));
      boolean bool1 = "yes".equals(paramMap.get(".sysmsg.showprivacypolicy.needbirthday"));
      boolean bool2 = "yes".equals(paramMap.get(".sysmsg.showprivacypolicy.needopenplatform"));
      boolean bool3 = "yes".equals(paramMap.get(".sysmsg.showprivacypolicy.needconfirm"));
      g.afB().afk().set(ae.a.Fth, Boolean.valueOf(bool1));
      g.afB().afk().set(ae.a.Fti, Boolean.valueOf(bool2));
      g.afB().afk().set(ae.a.Ftj, Boolean.valueOf(bool3));
      paramMap = com.tencent.mm.bx.b.cd(q.Xa().getBytes());
      paramMap.Vu(16);
      paramMap = Base64.encodeToString(paramMap.toByteArray(), 2);
      ad.i("MicroMsg.LauncherUI.HomeUI", "deviceId:%s, localDeviceId:%s, doubleCheckContent:%s, doubleCheckOk:%s, doubleCheckCancel:%s, needBirthday:%s, needOpenPlatform:%s, needConfirm:%s", new Object[] { paramString, paramMap, HomeUI.C(this.FLD), HomeUI.E(this.FLD), HomeUI.D(this.FLD), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
      if ((bt.isNullOrNil(paramString)) || (paramString.equals(paramMap)))
      {
        paramString = g.afB().afk().get(274436, "").toString();
        paramMap = HomeUI.b(this.FLD);
        parama = ac.eFu();
        int i;
        if (bool2)
        {
          i = 1;
          paramMap = paramMap.getString(2131760685, new Object[] { parama, paramString, "login", Integer.valueOf(1), Integer.valueOf(i) });
          if (!com.tencent.mm.ax.b.yL(paramString)) {
            break label534;
          }
          ad.i("MicroMsg.LauncherUI.HomeUI", "eu true, needconfirm: %s", new Object[] { Boolean.valueOf(bool3) });
          if (bool3) {
            break label498;
          }
          paramString = new Bundle();
          paramString.putString("close_dialog_msg", HomeUI.C(this.FLD));
          paramString.putString("close_dialog_cancel", HomeUI.D(this.FLD));
          paramString.putString("close_dialog_ok", HomeUI.E(this.FLD));
          paramString.putBoolean("close_dialog_ok_close", false);
          HomeUI.a(this.FLD, paramMap, 22722, paramString);
        }
        for (;;)
        {
          com.tencent.mm.ui.base.b.jJ(HomeUI.b(this.FLD));
          AppMethodBeat.o(204896);
          return;
          i = 0;
          break;
          label498:
          HomeUI.a(this.FLD, paramMap, 22722, HomeUI.b(this.FLD).getString(2131760033, new Object[] { ac.eFu() }));
          continue;
          label534:
          ad.i("MicroMsg.LauncherUI.HomeUI", "eu false");
          paramString = new Bundle();
          paramString.putString("close_dialog_msg", HomeUI.b(this.FLD).getString(2131760682));
          paramString.putString("close_dialog_cancel", HomeUI.b(this.FLD).getString(2131760803));
          paramString.putString("close_dialog_ok", HomeUI.b(this.FLD).getString(2131760684));
          paramString.putBoolean("close_dialog_ok_close", false);
          HomeUI.a(this.FLD, paramMap, 22722, paramString);
        }
      }
      ad.i("MicroMsg.LauncherUI.HomeUI", "device id not match");
    }
    AppMethodBeat.o(204896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI.38
 * JD-Core Version:    0.7.0.1
 */