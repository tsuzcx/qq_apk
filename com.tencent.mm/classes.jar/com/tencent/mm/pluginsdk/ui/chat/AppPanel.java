package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vj.b;
import com.tencent.mm.g.b.a.bl;
import com.tencent.mm.g.b.a.bm;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.a.f;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.MMFlipper.a;
import com.tencent.mm.ui.base.MMFlipper.b;
import com.tencent.mm.ui.base.MMFlipper.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel
  extends LinearLayout
{
  private static boolean CaC = false;
  private static int vVL = 215;
  private static int vVM = 158;
  private int BZP;
  private int BZS;
  private int CaA;
  private AppGrid.b CaB;
  private boolean CaD;
  private int CaE;
  private final boolean[] Cad;
  private a Cae;
  private b Caf;
  private ChatFooter.b Cag;
  private List<AppGrid> Cah;
  private int Cai;
  public int Caj;
  private int Cak;
  public a Cal;
  private int Cam;
  private int Can;
  private int Cao;
  private boolean Cap;
  private boolean Caq;
  private boolean Car;
  private boolean Cas;
  boolean Cat;
  boolean Cau;
  boolean Cav;
  boolean Caw;
  private Map<String, com.tencent.mm.pluginsdk.model.app.g> Cax;
  private boolean Cay;
  private final int Caz;
  Context context;
  private boolean csX;
  private List<com.tencent.mm.pluginsdk.model.app.g> hND;
  private int rwX;
  private SharedPreferences sp;
  private boolean vWa;
  private int vWb;
  private int vWc;
  public MMFlipper vWd;
  private MMDotView vWe;
  
  public AppPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31459);
    this.Cad = new boolean[20];
    this.vWa = false;
    this.BZS = 20;
    this.rwX = this.BZS;
    this.Caj = 0;
    this.Cak = -1;
    this.csX = false;
    this.Cam = 0;
    this.Can = 0;
    this.Cao = 0;
    this.Cap = false;
    this.Caq = false;
    this.Car = false;
    this.Cas = false;
    this.Cat = false;
    this.Cau = false;
    this.Cav = false;
    this.Caw = false;
    this.Cax = null;
    this.Cay = true;
    this.hND = new LinkedList();
    this.Caz = 2;
    this.CaA = -1;
    this.CaB = new AppGrid.b()
    {
      public final int UW(int paramAnonymousInt)
      {
        AppMethodBeat.i(204873);
        if (paramAnonymousInt < AppPanel.f(AppPanel.this))
        {
          int m = AppPanel.j(AppPanel.this).length;
          int i = 0;
          int k;
          for (int j = 0; i < m; j = k)
          {
            k = j;
            if (AppPanel.j(AppPanel.this)[i] != 0)
            {
              if (j == paramAnonymousInt)
              {
                AppMethodBeat.o(204873);
                return i;
              }
              k = j + 1;
            }
            i += 1;
          }
        }
        if ((paramAnonymousInt >= AppPanel.f(AppPanel.this)) && (paramAnonymousInt < AppPanel.k(AppPanel.this)))
        {
          AppMethodBeat.o(204873);
          return -2147483648;
        }
        AppMethodBeat.o(204873);
        return 2147483647;
      }
      
      public final void UX(int paramAnonymousInt)
      {
        AppMethodBeat.i(204874);
        if (paramAnonymousInt == 0)
        {
          if (!AppPanel.this.Cal.CaJ.value)
          {
            Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(204874);
            return;
          }
          AppPanel.a(AppPanel.this, true);
          AppMethodBeat.o(204874);
          return;
        }
        AppMethodBeat.o(204874);
      }
      
      public final void a(int paramAnonymousInt, com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        int i = 0;
        AppMethodBeat.i(204875);
        boolean bool1;
        Object localObject;
        if (paramAnonymousg != null)
        {
          bool1 = true;
          ad.d("MicroMsg.AppPanel", "pos=%d, has appInfo = %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool1) });
          if ((paramAnonymousg != null) && (com.tencent.mm.pluginsdk.model.app.h.o(paramAnonymousg)))
          {
            localObject = paramAnonymousg.field_appId;
            HashMap localHashMap = new HashMap();
            u.q(localHashMap);
            localHashMap.put(localObject, "1");
            u.p(localHashMap);
          }
          AppPanel.d(AppPanel.this, AppPanel.m(AppPanel.this).getCurScreen());
          if (!(paramAnonymousg instanceof a.a)) {
            break label323;
          }
          paramAnonymousg = (a.a)paramAnonymousg;
          ad.i("MicroMsg.AppPanel", "jump_type:%s", new Object[] { Integer.valueOf(paramAnonymousg.uaQ) });
          if (paramAnonymousg.uaQ != 1) {
            break label296;
          }
          localObject = new f();
          ((f)localObject).username = paramAnonymousg.Cbk;
          ((f)localObject).version = paramAnonymousg.Cbl;
        }
        for (;;)
        {
          try
          {
            ((f)localObject).gXn = Integer.parseInt(paramAnonymousg.Cbn);
            ((f)localObject).iJb = paramAnonymousg.Cbm;
            ((f)localObject).scene = 1156;
            ((f)localObject).iJl = paramAnonymousg.iJl;
            ((n)com.tencent.mm.kernel.g.ab(n.class)).a(AppPanel.this.getContext(), (f)localObject);
            localObject = new bl();
            ((bl)localObject).dFd = 2L;
            ((bl)localObject).dPK = 0L;
            ((bl)localObject).im(paramAnonymousg.Cbi);
            ((bl)localObject).aBj();
            AppMethodBeat.o(204875);
            return;
            bool1 = false;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            ((f)localObject).gXn = 0;
            continue;
          }
          label296:
          if (paramAnonymousg.uaQ == 2) {
            com.tencent.mm.plugin.account.a.b.a.b(AppPanel.l(AppPanel.this), paramAnonymousg.kXu, 0, true);
          }
        }
        label323:
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(204875);
          return;
          if (AppPanel.g(AppPanel.this) == null)
          {
            ad.e("MicroMsg.AppPanel", "infoList == null");
            AppMethodBeat.o(204875);
            return;
          }
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(10305, String.valueOf(AppPanel.g(AppPanel.this).size()));
          com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(10) });
          com.tencent.mm.kernel.g.afB().afk().set(69121, "");
          AppPanel.n(AppPanel.this).cOk();
          AppMethodBeat.o(204875);
          return;
          localObject = paramAnonymousg;
          if (paramAnonymousg == null) {
            localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.o(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.BPE);
          }
          az.arV();
          paramAnonymousInt = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.Fla, Integer.valueOf(0))).intValue();
          az.arV();
          paramAnonymousg = bt.S(((String)com.tencent.mm.model.c.afk().get(ae.a.Fnr, "")).split(";"));
          if (!paramAnonymousg.contains(String.valueOf(paramAnonymousInt)))
          {
            paramAnonymousg.add(String.valueOf(paramAnonymousInt));
            az.arV();
            com.tencent.mm.model.c.afk().set(ae.a.Fnr, bt.n(paramAnonymousg, ";"));
            AppPanel.this.refresh();
          }
          az.arV();
          com.tencent.mm.model.c.afk().set(80, Boolean.FALSE);
          AppPanel.n(AppPanel.this).d((com.tencent.mm.pluginsdk.model.app.g)localObject);
          AppMethodBeat.o(204875);
          return;
          if (!AppPanel.this.Cal.CaQ.value)
          {
            Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(204875);
            return;
          }
          if (paramAnonymousg == null)
          {
            ad.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
            AppMethodBeat.o(204875);
            return;
          }
          if ((paramAnonymousg.evD()) || (paramAnonymousg.evG()))
          {
            if (AppPanel.p(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.l(AppPanel.this).getSharedPreferences(aj.eFD(), 0));
            }
            if (AppPanel.p(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
              AppPanel.p(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
            }
            if (paramAnonymousg.evG()) {
              com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(16), paramAnonymousg.field_appId, Integer.valueOf(0) });
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(13), paramAnonymousg.field_appId, Integer.valueOf(0) });
          }
          for (;;)
          {
            AppPanel.n(AppPanel.this).d(paramAnonymousg);
            AppMethodBeat.o(204875);
            return;
            com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(11), paramAnonymousg.field_appId });
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(14) });
          paramAnonymousg = AppPanel.n(AppPanel.this);
          if (AppPanel.this.Cal.CaZ.value) {}
          for (paramAnonymousInt = i;; paramAnonymousInt = 2)
          {
            paramAnonymousg.Gr(paramAnonymousInt);
            AppMethodBeat.o(204875);
            return;
          }
          if (!AppPanel.this.Cal.CaK.value)
          {
            Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(204875);
            return;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(4) });
          AppPanel.n(AppPanel.this).cOj();
          AppMethodBeat.o(204875);
          return;
          if (!AppPanel.this.Cal.Cba.value)
          {
            Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(204875);
            return;
          }
          if (paramAnonymousg == null)
          {
            localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.o(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.BPG);
            paramAnonymousg = (com.tencent.mm.pluginsdk.model.app.g)localObject;
            if (localObject == null)
            {
              AppMethodBeat.o(204875);
              return;
            }
          }
          if ((paramAnonymousg.evD()) || (paramAnonymousg.evG()))
          {
            if (AppPanel.p(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.l(AppPanel.this).getSharedPreferences(aj.eFD(), 0));
            }
            if (AppPanel.p(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
              AppPanel.p(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(13), paramAnonymousg.field_appId, Integer.valueOf(0) });
          }
          for (;;)
          {
            az.arV();
            paramAnonymousInt = ((Integer)com.tencent.mm.model.c.afk().get(ae.a.Fla, Integer.valueOf(0))).intValue();
            az.arV();
            paramAnonymousg = bt.S(((String)com.tencent.mm.model.c.afk().get(ae.a.Fns, "")).split(";"));
            if (!paramAnonymousg.contains(String.valueOf(paramAnonymousInt)))
            {
              paramAnonymousg.add(String.valueOf(paramAnonymousInt));
              az.arV();
              com.tencent.mm.model.c.afk().set(ae.a.Fns, bt.n(paramAnonymousg, ";"));
              AppPanel.this.refresh();
            }
            AppPanel.n(AppPanel.this).cOo();
            AppMethodBeat.o(204875);
            return;
            com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(11), paramAnonymousg.field_appId });
          }
          if ((!AppPanel.this.Cal.CaW.value) || (!AppPanel.this.Cal.CaX.value))
          {
            Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(204875);
            return;
          }
          az.arV();
          if (((Boolean)com.tencent.mm.model.c.afk().get(290817, Boolean.TRUE)).booleanValue())
          {
            az.arV();
            com.tencent.mm.model.c.afk().set(290817, Boolean.FALSE);
            AppPanel.this.refresh();
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(3) });
          AppPanel.n(AppPanel.this).cOi();
          AppMethodBeat.o(204875);
          return;
          if (!AppPanel.this.Cal.CaO.value)
          {
            Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(204875);
            return;
          }
          az.arV();
          if (((Boolean)com.tencent.mm.model.c.afk().get(327744, Boolean.TRUE)).booleanValue())
          {
            az.arV();
            com.tencent.mm.model.c.afk().set(327744, Boolean.FALSE);
            AppPanel.this.refresh();
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(12) });
          AppPanel.n(AppPanel.this).cOm();
          AppMethodBeat.o(204875);
          return;
          if (!AppPanel.this.Cal.CaJ.value)
          {
            Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(204875);
            return;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(1) });
          AppPanel.a(AppPanel.this, false);
          AppMethodBeat.o(204875);
          return;
          if (!AppPanel.this.Cal.CaM.value)
          {
            Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(204875);
            return;
          }
          com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(8) });
          az.arV();
          com.tencent.mm.model.c.afk().set(54, Boolean.FALSE);
          if (AppPanel.n(AppPanel.this) != null)
          {
            paramAnonymousg = new vj();
            paramAnonymousg.dAP.dAR = true;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousg);
            paramAnonymousg = paramAnonymousg.dAQ.dAT;
            if (!bt.isNullOrNil(paramAnonymousg))
            {
              ad.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramAnonymousg)));
              com.tencent.mm.ui.base.h.d(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131764350), "", AppPanel.l(AppPanel.this).getString(2131755835), AppPanel.l(AppPanel.this).getString(2131755691), new AppPanel.5.1(this), new AppPanel.5.2(this));
              AppMethodBeat.o(204875);
              return;
            }
            AppPanel.n(AppPanel.this).cOf();
            AppMethodBeat.o(204875);
            return;
            if (!AppPanel.this.Cal.CaS.value)
            {
              Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
              AppMethodBeat.o(204875);
              return;
            }
            com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(7) });
            az.arV();
            com.tencent.mm.model.c.afk().set(62, Boolean.FALSE);
            paramAnonymousg = new vj();
            paramAnonymousg.dAP.dAR = true;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousg);
            paramAnonymousg = paramAnonymousg.dAQ.dAT;
            if (!bt.isNullOrNil(paramAnonymousg))
            {
              ad.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramAnonymousg)));
              com.tencent.mm.ui.base.h.d(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131764350), "", AppPanel.l(AppPanel.this).getString(2131755835), AppPanel.l(AppPanel.this).getString(2131755691), new AppPanel.5.3(this), new AppPanel.5.4(this));
              AppMethodBeat.o(204875);
              return;
            }
            AppPanel.n(AppPanel.this).cOg();
            AppMethodBeat.o(204875);
            return;
            if (AppPanel.n(AppPanel.this) != null)
            {
              com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(6) });
              az.arV();
              com.tencent.mm.model.c.afk().set(67, Boolean.FALSE);
              AppPanel.n(AppPanel.this).cOh();
              AppMethodBeat.o(204875);
              return;
              com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(9) });
              az.arV();
              com.tencent.mm.model.c.afk().set(73, Boolean.FALSE);
              AppPanel.q(AppPanel.this).eyM();
              AppMethodBeat.o(204875);
              return;
              if (!AppPanel.this.Cal.CaL.value)
              {
                Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
                AppMethodBeat.o(204875);
                return;
              }
              com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(5) });
              if (AppPanel.n(AppPanel.this) != null)
              {
                AppPanel.n(AppPanel.this).cOl();
                AppMethodBeat.o(204875);
                return;
                if (!AppPanel.this.Cal.CaY.value)
                {
                  Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
                  AppMethodBeat.o(204875);
                  return;
                }
                if (AppPanel.n(AppPanel.this) != null) {
                  AppPanel.n(AppPanel.this).cOn();
                }
                com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(15) });
                az.arV();
                bool1 = ((Boolean)com.tencent.mm.model.c.afk().get(208899, Boolean.FALSE)).booleanValue();
                az.arV();
                boolean bool2 = ((Boolean)com.tencent.mm.model.c.afk().get(208913, Boolean.FALSE)).booleanValue();
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.h.vKh.f(11594, new Object[] { Integer.valueOf(3) });
                  AppMethodBeat.o(204875);
                  return;
                }
                if (bool2)
                {
                  com.tencent.mm.plugin.report.service.h.vKh.f(11594, new Object[] { Integer.valueOf(4) });
                  AppMethodBeat.o(204875);
                  return;
                  if (AppPanel.n(AppPanel.this) != null)
                  {
                    AppPanel.n(AppPanel.this).cOp();
                    AppMethodBeat.o(204875);
                    return;
                    if (!AppPanel.this.Cal.Cbc.value)
                    {
                      Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
                      AppMethodBeat.o(204875);
                      return;
                    }
                    AppPanel.n(AppPanel.this).cOq();
                    AppMethodBeat.o(204875);
                    return;
                    if (AppPanel.n(AppPanel.this) != null)
                    {
                      if (paramAnonymousg == null)
                      {
                        localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.o(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.BPH);
                        paramAnonymousg = (com.tencent.mm.pluginsdk.model.app.g)localObject;
                        if (localObject == null)
                        {
                          ad.i("MicroMsg.AppPanel", "empty info");
                          AppMethodBeat.o(204875);
                          return;
                        }
                      }
                      if ((paramAnonymousg.evD()) || (paramAnonymousg.evG()))
                      {
                        if (AppPanel.p(AppPanel.this) == null) {
                          AppPanel.a(AppPanel.this, AppPanel.l(AppPanel.this).getSharedPreferences(aj.eFD(), 0));
                        }
                        if (AppPanel.p(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
                          AppPanel.p(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
                        }
                      }
                      AppPanel.n(AppPanel.this).cOr();
                      AppMethodBeat.o(204875);
                      return;
                      if (!AppPanel.this.Cal.Cbe.value)
                      {
                        Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
                        AppMethodBeat.o(204875);
                        return;
                      }
                      com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(17) });
                      if (AppPanel.n(AppPanel.this) != null)
                      {
                        AppPanel.n(AppPanel.this).cOs();
                        AppMethodBeat.o(204875);
                        return;
                        if (!AppPanel.this.Cal.Cbf.value)
                        {
                          Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
                          AppMethodBeat.o(204875);
                          return;
                        }
                        if (AppPanel.n(AppPanel.this) != null)
                        {
                          AppPanel.n(AppPanel.this).cOt();
                          AppMethodBeat.o(204875);
                          return;
                          if (!AppPanel.this.Cal.Cbg.value)
                          {
                            Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
                            AppMethodBeat.o(204875);
                            return;
                          }
                          com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(19) });
                          if (AppPanel.n(AppPanel.this) != null)
                          {
                            AppPanel.n(AppPanel.this).cOu();
                            AppMethodBeat.o(204875);
                            return;
                            if (!AppPanel.this.Cal.Lwz.value)
                            {
                              Toast.makeText(AppPanel.l(AppPanel.this), AppPanel.l(AppPanel.this).getString(2131757253), 0).show();
                              AppMethodBeat.o(204875);
                              return;
                            }
                            com.tencent.mm.plugin.report.service.h.vKh.f(10923, new Object[] { Integer.valueOf(20) });
                            if (AppPanel.n(AppPanel.this) != null)
                            {
                              AppPanel.n(AppPanel.this).fXT();
                              com.tencent.mm.live.d.a.fPh();
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    };
    this.CaD = true;
    this.CaE = -1;
    this.context = paramContext;
    AppMethodBeat.o(31459);
  }
  
  private int UY(int paramInt)
  {
    int i = paramInt / this.BZP;
    if (paramInt % this.BZP > 0) {}
    for (paramInt = i;; paramInt = i - 1)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      return i;
    }
  }
  
  private void dmG()
  {
    AppMethodBeat.i(31479);
    ad.i("MicroMsg.AppPanel", "init app grid: %s, %s", new Object[] { Integer.valueOf(this.vWb), Integer.valueOf(this.vWc) });
    if ((this.vWb == 0) || (this.vWc == 0))
    {
      AppMethodBeat.o(31479);
      return;
    }
    if (this.Cak == -1) {
      this.vWd.setToScreen(this.Caj);
    }
    int i = BackwardSupportUtil.b.g(this.context, 82.0F);
    int m = BackwardSupportUtil.b.g(this.context, 90.0F);
    eyE();
    int j = 4;
    if (!this.Cay) {
      j = this.vWb / i;
    }
    int k = this.vWc / m;
    i = k;
    if (k > 2) {
      i = 2;
    }
    m = (this.vWc - m * i) / (i + 1);
    ad.d("MicroMsg.AppPanel", "jacks spacing2 = %d", new Object[] { Integer.valueOf(m) });
    ad.d("MicroMsg.AppPanel", "in initAppGrid, gridWidth = %d, gridHeight = %d", new Object[] { Integer.valueOf(this.vWb), Integer.valueOf(this.vWc) });
    if (j == 0) {
      j = 1;
    }
    for (;;)
    {
      k = i;
      if (i == 0) {
        k = 1;
      }
      this.Cai = k;
      this.BZP = (j * k);
      int n;
      if (this.Cal.CaQ.value)
      {
        this.rwX = (this.BZS + this.hND.size());
        this.rwX += this.Cal.eyQ();
        n = (int)Math.ceil(this.rwX / this.BZP);
        ad.i("MicroMsg.AppPanel", "in initAppGrid, totalItemCount = %d, itemsPerPage = %d, pageCount = %d visibleLocalAppCount = %d infoList = %d", new Object[] { Integer.valueOf(this.rwX), Integer.valueOf(this.BZP), Integer.valueOf(n), Integer.valueOf(this.BZS), Integer.valueOf(this.hND.size()) });
        if (this.CaA != n) {
          break label883;
        }
        ad.i("MicroMsg.AppPanel", "mLastPageCount == pageCount! [%s:%s]", new Object[] { Integer.valueOf(this.CaA), Integer.valueOf(n) });
      }
      label883:
      for (i = 0;; i = 1)
      {
        if (i != 0)
        {
          this.Cah = new ArrayList();
          this.vWd.removeAllViews();
        }
        long l2 = System.currentTimeMillis();
        long l1 = 0L;
        if (n > 10)
        {
          com.tencent.mm.plugin.report.service.h.vKh.f(16776, new Object[] { Integer.valueOf(0), Integer.valueOf(1) });
          com.tencent.mm.plugin.report.service.h.vKh.m(999L, 1L, 1L);
        }
        com.tencent.e.i.b local4 = new com.tencent.e.i.b()
        {
          public final String getKey()
          {
            return "initAppGrid";
          }
          
          public final void run()
          {
            AppMethodBeat.i(204868);
            ad.e("MicroMsg.AppPanel", "initAppGrid ANR!");
            com.tencent.mm.plugin.report.service.h.vKh.m(999L, 2L, 1L);
            AppMethodBeat.o(204868);
          }
        };
        com.tencent.e.h.Iye.q(local4, 5000L);
        k = 0;
        if (k < n)
        {
          if (k >= n)
          {
            ad.e("MicroMsg.AppPanel", "my god! you see a ghost! %s", new Object[] { Integer.valueOf(n) });
            com.tencent.mm.plugin.report.service.h.vKh.m(999L, 0L, 1L);
            com.tencent.mm.plugin.report.service.h.vKh.f(16776, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
          }
        }
        else
        {
          local4.cancel();
          ad.i("MicroMsg.AppPanel", "[initAppGrid] cost:%sms inflateCost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l2), Long.valueOf(l1) });
          localObject = this.Cah.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((AppGrid)((Iterator)localObject).next()).setOnAppSelectedListener(this.CaB);
          }
          this.rwX = this.BZS;
          break;
        }
        long l3 = System.currentTimeMillis();
        if ((i == 0) && (this.Cah.size() > k) && (this.Cah.get(k) != null)) {}
        for (Object localObject = (AppGrid)this.Cah.get(k);; localObject = (AppGrid)inflate(this.context, 2131493082, null))
        {
          ad.i("MicroMsg.AppPanel", "[initAppGrid] i:%s cost:%sms", new Object[] { Integer.valueOf(k), Long.valueOf(System.currentTimeMillis() - l2) });
          l1 += System.currentTimeMillis() - l3;
          ((AppGrid)localObject).a(this.hND, this.Cax, this.Cal.getAppPanelUnCertainEnterArrayList());
          ((AppGrid)localObject).b(k, this.rwX, this.BZP, n, j, this.BZS);
          ((AppGrid)localObject).UV(m);
          if (i != 0)
          {
            this.vWd.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
            this.Cah.add(localObject);
          }
          k += 1;
          break;
        }
        dmH();
        this.CaA = n;
        requestLayout();
        eyG();
        AppMethodBeat.o(31479);
        return;
      }
    }
  }
  
  private void dmH()
  {
    AppMethodBeat.i(31480);
    if (this.Cah.size() <= 1)
    {
      this.vWe.setVisibility(4);
      AppMethodBeat.o(31480);
      return;
    }
    this.vWe.setVisibility(0);
    this.vWe.setDotCount(this.Cah.size());
    int i = this.vWd.getCurScreen();
    this.vWd.setToScreen(i);
    this.vWe.setSelectedDot(i);
    AppMethodBeat.o(31480);
  }
  
  private void eyF()
  {
    AppMethodBeat.i(31477);
    ad.d("MicroMsg.AppPanel", "AppPanel initFlipper");
    this.CaA = -1;
    this.vWd.removeAllViews();
    this.vWd.setOnMeasureListener(new MMFlipper.a()
    {
      public final void gQ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(31448);
        ad.i("MicroMsg.AppPanel", "onMeasure width:" + paramAnonymousInt1 + " height:" + paramAnonymousInt2 + " isMeasured:" + AppPanel.a(AppPanel.this));
        if ((AppPanel.a(AppPanel.this)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
        {
          if ((paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0)) {
            ad.d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
          }
          AppMethodBeat.o(31448);
          return;
        }
        if (AppPanel.b(AppPanel.this) == 2) {
          ad.d("MicroMsg.AppPanel", "landspace");
        }
        for (;;)
        {
          AppPanel.c(AppPanel.this);
          AppPanel.a(AppPanel.this, paramAnonymousInt2);
          AppPanel.b(AppPanel.this, paramAnonymousInt1);
          AppPanel.d(AppPanel.this);
          AppMethodBeat.o(31448);
          return;
          ad.d("MicroMsg.AppPanel", "portrait");
        }
      }
    });
    this.vWd.setOnFlipperViewShowedListener(new MMFlipper.d()
    {
      public final void aik(int paramAnonymousInt)
      {
        AppMethodBeat.i(204866);
        ad.i("MicroMsg.AppPanel", "viewpage reshow %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt == 1) {
          com.tencent.mm.live.d.e.fPY();
        }
        AppMethodBeat.o(204866);
      }
    });
    this.vWd.setOnScreenChangedListener(new MMFlipper.b()
    {
      public final void u(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(204867);
        AppPanel.e(AppPanel.this).setSelectedDot(paramAnonymousInt2);
        Object localObject2;
        if ((AppPanel.this.getVisibility() == 0) && (paramAnonymousInt1 != -1) && (paramAnonymousInt1 != paramAnonymousInt2) && (paramAnonymousBoolean))
        {
          if (AppPanel.this.Cal.CaQ.value) {}
          for (int i = AppPanel.f(AppPanel.this) + AppPanel.g(AppPanel.this).size();; i = AppPanel.f(AppPanel.this))
          {
            localObject1 = new bl();
            ((bl)localObject1).dFd = 1L;
            ((bl)localObject1).dPK = 0L;
            localObject2 = new StringBuilder();
            int j = 0;
            while (j < AppPanel.this.getAppPanelUnCertainEnterArrayList().size())
            {
              AppPanel localAppPanel = AppPanel.this;
              if (paramAnonymousInt1 == AppPanel.c(localAppPanel, AppPanel.h(localAppPanel) + i + 1)) {
                ((StringBuilder)localObject2).append(((a.a)AppPanel.this.getAppPanelUnCertainEnterArrayList().get(j)).Cbi).append("|");
              }
              j += 1;
            }
          }
          ((bl)localObject1).im(((StringBuilder)localObject2).toString());
          ((bl)localObject1).aBj();
          paramAnonymousInt1 = AppPanel.this.getPosPage$134621();
          if ((paramAnonymousInt1 != -1) && (paramAnonymousInt1 == AppPanel.this.getCurScreen())) {
            if (AppPanel.i(AppPanel.this) != null) {
              break label325;
            }
          }
        }
        label325:
        for (Object localObject1 = "";; localObject1 = AppPanel.i(AppPanel.this).getTalkerUserName())
        {
          localObject2 = new bm();
          ((bm)localObject2).in((String)localObject1);
          ((bm)localObject2).dPK = 0L;
          ((bm)localObject2).io("19");
          ((bm)localObject2).aBj();
          ad.i("MicroMsg.AppPanel", "scroll to show page %s", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          if (paramAnonymousInt2 == 1) {
            com.tencent.mm.live.d.e.fPY();
          }
          AppMethodBeat.o(204867);
          return;
        }
      }
    });
    eyJ();
    AppMethodBeat.o(31477);
  }
  
  private void eyG()
  {
    AppMethodBeat.i(163206);
    if (this.Cak == -1)
    {
      AppMethodBeat.o(163206);
      return;
    }
    if (this.Cal.CaQ.value) {}
    bl localbl;
    StringBuilder localStringBuilder;
    for (int i = this.BZS + this.hND.size();; i = this.BZS)
    {
      this.Caj = UY(this.Cak + i + 1);
      this.vWd.setToScreen(this.Caj);
      this.Cak = -1;
      localbl = new bl();
      localbl.dFd = 1L;
      localbl.dPK = 1L;
      localStringBuilder = new StringBuilder();
      int j = 0;
      while (j < getAppPanelUnCertainEnterArrayList().size())
      {
        if (this.Caj == UY(this.Cak + i + 1)) {
          localStringBuilder.append(((a.a)getAppPanelUnCertainEnterArrayList().get(j)).Cbi).append("|");
        }
        j += 1;
      }
    }
    localbl.im(localStringBuilder.toString());
    localbl.aBj();
    AppMethodBeat.o(163206);
  }
  
  private void eyH()
  {
    AppMethodBeat.i(31482);
    ad.i("MicroMsg.AppPanel", "[dealOrientationChange]");
    this.vWa = false;
    this.vWd.setToScreen(0);
    eyF();
    requestLayout();
    AppMethodBeat.o(31482);
  }
  
  private void eyJ()
  {
    AppMethodBeat.i(31484);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.CaD)
    {
      if (getScreenOrientation() != 2) {
        break label79;
      }
      ad.d("MicroMsg.AppPanel", "initFlipper, landscape");
      localView = findViewById(2131296867);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = BackwardSupportUtil.b.g(this.context, vVM);
      localView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.CaD = false;
      AppMethodBeat.o(31484);
      return;
      label79:
      ad.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", new Object[] { Integer.valueOf(vVL) });
      localView = findViewById(2131296867);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = getPortHeightPX();
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private boolean eyK()
  {
    AppMethodBeat.i(31487);
    if (this.Caw)
    {
      AppMethodBeat.o(31487);
      return false;
    }
    com.tencent.mm.plugin.card.c.b localb = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.card.c.b.class);
    if (localb != null)
    {
      if ((localb.bJs()) && (localb.bJv() > 0))
      {
        AppMethodBeat.o(31487);
        return true;
      }
      AppMethodBeat.o(31487);
      return false;
    }
    AppMethodBeat.o(31487);
    return false;
  }
  
  private void gH(List<com.tencent.mm.pluginsdk.model.app.g> paramList)
  {
    AppMethodBeat.i(31462);
    boolean bool1 = this.Cap;
    this.Cap = false;
    boolean bool2 = this.Caq;
    boolean bool3 = this.Car;
    boolean bool4 = this.Cas;
    this.Caq = false;
    this.Car = false;
    this.Cas = false;
    int j = com.tencent.mm.pluginsdk.model.app.h.Un(this.Cao);
    int k = this.Cao;
    if (paramList != null) {}
    for (int i = paramList.size();; i = -1)
    {
      ad.i("MicroMsg.AppPanel", "serviceCount, %d, %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      this.Cax = new HashMap();
      if (j <= 0) {
        break label485;
      }
      if ((paramList == null) || (paramList.size() <= 0)) {
        break;
      }
      for (i = 0; i < paramList.size(); i = j + 1)
      {
        com.tencent.mm.pluginsdk.model.app.g localg = (com.tencent.mm.pluginsdk.model.app.g)paramList.get(i);
        j = i;
        if (localg != null)
        {
          j = i;
          if (localg.field_appId != null)
          {
            j = i;
            if (localg.evD())
            {
              if (!localg.evF()) {
                this.Cap = true;
              }
              j = i;
              if (com.tencent.mm.pluginsdk.model.app.g.BPE.equals(localg.field_appId))
              {
                this.Cax.put(com.tencent.mm.pluginsdk.model.app.g.BPE, localg);
                ad.i("MicroMsg.AppPanel", "remittance: %s, %s", new Object[] { Boolean.valueOf(this.Cau), Boolean.valueOf(this.Caq) });
                if (!this.Cau) {
                  this.Caq = true;
                }
                paramList.remove(i);
                j = i - 1;
              }
              i = j;
              if (com.tencent.mm.pluginsdk.model.app.g.BPG.equals(localg.field_appId))
              {
                this.Cax.put(com.tencent.mm.pluginsdk.model.app.g.BPG, localg);
                ad.i("MicroMsg.AppPanel", "luckyMoney: %s, %s", new Object[] { Boolean.valueOf(this.Cat), Boolean.valueOf(this.Car) });
                if (!this.Cat) {
                  this.Car = true;
                }
                paramList.remove(j);
                i = j - 1;
              }
              j = i;
              if (com.tencent.mm.pluginsdk.model.app.g.BPH.equals(localg.field_appId))
              {
                this.Cax.put(com.tencent.mm.pluginsdk.model.app.g.BPH, localg);
                ad.i("MicroMsg.AppPanel", "aa: %s, %s", new Object[] { Boolean.valueOf(this.Cat), Boolean.valueOf(this.Car) });
                if (!this.Cav) {
                  this.Cas = true;
                }
                paramList.remove(i);
                j = i - 1;
              }
            }
          }
        }
      }
    }
    com.tencent.mm.plugin.report.service.h.vKh.dB(965, 36);
    label485:
    ad.i("MicroMsg.AppPanel", "hasService %b", new Object[] { Boolean.valueOf(this.Cap) });
    if ((bool1 != this.Cap) || (bool2 != this.Caq) || (bool3 != this.Car) || (bool4 != this.Cas))
    {
      this.Cal.uh(this.Cap);
      this.Cal.ui(this.Caq);
      this.Cal.ul(this.Car);
      this.Cal.um(this.Cas);
      eyE();
    }
    AppMethodBeat.o(31462);
  }
  
  private static void gI(List<com.tencent.mm.pluginsdk.model.app.g> paramList)
  {
    AppMethodBeat.i(31486);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(31486);
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      com.tencent.mm.pluginsdk.model.app.g localg = (com.tencent.mm.pluginsdk.model.app.g)paramList.get(i);
      if ((localg != null) && (com.tencent.mm.pluginsdk.model.app.g.BPF.equals(localg.field_appId)))
      {
        paramList.remove(localg);
        ad.i("MicroMsg.AppPanel", "do remove card");
        AppMethodBeat.o(31486);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(31486);
  }
  
  private int getPortHeightPX()
  {
    AppMethodBeat.i(31485);
    if (this.CaE > 0)
    {
      i = this.CaE;
      AppMethodBeat.o(31485);
      return i;
    }
    int i = BackwardSupportUtil.b.g(this.context, vVL);
    AppMethodBeat.o(31485);
    return i;
  }
  
  private int getScreenOrientation()
  {
    AppMethodBeat.i(31476);
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (localDisplay.getWidth() < localDisplay.getHeight()) {}
    for (int i = 1;; i = 2)
    {
      AppMethodBeat.o(31476);
      return i;
    }
  }
  
  public final void eyA()
  {
    AppMethodBeat.i(31473);
    this.Cal.CaY.value = false;
    eyE();
    AppMethodBeat.o(31473);
  }
  
  public final void eyB()
  {
    AppMethodBeat.i(31474);
    this.Cal.Cbe.value = false;
    eyE();
    AppMethodBeat.o(31474);
  }
  
  public final void eyC()
  {
    AppMethodBeat.i(185751);
    this.Cal.Cbf.value = false;
    eyE();
    AppMethodBeat.o(185751);
  }
  
  public final void eyD()
  {
    AppMethodBeat.i(191283);
    this.Cal.Cbg.value = false;
    eyE();
    AppMethodBeat.o(191283);
  }
  
  public final void eyE()
  {
    AppMethodBeat.i(31475);
    int j = this.Cad.length;
    int i = 0;
    while (i < j)
    {
      this.Cad[i] = true;
      i += 1;
    }
    if (!this.Cal.CaJ.value) {
      this.Cad[0] = false;
    }
    for (j = 1;; j = 0)
    {
      i = j;
      if (!this.Cal.CaI.value)
      {
        this.Cad[1] = false;
        i = j + 1;
      }
      j = i;
      if (!this.Cal.Cbe.value)
      {
        this.Cad[18] = false;
        j = i + 1;
      }
      i = j;
      if (!this.Cal.Cbf.value)
      {
        this.Cad[12] = false;
        i = j + 1;
      }
      j = i;
      if (!this.Cal.Lwz.value)
      {
        this.Cad[19] = false;
        j = i + 1;
      }
      i = j;
      if (!this.Cal.Cbg.value)
      {
        this.Cad[13] = false;
        i = j + 1;
      }
      if (this.Cal.CaW.value)
      {
        j = i;
        if (this.Cal.CaX.value) {}
      }
      else
      {
        this.Cad[6] = false;
        j = i + 1;
      }
      i = j;
      if (!this.Cal.CaO.value)
      {
        this.Cad[16] = false;
        i = j + 1;
      }
      j = i;
      if (!this.Cal.CaP.value)
      {
        ad.i("MicroMsg.AppPanel", "disable remittance");
        this.Cad[8] = false;
        j = i + 1;
      }
      i = j;
      if (!this.Cal.CaK.value)
      {
        this.Cad[14] = false;
        i = j + 1;
      }
      j = i;
      if (!this.Cal.CaY.value)
      {
        this.Cad[15] = false;
        j = i + 1;
      }
      i = j;
      if (!this.Cal.Cbb.value)
      {
        this.Cad[3] = false;
        i = j + 1;
      }
      j = i;
      if (!this.Cal.CaL.value)
      {
        this.Cad[11] = false;
        j = i + 1;
      }
      i = j;
      if (!this.Cal.CaR.value)
      {
        this.Cad[5] = false;
        i = j + 1;
      }
      if (this.Cal.CaT.value)
      {
        j = i;
        if (this.Cal.CaS.value) {}
      }
      else
      {
        this.Cad[4] = false;
        j = i + 1;
      }
      if (this.Cal.CaN.value)
      {
        i = j;
        if (this.Cal.CaM.value) {}
      }
      else
      {
        this.Cad[2] = false;
        i = j + 1;
      }
      if (this.Cal.CaV.value)
      {
        j = i;
        if (this.Cal.CaU.value) {}
      }
      else
      {
        this.Cad[10] = false;
        j = i + 1;
      }
      i = j;
      if (!this.Cal.Cba.value)
      {
        ad.i("MicroMsg.AppPanel", "disable lucky money");
        this.Cad[7] = false;
        i = j + 1;
      }
      j = i;
      if (!this.Cal.Cbc.value)
      {
        this.Cad[17] = false;
        j = i + 1;
      }
      this.Cad[9] = false;
      this.BZS = (20 - (j + 1));
      AppMethodBeat.o(31475);
      return;
    }
  }
  
  public final void eyI()
  {
    AppMethodBeat.i(31483);
    ad.i("MicroMsg.AppPanel", "[forceRefreshSize]");
    eyJ();
    eyH();
    AppMethodBeat.o(31483);
  }
  
  public final void eyu()
  {
    AppMethodBeat.i(31463);
    this.Cal.eyN();
    this.Cat = false;
    this.Cau = false;
    this.Cav = false;
    this.Caw = false;
    eyv();
    this.Cal.uh(this.Cap);
    this.Cal.ui(this.Caq);
    this.Cal.ul(this.Car);
    this.Cal.um(this.Cas);
    eyE();
    AppMethodBeat.o(31463);
  }
  
  public final void eyv()
  {
    AppMethodBeat.i(31464);
    com.tencent.mm.m.g.Ze();
    if (com.tencent.mm.m.c.YO() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.Cal.eyO();
      this.Cal.uj(bool);
      bool = d.axB("location");
      this.Cal.uk(bool);
      this.Cal.eyP();
      AppMethodBeat.o(31464);
      return;
    }
  }
  
  public final void eyw()
  {
    AppMethodBeat.i(31465);
    this.Cal.CaK.value = false;
    eyE();
    AppMethodBeat.o(31465);
  }
  
  public final void eyx()
  {
    AppMethodBeat.i(31470);
    this.Cal.CaR.value = false;
    eyE();
    ad.d("MicroMsg.AppPanel", "disableTalkroom enable false");
    AppMethodBeat.o(31470);
  }
  
  public final void eyy()
  {
    AppMethodBeat.i(31471);
    this.Cal.CaW.value = false;
    eyE();
    AppMethodBeat.o(31471);
  }
  
  public final void eyz()
  {
    AppMethodBeat.i(31472);
    this.Cal.CaQ.value = false;
    eyE();
    AppMethodBeat.o(31472);
  }
  
  public final void fZG()
  {
    AppMethodBeat.i(204877);
    this.Cal.zh(false);
    eyE();
    AppMethodBeat.o(204877);
  }
  
  public ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163205);
    ArrayList localArrayList = this.Cal.getAppPanelUnCertainEnterArrayList();
    AppMethodBeat.o(163205);
    return localArrayList;
  }
  
  public int getCurScreen()
  {
    AppMethodBeat.i(191284);
    if (this.vWd != null)
    {
      int i = this.vWd.getCurScreen();
      AppMethodBeat.o(191284);
      return i;
    }
    AppMethodBeat.o(191284);
    return -1;
  }
  
  public int getPageMaxRowCount()
  {
    if (this.Cai == 0)
    {
      int i = (this.rwX + 3) / 4;
      if (i > 2) {
        return 2;
      }
      return i;
    }
    return this.Cai;
  }
  
  public final int getPosPage$134621()
  {
    int m = this.Cad.length;
    int j = 0;
    int i = 0;
    int k;
    if (j < m)
    {
      k = i;
      if (this.Cad[j] != 0) {
        if (j != 13) {}
      }
    }
    for (;;)
    {
      if (i != -1) {
        break label61;
      }
      j = -1;
      return j;
      k = i + 1;
      j += 1;
      i = k;
      break;
      i = -1;
    }
    label61:
    j = i + 1;
    i = j / this.BZP;
    if (j % this.BZP > 0) {}
    for (;;)
    {
      j = i;
      if (i >= 0) {
        break;
      }
      return 0;
      i -= 1;
    }
  }
  
  public final void init(int paramInt)
  {
    AppMethodBeat.i(31460);
    ad.i("MicroMsg.AppPanel", "init: %s", new Object[] { Integer.valueOf(paramInt) });
    this.Cal = new a();
    this.Cao = paramInt;
    Object localObject = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (((Display)localObject).getWidth() < ((Display)localObject).getHeight())
    {
      this.Cam = ((Display)localObject).getWidth();
      this.Can = ((Display)localObject).getHeight();
      View.inflate(this.context, 2131493086, this);
      this.vWe = ((MMDotView)findViewById(2131296868));
      this.vWd = ((MMFlipper)findViewById(2131296869));
    }
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.m.g.Zd().getValue("ShowAPPSuggestion");
        if ((!bt.isNullOrNil((String)localObject)) && (Integer.valueOf((String)localObject).intValue() == 1)) {
          continue;
        }
        this.hND = com.tencent.mm.pluginsdk.model.app.h.a(this.context, false, this.Cao);
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
        this.hND = com.tencent.mm.pluginsdk.model.app.h.a(this.context, false, this.Cao);
        continue;
      }
      if (!eyK()) {
        gI(this.hND);
      }
      gH(this.hND);
      eyF();
      eyu();
      AppMethodBeat.o(31460);
      return;
      this.Cam = ((Display)localObject).getHeight();
      this.Can = ((Display)localObject).getWidth();
      break;
      this.hND = com.tencent.mm.pluginsdk.model.app.h.a(this.context, true, this.Cao);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(31481);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      ad.d("MicroMsg.AppPanel", "onConfigChanged:" + paramConfiguration.orientation);
      if (paramConfiguration.orientation != 1) {
        break label76;
      }
    }
    label76:
    for (this.Cay = true;; this.Cay = false)
    {
      setNeedRefreshHeight(true);
      eyH();
      AppMethodBeat.o(31481);
      return;
    }
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(31478);
    ad.i("MicroMsg.AppPanel", "app panel refleshed: %s", new Object[] { Integer.valueOf(this.Cao) });
    for (;;)
    {
      try
      {
        String str = com.tencent.mm.m.g.Zd().getValue("ShowAPPSuggestion");
        if ((!bt.isNullOrNil(str)) && (Integer.valueOf(str).intValue() == 1)) {
          continue;
        }
        this.hND = com.tencent.mm.pluginsdk.model.app.h.a(this.context, false, this.Cao);
        ad.i("MicroMsg.AppPanel", "jacks not show App Suggestion");
      }
      catch (Exception localException)
      {
        int i;
        ad.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
        this.hND = com.tencent.mm.pluginsdk.model.app.h.a(this.context, false, this.Cao);
        continue;
      }
      if (!eyK()) {
        gI(this.hND);
      }
      gH(this.hND);
      if (this.Cal != null)
      {
        this.Cal.uh(this.Cap);
        this.Cal.ui(this.Caq);
        this.Cal.ul(this.Car);
        this.Cal.um(this.Cas);
      }
      i = this.vWd.getCurScreen();
      dmG();
      this.vWd.setToScreen(i);
      this.vWe.setSelectedDot(i);
      AppMethodBeat.o(31478);
      return;
      ad.i("MicroMsg.AppPanel", "jacks show App Suggestion");
      this.hND = com.tencent.mm.pluginsdk.model.app.h.a(this.context, true, this.Cao);
    }
  }
  
  public void setAppPanelListener(a parama)
  {
    this.Cae = parama;
  }
  
  public void setAppPanelUnCertainEnterArrayList(ArrayList<a.a> paramArrayList)
  {
    this.Cal.Cbh = paramArrayList;
  }
  
  public void setChattingContext(ChatFooter.b paramb)
  {
    this.Cag = paramb;
  }
  
  public void setNeedRefreshHeight(boolean paramBoolean)
  {
    this.CaD = paramBoolean;
  }
  
  public void setOnSwitchPanelListener(b paramb)
  {
    this.Caf = paramb;
  }
  
  public void setPortHeighDP(int paramInt)
  {
    if (vVL != paramInt)
    {
      vVL = paramInt;
      this.CaD = true;
    }
  }
  
  public void setPortHeighPx(int paramInt)
  {
    if (this.CaE != paramInt)
    {
      this.CaE = paramInt;
      this.CaD = true;
    }
  }
  
  public void setServiceShowFlag(int paramInt)
  {
    AppMethodBeat.i(31461);
    ad.i("MicroMsg.AppPanel", "setServiceShowFlag: %s", new Object[] { Integer.valueOf(paramInt) });
    this.Cao = paramInt;
    AppMethodBeat.o(31461);
  }
  
  public void setUncertainEnterLocation(int paramInt)
  {
    this.Cak = paramInt;
  }
  
  public final void ud(boolean paramBoolean)
  {
    AppMethodBeat.i(31466);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.Cal.CaM.value = paramBoolean;
      eyE();
      ad.d("MicroMsg.AppPanel", "enable " + paramBoolean + " isVoipPluginEnable " + this.Cal.CaN.value);
      AppMethodBeat.o(31466);
      return;
    }
  }
  
  public final void ue(boolean paramBoolean)
  {
    AppMethodBeat.i(31467);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.Cal.CaS.value = paramBoolean;
      eyE();
      ad.d("MicroMsg.AppPanel", "enable " + this.Cal.CaT.value + " isVoipAudioEnable " + paramBoolean);
      AppMethodBeat.o(31467);
      return;
    }
  }
  
  public final void uf(boolean paramBoolean)
  {
    AppMethodBeat.i(31468);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.Cal.Cbb.value = paramBoolean;
      eyE();
      ad.d("MicroMsg.AppPanel", "enable " + this.Cal.Cbb.value + " isMultiTalkEnable " + paramBoolean);
      AppMethodBeat.o(31468);
      return;
    }
  }
  
  public final void ug(boolean paramBoolean)
  {
    AppMethodBeat.i(31469);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.Cal.CaU.value = paramBoolean;
      eyE();
      AppMethodBeat.o(31469);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Gq(int paramInt);
    
    public abstract void Gr(int paramInt);
    
    public abstract void cOf();
    
    public abstract void cOg();
    
    public abstract void cOh();
    
    public abstract void cOi();
    
    public abstract void cOj();
    
    public abstract void cOk();
    
    public abstract void cOl();
    
    public abstract void cOm();
    
    public abstract void cOn();
    
    public abstract void cOo();
    
    public abstract void cOp();
    
    public abstract void cOq();
    
    public abstract void cOr();
    
    public abstract void cOs();
    
    public abstract void cOt();
    
    public abstract void cOu();
    
    public abstract void d(com.tencent.mm.pluginsdk.model.app.g paramg);
    
    public abstract void fXT();
  }
  
  public static abstract interface b
  {
    public abstract void eyM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel
 * JD-Core Version:    0.7.0.1
 */