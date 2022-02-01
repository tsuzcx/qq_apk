package com.tencent.mm.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.arch.lifecycle.ViewModelProvider;
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
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Pair;
import android.view.KeyEvent;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.t;
import com.tencent.mm.app.w;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.nw.a;
import com.tencent.mm.g.a.yp;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.multitask.ui.panel.MultiTaskContainerView;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.api.o;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.conversation.ConversationListView;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public class HomeUI
  implements com.tencent.mm.plugin.taskbar.api.a, LauncherUI.b, LauncherUI.c, LauncherUI.d
{
  public static Boolean OCE = Boolean.FALSE;
  public static Boolean OCF = Boolean.FALSE;
  private static boolean OCU = true;
  static final int OCW = 2131304628;
  static final int OCX = 2131304603;
  private View ARQ;
  View BdQ;
  IListener CWJ;
  private final long EKO;
  private long EKP;
  private boolean FUb;
  private String OCA;
  private String OCB;
  private String OCC;
  af OCD;
  private final long OCG;
  private final long OCH;
  private boolean OCI;
  private int OCJ;
  private int OCK;
  private int OCL;
  a OCM;
  LauncherUI.a OCN;
  i OCO;
  MainTabUI OCP;
  int OCQ;
  int OCR;
  private boolean OCS;
  boolean OCT;
  View.OnLayoutChangeListener OCV;
  b OCY;
  View OCZ;
  private final long OCt;
  private final long OCu;
  public boolean OCv;
  boolean OCw;
  public boolean OCx;
  private WeImageView OCy;
  private boolean OCz;
  ImageView ODa;
  private View ODb;
  ImageView ODc;
  View ODd;
  MenuItem ODe;
  MenuItem ODf;
  private MenuItem ODg;
  MenuItem ODh;
  Menu ODi;
  private boolean ODj;
  IListener ODk;
  Runnable ODl;
  private int ODm;
  private LinkedList<Runnable> ODn;
  com.tencent.mm.plugin.messenger.foundation.a.q ODo;
  private float ODp;
  private boolean ODq;
  private TextView OxL;
  boolean OxS;
  View Oyi;
  private int clickCount;
  View contentView;
  private String dVu;
  LayoutInflater kgB;
  private boolean kgv;
  ActionBar mActionBar;
  MessageQueue.IdleHandler pzA;
  MMFragmentActivity uLr;
  private final HashMap<String, Object> values;
  private TextView xXX;
  private long xsI;
  
  public HomeUI()
  {
    AppMethodBeat.i(33232);
    this.OCt = 604800000L;
    this.OCu = 86400000L;
    this.kgv = true;
    this.OCv = false;
    this.dVu = null;
    this.OCx = false;
    this.OxS = false;
    this.OCz = false;
    this.OCG = 432000000L;
    this.OCH = 604800000L;
    this.OCI = true;
    this.OCJ = 0;
    this.OCK = 0;
    this.OCL = 0;
    this.OCM = a.ODy;
    this.OCP = new MainTabUI();
    this.OCQ = 0;
    this.OCR = 0;
    this.OCS = false;
    this.OCT = true;
    this.OCV = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8) {}
    };
    this.FUb = LocaleUtil.isChineseAppLang();
    this.ODj = true;
    this.clickCount = 0;
    this.xsI = 0L;
    this.values = new HashMap();
    this.CWJ = new IListener() {};
    this.ODk = new IListener() {};
    this.pzA = new HomeUI.18(this);
    this.ODl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(232572);
        if (((com.tencent.mm.q.a.o(HomeUI.b(HomeUI.this), true)) && (!com.tencent.mm.q.a.cA(HomeUI.b(HomeUI.this)))) || (com.tencent.mm.q.a.r(HomeUI.b(HomeUI.this), true)))
        {
          AppMethodBeat.o(232572);
          return;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("BaseScanUI_select_scan_mode", 1);
        localIntent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
        localIntent.putExtra("key_enable_multi_code", true);
        localIntent.putExtra("key_scan_goods_enable_dynamic_wording", true);
        localIntent.putExtra("key_scan_entry_scene", 5);
        localIntent.setFlags(65536);
        com.tencent.mm.plugin.report.service.h.CyF.a(11409, new Object[0]);
        com.tencent.mm.br.c.b(HomeUI.b(HomeUI.this), "scanner", ".ui.BaseScanUI", localIntent);
        AppMethodBeat.o(232572);
      }
    };
    this.ODm = 0;
    this.EKO = 300L;
    this.EKP = SystemClock.elapsedRealtime();
    this.ODn = new LinkedList();
    this.ODo = new com.tencent.mm.plugin.messenger.foundation.a.q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, h.a paramAnonymousa)
      {
        AppMethodBeat.i(232581);
        if ((Util.nullAsNil(paramAnonymousString).equals("showprivacypolicy")) && (paramAnonymousMap != null))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.device_id");
          HomeUI.c(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_content"));
          HomeUI.a(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_ok"));
          HomeUI.b(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_cancel"));
          boolean bool1 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needbirthday"));
          boolean bool2 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needopenplatform"));
          boolean bool3 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needconfirm"));
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogv, Boolean.valueOf(bool1));
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogw, Boolean.valueOf(bool2));
          com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogx, Boolean.valueOf(bool3));
          paramAnonymousMap = com.tencent.mm.bw.b.cD(com.tencent.mm.compatible.deviceinfo.q.aoG().getBytes());
          paramAnonymousMap.aiU(16);
          paramAnonymousMap = Base64.encodeToString(paramAnonymousMap.toByteArray(), 2);
          Log.i("MicroMsg.LauncherUI.HomeUI", "deviceId:%s, localDeviceId:%s, doubleCheckContent:%s, doubleCheckOk:%s, doubleCheckCancel:%s, needBirthday:%s, needOpenPlatform:%s, needConfirm:%s", new Object[] { paramAnonymousString, paramAnonymousMap, HomeUI.F(HomeUI.this), HomeUI.E(HomeUI.this), HomeUI.G(HomeUI.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((Util.isNullOrNil(paramAnonymousString)) || (paramAnonymousString.equals(paramAnonymousMap)))
          {
            paramAnonymousString = com.tencent.mm.kernel.g.aAh().azQ().get(274436, "").toString();
            paramAnonymousMap = HomeUI.b(HomeUI.this);
            paramAnonymousa = LocaleUtil.getApplicationLanguage();
            int i;
            if (bool2)
            {
              i = 1;
              paramAnonymousMap = paramAnonymousMap.getString(2131762219, new Object[] { paramAnonymousa, paramAnonymousString, "login", Integer.valueOf(1), Integer.valueOf(i) });
              if (!com.tencent.mm.aw.b.Pi(paramAnonymousString)) {
                break label534;
              }
              Log.i("MicroMsg.LauncherUI.HomeUI", "eu true, needconfirm: %s", new Object[] { Boolean.valueOf(bool3) });
              if (bool3) {
                break label498;
              }
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("close_dialog_msg", HomeUI.F(HomeUI.this));
              paramAnonymousString.putString("close_dialog_cancel", HomeUI.G(HomeUI.this));
              paramAnonymousString.putString("close_dialog_ok", HomeUI.E(HomeUI.this));
              paramAnonymousString.putBoolean("close_dialog_ok_close", false);
              HomeUI.a(HomeUI.this, paramAnonymousMap, 22722, paramAnonymousString);
            }
            for (;;)
            {
              com.tencent.mm.ui.base.b.ke(HomeUI.b(HomeUI.this));
              AppMethodBeat.o(232581);
              return;
              i = 0;
              break;
              label498:
              HomeUI.a(HomeUI.this, paramAnonymousMap, 22722, HomeUI.b(HomeUI.this).getString(2131761411, new Object[] { LocaleUtil.getApplicationLanguage() }));
              continue;
              label534:
              Log.i("MicroMsg.LauncherUI.HomeUI", "eu false");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("close_dialog_msg", HomeUI.b(HomeUI.this).getString(2131762215));
              paramAnonymousString.putString("close_dialog_cancel", HomeUI.b(HomeUI.this).getString(2131762556));
              paramAnonymousString.putString("close_dialog_ok", HomeUI.b(HomeUI.this).getString(2131762218));
              paramAnonymousString.putBoolean("close_dialog_ok_close", false);
              HomeUI.a(HomeUI.this, paramAnonymousMap, 22722, paramAnonymousString);
            }
          }
          Log.i("MicroMsg.LauncherUI.HomeUI", "device id not match");
        }
        AppMethodBeat.o(232581);
      }
    };
    this.ODp = 0.0F;
    this.ODq = false;
    AppMethodBeat.o(33232);
  }
  
  private void Ba(final boolean paramBoolean)
  {
    AppMethodBeat.i(33235);
    if (this.ARQ != null)
    {
      Log.e("MicroMsg.LauncherUI.HomeUI", "tipsView already shown");
      AppMethodBeat.o(33235);
      return;
    }
    this.ARQ = View.inflate(MMApplicationContext.getContext(), 2131495851, null);
    Object localObject = (TextView)this.ARQ.findViewById(2131305373);
    if (paramBoolean) {
      ((TextView)localObject).setText(MMApplicationContext.getContext().getString(2131755157));
    }
    for (;;)
    {
      localObject = new FrameLayout.LayoutParams(-2, -2, 53);
      this.ARQ.setBackgroundResource(2131234326);
      if (this.contentView != null)
      {
        ((ViewGroup)this.contentView).addView(this.ARQ, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), 2130772156);
        this.ARQ.startAnimation((Animation)localObject);
        this.ARQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33179);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            HomeUI.m(HomeUI.this).iv();
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
      ((TextView)localObject).setText(MMApplicationContext.getContext().getString(2131755154));
    }
  }
  
  private void Bc(boolean paramBoolean)
  {
    AppMethodBeat.i(232585);
    if (((this.OCP.gIX() instanceof MainUI)) && (((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class)).isMultiTaskMode()))
    {
      i = 1;
      if ((i == 0) || (((com.tencent.mm.plugin.multitask.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.multitask.d.class)).isDataEmpty())) {
        break label143;
      }
    }
    label143:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (!paramBoolean)) {
        break label148;
      }
      localObject = (ImageView)this.mActionBar.getCustomView().findViewById(2131296449);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setAlpha(1.0F);
      this.mActionBar.getCustomView().setVisibility(0);
      localObject = com.tencent.mm.ui.component.a.PRN;
      ((MultiTaskUIC)com.tencent.mm.ui.component.a.b(this.uLr).get(MultiTaskUIC.class)).hx(true);
      AppMethodBeat.o(232585);
      return;
      i = 0;
      break;
    }
    label148:
    ((ImageView)this.mActionBar.getCustomView().findViewById(2131296449)).setVisibility(4);
    Object localObject = com.tencent.mm.ui.component.a.PRN;
    ((MultiTaskUIC)com.tencent.mm.ui.component.a.b(this.uLr).get(MultiTaskUIC.class)).hx(false);
    AppMethodBeat.o(232585);
  }
  
  private void Be(boolean paramBoolean)
  {
    AppMethodBeat.i(33249);
    View localView;
    int j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.uLr.getWindow().getDecorView();
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
  
  private void akO(int paramInt)
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
      if (Math.abs(this.ODm - i) >= 50000) {}
      try
      {
        this.uLr.getWindow().setStatusBarColor(i);
        this.ODm = i;
        AppMethodBeat.o(33248);
        return;
        i = paramInt;
        if (Build.VERSION.SDK_INT < 21) {
          continue;
        }
        i = ar.v(this.uLr.getResources().getColor(2131101173), paramInt);
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localNullPointerException, "updateStatusBar %s", new Object[] { Integer.valueOf(i) });
        }
      }
    }
  }
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(33236);
    if (this.ARQ != null)
    {
      this.ARQ.clearAnimation();
      this.ARQ.setVisibility(8);
      if (paramBoolean1.booleanValue())
      {
        if (!paramBoolean2.booleanValue()) {
          break label89;
        }
        bg.aVF();
        com.tencent.mm.model.c.azQ().set(340227, Boolean.TRUE);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(232L, 0L, 1L, false);
        OCE = Boolean.FALSE;
      }
    }
    for (;;)
    {
      this.ARQ = null;
      AppMethodBeat.o(33236);
      return;
      label89:
      bg.aVF();
      com.tencent.mm.model.c.azQ().set(340230, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(232L, 5L, 1L, false);
      OCF = Boolean.FALSE;
    }
  }
  
  private void gGB()
  {
    AppMethodBeat.i(33253);
    if (this.uLr != null) {}
    try
    {
      this.uLr.moveTaskToBack(true);
      if (bg.aAc()) {
        bg.aAk().postToWorkerDelayed(new HomeUI.26(this), 500L);
      }
      w.WE().start();
      AppMethodBeat.o(33253);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
      }
    }
  }
  
  private boolean gHQ()
  {
    return (this.OCJ == 3) && (this.OCK == 3);
  }
  
  private boolean gHR()
  {
    return (this.OCJ == 2) && (this.OCK == 2);
  }
  
  private static boolean gId()
  {
    AppMethodBeat.i(33260);
    if (!o.isShowStoryCheck())
    {
      AppMethodBeat.o(33260);
      return false;
    }
    if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(z.aTY()))
    {
      AppMethodBeat.o(33260);
      return true;
    }
    AppMethodBeat.o(33260);
    return false;
  }
  
  static boolean gIf()
  {
    AppMethodBeat.i(33264);
    boolean bool = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).getStoryNewFeatureConfig().fng();
    AppMethodBeat.o(33264);
    return bool;
  }
  
  static boolean gIg()
  {
    AppMethodBeat.i(33265);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.OnA, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(33265);
    return bool;
  }
  
  private void setActionBarColor(int paramInt)
  {
    AppMethodBeat.i(33256);
    if (this.mActionBar != null) {
      this.mActionBar.setBackgroundDrawable(new ColorDrawable(paramInt));
    }
    if (this.BdQ != null) {
      this.BdQ.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(33256);
  }
  
  @SuppressLint({"RestrictedApi"})
  private void updateTitle()
  {
    AppMethodBeat.i(33233);
    if (!this.OCI)
    {
      AppMethodBeat.o(33233);
      return;
    }
    int i = this.OCP.acm;
    Object localObject1 = getString(2131755908);
    Object localObject2;
    if (i == 0) {
      if (this.FUb)
      {
        localObject1 = localObject1 + com.tencent.mm.cc.h.jr(this.uLr);
        localObject2 = localObject1;
        if (this.OCP.OHZ.gJh() > 0)
        {
          localObject2 = localObject1;
          if (!this.FUb) {
            localObject2 = localObject1 + " ";
          }
          localObject2 = localObject2 + "(" + this.OCP.OHZ.gJh() + ")";
        }
        localObject1 = new yp();
        ((yp)localObject1).eeQ.eeR = 1;
        ((yp)localObject1).eeQ.title = ((CharSequence)localObject2).toString();
        EventCenter.instance.publish((IEvent)localObject1);
        localObject1 = localObject2;
      }
    }
    label214:
    label989:
    label1013:
    for (;;)
    {
      if (i == 3)
      {
        akO(this.uLr.getResources().getColor(2131101287));
        if (gId())
        {
          Be(true);
          label247:
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).checkPost();
          if (this.mActionBar != null)
          {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.uLr.getResources().getColor(2131101287)));
            this.mActionBar.getCustomView().setVisibility(8);
          }
          if (this.BdQ != null) {
            this.BdQ.setBackgroundColor(this.uLr.getResources().getColor(2131101287));
          }
          this.ODj = false;
          if ((gHQ()) && (this.ODh != null) && (!this.ODh.isVisible())) {
            this.ODh.setVisible(true);
          }
          Log.i("MicroMsg.LauncherUI.HomeUI", "alvinluo updateSettingTitle");
          this.mActionBar.setElevation(0.0F);
          this.mActionBar.gy();
          this.xXX = ((TextView)this.mActionBar.getCustomView().findViewById(16908308));
          this.OCy = ((WeImageView)this.mActionBar.getCustomView().findViewById(2131302348));
          if (this.OCy != null) {
            this.OCy.setVisibility(8);
          }
          if (this.xXX != null)
          {
            this.xXX.setText((CharSequence)localObject1);
            if (i != 0) {
              break label989;
            }
            ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).setTextWithStatus(this.xXX, com.tencent.mm.plugin.auth.a.a.ceA(), a.b.FXm, a.c.FXp);
          }
        }
      }
      for (;;)
      {
        boolean bool = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
        if ((this.OCy != null) && (bool) && (i == 0)) {
          this.OCy.setVisibility(0);
        }
        if (gHQ()) {
          this.xXX.setVisibility(8);
        }
        float f = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131165186) * com.tencent.mm.cb.a.ji(MMApplicationContext.getContext());
        if (this.xXX.getTextSize() != f) {
          this.xXX.setTextSize(0, f);
        }
        i = this.uLr.getResources().getColor(2131099904);
        if ((this.OxS) && (this.xXX.getCurrentTextColor() != i)) {
          this.xXX.setTextColor(i);
        }
        ao.a(this.xXX.getPaint(), 0.8F);
        Bc(true);
        AppMethodBeat.o(33233);
        return;
        localObject1 = localObject1 + " " + com.tencent.mm.cc.h.jr(this.uLr);
        break;
        if (i == 1)
        {
          localObject1 = getString(2131762819);
          break label214;
        }
        if (i == 2)
        {
          localObject1 = getString(2131762817);
          break label214;
        }
        if (i != 3) {
          break label1013;
        }
        localObject1 = getString(2131762857);
        break label214;
        Be(false);
        break label247;
        akO(this.uLr.getResources().getColor(2131100898));
        Be(this.OxS);
        localObject2 = this.mActionBar.getCustomView().getBackground();
        if ((localObject2 instanceof ColorDrawable)) {
          if (((ColorDrawable)localObject2).getColor() != this.uLr.getResources().getColor(2131100898)) {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.uLr.getResources().getColor(2131100898)));
          }
        }
        for (;;)
        {
          if (this.mActionBar.getCustomView().getVisibility() != 0) {
            this.mActionBar.getCustomView().setVisibility(0);
          }
          this.ODj = true;
          if ((gHR()) && (this.ODe != null) && (!this.ODe.isVisible())) {
            this.ODe.setVisible(true);
          }
          if ((!gHR()) || (this.ODf == null) || (this.ODf.isVisible())) {
            break;
          }
          this.ODf.setVisible(true);
          break;
          this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.uLr.getResources().getColor(2131100898)));
        }
        ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).clearTextStatus(this.xXX, com.tencent.mm.plugin.auth.a.a.ceA());
      }
    }
  }
  
  private static void y(View paramView, boolean paramBoolean)
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
      paramView.setBackgroundResource(2131101287);
    }
    AppMethodBeat.o(33263);
  }
  
  final void Bb(boolean paramBoolean)
  {
    AppMethodBeat.i(33238);
    if ((this.OCD == null) || (this.OCZ == null) || (this.OCY == null))
    {
      AppMethodBeat.o(33238);
      return;
    }
    if (!bg.aAc())
    {
      Log.w("MicroMsg.LauncherUI.HomeUI", "want update more menu new tips, but mmcore not ready");
      AppMethodBeat.o(33238);
      return;
    }
    this.OCD.OKi.Bs(paramBoolean);
    Object localObject = this.OCY;
    if (com.tencent.mm.plugin.newtips.a.g.a(((b)localObject).ODr.OCD.OKi.gCH(), (com.tencent.mm.plugin.newtips.a.a)localObject))
    {
      localObject = new yp();
      ((yp)localObject).eeQ.eeR = 2;
      ((yp)localObject).eeQ.eeS = this.OCD.OKi.gCH();
      ((yp)localObject).eeQ.eeT = false;
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(33238);
      return;
    }
    if (((b)localObject).ODr.OCD.OKi.gCH()) {
      ((b)localObject).ODr.ODb.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject, com.tencent.mm.plugin.newtips.a.k.ADG, ((b)localObject).ODr.OCD.OKi.gCH());
      break;
      ((b)localObject).ODr.ODb.setVisibility(8);
    }
  }
  
  public final void Bd(boolean paramBoolean)
  {
    AppMethodBeat.i(33246);
    if (!paramBoolean) {
      initActionBar();
    }
    this.uLr.supportInvalidateOptionsMenu();
    if (z.aUQ().booleanValue()) {
      gHS();
    }
    this.OCP.gJa();
    AppMethodBeat.o(33246);
  }
  
  public final void Bf(boolean paramBoolean)
  {
    AppMethodBeat.i(33262);
    if ((this.ODh != null) && (this.ODh.getActionView() != null) && (this.uLr != null))
    {
      if (this.uLr.getResources().getConfiguration().orientation == 2)
      {
        this.ODh.setVisible(false);
        this.ODh.setEnabled(false);
        AppMethodBeat.o(33262);
        return;
      }
      this.ODh.setVisible(true);
      this.ODh.setEnabled(true);
      ImageView localImageView = (ImageView)this.ODh.getActionView().findViewById(2131302468);
      localImageView.setImageDrawable(this.uLr.getResources().getDrawable(2131690501));
      if ((paramBoolean) || (ao.isDarkMode())) {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      }
      while (this.OCT)
      {
        this.ODh.getActionView().findViewById(2131309167).setVisibility(0);
        AppMethodBeat.o(33262);
        return;
        localImageView.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
      }
      this.ODh.getActionView().findViewById(2131309167).setVisibility(8);
    }
    AppMethodBeat.o(33262);
  }
  
  public final void Fg(boolean paramBoolean)
  {
    AppMethodBeat.i(258262);
    Log.i("MicroMsg.LauncherUI.HomeUI", "alvinluo updateStatusBar show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Resources localResources = this.uLr.getResources();
    if (paramBoolean) {}
    for (int i = 2131100898;; i = 2131101287)
    {
      akO(localResources.getColor(i));
      AppMethodBeat.o(258262);
      return;
    }
  }
  
  public final void a(FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33245);
    this.uLr.getWindow().getDecorView().getBottom();
    this.uLr.getSupportActionBar().getCustomView().getBottom();
    paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
    paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
    AppMethodBeat.o(33245);
  }
  
  public final void aI(Runnable paramRunnable)
  {
    AppMethodBeat.i(33251);
    this.ODn.remove(paramRunnable);
    AppMethodBeat.o(33251);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33252);
    Log.i("MicroMsg.LauncherUI.HomeUI", "ui group onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    com.tencent.mm.compatible.b.g.anG();
    com.tencent.mm.compatible.b.g.anG();
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.OCD != null) && (this.OCD.isShowing()))
    {
      this.OCD.dismiss();
      AppMethodBeat.o(33252);
      return true;
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      gHT();
      AppMethodBeat.o(33252);
      return true;
    }
    Object localObject1 = this.OCP.gIX();
    if ((localObject1 != null) && (((MMFragment)localObject1).onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(33252);
      return true;
    }
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      if ((bg.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY) && (NetStatusUtil.isWap(this.uLr)))
      {
        Object localObject2 = this.uLr;
        paramKeyEvent = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33199);
            HomeUI.D(HomeUI.this);
            AppMethodBeat.o(33199);
          }
        };
        if (!bg.aAc()) {
          i = 0;
        }
        while (i != 0)
        {
          AppMethodBeat.o(33252);
          return true;
          bg.aVF();
          i = ((Integer)com.tencent.mm.model.c.azQ().get(65, Integer.valueOf(0))).intValue();
          if (i >= 5)
          {
            i = 0;
          }
          else if (!MMEntryLock.lock("show_wap_adviser"))
          {
            i = 0;
          }
          else
          {
            localObject1 = View.inflate((Context)localObject2, 2131495843, null);
            ((TextView)((View)localObject1).findViewById(2131305273)).setText(2131763517);
            localObject2 = new d.a((Context)localObject2);
            ((d.a)localObject2).aoO(2131755998);
            ((d.a)localObject2).hs((View)localObject1);
            ((d.a)localObject2).aoV(2131755921).c(new MMAppMgr.1(i));
            ((d.a)localObject2).Dk(false);
            ((d.a)localObject2).aoW(2131763511).d(new MMAppMgr.7());
            ((d.a)localObject2).a(new MMAppMgr.8(paramKeyEvent));
            ((d.a)localObject2).hbn().show();
            i = 1;
          }
        }
      }
      final int i = NetStatusUtil.getBackgroundLimitType(this.uLr);
      if ((bg.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY) && (NetStatusUtil.isLimited(i)))
      {
        bg.aVF();
        if ((Util.nullAsTrue((Boolean)com.tencent.mm.model.c.azQ().get(16385, null))) && (MMAppMgr.a(this.uLr, i, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33202);
            try
            {
              NetStatusUtil.startSettingItent(HomeUI.b(HomeUI.this), i);
              AppMethodBeat.o(33202);
              return;
            }
            catch (Exception paramAnonymousDialogInterface)
            {
              Log.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", paramAnonymousDialogInterface, "", new Object[0]);
              AppMethodBeat.o(33202);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33203);
            HomeUI.D(HomeUI.this);
            AppMethodBeat.o(33203);
          }
        })))
        {
          AppMethodBeat.o(33252);
          return true;
        }
      }
      gGB();
    }
    AppMethodBeat.o(33252);
    return false;
  }
  
  public final void f(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33257);
    MMFragment localMMFragment = getMainTabUI().gIX();
    if (localMMFragment != null)
    {
      if ((localMMFragment instanceof MoreTabUI))
      {
        setActionBarColor(this.uLr.getResources().getColor(2131101287));
        AppMethodBeat.o(33257);
        return;
      }
      if (!(localMMFragment instanceof MainUI)) {
        setActionBarColor(this.uLr.getResources().getColor(2131100898));
      }
      while (paramInt2 > 10)
      {
        y(this.Oyi, false);
        y(this.OCZ, false);
        AppMethodBeat.o(33257);
        return;
        setActionBarColor(paramInt1);
      }
      y(this.Oyi, true);
      y(this.OCZ, true);
    }
    AppMethodBeat.o(33257);
  }
  
  public final void g(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33258);
    if ((paramInt1 != 0) && (this.xXX != null)) {
      this.xXX.setTextColor(paramInt1);
    }
    if (this.ODc != null)
    {
      if (this.ODq) {
        this.ODc.setAlpha(paramFloat);
      }
      this.ODc.setImageDrawable(ar.m(this.uLr, 2131689496, paramInt2));
    }
    if (this.ODa != null)
    {
      if (this.ODq) {
        this.ODa.setAlpha(paramFloat);
      }
      this.ODa.setImageDrawable(ar.m(this.uLr, 2131690728, paramInt2));
    }
    AppMethodBeat.o(33258);
  }
  
  public final void gHP()
  {
    AppMethodBeat.i(232584);
    Object localObject = this.OCP;
    boolean bool = this.OCv;
    Log.v("MicroMsg.LauncherUI.MainTabUI", "doOnPause %d, mainTabHasCreate:%b", new Object[] { Integer.valueOf(((MainTabUI)localObject).acm), Boolean.valueOf(bool) });
    if (bool) {
      ((MainTabUI)localObject).gIZ();
    }
    localObject = ((MainTabUI)localObject).OHZ;
    if (bg.aAc())
    {
      bg.aVF();
      com.tencent.mm.model.c.azQ().remove(((ab)localObject).OIt);
      bg.aVF();
      com.tencent.mm.model.c.aST().remove((MStorageEx.IOnStorageChange)localObject);
      com.tencent.mm.y.c.axV().b(((ab)localObject).OIs);
      EventCenter.instance.removeListener(((ab)localObject).OIu);
      EventCenter.instance.removeListener(((ab)localObject).OAR);
      EventCenter.instance.removeListener(((ab)localObject).OAQ);
    }
    if (((ab)localObject).OIr != null)
    {
      ((ab)localObject).OIr.OIo = null;
      ((ab)localObject).OIr = null;
    }
    localObject = this.OCO;
    if (((i)localObject).OCb != null)
    {
      bg.azz().b(255, ((i)localObject).OCb);
      bg.azz().b(384, ((i)localObject).OCb);
      ((i)localObject).OCb = null;
    }
    CrashReportFactory.setForeground(false);
    this.OCM = a.ODA;
    if (!bg.aVy()) {
      bg.getNotification().dh(false);
    }
    bool = this.OCN.gIx();
    Log.i("MicroMsg.LauncherUI.HomeUI", "edw onPause, chatting is show ".concat(String.valueOf(bool)));
    if (!bool) {
      k.a(this.uLr, 4, this.OCP.acm, "directReport_onPause");
    }
    if (!this.uLr.isFinishing()) {
      com.tencent.mm.ui.widget.h.a(this.uLr);
    }
    if (this.OCv)
    {
      Log.d("MicroMsg.LauncherUI.HomeUI", "KEVIN MainTabUI onMainTabPause");
      com.tencent.mm.blink.b.ake().akg();
      if (bg.aAc()) {
        EventCenter.instance.removeListener(this.CWJ);
      }
    }
    if ((this.OCD != null) && (this.OCD.isShowing())) {
      this.OCD.dismiss();
    }
    AppMethodBeat.o(232584);
  }
  
  final void gHS()
  {
    AppMethodBeat.i(33234);
    if (!bg.aAc())
    {
      Log.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready");
      AppMethodBeat.o(33234);
      return;
    }
    bg.aVF();
    Boolean localBoolean = Boolean.valueOf(Util.nullAsFalse((Boolean)com.tencent.mm.model.c.azQ().get(340227, null)));
    if ((!localBoolean.booleanValue()) && (!l.PVD.booleanValue()))
    {
      OCE = Boolean.TRUE;
      Ba(true);
    }
    long l1 = System.currentTimeMillis();
    bg.aVF();
    long l2 = Util.nullAs((Long)com.tencent.mm.model.c.azQ().get(340240, null), 0L);
    bg.aVF();
    boolean bool1 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.azQ().get(340230, null));
    bg.aVF();
    boolean bool2 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.azQ().get(340228, null));
    bg.aVF();
    boolean bool3 = Util.nullAsFalse((Boolean)com.tencent.mm.model.c.azQ().get(340229, null));
    if ((localBoolean.booleanValue()) && (Boolean.valueOf(bool2).booleanValue()) && (Boolean.valueOf(bool3).booleanValue()) && (!Boolean.valueOf(bool1).booleanValue()) && (l1 - l2 >= 432000000L))
    {
      OCF = Boolean.TRUE;
      Ba(false);
    }
    AppMethodBeat.o(33234);
  }
  
  final void gHT()
  {
    AppMethodBeat.i(33237);
    if ((this.OCD == null) || (!bg.aAc()))
    {
      AppMethodBeat.o(33237);
      return;
    }
    if (this.OCD.isShowing())
    {
      this.OCD.dismiss();
      AppMethodBeat.o(33237);
      return;
    }
    this.OCD.iv();
    AppMethodBeat.o(33237);
  }
  
  final void gHU()
  {
    AppMethodBeat.i(33239);
    int i;
    if (this.ODh != null)
    {
      this.ODh.setShowAsAction(2);
      if (this.ODj) {
        break label254;
      }
      if (!(this.OCP.gIX() instanceof MoreTabUI)) {
        break label249;
      }
      MoreTabUI localMoreTabUI = (MoreTabUI)this.OCP.gIX();
      if ((localMoreTabUI.OIC != null) && (localMoreTabUI.OIC.isVisible))
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
        this.ODh.setVisible(true);
      }
    }
    else
    {
      label94:
      if (this.ODf != null)
      {
        if (!this.ODj) {
          break label279;
        }
        this.ODf.setShowAsAction(2);
        this.ODf.setVisible(true);
        if (this.xXX != null) {
          this.xXX.setVisibility(0);
        }
      }
      label144:
      if (this.ODe != null)
      {
        if (!this.ODj) {
          break label320;
        }
        this.ODe.setShowAsAction(2);
        this.ODe.setVisible(true);
        if (this.xXX != null) {
          this.xXX.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (this.ODg != null)
      {
        if (!this.ODj)
        {
          this.ODg.setShowAsAction(2);
          this.ODg.setVisible(true);
          this.OxL.setVisibility(0);
          AppMethodBeat.o(33239);
          return;
          i = 0;
          break;
          label249:
          i = 0;
          break label79;
          label254:
          this.ODh.setVisible(false);
          this.ODh.setEnabled(false);
          break label94;
          label279:
          this.ODf.setVisible(false);
          this.ODf.setEnabled(false);
          if (this.xXX == null) {
            break label144;
          }
          this.xXX.setVisibility(8);
          break label144;
          label320:
          this.ODe.setVisible(false);
          this.ODe.setEnabled(false);
          if (this.xXX == null) {
            continue;
          }
          this.xXX.setVisibility(8);
          continue;
        }
        this.ODg.setVisible(false);
        this.ODg.setEnabled(false);
        this.OxL.setVisibility(8);
      }
    }
    AppMethodBeat.o(33239);
  }
  
  final void gHV()
  {
    AppMethodBeat.i(33240);
    int i = this.OCP.acm;
    if (i == 0) {
      getMainTabUI().gIX();
    }
    Intent localIntent = new Intent().putExtra("from_tab_index", i).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = localObject2;
      if (!ao.isDarkMode())
      {
        localObject1 = localObject2;
        if (com.tencent.mm.compatible.util.d.oE(30)) {
          localObject1 = ActivityOptions.makeSceneTransitionAnimation(this.uLr, new Pair[0]).toBundle();
        }
      }
    }
    com.tencent.mm.plugin.fts.a.d.b(this.uLr, ".ui.FTSMainUI", localIntent, (Bundle)localObject1);
    AppMethodBeat.o(33240);
  }
  
  final void gHW()
  {
    AppMethodBeat.i(33242);
    if ((gIf()) && (gIg())) {
      this.OCT = false;
    }
    if (gIf()) {
      com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.OnA, Boolean.FALSE);
    }
    if (this.ODd != null)
    {
      this.ODd.findViewById(2131309167).setVisibility(8);
      localObject = com.tencent.mm.plugin.story.h.h.FuH;
      com.tencent.mm.plugin.story.h.h.Kt(0L);
    }
    if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).canPostStory())
    {
      com.tencent.mm.kernel.g.aAi();
      int i = ((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Oir, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.h.c(this.uLr, "", this.uLr.getResources().getString(2131766549, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(33242);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class);
    MMFragmentActivity localMMFragmentActivity = this.uLr;
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.FuH;
    ((com.tencent.mm.plugin.story.api.e)localObject).startStoryCaptureForResult(localMMFragmentActivity, 0, com.tencent.mm.plugin.story.h.h.fqA(), 10);
    AppMethodBeat.o(33242);
  }
  
  public final void gHX()
  {
    AppMethodBeat.i(33243);
    if ((z.aUQ().booleanValue()) && ((OCE.booleanValue()) || (OCF.booleanValue())))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    if (!ao.gJK()) {
      this.OCP.gHX();
    }
    AppMethodBeat.o(33243);
  }
  
  public final void gHY()
  {
    AppMethodBeat.i(33244);
    bg.aAk().setLowestPriority();
    this.OCP.gJb();
    MMHandlerThread.postToMainThread(this.ODl);
    AppMethodBeat.o(33244);
  }
  
  public final boolean gHZ()
  {
    return this.OCM == a.ODz;
  }
  
  public final void gIa()
  {
    AppMethodBeat.i(33254);
    updateTitle();
    AppMethodBeat.o(33254);
  }
  
  public final void gIb()
  {
    AppMethodBeat.i(33255);
    this.OCP.gIb();
    AppMethodBeat.o(33255);
  }
  
  public final void gIc()
  {
    AppMethodBeat.i(33259);
    this.OCP.alb(170);
    AppMethodBeat.o(33259);
  }
  
  final void gIe()
  {
    AppMethodBeat.i(33261);
    if ((this.ODh != null) && (this.ODh.getActionView() != null))
    {
      ImageView localImageView = (ImageView)this.ODh.getActionView().findViewById(2131302468);
      localImageView.setImageDrawable(this.uLr.getResources().getDrawable(2131690501));
      if (gId())
      {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        if (!this.OCT) {
          break label169;
        }
        if ((!gIf()) || (!gIg())) {
          break label164;
        }
      }
      label164:
      for (boolean bool = true;; bool = false)
      {
        this.OCT = bool;
        this.ODh.getActionView().findViewById(2131309167).setVisibility(0);
        AppMethodBeat.o(33261);
        return;
        localImageView.setColorFilter(new PorterDuffColorFilter(this.uLr.getResources().getColor(2131099669), PorterDuff.Mode.SRC_ATOP));
        break;
      }
      label169:
      this.ODh.getActionView().findViewById(2131309167).setVisibility(8);
    }
    AppMethodBeat.o(33261);
  }
  
  public MainTabUI getMainTabUI()
  {
    return this.OCP;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(33241);
    String str = this.uLr.getString(paramInt);
    AppMethodBeat.o(33241);
    return str;
  }
  
  final void initActionBar()
  {
    AppMethodBeat.i(33247);
    if (this.OCN.gIx())
    {
      Log.w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground True!");
      AppMethodBeat.o(33247);
      return;
    }
    this.OxS = ao.isDarkMode();
    this.mActionBar.setLogo(new ColorDrawable(this.uLr.getResources().getColor(17170445)));
    this.mActionBar.gt();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.gs();
    this.mActionBar.gu();
    this.mActionBar.setCustomView(aa.jQ(this.uLr).inflate(2131492948, new LinearLayout(this.uLr), false));
    ImageView localImageView = (ImageView)this.mActionBar.getCustomView().findViewById(2131296449);
    if (localImageView != null) {
      localImageView.getDrawable().setColorFilter(this.uLr.getResources().getColor(2131099746), PorterDuff.Mode.SRC_ATOP);
    }
    localImageView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232573);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = com.tencent.mm.ui.component.a.PRN;
        paramAnonymousView = (MultiTaskUIC)com.tencent.mm.ui.component.a.b(HomeUI.i(HomeUI.this)).get(MultiTaskUIC.class);
        Log.i(MultiTaskUIC.TAG, "showPanel, smoothScrool:true");
        paramAnonymousView.AfG = 2;
        paramAnonymousView.erT();
        localObject = paramAnonymousView.AfM;
        if (localObject != null) {
          ((MultiTaskContainerView)localObject).RT(0);
        }
        paramAnonymousView = paramAnonymousView.AfC;
        if (paramAnonymousView != null) {
          paramAnonymousView.setCurrentItem(0, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(232573);
      }
    });
    this.mActionBar.setBackgroundDrawable(ar.m(this.uLr, 2131100229, this.uLr.getResources().getColor(2131099669)));
    updateTitle();
    this.mActionBar.getCustomView().findViewById(2131296446).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232574);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (SystemClock.elapsedRealtime() - HomeUI.B(HomeUI.this) < 300L)
        {
          paramAnonymousView = HomeUI.C(HomeUI.this).iterator();
          while (paramAnonymousView.hasNext()) {
            ((Runnable)paramAnonymousView.next()).run();
          }
        }
        HomeUI.b(HomeUI.this, SystemClock.elapsedRealtime());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$28", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(232574);
      }
    });
    AppMethodBeat.o(33247);
  }
  
  public final void setTitleBarDoubleClickListener(Runnable paramRunnable)
  {
    AppMethodBeat.i(33250);
    if (!this.ODn.contains(paramRunnable)) {
      this.ODn.add(paramRunnable);
    }
    AppMethodBeat.o(33250);
  }
  
  public static class FitSystemWindowLayoutView
    extends FrameLayout
  {
    private int ODC;
    private ViewGroup ODD;
    private Rect mRect;
    
    public FitSystemWindowLayoutView(Context paramContext)
    {
      super();
      AppMethodBeat.i(33220);
      this.mRect = new Rect();
      this.ODD = null;
      AppMethodBeat.o(33220);
    }
    
    public FitSystemWindowLayoutView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(33219);
      this.mRect = new Rect();
      this.ODD = null;
      AppMethodBeat.o(33219);
    }
    
    @TargetApi(14)
    public boolean fitSystemWindows(Rect paramRect)
    {
      AppMethodBeat.i(33221);
      Object localObject2 = paramRect.toString();
      int i = this.ODC;
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
          this.ODC = paramRect.top;
        }
        if ((this.ODD != null) && ((this.ODD.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
        {
          localObject1 = (ViewGroup.MarginLayoutParams)this.ODD.getLayoutParams();
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
            if ((Float.compare(j, com.tencent.mm.cb.a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 2.0F) <= 0) && (j >= 0)) {
              break label471;
            }
            Log.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", new Object[] { Integer.valueOf(j) });
            ((TestTimeForChatting)localObject2).Qxf = 0;
            if ((Float.compare(k, com.tencent.mm.cb.a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 2.0F) <= 0) && (k >= 0)) {
              break label480;
            }
            Log.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", new Object[] { Integer.valueOf(j) });
            ((TestTimeForChatting)localObject2).Qxg = 0;
            label286:
            Log.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          }
          ao.P(((ViewGroup.MarginLayoutParams)localObject1).leftMargin, ((ViewGroup.MarginLayoutParams)localObject1).topMargin, ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
        }
        this.mRect.set(paramRect);
        if (!com.tencent.mm.compatible.util.d.oD(14)) {
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
        ((TestTimeForChatting)localObject2).Qxf = j;
        break label235;
        label480:
        ((TestTimeForChatting)localObject2).Qxg = k;
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
      return this.ODC;
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
          if (((localView instanceof ImageView)) && (localView.getId() == 2131306100) && (localView.getLayoutParams() != null) && ((localView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (!(localView.getLayoutParams() instanceof FrameLayout.LayoutParams))) {
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
      this.ODD = paramViewGroup;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(33218);
      ODy = new a("ACTIVITY_CREATE", 0);
      ODz = new a("ACTIVITY_RESUME", 1);
      ODA = new a("ACTIVITY_PAUSE", 2);
      ODB = new a[] { ODy, ODz, ODA };
      AppMethodBeat.o(33218);
    }
    
    private a() {}
  }
  
  final class b
    implements com.tencent.mm.plugin.newtips.a.a
  {
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(33227);
      this$1 = new ViewGroup.LayoutParams(paramInt1, paramInt2);
      HomeUI localHomeUI = HomeUI.this;
      com.tencent.mm.kiss.a.b.aBh();
      HomeUI.a(localHomeUI, com.tencent.mm.kiss.a.b.c(HomeUI.b(HomeUI.this), 2131492950));
      HomeUI.a(HomeUI.this, (ImageView)HomeUI.r(HomeUI.this).findViewById(2131302468));
      HomeUI.b(HomeUI.this, HomeUI.r(HomeUI.this).findViewById(2131309167));
      HomeUI.r(HomeUI.this).setLayoutParams(HomeUI.this);
      HomeUI.r(HomeUI.this).setMinimumHeight(paramInt2);
      HomeUI.r(HomeUI.this).setMinimumWidth(paramInt1);
      HomeUI.s(HomeUI.this).setImageResource(2131690728);
      HomeUI.r(HomeUI.this).setContentDescription(HomeUI.this.getString(2131766795));
      HomeUI.r(HomeUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33224);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$PlusActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          com.tencent.mm.plugin.newtips.a.exl().TC(3);
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(10919, "0");
          HomeUI.t(HomeUI.this);
          if (HomeUI.OCE.booleanValue())
          {
            paramAnonymousView = HomeUI.this;
            localObject = Boolean.TRUE;
            HomeUI.a(paramAnonymousView, (Boolean)localObject, (Boolean)localObject);
          }
          if (HomeUI.OCF.booleanValue()) {
            HomeUI.a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
          }
          if (!WeChatEnvironment.isMonkeyEnv())
          {
            long l = Util.nowMilliSecond();
            if (l - HomeUI.u(HomeUI.this) <= 10000L) {
              break label190;
            }
            HomeUI.a(HomeUI.this, l);
            HomeUI.v(HomeUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$PlusActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33224);
            return;
            label190:
            HomeUI.w(HomeUI.this);
            if (HomeUI.x(HomeUI.this) >= 5)
            {
              Log.w("MicroMsg.LauncherUI.HomeUI", "Switch to MonkeyEnv now.");
              WeChatEnvironment.setMonkeyEnv(true);
            }
          }
        }
      });
      HomeUI.r(HomeUI.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(33225);
          HomeUI.b(HomeUI.this).supportInvalidateOptionsMenu();
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
    
    public final void a(com.tencent.mm.plugin.newtips.a.k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(258260);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(258260);
    }
    
    public final boolean a(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, ehv paramehv)
    {
      return false;
    }
    
    public final boolean ehp()
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
      View localView = HomeUI.r(HomeUI.this);
      AppMethodBeat.o(33228);
      return localView;
    }
    
    public final boolean qV(boolean paramBoolean)
    {
      AppMethodBeat.i(258261);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(258261);
      return paramBoolean;
    }
    
    public final boolean qW(boolean paramBoolean)
    {
      AppMethodBeat.i(33231);
      if (paramBoolean) {
        HomeUI.y(HomeUI.this).setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33231);
        return true;
        HomeUI.y(HomeUI.this).setVisibility(8);
      }
    }
    
    public final boolean qX(boolean paramBoolean)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI
 * JD-Core Version:    0.7.0.1
 */