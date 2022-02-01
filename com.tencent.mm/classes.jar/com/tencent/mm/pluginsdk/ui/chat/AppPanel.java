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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.f.a.yx.b;
import com.tencent.mm.f.b.a.jc;
import com.tencent.mm.f.b.a.jd;
import com.tencent.mm.live.d.e;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.topstory.ui.c.g;
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
  private static int ITN = 215;
  private static int ITO = 158;
  private static boolean RhS = false;
  private int BQJ;
  private boolean IUc;
  private int IUd;
  private int IUe;
  public MMFlipper IUf;
  private MMDotView IUg;
  private int RhA;
  public a RhB;
  private int RhC;
  private int RhD;
  private int RhE;
  private boolean RhF;
  private boolean RhG;
  private boolean RhH;
  private boolean RhI;
  boolean RhJ;
  boolean RhK;
  boolean RhL;
  boolean RhM;
  private Map<String, com.tencent.mm.pluginsdk.model.app.g> RhN;
  private boolean RhO;
  private final int RhP;
  private int RhQ;
  private AppGrid.b RhR;
  private boolean RhT;
  private int RhU;
  private int Rhf;
  private int Rhi;
  private final boolean[] Rht;
  private a Rhu;
  private AppPanel.b Rhv;
  private ChatFooter.b Rhw;
  private List<AppGrid> Rhx;
  private int Rhy;
  public int Rhz;
  Context context;
  private boolean isInit;
  private List<com.tencent.mm.pluginsdk.model.app.g> mxJ;
  private SharedPreferences sp;
  
  public AppPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31459);
    this.Rht = new boolean[21];
    this.IUc = false;
    this.Rhi = 21;
    this.BQJ = this.Rhi;
    this.Rhz = 0;
    this.RhA = -1;
    this.isInit = false;
    this.RhC = 0;
    this.RhD = 0;
    this.RhE = 0;
    this.RhF = false;
    this.RhG = false;
    this.RhH = false;
    this.RhI = false;
    this.RhJ = false;
    this.RhK = false;
    this.RhL = false;
    this.RhM = false;
    this.RhN = null;
    this.RhO = true;
    this.mxJ = new LinkedList();
    this.RhP = 2;
    this.RhQ = -1;
    this.RhR = new AppGrid.b()
    {
      public final void a(int paramAnonymousInt, com.tencent.mm.pluginsdk.model.app.g paramAnonymousg)
      {
        int i = 0;
        AppMethodBeat.i(277930);
        if (paramAnonymousg != null) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          Log.d("MicroMsg.AppPanel", "pos=%d, has appInfo = %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(bool1) });
          if ((paramAnonymousg != null) && (com.tencent.mm.pluginsdk.model.app.h.p(paramAnonymousg))) {
            z.aK(paramAnonymousg.field_appId, "1");
          }
          AppPanel.d(AppPanel.this, AppPanel.q(AppPanel.this).getCurScreen());
          if (!(paramAnonymousg instanceof a.a)) {
            break label500;
          }
          paramAnonymousg = (a.a)paramAnonymousg;
          Log.i("MicroMsg.AppPanel", "jump_type:%s", new Object[] { Integer.valueOf(paramAnonymousg.jump_type) });
          if ((paramAnonymousg.RiQ == null) || (paramAnonymousg.RiQ.hle() == null)) {
            break;
          }
          AppPanel.a(AppPanel.this, paramAnonymousg.RiQ.hle());
          AppMethodBeat.o(277930);
          return;
        }
        Object localObject;
        if (paramAnonymousg.jump_type == 1)
        {
          localObject = new com.tencent.mm.plugin.appbrand.api.g();
          if (!TextUtils.isEmpty(paramAnonymousg.RiC))
          {
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).username = paramAnonymousg.RiC;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).version = paramAnonymousg.RiE;
          }
        }
        for (;;)
        {
          try
          {
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).cBU = Integer.parseInt(paramAnonymousg.RiG);
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).nBq = paramAnonymousg.RiF;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).scene = 1156;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).fWY = paramAnonymousg.fWY;
            ((r)com.tencent.mm.kernel.h.ae(r.class)).a(AppPanel.this.getContext(), (com.tencent.mm.plugin.appbrand.api.g)localObject);
            localObject = new jc();
            ((jc)localObject).gef = 2L;
            ((jc)localObject).gKK = 0L;
            ((jc)localObject).Aj(paramAnonymousg.RiB);
            ((jc)localObject).bpa();
            AppMethodBeat.o(277930);
            return;
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).appId = paramAnonymousg.RiD;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            ((com.tencent.mm.plugin.appbrand.api.g)localObject).cBU = 0;
            continue;
          }
          if (paramAnonymousg.jump_type == 2) {
            if (paramAnonymousg.RiP > 0)
            {
              localObject = AppPanel.j(AppPanel.this);
              String str = paramAnonymousg.qpi;
              paramAnonymousInt = paramAnonymousg.RiP;
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", str);
              localIntent.putExtra("showShare", false);
              localIntent.putExtra("show_bottom", false);
              localIntent.putExtra("needRedirect", false);
              localIntent.putExtra("neverGetA8Key", false);
              localIntent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
              localIntent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
              localIntent.putExtra("KHalfScreenHeight", paramAnonymousInt);
              localIntent.putExtra("KHalfScreenHeightPercent", -1.0F);
              com.tencent.mm.by.c.b((Context)localObject, "webview", ".ui.tools.WebViewUI", localIntent);
            }
            else
            {
              com.tencent.mm.plugin.account.sdk.b.a.b(AppPanel.j(AppPanel.this), paramAnonymousg.qpi, 0, true);
            }
          }
        }
        label500:
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(277930);
          return;
          if (AppPanel.g(AppPanel.this) == null)
          {
            Log.e("MicroMsg.AppPanel", "infoList == null");
            AppMethodBeat.o(277930);
            return;
          }
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10305, String.valueOf(AppPanel.g(AppPanel.this).size()));
          com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(10) });
          com.tencent.mm.kernel.h.aHG().aHp().i(69121, "");
          AppPanel.v(AppPanel.this).eRG();
          AppMethodBeat.o(277930);
          return;
          if (!WeChatBrands.Business.Entries.SessionPayment.checkAvailable(AppPanel.this.getContext()))
          {
            AppMethodBeat.o(277930);
            return;
          }
          localObject = paramAnonymousg;
          if (paramAnonymousg == null) {
            localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.w(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.QWe);
          }
          bh.beI();
          paramAnonymousInt = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
          bh.beI();
          paramAnonymousg = Util.stringsToList(((String)com.tencent.mm.model.c.aHp().get(ar.a.VnZ, "")).split(";"));
          if (!paramAnonymousg.contains(String.valueOf(paramAnonymousInt)))
          {
            paramAnonymousg.add(String.valueOf(paramAnonymousInt));
            bh.beI();
            com.tencent.mm.model.c.aHp().set(ar.a.VnZ, Util.listToString(paramAnonymousg, ";"));
            AppPanel.this.bfU();
          }
          bh.beI();
          com.tencent.mm.model.c.aHp().i(80, Boolean.FALSE);
          AppPanel.v(AppPanel.this).d((com.tencent.mm.pluginsdk.model.app.g)localObject);
          AppMethodBeat.o(277930);
          return;
          if (!AppPanel.this.RhB.Rih.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(277930);
            return;
          }
          if (paramAnonymousg == null)
          {
            Log.e("MicroMsg.AppPanel", "APP_MSG_POS bug appInfo is null");
            AppMethodBeat.o(277930);
            return;
          }
          if ((paramAnonymousg.hhs()) || (paramAnonymousg.hhu()))
          {
            if (AppPanel.x(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0));
            }
            if (AppPanel.x(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
              AppPanel.x(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
            }
            if (paramAnonymousg.hhu()) {
              com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(16), paramAnonymousg.field_appId, Integer.valueOf(0) });
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(13), paramAnonymousg.field_appId, Integer.valueOf(0) });
          }
          for (;;)
          {
            AppPanel.v(AppPanel.this).d(paramAnonymousg);
            AppMethodBeat.o(277930);
            return;
            com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(11), paramAnonymousg.field_appId });
          }
          if (AppPanel.t(AppPanel.this))
          {
            AppPanel.u(AppPanel.this);
            AppMethodBeat.o(277930);
            return;
          }
          paramAnonymousg = ((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.d.class)).aKI(AppPanel.i(AppPanel.this).getTalkerUserName());
          if (!TextUtils.isEmpty(paramAnonymousg))
          {
            AppPanel.a(AppPanel.this, paramAnonymousg);
            AppMethodBeat.o(277930);
            return;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(14) });
          paramAnonymousg = AppPanel.v(AppPanel.this);
          if (AppPanel.this.RhB.Riq.value) {}
          for (paramAnonymousInt = i;; paramAnonymousInt = 2)
          {
            paramAnonymousg.Ww(paramAnonymousInt);
            AppMethodBeat.o(277930);
            return;
          }
          if (!AppPanel.this.RhB.Rib.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(277930);
            return;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(4) });
          AppPanel.v(AppPanel.this).eRF();
          AppMethodBeat.o(277930);
          return;
          if (!WeChatBrands.Business.Entries.SessionLuckyMoney.checkAvailable(AppPanel.this.getContext()))
          {
            AppMethodBeat.o(277930);
            return;
          }
          if (!AppPanel.this.RhB.Rir.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(277930);
            return;
          }
          if (paramAnonymousg == null)
          {
            localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.w(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.QWg);
            paramAnonymousg = (com.tencent.mm.pluginsdk.model.app.g)localObject;
            if (localObject == null)
            {
              AppMethodBeat.o(277930);
              return;
            }
          }
          if ((paramAnonymousg.hhs()) || (paramAnonymousg.hhu()))
          {
            if (AppPanel.x(AppPanel.this) == null) {
              AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0));
            }
            if (AppPanel.x(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
              AppPanel.x(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(13), paramAnonymousg.field_appId, Integer.valueOf(0) });
          }
          for (;;)
          {
            bh.beI();
            paramAnonymousInt = ((Integer)com.tencent.mm.model.c.aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
            bh.beI();
            paramAnonymousg = Util.stringsToList(((String)com.tencent.mm.model.c.aHp().get(ar.a.Voa, "")).split(";"));
            if (!paramAnonymousg.contains(String.valueOf(paramAnonymousInt)))
            {
              paramAnonymousg.add(String.valueOf(paramAnonymousInt));
              bh.beI();
              com.tencent.mm.model.c.aHp().set(ar.a.Voa, Util.listToString(paramAnonymousg, ";"));
              AppPanel.this.bfU();
            }
            AppPanel.v(AppPanel.this).eRK();
            AppMethodBeat.o(277930);
            return;
            com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(11), paramAnonymousg.field_appId });
          }
          if (!WeChatBrands.Business.Entries.SessionLocation.checkAvailable(AppPanel.this.getContext()))
          {
            AppMethodBeat.o(277930);
            return;
          }
          if ((!AppPanel.this.RhB.Rin.value) || (!AppPanel.this.RhB.Rio.value))
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(277930);
            return;
          }
          bh.beI();
          if (((Boolean)com.tencent.mm.model.c.aHp().b(290817, Boolean.TRUE)).booleanValue())
          {
            bh.beI();
            com.tencent.mm.model.c.aHp().i(290817, Boolean.FALSE);
            AppPanel.this.bfU();
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(3) });
          AppPanel.v(AppPanel.this).eRE();
          AppMethodBeat.o(277930);
          return;
          if (!AppPanel.this.RhB.Rif.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(277930);
            return;
          }
          bh.beI();
          if (((Boolean)com.tencent.mm.model.c.aHp().b(327744, Boolean.TRUE)).booleanValue())
          {
            bh.beI();
            com.tencent.mm.model.c.aHp().i(327744, Boolean.FALSE);
            AppPanel.this.bfU();
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(12) });
          AppPanel.v(AppPanel.this).eRI();
          AppMethodBeat.o(277930);
          return;
          if (AppPanel.t(AppPanel.this))
          {
            AppPanel.u(AppPanel.this);
            AppMethodBeat.o(277930);
            return;
          }
          paramAnonymousg = ((com.tencent.mm.plugin.gamelife.a.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.gamelife.a.d.class)).aKH(AppPanel.i(AppPanel.this).getTalkerUserName());
          if (!TextUtils.isEmpty(paramAnonymousg))
          {
            AppPanel.a(AppPanel.this, paramAnonymousg);
            AppMethodBeat.o(277930);
            return;
          }
          if (!AppPanel.this.RhB.Ria.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(277930);
            return;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(1) });
          AppPanel.a(AppPanel.this, false);
          AppMethodBeat.o(277930);
          return;
          if (!AppPanel.this.RhB.Rid.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(277930);
            return;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(8) });
          bh.beI();
          com.tencent.mm.model.c.aHp().i(54, Boolean.FALSE);
          if (AppPanel.v(AppPanel.this) != null)
          {
            paramAnonymousg = new yx();
            paramAnonymousg.fYg.fYi = true;
            EventCenter.instance.publish(paramAnonymousg);
            paramAnonymousg = paramAnonymousg.fYh.fYk;
            if (!Util.isNullOrNil(paramAnonymousg))
            {
              Log.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramAnonymousg)));
              com.tencent.mm.ui.base.h.c(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.eTP), "", AppPanel.j(AppPanel.this).getString(R.l.app_ok), AppPanel.j(AppPanel.this).getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(283449);
                  yx localyx = new yx();
                  localyx.fYg.fYj = true;
                  EventCenter.instance.publish(localyx);
                  AppPanel.v(AppPanel.this).eRB();
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(283449);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(270660);
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(270660);
                }
              });
              AppMethodBeat.o(277930);
              return;
            }
            AppPanel.v(AppPanel.this).eRB();
            AppMethodBeat.o(277930);
            return;
            if (!AppPanel.this.RhB.Rij.value)
            {
              Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
              AppMethodBeat.o(277930);
              return;
            }
            com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(7) });
            bh.beI();
            com.tencent.mm.model.c.aHp().i(62, Boolean.FALSE);
            paramAnonymousg = new yx();
            paramAnonymousg.fYg.fYi = true;
            EventCenter.instance.publish(paramAnonymousg);
            paramAnonymousg = paramAnonymousg.fYh.fYk;
            if (!Util.isNullOrNil(paramAnonymousg))
            {
              Log.v("MicroMsg.AppPanel", "Talkroom is on: ".concat(String.valueOf(paramAnonymousg)));
              com.tencent.mm.ui.base.h.c(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.eTP), "", AppPanel.j(AppPanel.this).getString(R.l.app_ok), AppPanel.j(AppPanel.this).getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(271659);
                  yx localyx = new yx();
                  localyx.fYg.fYj = true;
                  EventCenter.instance.publish(localyx);
                  AppPanel.v(AppPanel.this).eRC();
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(271659);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(219906);
                  paramAnonymous2DialogInterface.dismiss();
                  AppMethodBeat.o(219906);
                }
              });
              AppMethodBeat.o(277930);
              return;
            }
            AppPanel.v(AppPanel.this).eRC();
            AppMethodBeat.o(277930);
            return;
            if (AppPanel.v(AppPanel.this) != null)
            {
              com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(6) });
              bh.beI();
              com.tencent.mm.model.c.aHp().i(67, Boolean.FALSE);
              AppPanel.v(AppPanel.this).eRD();
              AppMethodBeat.o(277930);
              return;
              if (AppPanel.t(AppPanel.this))
              {
                AppPanel.u(AppPanel.this);
                AppMethodBeat.o(277930);
                return;
              }
              if (!WeChatBrands.Business.Entries.SessionVoiceMsg.checkAvailable(AppPanel.this.getContext()))
              {
                AppMethodBeat.o(277930);
                return;
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(9) });
              bh.beI();
              com.tencent.mm.model.c.aHp().i(73, Boolean.FALSE);
              AppPanel.y(AppPanel.this).hla();
              AppMethodBeat.o(277930);
              return;
              if (!AppPanel.this.RhB.Ric.value)
              {
                Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                AppMethodBeat.o(277930);
                return;
              }
              com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(5) });
              if (AppPanel.v(AppPanel.this) != null)
              {
                AppPanel.v(AppPanel.this).eRH();
                AppMethodBeat.o(277930);
                return;
                if (!AppPanel.this.RhB.Rip.value)
                {
                  Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                  AppMethodBeat.o(277930);
                  return;
                }
                if (AppPanel.v(AppPanel.this) != null) {
                  AppPanel.v(AppPanel.this).eRJ();
                }
                com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(15) });
                bh.beI();
                bool1 = ((Boolean)com.tencent.mm.model.c.aHp().b(208899, Boolean.FALSE)).booleanValue();
                bh.beI();
                boolean bool2 = ((Boolean)com.tencent.mm.model.c.aHp().b(208913, Boolean.FALSE)).booleanValue();
                if (bool1)
                {
                  com.tencent.mm.plugin.report.service.h.IzE.a(11594, new Object[] { Integer.valueOf(3) });
                  AppMethodBeat.o(277930);
                  return;
                }
                if (bool2)
                {
                  com.tencent.mm.plugin.report.service.h.IzE.a(11594, new Object[] { Integer.valueOf(4) });
                  AppMethodBeat.o(277930);
                  return;
                  if (AppPanel.v(AppPanel.this) != null)
                  {
                    AppPanel.v(AppPanel.this).eRL();
                    AppMethodBeat.o(277930);
                    return;
                    if (!AppPanel.this.RhB.Rit.value)
                    {
                      Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                      AppMethodBeat.o(277930);
                      return;
                    }
                    AppPanel.v(AppPanel.this).eRM();
                    AppMethodBeat.o(277930);
                    return;
                    if (!AppPanel.this.RhB.Riz.value)
                    {
                      Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                      AppMethodBeat.o(277930);
                      return;
                    }
                    AppPanel.v(AppPanel.this).eRN();
                    com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(21) });
                    AppMethodBeat.o(277930);
                    return;
                    if (AppPanel.v(AppPanel.this) != null)
                    {
                      if (paramAnonymousg == null)
                      {
                        localObject = (com.tencent.mm.pluginsdk.model.app.g)AppPanel.w(AppPanel.this).get(com.tencent.mm.pluginsdk.model.app.g.QWh);
                        paramAnonymousg = (com.tencent.mm.pluginsdk.model.app.g)localObject;
                        if (localObject == null)
                        {
                          Log.i("MicroMsg.AppPanel", "empty info");
                          AppMethodBeat.o(277930);
                          return;
                        }
                      }
                      if ((paramAnonymousg.hhs()) || (paramAnonymousg.hhu()))
                      {
                        if (AppPanel.x(AppPanel.this) == null) {
                          AppPanel.a(AppPanel.this, AppPanel.j(AppPanel.this).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0));
                        }
                        if (AppPanel.x(AppPanel.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, true)) {
                          AppPanel.x(AppPanel.this).edit().putBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramAnonymousg.field_appId, false).commit();
                        }
                      }
                      AppPanel.v(AppPanel.this).eRO();
                      AppMethodBeat.o(277930);
                      return;
                      if (!AppPanel.this.RhB.Riv.value)
                      {
                        Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                        AppMethodBeat.o(277930);
                        return;
                      }
                      com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(17) });
                      if (AppPanel.v(AppPanel.this) != null)
                      {
                        AppPanel.v(AppPanel.this).eRP();
                        AppMethodBeat.o(277930);
                        return;
                        if (!WeChatBrands.Business.Entries.SessionGroupTools.checkAvailable(AppPanel.this.getContext()))
                        {
                          AppMethodBeat.o(277930);
                          return;
                        }
                        if (!AppPanel.this.RhB.Riw.value)
                        {
                          Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                          AppMethodBeat.o(277930);
                          return;
                        }
                        if (AppPanel.v(AppPanel.this) != null)
                        {
                          AppPanel.v(AppPanel.this).eRR();
                          AppMethodBeat.o(277930);
                          return;
                          if (!WeChatBrands.Business.Entries.SessionGroupSolitaire.checkAvailable(AppPanel.this.getContext()))
                          {
                            AppMethodBeat.o(277930);
                            return;
                          }
                          if (!AppPanel.this.RhB.Rix.value)
                          {
                            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                            AppMethodBeat.o(277930);
                            return;
                          }
                          com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(19) });
                          if (AppPanel.v(AppPanel.this) != null)
                          {
                            AppPanel.v(AppPanel.this).eRS();
                            AppMethodBeat.o(277930);
                            return;
                            if (!WeChatBrands.Business.Entries.SessionGroupLive.checkAvailable(AppPanel.this.getContext()))
                            {
                              AppMethodBeat.o(277930);
                              return;
                            }
                            if (!AppPanel.this.RhB.Riy.value)
                            {
                              Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
                              AppMethodBeat.o(277930);
                              return;
                            }
                            com.tencent.mm.plugin.report.service.h.IzE.a(10923, new Object[] { Integer.valueOf(20) });
                            if (AppPanel.v(AppPanel.this) != null)
                            {
                              AppPanel.v(AppPanel.this).eRQ();
                              com.tencent.mm.live.d.a.aPR();
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
      
      public final int aqt(int paramAnonymousInt)
      {
        AppMethodBeat.i(277921);
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
                AppMethodBeat.o(277921);
                return i;
              }
              k = j + 1;
            }
            i += 1;
          }
        }
        if ((paramAnonymousInt >= AppPanel.f(AppPanel.this)) && (paramAnonymousInt < AppPanel.s(AppPanel.this)))
        {
          AppMethodBeat.o(277921);
          return -2147483648;
        }
        AppMethodBeat.o(277921);
        return 2147483647;
      }
      
      public final void aqu(int paramAnonymousInt)
      {
        AppMethodBeat.i(277922);
        if (paramAnonymousInt == 0)
        {
          if (!AppPanel.this.RhB.Ria.value)
          {
            Toast.makeText(AppPanel.j(AppPanel.this), AppPanel.j(AppPanel.this).getString(R.l.chatting_msg_type_not_support), 0).show();
            AppMethodBeat.o(277922);
            return;
          }
          if (AppPanel.t(AppPanel.this))
          {
            AppPanel.u(AppPanel.this);
            AppMethodBeat.o(277922);
            return;
          }
          AppPanel.a(AppPanel.this, true);
          AppMethodBeat.o(277922);
          return;
        }
        AppMethodBeat.o(277922);
      }
    };
    this.RhT = true;
    this.RhU = -1;
    this.context = paramContext;
    AppMethodBeat.o(31459);
  }
  
  private int aqv(int paramInt)
  {
    int i = paramInt / this.Rhf;
    if (paramInt % this.Rhf > 0) {}
    for (paramInt = i;; paramInt = i - 1)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      return i;
    }
  }
  
  private void brs(String paramString)
  {
    AppMethodBeat.i(265022);
    Log.i("MicroMsg.AppPanel", "showForbiddenDialog: %s", new Object[] { paramString });
    f.a locala = new f.a(MMApplicationContext.getContext());
    locala.bBl(paramString).HL(true);
    locala.ayp(c.g.welcome_i_know).b(new f.c()
    {
      public final void g(boolean paramAnonymousBoolean, String paramAnonymousString) {}
    }).b(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
    }).show();
    AppMethodBeat.o(265022);
  }
  
  private void dlN()
  {
    AppMethodBeat.i(265020);
    com.tencent.e.h.ZvG.bDh("AppPanel-loadinfo");
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(292230);
        AppPanel.g(AppPanel.this).clear();
        for (;;)
        {
          try
          {
            String str = com.tencent.mm.n.h.axc().getValue("ShowAPPSuggestion");
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
            AppPanel.jl(AppPanel.g(AppPanel.this));
          }
          AppPanel.b(AppPanel.this, AppPanel.g(AppPanel.this));
          if (AppPanel.this.RhB != null)
          {
            AppPanel.this.RhB.Ef(AppPanel.m(AppPanel.this));
            AppPanel.this.RhB.Eg(AppPanel.n(AppPanel.this));
            AppPanel.this.RhB.Ej(AppPanel.o(AppPanel.this));
            AppPanel.this.RhB.Ek(AppPanel.p(AppPanel.this));
          }
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(267037);
              if (AppPanel.h(AppPanel.this) == -1) {}
              for (int i = AppPanel.q(AppPanel.this).getCurScreen();; i = -1)
              {
                AppPanel.d(AppPanel.this);
                if (i != -1)
                {
                  AppPanel.q(AppPanel.this).setToScreen(i);
                  AppPanel.e(AppPanel.this).setSelectedDot(i);
                }
                AppMethodBeat.o(267037);
                return;
              }
            }
          });
          AppMethodBeat.o(292230);
          return;
          Log.i("MicroMsg.AppPanel", "jacks show App Suggestion");
          AppPanel.a(AppPanel.this, com.tencent.mm.pluginsdk.model.app.h.a(AppPanel.j(AppPanel.this), true, AppPanel.k(AppPanel.this)));
        }
      }
    }, "AppPanel-loadinfo");
    AppMethodBeat.o(265020);
  }
  
  private int getPortHeightPX()
  {
    AppMethodBeat.i(31485);
    if (this.RhU > 0)
    {
      i = this.RhU;
      AppMethodBeat.o(31485);
      return i;
    }
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, ITN);
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
  
  private void hkU()
  {
    AppMethodBeat.i(31477);
    Log.d("MicroMsg.AppPanel", "AppPanel initFlipper");
    this.RhQ = -1;
    this.IUf.removeAllViews();
    this.IUf.setOnMeasureListener(new MMFlipper.b()
    {
      public final void jl(int paramAnonymousInt1, int paramAnonymousInt2)
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
    this.IUf.setOnFlipperViewShowedListener(new MMFlipper.a()
    {
      public final void aqx(int paramAnonymousInt)
      {
        AppMethodBeat.i(278159);
        Log.i("MicroMsg.AppPanel", "viewpage reshow %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        int i = AppPanel.this.aqw(14);
        if ((paramAnonymousInt == i) && (AppPanel.this.RhB.Riy.value)) {
          e.tX(i + 1);
        }
        AppMethodBeat.o(278159);
      }
    });
    this.IUf.setOnScreenChangedListener(new MMFlipper.c()
    {
      public final void E(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(286447);
        AppPanel.e(AppPanel.this).setSelectedDot(paramAnonymousInt2);
        Object localObject2;
        if ((AppPanel.this.getVisibility() == 0) && (paramAnonymousInt1 != -1) && (paramAnonymousInt1 != paramAnonymousInt2) && (paramAnonymousBoolean))
        {
          if (AppPanel.this.RhB.Rih.value) {}
          for (int i = AppPanel.f(AppPanel.this) + AppPanel.g(AppPanel.this).size();; i = AppPanel.f(AppPanel.this))
          {
            localObject1 = new jc();
            ((jc)localObject1).gef = 1L;
            ((jc)localObject1).gKK = 0L;
            localObject2 = new StringBuilder();
            int j = 0;
            while (j < AppPanel.this.getAppPanelUnCertainEnterArrayList().size())
            {
              AppPanel localAppPanel = AppPanel.this;
              if (paramAnonymousInt1 == AppPanel.c(localAppPanel, AppPanel.h(localAppPanel) + i + 1)) {
                ((StringBuilder)localObject2).append(((a.a)AppPanel.this.getAppPanelUnCertainEnterArrayList().get(j)).RiB).append("|");
              }
              j += 1;
            }
          }
          ((jc)localObject1).Aj(((StringBuilder)localObject2).toString());
          ((jc)localObject1).bpa();
          paramAnonymousInt1 = AppPanel.this.aqw(13);
          if ((paramAnonymousInt1 != -1) && (paramAnonymousInt1 == AppPanel.this.getCurScreen())) {
            if (AppPanel.i(AppPanel.this) != null) {
              break label364;
            }
          }
        }
        label364:
        for (Object localObject1 = "";; localObject1 = AppPanel.i(AppPanel.this).getTalkerUserName())
        {
          localObject2 = new jd();
          ((jd)localObject2).Ak((String)localObject1);
          ((jd)localObject2).gKK = 0L;
          ((jd)localObject2).Al("19");
          ((jd)localObject2).gKN = (paramAnonymousInt1 + 1);
          ((jd)localObject2).bpa();
          Log.i("MicroMsg.AppPanel", "scroll to show page %s", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          paramAnonymousInt1 = AppPanel.this.aqw(14);
          if ((paramAnonymousInt2 == paramAnonymousInt1) && (AppPanel.this.RhB.Riy.value)) {
            e.tX(paramAnonymousInt1 + 1);
          }
          AppMethodBeat.o(286447);
          return;
        }
      }
    });
    hkY();
    AppMethodBeat.o(31477);
  }
  
  private void hkV()
  {
    AppMethodBeat.i(163206);
    if (this.RhA == -1)
    {
      AppMethodBeat.o(163206);
      return;
    }
    if (this.RhB.Rih.value) {}
    jc localjc;
    StringBuilder localStringBuilder;
    for (int i = this.Rhi + this.mxJ.size();; i = this.Rhi)
    {
      this.Rhz = aqv(this.RhA + i + 1);
      this.IUf.setToScreen(this.Rhz);
      this.RhA = -1;
      localjc = new jc();
      localjc.gef = 1L;
      localjc.gKK = 1L;
      localStringBuilder = new StringBuilder();
      int j = 0;
      while (j < getAppPanelUnCertainEnterArrayList().size())
      {
        if (this.Rhz == aqv(this.RhA + i + 1)) {
          localStringBuilder.append(((a.a)getAppPanelUnCertainEnterArrayList().get(j)).RiB).append("|");
        }
        j += 1;
      }
    }
    localjc.Aj(localStringBuilder.toString());
    localjc.bpa();
    AppMethodBeat.o(163206);
  }
  
  private void hkW()
  {
    AppMethodBeat.i(31482);
    Log.i("MicroMsg.AppPanel", "[dealOrientationChange]");
    this.IUc = false;
    this.IUf.setToScreen(0);
    hkU();
    requestLayout();
    AppMethodBeat.o(31482);
  }
  
  private void hkY()
  {
    AppMethodBeat.i(31484);
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    if (this.RhT)
    {
      if (getScreenOrientation() != 2) {
        break label79;
      }
      Log.d("MicroMsg.AppPanel", "initFlipper, landscape");
      localView = findViewById(R.h.dre);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, ITO);
      localView.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      this.RhT = false;
      AppMethodBeat.o(31484);
      return;
      label79:
      Log.d("MicroMsg.AppPanel", "initFlipper, portrait: %d", new Object[] { Integer.valueOf(ITN) });
      localView = findViewById(R.h.dre);
      localLayoutParams = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams.height = getPortHeightPX();
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public final void Eb(boolean paramBoolean)
  {
    AppMethodBeat.i(31466);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.RhB.Rid.value = paramBoolean;
      hkT();
      Log.d("MicroMsg.AppPanel", "enable " + paramBoolean + " isVoipPluginEnable " + this.RhB.Rie.value);
      AppMethodBeat.o(31466);
      return;
    }
  }
  
  public final void Ec(boolean paramBoolean)
  {
    AppMethodBeat.i(31467);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.RhB.Rij.value = paramBoolean;
      hkT();
      Log.d("MicroMsg.AppPanel", "enable " + this.RhB.Rik.value + " isVoipAudioEnable " + paramBoolean);
      AppMethodBeat.o(31467);
      return;
    }
  }
  
  public final void Ed(boolean paramBoolean)
  {
    AppMethodBeat.i(31468);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.RhB.Ris.value = paramBoolean;
      hkT();
      Log.d("MicroMsg.AppPanel", "enable " + this.RhB.Ris.value + " isMultiTalkEnable " + paramBoolean);
      AppMethodBeat.o(31468);
      return;
    }
  }
  
  public final void Ee(boolean paramBoolean)
  {
    AppMethodBeat.i(31469);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.RhB.Ril.value = paramBoolean;
      hkT();
      AppMethodBeat.o(31469);
      return;
    }
  }
  
  public final int aqw(int paramInt)
  {
    int m = this.Rht.length;
    int j = 0;
    int i = 0;
    int k;
    if (j < m)
    {
      k = i;
      if (this.Rht[j] != 0) {
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
    paramInt = i / this.Rhf;
    if (i % this.Rhf > 0) {}
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
  
  public final void bfU()
  {
    AppMethodBeat.i(31478);
    Log.i("MicroMsg.AppPanel", "app panel refleshed: %s", new Object[] { Integer.valueOf(this.RhE) });
    dlN();
    AppMethodBeat.o(31478);
  }
  
  public ArrayList<a.a> getAppPanelUnCertainEnterArrayList()
  {
    AppMethodBeat.i(163205);
    ArrayList localArrayList = this.RhB.getAppPanelUnCertainEnterArrayList();
    AppMethodBeat.o(163205);
    return localArrayList;
  }
  
  public int getCurScreen()
  {
    AppMethodBeat.i(265021);
    if (this.IUf != null)
    {
      int i = this.IUf.getCurScreen();
      AppMethodBeat.o(265021);
      return i;
    }
    AppMethodBeat.o(265021);
    return -1;
  }
  
  public int getPageMaxRowCount()
  {
    if (this.Rhy == 0)
    {
      int i = (this.BQJ + 3) / 4;
      if (i > 2) {
        return 2;
      }
      return i;
    }
    return this.Rhy;
  }
  
  public final void hkI()
  {
    AppMethodBeat.i(31463);
    this.RhB.hlb();
    this.RhJ = false;
    this.RhK = false;
    this.RhL = false;
    this.RhM = false;
    hkJ();
    this.RhB.Ef(this.RhF);
    this.RhB.Eg(this.RhG);
    this.RhB.Ej(this.RhH);
    this.RhB.Ek(this.RhI);
    hkT();
    AppMethodBeat.o(31463);
  }
  
  public final void hkJ()
  {
    AppMethodBeat.i(31464);
    com.tencent.mm.n.h.axd();
    if (com.tencent.mm.n.d.awQ() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      this.RhB.hlc();
      this.RhB.Eh(bool);
      bool = com.tencent.mm.by.c.blP("location");
      this.RhB.Ei(bool);
      this.RhB.hld();
      AppMethodBeat.o(31464);
      return;
    }
  }
  
  public final void hkK()
  {
    AppMethodBeat.i(31465);
    this.RhB.Rib.value = false;
    hkT();
    AppMethodBeat.o(31465);
  }
  
  public final void hkL()
  {
    AppMethodBeat.i(31470);
    this.RhB.Rii.value = false;
    hkT();
    Log.d("MicroMsg.AppPanel", "disableTalkroom enable false");
    AppMethodBeat.o(31470);
  }
  
  public final void hkM()
  {
    AppMethodBeat.i(31471);
    this.RhB.Rin.value = false;
    hkT();
    AppMethodBeat.o(31471);
  }
  
  public final void hkN()
  {
    AppMethodBeat.i(31472);
    this.RhB.Rih.value = false;
    hkT();
    AppMethodBeat.o(31472);
  }
  
  public final void hkO()
  {
    AppMethodBeat.i(31473);
    this.RhB.Rip.value = false;
    hkT();
    AppMethodBeat.o(31473);
  }
  
  public final void hkP()
  {
    AppMethodBeat.i(31474);
    this.RhB.Riv.value = false;
    hkT();
    AppMethodBeat.o(31474);
  }
  
  public final void hkQ()
  {
    AppMethodBeat.i(185751);
    this.RhB.Riw.value = false;
    hkT();
    AppMethodBeat.o(185751);
  }
  
  public final void hkR()
  {
    AppMethodBeat.i(265018);
    this.RhB.Rix.value = false;
    hkT();
    AppMethodBeat.o(265018);
  }
  
  public final void hkS()
  {
    AppMethodBeat.i(265019);
    this.RhB.El(false);
    hkT();
    AppMethodBeat.o(265019);
  }
  
  public final void hkT()
  {
    AppMethodBeat.i(31475);
    int j = this.Rht.length;
    int i = 0;
    while (i < j)
    {
      this.Rht[i] = true;
      i += 1;
    }
    if (!this.RhB.Ria.value) {
      this.Rht[0] = false;
    }
    for (j = 1;; j = 0)
    {
      i = j;
      if (!this.RhB.RhZ.value)
      {
        this.Rht[1] = false;
        i = j + 1;
      }
      j = i;
      if (!this.RhB.Riv.value)
      {
        this.Rht[19] = false;
        j = i + 1;
      }
      i = j;
      if (!this.RhB.Riw.value)
      {
        this.Rht[12] = false;
        i = j + 1;
      }
      j = i;
      if (!this.RhB.Rix.value)
      {
        this.Rht[13] = false;
        j = i + 1;
      }
      i = j;
      if (!this.RhB.Riy.value)
      {
        this.Rht[14] = false;
        i = j + 1;
      }
      if (this.RhB.Rin.value)
      {
        j = i;
        if (this.RhB.Rio.value) {}
      }
      else
      {
        this.Rht[6] = false;
        j = i + 1;
      }
      i = j;
      if (!this.RhB.Rif.value)
      {
        this.Rht[17] = false;
        i = j + 1;
      }
      j = i;
      if (!this.RhB.Rig.value)
      {
        Log.i("MicroMsg.AppPanel", "disable remittance");
        this.Rht[8] = false;
        j = i + 1;
      }
      i = j;
      if (!this.RhB.Rib.value)
      {
        this.Rht[15] = false;
        i = j + 1;
      }
      j = i;
      if (!this.RhB.Rip.value)
      {
        this.Rht[16] = false;
        j = i + 1;
      }
      i = j;
      if (!this.RhB.Ris.value)
      {
        this.Rht[3] = false;
        i = j + 1;
      }
      j = i;
      if (!this.RhB.Ric.value)
      {
        this.Rht[11] = false;
        j = i + 1;
      }
      i = j;
      if (!this.RhB.Rii.value)
      {
        this.Rht[5] = false;
        i = j + 1;
      }
      if (this.RhB.Rik.value)
      {
        j = i;
        if (this.RhB.Rij.value) {}
      }
      else
      {
        this.Rht[4] = false;
        j = i + 1;
      }
      if (this.RhB.Rie.value)
      {
        i = j;
        if (this.RhB.Rid.value) {}
      }
      else
      {
        this.Rht[2] = false;
        i = j + 1;
      }
      if (this.RhB.Rim.value)
      {
        j = i;
        if (this.RhB.Ril.value) {}
      }
      else
      {
        this.Rht[10] = false;
        j = i + 1;
      }
      i = j;
      if (!this.RhB.Rir.value)
      {
        Log.i("MicroMsg.AppPanel", "disable lucky money");
        this.Rht[7] = false;
        i = j + 1;
      }
      j = i;
      if (!this.RhB.Rit.value)
      {
        this.Rht[18] = false;
        j = i + 1;
      }
      i = j;
      if (!this.RhB.Riz.value)
      {
        this.Rht[20] = false;
        i = j + 1;
      }
      this.Rht[9] = false;
      this.Rhi = (21 - (i + 1));
      AppMethodBeat.o(31475);
      return;
    }
  }
  
  public final void hkX()
  {
    AppMethodBeat.i(31483);
    Log.i("MicroMsg.AppPanel", "[forceRefreshSize]");
    hkY();
    hkW();
    AppMethodBeat.o(31483);
  }
  
  public final void init(int paramInt)
  {
    AppMethodBeat.i(31460);
    Log.i("MicroMsg.AppPanel", "init: %s", new Object[] { Integer.valueOf(paramInt) });
    this.RhB = new a();
    this.RhE = paramInt;
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    if (localDisplay.getWidth() < localDisplay.getHeight()) {
      this.RhC = localDisplay.getWidth();
    }
    for (this.RhD = localDisplay.getHeight();; this.RhD = localDisplay.getWidth())
    {
      View.inflate(this.context, R.i.ebB, this);
      this.IUg = ((MMDotView)findViewById(R.h.drf));
      this.IUf = ((MMFlipper)findViewById(R.h.drg));
      hkU();
      hkI();
      dlN();
      AppMethodBeat.o(31460);
      return;
      this.RhC = localDisplay.getHeight();
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
    for (this.RhO = true;; this.RhO = false)
    {
      setNeedRefreshHeight(true);
      hkW();
      AppMethodBeat.o(31481);
      return;
    }
  }
  
  public void setAppPanelListener(a parama)
  {
    this.Rhu = parama;
  }
  
  public void setAppPanelUnCertainEnterArrayList(ArrayList<a.a> paramArrayList)
  {
    this.RhB.RiA = paramArrayList;
  }
  
  public void setChattingContext(ChatFooter.b paramb)
  {
    this.Rhw = paramb;
  }
  
  public void setNeedRefreshHeight(boolean paramBoolean)
  {
    this.RhT = paramBoolean;
  }
  
  public void setOnSwitchPanelListener(AppPanel.b paramb)
  {
    this.Rhv = paramb;
  }
  
  public void setPortHeighDP(int paramInt)
  {
    if (ITN != paramInt)
    {
      ITN = paramInt;
      this.RhT = true;
    }
  }
  
  public void setPortHeighPx(int paramInt)
  {
    if (this.RhU != paramInt)
    {
      this.RhU = paramInt;
      this.RhT = true;
    }
  }
  
  public void setServiceShowFlag(int paramInt)
  {
    AppMethodBeat.i(31461);
    Log.i("MicroMsg.AppPanel", "setServiceShowFlag: %s", new Object[] { Integer.valueOf(paramInt) });
    this.RhE = paramInt;
    AppMethodBeat.o(31461);
  }
  
  public void setUncertainEnterLocation(int paramInt)
  {
    this.RhA = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void Wv(int paramInt);
    
    public abstract void Ww(int paramInt);
    
    public abstract void d(com.tencent.mm.pluginsdk.model.app.g paramg);
    
    public abstract void eRB();
    
    public abstract void eRC();
    
    public abstract void eRD();
    
    public abstract void eRE();
    
    public abstract void eRF();
    
    public abstract void eRG();
    
    public abstract void eRH();
    
    public abstract void eRI();
    
    public abstract void eRJ();
    
    public abstract void eRK();
    
    public abstract void eRL();
    
    public abstract void eRM();
    
    public abstract void eRN();
    
    public abstract void eRO();
    
    public abstract void eRP();
    
    public abstract void eRQ();
    
    public abstract void eRR();
    
    public abstract void eRS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel
 * JD-Core Version:    0.7.0.1
 */