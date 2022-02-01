package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Looper;
import android.os.Process;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.jg.JgClassChecked;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.o;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.z;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.ad;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.xweb.ah;
import java.util.Iterator;
import java.util.List;

public final class MMAppMgr
{
  static StringBuffer HoB;
  private static long HoC;
  public Receiver HoD;
  private long hTq;
  private String iTU;
  
  public static void Lm()
  {
    AppMethodBeat.i(33424);
    az.getNotification().Lm();
    AppMethodBeat.o(33424);
  }
  
  public static boolean a(final Activity paramActivity, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(33433);
    final SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences(ai.eUX(), 0);
    boolean bool = localSharedPreferences.getBoolean("gprs_alert", true);
    com.tencent.mm.sdk.platformtools.i.GqK &= bool;
    if (bool)
    {
      View localView = View.inflate(paramActivity, 2131494414, null);
      Object localObject3 = paramActivity.getString(2131762010);
      Object localObject2 = paramActivity.getString(2131761070);
      String str = paramActivity.getString(2131761069, new Object[] { localObject3, localObject2 });
      Object localObject1 = Spannable.Factory.getInstance().newSpannable(str);
      ClickableSpan local12 = new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33414);
          bs.bY(this.iuN, ai.getResources().getString(2131760685, new Object[] { com.tencent.mm.sdk.platformtools.ab.iC(this.iuN), com.tencent.mm.sdk.platformtools.ab.eUN(), "setting", Integer.valueOf(0), Integer.valueOf(0) }));
          AppMethodBeat.o(33414);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(33415);
          paramAnonymousTextPaint.setColor(this.iuN.getResources().getColor(2131100547));
          AppMethodBeat.o(33415);
        }
      };
      int i = str.indexOf((String)localObject3);
      int j = str.indexOf((String)localObject3);
      ((Spannable)localObject1).setSpan(local12, i, ((String)localObject3).length() + j, 33);
      localObject3 = new StyleSpan(1);
      i = str.indexOf((String)localObject2);
      j = str.indexOf((String)localObject2);
      ((Spannable)localObject1).setSpan(localObject3, i, ((String)localObject2).length() + j, 33);
      localObject2 = (TextView)localView.findViewById(2131301986);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
      localObject1 = (CheckBox)localView.findViewById(2131300606);
      paramOnClickListener = com.tencent.mm.ui.base.h.a(paramActivity, false, null, localView, paramActivity.getString(2131757560), paramActivity.getString(2131761066), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33416);
          if (this.HoE.isChecked())
          {
            SharedPreferences.Editor localEditor = localSharedPreferences.edit();
            localEditor.putBoolean("gprs_alert", false);
            localEditor.commit();
          }
          com.tencent.mm.sdk.platformtools.i.GqK = false;
          paramAnonymousDialogInterface.dismiss();
          MMAppMgr.jB(paramActivity);
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
          }
          AppMethodBeat.o(33416);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33404);
          paramAnonymousDialogInterface.dismiss();
          MMAppMgr.m(this.iuN, true);
          AppMethodBeat.o(33404);
        }
      });
      if (paramOnClickListener == null)
      {
        AppMethodBeat.o(33433);
        return false;
      }
      paramOnClickListener.setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(33405);
          this.iuN.onKeyDown(4, new KeyEvent(0, 4));
          AppMethodBeat.o(33405);
        }
      });
    }
    AppMethodBeat.o(33433);
    return bool;
  }
  
  public static boolean a(Context paramContext, int paramInt, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(33434);
    View localView = View.inflate(paramContext, 2131495013, null);
    Object localObject = (CheckBox)localView.findViewById(2131302707);
    ((CheckBox)localObject).setText(paramContext.getString(2131761541));
    ((CheckBox)localObject).setOnCheckedChangeListener(new MMAppMgr.4());
    localView.findViewById(2131302709).setVisibility(8);
    localObject = (TextView)localView.findViewById(2131302708);
    switch (paramInt)
    {
    case 2: 
    default: 
      ((TextView)localObject).setText(2131761553);
      paramInt = 1;
    }
    while (paramInt != 0)
    {
      paramContext = new d.a(paramContext);
      paramContext.acF(2131755906);
      paramContext.yf(false);
      paramContext.gH(localView);
      paramContext.acM(2131761550).b(paramOnClickListener1);
      paramContext.acN(2131761541).c(paramOnClickListener2);
      paramContext.fvp().show();
      AppMethodBeat.o(33434);
      return true;
      ((TextView)localObject).setText(2131761553);
      paramInt = 0;
      continue;
      ((TextView)localObject).setText(2131761540);
      paramInt = 1;
    }
    AppMethodBeat.o(33434);
    return false;
  }
  
  private static String aPC(String paramString)
  {
    AppMethodBeat.i(33422);
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
    paramString = paramString.substring(i + 1);
    AppMethodBeat.o(33422);
    return paramString;
  }
  
  public static void bA(Context paramContext)
  {
    AppMethodBeat.i(196317);
    ad.aLY().edit().putBoolean("is_in_notify_mode", true).commit();
    am.aKP("welcome_page_show");
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().p(-1, null);
    com.tencent.mm.g.a.ab localab = new com.tencent.mm.g.a.ab();
    localab.cZr.cZs = false;
    com.tencent.mm.sdk.b.a.GpY.l(localab);
    com.tencent.mm.plugin.setting.b.iyy.Lm();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().UP();
    m(paramContext, false);
    AppMethodBeat.o(196317);
  }
  
  public static com.tencent.mm.ui.widget.a.d bC(Context paramContext)
  {
    AppMethodBeat.i(33435);
    try
    {
      localObject = (LocationManager)paramContext.getSystemService("location");
      if (ax.isWifi(paramContext))
      {
        boolean bool = ((LocationManager)localObject).isProviderEnabled("gps");
        if (bool)
        {
          AppMethodBeat.o(33435);
          return null;
        }
      }
    }
    catch (Exception paramContext)
    {
      ac.printErrStackTrace("MicroMsg.MMAppMgr", paramContext, "showLbsTipsAlert error", new Object[0]);
      AppMethodBeat.o(33435);
      return null;
    }
    az.ayM();
    Object localObject = (Boolean)com.tencent.mm.model.c.agA().get(4105, Boolean.FALSE);
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(33435);
      return null;
    }
    localObject = View.inflate(paramContext, 2131494581, null);
    ((CheckBox)((View)localObject).findViewById(2131301370)).setOnCheckedChangeListener(new MMAppMgr.5());
    MMAppMgr.6 local6 = new MMAppMgr.6(paramContext);
    paramContext = new d.a(paramContext);
    paramContext.acF(2131761519);
    paramContext.gH((View)localObject);
    paramContext.acM(2131755889).b(local6);
    paramContext.acN(2131755796);
    paramContext = paramContext.fvp();
    paramContext.show();
    AppMethodBeat.o(33435);
    return paramContext;
  }
  
  public static void bc(Activity paramActivity)
  {
    AppMethodBeat.i(33431);
    new Intent();
    com.tencent.mm.br.d.N(paramActivity, "whatsnew", ".ui.WhatsNewUI");
    AppMethodBeat.o(33431);
  }
  
  public static void bcH()
  {
    AppMethodBeat.i(210124);
    wA(true);
    AppMethodBeat.o(210124);
  }
  
  public static void bz(Context paramContext)
  {
    AppMethodBeat.i(33428);
    m(paramContext, true);
    AppMethodBeat.o(33428);
  }
  
  public static void cancelNotification(String paramString)
  {
    AppMethodBeat.i(33423);
    az.getNotification().cancelNotification(paramString);
    AppMethodBeat.o(33423);
  }
  
  public static void fgL()
  {
    AppMethodBeat.i(33421);
    StringBuffer localStringBuffer = new StringBuffer(800);
    if (HoB == null)
    {
      HoB = localStringBuffer;
      HoC = bs.aNx();
      AppMethodBeat.o(33421);
      return;
    }
    String str = HoB.toString();
    localStringBuffer.append(aPC(str));
    HoB = localStringBuffer;
    ac.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", new Object[] { str });
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(10508, "1," + HoC + "," + str);
    HoC = bs.aNx();
    AppMethodBeat.o(33421);
  }
  
  public static void fgM()
  {
    AppMethodBeat.i(33427);
    Context localContext = ai.getContext();
    if (localContext != null)
    {
      if (!com.tencent.mm.booter.c.Un()) {
        break label80;
      }
      com.tencent.mm.app.g.Km();
    }
    for (;;)
    {
      com.tencent.mm.br.d.ba(new Intent(localContext, NotifyReceiver.NotifyService.class));
      localContext.stopService(new Intent(localContext, CacheService.class));
      com.tencent.mm.br.d.n(new Intent().setClassName(localContext, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"), "exdevice");
      AppMethodBeat.o(33427);
      return;
      try
      {
        label80:
        localContext.stopService(new Intent(localContext, CoreService.class));
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.MMAppMgr", "killService() Exception:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static boolean jA(Context paramContext)
  {
    AppMethodBeat.i(33430);
    if (!az.agM())
    {
      AppMethodBeat.o(33430);
      return false;
    }
    az.ayM();
    if (bs.l((Boolean)com.tencent.mm.model.c.agA().get(61, null)))
    {
      AppMethodBeat.o(33430);
      return false;
    }
    if (!am.aKO("show_wap_adviser"))
    {
      AppMethodBeat.o(33430);
      return false;
    }
    View localView = View.inflate(paramContext, 2131495013, null);
    ((TextView)localView.findViewById(2131302708)).setText(2131761552);
    Object localObject = (CheckBox)localView.findViewById(2131302707);
    ((CheckBox)localObject).setText(paramContext.getString(2131762015));
    ((CheckBox)localObject).setOnCheckedChangeListener(new MMAppMgr.9());
    ((CheckBox)localObject).setVisibility(0);
    localObject = new d.a(paramContext);
    ((d.a)localObject).acF(2131755906);
    ((d.a)localObject).gH(localView);
    ((d.a)localObject).acM(2131762017).b(new MMAppMgr.10(paramContext));
    ((d.a)localObject).yf(false);
    ((d.a)localObject).acN(2131762016);
    ((d.a)localObject).a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(33413);
        am.aKP("show_wap_adviser");
        AppMethodBeat.o(33413);
      }
    });
    ((d.a)localObject).fvp().show();
    AppMethodBeat.o(33430);
    return true;
  }
  
  public static void jB(Context paramContext)
  {
    AppMethodBeat.i(33432);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(ai.eUX(), 0);
    if (!localSharedPreferences.getBoolean("Main_ShortCut", false))
    {
      Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramContext.getString(2131760676));
      localIntent1.putExtra("duplicate", false);
      Intent localIntent2 = new Intent("android.intent.action.MAIN");
      localIntent2.addCategory("android.intent.category.LAUNCHER");
      localIntent2.setComponent(new ComponentName(paramContext.getPackageName(), ai.eUW() + ".ui.LauncherUI"));
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramContext, 2131232660));
      localIntent1.putExtra("shortcut_icon_resource_id", 2131232660);
      localIntent1.putExtra("shortcut_is_adaptive_icon", true);
      localIntent1.putExtra("is_main_shortcut", true);
      com.tencent.mm.plugin.base.model.b.p(paramContext, localIntent1);
      paramContext = localSharedPreferences.edit();
      paramContext.putBoolean("Main_ShortCut", true);
      paramContext.commit();
    }
    AppMethodBeat.o(33432);
  }
  
  public static void m(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(33429);
    com.tencent.mm.kernel.g.agS().dA(paramBoolean);
    Mars.onSingalCrash(0);
    MMNativeJpeg.Destroy();
    o.Lp();
    if ((az.agi() != null) && (az.agi().hwg != null)) {
      az.agi().hwg.eF(paramBoolean);
    }
    Object localObject = new Intent().setClass(paramContext, LauncherUI.class);
    ((Intent)localObject).addFlags(32768);
    ((Intent)localObject).putExtra("absolutely_exit_pid", Process.myPid());
    ((Intent)localObject).putExtra("kill_service", paramBoolean);
    if (!(paramContext instanceof Activity)) {
      ((Intent)localObject).addFlags(268435456);
    }
    for (;;)
    {
      try
      {
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/MMAppMgr", "exitApplication", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/MMAppMgr", "exitApplication", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(33429);
        return;
      }
      catch (Throwable paramContext)
      {
        ac.printErrStackTrace("MicroMsg.MMAppMgr", paramContext, "[-] Fail to start launcherUI in suicide.", new Object[0]);
        AppMethodBeat.o(33429);
      }
      ((Activity)paramContext).finish();
    }
  }
  
  public static void wA(boolean paramBoolean)
  {
    AppMethodBeat.i(33426);
    ac.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), bs.eWi(), Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.report.c.d.E(2, 0, "");
    if (paramBoolean) {
      fgM();
    }
    Object localObject = new z();
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new la();
    ((la)localObject).dmU.status = 0;
    ((la)localObject).dmU.reason = 2;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    fgL();
    if (paramBoolean)
    {
      az.ub(bs.eWi().toString());
      com.tencent.mm.kernel.g.agS().releaseAll();
    }
    ac.appenderClose();
    Mars.onSingalCrash(0);
    com.tencent.mm.bv.a.f(ai.getContext(), new String[] { "com.tencent.mm:recovery", "com.tencent.mm:support", "com.tencent.mm:tools", "com.tencent.mm:toolsmp", "com.tencent.mm:appbrand0", "com.tencent.mm:appbrand1", "com.tencent.mm:appbrand2", "com.tencent.mm:appbrand3", "com.tencent.mm:appbrand4", "com.tencent.mm:lite" });
    try
    {
      ah.clearAllWebViewCache(ai.getContext(), true);
      ac.i("MicroMsg.MMAppMgr", "clearAllWebViewCache");
      Process.killProcess(Process.myPid());
      AppMethodBeat.o(33426);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.i("MicroMsg.MMAppMgr", "clear cookie failed : %s", new Object[] { localException });
      }
    }
  }
  
  @JgClassChecked(author=20, fComment="checked", lastDate="20141015", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
  public static class Receiver
    extends BroadcastReceiver
  {
    private MMAppMgr appMgr;
    
    public Receiver(MMAppMgr paramMMAppMgr)
    {
      this.appMgr = paramMMAppMgr;
    }
    
    private static boolean bl(Intent paramIntent)
    {
      AppMethodBeat.i(33419);
      if (!paramIntent.getBooleanExtra("process_is_mm", false))
      {
        AppMethodBeat.o(33419);
        return true;
      }
      if (paramIntent.getIntExtra("process_id", 0) == Process.myPid())
      {
        AppMethodBeat.o(33419);
        return true;
      }
      AppMethodBeat.o(33419);
      return false;
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(33420);
      if (paramIntent == null)
      {
        AppMethodBeat.o(33420);
        return;
      }
      if ((az.ayF()) || (az.ayH()))
      {
        AppMethodBeat.o(33420);
        return;
      }
      Object localObject = paramIntent.getAction();
      if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(localObject))
      {
        if (!bl(paramIntent))
        {
          ac.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
          AppMethodBeat.o(33420);
          return;
        }
        MMAppMgr.a(this.appMgr, paramIntent, true);
        AppMethodBeat.o(33420);
        return;
      }
      if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(localObject))
      {
        if (!bl(paramIntent))
        {
          ac.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
          AppMethodBeat.o(33420);
          return;
        }
        o.report();
        MMAppMgr.a(this.appMgr, paramIntent, false);
        if ((MMAppMgr.HoB != null) && (MMAppMgr.HoB.length() > 800)) {
          new ao(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33417);
              MMAppMgr.fgL();
              AppMethodBeat.o(33417);
            }
          });
        }
        AppMethodBeat.o(33420);
        return;
      }
      if ("com.tencent.mm.ui.ACTION_ABTEST".equals(localObject))
      {
        paramContext = paramIntent.getStringExtra("content");
        if (bs.isNullOrNil(paramContext)) {
          ac.i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
        }
        for (;;)
        {
          if ((MMAppMgr.HoB != null) && (MMAppMgr.HoB.length() > 800)) {
            new ao(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33418);
                MMAppMgr.fgL();
                AppMethodBeat.o(33418);
              }
            });
          }
          AppMethodBeat.o(33420);
          return;
          if (MMAppMgr.HoB == null) {
            MMAppMgr.HoB = new StringBuffer(800);
          }
          MMAppMgr.HoB.append(paramContext);
          ac.i("MicroMsg.MMAppMgr", "cpan content: %s", new Object[] { paramContext });
        }
      }
      if (paramIntent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE"))
      {
        int i;
        if (!paramIntent.getBooleanExtra("intent_extra_is_silence_stat", false))
        {
          i = paramIntent.getIntExtra("intent_extra_opcode", 0);
          ac.d("MicroMsg.MMAppMgr", "incremental_update = ".concat(String.valueOf(i)));
          if (az.agM()) {
            com.tencent.mm.plugin.report.service.h.wUl.f(10328, new Object[] { Integer.valueOf(i) });
          }
        }
        long l1;
        long l2;
        label639:
        for (;;)
        {
          l1 = paramIntent.getLongExtra("intent_extra_flow_stat_upstream", 0L);
          l2 = paramIntent.getLongExtra("intent_extra_flow_stat_downstream", 0L);
          boolean bool = paramIntent.getBooleanExtra("intent_extra_flow_stat_is_wifi", false);
          if ((!az.agM()) || ((l1 == 0L) && (l2 == 0L))) {
            break label653;
          }
          ac.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
          if (!bool) {
            break;
          }
          n.b((int)l2, (int)l1, 0);
          AppMethodBeat.o(33420);
          return;
          i = paramIntent.getIntExtra("intent_extra_opcode", 0);
          ac.d("MicroMsg.MMAppMgr", "silence_update_stat = ".concat(String.valueOf(i)));
          if (az.agM())
          {
            if (i == 2)
            {
              int j = paramIntent.getIntExtra("intent_extra_install_dialog_times", 0);
              com.tencent.mm.plugin.report.service.h.wUl.f(11147, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            for (;;)
            {
              if ((i != 4) || (com.tencent.mm.pluginsdk.g.i.eLz() != 4)) {
                break label639;
              }
              paramContext = com.tencent.mm.pluginsdk.model.app.b.eKS();
              if (paramContext == null) {
                break;
              }
              paramContext.eKU();
              break;
              com.tencent.mm.plugin.report.service.h.wUl.f(11147, new Object[] { Integer.valueOf(i) });
            }
          }
        }
        n.c((int)l2, (int)l1, 0);
        label653:
        AppMethodBeat.o(33420);
        return;
      }
      if (paramIntent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP"))
      {
        MMAppMgr.m(paramContext, true);
        AppMethodBeat.o(33420);
        return;
      }
      if (paramIntent.getAction().equals("MINIQB_OPEN_RET"))
      {
        paramContext = paramIntent.getStringExtra("op_type");
        if ("NOTIFY_RET".equals(paramContext))
        {
          com.tencent.mm.pluginsdk.ui.tools.a.aX(paramIntent);
          AppMethodBeat.o(33420);
          return;
        }
        if ("SEND_TO_FRIENDS".equals(paramContext))
        {
          ac.i("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS");
          if (!com.tencent.mm.kernel.g.agM())
          {
            ac.e("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS, account not ready");
            AppMethodBeat.o(33420);
            return;
          }
          String str2 = com.tencent.mm.cq.a.aST(paramIntent.getStringExtra("file_path"));
          localObject = paramIntent.getStringExtra("file_name");
          String str1 = paramIntent.getStringExtra("to_user");
          paramContext = paramIntent.getStringExtra("send_text");
          if ((bs.isNullOrNil(str2)) || (bs.isNullOrNil((String)localObject)) || (bs.isNullOrNil(str1)))
          {
            ac.e("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS, param empty");
            AppMethodBeat.o(33420);
            return;
          }
          WXFileObject localWXFileObject = new WXFileObject();
          localWXFileObject.setFilePath(str2);
          paramIntent = new WXMediaMessage();
          paramIntent.mediaObject = localWXFileObject;
          paramIntent.title = ((String)localObject);
          paramIntent.description = ((String)localObject);
          localObject = bs.S(str1.split(",")).iterator();
          while (((Iterator)localObject).hasNext())
          {
            str1 = (String)((Iterator)localObject).next();
            m.a(paramIntent, "", "", str1, 3, null);
            if (!bs.isNullOrNil(paramContext)) {
              j.dck().X(str1, paramContext, w.xt(str1));
            }
          }
        }
        AppMethodBeat.o(33420);
        return;
      }
      ac.e("MicroMsg.MMAppMgr", "unknown broadcast action");
      AppMethodBeat.o(33420);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr
 * JD-Core Version:    0.7.0.1
 */