package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vt.b;
import com.tencent.mm.g.b.a.cz;
import com.tencent.mm.g.b.a.da;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.MMFlipper.a;
import com.tencent.mm.ui.base.MMFlipper.b;
import com.tencent.mm.ui.base.MMFlipper.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel
  extends LinearLayout
{
  private static boolean DsS = false;
  private static int xgx = 215;
  private static int xgy = 158;
  private int DsA;
  public a DsB;
  private int DsC;
  private int DsD;
  private int DsE;
  private boolean DsF;
  private boolean DsG;
  private boolean DsH;
  private boolean DsI;
  boolean DsJ;
  boolean DsK;
  boolean DsL;
  boolean DsM;
  private Map<String, com.tencent.mm.pluginsdk.model.app.g> DsN;
  private boolean DsO;
  private final int DsP;
  private int DsQ;
  private AppGrid.b DsR;
  private boolean DsT;
  private int DsU;
  private int Dsf;
  private int Dsi;
  private final boolean[] Dst;
  private a Dsu;
  private b Dsv;
  private ChatFooter.b Dsw;
  private List<AppGrid> Dsx;
  private int Dsy;
  public int Dsz;
  Context context;
  private boolean cqf;
  private List<com.tencent.mm.pluginsdk.model.app.g> inZ;
  private int sFP;
  private SharedPreferences sp;
  private boolean xgM;
  private int xgN;
  private int xgO;
  public MMFlipper xgP;
  private MMDotView xgQ;
  
  public AppPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31459);
    this.Dst = new boolean[20];
    this.xgM = false;
    this.Dsi = 20;
    this.sFP = this.Dsi;
    this.Dsz = 0;
    this.DsA = -1;
    this.cqf = false;
    this.DsC = 0;
    this.DsD = 0;
    this.DsE = 0;
    this.DsF = false;
    this.DsG = false;
    this.DsH = false;
    this.DsI = false;
    this.DsJ = false;
    this.DsK = false;
    this.DsL = false;
    this.DsM = false;
    this.DsN = null;
    this.DsO = true;
    this.inZ = new LinkedList();
    this.DsP = 2;
    this.DsQ = -1;
    this.DsR = new AppGrid.b()
    {
      public final int Xe(int paramAnonymousInt)
      {
        AppMethodBeat.i(196129);
        if (paramAnonymousInt < AppPanel.f(AppPanel.this))
        {
          int m = AppPanel.r(AppPanel.this).length;
          int i = 0;
          int k;
          for (int j = 0; i < m; j = k)
          {
            k = j;
            if (AppPanel.r(AppPanel.this)[i] != 0)
            {
              if (j == paramAnonymousInt)
              {
                AppMethodBeat.o(196129);
                return i;
              }
              k = j + 1;
            }
            i += 1;
          }
        }
        if ((paramAnonymousInt >= AppPanel.f(AppPanel.this)) && (paramAnonymousInt < AppPanel.s(AppPanel.this)))
        {
          AppMethodBeat.o(196129);
          return -2147483648;
        }
        AppMethodBeat.o(196129);
        return 2147483647;
      }
      
      public final void Xf(int paramAnonymousInt)
      {
        AppMethodBeat.i(196130);
        if (paramAnonymousInt == 0)
        {
          if (!AppPanel.this.DsB.Dta.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(196130);
            return;
          }
          AppPanel.a(AppPanel.this, true);
          AppMethodBeat.o(196130);
          return;
        }
        AppMethodBeat.o(196130);
      }
      
      public final void a(int paramAnonymousInt, com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        int i = 0;
        AppMethodBeat.i(196131);
        boolean bool1;
        Object localObject;
        if (paramAnonymousg != null)
        {
          bool1 = true;
          ac.d("MicroMsg.AppPanel", "pos=%d, has appInfo = %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool1) });
          if ((paramAnonymousg != null) && (com.tencent.mm.pluginsdk.model.app.h.o(paramAnonymousg)))
          {
            localObject = paramAnonymousg.field_appId;
            HashMap localHashMap = new HashMap();
            u.p(localHashMap);
            localHashMap.put(localObject, "1");
            u.o(localHashMap);
          }
          AppPanel.d(AppPanel.this, AppPanel.q(AppPanel.this).getCurScreen());
          if (!(paramAnonymousg instanceof a.a)) {
            break label323;
          }
          paramAnonymousg = (a.a)paramAnonymousg;
          ac.i("MicroMsg.AppPanel", "jump_type:%s", new Object[] { Integer.valueOf(paramAnonymousg.vjP) });
          if (paramAnonymousg.vjP != 1) {
            break label296;
          }
          localObject = new com.tencent.mm.plugin.appbrand.a.f();
          ((com.tencent.mm.plugin.appbrand.a.f)localObject).username = paramAnonymousg.DtC;
          ((com.tencent.mm.plugin.appbrand.a.f)localObject).version = paramAnonymousg.DtD;
        }
        for (;;)
        {
          try
          {
            ((com.tencent.mm.plugin.appbrand.a.f)localObject).hxM = Integer.parseInt(paramAnonymousg.DtF);
            ((com.tencent.mm.plugin.appbrand.a.f)localObject).jjf = paramAnonymousg.DtE;
            ((com.tencent.mm.plugin.appbrand.a.f)localObject).scene = 1156;
            ((com.tencent.mm.plugin.appbrand.a.f)localObject).jjp = paramAnonymousg.jjp;
            ((n)com.tencent.mm.kernel.g.ab(n.class)).a(AppPanel.this.getContext(), (com.tencent.mm.plugin.appbrand.a.f)localObject);
            localObject = new cz();
            ((cz)localObject).dCQ = 2L;
            ((cz)localObject).dRB = 0L;
            ((cz)localObject).lb(paramAnonymousg.DtA);
            ((cz)localObject).aHZ();
            AppMethodBeat.o(196131);
            return;
            bool1 = false;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            ((com.tencent.mm.plugin.appbrand.a.f)localObject).hxM = 0;
            continue;
          }
          label296:
          if (paramAnonymousg.vjP == 2) {
            com.tencent.mm.plugin.account.a.b.a.b(AppPanel.j(AppPanel.this), paramAnonymousg.lze, 0, true);
          }
        }
        label323:
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(196131);
          return;
          if (AppPanel.g(AppPanel.this) == null)
          {
            ac.e("MicroMsg.AppPanel", "infoList == null");
            AppMethodBeat.o(196131);
            return;
          }
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(10305, String.valueOf(AppPanel.g(AppPanel.this).size()));
          com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(10) });
          com.tencent.mm.kernel.g.agR().agA().set(69121, "");
          AppPanel.t(AppPanel.this).dbS();
          AppMethodBeat.o(196131);
          return;
          localObject = paramAnonymousg;
          if (paramAnonymousg == null) {
            localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.u(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.DhS);
          }
          az.ayM();
          paramAnonymousInt = ((Integer)com.tencent.mm.model.c.agA().get(ah.a.GIP, Integer.valueOf(0))).intValue();
          az.ayM();
          paramAnonymousg = bs.S(((String)com.tencent.mm.model.c.agA().get(ah.a.GLg, "")).split(";"));
          if (!paramAnonymousg.contains(String.valueOf(paramAnonymousInt)))
          {
            paramAnonymousg.add(String.valueOf(paramAnonymousInt));
            az.ayM();
            com.tencent.mm.model.c.agA().set(ah.a.GLg, bs.n(paramAnonymousg, ";"));
            AppPanel.this.refresh();
          }
          az.ayM();
          com.tencent.mm.model.c.agA().set(80, Boolean.FALSE);
          AppPanel.t(AppPanel.this).d((com.tencent.mm.pluginsdk.model.app.g)localObject);
          AppMethodBeat.o(196131);
          return;
          if (!AppPanel.this.DsB.Dth.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(196131);
            return;
          }
          if (paramAnonymousg == null)
          {
            ac.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
            AppMethodBeat.o(196131);
            return;
          }
          if ((paramAnonymousg.eKX()) || (paramAnonymousg.eLa()))
          {
            if (AppPanel.v(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(ai.eUX(), 0));
            }
            if (AppPanel.v(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
              AppPanel.v(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
            }
            if (paramAnonymousg.eLa()) {
              com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(16), paramAnonymousg.field_appId, Integer.valueOf(0) });
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(13), paramAnonymousg.field_appId, Integer.valueOf(0) });
          }
          for (;;)
          {
            AppPanel.t(AppPanel.this).d(paramAnonymousg);
            AppMethodBeat.o(196131);
            return;
            com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(11), paramAnonymousg.field_appId });
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(14) });
          paramAnonymousg = AppPanel.t(AppPanel.this);
          if (AppPanel.this.DsB.Dtq.value) {}
          for (paramAnonymousInt = i;; paramAnonymousInt = 2)
          {
            paramAnonymousg.In(paramAnonymousInt);
            AppMethodBeat.o(196131);
            return;
          }
          if (!AppPanel.this.DsB.Dtb.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(196131);
            return;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(4) });
          AppPanel.t(AppPanel.this).dbR();
          AppMethodBeat.o(196131);
          return;
          if (!AppPanel.this.DsB.Dtr.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(196131);
            return;
          }
          if (paramAnonymousg == null)
          {
            localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.u(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.DhU);
            paramAnonymousg = (com.tencent.mm.pluginsdk.model.app.g)localObject;
            if (localObject == null)
            {
              AppMethodBeat.o(196131);
              return;
            }
          }
          if ((paramAnonymousg.eKX()) || (paramAnonymousg.eLa()))
          {
            if (AppPanel.v(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(ai.eUX(), 0));
            }
            if (AppPanel.v(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
              AppPanel.v(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(13), paramAnonymousg.field_appId, Integer.valueOf(0) });
          }
          for (;;)
          {
            az.ayM();
            paramAnonymousInt = ((Integer)com.tencent.mm.model.c.agA().get(ah.a.GIP, Integer.valueOf(0))).intValue();
            az.ayM();
            paramAnonymousg = bs.S(((String)com.tencent.mm.model.c.agA().get(ah.a.GLh, "")).split(";"));
            if (!paramAnonymousg.contains(String.valueOf(paramAnonymousInt)))
            {
              paramAnonymousg.add(String.valueOf(paramAnonymousInt));
              az.ayM();
              com.tencent.mm.model.c.agA().set(ah.a.GLh, bs.n(paramAnonymousg, ";"));
              AppPanel.this.refresh();
            }
            AppPanel.t(AppPanel.this).dbW();
            AppMethodBeat.o(196131);
            return;
            com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(11), paramAnonymousg.field_appId });
          }
          if ((!AppPanel.this.DsB.Dtn.value) || (!AppPanel.this.DsB.Dto.value))
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(196131);
            return;
          }
          az.ayM();
          if (((Boolean)com.tencent.mm.model.c.agA().get(290817, Boolean.TRUE)).booleanValue())
          {
            az.ayM();
            com.tencent.mm.model.c.agA().set(290817, Boolean.FALSE);
            AppPanel.this.refresh();
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(3) });
          AppPanel.t(AppPanel.this).dbQ();
          AppMethodBeat.o(196131);
          return;
          if (!AppPanel.this.DsB.Dtf.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(196131);
            return;
          }
          az.ayM();
          if (((Boolean)com.tencent.mm.model.c.agA().get(327744, Boolean.TRUE)).booleanValue())
          {
            az.ayM();
            com.tencent.mm.model.c.agA().set(327744, Boolean.FALSE);
            AppPanel.this.refresh();
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(12) });
          AppPanel.t(AppPanel.this).dbU();
          AppMethodBeat.o(196131);
          return;
          if (!AppPanel.this.DsB.Dta.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(196131);
            return;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(1) });
          AppPanel.a(AppPanel.this, false);
          AppMethodBeat.o(196131);
          return;
          if (!AppPanel.this.DsB.Dtd.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(196131);
            return;
          }
          com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(8) });
          az.ayM();
          com.tencent.mm.model.c.agA().set(54, Boolean.FALSE);
          if (AppPanel.t(AppPanel.this) != null)
          {
            paramAnonymousg = new vt();
            paramAnonymousg.dyB.dyD = true;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousg);
            paramAnonymousg = paramAnonymousg.dyC.dyF;
            if (!bs.isNullOrNil(paramAnonymousg))
            {
              ac.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramAnonymousg)));
              com.tencent.mm.ui.base.h.d(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131764350), "", AppPanel.j(AppPanel.this).getString(2131755835), AppPanel.j(AppPanel.this).getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(196125);
                  vt localvt = new vt();
                  localvt.dyB.dyE = true;
                  com.tencent.mm.sdk.b.a.GpY.l(localvt);
                  AppPanel.t(AppPanel.this).dbN();
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(196125);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(196126);
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(196126);
                }
              });
              AppMethodBeat.o(196131);
              return;
            }
            AppPanel.t(AppPanel.this).dbN();
            AppMethodBeat.o(196131);
            return;
            if (!AppPanel.this.DsB.Dtj.value)
            {
              Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
              AppMethodBeat.o(196131);
              return;
            }
            com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(7) });
            az.ayM();
            com.tencent.mm.model.c.agA().set(62, Boolean.FALSE);
            paramAnonymousg = new vt();
            paramAnonymousg.dyB.dyD = true;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousg);
            paramAnonymousg = paramAnonymousg.dyC.dyF;
            if (!bs.isNullOrNil(paramAnonymousg))
            {
              ac.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramAnonymousg)));
              com.tencent.mm.ui.base.h.d(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131764350), "", AppPanel.j(AppPanel.this).getString(2131755835), AppPanel.j(AppPanel.this).getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(196127);
                  vt localvt = new vt();
                  localvt.dyB.dyE = true;
                  com.tencent.mm.sdk.b.a.GpY.l(localvt);
                  AppPanel.t(AppPanel.this).dbO();
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(196127);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(196128);
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(196128);
                }
              });
              AppMethodBeat.o(196131);
              return;
            }
            AppPanel.t(AppPanel.this).dbO();
            AppMethodBeat.o(196131);
            return;
            if (AppPanel.t(AppPanel.this) != null)
            {
              com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(6) });
              az.ayM();
              com.tencent.mm.model.c.agA().set(67, Boolean.FALSE);
              AppPanel.t(AppPanel.this).dbP();
              AppMethodBeat.o(196131);
              return;
              com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(9) });
              az.ayM();
              com.tencent.mm.model.c.agA().set(73, Boolean.FALSE);
              AppPanel.w(AppPanel.this).eOh();
              AppMethodBeat.o(196131);
              return;
              if (!AppPanel.this.DsB.Dtc.value)
              {
                Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                AppMethodBeat.o(196131);
                return;
              }
              com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(5) });
              if (AppPanel.t(AppPanel.this) != null)
              {
                AppPanel.t(AppPanel.this).dbT();
                AppMethodBeat.o(196131);
                return;
                if (!AppPanel.this.DsB.Dtp.value)
                {
                  Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                  AppMethodBeat.o(196131);
                  return;
                }
                if (AppPanel.t(AppPanel.this) != null) {
                  AppPanel.t(AppPanel.this).dbV();
                }
                com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(15) });
                az.ayM();
                bool1 = ((Boolean)com.tencent.mm.model.c.agA().get(208899, Boolean.FALSE)).booleanValue();
                az.ayM();
                boolean bool2 = ((Boolean)com.tencent.mm.model.c.agA().get(208913, Boolean.FALSE)).booleanValue();
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.h.wUl.f(11594, new Object[] { Integer.valueOf(3) });
                  AppMethodBeat.o(196131);
                  return;
                }
                if (bool2)
                {
                  com.tencent.mm.plugin.report.service.h.wUl.f(11594, new Object[] { Integer.valueOf(4) });
                  AppMethodBeat.o(196131);
                  return;
                  if (AppPanel.t(AppPanel.this) != null)
                  {
                    AppPanel.t(AppPanel.this).dbX();
                    AppMethodBeat.o(196131);
                    return;
                    if (!AppPanel.this.DsB.Dtt.value)
                    {
                      Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                      AppMethodBeat.o(196131);
                      return;
                    }
                    AppPanel.t(AppPanel.this).dbY();
                    AppMethodBeat.o(196131);
                    return;
                    if (AppPanel.t(AppPanel.this) != null)
                    {
                      if (paramAnonymousg == null)
                      {
                        localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.u(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.DhV);
                        paramAnonymousg = (com.tencent.mm.pluginsdk.model.app.g)localObject;
                        if (localObject == null)
                        {
                          ac.i("MicroMsg.AppPanel", "empty info");
                          AppMethodBeat.o(196131);
                          return;
                        }
                      }
                      if ((paramAnonymousg.eKX()) || (paramAnonymousg.eLa()))
                      {
                        if (AppPanel.v(AppPanel.this) == null) {
                          AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(ai.eUX(), 0));
                        }
                        if (AppPanel.v(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
                          AppPanel.v(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
                        }
                      }
                      AppPanel.t(AppPanel.this).dbZ();
                      AppMethodBeat.o(196131);
                      return;
                      if (!AppPanel.this.DsB.Dtv.value)
                      {
                        Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                        AppMethodBeat.o(196131);
                        return;
                      }
                      com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(17) });
                      if (AppPanel.t(AppPanel.this) != null)
                      {
                        AppPanel.t(AppPanel.this).dca();
                        AppMethodBeat.o(196131);
                        return;
                        if (!AppPanel.this.DsB.Dtw.value)
                        {
                          Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                          AppMethodBeat.o(196131);
                          return;
                        }
                        if (AppPanel.t(AppPanel.this) != null)
                        {
                          AppPanel.t(AppPanel.this).dcc();
                          AppMethodBeat.o(196131);
                          return;
                          if (!AppPanel.this.DsB.Dtx.value)
                          {
                            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                            AppMethodBeat.o(196131);
                            return;
                          }
                          com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(19) });
                          if (AppPanel.t(AppPanel.this) != null)
                          {
                            AppPanel.t(AppPanel.this).dcd();
                            AppMethodBeat.o(196131);
                            return;
                            if (!AppPanel.this.DsB.Dty.value)
                            {
                              Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                              AppMethodBeat.o(196131);
                              return;
                            }
                            com.tencent.mm.plugin.report.service.h.wUl.f(10923, new Object[] { Integer.valueOf(20) });
                            if (AppPanel.t(AppPanel.this) != null)
                            {
                              AppPanel.t(AppPanel.this).dcb();
                              com.tencent.mm.live.d.a.amt();
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
    this.DsT = true;
    this.DsU = -1;
    this.context = paramContext;
    AppMethodBeat.o(31459);
  }
  
  private int Xg(int paramInt)
  {
    int i = paramInt / this.Dsf;
    if (paramInt % this.Dsf > 0) {}
    for (paramInt = i;; paramInt = i - 1)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      return i;
    }
  }
  
  private void eOa()
  {
    AppMethodBeat.i(31477);
    ac.d("MicroMsg.AppPanel", "AppPanel initFlipper");
    this.DsQ = -1;
    this.xgP.removeAllViews();
    this.xgP.setOnMeasureListener(new MMFlipper.b()
    {
      public final void gZ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(31448);
        ac.i("MicroMsg.AppPanel", "onMeasure width:" + paramAnonymousInt1 + " height:" + paramAnonymousInt2 + " isMeasured:" + AppPanel.a(AppPanel.this));
        if ((AppPanel.a(AppPanel.this)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
        {
          if ((paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0)) {
            ac.d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
          }
          AppMethodBeat.o(31448);
          return;
        }
        if (AppPanel.b(AppPanel.this) == 2) {
          ac.d("MicroMsg.AppPanel", "landspace");
        }
        for (;;)
        {
          AppPanel.c(AppPanel.this);
          AppPanel.a(AppPanel.this, paramAnonymousInt2);
          AppPanel.b(AppPanel.this, paramAnonymousInt1);
          AppPanel.d(AppPanel.this);
          AppMethodBeat.o(31448);
          return;
          ac.d("MicroMsg.AppPanel", "portrait");
        }
      }
    });
    this.xgP.setOnFlipperViewShowedListener(new MMFlipper.a()
    {
      public final void Xh(int paramAnonymousInt)
      {
        AppMethodBeat.i(196121);
        ac.i("MicroMsg.AppPanel", "viewpage reshow %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == 1) && (AppPanel.this.DsB.Dty.value)) {
          com.tencent.mm.live.d.e.ank();
        }
        AppMethodBeat.o(196121);
      }
    });
    this.xgP.setOnScreenChangedListener(new MMFlipper.c()
    {
      public final void u(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(196122);
        AppPanel.e(AppPanel.this).setSelectedDot(paramAnonymousInt2);
        Object localObject2;
        if ((AppPanel.this.getVisibility() == 0) && (paramAnonymousInt1 != -1) && (paramAnonymousInt1 != paramAnonymousInt2) && (paramAnonymousBoolean))
        {
          if (AppPanel.this.DsB.Dth.value) {}
          for (int i = AppPanel.f(AppPanel.this) + AppPanel.g(AppPanel.this).size();; i = AppPanel.f(AppPanel.this))
          {
            localObject1 = new cz();
            ((cz)localObject1).dCQ = 1L;
            ((cz)localObject1).dRB = 0L;
            localObject2 = new StringBuilder();
            int j = 0;
            while (j < AppPanel.this.getAppPanelUnCertainEnterArrayList().size())
            {
              AppPanel localAppPanel = AppPanel.this;
              if (paramAnonymousInt1 == AppPanel.c(localAppPanel, AppPanel.h(localAppPanel) + i + 1)) {
                ((StringBuilder)localObject2).append(((a.a)AppPanel.this.getAppPanelUnCertainEnterArrayList().get(j)).DtA).append("|");
              }
              j += 1;
            }
          }
          ((cz)localObject1).lb(((StringBuilder)localObject2).toString());
          ((cz)localObject1).aHZ();
          paramAnonymousInt1 = AppPanel.this.getPosPage$134621();
          if ((paramAnonymousInt1 != -1) && (paramAnonymousInt1 == AppPanel.this.getCurScreen())) {
            if (AppPanel.i(AppPanel.this) != null) {
              break label341;
            }
          }
        }
        label341:
        for (Object localObject1 = "";; localObject1 = AppPanel.i(AppPanel.this).getTalkerUserName())
        {
          localObject2 = new da();
          ((da)localObject2).lc((String)localObject1);
          ((da)localObject2).dRB = 0L;
          ((da)localObject2).ld("19");
          ((da)localObject2).aHZ();
          ac.i("MicroMsg.AppPanel", "scroll to show page %s", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt2 == 1) && (AppPanel.this.DsB.Dty.value)) {
            com.tencent.mm.live.d.e.ank();
          }
          AppMethodBeat.o(196122);
          return;
        }
      }
    });
    eOe();
    AppMethodBeat.o(31477);
  }
  
  private void eOb()
  {
    AppMethodBeat.i(163206);
    if (this.DsA == -1)
    {
      AppMethodBeat.o(163206);
      return;
    }
    if (this.DsB.Dth.value) {}
    cz localcz;
    StringBuilder localStringBuilder;
    for (int i = this.Dsi + this.inZ.size();; i = this.Dsi)
    {
      this.Dsz = Xg(this.DsA + i + 1);
      this.xgP.setToScreen(this.Dsz);
      this.DsA = -1;
      localcz = new cz();
      localcz.dCQ = 1L;
      localcz.dRB = 1L;
      localStringBuilder = new StringBuilder();
      int j = 0;
      while (j < getAppPanelUnCertainEnterArrayList().size())
      {
        if (this.Dsz == Xg(this.DsA + i + 1)) {
          localStringBuilder.append(((a.a)getAppPanelUnCertainEnterArrayList().get(j)).DtA).append("|");
        }
        j += 1;
      }
    }
    localcz.lb(localStringBuilder.toString());
    localcz.aHZ();
    AppMethodBeat.o(163206);
  }
  
  private void eOc()
  {
    AppMethodBeat.i(31482);
    ac.i("MicroMsg.AppPanel", "[dealOrientationChange]");
    this.xgM = false;
    this.xgP.setToScreen(0);
    eOa();
    requestLayout();
    AppMethodBeat.o(31482);
  }
  
  private void eOe()
  {
    AppMethodBeat.i(31484);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.DsT)
    {
      if (getScreenOrientation() != 2) {
        break label79;
      }
      ac.d("MicroMsg.AppPanel", "initFlipper, landscape");
      localView = findViewById(2131296867);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = BackwardSupportUtil.b.g(this.context, xgy);
      localView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.DsT = false;
      AppMethodBeat.o(31484);
      return;
      label79:
      ac.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", new Object[] { Integer.valueOf(xgx) });
      localView = findViewById(2131296867);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = getPortHeightPX();
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private boolean eOf()
  {
    AppMethodBeat.i(31487);
    if (this.DsM)
    {
      AppMethodBeat.o(31487);
      return false;
    }
    com.tencent.mm.plugin.card.c.b localb = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.card.c.b.class);
    if (localb != null)
    {
      if ((localb.bQF()) && (localb.bQI() > 0))
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
  
  private void gT(List<com.tencent.mm.pluginsdk.model.app.g> paramList)
  {
    AppMethodBeat.i(31462);
    boolean bool1 = this.DsF;
    this.DsF = false;
    boolean bool2 = this.DsG;
    boolean bool3 = this.DsH;
    boolean bool4 = this.DsI;
    this.DsG = false;
    this.DsH = false;
    this.DsI = false;
    int j = com.tencent.mm.pluginsdk.model.app.h.Wx(this.DsE);
    int k = this.DsE;
    if (paramList != null) {}
    for (int i = paramList.size();; i = -1)
    {
      ac.i("MicroMsg.AppPanel", "serviceCount, %d, %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      this.DsN = new HashMap();
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
            if (localg.eKX())
            {
              if (!localg.eKZ()) {
                this.DsF = true;
              }
              j = i;
              if (com.tencent.mm.pluginsdk.model.app.g.DhS.equals(localg.field_appId))
              {
                this.DsN.put(com.tencent.mm.pluginsdk.model.app.g.DhS, localg);
                ac.i("MicroMsg.AppPanel", "remittance: %s, %s", new Object[] { Boolean.valueOf(this.DsK), Boolean.valueOf(this.DsG) });
                if (!this.DsK) {
                  this.DsG = true;
                }
                paramList.remove(i);
                j = i - 1;
              }
              i = j;
              if (com.tencent.mm.pluginsdk.model.app.g.DhU.equals(localg.field_appId))
              {
                this.DsN.put(com.tencent.mm.pluginsdk.model.app.g.DhU, localg);
                ac.i("MicroMsg.AppPanel", "luckyMoney: %s, %s", new Object[] { Boolean.valueOf(this.DsJ), Boolean.valueOf(this.DsH) });
                if (!this.DsJ) {
                  this.DsH = true;
                }
                paramList.remove(j);
                i = j - 1;
              }
              j = i;
              if (com.tencent.mm.pluginsdk.model.app.g.DhV.equals(localg.field_appId))
              {
                this.DsN.put(com.tencent.mm.pluginsdk.model.app.g.DhV, localg);
                ac.i("MicroMsg.AppPanel", "aa: %s, %s", new Object[] { Boolean.valueOf(this.DsJ), Boolean.valueOf(this.DsH) });
                if (!this.DsL) {
                  this.DsI = true;
                }
                paramList.remove(i);
                j = i - 1;
              }
            }
          }
        }
      }
    }
    com.tencent.mm.plugin.report.service.h.wUl.dB(965, 36);
    label485:
    ac.i("MicroMsg.AppPanel", "hasService %b", new Object[] { Boolean.valueOf(this.DsF) });
    if ((bool1 != this.DsF) || (bool2 != this.DsG) || (bool3 != this.DsH) || (bool4 != this.DsI))
    {
      this.DsB.vi(this.DsF);
      this.DsB.vj(this.DsG);
      this.DsB.vm(this.DsH);
      this.DsB.vn(this.DsI);
      eNZ();
    }
    AppMethodBeat.o(31462);
  }
  
  private static void gU(List<com.tencent.mm.pluginsdk.model.app.g> paramList)
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
      if ((localg != null) && (com.tencent.mm.pluginsdk.model.app.g.DhT.equals(localg.field_appId)))
      {
        paramList.remove(localg);
        ac.i("MicroMsg.AppPanel", "do remove card");
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
    if (this.DsU > 0)
    {
      i = this.DsU;
      AppMethodBeat.o(31485);
      return i;
    }
    int i = BackwardSupportUtil.b.g(this.context, xgx);
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
  
  public final void eNO()
  {
    AppMethodBeat.i(31463);
    this.DsB.eOi();
    this.DsJ = false;
    this.DsK = false;
    this.DsL = false;
    this.DsM = false;
    eNP();
    this.DsB.vi(this.DsF);
    this.DsB.vj(this.DsG);
    this.DsB.vm(this.DsH);
    this.DsB.vn(this.DsI);
    eNZ();
    AppMethodBeat.o(31463);
  }
  
  public final void eNP()
  {
    AppMethodBeat.i(31464);
    com.tencent.mm.m.g.ZZ();
    if (com.tencent.mm.m.c.ZL() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.DsB.eOj();
      this.DsB.vk(bool);
      bool = d.aCT("location");
      this.DsB.vl(bool);
      this.DsB.eOk();
      AppMethodBeat.o(31464);
      return;
    }
  }
  
  public final void eNQ()
  {
    AppMethodBeat.i(31465);
    this.DsB.Dtb.value = false;
    eNZ();
    AppMethodBeat.o(31465);
  }
  
  public final void eNR()
  {
    AppMethodBeat.i(31470);
    this.DsB.Dti.value = false;
    eNZ();
    ac.d("MicroMsg.AppPanel", "disableTalkroom enable false");
    AppMethodBeat.o(31470);
  }
  
  public final void eNS()
  {
    AppMethodBeat.i(31471);
    this.DsB.Dtn.value = false;
    eNZ();
    AppMethodBeat.o(31471);
  }
  
  public final void eNT()
  {
    AppMethodBeat.i(31472);
    this.DsB.Dth.value = false;
    eNZ();
    AppMethodBeat.o(31472);
  }
  
  public final void eNU()
  {
    AppMethodBeat.i(31473);
    this.DsB.Dtp.value = false;
    eNZ();
    AppMethodBeat.o(31473);
  }
  
  public final void eNV()
  {
    AppMethodBeat.i(31474);
    this.DsB.Dtv.value = false;
    eNZ();
    AppMethodBeat.o(31474);
  }
  
  public final void eNW()
  {
    AppMethodBeat.i(185751);
    this.DsB.Dtw.value = false;
    eNZ();
    AppMethodBeat.o(185751);
  }
  
  public final void eNX()
  {
    AppMethodBeat.i(196133);
    this.DsB.Dtx.value = false;
    eNZ();
    AppMethodBeat.o(196133);
  }
  
  public final void eNY()
  {
    AppMethodBeat.i(196134);
    this.DsB.vo(false);
    eNZ();
    AppMethodBeat.o(196134);
  }
  
  public final void eNZ()
  {
    AppMethodBeat.i(31475);
    int j = this.Dst.length;
    int i = 0;
    while (i < j)
    {
      this.Dst[i] = true;
      i += 1;
    }
    if (!this.DsB.Dta.value) {
      this.Dst[0] = false;
    }
    for (j = 1;; j = 0)
    {
      i = j;
      if (!this.DsB.DsZ.value)
      {
        this.Dst[1] = false;
        i = j + 1;
      }
      j = i;
      if (!this.DsB.Dtv.value)
      {
        this.Dst[19] = false;
        j = i + 1;
      }
      i = j;
      if (!this.DsB.Dtw.value)
      {
        this.Dst[12] = false;
        i = j + 1;
      }
      j = i;
      if (!this.DsB.Dtx.value)
      {
        this.Dst[13] = false;
        j = i + 1;
      }
      i = j;
      if (!this.DsB.Dty.value)
      {
        this.Dst[14] = false;
        i = j + 1;
      }
      if (this.DsB.Dtn.value)
      {
        j = i;
        if (this.DsB.Dto.value) {}
      }
      else
      {
        this.Dst[6] = false;
        j = i + 1;
      }
      i = j;
      if (!this.DsB.Dtf.value)
      {
        this.Dst[17] = false;
        i = j + 1;
      }
      j = i;
      if (!this.DsB.Dtg.value)
      {
        ac.i("MicroMsg.AppPanel", "disable remittance");
        this.Dst[8] = false;
        j = i + 1;
      }
      i = j;
      if (!this.DsB.Dtb.value)
      {
        this.Dst[15] = false;
        i = j + 1;
      }
      j = i;
      if (!this.DsB.Dtp.value)
      {
        this.Dst[16] = false;
        j = i + 1;
      }
      i = j;
      if (!this.DsB.Dts.value)
      {
        this.Dst[3] = false;
        i = j + 1;
      }
      j = i;
      if (!this.DsB.Dtc.value)
      {
        this.Dst[11] = false;
        j = i + 1;
      }
      i = j;
      if (!this.DsB.Dti.value)
      {
        this.Dst[5] = false;
        i = j + 1;
      }
      if (this.DsB.Dtk.value)
      {
        j = i;
        if (this.DsB.Dtj.value) {}
      }
      else
      {
        this.Dst[4] = false;
        j = i + 1;
      }
      if (this.DsB.Dte.value)
      {
        i = j;
        if (this.DsB.Dtd.value) {}
      }
      else
      {
        this.Dst[2] = false;
        i = j + 1;
      }
      if (this.DsB.Dtm.value)
      {
        j = i;
        if (this.DsB.Dtl.value) {}
      }
      else
      {
        this.Dst[10] = false;
        j = i + 1;
      }
      i = j;
      if (!this.DsB.Dtr.value)
      {
        ac.i("MicroMsg.AppPanel", "disable lucky money");
        this.Dst[7] = false;
        i = j + 1;
      }
      j = i;
      if (!this.DsB.Dtt.value)
      {
        this.Dst[18] = false;
        j = i + 1;
      }
      this.Dst[9] = false;
      this.Dsi = (20 - (j + 1));
      AppMethodBeat.o(31475);
      return;
    }
  }
  
  public final void eOd()
  {
    AppMethodBeat.i(31483);
    ac.i("MicroMsg.AppPanel", "[forceRefreshSize]");
    eOe();
    eOc();
    AppMethodBeat.o(31483);
  }
  
  public ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163205);
    ArrayList localArrayList = this.DsB.getAppPanelUnCertainEnterArrayList();
    AppMethodBeat.o(163205);
    return localArrayList;
  }
  
  public int getCurScreen()
  {
    AppMethodBeat.i(196135);
    if (this.xgP != null)
    {
      int i = this.xgP.getCurScreen();
      AppMethodBeat.o(196135);
      return i;
    }
    AppMethodBeat.o(196135);
    return -1;
  }
  
  public int getPageMaxRowCount()
  {
    if (this.Dsy == 0)
    {
      int i = (this.sFP + 3) / 4;
      if (i > 2) {
        return 2;
      }
      return i;
    }
    return this.Dsy;
  }
  
  public final int getPosPage$134621()
  {
    int m = this.Dst.length;
    int j = 0;
    int i = 0;
    int k;
    if (j < m)
    {
      k = i;
      if (this.Dst[j] != 0) {
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
    i = j / this.Dsf;
    if (j % this.Dsf > 0) {}
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
    ac.i("MicroMsg.AppPanel", "init: %s", new Object[] { Integer.valueOf(paramInt) });
    this.DsB = new a();
    this.DsE = paramInt;
    Object localObject = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (((Display)localObject).getWidth() < ((Display)localObject).getHeight())
    {
      this.DsC = ((Display)localObject).getWidth();
      this.DsD = ((Display)localObject).getHeight();
      View.inflate(this.context, 2131493086, this);
      this.xgQ = ((MMDotView)findViewById(2131296868));
      this.xgP = ((MMFlipper)findViewById(2131296869));
    }
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.m.g.ZY().getValue("ShowAPPSuggestion");
        if ((!bs.isNullOrNil((String)localObject)) && (Integer.valueOf((String)localObject).intValue() == 1)) {
          continue;
        }
        this.inZ = com.tencent.mm.pluginsdk.model.app.h.a(this.context, false, this.DsE);
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
        this.inZ = com.tencent.mm.pluginsdk.model.app.h.a(this.context, false, this.DsE);
        continue;
      }
      if (!eOf()) {
        gU(this.inZ);
      }
      gT(this.inZ);
      eOa();
      eNO();
      AppMethodBeat.o(31460);
      return;
      this.DsC = ((Display)localObject).getHeight();
      this.DsD = ((Display)localObject).getWidth();
      break;
      this.inZ = com.tencent.mm.pluginsdk.model.app.h.a(this.context, true, this.DsE);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(31481);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      ac.d("MicroMsg.AppPanel", "onConfigChanged:" + paramConfiguration.orientation);
      if (paramConfiguration.orientation != 1) {
        break label76;
      }
    }
    label76:
    for (this.DsO = true;; this.DsO = false)
    {
      setNeedRefreshHeight(true);
      eOc();
      AppMethodBeat.o(31481);
      return;
    }
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(31478);
    ac.i("MicroMsg.AppPanel", "app panel refleshed: %s", new Object[] { Integer.valueOf(this.DsE) });
    com.tencent.e.h.JZN.aTz("AppPanel-refresh");
    com.tencent.e.h.JZN.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196124);
        AppPanel.g(AppPanel.this).clear();
        for (;;)
        {
          try
          {
            String str = com.tencent.mm.m.g.ZY().getValue("ShowAPPSuggestion");
            if ((!bs.isNullOrNil(str)) && (Integer.valueOf(str).intValue() == 1)) {
              continue;
            }
            AppPanel.a(AppPanel.this, com.tencent.mm.pluginsdk.model.app.h.a(AppPanel.j(AppPanel.this), false, AppPanel.k(AppPanel.this)));
            ac.i("MicroMsg.AppPanel", "jacks not show App Suggestion");
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
            AppPanel.a(AppPanel.this, com.tencent.mm.pluginsdk.model.app.h.a(AppPanel.j(AppPanel.this), false, AppPanel.k(AppPanel.this)));
            continue;
          }
          com.tencent.e.h.JZN.aQ(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(196123);
              if (!AppPanel.l(AppPanel.this)) {
                AppPanel.gV(AppPanel.g(AppPanel.this));
              }
              AppPanel.b(AppPanel.this, AppPanel.g(AppPanel.this));
              if (AppPanel.this.DsB != null)
              {
                AppPanel.this.DsB.vi(AppPanel.m(AppPanel.this));
                AppPanel.this.DsB.vj(AppPanel.n(AppPanel.this));
                AppPanel.this.DsB.vm(AppPanel.o(AppPanel.this));
                AppPanel.this.DsB.vn(AppPanel.p(AppPanel.this));
              }
              int i = AppPanel.q(AppPanel.this).getCurScreen();
              AppPanel.d(AppPanel.this);
              AppPanel.q(AppPanel.this).setToScreen(i);
              AppPanel.e(AppPanel.this).setSelectedDot(i);
              AppMethodBeat.o(196123);
            }
          });
          AppMethodBeat.o(196124);
          return;
          ac.i("MicroMsg.AppPanel", "jacks show App Suggestion");
          AppPanel.a(AppPanel.this, com.tencent.mm.pluginsdk.model.app.h.a(AppPanel.j(AppPanel.this), true, AppPanel.k(AppPanel.this)));
        }
      }
    }, "AppPanel-refresh");
    AppMethodBeat.o(31478);
  }
  
  public void setAppPanelListener(a parama)
  {
    this.Dsu = parama;
  }
  
  public void setAppPanelUnCertainEnterArrayList(ArrayList<a.a> paramArrayList)
  {
    this.DsB.Dtz = paramArrayList;
  }
  
  public void setChattingContext(ChatFooter.b paramb)
  {
    this.Dsw = paramb;
  }
  
  public void setNeedRefreshHeight(boolean paramBoolean)
  {
    this.DsT = paramBoolean;
  }
  
  public void setOnSwitchPanelListener(b paramb)
  {
    this.Dsv = paramb;
  }
  
  public void setPortHeighDP(int paramInt)
  {
    if (xgx != paramInt)
    {
      xgx = paramInt;
      this.DsT = true;
    }
  }
  
  public void setPortHeighPx(int paramInt)
  {
    if (this.DsU != paramInt)
    {
      this.DsU = paramInt;
      this.DsT = true;
    }
  }
  
  public void setServiceShowFlag(int paramInt)
  {
    AppMethodBeat.i(31461);
    ac.i("MicroMsg.AppPanel", "setServiceShowFlag: %s", new Object[] { Integer.valueOf(paramInt) });
    this.DsE = paramInt;
    AppMethodBeat.o(31461);
  }
  
  public void setUncertainEnterLocation(int paramInt)
  {
    this.DsA = paramInt;
  }
  
  public final void ve(boolean paramBoolean)
  {
    AppMethodBeat.i(31466);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.DsB.Dtd.value = paramBoolean;
      eNZ();
      ac.d("MicroMsg.AppPanel", "enable " + paramBoolean + " isVoipPluginEnable " + this.DsB.Dte.value);
      AppMethodBeat.o(31466);
      return;
    }
  }
  
  public final void vf(boolean paramBoolean)
  {
    AppMethodBeat.i(31467);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.DsB.Dtj.value = paramBoolean;
      eNZ();
      ac.d("MicroMsg.AppPanel", "enable " + this.DsB.Dtk.value + " isVoipAudioEnable " + paramBoolean);
      AppMethodBeat.o(31467);
      return;
    }
  }
  
  public final void vg(boolean paramBoolean)
  {
    AppMethodBeat.i(31468);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.DsB.Dts.value = paramBoolean;
      eNZ();
      ac.d("MicroMsg.AppPanel", "enable " + this.DsB.Dts.value + " isMultiTalkEnable " + paramBoolean);
      AppMethodBeat.o(31468);
      return;
    }
  }
  
  public final void vh(boolean paramBoolean)
  {
    AppMethodBeat.i(31469);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.DsB.Dtl.value = paramBoolean;
      eNZ();
      AppMethodBeat.o(31469);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Im(int paramInt);
    
    public abstract void In(int paramInt);
    
    public abstract void d(com.tencent.mm.pluginsdk.model.app.g paramg);
    
    public abstract void dbN();
    
    public abstract void dbO();
    
    public abstract void dbP();
    
    public abstract void dbQ();
    
    public abstract void dbR();
    
    public abstract void dbS();
    
    public abstract void dbT();
    
    public abstract void dbU();
    
    public abstract void dbV();
    
    public abstract void dbW();
    
    public abstract void dbX();
    
    public abstract void dbY();
    
    public abstract void dbZ();
    
    public abstract void dca();
    
    public abstract void dcb();
    
    public abstract void dcc();
    
    public abstract void dcd();
  }
  
  public static abstract interface b
  {
    public abstract void eOh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel
 * JD-Core Version:    0.7.0.1
 */