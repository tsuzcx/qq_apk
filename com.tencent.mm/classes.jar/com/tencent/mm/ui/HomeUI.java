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
import android.os.Debug;
import android.os.Looper;
import android.os.MessageQueue;
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
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.app.w;
import com.tencent.mm.av.p;
import com.tencent.mm.av.p.c;
import com.tencent.mm.blink.FirstScreenFrameLayout.a;
import com.tencent.mm.booter.y;
import com.tencent.mm.booter.y.1;
import com.tencent.mm.g.a.dc;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.protocal.protobuf.dnz;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.conversation.ConversationListView;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public class HomeUI
  implements com.tencent.mm.plugin.appbrand.widget.header.a, LauncherUI.b, LauncherUI.c, LauncherUI.d
{
  private static boolean JsE = true;
  static final int JsG = 2131302248;
  static final int JsH = 2131302237;
  public static Boolean Jso = Boolean.FALSE;
  public static Boolean Jsp = Boolean.FALSE;
  private final long ABq;
  private long ABr;
  private TextView JnR;
  boolean JnY;
  View Joo;
  MMFragmentActivity JrI;
  int JsA;
  int JsB;
  private boolean JsC;
  boolean JsD;
  View.OnLayoutChangeListener JsF;
  b JsI;
  View JsJ;
  ImageView JsK;
  private View JsL;
  ImageView JsM;
  View JsN;
  MenuItem JsO;
  MenuItem JsP;
  private MenuItem JsQ;
  MenuItem JsR;
  Menu JsS;
  private boolean JsT;
  Runnable JsU;
  private int JsV;
  private LinkedList<Runnable> JsW;
  com.tencent.mm.plugin.messenger.foundation.a.q JsX;
  private float JsY;
  private boolean JsZ;
  private final long Jsd;
  private final long Jse;
  public boolean Jsf;
  boolean Jsg;
  public boolean Jsh;
  private TextView Jsi;
  private boolean Jsj;
  private String Jsk;
  private String Jsl;
  private String Jsm;
  ae Jsn;
  private final long Jsq;
  private final long Jsr;
  private boolean Jss;
  private int Jst;
  private int Jsu;
  private int Jsv;
  a Jsw;
  LauncherUI.a Jsx;
  h Jsy;
  MainTabUI Jsz;
  private int clickCount;
  View contentView;
  private String dDG;
  private boolean jit;
  LayoutInflater jiz;
  ActionBar mActionBar;
  private boolean nbr;
  MessageQueue.IdleHandler omO;
  private long ubu;
  private final HashMap<String, Object> values;
  private View wVN;
  View xgg;
  com.tencent.mm.sdk.b.c yRT;
  
  public HomeUI()
  {
    AppMethodBeat.i(33232);
    this.Jsd = 604800000L;
    this.Jse = 86400000L;
    this.jit = true;
    this.Jsf = false;
    this.dDG = null;
    this.Jsh = false;
    this.JnY = false;
    this.Jsj = false;
    this.Jsq = 432000000L;
    this.Jsr = 604800000L;
    this.Jss = true;
    this.Jst = 0;
    this.Jsu = 0;
    this.Jsv = 0;
    this.Jsw = a.Jtf;
    this.Jsz = new MainTabUI();
    this.JsA = 0;
    this.JsB = 0;
    this.JsC = false;
    this.JsD = true;
    this.JsF = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8) {}
    };
    this.nbr = com.tencent.mm.sdk.platformtools.ad.foi();
    this.JsT = true;
    this.clickCount = 0;
    this.ubu = 0L;
    this.values = new HashMap();
    this.yRT = new com.tencent.mm.sdk.b.c() {};
    this.omO = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(186960);
        bc.aCg();
        if (bu.o((Integer)com.tencent.mm.model.c.ajA().get(15, null)) == 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LauncherUI.HomeUI", "not init finish , do not post sync task");
          AppMethodBeat.o(186960);
          return false;
        }
        Object localObject = bb.hIK.ay("login_user_name", "");
        if ((bc.aCh()) || (!((String)localObject).equals(""))) {
          bc.ajj().a(new bq(new HomeUI.16.1(this), "launch normal"), 0);
        }
        com.tencent.mm.sdk.g.b.c(new y.1(new y(HomeUI.b(HomeUI.this))), "StartupReport_report");
        com.tencent.mm.booter.o.Xj();
        HomeUI.fAr();
        com.tencent.e.h.MqF.aO(new HomeUI.16.2(this));
        localObject = p.aIL().ieM;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SendImgSpeeder", "POOL_AUTO_FILL_SIZE is 0");
        ((p.c)localObject).aIP();
        Looper.myQueue().removeIdleHandler(HomeUI.this.omO);
        AppMethodBeat.o(186960);
        return false;
      }
    };
    this.JsU = new HomeUI.17(this);
    this.JsV = 0;
    this.ABq = 300L;
    this.ABr = SystemClock.elapsedRealtime();
    this.JsW = new LinkedList();
    this.JsX = new com.tencent.mm.plugin.messenger.foundation.a.q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
      {
        AppMethodBeat.i(186966);
        if ((bu.nullAsNil(paramAnonymousString).equals("showprivacypolicy")) && (paramAnonymousMap != null))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.device_id");
          HomeUI.a(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_content"));
          HomeUI.b(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_ok"));
          HomeUI.c(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_cancel"));
          boolean bool1 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needbirthday"));
          boolean bool2 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needopenplatform"));
          boolean bool3 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needconfirm"));
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXY, Boolean.valueOf(bool1));
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXZ, Boolean.valueOf(bool2));
          com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IYa, Boolean.valueOf(bool3));
          paramAnonymousMap = com.tencent.mm.bw.b.cm(com.tencent.mm.compatible.deviceinfo.q.aaH().getBytes());
          paramAnonymousMap.aaf(16);
          paramAnonymousMap = Base64.encodeToString(paramAnonymousMap.toByteArray(), 2);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "deviceId:%s, localDeviceId:%s, doubleCheckContent:%s, doubleCheckOk:%s, doubleCheckCancel:%s, needBirthday:%s, needOpenPlatform:%s, needConfirm:%s", new Object[] { paramAnonymousString, paramAnonymousMap, HomeUI.C(HomeUI.this), HomeUI.E(HomeUI.this), HomeUI.D(HomeUI.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((bu.isNullOrNil(paramAnonymousString)) || (paramAnonymousString.equals(paramAnonymousMap)))
          {
            paramAnonymousString = com.tencent.mm.kernel.g.ajR().ajA().get(274436, "").toString();
            paramAnonymousMap = HomeUI.b(HomeUI.this);
            paramAnonymousa = com.tencent.mm.sdk.platformtools.ad.fom();
            int i;
            if (bool2)
            {
              i = 1;
              paramAnonymousMap = paramAnonymousMap.getString(2131760685, new Object[] { paramAnonymousa, paramAnonymousString, "login", Integer.valueOf(1), Integer.valueOf(i) });
              if (!com.tencent.mm.aw.b.Gw(paramAnonymousString)) {
                break label534;
              }
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "eu true, needconfirm: %s", new Object[] { Boolean.valueOf(bool3) });
              if (bool3) {
                break label498;
              }
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("close_dialog_msg", HomeUI.C(HomeUI.this));
              paramAnonymousString.putString("close_dialog_cancel", HomeUI.D(HomeUI.this));
              paramAnonymousString.putString("close_dialog_ok", HomeUI.E(HomeUI.this));
              paramAnonymousString.putBoolean("close_dialog_ok_close", false);
              HomeUI.a(HomeUI.this, paramAnonymousMap, 22722, paramAnonymousString);
            }
            for (;;)
            {
              com.tencent.mm.ui.base.b.km(HomeUI.b(HomeUI.this));
              AppMethodBeat.o(186966);
              return;
              i = 0;
              break;
              label498:
              HomeUI.a(HomeUI.this, paramAnonymousMap, 22722, HomeUI.b(HomeUI.this).getString(2131760033, new Object[] { com.tencent.mm.sdk.platformtools.ad.fom() }));
              continue;
              label534:
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "eu false");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("close_dialog_msg", HomeUI.b(HomeUI.this).getString(2131760682));
              paramAnonymousString.putString("close_dialog_cancel", HomeUI.b(HomeUI.this).getString(2131760803));
              paramAnonymousString.putString("close_dialog_ok", HomeUI.b(HomeUI.this).getString(2131760684));
              paramAnonymousString.putBoolean("close_dialog_ok_close", false);
              HomeUI.a(HomeUI.this, paramAnonymousMap, 22722, paramAnonymousString);
            }
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "device id not match");
        }
        AppMethodBeat.o(186966);
      }
    };
    this.JsY = 0.0F;
    this.JsZ = false;
    AppMethodBeat.o(33232);
  }
  
  private void ach(int paramInt)
  {
    AppMethodBeat.i(33248);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(33248);
      return;
    }
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.abu())) {
      i = paramInt;
    }
    for (;;)
    {
      if (Math.abs(this.JsV - i) >= 50000) {}
      try
      {
        this.JrI.getWindow().setStatusBarColor(i);
        this.JsV = i;
        AppMethodBeat.o(33248);
        return;
        i = paramInt;
        if (Build.VERSION.SDK_INT < 21) {
          continue;
        }
        i = ao.v(this.JrI.getResources().getColor(2131100954), paramInt);
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localNullPointerException, "updateStatusBar %s", new Object[] { Integer.valueOf(i) });
        }
      }
    }
  }
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(33236);
    if (this.wVN != null)
    {
      this.wVN.clearAnimation();
      this.wVN.setVisibility(8);
      if (paramBoolean1.booleanValue())
      {
        if (!paramBoolean2.booleanValue()) {
          break label89;
        }
        bc.aCg();
        com.tencent.mm.model.c.ajA().set(340227, Boolean.TRUE);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(232L, 0L, 1L, false);
        Jso = Boolean.FALSE;
      }
    }
    for (;;)
    {
      this.wVN = null;
      AppMethodBeat.o(33236);
      return;
      label89:
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(340230, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(232L, 5L, 1L, false);
      Jsp = Boolean.FALSE;
    }
  }
  
  private static boolean fAk()
  {
    AppMethodBeat.i(33260);
    if (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck())
    {
      AppMethodBeat.o(33260);
      return false;
    }
    if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(v.aAC()))
    {
      AppMethodBeat.o(33260);
      return true;
    }
    AppMethodBeat.o(33260);
    return false;
  }
  
  static boolean fAm()
  {
    AppMethodBeat.i(33264);
    boolean bool = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryNewFeatureConfig().ekF();
    AppMethodBeat.o(33264);
    return bool;
  }
  
  static boolean fAn()
  {
    AppMethodBeat.i(33265);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.JdU, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(33265);
    return bool;
  }
  
  private void fyN()
  {
    AppMethodBeat.i(33253);
    if (this.JrI != null) {}
    try
    {
      this.JrI.moveTaskToBack(true);
      if (bc.ajM()) {
        bc.ajU().n(new HomeUI.22(this), 500L);
      }
      w.Mt().start();
      AppMethodBeat.o(33253);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
      }
    }
  }
  
  private boolean fzY()
  {
    return (this.Jst == 2) && (this.Jsu == 2);
  }
  
  private void setActionBarColor(int paramInt)
  {
    AppMethodBeat.i(33256);
    if (this.mActionBar != null) {
      this.mActionBar.setBackgroundDrawable(new ColorDrawable(paramInt));
    }
    if (this.xgg != null) {
      this.xgg.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(33256);
  }
  
  @SuppressLint({"RestrictedApi"})
  private void updateTitle()
  {
    AppMethodBeat.i(33233);
    if (!this.Jss)
    {
      AppMethodBeat.o(33233);
      return;
    }
    int i = this.Jsz.abZ;
    Object localObject1 = getString(2131755822);
    Object localObject2;
    if (i == 0) {
      if (this.nbr)
      {
        localObject1 = (String)localObject1 + com.tencent.mm.cc.g.ix(this.JrI);
        localObject2 = localObject1;
        if (this.Jsz.JxF.fBo() > 0)
        {
          localObject2 = localObject1;
          if (!this.nbr) {
            localObject2 = (String)localObject1 + " ";
          }
          localObject2 = (String)localObject2 + "(" + this.Jsz.JxF.fBo() + ")";
        }
        localObject1 = new xo();
        ((xo)localObject1).dMY.dMZ = 1;
        ((xo)localObject1).dMY.title = ((String)localObject2);
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = localObject2;
      }
    }
    label198:
    label861:
    for (;;)
    {
      if (i == 3)
      {
        ach(this.JrI.getResources().getColor(2131101053));
        if (fAk())
        {
          xp(true);
          label231:
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).checkPost();
          if (this.mActionBar != null)
          {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.JrI.getResources().getColor(2131101053)));
            this.mActionBar.getCustomView().setVisibility(8);
          }
          if (this.xgg != null) {
            this.xgg.setBackgroundColor(this.JrI.getResources().getColor(2131101053));
          }
          this.JsT = false;
          if ((this.Jst != 3) || (this.Jsu != 3)) {
            break label624;
          }
        }
        label624:
        for (i = 1;; i = 0)
        {
          if ((i != 0) && (this.JsR != null) && (!this.JsR.isVisible())) {
            this.JsR.setVisible(true);
          }
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "alvinluo updateSettingTitle");
          this.mActionBar.setElevation(0.0F);
          this.mActionBar.gr();
          this.Jsi = ((TextView)this.mActionBar.getCustomView().findViewById(16908308));
          if (this.Jsi != null)
          {
            this.Jsi.setText((CharSequence)localObject1);
            float f = com.tencent.mm.cb.a.ay(ak.getContext(), 2131165184) * com.tencent.mm.cb.a.ip(ak.getContext());
            if (this.Jsi.getTextSize() != f) {
              this.Jsi.setTextSize(0, f);
            }
            i = this.JrI.getResources().getColor(2131099886);
            if ((this.JnY) && (this.Jsi.getCurrentTextColor() != i)) {
              this.Jsi.setTextColor(i);
            }
            al.a(this.Jsi.getPaint(), 0.8F);
          }
          AppMethodBeat.o(33233);
          return;
          localObject1 = (String)localObject1 + " " + com.tencent.mm.cc.g.ix(this.JrI);
          break;
          if (i == 1)
          {
            localObject1 = getString(2131761038);
            break label198;
          }
          if (i == 2)
          {
            localObject1 = getString(2131761036);
            break label198;
          }
          if (i != 3) {
            break label861;
          }
          localObject1 = getString(2131761071);
          break label198;
          xp(false);
          break label231;
        }
      }
      ach(this.JrI.getResources().getColor(2131100705));
      xp(this.JnY);
      localObject2 = this.mActionBar.getCustomView().getBackground();
      if ((localObject2 instanceof ColorDrawable)) {
        if (((ColorDrawable)localObject2).getColor() != this.JrI.getResources().getColor(2131100705)) {
          this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.JrI.getResources().getColor(2131100705)));
        }
      }
      for (;;)
      {
        if (this.mActionBar.getCustomView().getVisibility() != 0) {
          this.mActionBar.getCustomView().setVisibility(0);
        }
        this.JsT = true;
        if ((fzY()) && (this.JsO != null) && (!this.JsO.isVisible())) {
          this.JsO.setVisible(true);
        }
        if ((!fzY()) || (this.JsP == null) || (this.JsP.isVisible())) {
          break;
        }
        this.JsP.setVisible(true);
        break;
        this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.JrI.getResources().getColor(2131100705)));
      }
    }
  }
  
  private static void w(View paramView, boolean paramBoolean)
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
      paramView.setBackgroundResource(2131101053);
    }
    AppMethodBeat.o(33263);
  }
  
  private void xm(final boolean paramBoolean)
  {
    AppMethodBeat.i(33235);
    if (this.wVN != null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LauncherUI.HomeUI", "tipsView already shown");
      AppMethodBeat.o(33235);
      return;
    }
    this.wVN = View.inflate(ak.getContext(), 2131495019, null);
    Object localObject = (TextView)this.wVN.findViewById(2131302803);
    if (paramBoolean) {
      ((TextView)localObject).setText(ak.getContext().getString(2131755139));
    }
    for (;;)
    {
      localObject = new FrameLayout.LayoutParams(-2, -2, 53);
      this.wVN.setBackgroundResource(2131233522);
      if (this.contentView != null)
      {
        ((ViewGroup)this.contentView).addView(this.wVN, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(ak.getContext(), 2130772132);
        this.wVN.startAnimation((Animation)localObject);
        this.wVN.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(163246);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            HomeUI.l(HomeUI.this).il();
            if (paramBoolean)
            {
              paramAnonymousView = HomeUI.this;
              localObject = Boolean.TRUE;
              HomeUI.a(paramAnonymousView, (Boolean)localObject, (Boolean)localObject);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(163246);
              return;
              HomeUI.a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
            }
          }
        });
      }
      AppMethodBeat.o(33235);
      return;
      ((TextView)localObject).setText(ak.getContext().getString(2131755136));
    }
  }
  
  private void xp(boolean paramBoolean)
  {
    AppMethodBeat.i(33249);
    View localView;
    int j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.JrI.getWindow().getDecorView();
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
  
  public final void a(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33257);
    MMFragment localMMFragment = getMainTabUI().fBd();
    if (localMMFragment != null)
    {
      if ((localMMFragment instanceof MoreTabUI))
      {
        setActionBarColor(this.JrI.getResources().getColor(2131101053));
        AppMethodBeat.o(33257);
        return;
      }
      if (!(localMMFragment instanceof MainUI)) {
        setActionBarColor(this.JrI.getResources().getColor(2131100705));
      }
      while (paramInt2 > 10)
      {
        w(this.Joo, false);
        w(this.JsJ, false);
        AppMethodBeat.o(33257);
        return;
        setActionBarColor(paramInt1);
      }
      w(this.Joo, true);
      w(this.JsJ, true);
    }
    AppMethodBeat.o(33257);
  }
  
  public final void a(FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33245);
    this.JrI.getWindow().getDecorView().getBottom();
    this.JrI.getSupportActionBar().getCustomView().getBottom();
    paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
    paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
    AppMethodBeat.o(33245);
  }
  
  public final void aD(Runnable paramRunnable)
  {
    AppMethodBeat.i(33251);
    this.JsW.remove(paramRunnable);
    AppMethodBeat.o(33251);
  }
  
  public final void b(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33258);
    if ((paramInt1 != 0) && (this.Jsi != null)) {
      this.Jsi.setTextColor(paramInt1);
    }
    if (this.JsM != null)
    {
      if (this.JsZ) {
        this.JsM.setAlpha(paramFloat);
      }
      this.JsM.setImageDrawable(ao.k(this.JrI, 2131689494, paramInt2));
    }
    if (this.JsK != null)
    {
      if (this.JsZ) {
        this.JsK.setAlpha(paramFloat);
      }
      this.JsK.setImageDrawable(ao.k(this.JrI, 2131690510, paramInt2));
    }
    AppMethodBeat.o(33258);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33252);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI.HomeUI", "ui group onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    com.tencent.mm.compatible.b.g.ZT();
    com.tencent.mm.compatible.b.g.ZT();
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.Jsn != null) && (this.Jsn.isShowing()))
    {
      this.Jsn.dismiss();
      AppMethodBeat.o(33252);
      return true;
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      fAa();
      AppMethodBeat.o(33252);
      return true;
    }
    Object localObject1 = this.Jsz.fBd();
    if ((localObject1 != null) && (((MMFragment)localObject1).onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(33252);
      return true;
    }
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      if ((bc.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk) && (az.isWap(this.JrI)))
      {
        Object localObject2 = this.JrI;
        paramKeyEvent = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33196);
            HomeUI.B(HomeUI.this);
            AppMethodBeat.o(33196);
          }
        };
        if (!bc.ajM()) {
          i = 0;
        }
        while (i != 0)
        {
          AppMethodBeat.o(33252);
          return true;
          bc.aCg();
          i = ((Integer)com.tencent.mm.model.c.ajA().get(65, Integer.valueOf(0))).intValue();
          if (i >= 5)
          {
            i = 0;
          }
          else if (!com.tencent.mm.sdk.platformtools.ao.aRR("show_wap_adviser"))
          {
            i = 0;
          }
          else
          {
            localObject1 = View.inflate((Context)localObject2, 2131495013, null);
            ((TextView)((View)localObject1).findViewById(2131302708)).setText(2131761551);
            localObject2 = new d.a((Context)localObject2);
            ((d.a)localObject2).afN(2131755906);
            ((d.a)localObject2).hd((View)localObject1);
            ((d.a)localObject2).afU(2131755835).c(new MMAppMgr.1(i));
            ((d.a)localObject2).zf(false);
            ((d.a)localObject2).afV(2131761545).d(new MMAppMgr.7());
            ((d.a)localObject2).a(new MMAppMgr.8(paramKeyEvent));
            ((d.a)localObject2).fQv().show();
            i = 1;
          }
        }
      }
      final int i = az.getBackgroundLimitType(this.JrI);
      if ((bc.ajM()) && (com.tencent.mm.kernel.g.ajP().gDk) && (az.isLimited(i)))
      {
        bc.aCg();
        if ((bu.n((Boolean)com.tencent.mm.model.c.ajA().get(16385, null))) && (MMAppMgr.a(this.JrI, i, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(163261);
            try
            {
              az.startSettingItent(HomeUI.b(HomeUI.this), i);
              AppMethodBeat.o(163261);
              return;
            }
            catch (Exception paramAnonymousDialogInterface)
            {
              com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", paramAnonymousDialogInterface, "", new Object[0]);
              AppMethodBeat.o(163261);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(186963);
            HomeUI.B(HomeUI.this);
            AppMethodBeat.o(186963);
          }
        })))
        {
          AppMethodBeat.o(33252);
          return true;
        }
      }
      fyN();
    }
    AppMethodBeat.o(33252);
    return false;
  }
  
  final void fAa()
  {
    AppMethodBeat.i(33237);
    if ((this.Jsn == null) || (!bc.ajM()))
    {
      AppMethodBeat.o(33237);
      return;
    }
    if (this.Jsn.isShowing())
    {
      this.Jsn.dismiss();
      AppMethodBeat.o(33237);
      return;
    }
    this.Jsn.il();
    AppMethodBeat.o(33237);
  }
  
  final void fAb()
  {
    AppMethodBeat.i(33239);
    int i;
    if (this.JsR != null)
    {
      this.JsR.setShowAsAction(2);
      if (this.JsT) {
        break label224;
      }
      if (!(this.Jsz.fBd() instanceof MoreTabUI)) {
        break label219;
      }
      MoreTabUI localMoreTabUI = (MoreTabUI)this.Jsz.fBd();
      if ((localMoreTabUI.Jyi != null) && (localMoreTabUI.Jyi.isVisible))
      {
        i = 1;
        if (i == 0) {
          break label219;
        }
        i = 1;
        label79:
        if (i == 0) {
          break label224;
        }
        this.JsR.setVisible(true);
      }
    }
    else
    {
      label94:
      if (this.JsP != null)
      {
        if (!this.JsT) {
          break label249;
        }
        this.JsP.setShowAsAction(2);
        this.JsP.setVisible(true);
      }
      label129:
      if (this.JsO != null)
      {
        if (!this.JsT) {
          break label274;
        }
        this.JsO.setShowAsAction(2);
        this.JsO.setVisible(true);
      }
    }
    for (;;)
    {
      if (this.JsQ != null)
      {
        if (!this.JsT)
        {
          this.JsQ.setShowAsAction(2);
          this.JsQ.setVisible(true);
          this.JnR.setVisibility(0);
          AppMethodBeat.o(33239);
          return;
          i = 0;
          break;
          label219:
          i = 0;
          break label79;
          label224:
          this.JsR.setVisible(false);
          this.JsR.setEnabled(false);
          break label94;
          label249:
          this.JsP.setVisible(false);
          this.JsP.setEnabled(false);
          break label129;
          label274:
          this.JsO.setVisible(false);
          this.JsO.setEnabled(false);
          continue;
        }
        this.JsQ.setVisible(false);
        this.JsQ.setEnabled(false);
        this.JnR.setVisibility(8);
      }
    }
    AppMethodBeat.o(33239);
  }
  
  final void fAc()
  {
    AppMethodBeat.i(33240);
    if (!((n)com.tencent.mm.kernel.g.ad(n.class)).isFTSIndexReady())
    {
      Toast.makeText(ak.getContext(), 2131762954, 0).show();
      AppMethodBeat.o(33240);
      return;
    }
    int i = this.Jsz.abZ;
    if (i == 0) {
      getMainTabUI().fBd();
    }
    Intent localIntent = new Intent().putExtra("from_tab_index", i).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = localObject2;
      if (!al.isDarkMode()) {
        localObject1 = ActivityOptions.makeSceneTransitionAnimation(this.JrI, new Pair[0]).toBundle();
      }
    }
    com.tencent.mm.plugin.fts.a.d.b(this.JrI, ".ui.FTSMainUI", localIntent, (Bundle)localObject1);
    AppMethodBeat.o(33240);
  }
  
  final void fAd()
  {
    AppMethodBeat.i(33242);
    if ((fAm()) && (fAn())) {
      this.JsD = false;
    }
    if (fAm()) {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.JdU, Boolean.FALSE);
    }
    if (this.JsN != null)
    {
      this.JsN.findViewById(2131305884).setVisibility(8);
      localObject = com.tencent.mm.plugin.story.h.h.BjR;
      com.tencent.mm.plugin.story.h.h.Bo(0L);
    }
    if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).canPostStory())
    {
      com.tencent.mm.kernel.g.ajS();
      int i = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IZL, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.h.c(this.JrI, "", this.JrI.getResources().getString(2131764291, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(33242);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
    MMFragmentActivity localMMFragmentActivity = this.JrI;
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.BjR;
    ((com.tencent.mm.plugin.story.api.e)localObject).startStoryCaptureForResult(localMMFragmentActivity, 0, com.tencent.mm.plugin.story.h.h.eoa(), 10);
    AppMethodBeat.o(33242);
  }
  
  public final void fAe()
  {
    AppMethodBeat.i(33243);
    if ((v.aBt().booleanValue()) && ((Jso.booleanValue()) || (Jsp.booleanValue())))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    this.Jsz.fAe();
    AppMethodBeat.o(33243);
  }
  
  public final void fAf()
  {
    AppMethodBeat.i(33244);
    bc.ajU().foM();
    this.Jsz.fBh();
    ar.f(this.JsU);
    AppMethodBeat.o(33244);
  }
  
  public final boolean fAg()
  {
    return this.Jsw == a.Jtg;
  }
  
  public final void fAh()
  {
    AppMethodBeat.i(33254);
    updateTitle();
    AppMethodBeat.o(33254);
  }
  
  public final void fAi()
  {
    AppMethodBeat.i(33255);
    this.Jsz.fAi();
    AppMethodBeat.o(33255);
  }
  
  public final void fAj()
  {
    AppMethodBeat.i(33259);
    this.Jsz.act(170);
    AppMethodBeat.o(33259);
  }
  
  final void fAl()
  {
    AppMethodBeat.i(33261);
    if ((this.JsR != null) && (this.JsR.getActionView() != null))
    {
      ImageView localImageView = (ImageView)this.JsR.getActionView().findViewById(2131300874);
      localImageView.setImageDrawable(this.JrI.getResources().getDrawable(2131690361));
      if (fAk())
      {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        if (!this.JsD) {
          break label169;
        }
        if ((!fAm()) || (!fAn())) {
          break label164;
        }
      }
      label164:
      for (boolean bool = true;; bool = false)
      {
        this.JsD = bool;
        this.JsR.getActionView().findViewById(2131305884).setVisibility(0);
        AppMethodBeat.o(33261);
        return;
        localImageView.setColorFilter(new PorterDuffColorFilter(this.JrI.getResources().getColor(2131099664), PorterDuff.Mode.SRC_ATOP));
        break;
      }
      label169:
      this.JsR.getActionView().findViewById(2131305884).setVisibility(8);
    }
    AppMethodBeat.o(33261);
  }
  
  final void fzZ()
  {
    AppMethodBeat.i(33234);
    if (!bc.ajM())
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready");
      AppMethodBeat.o(33234);
      return;
    }
    bc.aCg();
    Boolean localBoolean = Boolean.valueOf(bu.o((Boolean)com.tencent.mm.model.c.ajA().get(340227, null)));
    if ((!localBoolean.booleanValue()) && (!l.KIF.booleanValue()))
    {
      Jso = Boolean.TRUE;
      xm(true);
    }
    long l1 = System.currentTimeMillis();
    bc.aCg();
    long l2 = bu.a((Long)com.tencent.mm.model.c.ajA().get(340240, null), 0L);
    bc.aCg();
    boolean bool1 = bu.o((Boolean)com.tencent.mm.model.c.ajA().get(340230, null));
    bc.aCg();
    boolean bool2 = bu.o((Boolean)com.tencent.mm.model.c.ajA().get(340228, null));
    bc.aCg();
    boolean bool3 = bu.o((Boolean)com.tencent.mm.model.c.ajA().get(340229, null));
    if ((localBoolean.booleanValue()) && (Boolean.valueOf(bool2).booleanValue()) && (Boolean.valueOf(bool3).booleanValue()) && (!Boolean.valueOf(bool1).booleanValue()) && (l1 - l2 >= 432000000L))
    {
      Jsp = Boolean.TRUE;
      xm(false);
    }
    AppMethodBeat.o(33234);
  }
  
  public MainTabUI getMainTabUI()
  {
    return this.Jsz;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(33241);
    String str = this.JrI.getString(paramInt);
    AppMethodBeat.o(33241);
    return str;
  }
  
  final void initActionBar()
  {
    AppMethodBeat.i(33247);
    if (this.Jsx.fAF())
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground True!");
      AppMethodBeat.o(33247);
      return;
    }
    this.JnY = al.isDarkMode();
    this.mActionBar.setLogo(new ColorDrawable(this.JrI.getResources().getColor(17170445)));
    this.mActionBar.gm();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.gl();
    this.mActionBar.gn();
    this.mActionBar.setCustomView(z.jV(this.JrI).inflate(2131492927, new LinearLayout(this.JrI), false));
    ImageView localImageView = (ImageView)this.mActionBar.getCustomView().findViewById(2131296417);
    if (localImageView != null) {
      localImageView.getDrawable().setColorFilter(this.JrI.getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
    }
    this.mActionBar.setBackgroundDrawable(ao.k(this.JrI, 2131100196, this.JrI.getResources().getColor(2131099664)));
    updateTitle();
    this.mActionBar.getCustomView().findViewById(2131296414).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186962);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (SystemClock.elapsedRealtime() - HomeUI.z(HomeUI.this) < 300L)
        {
          paramAnonymousView = HomeUI.A(HomeUI.this).iterator();
          while (paramAnonymousView.hasNext()) {
            ((Runnable)paramAnonymousView.next()).run();
          }
        }
        HomeUI.b(HomeUI.this, SystemClock.elapsedRealtime());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186962);
      }
    });
    AppMethodBeat.o(33247);
  }
  
  public final void setTitleBarDoubleClickListener(Runnable paramRunnable)
  {
    AppMethodBeat.i(33250);
    if (!this.JsW.contains(paramRunnable)) {
      this.JsW.add(paramRunnable);
    }
    AppMethodBeat.o(33250);
  }
  
  final void xn(boolean paramBoolean)
  {
    AppMethodBeat.i(33238);
    if ((this.Jsn == null) || (this.JsJ == null) || (this.JsI == null))
    {
      AppMethodBeat.o(33238);
      return;
    }
    if (!bc.ajM())
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LauncherUI.HomeUI", "want update more menu new tips, but mmcore not ready");
      AppMethodBeat.o(33238);
      return;
    }
    this.Jsn.JzN.xD(paramBoolean);
    Object localObject = this.JsI;
    if (!com.tencent.mm.plugin.newtips.a.g.a(((b)localObject).Jta.Jsn.JzN.fva(), (com.tencent.mm.plugin.newtips.a.a)localObject))
    {
      if (!((b)localObject).Jta.Jsn.JzN.fva()) {
        break label196;
      }
      ((b)localObject).Jta.JsL.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject, k.wIv, ((b)localObject).Jta.Jsn.JzN.fva());
      localObject = new xo();
      ((xo)localObject).dMY.dMZ = 2;
      ((xo)localObject).dMY.dNa = this.Jsn.JzN.fva();
      ((xo)localObject).dMY.dNb = false;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(33238);
      return;
      label196:
      ((b)localObject).Jta.JsL.setVisibility(8);
    }
  }
  
  public final void xo(boolean paramBoolean)
  {
    AppMethodBeat.i(33246);
    if (!paramBoolean) {
      initActionBar();
    }
    this.JrI.supportInvalidateOptionsMenu();
    if (v.aBt().booleanValue()) {
      fzZ();
    }
    this.Jsz.fBg();
    AppMethodBeat.o(33246);
  }
  
  public final void xq(boolean paramBoolean)
  {
    AppMethodBeat.i(33262);
    if ((this.JsR != null) && (this.JsR.getActionView() != null) && (this.JrI != null))
    {
      if (this.JrI.getResources().getConfiguration().orientation == 2)
      {
        this.JsR.setVisible(false);
        this.JsR.setEnabled(false);
        AppMethodBeat.o(33262);
        return;
      }
      this.JsR.setVisible(true);
      this.JsR.setEnabled(true);
      ImageView localImageView = (ImageView)this.JsR.getActionView().findViewById(2131300874);
      localImageView.setImageDrawable(this.JrI.getResources().getDrawable(2131690361));
      if ((paramBoolean) || (al.isDarkMode())) {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      }
      while (this.JsD)
      {
        this.JsR.getActionView().findViewById(2131305884).setVisibility(0);
        AppMethodBeat.o(33262);
        return;
        localImageView.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
      }
      this.JsR.getActionView().findViewById(2131305884).setVisibility(8);
    }
    AppMethodBeat.o(33262);
  }
  
  public static class FitSystemWindowLayoutView
    extends FrameLayout
  {
    private int Jtj;
    private ViewGroup Jtk;
    private Rect mRect;
    
    public FitSystemWindowLayoutView(Context paramContext)
    {
      super();
      AppMethodBeat.i(33220);
      this.mRect = new Rect();
      this.Jtk = null;
      AppMethodBeat.o(33220);
    }
    
    public FitSystemWindowLayoutView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(33219);
      this.mRect = new Rect();
      this.Jtk = null;
      AppMethodBeat.o(33219);
    }
    
    @TargetApi(14)
    public boolean fitSystemWindows(Rect paramRect)
    {
      AppMethodBeat.i(33221);
      Object localObject2 = paramRect.toString();
      int i = this.Jtj;
      int j = hashCode();
      Object localObject1;
      int k;
      label156:
      label235:
      boolean bool;
      if (paramRect.height() == 0)
      {
        localObject1 = bu.fpN();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d stack:%s", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j), localObject1 });
        if (paramRect.top > 0) {
          this.Jtj = paramRect.top;
        }
        if ((this.Jtk != null) && ((this.Jtk.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
        {
          localObject1 = (ViewGroup.MarginLayoutParams)this.Jtk.getLayoutParams();
          j = ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
          k = ((ViewGroup.MarginLayoutParams)localObject1).rightMargin;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
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
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", new Object[] { Integer.valueOf(j) });
            ((TestTimeForChatting)localObject2).Lig = 0;
            if ((Float.compare(k, com.tencent.mm.cb.a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 2.0F) <= 0) && (k >= 0)) {
              break label480;
            }
            com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", new Object[] { Integer.valueOf(j) });
            ((TestTimeForChatting)localObject2).Lih = 0;
            label286:
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          }
          al.P(((ViewGroup.MarginLayoutParams)localObject1).leftMargin, ((ViewGroup.MarginLayoutParams)localObject1).topMargin, ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
        }
        this.mRect.set(paramRect);
        if (!com.tencent.mm.compatible.util.d.lA(14)) {
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(Build.VERSION.SDK_INT) });
        bool = super.fitSystemWindows(this.mRect);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(33221);
        return bool;
        localObject1 = "pass";
        break;
        label471:
        ((TestTimeForChatting)localObject2).Lig = j;
        break label235;
        label480:
        ((TestTimeForChatting)localObject2).Lih = k;
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
      return this.Jtj;
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
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localClassCastException, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LauncherUI.HomeUI", "my layout params %s %s", new Object[] { getLayoutParams(), getLayoutParams().getClass() });
        int j = getChildCount();
        int i = 0;
        View localView;
        while (i < j)
        {
          localView = getChildAt(i);
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", new Object[] { Integer.valueOf(i), localView, localView.getLayoutParams(), localView.getLayoutParams().getClass() });
          i += 1;
        }
        i = 0;
        while (i < j)
        {
          localView = getChildAt(i);
          if (((localView instanceof ImageView)) && (localView.getId() == 2131303386) && (localView.getLayoutParams() != null) && ((localView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (!(localView.getLayoutParams() instanceof FrameLayout.LayoutParams))) {
            localView.setLayoutParams(new FrameLayout.LayoutParams(localView.getLayoutParams()));
          }
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", new Object[] { Integer.valueOf(i), localView, localView.getLayoutParams(), localView.getLayoutParams().getClass() });
          i += 1;
        }
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(33222);
      }
    }
    
    public void setActionBarContainer(ViewGroup paramViewGroup)
    {
      this.Jtk = paramViewGroup;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(33218);
      Jtf = new a("ACTIVITY_CREATE", 0);
      Jtg = new a("ACTIVITY_RESUME", 1);
      Jth = new a("ACTIVITY_PAUSE", 2);
      Jti = new a[] { Jtf, Jtg, Jth };
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
      com.tencent.mm.kiss.a.b.akR();
      HomeUI.a(localHomeUI, com.tencent.mm.kiss.a.b.c(HomeUI.b(HomeUI.this), 2131492929));
      HomeUI.a(HomeUI.this, (ImageView)HomeUI.q(HomeUI.this).findViewById(2131300874));
      HomeUI.b(HomeUI.this, HomeUI.q(HomeUI.this).findViewById(2131305884));
      HomeUI.q(HomeUI.this).setLayoutParams(HomeUI.this);
      HomeUI.q(HomeUI.this).setMinimumHeight(paramInt2);
      HomeUI.q(HomeUI.this).setMinimumWidth(paramInt1);
      HomeUI.r(HomeUI.this).setImageResource(2131690510);
      HomeUI.q(HomeUI.this).setContentDescription(HomeUI.this.getString(2131764451));
      HomeUI.q(HomeUI.this).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33224);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$PlusActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          com.tencent.mm.plugin.newtips.a.dxD().Mv(3);
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(10919, "0");
          HomeUI.s(HomeUI.this);
          if (HomeUI.Jso.booleanValue())
          {
            paramAnonymousView = HomeUI.this;
            localObject = Boolean.TRUE;
            HomeUI.a(paramAnonymousView, (Boolean)localObject, (Boolean)localObject);
          }
          if (HomeUI.Jsp.booleanValue()) {
            HomeUI.a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
          }
          if (!bv.fnD())
          {
            long l = bu.fpO();
            if (l - HomeUI.t(HomeUI.this) <= 10000L) {
              break label190;
            }
            HomeUI.a(HomeUI.this, l);
            HomeUI.u(HomeUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$PlusActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(33224);
            return;
            label190:
            HomeUI.v(HomeUI.this);
            if (HomeUI.w(HomeUI.this) >= 5)
            {
              com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.LauncherUI.HomeUI", "Switch to MonkeyEnv now.");
              bv.wS(true);
            }
          }
        }
      });
      HomeUI.q(HomeUI.this).post(new Runnable()
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
    
    public final void a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(224186);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(224186);
    }
    
    public final boolean a(boolean paramBoolean, dnz paramdnz)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dnz paramdnz)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dnz paramdnz)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dnz paramdnz)
    {
      return false;
    }
    
    public final boolean dnD()
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
      View localView = HomeUI.q(HomeUI.this);
      AppMethodBeat.o(33228);
      return localView;
    }
    
    public final boolean oq(boolean paramBoolean)
    {
      AppMethodBeat.i(224187);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(224187);
      return paramBoolean;
    }
    
    public final boolean or(boolean paramBoolean)
    {
      AppMethodBeat.i(33231);
      if (paramBoolean) {
        HomeUI.x(HomeUI.this).setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(33231);
        return true;
        HomeUI.x(HomeUI.this).setVisibility(8);
      }
    }
    
    public final boolean os(boolean paramBoolean)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI
 * JD-Core Version:    0.7.0.1
 */