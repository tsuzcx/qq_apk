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
import com.tencent.mm.al.q;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.o;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.g.a.y;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.xweb.af;
import java.util.Iterator;
import java.util.List;

public final class MMAppMgr
{
  static StringBuffer FOQ;
  private static long FOR;
  public Receiver FOS;
  private long hsO;
  private String itP;
  
  public static void Lo()
  {
    AppMethodBeat.i(33424);
    az.getNotification().Lo();
    AppMethodBeat.o(33424);
  }
  
  public static boolean a(final Activity paramActivity, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(33433);
    final SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences(aj.eFD(), 0);
    boolean bool = localSharedPreferences.getBoolean("gprs_alert", true);
    com.tencent.mm.sdk.platformtools.i.ETx &= bool;
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
          bt.bX(this.hUJ, aj.getResources().getString(2131760685, new Object[] { ac.ir(this.hUJ), ac.eFt(), "setting", Integer.valueOf(0), Integer.valueOf(0) }));
          AppMethodBeat.o(33414);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(33415);
          paramAnonymousTextPaint.setColor(this.hUJ.getResources().getColor(2131100547));
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
          if (this.FOT.isChecked())
          {
            SharedPreferences.Editor localEditor = localSharedPreferences.edit();
            localEditor.putBoolean("gprs_alert", false);
            localEditor.commit();
          }
          com.tencent.mm.sdk.platformtools.i.ETx = false;
          paramAnonymousDialogInterface.dismiss();
          MMAppMgr.jq(paramActivity);
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
          MMAppMgr.m(this.hUJ, true);
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
          this.hUJ.onKeyDown(4, new KeyEvent(0, 4));
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
      paramContext.aau(2131755906);
      paramContext.wX(false);
      paramContext.gs(localView);
      paramContext.aaB(2131761550).b(paramOnClickListener1);
      paramContext.aaC(2131761541).c(paramOnClickListener2);
      paramContext.fft().show();
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
  
  private static String aKa(String paramString)
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
  
  public static void aVJ()
  {
    AppMethodBeat.i(204938);
    vy(true);
    AppMethodBeat.o(204938);
  }
  
  public static void aY(Activity paramActivity)
  {
    AppMethodBeat.i(33431);
    new Intent();
    com.tencent.mm.bs.d.O(paramActivity, "whatsnew", ".ui.WhatsNewUI");
    AppMethodBeat.o(33431);
  }
  
  public static void bw(Context paramContext)
  {
    AppMethodBeat.i(33428);
    m(paramContext, true);
    AppMethodBeat.o(33428);
  }
  
  public static com.tencent.mm.ui.widget.a.d bz(Context paramContext)
  {
    AppMethodBeat.i(33435);
    try
    {
      localObject = (LocationManager)paramContext.getSystemService("location");
      if (ay.isWifi(paramContext))
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
      ad.printErrStackTrace("MicroMsg.MMAppMgr", paramContext, "showLbsTipsAlert error", new Object[0]);
      AppMethodBeat.o(33435);
      return null;
    }
    az.arV();
    Object localObject = (Boolean)com.tencent.mm.model.c.afk().get(4105, Boolean.FALSE);
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(33435);
      return null;
    }
    localObject = View.inflate(paramContext, 2131494581, null);
    ((CheckBox)((View)localObject).findViewById(2131301370)).setOnCheckedChangeListener(new MMAppMgr.5());
    MMAppMgr.6 local6 = new MMAppMgr.6(paramContext);
    paramContext = new d.a(paramContext);
    paramContext.aau(2131761519);
    paramContext.gs((View)localObject);
    paramContext.aaB(2131755889).b(local6);
    paramContext.aaC(2131755796);
    paramContext = paramContext.fft();
    paramContext.show();
    AppMethodBeat.o(33435);
    return paramContext;
  }
  
  public static void cancelNotification(String paramString)
  {
    AppMethodBeat.i(33423);
    az.getNotification().cancelNotification(paramString);
    AppMethodBeat.o(33423);
  }
  
  public static void eRc()
  {
    AppMethodBeat.i(33421);
    StringBuffer localStringBuffer = new StringBuffer(800);
    if (FOQ == null)
    {
      FOQ = localStringBuffer;
      FOR = bt.aGK();
      AppMethodBeat.o(33421);
      return;
    }
    String str = FOQ.toString();
    localStringBuffer.append(aKa(str));
    FOQ = localStringBuffer;
    ad.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", new Object[] { str });
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(10508, "1," + FOR + "," + str);
    FOR = bt.aGK();
    AppMethodBeat.o(33421);
  }
  
