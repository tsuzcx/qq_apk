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
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.z;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.e;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.i.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.xweb.ah;
import java.util.Iterator;
import java.util.List;

public final class MMAppMgr
{
  static StringBuffer JwR;
  private static long JwS;
  public Receiver JwT;
  private long ipF;
  private String jpW;
  
  public static void MP()
  {
    AppMethodBeat.i(33424);
    bc.getNotification().MP();
    AppMethodBeat.o(33424);
  }
  
  public static boolean a(final Activity paramActivity, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(33433);
    final SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences(ak.fow(), 0);
    boolean bool = localSharedPreferences.getBoolean("gprs_alert", true);
    k.IwJ &= bool;
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
          bu.ce(this.iQK, ak.getResources().getString(2131760685, new Object[] { ad.iR(this.iQK), ad.fol(), "setting", Integer.valueOf(0), Integer.valueOf(0) }));
          AppMethodBeat.o(33414);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(33415);
          paramAnonymousTextPaint.setColor(this.iQK.getResources().getColor(2131100547));
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
      paramOnClickListener = h.a(paramActivity, false, null, localView, paramActivity.getString(2131757560), paramActivity.getString(2131761066), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33416);
          if (this.JwU.isChecked())
          {
            SharedPreferences.Editor localEditor = localSharedPreferences.edit();
            localEditor.putBoolean("gprs_alert", false);
            localEditor.commit();
          }
          k.IwJ = false;
          paramAnonymousDialogInterface.dismiss();
          MMAppMgr.jT(paramActivity);
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
          paramAnonymousDialogInterface = this.iQK;
          com.tencent.mm.kernel.g.ajS().dD(true);
          Mars.onSingalCrash(0);
          MMNativeJpeg.Destroy();
          o.MS();
          if ((bc.ajj() != null) && (bc.ajj().hRo != null)) {
            bc.ajj().hRo.eJ(true);
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
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/MMAppMgr", "exitApplicationFromSplash", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/MMAppMgr", "exitApplicationFromSplash", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(33404);
              return;
            }
            catch (Throwable paramAnonymousDialogInterface)
            {
              ae.printErrStackTrace("MicroMsg.MMAppMgr", paramAnonymousDialogInterface, "[-] Fail to start launcherUI in suicide.", new Object[0]);
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
          this.iQK.onKeyDown(4, new KeyEvent(0, 4));
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
      paramContext.afN(2131755906);
      paramContext.zf(false);
      paramContext.hd(localView);
      paramContext.afU(2131761550).c(paramOnClickListener1);
      paramContext.afV(2131761541).d(paramOnClickListener2);
      paramContext.fQv().show();
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
  
  private static String aWT(String paramString)
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
    AppMethodBeat.i(33428);
    m(paramContext, true);
    AppMethodBeat.o(33428);
  }
  
  public static com.tencent.mm.ui.widget.a.d bD(Context paramContext)
  {
    AppMethodBeat.i(33435);
    try
    {
      localObject = (LocationManager)paramContext.getSystemService("location");
      if (az.isWifi(paramContext))
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
      ae.printErrStackTrace("MicroMsg.MMAppMgr", paramContext, "showLbsTipsAlert error", new Object[0]);
      AppMethodBeat.o(33435);
      return null;
    }
    bc.aCg();
    Object localObject = (Boolean)com.tencent.mm.model.c.ajA().get(4105, Boolean.FALSE);
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(33435);
      return null;
    }
    localObject = View.inflate(paramContext, 2131494581, null);
    ((CheckBox)((View)localObject).findViewById(2131301370)).setOnCheckedChangeListener(new MMAppMgr.5());
    MMAppMgr.6 local6 = new MMAppMgr.6(paramContext);
    paramContext = new d.a(paramContext);
    paramContext.afN(2131761519);
    paramContext.hd((View)localObject);
    paramContext.afU(2131755889).c(local6);
    paramContext.afV(2131755796);
    paramContext = paramContext.fQv();
    paramContext.show();
    AppMethodBeat.o(33435);
    return paramContext;
  }
  
  public static void bd(Activity paramActivity)
  {
    AppMethodBeat.i(33431);
    new Intent();
    com.tencent.mm.br.d.Q(paramActivity, "whatsnew", ".ui.WhatsNewUI");
    AppMethodBeat.o(33431);
  }
  
  public static void bgT()
  {
    AppMethodBeat.i(185859);
    xu(true);
    AppMethodBeat.o(185859);
  }
  
  public static void cancelNotification(String paramString)
  {
    AppMethodBeat.i(33423);
    bc.getNotification().cancelNotification(paramString);
    AppMethodBeat.o(33423);
  }
  
