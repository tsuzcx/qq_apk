package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tl.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class AppPanel$4
  implements AppGrid.b
{
  AppPanel$4(AppPanel paramAppPanel) {}
  
  public final int Mf(int paramInt)
  {
    AppMethodBeat.i(27748);
    if (paramInt < AppPanel.f(this.vVs))
    {
      int m = AppPanel.g(this.vVs).length;
      int i = 0;
      int k;
      for (int j = 0; i < m; j = k)
      {
        k = j;
        if (AppPanel.g(this.vVs)[i] != 0)
        {
          if (j == paramInt)
          {
            AppMethodBeat.o(27748);
            return i;
          }
          k = j + 1;
        }
        i += 1;
      }
    }
    if ((paramInt >= AppPanel.f(this.vVs)) && (paramInt < AppPanel.h(this.vVs)))
    {
      AppMethodBeat.o(27748);
      return -2147483648;
    }
    AppMethodBeat.o(27748);
    return 2147483647;
  }
  
  public final void Mg(int paramInt)
  {
    AppMethodBeat.i(27749);
    if (paramInt == 0)
    {
      if (!this.vVs.vUY.vVw.value)
      {
        Toast.makeText(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131298262), 0).show();
        AppMethodBeat.o(27749);
        return;
      }
      AppPanel.a(this.vVs, true);
      AppMethodBeat.o(27749);
      return;
    }
    AppMethodBeat.o(27749);
  }
  
  public final void a(int paramInt, f paramf)
  {
    boolean bool2 = true;
    int i = 0;
    AppMethodBeat.i(27750);
    if (paramf != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.d("MicroMsg.AppPanel", "pos=%d, has appInfo = %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool1) });
      if ((paramf != null) && (com.tencent.mm.pluginsdk.model.app.g.n(paramf)))
      {
        localObject = paramf.field_appId;
        HashMap localHashMap = new HashMap();
        r.n(localHashMap);
        localHashMap.put(localObject, "1");
        r.m(localHashMap);
      }
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(27750);
        return;
      }
    }
    if (AppPanel.j(this.vVs) == null)
    {
      ab.e("MicroMsg.AppPanel", "infoList == null");
      AppMethodBeat.o(27750);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(10305, String.valueOf(AppPanel.j(this.vVs).size()));
    com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(10) });
    com.tencent.mm.kernel.g.RL().Ru().set(69121, "");
    AppPanel.k(this.vVs).bPt();
    AppMethodBeat.o(27750);
    return;
    Object localObject = paramf;
    if (paramf == null) {
      localObject = (f)AppPanel.l(this.vVs).get(f.vKX);
    }
    aw.aaz();
    paramInt = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue();
    aw.aaz();
    paramf = bo.P(((String)com.tencent.mm.model.c.Ru().get(ac.a.yEL, "")).split(";"));
    if (!paramf.contains(String.valueOf(paramInt)))
    {
      paramf.add(String.valueOf(paramInt));
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yEL, bo.d(paramf, ";"));
      this.vVs.refresh();
    }
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(80, Boolean.FALSE);
    AppPanel.k(this.vVs).d((f)localObject);
    AppMethodBeat.o(27750);
    return;
    if (!this.vVs.vUY.vVD.value)
    {
      Toast.makeText(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131298262), 0).show();
      AppMethodBeat.o(27750);
      return;
    }
    if (paramf == null)
    {
      ab.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
      AppMethodBeat.o(27750);
      return;
    }
    if ((paramf.dlw()) || (paramf.dlz()))
    {
      if (AppPanel.m(this.vVs) == null) {
        AppPanel.a(this.vVs, AppPanel.i(this.vVs).getSharedPreferences(ah.dsP(), 0));
      }
      if (AppPanel.m(this.vVs).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramf.field_appId, true)) {
        AppPanel.m(this.vVs).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramf.field_appId, false).commit();
      }
      if (paramf.dlz()) {
        com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(16), paramf.field_appId, Integer.valueOf(0) });
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(13), paramf.field_appId, Integer.valueOf(0) });
    }
    for (;;)
    {
      AppPanel.k(this.vVs).d(paramf);
      AppMethodBeat.o(27750);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(11), paramf.field_appId });
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(14) });
    paramf = AppPanel.k(this.vVs);
    if (this.vVs.vUY.vVM.value) {}
    for (paramInt = i;; paramInt = 2)
    {
      paramf.yR(paramInt);
      AppMethodBeat.o(27750);
      return;
    }
    if (!this.vVs.vUY.vVx.value)
    {
      Toast.makeText(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131298262), 0).show();
      AppMethodBeat.o(27750);
      return;
    }
    com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(4) });
    AppPanel.k(this.vVs).bPs();
    AppMethodBeat.o(27750);
    return;
    if (!this.vVs.vUY.vVN.value)
    {
      Toast.makeText(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131298262), 0).show();
      AppMethodBeat.o(27750);
      return;
    }
    if (paramf == null)
    {
      localObject = (f)AppPanel.l(this.vVs).get(f.vKZ);
      paramf = (f)localObject;
      if (localObject == null)
      {
        AppMethodBeat.o(27750);
        return;
      }
    }
    if ((paramf.dlw()) || (paramf.dlz()))
    {
      if (AppPanel.m(this.vVs) == null) {
        AppPanel.a(this.vVs, AppPanel.i(this.vVs).getSharedPreferences(ah.dsP(), 0));
      }
      if (AppPanel.m(this.vVs).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramf.field_appId, true)) {
        AppPanel.m(this.vVs).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramf.field_appId, false).commit();
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(13), paramf.field_appId, Integer.valueOf(0) });
      label1259:
      bool1 = com.tencent.mm.x.c.PJ().a(ac.a.yJi, ac.a.yJj);
      if (bool1) {
        com.tencent.mm.x.c.PJ().c(ac.a.yJi, ac.a.yJj);
      }
      aw.aaz();
      paramInt = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue();
      aw.aaz();
      paramf = bo.P(((String)com.tencent.mm.model.c.Ru().get(ac.a.yEM, "")).split(";"));
      if (paramf.contains(String.valueOf(paramInt))) {
        break label3127;
      }
      paramf.add(String.valueOf(paramInt));
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yEM, bo.d(paramf, ";"));
      bool1 = bool2;
    }
    label3127:
    for (;;)
    {
      if (bool1) {
        this.vVs.refresh();
      }
      AppPanel.k(this.vVs).bPx();
      AppMethodBeat.o(27750);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(11), paramf.field_appId });
      break label1259;
      if ((!this.vVs.vUY.vVJ.value) || (!this.vVs.vUY.vVK.value))
      {
        Toast.makeText(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131298262), 0).show();
        AppMethodBeat.o(27750);
        return;
      }
      aw.aaz();
      if (((Boolean)com.tencent.mm.model.c.Ru().get(290817, Boolean.TRUE)).booleanValue())
      {
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(290817, Boolean.FALSE);
        this.vVs.refresh();
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(3) });
      AppPanel.k(this.vVs).bPr();
      AppMethodBeat.o(27750);
      return;
      if (!this.vVs.vUY.vVB.value)
      {
        Toast.makeText(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131298262), 0).show();
        AppMethodBeat.o(27750);
        return;
      }
      aw.aaz();
      if (((Boolean)com.tencent.mm.model.c.Ru().get(327744, Boolean.TRUE)).booleanValue())
      {
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(327744, Boolean.FALSE);
        this.vVs.refresh();
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(12) });
      AppPanel.k(this.vVs).bPv();
      AppMethodBeat.o(27750);
      return;
      if (!this.vVs.vUY.vVw.value)
      {
        Toast.makeText(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131298262), 0).show();
        AppMethodBeat.o(27750);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(1) });
      AppPanel.a(this.vVs, false);
      AppMethodBeat.o(27750);
      return;
      if (!this.vVs.vUY.vVz.value)
      {
        Toast.makeText(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131298262), 0).show();
        AppMethodBeat.o(27750);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(8) });
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(54, Boolean.FALSE);
      if (AppPanel.k(this.vVs) == null) {
        break;
      }
      paramf = new tl();
      paramf.cJT.cJV = true;
      com.tencent.mm.sdk.b.a.ymk.l(paramf);
      paramf = paramf.cJU.cJX;
      if (!bo.isNullOrNil(paramf))
      {
        ab.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramf)));
        com.tencent.mm.ui.base.h.d(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131304232), "", AppPanel.i(this.vVs).getString(2131297018), AppPanel.i(this.vVs).getString(2131296888), new AppPanel.4.1(this), new AppPanel.4.2(this));
        AppMethodBeat.o(27750);
        return;
      }
      AppPanel.k(this.vVs).bPo();
      AppMethodBeat.o(27750);
      return;
      if (!this.vVs.vUY.vVF.value)
      {
        Toast.makeText(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131298262), 0).show();
        AppMethodBeat.o(27750);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(7) });
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(62, Boolean.FALSE);
      paramf = new tl();
      paramf.cJT.cJV = true;
      com.tencent.mm.sdk.b.a.ymk.l(paramf);
      paramf = paramf.cJU.cJX;
      if (!bo.isNullOrNil(paramf))
      {
        ab.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramf)));
        com.tencent.mm.ui.base.h.d(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131304232), "", AppPanel.i(this.vVs).getString(2131297018), AppPanel.i(this.vVs).getString(2131296888), new AppPanel.4.3(this), new AppPanel.4.4(this));
        AppMethodBeat.o(27750);
        return;
      }
      AppPanel.k(this.vVs).bPp();
      AppMethodBeat.o(27750);
      return;
      if (AppPanel.k(this.vVs) == null) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(6) });
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(67, Boolean.FALSE);
      AppPanel.k(this.vVs).bPq();
      AppMethodBeat.o(27750);
      return;
      com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(9) });
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(73, Boolean.FALSE);
      AppPanel.n(this.vVs).dnZ();
      AppMethodBeat.o(27750);
      return;
      if (!this.vVs.vUY.vVy.value)
      {
        Toast.makeText(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131298262), 0).show();
        AppMethodBeat.o(27750);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(5) });
      if (AppPanel.k(this.vVs) == null) {
        break;
      }
      AppPanel.k(this.vVs).bPu();
      AppMethodBeat.o(27750);
      return;
      if (!this.vVs.vUY.vVL.value)
      {
        Toast.makeText(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131298262), 0).show();
        AppMethodBeat.o(27750);
        return;
      }
      if (AppPanel.k(this.vVs) != null) {
        AppPanel.k(this.vVs).bPw();
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(15) });
      aw.aaz();
      bool1 = ((Boolean)com.tencent.mm.model.c.Ru().get(208899, Boolean.FALSE)).booleanValue();
      aw.aaz();
      bool2 = ((Boolean)com.tencent.mm.model.c.Ru().get(208913, Boolean.FALSE)).booleanValue();
      if (bool1)
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(11594, new Object[] { Integer.valueOf(3) });
        AppMethodBeat.o(27750);
        return;
      }
      if (!bool2) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(11594, new Object[] { Integer.valueOf(4) });
      AppMethodBeat.o(27750);
      return;
      if (AppPanel.k(this.vVs) == null) {
        break;
      }
      AppPanel.k(this.vVs).bPy();
      AppMethodBeat.o(27750);
      return;
      if (!this.vVs.vUY.vVP.value)
      {
        Toast.makeText(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131298262), 0).show();
        AppMethodBeat.o(27750);
        return;
      }
      AppPanel.k(this.vVs).bPz();
      AppMethodBeat.o(27750);
      return;
      if (AppPanel.k(this.vVs) == null) {
        break;
      }
      if (paramf == null)
      {
        localObject = (f)AppPanel.l(this.vVs).get(f.vLa);
        paramf = (f)localObject;
        if (localObject == null)
        {
          ab.i("MicroMsg.AppPanel", "empty info");
          AppMethodBeat.o(27750);
          return;
        }
      }
      if ((paramf.dlw()) || (paramf.dlz()))
      {
        if (AppPanel.m(this.vVs) == null) {
          AppPanel.a(this.vVs, AppPanel.i(this.vVs).getSharedPreferences(ah.dsP(), 0));
        }
        if (AppPanel.m(this.vVs).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramf.field_appId, true)) {
          AppPanel.m(this.vVs).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramf.field_appId, false).commit();
        }
      }
      AppPanel.k(this.vVs).bPA();
      AppMethodBeat.o(27750);
      return;
      if (!this.vVs.vUY.vVR.value)
      {
        Toast.makeText(AppPanel.i(this.vVs), AppPanel.i(this.vVs).getString(2131298262), 0).show();
        AppMethodBeat.o(27750);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(10923, new Object[] { Integer.valueOf(17) });
      if (AppPanel.k(this.vVs) == null) {
        break;
      }
      AppPanel.k(this.vVs).bPB();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel.4
 * JD-Core Version:    0.7.0.1
 */