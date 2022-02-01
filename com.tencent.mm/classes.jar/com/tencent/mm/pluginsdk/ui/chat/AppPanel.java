package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
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
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.wm.b;
import com.tencent.mm.g.b.a.ds;
import com.tencent.mm.g.b.a.dt;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.MMFlipper.a;
import com.tencent.mm.ui.base.MMFlipper.b;
import com.tencent.mm.ui.base.MMFlipper.c;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel
  extends LinearLayout
{
  private static boolean EXW = false;
  private static int yuy = 215;
  private static int yuz = 158;
  private ChatFooter.b EXA;
  private List<AppGrid> EXB;
  private int EXC;
  public int EXD;
  private int EXE;
  public a EXF;
  private int EXG;
  private int EXH;
  private int EXI;
  private boolean EXJ;
  private boolean EXK;
  private boolean EXL;
  private boolean EXM;
  boolean EXN;
  boolean EXO;
  boolean EXP;
  boolean EXQ;
  private Map<String, com.tencent.mm.pluginsdk.model.app.g> EXR;
  private boolean EXS;
  private final int EXT;
  private int EXU;
  private AppGrid.b EXV;
  private boolean EXX;
  private int EXY;
  private int EXj;
  private int EXm;
  private final boolean[] EXx;
  private a EXy;
  private b EXz;
  private boolean cAX;
  Context context;
  private List<com.tencent.mm.pluginsdk.model.app.g> iHw;
  private SharedPreferences sp;
  private int tCJ;
  private boolean yuN;
  private int yuO;
  private int yuP;
  public MMFlipper yuQ;
  private MMDotView yuR;
  
  public AppPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31459);
    this.EXx = new boolean[21];
    this.yuN = false;
    this.EXm = 21;
    this.tCJ = this.EXm;
    this.EXD = 0;
    this.EXE = -1;
    this.cAX = false;
    this.EXG = 0;
    this.EXH = 0;
    this.EXI = 0;
    this.EXJ = false;
    this.EXK = false;
    this.EXL = false;
    this.EXM = false;
    this.EXN = false;
    this.EXO = false;
    this.EXP = false;
    this.EXQ = false;
    this.EXR = null;
    this.EXS = true;
    this.iHw = new LinkedList();
    this.EXT = 2;
    this.EXU = -1;
    this.EXV = new AppGrid.b()
    {
      public final int Za(int paramAnonymousInt)
      {
        AppMethodBeat.i(193456);
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
                AppMethodBeat.o(193456);
                return i;
              }
              k = j + 1;
            }
            i += 1;
          }
        }
        if ((paramAnonymousInt >= AppPanel.f(AppPanel.this)) && (paramAnonymousInt < AppPanel.s(AppPanel.this)))
        {
          AppMethodBeat.o(193456);
          return -2147483648;
        }
        AppMethodBeat.o(193456);
        return 2147483647;
      }
      
      public final void Zb(int paramAnonymousInt)
      {
        AppMethodBeat.i(193457);
        if (paramAnonymousInt == 0)
        {
          if (!AppPanel.this.EXF.EYe.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(193457);
            return;
          }
          AppPanel.a(AppPanel.this, true);
          AppMethodBeat.o(193457);
          return;
        }
        AppMethodBeat.o(193457);
      }
      
      public final void a(int paramAnonymousInt, com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        int i = 0;
        AppMethodBeat.i(193458);
        boolean bool1;
        Object localObject;
        if (paramAnonymousg != null)
        {
          bool1 = true;
          ad.d("MicroMsg.AppPanel", "pos=%d, has appInfo = %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool1) });
          if ((paramAnonymousg != null) && (com.tencent.mm.pluginsdk.model.app.h.o(paramAnonymousg))) {
            u.aE(paramAnonymousg.field_appId, "1");
          }
          AppPanel.d(AppPanel.this, AppPanel.q(AppPanel.this).getCurScreen());
          if (!(paramAnonymousg instanceof a.a)) {
            break label295;
          }
          paramAnonymousg = (a.a)paramAnonymousg;
          ad.i("MicroMsg.AppPanel", "jump_type:%s", new Object[] { Integer.valueOf(paramAnonymousg.uxt) });
          if (paramAnonymousg.uxt != 1) {
            break label268;
          }
          localObject = new com.tencent.mm.plugin.appbrand.api.f();
          ((com.tencent.mm.plugin.appbrand.api.f)localObject).username = paramAnonymousg.EYH;
          ((com.tencent.mm.plugin.appbrand.api.f)localObject).version = paramAnonymousg.EYI;
        }
        for (;;)
        {
          try
          {
            ((com.tencent.mm.plugin.appbrand.api.f)localObject).hQh = Integer.parseInt(paramAnonymousg.EYK);
            ((com.tencent.mm.plugin.appbrand.api.f)localObject).jCN = paramAnonymousg.EYJ;
            ((com.tencent.mm.plugin.appbrand.api.f)localObject).scene = 1156;
            ((com.tencent.mm.plugin.appbrand.api.f)localObject).jCX = paramAnonymousg.jCX;
            ((o)com.tencent.mm.kernel.g.ab(o.class)).a(AppPanel.this.getContext(), (com.tencent.mm.plugin.appbrand.api.f)localObject);
            localObject = new ds();
            ((ds)localObject).dPl = 2L;
            ((ds)localObject).egY = 0L;
            ((ds)localObject).ne(paramAnonymousg.EYF);
            ((ds)localObject).aLk();
            AppMethodBeat.o(193458);
            return;
            bool1 = false;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            ((com.tencent.mm.plugin.appbrand.api.f)localObject).hQh = 0;
            continue;
          }
          label268:
          if (paramAnonymousg.uxt == 2) {
            com.tencent.mm.plugin.account.a.b.a.b(AppPanel.j(AppPanel.this), paramAnonymousg.lYC, 0, true);
          }
        }
        label295:
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(193458);
          return;
          if (AppPanel.g(AppPanel.this) == null)
          {
            ad.e("MicroMsg.AppPanel", "infoList == null");
            AppMethodBeat.o(193458);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10305, String.valueOf(AppPanel.g(AppPanel.this).size()));
          com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(10) });
          com.tencent.mm.kernel.g.ajC().ajl().set(69121, "");
          AppPanel.t(AppPanel.this).dlm();
          AppMethodBeat.o(193458);
          return;
          localObject = paramAnonymousg;
          if (paramAnonymousg == null) {
            localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.u(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.EMD);
          }
          ba.aBQ();
          paramAnonymousInt = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
          ba.aBQ();
          paramAnonymousg = bt.U(((String)com.tencent.mm.model.c.ajl().get(al.a.Ixy, "")).split(";"));
          if (!paramAnonymousg.contains(String.valueOf(paramAnonymousInt)))
          {
            paramAnonymousg.add(String.valueOf(paramAnonymousInt));
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(al.a.Ixy, bt.m(paramAnonymousg, ";"));
            AppPanel.this.refresh();
          }
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(80, Boolean.FALSE);
          AppPanel.t(AppPanel.this).d((com.tencent.mm.pluginsdk.model.app.g)localObject);
          AppMethodBeat.o(193458);
          return;
          if (!AppPanel.this.EXF.EYl.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(193458);
            return;
          }
          if (paramAnonymousg == null)
          {
            ad.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
            AppMethodBeat.o(193458);
            return;
          }
          if ((paramAnonymousg.eZR()) || (paramAnonymousg.eZU()))
          {
            if (AppPanel.v(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(aj.fkC(), 0));
            }
            if (AppPanel.v(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
              AppPanel.v(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
            }
            if (paramAnonymousg.eZU()) {
              com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(16), paramAnonymousg.field_appId, Integer.valueOf(0) });
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(13), paramAnonymousg.field_appId, Integer.valueOf(0) });
          }
          for (;;)
          {
            AppPanel.t(AppPanel.this).d(paramAnonymousg);
            AppMethodBeat.o(193458);
            return;
            com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(11), paramAnonymousg.field_appId });
          }
          if (AppPanel.w(AppPanel.this))
          {
            AppPanel.x(AppPanel.this);
            AppMethodBeat.o(193458);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(14) });
          paramAnonymousg = AppPanel.t(AppPanel.this);
          if (AppPanel.this.EXF.EYu.value) {}
          for (paramAnonymousInt = i;; paramAnonymousInt = 2)
          {
            paramAnonymousg.JJ(paramAnonymousInt);
            AppMethodBeat.o(193458);
            return;
          }
          if (!AppPanel.this.EXF.EYf.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(193458);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(4) });
          AppPanel.t(AppPanel.this).dll();
          AppMethodBeat.o(193458);
          return;
          if (!AppPanel.this.EXF.EYv.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(193458);
            return;
          }
          if (paramAnonymousg == null)
          {
            localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.u(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.EMF);
            paramAnonymousg = (com.tencent.mm.pluginsdk.model.app.g)localObject;
            if (localObject == null)
            {
              AppMethodBeat.o(193458);
              return;
            }
          }
          if ((paramAnonymousg.eZR()) || (paramAnonymousg.eZU()))
          {
            if (AppPanel.v(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(aj.fkC(), 0));
            }
            if (AppPanel.v(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
              AppPanel.v(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(13), paramAnonymousg.field_appId, Integer.valueOf(0) });
          }
          for (;;)
          {
            ba.aBQ();
            paramAnonymousInt = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
            ba.aBQ();
            paramAnonymousg = bt.U(((String)com.tencent.mm.model.c.ajl().get(al.a.Ixz, "")).split(";"));
            if (!paramAnonymousg.contains(String.valueOf(paramAnonymousInt)))
            {
              paramAnonymousg.add(String.valueOf(paramAnonymousInt));
              ba.aBQ();
              com.tencent.mm.model.c.ajl().set(al.a.Ixz, bt.m(paramAnonymousg, ";"));
              AppPanel.this.refresh();
            }
            AppPanel.t(AppPanel.this).dlq();
            AppMethodBeat.o(193458);
            return;
            com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(11), paramAnonymousg.field_appId });
          }
          if ((!AppPanel.this.EXF.EYr.value) || (!AppPanel.this.EXF.EYs.value))
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(193458);
            return;
          }
          ba.aBQ();
          if (((Boolean)com.tencent.mm.model.c.ajl().get(290817, Boolean.TRUE)).booleanValue())
          {
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(290817, Boolean.FALSE);
            AppPanel.this.refresh();
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(3) });
          AppPanel.t(AppPanel.this).dlk();
          AppMethodBeat.o(193458);
          return;
          if (!AppPanel.this.EXF.EYj.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(193458);
            return;
          }
          ba.aBQ();
          if (((Boolean)com.tencent.mm.model.c.ajl().get(327744, Boolean.TRUE)).booleanValue())
          {
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(327744, Boolean.FALSE);
            AppPanel.this.refresh();
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(12) });
          AppPanel.t(AppPanel.this).dlo();
          AppMethodBeat.o(193458);
          return;
          if (AppPanel.w(AppPanel.this))
          {
            AppPanel.x(AppPanel.this);
            AppMethodBeat.o(193458);
            return;
          }
          if (!AppPanel.this.EXF.EYe.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(193458);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(1) });
          AppPanel.a(AppPanel.this, false);
          AppMethodBeat.o(193458);
          return;
          if (!AppPanel.this.EXF.EYh.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
            AppMethodBeat.o(193458);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(8) });
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(54, Boolean.FALSE);
          if (AppPanel.t(AppPanel.this) != null)
          {
            paramAnonymousg = new wm();
            paramAnonymousg.dKN.dKP = true;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousg);
            paramAnonymousg = paramAnonymousg.dKO.dKR;
            if (!bt.isNullOrNil(paramAnonymousg))
            {
              ad.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramAnonymousg)));
              com.tencent.mm.ui.base.h.e(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131764350), "", AppPanel.j(AppPanel.this).getString(2131755835), AppPanel.j(AppPanel.this).getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(193452);
                  wm localwm = new wm();
                  localwm.dKN.dKQ = true;
                  com.tencent.mm.sdk.b.a.IbL.l(localwm);
                  AppPanel.t(AppPanel.this).dlh();
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(193452);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(193453);
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(193453);
                }
              });
              AppMethodBeat.o(193458);
              return;
            }
            AppPanel.t(AppPanel.this).dlh();
            AppMethodBeat.o(193458);
            return;
            if (!AppPanel.this.EXF.EYn.value)
            {
              Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
              AppMethodBeat.o(193458);
              return;
            }
            com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(7) });
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(62, Boolean.FALSE);
            paramAnonymousg = new wm();
            paramAnonymousg.dKN.dKP = true;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousg);
            paramAnonymousg = paramAnonymousg.dKO.dKR;
            if (!bt.isNullOrNil(paramAnonymousg))
            {
              ad.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramAnonymousg)));
              com.tencent.mm.ui.base.h.e(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131764350), "", AppPanel.j(AppPanel.this).getString(2131755835), AppPanel.j(AppPanel.this).getString(2131755691), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(193454);
                  wm localwm = new wm();
                  localwm.dKN.dKQ = true;
                  com.tencent.mm.sdk.b.a.IbL.l(localwm);
                  AppPanel.t(AppPanel.this).dli();
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(193454);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(193455);
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(193455);
                }
              });
              AppMethodBeat.o(193458);
              return;
            }
            AppPanel.t(AppPanel.this).dli();
            AppMethodBeat.o(193458);
            return;
            if (AppPanel.t(AppPanel.this) != null)
            {
              com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(6) });
              ba.aBQ();
              com.tencent.mm.model.c.ajl().set(67, Boolean.FALSE);
              AppPanel.t(AppPanel.this).dlj();
              AppMethodBeat.o(193458);
              return;
              if (AppPanel.w(AppPanel.this))
              {
                AppPanel.x(AppPanel.this);
                AppMethodBeat.o(193458);
                return;
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(9) });
              ba.aBQ();
              com.tencent.mm.model.c.ajl().set(73, Boolean.FALSE);
              AppPanel.y(AppPanel.this).fdg();
              AppMethodBeat.o(193458);
              return;
              if (!AppPanel.this.EXF.EYg.value)
              {
                Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                AppMethodBeat.o(193458);
                return;
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(5) });
              if (AppPanel.t(AppPanel.this) != null)
              {
                AppPanel.t(AppPanel.this).dln();
                AppMethodBeat.o(193458);
                return;
                if (!AppPanel.this.EXF.EYt.value)
                {
                  Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                  AppMethodBeat.o(193458);
                  return;
                }
                if (AppPanel.t(AppPanel.this) != null) {
                  AppPanel.t(AppPanel.this).dlp();
                }
                com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(15) });
                ba.aBQ();
                bool1 = ((Boolean)com.tencent.mm.model.c.ajl().get(208899, Boolean.FALSE)).booleanValue();
                ba.aBQ();
                boolean bool2 = ((Boolean)com.tencent.mm.model.c.ajl().get(208913, Boolean.FALSE)).booleanValue();
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.g.yhR.f(11594, new Object[] { Integer.valueOf(3) });
                  AppMethodBeat.o(193458);
                  return;
                }
                if (bool2)
                {
                  com.tencent.mm.plugin.report.service.g.yhR.f(11594, new Object[] { Integer.valueOf(4) });
                  AppMethodBeat.o(193458);
                  return;
                  if (AppPanel.t(AppPanel.this) != null)
                  {
                    AppPanel.t(AppPanel.this).dlr();
                    AppMethodBeat.o(193458);
                    return;
                    if (!AppPanel.this.EXF.EYx.value)
                    {
                      Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                      AppMethodBeat.o(193458);
                      return;
                    }
                    AppPanel.t(AppPanel.this).dls();
                    AppMethodBeat.o(193458);
                    return;
                    if (!AppPanel.this.EXF.EYD.value)
                    {
                      Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                      AppMethodBeat.o(193458);
                      return;
                    }
                    AppPanel.t(AppPanel.this).dlt();
                    com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(21) });
                    AppMethodBeat.o(193458);
                    return;
                    if (AppPanel.t(AppPanel.this) != null)
                    {
                      if (paramAnonymousg == null)
                      {
                        localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.u(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.EMG);
                        paramAnonymousg = (com.tencent.mm.pluginsdk.model.app.g)localObject;
                        if (localObject == null)
                        {
                          ad.i("MicroMsg.AppPanel", "empty info");
                          AppMethodBeat.o(193458);
                          return;
                        }
                      }
                      if ((paramAnonymousg.eZR()) || (paramAnonymousg.eZU()))
                      {
                        if (AppPanel.v(AppPanel.this) == null) {
                          AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(aj.fkC(), 0));
                        }
                        if (AppPanel.v(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
                          AppPanel.v(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
                        }
                      }
                      AppPanel.t(AppPanel.this).dlu();
                      AppMethodBeat.o(193458);
                      return;
                      if (!AppPanel.this.EXF.EYz.value)
                      {
                        Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                        AppMethodBeat.o(193458);
                        return;
                      }
                      com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(17) });
                      if (AppPanel.t(AppPanel.this) != null)
                      {
                        AppPanel.t(AppPanel.this).dlv();
                        AppMethodBeat.o(193458);
                        return;
                        if (!AppPanel.this.EXF.EYA.value)
                        {
                          Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                          AppMethodBeat.o(193458);
                          return;
                        }
                        if (AppPanel.t(AppPanel.this) != null)
                        {
                          AppPanel.t(AppPanel.this).dlx();
                          AppMethodBeat.o(193458);
                          return;
                          if (!AppPanel.this.EXF.EYB.value)
                          {
                            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                            AppMethodBeat.o(193458);
                            return;
                          }
                          com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(19) });
                          if (AppPanel.t(AppPanel.this) != null)
                          {
                            AppPanel.t(AppPanel.this).dly();
                            AppMethodBeat.o(193458);
                            return;
                            if (!AppPanel.this.EXF.EYC.value)
                            {
                              Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757253), 0).show();
                              AppMethodBeat.o(193458);
                              return;
                            }
                            com.tencent.mm.plugin.report.service.g.yhR.f(10923, new Object[] { Integer.valueOf(20) });
                            if (AppPanel.t(AppPanel.this) != null)
                            {
                              AppPanel.t(AppPanel.this).dlw();
                              com.tencent.mm.live.d.a.apg();
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
    this.EXX = true;
    this.EXY = -1;
    this.context = paramContext;
    AppMethodBeat.o(31459);
  }
  
  private int Zc(int paramInt)
  {
    int i = paramInt / this.EXj;
    if (paramInt % this.EXj > 0) {}
    for (paramInt = i;; paramInt = i - 1)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      return i;
    }
  }
  
  private void fcZ()
  {
    AppMethodBeat.i(31477);
    ad.d("MicroMsg.AppPanel", "AppPanel initFlipper");
    this.EXU = -1;
    this.yuQ.removeAllViews();
    this.yuQ.setOnMeasureListener(new MMFlipper.b()
    {
      public final void hq(int paramAnonymousInt1, int paramAnonymousInt2)
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
    this.yuQ.setOnFlipperViewShowedListener(new MMFlipper.a()
    {
      public final void Zd(int paramAnonymousInt)
      {
        AppMethodBeat.i(193448);
        ad.i("MicroMsg.AppPanel", "viewpage reshow %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == 1) && (AppPanel.this.EXF.EYC.value)) {
          com.tencent.mm.live.d.e.apX();
        }
        AppMethodBeat.o(193448);
      }
    });
    this.yuQ.setOnScreenChangedListener(new MMFlipper.c()
    {
      public final void u(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(193449);
        AppPanel.e(AppPanel.this).setSelectedDot(paramAnonymousInt2);
        Object localObject2;
        if ((AppPanel.this.getVisibility() == 0) && (paramAnonymousInt1 != -1) && (paramAnonymousInt1 != paramAnonymousInt2) && (paramAnonymousBoolean))
        {
          if (AppPanel.this.EXF.EYl.value) {}
          for (int i = AppPanel.f(AppPanel.this) + AppPanel.g(AppPanel.this).size();; i = AppPanel.f(AppPanel.this))
          {
            localObject1 = new ds();
            ((ds)localObject1).dPl = 1L;
            ((ds)localObject1).egY = 0L;
            localObject2 = new StringBuilder();
            int j = 0;
            while (j < AppPanel.this.getAppPanelUnCertainEnterArrayList().size())
            {
              AppPanel localAppPanel = AppPanel.this;
              if (paramAnonymousInt1 == AppPanel.c(localAppPanel, AppPanel.h(localAppPanel) + i + 1)) {
                ((StringBuilder)localObject2).append(((a.a)AppPanel.this.getAppPanelUnCertainEnterArrayList().get(j)).EYF).append("|");
              }
              j += 1;
            }
          }
          ((ds)localObject1).ne(((StringBuilder)localObject2).toString());
          ((ds)localObject1).aLk();
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
          localObject2 = new dt();
          ((dt)localObject2).nf((String)localObject1);
          ((dt)localObject2).egY = 0L;
          ((dt)localObject2).ng("19");
          ((dt)localObject2).aLk();
          ad.i("MicroMsg.AppPanel", "scroll to show page %s", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          if ((paramAnonymousInt2 == 1) && (AppPanel.this.EXF.EYC.value)) {
            com.tencent.mm.live.d.e.apX();
          }
          AppMethodBeat.o(193449);
          return;
        }
      }
    });
    fdd();
    AppMethodBeat.o(31477);
  }
  
  private void fda()
  {
    AppMethodBeat.i(163206);
    if (this.EXE == -1)
    {
      AppMethodBeat.o(163206);
      return;
    }
    if (this.EXF.EYl.value) {}
    ds localds;
    StringBuilder localStringBuilder;
    for (int i = this.EXm + this.iHw.size();; i = this.EXm)
    {
      this.EXD = Zc(this.EXE + i + 1);
      this.yuQ.setToScreen(this.EXD);
      this.EXE = -1;
      localds = new ds();
      localds.dPl = 1L;
      localds.egY = 1L;
      localStringBuilder = new StringBuilder();
      int j = 0;
      while (j < getAppPanelUnCertainEnterArrayList().size())
      {
        if (this.EXD == Zc(this.EXE + i + 1)) {
          localStringBuilder.append(((a.a)getAppPanelUnCertainEnterArrayList().get(j)).EYF).append("|");
        }
        j += 1;
      }
    }
    localds.ne(localStringBuilder.toString());
    localds.aLk();
    AppMethodBeat.o(163206);
  }
  
  private void fdb()
  {
    AppMethodBeat.i(31482);
    ad.i("MicroMsg.AppPanel", "[dealOrientationChange]");
    this.yuN = false;
    this.yuQ.setToScreen(0);
    fcZ();
    requestLayout();
    AppMethodBeat.o(31482);
  }
  
  private void fdd()
  {
    AppMethodBeat.i(31484);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.EXX)
    {
      if (getScreenOrientation() != 2) {
        break label79;
      }
      ad.d("MicroMsg.AppPanel", "initFlipper, landscape");
      localView = findViewById(2131296867);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = BackwardSupportUtil.b.g(this.context, yuz);
      localView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.EXX = false;
      AppMethodBeat.o(31484);
      return;
      label79:
      ad.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", new Object[] { Integer.valueOf(yuy) });
      localView = findViewById(2131296867);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = getPortHeightPX();
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private boolean fde()
  {
    AppMethodBeat.i(31487);
    if (this.EXQ)
    {
      AppMethodBeat.o(31487);
      return false;
    }
    com.tencent.mm.plugin.card.c.b localb = (com.tencent.mm.plugin.card.c.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.card.c.b.class);
    if (localb != null)
    {
      if ((localb.bVk()) && (localb.bVn() > 0))
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
    if (this.EXY > 0)
    {
      i = this.EXY;
      AppMethodBeat.o(31485);
      return i;
    }
    int i = BackwardSupportUtil.b.g(this.context, yuy);
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
  
  private void he(List<com.tencent.mm.pluginsdk.model.app.g> paramList)
  {
    AppMethodBeat.i(31462);
    boolean bool1 = this.EXJ;
    this.EXJ = false;
    boolean bool2 = this.EXK;
    boolean bool3 = this.EXL;
    boolean bool4 = this.EXM;
    this.EXK = false;
    this.EXL = false;
    this.EXM = false;
    int j = com.tencent.mm.pluginsdk.model.app.h.Yt(this.EXI);
    int k = this.EXI;
    if (paramList != null) {}
    for (int i = paramList.size();; i = -1)
    {
      ad.i("MicroMsg.AppPanel", "serviceCount, %d, %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      this.EXR = new HashMap();
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
            if (localg.eZR())
            {
              if (!localg.eZT()) {
                this.EXJ = true;
              }
              j = i;
              if (com.tencent.mm.pluginsdk.model.app.g.EMD.equals(localg.field_appId))
              {
                this.EXR.put(com.tencent.mm.pluginsdk.model.app.g.EMD, localg);
                ad.i("MicroMsg.AppPanel", "remittance: %s, %s", new Object[] { Boolean.valueOf(this.EXO), Boolean.valueOf(this.EXK) });
                if (!this.EXO) {
                  this.EXK = true;
                }
                paramList.remove(i);
                j = i - 1;
              }
              i = j;
              if (com.tencent.mm.pluginsdk.model.app.g.EMF.equals(localg.field_appId))
              {
                this.EXR.put(com.tencent.mm.pluginsdk.model.app.g.EMF, localg);
                ad.i("MicroMsg.AppPanel", "luckyMoney: %s, %s", new Object[] { Boolean.valueOf(this.EXN), Boolean.valueOf(this.EXL) });
                if (!this.EXN) {
                  this.EXL = true;
                }
                paramList.remove(j);
                i = j - 1;
              }
              j = i;
              if (com.tencent.mm.pluginsdk.model.app.g.EMG.equals(localg.field_appId))
              {
                this.EXR.put(com.tencent.mm.pluginsdk.model.app.g.EMG, localg);
                ad.i("MicroMsg.AppPanel", "aa: %s, %s", new Object[] { Boolean.valueOf(this.EXN), Boolean.valueOf(this.EXL) });
                if (!this.EXP) {
                  this.EXM = true;
                }
                paramList.remove(i);
                j = i - 1;
              }
            }
          }
        }
      }
    }
    com.tencent.mm.plugin.report.service.g.yhR.dD(965, 36);
    label485:
    ad.i("MicroMsg.AppPanel", "hasService %b", new Object[] { Boolean.valueOf(this.EXJ) });
    if ((bool1 != this.EXJ) || (bool2 != this.EXK) || (bool3 != this.EXL) || (bool4 != this.EXM))
    {
      this.EXF.vU(this.EXJ);
      this.EXF.vV(this.EXK);
      this.EXF.vY(this.EXL);
      this.EXF.vZ(this.EXM);
      fcY();
    }
    AppMethodBeat.o(31462);
  }
  
  private static void hf(List<com.tencent.mm.pluginsdk.model.app.g> paramList)
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
      if ((localg != null) && (com.tencent.mm.pluginsdk.model.app.g.EME.equals(localg.field_appId)))
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
  
  public final void fcN()
  {
    AppMethodBeat.i(31463);
    this.EXF.fdh();
    this.EXN = false;
    this.EXO = false;
    this.EXP = false;
    this.EXQ = false;
    fcO();
    this.EXF.vU(this.EXJ);
    this.EXF.vV(this.EXK);
    this.EXF.vY(this.EXL);
    this.EXF.vZ(this.EXM);
    fcY();
    AppMethodBeat.o(31463);
  }
  
  public final void fcO()
  {
    AppMethodBeat.i(31464);
    com.tencent.mm.n.g.acB();
    if (com.tencent.mm.n.c.acm() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.EXF.fdi();
      this.EXF.vW(bool);
      bool = d.aIu("location");
      this.EXF.vX(bool);
      this.EXF.fdj();
      AppMethodBeat.o(31464);
      return;
    }
  }
  
  public final void fcP()
  {
    AppMethodBeat.i(31465);
    this.EXF.EYf.value = false;
    fcY();
    AppMethodBeat.o(31465);
  }
  
  public final void fcQ()
  {
    AppMethodBeat.i(31470);
    this.EXF.EYm.value = false;
    fcY();
    ad.d("MicroMsg.AppPanel", "disableTalkroom enable false");
    AppMethodBeat.o(31470);
  }
  
  public final void fcR()
  {
    AppMethodBeat.i(31471);
    this.EXF.EYr.value = false;
    fcY();
    AppMethodBeat.o(31471);
  }
  
  public final void fcS()
  {
    AppMethodBeat.i(31472);
    this.EXF.EYl.value = false;
    fcY();
    AppMethodBeat.o(31472);
  }
  
  public final void fcT()
  {
    AppMethodBeat.i(31473);
    this.EXF.EYt.value = false;
    fcY();
    AppMethodBeat.o(31473);
  }
  
  public final void fcU()
  {
    AppMethodBeat.i(31474);
    this.EXF.EYz.value = false;
    fcY();
    AppMethodBeat.o(31474);
  }
  
  public final void fcV()
  {
    AppMethodBeat.i(185751);
    this.EXF.EYA.value = false;
    fcY();
    AppMethodBeat.o(185751);
  }
  
  public final void fcW()
  {
    AppMethodBeat.i(193460);
    this.EXF.EYB.value = false;
    fcY();
    AppMethodBeat.o(193460);
  }
  
  public final void fcX()
  {
    AppMethodBeat.i(193461);
    this.EXF.wa(false);
    fcY();
    AppMethodBeat.o(193461);
  }
  
  public final void fcY()
  {
    AppMethodBeat.i(31475);
    int j = this.EXx.length;
    int i = 0;
    while (i < j)
    {
      this.EXx[i] = true;
      i += 1;
    }
    if (!this.EXF.EYe.value) {
      this.EXx[0] = false;
    }
    for (j = 1;; j = 0)
    {
      i = j;
      if (!this.EXF.EYd.value)
      {
        this.EXx[1] = false;
        i = j + 1;
      }
      j = i;
      if (!this.EXF.EYz.value)
      {
        this.EXx[19] = false;
        j = i + 1;
      }
      i = j;
      if (!this.EXF.EYA.value)
      {
        this.EXx[12] = false;
        i = j + 1;
      }
      j = i;
      if (!this.EXF.EYB.value)
      {
        this.EXx[13] = false;
        j = i + 1;
      }
      i = j;
      if (!this.EXF.EYC.value)
      {
        this.EXx[14] = false;
        i = j + 1;
      }
      if (this.EXF.EYr.value)
      {
        j = i;
        if (this.EXF.EYs.value) {}
      }
      else
      {
        this.EXx[6] = false;
        j = i + 1;
      }
      i = j;
      if (!this.EXF.EYj.value)
      {
        this.EXx[17] = false;
        i = j + 1;
      }
      j = i;
      if (!this.EXF.EYk.value)
      {
        ad.i("MicroMsg.AppPanel", "disable remittance");
        this.EXx[8] = false;
        j = i + 1;
      }
      i = j;
      if (!this.EXF.EYf.value)
      {
        this.EXx[15] = false;
        i = j + 1;
      }
      j = i;
      if (!this.EXF.EYt.value)
      {
        this.EXx[16] = false;
        j = i + 1;
      }
      i = j;
      if (!this.EXF.EYw.value)
      {
        this.EXx[3] = false;
        i = j + 1;
      }
      j = i;
      if (!this.EXF.EYg.value)
      {
        this.EXx[11] = false;
        j = i + 1;
      }
      i = j;
      if (!this.EXF.EYm.value)
      {
        this.EXx[5] = false;
        i = j + 1;
      }
      if (this.EXF.EYo.value)
      {
        j = i;
        if (this.EXF.EYn.value) {}
      }
      else
      {
        this.EXx[4] = false;
        j = i + 1;
      }
      if (this.EXF.EYi.value)
      {
        i = j;
        if (this.EXF.EYh.value) {}
      }
      else
      {
        this.EXx[2] = false;
        i = j + 1;
      }
      if (this.EXF.EYq.value)
      {
        j = i;
        if (this.EXF.EYp.value) {}
      }
      else
      {
        this.EXx[10] = false;
        j = i + 1;
      }
      i = j;
      if (!this.EXF.EYv.value)
      {
        ad.i("MicroMsg.AppPanel", "disable lucky money");
        this.EXx[7] = false;
        i = j + 1;
      }
      j = i;
      if (!this.EXF.EYx.value)
      {
        this.EXx[18] = false;
        j = i + 1;
      }
      i = j;
      if (!this.EXF.EYD.value)
      {
        this.EXx[20] = false;
        i = j + 1;
      }
      this.EXx[9] = false;
      this.EXm = (21 - (i + 1));
      AppMethodBeat.o(31475);
      return;
    }
  }
  
  public final void fdc()
  {
    AppMethodBeat.i(31483);
    ad.i("MicroMsg.AppPanel", "[forceRefreshSize]");
    fdd();
    fdb();
    AppMethodBeat.o(31483);
  }
  
  public ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163205);
    ArrayList localArrayList = this.EXF.getAppPanelUnCertainEnterArrayList();
    AppMethodBeat.o(163205);
    return localArrayList;
  }
  
  public int getCurScreen()
  {
    AppMethodBeat.i(193462);
    if (this.yuQ != null)
    {
      int i = this.yuQ.getCurScreen();
      AppMethodBeat.o(193462);
      return i;
    }
    AppMethodBeat.o(193462);
    return -1;
  }
  
  public int getPageMaxRowCount()
  {
    if (this.EXC == 0)
    {
      int i = (this.tCJ + 3) / 4;
      if (i > 2) {
        return 2;
      }
      return i;
    }
    return this.EXC;
  }
  
  public final int getPosPage$134621()
  {
    int m = this.EXx.length;
    int j = 0;
    int i = 0;
    int k;
    if (j < m)
    {
      k = i;
      if (this.EXx[j] != 0) {
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
    i = j / this.EXj;
    if (j % this.EXj > 0) {}
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
    this.EXF = new a();
    this.EXI = paramInt;
    Object localObject = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (((Display)localObject).getWidth() < ((Display)localObject).getHeight())
    {
      this.EXG = ((Display)localObject).getWidth();
      this.EXH = ((Display)localObject).getHeight();
      View.inflate(this.context, 2131493086, this);
      this.yuR = ((MMDotView)findViewById(2131296868));
      this.yuQ = ((MMFlipper)findViewById(2131296869));
    }
    for (;;)
    {
      try
      {
        localObject = com.tencent.mm.n.g.acA().getValue("ShowAPPSuggestion");
        if ((!bt.isNullOrNil((String)localObject)) && (Integer.valueOf((String)localObject).intValue() == 1)) {
          continue;
        }
        this.iHw = com.tencent.mm.pluginsdk.model.app.h.a(this.context, false, this.EXI);
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
        this.iHw = com.tencent.mm.pluginsdk.model.app.h.a(this.context, false, this.EXI);
        continue;
      }
      if (!fde()) {
        hf(this.iHw);
      }
      he(this.iHw);
      fcZ();
      fcN();
      AppMethodBeat.o(31460);
      return;
      this.EXG = ((Display)localObject).getHeight();
      this.EXH = ((Display)localObject).getWidth();
      break;
      this.iHw = com.tencent.mm.pluginsdk.model.app.h.a(this.context, true, this.EXI);
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
    for (this.EXS = true;; this.EXS = false)
    {
      setNeedRefreshHeight(true);
      fdb();
      AppMethodBeat.o(31481);
      return;
    }
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(31478);
    ad.i("MicroMsg.AppPanel", "app panel refleshed: %s", new Object[] { Integer.valueOf(this.EXI) });
    com.tencent.e.h.LTJ.aZz("AppPanel-refresh");
    com.tencent.e.h.LTJ.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193451);
        AppPanel.g(AppPanel.this).clear();
        for (;;)
        {
          try
          {
            String str = com.tencent.mm.n.g.acA().getValue("ShowAPPSuggestion");
            if ((!bt.isNullOrNil(str)) && (Integer.valueOf(str).intValue() == 1)) {
              continue;
            }
            AppPanel.a(AppPanel.this, com.tencent.mm.pluginsdk.model.app.h.a(AppPanel.j(AppPanel.this), false, AppPanel.k(AppPanel.this)));
            ad.i("MicroMsg.AppPanel", "jacks not show App Suggestion");
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
            AppPanel.a(AppPanel.this, com.tencent.mm.pluginsdk.model.app.h.a(AppPanel.j(AppPanel.this), false, AppPanel.k(AppPanel.this)));
            continue;
          }
          com.tencent.e.h.LTJ.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193450);
              if (!AppPanel.l(AppPanel.this)) {
                AppPanel.hg(AppPanel.g(AppPanel.this));
              }
              AppPanel.b(AppPanel.this, AppPanel.g(AppPanel.this));
              if (AppPanel.this.EXF != null)
              {
                AppPanel.this.EXF.vU(AppPanel.m(AppPanel.this));
                AppPanel.this.EXF.vV(AppPanel.n(AppPanel.this));
                AppPanel.this.EXF.vY(AppPanel.o(AppPanel.this));
                AppPanel.this.EXF.vZ(AppPanel.p(AppPanel.this));
              }
              int i = AppPanel.q(AppPanel.this).getCurScreen();
              AppPanel.d(AppPanel.this);
              AppPanel.q(AppPanel.this).setToScreen(i);
              AppPanel.e(AppPanel.this).setSelectedDot(i);
              AppMethodBeat.o(193450);
            }
          });
          AppMethodBeat.o(193451);
          return;
          ad.i("MicroMsg.AppPanel", "jacks show App Suggestion");
          AppPanel.a(AppPanel.this, com.tencent.mm.pluginsdk.model.app.h.a(AppPanel.j(AppPanel.this), true, AppPanel.k(AppPanel.this)));
        }
      }
    }, "AppPanel-refresh");
    AppMethodBeat.o(31478);
  }
  
  public void setAppPanelListener(a parama)
  {
    this.EXy = parama;
  }
  
  public void setAppPanelUnCertainEnterArrayList(ArrayList<a.a> paramArrayList)
  {
    this.EXF.EYE = paramArrayList;
  }
  
  public void setChattingContext(ChatFooter.b paramb)
  {
    this.EXA = paramb;
  }
  
  public void setNeedRefreshHeight(boolean paramBoolean)
  {
    this.EXX = paramBoolean;
  }
  
  public void setOnSwitchPanelListener(b paramb)
  {
    this.EXz = paramb;
  }
  
  public void setPortHeighDP(int paramInt)
  {
    if (yuy != paramInt)
    {
      yuy = paramInt;
      this.EXX = true;
    }
  }
  
  public void setPortHeighPx(int paramInt)
  {
    if (this.EXY != paramInt)
    {
      this.EXY = paramInt;
      this.EXX = true;
    }
  }
  
  public void setServiceShowFlag(int paramInt)
  {
    AppMethodBeat.i(31461);
    ad.i("MicroMsg.AppPanel", "setServiceShowFlag: %s", new Object[] { Integer.valueOf(paramInt) });
    this.EXI = paramInt;
    AppMethodBeat.o(31461);
  }
  
  public void setUncertainEnterLocation(int paramInt)
  {
    this.EXE = paramInt;
  }
  
  public final void vQ(boolean paramBoolean)
  {
    AppMethodBeat.i(31466);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.EXF.EYh.value = paramBoolean;
      fcY();
      ad.d("MicroMsg.AppPanel", "enable " + paramBoolean + " isVoipPluginEnable " + this.EXF.EYi.value);
      AppMethodBeat.o(31466);
      return;
    }
  }
  
  public final void vR(boolean paramBoolean)
  {
    AppMethodBeat.i(31467);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.EXF.EYn.value = paramBoolean;
      fcY();
      ad.d("MicroMsg.AppPanel", "enable " + this.EXF.EYo.value + " isVoipAudioEnable " + paramBoolean);
      AppMethodBeat.o(31467);
      return;
    }
  }
  
  public final void vS(boolean paramBoolean)
  {
    AppMethodBeat.i(31468);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.EXF.EYw.value = paramBoolean;
      fcY();
      ad.d("MicroMsg.AppPanel", "enable " + this.EXF.EYw.value + " isMultiTalkEnable " + paramBoolean);
      AppMethodBeat.o(31468);
      return;
    }
  }
  
  public final void vT(boolean paramBoolean)
  {
    AppMethodBeat.i(31469);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.EXF.EYp.value = paramBoolean;
      fcY();
      AppMethodBeat.o(31469);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void JI(int paramInt);
    
    public abstract void JJ(int paramInt);
    
    public abstract void d(com.tencent.mm.pluginsdk.model.app.g paramg);
    
    public abstract void dlh();
    
    public abstract void dli();
    
    public abstract void dlj();
    
    public abstract void dlk();
    
    public abstract void dll();
    
    public abstract void dlm();
    
    public abstract void dln();
    
    public abstract void dlo();
    
    public abstract void dlp();
    
    public abstract void dlq();
    
    public abstract void dlr();
    
    public abstract void dls();
    
    public abstract void dlt();
    
    public abstract void dlu();
    
    public abstract void dlv();
    
    public abstract void dlw();
    
    public abstract void dlx();
    
    public abstract void dly();
  }
  
  public static abstract interface b
  {
    public abstract void fdg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel
 * JD-Core Version:    0.7.0.1
 */