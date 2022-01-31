package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.h.a.ru.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class AppPanel$3
  implements AppGrid.b
{
  AppPanel$3(AppPanel paramAppPanel) {}
  
  public final int Eg(int paramInt)
  {
    if (paramInt < AppPanel.f(this.sen))
    {
      int m = AppPanel.g(this.sen).length;
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        k = j;
        if (AppPanel.g(this.sen)[i] != 0)
        {
          if (j == paramInt) {
            return i;
          }
          k = j + 1;
        }
        i += 1;
      }
    }
    if ((paramInt >= AppPanel.f(this.sen)) && (paramInt < AppPanel.h(this.sen))) {
      return -2147483648;
    }
    return 2147483647;
  }
  
  public final void Eh(int paramInt)
  {
    if (paramInt == 0)
    {
      if (!this.sen.sdT.ser.value) {
        Toast.makeText(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.chatting_msg_type_not_support), 0).show();
      }
    }
    else {
      return;
    }
    AppPanel.a(this.sen, true);
  }
  
  public final void a(int paramInt, f paramf)
  {
    int i = 0;
    boolean bool1;
    Object localObject;
    if (paramf != null)
    {
      bool1 = true;
      y.d("MicroMsg.AppPanel", "pos=%d, has appInfo = %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool1) });
      if ((paramf != null) && (com.tencent.mm.pluginsdk.model.app.g.j(paramf)))
      {
        localObject = paramf.field_appId;
        HashMap localHashMap = new HashMap();
        q.j(localHashMap);
        localHashMap.put(localObject, "1");
        q.i(localHashMap);
      }
    }
    switch (paramInt)
    {
    default: 
    case 2147483647: 
    case 8: 
    case -2147483648: 
    case 1: 
    case 12: 
    case 7: 
      do
      {
        return;
        bool1 = false;
        break;
        if (AppPanel.j(this.sen) == null)
        {
          y.e("MicroMsg.AppPanel", "infoList == null");
          return;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.aC(10305, String.valueOf(AppPanel.j(this.sen).size()));
        com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(10) });
        com.tencent.mm.kernel.g.DP().Dz().o(69121, "");
        AppPanel.k(this.sen).bhr();
        return;
        localObject = paramf;
        if (paramf == null) {
          localObject = (f)AppPanel.l(this.sen).get(f.rUa);
        }
        au.Hx();
        paramInt = ((Integer)c.Dz().get(ac.a.usE, Integer.valueOf(0))).intValue();
        au.Hx();
        paramf = bk.G(((String)c.Dz().get(ac.a.uuH, "")).split(";"));
        if (!paramf.contains(String.valueOf(paramInt)))
        {
          paramf.add(String.valueOf(paramInt));
          au.Hx();
          c.Dz().c(ac.a.uuH, bk.c(paramf, ";"));
          this.sen.refresh();
        }
        au.Hx();
        c.Dz().o(80, Boolean.valueOf(false));
        AppPanel.k(this.sen).b((f)localObject);
        return;
        if (!this.sen.sdT.sez.value)
        {
          Toast.makeText(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.chatting_msg_type_not_support), 0).show();
          return;
        }
        if (paramf == null)
        {
          y.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
          return;
        }
        if ((paramf.ckN()) || (paramf.ckP()))
        {
          if (AppPanel.m(this.sen) == null) {
            AppPanel.a(this.sen, AppPanel.i(this.sen).getSharedPreferences(ae.cqR(), 0));
          }
          if (AppPanel.m(this.sen).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramf.field_appId, true)) {
            AppPanel.m(this.sen).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramf.field_appId, false).commit();
          }
          if (paramf.ckP()) {
            com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(16), paramf.field_appId, Integer.valueOf(0) });
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(13), paramf.field_appId, Integer.valueOf(0) });
        }
        for (;;)
        {
          AppPanel.k(this.sen).b(paramf);
          return;
          com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(11), paramf.field_appId });
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(14) });
        paramf = AppPanel.k(this.sen);
        if (this.sen.sdT.seI.value) {}
        for (paramInt = i;; paramInt = 2)
        {
          paramf.tB(paramInt);
          return;
        }
        if (!this.sen.sdT.ses.value)
        {
          Toast.makeText(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.chatting_msg_type_not_support), 0).show();
          return;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(4) });
        AppPanel.k(this.sen).bhq();
        return;
        if (!this.sen.sdT.seJ.value)
        {
          Toast.makeText(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.chatting_msg_type_not_support), 0).show();
          return;
        }
        if (paramf != null) {
          break label2880;
        }
        paramf = (f)AppPanel.l(this.sen).get(f.rUc);
      } while (paramf == null);
    }
    label2880:
    for (;;)
    {
      if ((paramf.ckN()) || (paramf.ckP()))
      {
        if (AppPanel.m(this.sen) == null) {
          AppPanel.a(this.sen, AppPanel.i(this.sen).getSharedPreferences(ae.cqR(), 0));
        }
        if (AppPanel.m(this.sen).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramf.field_appId, true)) {
          AppPanel.m(this.sen).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramf.field_appId, false).commit();
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(13), paramf.field_appId, Integer.valueOf(0) });
      }
      for (;;)
      {
        au.Hx();
        paramInt = ((Integer)c.Dz().get(ac.a.usE, Integer.valueOf(0))).intValue();
        au.Hx();
        paramf = bk.G(((String)c.Dz().get(ac.a.uuI, "")).split(";"));
        if (!paramf.contains(String.valueOf(paramInt)))
        {
          paramf.add(String.valueOf(paramInt));
          au.Hx();
          c.Dz().c(ac.a.uuI, bk.c(paramf, ";"));
          this.sen.refresh();
        }
        AppPanel.k(this.sen).bhv();
        return;
        com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(11), paramf.field_appId });
      }
      if ((!this.sen.sdT.seF.value) || (!this.sen.sdT.seG.value))
      {
        Toast.makeText(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.chatting_msg_type_not_support), 0).show();
        return;
      }
      au.Hx();
      if (((Boolean)c.Dz().get(290817, Boolean.valueOf(true))).booleanValue())
      {
        au.Hx();
        c.Dz().o(290817, Boolean.valueOf(false));
        this.sen.refresh();
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(3) });
      AppPanel.k(this.sen).bhp();
      return;
      if (!this.sen.sdT.sew.value)
      {
        Toast.makeText(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.chatting_msg_type_not_support), 0).show();
        return;
      }
      au.Hx();
      if (((Boolean)c.Dz().get(327744, Boolean.valueOf(true))).booleanValue())
      {
        au.Hx();
        c.Dz().o(327744, Boolean.valueOf(false));
        this.sen.refresh();
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(12) });
      AppPanel.k(this.sen).bht();
      return;
      if (!this.sen.sdT.ser.value)
      {
        Toast.makeText(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.chatting_msg_type_not_support), 0).show();
        return;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(1) });
      AppPanel.a(this.sen, false);
      return;
      if (!this.sen.sdT.seu.value)
      {
        Toast.makeText(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.chatting_msg_type_not_support), 0).show();
        return;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(8) });
      au.Hx();
      c.Dz().o(54, Boolean.valueOf(false));
      if (AppPanel.k(this.sen) == null) {
        break;
      }
      paramf = new ru();
      paramf.cbq.cbs = true;
      com.tencent.mm.sdk.b.a.udP.m(paramf);
      paramf = paramf.cbr.cbu;
      if (!bk.bl(paramf))
      {
        y.v("MicroMsg.AppPanel", "Talkroom is on: " + paramf);
        com.tencent.mm.ui.base.h.a(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.talk_room_enter_voip_tip), "", AppPanel.i(this.sen).getString(R.l.app_ok), AppPanel.i(this.sen).getString(R.l.app_cancel), new AppPanel.3.1(this), new AppPanel.3.2(this));
        return;
      }
      AppPanel.k(this.sen).bhm();
      return;
      if (!this.sen.sdT.seB.value)
      {
        Toast.makeText(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.chatting_msg_type_not_support), 0).show();
        return;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(7) });
      au.Hx();
      c.Dz().o(62, Boolean.valueOf(false));
      paramf = new ru();
      paramf.cbq.cbs = true;
      com.tencent.mm.sdk.b.a.udP.m(paramf);
      paramf = paramf.cbr.cbu;
      if (!bk.bl(paramf))
      {
        y.v("MicroMsg.AppPanel", "Talkroom is on: " + paramf);
        com.tencent.mm.ui.base.h.a(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.talk_room_enter_voip_tip), "", AppPanel.i(this.sen).getString(R.l.app_ok), AppPanel.i(this.sen).getString(R.l.app_cancel), new AppPanel.3.3(this), new AppPanel.3.4(this));
        return;
      }
      AppPanel.k(this.sen).bhn();
      return;
      if (AppPanel.k(this.sen) == null) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(6) });
      au.Hx();
      c.Dz().o(67, Boolean.valueOf(false));
      AppPanel.k(this.sen).bho();
      return;
      com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(9) });
      au.Hx();
      c.Dz().o(73, Boolean.valueOf(false));
      AppPanel.n(this.sen).cna();
      return;
      if (!this.sen.sdT.set.value)
      {
        Toast.makeText(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.chatting_msg_type_not_support), 0).show();
        return;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(5) });
      if (AppPanel.k(this.sen) == null) {
        break;
      }
      AppPanel.k(this.sen).bhs();
      return;
      if (!this.sen.sdT.seH.value)
      {
        Toast.makeText(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.chatting_msg_type_not_support), 0).show();
        return;
      }
      if (AppPanel.k(this.sen) != null) {
        AppPanel.k(this.sen).bhu();
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(15) });
      au.Hx();
      bool1 = ((Boolean)c.Dz().get(208899, Boolean.valueOf(false))).booleanValue();
      au.Hx();
      boolean bool2 = ((Boolean)c.Dz().get(208913, Boolean.valueOf(false))).booleanValue();
      if (bool1)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.f(11594, new Object[] { Integer.valueOf(3) });
        return;
      }
      if (!bool2) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(11594, new Object[] { Integer.valueOf(4) });
      return;
      if (AppPanel.k(this.sen) == null) {
        break;
      }
      AppPanel.k(this.sen).bhw();
      return;
      if (!this.sen.sdT.seL.value)
      {
        Toast.makeText(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.chatting_msg_type_not_support), 0).show();
        return;
      }
      AppPanel.k(this.sen).bhx();
      return;
      if (AppPanel.k(this.sen) == null) {
        break;
      }
      if (paramf == null)
      {
        localObject = (f)AppPanel.l(this.sen).get(f.rUd);
        paramf = (f)localObject;
        if (localObject == null)
        {
          y.i("MicroMsg.AppPanel", "empty info");
          return;
        }
      }
      if ((paramf.ckN()) || (paramf.ckP()))
      {
        if (AppPanel.m(this.sen) == null) {
          AppPanel.a(this.sen, AppPanel.i(this.sen).getSharedPreferences(ae.cqR(), 0));
        }
        if (AppPanel.m(this.sen).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramf.field_appId, true)) {
          AppPanel.m(this.sen).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramf.field_appId, false).commit();
        }
      }
      AppPanel.k(this.sen).bhy();
      return;
      if (!this.sen.sdT.seN.value)
      {
        Toast.makeText(AppPanel.i(this.sen), AppPanel.i(this.sen).getString(R.l.chatting_msg_type_not_support), 0).show();
        return;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.f(10923, new Object[] { Integer.valueOf(17) });
      if (AppPanel.k(this.sen) == null) {
        break;
      }
      AppPanel.k(this.sen).bhz();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel.3
 * JD-Core Version:    0.7.0.1
 */