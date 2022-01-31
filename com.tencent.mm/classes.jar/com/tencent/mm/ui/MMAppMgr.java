package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.LocationManager;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.provider.Settings.Secure;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mars.BaseEvent;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.be.e.1;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.z.a;
import com.tencent.mm.h.a.cs;
import com.tencent.mm.h.a.gb;
import com.tencent.mm.h.a.gy;
import com.tencent.mm.h.a.jf;
import com.tencent.mm.h.a.k;
import com.tencent.mm.h.a.nm;
import com.tencent.mm.h.a.oi;
import com.tencent.mm.h.a.rp;
import com.tencent.mm.h.a.sf;
import com.tencent.mm.h.a.un;
import com.tencent.mm.h.a.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.h.a;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bt;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.webview.ui.tools.bag.l;
import com.tencent.mm.plugin.webview.ui.tools.bag.l.a;
import com.tencent.mm.pluginsdk.f.f;
import com.tencent.mm.pluginsdk.f.f.b;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.xweb.s;
import java.util.Map;

public final class MMAppMgr
{
  private static long reZ;
  static StringBuffer uNI;
  long eAr;
  String foU;
  public MMAppMgr.Receiver uNJ;
  boolean uNK = false;
  boolean uNL = false;
  final am uNM = new am(new MMAppMgr.1(this), true);
  private final am uNN = new am(Looper.getMainLooper(), new am.a()
  {
    public final boolean tC()
    {
      if (MMAppMgr.this.uNL == MMAppMgr.this.uNK)
      {
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMAppMgr", "status not changed, cur=" + MMAppMgr.this.uNL);
        return true;
      }
      if (au.Hp()) {
        return false;
      }
      MMAppMgr.this.uNL = MMAppMgr.this.uNK;
      boolean bool = MMAppMgr.this.uNL;
      if (!MatrixReport.isInstalled()) {
        com.tencent.matrix.d.b.e("Matrix.Manager", "onForeground, matrix report is not installed, just return", new Object[0]);
      }
      for (;;)
      {
        BaseEvent.onForeground(MMAppMgr.this.uNL);
        com.tencent.mm.am.a.bU(MMAppMgr.this.uNL);
        if (!MMAppMgr.this.uNL) {
          break label674;
        }
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMAppMgr", "[ACTIVATED MODE]");
        au.Dk().bN(true);
        if ((au.DK()) && (g.DN().dJH) && (!au.CW()))
        {
          localObject1 = com.tencent.mm.booter.z.diw;
          if (!((com.tencent.mm.booter.z)localObject1).hasInit)
          {
            ((com.tencent.mm.booter.z)localObject1).hasInit = true;
            Object localObject2 = com.tencent.mm.model.c.c.IX().fJ("100066");
            if (((com.tencent.mm.storage.c)localObject2).isValid())
            {
              localObject2 = ((com.tencent.mm.storage.c)localObject2).ctr();
              ((com.tencent.mm.booter.z)localObject1).diI = ah.getInt((String)((Map)localObject2).get("maxCacheCount"), 20);
              ((com.tencent.mm.booter.z)localObject1).diJ = ah.getInt((String)((Map)localObject2).get("maxCacheHours"), 24);
            }
            localObject2 = com.tencent.mm.model.c.c.IX().fJ("100058");
            if (((com.tencent.mm.storage.c)localObject2).isValid())
            {
              localObject2 = ((com.tencent.mm.storage.c)localObject2).ctr();
              ((com.tencent.mm.booter.z)localObject1).diK = ah.getInt((String)((Map)localObject2).get("cacheLogCount"), 30);
              ((com.tencent.mm.booter.z)localObject1).diL = ah.getInt((String)((Map)localObject2).get("maxCacheTime"), 10800);
            }
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.StayTimeReport", "initAbtestChattingArg appMaxCnt:%d, appMaxHour:%d, chattingMaxCnt:%d, chattingMaxSeconds:%d", new Object[] { Integer.valueOf(((com.tencent.mm.booter.z)localObject1).diI), Integer.valueOf(((com.tencent.mm.booter.z)localObject1).diJ), Integer.valueOf(((com.tencent.mm.booter.z)localObject1).diK), Integer.valueOf(((com.tencent.mm.booter.z)localObject1).diL) });
          }
          com.tencent.mm.modelsimple.c.bZ(true);
          com.tencent.mm.modelmulti.n.Pm().iT(3);
          au.Dk().a(new com.tencent.mm.modelmulti.h(), 0);
          com.tencent.mm.blink.b.vG().k(new MMAppMgr.8.1(this));
          bt.If().d(19, new Object[] { Integer.valueOf(1) });
          localObject1 = com.tencent.mm.be.e.Rk();
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
          ((com.tencent.mm.be.e)localObject1).elq.mw(true);
          com.tencent.mm.as.o.OL().bN(true);
          if (f.rVL != null) {
            f.rVL.bLR();
          }
          localObject1 = new k();
          ((k)localObject1).bFj.bFk = true;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
          com.tencent.mm.modelstat.o.jl(4);
          com.tencent.mm.modelstat.o.jl(3);
          com.tencent.mm.modelstat.o.cc(true);
          localObject1 = new rp();
          ((rp)localObject1).cbe.cbf = true;
          ((rp)localObject1).cbe.scene = 1;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
          localObject1 = new un();
          ((un)localObject1).cfh.bHz = 5;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
          localObject1 = new gy();
          ((gy)localObject1).bOM.bHz = 2;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        }
        au.Dk().bM(false);
        ae.getContext().getSharedPreferences("notify_prep", 0).edit().putBoolean("longNoopIntervalFlag", false).commit();
        if (MMAppMgr.this.uNM.crl()) {
          break;
        }
        MMAppMgr.this.uNM.stopTimer();
        return true;
        MatrixReport.with().onForeground(bool);
      }
      label674:
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMAppMgr", "[DEACTIVATED MODE]");
      MMAppMgr.this.eAr = bk.UZ();
      MMAppMgr.this.foU = "desktop";
      Object localObject1 = new k();
      ((k)localObject1).bFj.bFk = false;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      au.Dk().bN(false);
      if (au.DK())
      {
        g.DQ();
        if (g.DN().dJH)
        {
          com.tencent.mm.bs.a.Xn(com.tencent.mm.bs.a.coA());
          localObject1 = com.tencent.mm.be.e.Rk();
          Looper.myQueue().addIdleHandler(new e.1((com.tencent.mm.be.e)localObject1));
          localObject1 = new nm();
          ((nm)localObject1).bXg.state = 0;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
          localObject1 = new sf();
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
          localObject1 = new com.tencent.mm.h.a.d();
          ((com.tencent.mm.h.a.d)localObject1).bES.bET = false;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
          localObject1 = new oi();
          ((oi)localObject1).bXW.axD = false;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
          com.tencent.mm.as.o.OL().bN(false);
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod]");
          au.Hx();
          localObject1 = com.tencent.mm.model.c.Dz().get(327808, null);
          if (localObject1 != null) {
            break label1205;
          }
          bool = true;
        }
      }
      for (;;)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMAppMgr", "[oneliang][statInputMethod] needToStat:%s", new Object[] { String.valueOf(bool) });
          if (bool) {}
          try
          {
            localObject1 = Settings.Secure.getString(ae.getContext().getContentResolver(), "default_input_method");
            com.tencent.mm.plugin.report.service.h.nFQ.aC(11375, bk.pm((String)localObject1));
            au.Hx();
            com.tencent.mm.model.c.Dz().o(327808, Long.valueOf(System.currentTimeMillis()));
            localObject1 = new cs();
            ((cs)localObject1).bIS.state = 0;
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
            localObject1 = new un();
            ((un)localObject1).cfh.bHz = 3;
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
            localObject1 = new gy();
            ((gy)localObject1).bOM.bHz = 1;
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
            com.tencent.mm.modelsimple.c.bZ(false);
            com.tencent.mm.modelstat.o.cc(false);
            if (!MMAppMgr.this.uNM.crl()) {
              MMAppMgr.this.uNM.stopTimer();
            }
            if ((bk.bu(ae.getContext(), ae.getPackageName() + ":tools")) || (bk.bu(ae.getContext(), ae.getPackageName() + ":toolsmp")))
            {
              bool = true;
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMAppMgr", "before kill tools, tools is running : %b", new Object[] { Boolean.valueOf(bool) });
              if (!bool) {
                break;
              }
              MMAppMgr.this.uNM.S(60000L, 60000L);
              return true;
              label1205:
              if (bk.bl(localObject1.toString()))
              {
                bool = true;
                continue;
              }
              long l = bk.ZS(localObject1.toString());
              if (System.currentTimeMillis() - l < 604800000L) {
                break label1283;
              }
              bool = true;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMAppMgr", "[oneliang][inputMethodStat]exception:" + localException.getMessage());
              continue;
              bool = false;
            }
            label1283:
            bool = false;
          }
        }
      }
    }
  }, false);
  public int uNO = 0;
  boolean uNP = true;
  private final am uNQ = new am(Looper.getMainLooper(), new MMAppMgr.9(this), true);
  
  public static void Y(Activity paramActivity)
  {
    com.tencent.mm.br.d.b(paramActivity, "whatsnew", ".ui.WhatsNewUI", new Intent(), 57005);
  }
  
  public static boolean a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences(ae.cqR(), 0);
    boolean bool = localSharedPreferences.getBoolean("gprs_alert", true);
    com.tencent.mm.sdk.platformtools.e.uel &= bool;
    if (bool)
    {
      View localView = View.inflate(paramActivity, R.i.gprs_alert_dialog_view, null);
      CheckBox localCheckBox = (CheckBox)localView.findViewById(R.h.gprs_alert_cb);
      paramOnClickListener = com.tencent.mm.ui.base.h.a(paramActivity, false, null, localView, paramActivity.getString(R.l.confirm_dialog_ok), paramActivity.getString(R.l.main_exit), new MMAppMgr.2(localCheckBox, localSharedPreferences, paramActivity, paramOnClickListener), new MMAppMgr.3(paramActivity));
      if (paramOnClickListener == null) {
        return false;
      }
      paramOnClickListener.setOnCancelListener(new MMAppMgr.4(paramActivity));
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, int paramInt, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    View localView = View.inflate(paramContext, R.i.network_tips, null);
    Object localObject = (CheckBox)localView.findViewById(R.h.network_tips_cb);
    ((CheckBox)localObject).setText(paramContext.getString(R.l.network_cancel));
    ((CheckBox)localObject).setOnCheckedChangeListener(new MMAppMgr.5());
    localView.findViewById(R.h.network_tips_subcontent).setVisibility(8);
    localObject = (TextView)localView.findViewById(R.h.network_tips_content);
    switch (paramInt)
    {
    case 2: 
    default: 
      ((TextView)localObject).setText(R.l.network_wifi_limited);
      paramInt = 1;
    }
    while (paramInt != 0)
    {
      paramContext = new c.a(paramContext);
      paramContext.Ip(R.l.app_tip);
      paramContext.nW(false);
      paramContext.ei(localView);
      paramContext.Is(R.l.network_ok).a(paramOnClickListener1);
      paramContext.It(R.l.network_cancel).b(paramOnClickListener2);
      paramContext.aoP().show();
      return true;
      ((TextView)localObject).setText(R.l.network_wifi_limited);
      paramInt = 0;
      continue;
      ((TextView)localObject).setText(R.l.network_bg_process_limited);
      paramInt = 1;
    }
    return false;
  }
  
  public static void aK(Context paramContext)
  {
    i(paramContext, true);
  }
  
  public static com.tencent.mm.ui.widget.a.c aM(Context paramContext)
  {
    try
    {
      localObject = (LocationManager)paramContext.getSystemService("location");
      if (aq.isWifi(paramContext))
      {
        boolean bool = ((LocationManager)localObject).isProviderEnabled("gps");
        if (bool) {
          return null;
        }
      }
    }
    catch (Exception paramContext)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.MMAppMgr", paramContext, "showLbsTipsAlert error", new Object[0]);
      return null;
    }
    au.Hx();
    Object localObject = (Boolean)com.tencent.mm.model.c.Dz().get(4105, Boolean.valueOf(false));
    if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
      return null;
    }
    localObject = View.inflate(paramContext, R.i.lbs_tips_alert, null);
    ((CheckBox)((View)localObject).findViewById(R.h.lbs_tips_alert_cb)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          au.Hx();
          com.tencent.mm.model.c.Dz().o(4105, Boolean.valueOf(true));
          return;
        }
        au.Hx();
        com.tencent.mm.model.c.Dz().o(4105, Boolean.valueOf(false));
      }
    });
    DialogInterface.OnClickListener local7 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        try
        {
          paramAnonymousDialogInterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
          this.val$context.startActivity(paramAnonymousDialogInterface);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.MMAppMgr", paramAnonymousDialogInterface, "showLbsTipsAlert", new Object[0]);
        }
      }
    };
    paramContext = new c.a(paramContext);
    paramContext.Ip(R.l.nearby_friend_setting_tips_title);
    paramContext.ei((View)localObject);
    paramContext.Is(R.l.app_set).a(local7);
    paramContext.It(R.l.app_ignore_it);
    paramContext = paramContext.aoP();
    paramContext.show();
    return paramContext;
  }
  
  private static String acV(String paramString)
  {
    int j = 0;
    int i = paramString.length() - 1;
    while (i >= 0)
    {
      int k = j;
      if (paramString.charAt(i) == '|') {
        k = j + 1;
      }
      if (k == 3) {
        break;
      }
      i -= 1;
      j = k;
    }
    return paramString.substring(i + 1);
  }
  
  public static void afy()
  {
    mU(true);
  }
  
  public static void cancelNotification(String paramString)
  {
    au.getNotification().cancelNotification(paramString);
  }
  
  public static void czD()
  {
    StringBuffer localStringBuffer = new StringBuffer(800);
    if (uNI == null)
    {
      uNI = localStringBuffer;
      reZ = bk.UX();
      return;
    }
    String str = uNI.toString();
    localStringBuffer.append(acV(str));
    uNI = localStringBuffer;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", new Object[] { str });
    com.tencent.mm.plugin.report.service.h.nFQ.aC(10508, "1," + reZ + "," + str);
    reZ = bk.UX();
  }
  
  public static void czE()
  {
    Context localContext = ae.getContext();
    if (localContext != null)
    {
      localContext.stopService(new Intent(localContext, CoreService.class));
      localContext.stopService(new Intent(localContext, NotifyReceiver.NotifyService.class));
      localContext.stopService(new Intent(localContext, CacheService.class));
      localContext.stopService(new Intent().setClassName(localContext, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"));
    }
  }
  
  public static void gr(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(ae.cqR(), 0);
    if (!localSharedPreferences.getBoolean("Main_ShortCut", false))
    {
      Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramContext.getString(R.l.launcher_name));
      localIntent1.putExtra("duplicate", false);
      Intent localIntent2 = new Intent("android.intent.action.MAIN");
      localIntent2.addCategory("android.intent.category.LAUNCHER");
      localIntent2.setComponent(new ComponentName(paramContext.getPackageName(), ae.cqQ() + ".ui.LauncherUI"));
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramContext, R.g.icon));
      localIntent1.putExtra("shortcut_icon_resource_id", R.g.icon);
      localIntent1.putExtra("shortcut_is_adaptive_icon", true);
      localIntent1.putExtra("is_main_shortcut", true);
      com.tencent.mm.plugin.base.model.b.n(paramContext, localIntent1);
      paramContext = localSharedPreferences.edit();
      paramContext.putBoolean("Main_ShortCut", true);
      paramContext.commit();
    }
  }
  
  public static void i(Context paramContext, boolean paramBoolean)
  {
    g.DQ().dKP.dLl.aP(paramBoolean);
    com.tencent.mrs.a.onDestroy();
    BaseEvent.onSingalCrash(0);
    MMNativeJpeg.Destroy();
    com.tencent.mm.booter.o.tq();
    if ((au.Dk() != null) && (au.Dk().edx != null)) {
      au.Dk().edx.bQ(paramBoolean);
    }
    Intent localIntent = new Intent().setClass(paramContext, LauncherUI.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("absolutely_exit_pid", Process.myPid());
    localIntent.putExtra("kill_service", paramBoolean);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void mU(boolean paramBoolean)
  {
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), bk.csb(), Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.report.b.d.r(2, 0, "");
    if (paramBoolean) {
      czE();
    }
    Object localObject = new w();
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    localObject = new jf();
    ((jf)localObject).bRC.status = 0;
    ((jf)localObject).bRC.aQw = 2;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    czD();
    if (paramBoolean)
    {
      au.gc(bk.csb().toString());
      g.DQ().releaseAll();
    }
    com.tencent.mm.sdk.platformtools.y.appenderClose();
    BaseEvent.onSingalCrash(0);
    com.tencent.mrs.a.onDestroy();
    localObject = ae.getContext();
    if (localObject != null)
    {
      localObject = com.tencent.mm.bu.a.fd((Context)localObject);
      int i = 0;
      while (i < 9)
      {
        String str = new String[] { "com.tencent.mm:recovery", "com.tencent.mm:support", "com.tencent.mm:tools", "com.tencent.mm:toolsmp", "com.tencent.mm:appbrand0", "com.tencent.mm:appbrand1", "com.tencent.mm:appbrand2", "com.tencent.mm:appbrand3", "com.tencent.mm:appbrand4" }[i];
        Integer localInteger = (Integer)((Map)localObject).get(str);
        if (localInteger != null)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.ProcessOperator", "killProcess(pid : %s, process : %s)", new Object[] { localInteger, str });
          Process.killProcess(localInteger.intValue());
        }
        i += 1;
      }
    }
    try
    {
      s.clearAllWebViewCache(ae.getContext(), true);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMAppMgr", "clearAllWebViewCache");
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMAppMgr", "clear cookie failed : %s", new Object[] { localException });
      }
    }
  }
  
  public static void tn()
  {
    au.getNotification().tn();
  }
  
  public final void c(Intent paramIntent, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      com.tencent.mm.ag.n.Kc();
      localObject1 = new nm();
      ((nm)localObject1).bXg.state = 1;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new com.tencent.mm.h.a.d();
      ((com.tencent.mm.h.a.d)localObject1).bES.bET = true;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new oi();
      ((oi)localObject1).bXW.axD = true;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new cs();
      ((cs)localObject1).bIS.state = 1;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    }
    Object localObject1 = new gb();
    ((gb)localObject1).bNq.bFk = paramBoolean;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
    this.uNK = paramBoolean;
    paramIntent = paramIntent.getStringExtra("classname");
    Object localObject2;
    if (bk.bl(paramIntent))
    {
      paramIntent = "";
      if (!paramBoolean) {
        break label382;
      }
      localObject2 = com.tencent.mm.booter.z.diw;
      if (((com.tencent.mm.booter.z)localObject2).diH == -1L)
      {
        if (((com.tencent.mm.booter.z)localObject2).dix.Fl(3) == 0) {
          ((com.tencent.mm.booter.z)localObject2).dix.setLong(1, ah.UX());
        }
        ((com.tencent.mm.booter.z)localObject2).diH = ah.UX();
        if (((com.tencent.mm.booter.z)localObject2).diA != null) {
          break label369;
        }
        localObject1 = "null";
        label231:
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.StayTimeReport", "onAppResume chatUser:%s, class:%s", new Object[] { localObject1, paramIntent });
        if (((com.tencent.mm.booter.z)localObject2).diA != null)
        {
          ((com.tencent.mm.booter.z)localObject2).diE = ah.UZ();
          if ((paramIntent != null) && (paramIntent.contains("WebViewUI"))) {
            ((com.tencent.mm.booter.z)localObject2).diF = ah.UZ();
          }
        }
      }
      label291:
      if (g.DN().Dc()) {
        if (bk.bl(l.rss.rsw.url)) {
          break label740;
        }
      }
    }
    label740:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.uNO = 0;
        this.uNQ.S(100L, 20L);
      }
      this.uNN.S(800L, 800L);
      return;
      paramIntent = paramIntent.substring(paramIntent.lastIndexOf(".") + 1);
      break;
      label369:
      localObject1 = ((com.tencent.mm.booter.z)localObject2).diA.diN;
      break label231;
      label382:
      localObject1 = com.tencent.mm.booter.z.diw;
      if (((com.tencent.mm.booter.z)localObject1).diH == -1L) {
        break label291;
      }
      long l = ah.UX();
      localObject2 = (String)((com.tencent.mm.booter.z)localObject1).dix.get(2, "");
      localObject2 = (String)localObject2 + ((com.tencent.mm.booter.z)localObject1).diH + "|" + l + "#";
      ((com.tencent.mm.booter.z)localObject1).dix.set(2, localObject2);
      i = ((com.tencent.mm.booter.z)localObject1).dix.Fl(3) + 1;
      ((com.tencent.mm.booter.z)localObject1).dix.setInt(3, i);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.StayTimeReport", "onAppPause,appReportCnt:%d app(%d-%d)", new Object[] { Integer.valueOf(i), Long.valueOf(((com.tencent.mm.booter.z)localObject1).diH), Long.valueOf(l) });
      ((com.tencent.mm.booter.z)localObject1).diH = -1L;
      if ((ah.cn(((com.tencent.mm.booter.z)localObject1).dix.getLong(1, 0L)) > 3600L * ((com.tencent.mm.booter.z)localObject1).diJ) || (i > ((com.tencent.mm.booter.z)localObject1).diI))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.aC(13110, (String)localObject2);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.StayTimeReport", "report appStayTime:%s", new Object[] { localObject2 });
        ((com.tencent.mm.booter.z)localObject1).dix.set(2, "");
        ((com.tencent.mm.booter.z)localObject1).dix.setInt(3, 0);
      }
      if (((com.tencent.mm.booter.z)localObject1).diA == null) {
        break label291;
      }
      localObject2 = ((com.tencent.mm.booter.z)localObject1).diA;
      ((z.a)localObject2).time += ah.cp(((com.tencent.mm.booter.z)localObject1).diE) / 1000L;
      if ((paramIntent != null) && (paramIntent.contains("WebViewUI")))
      {
        paramIntent = ((com.tencent.mm.booter.z)localObject1).diA;
        paramIntent.diR = ((int)(paramIntent.diR + ah.cp(((com.tencent.mm.booter.z)localObject1).diF) / 1000L));
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.StayTimeReport", "onAppPause, chatting:totalTime:%d", new Object[] { Long.valueOf(((com.tencent.mm.booter.z)localObject1).diA.time) });
      break label291;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr
 * JD-Core Version:    0.7.0.1
 */