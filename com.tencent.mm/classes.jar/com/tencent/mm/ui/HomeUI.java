package com.tencent.mm.ui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.util.Base64;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.abt;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.finder.extension.reddot.FinderRedDotManagerOnTab.mainUiIndexChangeListener.1;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.protocal.protobuf.fng;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.conversation.ConversationListView;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class HomeUI
  implements com.tencent.mm.plugin.taskbar.api.a, LauncherUI.b, LauncherUI.c, LauncherUI.e
{
  private static boolean adAH = true;
  static final int adAJ = R.h.menu_search;
  static final int adAK = R.h.menu_add;
  public static Boolean adAr = Boolean.FALSE;
  public static Boolean adAs = Boolean.FALSE;
  MMFragmentActivity EzS;
  private long HRo;
  private TextView IWX;
  View Inv;
  private View MHV;
  IListener Pme;
  private boolean SSt;
  private final long WZx;
  LauncherUI.a adAA;
  j adAB;
  MainTabUI adAC;
  int adAD;
  int adAE;
  private boolean adAF;
  boolean adAG;
  View.OnLayoutChangeListener adAI;
  b adAL;
  View adAM;
  ImageView adAN;
  private View adAO;
  ImageView adAP;
  View adAQ;
  MenuItem adAR;
  MenuItem adAS;
  private MenuItem adAT;
  MenuItem adAU;
  Menu adAV;
  private boolean adAW;
  IListener adAX;
  Runnable adAY;
  private int adAZ;
  private final long adAi;
  private final long adAj;
  public boolean adAk;
  boolean adAl;
  public boolean adAm;
  private WeImageView adAn;
  private boolean adAo;
  private String adAp;
  al adAq;
  private final long adAt;
  private final long adAu;
  private boolean adAv;
  private int adAw;
  private int adAx;
  private int adAy;
  HomeUI.a adAz;
  private long adBa;
  private LinkedList<Runnable> adBb;
  t adBc;
  private float adBd;
  private boolean adBe;
  private TextView aduW;
  boolean advd;
  View advt;
  private int clickCount;
  View contentView;
  MessageQueue.IdleHandler fgm;
  private String hUQ;
  ActionBar mActionBar;
  private boolean pUC;
  LayoutInflater pUI;
  private String pXq;
  private String pXr;
  private final HashMap<String, Object> values;
  
  public HomeUI()
  {
    AppMethodBeat.i(33232);
    this.adAi = 604800000L;
    this.adAj = 86400000L;
    this.pUC = true;
    this.adAk = false;
    this.hUQ = null;
    this.adAm = false;
    this.advd = false;
    this.adAo = false;
    this.adAt = 432000000L;
    this.adAu = 604800000L;
    this.adAv = true;
    this.adAw = 0;
    this.adAx = 0;
    this.adAy = 0;
    this.adAz = HomeUI.a.adBl;
    this.adAC = new MainTabUI();
    this.adAD = 0;
    this.adAE = 0;
    this.adAF = false;
    this.adAG = true;
    this.adAI = new HomeUI.41(this);
    this.SSt = LocaleUtil.isChineseAppLang();
    this.adAW = true;
    this.clickCount = 0;
    this.HRo = 0L;
    this.values = new HashMap();
    this.Pme = new HomeUI.24(this, com.tencent.mm.app.f.hfK);
    this.adAX = new HomeUI.25(this, com.tencent.mm.app.f.hfK);
    this.fgm = new HomeUI.17(this);
    this.adAY = new HomeUI.18(this);
    this.adAZ = 0;
    this.WZx = 300L;
    this.adBa = SystemClock.elapsedRealtime();
    this.adBb = new LinkedList();
    this.adBc = new t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, g.a paramAnonymousa)
      {
        AppMethodBeat.i(249236);
        if ((Util.nullAsNil(paramAnonymousString).equals("showprivacypolicy")) && (paramAnonymousMap != null))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.device_id");
          HomeUI.a(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_content"));
          HomeUI.b(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_ok"));
          HomeUI.c(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_cancel"));
          boolean bool1 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needbirthday"));
          boolean bool2 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needopenplatform"));
          boolean bool3 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needconfirm"));
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acWu, Boolean.valueOf(bool1));
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acWv, Boolean.valueOf(bool2));
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acWw, Boolean.valueOf(bool3));
          paramAnonymousMap = com.tencent.mm.bx.b.cX(q.aPg().getBytes());
          paramAnonymousMap.axn(16);
          paramAnonymousMap = Base64.encodeToString(paramAnonymousMap.toByteArray(), 2);
          Log.i("MicroMsg.LauncherUI.HomeUI", "deviceId:%s, localDeviceId:%s, doubleCheckContent:%s, doubleCheckOk:%s, doubleCheckCancel:%s, needBirthday:%s, needOpenPlatform:%s, needConfirm:%s", new Object[] { paramAnonymousString, paramAnonymousMap, HomeUI.F(HomeUI.this), HomeUI.H(HomeUI.this), HomeUI.G(HomeUI.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((Util.isNullOrNil(paramAnonymousString)) || (paramAnonymousString.equals(paramAnonymousMap)))
          {
            paramAnonymousString = com.tencent.mm.kernel.h.baE().ban().d(274436, "").toString();
            paramAnonymousMap = HomeUI.c(HomeUI.this);
            int j = R.l.license_read_url;
            paramAnonymousa = LocaleUtil.getApplicationLanguage();
            int i;
            if (bool2)
            {
              i = 1;
              paramAnonymousMap = paramAnonymousMap.getString(j, new Object[] { paramAnonymousa, paramAnonymousString, "login", Integer.valueOf(1), Integer.valueOf(i) });
              if (!com.tencent.mm.au.b.OE(paramAnonymousString)) {
                break label540;
              }
              Log.i("MicroMsg.LauncherUI.HomeUI", "eu true, needconfirm: %s", new Object[] { Boolean.valueOf(bool3) });
              if (bool3) {
                break label503;
              }
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("close_dialog_msg", HomeUI.F(HomeUI.this));
              paramAnonymousString.putString("close_dialog_cancel", HomeUI.G(HomeUI.this));
              paramAnonymousString.putString("close_dialog_ok", HomeUI.H(HomeUI.this));
              paramAnonymousString.putBoolean("close_dialog_ok_close", false);
              HomeUI.a(HomeUI.this, paramAnonymousMap, 22722, paramAnonymousString);
            }
            for (;;)
            {
              com.tencent.mm.ui.base.b.ng(HomeUI.c(HomeUI.this));
              AppMethodBeat.o(249236);
              return;
              i = 0;
              break;
              label503:
              HomeUI.a(HomeUI.this, paramAnonymousMap, 22722, HomeUI.c(HomeUI.this).getString(R.l.gdpr_warn_privacy_url, new Object[] { LocaleUtil.getApplicationLanguage() }));
              continue;
              label540:
              Log.i("MicroMsg.LauncherUI.HomeUI", "eu false");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("close_dialog_msg", HomeUI.c(HomeUI.this).getString(R.l.license_disagree_tip));
              paramAnonymousString.putString("close_dialog_cancel", HomeUI.c(HomeUI.this).getString(R.l.logout_menu_logout));
              paramAnonymousString.putString("close_dialog_ok", HomeUI.c(HomeUI.this).getString(R.l.license_read_again));
              paramAnonymousString.putBoolean("close_dialog_ok_close", false);
              HomeUI.a(HomeUI.this, paramAnonymousMap, 22722, paramAnonymousString);
            }
          }
          Log.i("MicroMsg.LauncherUI.HomeUI", "device id not match");
        }
        AppMethodBeat.o(249236);
      }
    };
    this.adBd = 0.0F;
    this.adBe = false;
    AppMethodBeat.o(33232);
  }
  
  private static void G(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(33263);
    if (paramView != null)
    {
      if (paramBoolean)
      {
        paramView.setClickable(true);
        AppMethodBeat.o(33263);
        return;
      }
      paramView.setClickable(false);
      paramView.setBackgroundResource(R.e.transparent);
    }
    AppMethodBeat.o(33263);
  }
  
  private void Lc(boolean paramBoolean)
  {
    AppMethodBeat.i(249489);
    if (((this.adAC.jkb() instanceof MainUI)) && (((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.multitask.d.class)).isMultiTaskMode()))
    {
      i = 1;
      if ((i == 0) || (((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.multitask.d.class)).isDataEmpty())) {
        break label174;
      }
    }
    label174:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (!paramBoolean)) {
        break label179;
      }
      localObject = (LinearLayout)this.mActionBar.getCustomView().findViewById(R.h.actionbar_up_indicator);
      if (localObject != null)
      {
        ((LinearLayout)localObject).setFocusable(true);
        ((LinearLayout)localObject).setClickable(true);
      }
      localObject = (ImageView)this.mActionBar.getCustomView().findViewById(R.h.actionbar_up_indicator_btn);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setAlpha(1.0F);
      this.mActionBar.getCustomView().setVisibility(0);
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.multitask.ui.uic.c)com.tencent.mm.ui.component.k.d(this.EzS).q(com.tencent.mm.plugin.multitask.ui.uic.c.class)).jr(true);
      AppMethodBeat.o(249489);
      return;
      i = 0;
      break;
    }
    label179:
    Object localObject = (LinearLayout)this.mActionBar.getCustomView().findViewById(R.h.actionbar_up_indicator);
    if (localObject != null)
    {
      ((LinearLayout)localObject).setFocusable(false);
      ((LinearLayout)localObject).setClickable(false);
    }
    ((ImageView)this.mActionBar.getCustomView().findViewById(R.h.actionbar_up_indicator_btn)).setVisibility(4);
    localObject = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.multitask.ui.uic.c)com.tencent.mm.ui.component.k.d(this.EzS).q(com.tencent.mm.plugin.multitask.ui.uic.c.class)).jr(false);
    AppMethodBeat.o(249489);
  }
  
  private void Le(boolean paramBoolean)
  {
    AppMethodBeat.i(33249);
    View localView;
    int j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.EzS.getWindow().getDecorView();
      j = localView.getSystemUiVisibility();
      if (!paramBoolean) {
        break label60;
      }
    }
    label60:
    for (int i = j & 0xFFFFDFFF;; i = j | 0x2000)
    {
      if (j != i) {
        localView.setSystemUiVisibility(i);
      }
      AppMethodBeat.o(33249);
      return;
    }
  }
  
  private void aAa(int paramInt)
  {
    AppMethodBeat.i(33248);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(33248);
      return;
    }
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.isMIUIV8())) {
      i = paramInt;
    }
    for (;;)
    {
      Object localObject = LauncherUI.getInstance();
      paramInt = i;
      if (localObject != null)
      {
        paramInt = i;
        if (((LauncherUI)localObject).adBG.getMainTabUI() != null) {
          if (!((LauncherUI)localObject).adBG.getMainTabUI().glK())
          {
            localObject = com.tencent.mm.ui.component.k.aeZF;
            paramInt = i;
            if (!((com.tencent.mm.plugin.multitask.ui.uic.c)com.tencent.mm.ui.component.k.d(this.EzS).q(com.tencent.mm.plugin.multitask.ui.uic.c.class)).gkZ()) {}
          }
          else
          {
            paramInt = this.EzS.getResources().getColor(R.e.transparent);
          }
        }
      }
      if (Math.abs(this.adAZ - paramInt) >= 50000) {}
      try
      {
        this.EzS.getWindow().setStatusBarColor(paramInt);
        this.adAZ = paramInt;
        AppMethodBeat.o(33248);
        return;
        i = paramInt;
        if (Build.VERSION.SDK_INT < 21) {
          continue;
        }
        i = bb.av(this.EzS.getResources().getColor(R.e.statusbar_fg_drak_color), paramInt);
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localNullPointerException, "updateStatusBar %s", new Object[] { Integer.valueOf(paramInt) });
        }
      }
    }
  }
  
  private void aMl()
  {
    AppMethodBeat.i(33233);
    if (!this.adAv)
    {
      AppMethodBeat.o(33233);
      return;
    }
    int i = this.adAC.jP;
    Object localObject1 = getString(R.l.app_name_separation);
    Object localObject2;
    if (i == 0)
    {
      localObject2 = localObject1;
      if (this.adAC.adGR.jkm() > 0)
      {
        localObject2 = localObject1;
        if (!this.SSt) {
          localObject2 = localObject1 + " ";
        }
        localObject2 = localObject2 + "(" + this.adAC.adGR.jkm() + ")";
      }
      localObject1 = new abt();
      ((abt)localObject1).ifk.ifl = 1;
      ((abt)localObject1).ifk.title = ((CharSequence)localObject2).toString();
      ((abt)localObject1).publish();
      localObject1 = localObject2;
    }
    label1053:
    for (;;)
    {
      boolean bool;
      if (i == 3)
      {
        aAa(this.EzS.getResources().getColor(R.e.transparent));
        if (!jiY())
        {
          if (!ac.hFS())
          {
            bool = false;
            label213:
            if ((!bool) && (!aw.isDarkMode())) {
              break label731;
            }
          }
        }
        else
        {
          Le(true);
          label228:
          ((e)com.tencent.mm.kernel.h.az(e.class)).checkPost();
          if (this.mActionBar != null)
          {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.EzS.getResources().getColor(R.e.transparent)));
            this.mActionBar.getCustomView().setVisibility(8);
          }
          if (this.Inv != null) {
            this.Inv.setBackgroundColor(this.EzS.getResources().getColor(R.e.transparent));
          }
          this.adAW = false;
          if ((jiL()) && (this.adAU != null) && (!this.adAU.isVisible())) {
            this.adAU.setVisible(true);
          }
          Log.i("MicroMsg.LauncherUI.HomeUI", "alvinluo updateSettingTitle");
          this.mActionBar.g(0.0F);
          this.mActionBar.bz();
          this.IWX = ((TextView)this.mActionBar.getCustomView().findViewById(16908308));
          this.adAn = ((WeImageView)this.mActionBar.getCustomView().findViewById(R.h.home_title_icon));
          if (this.adAn != null) {
            this.adAn.setVisibility(8);
          }
          if (this.IWX != null)
          {
            this.IWX.setText((CharSequence)localObject1);
            a.a.jlv().r(this.EzS, ((CharSequence)localObject1).toString());
            if (i != 0) {
              break label971;
            }
            ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).setTextWithStatus(this.IWX, com.tencent.mm.plugin.auth.a.a.cUx(), a.b.ThJ, a.c.ThP);
            label502:
            bool = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
            if ((this.adAn != null) && (bool) && (i == 0)) {
              this.adAn.setVisibility(0);
            }
            if (!jiL()) {
              break label995;
            }
            this.IWX.setVisibility(8);
            label556:
            if (a.jhB()) {
              break label1006;
            }
            float f = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), R.f.ActionBarTextSize);
            if (this.IWX.getTextSize() != f) {
              this.IWX.setTextSize(0, f);
            }
          }
        }
      }
      for (;;)
      {
        i = this.EzS.getResources().getColor(R.e.actionbar_title_light_color);
        if ((this.advd) && (this.IWX.getCurrentTextColor() != i)) {
          this.IWX.setTextColor(i);
        }
        aw.a(this.IWX.getPaint(), 0.8F);
        Lc(true);
        AppMethodBeat.o(33233);
        return;
        if (i == 1)
        {
          localObject1 = getString(R.l.gMU);
          break;
        }
        if (i == 2)
        {
          localObject1 = getString(R.l.gMS);
          break;
        }
        if (i != 3) {
          break label1053;
        }
        localObject1 = getString(R.l.gNo);
        break;
        bool = ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).hasStatus(com.tencent.mm.plugin.auth.a.a.cUx());
        break label213;
        label731:
        Le(false);
        break label228;
        aAa(this.EzS.getResources().getColor(R.e.normal_actionbar_color));
        Le(this.advd);
        localObject2 = this.mActionBar.getCustomView().getBackground();
        if ((localObject2 instanceof ColorDrawable)) {
          if (((ColorDrawable)localObject2).getColor() != this.EzS.getResources().getColor(R.e.normal_actionbar_color)) {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.EzS.getResources().getColor(R.e.normal_actionbar_color)));
          }
        }
        for (;;)
        {
          if (this.mActionBar.getCustomView().getVisibility() != 0) {
            this.mActionBar.getCustomView().setVisibility(0);
          }
          this.adAW = true;
          if ((jiM()) && (this.adAR != null) && (!this.adAR.isVisible())) {
            this.adAR.setVisible(true);
          }
          if ((!jiM()) || (this.adAS == null) || (this.adAS.isVisible())) {
            break;
          }
          this.adAS.setVisible(true);
          break;
          this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.EzS.getResources().getColor(R.e.normal_actionbar_color)));
        }
        label971:
        ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).clearTextStatus(this.IWX, com.tencent.mm.plugin.auth.a.a.cUx());
        break label502;
        label995:
        this.IWX.setVisibility(0);
        break label556;
        label1006:
        a.v(this.IWX, R.f.ActionBarTextSize);
        localObject1 = this.mActionBar.getCustomView().findViewById(R.h.text2);
        if ((localObject1 instanceof TextView)) {
          a.v((TextView)localObject1, R.f.ActionBarTextSize);
        }
      }
    }
  }
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(33236);
    if (this.MHV != null)
    {
      this.MHV.clearAnimation();
      this.MHV.setVisibility(8);
      if (paramBoolean1.booleanValue())
      {
        if (!paramBoolean2.booleanValue()) {
          break label89;
        }
        bh.bCz();
        com.tencent.mm.model.c.ban().B(340227, Boolean.TRUE);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(232L, 0L, 1L, false);
        adAr = Boolean.FALSE;
      }
    }
    for (;;)
    {
      this.MHV = null;
      AppMethodBeat.o(33236);
      return;
      label89:
      bh.bCz();
      com.tencent.mm.model.c.ban().B(340230, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(232L, 5L, 1L, false);
      adAs = Boolean.FALSE;
    }
  }
  
  private boolean jiL()
  {
    return (this.adAw == 3) && (this.adAx == 3);
  }
  
  private boolean jiM()
  {
    return (this.adAw == 2) && (this.adAx == 2);
  }
  
  private static boolean jiY()
  {
    AppMethodBeat.i(33260);
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(33260);
      return false;
    }
    if (((e)com.tencent.mm.kernel.h.az(e.class)).isStoryExist(com.tencent.mm.model.z.bAM()))
    {
      AppMethodBeat.o(33260);
      return true;
    }
    AppMethodBeat.o(33260);
    return false;
  }
  
  static boolean jja()
  {
    AppMethodBeat.i(33264);
    boolean bool = ((e)com.tencent.mm.kernel.h.az(e.class)).getStoryNewFeatureConfig().huS();
    AppMethodBeat.o(33264);
    return bool;
  }
  
  static boolean jjb()
  {
    AppMethodBeat.i(33265);
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.adfH, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(33265);
    return bool;
  }
  
  private void setActionBarColor(int paramInt)
  {
    AppMethodBeat.i(33256);
    if (this.mActionBar != null) {
      this.mActionBar.setBackgroundDrawable(new ColorDrawable(paramInt));
    }
    if (this.Inv != null) {
      this.Inv.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(33256);
  }
  
  public final void Fh(boolean paramBoolean)
  {
    AppMethodBeat.i(249723);
    Log.i("MicroMsg.LauncherUI.HomeUI", "alvinluo updateStatusBar show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Resources localResources = this.EzS.getResources();
    if (paramBoolean) {}
    for (int i = R.e.normal_actionbar_color;; i = R.e.transparent)
    {
      aAa(localResources.getColor(i));
      AppMethodBeat.o(249723);
      return;
    }
  }
  
  final void Lb(boolean paramBoolean)
  {
    AppMethodBeat.i(33238);
    if ((this.adAq == null) || (this.adAM == null) || (this.adAL == null))
    {
      AppMethodBeat.o(33238);
      return;
    }
    if (!bh.baz())
    {
      Log.w("MicroMsg.LauncherUI.HomeUI", "want update more menu new tips, but mmcore not ready");
      AppMethodBeat.o(33238);
      return;
    }
    this.adAq.adJh.Ls(paramBoolean);
    Object localObject = this.adAL;
    if (com.tencent.mm.plugin.newtips.a.g.a(((b)localObject).adBf.adAq.adJh.jaZ(), (com.tencent.mm.plugin.newtips.a.a)localObject))
    {
      localObject = new abt();
      ((abt)localObject).ifk.ifl = 2;
      ((abt)localObject).ifk.ifm = this.adAq.adJh.jaZ();
      ((abt)localObject).ifk.ifn = false;
      ((abt)localObject).publish();
      AppMethodBeat.o(33238);
      return;
    }
    if (((b)localObject).adBf.adAq.adJh.jaZ()) {
      ((b)localObject).adBf.adAO.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject, com.tencent.mm.plugin.newtips.a.k.MsK, ((b)localObject).adBf.adAq.adJh.jaZ());
      break;
      ((b)localObject).adBf.adAO.setVisibility(8);
    }
  }
  
  public final void Ld(boolean paramBoolean)
  {
    AppMethodBeat.i(33246);
    if (!paramBoolean) {
      initActionBar();
    }
    this.EzS.supportInvalidateOptionsMenu();
    if (com.tencent.mm.model.z.bBK().booleanValue())
    {
      if (bh.baz()) {
        break label59;
      }
      Log.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready");
    }
    for (;;)
    {
      this.adAC.jkf();
      AppMethodBeat.o(33246);
      return;
      label59:
      bh.bCz();
      Boolean localBoolean = Boolean.valueOf(Util.nullAsFalse((Boolean)com.tencent.mm.model.c.ban().d(340227, null)));
      if ((!localBoolean.booleanValue()) && (!com.tencent.mm.ui.contact.l.afdT.booleanValue())) {
        adAr = Boolean.TRUE;
      }
      long l1 = System.currentTimeMillis();
      bh.bCz();
      long l2 = Util.nullAs((Long)com.tencent.mm.model.c.ban().d(340240, null), 0L);
      bh.bCz();
      paramBoolean = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.ban().d(340230, null));
      bh.bCz();
      boolean bool1 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.ban().d(340228, null));
      bh.bCz();
      boolean bool2 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.ban().d(340229, null));
      if ((localBoolean.booleanValue()) && (Boolean.valueOf(bool1).booleanValue()) && (Boolean.valueOf(bool2).booleanValue()) && (!Boolean.valueOf(paramBoolean).booleanValue()) && (l1 - l2 >= 432000000L)) {
        adAs = Boolean.TRUE;
      }
    }
  }
  
  public final void Lf(boolean paramBoolean)
  {
    AppMethodBeat.i(33262);
    if ((this.adAU != null) && (this.adAU.getActionView() != null) && (this.EzS != null))
    {
      if (this.EzS.getResources().getConfiguration().orientation == 2)
      {
        this.adAU.setVisible(false);
        this.adAU.setEnabled(false);
        AppMethodBeat.o(33262);
        return;
      }
      this.adAU.setVisible(true);
      this.adAU.setEnabled(true);
      ImageView localImageView = (ImageView)this.adAU.getActionView().findViewById(R.h.icon);
      localImageView.setImageDrawable(this.EzS.getResources().getDrawable(R.k.icons_filled_camera));
      if ((paramBoolean) || (aw.isDarkMode())) {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      }
      while (this.adAG)
      {
        this.adAU.getActionView().findViewById(R.h.tips).setVisibility(0);
        AppMethodBeat.o(33262);
        return;
        localImageView.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
      }
      this.adAU.getActionView().findViewById(R.h.tips).setVisibility(8);
    }
    AppMethodBeat.o(33262);
  }
  
  public final void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33245);
    this.EzS.getWindow().getDecorView().getBottom();
    this.EzS.getSupportActionBar().getCustomView().getBottom();
    paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
    paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
    AppMethodBeat.o(33245);
  }
  
  public final void aW(Runnable paramRunnable)
  {
    AppMethodBeat.i(33251);
    this.adBb.remove(paramRunnable);
    AppMethodBeat.o(33251);
  }
  
  public final void g(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33257);
    MMFragment localMMFragment = getMainTabUI().jkb();
    if (localMMFragment != null)
    {
      if ((localMMFragment instanceof MoreTabUI))
      {
        setActionBarColor(this.EzS.getResources().getColor(R.e.transparent));
        AppMethodBeat.o(33257);
        return;
      }
      if (!(localMMFragment instanceof MainUI)) {
        setActionBarColor(this.EzS.getResources().getColor(R.e.normal_actionbar_color));
      }
      while (paramInt2 > 10)
      {
        G(this.advt, false);
        G(this.adAM, false);
        AppMethodBeat.o(33257);
        return;
        setActionBarColor(paramInt1);
      }
      G(this.advt, true);
      G(this.adAM, true);
    }
    AppMethodBeat.o(33257);
  }
  
  public MainTabUI getMainTabUI()
  {
    return this.adAC;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(33241);
    String str = this.EzS.getString(paramInt);
    AppMethodBeat.o(33241);
    return str;
  }
  
  public final void h(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33258);
    if ((paramInt1 != 0) && (this.IWX != null)) {
      this.IWX.setTextColor(paramInt1);
    }
    if (this.adAP != null)
    {
      if (this.adBe) {
        this.adAP.setAlpha(paramFloat);
      }
      this.adAP.setImageDrawable(bb.m(this.EzS, R.k.actionbar_icon_dark_search, paramInt2));
    }
    if (this.adAN != null)
    {
      if (this.adBe) {
        this.adAN.setAlpha(paramFloat);
      }
      this.adAN.setImageDrawable(bb.m(this.EzS, R.k.icons_outlined_add2, paramInt2));
    }
    AppMethodBeat.o(33258);
  }
  
  public final void hdx()
  {
    boolean bool1 = false;
    AppMethodBeat.i(249666);
    Object localObject = this.adAC;
    boolean bool2 = this.adAk;
    Log.v("MicroMsg.LauncherUI.MainTabUI", "doOnPause %d, mainTabHasCreate:%b", new Object[] { Integer.valueOf(((MainTabUI)localObject).jP), Boolean.valueOf(bool2) });
    if (bool2) {
      ((MainTabUI)localObject).jke();
    }
    localObject = ((MainTabUI)localObject).adGR;
    if (bh.baz())
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().remove(((ah)localObject).adHp);
      bh.bCz();
      com.tencent.mm.model.c.bzG().remove((MStorageEx.IOnStorageChange)localObject);
      com.tencent.mm.aa.c.aYo().b(((ah)localObject).adHo);
      ((ah)localObject).adHq.dead();
      ((ah)localObject).adyq.dead();
      ((ah)localObject).adyp.dead();
    }
    if (((ah)localObject).adHi != null) {
      ((ah)localObject).adHi.DWR.dead();
    }
    if (((ah)localObject).adHn != null)
    {
      ((ah)localObject).adHn.adHj = null;
      ((ah)localObject).adHn = null;
    }
    if (this.adAB != null)
    {
      localObject = this.adAB;
      if (((j)localObject).adzR != null)
      {
        bh.aZW().b(255, ((j)localObject).adzR);
        bh.aZW().b(384, ((j)localObject).adzR);
        ((j)localObject).adzR = null;
      }
    }
    CrashReportFactory.setForeground(false);
    this.adAz = HomeUI.a.adBn;
    if (!bh.bCs()) {
      bh.getNotification().et(false);
    }
    if (this.adAA != null) {
      bool1 = this.adAA.glL();
    }
    Log.i("MicroMsg.LauncherUI.HomeUI", "edw onPause, chatting is show ".concat(String.valueOf(bool1)));
    if (!bool1) {
      k.a(this.EzS, 4, this.adAC.jP, "directReport_onPause");
    }
    if (!this.EzS.isFinishing()) {
      com.tencent.mm.ui.widget.l.a(this.EzS);
    }
    if (this.adAk)
    {
      Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onMainTabPause");
      com.tencent.mm.blink.b.aJY().aKa();
      if (bh.baz()) {
        this.Pme.dead();
      }
    }
    if ((this.adAq != null) && (this.adAq.isShowing())) {
      this.adAq.dismiss();
    }
    AppMethodBeat.o(249666);
  }
  
  final void initActionBar()
  {
    AppMethodBeat.i(33247);
    if (this.adAA.glL())
    {
      Log.w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground True!");
      AppMethodBeat.o(33247);
      return;
    }
    this.advd = aw.isDarkMode();
    this.mActionBar.setLogo(new ColorDrawable(this.EzS.getResources().getColor(17170445)));
    this.mActionBar.x(false);
    this.mActionBar.w(false);
    this.mActionBar.v(false);
    this.mActionBar.y(true);
    this.mActionBar.setCustomView(af.mU(this.EzS).inflate(R.i.actionbar_title_launcher_center, new LinearLayout(this.EzS), false));
    Object localObject = (ImageView)this.mActionBar.getCustomView().findViewById(R.h.actionbar_up_indicator_btn);
    if (localObject != null) {
      ((ImageView)localObject).getDrawable().setColorFilter(this.EzS.getResources().getColor(R.e.FG_0), PorterDuff.Mode.SRC_ATOP);
    }
    ((ImageView)localObject).setOnClickListener(new HomeUI.19(this));
    localObject = i.agtt;
    if (((Integer)i.a(b.a.agqy, Integer.valueOf(0))).intValue() == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = (TextView)this.mActionBar.getCustomView().findViewById(16908308);
        if (localObject != null) {
          ((TextView)localObject).setOnClickListener(new HomeUI.21(this));
        }
      }
      this.mActionBar.setBackgroundDrawable(bb.m(this.EzS, R.e.dark_actionbar_color, this.EzS.getResources().getColor(R.e.BW_0_Alpha_0_9)));
      aMl();
      this.mActionBar.getCustomView().findViewById(R.h.actionbar_title_launcher_container).setOnClickListener(new HomeUI.22(this));
      AppMethodBeat.o(33247);
      return;
    }
  }
  
  final void jhu()
  {
    AppMethodBeat.i(33253);
    jiU();
    if (bh.baz()) {
      bh.baH().postToWorkerDelayed(new HomeUI.28(this), 500L);
    }
    com.tencent.mm.app.z localz = com.tencent.mm.app.z.aCK();
    localz.hhr = false;
    localz.hhs.removeMessages(-1999);
    localz.hhs.removeMessages(-2999);
    localz.hhs.sendEmptyMessageDelayed(-1999, 3000L);
    localz.hhs.sendEmptyMessageDelayed(-2999, 30000L);
    AppMethodBeat.o(33253);
  }
  
  final void jiN()
  {
    AppMethodBeat.i(33237);
    if ((this.adAq == null) || (!bh.baz()))
    {
      AppMethodBeat.o(33237);
      return;
    }
    if (this.adAq.isShowing())
    {
      this.adAq.dismiss();
      AppMethodBeat.o(33237);
      return;
    }
    this.adAq.du();
    AppMethodBeat.o(33237);
  }
  
  final void jiO()
  {
    AppMethodBeat.i(33239);
    int i;
    if (this.adAU != null)
    {
      this.adAU.setShowAsAction(2);
      if (this.adAW) {
        break label254;
      }
      if (!(this.adAC.jkb() instanceof MoreTabUI)) {
        break label249;
      }
      MoreTabUI localMoreTabUI = (MoreTabUI)this.adAC.jkb();
      if ((localMoreTabUI.adHx != null) && (localMoreTabUI.adHx.isVisible))
      {
        i = 1;
        if (i == 0) {
          break label249;
        }
        i = 1;
        label79:
        if (i == 0) {
          break label254;
        }
        this.adAU.setVisible(true);
      }
    }
    else
    {
      label94:
      if (this.adAS != null)
      {
        if (!this.adAW) {
          break label279;
        }
        this.adAS.setShowAsAction(2);
        this.adAS.setVisible(true);
        if (this.IWX != null) {
          this.IWX.setVisibility(0);
        }
      }
      label144:
      if (this.adAR != null)
      {
        if (!this.adAW) {
          break label320;
        }
        this.adAR.setShowAsAction(2);
        this.adAR.setVisible(true);
        if (this.IWX != null) {
          this.IWX.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (this.adAT != null)
      {
        if (!this.adAW)
        {
          this.adAT.setShowAsAction(2);
          this.adAT.setVisible(true);
          this.aduW.setVisibility(0);
          AppMethodBeat.o(33239);
          return;
          i = 0;
          break;
          label249:
          i = 0;
          break label79;
          label254:
          this.adAU.setVisible(false);
          this.adAU.setEnabled(false);
          break label94;
          label279:
          this.adAS.setVisible(false);
          this.adAS.setEnabled(false);
          if (this.IWX == null) {
            break label144;
          }
          this.IWX.setVisibility(8);
          break label144;
          label320:
          this.adAR.setVisible(false);
          this.adAR.setEnabled(false);
          if (this.IWX == null) {
            continue;
          }
          this.IWX.setVisibility(8);
          continue;
        }
        this.adAT.setVisible(false);
        this.adAT.setEnabled(false);
        this.aduW.setVisibility(8);
      }
    }
    AppMethodBeat.o(33239);
  }
  
  final void jiP()
  {
    AppMethodBeat.i(33240);
    int i = this.adAC.jP;
    if (i == 0) {
      getMainTabUI().jkb();
    }
    Intent localIntent = new Intent().putExtra("from_tab_index", i).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = localObject2;
      if (!aw.isDarkMode())
      {
        localObject1 = localObject2;
        if (com.tencent.mm.compatible.util.d.rc(30)) {
          localObject1 = ActivityOptions.makeSceneTransitionAnimation(this.EzS, new Pair[0]).toBundle();
        }
      }
    }
    com.tencent.mm.plugin.fts.a.d.b(this.EzS, ".ui.FTSMainUI", localIntent, (Bundle)localObject1);
    AppMethodBeat.o(33240);
  }
  
  final void jiQ()
  {
    AppMethodBeat.i(33242);
    if ((jja()) && (jjb())) {
      this.adAG = false;
    }
    if (jja()) {
      com.tencent.mm.kernel.h.baE().ban().set(at.a.adfH, Boolean.FALSE);
    }
    if (this.adAQ != null)
    {
      this.adAQ.findViewById(R.h.tips).setVisibility(8);
      localObject = com.tencent.mm.plugin.story.g.h.SqZ;
      com.tencent.mm.plugin.story.g.h.vW(0L);
    }
    if (!((e)com.tencent.mm.kernel.h.az(e.class)).canPostStory())
    {
      com.tencent.mm.kernel.h.baF();
      int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acYs, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.k.c(this.EzS, "", this.EzS.getResources().getString(R.l.story_one_day_post_tip, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(33242);
      return;
    }
    Object localObject = (e)com.tencent.mm.kernel.h.az(e.class);
    MMFragmentActivity localMMFragmentActivity = this.EzS;
    com.tencent.mm.plugin.story.g.h localh = com.tencent.mm.plugin.story.g.h.SqZ;
    ((e)localObject).startStoryCaptureForResult(localMMFragmentActivity, 0, com.tencent.mm.plugin.story.g.h.hyo(), 10);
    AppMethodBeat.o(33242);
  }
  
  public final void jiR()
  {
    AppMethodBeat.i(33243);
    if ((com.tencent.mm.model.z.bBK().booleanValue()) && ((adAr.booleanValue()) || (adAs.booleanValue())))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    if (!aw.jkS())
    {
      this.adAC.jiR();
      AppMethodBeat.o(33243);
      return;
    }
    this.adAC.adGY = Boolean.TRUE;
    AppMethodBeat.o(33243);
  }
  
  public final void jiS()
  {
    AppMethodBeat.i(33244);
    bh.baH().setLowestPriority();
    this.adAC.jkg();
    MMHandlerThread.postToMainThread(this.adAY);
    AppMethodBeat.o(33244);
  }
  
  public final boolean jiT()
  {
    return this.adAz == HomeUI.a.adBm;
  }
  
  public final void jiU()
  {
    AppMethodBeat.i(249703);
    if (this.EzS != null) {
      try
      {
        this.EzS.moveTaskToBack(true);
        AppMethodBeat.o(249703);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(249703);
  }
  
  public final void jiV()
  {
    AppMethodBeat.i(33254);
    aMl();
    AppMethodBeat.o(33254);
  }
  
  public final void jiW()
  {
    AppMethodBeat.i(33255);
    this.adAC.jiW();
    AppMethodBeat.o(33255);
  }
  
  public final void jiX()
  {
    AppMethodBeat.i(33259);
    this.adAC.aAq(170);
    AppMethodBeat.o(33259);
  }
  
  final void jiZ()
  {
    AppMethodBeat.i(33261);
    if ((this.adAU != null) && (this.adAU.getActionView() != null))
    {
      ImageView localImageView = (ImageView)this.adAU.getActionView().findViewById(R.h.icon);
      localImageView.setImageDrawable(this.EzS.getResources().getDrawable(R.k.icons_filled_camera));
      if (jiY())
      {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        if (!this.adAG) {
          break label169;
        }
        if ((!jja()) || (!jjb())) {
          break label164;
        }
      }
      label164:
      for (boolean bool = true;; bool = false)
      {
        this.adAG = bool;
        this.adAU.getActionView().findViewById(R.h.tips).setVisibility(0);
        AppMethodBeat.o(33261);
        return;
        localImageView.setColorFilter(new PorterDuffColorFilter(this.EzS.getResources().getColor(R.e.BW_0_Alpha_0_9), PorterDuff.Mode.SRC_ATOP));
        break;
      }
      label169:
      this.adAU.getActionView().findViewById(R.h.tips).setVisibility(8);
    }
    AppMethodBeat.o(33261);
  }
  
  public final void setTitleBarDoubleClickListener(Runnable paramRunnable)
  {
    AppMethodBeat.i(33250);
    if (!this.adBb.contains(paramRunnable)) {
      this.adBb.add(paramRunnable);
    }
    AppMethodBeat.o(33250);
  }
  
  final class b
    implements com.tencent.mm.plugin.newtips.a.a
  {
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(33227);
      this$1 = new ViewGroup.LayoutParams(paramInt1, paramInt2);
      HomeUI localHomeUI = HomeUI.this;
      com.tencent.mm.kiss.layout.b.bbG();
      HomeUI.a(localHomeUI, com.tencent.mm.kiss.layout.b.d(HomeUI.c(HomeUI.this), R.i.actionbar_option_menu_right));
      HomeUI.a(HomeUI.this, (ImageView)HomeUI.s(HomeUI.this).findViewById(R.h.icon));
      HomeUI.b(HomeUI.this, HomeUI.s(HomeUI.this).findViewById(R.h.tips));
      HomeUI.s(HomeUI.this).setLayoutParams(HomeUI.this);
      HomeUI.s(HomeUI.this).setMinimumHeight(paramInt2);
      HomeUI.s(HomeUI.this).setMinimumWidth(paramInt1);
      HomeUI.t(HomeUI.this).setImageResource(R.k.icons_outlined_add2);
      HomeUI.s(HomeUI.this).setContentDescription(HomeUI.this.getString(R.l.top_item_desc_more));
      HomeUI.s(HomeUI.this).setOnClickListener(new HomeUI.b.1(this));
      HomeUI.s(HomeUI.this).post(new HomeUI.b.2(this));
      AppMethodBeat.o(33227);
    }
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(369615);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(369615);
    }
    
    public final boolean a(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, fng paramfng)
    {
      return false;
    }
    
    public final boolean fZD()
    {
      return false;
    }
    
    public final String getPath()
    {
      return "plus";
    }
    
    public final View getRoot()
    {
      AppMethodBeat.i(33228);
      View localView = HomeUI.s(HomeUI.this);
      AppMethodBeat.o(33228);
      return localView;
    }
    
    public final boolean ym(boolean paramBoolean)
    {
      AppMethodBeat.i(369616);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(369616);
      return paramBoolean;
    }
    
    public final boolean yn(boolean paramBoolean)
    {
      AppMethodBeat.i(33231);
      if (paramBoolean) {
        HomeUI.z(HomeUI.this).setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33231);
        return true;
        HomeUI.z(HomeUI.this).setVisibility(8);
      }
    }
    
    public final boolean yo(boolean paramBoolean)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI
 * JD-Core Version:    0.7.0.1
 */