  public static void eRd()
  {
    AppMethodBeat.i(33427);
    Context localContext = aj.getContext();
    if (localContext != null)
    {
      if (!com.tencent.mm.booter.c.Tt()) {
        break label80;
      }
      com.tencent.mm.app.g.KB();
    }
    for (;;)
    {
      com.tencent.mm.bs.d.aZ(new Intent(localContext, NotifyReceiver.NotifyService.class));
      localContext.stopService(new Intent(localContext, CacheService.class));
      com.tencent.mm.bs.d.n(new Intent().setClassName(localContext, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"), "exdevice");
      AppMethodBeat.o(33427);
      return;
      try
      {
        label80:
        localContext.stopService(new Intent(localContext, CoreService.class));
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.MMAppMgr", "killService() Exception:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static boolean jp(Context paramContext)
  {
    AppMethodBeat.i(33430);
    if (!az.afw())
    {
      AppMethodBeat.o(33430);
      return false;
    }
    az.arV();
    if (bt.l((Boolean)com.tencent.mm.model.c.afk().get(61, null)))
    {
      AppMethodBeat.o(33430);
      return false;
    }
    if (!an.aFx("show_wap_adviser"))
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
    ((d.a)localObject).aau(2131755906);
    ((d.a)localObject).gs(localView);
    ((d.a)localObject).aaB(2131762017).b(new MMAppMgr.10(paramContext));
    ((d.a)localObject).wX(false);
    ((d.a)localObject).aaC(2131762016);
    ((d.a)localObject).a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(33413);
        an.aFy("show_wap_adviser");
        AppMethodBeat.o(33413);
      }
    });
    ((d.a)localObject).fft().show();
    AppMethodBeat.o(33430);
    return true;
  }
  
  public static void jq(Context paramContext)
  {
    AppMethodBeat.i(33432);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(aj.eFD(), 0);
    if (!localSharedPreferences.getBoolean("Main_ShortCut", false))
    {
      Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramContext.getString(2131760676));
      localIntent1.putExtra("duplicate", false);
      Intent localIntent2 = new Intent("android.intent.action.MAIN");
      localIntent2.addCategory("android.intent.category.LAUNCHER");
      localIntent2.setComponent(new ComponentName(paramContext.getPackageName(), aj.eFC() + ".ui.LauncherUI"));
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
    com.tencent.mm.kernel.g.afC().dA(paramBoolean);
    Mars.onSingalCrash(0);
    MMNativeJpeg.Destroy();
    o.Lr();
    if ((az.aeS() != null) && (az.aeS().gVH != null)) {
      az.aeS().gVH.ek(paramBoolean);
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/MMAppMgr", "exitApplication", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/MMAppMgr", "exitApplication", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(33429);
        return;
      }
      catch (Throwable paramContext)
      {
        ad.printErrStackTrace("MicroMsg.MMAppMgr", paramContext, "[-] Fail to start launcherUI in suicide.", new Object[0]);
        AppMethodBeat.o(33429);
      }
      ((Activity)paramContext).finish();
    }
  }
  
  public static void vy(boolean paramBoolean)
  {
    AppMethodBeat.i(33426);
    ad.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), bt.eGN(), Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.report.b.d.F(2, 0, "");
    if (paramBoolean) {
      eRd();
    }
    Object localObject = new y();
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new kr();
    ((kr)localObject).dpk.status = 0;
    ((kr)localObject).dpk.bvJ = 2;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    eRc();
    if (paramBoolean)
    {
      az.qM(bt.eGN().toString());
      com.tencent.mm.kernel.g.afC().releaseAll();
    }
    ad.appenderClose();
    Mars.onSingalCrash(0);
    com.tencent.mm.bw.a.f(aj.getContext(), new String[] { "com.tencent.mm:recovery", "com.tencent.mm:support", "com.tencent.mm:tools", "com.tencent.mm:toolsmp", "com.tencent.mm:appbrand0", "com.tencent.mm:appbrand1", "com.tencent.mm:appbrand2", "com.tencent.mm:appbrand3", "com.tencent.mm:appbrand4" });
    try
    {
      af.clearAllWebViewCache(aj.getContext(), true);
      ad.i("MicroMsg.MMAppMgr", "clearAllWebViewCache");
      Process.killProcess(Process.myPid());
      AppMethodBeat.o(33426);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.i("MicroMsg.MMAppMgr", "clear cookie failed : %s", new Object[] { localException });
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
    
    private static boolean bk(Intent paramIntent)
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
      if ((az.arO()) || (az.arQ()))
      {
        AppMethodBeat.o(33420);
        return;
      }
      Object localObject = paramIntent.getAction();
      if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(localObject))
      {
        if (!bk(paramIntent))
        {
          ad.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
          AppMethodBeat.o(33420);
          return;
        }
        MMAppMgr.a(this.appMgr, paramIntent, true);
        AppMethodBeat.o(33420);
        return;
      }
      if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(localObject))
      {
        if (!bk(paramIntent))
        {
          ad.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
          AppMethodBeat.o(33420);
          return;
        }
        o.report();
        MMAppMgr.a(this.appMgr, paramIntent, false);
        if ((MMAppMgr.FOQ != null) && (MMAppMgr.FOQ.length() > 800)) {
          new ap(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33417);
              MMAppMgr.eRc();
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
        if (bt.isNullOrNil(paramContext)) {
          ad.i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
        }
        for (;;)
        {
          if ((MMAppMgr.FOQ != null) && (MMAppMgr.FOQ.length() > 800)) {
            new ap(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33418);
                MMAppMgr.eRc();
                AppMethodBeat.o(33418);
              }
            });
          }
          AppMethodBeat.o(33420);
          return;
          if (MMAppMgr.FOQ == null) {
            MMAppMgr.FOQ = new StringBuffer(800);
          }
          MMAppMgr.FOQ.append(paramContext);
          ad.i("MicroMsg.MMAppMgr", "cpan content: %s", new Object[] { paramContext });
        }
      }
      if (paramIntent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE"))
      {
        int i;
        if (!paramIntent.getBooleanExtra("intent_extra_is_silence_stat", false))
        {
          i = paramIntent.getIntExtra("intent_extra_opcode", 0);
          ad.d("MicroMsg.MMAppMgr", "incremental_update = ".concat(String.valueOf(i)));
          if (az.afw()) {
            com.tencent.mm.plugin.report.service.h.vKh.f(10328, new Object[] { Integer.valueOf(i) });
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
          if ((!az.afw()) || ((l1 == 0L) && (l2 == 0L))) {
            break label653;
          }
          ad.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
          if (!bool) {
            break;
          }
          n.b((int)l2, (int)l1, 0);
          AppMethodBeat.o(33420);
          return;
          i = paramIntent.getIntExtra("intent_extra_opcode", 0);
          ad.d("MicroMsg.MMAppMgr", "silence_update_stat = ".concat(String.valueOf(i)));
          if (az.afw())
          {
            if (i == 2)
            {
              int j = paramIntent.getIntExtra("intent_extra_install_dialog_times", 0);
              com.tencent.mm.plugin.report.service.h.vKh.f(11147, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            for (;;)
            {
              if ((i != 4) || (com.tencent.mm.pluginsdk.g.i.ewf() != 4)) {
                break label639;
              }
              paramContext = com.tencent.mm.pluginsdk.model.app.b.evy();
              if (paramContext == null) {
                break;
              }
              paramContext.evA();
              break;
              com.tencent.mm.plugin.report.service.h.vKh.f(11147, new Object[] { Integer.valueOf(i) });
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
          com.tencent.mm.pluginsdk.ui.tools.a.aW(paramIntent);
          AppMethodBeat.o(33420);
          return;
        }
        if ("SEND_TO_FRIENDS".equals(paramContext))
        {
          ad.i("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS");
          if (!com.tencent.mm.kernel.g.afw())
          {
            ad.e("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS, account not ready");
            AppMethodBeat.o(33420);
            return;
          }
          String str2 = com.tencent.mm.cr.a.aNq(paramIntent.getStringExtra("file_path"));
          localObject = paramIntent.getStringExtra("file_name");
          String str1 = paramIntent.getStringExtra("to_user");
          paramContext = paramIntent.getStringExtra("send_text");
          if ((bt.isNullOrNil(str2)) || (bt.isNullOrNil((String)localObject)) || (bt.isNullOrNil(str1)))
          {
            ad.e("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS, param empty");
            AppMethodBeat.o(33420);
            return;
          }
          WXFileObject localWXFileObject = new WXFileObject();
          localWXFileObject.setFilePath(str2);
          paramIntent = new WXMediaMessage();
          paramIntent.mediaObject = localWXFileObject;
          paramIntent.title = ((String)localObject);
          paramIntent.description = ((String)localObject);
          localObject = bt.S(str1.split(",")).iterator();
          while (((Iterator)localObject).hasNext())
          {
            str1 = (String)((Iterator)localObject).next();
            m.a(paramIntent, "", "", str1, 3, null);
            if (!bt.isNullOrNil(paramContext)) {
              j.cOB().W(str1, paramContext, w.tq(str1));
            }
          }
        }
        AppMethodBeat.o(33420);
        return;
      }
      ad.e("MicroMsg.MMAppMgr", "unknown broadcast action");
      AppMethodBeat.o(33420);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr
 * JD-Core Version:    0.7.0.1
 */