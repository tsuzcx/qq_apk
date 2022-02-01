package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.b;
import com.tencent.mm.g.b.a.du;
import com.tencent.mm.g.b.a.dv;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.MMFlipper.a;
import com.tencent.mm.ui.base.MMFlipper.b;
import com.tencent.mm.ui.base.MMFlipper.c;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel
  extends LinearLayout
{
  private static boolean Fqq = false;
  private static int yKy = 215;
  private static int yKz = 158;
  private int FpD;
  private int FpG;
  private final boolean[] FpR;
  private a FpS;
  private b FpT;
  private ChatFooter.b FpU;
  private List<AppGrid> FpV;
  private int FpW;
  public int FpX;
  private int FpY;
  public a FpZ;
  private int Fqa;
  private int Fqb;
  private int Fqc;
  private boolean Fqd;
  private boolean Fqe;
  private boolean Fqf;
  private boolean Fqg;
  boolean Fqh;
  boolean Fqi;
  boolean Fqj;
  boolean Fqk;
  private Map<String, com.tencent.mm.pluginsdk.model.app.g> Fql;
  private boolean Fqm;
  private final int Fqn;
  private int Fqo;
  private AppGrid.b Fqp;
  private boolean Fqr;
  private int Fqs;
  private boolean cBE;
  Context context;
  private List<com.tencent.mm.pluginsdk.model.app.g> iKp;
  private SharedPreferences sp;
  private int tNA;
  private boolean yKN;
  private int yKO;
  private int yKP;
  public MMFlipper yKQ;
  private MMDotView yKR;
  
  public AppPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31459);
    this.FpR = new boolean[21];
    this.yKN = false;
    this.FpG = 21;
    this.tNA = this.FpG;
    this.FpX = 0;
    this.FpY = -1;
    this.cBE = false;
    this.Fqa = 0;
    this.Fqb = 0;
    this.Fqc = 0;
    this.Fqd = false;
    this.Fqe = false;
    this.Fqf = false;
    this.Fqg = false;
    this.Fqh = false;
    this.Fqi = false;
    this.Fqj = false;
    this.Fqk = false;
    this.Fql = null;
    this.Fqm = true;
    this.iKp = new LinkedList();
    this.Fqn = 2;
    this.Fqo = -1;
    this.Fqp = new AppGrid.b()
    {
      public final int ZG(int paramAnonymousInt)
      {
        AppMethodBeat.i(186736);
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
                AppMethodBeat.o(186736);
                return i;
              }
              k = j + 1;
            }
            i += 1;
          }
        }
        if ((paramAnonymousInt >= AppPanel.f(AppPanel.this)) && (paramAnonymousInt < AppPanel.s(AppPanel.this)))
        {
          AppMethodBeat.o(186736);
          return -2147483648;
        }
        AppMethodBeat.o(186736);
        return 2147483647;
      }
      
      public final void ZH(int paramAnonymousInt)
      {
        AppMethodBeat.i(186737);
        if (paramAnonymousInt == 0)
        {
          if (!AppPanel.this.FpZ.Fqy.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(186737);
            return;
          }
          AppPanel.a(AppPanel.this, true);
          AppMethodBeat.o(186737);
          return;
        }
        AppMethodBeat.o(186737);
      }
      
      public final void a(int paramAnonymousInt, com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        int i = 0;
        AppMethodBeat.i(186738);
        if (paramAnonymousg != null) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          ae.d("MicroMsg.AppPanel", "pos=%d, has appInfo = %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool1) });
          if ((paramAnonymousg != null) && (com.tencent.mm.pluginsdk.model.app.h.o(paramAnonymousg))) {
            v.aF(paramAnonymousg.field_appId, "1");
          }
          AppPanel.d(AppPanel.this, AppPanel.q(AppPanel.this).getCurScreen());
          if (!(paramAnonymousg instanceof a.a)) {
            break label358;
          }
          paramAnonymousg = (a.a)paramAnonymousg;
          ae.i("MicroMsg.AppPanel", "jump_type:%s", new Object[] { Integer.valueOf(paramAnonymousg.uIW) });
          if ((paramAnonymousg.Fro == null) || (paramAnonymousg.Fro.fgY() == null)) {
            break;
          }
          AppPanel.a(AppPanel.this, paramAnonymousg.Fro.fgY());
          AppMethodBeat.o(186738);
          return;
        }
        Object localObject;
        if (paramAnonymousg.uIW == 1)
        {
          localObject = new com.tencent.mm.plugin.appbrand.api.f();
          if (!TextUtils.isEmpty(paramAnonymousg.Frb))
          {
            ((com.tencent.mm.plugin.appbrand.api.f)localObject).username = paramAnonymousg.Frb;
            ((com.tencent.mm.plugin.appbrand.api.f)localObject).version = paramAnonymousg.Frd;
          }
        }
        for (;;)
        {
          try
          {
            ((com.tencent.mm.plugin.appbrand.api.f)localObject).hSZ = Integer.parseInt(paramAnonymousg.Frf);
            ((com.tencent.mm.plugin.appbrand.api.f)localObject).jFL = paramAnonymousg.Fre;
            ((com.tencent.mm.plugin.appbrand.api.f)localObject).scene = 1156;
            ((com.tencent.mm.plugin.appbrand.api.f)localObject).jFV = paramAnonymousg.jFV;
            ((p)com.tencent.mm.kernel.g.ab(p.class)).a(AppPanel.this.getContext(), (com.tencent.mm.plugin.appbrand.api.f)localObject);
            localObject = new du();
            ((du)localObject).dQB = 2L;
            ((du)localObject).eiI = 0L;
            ((du)localObject).nz(paramAnonymousg.FqZ);
            ((du)localObject).aLH();
            AppMethodBeat.o(186738);
            return;
            ((com.tencent.mm.plugin.appbrand.api.f)localObject).appId = paramAnonymousg.Frc;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            ((com.tencent.mm.plugin.appbrand.api.f)localObject).hSZ = 0;
            continue;
          }
          if (paramAnonymousg.uIW == 2) {
            com.tencent.mm.plugin.account.a.b.a.b(AppPanel.j(AppPanel.this), paramAnonymousg.mdj, 0, true);
          }
        }
        label358:
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(186738);
          return;
          if (AppPanel.g(AppPanel.this) == null)
          {
            ae.e("MicroMsg.AppPanel", "infoList == null");
            AppMethodBeat.o(186738);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(10305, String.valueOf(AppPanel.g(AppPanel.this).size()));
          com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(10) });
          com.tencent.mm.kernel.g.ajR().ajA().set(69121, "");
          AppPanel.t(AppPanel.this).dom();
          AppMethodBeat.o(186738);
          return;
          localObject = paramAnonymousg;
          if (paramAnonymousg == null) {
            localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.u(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.Ffa);
          }
          bc.aCg();
          paramAnonymousInt = ((Integer)com.tencent.mm.model.c.ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
          bc.aCg();
          paramAnonymousg = bu.U(((String)com.tencent.mm.model.c.ajA().get(am.a.IRW, "")).split(";"));
          if (!paramAnonymousg.contains(String.valueOf(paramAnonymousInt)))
          {
            paramAnonymousg.add(String.valueOf(paramAnonymousInt));
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(am.a.IRW, bu.m(paramAnonymousg, ";"));
            AppPanel.this.refresh();
          }
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(80, Boolean.FALSE);
          AppPanel.t(AppPanel.this).d((com.tencent.mm.pluginsdk.model.app.g)localObject);
          AppMethodBeat.o(186738);
          return;
          if (!AppPanel.this.FpZ.FqF.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(186738);
            return;
          }
          if (paramAnonymousg == null)
          {
            ae.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
            AppMethodBeat.o(186738);
            return;
          }
          if ((paramAnonymousg.fdF()) || (paramAnonymousg.fdI()))
          {
            if (AppPanel.v(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(ak.fow(), 0));
            }
            if (AppPanel.v(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
              AppPanel.v(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
            }
            if (paramAnonymousg.fdI()) {
              com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(16), paramAnonymousg.field_appId, Integer.valueOf(0) });
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(13), paramAnonymousg.field_appId, Integer.valueOf(0) });
          }
          for (;;)
          {
            AppPanel.t(AppPanel.this).d(paramAnonymousg);
            AppMethodBeat.o(186738);
            return;
            com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(11), paramAnonymousg.field_appId });
          }
          if (AppPanel.w(AppPanel.this))
          {
            AppPanel.x(AppPanel.this);
            AppMethodBeat.o(186738);
            return;
          }
          paramAnonymousg = ((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.d.class)).anC(AppPanel.i(AppPanel.this).getTalkerUserName());
          if (!TextUtils.isEmpty(paramAnonymousg))
          {
            AppPanel.a(AppPanel.this, paramAnonymousg);
            AppMethodBeat.o(186738);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(14) });
          paramAnonymousg = AppPanel.t(AppPanel.this);
          if (AppPanel.this.FpZ.FqO.value) {}
          for (paramAnonymousInt = i;; paramAnonymousInt = 2)
          {
            paramAnonymousg.Ki(paramAnonymousInt);
            AppMethodBeat.o(186738);
            return;
          }
          if (!AppPanel.this.FpZ.Fqz.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(186738);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(4) });
          AppPanel.t(AppPanel.this).dol();
          AppMethodBeat.o(186738);
          return;
          if (!AppPanel.this.FpZ.FqP.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(186738);
            return;
          }
          if (paramAnonymousg == null)
          {
            localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.u(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.Ffc);
            paramAnonymousg = (com.tencent.mm.pluginsdk.model.app.g)localObject;
            if (localObject == null)
            {
              AppMethodBeat.o(186738);
              return;
            }
          }
          if ((paramAnonymousg.fdF()) || (paramAnonymousg.fdI()))
          {
            if (AppPanel.v(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(ak.fow(), 0));
            }
            if (AppPanel.v(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
              AppPanel.v(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(13), paramAnonymousg.field_appId, Integer.valueOf(0) });
          }
          for (;;)
          {
            bc.aCg();
            paramAnonymousInt = ((Integer)com.tencent.mm.model.c.ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
            bc.aCg();
            paramAnonymousg = bu.U(((String)com.tencent.mm.model.c.ajA().get(am.a.IRX, "")).split(";"));
            if (!paramAnonymousg.contains(String.valueOf(paramAnonymousInt)))
            {
              paramAnonymousg.add(String.valueOf(paramAnonymousInt));
              bc.aCg();
              com.tencent.mm.model.c.ajA().set(am.a.IRX, bu.m(paramAnonymousg, ";"));
              AppPanel.this.refresh();
            }
            AppPanel.t(AppPanel.this).doq();
            AppMethodBeat.o(186738);
            return;
            com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(11), paramAnonymousg.field_appId });
          }
          if ((!AppPanel.this.FpZ.FqL.value) || (!AppPanel.this.FpZ.FqM.value))
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(186738);
            return;
          }
          bc.aCg();
          if (((Boolean)com.tencent.mm.model.c.ajA().get(290817, Boolean.TRUE)).booleanValue())
          {
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(290817, Boolean.FALSE);
            AppPanel.this.refresh();
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(3) });
          AppPanel.t(AppPanel.this).dok();
          AppMethodBeat.o(186738);
          return;
          if (!AppPanel.this.FpZ.FqD.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(186738);
            return;
          }
          bc.aCg();
          if (((Boolean)com.tencent.mm.model.c.ajA().get(327744, Boolean.TRUE)).booleanValue())
          {
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(327744, Boolean.FALSE);
            AppPanel.this.refresh();
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(12) });
          AppPanel.t(AppPanel.this).doo();
          AppMethodBeat.o(186738);
          return;
          if (AppPanel.w(AppPanel.this))
          {
            AppPanel.x(AppPanel.this);
            AppMethodBeat.o(186738);
            return;
          }
          paramAnonymousg = ((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.gamelife.a.d.class)).anB(AppPanel.i(AppPanel.this).getTalkerUserName());
          if (!TextUtils.isEmpty(paramAnonymousg))
          {
            AppPanel.a(AppPanel.this, paramAnonymousg);
            AppMethodBeat.o(186738);
            return;
          }
          if (!AppPanel.this.FpZ.Fqy.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(186738);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(1) });
          AppPanel.a(AppPanel.this, false);
          AppMethodBeat.o(186738);
          return;
          if (!AppPanel.this.FpZ.FqB.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(186738);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(8) });
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(54, Boolean.FALSE);
          if (AppPanel.t(AppPanel.this) != null)
          {
            paramAnonymousg = new wq();
            paramAnonymousg.dMc.dMe = true;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousg);
            paramAnonymousg = paramAnonymousg.dMd.dMg;
            if (!bu.isNullOrNil(paramAnonymousg))
            {
              ae.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramAnonymousg)));
              com.tencent.mm.ui.base.h.e(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131764350), "", AppPanel.j(AppPanel.this).getString(2131755835), AppPanel.j(AppPanel.this).getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(186732);
                  wq localwq = new wq();
                  localwq.dMc.dMf = true;
                  com.tencent.mm.sdk.b.a.IvT.l(localwq);
                  AppPanel.t(AppPanel.this).doh();
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(186732);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(186733);
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(186733);
                }
              });
              AppMethodBeat.o(186738);
              return;
            }
            AppPanel.t(AppPanel.this).doh();
            AppMethodBeat.o(186738);
            return;
            if (!AppPanel.this.FpZ.FqH.value)
            {
              Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
              AppMethodBeat.o(186738);
              return;
            }
            com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(7) });
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(62, Boolean.FALSE);
            paramAnonymousg = new wq();
            paramAnonymousg.dMc.dMe = true;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousg);
            paramAnonymousg = paramAnonymousg.dMd.dMg;
            if (!bu.isNullOrNil(paramAnonymousg))
            {
              ae.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramAnonymousg)));
              com.tencent.mm.ui.base.h.e(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131764350), "", AppPanel.j(AppPanel.this).getString(2131755835), AppPanel.j(AppPanel.this).getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(186734);
                  wq localwq = new wq();
                  localwq.dMc.dMf = true;
                  com.tencent.mm.sdk.b.a.IvT.l(localwq);
                  AppPanel.t(AppPanel.this).doi();
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(186734);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(186735);
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(186735);
                }
              });
              AppMethodBeat.o(186738);
              return;
            }
            AppPanel.t(AppPanel.this).doi();
            AppMethodBeat.o(186738);
            return;
            if (AppPanel.t(AppPanel.this) != null)
            {
              com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(6) });
              bc.aCg();
              com.tencent.mm.model.c.ajA().set(67, Boolean.FALSE);
              AppPanel.t(AppPanel.this).doj();
              AppMethodBeat.o(186738);
              return;
              if (AppPanel.w(AppPanel.this))
              {
                AppPanel.x(AppPanel.this);
                AppMethodBeat.o(186738);
                return;
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(9) });
              bc.aCg();
              com.tencent.mm.model.c.ajA().set(73, Boolean.FALSE);
              AppPanel.y(AppPanel.this).fgU();
              AppMethodBeat.o(186738);
              return;
              if (!AppPanel.this.FpZ.FqA.value)
              {
                Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                AppMethodBeat.o(186738);
                return;
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(5) });
              if (AppPanel.t(AppPanel.this) != null)
              {
                AppPanel.t(AppPanel.this).don();
                AppMethodBeat.o(186738);
                return;
                if (!AppPanel.this.FpZ.FqN.value)
                {
                  Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                  AppMethodBeat.o(186738);
                  return;
                }
                if (AppPanel.t(AppPanel.this) != null) {
                  AppPanel.t(AppPanel.this).dop();
                }
                com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(15) });
                bc.aCg();
                bool1 = ((Boolean)com.tencent.mm.model.c.ajA().get(208899, Boolean.FALSE)).booleanValue();
                bc.aCg();
                boolean bool2 = ((Boolean)com.tencent.mm.model.c.ajA().get(208913, Boolean.FALSE)).booleanValue();
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.g.yxI.f(11594, new Object[] { Integer.valueOf(3) });
                  AppMethodBeat.o(186738);
                  return;
                }
                if (bool2)
                {
                  com.tencent.mm.plugin.report.service.g.yxI.f(11594, new Object[] { Integer.valueOf(4) });
                  AppMethodBeat.o(186738);
                  return;
                  if (AppPanel.t(AppPanel.this) != null)
                  {
                    AppPanel.t(AppPanel.this).dor();
                    AppMethodBeat.o(186738);
                    return;
                    if (!AppPanel.this.FpZ.FqR.value)
                    {
                      Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                      AppMethodBeat.o(186738);
                      return;
                    }
                    AppPanel.t(AppPanel.this).dos();
                    AppMethodBeat.o(186738);
                    return;
                    if (!AppPanel.this.FpZ.FqX.value)
                    {
                      Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                      AppMethodBeat.o(186738);
                      return;
                    }
                    AppPanel.t(AppPanel.this).dot();
                    com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(21) });
                    AppMethodBeat.o(186738);
                    return;
                    if (AppPanel.t(AppPanel.this) != null)
                    {
                      if (paramAnonymousg == null)
                      {
                        localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.u(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.Ffd);
                        paramAnonymousg = (com.tencent.mm.pluginsdk.model.app.g)localObject;
                        if (localObject == null)
                        {
                          ae.i("MicroMsg.AppPanel", "empty info");
                          AppMethodBeat.o(186738);
                          return;
                        }
                      }
                      if ((paramAnonymousg.fdF()) || (paramAnonymousg.fdI()))
                      {
                        if (AppPanel.v(AppPanel.this) == null) {
                          AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(ak.fow(), 0));
                        }
                        if (AppPanel.v(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
                          AppPanel.v(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
                        }
                      }
                      AppPanel.t(AppPanel.this).dou();
                      AppMethodBeat.o(186738);
                      return;
                      if (!AppPanel.this.FpZ.FqT.value)
                      {
                        Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                        AppMethodBeat.o(186738);
                        return;
                      }
                      com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(17) });
                      if (AppPanel.t(AppPanel.this) != null)
                      {
                        AppPanel.t(AppPanel.this).dov();
                        AppMethodBeat.o(186738);
                        return;
                        if (!AppPanel.this.FpZ.FqU.value)
                        {
                          Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                          AppMethodBeat.o(186738);
                          return;
                        }
                        if (AppPanel.t(AppPanel.this) != null)
                        {
                          AppPanel.t(AppPanel.this).dox();
                          AppMethodBeat.o(186738);
                          return;
                          if (!AppPanel.this.FpZ.FqV.value)
                          {
                            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                            AppMethodBeat.o(186738);
                            return;
                          }
                          com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(19) });
                          if (AppPanel.t(AppPanel.this) != null)
                          {
                            AppPanel.t(AppPanel.this).doy();
                            AppMethodBeat.o(186738);
                            return;
                            if (!AppPanel.this.FpZ.FqW.value)
                            {
                              Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                              AppMethodBeat.o(186738);
                              return;
                            }
                            com.tencent.mm.plugin.report.service.g.yxI.f(10923, new Object[] { Integer.valueOf(20) });
                            if (AppPanel.t(AppPanel.this) != null)
                            {
                              AppPanel.t(AppPanel.this).dow();
                              com.tencent.mm.live.d.a.apu();
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
    this.Fqr = true;
    this.Fqs = -1;
    this.context = paramContext;
    AppMethodBeat.o(31459);
  }
  
  private int ZI(int paramInt)
  {
    int i = paramInt / this.FpD;
    if (paramInt % this.FpD > 0) {}
    for (paramInt = i;; paramInt = i - 1)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      return i;
    }
  }
  
  private void aOu(String paramString)
  {
    AppMethodBeat.i(186743);
    ae.i("MicroMsg.AppPanel", "showForbiddenDialog: %s", new Object[] { paramString });
    f.a locala = new f.a(ak.getContext());
    locala.aZq(paramString).zi(true);
    locala.afY(2131766205).b(new f.c()
    {
      public final void d(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).b(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
    }).show();
    AppMethodBeat.o(186743);
  }
  
  private void fgN()
  {
    AppMethodBeat.i(31477);
    ae.d("MicroMsg.AppPanel", "AppPanel initFlipper");
    this.Fqo = -1;
    this.yKQ.removeAllViews();
    this.yKQ.setOnMeasureListener(new MMFlipper.b()
    {
      public final void hs(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(31448);
        ae.i("MicroMsg.AppPanel", "onMeasure width:" + paramAnonymousInt1 + " height:" + paramAnonymousInt2 + " isMeasured:" + AppPanel.a(AppPanel.this));
        if ((AppPanel.a(AppPanel.this)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
        {
          if ((paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0)) {
            ae.d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
          }
          AppMethodBeat.o(31448);
          return;
        }
        if (AppPanel.b(AppPanel.this) == 2) {
          ae.d("MicroMsg.AppPanel", "landspace");
        }
        for (;;)
        {
          AppPanel.c(AppPanel.this);
          AppPanel.a(AppPanel.this, paramAnonymousInt2);
          AppPanel.b(AppPanel.this, paramAnonymousInt1);
          AppPanel.d(AppPanel.this);
          AppMethodBeat.o(31448);
          return;
          ae.d("MicroMsg.AppPanel", "portrait");
        }
      }
    });
    this.yKQ.setOnFlipperViewShowedListener(new MMFlipper.a()
    {
      public final void ZJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(186728);
        ae.i("MicroMsg.AppPanel", "viewpage reshow %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == 1) && (AppPanel.this.FpZ.FqW.value)) {
          com.tencent.mm.live.d.e.aql();
        }
        AppMethodBeat.o(186728);
      }
    });
    this.yKQ.setOnScreenChangedListener(new MMFlipper.c()
    {
      public final void u(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(186729);
        AppPanel.e(AppPanel.this).setSelectedDot(paramAnonymousInt2);
        Object localObject2;
        if ((AppPanel.this.getVisibility() == 0) && (paramAnonymousInt1 != -1) && (paramAnonymousInt1 != paramAnonymousInt2) && (paramAnonymousBoolean))
        {
          if (AppPanel.this.FpZ.FqF.value) {}
          for (int i = AppPanel.f(AppPanel.this) + AppPanel.g(AppPanel.this).size();; i = AppPanel.f(AppPanel.this))
          {
            localObject1 = new du();
            ((du)localObject1).dQB = 1L;
            ((du)localObject1).eiI = 0L;
            localObject2 = new StringBuilder();
            int j = 0;
            while (j < AppPanel.this.getAppPanelUnCertainEnterArrayList().size())
            {
              AppPanel localAppPanel = AppPanel.this;
              if (paramAnonymousInt1 == AppPanel.c(localAppPanel, AppPanel.h(localAppPanel) + i + 1)) {
                ((StringBuilder)localObject2).append(((a.a)AppPanel.this.getAppPanelUnCertainEnterArrayList().get(j)).FqZ).append("|");
              }
              j += 1;
            }
          }
          ((du)localObject1).nz(((StringBuilder)localObject2).toString());
          ((du)localObject1).aLH();
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
          localObject2 = new dv();
          ((dv)localObject2).nA((String)localObject1);
          ((dv)localObject2).eiI = 0L;
          ((dv)localObject2).nB("19");
          ((dv)localObject2).aLH();
          ae.i("MicroMsg.AppPanel", "scroll to show page %s", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt2 == 1) && (AppPanel.this.FpZ.FqW.value)) {
            com.tencent.mm.live.d.e.aql();
          }
          AppMethodBeat.o(186729);
          return;
        }
      }
    });
    fgR();
    AppMethodBeat.o(31477);
  }
  
  private void fgO()
  {
    AppMethodBeat.i(163206);
    if (this.FpY == -1)
    {
      AppMethodBeat.o(163206);
      return;
    }
    if (this.FpZ.FqF.value) {}
    du localdu;
    StringBuilder localStringBuilder;
    for (int i = this.FpG + this.iKp.size();; i = this.FpG)
    {
      this.FpX = ZI(this.FpY + i + 1);
      this.yKQ.setToScreen(this.FpX);
      this.FpY = -1;
      localdu = new du();
      localdu.dQB = 1L;
      localdu.eiI = 1L;
      localStringBuilder = new StringBuilder();
      int j = 0;
      while (j < getAppPanelUnCertainEnterArrayList().size())
      {
        if (this.FpX == ZI(this.FpY + i + 1)) {
          localStringBuilder.append(((a.a)getAppPanelUnCertainEnterArrayList().get(j)).FqZ).append("|");
        }
        j += 1;
      }
    }
    localdu.nz(localStringBuilder.toString());
    localdu.aLH();
    AppMethodBeat.o(163206);
  }
  
  private void fgP()
  {
    AppMethodBeat.i(31482);
    ae.i("MicroMsg.AppPanel", "[dealOrientationChange]");
    this.yKN = false;
    this.yKQ.setToScreen(0);
    fgN();
    requestLayout();
    AppMethodBeat.o(31482);
  }
  
  private void fgR()
  {
    AppMethodBeat.i(31484);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.Fqr)
    {
      if (getScreenOrientation() != 2) {
        break label79;
      }
      ae.d("MicroMsg.AppPanel", "initFlipper, landscape");
      localView = findViewById(2131296867);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = BackwardSupportUtil.b.h(this.context, yKz);
      localView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.Fqr = false;
      AppMethodBeat.o(31484);
      return;
      label79:
      ae.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", new Object[] { Integer.valueOf(yKy) });
      localView = findViewById(2131296867);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = getPortHeightPX();
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private boolean fgS()
  {
    AppMethodBeat.i(31487);
    if (this.Fqk)
    {
      AppMethodBeat.o(31487);
      return false;
    }
    com.tencent.mm.plugin.card.c.b localb = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.card.c.b.class);
    if (localb != null)
    {
      if ((localb.bWz()) && (localb.bWC() > 0))
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
  
  private int getPortHeightPX()
  {
    AppMethodBeat.i(31485);
    if (this.Fqs > 0)
    {
      i = this.Fqs;
      AppMethodBeat.o(31485);
      return i;
    }
    int i = BackwardSupportUtil.b.h(this.context, yKy);
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
  
  private void ho(List<com.tencent.mm.pluginsdk.model.app.g> paramList)
  {
    AppMethodBeat.i(31462);
    boolean bool1 = this.Fqd;
    this.Fqd = false;
    boolean bool2 = this.Fqe;
    boolean bool3 = this.Fqf;
    boolean bool4 = this.Fqg;
    this.Fqe = false;
    this.Fqf = false;
    this.Fqg = false;
    int j = com.tencent.mm.pluginsdk.model.app.h.YZ(this.Fqc);
    int k = this.Fqc;
    if (paramList != null) {}
    for (int i = paramList.size();; i = -1)
    {
      ae.i("MicroMsg.AppPanel", "serviceCount, %d, %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      this.Fql = new HashMap();
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
            if (localg.fdF())
            {
              if (!localg.fdH()) {
                this.Fqd = true;
              }
              j = i;
              if (com.tencent.mm.pluginsdk.model.app.g.Ffa.equals(localg.field_appId))
              {
                this.Fql.put(com.tencent.mm.pluginsdk.model.app.g.Ffa, localg);
                ae.i("MicroMsg.AppPanel", "remittance: %s, %s", new Object[] { Boolean.valueOf(this.Fqi), Boolean.valueOf(this.Fqe) });
                if (!this.Fqi) {
                  this.Fqe = true;
                }
                paramList.remove(i);
                j = i - 1;
              }
              i = j;
              if (com.tencent.mm.pluginsdk.model.app.g.Ffc.equals(localg.field_appId))
              {
                this.Fql.put(com.tencent.mm.pluginsdk.model.app.g.Ffc, localg);
                ae.i("MicroMsg.AppPanel", "luckyMoney: %s, %s", new Object[] { Boolean.valueOf(this.Fqh), Boolean.valueOf(this.Fqf) });
                if (!this.Fqh) {
                  this.Fqf = true;
                }
                paramList.remove(j);
                i = j - 1;
              }
              j = i;
              if (com.tencent.mm.pluginsdk.model.app.g.Ffd.equals(localg.field_appId))
              {
                this.Fql.put(com.tencent.mm.pluginsdk.model.app.g.Ffd, localg);
                ae.i("MicroMsg.AppPanel", "aa: %s, %s", new Object[] { Boolean.valueOf(this.Fqh), Boolean.valueOf(this.Fqf) });
                if (!this.Fqj) {
                  this.Fqg = true;
                }
                paramList.remove(i);
                j = i - 1;
              }
            }
          }
        }
      }
    }
    com.tencent.mm.plugin.report.service.g.yxI.dD(965, 36);
    label485:
    ae.i("MicroMsg.AppPanel", "hasService %b", new Object[] { Boolean.valueOf(this.Fqd) });
    if ((bool1 != this.Fqd) || (bool2 != this.Fqe) || (bool3 != this.Fqf) || (bool4 != this.Fqg))
    {
      this.FpZ.wc(this.Fqd);
      this.FpZ.wd(this.Fqe);
      this.FpZ.wg(this.Fqf);
      this.FpZ.wh(this.Fqg);
      fgM();
    }
    AppMethodBeat.o(31462);
  }
  
  private static void hp(List<com.tencent.mm.pluginsdk.model.app.g> paramList)
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
      if ((localg != null) && (com.tencent.mm.pluginsdk.model.app.g.Ffb.equals(localg.field_appId)))
      {
        paramList.remove(localg);
        ae.i("MicroMsg.AppPanel", "do remove card");
        AppMethodBeat.o(31486);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(31486);
  }
  
  public final void fgB()
  {
    AppMethodBeat.i(31463);
    this.FpZ.fgV();
    this.Fqh = false;
    this.Fqi = false;
    this.Fqj = false;
    this.Fqk = false;
    fgC();
    this.FpZ.wc(this.Fqd);
    this.FpZ.wd(this.Fqe);
    this.FpZ.wg(this.Fqf);
    this.FpZ.wh(this.Fqg);
    fgM();
    AppMethodBeat.o(31463);
  }
  
  public final void fgC()
  {
    AppMethodBeat.i(31464);
    com.tencent.mm.n.g.acM();
    if (com.tencent.mm.n.c.acx() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.FpZ.fgW();
      this.FpZ.we(bool);
      bool = com.tencent.mm.br.d.aJN("location");
      this.FpZ.wf(bool);
      this.FpZ.fgX();
      AppMethodBeat.o(31464);
      return;
    }
  }
  
  public final void fgD()
  {
    AppMethodBeat.i(31465);
    this.FpZ.Fqz.value = false;
    fgM();
    AppMethodBeat.o(31465);
  }
  
  public final void fgE()
  {
    AppMethodBeat.i(31470);
    this.FpZ.FqG.value = false;
    fgM();
    ae.d("MicroMsg.AppPanel", "disableTalkroom enable false");
    AppMethodBeat.o(31470);
  }
  
  public final void fgF()
  {
    AppMethodBeat.i(31471);
    this.FpZ.FqL.value = false;
    fgM();
    AppMethodBeat.o(31471);
  }
  
  public final void fgG()
  {
    AppMethodBeat.i(31472);
    this.FpZ.FqF.value = false;
    fgM();
    AppMethodBeat.o(31472);
  }
  
  public final void fgH()
  {
    AppMethodBeat.i(31473);
    this.FpZ.FqN.value = false;
    fgM();
    AppMethodBeat.o(31473);
  }
  
  public final void fgI()
  {
    AppMethodBeat.i(31474);
    this.FpZ.FqT.value = false;
    fgM();
    AppMethodBeat.o(31474);
  }
  
  public final void fgJ()
  {
    AppMethodBeat.i(185751);
    this.FpZ.FqU.value = false;
    fgM();
    AppMethodBeat.o(185751);
  }
  
  public final void fgK()
  {
    AppMethodBeat.i(186740);
    this.FpZ.FqV.value = false;
    fgM();
    AppMethodBeat.o(186740);
  }
  
  public final void fgL()
  {
    AppMethodBeat.i(186741);
    this.FpZ.wi(false);
    fgM();
    AppMethodBeat.o(186741);
  }
  
  public final void fgM()
  {
    AppMethodBeat.i(31475);
    int j = this.FpR.length;
    int i = 0;
    while (i < j)
    {
      this.FpR[i] = true;
      i += 1;
    }
    if (!this.FpZ.Fqy.value) {
      this.FpR[0] = false;
    }
    for (j = 1;; j = 0)
    {
      i = j;
      if (!this.FpZ.Fqx.value)
      {
        this.FpR[1] = false;
        i = j + 1;
      }
      j = i;
      if (!this.FpZ.FqT.value)
      {
        this.FpR[19] = false;
        j = i + 1;
      }
      i = j;
      if (!this.FpZ.FqU.value)
      {
        this.FpR[12] = false;
        i = j + 1;
      }
      j = i;
      if (!this.FpZ.FqV.value)
      {
        this.FpR[13] = false;
        j = i + 1;
      }
      i = j;
      if (!this.FpZ.FqW.value)
      {
        this.FpR[14] = false;
        i = j + 1;
      }
      if (this.FpZ.FqL.value)
      {
        j = i;
        if (this.FpZ.FqM.value) {}
      }
      else
      {
        this.FpR[6] = false;
        j = i + 1;
      }
      i = j;
      if (!this.FpZ.FqD.value)
      {
        this.FpR[17] = false;
        i = j + 1;
      }
      j = i;
      if (!this.FpZ.FqE.value)
      {
        ae.i("MicroMsg.AppPanel", "disable remittance");
        this.FpR[8] = false;
        j = i + 1;
      }
      i = j;
      if (!this.FpZ.Fqz.value)
      {
        this.FpR[15] = false;
        i = j + 1;
      }
      j = i;
      if (!this.FpZ.FqN.value)
      {
        this.FpR[16] = false;
        j = i + 1;
      }
      i = j;
      if (!this.FpZ.FqQ.value)
      {
        this.FpR[3] = false;
        i = j + 1;
      }
      j = i;
      if (!this.FpZ.FqA.value)
      {
        this.FpR[11] = false;
        j = i + 1;
      }
      i = j;
      if (!this.FpZ.FqG.value)
      {
        this.FpR[5] = false;
        i = j + 1;
      }
      if (this.FpZ.FqI.value)
      {
        j = i;
        if (this.FpZ.FqH.value) {}
      }
      else
      {
        this.FpR[4] = false;
        j = i + 1;
      }
      if (this.FpZ.FqC.value)
      {
        i = j;
        if (this.FpZ.FqB.value) {}
      }
      else
      {
        this.FpR[2] = false;
        i = j + 1;
      }
      if (this.FpZ.FqK.value)
      {
        j = i;
        if (this.FpZ.FqJ.value) {}
      }
      else
      {
        this.FpR[10] = false;
        j = i + 1;
      }
      i = j;
      if (!this.FpZ.FqP.value)
      {
        ae.i("MicroMsg.AppPanel", "disable lucky money");
        this.FpR[7] = false;
        i = j + 1;
      }
      j = i;
      if (!this.FpZ.FqR.value)
      {
        this.FpR[18] = false;
        j = i + 1;
      }
      i = j;
      if (!this.FpZ.FqX.value)
      {
        this.FpR[20] = false;
        i = j + 1;
      }
      this.FpR[9] = false;
      this.FpG = (21 - (i + 1));
      AppMethodBeat.o(31475);
      return;
    }
  }
  
  public final void fgQ()
  {
    AppMethodBeat.i(31483);
    ae.i("MicroMsg.AppPanel", "[forceRefreshSize]");
    fgR();
    fgP();
    AppMethodBeat.o(31483);
  }
  
  public ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163205);
    ArrayList localArrayList = this.FpZ.getAppPanelUnCertainEnterArrayList();
    AppMethodBeat.o(163205);
    return localArrayList;
  }
  
  public int getCurScreen()
  {
    AppMethodBeat.i(186742);
    if (this.yKQ != null)
    {
      int i = this.yKQ.getCurScreen();
      AppMethodBeat.o(186742);
      return i;
    }
    AppMethodBeat.o(186742);
    return -1;
  }
  
  public int getPageMaxRowCount()
  {
    if (this.FpW == 0)
    {
      int i = (this.tNA + 3) / 4;
      if (i > 2) {
        return 2;
      }
      return i;
    }
    return this.FpW;
  }
  
  public final int getPosPage$134621()
  {
    int m = this.FpR.length;
    int j = 0;
    int i = 0;
    int k;
    if (j < m)
    {
      k = i;
      if (this.FpR[j] != 0) {
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
    i = j / this.FpD;
    if (j % this.FpD > 0) {}
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
    ae.i("MicroMsg.AppPanel", "init: %s", new Object[] { Integer.valueOf(paramInt) });
    this.FpZ = new a();
    this.Fqc = paramInt;
    Object localObject = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (((Display)localObject).getWidth() < ((Display)localObject).getHeight())
    {
      this.Fqa = ((Display)localObject).getWidth();
      this.Fqb = ((Display)localObject).getHeight();
      View.inflate(this.context, 2131493086, this);
      this.yKR = ((MMDotView)findViewById(2131296868));
      this.yKQ = ((MMFlipper)findViewById(2131296869));
    }
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.n.g.acL().getValue("ShowAPPSuggestion");
        if ((!bu.isNullOrNil((String)localObject)) && (Integer.valueOf((String)localObject).intValue() == 1)) {
          continue;
        }
        this.iKp = com.tencent.mm.pluginsdk.model.app.h.a(this.context, false, this.Fqc);
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
        this.iKp = com.tencent.mm.pluginsdk.model.app.h.a(this.context, false, this.Fqc);
        continue;
      }
      if (!fgS()) {
        hp(this.iKp);
      }
      ho(this.iKp);
      fgN();
      fgB();
      AppMethodBeat.o(31460);
      return;
      this.Fqa = ((Display)localObject).getHeight();
      this.Fqb = ((Display)localObject).getWidth();
      break;
      this.iKp = com.tencent.mm.pluginsdk.model.app.h.a(this.context, true, this.Fqc);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(31481);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      ae.d("MicroMsg.AppPanel", "onConfigChanged:" + paramConfiguration.orientation);
      if (paramConfiguration.orientation != 1) {
        break label76;
      }
    }
    label76:
    for (this.Fqm = true;; this.Fqm = false)
    {
      setNeedRefreshHeight(true);
      fgP();
      AppMethodBeat.o(31481);
      return;
    }
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(31478);
    ae.i("MicroMsg.AppPanel", "app panel refleshed: %s", new Object[] { Integer.valueOf(this.Fqc) });
    com.tencent.e.h.MqF.bbc("AppPanel-refresh");
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186731);
        AppPanel.g(AppPanel.this).clear();
        for (;;)
        {
          try
          {
            String str = com.tencent.mm.n.g.acL().getValue("ShowAPPSuggestion");
            if ((!bu.isNullOrNil(str)) && (Integer.valueOf(str).intValue() == 1)) {
              continue;
            }
            AppPanel.a(AppPanel.this, com.tencent.mm.pluginsdk.model.app.h.a(AppPanel.j(AppPanel.this), false, AppPanel.k(AppPanel.this)));
            ae.i("MicroMsg.AppPanel", "jacks not show App Suggestion");
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
            AppPanel.a(AppPanel.this, com.tencent.mm.pluginsdk.model.app.h.a(AppPanel.j(AppPanel.this), false, AppPanel.k(AppPanel.this)));
            continue;
          }
          if (!AppPanel.l(AppPanel.this)) {
            AppPanel.hq(AppPanel.g(AppPanel.this));
          }
          AppPanel.b(AppPanel.this, AppPanel.g(AppPanel.this));
          if (AppPanel.this.FpZ != null)
          {
            AppPanel.this.FpZ.wc(AppPanel.m(AppPanel.this));
            AppPanel.this.FpZ.wd(AppPanel.n(AppPanel.this));
            AppPanel.this.FpZ.wg(AppPanel.o(AppPanel.this));
            AppPanel.this.FpZ.wh(AppPanel.p(AppPanel.this));
          }
          com.tencent.e.h.MqF.aM(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186730);
              if (AppPanel.h(AppPanel.this) == -1) {}
              for (int i = AppPanel.q(AppPanel.this).getCurScreen();; i = -1)
              {
                AppPanel.d(AppPanel.this);
                if (i != -1)
                {
                  AppPanel.q(AppPanel.this).setToScreen(i);
                  AppPanel.e(AppPanel.this).setSelectedDot(i);
                }
                AppMethodBeat.o(186730);
                return;
              }
            }
          });
          AppMethodBeat.o(186731);
          return;
          ae.i("MicroMsg.AppPanel", "jacks show App Suggestion");
          AppPanel.a(AppPanel.this, com.tencent.mm.pluginsdk.model.app.h.a(AppPanel.j(AppPanel.this), true, AppPanel.k(AppPanel.this)));
        }
      }
    }, "AppPanel-refresh");
    AppMethodBeat.o(31478);
  }
  
  public void setAppPanelListener(a parama)
  {
    this.FpS = parama;
  }
  
  public void setAppPanelUnCertainEnterArrayList(ArrayList<a.a> paramArrayList)
  {
    this.FpZ.FqY = paramArrayList;
  }
  
  public void setChattingContext(ChatFooter.b paramb)
  {
    this.FpU = paramb;
  }
  
  public void setNeedRefreshHeight(boolean paramBoolean)
  {
    this.Fqr = paramBoolean;
  }
  
  public void setOnSwitchPanelListener(b paramb)
  {
    this.FpT = paramb;
  }
  
  public void setPortHeighDP(int paramInt)
  {
    if (yKy != paramInt)
    {
      yKy = paramInt;
      this.Fqr = true;
    }
  }
  
  public void setPortHeighPx(int paramInt)
  {
    if (this.Fqs != paramInt)
    {
      this.Fqs = paramInt;
      this.Fqr = true;
    }
  }
  
  public void setServiceShowFlag(int paramInt)
  {
    AppMethodBeat.i(31461);
    ae.i("MicroMsg.AppPanel", "setServiceShowFlag: %s", new Object[] { Integer.valueOf(paramInt) });
    this.Fqc = paramInt;
    AppMethodBeat.o(31461);
  }
  
  public void setUncertainEnterLocation(int paramInt)
  {
    this.FpY = paramInt;
  }
  
  public final void vY(boolean paramBoolean)
  {
    AppMethodBeat.i(31466);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.FpZ.FqB.value = paramBoolean;
      fgM();
      ae.d("MicroMsg.AppPanel", "enable " + paramBoolean + " isVoipPluginEnable " + this.FpZ.FqC.value);
      AppMethodBeat.o(31466);
      return;
    }
  }
  
  public final void vZ(boolean paramBoolean)
  {
    AppMethodBeat.i(31467);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.FpZ.FqH.value = paramBoolean;
      fgM();
      ae.d("MicroMsg.AppPanel", "enable " + this.FpZ.FqI.value + " isVoipAudioEnable " + paramBoolean);
      AppMethodBeat.o(31467);
      return;
    }
  }
  
  public final void wa(boolean paramBoolean)
  {
    AppMethodBeat.i(31468);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.FpZ.FqQ.value = paramBoolean;
      fgM();
      ae.d("MicroMsg.AppPanel", "enable " + this.FpZ.FqQ.value + " isMultiTalkEnable " + paramBoolean);
      AppMethodBeat.o(31468);
      return;
    }
  }
  
  public final void wb(boolean paramBoolean)
  {
    AppMethodBeat.i(31469);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.FpZ.FqJ.value = paramBoolean;
      fgM();
      AppMethodBeat.o(31469);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Kh(int paramInt);
    
    public abstract void Ki(int paramInt);
    
    public abstract void d(com.tencent.mm.pluginsdk.model.app.g paramg);
    
    public abstract void doh();
    
    public abstract void doi();
    
    public abstract void doj();
    
    public abstract void dok();
    
    public abstract void dol();
    
    public abstract void dom();
    
    public abstract void don();
    
    public abstract void doo();
    
    public abstract void dop();
    
    public abstract void doq();
    
    public abstract void dor();
    
    public abstract void dos();
    
    public abstract void dot();
    
    public abstract void dou();
    
    public abstract void dov();
    
    public abstract void dow();
    
    public abstract void dox();
    
    public abstract void doy();
  }
  
  public static abstract interface b
  {
    public abstract void fgU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel
 * JD-Core Version:    0.7.0.1
 */