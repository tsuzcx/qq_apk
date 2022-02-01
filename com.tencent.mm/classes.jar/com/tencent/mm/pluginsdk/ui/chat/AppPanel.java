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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.autogen.a.aaq.b;
import com.tencent.mm.autogen.mmdata.rpt.lm;
import com.tencent.mm.autogen.mmdata.rpt.ln;
import com.tencent.mm.live.c.e;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.topstory.ui.c.g;
import com.tencent.mm.pluginsdk.model.app.o;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.base.MMFlipper.a;
import com.tencent.mm.ui.base.MMFlipper.b;
import com.tencent.mm.ui.base.MMFlipper.c;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AppPanel
  extends LinearLayout
{
  private static int PcG = 215;
  private static int PcH = 158;
  private static boolean YdY = false;
  private int HCu;
  private boolean PcU;
  private int PcV;
  private int PcW;
  public MMFlipper PcX;
  private MMDotView PcY;
  private a YdA;
  private b YdB;
  private ChatFooter.b YdC;
  private List<AppGrid> YdD;
  private int YdE;
  public int YdF;
  private int YdG;
  public a YdH;
  private int YdI;
  private int YdJ;
  private int YdK;
  private boolean YdL;
  private boolean YdM;
  private boolean YdN;
  private boolean YdO;
  boolean YdP;
  boolean YdQ;
  boolean YdR;
  boolean YdS;
  private Map<String, com.tencent.mm.pluginsdk.model.app.g> YdT;
  private boolean YdU;
  private final int YdV;
  private int YdW;
  private AppGrid.b YdX;
  private boolean YdZ;
  private int Ydl;
  private int Ydo;
  private final boolean[] Ydz;
  private int Yea;
  private List<com.tencent.mm.pluginsdk.model.app.g> aYV;
  Context context;
  private com.tencent.mm.ui.chatting.d.a hlc;
  private boolean isInit;
  private SharedPreferences sp;
  
  public AppPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31459);
    this.Ydz = new boolean[22];
    this.PcU = false;
    this.Ydo = 22;
    this.HCu = this.Ydo;
    this.YdF = 0;
    this.YdG = -1;
    this.isInit = false;
    this.YdI = 0;
    this.YdJ = 0;
    this.YdK = 0;
    this.YdL = false;
    this.YdM = false;
    this.YdN = false;
    this.YdO = false;
    this.YdP = false;
    this.YdQ = false;
    this.YdR = false;
    this.YdS = false;
    this.YdT = null;
    this.YdU = true;
    this.aYV = new LinkedList();
    this.YdV = 2;
    this.YdW = -1;
    this.YdX = new AppGrid.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        int i = 0;
        AppMethodBeat.i(245330);
        if (paramAnonymousg != null) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          Log.d("MicroMsg.AppPanel", "pos=%d, has appInfo = %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool1) });
          if ((paramAnonymousg != null) && (com.tencent.mm.pluginsdk.model.app.h.p(paramAnonymousg))) {
            z.aU(paramAnonymousg.field_appId, "1");
          }
          AppPanel.d(AppPanel.this, AppPanel.q(AppPanel.this).getCurScreen());
          if (!(paramAnonymousg instanceof a.a)) {
            break label500;
          }
          paramAnonymousg = (a.a)paramAnonymousg;
          Log.i("MicroMsg.AppPanel", "jump_type:%s", new Object[] { Integer.valueOf(paramAnonymousg.jump_type) });
          if ((paramAnonymousg.YeX == null) || (paramAnonymousg.YeX.iLV() == null)) {
            break;
          }
          AppPanel.a(AppPanel.this, paramAnonymousg.YeX.iLV());
          AppMethodBeat.o(245330);
          return;
        }
        Object localObject;
        if (paramAnonymousg.jump_type == 1)
        {
          localObject = new com.tencent.mm.plugin.appbrand.api.g();
          if (!TextUtils.isEmpty(paramAnonymousg.YeK))
          {
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).username = paramAnonymousg.YeK;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).version = paramAnonymousg.YeM;
          }
        }
        for (;;)
        {
          try
          {
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).euz = Integer.parseInt(paramAnonymousg.YeO);
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).qAF = paramAnonymousg.YeN;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).scene = 1156;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).icX = paramAnonymousg.icX;
            ((t)com.tencent.mm.kernel.h.ax(t.class)).a(AppPanel.this.getContext(), (com.tencent.mm.plugin.appbrand.api.g)localObject);
            localObject = new lm();
            ((lm)localObject).ikE = 2L;
            ((lm)localObject).jaa = 0L;
            ((lm)localObject).uu(paramAnonymousg.YeJ);
            ((lm)localObject).bMH();
            AppMethodBeat.o(245330);
            return;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).appId = paramAnonymousg.YeL;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).euz = 0;
            continue;
          }
          if (paramAnonymousg.jump_type == 2) {
            if (paramAnonymousg.YeW > 0)
            {
              localObject = AppPanel.j(AppPanel.this);
              String str = paramAnonymousg.ttL;
              paramAnonymousInt = paramAnonymousg.YeW;
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", str);
              localIntent.putExtra("showShare", false);
              localIntent.putExtra("show_bottom", false);
              localIntent.putExtra("needRedirect", false);
              localIntent.putExtra("neverGetA8Key", false);
              localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
              localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
              localIntent.putExtra("KHalfScreenHeight", paramAnonymousInt);
              localIntent.putExtra("KHalfScreenHeightPercent", -1.0F);
              com.tencent.mm.br.c.b((Context)localObject, "webview", ".ui.tools.WebViewUI", localIntent);
            }
            else
            {
              com.tencent.mm.plugin.account.sdk.c.a.b(AppPanel.j(AppPanel.this), paramAnonymousg.ttL, 0, true);
            }
          }
        }
        label500:
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(245330);
          return;
          if (AppPanel.g(AppPanel.this) == null)
          {
            Log.e("MicroMsg.AppPanel", "infoList == null");
            AppMethodBeat.o(245330);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10305, String.valueOf(AppPanel.g(AppPanel.this).size()));
          com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(10), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
          com.tencent.mm.kernel.h.baE().ban().B(69121, "");
          AppPanel.v(AppPanel.this).gap();
          AppMethodBeat.o(245330);
          return;
          if (!WeChatBrands.Business.Entries.SessionPayment.checkAvailable(AppPanel.this.getContext()))
          {
            AppMethodBeat.o(245330);
            return;
          }
          localObject = paramAnonymousg;
          if (paramAnonymousg == null) {
            localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.w(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.XSb);
          }
          bh.bCz();
          paramAnonymousInt = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
          bh.bCz();
          paramAnonymousg = Util.stringsToList(((String)com.tencent.mm.model.c.ban().get(at.a.acPu, "")).split(";"));
          if (!paramAnonymousg.contains(String.valueOf(paramAnonymousInt)))
          {
            paramAnonymousg.add(String.valueOf(paramAnonymousInt));
            bh.bCz();
            com.tencent.mm.model.c.ban().set(at.a.acPu, Util.listToString(paramAnonymousg, ";"));
            AppPanel.this.bDL();
          }
          bh.bCz();
          com.tencent.mm.model.c.ban().B(80, Boolean.FALSE);
          AppPanel.v(AppPanel.this).d((com.tencent.mm.pluginsdk.model.app.g)localObject);
          AppMethodBeat.o(245330);
          return;
          if (!AppPanel.this.YdH.Yen.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(245330);
            return;
          }
          if (paramAnonymousg == null)
          {
            Log.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
            AppMethodBeat.o(245330);
            return;
          }
          if ((paramAnonymousg.iIs()) || (paramAnonymousg.iIu()))
          {
            if (AppPanel.x(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0));
            }
            if (AppPanel.x(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
              AppPanel.x(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
            }
            if (paramAnonymousg.iIu()) {
              com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(16), paramAnonymousg.field_appId, Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
            }
          }
          for (;;)
          {
            AppPanel.v(AppPanel.this).d(paramAnonymousg);
            AppMethodBeat.o(245330);
            return;
            com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(13), paramAnonymousg.field_appId, Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
            continue;
            com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(11), paramAnonymousg.field_appId, Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
          }
          if (AppPanel.t(AppPanel.this))
          {
            AppPanel.u(AppPanel.this);
            AppMethodBeat.o(245330);
            return;
          }
          paramAnonymousg = ((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.d.class)).aHy(AppPanel.i(AppPanel.this).getTalkerUserName());
          if (!TextUtils.isEmpty(paramAnonymousg))
          {
            AppPanel.a(AppPanel.this, paramAnonymousg);
            AppMethodBeat.o(245330);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(14), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
          paramAnonymousg = AppPanel.v(AppPanel.this);
          if (AppPanel.this.YdH.Yew.value) {}
          for (paramAnonymousInt = i;; paramAnonymousInt = 2)
          {
            paramAnonymousg.aas(paramAnonymousInt);
            AppMethodBeat.o(245330);
            return;
          }
          if (!AppPanel.this.YdH.Yeh.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(245330);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(4), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
          AppPanel.v(AppPanel.this).gao();
          AppMethodBeat.o(245330);
          return;
          if (!WeChatBrands.Business.Entries.SessionLuckyMoney.checkAvailable(AppPanel.this.getContext()))
          {
            AppMethodBeat.o(245330);
            return;
          }
          if (!AppPanel.this.YdH.Yex.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(245330);
            return;
          }
          if (paramAnonymousg == null)
          {
            localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.w(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.XSd);
            paramAnonymousg = (com.tencent.mm.pluginsdk.model.app.g)localObject;
            if (localObject == null)
            {
              AppMethodBeat.o(245330);
              return;
            }
          }
          if ((paramAnonymousg.iIs()) || (paramAnonymousg.iIu()))
          {
            if (AppPanel.x(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0));
            }
            if (AppPanel.x(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
              AppPanel.x(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(13), paramAnonymousg.field_appId, Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
          }
          for (;;)
          {
            bh.bCz();
            paramAnonymousInt = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
            bh.bCz();
            paramAnonymousg = Util.stringsToList(((String)com.tencent.mm.model.c.ban().get(at.a.acPv, "")).split(";"));
            if (!paramAnonymousg.contains(String.valueOf(paramAnonymousInt)))
            {
              paramAnonymousg.add(String.valueOf(paramAnonymousInt));
              bh.bCz();
              com.tencent.mm.model.c.ban().set(at.a.acPv, Util.listToString(paramAnonymousg, ";"));
              AppPanel.this.bDL();
            }
            AppPanel.v(AppPanel.this).gat();
            AppMethodBeat.o(245330);
            return;
            com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(11), paramAnonymousg.field_appId, Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
          }
          if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(AppPanel.this.getContext()))
          {
            AppMethodBeat.o(245330);
            return;
          }
          if ((!AppPanel.this.YdH.Yet.value) || (!AppPanel.this.YdH.Yeu.value))
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(245330);
            return;
          }
          bh.bCz();
          if (((Boolean)com.tencent.mm.model.c.ban().d(290817, Boolean.TRUE)).booleanValue())
          {
            bh.bCz();
            com.tencent.mm.model.c.ban().B(290817, Boolean.FALSE);
            AppPanel.this.bDL();
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(3), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
          AppPanel.v(AppPanel.this).gan();
          AppMethodBeat.o(245330);
          return;
          if (!AppPanel.this.YdH.Yel.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(245330);
            return;
          }
          bh.bCz();
          if (((Boolean)com.tencent.mm.model.c.ban().d(327744, Boolean.TRUE)).booleanValue())
          {
            bh.bCz();
            com.tencent.mm.model.c.ban().B(327744, Boolean.FALSE);
            AppPanel.this.bDL();
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(12), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
          AppPanel.v(AppPanel.this).gar();
          AppMethodBeat.o(245330);
          return;
          if (AppPanel.t(AppPanel.this))
          {
            AppPanel.u(AppPanel.this);
            AppMethodBeat.o(245330);
            return;
          }
          paramAnonymousg = ((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.gamelife.a.d.class)).aHx(AppPanel.i(AppPanel.this).getTalkerUserName());
          if (!TextUtils.isEmpty(paramAnonymousg))
          {
            AppPanel.a(AppPanel.this, paramAnonymousg);
            AppMethodBeat.o(245330);
            return;
          }
          if (!AppPanel.this.YdH.Yeg.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(245330);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(1), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
          AppPanel.a(AppPanel.this, false);
          AppMethodBeat.o(245330);
          return;
          if (!AppPanel.this.YdH.Yej.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(245330);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(8), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
          bh.bCz();
          com.tencent.mm.model.c.ban().B(54, Boolean.FALSE);
          if (AppPanel.v(AppPanel.this) != null)
          {
            paramAnonymousg = new aaq();
            paramAnonymousg.ieg.iei = true;
            paramAnonymousg.publish();
            paramAnonymousg = paramAnonymousg.ieh.iek;
            if (!Util.isNullOrNil(paramAnonymousg))
            {
              Log.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramAnonymousg)));
              com.tencent.mm.ui.base.k.b(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.gWJ), "", AppPanel.j(AppPanel.this).getString(R.l.app_ok), AppPanel.j(AppPanel.this).getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(245412);
                  aaq localaaq = new aaq();
                  localaaq.ieg.iej = true;
                  localaaq.publish();
                  AppPanel.v(AppPanel.this).gak();
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(245412);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(245393);
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(245393);
                }
              });
              AppMethodBeat.o(245330);
              return;
            }
            AppPanel.v(AppPanel.this).gak();
            AppMethodBeat.o(245330);
            return;
            if (!AppPanel.this.YdH.Yep.value)
            {
              Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
              AppMethodBeat.o(245330);
              return;
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(7), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
            bh.bCz();
            com.tencent.mm.model.c.ban().B(62, Boolean.FALSE);
            paramAnonymousg = new aaq();
            paramAnonymousg.ieg.iei = true;
            paramAnonymousg.publish();
            paramAnonymousg = paramAnonymousg.ieh.iek;
            if (!Util.isNullOrNil(paramAnonymousg))
            {
              Log.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramAnonymousg)));
              com.tencent.mm.ui.base.k.b(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.gWJ), "", AppPanel.j(AppPanel.this).getString(R.l.app_ok), AppPanel.j(AppPanel.this).getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(245395);
                  aaq localaaq = new aaq();
                  localaaq.ieg.iej = true;
                  localaaq.publish();
                  AppPanel.v(AppPanel.this).gal();
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(245395);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(245396);
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(245396);
                }
              });
              AppMethodBeat.o(245330);
              return;
            }
            AppPanel.v(AppPanel.this).gal();
            AppMethodBeat.o(245330);
            return;
            if (AppPanel.v(AppPanel.this) != null)
            {
              com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(6), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
              bh.bCz();
              com.tencent.mm.model.c.ban().B(67, Boolean.FALSE);
              AppPanel.v(AppPanel.this).gam();
              AppMethodBeat.o(245330);
              return;
              if (AppPanel.t(AppPanel.this))
              {
                AppPanel.u(AppPanel.this);
                AppMethodBeat.o(245330);
                return;
              }
              if (!WeChatBrands.Business.Entries.SessionVoiceMsg.checkAvailable(AppPanel.this.getContext()))
              {
                AppMethodBeat.o(245330);
                return;
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(9), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
              bh.bCz();
              com.tencent.mm.model.c.ban().B(73, Boolean.FALSE);
              AppPanel.y(AppPanel.this).iLR();
              AppMethodBeat.o(245330);
              return;
              if (!AppPanel.this.YdH.Yei.value)
              {
                Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                AppMethodBeat.o(245330);
                return;
              }
              com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(5), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
              if (AppPanel.v(AppPanel.this) != null)
              {
                AppPanel.v(AppPanel.this).gaq();
                AppMethodBeat.o(245330);
                return;
                if (!AppPanel.this.YdH.Yev.value)
                {
                  Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                  AppMethodBeat.o(245330);
                  return;
                }
                if (AppPanel.v(AppPanel.this) != null) {
                  AppPanel.v(AppPanel.this).gas();
                }
                com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(15), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
                bh.bCz();
                bool1 = ((Boolean)com.tencent.mm.model.c.ban().d(208899, Boolean.FALSE)).booleanValue();
                bh.bCz();
                boolean bool2 = ((Boolean)com.tencent.mm.model.c.ban().d(208913, Boolean.FALSE)).booleanValue();
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.h.OAn.b(11594, new Object[] { Integer.valueOf(3) });
                  AppMethodBeat.o(245330);
                  return;
                }
                if (bool2)
                {
                  com.tencent.mm.plugin.report.service.h.OAn.b(11594, new Object[] { Integer.valueOf(4) });
                  AppMethodBeat.o(245330);
                  return;
                  if (AppPanel.v(AppPanel.this) != null)
                  {
                    AppPanel.v(AppPanel.this).gau();
                    AppMethodBeat.o(245330);
                    return;
                    if (!AppPanel.this.YdH.Yez.value)
                    {
                      Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                      AppMethodBeat.o(245330);
                      return;
                    }
                    AppPanel.v(AppPanel.this).gav();
                    AppMethodBeat.o(245330);
                    return;
                    if (!AppPanel.this.YdH.YeF.value)
                    {
                      Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                      AppMethodBeat.o(245330);
                      return;
                    }
                    AppPanel.v(AppPanel.this).gaw();
                    com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(21), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
                    AppMethodBeat.o(245330);
                    return;
                    if (AppPanel.v(AppPanel.this) != null)
                    {
                      if (paramAnonymousg == null)
                      {
                        localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.w(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.XSe);
                        paramAnonymousg = (com.tencent.mm.pluginsdk.model.app.g)localObject;
                        if (localObject == null)
                        {
                          Log.i("MicroMsg.AppPanel", "empty info");
                          AppMethodBeat.o(245330);
                          return;
                        }
                      }
                      if ((paramAnonymousg.iIs()) || (paramAnonymousg.iIu()))
                      {
                        if (AppPanel.x(AppPanel.this) == null) {
                          AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0));
                        }
                        if (AppPanel.x(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
                          AppPanel.x(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
                        }
                      }
                      AppPanel.v(AppPanel.this).gax();
                      AppMethodBeat.o(245330);
                      return;
                      if (!AppPanel.this.YdH.YeB.value)
                      {
                        Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                        AppMethodBeat.o(245330);
                        return;
                      }
                      com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(17), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
                      if (AppPanel.v(AppPanel.this) != null)
                      {
                        AppPanel.v(AppPanel.this).gay();
                        AppMethodBeat.o(245330);
                        return;
                        if (!WeChatBrands.Business.Entries.SessionGroupTools.checkAvailable(AppPanel.this.getContext()))
                        {
                          AppMethodBeat.o(245330);
                          return;
                        }
                        if (!AppPanel.this.YdH.YeC.value)
                        {
                          Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                          AppMethodBeat.o(245330);
                          return;
                        }
                        if (AppPanel.v(AppPanel.this) != null)
                        {
                          AppPanel.v(AppPanel.this).gaA();
                          AppMethodBeat.o(245330);
                          return;
                          if (!WeChatBrands.Business.Entries.SessionGroupSolitaire.checkAvailable(AppPanel.this.getContext()))
                          {
                            AppMethodBeat.o(245330);
                            return;
                          }
                          if (!AppPanel.this.YdH.YeD.value)
                          {
                            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                            AppMethodBeat.o(245330);
                            return;
                          }
                          com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(19), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
                          if (AppPanel.v(AppPanel.this) != null)
                          {
                            AppPanel.v(AppPanel.this).gaB();
                            AppMethodBeat.o(245330);
                            return;
                            if (!WeChatBrands.Business.Entries.SessionGroupLive.checkAvailable(AppPanel.this.getContext()))
                            {
                              AppMethodBeat.o(245330);
                              return;
                            }
                            if (!AppPanel.this.YdH.YeE.value)
                            {
                              Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                              AppMethodBeat.o(245330);
                              return;
                            }
                            com.tencent.mm.plugin.report.service.h.OAn.b(10923, new Object[] { Integer.valueOf(20), "", Integer.valueOf(0), AppPanel.i(AppPanel.this).getTalkerUserName() });
                            if (AppPanel.v(AppPanel.this) != null)
                            {
                              AppPanel.v(AppPanel.this).gaz();
                              com.tencent.mm.live.c.a.bjE();
                              AppMethodBeat.o(245330);
                              return;
                              paramAnonymousg = (com.tencent.mm.plugin.musicchat.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.musicchat.a.a.class);
                              paramAnonymousg.setMusicSender(new o(AppPanel.i(AppPanel.this).getTalkerUserName()));
                              paramAnonymousg.startSendMusic(AppPanel.j(AppPanel.this));
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
      
      public final int awx(int paramAnonymousInt)
      {
        AppMethodBeat.i(245310);
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
                AppMethodBeat.o(245310);
                return i;
              }
              k = j + 1;
            }
            i += 1;
          }
        }
        if ((paramAnonymousInt >= AppPanel.f(AppPanel.this)) && (paramAnonymousInt < AppPanel.s(AppPanel.this)))
        {
          AppMethodBeat.o(245310);
          return -2147483648;
        }
        AppMethodBeat.o(245310);
        return 2147483647;
      }
      
      public final void awy(int paramAnonymousInt)
      {
        AppMethodBeat.i(245315);
        if (paramAnonymousInt == 0)
        {
          if (!AppPanel.this.YdH.Yeg.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(245315);
            return;
          }
          if (AppPanel.t(AppPanel.this))
          {
            AppPanel.u(AppPanel.this);
            AppMethodBeat.o(245315);
            return;
          }
          if (com.tencent.mm.pluginsdk.permission.b.g(AppPanel.j(AppPanel.this), new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }))
          {
            AppPanel.a(AppPanel.this, true);
            AppMethodBeat.o(245315);
            return;
          }
          AppPanel.a(AppPanel.this, false);
          AppMethodBeat.o(245315);
          return;
        }
        AppMethodBeat.o(245315);
      }
    };
    this.YdZ = true;
    this.Yea = -1;
    this.context = paramContext;
    AppMethodBeat.o(31459);
  }
  
  private int awz(int paramInt)
  {
    int i = paramInt / this.Ydl;
    if (paramInt % this.Ydl > 0) {}
    for (paramInt = i;; paramInt = i - 1)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      return i;
    }
  }
  
  private void brg(String paramString)
  {
    AppMethodBeat.i(245398);
    Log.i("MicroMsg.AppPanel", "showForbiddenDialog: %s", new Object[] { paramString });
    g.a locala = new g.a(this.context);
    locala.bDE(paramString).NF(true);
    locala.aEX(c.g.welcome_i_know).b(new g.c()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).d(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
    }).show();
    AppMethodBeat.o(245398);
  }
  
  private void dSD()
  {
    AppMethodBeat.i(245394);
    com.tencent.threadpool.h.ahAA.bFQ("AppPanel-loadinfo");
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(245306);
        AppPanel.g(AppPanel.this).clear();
        for (;;)
        {
          try
          {
            String str = com.tencent.mm.k.i.aRC().getValue("ShowAPPSuggestion");
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
            AppPanel.mw(AppPanel.g(AppPanel.this));
          }
          AppPanel.b(AppPanel.this, AppPanel.g(AppPanel.this));
          if (AppPanel.this.YdH != null)
          {
            AppPanel.this.YdH.JP(AppPanel.m(AppPanel.this));
            AppPanel.this.YdH.JQ(AppPanel.n(AppPanel.this));
            AppPanel.this.YdH.JT(AppPanel.o(AppPanel.this));
            AppPanel.this.YdH.JU(AppPanel.p(AppPanel.this));
          }
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(245406);
              if (AppPanel.h(AppPanel.this) == -1) {}
              for (int i = AppPanel.q(AppPanel.this).getCurScreen();; i = -1)
              {
                AppPanel.d(AppPanel.this);
                if (i != -1)
                {
                  AppPanel.q(AppPanel.this).setToScreen(i);
                  AppPanel.e(AppPanel.this).setSelectedDot(i);
                }
                AppMethodBeat.o(245406);
                return;
              }
            }
          });
          AppMethodBeat.o(245306);
          return;
          Log.i("MicroMsg.AppPanel", "jacks show App Suggestion");
          AppPanel.a(AppPanel.this, com.tencent.mm.pluginsdk.model.app.h.a(AppPanel.j(AppPanel.this), true, AppPanel.k(AppPanel.this)));
        }
      }
    }, "AppPanel-loadinfo");
    AppMethodBeat.o(245394);
  }
  
  private int getPortHeightPX()
  {
    AppMethodBeat.i(31485);
    if (this.Yea > 0)
    {
      i = this.Yea;
      AppMethodBeat.o(31485);
      return i;
    }
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, PcG);
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
  
  private void iLM()
  {
    AppMethodBeat.i(31477);
    Log.d("MicroMsg.AppPanel", "AppPanel initFlipper");
    this.YdW = -1;
    this.PcX.removeAllViews();
    this.PcX.setOnMeasureListener(new MMFlipper.b()
    {
      public final void kS(int paramAnonymousInt1, int paramAnonymousInt2)
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
    this.PcX.setOnFlipperViewShowedListener(new MMFlipper.a()
    {
      public final void awB(int paramAnonymousInt)
      {
        AppMethodBeat.i(245307);
        Log.i("MicroMsg.AppPanel", "viewpage reshow %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        int i = AppPanel.this.awA(14);
        if ((paramAnonymousInt == i) && (AppPanel.this.YdH.YeE.value)) {
          e.tR(i + 1);
        }
        AppMethodBeat.o(245307);
      }
    });
    this.PcX.setOnScreenChangedListener(new MMFlipper.c()
    {
      public final void onScreenChanged(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(245308);
        AppPanel.e(AppPanel.this).setSelectedDot(paramAnonymousInt2);
        Object localObject2;
        if ((AppPanel.this.getVisibility() == 0) && (paramAnonymousInt1 != -1) && (paramAnonymousInt1 != paramAnonymousInt2) && (paramAnonymousBoolean))
        {
          if (AppPanel.this.YdH.Yen.value) {}
          for (int i = AppPanel.f(AppPanel.this) + AppPanel.g(AppPanel.this).size();; i = AppPanel.f(AppPanel.this))
          {
            localObject1 = new lm();
            ((lm)localObject1).ikE = 1L;
            ((lm)localObject1).jaa = 0L;
            localObject2 = new StringBuilder();
            int j = 0;
            while (j < AppPanel.this.getAppPanelUnCertainEnterArrayList().size())
            {
              AppPanel localAppPanel = AppPanel.this;
              if (paramAnonymousInt1 == AppPanel.c(localAppPanel, AppPanel.h(localAppPanel) + i + 1)) {
                ((StringBuilder)localObject2).append(((a.a)AppPanel.this.getAppPanelUnCertainEnterArrayList().get(j)).YeJ).append("|");
              }
              j += 1;
            }
          }
          ((lm)localObject1).uu(((StringBuilder)localObject2).toString());
          ((lm)localObject1).bMH();
          paramAnonymousInt1 = AppPanel.this.awA(13);
          if ((paramAnonymousInt1 != -1) && (paramAnonymousInt1 == AppPanel.this.getCurScreen())) {
            if (AppPanel.i(AppPanel.this) != null) {
              break label364;
            }
          }
        }
        label364:
        for (Object localObject1 = "";; localObject1 = AppPanel.i(AppPanel.this).getTalkerUserName())
        {
          localObject2 = new ln();
          ((ln)localObject2).uv((String)localObject1);
          ((ln)localObject2).jaa = 0L;
          ((ln)localObject2).uw("19");
          ((ln)localObject2).jad = (paramAnonymousInt1 + 1);
          ((ln)localObject2).bMH();
          Log.i("MicroMsg.AppPanel", "scroll to show page %s", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          paramAnonymousInt1 = AppPanel.this.awA(14);
          if ((paramAnonymousInt2 == paramAnonymousInt1) && (AppPanel.this.YdH.YeE.value)) {
            e.tR(paramAnonymousInt1 + 1);
          }
          AppMethodBeat.o(245308);
          return;
        }
      }
    });
    iLP();
    AppMethodBeat.o(31477);
  }
  
  private void iLN()
  {
    AppMethodBeat.i(163206);
    if (this.YdG == -1)
    {
      AppMethodBeat.o(163206);
      return;
    }
    if (this.YdH.Yen.value) {}
    lm locallm;
    StringBuilder localStringBuilder;
    for (int i = this.Ydo + this.aYV.size();; i = this.Ydo)
    {
      this.YdF = awz(this.YdG + i + 1);
      this.PcX.setToScreen(this.YdF);
      this.YdG = -1;
      locallm = new lm();
      locallm.ikE = 1L;
      locallm.jaa = 1L;
      localStringBuilder = new StringBuilder();
      int j = 0;
      while (j < getAppPanelUnCertainEnterArrayList().size())
      {
        if (this.YdF == awz(this.YdG + i + 1)) {
          localStringBuilder.append(((a.a)getAppPanelUnCertainEnterArrayList().get(j)).YeJ).append("|");
        }
        j += 1;
      }
    }
    locallm.uu(localStringBuilder.toString());
    locallm.bMH();
    AppMethodBeat.o(163206);
  }
  
  private void iLP()
  {
    AppMethodBeat.i(31484);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.YdZ)
    {
      if (getScreenOrientation() != 2) {
        break label79;
      }
      Log.d("MicroMsg.AppPanel", "initFlipper, landscape");
      localView = findViewById(R.h.frr);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, PcH);
      localView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.YdZ = false;
      AppMethodBeat.o(31484);
      return;
      label79:
      Log.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", new Object[] { Integer.valueOf(PcG) });
      localView = findViewById(R.h.frr);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = getPortHeightPX();
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public final void JL(boolean paramBoolean)
  {
    AppMethodBeat.i(31466);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.YdH.Yej.value = paramBoolean;
      iLL();
      Log.d("MicroMsg.AppPanel", "enable " + paramBoolean + " isVoipPluginEnable " + this.YdH.Yek.value);
      AppMethodBeat.o(31466);
      return;
    }
  }
  
  public final void JM(boolean paramBoolean)
  {
    AppMethodBeat.i(31467);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.YdH.Yep.value = paramBoolean;
      iLL();
      Log.d("MicroMsg.AppPanel", "enable " + this.YdH.Yeq.value + " isVoipAudioEnable " + paramBoolean);
      AppMethodBeat.o(31467);
      return;
    }
  }
  
  public final void JN(boolean paramBoolean)
  {
    AppMethodBeat.i(31468);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.YdH.Yey.value = paramBoolean;
      iLL();
      Log.d("MicroMsg.AppPanel", "enable " + this.YdH.Yey.value + " isMultiTalkEnable " + paramBoolean);
      AppMethodBeat.o(31468);
      return;
    }
  }
  
  public final void JO(boolean paramBoolean)
  {
    AppMethodBeat.i(31469);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.YdH.Yer.value = paramBoolean;
      iLL();
      AppMethodBeat.o(31469);
      return;
    }
  }
  
  public final int awA(int paramInt)
  {
    int m = this.Ydz.length;
    int j = 0;
    int i = 0;
    int k;
    if (j < m)
    {
      k = i;
      if (this.Ydz[j] != 0) {
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
    paramInt = i / this.Ydl;
    if (i % this.Ydl > 0) {}
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
  
  public final void bDL()
  {
    AppMethodBeat.i(31478);
    Log.i("MicroMsg.AppPanel", "app panel refleshed: %s", new Object[] { Integer.valueOf(this.YdK) });
    dSD();
    AppMethodBeat.o(31478);
  }
  
  public ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163205);
    ArrayList localArrayList = this.YdH.getAppPanelUnCertainEnterArrayList();
    AppMethodBeat.o(163205);
    return localArrayList;
  }
  
  public int getCurScreen()
  {
    AppMethodBeat.i(245553);
    if (this.PcX != null)
    {
      int i = this.PcX.getCurScreen();
      AppMethodBeat.o(245553);
      return i;
    }
    AppMethodBeat.o(245553);
    return -1;
  }
  
  public int getPageMaxRowCount()
  {
    if (this.YdE == 0)
    {
      int i = (this.HCu + 3) / 4;
      if (i > 2) {
        return 2;
      }
      return i;
    }
    return this.YdE;
  }
  
  public final void iLA()
  {
    AppMethodBeat.i(31464);
    com.tencent.mm.k.i.aRD();
    if (com.tencent.mm.k.d.aRq() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.YdH.iLT();
      this.YdH.JR(bool);
      bool = com.tencent.mm.br.c.blq("location");
      this.YdH.JS(bool);
      this.YdH.iLU();
      bool = ((com.tencent.mm.plugin.musicchat.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.musicchat.a.a.class)).isEnableMusicChat();
      this.YdH.JW(bool);
      AppMethodBeat.o(31464);
      return;
    }
  }
  
  public final void iLB()
  {
    AppMethodBeat.i(31465);
    this.YdH.Yeh.value = false;
    iLL();
    AppMethodBeat.o(31465);
  }
  
  public final void iLC()
  {
    AppMethodBeat.i(31470);
    this.YdH.Yeo.value = false;
    iLL();
    Log.d("MicroMsg.AppPanel", "disableTalkroom enable false");
    AppMethodBeat.o(31470);
  }
  
  public final void iLD()
  {
    AppMethodBeat.i(31471);
    this.YdH.Yet.value = false;
    iLL();
    AppMethodBeat.o(31471);
  }
  
  public final void iLE()
  {
    AppMethodBeat.i(31472);
    this.YdH.Yen.value = false;
    iLL();
    AppMethodBeat.o(31472);
  }
  
  public final void iLF()
  {
    AppMethodBeat.i(31473);
    this.YdH.Yev.value = false;
    iLL();
    AppMethodBeat.o(31473);
  }
  
  public final void iLG()
  {
    AppMethodBeat.i(31474);
    this.YdH.YeB.value = false;
    iLL();
    AppMethodBeat.o(31474);
  }
  
  public final void iLH()
  {
    AppMethodBeat.i(185751);
    this.YdH.YeC.value = false;
    iLL();
    AppMethodBeat.o(185751);
  }
  
  public final void iLI()
  {
    AppMethodBeat.i(245514);
    this.YdH.YeD.value = false;
    iLL();
    AppMethodBeat.o(245514);
  }
  
  public final void iLJ()
  {
    AppMethodBeat.i(245517);
    this.YdH.JV(false);
    iLL();
    AppMethodBeat.o(245517);
  }
  
  public final void iLK()
  {
    AppMethodBeat.i(245523);
    this.YdH.YeG.value = false;
    iLL();
    Log.d("MicroMsg.AppPanel", "enable false isMusicChatPluginEnable " + this.YdH.YeH.value);
    AppMethodBeat.o(245523);
  }
  
  public final void iLL()
  {
    AppMethodBeat.i(31475);
    int j = this.Ydz.length;
    int i = 0;
    while (i < j)
    {
      this.Ydz[i] = true;
      i += 1;
    }
    if (!this.YdH.Yeg.value) {
      this.Ydz[0] = false;
    }
    for (j = 1;; j = 0)
    {
      i = j;
      if (!this.YdH.Yef.value)
      {
        this.Ydz[1] = false;
        i = j + 1;
      }
      j = i;
      if (!this.YdH.YeB.value)
      {
        this.Ydz[19] = false;
        j = i + 1;
      }
      i = j;
      if (!this.YdH.YeC.value)
      {
        this.Ydz[12] = false;
        i = j + 1;
      }
      j = i;
      if (!this.YdH.YeD.value)
      {
        this.Ydz[13] = false;
        j = i + 1;
      }
      i = j;
      if (!this.YdH.YeE.value)
      {
        this.Ydz[14] = false;
        i = j + 1;
      }
      if (this.YdH.Yet.value)
      {
        j = i;
        if (this.YdH.Yeu.value) {}
      }
      else
      {
        this.Ydz[6] = false;
        j = i + 1;
      }
      i = j;
      if (!this.YdH.Yel.value)
      {
        this.Ydz[17] = false;
        i = j + 1;
      }
      j = i;
      if (!this.YdH.Yem.value)
      {
        Log.i("MicroMsg.AppPanel", "disable remittance");
        this.Ydz[8] = false;
        j = i + 1;
      }
      i = j;
      if (!this.YdH.Yeh.value)
      {
        this.Ydz[15] = false;
        i = j + 1;
      }
      j = i;
      if (!this.YdH.Yev.value)
      {
        this.Ydz[16] = false;
        j = i + 1;
      }
      i = j;
      if (!this.YdH.Yey.value)
      {
        this.Ydz[3] = false;
        i = j + 1;
      }
      j = i;
      if (!this.YdH.Yei.value)
      {
        this.Ydz[11] = false;
        j = i + 1;
      }
      i = j;
      if (!this.YdH.Yeo.value)
      {
        this.Ydz[5] = false;
        i = j + 1;
      }
      if (this.YdH.Yeq.value)
      {
        j = i;
        if (this.YdH.Yep.value) {}
      }
      else
      {
        this.Ydz[4] = false;
        j = i + 1;
      }
      if (this.YdH.Yek.value)
      {
        i = j;
        if (this.YdH.Yej.value) {}
      }
      else
      {
        this.Ydz[2] = false;
        i = j + 1;
      }
      if (this.YdH.Yes.value)
      {
        j = i;
        if (this.YdH.Yer.value) {}
      }
      else
      {
        this.Ydz[10] = false;
        j = i + 1;
      }
      i = j;
      if (!this.YdH.Yex.value)
      {
        Log.i("MicroMsg.AppPanel", "disable lucky money");
        this.Ydz[7] = false;
        i = j + 1;
      }
      j = i;
      if (!this.YdH.Yez.value)
      {
        this.Ydz[18] = false;
        j = i + 1;
      }
      i = j;
      if (!this.YdH.YeF.value)
      {
        this.Ydz[20] = false;
        i = j + 1;
      }
      this.Ydz[9] = false;
      j = i + 1;
      if (this.YdH.YeH.value)
      {
        i = j;
        if (this.YdH.YeG.value) {}
      }
      else
      {
        this.Ydz[21] = false;
        i = j + 1;
      }
      this.Ydo = (22 - i);
      AppMethodBeat.o(31475);
      return;
    }
  }
  
  public final void iLO()
  {
    AppMethodBeat.i(31483);
    Log.i("MicroMsg.AppPanel", "[forceRefreshSize]");
    iLP();
    AppMethodBeat.o(31483);
  }
  
  public final void iLz()
  {
    AppMethodBeat.i(31463);
    this.YdH.iLS();
    this.YdP = false;
    this.YdQ = false;
    this.YdR = false;
    this.YdS = false;
    iLA();
    this.YdH.JP(this.YdL);
    this.YdH.JQ(this.YdM);
    this.YdH.JT(this.YdN);
    this.YdH.JU(this.YdO);
    iLL();
    AppMethodBeat.o(31463);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(31481);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      Log.d("MicroMsg.AppPanel", "onConfigChanged:" + paramConfiguration.orientation);
      if (paramConfiguration.orientation != 1) {
        break label101;
      }
    }
    label101:
    for (this.YdU = true;; this.YdU = false)
    {
      setNeedRefreshHeight(true);
      Log.i("MicroMsg.AppPanel", "[dealOrientationChange]");
      this.PcU = false;
      this.PcX.setToScreen(0);
      iLM();
      requestLayout();
      AppMethodBeat.o(31481);
      return;
    }
  }
  
  public final void sE(int paramInt)
  {
    AppMethodBeat.i(31460);
    Log.i("MicroMsg.AppPanel", "init: %s", new Object[] { Integer.valueOf(paramInt) });
    this.YdH = new a();
    this.YdK = paramInt;
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (localDisplay.getWidth() < localDisplay.getHeight()) {
      this.YdI = localDisplay.getWidth();
    }
    for (this.YdJ = localDisplay.getHeight();; this.YdJ = localDisplay.getWidth())
    {
      View.inflate(this.context, R.i.gej, this);
      this.PcY = ((MMDotView)findViewById(R.h.frs));
      this.PcX = ((MMFlipper)findViewById(R.h.frt));
      iLM();
      iLz();
      dSD();
      AppMethodBeat.o(31460);
      return;
      this.YdI = localDisplay.getHeight();
    }
  }
  
  public void setAppPanelListener(a parama)
  {
    this.YdA = parama;
  }
  
  public void setAppPanelUnCertainEnterArrayList(ArrayList<a.a> paramArrayList)
  {
    this.YdH.YeI = paramArrayList;
  }
  
  public void setChattingContext(ChatFooter.b paramb)
  {
    this.YdC = paramb;
  }
  
  public void setChattingContext(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.hlc = parama;
  }
  
  public void setNeedRefreshHeight(boolean paramBoolean)
  {
    this.YdZ = paramBoolean;
  }
  
  public void setOnSwitchPanelListener(b paramb)
  {
    this.YdB = paramb;
  }
  
  public void setPortHeighDP(int paramInt)
  {
    if (PcG != paramInt)
    {
      PcG = paramInt;
      this.YdZ = true;
    }
  }
  
  public void setPortHeighPx(int paramInt)
  {
    if (this.Yea != paramInt)
    {
      this.Yea = paramInt;
      this.YdZ = true;
    }
  }
  
  public void setServiceShowFlag(int paramInt)
  {
    AppMethodBeat.i(31461);
    Log.i("MicroMsg.AppPanel", "setServiceShowFlag: %s", new Object[] { Integer.valueOf(paramInt) });
    this.YdK = paramInt;
    AppMethodBeat.o(31461);
  }
  
  public void setUncertainEnterLocation(int paramInt)
  {
    this.YdG = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void aar(int paramInt);
    
    public abstract void aas(int paramInt);
    
    public abstract void d(com.tencent.mm.pluginsdk.model.app.g paramg);
    
    public abstract void gaA();
    
    public abstract void gaB();
    
    public abstract void gak();
    
    public abstract void gal();
    
    public abstract void gam();
    
    public abstract void gan();
    
    public abstract void gao();
    
    public abstract void gap();
    
    public abstract void gaq();
    
    public abstract void gar();
    
    public abstract void gas();
    
    public abstract void gat();
    
    public abstract void gau();
    
    public abstract void gav();
    
    public abstract void gaw();
    
    public abstract void gax();
    
    public abstract void gay();
    
    public abstract void gaz();
  }
  
  public static abstract interface b
  {
    public abstract void iLR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel
 * JD-Core Version:    0.7.0.1
 */