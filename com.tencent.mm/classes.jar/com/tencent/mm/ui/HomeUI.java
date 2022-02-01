package com.tencent.mm.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.h.a;
import com.tencent.mm.app.w;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.f.a.dk;
import com.tencent.mm.f.a.ot;
import com.tencent.mm.f.a.ot.a;
import com.tencent.mm.f.a.zw;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitask.ui.panel.MultiTaskContainerView;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.protocal.protobuf.erx;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.conversation.ConversationListView;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import com.tencent.mm.util.b.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public class HomeUI
  implements com.tencent.mm.plugin.taskbar.api.a, LauncherUI.b, LauncherUI.c, LauncherUI.e
{
  public static Boolean VVV = Boolean.FALSE;
  public static Boolean VVW = Boolean.FALSE;
  private static boolean VWl = true;
  static final int VWn = R.h.menu_search;
  static final int VWo = R.h.menu_add;
  private long Cfh;
  View Cwk;
  private TextView DcD;
  private View GLc;
  IListener Jcp;
  private boolean MoZ;
  private final long Qhx;
  private TextView VQO;
  boolean VQV;
  View VRl;
  private final long VVK;
  private final long VVL;
  public boolean VVM;
  boolean VVN;
  public boolean VVO;
  private WeImageView VVP;
  private boolean VVQ;
  private String VVR;
  private String VVS;
  private String VVT;
  ah VVU;
  private final long VVX;
  private final long VVY;
  private boolean VVZ;
  private boolean VWA;
  IListener VWB;
  Runnable VWC;
  private int VWD;
  private long VWE;
  private LinkedList<Runnable> VWF;
  com.tencent.mm.plugin.messenger.foundation.a.t VWG;
  private float VWH;
  private boolean VWI;
  private int VWa;
  private int VWb;
  private int VWc;
  HomeUI.a VWd;
  LauncherUI.a VWe;
  j VWf;
  MainTabUI VWg;
  int VWh;
  int VWi;
  private boolean VWj;
  boolean VWk;
  View.OnLayoutChangeListener VWm;
  b VWp;
  View VWq;
  ImageView VWr;
  private View VWs;
  ImageView VWt;
  View VWu;
  MenuItem VWv;
  MenuItem VWw;
  private MenuItem VWx;
  MenuItem VWy;
  Menu VWz;
  private int clickCount;
  View contentView;
  private String fOX;
  ActionBar mActionBar;
  private boolean mXU;
  LayoutInflater mYa;
  MessageQueue.IdleHandler sJE;
  private final HashMap<String, Object> values;
  MMFragmentActivity zwS;
  
  public HomeUI()
  {
    AppMethodBeat.i(33232);
    this.VVK = 604800000L;
    this.VVL = 86400000L;
    this.mXU = true;
    this.VVM = false;
    this.fOX = null;
    this.VVO = false;
    this.VQV = false;
    this.VVQ = false;
    this.VVX = 432000000L;
    this.VVY = 604800000L;
    this.VVZ = true;
    this.VWa = 0;
    this.VWb = 0;
    this.VWc = 0;
    this.VWd = HomeUI.a.VWQ;
    this.VWg = new MainTabUI();
    this.VWh = 0;
    this.VWi = 0;
    this.VWj = false;
    this.VWk = true;
    this.VWm = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8) {}
    };
    this.MoZ = LocaleUtil.isChineseAppLang();
    this.VWA = true;
    this.clickCount = 0;
    this.Cfh = 0L;
    this.values = new HashMap();
    this.Jcp = new IListener() {};
    this.VWB = new IListener() {};
    this.sJE = new HomeUI.18(this);
    this.VWC = new HomeUI.19(this);
    this.VWD = 0;
    this.Qhx = 300L;
    this.VWE = SystemClock.elapsedRealtime();
    this.VWF = new LinkedList();
    this.VWG = new com.tencent.mm.plugin.messenger.foundation.a.t()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(261395);
        if ((Util.nullAsNil(paramAnonymousString).equals("showprivacypolicy")) && (paramAnonymousMap != null))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.device_id");
          HomeUI.a(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_content"));
          HomeUI.b(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_ok"));
          HomeUI.c(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_cancel"));
          boolean bool1 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needbirthday"));
          boolean bool2 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needopenplatform"));
          boolean bool3 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needconfirm"));
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VuL, Boolean.valueOf(bool1));
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VuM, Boolean.valueOf(bool2));
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VuN, Boolean.valueOf(bool3));
          paramAnonymousMap = com.tencent.mm.cd.b.cU(q.auM().getBytes());
          paramAnonymousMap.arf(16);
          paramAnonymousMap = Base64.encodeToString(paramAnonymousMap.toByteArray(), 2);
          Log.i("MicroMsg.LauncherUI.HomeUI", "deviceId:%s, localDeviceId:%s, doubleCheckContent:%s, doubleCheckOk:%s, doubleCheckCancel:%s, needBirthday:%s, needOpenPlatform:%s, needConfirm:%s", new Object[] { paramAnonymousString, paramAnonymousMap, HomeUI.F(HomeUI.this), HomeUI.H(HomeUI.this), HomeUI.G(HomeUI.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((Util.isNullOrNil(paramAnonymousString)) || (paramAnonymousString.equals(paramAnonymousMap)))
          {
            paramAnonymousString = com.tencent.mm.kernel.h.aHG().aHp().b(274436, "").toString();
            paramAnonymousMap = HomeUI.c(HomeUI.this);
            int j = R.l.license_read_url;
            paramAnonymousa = LocaleUtil.getApplicationLanguage();
            int i;
            if (bool2)
            {
              i = 1;
              paramAnonymousMap = paramAnonymousMap.getString(j, new Object[] { paramAnonymousa, paramAnonymousString, "login", Integer.valueOf(1), Integer.valueOf(i) });
              if (!com.tencent.mm.az.b.WF(paramAnonymousString)) {
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
              com.tencent.mm.ui.base.b.lc(HomeUI.c(HomeUI.this));
              AppMethodBeat.o(261395);
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
        AppMethodBeat.o(261395);
      }
    };
    this.VWH = 0.0F;
    this.VWI = false;
    AppMethodBeat.o(33232);
  }
  
  private static void A(View paramView, boolean paramBoolean)
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
  
  private void Fq(final boolean paramBoolean)
  {
    AppMethodBeat.i(33235);
    if (this.GLc != null)
    {
      Log.e("MicroMsg.LauncherUI.HomeUI", "tipsView already shown");
      AppMethodBeat.o(33235);
      return;
    }
    this.GLc = View.inflate(MMApplicationContext.getContext(), R.i.ejz, null);
    Object localObject = (TextView)this.GLc.findViewById(R.h.dOE);
    if (paramBoolean) {
      ((TextView)localObject).setText(MMApplicationContext.getContext().getString(R.l.emF));
    }
    for (;;)
    {
      localObject = new FrameLayout.LayoutParams(-2, -2, 53);
      this.GLc.setBackgroundResource(R.g.ofm_pop_up_bg);
      if (this.contentView != null)
      {
        ((ViewGroup)this.contentView).addView(this.GLc, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), R.a.shake_y);
        this.GLc.startAnimation((Animation)localObject);
        this.GLc.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33179);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/HomeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            HomeUI.n(HomeUI.this).cB();
            if (paramBoolean)
            {
              paramAnonymousView = HomeUI.this;
              localObject = Boolean.TRUE;
              HomeUI.a(paramAnonymousView, (Boolean)localObject, (Boolean)localObject);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(33179);
              return;
              HomeUI.a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
            }
          }
        });
      }
      AppMethodBeat.o(33235);
      return;
      ((TextView)localObject).setText(MMApplicationContext.getContext().getString(R.l.emE));
    }
  }
  
  private void Fs(boolean paramBoolean)
  {
    AppMethodBeat.i(271782);
    if (((this.VWg.hHU() instanceof MainUI)) && (((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.multitask.d.class)).isMultiTaskMode()))
    {
      i = 1;
      if ((i == 0) || (((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.multitask.d.class)).isDataEmpty())) {
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
      localObject = com.tencent.mm.ui.component.g.Xox;
      ((com.tencent.mm.plugin.multitask.ui.a.c)com.tencent.mm.ui.component.g.b(this.zwS).i(com.tencent.mm.plugin.multitask.ui.a.c.class)).in(true);
      AppMethodBeat.o(271782);
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
    localObject = com.tencent.mm.ui.component.g.Xox;
    ((com.tencent.mm.plugin.multitask.ui.a.c)com.tencent.mm.ui.component.g.b(this.zwS).i(com.tencent.mm.plugin.multitask.ui.a.c.class)).in(false);
    AppMethodBeat.o(271782);
  }
  
  private void Fu(boolean paramBoolean)
  {
    AppMethodBeat.i(33249);
    View localView;
    int j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.zwS.getWindow().getDecorView();
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
  
  private void atI(int paramInt)
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
        if (((LauncherUI)localObject).VXk.getMainTabUI() != null) {
          if (!((LauncherUI)localObject).VXk.getMainTabUI().fcH())
          {
            localObject = com.tencent.mm.ui.component.g.Xox;
            paramInt = i;
            if (!((com.tencent.mm.plugin.multitask.ui.a.c)com.tencent.mm.ui.component.g.b(this.zwS).i(com.tencent.mm.plugin.multitask.ui.a.c.class)).fbW()) {}
          }
          else
          {
            paramInt = this.zwS.getResources().getColor(R.e.transparent);
          }
        }
      }
      if (Math.abs(this.VWD - paramInt) >= 50000) {}
      try
      {
        this.zwS.getWindow().setStatusBarColor(paramInt);
        this.VWD = paramInt;
        AppMethodBeat.o(33248);
        return;
        i = paramInt;
        if (Build.VERSION.SDK_INT < 21) {
          continue;
        }
        i = au.A(this.zwS.getResources().getColor(R.e.statusbar_fg_drak_color), paramInt);
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
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(33236);
    if (this.GLc != null)
    {
      this.GLc.clearAnimation();
      this.GLc.setVisibility(8);
      if (paramBoolean1.booleanValue())
      {
        if (!paramBoolean2.booleanValue()) {
          break label89;
        }
        bh.beI();
        com.tencent.mm.model.c.aHp().i(340227, Boolean.TRUE);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(232L, 0L, 1L, false);
        VVV = Boolean.FALSE;
      }
    }
    for (;;)
    {
      this.GLc = null;
      AppMethodBeat.o(33236);
      return;
      label89:
      bh.beI();
      com.tencent.mm.model.c.aHp().i(340230, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(232L, 5L, 1L, false);
      VVW = Boolean.FALSE;
    }
  }
  
  private boolean hGA()
  {
    return (this.VWa == 2) && (this.VWb == 2);
  }
  
  private static boolean hGN()
  {
    AppMethodBeat.i(33260);
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(33260);
      return false;
    }
    if (((e)com.tencent.mm.kernel.h.ag(e.class)).isStoryExist(z.bcZ()))
    {
      AppMethodBeat.o(33260);
      return true;
    }
    AppMethodBeat.o(33260);
    return false;
  }
  
  static boolean hGP()
  {
    AppMethodBeat.i(33264);
    boolean bool = ((e)com.tencent.mm.kernel.h.ag(e.class)).getStoryNewFeatureConfig().gbz();
    AppMethodBeat.o(33264);
    return bool;
  }
  
  static boolean hGQ()
  {
    AppMethodBeat.i(33265);
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VCN, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(33265);
    return bool;
  }
  
  private boolean hGz()
  {
    return (this.VWa == 3) && (this.VWb == 3);
  }
  
  private void setActionBarColor(int paramInt)
  {
    AppMethodBeat.i(33256);
    if (this.mActionBar != null) {
      this.mActionBar.setBackgroundDrawable(new ColorDrawable(paramInt));
    }
    if (this.Cwk != null) {
      this.Cwk.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(33256);
  }
  
  @SuppressLint({"RestrictedApi"})
  private void updateTitle()
  {
    AppMethodBeat.i(33233);
    if (!this.VVZ)
    {
      AppMethodBeat.o(33233);
      return;
    }
    int i = this.VWg.iU;
    Object localObject1 = getString(R.l.app_name);
    Object localObject2;
    if (i == 0)
    {
      localObject2 = localObject1;
      if (this.VWg.Wbu.hIf() > 0)
      {
        localObject2 = localObject1;
        if (!this.MoZ) {
          localObject2 = localObject1 + " ";
        }
        localObject2 = localObject2 + "(" + this.VWg.Wbu.hIf() + ")";
      }
      localObject1 = new zw();
      ((zw)localObject1).fZf.fZg = 1;
      ((zw)localObject1).fZf.title = ((CharSequence)localObject2).toString();
      EventCenter.instance.publish((IEvent)localObject1);
      localObject1 = localObject2;
    }
    label216:
    label993:
    for (;;)
    {
      boolean bool;
      if (i == 3)
      {
        atI(this.zwS.getResources().getColor(R.e.transparent));
        if (!hGN())
        {
          if (!com.tencent.mm.plugin.textstatus.a.t.gkZ())
          {
            bool = false;
            if ((!bool) && (!ar.isDarkMode())) {
              break label718;
            }
          }
        }
        else
        {
          Fu(true);
          label231:
          ((e)com.tencent.mm.kernel.h.ag(e.class)).checkPost();
          if (this.mActionBar != null)
          {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.zwS.getResources().getColor(R.e.transparent)));
            this.mActionBar.getCustomView().setVisibility(8);
          }
          if (this.Cwk != null) {
            this.Cwk.setBackgroundColor(this.zwS.getResources().getColor(R.e.transparent));
          }
          this.VWA = false;
          if ((hGz()) && (this.VWy != null) && (!this.VWy.isVisible())) {
            this.VWy.setVisible(true);
          }
          Log.i("MicroMsg.LauncherUI.HomeUI", "alvinluo updateSettingTitle");
          this.mActionBar.e(0.0F);
          this.mActionBar.aG();
          this.DcD = ((TextView)this.mActionBar.getCustomView().findViewById(16908308));
          this.VVP = ((WeImageView)this.mActionBar.getCustomView().findViewById(R.h.home_title_icon));
          if (this.VVP != null) {
            this.VVP.setVisibility(8);
          }
          if (this.DcD != null)
          {
            this.DcD.setText((CharSequence)localObject1);
            if (i != 0) {
              break label958;
            }
            ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).setTextWithStatus(this.DcD, com.tencent.mm.plugin.auth.a.a.crN(), a.b.MzF, a.c.MzI);
            label488:
            bool = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM();
            if ((this.VVP != null) && (bool) && (i == 0)) {
              this.VVP.setVisibility(0);
            }
            if (!hGz()) {
              break label982;
            }
            this.DcD.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        float f = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), R.f.ActionBarTextSize) * com.tencent.mm.ci.a.km(MMApplicationContext.getContext());
        if (this.DcD.getTextSize() != f) {
          this.DcD.setTextSize(0, f);
        }
        i = this.zwS.getResources().getColor(R.e.actionbar_title_light_color);
        if ((this.VQV) && (this.DcD.getCurrentTextColor() != i)) {
          this.DcD.setTextColor(i);
        }
        ar.a(this.DcD.getPaint(), 0.8F);
        Fs(true);
        AppMethodBeat.o(33233);
        return;
        if (i == 1)
        {
          localObject1 = getString(R.l.eKZ);
          break;
        }
        if (i == 2)
        {
          localObject1 = getString(R.l.eKX);
          break;
        }
        if (i != 3) {
          break label993;
        }
        localObject1 = getString(R.l.eLu);
        break;
        bool = ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).hasStatus(com.tencent.mm.plugin.auth.a.a.crN());
        break label216;
        Fu(false);
        break label231;
        atI(this.zwS.getResources().getColor(R.e.normal_actionbar_color));
        Fu(this.VQV);
        localObject2 = this.mActionBar.getCustomView().getBackground();
        if ((localObject2 instanceof ColorDrawable)) {
          if (((ColorDrawable)localObject2).getColor() != this.zwS.getResources().getColor(R.e.normal_actionbar_color)) {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.zwS.getResources().getColor(R.e.normal_actionbar_color)));
          }
        }
        for (;;)
        {
          if (this.mActionBar.getCustomView().getVisibility() != 0) {
            this.mActionBar.getCustomView().setVisibility(0);
          }
          this.VWA = true;
          if ((hGA()) && (this.VWv != null) && (!this.VWv.isVisible())) {
            this.VWv.setVisible(true);
          }
          if ((!hGA()) || (this.VWw == null) || (this.VWw.isVisible())) {
            break;
          }
          this.VWw.setVisible(true);
          break;
          this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.zwS.getResources().getColor(R.e.normal_actionbar_color)));
        }
        ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).clearTextStatus(this.DcD, com.tencent.mm.plugin.auth.a.a.crN());
        break label488;
        this.DcD.setVisibility(0);
      }
    }
  }
  
  final void Fr(boolean paramBoolean)
  {
    AppMethodBeat.i(33238);
    if ((this.VVU == null) || (this.VWq == null) || (this.VWp == null))
    {
      AppMethodBeat.o(33238);
      return;
    }
    if (!bh.aHB())
    {
      Log.w("MicroMsg.LauncherUI.HomeUI", "want update more menu new tips, but mmcore not ready");
      AppMethodBeat.o(33238);
      return;
    }
    this.VVU.WdD.FJ(paramBoolean);
    Object localObject = this.VWp;
    if (com.tencent.mm.plugin.newtips.a.g.a(((b)localObject).VWJ.VVU.WdD.hyT(), (com.tencent.mm.plugin.newtips.a.a)localObject))
    {
      localObject = new zw();
      ((zw)localObject).fZf.fZg = 2;
      ((zw)localObject).fZf.fZh = this.VVU.WdD.hyT();
      ((zw)localObject).fZf.fZi = false;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(33238);
      return;
    }
    if (((b)localObject).VWJ.VVU.WdD.hyT()) {
      ((b)localObject).VWJ.VWs.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject, k.GwK, ((b)localObject).VWJ.VVU.WdD.hyT());
      break;
      ((b)localObject).VWJ.VWs.setVisibility(8);
    }
  }
  
  public final void Ft(boolean paramBoolean)
  {
    AppMethodBeat.i(33246);
    if (!paramBoolean) {
      initActionBar();
    }
    this.zwS.supportInvalidateOptionsMenu();
    if (z.bdS().booleanValue()) {
      hGB();
    }
    this.VWg.hHY();
    AppMethodBeat.o(33246);
  }
  
  public final void Fv(boolean paramBoolean)
  {
    AppMethodBeat.i(33262);
    if ((this.VWy != null) && (this.VWy.getActionView() != null) && (this.zwS != null))
    {
      if (this.zwS.getResources().getConfiguration().orientation == 2)
      {
        this.VWy.setVisible(false);
        this.VWy.setEnabled(false);
        AppMethodBeat.o(33262);
        return;
      }
      this.VWy.setVisible(true);
      this.VWy.setEnabled(true);
      ImageView localImageView = (ImageView)this.VWy.getActionView().findViewById(R.h.icon);
      localImageView.setImageDrawable(this.zwS.getResources().getDrawable(R.k.icons_filled_camera));
      if ((paramBoolean) || (ar.isDarkMode())) {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      }
      while (this.VWk)
      {
        this.VWy.getActionView().findViewById(R.h.tips).setVisibility(0);
        AppMethodBeat.o(33262);
        return;
        localImageView.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
      }
      this.VWy.getActionView().findViewById(R.h.tips).setVisibility(8);
    }
    AppMethodBeat.o(33262);
  }
  
  public final void a(FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33245);
    this.zwS.getWindow().getDecorView().getBottom();
    this.zwS.getSupportActionBar().getCustomView().getBottom();
    paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
    paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
    AppMethodBeat.o(33245);
  }
  
  public final void aO(Runnable paramRunnable)
  {
    AppMethodBeat.i(33251);
    this.VWF.remove(paramRunnable);
    AppMethodBeat.o(33251);
  }
  
  public final void f(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33257);
    MMFragment localMMFragment = getMainTabUI().hHU();
    if (localMMFragment != null)
    {
      if ((localMMFragment instanceof MoreTabUI))
      {
        setActionBarColor(this.zwS.getResources().getColor(R.e.transparent));
        AppMethodBeat.o(33257);
        return;
      }
      if (!(localMMFragment instanceof MainUI)) {
        setActionBarColor(this.zwS.getResources().getColor(R.e.normal_actionbar_color));
      }
      while (paramInt2 > 10)
      {
        A(this.VRl, false);
        A(this.VWq, false);
        AppMethodBeat.o(33257);
        return;
        setActionBarColor(paramInt1);
      }
      A(this.VRl, true);
      A(this.VWq, true);
    }
    AppMethodBeat.o(33257);
  }
  
  public final void fMw()
  {
    AppMethodBeat.i(271769);
    Object localObject = this.VWg;
    boolean bool = this.VVM;
    Log.v("MicroMsg.LauncherUI.MainTabUI", "doOnPause %d, mainTabHasCreate:%b", new Object[] { Integer.valueOf(((MainTabUI)localObject).iU), Boolean.valueOf(bool) });
    if (bool) {
      ((MainTabUI)localObject).hHX();
    }
    localObject = ((MainTabUI)localObject).Wbu;
    if (bh.aHB())
    {
      bh.beI();
      com.tencent.mm.model.c.aHp().remove(((ae)localObject).WbO);
      bh.beI();
      com.tencent.mm.model.c.bbR().remove((MStorageEx.IOnStorageChange)localObject);
      com.tencent.mm.aa.c.aFn().b(((ae)localObject).WbN);
      EventCenter.instance.removeListener(((ae)localObject).WbP);
      EventCenter.instance.removeListener(((ae)localObject).VUf);
      EventCenter.instance.removeListener(((ae)localObject).VUe);
    }
    if (((ae)localObject).WbM != null)
    {
      ((ae)localObject).WbM.WbJ = null;
      ((ae)localObject).WbM = null;
    }
    localObject = this.VWf;
    if (((j)localObject).VVt != null)
    {
      bh.aGY().b(255, ((j)localObject).VVt);
      bh.aGY().b(384, ((j)localObject).VVt);
      ((j)localObject).VVt = null;
    }
    CrashReportFactory.setForeground(false);
    this.VWd = HomeUI.a.VWS;
    if (!bh.beB()) {
      bh.getNotification().dH(false);
    }
    bool = this.VWe.fcI();
    Log.i("MicroMsg.LauncherUI.HomeUI", "edw onPause, chatting is show ".concat(String.valueOf(bool)));
    if (!bool) {
      l.a(this.zwS, 4, this.VWg.iU, "directReport_onPause");
    }
    if (!this.zwS.isFinishing()) {
      com.tencent.mm.ui.widget.j.a(this.zwS);
    }
    if (this.VVM)
    {
      Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onMainTabPause");
      com.tencent.mm.blink.b.aqa().aqc();
      if (bh.aHB()) {
        EventCenter.instance.removeListener(this.Jcp);
      }
    }
    if ((this.VVU != null) && (this.VVU.isShowing())) {
      this.VVU.dismiss();
    }
    AppMethodBeat.o(271769);
  }
  
  public final void g(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33258);
    if ((paramInt1 != 0) && (this.DcD != null)) {
      this.DcD.setTextColor(paramInt1);
    }
    if (this.VWt != null)
    {
      if (this.VWI) {
        this.VWt.setAlpha(paramFloat);
      }
      this.VWt.setImageDrawable(au.o(this.zwS, R.k.actionbar_icon_dark_search, paramInt2));
    }
    if (this.VWr != null)
    {
      if (this.VWI) {
        this.VWr.setAlpha(paramFloat);
      }
      this.VWr.setImageDrawable(au.o(this.zwS, R.k.icons_outlined_add2, paramInt2));
    }
    AppMethodBeat.o(33258);
  }
  
  public MainTabUI getMainTabUI()
  {
    return this.VWg;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(33241);
    String str = this.zwS.getString(paramInt);
    AppMethodBeat.o(33241);
    return str;
  }
  
  final void hFi()
  {
    AppMethodBeat.i(33253);
    hGJ();
    if (bh.aHB()) {
      bh.aHJ().postToWorkerDelayed(new HomeUI.27(this), 500L);
    }
    w localw = w.aaZ();
    localw.fdB = false;
    localw.fdC.removeMessages(-1999);
    localw.fdC.removeMessages(-2999);
    localw.fdC.sendEmptyMessageDelayed(-1999, 3000L);
    localw.fdC.sendEmptyMessageDelayed(-2999, 30000L);
    AppMethodBeat.o(33253);
  }
  
  final void hGB()
  {
    AppMethodBeat.i(33234);
    if (!bh.aHB())
    {
      Log.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready");
      AppMethodBeat.o(33234);
      return;
    }
    bh.beI();
    Boolean localBoolean = Boolean.valueOf(Util.nullAsFalse((Boolean)com.tencent.mm.model.c.aHp().b(340227, null)));
    if ((!localBoolean.booleanValue()) && (!com.tencent.mm.ui.contact.l.Xss.booleanValue()))
    {
      VVV = Boolean.TRUE;
      Fq(true);
    }
    long l1 = System.currentTimeMillis();
    bh.beI();
    long l2 = Util.nullAs((Long)com.tencent.mm.model.c.aHp().b(340240, null), 0L);
    bh.beI();
    boolean bool1 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.aHp().b(340230, null));
    bh.beI();
    boolean bool2 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.aHp().b(340228, null));
    bh.beI();
    boolean bool3 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.aHp().b(340229, null));
    if ((localBoolean.booleanValue()) && (Boolean.valueOf(bool2).booleanValue()) && (Boolean.valueOf(bool3).booleanValue()) && (!Boolean.valueOf(bool1).booleanValue()) && (l1 - l2 >= 432000000L))
    {
      VVW = Boolean.TRUE;
      Fq(false);
    }
    AppMethodBeat.o(33234);
  }
  
  final void hGC()
  {
    AppMethodBeat.i(33237);
    if ((this.VVU == null) || (!bh.aHB()))
    {
      AppMethodBeat.o(33237);
      return;
    }
    if (this.VVU.isShowing())
    {
      this.VVU.dismiss();
      AppMethodBeat.o(33237);
      return;
    }
    this.VVU.cB();
    AppMethodBeat.o(33237);
  }
  
  final void hGD()
  {
    AppMethodBeat.i(33239);
    int i;
    if (this.VWy != null)
    {
      this.VWy.setShowAsAction(2);
      if (this.VWA) {
        break label254;
      }
      if (!(this.VWg.hHU() instanceof MoreTabUI)) {
        break label249;
      }
      MoreTabUI localMoreTabUI = (MoreTabUI)this.VWg.hHU();
      if ((localMoreTabUI.WbV != null) && (localMoreTabUI.WbV.isVisible))
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
        this.VWy.setVisible(true);
      }
    }
    else
    {
      label94:
      if (this.VWw != null)
      {
        if (!this.VWA) {
          break label279;
        }
        this.VWw.setShowAsAction(2);
        this.VWw.setVisible(true);
        if (this.DcD != null) {
          this.DcD.setVisibility(0);
        }
      }
      label144:
      if (this.VWv != null)
      {
        if (!this.VWA) {
          break label320;
        }
        this.VWv.setShowAsAction(2);
        this.VWv.setVisible(true);
        if (this.DcD != null) {
          this.DcD.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (this.VWx != null)
      {
        if (!this.VWA)
        {
          this.VWx.setShowAsAction(2);
          this.VWx.setVisible(true);
          this.VQO.setVisibility(0);
          AppMethodBeat.o(33239);
          return;
          i = 0;
          break;
          label249:
          i = 0;
          break label79;
          label254:
          this.VWy.setVisible(false);
          this.VWy.setEnabled(false);
          break label94;
          label279:
          this.VWw.setVisible(false);
          this.VWw.setEnabled(false);
          if (this.DcD == null) {
            break label144;
          }
          this.DcD.setVisibility(8);
          break label144;
          label320:
          this.VWv.setVisible(false);
          this.VWv.setEnabled(false);
          if (this.DcD == null) {
            continue;
          }
          this.DcD.setVisibility(8);
          continue;
        }
        this.VWx.setVisible(false);
        this.VWx.setEnabled(false);
        this.VQO.setVisibility(8);
      }
    }
    AppMethodBeat.o(33239);
  }
  
  final void hGE()
  {
    AppMethodBeat.i(33240);
    int i = this.VWg.iU;
    if (i == 0) {
      getMainTabUI().hHU();
    }
    Intent localIntent = new Intent().putExtra("from_tab_index", i).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = localObject2;
      if (!ar.isDarkMode())
      {
        localObject1 = localObject2;
        if (com.tencent.mm.compatible.util.d.qW(30)) {
          localObject1 = ActivityOptions.makeSceneTransitionAnimation(this.zwS, new Pair[0]).toBundle();
        }
      }
    }
    com.tencent.mm.plugin.fts.a.d.b(this.zwS, ".ui.FTSMainUI", localIntent, (Bundle)localObject1);
    AppMethodBeat.o(33240);
  }
  
  final void hGF()
  {
    AppMethodBeat.i(33242);
    if ((hGP()) && (hGQ())) {
      this.VWk = false;
    }
    if (hGP()) {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCN, Boolean.FALSE);
    }
    if (this.VWu != null)
    {
      this.VWu.findViewById(R.h.tips).setVisibility(8);
      localObject = com.tencent.mm.plugin.story.h.h.LOJ;
      com.tencent.mm.plugin.story.h.h.RN(0L);
    }
    if (!((e)com.tencent.mm.kernel.h.ag(e.class)).canPostStory())
    {
      com.tencent.mm.kernel.h.aHH();
      int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VwH, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.h.c(this.zwS, "", this.zwS.getResources().getString(R.l.story_one_day_post_tip, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(33242);
      return;
    }
    Object localObject = (e)com.tencent.mm.kernel.h.ag(e.class);
    MMFragmentActivity localMMFragmentActivity = this.zwS;
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.LOJ;
    ((e)localObject).startStoryCaptureForResult(localMMFragmentActivity, 0, com.tencent.mm.plugin.story.h.h.geW(), 10);
    AppMethodBeat.o(33242);
  }
  
  public final void hGG()
  {
    AppMethodBeat.i(33243);
    if ((z.bdS().booleanValue()) && ((VVV.booleanValue()) || (VVW.booleanValue())))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    if (!ar.hIH()) {
      this.VWg.hGG();
    }
    AppMethodBeat.o(33243);
  }
  
  public final void hGH()
  {
    AppMethodBeat.i(33244);
    bh.aHJ().setLowestPriority();
    this.VWg.hHZ();
    MMHandlerThread.postToMainThread(this.VWC);
    AppMethodBeat.o(33244);
  }
  
  public final boolean hGI()
  {
    return this.VWd == HomeUI.a.VWR;
  }
  
  public final void hGJ()
  {
    AppMethodBeat.i(271792);
    if (this.zwS != null) {
      try
      {
        this.zwS.moveTaskToBack(true);
        AppMethodBeat.o(271792);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(271792);
  }
  
  public final void hGK()
  {
    AppMethodBeat.i(33254);
    updateTitle();
    AppMethodBeat.o(33254);
  }
  
  public final void hGL()
  {
    AppMethodBeat.i(33255);
    this.VWg.hGL();
    AppMethodBeat.o(33255);
  }
  
  public final void hGM()
  {
    AppMethodBeat.i(33259);
    this.VWg.atY(170);
    AppMethodBeat.o(33259);
  }
  
  final void hGO()
  {
    AppMethodBeat.i(33261);
    if ((this.VWy != null) && (this.VWy.getActionView() != null))
    {
      ImageView localImageView = (ImageView)this.VWy.getActionView().findViewById(R.h.icon);
      localImageView.setImageDrawable(this.zwS.getResources().getDrawable(R.k.icons_filled_camera));
      if (hGN())
      {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        if (!this.VWk) {
          break label169;
        }
        if ((!hGP()) || (!hGQ())) {
          break label164;
        }
      }
      label164:
      for (boolean bool = true;; bool = false)
      {
        this.VWk = bool;
        this.VWy.getActionView().findViewById(R.h.tips).setVisibility(0);
        AppMethodBeat.o(33261);
        return;
        localImageView.setColorFilter(new PorterDuffColorFilter(this.zwS.getResources().getColor(R.e.BW_0_Alpha_0_9), PorterDuff.Mode.SRC_ATOP));
        break;
      }
      label169:
      this.VWy.getActionView().findViewById(R.h.tips).setVisibility(8);
    }
    AppMethodBeat.o(33261);
  }
  
  final void initActionBar()
  {
    AppMethodBeat.i(33247);
    if (this.VWe.fcI())
    {
      Log.w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground True!");
      AppMethodBeat.o(33247);
      return;
    }
    this.VQV = ar.isDarkMode();
    this.mActionBar.setLogo(new ColorDrawable(this.zwS.getResources().getColor(17170445)));
    this.mActionBar.t(false);
    this.mActionBar.s(false);
    this.mActionBar.r(false);
    this.mActionBar.u(true);
    this.mActionBar.setCustomView(ad.kS(this.zwS).inflate(R.i.actionbar_title_launcher_center, new LinearLayout(this.zwS), false));
    Object localObject = (ImageView)this.mActionBar.getCustomView().findViewById(R.h.actionbar_up_indicator_btn);
    if (localObject != null) {
      ((ImageView)localObject).getDrawable().setColorFilter(this.zwS.getResources().getColor(R.e.FG_0), PorterDuff.Mode.SRC_ATOP);
    }
    ((ImageView)localObject).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(270782);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/HomeUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = com.tencent.mm.ui.component.g.Xox;
        paramAnonymousView = (com.tencent.mm.plugin.multitask.ui.a.c)com.tencent.mm.ui.component.g.b(HomeUI.j(HomeUI.this)).i(com.tencent.mm.plugin.multitask.ui.a.c.class);
        Log.i(com.tencent.mm.plugin.multitask.ui.a.c.TAG, "showPanel, smoothScrool:true");
        paramAnonymousView.FMm = 2;
        paramAnonymousView.fcb();
        localObject = paramAnonymousView.FMu;
        if (localObject != null) {
          ((MultiTaskContainerView)localObject).Yl(0);
        }
        paramAnonymousView = paramAnonymousView.FMi;
        if (paramAnonymousView != null) {
          paramAnonymousView.setCurrentItem(0, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(270782);
      }
    });
    localObject = com.tencent.mm.util.i.YyX;
    if (((Integer)com.tencent.mm.util.i.a(b.a.YxP, Integer.valueOf(0))).intValue() == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = (TextView)this.mActionBar.getCustomView().findViewById(16908308);
        if (localObject != null) {
          ((TextView)localObject).setOnClickListener(new HomeUI.21(this));
        }
      }
      this.mActionBar.setBackgroundDrawable(au.o(this.zwS, R.e.dark_actionbar_color, this.zwS.getResources().getColor(R.e.BW_0_Alpha_0_9)));
      updateTitle();
      this.mActionBar.getCustomView().findViewById(R.h.actionbar_title_launcher_container).setOnClickListener(new HomeUI.22(this));
      AppMethodBeat.o(33247);
      return;
    }
  }
  
  public final void setTitleBarDoubleClickListener(Runnable paramRunnable)
  {
    AppMethodBeat.i(33250);
    if (!this.VWF.contains(paramRunnable)) {
      this.VWF.add(paramRunnable);
    }
    AppMethodBeat.o(33250);
  }
  
  public final void zQ(boolean paramBoolean)
  {
    AppMethodBeat.i(271796);
    Log.i("MicroMsg.LauncherUI.HomeUI", "alvinluo updateStatusBar show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Resources localResources = this.zwS.getResources();
    if (paramBoolean) {}
    for (int i = R.e.normal_actionbar_color;; i = R.e.transparent)
    {
      atI(localResources.getColor(i));
      AppMethodBeat.o(271796);
      return;
    }
  }
  
  public static class FitSystemWindowLayoutView
    extends FrameLayout
  {
    private int VWU;
    private ViewGroup VWV;
    private Rect mRect;
    
    public FitSystemWindowLayoutView(Context paramContext)
    {
      super();
      AppMethodBeat.i(33220);
      this.mRect = new Rect();
      this.VWV = null;
      AppMethodBeat.o(33220);
    }
    
    public FitSystemWindowLayoutView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(33219);
      this.mRect = new Rect();
      this.VWV = null;
      AppMethodBeat.o(33219);
    }
    
    @TargetApi(14)
    public boolean fitSystemWindows(Rect paramRect)
    {
      AppMethodBeat.i(33221);
      Object localObject2 = paramRect.toString();
      int i = this.VWU;
      int j = hashCode();
      Object localObject1;
      int k;
      label156:
      label235:
      boolean bool;
      if (paramRect.height() == 0)
      {
        localObject1 = Util.getStack();
        Log.i("MicroMsg.LauncherUI", "fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d stack:%s", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j), localObject1 });
        if (paramRect.top > 0) {
          this.VWU = paramRect.top;
        }
        if ((this.VWV != null) && ((this.VWV.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
        {
          localObject1 = (ViewGroup.MarginLayoutParams)this.VWV.getLayoutParams();
          j = ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
          k = ((ViewGroup.MarginLayoutParams)localObject1).rightMargin;
          Log.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          i = 0;
          if (i < getChildCount())
          {
            localObject2 = getChildAt(i);
            if (!(localObject2 instanceof TestTimeForChatting)) {
              break label490;
            }
            localObject2 = (TestTimeForChatting)localObject2;
            if ((Float.compare(j, com.tencent.mm.ci.a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 2.0F) <= 0) && (j >= 0)) {
              break label471;
            }
            Log.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", new Object[] { Integer.valueOf(j) });
            ((TestTimeForChatting)localObject2).XVl = 0;
            if ((Float.compare(k, com.tencent.mm.ci.a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 2.0F) <= 0) && (k >= 0)) {
              break label480;
            }
            Log.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", new Object[] { Integer.valueOf(j) });
            ((TestTimeForChatting)localObject2).XVm = 0;
            label286:
            Log.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          }
          ar.U(((ViewGroup.MarginLayoutParams)localObject1).leftMargin, ((ViewGroup.MarginLayoutParams)localObject1).topMargin, ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
        }
        this.mRect.set(paramRect);
        if (!com.tencent.mm.compatible.util.d.qV(14)) {
          break label504;
        }
        i = 0;
        label353:
        if (i >= getChildCount()) {
          break label504;
        }
        localObject1 = getChildAt(i);
        if (!(localObject1 instanceof TestTimeForChatting)) {
          break label497;
        }
        ((View)localObject1).setFitsSystemWindows(true);
        bool = ((TestTimeForChatting)localObject1).fitSystemWindows(paramRect);
        ((View)localObject1).setFitsSystemWindows(false);
      }
      for (;;)
      {
        Log.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(Build.VERSION.SDK_INT) });
        bool = super.fitSystemWindows(this.mRect);
        Log.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(33221);
        return bool;
        localObject1 = "pass";
        break;
        label471:
        ((TestTimeForChatting)localObject2).XVl = j;
        break label235;
        label480:
        ((TestTimeForChatting)localObject2).XVm = k;
        break label286;
        label490:
        i += 1;
        break label156;
        label497:
        i += 1;
        break label353;
        label504:
        bool = false;
      }
    }
    
    public int getCacheInsetsTop()
    {
      return this.VWU;
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(33222);
      try
      {
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(33222);
        return;
      }
      catch (ClassCastException localClassCastException)
      {
        Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localClassCastException, "", new Object[0]);
        Log.e("MicroMsg.LauncherUI.HomeUI", "my layout params %s %s", new Object[] { getLayoutParams(), getLayoutParams().getClass() });
        int j = getChildCount();
        int i = 0;
        View localView;
        while (i < j)
        {
          localView = getChildAt(i);
          Log.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", new Object[] { Integer.valueOf(i), localView, localView.getLayoutParams(), localView.getLayoutParams().getClass() });
          i += 1;
        }
        i = 0;
        while (i < j)
        {
          localView = getChildAt(i);
          if (((localView instanceof ImageView)) && (localView.getId() == R.h.dRm) && (localView.getLayoutParams() != null) && ((localView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (!(localView.getLayoutParams() instanceof FrameLayout.LayoutParams))) {
            localView.setLayoutParams(new FrameLayout.LayoutParams(localView.getLayoutParams()));
          }
          Log.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", new Object[] { Integer.valueOf(i), localView, localView.getLayoutParams(), localView.getLayoutParams().getClass() });
          i += 1;
        }
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(33222);
      }
    }
    
    public void setActionBarContainer(ViewGroup paramViewGroup)
    {
      this.VWV = paramViewGroup;
    }
  }
  
  final class b
    implements com.tencent.mm.plugin.newtips.a.a
  {
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(33227);
      this$1 = new ViewGroup.LayoutParams(paramInt1, paramInt2);
      HomeUI localHomeUI = HomeUI.this;
      com.tencent.mm.kiss.a.b.aIK();
      HomeUI.a(localHomeUI, com.tencent.mm.kiss.a.b.d(HomeUI.c(HomeUI.this), R.i.actionview_with_dot_tips));
      HomeUI.a(HomeUI.this, (ImageView)HomeUI.s(HomeUI.this).findViewById(R.h.icon));
      HomeUI.b(HomeUI.this, HomeUI.s(HomeUI.this).findViewById(R.h.tips));
      HomeUI.s(HomeUI.this).setLayoutParams(HomeUI.this);
      HomeUI.s(HomeUI.this).setMinimumHeight(paramInt2);
      HomeUI.s(HomeUI.this).setMinimumWidth(paramInt1);
      HomeUI.t(HomeUI.this).setImageResource(R.k.icons_outlined_add2);
      HomeUI.s(HomeUI.this).setContentDescription(HomeUI.this.getString(R.l.top_item_desc_more));
      HomeUI.s(HomeUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33224);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/HomeUI$PlusActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          com.tencent.mm.plugin.newtips.a.fiO().aap(3);
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10919, "0");
          HomeUI.u(HomeUI.this);
          if (HomeUI.VVV.booleanValue())
          {
            paramAnonymousView = HomeUI.this;
            localObject = Boolean.TRUE;
            HomeUI.a(paramAnonymousView, (Boolean)localObject, (Boolean)localObject);
          }
          if (HomeUI.VVW.booleanValue()) {
            HomeUI.a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
          }
          if (!WeChatEnvironment.isMonkeyEnv())
          {
            long l = Util.nowMilliSecond();
            if (l - HomeUI.v(HomeUI.this) <= 10000L) {
              break label190;
            }
            HomeUI.a(HomeUI.this, l);
            HomeUI.w(HomeUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$PlusActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33224);
            return;
            label190:
            HomeUI.x(HomeUI.this);
            if (HomeUI.y(HomeUI.this) >= 5)
            {
              Log.w("MicroMsg.LauncherUI.HomeUI", "Switch to MonkeyEnv now.");
              WeChatEnvironment.setMonkeyEnv(true);
            }
          }
        }
      });
      HomeUI.s(HomeUI.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33225);
          HomeUI.c(HomeUI.this).supportInvalidateOptionsMenu();
          AppMethodBeat.o(33225);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(33226);
          String str = super.toString() + "|supportInvalidateOptionsMenu";
          AppMethodBeat.o(33226);
          return str;
        }
      });
      AppMethodBeat.o(33227);
    }
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(293250);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(293250);
    }
    
    public final boolean a(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, erx paramerx)
    {
      return false;
    }
    
    public final boolean eQW()
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
    
    public final boolean tX(boolean paramBoolean)
    {
      AppMethodBeat.i(293251);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(293251);
      return paramBoolean;
    }
    
    public final boolean tY(boolean paramBoolean)
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
    
    public final boolean tZ(boolean paramBoolean)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI
 * JD-Core Version:    0.7.0.1
 */