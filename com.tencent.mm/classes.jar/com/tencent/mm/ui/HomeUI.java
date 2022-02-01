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
import com.tencent.mm.al.e.a;
import com.tencent.mm.app.v;
import com.tencent.mm.aw.p;
import com.tencent.mm.aw.p.c;
import com.tencent.mm.blink.FirstScreenFrameLayout.a;
import com.tencent.mm.booter.y;
import com.tencent.mm.booter.y.1;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.g.a.db;
import com.tencent.mm.g.a.xk;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bo;
import com.tencent.mm.model.bo.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  public static Boolean IXG = Boolean.FALSE;
  public static Boolean IXH = Boolean.FALSE;
  private static boolean IXW = true;
  static final int IXY = 2131302248;
  static final int IXZ = 2131302237;
  private final long Ake;
  private long Akf;
  View ITG;
  private TextView ITj;
  boolean ITq;
  private TextView IXA;
  private boolean IXB;
  private String IXC;
  private String IXD;
  private String IXE;
  ae IXF;
  private final long IXI;
  private final long IXJ;
  private boolean IXK;
  private int IXL;
  private int IXM;
  private int IXN;
  HomeUI.a IXO;
  LauncherUI.a IXP;
  h IXQ;
  MainTabUI IXR;
  int IXS;
  int IXT;
  private boolean IXU;
  boolean IXV;
  View.OnLayoutChangeListener IXX;
  MMFragmentActivity IXa;
  private final long IXv;
  private final long IXw;
  public boolean IXx;
  boolean IXy;
  public boolean IXz;
  b IYa;
  View IYb;
  ImageView IYc;
  private View IYd;
  ImageView IYe;
  View IYf;
  MenuItem IYg;
  MenuItem IYh;
  private MenuItem IYi;
  MenuItem IYj;
  Menu IYk;
  private boolean IYl;
  Runnable IYm;
  private int IYn;
  private LinkedList<Runnable> IYo;
  com.tencent.mm.plugin.messenger.foundation.a.q IYp;
  private float IYq;
  private boolean IYr;
  private int clickCount;
  View contentView;
  private String dCB;
  private boolean jfA;
  LayoutInflater jfG;
  ActionBar mActionBar;
  private boolean mWl;
  MessageQueue.IdleHandler ogP;
  private long tQD;
  private final HashMap<String, Object> values;
  private View wGb;
  View wQp;
  com.tencent.mm.sdk.b.c yBT;
  
  public HomeUI()
  {
    AppMethodBeat.i(33232);
    this.IXv = 604800000L;
    this.IXw = 86400000L;
    this.jfA = true;
    this.IXx = false;
    this.dCB = null;
    this.IXz = false;
    this.ITq = false;
    this.IXB = false;
    this.IXI = 432000000L;
    this.IXJ = 604800000L;
    this.IXK = true;
    this.IXL = 0;
    this.IXM = 0;
    this.IXN = 0;
    this.IXO = HomeUI.a.IYx;
    this.IXR = new MainTabUI();
    this.IXS = 0;
    this.IXT = 0;
    this.IXU = false;
    this.IXV = true;
    this.IXX = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8) {}
    };
    this.mWl = ac.fko();
    this.IYl = true;
    this.clickCount = 0;
    this.tQD = 0L;
    this.values = new HashMap();
    this.yBT = new com.tencent.mm.sdk.b.c() {};
    this.ogP = new MessageQueue.IdleHandler()
    {
      public final boolean queueIdle()
      {
        AppMethodBeat.i(193674);
        ba.aBQ();
        if (bt.n((Integer)com.tencent.mm.model.c.ajl().get(15, null)) == 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI.HomeUI", "not init finish , do not post sync task");
          AppMethodBeat.o(193674);
          return false;
        }
        Object localObject = az.hFS.ax("login_user_name", "");
        if ((ba.aBR()) || (!((String)localObject).equals(""))) {
          ba.aiU().a(new bo(new bo.a()
          {
            public final void a(com.tencent.mm.network.e paramAnonymous2e) {}
          }, "launch normal"), 0);
        }
        com.tencent.mm.sdk.g.b.c(new y.1(new y(HomeUI.b(HomeUI.this))), "StartupReport_report");
        com.tencent.mm.booter.o.Xb();
        HomeUI.fwr();
        com.tencent.e.h.LTJ.aR(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193673);
            try
            {
              com.tencent.mm.plugin.report.service.e.dKn();
              AppMethodBeat.o(193673);
              return;
            }
            catch (Throwable localThrowable)
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI.HomeUI", "loadFilesToReport error message : " + localThrowable.getMessage());
              AppMethodBeat.o(193673);
            }
          }
        });
        localObject = p.aIt().ibT;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SendImgSpeeder", "POOL_AUTO_FILL_SIZE is 0");
        ((p.c)localObject).aIx();
        Looper.myQueue().removeIdleHandler(HomeUI.this.ogP);
        AppMethodBeat.o(193674);
        return false;
      }
    };
    this.IYm = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193675);
        if (((com.tencent.mm.s.a.n(HomeUI.b(HomeUI.this), true)) && (!com.tencent.mm.s.a.cd(HomeUI.b(HomeUI.this)))) || (com.tencent.mm.s.a.p(HomeUI.b(HomeUI.this), true)))
        {
          AppMethodBeat.o(193675);
          return;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("BaseScanUI_select_scan_mode", 1);
        localIntent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
        localIntent.putExtra("key_config_black_interval", true);
        localIntent.setFlags(65536);
        com.tencent.mm.plugin.report.service.g.yhR.f(11409, new Object[0]);
        com.tencent.mm.bs.d.b(HomeUI.b(HomeUI.this), "scanner", ".ui.BaseScanUI", localIntent);
        AppMethodBeat.o(193675);
      }
    };
    this.IYn = 0;
    this.Ake = 300L;
    this.Akf = SystemClock.elapsedRealtime();
    this.IYo = new LinkedList();
    this.IYp = new com.tencent.mm.plugin.messenger.foundation.a.q()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, e.a paramAnonymousa)
      {
        AppMethodBeat.i(193680);
        if ((bt.nullAsNil(paramAnonymousString).equals("showprivacypolicy")) && (paramAnonymousMap != null))
        {
          paramAnonymousString = (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.device_id");
          HomeUI.a(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_content"));
          HomeUI.b(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_ok"));
          HomeUI.c(HomeUI.this, (String)paramAnonymousMap.get(".sysmsg.showprivacypolicy.doublecheck_cancel"));
          boolean bool1 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needbirthday"));
          boolean bool2 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needopenplatform"));
          boolean bool3 = "yes".equals(paramAnonymousMap.get(".sysmsg.showprivacypolicy.needconfirm"));
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDy, Boolean.valueOf(bool1));
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDz, Boolean.valueOf(bool2));
          com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IDA, Boolean.valueOf(bool3));
          paramAnonymousMap = com.tencent.mm.bx.b.cj(com.tencent.mm.compatible.deviceinfo.q.aay().getBytes());
          paramAnonymousMap.Zz(16);
          paramAnonymousMap = Base64.encodeToString(paramAnonymousMap.toByteArray(), 2);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "deviceId:%s, localDeviceId:%s, doubleCheckContent:%s, doubleCheckOk:%s, doubleCheckCancel:%s, needBirthday:%s, needOpenPlatform:%s, needConfirm:%s", new Object[] { paramAnonymousString, paramAnonymousMap, HomeUI.C(HomeUI.this), HomeUI.E(HomeUI.this), HomeUI.D(HomeUI.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((bt.isNullOrNil(paramAnonymousString)) || (paramAnonymousString.equals(paramAnonymousMap)))
          {
            paramAnonymousString = com.tencent.mm.kernel.g.ajC().ajl().get(274436, "").toString();
            paramAnonymousMap = HomeUI.b(HomeUI.this);
            paramAnonymousa = ac.fks();
            int i;
            if (bool2)
            {
              i = 1;
              paramAnonymousMap = paramAnonymousMap.getString(2131760685, new Object[] { paramAnonymousa, paramAnonymousString, "login", Integer.valueOf(1), Integer.valueOf(i) });
              if (!com.tencent.mm.ax.b.FU(paramAnonymousString)) {
                break label534;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "eu true, needconfirm: %s", new Object[] { Boolean.valueOf(bool3) });
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
              com.tencent.mm.ui.base.b.kf(HomeUI.b(HomeUI.this));
              AppMethodBeat.o(193680);
              return;
              i = 0;
              break;
              label498:
              HomeUI.a(HomeUI.this, paramAnonymousMap, 22722, HomeUI.b(HomeUI.this).getString(2131760033, new Object[] { ac.fks() }));
              continue;
              label534:
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "eu false");
              paramAnonymousString = new Bundle();
              paramAnonymousString.putString("close_dialog_msg", HomeUI.b(HomeUI.this).getString(2131760682));
              paramAnonymousString.putString("close_dialog_cancel", HomeUI.b(HomeUI.this).getString(2131760803));
              paramAnonymousString.putString("close_dialog_ok", HomeUI.b(HomeUI.this).getString(2131760684));
              paramAnonymousString.putBoolean("close_dialog_ok_close", false);
              HomeUI.a(HomeUI.this, paramAnonymousMap, 22722, paramAnonymousString);
            }
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "device id not match");
        }
        AppMethodBeat.o(193680);
      }
    };
    this.IYq = 0.0F;
    this.IYr = false;
    AppMethodBeat.o(33232);
  }
  
  private void abz(int paramInt)
  {
    AppMethodBeat.i(33248);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(33248);
      return;
    }
    int i;
    if ((Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.compatible.util.g.abl())) {
      i = paramInt;
    }
    for (;;)
    {
      if (Math.abs(this.IYn - i) >= 50000) {}
      try
      {
        this.IXa.getWindow().setStatusBarColor(i);
        this.IYn = i;
        AppMethodBeat.o(33248);
        return;
        i = paramInt;
        if (Build.VERSION.SDK_INT < 21) {
          continue;
        }
        i = ao.v(this.IXa.getResources().getColor(2131100954), paramInt);
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localNullPointerException, "updateStatusBar %s", new Object[] { Integer.valueOf(i) });
        }
      }
    }
  }
  
  private void c(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(33236);
    if (this.wGb != null)
    {
      this.wGb.clearAnimation();
      this.wGb.setVisibility(8);
      if (paramBoolean1.booleanValue())
      {
        if (!paramBoolean2.booleanValue()) {
          break label89;
        }
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(340227, Boolean.TRUE);
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(232L, 0L, 1L, false);
        IXG = Boolean.FALSE;
      }
    }
    for (;;)
    {
      this.wGb = null;
      AppMethodBeat.o(33236);
      return;
      label89:
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(340230, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(232L, 5L, 1L, false);
      IXH = Boolean.FALSE;
    }
  }
  
  private void fuM()
  {
    AppMethodBeat.i(33253);
    if (this.IXa != null) {}
    try
    {
      this.IXa.moveTaskToBack(true);
      if (ba.ajx()) {
        ba.ajF().n(new HomeUI.22(this), 500L);
      }
      v.Ml().start();
      AppMethodBeat.o(33253);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localException, "", new Object[0]);
      }
    }
  }
  
  private boolean fvY()
  {
    return (this.IXL == 2) && (this.IXM == 2);
  }
  
  private static boolean fwk()
  {
    AppMethodBeat.i(33260);
    if (!com.tencent.mm.plugin.story.api.o.isShowStoryCheck())
    {
      AppMethodBeat.o(33260);
      return false;
    }
    if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(u.aAm()))
    {
      AppMethodBeat.o(33260);
      return true;
    }
    AppMethodBeat.o(33260);
    return false;
  }
  
  static boolean fwm()
  {
    AppMethodBeat.i(33264);
    boolean bool = ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).getStoryNewFeatureConfig().egX();
    AppMethodBeat.o(33264);
    return bool;
  }
  
  static boolean fwn()
  {
    AppMethodBeat.i(33265);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IJo, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(33265);
    return bool;
  }
  
  private void setActionBarColor(int paramInt)
  {
    AppMethodBeat.i(33256);
    if (this.mActionBar != null) {
      this.mActionBar.setBackgroundDrawable(new ColorDrawable(paramInt));
    }
    if (this.wQp != null) {
      this.wQp.setBackgroundColor(paramInt);
    }
    AppMethodBeat.o(33256);
  }
  
  @SuppressLint({"RestrictedApi"})
  private void updateTitle()
  {
    AppMethodBeat.i(33233);
    if (!this.IXK)
    {
      AppMethodBeat.o(33233);
      return;
    }
    int i = this.IXR.abZ;
    Object localObject1 = getString(2131755822);
    Object localObject2;
    if (i == 0) {
      if (this.mWl)
      {
        localObject1 = (String)localObject1 + com.tencent.mm.cd.g.is(this.IXa);
        localObject2 = localObject1;
        if (this.IXR.JcV.fxm() > 0)
        {
          localObject2 = localObject1;
          if (!this.mWl) {
            localObject2 = (String)localObject1 + " ";
          }
          localObject2 = (String)localObject2 + "(" + this.IXR.JcV.fxm() + ")";
        }
        localObject1 = new xk();
        ((xk)localObject1).dLJ.dLK = 1;
        ((xk)localObject1).dLJ.title = ((String)localObject2);
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = localObject2;
      }
    }
    label198:
    label861:
    for (;;)
    {
      if (i == 3)
      {
        abz(this.IXa.getResources().getColor(2131101053));
        if (fwk())
        {
          xh(true);
          label231:
          ((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).checkPost();
          if (this.mActionBar != null)
          {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.IXa.getResources().getColor(2131101053)));
            this.mActionBar.getCustomView().setVisibility(8);
          }
          if (this.wQp != null) {
            this.wQp.setBackgroundColor(this.IXa.getResources().getColor(2131101053));
          }
          this.IYl = false;
          if ((this.IXL != 3) || (this.IXM != 3)) {
            break label624;
          }
        }
        label624:
        for (i = 1;; i = 0)
        {
          if ((i != 0) && (this.IYj != null) && (!this.IYj.isVisible())) {
            this.IYj.setVisible(true);
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "alvinluo updateSettingTitle");
          this.mActionBar.setElevation(0.0F);
          this.mActionBar.gr();
          this.IXA = ((TextView)this.mActionBar.getCustomView().findViewById(16908308));
          if (this.IXA != null)
          {
            this.IXA.setText((CharSequence)localObject1);
            float f = com.tencent.mm.cc.a.ay(aj.getContext(), 2131165184) * com.tencent.mm.cc.a.ik(aj.getContext());
            if (this.IXA.getTextSize() != f) {
              this.IXA.setTextSize(0, f);
            }
            i = this.IXa.getResources().getColor(2131099886);
            if ((this.ITq) && (this.IXA.getCurrentTextColor() != i)) {
              this.IXA.setTextColor(i);
            }
            al.a(this.IXA.getPaint(), 0.8F);
          }
          AppMethodBeat.o(33233);
          return;
          localObject1 = (String)localObject1 + " " + com.tencent.mm.cd.g.is(this.IXa);
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
          xh(false);
          break label231;
        }
      }
      abz(this.IXa.getResources().getColor(2131100705));
      xh(this.ITq);
      localObject2 = this.mActionBar.getCustomView().getBackground();
      if ((localObject2 instanceof ColorDrawable)) {
        if (((ColorDrawable)localObject2).getColor() != this.IXa.getResources().getColor(2131100705)) {
          this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.IXa.getResources().getColor(2131100705)));
        }
      }
      for (;;)
      {
        if (this.mActionBar.getCustomView().getVisibility() != 0) {
          this.mActionBar.getCustomView().setVisibility(0);
        }
        this.IYl = true;
        if ((fvY()) && (this.IYg != null) && (!this.IYg.isVisible())) {
          this.IYg.setVisible(true);
        }
        if ((!fvY()) || (this.IYh == null) || (this.IYh.isVisible())) {
          break;
        }
        this.IYh.setVisible(true);
        break;
        this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.IXa.getResources().getColor(2131100705)));
      }
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
  
  private void xe(final boolean paramBoolean)
  {
    AppMethodBeat.i(33235);
    if (this.wGb != null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI.HomeUI", "tipsView already shown");
      AppMethodBeat.o(33235);
      return;
    }
    this.wGb = View.inflate(aj.getContext(), 2131495019, null);
    Object localObject = (TextView)this.wGb.findViewById(2131302803);
    if (paramBoolean) {
      ((TextView)localObject).setText(aj.getContext().getString(2131755139));
    }
    for (;;)
    {
      localObject = new FrameLayout.LayoutParams(-2, -2, 53);
      this.wGb.setBackgroundResource(2131233522);
      if (this.contentView != null)
      {
        ((ViewGroup)this.contentView).addView(this.wGb, (ViewGroup.LayoutParams)localObject);
        localObject = AnimationUtils.loadAnimation(aj.getContext(), 2130772132);
        this.wGb.startAnimation((Animation)localObject);
        this.wGb.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(163246);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
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
      ((TextView)localObject).setText(aj.getContext().getString(2131755136));
    }
  }
  
  private void xh(boolean paramBoolean)
  {
    AppMethodBeat.i(33249);
    View localView;
    int j;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localView = this.IXa.getWindow().getDecorView();
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
    MMFragment localMMFragment = getMainTabUI().fxb();
    if (localMMFragment != null)
    {
      if ((localMMFragment instanceof MoreTabUI))
      {
        setActionBarColor(this.IXa.getResources().getColor(2131101053));
        AppMethodBeat.o(33257);
        return;
      }
      if (!(localMMFragment instanceof MainUI)) {
        setActionBarColor(this.IXa.getResources().getColor(2131100705));
      }
      while (paramInt2 > 10)
      {
        v(this.ITG, false);
        v(this.IYb, false);
        AppMethodBeat.o(33257);
        return;
        setActionBarColor(paramInt1);
      }
      v(this.ITG, true);
      v(this.IYb, true);
    }
    AppMethodBeat.o(33257);
  }
  
  public final void a(FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(33245);
    this.IXa.getWindow().getDecorView().getBottom();
    this.IXa.getSupportActionBar().getCustomView().getBottom();
    paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
    paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
    AppMethodBeat.o(33245);
  }
  
  public final void aF(Runnable paramRunnable)
  {
    AppMethodBeat.i(33251);
    this.IYo.remove(paramRunnable);
    AppMethodBeat.o(33251);
  }
  
  public final void b(float paramFloat, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33258);
    if ((paramInt1 != 0) && (this.IXA != null)) {
      this.IXA.setTextColor(paramInt1);
    }
    if (this.IYe != null)
    {
      if (this.IYr) {
        this.IYe.setAlpha(paramFloat);
      }
      this.IYe.setImageDrawable(ao.k(this.IXa, 2131689494, paramInt2));
    }
    if (this.IYc != null)
    {
      if (this.IYr) {
        this.IYc.setAlpha(paramFloat);
      }
      this.IYc.setImageDrawable(ao.k(this.IXa, 2131690510, paramInt2));
    }
    AppMethodBeat.o(33258);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(33252);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI.HomeUI", "ui group onKeyDown, code:%d action:%d", new Object[] { Integer.valueOf(paramKeyEvent.getKeyCode()), Integer.valueOf(paramKeyEvent.getAction()) });
    com.tencent.mm.compatible.b.g.ZK();
    com.tencent.mm.compatible.b.g.ZK();
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1) && (this.IXF != null) && (this.IXF.isShowing()))
    {
      this.IXF.dismiss();
      AppMethodBeat.o(33252);
      return true;
    }
    if ((paramKeyEvent.getKeyCode() == 82) && (paramKeyEvent.getAction() == 1))
    {
      fwa();
      AppMethodBeat.o(33252);
      return true;
    }
    Object localObject1 = this.IXR.fxb();
    if ((localObject1 != null) && (((MMFragment)localObject1).onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(33252);
      return true;
    }
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      if ((ba.ajx()) && (com.tencent.mm.kernel.g.ajA().gAD) && (ay.isWap(this.IXa)))
      {
        Object localObject2 = this.IXa;
        paramKeyEvent = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(33196);
            HomeUI.B(HomeUI.this);
            AppMethodBeat.o(33196);
          }
        };
        if (!ba.ajx()) {
          i = 0;
        }
        while (i != 0)
        {
          AppMethodBeat.o(33252);
          return true;
          ba.aBQ();
          i = ((Integer)com.tencent.mm.model.c.ajl().get(65, Integer.valueOf(0))).intValue();
          if (i >= 5)
          {
            i = 0;
          }
          else if (!an.aQu("show_wap_adviser"))
          {
            i = 0;
          }
          else
          {
            localObject1 = View.inflate((Context)localObject2, 2131495013, null);
            ((TextView)((View)localObject1).findViewById(2131302708)).setText(2131761551);
            localObject2 = new d.a((Context)localObject2);
            ((d.a)localObject2).afe(2131755906);
            ((d.a)localObject2).gY((View)localObject1);
            ((d.a)localObject2).afl(2131755835).c(new MMAppMgr.1(i));
            ((d.a)localObject2).yR(false);
            ((d.a)localObject2).afm(2131761545).d(new MMAppMgr.7());
            ((d.a)localObject2).a(new MMAppMgr.8(paramKeyEvent));
            ((d.a)localObject2).fMb().show();
            i = 1;
          }
        }
      }
      final int i = ay.getBackgroundLimitType(this.IXa);
      if ((ba.ajx()) && (com.tencent.mm.kernel.g.ajA().gAD) && (ay.isLimited(i)))
      {
        ba.aBQ();
        if ((bt.n((Boolean)com.tencent.mm.model.c.ajl().get(16385, null))) && (MMAppMgr.a(this.IXa, i, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(163261);
            try
            {
              ay.startSettingItent(HomeUI.b(HomeUI.this), i);
              AppMethodBeat.o(163261);
              return;
            }
            catch (Exception paramAnonymousDialogInterface)
            {
              com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", paramAnonymousDialogInterface, "", new Object[0]);
              AppMethodBeat.o(163261);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(193677);
            HomeUI.B(HomeUI.this);
            AppMethodBeat.o(193677);
          }
        })))
        {
          AppMethodBeat.o(33252);
          return true;
        }
      }
      fuM();
    }
    AppMethodBeat.o(33252);
    return false;
  }
  
  final void fvZ()
  {
    AppMethodBeat.i(33234);
    if (!ba.ajx())
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready");
      AppMethodBeat.o(33234);
      return;
    }
    ba.aBQ();
    Boolean localBoolean = Boolean.valueOf(bt.o((Boolean)com.tencent.mm.model.c.ajl().get(340227, null)));
    if ((!localBoolean.booleanValue()) && (!l.Kml.booleanValue()))
    {
      IXG = Boolean.TRUE;
      xe(true);
    }
    long l1 = System.currentTimeMillis();
    ba.aBQ();
    long l2 = bt.a((Long)com.tencent.mm.model.c.ajl().get(340240, null), 0L);
    ba.aBQ();
    boolean bool1 = bt.o((Boolean)com.tencent.mm.model.c.ajl().get(340230, null));
    ba.aBQ();
    boolean bool2 = bt.o((Boolean)com.tencent.mm.model.c.ajl().get(340228, null));
    ba.aBQ();
    boolean bool3 = bt.o((Boolean)com.tencent.mm.model.c.ajl().get(340229, null));
    if ((localBoolean.booleanValue()) && (Boolean.valueOf(bool2).booleanValue()) && (Boolean.valueOf(bool3).booleanValue()) && (!Boolean.valueOf(bool1).booleanValue()) && (l1 - l2 >= 432000000L))
    {
      IXH = Boolean.TRUE;
      xe(false);
    }
    AppMethodBeat.o(33234);
  }
  
  final void fwa()
  {
    AppMethodBeat.i(33237);
    if ((this.IXF == null) || (!ba.ajx()))
    {
      AppMethodBeat.o(33237);
      return;
    }
    if (this.IXF.isShowing())
    {
      this.IXF.dismiss();
      AppMethodBeat.o(33237);
      return;
    }
    this.IXF.il();
    AppMethodBeat.o(33237);
  }
  
  final void fwb()
  {
    AppMethodBeat.i(33239);
    int i;
    if (this.IYj != null)
    {
      this.IYj.setShowAsAction(2);
      if (this.IYl) {
        break label224;
      }
      if (!(this.IXR.fxb() instanceof MoreTabUI)) {
        break label219;
      }
      MoreTabUI localMoreTabUI = (MoreTabUI)this.IXR.fxb();
      if ((localMoreTabUI.Jdx != null) && (localMoreTabUI.Jdx.isVisible))
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
        this.IYj.setVisible(true);
      }
    }
    else
    {
      label94:
      if (this.IYh != null)
      {
        if (!this.IYl) {
          break label249;
        }
        this.IYh.setShowAsAction(2);
        this.IYh.setVisible(true);
      }
      label129:
      if (this.IYg != null)
      {
        if (!this.IYl) {
          break label274;
        }
        this.IYg.setShowAsAction(2);
        this.IYg.setVisible(true);
      }
    }
    for (;;)
    {
      if (this.IYi != null)
      {
        if (!this.IYl)
        {
          this.IYi.setShowAsAction(2);
          this.IYi.setVisible(true);
          this.ITj.setVisibility(0);
          AppMethodBeat.o(33239);
          return;
          i = 0;
          break;
          label219:
          i = 0;
          break label79;
          label224:
          this.IYj.setVisible(false);
          this.IYj.setEnabled(false);
          break label94;
          label249:
          this.IYh.setVisible(false);
          this.IYh.setEnabled(false);
          break label129;
          label274:
          this.IYg.setVisible(false);
          this.IYg.setEnabled(false);
          continue;
        }
        this.IYi.setVisible(false);
        this.IYi.setEnabled(false);
        this.ITj.setVisibility(8);
      }
    }
    AppMethodBeat.o(33239);
  }
  
  final void fwc()
  {
    AppMethodBeat.i(33240);
    if (!((n)com.tencent.mm.kernel.g.ad(n.class)).isFTSIndexReady())
    {
      Toast.makeText(aj.getContext(), 2131762954, 0).show();
      AppMethodBeat.o(33240);
      return;
    }
    int i = this.IXR.abZ;
    if (i == 0) {
      getMainTabUI().fxb();
    }
    Intent localIntent = new Intent().putExtra("from_tab_index", i).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = localObject2;
      if (!al.isDarkMode()) {
        localObject1 = ActivityOptions.makeSceneTransitionAnimation(this.IXa, new Pair[0]).toBundle();
      }
    }
    com.tencent.mm.plugin.fts.a.d.b(this.IXa, ".ui.FTSMainUI", localIntent, (Bundle)localObject1);
    AppMethodBeat.o(33240);
  }
  
  final void fwd()
  {
    AppMethodBeat.i(33242);
    if ((fwm()) && (fwn())) {
      this.IXV = false;
    }
    if (fwm()) {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IJo, Boolean.FALSE);
    }
    if (this.IYf != null)
    {
      this.IYf.findViewById(2131305884).setVisibility(8);
      localObject = com.tencent.mm.plugin.story.h.h.ASt;
      com.tencent.mm.plugin.story.h.h.AQ(0L);
    }
    if (!((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).canPostStory())
    {
      com.tencent.mm.kernel.g.ajD();
      int i = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IFl, Integer.valueOf(0))).intValue();
      com.tencent.mm.ui.base.h.c(this.IXa, "", this.IXa.getResources().getString(2131764291, new Object[] { Integer.valueOf(i) }), true);
      AppMethodBeat.o(33242);
      return;
    }
    Object localObject = (com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class);
    MMFragmentActivity localMMFragmentActivity = this.IXa;
    com.tencent.mm.plugin.story.h.h localh = com.tencent.mm.plugin.story.h.h.ASt;
    ((com.tencent.mm.plugin.story.api.e)localObject).startStoryCaptureForResult(localMMFragmentActivity, 0, com.tencent.mm.plugin.story.h.h.ekr(), 10);
    AppMethodBeat.o(33242);
  }
  
  public final void fwe()
  {
    AppMethodBeat.i(33243);
    if ((u.aBd().booleanValue()) && ((IXG.booleanValue()) || (IXH.booleanValue())))
    {
      Boolean localBoolean = Boolean.FALSE;
      c(localBoolean, localBoolean);
    }
    this.IXR.fwe();
    AppMethodBeat.o(33243);
  }
  
  public final void fwf()
  {
    AppMethodBeat.i(33244);
    ba.ajF().fkR();
    this.IXR.fxf();
    aq.f(this.IYm);
    AppMethodBeat.o(33244);
  }
  
  public final boolean fwg()
  {
    return this.IXO == HomeUI.a.IYy;
  }
  
  public final void fwh()
  {
    AppMethodBeat.i(33254);
    updateTitle();
    AppMethodBeat.o(33254);
  }
  
  public final void fwi()
  {
    AppMethodBeat.i(33255);
    this.IXR.fwi();
    AppMethodBeat.o(33255);
  }
  
  public final void fwj()
  {
    AppMethodBeat.i(33259);
    this.IXR.abL(170);
    AppMethodBeat.o(33259);
  }
  
  final void fwl()
  {
    AppMethodBeat.i(33261);
    if ((this.IYj != null) && (this.IYj.getActionView() != null))
    {
      ImageView localImageView = (ImageView)this.IYj.getActionView().findViewById(2131300874);
      localImageView.setImageDrawable(this.IXa.getResources().getDrawable(2131690361));
      if (fwk())
      {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
        if (!this.IXV) {
          break label169;
        }
        if ((!fwm()) || (!fwn())) {
          break label164;
        }
      }
      label164:
      for (boolean bool = true;; bool = false)
      {
        this.IXV = bool;
        this.IYj.getActionView().findViewById(2131305884).setVisibility(0);
        AppMethodBeat.o(33261);
        return;
        localImageView.setColorFilter(new PorterDuffColorFilter(this.IXa.getResources().getColor(2131099664), PorterDuff.Mode.SRC_ATOP));
        break;
      }
      label169:
      this.IYj.getActionView().findViewById(2131305884).setVisibility(8);
    }
    AppMethodBeat.o(33261);
  }
  
  public MainTabUI getMainTabUI()
  {
    return this.IXR;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(33241);
    String str = this.IXa.getString(paramInt);
    AppMethodBeat.o(33241);
    return str;
  }
  
  final void initActionBar()
  {
    AppMethodBeat.i(33247);
    if (this.IXP.fwF())
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground True!");
      AppMethodBeat.o(33247);
      return;
    }
    this.ITq = al.isDarkMode();
    this.mActionBar.setLogo(new ColorDrawable(this.IXa.getResources().getColor(17170445)));
    this.mActionBar.gm();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.gl();
    this.mActionBar.gn();
    this.mActionBar.setCustomView(z.jO(this.IXa).inflate(2131492927, new LinearLayout(this.IXa), false));
    ImageView localImageView = (ImageView)this.mActionBar.getCustomView().findViewById(2131296417);
    if (localImageView != null) {
      localImageView.getDrawable().setColorFilter(this.IXa.getResources().getColor(2131099732), PorterDuff.Mode.SRC_ATOP);
    }
    this.mActionBar.setBackgroundDrawable(ao.k(this.IXa, 2131100196, this.IXa.getResources().getColor(2131099664)));
    updateTitle();
    this.mActionBar.getCustomView().findViewById(2131296414).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193676);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (SystemClock.elapsedRealtime() - HomeUI.z(HomeUI.this) < 300L)
        {
          paramAnonymousView = HomeUI.A(HomeUI.this).iterator();
          while (paramAnonymousView.hasNext()) {
            ((Runnable)paramAnonymousView.next()).run();
          }
        }
        HomeUI.b(HomeUI.this, SystemClock.elapsedRealtime());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/HomeUI$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(193676);
      }
    });
    AppMethodBeat.o(33247);
  }
  
  public final void setTitleBarDoubleClickListener(Runnable paramRunnable)
  {
    AppMethodBeat.i(33250);
    if (!this.IYo.contains(paramRunnable)) {
      this.IYo.add(paramRunnable);
    }
    AppMethodBeat.o(33250);
  }
  
  final void xf(boolean paramBoolean)
  {
    AppMethodBeat.i(33238);
    if ((this.IXF == null) || (this.IYb == null) || (this.IYa == null))
    {
      AppMethodBeat.o(33238);
      return;
    }
    if (!ba.ajx())
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI.HomeUI", "want update more menu new tips, but mmcore not ready");
      AppMethodBeat.o(33238);
      return;
    }
    this.IXF.Jfc.xv(paramBoolean);
    Object localObject = this.IYa;
    if (!com.tencent.mm.plugin.newtips.a.g.a(((b)localObject).IYs.IXF.Jfc.fra(), (com.tencent.mm.plugin.newtips.a.a)localObject))
    {
      if (!((b)localObject).IYs.IXF.Jfc.fra()) {
        break label196;
      }
      ((b)localObject).IYs.IYd.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.plugin.newtips.a.g.a((com.tencent.mm.plugin.newtips.a.a)localObject, k.wsL, ((b)localObject).IYs.IXF.Jfc.fra());
      localObject = new xk();
      ((xk)localObject).dLJ.dLK = 2;
      ((xk)localObject).dLJ.dLL = this.IXF.Jfc.fra();
      ((xk)localObject).dLJ.dLM = false;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      AppMethodBeat.o(33238);
      return;
      label196:
      ((b)localObject).IYs.IYd.setVisibility(8);
    }
  }
  
  public final void xg(boolean paramBoolean)
  {
    AppMethodBeat.i(33246);
    if (!paramBoolean) {
      initActionBar();
    }
    this.IXa.supportInvalidateOptionsMenu();
    if (u.aBd().booleanValue()) {
      fvZ();
    }
    this.IXR.fxe();
    AppMethodBeat.o(33246);
  }
  
  public final void xi(boolean paramBoolean)
  {
    AppMethodBeat.i(33262);
    if ((this.IYj != null) && (this.IYj.getActionView() != null) && (this.IXa != null))
    {
      if (this.IXa.getResources().getConfiguration().orientation == 2)
      {
        this.IYj.setVisible(false);
        this.IYj.setEnabled(false);
        AppMethodBeat.o(33262);
        return;
      }
      this.IYj.setVisible(true);
      this.IYj.setEnabled(true);
      ImageView localImageView = (ImageView)this.IYj.getActionView().findViewById(2131300874);
      localImageView.setImageDrawable(this.IXa.getResources().getDrawable(2131690361));
      if ((paramBoolean) || (al.isDarkMode())) {
        localImageView.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
      }
      while (this.IXV)
      {
        this.IYj.getActionView().findViewById(2131305884).setVisibility(0);
        AppMethodBeat.o(33262);
        return;
        localImageView.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.SRC_ATOP));
      }
      this.IYj.getActionView().findViewById(2131305884).setVisibility(8);
    }
    AppMethodBeat.o(33262);
  }
  
  public static class FitSystemWindowLayoutView
    extends FrameLayout
  {
    private int IYB;
    private ViewGroup IYC;
    private Rect mRect;
    
    public FitSystemWindowLayoutView(Context paramContext)
    {
      super();
      AppMethodBeat.i(33220);
      this.mRect = new Rect();
      this.IYC = null;
      AppMethodBeat.o(33220);
    }
    
    public FitSystemWindowLayoutView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(33219);
      this.mRect = new Rect();
      this.IYC = null;
      AppMethodBeat.o(33219);
    }
    
    @TargetApi(14)
    public boolean fitSystemWindows(Rect paramRect)
    {
      AppMethodBeat.i(33221);
      Object localObject2 = paramRect.toString();
      int i = this.IYB;
      int j = hashCode();
      Object localObject1;
      int k;
      label156:
      label235:
      boolean bool;
      if (paramRect.height() == 0)
      {
        localObject1 = bt.flS();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d stack:%s", new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j), localObject1 });
        if (paramRect.top > 0) {
          this.IYB = paramRect.top;
        }
        if ((this.IYC != null) && ((this.IYC.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
        {
          localObject1 = (ViewGroup.MarginLayoutParams)this.IYC.getLayoutParams();
          j = ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
          k = ((ViewGroup.MarginLayoutParams)localObject1).rightMargin;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
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
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", new Object[] { Integer.valueOf(j) });
            ((TestTimeForChatting)localObject2).KLM = 0;
            if ((Float.compare(k, com.tencent.mm.cc.a.fromDPToPix(((TestTimeForChatting)localObject2).getContext(), 48) * 2.0F) <= 0) && (k >= 0)) {
              break label480;
            }
            com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", new Object[] { Integer.valueOf(j) });
            ((TestTimeForChatting)localObject2).KLN = 0;
            label286:
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          }
          al.P(((ViewGroup.MarginLayoutParams)localObject1).leftMargin, ((ViewGroup.MarginLayoutParams)localObject1).topMargin, ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
        }
        this.mRect.set(paramRect);
        if (!com.tencent.mm.compatible.util.d.ly(14)) {
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(Build.VERSION.SDK_INT) });
        bool = super.fitSystemWindows(this.mRect);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(33221);
        return bool;
        localObject1 = "pass";
        break;
        label471:
        ((TestTimeForChatting)localObject2).KLM = j;
        break label235;
        label480:
        ((TestTimeForChatting)localObject2).KLN = k;
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
      return this.IYB;
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
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", localClassCastException, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI.HomeUI", "my layout params %s %s", new Object[] { getLayoutParams(), getLayoutParams().getClass() });
        int j = getChildCount();
        int i = 0;
        View localView;
        while (i < j)
        {
          localView = getChildAt(i);
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", new Object[] { Integer.valueOf(i), localView, localView.getLayoutParams(), localView.getLayoutParams().getClass() });
          i += 1;
        }
        i = 0;
        while (i < j)
        {
          localView = getChildAt(i);
          if (((localView instanceof ImageView)) && (localView.getId() == 2131303386) && (localView.getLayoutParams() != null) && ((localView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (!(localView.getLayoutParams() instanceof FrameLayout.LayoutParams))) {
            localView.setLayoutParams(new FrameLayout.LayoutParams(localView.getLayoutParams()));
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", new Object[] { Integer.valueOf(i), localView, localView.getLayoutParams(), localView.getLayoutParams().getClass() });
          i += 1;
        }
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(33222);
      }
    }
    
    public void setActionBarContainer(ViewGroup paramViewGroup)
    {
      this.IYC = paramViewGroup;
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
      com.tencent.mm.kiss.a.b.akC();
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/HomeUI$PlusActionView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          com.tencent.mm.plugin.newtips.a.dun().LQ(3);
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10919, "0");
          HomeUI.s(HomeUI.this);
          if (HomeUI.IXG.booleanValue())
          {
            paramAnonymousView = HomeUI.this;
            localObject = Boolean.TRUE;
            HomeUI.a(paramAnonymousView, (Boolean)localObject, (Boolean)localObject);
          }
          if (HomeUI.IXH.booleanValue()) {
            HomeUI.a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
          }
          if (!bu.fjL())
          {
            long l = bt.flT();
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
              com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.LauncherUI.HomeUI", "Switch to MonkeyEnv now.");
              bu.wK(true);
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
      AppMethodBeat.i(221389);
      com.tencent.mm.plugin.newtips.a.g.a(this, paramk, paramBoolean);
      AppMethodBeat.o(221389);
    }
    
    public final boolean a(boolean paramBoolean, dnc paramdnc)
    {
      return false;
    }
    
    public final boolean b(boolean paramBoolean, dnc paramdnc)
    {
      return false;
    }
    
    public final boolean c(boolean paramBoolean, dnc paramdnc)
    {
      return false;
    }
    
    public final boolean d(boolean paramBoolean, dnc paramdnc)
    {
      return false;
    }
    
    public final boolean dkD()
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
    
    public final boolean ol(boolean paramBoolean)
    {
      AppMethodBeat.i(221390);
      paramBoolean = com.tencent.mm.plugin.newtips.a.g.a(paramBoolean, this);
      AppMethodBeat.o(221390);
      return paramBoolean;
    }
    
    public final boolean om(boolean paramBoolean)
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
    
    public final boolean on(boolean paramBoolean)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.HomeUI
 * JD-Core Version:    0.7.0.1
 */