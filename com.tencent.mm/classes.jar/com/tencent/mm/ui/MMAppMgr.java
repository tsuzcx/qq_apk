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
import android.location.LocationManager;
import android.os.Looper;
import android.os.Process;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.jg.JgClassChecked;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.app.ai;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.o;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Wordings;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.xweb.ah;
import java.util.Iterator;
import java.util.List;

public final class MMAppMgr
{
  static StringBuffer OHl;
  private static long OHm;
  public Receiver OHn;
  private long jkM;
  private String koi;
  
  public static void Bj(boolean paramBoolean)
  {
    AppMethodBeat.i(33426);
    Log.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), Util.getStack(), Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.report.b.d.E(2, 0, "");
    if (paramBoolean) {
      gIU();
    }
    Object localObject1 = new com.tencent.mm.g.a.ab();
    EventCenter.instance.publish((IEvent)localObject1);
    localObject1 = new ma();
    ((ma)localObject1).dRA.status = 0;
    ((ma)localObject1).dRA.bDZ = 2;
    EventCenter.instance.publish((IEvent)localObject1);
    gIT();
    if (paramBoolean)
    {
      bg.FM(Util.getStack().toString());
      com.tencent.mm.kernel.g.aAi().releaseAll();
    }
    Log.appenderClose();
    Mars.onSingalCrash(0);
    com.tencent.mm.bv.a.f(MMApplicationContext.getContext(), new String[] { MMApplicationContext.getApplicationId() + ":recovery", MMApplicationContext.getApplicationId() + ":support", MMApplicationContext.getApplicationId() + ":tools", MMApplicationContext.getApplicationId() + ":toolsmp", MMApplicationContext.getApplicationId() + ":appbrand0", MMApplicationContext.getApplicationId() + ":appbrand1", MMApplicationContext.getApplicationId() + ":appbrand2", MMApplicationContext.getApplicationId() + ":appbrand3", MMApplicationContext.getApplicationId() + ":appbrand4", MMApplicationContext.getApplicationId() + ":lite" });
    try
    {
      ah.clearAllWebViewCache(MMApplicationContext.getContext(), true);
      Log.i("MicroMsg.MMAppMgr", "clearAllWebViewCache");
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/ui/MMAppMgr", "killProcess", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/MMAppMgr", "killProcess", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(33426);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.i("MicroMsg.MMAppMgr", "clear cookie failed : %s", new Object[] { localException });
      }
    }
  }
  
  public static void Xc()
  {
    AppMethodBeat.i(33424);
    bg.getNotification().Xc();
    AppMethodBeat.o(33424);
  }
  
  public static boolean a(final Activity paramActivity, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(33433);
    final SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    boolean bool = localSharedPreferences.getBoolean("gprs_alert", true);
    ChannelUtil.isShowingGprsAlert &= bool;
    if (bool)
    {
      ai.init(paramActivity.getBaseContext());
      View localView = View.inflate(paramActivity, 2131494986, null);
      Object localObject3 = WeChatBrands.Wordings.translate(paramActivity.getString(2131764020));
      Object localObject2 = WeChatBrands.Wordings.translate(paramActivity.getString(2131762856));
      String str = WeChatBrands.Wordings.translate(paramActivity.getString(2131762855, new Object[] { localObject3, localObject2 }));
      Object localObject1 = Spannable.Factory.getInstance().newSpannable(str);
      MMAppMgr.12 local12 = new MMAppMgr.12(paramActivity);
      int i = str.indexOf((String)localObject3);
      int j = str.indexOf((String)localObject3);
      ((Spannable)localObject1).setSpan(local12, i, ((String)localObject3).length() + j, 33);
      localObject3 = new StyleSpan(1);
      i = str.indexOf((String)localObject2);
      j = str.indexOf((String)localObject2);
      ((Spannable)localObject1).setSpan(localObject3, i, ((String)localObject2).length() + j, 33);
      localObject2 = (TextView)localView.findViewById(2131304323);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
      localObject1 = (CheckBox)localView.findViewById(2131302159);
      paramOnClickListener = com.tencent.mm.ui.base.h.a(paramActivity, false, null, localView, paramActivity.getString(2131757787), paramActivity.getString(2131762852), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33416);
          if (this.OHo.isChecked())
          {
            SharedPreferences.Editor localEditor = localSharedPreferences.edit();
            localEditor.putBoolean("gprs_alert", false);
            localEditor.commit();
          }
          ChannelUtil.isShowingGprsAlert = false;
          paramAnonymousDialogInterface.dismiss();
          MMAppMgr.jO(paramActivity);
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
          paramAnonymousDialogInterface = this.dnO;
          com.tencent.mm.kernel.g.aAi().et(true);
          Mars.onSingalCrash(0);
          MMNativeJpeg.Destroy();
          o.Xe();
          if ((bg.azz() != null) && (bg.azz().iMw != null)) {
            bg.azz().iMw.fA(true);
          }
          Object localObject = new Intent().setClass(paramAnonymousDialogInterface, LauncherUI.class);
          ((Intent)localObject).addFlags(32768);
          ((Intent)localObject).putExtra("absolutely_exit_pid", Process.myPid());
          ((Intent)localObject).putExtra("kill_service", true);
          if (!(paramAnonymousDialogInterface instanceof Activity)) {
            ((Intent)localObject).addFlags(268435456);
          }
          for (;;)
          {
            try
            {
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/MMAppMgr", "exitApplicationFromSplash", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/MMAppMgr", "exitApplicationFromSplash", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(33404);
              return;
            }
            catch (Throwable paramAnonymousDialogInterface)
            {
              Log.printErrStackTrace("MicroMsg.MMAppMgr", paramAnonymousDialogInterface, "[-] Fail to start launcherUI in suicide.", new Object[0]);
              AppMethodBeat.o(33404);
            }
            ((Activity)paramAnonymousDialogInterface).finish();
          }
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
          this.dnO.onKeyDown(4, new KeyEvent(0, 4));
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
    View localView = View.inflate(paramContext, 2131495843, null);
    Object localObject = (CheckBox)localView.findViewById(2131305272);
    ((CheckBox)localObject).setText(paramContext.getString(2131763507));
    ((CheckBox)localObject).setOnCheckedChangeListener(new MMAppMgr.4());
    localView.findViewById(2131305274).setVisibility(8);
    localObject = (TextView)localView.findViewById(2131305273);
    switch (paramInt)
    {
    case 2: 
    default: 
      ((TextView)localObject).setText(2131763519);
      paramInt = 1;
    }
    while (paramInt != 0)
    {
      paramContext = new d.a(paramContext);
      paramContext.aoO(2131755998);
      paramContext.Dk(false);
      paramContext.hs(localView);
      paramContext.aoV(2131763516).c(paramOnClickListener1);
      paramContext.aoW(2131763507).d(paramOnClickListener2);
      paramContext.hbn().show();
      AppMethodBeat.o(33434);
      return true;
      ((TextView)localObject).setText(2131763519);
      paramInt = 0;
      continue;
      ((TextView)localObject).setText(2131763506);
      paramInt = 1;
    }
    AppMethodBeat.o(33434);
    return false;
  }
  
  public static void bCm()
  {
    AppMethodBeat.i(185859);
    Bj(true);
    AppMethodBeat.o(185859);
  }
  
  public static void bV(Context paramContext)
  {
    AppMethodBeat.i(33428);
    n(paramContext, true);
    AppMethodBeat.o(33428);
  }
  
  public static com.tencent.mm.ui.widget.a.d bY(Context paramContext)
  {
    AppMethodBeat.i(33435);
    try
    {
      localObject = (LocationManager)paramContext.getSystemService("location");
      if (NetStatusUtil.isWifi(paramContext))
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
      Log.printErrStackTrace("MicroMsg.MMAppMgr", paramContext, "showLbsTipsAlert error", new Object[0]);
      AppMethodBeat.o(33435);
      return null;
    }
    bg.aVF();
    Object localObject = (Boolean)com.tencent.mm.model.c.azQ().get(4105, Boolean.FALSE);
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(33435);
      return null;
    }
    localObject = View.inflate(paramContext, 2131495208, null);
    ((CheckBox)((View)localObject).findViewById(2131303121)).setOnCheckedChangeListener(new MMAppMgr.5());
    MMAppMgr.6 local6 = new MMAppMgr.6(paramContext);
    paramContext = new d.a(paramContext);
    paramContext.aoO(2131763461);
    paramContext.hs((View)localObject);
    paramContext.aoV(2131755981).c(local6);
    paramContext.aoW(2131755877);
    paramContext = paramContext.hbn();
    paramContext.show();
    AppMethodBeat.o(33435);
    return paramContext;
  }
  
  public static void bh(Activity paramActivity)
  {
    AppMethodBeat.i(33431);
    if (com.tencent.mm.kernel.g.aAh().hqT)
    {
      com.tencent.mm.br.c.V(paramActivity, "whatsnew", ".ui.WhatsNewUI");
      AppMethodBeat.o(33431);
      return;
    }
    new com.tencent.mm.plugin.whatsnew.ui.d(paramActivity).show();
    AppMethodBeat.o(33431);
  }
  
  private static String blS(String paramString)
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
  
  public static void cancelNotification(String paramString)
  {
    AppMethodBeat.i(33423);
    bg.getNotification().cancelNotification(paramString);
    AppMethodBeat.o(33423);
  }
  
  public static void gIT()
  {
    AppMethodBeat.i(33421);
    StringBuffer localStringBuffer = new StringBuffer(800);
    if (OHl == null)
    {
      OHl = localStringBuffer;
      OHm = Util.nowSecond();
      AppMethodBeat.o(33421);
      return;
    }
    String str = OHl.toString();
    localStringBuffer.append(blS(str));
    OHl = localStringBuffer;
    Log.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", new Object[] { str });
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(10508, "1," + OHm + "," + str);
    OHm = Util.nowSecond();
    AppMethodBeat.o(33421);
  }
  
  public static void gIU()
  {
    AppMethodBeat.i(33427);
    Context localContext = MMApplicationContext.getContext();
    if (localContext != null)
    {
      if (!com.tencent.mm.booter.c.akA()) {
        break label80;
      }
      com.tencent.mm.app.g.Wj();
    }
    for (;;)
    {
      com.tencent.mm.br.c.bs(new Intent(localContext, NotifyReceiver.NotifyService.class));
      localContext.stopService(new Intent(localContext, CacheService.class));
      com.tencent.mm.br.c.o(new Intent().setClassName(localContext, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"), "exdevice");
      AppMethodBeat.o(33427);
      return;
      try
      {
        label80:
        localContext.stopService(new Intent(localContext, CoreService.class));
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.MMAppMgr", "killService() Exception:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static boolean jN(Context paramContext)
  {
    AppMethodBeat.i(33430);
    if (!bg.aAc())
    {
      AppMethodBeat.o(33430);
      return false;
    }
    bg.aVF();
    if (Util.nullAsFalse((Boolean)com.tencent.mm.model.c.azQ().get(61, null)))
    {
      AppMethodBeat.o(33430);
      return false;
    }
    if (!MMEntryLock.lock("show_wap_adviser"))
    {
      AppMethodBeat.o(33430);
      return false;
    }
    View localView = View.inflate(paramContext, 2131495843, null);
    ((TextView)localView.findViewById(2131305273)).setText(2131763518);
    Object localObject = (CheckBox)localView.findViewById(2131305272);
    ((CheckBox)localObject).setText(paramContext.getString(2131764025));
    ((CheckBox)localObject).setOnCheckedChangeListener(new MMAppMgr.9());
    ((CheckBox)localObject).setVisibility(0);
    localObject = new d.a(paramContext);
    ((d.a)localObject).aoO(2131755998);
    ((d.a)localObject).hs(localView);
    ((d.a)localObject).aoV(2131764027).c(new MMAppMgr.10(paramContext));
    ((d.a)localObject).Dk(false);
    ((d.a)localObject).aoW(2131764026);
    ((d.a)localObject).a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(33413);
        MMEntryLock.unlock("show_wap_adviser");
        AppMethodBeat.o(33413);
      }
    });
    ((d.a)localObject).hbn().show();
    AppMethodBeat.o(33430);
    return true;
  }
  
  public static void jO(Context paramContext)
  {
    AppMethodBeat.i(33432);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    if (!localSharedPreferences.getBoolean("Main_ShortCut", false))
    {
      Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramContext.getString(2131762208));
      localIntent1.putExtra("duplicate", false);
      Intent localIntent2 = new Intent("android.intent.action.MAIN");
      localIntent2.addCategory("android.intent.category.LAUNCHER");
      localIntent2.setComponent(new ComponentName(paramContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".ui.LauncherUI"));
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramContext, 2131233070));
      localIntent1.putExtra("shortcut_icon_resource_id", 2131233070);
      localIntent1.putExtra("shortcut_is_adaptive_icon", true);
      localIntent1.putExtra("is_main_shortcut", true);
      com.tencent.mm.plugin.base.model.b.p(paramContext, localIntent1);
      paramContext = localSharedPreferences.edit();
      paramContext.putBoolean("Main_ShortCut", true);
      paramContext.commit();
    }
    AppMethodBeat.o(33432);
  }
  
  public static void n(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(33429);
    com.tencent.mm.kernel.g.aAi().et(paramBoolean);
    Mars.onSingalCrash(0);
    MMNativeJpeg.Destroy();
    o.Xe();
    if ((bg.azz() != null) && (bg.azz().iMw != null)) {
      bg.azz().iMw.fA(paramBoolean);
    }
    Object localObject = new Intent().setClass(paramContext, LauncherUI.class);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("absolutely_exit_pid", Process.myPid());
    ((Intent)localObject).putExtra("kill_service", paramBoolean);
    if (!(paramContext instanceof Activity)) {
      ((Intent)localObject).addFlags(268435456);
    }
    try
    {
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/MMAppMgr", "exitApplication", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/MMAppMgr", "exitApplication", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(33429);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.printErrStackTrace("MicroMsg.MMAppMgr", paramContext, "[-] Fail to start launcherUI in suicide.", new Object[0]);
      AppMethodBeat.o(33429);
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
    
    private static boolean bB(Intent paramIntent)
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
      if ((bg.aVy()) || (bg.aVA()))
      {
        AppMethodBeat.o(33420);
        return;
      }
      Object localObject = paramIntent.getAction();
      if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(localObject))
      {
        if (!bB(paramIntent))
        {
          Log.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
          AppMethodBeat.o(33420);
          return;
        }
        MMAppMgr.a(this.appMgr, paramIntent, true);
        AppMethodBeat.o(33420);
        return;
      }
      if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(localObject))
      {
        if (!bB(paramIntent))
        {
          Log.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
          AppMethodBeat.o(33420);
          return;
        }
        o.report();
        MMAppMgr.a(this.appMgr, paramIntent, false);
        if ((MMAppMgr.OHl != null) && (MMAppMgr.OHl.length() > 800)) {
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33417);
              MMAppMgr.gIT();
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
        if (Util.isNullOrNil(paramContext)) {
          Log.i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
        }
        for (;;)
        {
          if ((MMAppMgr.OHl != null) && (MMAppMgr.OHl.length() > 800)) {
            new MMHandler(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33418);
                MMAppMgr.gIT();
                AppMethodBeat.o(33418);
              }
            });
          }
          AppMethodBeat.o(33420);
          return;
          if (MMAppMgr.OHl == null) {
            MMAppMgr.OHl = new StringBuffer(800);
          }
          MMAppMgr.OHl.append(paramContext);
          Log.i("MicroMsg.MMAppMgr", "cpan content: %s", new Object[] { paramContext });
        }
      }
      if (paramIntent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE"))
      {
        int i;
        if (!paramIntent.getBooleanExtra("intent_extra_is_silence_stat", false))
        {
          i = paramIntent.getIntExtra("intent_extra_opcode", 0);
          Log.d("MicroMsg.MMAppMgr", "incremental_update = ".concat(String.valueOf(i)));
          if (bg.aAc()) {
            com.tencent.mm.plugin.report.service.h.CyF.a(10328, new Object[] { Integer.valueOf(i) });
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
          if ((!bg.aAc()) || ((l1 == 0L) && (l2 == 0L))) {
            break label653;
          }
          Log.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
          if (!bool) {
            break;
          }
          n.b((int)l2, (int)l1, 0);
          AppMethodBeat.o(33420);
          return;
          i = paramIntent.getIntExtra("intent_extra_opcode", 0);
          Log.d("MicroMsg.MMAppMgr", "silence_update_stat = ".concat(String.valueOf(i)));
          if (bg.aAc())
          {
            if (i == 2)
            {
              int j = paramIntent.getIntExtra("intent_extra_install_dialog_times", 0);
              com.tencent.mm.plugin.report.service.h.CyF.a(11147, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            for (;;)
            {
              if ((i != 4) || (com.tencent.mm.pluginsdk.i.g.gnu() != 4)) {
                break label639;
              }
              paramContext = com.tencent.mm.pluginsdk.model.app.b.gmM();
              if (paramContext == null) {
                break;
              }
              paramContext.gmO();
              break;
              com.tencent.mm.plugin.report.service.h.CyF.a(11147, new Object[] { Integer.valueOf(i) });
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
        MMAppMgr.n(paramContext, true);
        AppMethodBeat.o(33420);
        return;
      }
      if (paramIntent.getAction().equals("MINIQB_OPEN_RET"))
      {
        paramContext = paramIntent.getStringExtra("op_type");
        if ("NOTIFY_RET".equals(paramContext))
        {
          com.tencent.mm.pluginsdk.ui.tools.a.bq(paramIntent);
          AppMethodBeat.o(33420);
          return;
        }
        if ("SEND_TO_FRIENDS".equals(paramContext))
        {
          Log.i("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS");
          if (!com.tencent.mm.kernel.g.aAc())
          {
            Log.e("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS, account not ready");
            AppMethodBeat.o(33420);
            return;
          }
          String str2 = com.tencent.mm.cr.a.bpF(paramIntent.getStringExtra("file_path"));
          localObject = paramIntent.getStringExtra("file_name");
          String str1 = paramIntent.getStringExtra("to_user");
          paramContext = paramIntent.getStringExtra("send_text");
          if ((Util.isNullOrNil(str2)) || (Util.isNullOrNil((String)localObject)) || (Util.isNullOrNil(str1)))
          {
            Log.e("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS, param empty");
            AppMethodBeat.o(33420);
            return;
          }
          WXFileObject localWXFileObject = new WXFileObject();
          localWXFileObject.setFilePath(str2);
          paramIntent = new WXMediaMessage();
          paramIntent.mediaObject = localWXFileObject;
          paramIntent.title = ((String)localObject);
          paramIntent.description = ((String)localObject);
          localObject = Util.stringsToList(str1.split(",")).iterator();
          while (((Iterator)localObject).hasNext())
          {
            str1 = (String)((Iterator)localObject).next();
            m.a(paramIntent, "", "", str1, 3, null);
            if (!Util.isNullOrNil(paramContext)) {
              com.tencent.mm.plugin.messenger.a.g.eir().ad(str1, paramContext, com.tencent.mm.model.ab.JG(str1));
            }
          }
        }
        AppMethodBeat.o(33420);
        return;
      }
      Log.e("MicroMsg.MMAppMgr", "unknown broadcast action");
      AppMethodBeat.o(33420);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr
 * JD-Core Version:    0.7.0.1
 */