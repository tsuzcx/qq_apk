package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.g.b.a.gx;
import com.tencent.mm.g.b.a.gy;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.MMFlipper.a;
import com.tencent.mm.ui.base.MMFlipper.b;
import com.tencent.mm.ui.base.MMFlipper.c;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel
  extends LinearLayout
{
  private static int COl = 215;
  private static int COm = 158;
  private static boolean Khh = false;
  private boolean COA;
  private int COB;
  private int COC;
  public MMFlipper COD;
  private MMDotView COE;
  private final boolean[] KgI;
  private a KgJ;
  private AppPanel.b KgK;
  private ChatFooter.b KgL;
  private List<AppGrid> KgM;
  private int KgN;
  public int KgO;
  private int KgP;
  public a KgQ;
  private int KgR;
  private int KgS;
  private int KgT;
  private boolean KgU;
  private boolean KgV;
  private boolean KgW;
  private boolean KgX;
  boolean KgY;
  boolean KgZ;
  private int Kgu;
  private int Kgx;
  boolean Kha;
  boolean Khb;
  private Map<String, com.tencent.mm.pluginsdk.model.app.g> Khc;
  private boolean Khd;
  private final int Khe;
  private int Khf;
  private AppGrid.b Khg;
  private boolean Khi;
  private int Khj;
  Context context;
  private boolean isInit;
  private List<com.tencent.mm.pluginsdk.model.app.g> jGV;
  private SharedPreferences sp;
  private int xeA;
  
  public AppPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31459);
    this.KgI = new boolean[21];
    this.COA = false;
    this.Kgx = 21;
    this.xeA = this.Kgx;
    this.KgO = 0;
    this.KgP = -1;
    this.isInit = false;
    this.KgR = 0;
    this.KgS = 0;
    this.KgT = 0;
    this.KgU = false;
    this.KgV = false;
    this.KgW = false;
    this.KgX = false;
    this.KgY = false;
    this.KgZ = false;
    this.Kha = false;
    this.Khb = false;
    this.Khc = null;
    this.Khd = true;
    this.jGV = new LinkedList();
    this.Khe = 2;
    this.Khf = -1;
    this.Khg = new AppGrid.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        int i = 0;
        AppMethodBeat.i(232209);
        if (paramAnonymousg != null) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          Log.d("MicroMsg.AppPanel", "pos=%d, has appInfo = %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool1) });
          if ((paramAnonymousg != null) && (com.tencent.mm.pluginsdk.model.app.h.p(paramAnonymousg))) {
            z.aH(paramAnonymousg.field_appId, "1");
          }
          AppPanel.d(AppPanel.this, AppPanel.q(AppPanel.this).getCurScreen());
          if (!(paramAnonymousg instanceof a.a)) {
            break label488;
          }
          paramAnonymousg = (a.a)paramAnonymousg;
          Log.i("MicroMsg.AppPanel", "jump_type:%s", new Object[] { Integer.valueOf(paramAnonymousg.uSc) });
          if ((paramAnonymousg.Kig == null) || (paramAnonymousg.Kig.gqg() == null)) {
            break;
          }
          AppPanel.a(AppPanel.this, paramAnonymousg.Kig.gqg());
          AppMethodBeat.o(232209);
          return;
        }
        Object localObject;
        if (paramAnonymousg.uSc == 1)
        {
          localObject = new com.tencent.mm.plugin.appbrand.api.g();
          if (!TextUtils.isEmpty(paramAnonymousg.KhS))
          {
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).username = paramAnonymousg.KhS;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).version = paramAnonymousg.KhU;
          }
        }
        for (;;)
        {
          try
          {
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).iOo = Integer.parseInt(paramAnonymousg.KhW);
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).kHw = paramAnonymousg.KhV;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).scene = 1156;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).kHG = paramAnonymousg.kHG;
            ((r)com.tencent.mm.kernel.g.af(r.class)).a(AppPanel.this.getContext(), (com.tencent.mm.plugin.appbrand.api.g)localObject);
            localObject = new gx();
            ((gx)localObject).ejA = 2L;
            ((gx)localObject).eLg = 0L;
            ((gx)localObject).uM(paramAnonymousg.KhQ);
            ((gx)localObject).bfK();
            AppMethodBeat.o(232209);
            return;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).appId = paramAnonymousg.KhT;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).iOo = 0;
            continue;
          }
          if (paramAnonymousg.uSc == 2) {
            if (paramAnonymousg.Kif > 0)
            {
              localObject = AppPanel.j(AppPanel.this);
              String str = paramAnonymousg.nnB;
              paramAnonymousInt = paramAnonymousg.Kif;
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", str);
              localIntent.putExtra("showShare", false);
              localIntent.putExtra("show_bottom", false);
              localIntent.putExtra("needRedirect", false);
              localIntent.putExtra("neverGetA8Key", false);
              localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
              localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
              localIntent.putExtra("KHalfScreenHeight", paramAnonymousInt);
              com.tencent.mm.br.c.b((Context)localObject, "webview", ".ui.tools.WebViewUI", localIntent);
            }
            else
            {
              com.tencent.mm.plugin.account.a.b.a.b(AppPanel.j(AppPanel.this), paramAnonymousg.nnB, 0, true);
            }
          }
        }
        label488:
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(232209);
          return;
          if (AppPanel.g(AppPanel.this) == null)
          {
            Log.e("MicroMsg.AppPanel", "infoList == null");
            AppMethodBeat.o(232209);
            return;
          }
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(10305, String.valueOf(AppPanel.g(AppPanel.this).size()));
          com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(10) });
          com.tencent.mm.kernel.g.aAh().azQ().set(69121, "");
          AppPanel.t(AppPanel.this).ehZ();
          AppMethodBeat.o(232209);
          return;
          if (!WeChatBrands.Business.Entries.SessionPayment.checkAvailable(AppPanel.this.getContext()))
          {
            AppMethodBeat.o(232209);
            return;
          }
          localObject = paramAnonymousg;
          if (paramAnonymousg == null) {
            localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.u(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.JVR);
          }
          bg.aVF();
          paramAnonymousInt = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
          bg.aVF();
          paramAnonymousg = Util.stringsToList(((String)com.tencent.mm.model.c.azQ().get(ar.a.NZY, "")).split(";"));
          if (!paramAnonymousg.contains(String.valueOf(paramAnonymousInt)))
          {
            paramAnonymousg.add(String.valueOf(paramAnonymousInt));
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(ar.a.NZY, Util.listToString(paramAnonymousg, ";"));
            AppPanel.this.refresh();
          }
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(80, Boolean.FALSE);
          AppPanel.t(AppPanel.this).d((com.tencent.mm.pluginsdk.model.app.g)localObject);
          AppMethodBeat.o(232209);
          return;
          if (!AppPanel.this.KgQ.Khw.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
            AppMethodBeat.o(232209);
            return;
          }
          if (paramAnonymousg == null)
          {
            Log.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
            AppMethodBeat.o(232209);
            return;
          }
          if ((paramAnonymousg.gmR()) || (paramAnonymousg.gmT()))
          {
            if (AppPanel.v(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0));
            }
            if (AppPanel.v(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
              AppPanel.v(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
            }
            if (paramAnonymousg.gmT()) {
              com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(16), paramAnonymousg.field_appId, Integer.valueOf(0) });
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(13), paramAnonymousg.field_appId, Integer.valueOf(0) });
          }
          for (;;)
          {
            AppPanel.t(AppPanel.this).d(paramAnonymousg);
            AppMethodBeat.o(232209);
            return;
            com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(11), paramAnonymousg.field_appId });
          }
          if (AppPanel.w(AppPanel.this))
          {
            AppPanel.x(AppPanel.this);
            AppMethodBeat.o(232209);
            return;
          }
          paramAnonymousg = ((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.d.class)).aAV(AppPanel.i(AppPanel.this).getTalkerUserName());
          if (!TextUtils.isEmpty(paramAnonymousg))
          {
            AppPanel.a(AppPanel.this, paramAnonymousg);
            AppMethodBeat.o(232209);
            return;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(14) });
          paramAnonymousg = AppPanel.t(AppPanel.this);
          if (AppPanel.this.KgQ.KhF.value) {}
          for (paramAnonymousInt = i;; paramAnonymousInt = 2)
          {
            paramAnonymousg.Qk(paramAnonymousInt);
            AppMethodBeat.o(232209);
            return;
          }
          if (!AppPanel.this.KgQ.Khq.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
            AppMethodBeat.o(232209);
            return;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(4) });
          AppPanel.t(AppPanel.this).ehY();
          AppMethodBeat.o(232209);
          return;
          if (!WeChatBrands.Business.Entries.SessionLuckyMoney.checkAvailable(AppPanel.this.getContext()))
          {
            AppMethodBeat.o(232209);
            return;
          }
          if (!AppPanel.this.KgQ.KhG.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
            AppMethodBeat.o(232209);
            return;
          }
          if (paramAnonymousg == null)
          {
            localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.u(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.JVT);
            paramAnonymousg = (com.tencent.mm.pluginsdk.model.app.g)localObject;
            if (localObject == null)
            {
              AppMethodBeat.o(232209);
              return;
            }
          }
          if ((paramAnonymousg.gmR()) || (paramAnonymousg.gmT()))
          {
            if (AppPanel.v(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0));
            }
            if (AppPanel.v(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
              AppPanel.v(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(13), paramAnonymousg.field_appId, Integer.valueOf(0) });
          }
          for (;;)
          {
            bg.aVF();
            paramAnonymousInt = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
            bg.aVF();
            paramAnonymousg = Util.stringsToList(((String)com.tencent.mm.model.c.azQ().get(ar.a.NZZ, "")).split(";"));
            if (!paramAnonymousg.contains(String.valueOf(paramAnonymousInt)))
            {
              paramAnonymousg.add(String.valueOf(paramAnonymousInt));
              bg.aVF();
              com.tencent.mm.model.c.azQ().set(ar.a.NZZ, Util.listToString(paramAnonymousg, ";"));
              AppPanel.this.refresh();
            }
            AppPanel.t(AppPanel.this).eid();
            AppMethodBeat.o(232209);
            return;
            com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(11), paramAnonymousg.field_appId });
          }
          if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(AppPanel.this.getContext()))
          {
            AppMethodBeat.o(232209);
            return;
          }
          if ((!AppPanel.this.KgQ.KhC.value) || (!AppPanel.this.KgQ.KhD.value))
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
            AppMethodBeat.o(232209);
            return;
          }
          bg.aVF();
          if (((Boolean)com.tencent.mm.model.c.azQ().get(290817, Boolean.TRUE)).booleanValue())
          {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(290817, Boolean.FALSE);
            AppPanel.this.refresh();
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(3) });
          AppPanel.t(AppPanel.this).ehX();
          AppMethodBeat.o(232209);
          return;
          if (!AppPanel.this.KgQ.Khu.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
            AppMethodBeat.o(232209);
            return;
          }
          bg.aVF();
          if (((Boolean)com.tencent.mm.model.c.azQ().get(327744, Boolean.TRUE)).booleanValue())
          {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(327744, Boolean.FALSE);
            AppPanel.this.refresh();
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(12) });
          AppPanel.t(AppPanel.this).eib();
          AppMethodBeat.o(232209);
          return;
          if (AppPanel.w(AppPanel.this))
          {
            AppPanel.x(AppPanel.this);
            AppMethodBeat.o(232209);
            return;
          }
          paramAnonymousg = ((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.gamelife.a.d.class)).aAU(AppPanel.i(AppPanel.this).getTalkerUserName());
          if (!TextUtils.isEmpty(paramAnonymousg))
          {
            AppPanel.a(AppPanel.this, paramAnonymousg);
            AppMethodBeat.o(232209);
            return;
          }
          if (!AppPanel.this.KgQ.Khp.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
            AppMethodBeat.o(232209);
            return;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(1) });
          AppPanel.a(AppPanel.this, false);
          AppMethodBeat.o(232209);
          return;
          if (!AppPanel.this.KgQ.Khs.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
            AppMethodBeat.o(232209);
            return;
          }
          com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(8) });
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(54, Boolean.FALSE);
          if (AppPanel.t(AppPanel.this) != null)
          {
            paramAnonymousg = new xq();
            paramAnonymousg.edR.edT = true;
            EventCenter.instance.publish(paramAnonymousg);
            paramAnonymousg = paramAnonymousg.edS.edV;
            if (!Util.isNullOrNil(paramAnonymousg))
            {
              Log.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramAnonymousg)));
              com.tencent.mm.ui.base.h.c(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131766611), "", AppPanel.j(AppPanel.this).getString(2131755921), AppPanel.j(AppPanel.this).getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(232203);
                  xq localxq = new xq();
                  localxq.edR.edU = true;
                  EventCenter.instance.publish(localxq);
                  AppPanel.t(AppPanel.this).ehU();
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(232203);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(232204);
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(232204);
                }
              });
              AppMethodBeat.o(232209);
              return;
            }
            AppPanel.t(AppPanel.this).ehU();
            AppMethodBeat.o(232209);
            return;
            if (!AppPanel.this.KgQ.Khy.value)
            {
              Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
              AppMethodBeat.o(232209);
              return;
            }
            com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(7) });
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(62, Boolean.FALSE);
            paramAnonymousg = new xq();
            paramAnonymousg.edR.edT = true;
            EventCenter.instance.publish(paramAnonymousg);
            paramAnonymousg = paramAnonymousg.edS.edV;
            if (!Util.isNullOrNil(paramAnonymousg))
            {
              Log.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramAnonymousg)));
              com.tencent.mm.ui.base.h.c(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131766611), "", AppPanel.j(AppPanel.this).getString(2131755921), AppPanel.j(AppPanel.this).getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(232205);
                  xq localxq = new xq();
                  localxq.edR.edU = true;
                  EventCenter.instance.publish(localxq);
                  AppPanel.t(AppPanel.this).ehV();
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(232205);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(232206);
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(232206);
                }
              });
              AppMethodBeat.o(232209);
              return;
            }
            AppPanel.t(AppPanel.this).ehV();
            AppMethodBeat.o(232209);
            return;
            if (AppPanel.t(AppPanel.this) != null)
            {
              com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(6) });
              bg.aVF();
              com.tencent.mm.model.c.azQ().set(67, Boolean.FALSE);
              AppPanel.t(AppPanel.this).ehW();
              AppMethodBeat.o(232209);
              return;
              if (AppPanel.w(AppPanel.this))
              {
                AppPanel.x(AppPanel.this);
                AppMethodBeat.o(232209);
                return;
              }
              if (!WeChatBrands.Business.Entries.SessionVoiceMsg.checkAvailable(AppPanel.this.getContext()))
              {
                AppMethodBeat.o(232209);
                return;
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(9) });
              bg.aVF();
              com.tencent.mm.model.c.azQ().set(73, Boolean.FALSE);
              AppPanel.y(AppPanel.this).gqc();
              AppMethodBeat.o(232209);
              return;
              if (!AppPanel.this.KgQ.Khr.value)
              {
                Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
                AppMethodBeat.o(232209);
                return;
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(5) });
              if (AppPanel.t(AppPanel.this) != null)
              {
                AppPanel.t(AppPanel.this).eia();
                AppMethodBeat.o(232209);
                return;
                if (!AppPanel.this.KgQ.KhE.value)
                {
                  Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
                  AppMethodBeat.o(232209);
                  return;
                }
                if (AppPanel.t(AppPanel.this) != null) {
                  AppPanel.t(AppPanel.this).eic();
                }
                com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(15) });
                bg.aVF();
                bool1 = ((Boolean)com.tencent.mm.model.c.azQ().get(208899, Boolean.FALSE)).booleanValue();
                bg.aVF();
                boolean bool2 = ((Boolean)com.tencent.mm.model.c.azQ().get(208913, Boolean.FALSE)).booleanValue();
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.h.CyF.a(11594, new Object[] { Integer.valueOf(3) });
                  AppMethodBeat.o(232209);
                  return;
                }
                if (bool2)
                {
                  com.tencent.mm.plugin.report.service.h.CyF.a(11594, new Object[] { Integer.valueOf(4) });
                  AppMethodBeat.o(232209);
                  return;
                  if (AppPanel.t(AppPanel.this) != null)
                  {
                    AppPanel.t(AppPanel.this).eie();
                    AppMethodBeat.o(232209);
                    return;
                    if (!AppPanel.this.KgQ.KhI.value)
                    {
                      Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
                      AppMethodBeat.o(232209);
                      return;
                    }
                    AppPanel.t(AppPanel.this).eif();
                    AppMethodBeat.o(232209);
                    return;
                    if (!AppPanel.this.KgQ.KhO.value)
                    {
                      Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
                      AppMethodBeat.o(232209);
                      return;
                    }
                    AppPanel.t(AppPanel.this).eig();
                    com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(21) });
                    AppMethodBeat.o(232209);
                    return;
                    if (AppPanel.t(AppPanel.this) != null)
                    {
                      if (paramAnonymousg == null)
                      {
                        localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.u(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.JVU);
                        paramAnonymousg = (com.tencent.mm.pluginsdk.model.app.g)localObject;
                        if (localObject == null)
                        {
                          Log.i("MicroMsg.AppPanel", "empty info");
                          AppMethodBeat.o(232209);
                          return;
                        }
                      }
                      if ((paramAnonymousg.gmR()) || (paramAnonymousg.gmT()))
                      {
                        if (AppPanel.v(AppPanel.this) == null) {
                          AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0));
                        }
                        if (AppPanel.v(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
                          AppPanel.v(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
                        }
                      }
                      AppPanel.t(AppPanel.this).eih();
                      AppMethodBeat.o(232209);
                      return;
                      if (!AppPanel.this.KgQ.KhK.value)
                      {
                        Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
                        AppMethodBeat.o(232209);
                        return;
                      }
                      com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(17) });
                      if (AppPanel.t(AppPanel.this) != null)
                      {
                        AppPanel.t(AppPanel.this).eii();
                        AppMethodBeat.o(232209);
                        return;
                        if (!WeChatBrands.Business.Entries.SessionGroupTools.checkAvailable(AppPanel.this.getContext()))
                        {
                          AppMethodBeat.o(232209);
                          return;
                        }
                        if (!AppPanel.this.KgQ.KhL.value)
                        {
                          Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
                          AppMethodBeat.o(232209);
                          return;
                        }
                        if (AppPanel.t(AppPanel.this) != null)
                        {
                          AppPanel.t(AppPanel.this).eik();
                          AppMethodBeat.o(232209);
                          return;
                          if (!WeChatBrands.Business.Entries.SessionGroupSolitaire.checkAvailable(AppPanel.this.getContext()))
                          {
                            AppMethodBeat.o(232209);
                            return;
                          }
                          if (!AppPanel.this.KgQ.KhM.value)
                          {
                            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
                            AppMethodBeat.o(232209);
                            return;
                          }
                          com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(19) });
                          if (AppPanel.t(AppPanel.this) != null)
                          {
                            AppPanel.t(AppPanel.this).eil();
                            AppMethodBeat.o(232209);
                            return;
                            if (!WeChatBrands.Business.Entries.SessionGroupLive.checkAvailable(AppPanel.this.getContext()))
                            {
                              AppMethodBeat.o(232209);
                              return;
                            }
                            if (!AppPanel.this.KgQ.KhN.value)
                            {
                              Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
                              AppMethodBeat.o(232209);
                              return;
                            }
                            com.tencent.mm.plugin.report.service.h.CyF.a(10923, new Object[] { Integer.valueOf(20) });
                            if (AppPanel.t(AppPanel.this) != null)
                            {
                              AppPanel.t(AppPanel.this).eij();
                              com.tencent.mm.live.d.a.aHT();
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
      
      public final int air(int paramAnonymousInt)
      {
        AppMethodBeat.i(232207);
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
                AppMethodBeat.o(232207);
                return i;
              }
              k = j + 1;
            }
            i += 1;
          }
        }
        if ((paramAnonymousInt >= AppPanel.f(AppPanel.this)) && (paramAnonymousInt < AppPanel.s(AppPanel.this)))
        {
          AppMethodBeat.o(232207);
          return -2147483648;
        }
        AppMethodBeat.o(232207);
        return 2147483647;
      }
      
      public final void ais(int paramAnonymousInt)
      {
        AppMethodBeat.i(232208);
        if (paramAnonymousInt == 0)
        {
          if (!AppPanel.this.KgQ.Khp.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(2131757466), 0).show();
            AppMethodBeat.o(232208);
            return;
          }
          AppPanel.a(AppPanel.this, true);
          AppMethodBeat.o(232208);
          return;
        }
        AppMethodBeat.o(232208);
      }
    };
    this.Khi = true;
    this.Khj = -1;
    this.context = paramContext;
    AppMethodBeat.o(31459);
  }
  
  private int ait(int paramInt)
  {
    int i = paramInt / this.Kgu;
    if (paramInt % this.Kgu > 0) {}
    for (paramInt = i;; paramInt = i - 1)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      return i;
    }
  }
  
  private void beW(String paramString)
  {
    AppMethodBeat.i(232215);
    Log.i("MicroMsg.AppPanel", "showForbiddenDialog: %s", new Object[] { paramString });
    f.a locala = new f.a(MMApplicationContext.getContext());
    locala.bow(paramString).Dq(true);
    locala.apa(2131768713).b(new f.c()
    {
      public final void e(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).b(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
    }).show();
    AppMethodBeat.o(232215);
  }
  
  private void bqe()
  {
    AppMethodBeat.i(232213);
    com.tencent.f.h.RTc.bqo("AppPanel-loadinfo");
    com.tencent.f.h.RTc.b(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(232202);
        AppPanel.g(AppPanel.this).clear();
        for (;;)
        {
          try
          {
            String str = com.tencent.mm.n.h.aqJ().getValue("ShowAPPSuggestion");
            if ((!Util.isNullOrNil(str)) && (Integer.valueOf(str).intValue() == 1)) {
              continue;
            }
            AppPanel.a(AppPanel.this, com.tencent.mm.pluginsdk.model.app.h.a(AppPanel.j(AppPanel.this), false, AppPanel.k(AppPanel.this)));
            Log.i("MicroMsg.AppPanel", "jacks not show App Suggestion");
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.AppPanel", "exception in appPanel init, %s", new Object[] { localException.getMessage() });
            AppPanel.a(AppPanel.this, com.tencent.mm.pluginsdk.model.app.h.a(AppPanel.j(AppPanel.this), false, AppPanel.k(AppPanel.this)));
            continue;
          }
          if (!AppPanel.l(AppPanel.this)) {
            AppPanel.iu(AppPanel.g(AppPanel.this));
          }
          AppPanel.b(AppPanel.this, AppPanel.g(AppPanel.this));
          if (AppPanel.this.KgQ != null)
          {
            AppPanel.this.KgQ.Aa(AppPanel.m(AppPanel.this));
            AppPanel.this.KgQ.Ab(AppPanel.n(AppPanel.this));
            AppPanel.this.KgQ.Ae(AppPanel.o(AppPanel.this));
            AppPanel.this.KgQ.Af(AppPanel.p(AppPanel.this));
          }
          com.tencent.f.h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(232201);
              if (AppPanel.h(AppPanel.this) == -1) {}
              for (int i = AppPanel.q(AppPanel.this).getCurScreen();; i = -1)
              {
                AppPanel.d(AppPanel.this);
                if (i != -1)
                {
                  AppPanel.q(AppPanel.this).setToScreen(i);
                  AppPanel.e(AppPanel.this).setSelectedDot(i);
                }
                AppMethodBeat.o(232201);
                return;
              }
            }
          });
          AppMethodBeat.o(232202);
          return;
          Log.i("MicroMsg.AppPanel", "jacks show App Suggestion");
          AppPanel.a(AppPanel.this, com.tencent.mm.pluginsdk.model.app.h.a(AppPanel.j(AppPanel.this), true, AppPanel.k(AppPanel.this)));
        }
      }
    }, "AppPanel-loadinfo");
    AppMethodBeat.o(232213);
  }
  
  private int getPortHeightPX()
  {
    AppMethodBeat.i(31485);
    if (this.Khj > 0)
    {
      i = this.Khj;
      AppMethodBeat.o(31485);
      return i;
    }
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, COl);
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
  
  private void gpW()
  {
    AppMethodBeat.i(31477);
    Log.d("MicroMsg.AppPanel", "AppPanel initFlipper");
    this.Khf = -1;
    this.COD.removeAllViews();
    this.COD.setOnMeasureListener(new MMFlipper.b()
    {
      public final void ig(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(31448);
        Log.i("MicroMsg.AppPanel", "onMeasure width:" + paramAnonymousInt1 + " height:" + paramAnonymousInt2 + " isMeasured:" + AppPanel.a(AppPanel.this));
        if ((AppPanel.a(AppPanel.this)) || (paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0))
        {
          if ((paramAnonymousInt2 == 0) || (paramAnonymousInt1 == 0)) {
            Log.d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
          }
          AppMethodBeat.o(31448);
          return;
        }
        if (AppPanel.b(AppPanel.this) == 2) {
          Log.d("MicroMsg.AppPanel", "landspace");
        }
        for (;;)
        {
          AppPanel.c(AppPanel.this);
          AppPanel.a(AppPanel.this, paramAnonymousInt2);
          AppPanel.b(AppPanel.this, paramAnonymousInt1);
          AppPanel.d(AppPanel.this);
          AppMethodBeat.o(31448);
          return;
          Log.d("MicroMsg.AppPanel", "portrait");
        }
      }
    });
    this.COD.setOnFlipperViewShowedListener(new MMFlipper.a()
    {
      public final void aiv(int paramAnonymousInt)
      {
        AppMethodBeat.i(232199);
        Log.i("MicroMsg.AppPanel", "viewpage reshow %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        int i = AppPanel.this.aiu(14);
        if ((paramAnonymousInt == i) && (AppPanel.this.KgQ.KhN.value)) {
          com.tencent.mm.live.d.e.rj(i + 1);
        }
        AppMethodBeat.o(232199);
      }
    });
    this.COD.setOnScreenChangedListener(new MMFlipper.c()
    {
      public final void z(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(232200);
        AppPanel.e(AppPanel.this).setSelectedDot(paramAnonymousInt2);
        Object localObject2;
        if ((AppPanel.this.getVisibility() == 0) && (paramAnonymousInt1 != -1) && (paramAnonymousInt1 != paramAnonymousInt2) && (paramAnonymousBoolean))
        {
          if (AppPanel.this.KgQ.Khw.value) {}
          for (int i = AppPanel.f(AppPanel.this) + AppPanel.g(AppPanel.this).size();; i = AppPanel.f(AppPanel.this))
          {
            localObject1 = new gx();
            ((gx)localObject1).ejA = 1L;
            ((gx)localObject1).eLg = 0L;
            localObject2 = new StringBuilder();
            int j = 0;
            while (j < AppPanel.this.getAppPanelUnCertainEnterArrayList().size())
            {
              AppPanel localAppPanel = AppPanel.this;
              if (paramAnonymousInt1 == AppPanel.c(localAppPanel, AppPanel.h(localAppPanel) + i + 1)) {
                ((StringBuilder)localObject2).append(((a.a)AppPanel.this.getAppPanelUnCertainEnterArrayList().get(j)).KhQ).append("|");
              }
              j += 1;
            }
          }
          ((gx)localObject1).uM(((StringBuilder)localObject2).toString());
          ((gx)localObject1).bfK();
          paramAnonymousInt1 = AppPanel.this.aiu(13);
          if ((paramAnonymousInt1 != -1) && (paramAnonymousInt1 == AppPanel.this.getCurScreen())) {
            if (AppPanel.i(AppPanel.this) != null) {
              break label364;
            }
          }
        }
        label364:
        for (Object localObject1 = "";; localObject1 = AppPanel.i(AppPanel.this).getTalkerUserName())
        {
          localObject2 = new gy();
          ((gy)localObject2).uN((String)localObject1);
          ((gy)localObject2).eLg = 0L;
          ((gy)localObject2).uO("19");
          ((gy)localObject2).eLj = (paramAnonymousInt1 + 1);
          ((gy)localObject2).bfK();
          Log.i("MicroMsg.AppPanel", "scroll to show page %s", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          paramAnonymousInt1 = AppPanel.this.aiu(14);
          if ((paramAnonymousInt2 == paramAnonymousInt1) && (AppPanel.this.KgQ.KhN.value)) {
            com.tencent.mm.live.d.e.rj(paramAnonymousInt1 + 1);
          }
          AppMethodBeat.o(232200);
          return;
        }
      }
    });
    gqa();
    AppMethodBeat.o(31477);
  }
  
  private void gpX()
  {
    AppMethodBeat.i(163206);
    if (this.KgP == -1)
    {
      AppMethodBeat.o(163206);
      return;
    }
    if (this.KgQ.Khw.value) {}
    gx localgx;
    StringBuilder localStringBuilder;
    for (int i = this.Kgx + this.jGV.size();; i = this.Kgx)
    {
      this.KgO = ait(this.KgP + i + 1);
      this.COD.setToScreen(this.KgO);
      this.KgP = -1;
      localgx = new gx();
      localgx.ejA = 1L;
      localgx.eLg = 1L;
      localStringBuilder = new StringBuilder();
      int j = 0;
      while (j < getAppPanelUnCertainEnterArrayList().size())
      {
        if (this.KgO == ait(this.KgP + i + 1)) {
          localStringBuilder.append(((a.a)getAppPanelUnCertainEnterArrayList().get(j)).KhQ).append("|");
        }
        j += 1;
      }
    }
    localgx.uM(localStringBuilder.toString());
    localgx.bfK();
    AppMethodBeat.o(163206);
  }
  
  private void gpY()
  {
    AppMethodBeat.i(31482);
    Log.i("MicroMsg.AppPanel", "[dealOrientationChange]");
    this.COA = false;
    this.COD.setToScreen(0);
    gpW();
    requestLayout();
    AppMethodBeat.o(31482);
  }
  
  private void gqa()
  {
    AppMethodBeat.i(31484);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.Khi)
    {
      if (getScreenOrientation() != 2) {
        break label79;
      }
      Log.d("MicroMsg.AppPanel", "initFlipper, landscape");
      localView = findViewById(2131296960);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, COm);
      localView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.Khi = false;
      AppMethodBeat.o(31484);
      return;
      label79:
      Log.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", new Object[] { Integer.valueOf(COl) });
      localView = findViewById(2131296960);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = getPortHeightPX();
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public final int aiu(int paramInt)
  {
    int m = this.KgI.length;
    int j = 0;
    int i = 0;
    int k;
    if (j < m)
    {
      k = i;
      if (this.KgI[j] != 0) {
        if (j != paramInt) {}
      }
    }
    for (;;)
    {
      if (i != -1) {
        break label63;
      }
      i = -1;
      return i;
      k = i + 1;
      j += 1;
      i = k;
      break;
      i = -1;
    }
    label63:
    i += 1;
    paramInt = i / this.Kgu;
    if (i % this.Kgu > 0) {}
    for (;;)
    {
      i = paramInt;
      if (paramInt >= 0) {
        break;
      }
      return 0;
      paramInt -= 1;
    }
  }
  
  public ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163205);
    ArrayList localArrayList = this.KgQ.getAppPanelUnCertainEnterArrayList();
    AppMethodBeat.o(163205);
    return localArrayList;
  }
  
  public int getCurScreen()
  {
    AppMethodBeat.i(232214);
    if (this.COD != null)
    {
      int i = this.COD.getCurScreen();
      AppMethodBeat.o(232214);
      return i;
    }
    AppMethodBeat.o(232214);
    return -1;
  }
  
  public int getPageMaxRowCount()
  {
    if (this.KgN == 0)
    {
      int i = (this.xeA + 3) / 4;
      if (i > 2) {
        return 2;
      }
      return i;
    }
    return this.KgN;
  }
  
  public final void gpK()
  {
    AppMethodBeat.i(31463);
    this.KgQ.gqd();
    this.KgY = false;
    this.KgZ = false;
    this.Kha = false;
    this.Khb = false;
    gpL();
    this.KgQ.Aa(this.KgU);
    this.KgQ.Ab(this.KgV);
    this.KgQ.Ae(this.KgW);
    this.KgQ.Af(this.KgX);
    gpV();
    AppMethodBeat.o(31463);
  }
  
  public final void gpL()
  {
    AppMethodBeat.i(31464);
    com.tencent.mm.n.h.aqK();
    if (com.tencent.mm.n.d.aqw() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.KgQ.gqe();
      this.KgQ.Ac(bool);
      bool = com.tencent.mm.br.c.aZU("location");
      this.KgQ.Ad(bool);
      this.KgQ.gqf();
      AppMethodBeat.o(31464);
      return;
    }
  }
  
  public final void gpM()
  {
    AppMethodBeat.i(31465);
    this.KgQ.Khq.value = false;
    gpV();
    AppMethodBeat.o(31465);
  }
  
  public final void gpN()
  {
    AppMethodBeat.i(31470);
    this.KgQ.Khx.value = false;
    gpV();
    Log.d("MicroMsg.AppPanel", "disableTalkroom enable false");
    AppMethodBeat.o(31470);
  }
  
  public final void gpO()
  {
    AppMethodBeat.i(31471);
    this.KgQ.KhC.value = false;
    gpV();
    AppMethodBeat.o(31471);
  }
  
  public final void gpP()
  {
    AppMethodBeat.i(31472);
    this.KgQ.Khw.value = false;
    gpV();
    AppMethodBeat.o(31472);
  }
  
  public final void gpQ()
  {
    AppMethodBeat.i(31473);
    this.KgQ.KhE.value = false;
    gpV();
    AppMethodBeat.o(31473);
  }
  
  public final void gpR()
  {
    AppMethodBeat.i(31474);
    this.KgQ.KhK.value = false;
    gpV();
    AppMethodBeat.o(31474);
  }
  
  public final void gpS()
  {
    AppMethodBeat.i(185751);
    this.KgQ.KhL.value = false;
    gpV();
    AppMethodBeat.o(185751);
  }
  
  public final void gpT()
  {
    AppMethodBeat.i(232211);
    this.KgQ.KhM.value = false;
    gpV();
    AppMethodBeat.o(232211);
  }
  
  public final void gpU()
  {
    AppMethodBeat.i(232212);
    this.KgQ.Ag(false);
    gpV();
    AppMethodBeat.o(232212);
  }
  
  public final void gpV()
  {
    AppMethodBeat.i(31475);
    int j = this.KgI.length;
    int i = 0;
    while (i < j)
    {
      this.KgI[i] = true;
      i += 1;
    }
    if (!this.KgQ.Khp.value) {
      this.KgI[0] = false;
    }
    for (j = 1;; j = 0)
    {
      i = j;
      if (!this.KgQ.Kho.value)
      {
        this.KgI[1] = false;
        i = j + 1;
      }
      j = i;
      if (!this.KgQ.KhK.value)
      {
        this.KgI[19] = false;
        j = i + 1;
      }
      i = j;
      if (!this.KgQ.KhL.value)
      {
        this.KgI[12] = false;
        i = j + 1;
      }
      j = i;
      if (!this.KgQ.KhM.value)
      {
        this.KgI[13] = false;
        j = i + 1;
      }
      i = j;
      if (!this.KgQ.KhN.value)
      {
        this.KgI[14] = false;
        i = j + 1;
      }
      if (this.KgQ.KhC.value)
      {
        j = i;
        if (this.KgQ.KhD.value) {}
      }
      else
      {
        this.KgI[6] = false;
        j = i + 1;
      }
      i = j;
      if (!this.KgQ.Khu.value)
      {
        this.KgI[17] = false;
        i = j + 1;
      }
      j = i;
      if (!this.KgQ.Khv.value)
      {
        Log.i("MicroMsg.AppPanel", "disable remittance");
        this.KgI[8] = false;
        j = i + 1;
      }
      i = j;
      if (!this.KgQ.Khq.value)
      {
        this.KgI[15] = false;
        i = j + 1;
      }
      j = i;
      if (!this.KgQ.KhE.value)
      {
        this.KgI[16] = false;
        j = i + 1;
      }
      i = j;
      if (!this.KgQ.KhH.value)
      {
        this.KgI[3] = false;
        i = j + 1;
      }
      j = i;
      if (!this.KgQ.Khr.value)
      {
        this.KgI[11] = false;
        j = i + 1;
      }
      i = j;
      if (!this.KgQ.Khx.value)
      {
        this.KgI[5] = false;
        i = j + 1;
      }
      if (this.KgQ.Khz.value)
      {
        j = i;
        if (this.KgQ.Khy.value) {}
      }
      else
      {
        this.KgI[4] = false;
        j = i + 1;
      }
      if (this.KgQ.Kht.value)
      {
        i = j;
        if (this.KgQ.Khs.value) {}
      }
      else
      {
        this.KgI[2] = false;
        i = j + 1;
      }
      if (this.KgQ.KhB.value)
      {
        j = i;
        if (this.KgQ.KhA.value) {}
      }
      else
      {
        this.KgI[10] = false;
        j = i + 1;
      }
      i = j;
      if (!this.KgQ.KhG.value)
      {
        Log.i("MicroMsg.AppPanel", "disable lucky money");
        this.KgI[7] = false;
        i = j + 1;
      }
      j = i;
      if (!this.KgQ.KhI.value)
      {
        this.KgI[18] = false;
        j = i + 1;
      }
      i = j;
      if (!this.KgQ.KhO.value)
      {
        this.KgI[20] = false;
        i = j + 1;
      }
      this.KgI[9] = false;
      this.Kgx = (21 - (i + 1));
      AppMethodBeat.o(31475);
      return;
    }
  }
  
  public final void gpZ()
  {
    AppMethodBeat.i(31483);
    Log.i("MicroMsg.AppPanel", "[forceRefreshSize]");
    gqa();
    gpY();
    AppMethodBeat.o(31483);
  }
  
  public final void init(int paramInt)
  {
    AppMethodBeat.i(31460);
    Log.i("MicroMsg.AppPanel", "init: %s", new Object[] { Integer.valueOf(paramInt) });
    this.KgQ = new a();
    this.KgT = paramInt;
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (localDisplay.getWidth() < localDisplay.getHeight()) {
      this.KgR = localDisplay.getWidth();
    }
    for (this.KgS = localDisplay.getHeight();; this.KgS = localDisplay.getWidth())
    {
      View.inflate(this.context, 2131493128, this);
      this.COE = ((MMDotView)findViewById(2131296961));
      this.COD = ((MMFlipper)findViewById(2131296962));
      gpW();
      gpK();
      bqe();
      AppMethodBeat.o(31460);
      return;
      this.KgR = localDisplay.getHeight();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(31481);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      Log.d("MicroMsg.AppPanel", "onConfigChanged:" + paramConfiguration.orientation);
      if (paramConfiguration.orientation != 1) {
        break label76;
      }
    }
    label76:
    for (this.Khd = true;; this.Khd = false)
    {
      setNeedRefreshHeight(true);
      gpY();
      AppMethodBeat.o(31481);
      return;
    }
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(31478);
    Log.i("MicroMsg.AppPanel", "app panel refleshed: %s", new Object[] { Integer.valueOf(this.KgT) });
    bqe();
    AppMethodBeat.o(31478);
  }
  
  public void setAppPanelListener(a parama)
  {
    this.KgJ = parama;
  }
  
  public void setAppPanelUnCertainEnterArrayList(ArrayList<a.a> paramArrayList)
  {
    this.KgQ.KhP = paramArrayList;
  }
  
  public void setChattingContext(ChatFooter.b paramb)
  {
    this.KgL = paramb;
  }
  
  public void setNeedRefreshHeight(boolean paramBoolean)
  {
    this.Khi = paramBoolean;
  }
  
  public void setOnSwitchPanelListener(AppPanel.b paramb)
  {
    this.KgK = paramb;
  }
  
  public void setPortHeighDP(int paramInt)
  {
    if (COl != paramInt)
    {
      COl = paramInt;
      this.Khi = true;
    }
  }
  
  public void setPortHeighPx(int paramInt)
  {
    if (this.Khj != paramInt)
    {
      this.Khj = paramInt;
      this.Khi = true;
    }
  }
  
  public void setServiceShowFlag(int paramInt)
  {
    AppMethodBeat.i(31461);
    Log.i("MicroMsg.AppPanel", "setServiceShowFlag: %s", new Object[] { Integer.valueOf(paramInt) });
    this.KgT = paramInt;
    AppMethodBeat.o(31461);
  }
  
  public void setUncertainEnterLocation(int paramInt)
  {
    this.KgP = paramInt;
  }
  
  public final void zW(boolean paramBoolean)
  {
    AppMethodBeat.i(31466);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.KgQ.Khs.value = paramBoolean;
      gpV();
      Log.d("MicroMsg.AppPanel", "enable " + paramBoolean + " isVoipPluginEnable " + this.KgQ.Kht.value);
      AppMethodBeat.o(31466);
      return;
    }
  }
  
  public final void zX(boolean paramBoolean)
  {
    AppMethodBeat.i(31467);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.KgQ.Khy.value = paramBoolean;
      gpV();
      Log.d("MicroMsg.AppPanel", "enable " + this.KgQ.Khz.value + " isVoipAudioEnable " + paramBoolean);
      AppMethodBeat.o(31467);
      return;
    }
  }
  
  public final void zY(boolean paramBoolean)
  {
    AppMethodBeat.i(31468);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.KgQ.KhH.value = paramBoolean;
      gpV();
      Log.d("MicroMsg.AppPanel", "enable " + this.KgQ.KhH.value + " isMultiTalkEnable " + paramBoolean);
      AppMethodBeat.o(31468);
      return;
    }
  }
  
  public final void zZ(boolean paramBoolean)
  {
    AppMethodBeat.i(31469);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.KgQ.KhA.value = paramBoolean;
      gpV();
      AppMethodBeat.o(31469);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void Qj(int paramInt);
    
    public abstract void Qk(int paramInt);
    
    public abstract void d(com.tencent.mm.pluginsdk.model.app.g paramg);
    
    public abstract void ehU();
    
    public abstract void ehV();
    
    public abstract void ehW();
    
    public abstract void ehX();
    
    public abstract void ehY();
    
    public abstract void ehZ();
    
    public abstract void eia();
    
    public abstract void eib();
    
    public abstract void eic();
    
    public abstract void eid();
    
    public abstract void eie();
    
    public abstract void eif();
    
    public abstract void eig();
    
    public abstract void eih();
    
    public abstract void eii();
    
    public abstract void eij();
    
    public abstract void eik();
    
    public abstract void eil();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel
 * JD-Core Version:    0.7.0.1
 */