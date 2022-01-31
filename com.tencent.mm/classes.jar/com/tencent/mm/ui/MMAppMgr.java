package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.LocationManager;
import android.os.Process;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mars.BaseEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.o;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.a.w;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.b.c.a;

public final class MMAppMgr
{
  static StringBuffer zbK;
  private static long zbL;
  private long fQk;
  private String gGo;
  public MMAppMgr.Receiver zbM;
  
  public MMAppMgr()
  {
    AppMethodBeat.i(29569);
    AppMethodBeat.o(29569);
  }
  
  public static void BR()
  {
    AppMethodBeat.i(29575);
    aw.getNotification().BR();
    AppMethodBeat.o(29575);
  }
  
  public static boolean a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(29587);
    SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences(ah.dsP(), 0);
    boolean bool = localSharedPreferences.getBoolean("gprs_alert", true);
    com.tencent.mm.sdk.platformtools.g.ymM &= bool;
    if (bool)
    {
      View localView = View.inflate(paramActivity, 2130969843, null);
      Object localObject3 = paramActivity.getString(2131302168);
      Object localObject2 = paramActivity.getString(2131301423);
      String str = paramActivity.getString(2131301422, new Object[] { localObject3, localObject2 });
      Object localObject1 = Spannable.Factory.getInstance().newSpannable(str);
      MMAppMgr.12 local12 = new MMAppMgr.12(paramActivity);
      int i = str.indexOf((String)localObject3);
      int j = str.indexOf((String)localObject3);
      ((Spannable)localObject1).setSpan(local12, i, ((String)localObject3).length() + j, 33);
      localObject3 = new StyleSpan(1);
      i = str.indexOf((String)localObject2);
      j = str.indexOf((String)localObject2);
      ((Spannable)localObject1).setSpan(localObject3, i, ((String)localObject2).length() + j, 33);
      localObject2 = (TextView)localView.findViewById(2131824823);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
      localObject1 = (CheckBox)localView.findViewById(2131824824);
      paramOnClickListener = com.tencent.mm.ui.base.h.a(paramActivity, false, null, localView, paramActivity.getString(2131298501), paramActivity.getString(2131301419), new MMAppMgr.13((CheckBox)localObject1, localSharedPreferences, paramActivity, paramOnClickListener), new MMAppMgr.2(paramActivity));
      if (paramOnClickListener == null)
      {
        AppMethodBeat.o(29587);
        return false;
      }
      paramOnClickListener.setOnCancelListener(new MMAppMgr.3(paramActivity));
    }
    AppMethodBeat.o(29587);
    return bool;
  }
  
  public static boolean a(Context paramContext, int paramInt, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(29588);
    View localView = View.inflate(paramContext, 2130970356, null);
    Object localObject = (CheckBox)localView.findViewById(2131826534);
    ((CheckBox)localObject).setText(paramContext.getString(2131301794));
    ((CheckBox)localObject).setOnCheckedChangeListener(new MMAppMgr.4());
    localView.findViewById(2131826533).setVisibility(8);
    localObject = (TextView)localView.findViewById(2131826532);
    switch (paramInt)
    {
    case 2: 
    default: 
      ((TextView)localObject).setText(2131301803);
      paramInt = 1;
    }
    while (paramInt != 0)
    {
      paramContext = new c.a(paramContext);
      paramContext.Rb(2131297087);
      paramContext.rG(false);
      paramContext.fu(localView);
      paramContext.Ri(2131301800).a(paramOnClickListener1);
      paramContext.Rj(2131301794).b(paramOnClickListener2);
      paramContext.aLZ().show();
      AppMethodBeat.o(29588);
      return true;
      ((TextView)localObject).setText(2131301803);
      paramInt = 0;
      continue;
      ((TextView)localObject).setText(2131301793);
      paramInt = 1;
    }
    AppMethodBeat.o(29588);
    return false;
  }
  
  public static void aAc()
  {
    AppMethodBeat.i(156905);
    qr(true);
    AppMethodBeat.o(156905);
  }
  
  private static String ato(String paramString)
  {
    AppMethodBeat.i(29572);
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
    AppMethodBeat.o(29572);
    return paramString;
  }
  
  public static void ay(Activity paramActivity)
  {
    AppMethodBeat.i(29584);
    new Intent();
    com.tencent.mm.bq.d.H(paramActivity, "whatsnew", ".ui.WhatsNewUI");
    AppMethodBeat.o(29584);
  }
  
  public static void bi(Context paramContext)
  {
    AppMethodBeat.i(29579);
    l(paramContext, true);
    AppMethodBeat.o(29579);
  }
  
  public static com.tencent.mm.ui.widget.b.c bl(Context paramContext)
  {
    AppMethodBeat.i(29589);
    try
    {
      localObject = (LocationManager)paramContext.getSystemService("location");
      if (at.isWifi(paramContext))
      {
        boolean bool = ((LocationManager)localObject).isProviderEnabled("gps");
        if (bool)
        {
          AppMethodBeat.o(29589);
          return null;
        }
      }
    }
    catch (Exception paramContext)
    {
      com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.MMAppMgr", paramContext, "showLbsTipsAlert error", new Object[0]);
      AppMethodBeat.o(29589);
      return null;
    }
    aw.aaz();
    Object localObject = (Boolean)com.tencent.mm.model.c.Ru().get(4105, Boolean.FALSE);
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(29589);
      return null;
    }
    localObject = View.inflate(paramContext, 2130969980, null);
    ((CheckBox)((View)localObject).findViewById(2131825415)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(153812);
        if (paramAnonymousBoolean)
        {
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(4105, Boolean.TRUE);
          AppMethodBeat.o(153812);
          return;
        }
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(4105, Boolean.FALSE);
        AppMethodBeat.o(153812);
      }
    });
    DialogInterface.OnClickListener local6 = new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(153813);
        try
        {
          paramAnonymousDialogInterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
          this.val$context.startActivity(paramAnonymousDialogInterface);
          AppMethodBeat.o(153813);
          return;
        }
        catch (Exception paramAnonymousDialogInterface)
        {
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.MMAppMgr", paramAnonymousDialogInterface, "showLbsTipsAlert", new Object[0]);
          AppMethodBeat.o(153813);
        }
      }
    };
    paramContext = new c.a(paramContext);
    paramContext.Rb(2131301772);
    paramContext.fu((View)localObject);
    paramContext.Ri(2131297072).a(local6);
    paramContext.Rj(2131296980);
    paramContext = paramContext.aLZ();
    paramContext.show();
    AppMethodBeat.o(29589);
    return paramContext;
  }
  
  public static void cancelNotification(String paramString)
  {
    AppMethodBeat.i(29574);
    aw.getNotification().cancelNotification(paramString);
    AppMethodBeat.o(29574);
  }
  
  public static void dCx()
  {
    AppMethodBeat.i(29571);
    StringBuffer localStringBuffer = new StringBuffer(800);
    if (zbK == null)
    {
      zbK = localStringBuffer;
      zbL = bo.aox();
      AppMethodBeat.o(29571);
      return;
    }
    String str = zbK.toString();
    localStringBuffer.append(ato(str));
    zbK = localStringBuffer;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", new Object[] { str });
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(10508, "1," + zbL + "," + str);
    zbL = bo.aox();
    AppMethodBeat.o(29571);
  }
  
  public static void dCy()
  {
    AppMethodBeat.i(29578);
    Context localContext = ah.getContext();
    if (localContext != null)
    {
      if (!com.tencent.mm.booter.c.Ii()) {
        break label80;
      }
      com.tencent.mm.app.e.Bb();
    }
    for (;;)
    {
      com.tencent.mm.bq.d.aH(new Intent(localContext, NotifyReceiver.NotifyService.class));
      localContext.stopService(new Intent(localContext, CacheService.class));
      com.tencent.mm.bq.d.l(new Intent().setClassName(localContext, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"), "exdevice");
      AppMethodBeat.o(29578);
      return;
      try
      {
        label80:
        localContext.stopService(new Intent(localContext, CoreService.class));
      }
      catch (Exception localException)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MMAppMgr", "killService() Exception:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static boolean hJ(Context paramContext)
  {
    AppMethodBeat.i(29583);
    if (!aw.RG())
    {
      AppMethodBeat.o(29583);
      return false;
    }
    aw.aaz();
    if (bo.e((Boolean)com.tencent.mm.model.c.Ru().get(61, null)))
    {
      AppMethodBeat.o(29583);
      return false;
    }
    if (!aj.apk("show_wap_adviser"))
    {
      AppMethodBeat.o(29583);
      return false;
    }
    View localView = View.inflate(paramContext, 2130970356, null);
    ((TextView)localView.findViewById(2131826532)).setText(2131301802);
    Object localObject = (CheckBox)localView.findViewById(2131826534);
    ((CheckBox)localObject).setText(paramContext.getString(2131302173));
    ((CheckBox)localObject).setOnCheckedChangeListener(new MMAppMgr.9());
    ((CheckBox)localObject).setVisibility(0);
    localObject = new c.a(paramContext);
    ((c.a)localObject).Rb(2131297087);
    ((c.a)localObject).fu(localView);
    ((c.a)localObject).Ri(2131302175).a(new MMAppMgr.10(paramContext));
    ((c.a)localObject).rG(false);
    ((c.a)localObject).Rj(2131302174);
    ((c.a)localObject).a(new MMAppMgr.11());
    ((c.a)localObject).aLZ().show();
    AppMethodBeat.o(29583);
    return true;
  }
  
  public static void hK(Context paramContext)
  {
    AppMethodBeat.i(29585);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(ah.dsP(), 0);
    if (!localSharedPreferences.getBoolean("Main_ShortCut", false))
    {
      Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramContext.getString(2131301058));
      localIntent1.putExtra("duplicate", false);
      Intent localIntent2 = new Intent("android.intent.action.MAIN");
      localIntent2.addCategory("android.intent.category.LAUNCHER");
      localIntent2.setComponent(new ComponentName(paramContext.getPackageName(), ah.dsO() + ".ui.LauncherUI"));
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramContext, 2130839103));
      localIntent1.putExtra("shortcut_icon_resource_id", 2130839103);
      localIntent1.putExtra("shortcut_is_adaptive_icon", true);
      localIntent1.putExtra("is_main_shortcut", true);
      com.tencent.mm.plugin.base.model.b.p(paramContext, localIntent1);
      paramContext = localSharedPreferences.edit();
      paramContext.putBoolean("Main_ShortCut", true);
      paramContext.commit();
    }
    AppMethodBeat.o(29585);
  }
  
  public static void l(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(29580);
    com.tencent.mm.kernel.g.RM().cw(paramBoolean);
    com.tencent.mrs.a.onDestroy();
    BaseEvent.onSingalCrash(0);
    MMNativeJpeg.Destroy();
    o.BU();
    if ((aw.Rc() != null) && (aw.Rc().ftA != null)) {
      aw.Rc().ftA.cS(paramBoolean);
    }
    Intent localIntent = new Intent().setClass(paramContext, LauncherUI.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("absolutely_exit_pid", Process.myPid());
    localIntent.putExtra("kill_service", paramBoolean);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    paramContext.startActivity(localIntent);
    AppMethodBeat.o(29580);
  }
  
  public static void qr(boolean paramBoolean)
  {
    AppMethodBeat.i(29577);
    com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), bo.dtY(), Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.report.b.d.x(2, 0, "");
    if (paramBoolean) {
      dCy();
    }
    Object localObject = new w();
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = new jo();
    ((jo)localObject).cze.status = 0;
    ((jo)localObject).cze.aXG = 2;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    dCx();
    if (paramBoolean)
    {
      aw.mw(bo.dtY().toString());
      com.tencent.mm.kernel.g.RM().releaseAll();
    }
    com.tencent.mm.sdk.platformtools.ab.appenderClose();
    BaseEvent.onSingalCrash(0);
    com.tencent.mrs.a.onDestroy();
    com.tencent.mm.bu.a.f(ah.getContext(), new String[] { "com.tencent.mm:recovery", "com.tencent.mm:support", "com.tencent.mm:tools", "com.tencent.mm:toolsmp", "com.tencent.mm:appbrand0", "com.tencent.mm:appbrand1", "com.tencent.mm:appbrand2", "com.tencent.mm:appbrand3", "com.tencent.mm:appbrand4" });
    try
    {
      com.tencent.xweb.ab.clearAllWebViewCache(ah.getContext(), true);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMAppMgr", "clearAllWebViewCache");
      Process.killProcess(Process.myPid());
      AppMethodBeat.o(29577);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMAppMgr", "clear cookie failed : %s", new Object[] { localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr
 * JD-Core Version:    0.7.0.1
 */