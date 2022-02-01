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
import android.view.View.OnLongClickListener;
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
import com.tencent.mm.ak.f.a;
import com.tencent.mm.app.v;
import com.tencent.mm.blink.FirstScreenFrameLayout.a;
import com.tencent.mm.booter.y;
import com.tencent.mm.booter.y.1;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.g.a.wr;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.protocal.protobuf.dhn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.n.d;
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
  public static Boolean HjZ = Boolean.FALSE;
  public static Boolean Hka = Boolean.FALSE;
  private static boolean Hkp = true;
  static final int Hkr = 2131302248;
  static final int Hks = 2131302237;
  private TextView HfT;
  boolean Hga;
  View Hgq;
  private final long HjO;
  private final long HjP;
  public boolean HjQ;
  boolean HjR;
  public boolean HjS;
  private TextView HjT;
  private boolean HjU;
  private String HjV;
  private String HjW;
  private String HjX;
  ae HjY;
  MMFragmentActivity Hjt;
  MenuItem HkA;
  private MenuItem HkB;
  MenuItem HkC;
  Menu HkD;
  private boolean HkE;
  Runnable HkF;
  private int HkG;
  private LinkedList<Runnable> HkH;
  p HkI;
  private float HkJ;
  private boolean HkK;
  private final long Hkb;
  private final long Hkc;
  private boolean Hkd;
  private int Hke;
  private int Hkf;
  private int Hkg;
  a Hkh;
  LauncherUI.a Hki;
  h Hkj;
  MainTabUI Hkk;
  int Hkl;
  int Hkm;
  private boolean Hkn;
  boolean Hko;
  View.OnLayoutChangeListener Hkq;
  b Hkt;
  View Hku;
  ImageView Hkv;
  private View Hkw;
  ImageView Hkx;
  View Hky;
  MenuItem Hkz;
  private int clickCount;
  View contentView;
  private String dqK;
  private boolean iMq;
  LayoutInflater iMw;
  ActionBar mActionBar;
  private boolean mvE;
  MessageQueue.IdleHandler nEp;
  private long sUe;
  View vJh;
  private final HashMap<String, Object> values;
  com.tencent.mm.sdk.b.c xnS;
  private final long ySC;
  private long ySD;
  private View zhJ;
  
  public HomeUI()
  {
    AppMethodBeat.i(33232);
    this.HjO = 604800000L;
    this.HjP = 86400000L;
    this.iMq = true;
    this.HjQ = false;
    this.dqK = null;
    this.HjS = false;
    this.Hga = false;
    this.HjU = false;
    this.Hkb = 432000000L;
    this.Hkc = 604800000L;
    this.Hkd = true;
    this.Hke = 0;
    this.Hkf = 0;
    this.Hkg = 0;
    this.Hkh = a.HkQ;
    this.Hkk = new MainTabUI();
    this.Hkl = 0;
    this.Hkm = 0;
    this.Hkn = false;
    this.Hko = true;
    this.Hkq = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8) {}
    };
    this.mvE = ab.eUK();
    this.HkE = true;
    this.clickCount = 0;
    this.sUe = 0L;
    this.values = new HashMap();
    this.xnS = new com.tencent.mm.sdk.b.c() {};
    this.nEp = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(196272);
        az.ayM();
        if (bs.m((Integer)com.tencent.mm.model.c.agA().get(15, null)) == 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          ac.e("MicroMsg.LauncherUI.HomeUI", "not init finish , do not post sync task");
          AppMethodBeat.o(196272);
          return false;
        }
        Object localObject = ay.hnA.aw("login_user_name", "");
        if ((az.ayN()) || (!((String)localObject).equals(""))) {
          az.agi().a(new bn(new bn.a()
          {
            public final void a(com.tencent.mm.network.e paramAnonymous2e) {}
          }, "launch normal"), 0);
        }
        com.tencent.mm.sdk.g.b.c(new y.1(new y(HomeUI.b(HomeUI.this))), "StartupReport_report");
        com.tencent.mm.booter.o.UK();
        HomeUI.fgf();
        f.dyP();
        localObject = com.tencent.mm.av.n.aFl().hJd;
        ac.i("MicroMsg.SendImgSpeeder", "POOL_AUTO_FILL_SIZE is 0");
        ((com.tencent.mm.av.n.c)localObject).aFp();
        Looper.myQueue().removeIdleHandler(HomeUI.this.nEp);
        AppMethodBeat.o(196272);
        return false;
      }
    };
    this.HkF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196273);
        if (((com.tencent.mm.r.a.cg(HomeUI.b(HomeUI.this))) && (!com.tencent.mm.r.a.cf(HomeUI.b(HomeUI.this)))) || (com.tencent.mm.r.a.cj(HomeUI.b(HomeUI.this))))
        {
          AppMethodBeat.o(196273);
          return;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("BaseScanUI_select_scan_mode", 1);
        localIntent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
        localIntent.putExtra("key_config_black_interval", true);
        localIntent.setFlags(65536);
        com.tencent.mm.plugin.report.service.h.wUl.f(11409, new Object[0]);
        com.tencent.mm.br.d.b(HomeUI.b(HomeUI.this), "scanner", ".ui.BaseScanUI", localIntent);
        AppMethodBeat.o(196273);
      }
    };
    this.HkG = 0;
    this.ySC = 300L;
    this.ySD = SystemClock.elapsedRealtime();
    this.HkH = new LinkedList();
    this.HkI = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, f.a paramAnonymousa)
      {
        AppMethodBeat.i(196278);
        if ((bs.nullAsNil(paramAnonymousString).equals("showprivacypolicy")) && (paramAnonymousMap != null))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.device_id");
          HomeUI.a(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_content"));
          HomeUI.b(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_ok"));
          HomeUI.c(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_cancel"));
          boolean bool1 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needbirthday"));
          boolean bool2 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needopenplatform"));
          boolean bool3 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needconfirm"));
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRb, Boolean.valueOf(bool1));
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRc, Boolean.valueOf(bool2));
          com.tencent.mm.kernel.g.agR().agA().set(ah.a.GRd, Boolean.valueOf(bool3));
          paramAnonymousMap = com.tencent.mm.bw.b.cc(com.tencent.mm.compatible.deviceinfo.q.XX().getBytes());
          paramAnonymousMap.XD(16);
          paramAnonymousMap = Base64.encodeToString(paramAnonymousMap.toByteArray(), 2);
          ac.i("MicroMsg.LauncherUI.HomeUI", "deviceId:%s, localDeviceId:%s, doubleCheckContent:%s, doubleCheckOk:%s, doubleCheckCancel:%s, needBirthday:%s, needOpenPlatform:%s, needConfirm:%s", new Object[] { paramAnonymousString, paramAnonymousMap, HomeUI.C(HomeUI.this), HomeUI.E(HomeUI.this), HomeUI.D(HomeUI.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((bs.isNullOrNil(paramAnonymousString)) || (paramAnonymousString.equals(paramAnonymousMap)))
          {
            paramAnonymousString = com.tencent.mm.kernel.g.agR().agA().get(274436, "").toString();
            paramAnonymousMap = HomeUI.b(HomeUI.this);
            paramAnonymousa = ab.eUO();
            int i;
            if (bool2)
            {
              i = 1;
              paramAnonymousMap = paramAnonymousMap.getString(2131760685, new Object[] { paramAnonymousa, paramAnonymousString, "login", Integer.valueOf(1), Integer.valueOf(i) });
              if (!com.tencent.mm.aw.b.CQ(paramAnonymousString)) {
                break label534;
              }
              ac.i("MicroMsg.LauncherUI.HomeUI", "eu true, needconfirm: %s", new Object[] { Boolean.valueOf(bool3) });
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
              com.tencent.mm.ui.base.b.jU(HomeUI.b(HomeUI.this));
              AppMethodBeat.o(196278);
              return;
              i = 0;
              break;
              label498:
              HomeUI.a(HomeUI.this, paramAnonymousMap, 22722, HomeUI.b(HomeUI.this).getString(2131760033, new Object[] { ab.eUO() }));
              continue;
              label534:
              ac.i("MicroMsg.LauncherUI.HomeUI", "eu false");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("close_dialog_msg", HomeUI.b(HomeUI.this).getString(2131760682));
              paramAnonymousString.putString("close_dialog_cancel", HomeUI.b(HomeUI.this).getString(2131760803));
              paramAnonymousString.putString("close_dialog_ok", HomeUI.b(HomeUI.this).getString(2131760684));
              paramAnonymousString.putBoolean("close_dialog_ok_close", false);
              HomeUI.a(HomeUI.this, paramAnonymousMap, 22722, paramAnonymousString);
            }
          }
          ac.i("MicroMsg.LauncherUI.HomeUI", "device id not match");
        }
        AppMethodBeat.o(196278);
      }
    };
    this.HkJ = 0.0F;
    this.HkK = false;
    AppMethodBeat.o(33232);
  }
  
  private void Zp(int paramInt)
  {
    AppMethodBeat.i(33248);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(33248);
      return;
    }
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.YJ())) {
      i = paramInt;
    }
    for (;;)
    {
      if (Math.abs(this.HkG - i) >= 50000) {}
      try
      {
        this.Hjt.getWindow().setStatusBarColor(i);
        this.HkG = i;
        AppMethodBeat.o(33248);
        return;
        i = paramInt;
        if (Build.VERSION.SDK_INT < 21) {
          continue;
        }
        i = am.o(this.Hjt.getResources().getColor(2131100954), paramInt);
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localNullPointerException, "updateStatusBar %s", new Object[] { Integer.valueOf(i) });
        }
      }
    }
  }
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(33236);
    if (this.zhJ != null)
    {
      this.zhJ.clearAnimation();
      this.zhJ.setVisibility(8);
      if (paramBoolean1.booleanValue())
      {
        if (!paramBoolean2.booleanValue()) {
          break label89;
        }
        az.ayM();
        com.tencent.mm.model.c.agA().set(340227, Boolean.TRUE);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(232L, 0L, 1L, false);
        HjZ = Boolean.FALSE;
      }
    }
    for (;;)
    {
      this.zhJ = null;
      AppMethodBeat.o(33236);
      return;
      label89:
      az.ayM();
      com.tencent.mm.model.c.agA().set(340230, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(232L, 5L, 1L, false);
      Hka = Boolean.FALSE;
    }
  }
  
  private void feF()
  {
    AppMethodBeat.i(33253);
    if (this.Hjt != null) {}
    try
    {
      this.Hjt.moveTaskToBack(true);
      if (az.agM()) {
        az.agU().m(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(163262);
            if (az.agM())
            {
              az.ayM();
              com.tencent.mm.storage.ae localae = com.tencent.mm.model.c.agA();
              if (localae != null) {
                localae.faa();
              }
            }
            AppMethodBeat.o(163262);
          }
        }, 500L);
      }
      v.KE().start();
      AppMethodBeat.o(33253);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
      }
    }
  }
  
  private boolean ffL()
  {
    return (this.Hke == 2) && (this.Hkf == 2);
  }
  
  private static boolean ffX()
  {
    AppMethodBeat.i(33260);
    if (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck())
    {
      AppMethodBeat.o(33260);
      return false;
    }
    if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(u.axw()))
    {
      AppMethodBeat.o(33260);
      return true;
    }
    AppMethodBeat.o(33260);
    return false;
  }
  
  static boolean ffZ()
  {
    AppMethodBeat.i(33264);
    boolean bool = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryNewFeatureConfig().dUI();
    AppMethodBeat.o(33264);
    return bool;
  }
  
  static boolean fga()
  {
    AppMethodBeat.i(33265);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GWq, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(33265);
    return bool;
  }
  
  private void setActionBarColor(int paramInt)
  {
    AppMethodBeat.i(33256);
    if (this.mActionBar != null) {
      this.mActionBar.setBackgroundDrawable(new ColorDrawable(paramInt));
    }
    if (this.vJh != null) {
      this.vJh.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(33256);
  }
  
  @SuppressLint({"RestrictedApi"})
  private void updateTitle()
  {
    AppMethodBeat.i(33233);
    if (!this.Hkd)
    {
      AppMethodBeat.o(33233);
      return;
    }
    int i = this.Hkk.aaj;
    Object localObject2 = getString(2131755822);
    Object localObject1;
    if (i == 0)
    {
      localObject1 = localObject2;
      if (com.tencent.mm.protocal.d.DIf)
      {
        if (this.mvE) {
          localObject1 = (String)localObject2 + getString(2131755263);
        }
      }
      else
      {
        localObject2 = localObject1;
        if (this.Hkk.Hpp.fha() > 0)
        {
          localObject2 = localObject1;
          if (!this.mvE) {
            localObject2 = (String)localObject1 + " ";
          }
          localObject2 = (String)localObject2 + "(" + this.Hkk.Hpp.fha() + ")";
        }
        localObject1 = new wr();
        ((wr)localObject1).dzx.dzy = 1;
        ((wr)localObject1).dzx.title = ((String)localObject2);
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      label209:
      if (i == 3)
      {
        Zp(this.Hjt.getResources().getColor(2131101053));
        if (ffX())
        {
          wv(true);
          label242:
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).checkPost();
          if (this.mActionBar != null)
          {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.Hjt.getResources().getColor(2131101053)));
            this.mActionBar.getCustomView().setVisibility(8);
          }
          if (this.vJh != null) {
            this.vJh.setBackgroundColor(this.Hjt.getResources().getColor(2131101053));
          }
          this.HkE = false;
          if ((this.Hke != 3) || (this.Hkf != 3)) {
            break label636;
          }
        }
        label636:
        for (i = 1;; i = 0)
        {
          if ((i != 0) && (this.HkC != null) && (!this.HkC.isVisible())) {
            this.HkC.setVisible(true);
          }
          ac.i("MicroMsg.LauncherUI.HomeUI", "alvinluo updateSettingTitle");
          this.mActionBar.setElevation(0.0F);
          this.mActionBar.fZ();
          this.HjT = ((TextView)this.mActionBar.getCustomView().findViewById(16908308));
          if (this.HjT != null)
          {
            this.HjT.setText((CharSequence)localObject1);
            float f = com.tencent.mm.cc.a.av(ai.getContext(), 2131165184) * com.tencent.mm.cc.a.ib(ai.getContext());
            if (this.HjT.getTextSize() != f) {
              this.HjT.setTextSize(0, f);
            }
            i = this.Hjt.getResources().getColor(2131099886);
            if ((this.Hga) && (this.HjT.getCurrentTextColor() != i)) {
              this.HjT.setTextColor(i);
            }
            aj.a(this.HjT.getPaint(), 0.8F);
          }
          AppMethodBeat.o(33233);
          return;
          localObject1 = (String)localObject2 + " " + getString(2131755263);
          break;
          if (i == 1)
          {
            localObject1 = getString(2131761038);
            break label209;
          }
          if (i == 2)
          {
            localObject1 = getString(2131761036);
            break label209;
          }
          if (i != 3) {
            break label873;
          }
          localObject1 = getString(2131761071);
          break label209;
          wv(false);
          break label242;
        }
      }
      Zp(this.Hjt.getResources().getColor(2131100705));
      wv(this.Hga);
      localObject2 = this.mActionBar.getCustomView().getBackground();
      if ((localObject2 instanceof ColorDrawable)) {
        if (((ColorDrawable)localObject2).getColor() != this.Hjt.getResources().getColor(2131100705)) {
          this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.Hjt.getResources().getColor(2131100705)));
        }
      }
      for (;;)
      {
        if (this.mActionBar.getCustomView().getVisibility() != 0) {
          this.mActionBar.getCustomView().setVisibility(0);
        }
        this.HkE = true;
        if ((ffL()) && (this.Hkz != null) && (!this.Hkz.isVisible())) {
          this.Hkz.setVisible(true);
        }
        if ((!ffL()) || (this.HkA == null) || (this.HkA.isVisible())) {
          break;
        }
        this.HkA.setVisible(true);
        break;
        this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.Hjt.getResources().getColor(2131100705)));
      }
      label873:
      localObject1 = localObject2;
    }
  }
  
  private static void v(View paramView, boolean paramBoolean)
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
  
  private void ws(final boolean paramBoolean)
  {
    AppMethodBeat.i(33235);
    if (this.zhJ != null)
    {
      ac.e("MicroMsg.LauncherUI.HomeUI", "tipsView already shown");
      AppMethodBeat.o(33235);
      return;
    }
    this.zhJ = View.inflate(ai.getContext(), 2131495019, null);
    Object localObject = (TextView)this.zhJ.findViewById(2131302803);
    if (paramBoolean) {
      ((TextView)localObject).setText(ai.getContext().getString(2131755139));
    }
    for (;;)
    {
      localObject = new FrameLayout.LayoutParams(-2, -2, 53);
      this.zhJ.setBackgroundResource(2131233522);
      if (this.contentView != null)
      {
        ((ViewGroup)this.contentView).addView(this.zhJ, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(ai.getContext(), 2130772132);
        this.zhJ.startAnimation((Animation)localObject);
        this.zhJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(163246);
            HomeUI.l(HomeUI.this).hU();
            if (paramBoolean)
            {
              paramAnonymousView = HomeUI.this;
              Boolean localBoolean = Boolean.TRUE;
              HomeUI.a(paramAnonymousView, localBoolean, localBoolean);
              AppMethodBeat.o(163246);
              return;
            }
            HomeUI.a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
            AppMethodBeat.o(163246);
          }
        });
      }
      AppMethodBeat.o(33235);
      return;
      ((TextView)localObject).setText(ai.getContext().getString(2131755136));
    }
  }
  
  private void wv(boolean paramBoolean)
  {
    AppMethodBeat.i(33249);
    View localView;
    int j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.Hjt.getWindow().getDecorView();
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
    MMFragment localMMFragment = getMainTabUI().fgP();
    if (localMMFragment != null)
    {
      if ((localMMFragment instanceof MoreTabUI))
      {
        setActionBarColor(this.Hjt.getResources().getColor(2131101053));
        AppMethodBeat.o(33257);
        return;
      }
      if (!(localMMFragment instanceof MainUI)) {
        setActionBarColor(this.Hjt.getResources().getColor(2131100705));
      }
      while (paramInt2 > 10)
      {
        v(this.Hgq, false);
        v(this.Hku, false);
        AppMethodBeat.o(33257);
        return;
        setActionBarColor(paramInt1);
      }
      v(this.Hgq, true);
      v(this.Hku, true);
    }
    AppMethodBeat.o(33257);
  }
  
  public final void a(FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33245);
    this.Hjt.getWindow().getDecorView().getBottom();
    this.Hjt.getSupportActionBar().getCustomView().getBottom();
    paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
    paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
    AppMethodBeat.o(33245);
  }
  
  public final void aH(Runnable paramRunnable)
  {
    AppMethodBeat.i(33251);
    this.HkH.remove(paramRunnable);
    AppMethodBeat.o(33251);
  }
  
  public final void b(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33258);
    if ((paramInt1 != 0) && (this.HjT != null)) {
      this.HjT.setTextColor(paramInt1);
    }
    if (this.Hkx != null)
    {
      if (this.HkK) {
        this.Hkx.setAlpha(paramFloat);
      }
      this.Hkx.setImageDrawable(am.k(this.Hjt, 2131689494, paramInt2));
    }
    if (this.Hkv != null)
    {
      if (this.HkK) {
        this.Hkv.setAlpha(paramFloat);
      }
      this.Hkv.setImageDrawable(am.k(this.Hjt, 2131690510, paramInt2));
    }
    AppMethodBeat.o(33258);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33252);
    ac.i("MicroMsg.LauncherUI.HomeUI", "ui group onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    com.tencent.mm.compatible.b.g.Xj();
    com.tencent.mm.compatible.b.g.Xj();
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.HjY != null) && (this.HjY.isShowing()))
    {
      this.HjY.dismiss();
      AppMethodBeat.o(33252);
      return true;
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      ffN();
      AppMethodBeat.o(33252);
      return true;
    }
    Object localObject1 = this.Hkk.fgP();
    if ((localObject1 != null) && (((MMFragment)localObject1).onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(33252);
      return true;
    }
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      if ((az.agM()) && (com.tencent.mm.kernel.g.agP().ggT) && (ax.isWap(this.Hjt)))
      {
        Object localObject2 = this.Hjt;
        paramKeyEvent = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33196);
            HomeUI.B(HomeUI.this);
            AppMethodBeat.o(33196);
          }
        };
        if (!az.agM()) {
          i = 0;
        }
        while (i != 0)
        {
          AppMethodBeat.o(33252);
          return true;
          az.ayM();
          i = ((Integer)com.tencent.mm.model.c.agA().get(65, Integer.valueOf(0))).intValue();
          if (i >= 5)
          {
            i = 0;
          }
          else if (!com.tencent.mm.sdk.platformtools.am.aKO("show_wap_adviser"))
          {
            i = 0;
          }
          else
          {
            localObject1 = View.inflate((Context)localObject2, 2131495013, null);
            ((TextView)((View)localObject1).findViewById(2131302708)).setText(2131761551);
            localObject2 = new d.a((Context)localObject2);
            ((d.a)localObject2).acF(2131755906);
            ((d.a)localObject2).gH((View)localObject1);
            ((d.a)localObject2).acM(2131755835).b(new MMAppMgr.1(i));
            ((d.a)localObject2).yf(false);
            ((d.a)localObject2).acN(2131761545).c(new MMAppMgr.7());
            ((d.a)localObject2).a(new MMAppMgr.8(paramKeyEvent));
            ((d.a)localObject2).fvp().show();
            i = 1;
          }
        }
      }
      final int i = ax.getBackgroundLimitType(this.Hjt);
      if ((az.agM()) && (com.tencent.mm.kernel.g.agP().ggT) && (ax.isLimited(i)))
      {
        az.ayM();
        if ((bs.k((Boolean)com.tencent.mm.model.c.agA().get(16385, null))) && (MMAppMgr.a(this.Hjt, i, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(163261);
            try
            {
              ax.startSettingItent(HomeUI.b(HomeUI.this), i);
              AppMethodBeat.o(163261);
              return;
            }
            catch (Exception paramAnonymousDialogInterface)
            {
              ac.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", paramAnonymousDialogInterface, "", new Object[0]);
              AppMethodBeat.o(163261);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(196275);
            HomeUI.B(HomeUI.this);
            AppMethodBeat.o(196275);
          }
        })))
        {
          AppMethodBeat.o(33252);
          return true;
        }
      }
      feF();
    }
    AppMethodBeat.o(33252);
    return false;
  }
  
  final void ffM()
  {
    AppMethodBeat.i(33234);
    if (!az.agM())
    {
      ac.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready");
      AppMethodBeat.o(33234);
      return;
    }
    az.ayM();
    Boolean localBoolean = Boolean.valueOf(bs.l((Boolean)com.tencent.mm.model.c.agA().get(340227, null)));
    if ((!localBoolean.booleanValue()) && (!com.tencent.mm.ui.contact.l.IvF.booleanValue()))
    {
      HjZ = Boolean.TRUE;
      ws(true);
    }
    long l1 = System.currentTimeMillis();
    az.ayM();
    long l2 = bs.a((Long)com.tencent.mm.model.c.agA().get(340240, null), 0L);
    az.ayM();
    boolean bool1 = bs.l((Boolean)com.tencent.mm.model.c.agA().get(340230, null));
    az.ayM();
    boolean bool2 = bs.l((Boolean)com.tencent.mm.model.c.agA().get(340228, null));
    az.ayM();
    boolean bool3 = bs.l((Boolean)com.tencent.mm.model.c.agA().get(340229, null));
    if ((localBoolean.booleanValue()) && (Boolean.valueOf(bool2).booleanValue()) && (Boolean.valueOf(bool3).booleanValue()) && (!Boolean.valueOf(bool1).booleanValue()) && (l1 - l2 >= 432000000L))
    {
      Hka = Boolean.TRUE;
      ws(false);
    }
    AppMethodBeat.o(33234);
  }
  
  final void ffN()
  {
    AppMethodBeat.i(33237);
    if ((this.HjY == null) || (!az.agM()))
    {
      AppMethodBeat.o(33237);
      return;
    }
    if (this.HjY.isShowing())
    {
      this.HjY.dismiss();
      AppMethodBeat.o(33237);
      return;
    }
    this.HjY.hU();
    AppMethodBeat.o(33237);
  }
  
  final void ffO()
  {
    AppMethodBeat.i(33239);
    int i;
    if (this.HkC != null)
    {
      this.HkC.setShowAsAction(2);
      if (this.HkE) {
        break label224;
      }
      if (!(this.Hkk.fgP() instanceof MoreTabUI)) {
        break label219;
      }
      MoreTabUI localMoreTabUI = (MoreTabUI)this.Hkk.fgP();
      if ((localMoreTabUI.HpR != null) && (localMoreTabUI.HpR.isVisible))
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
        this.HkC.setVisible(true);
      }
    }
    else
    {
      label94:
      if (this.HkA != null)
      {
        if (!this.HkE) {
          break label249;
        }
        this.HkA.setShowAsAction(2);
        this.HkA.setVisible(true);
      }
      label129:
      if (this.Hkz != null)
      {
        if (!this.HkE) {
          break label274;
        }
        this.Hkz.setShowAsAction(2);
        this.Hkz.setVisible(true);
      }
    }
    for (;;)
    {
      if (this.HkB != null)
      {
        if (!this.HkE)
        {
          this.HkB.setShowAsAction(2);
          this.HkB.setVisible(true);
          this.HfT.setVisibility(0);
          AppMethodBeat.o(33239);
          return;
          i = 0;
          break;
          label219:
          i = 0;
          break label79;
          label224:
          this.HkC.setVisible(false);
          this.HkC.setEnabled(false);
          break label94;
          label249:
          this.HkA.setVisible(false);
          this.HkA.setEnabled(false);
          break label129;
          label274:
          this.Hkz.setVisible(false);
          this.Hkz.setEnabled(false);
          continue;
        }
        this.HkB.setVisible(false);
        this.HkB.setEnabled(false);
        this.HfT.setVisibility(8);
      }
    }
    AppMethodBeat.o(33239);
  }
  
  final void ffP()
  {
    AppMethodBeat.i(33240);
    if (!((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).isFTSIndexReady())
    {
      Toast.makeText(ai.getContext(), 2131762954, 0).show();
      AppMethodBeat.o(33240);
      return;
    }
    int i = this.Hkk.aaj;
    if (i == 0) {
      getMainTabUI().fgP();
    }
    Intent localIntent = new Intent().putExtra("from_tab_index", i).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = localObject2;
      if (!aj.DT()) {
        localObject1 = ActivityOptions.makeSceneTransitionAnimation(this.Hjt, new Pair[0]).toBundle();
      }
    }
    com.tencent.mm.plugin.fts.a.d.b(this.Hjt, ".ui.FTSMainUI", localIntent, (Bundle)localObject1);
    AppMethodBeat.o(33240);
  }
  
  final void ffQ()
  {
    AppMethodBeat.i(33242);
    if ((ffZ()) && (fga())) {
      this.Hko = false;
    }
    if (ffZ()) {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GWq, Boolean.FALSE);
    }
    if (this.Hky != null)
    {
      this.Hky.findViewById(2131305884).setVisibility(8);
      localObject = com.tencent.mm.plugin.story.h.h.zAU;
      com.tencent.mm.plugin.story.h.h.ys(0L);
    }
    if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).canPostStory())
    {
      com.tencent.mm.kernel.g.agS();
      int i = ((Integer)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GSG, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.h.c(this.Hjt, "", this.Hjt.getResources().getString(2131764291, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(33242);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
    MMFragmentActivity localMMFragmentActivity = this.Hjt;
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.zAU;
    ((com.tencent.mm.plugin.story.api.e)localObject).startStoryCaptureForResult(localMMFragmentActivity, 0, com.tencent.mm.plugin.story.h.h.dYc(), 10);
    AppMethodBeat.o(33242);
  }
  
  public final void ffR()
  {
    AppMethodBeat.i(33243);
    if ((u.aye().booleanValue()) && ((HjZ.booleanValue()) || (Hka.booleanValue())))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    this.Hkk.ffR();
    AppMethodBeat.o(33243);
  }
  
  public final void ffS()
  {
    AppMethodBeat.i(33244);
    az.agU().eVk();
    this.Hkk.fgT();
    ap.f(this.HkF);
    AppMethodBeat.o(33244);
  }
  
  public final boolean ffT()
  {
    return this.Hkh == a.HkR;
  }
  
  public final void ffU()
  {
    AppMethodBeat.i(33254);
    updateTitle();
    AppMethodBeat.o(33254);
  }
  
  public final void ffV()
  {
    AppMethodBeat.i(33255);
    this.Hkk.ffV();
    AppMethodBeat.o(33255);
  }
  
  public final void ffW()
  {
    AppMethodBeat.i(33259);
    this.Hkk.ZB(170);
    AppMethodBeat.o(33259);
  }
  
  final void ffY()
  {
    AppMethodBeat.i(33261);
    if ((this.HkC != null) && (this.HkC.getActionView() != null))
    {
      ImageView localImageView = (ImageView)this.HkC.getActionView().findViewById(2131300874);
      localImageView.setImageDrawable(this.Hjt.getResources().getDrawable(2131690361));
      if (ffX())
      {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        if (!this.Hko) {
          break label169;
        }
        if ((!ffZ()) || (!fga())) {
          break label164;
        }
      }
      label164:
      for (boolean bool = true;; bool = false)
      {
        this.Hko = bool;
        this.HkC.getActionView().findViewById(2131305884).setVisibility(0);
        AppMethodBeat.o(33261);
        return;
        localImageView.setColorFilter(new PorterDuffColorFilter(this.Hjt.getResources().getColor(2131099664), PorterDuff.Mode.SRC_ATOP));
        break;
      }
      label169:
      this.HkC.getActionView().findViewById(2131305884).setVisibility(8);
    }
    AppMethodBeat.o(33261);
  }
  
  public MainTabUI getMainTabUI()
  {
    return this.Hkk;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(33241);
    String str = this.Hjt.getString(paramInt);
    AppMethodBeat.o(33241);
    return str;
  }
  
  final void initActionBar()
  {
    AppMethodBeat.i(33247);
    if (this.Hki.fgt())
    {
      ac.w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground True!");
      AppMethodBeat.o(33247);
      return;
    }
    this.Hga = aj.DT();
    this.mActionBar.setLogo(new ColorDrawable(this.Hjt.getResources().getColor(17170445)));
    this.mActionBar.fU();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.fT();
    this.mActionBar.fV();
    this.mActionBar.setCustomView(z.jD(this.Hjt).inflate(2131492927, new LinearLayout(this.Hjt), false));
    ImageView localImageView = (ImageView)this.mActionBar.getCustomView().findViewById(2131296417);
    if (localImageView != null) {
      localImageView.getDrawable().setColorFilter(this.Hjt.getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
    }
    this.mActionBar.setBackgroundDrawable(am.k(this.Hjt, 2131100196, this.Hjt.getResources().getColor(2131099664)));
    updateTitle();
    this.mActionBar.getCustomView().findViewById(2131296414).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196274);
        if (SystemClock.elapsedRealtime() - HomeUI.z(HomeUI.this) < 300L)
        {
          paramAnonymousView = HomeUI.A(HomeUI.this).iterator();
          while (paramAnonymousView.hasNext()) {
            ((Runnable)paramAnonymousView.next()).run();
          }
        }
        HomeUI.b(HomeUI.this, SystemClock.elapsedRealtime());
        AppMethodBeat.o(196274);
      }
    });
    AppMethodBeat.o(33247);
  }
  
  public final void setTitleBarDoubleClickListener(Runnable paramRunnable)
  {
    AppMethodBeat.i(33250);
    if (!this.HkH.contains(paramRunnable)) {
      this.HkH.add(paramRunnable);
    }
    AppMethodBeat.o(33250);
  }
  
  final void wt(boolean paramBoolean)
  {
    AppMethodBeat.i(33238);
    if ((this.HjY == null) || (this.Hku == null) || (this.Hkt == null))
    {
      AppMethodBeat.o(33238);
      return;
    }
    if (!az.agM())
    {
      ac.w("MicroMsg.LauncherUI.HomeUI", "want update more menu new tips, but mmcore not ready");
      AppMethodBeat.o(33238);
      return;
    }
    this.HjY.Hrw.wJ(paramBoolean);
    Object localObject = this.Hkt;
    if (!com.tencent.mm.plugin.newtips.a.g.a(((b)localObject).HkL.HjY.Hrw.faX(), (com.tencent.mm.plugin.newtips.a.a)localObject))
    {
      if (!((b)localObject).HkL.HjY.Hrw.faX()) {
        break label196;
      }
      ((b)localObject).HkL.Hkw.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject, k.vnt, ((b)localObject).HkL.HjY.Hrw.faX());
      localObject = new wr();
      ((wr)localObject).dzx.dzy = 2;
      ((wr)localObject).dzx.dzz = this.HjY.Hrw.faX();
      ((wr)localObject).dzx.dzA = false;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(33238);
      return;
      label196:
      ((b)localObject).HkL.Hkw.setVisibility(8);
    }
  }
  
  public final void wu(boolean paramBoolean)
  {
    AppMethodBeat.i(33246);
    if (!paramBoolean) {
      initActionBar();
    }
    this.Hjt.supportInvalidateOptionsMenu();
    if (u.aye().booleanValue()) {
      ffM();
    }
    this.Hkk.fgS();
    AppMethodBeat.o(33246);
  }
  
  public final void ww(boolean paramBoolean)
  {
    AppMethodBeat.i(33262);
    if ((this.HkC != null) && (this.HkC.getActionView() != null) && (this.Hjt != null))
    {
      if (this.Hjt.getResources().getConfiguration().orientation == 2)
      {
        this.HkC.setVisible(false);
        this.HkC.setEnabled(false);
        AppMethodBeat.o(33262);
        return;
      }
      this.HkC.setVisible(true);
      this.HkC.setEnabled(true);
      ImageView localImageView = (ImageView)this.HkC.getActionView().findViewById(2131300874);
      localImageView.setImageDrawable(this.Hjt.getResources().getDrawable(2131690361));
      if ((paramBoolean) || (aj.DT())) {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      }
      while (this.Hko)
      {
        this.HkC.getActionView().findViewById(2131305884).setVisibility(0);
        AppMethodBeat.o(33262);
        return;
        localImageView.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
      }
      this.HkC.getActionView().findViewById(2131305884).setVisibility(8);
    }
    AppMethodBeat.o(33262);
  }
  
  public static class FitSystemWindowLayoutView
    extends FrameLayout
  {
    private int HkU;
    private ViewGroup HkV;
    private Rect mRect;
    
    public FitSystemWindowLayoutView(Context paramContext)
    {
      super();
      AppMethodBeat.i(33220);
      this.mRect = new Rect();
      this.HkV = null;
      AppMethodBeat.o(33220);
    }
    
    public FitSystemWindowLayoutView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(33219);
      this.mRect = new Rect();
      this.HkV = null;
      AppMethodBeat.o(33219);
    }
    
    @TargetApi(14)
    public boolean fitSystemWindows(Rect paramRect)
    {
      AppMethodBeat.i(33221);
      Object localObject2 = paramRect.toString();
      int i = this.HkU;
      int j = hashCode();
      Object localObject1;
      int k;
      label156:
      label235:
      boolean bool;
      if (paramRect.height() == 0)
      {
        localObject1 = bs.eWi();
        ac.i("MicroMsg.LauncherUI", "fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d stack:%s", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j), localObject1 });
        if (paramRect.top > 0) {
          this.HkU = paramRect.top;
        }
        if ((this.HkV != null) && ((this.HkV.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
        {
          localObject1 = (ViewGroup.MarginLayoutParams)this.HkV.getLayoutParams();
          j = ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
          k = ((ViewGroup.MarginLayoutParams)localObject1).rightMargin;
          ac.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          i = 0;
          if (i < getChildCount())
          {
            localObject2 = getChildAt(i);
            if (!(localObject2 instanceof TestTimeForChatting)) {
              break label490;
            }
            localObject2 = (TestTimeForChatting)localObject2;
            if ((Float.compare(j, com.tencent.mm.cc.a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 2.0F) <= 0) && (j >= 0)) {
              break label471;
            }
            ac.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", new Object[] { Integer.valueOf(j) });
            ((TestTimeForChatting)localObject2).IUI = 0;
            if ((Float.compare(k, com.tencent.mm.cc.a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 2.0F) <= 0) && (k >= 0)) {
              break label480;
            }
            ac.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", new Object[] { Integer.valueOf(j) });
            ((TestTimeForChatting)localObject2).IUJ = 0;
            label286:
            ac.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          }
          aj.P(((ViewGroup.MarginLayoutParams)localObject1).leftMargin, ((ViewGroup.MarginLayoutParams)localObject1).topMargin, ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
        }
        this.mRect.set(paramRect);
        if (!com.tencent.mm.compatible.util.d.kZ(14)) {
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
        ac.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(Build.VERSION.SDK_INT) });
        bool = super.fitSystemWindows(this.mRect);
        ac.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(33221);
        return bool;
        localObject1 = "pass";
        break;
        label471:
        ((TestTimeForChatting)localObject2).IUI = j;
        break label235;
        label480:
        ((TestTimeForChatting)localObject2).IUJ = k;
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
      return this.HkU;
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
        ac.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localClassCastException, "", new Object[0]);
        ac.e("MicroMsg.LauncherUI.HomeUI", "my layout params %s %s", new Object[] { getLayoutParams(), getLayoutParams().getClass() });
        int j = getChildCount();
        int i = 0;
        View localView;
        while (i < j)
        {
          localView = getChildAt(i);
          ac.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", new Object[] { Integer.valueOf(i), localView, localView.getLayoutParams(), localView.getLayoutParams().getClass() });
          i += 1;
        }
        i = 0;
        while (i < j)
        {
          localView = getChildAt(i);
          if (((localView instanceof ImageView)) && (localView.getId() == 2131303386) && (localView.getLayoutParams() != null) && ((localView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (!(localView.getLayoutParams() instanceof FrameLayout.LayoutParams))) {
            localView.setLayoutParams(new FrameLayout.LayoutParams(localView.getLayoutParams()));
          }
          ac.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", new Object[] { Integer.valueOf(i), localView, localView.getLayoutParams(), localView.getLayoutParams().getClass() });
          i += 1;
        }
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(33222);
      }
    }
    
    public void setActionBarContainer(ViewGroup paramViewGroup)
    {
      this.HkV = paramViewGroup;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(33218);
      HkQ = new a("ACTIVITY_CREATE", 0);
      HkR = new a("ACTIVITY_RESUME", 1);
      HkS = new a("ACTIVITY_PAUSE", 2);
      HkT = new a[] { HkQ, HkR, HkS };
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
      com.tencent.mm.kiss.a.b.ahR();
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
          com.tencent.mm.plugin.newtips.a.dkb().Ko(3);
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(10919, "0");
          HomeUI.s(HomeUI.this);
          if (HomeUI.HjZ.booleanValue())
          {
            paramAnonymousView = HomeUI.this;
            Boolean localBoolean = Boolean.TRUE;
            HomeUI.a(paramAnonymousView, localBoolean, localBoolean);
          }
          if (HomeUI.Hka.booleanValue()) {
            HomeUI.a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
          }
          if (!bt.eUi())
          {
            long l = bs.eWj();
            if (l - HomeUI.t(HomeUI.this) > 10000L)
            {
              HomeUI.a(HomeUI.this, l);
              HomeUI.u(HomeUI.this);
              AppMethodBeat.o(33224);
              return;
            }
            HomeUI.v(HomeUI.this);
            if (HomeUI.w(HomeUI.this) >= 5)
            {
              ac.w("MicroMsg.LauncherUI.HomeUI", "Switch to MonkeyEnv now.");
              bt.vY(true);
            }
          }
          AppMethodBeat.o(33224);
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
      AppMethodBeat.i(210121);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(210121);
    }
    
    public final boolean a(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dhn paramdhn)
    {
      return false;
    }
    
    public final boolean dbk()
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
    
    public final boolean nR(boolean paramBoolean)
    {
      AppMethodBeat.i(210122);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(210122);
      return paramBoolean;
    }
    
    public final boolean nS(boolean paramBoolean)
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
    
    public final boolean nT(boolean paramBoolean)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI
 * JD-Core Version:    0.7.0.1
 */