  public static void fAZ()
  {
    AppMethodBeat.i(33421);
    StringBuffer localStringBuffer = new StringBuffer(800);
    if (JwR == null)
    {
      JwR = localStringBuffer;
      JwS = bu.aRi();
      AppMethodBeat.o(33421);
      return;
    }
    String str = JwR.toString();
    localStringBuffer.append(aWT(str));
    JwR = localStringBuffer;
    ae.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", new Object[] { str });
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(10508, "1," + JwS + "," + str);
    JwS = bu.aRi();
    AppMethodBeat.o(33421);
  }
  
  public static void fBa()
  {
    AppMethodBeat.i(33427);
    Context localContext = ak.getContext();
    if (localContext != null)
    {
      if (!com.tencent.mm.booter.c.WM()) {
        break label80;
      }
      com.tencent.mm.app.g.LW();
    }
    for (;;)
    {
      com.tencent.mm.br.d.bg(new Intent(localContext, NotifyReceiver.NotifyService.class));
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
        ae.e("MicroMsg.MMAppMgr", "killService() Exception:%s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public static boolean jS(Context paramContext)
  {
    AppMethodBeat.i(33430);
    if (!bc.ajM())
    {
      AppMethodBeat.o(33430);
      return false;
    }
    bc.aCg();
    if (bu.o((Boolean)com.tencent.mm.model.c.ajA().get(61, null)))
    {
      AppMethodBeat.o(33430);
      return false;
    }
    if (!ao.aRR("show_wap_adviser"))
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
    ((d.a)localObject).afN(2131755906);
    ((d.a)localObject).hd(localView);
    ((d.a)localObject).afU(2131762017).c(new MMAppMgr.10(paramContext));
    ((d.a)localObject).zf(false);
    ((d.a)localObject).afV(2131762016);
    ((d.a)localObject).a(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(33413);
        ao.aRS("show_wap_adviser");
        AppMethodBeat.o(33413);
      }
    });
    ((d.a)localObject).fQv().show();
    AppMethodBeat.o(33430);
    return true;
  }
  
  public static void jT(Context paramContext)
  {
    AppMethodBeat.i(33432);
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(ak.fow(), 0);
    if (!localSharedPreferences.getBoolean("Main_ShortCut", false))
    {
      Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramContext.getString(2131760676));
      localIntent1.putExtra("duplicate", false);
      Intent localIntent2 = new Intent("android.intent.action.MAIN");
      localIntent2.addCategory("android.intent.category.LAUNCHER");
      localIntent2.setComponent(new ComponentName(paramContext.getPackageName(), ak.fov() + ".ui.LauncherUI"));
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
    com.tencent.mm.kernel.g.ajS().dD(paramBoolean);
    Mars.onSingalCrash(0);
    MMNativeJpeg.Destroy();
    o.MS();
    if ((bc.ajj() != null) && (bc.ajj().hRo != null)) {
      bc.ajj().hRo.eJ(paramBoolean);
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/MMAppMgr", "exitApplication", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/MMAppMgr", "exitApplication", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(33429);
      return;
    }
    catch (Throwable paramContext)
    {
      ae.printErrStackTrace("MicroMsg.MMAppMgr", paramContext, "[-] Fail to start launcherUI in suicide.", new Object[0]);
      AppMethodBeat.o(33429);
    }
  }
  
  public static void xu(boolean paramBoolean)
  {
    AppMethodBeat.i(33426);
    ae.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), bu.fpN(), Boolean.valueOf(paramBoolean) });
    com.tencent.mm.plugin.report.b.d.F(2, 0, "");
    if (paramBoolean) {
      fBa();
    }
    Object localObject1 = new z();
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    localObject1 = new lk();
    ((lk)localObject1).dzN.status = 0;
    ((lk)localObject1).dzN.reason = 2;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    fAZ();
    if (paramBoolean)
    {
      bc.xA(bu.fpN().toString());
      com.tencent.mm.kernel.g.ajS().releaseAll();
    }
    ae.appenderClose();
    Mars.onSingalCrash(0);
    com.tencent.mm.bv.a.f(ak.getContext(), new String[] { "com.tencent.mm:recovery", "com.tencent.mm:support", "com.tencent.mm:tools", "com.tencent.mm:toolsmp", "com.tencent.mm:appbrand0", "com.tencent.mm:appbrand1", "com.tencent.mm:appbrand2", "com.tencent.mm:appbrand3", "com.tencent.mm:appbrand4", "com.tencent.mm:lite" });
    try
    {
      ah.clearAllWebViewCache(ak.getContext(), true);
      ae.i("MicroMsg.MMAppMgr", "clearAllWebViewCache");
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/MMAppMgr", "killProcess", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/MMAppMgr", "killProcess", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      AppMethodBeat.o(33426);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.i("MicroMsg.MMAppMgr", "clear cookie failed : %s", new Object[] { localException });
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
    
    private static boolean br(Intent paramIntent)
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
      if ((bc.aBZ()) || (bc.aCb()))
      {
        AppMethodBeat.o(33420);
        return;
      }
      Object localObject = paramIntent.getAction();
      if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(localObject))
      {
        if (!br(paramIntent))
        {
          ae.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
          AppMethodBeat.o(33420);
          return;
        }
        MMAppMgr.a(this.appMgr, paramIntent, true);
        AppMethodBeat.o(33420);
        return;
      }
      if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(localObject))
      {
        if (!br(paramIntent))
        {
          ae.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
          AppMethodBeat.o(33420);
          return;
        }
        o.report();
        MMAppMgr.a(this.appMgr, paramIntent, false);
        if ((MMAppMgr.JwR != null) && (MMAppMgr.JwR.length() > 800)) {
          new aq(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33417);
              MMAppMgr.fAZ();
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
        if (bu.isNullOrNil(paramContext)) {
          ae.i("MicroMsg.MMAppMgr", "dealWithClickTestCaseStream case id is null, broadcast should set this intent flag");
        }
        for (;;)
        {
          if ((MMAppMgr.JwR != null) && (MMAppMgr.JwR.length() > 800)) {
            new aq(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33418);
                MMAppMgr.fAZ();
                AppMethodBeat.o(33418);
              }
            });
          }
          AppMethodBeat.o(33420);
          return;
          if (MMAppMgr.JwR == null) {
            MMAppMgr.JwR = new StringBuffer(800);
          }
          MMAppMgr.JwR.append(paramContext);
          ae.i("MicroMsg.MMAppMgr", "cpan content: %s", new Object[] { paramContext });
        }
      }
      if (paramIntent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE"))
      {
        int i;
        if (!paramIntent.getBooleanExtra("intent_extra_is_silence_stat", false))
        {
          i = paramIntent.getIntExtra("intent_extra_opcode", 0);
          ae.d("MicroMsg.MMAppMgr", "incremental_update = ".concat(String.valueOf(i)));
          if (bc.ajM()) {
            com.tencent.mm.plugin.report.service.g.yxI.f(10328, new Object[] { Integer.valueOf(i) });
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
          if ((!bc.ajM()) || ((l1 == 0L) && (l2 == 0L))) {
            break label653;
          }
          ae.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
          if (!bool) {
            break;
          }
          n.b((int)l2, (int)l1, 0);
          AppMethodBeat.o(33420);
          return;
          i = paramIntent.getIntExtra("intent_extra_opcode", 0);
          ae.d("MicroMsg.MMAppMgr", "silence_update_stat = ".concat(String.valueOf(i)));
          if (bc.ajM())
          {
            if (i == 2)
            {
              int j = paramIntent.getIntExtra("intent_extra_install_dialog_times", 0);
              com.tencent.mm.plugin.report.service.g.yxI.f(11147, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            for (;;)
            {
              if ((i != 4) || (j.fek() != 4)) {
                break label639;
              }
              paramContext = com.tencent.mm.pluginsdk.model.app.b.fdA();
              if (paramContext == null) {
                break;
              }
              paramContext.fdC();
              break;
              com.tencent.mm.plugin.report.service.g.yxI.f(11147, new Object[] { Integer.valueOf(i) });
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
          com.tencent.mm.pluginsdk.ui.tools.a.bd(paramIntent);
          AppMethodBeat.o(33420);
          return;
        }
        if ("SEND_TO_FRIENDS".equals(paramContext))
        {
          ae.i("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS");
          if (!com.tencent.mm.kernel.g.ajM())
          {
            ae.e("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS, account not ready");
            AppMethodBeat.o(33420);
            return;
          }
          String str2 = com.tencent.mm.cp.a.baw(paramIntent.getStringExtra("file_path"));
          localObject = paramIntent.getStringExtra("file_name");
          String str1 = paramIntent.getStringExtra("to_user");
          paramContext = paramIntent.getStringExtra("send_text");
          if ((bu.isNullOrNil(str2)) || (bu.isNullOrNil((String)localObject)) || (bu.isNullOrNil(str1)))
          {
            ae.e("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS, param empty");
            AppMethodBeat.o(33420);
            return;
          }
          WXFileObject localWXFileObject = new WXFileObject();
          localWXFileObject.setFilePath(str2);
          paramIntent = new WXMediaMessage();
          paramIntent.mediaObject = localWXFileObject;
          paramIntent.title = ((String)localObject);
          paramIntent.description = ((String)localObject);
          localObject = bu.U(str1.split(",")).iterator();
          while (((Iterator)localObject).hasNext())
          {
            str1 = (String)((Iterator)localObject).next();
            m.a(paramIntent, "", "", str1, 3, null);
            if (!bu.isNullOrNil(paramContext)) {
              com.tencent.mm.plugin.messenger.a.g.doC().aa(str1, paramContext, x.Bb(str1));
            }
          }
        }
        AppMethodBeat.o(33420);
        return;
      }
      ae.e("MicroMsg.MMAppMgr", "unknown broadcast action");
      AppMethodBeat.o(33420);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr
 * JD-Core Version:    0.7.0.1
 */