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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.app.ak;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.o;
import com.tencent.mm.f.a.ac;
import com.tencent.mm.f.a.ae;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.af;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
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
import com.tencent.xweb.aj;
import java.util.Iterator;
import java.util.List;

public final class MMAppMgr
{
  private static StringBuffer WaG;
  private static long WaH;
  public Receiver WaI;
  private long maN;
  private String nga;
  
  public static void Fz(boolean paramBoolean)
  {
    AppMethodBeat.i(33426);
    Log.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), Util.getStack(), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      hHP();
    }
    Object localObject1 = new ac();
    EventCenter.instance.publish((IEvent)localObject1);
    localObject1 = new mr();
    ((mr)localObject1).fKQ.status = 0;
    ((mr)localObject1).fKQ.bnA = 2;
    EventCenter.instance.publish((IEvent)localObject1);
    hHN();
    if (paramBoolean)
    {
      bh.MM(Util.getStack().toString());
      com.tencent.mm.kernel.h.aHH().releaseAll();
    }
    Log.appenderClose();
    Mars.onSingalCrash(0);
    com.tencent.mm.cc.a.g(MMApplicationContext.getContext(), new String[] { MMApplicationContext.getApplicationId() + ":recovery", MMApplicationContext.getApplicationId() + ":support", MMApplicationContext.getApplicationId() + ":tools", MMApplicationContext.getApplicationId() + ":toolsmp", MMApplicationContext.getApplicationId() + ":appbrand0", MMApplicationContext.getApplicationId() + ":appbrand1", MMApplicationContext.getApplicationId() + ":appbrand2", MMApplicationContext.getApplicationId() + ":appbrand3", MMApplicationContext.getApplicationId() + ":appbrand4", MMApplicationContext.getApplicationId() + ":lite" });
    try
    {
      aj.clearAllWebViewCache(MMApplicationContext.getContext(), true);
      Log.i("MicroMsg.MMAppMgr", "clearAllWebViewCache");
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/ui/MMAppMgr", "killProcess", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/MMAppMgr", "killProcess", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
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
  
  public static void RP()
  {
    AppMethodBeat.i(185859);
    Fz(true);
    AppMethodBeat.o(185859);
  }
  
  public static boolean a(final Activity paramActivity, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(33433);
    final SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    boolean bool = localSharedPreferences.getBoolean("gprs_alert", true);
    ChannelUtil.isShowingGprsAlert &= bool;
    if (bool)
    {
      ak.init(paramActivity.getBaseContext());
      View localView = View.inflate(paramActivity, R.i.eht, null);
      Object localObject3 = WeChatBrands.Wordings.translate(paramActivity.getString(R.l.privacy_detail));
      Object localObject2 = WeChatBrands.Wordings.translate(paramActivity.getString(R.l.eLt));
      String str = WeChatBrands.Wordings.translate(paramActivity.getString(R.l.dLS, new Object[] { localObject3, localObject2 }));
      Object localObject1 = Spannable.Factory.getInstance().newSpannable(str);
      ClickableSpan local12 = new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33414);
          Util.jump(this.fgc, WeChatBrands.Wordings.translate(MMApplicationContext.getResources().getString(R.l.license_read_url, new Object[] { LocaleUtil.getCurrentLanguage(this.fgc), LocaleUtil.getCurrentCountryCode(), "setting", Integer.valueOf(0), Integer.valueOf(0) })));
          AppMethodBeat.o(33414);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(33415);
          paramAnonymousTextPaint.setColor(this.fgc.getResources().getColor(R.e.link_color));
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
      localObject2 = (TextView)localView.findViewById(R.h.dLS);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
      localObject1 = (CheckBox)localView.findViewById(R.h.dHY);
      paramOnClickListener = com.tencent.mm.ui.base.h.a(paramActivity, false, null, localView, paramActivity.getString(R.l.confirm_dialog_ok), paramActivity.getString(R.l.main_exit), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33416);
          if (this.WaJ.isChecked())
          {
            SharedPreferences.Editor localEditor = localSharedPreferences.edit();
            localEditor.putBoolean("gprs_alert", false);
            localEditor.commit();
          }
          ChannelUtil.isShowingGprsAlert = false;
          paramAnonymousDialogInterface.dismiss();
          MMAppMgr.kQ(paramActivity);
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
          MMAppMgr.kO(this.fgc);
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
          this.fgc.onKeyDown(4, new KeyEvent(0, 4));
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
    View localView = View.inflate(paramContext, R.i.ejw, null);
    Object localObject = (CheckBox)localView.findViewById(R.h.dNo);
    ((CheckBox)localObject).setText(paramContext.getString(R.l.eMq));
    ((CheckBox)localObject).setOnCheckedChangeListener(new MMAppMgr.4());
    localView.findViewById(R.h.dNp).setVisibility(8);
    localObject = (TextView)localView.findViewById(R.h.network_tips_content);
    switch (paramInt)
    {
    case 2: 
    default: 
      ((TextView)localObject).setText(R.l.eMy);
      paramInt = 1;
    }
    while (paramInt != 0)
    {
      paramContext = new d.a(paramContext);
      paramContext.ayc(R.l.app_tip);
      paramContext.HG(false);
      paramContext.iI(localView);
      paramContext.ayj(R.l.eMv).c(paramOnClickListener1);
      paramContext.ayk(R.l.eMq).d(paramOnClickListener2);
      paramContext.icu().show();
      AppMethodBeat.o(33434);
      return true;
      ((TextView)localObject).setText(R.l.eMy);
      paramInt = 0;
      continue;
      ((TextView)localObject).setText(R.l.eMp);
      paramInt = 1;
    }
    AppMethodBeat.o(33434);
    return false;
  }
  
  public static void abF()
  {
    AppMethodBeat.i(33424);
    bh.getNotification().abF();
    AppMethodBeat.o(33424);
  }
  
  public static boolean abN()
  {
    AppMethodBeat.i(222626);
    if (1 == ChannelUtil.channelId)
    {
      AppMethodBeat.o(222626);
      return false;
    }
    if (com.tencent.mm.protocal.d.RAG)
    {
      AppMethodBeat.o(222626);
      return false;
    }
    if ((com.tencent.mm.by.c.bsp("whatsnew")) && (LocaleUtil.isSimplifiedChineseAppLang()))
    {
      Log.i("MicroMsg.MMAppMgr", "[whatsnew] available.");
      AppMethodBeat.o(222626);
      return true;
    }
    AppMethodBeat.o(222626);
    return false;
  }
  
  public static void bT(Context paramContext)
  {
    AppMethodBeat.i(33428);
    o(paramContext, true);
    AppMethodBeat.o(33428);
  }
  
  public static void bU(Context paramContext)
  {
    AppMethodBeat.i(222611);
    af.btN().edit().putBoolean("is_in_notify_mode", true).commit();
    MMEntryLock.unlock("welcome_page_show");
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().s(-1, null);
    ae localae = new ae();
    localae.fvH.fvI = false;
    EventCenter.instance.publish(localae);
    com.tencent.mm.plugin.setting.c.mIH.abF();
    ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().aqY();
    o(paramContext, false);
    AppMethodBeat.o(222611);
  }
  
  public static com.tencent.mm.ui.widget.a.d bW(Context paramContext)
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
    bh.beI();
    Object localObject = (Boolean)com.tencent.mm.model.c.aHp().b(4105, Boolean.FALSE);
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(33435);
      return null;
    }
    localObject = View.inflate(paramContext, R.i.eil, null);
    ((CheckBox)((View)localObject).findViewById(R.h.dKZ)).setOnCheckedChangeListener(new MMAppMgr.5());
    MMAppMgr.6 local6 = new MMAppMgr.6(paramContext);
    paramContext = new d.a(paramContext);
    paramContext.ayc(R.l.nearby_friend_setting_tips_title);
    paramContext.iI((View)localObject);
    paramContext.ayj(R.l.app_set).c(local6);
    paramContext.ayk(R.l.app_ignore_it);
    paramContext = paramContext.icu();
    paramContext.show();
    AppMethodBeat.o(33435);
    return paramContext;
  }
  
  public static boolean bn(Activity paramActivity)
  {
    AppMethodBeat.i(222636);
    boolean bool = a(paramActivity, null);
    AppMethodBeat.o(222636);
    return bool;
  }
  
  private static String byr(String paramString)
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
  
  public static boolean h(Context paramContext, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(222621);
    if (!bh.aHB())
    {
      AppMethodBeat.o(222621);
      return false;
    }
    bh.beI();
    int i = ((Integer)com.tencent.mm.model.c.aHp().b(65, Integer.valueOf(0))).intValue();
    if (i >= 5)
    {
      AppMethodBeat.o(222621);
      return false;
    }
    if (!MMEntryLock.lock("show_wap_adviser"))
    {
      AppMethodBeat.o(222621);
      return false;
    }
    View localView = View.inflate(paramContext, R.i.ejw, null);
    ((TextView)localView.findViewById(R.h.network_tips_content)).setText(R.l.eMw);
    paramContext = new d.a(paramContext);
    paramContext.ayc(R.l.app_tip);
    paramContext.iI(localView);
    paramContext.ayj(R.l.app_ok).c(new MMAppMgr.1(i));
    paramContext.HG(false);
    paramContext.ayk(R.l.eMr).d(new MMAppMgr.7());
    paramContext.a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(33410);
        MMEntryLock.unlock("show_wap_adviser");
        if (this.QaB != null) {
          this.QaB.onClick(paramAnonymousDialogInterface, 0);
        }
        AppMethodBeat.o(33410);
      }
    });
    paramContext.icu().show();
    AppMethodBeat.o(222621);
    return true;
  }
  
  private static void hHN()
  {
    AppMethodBeat.i(33421);
    StringBuffer localStringBuffer = new StringBuffer(800);
    if (WaG == null)
    {
      WaG = localStringBuffer;
      WaH = Util.nowSecond();
      AppMethodBeat.o(33421);
      return;
    }
    String str = WaG.toString();
    localStringBuffer.append(byr(str));
    WaG = localStringBuffer;
    Log.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", new Object[] { str });
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(10508, "1," + WaH + "," + str);
    WaH = Util.nowSecond();
    AppMethodBeat.o(33421);
  }
  
  public static void hHO()
  {
    AppMethodBeat.i(222554);
    hHN();
    Log.appenderClose();
    Mars.onSingalCrash(0);
    AppMethodBeat.o(222554);
  }
  
  public static void hHP()
  {
    AppMethodBeat.i(33427);
    Context localContext = MMApplicationContext.getContext();
    if (localContext != null)
    {
      if (!com.tencent.mm.booter.c.aqw()) {
        break label80;
      }
      com.tencent.mm.app.g.aaF();
    }
    for (;;)
    {
      com.tencent.mm.by.c.bs(new Intent(localContext, NotifyReceiver.NotifyService.class));
      localContext.stopService(new Intent(localContext, CacheService.class));
      com.tencent.mm.by.c.n(new Intent().setClassName(localContext, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"), "exdevice");
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
  
  public static void hHQ() {}
  
  public static void hg(String paramString)
  {
    AppMethodBeat.i(33423);
    bh.getNotification().hg(paramString);
    AppMethodBeat.o(33423);
  }
  
  public static void kO(Context paramContext)
  {
    AppMethodBeat.i(222605);
    com.tencent.mm.kernel.h.aHH().eR(true);
    Mars.onSingalCrash(0);
    MMNativeJpeg.Destroy();
    o.abH();
    if ((bh.aGY() != null) && (bh.aGY().lCD != null)) {
      bh.aGY().lCD.gl(true);
    }
    Object localObject = new Intent().setClass(paramContext, LauncherUI.class);
    ((Intent)localObject).addFlags(32768);
    ((Intent)localObject).putExtra("absolutely_exit_pid", Process.myPid());
    ((Intent)localObject).putExtra("kill_service", true);
    if (!(paramContext instanceof Activity)) {
      ((Intent)localObject).addFlags(268435456);
    }
    for (;;)
    {
      try
      {
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/MMAppMgr", "exitApplicationFromSplash", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/MMAppMgr", "exitApplicationFromSplash", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(222605);
        return;
      }
      catch (Throwable paramContext)
      {
        Log.printErrStackTrace("MicroMsg.MMAppMgr", paramContext, "[-] Fail to start launcherUI in suicide.", new Object[0]);
        AppMethodBeat.o(222605);
      }
      ((Activity)paramContext).finish();
    }
  }
  
  public static boolean kP(Context paramContext)
  {
    AppMethodBeat.i(33430);
    if (!bh.aHB())
    {
      AppMethodBeat.o(33430);
      return false;
    }
    bh.beI();
    if (Util.nullAsFalse((Boolean)com.tencent.mm.model.c.aHp().b(61, null)))
    {
      AppMethodBeat.o(33430);
      return false;
    }
    if (!MMEntryLock.lock("show_wap_adviser"))
    {
      AppMethodBeat.o(33430);
      return false;
    }
    View localView = View.inflate(paramContext, R.i.ejw, null);
    ((TextView)localView.findViewById(R.h.network_tips_content)).setText(R.l.eMx);
    Object localObject = (CheckBox)localView.findViewById(R.h.dNo);
    ((CheckBox)localObject).setText(paramContext.getString(R.l.ePt));
    ((CheckBox)localObject).setOnCheckedChangeListener(new MMAppMgr.9());
    ((CheckBox)localObject).setVisibility(0);
    localObject = new d.a(paramContext);
    ((d.a)localObject).ayc(R.l.app_tip);
    ((d.a)localObject).iI(localView);
    ((d.a)localObject).ayj(R.l.ePv).c(new MMAppMgr.10(paramContext));
    ((d.a)localObject).HG(false);
    ((d.a)localObject).ayk(R.l.ePu);
    ((d.a)localObject).a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(33413);
        MMEntryLock.unlock("show_wap_adviser");
        AppMethodBeat.o(33413);
      }
    });
    ((d.a)localObject).icu().show();
    AppMethodBeat.o(33430);
    return true;
  }
  
  public static void kQ(Context paramContext)
  {
    AppMethodBeat.i(33432);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    if (!localSharedPreferences.getBoolean("Main_ShortCut", false))
    {
      Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramContext.getString(R.l.launcher_name));
      localIntent1.putExtra("duplicate", false);
      Intent localIntent2 = new Intent("android.intent.action.MAIN");
      localIntent2.addCategory("android.intent.category.LAUNCHER");
      localIntent2.setComponent(new ComponentName(paramContext.getPackageName(), MMApplicationContext.getSourcePackageName() + ".ui.LauncherUI"));
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramContext, R.g.icon));
      localIntent1.putExtra("shortcut_icon_resource_id", R.g.icon);
      localIntent1.putExtra("shortcut_is_adaptive_icon", true);
      localIntent1.putExtra("is_main_shortcut", true);
      com.tencent.mm.plugin.base.model.b.o(paramContext, localIntent1);
      paramContext = localSharedPreferences.edit();
      paramContext.putBoolean("Main_ShortCut", true);
      paramContext.commit();
    }
    AppMethodBeat.o(33432);
  }
  
  public static void o(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(33429);
    com.tencent.mm.kernel.h.aHH().eR(paramBoolean);
    Mars.onSingalCrash(0);
    MMNativeJpeg.Destroy();
    o.abH();
    if ((bh.aGY() != null) && (bh.aGY().lCD != null)) {
      bh.aGY().lCD.gl(paramBoolean);
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/MMAppMgr", "exitApplication", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/MMAppMgr", "exitApplication", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    
    private static boolean bC(Intent paramIntent)
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
      if ((bh.beB()) || (bh.beD()))
      {
        AppMethodBeat.o(33420);
        return;
      }
      Object localObject = paramIntent.getAction();
      if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(localObject))
      {
        if (!bC(paramIntent))
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
        if (!bC(paramIntent))
        {
          Log.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
          AppMethodBeat.o(33420);
          return;
        }
        o.report();
        MMAppMgr.a(this.appMgr, paramIntent, false);
        if ((MMAppMgr.hHR() != null) && (MMAppMgr.hHR().length() > 800)) {
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33417);
              MMAppMgr.access$200();
              AppMethodBeat.o(33417);
            }
          });
        }
        AppMethodBeat.o(33420);
        return;
      }
      if ("com.tencent.mm.ui.ACTION_ABTEST".equals(localObject))
      {
        MMAppMgr.bB(paramIntent);
        if ((MMAppMgr.hHR() != null) && (MMAppMgr.hHR().length() > 800)) {
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33418);
              MMAppMgr.access$200();
              AppMethodBeat.o(33418);
            }
          });
        }
        AppMethodBeat.o(33420);
        return;
      }
      if (paramIntent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE"))
      {
        int i;
        if (!paramIntent.getBooleanExtra("intent_extra_is_silence_stat", false))
        {
          i = paramIntent.getIntExtra("intent_extra_opcode", 0);
          Log.d("MicroMsg.MMAppMgr", "incremental_update = ".concat(String.valueOf(i)));
          if (bh.aHB()) {
            com.tencent.mm.plugin.report.service.h.IzE.a(10328, new Object[] { Integer.valueOf(i) });
          }
        }
        long l1;
        long l2;
        label577:
        for (;;)
        {
          l1 = paramIntent.getLongExtra("intent_extra_flow_stat_upstream", 0L);
          l2 = paramIntent.getLongExtra("intent_extra_flow_stat_downstream", 0L);
          boolean bool = paramIntent.getBooleanExtra("intent_extra_flow_stat_is_wifi", false);
          if ((!bh.aHB()) || ((l1 == 0L) && (l2 == 0L))) {
            break label591;
          }
          Log.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
          if (!bool) {
            break;
          }
          com.tencent.mm.modelstat.m.c((int)l2, (int)l1, 0);
          AppMethodBeat.o(33420);
          return;
          i = paramIntent.getIntExtra("intent_extra_opcode", 0);
          Log.d("MicroMsg.MMAppMgr", "silence_update_stat = ".concat(String.valueOf(i)));
          if (bh.aHB())
          {
            if (i == 2)
            {
              int j = paramIntent.getIntExtra("intent_extra_install_dialog_times", 0);
              com.tencent.mm.plugin.report.service.h.IzE.a(11147, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            for (;;)
            {
              if ((i != 4) || (com.tencent.mm.pluginsdk.j.g.hia() != 4)) {
                break label577;
              }
              paramContext = com.tencent.mm.pluginsdk.model.app.b.hhn();
              if (paramContext == null) {
                break;
              }
              paramContext.hhp();
              break;
              com.tencent.mm.plugin.report.service.h.IzE.a(11147, new Object[] { Integer.valueOf(i) });
            }
          }
        }
        com.tencent.mm.modelstat.m.d((int)l2, (int)l1, 0);
        label591:
        AppMethodBeat.o(33420);
        return;
      }
      if (paramIntent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP"))
      {
        MMAppMgr.bT(paramContext);
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
          if (!com.tencent.mm.kernel.h.aHB())
          {
            Log.e("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS, account not ready");
            AppMethodBeat.o(33420);
            return;
          }
          String str2 = com.tencent.mm.xwebutil.a.bCC(paramIntent.getStringExtra("file_path"));
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
            com.tencent.mm.pluginsdk.model.app.m.a(paramIntent, "", "", str1, 3, null);
            if (!Util.isNullOrNil(paramContext)) {
              com.tencent.mm.plugin.messenger.a.g.eRW().ai(str1, paramContext, ab.QZ(str1));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr
 * JD-Core Version:    0.7.0.1
 */