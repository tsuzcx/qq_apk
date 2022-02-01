package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
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
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mars.Mars;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.app.i;
import com.tencent.mm.autogen.a.af;
import com.tencent.mm.autogen.a.ny;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.cache.CacheService;
import com.tencent.mm.booter.o;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.n;
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
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.Iterator;
import java.util.List;

public final class MMAppMgr
{
  static StringBuffer adFc;
  private static long adFd;
  public Receiver adFe;
  private long oTE;
  private String qdi;
  
  public static void Lj(boolean paramBoolean)
  {
    AppMethodBeat.i(33426);
    Log.w("MicroMsg.MMAppMgr", "killProcess thread:%s proc:%d stack:%s, killService:%b", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.myPid()), Util.getStack(), Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      jjZ();
    }
    new af().publish();
    Object localObject1 = new ny();
    ((ny)localObject1).hQx.status = 0;
    ((ny)localObject1).hQx.reason = 2;
    ((ny)localObject1).publish();
    jjY();
    if (paramBoolean)
    {
      bh.Fv(Util.getStack().toString());
      com.tencent.mm.kernel.h.baF().releaseAll();
    }
    Log.appenderClose();
    Mars.onSingalCrash(0);
    com.tencent.mm.bv.a.h(MMApplicationContext.getContext(), new String[] { MMApplicationContext.getApplicationId() + ":recovery", MMApplicationContext.getApplicationId() + ":support", MMApplicationContext.getApplicationId() + ":tools", MMApplicationContext.getApplicationId() + ":toolsmp", MMApplicationContext.getApplicationId() + ":appbrand0", MMApplicationContext.getApplicationId() + ":appbrand1", MMApplicationContext.getApplicationId() + ":appbrand2", MMApplicationContext.getApplicationId() + ":appbrand3", MMApplicationContext.getApplicationId() + ":appbrand4", MMApplicationContext.getApplicationId() + ":lite" });
    try
    {
      com.tencent.xweb.ao.OU(true);
      Log.i("MicroMsg.MMAppMgr", "clearAllWebViewCache");
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/ui/MMAppMgr", "killProcess", "(Z)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
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
  
  public static boolean a(final Activity paramActivity, final DialogInterface.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(33433);
    final SharedPreferences localSharedPreferences = paramActivity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
    boolean bool = localSharedPreferences.getBoolean("gprs_alert", true);
    ChannelUtil.isShowingGprsAlert &= bool;
    if (bool)
    {
      com.tencent.mm.app.ao.init(paramActivity.getBaseContext());
      View localView = View.inflate(paramActivity, R.i.gko, null);
      Object localObject3 = WeChatBrands.Wordings.translate(paramActivity.getString(R.l.privacy_detail));
      Object localObject2 = WeChatBrands.Wordings.translate(paramActivity.getString(R.l.gNn));
      String str = WeChatBrands.Wordings.translate(paramActivity.getString(R.l.fNA, new Object[] { localObject3, localObject2 }));
      Object localObject1 = Spannable.Factory.getInstance().newSpannable(str);
      ClickableSpan local12 = new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33414);
          Util.jump(MMAppMgr.this, WeChatBrands.Wordings.translate(MMApplicationContext.getResources().getString(R.l.license_read_url, new Object[] { LocaleUtil.getCurrentLanguage(MMAppMgr.this), LocaleUtil.getCurrentCountryCode(), "setting", Integer.valueOf(0), Integer.valueOf(0) })));
          AppMethodBeat.o(33414);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(33415);
          paramAnonymousTextPaint.setColor(MMAppMgr.this.getResources().getColor(R.e.link_color));
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
      localObject2 = (TextView)localView.findViewById(R.h.fNA);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
      localObject1 = (CheckBox)localView.findViewById(R.h.fJl);
      paramOnClickListener = k.a(paramActivity, false, null, localView, paramActivity.getString(R.l.confirm_dialog_ok), paramActivity.getString(R.l.main_exit), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(33416);
          if (MMAppMgr.this.isChecked())
          {
            SharedPreferences.Editor localEditor = localSharedPreferences.edit();
            localEditor.putBoolean("gprs_alert", false);
            localEditor.commit();
          }
          ChannelUtil.isShowingGprsAlert = false;
          paramAnonymousDialogInterface.dismiss();
          MMAppMgr.mS(paramActivity);
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
          }
          AppMethodBeat.o(33416);
        }
      }, new DialogInterface.OnClickListener()
      {
        /* Error */
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          // Byte code:
          //   0: ldc 24
          //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   5: aload_1
          //   6: invokeinterface 35 1 0
          //   11: aload_0
          //   12: getfield 17	com/tencent/mm/ui/MMAppMgr$2:hkm	Landroid/app/Activity;
          //   15: astore_1
          //   16: invokestatic 41	com/tencent/mm/kernel/h:baF	()Lcom/tencent/mm/kernel/h;
          //   19: iconst_1
          //   20: invokevirtual 45	com/tencent/mm/kernel/h:fB	(Z)V
          //   23: iconst_0
          //   24: invokestatic 50	com/tencent/mars/Mars:onSingalCrash	(I)V
          //   27: invokestatic 55	com/tencent/mm/sdk/platformtools/MMNativeJpeg:Destroy	()V
          //   30: invokestatic 60	com/tencent/mm/booter/o:aDD	()V
          //   33: invokestatic 66	com/tencent/mm/model/bh:aZW	()Lcom/tencent/mm/am/s;
          //   36: ifnull +24 -> 60
          //   39: invokestatic 66	com/tencent/mm/model/bh:aZW	()Lcom/tencent/mm/am/s;
          //   42: getfield 72	com/tencent/mm/am/s:oun	Lcom/tencent/mm/network/g;
          //   45: ifnull +15 -> 60
          //   48: invokestatic 66	com/tencent/mm/model/bh:aZW	()Lcom/tencent/mm/am/s;
          //   51: getfield 72	com/tencent/mm/am/s:oun	Lcom/tencent/mm/network/g;
          //   54: iconst_1
          //   55: invokeinterface 77 2 0
          //   60: new 79	android/content/Intent
          //   63: dup
          //   64: invokespecial 80	android/content/Intent:<init>	()V
          //   67: aload_1
          //   68: ldc 82
          //   70: invokevirtual 86	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
          //   73: astore_3
          //   74: aload_3
          //   75: ldc 87
          //   77: invokevirtual 91	android/content/Intent:addFlags	(I)Landroid/content/Intent;
          //   80: pop
          //   81: aload_3
          //   82: ldc 93
          //   84: invokestatic 99	android/os/Process:myPid	()I
          //   87: invokevirtual 103	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
          //   90: pop
          //   91: aload_3
          //   92: ldc 105
          //   94: iconst_1
          //   95: invokevirtual 108	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
          //   98: pop
          //   99: aload_1
          //   100: instanceof 110
          //   103: ifne +76 -> 179
          //   106: aload_3
          //   107: ldc 111
          //   109: invokevirtual 91	android/content/Intent:addFlags	(I)Landroid/content/Intent;
          //   112: pop
          //   113: new 113	com/tencent/mm/hellhoundlib/b/a
          //   116: dup
          //   117: invokespecial 114	com/tencent/mm/hellhoundlib/b/a:<init>	()V
          //   120: aload_3
          //   121: invokevirtual 118	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
          //   124: astore_3
          //   125: aload_1
          //   126: aload_3
          //   127: invokevirtual 122	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
          //   130: ldc 123
          //   132: ldc 125
          //   134: ldc 127
          //   136: ldc 129
          //   138: ldc 131
          //   140: ldc 133
          //   142: invokestatic 139	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   145: aload_1
          //   146: aload_3
          //   147: iconst_0
          //   148: invokevirtual 143	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
          //   151: checkcast 79	android/content/Intent
          //   154: invokevirtual 147	android/content/Context:startActivity	(Landroid/content/Intent;)V
          //   157: aload_1
          //   158: ldc 123
          //   160: ldc 125
          //   162: ldc 127
          //   164: ldc 129
          //   166: ldc 131
          //   168: ldc 133
          //   170: invokestatic 151	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
          //   173: ldc 24
          //   175: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   178: return
          //   179: aload_1
          //   180: checkcast 110	android/app/Activity
          //   183: invokevirtual 157	android/app/Activity:finish	()V
          //   186: goto -73 -> 113
          //   189: astore_1
          //   190: ldc 159
          //   192: aload_1
          //   193: ldc 161
          //   195: iconst_0
          //   196: anewarray 4	java/lang/Object
          //   199: invokestatic 167	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   202: ldc 24
          //   204: invokestatic 154	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   207: return
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	208	0	this	2
          //   0	208	1	paramAnonymousDialogInterface	DialogInterface
          //   0	208	2	paramAnonymousInt	int
          //   73	74	3	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   113	173	189	finally
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
          MMAppMgr.this.onKeyDown(4, new KeyEvent(0, 4));
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
    View localView = View.inflate(paramContext, R.i.gmx, null);
    Object localObject = (CheckBox)localView.findViewById(R.h.fPp);
    ((CheckBox)localObject).setText(paramContext.getString(R.l.gOx));
    ((CheckBox)localObject).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(33406);
        bh.bCz();
        paramAnonymousCompoundButton = com.tencent.mm.model.c.ban();
        if (!paramAnonymousBoolean) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          paramAnonymousCompoundButton.B(16385, Boolean.valueOf(paramAnonymousBoolean));
          AppMethodBeat.o(33406);
          return;
        }
      }
    });
    localView.findViewById(R.h.fPq).setVisibility(8);
    localObject = (TextView)localView.findViewById(R.h.network_tips_content);
    switch (paramInt)
    {
    case 2: 
    default: 
      ((TextView)localObject).setText(R.l.gOF);
      paramInt = 1;
    }
    while (paramInt != 0)
    {
      paramContext = new e.a(paramContext);
      paramContext.aEK(R.l.app_tip);
      paramContext.NC(false);
      paramContext.md(localView);
      paramContext.aER(R.l.gOC).c(paramOnClickListener1);
      paramContext.aES(R.l.gOx).d(paramOnClickListener2);
      paramContext.jHH().show();
      AppMethodBeat.o(33434);
      return true;
      ((TextView)localObject).setText(R.l.gOF);
      paramInt = 0;
      continue;
      ((TextView)localObject).setText(R.l.gOw);
      paramInt = 1;
    }
    AppMethodBeat.o(33434);
    return false;
  }
  
  public static void aDA()
  {
    AppMethodBeat.i(33424);
    bh.getNotification().aDA();
    AppMethodBeat.o(33424);
  }
  
  public static void ase()
  {
    AppMethodBeat.i(185859);
    Lj(true);
    AppMethodBeat.o(185859);
  }
  
  private static String bzN(String paramString)
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
  
  public static void cF(Context paramContext)
  {
    AppMethodBeat.i(33428);
    o(paramContext, true);
    AppMethodBeat.o(33428);
  }
  
  public static e cI(Context paramContext)
  {
    AppMethodBeat.i(33435);
    try
    {
      if (NetStatusUtil.isWifi(paramContext))
      {
        boolean bool = com.tencent.mm.modelgeo.d.bJm();
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
    bh.bCz();
    Object localObject = (Boolean)com.tencent.mm.model.c.ban().d(4105, Boolean.FALSE);
    if ((localObject != null) && (((Boolean)localObject).booleanValue()))
    {
      AppMethodBeat.o(33435);
      return null;
    }
    localObject = View.inflate(paramContext, R.i.glj, null);
    ((CheckBox)((View)localObject).findViewById(R.h.fMC)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(33407);
        if (paramAnonymousBoolean)
        {
          bh.bCz();
          com.tencent.mm.model.c.ban().B(4105, Boolean.TRUE);
          AppMethodBeat.o(33407);
          return;
        }
        bh.bCz();
        com.tencent.mm.model.c.ban().B(4105, Boolean.FALSE);
        AppMethodBeat.o(33407);
      }
    });
    MMAppMgr.6 local6 = new MMAppMgr.6(paramContext);
    paramContext = new e.a(paramContext);
    paramContext.aEK(R.l.gOt);
    paramContext.md((View)localObject);
    paramContext.aER(R.l.app_set).c(local6);
    paramContext.aES(R.l.app_ignore_it);
    paramContext = paramContext.jHH();
    paramContext.show();
    AppMethodBeat.o(33435);
    return paramContext;
  }
  
  public static void iH(String paramString)
  {
    AppMethodBeat.i(33423);
    bh.getNotification().iH(paramString);
    AppMethodBeat.o(33423);
  }
  
  public static void jjY()
  {
    AppMethodBeat.i(33421);
    StringBuffer localStringBuffer = new StringBuffer(800);
    if (adFc == null)
    {
      adFc = localStringBuffer;
      adFd = Util.nowSecond();
      AppMethodBeat.o(33421);
      return;
    }
    String str = adFc.toString();
    localStringBuffer.append(bzN(str));
    adFc = localStringBuffer;
    Log.i("MicroMsg.MMAppMgr", "oreh report clickstream %s", new Object[] { str });
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(10508, "1," + adFd + "," + str);
    adFd = Util.nowSecond();
    AppMethodBeat.o(33421);
  }
  
  public static void jjZ()
  {
    AppMethodBeat.i(33427);
    Context localContext = MMApplicationContext.getContext();
    if (localContext != null)
    {
      if (!com.tencent.mm.booter.c.aKu()) {
        break label80;
      }
      i.aCm();
    }
    for (;;)
    {
      com.tencent.mm.br.c.bV(new Intent(localContext, NotifyReceiver.NotifyService.class));
      localContext.stopService(new Intent(localContext, CacheService.class));
      com.tencent.mm.br.c.p(new Intent().setClassName(localContext, "com.tencent.mm.plugin.exdevice.service.ExDeviceService"), "exdevice");
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
  
  public static boolean mR(Context paramContext)
  {
    AppMethodBeat.i(33430);
    if (!bh.baz())
    {
      AppMethodBeat.o(33430);
      return false;
    }
    bh.bCz();
    if (Util.nullAsFalse((Boolean)com.tencent.mm.model.c.ban().d(61, null)))
    {
      AppMethodBeat.o(33430);
      return false;
    }
    if (!MMEntryLock.lock("show_wap_adviser"))
    {
      AppMethodBeat.o(33430);
      return false;
    }
    View localView = View.inflate(paramContext, R.i.gmx, null);
    ((TextView)localView.findViewById(R.h.network_tips_content)).setText(R.l.gOE);
    Object localObject = (CheckBox)localView.findViewById(R.h.fPp);
    ((CheckBox)localObject).setText(paramContext.getString(R.l.gRV));
    ((CheckBox)localObject).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(33411);
        bh.bCz();
        com.tencent.mm.model.c.ban().B(61, Boolean.valueOf(paramAnonymousBoolean));
        AppMethodBeat.o(33411);
      }
    });
    ((CheckBox)localObject).setVisibility(0);
    localObject = new e.a(paramContext);
    ((e.a)localObject).aEK(R.l.app_tip);
    ((e.a)localObject).md(localView);
    ((e.a)localObject).aER(R.l.gRX).c(new MMAppMgr.10(paramContext));
    ((e.a)localObject).NC(false);
    ((e.a)localObject).aES(R.l.gRW);
    ((e.a)localObject).c(new MMAppMgr.11());
    ((e.a)localObject).jHH().show();
    AppMethodBeat.o(33430);
    return true;
  }
  
  public static void mS(Context paramContext)
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
      com.tencent.mm.plugin.base.model.b.F(paramContext, localIntent1);
      paramContext = localSharedPreferences.edit();
      paramContext.putBoolean("Main_ShortCut", true);
      paramContext.commit();
    }
    AppMethodBeat.o(33432);
  }
  
  public static void o(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(33429);
    com.tencent.mm.kernel.h.baF().fB(paramBoolean);
    Mars.onSingalCrash(0);
    MMNativeJpeg.Destroy();
    o.aDD();
    if ((bh.aZW() != null) && (bh.aZW().oun != null)) {
      bh.aZW().oun.hc(paramBoolean);
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/MMAppMgr", "exitApplication", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/MMAppMgr", "exitApplication", "(Landroid/content/Context;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(33429);
      return;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.MMAppMgr", paramContext, "[-] Fail to start launcherUI in suicide.", new Object[0]);
      AppMethodBeat.o(33429);
    }
  }
  
  public static class Receiver
    extends BroadcastReceiver
  {
    private MMAppMgr vte;
    
    public Receiver(MMAppMgr paramMMAppMgr)
    {
      this.vte = paramMMAppMgr;
    }
    
    private static boolean cf(Intent paramIntent)
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
      if ((bh.bCs()) || (bh.bCu()))
      {
        AppMethodBeat.o(33420);
        return;
      }
      Object localObject = paramIntent.getAction();
      if ("com.tencent.mm.ui.ACTION_ACTIVE".equals(localObject))
      {
        if (!cf(paramIntent))
        {
          Log.w("MicroMsg.MMAppMgr", "onreceive active process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
          AppMethodBeat.o(33420);
          return;
        }
        MMAppMgr.a(this.vte, paramIntent, true);
        AppMethodBeat.o(33420);
        return;
      }
      if ("com.tencent.mm.ui.ACTION_DEACTIVE".equals(localObject))
      {
        if (!cf(paramIntent))
        {
          Log.w("MicroMsg.MMAppMgr", "onreceive deactive process changed old: %d, new: %d", new Object[] { Integer.valueOf(paramIntent.getIntExtra("process_id", 0)), Integer.valueOf(Process.myPid()) });
          AppMethodBeat.o(33420);
          return;
        }
        o.report();
        MMAppMgr.a(this.vte, paramIntent, false);
        if ((MMAppMgr.adFc != null) && (MMAppMgr.adFc.length() > 800)) {
          new MMHandler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33417);
              MMAppMgr.jjY();
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
          if ((MMAppMgr.adFc != null) && (MMAppMgr.adFc.length() > 800)) {
            new MMHandler(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(33418);
                MMAppMgr.jjY();
                AppMethodBeat.o(33418);
              }
            });
          }
          AppMethodBeat.o(33420);
          return;
          if (MMAppMgr.adFc == null) {
            MMAppMgr.adFc = new StringBuffer(800);
          }
          MMAppMgr.adFc.append(paramContext);
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
          if (bh.baz()) {
            com.tencent.mm.plugin.report.service.h.OAn.b(10328, new Object[] { Integer.valueOf(i) });
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
          if ((!bh.baz()) || ((l1 == 0L) && (l2 == 0L))) {
            break label653;
          }
          Log.d("MicroMsg.MMAppMgr", "silence_update_flow_stat upstream %s downstream %s isWifi %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bool) });
          if (!bool) {
            break;
          }
          m.e((int)l2, (int)l1, 0);
          AppMethodBeat.o(33420);
          return;
          i = paramIntent.getIntExtra("intent_extra_opcode", 0);
          Log.d("MicroMsg.MMAppMgr", "silence_update_stat = ".concat(String.valueOf(i)));
          if (bh.baz())
          {
            if (i == 2)
            {
              int j = paramIntent.getIntExtra("intent_extra_install_dialog_times", 0);
              com.tencent.mm.plugin.report.service.h.OAn.b(11147, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            }
            for (;;)
            {
              if ((i != 4) || (com.tencent.mm.pluginsdk.platformtools.g.iJa() != 4)) {
                break label639;
              }
              paramContext = com.tencent.mm.pluginsdk.model.app.b.iIn();
              if (paramContext == null) {
                break;
              }
              paramContext.iIp();
              break;
              com.tencent.mm.plugin.report.service.h.OAn.b(11147, new Object[] { Integer.valueOf(i) });
            }
          }
        }
        m.f((int)l2, (int)l1, 0);
        label653:
        AppMethodBeat.o(33420);
        return;
      }
      if (paramIntent.getAction().equals("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP"))
      {
        MMAppMgr.o(paramContext, true);
        AppMethodBeat.o(33420);
        return;
      }
      if (paramIntent.getAction().equals("MINIQB_OPEN_RET"))
      {
        paramContext = paramIntent.getStringExtra("op_type");
        if ("NOTIFY_RET".equals(paramContext))
        {
          com.tencent.mm.pluginsdk.ui.tools.a.bT(paramIntent);
          AppMethodBeat.o(33420);
          return;
        }
        if ("SEND_TO_FRIENDS".equals(paramContext))
        {
          Log.i("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS");
          if (!com.tencent.mm.kernel.h.baz())
          {
            Log.e("MicroMsg.MMAppMgr", "onReceive SEND_TO_FRIENDS, account not ready");
            AppMethodBeat.o(33420);
            return;
          }
          String str2 = paramIntent.getStringExtra("file_path");
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
            n.a(paramIntent, "", "", str1, 3, null);
            if (!Util.isNullOrNil(paramContext)) {
              com.tencent.mm.plugin.messenger.a.g.gaI().ap(str1, paramContext, ab.IX(str1));
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