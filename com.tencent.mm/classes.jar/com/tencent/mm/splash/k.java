package com.tencent.mm.splash;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.b.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

final class k
  implements Handler.Callback
{
  public static int LAUNCH_ACTIVITY;
  public static int acBg;
  public static int acBh;
  public static int acBi;
  public static int acBj;
  public static int acBk;
  public static int acBl;
  public static int acBm;
  public static int acBn;
  public static int acBo;
  private static final Set<String> acBp;
  private static boolean acBq;
  private static Runnable acBr;
  private static boolean acBt;
  Handler.Callback Mvi;
  private boolean acBs = false;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(233919);
    LAUNCH_ACTIVITY = 100;
    acBg = 113;
    acBh = 114;
    acBi = 115;
    acBj = 116;
    acBk = 121;
    acBl = 122;
    acBm = 126;
    acBn = 134;
    acBo = 145;
    acBp = new HashSet(Arrays.asList(new String[] { "com.tencent.mm.plugin.wear.model.service.WearDataLayerService", "com.tencent.mm.plugin.account.model.AccountAuthenticatorService", "com.tencent.mm.plugin.account.model.ContactsSyncService", "com.tencent.mm.plugin.hld.WxHldService", "com.tencent.mm.plugin.fcm.WCFirebaseMessagingService", "com.tencent.mm.plugin.fcm.FCMInstanceIDListenerService", "com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService", "com.tencent.smtt.sandbox.SandboxedProcessService0", "com.tencent.smtt.sandbox.SandboxedProcessService1", "com.google.firebase.iid.FirebaseInstanceIdService", "com.google.firebase.messaging.FirebaseMessagingService", "com.google.android.gms.auth.api.signin.RevocationBoundService" }));
    acBq = false;
    acBt = false;
    AppMethodBeat.o(233919);
  }
  
  public k(Context paramContext, Handler.Callback paramCallback)
  {
    this.mContext = paramContext;
    this.Mvi = paramCallback;
  }
  
  public static void aV(Runnable paramRunnable)
  {
    acBq = true;
    acBr = paramRunnable;
  }
  
  public static boolean iVZ()
  {
    return acBt;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(40678);
    if (this.acBs)
    {
      i.g("WxSplash.SplashHackHandlerCallback", "found a infinite call loop", new Object[0]);
      AppMethodBeat.o(40678);
      return false;
    }
    acBt = false;
    i.g("WxSplash.SplashHackHandlerCallback", "before handleMessage %s, splash %s, pending early %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(i.iVM()), Boolean.valueOf(i.iVN()) });
    if ((acBq) && (paramMessage.what == 987654321))
    {
      if (acBr != null)
      {
        i.g("WxSplash.SplashHackHandlerCallback", "verify hack received.", new Object[0]);
        acBr.run();
      }
      AppMethodBeat.o(40678);
      return true;
    }
    if ((i.iVM()) && (!i.iVN()))
    {
      i.g("WxSplash.SplashHackHandlerCallback", "handleMessage %s, splash %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(i.iVM()) });
      if (((paramMessage.what == acBg) || (paramMessage.what == acBh) || (paramMessage.what == acBi) || (paramMessage.what == acBj) || (paramMessage.what == acBk) || (paramMessage.what == acBl) || (paramMessage.what == acBo)) && (q.shouldBlock(this.mContext) == null)) {}
    }
    try
    {
      Thread.sleep(8000L);
      label248:
      Object localObject1 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/splash/SplashHackHandlerCallback", "handleMessage", "(Landroid/os/Message;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/splash/SplashHackHandlerCallback", "handleMessage", "(Landroid/os/Message;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      localObject1 = Message.obtain();
      ((Message)localObject1).copyFrom(paramMessage);
      i.acAE.add(localObject1);
      if (i.acAI != null) {
        i.acAI.aDs();
      }
      AppMethodBeat.o(40678);
      return true;
      if ((paramMessage.what == acBm) || ((Build.VERSION.SDK_INT == 28) && (paramMessage.what == 160)))
      {
        if (i.acAJ.size() > 0) {
          acBt = true;
        }
        i.g("WxSplash.SplashHackHandlerCallback", "received a RELAUNCH_ACTIVITY message, with %s splash activity", new Object[] { Integer.valueOf(i.acAJ.size()) });
        localObject1 = paramMessage.obj;
        if (!d.rd(25)) {}
      }
      try
      {
        if (m.acBA == null)
        {
          localObject2 = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("mPreserveWindow");
          ((Field)localObject2).setAccessible(true);
          m.acBA = (Field)localObject2;
        }
        i.g("WxSplash.SplashHackHandlerCallback", "preserveWindow is %s, will set false", new Object[] { Boolean.valueOf(((Boolean)m.acBA.get(localObject1)).booleanValue()) });
        m.acBA.set(localObject1, Boolean.FALSE);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          i.a(localException, "");
        }
        if (this.Mvi == null) {
          break label752;
        }
        this.acBs = true;
        boolean bool = this.Mvi.handleMessage(paramMessage);
        this.acBs = false;
        AppMethodBeat.o(40678);
        return bool;
        AppMethodBeat.o(40678);
        return false;
      }
      if ((paramMessage.what == acBn) && ((paramMessage.obj instanceof String)))
      {
        localObject1 = (String)paramMessage.obj;
        i.g("WxSplash.SplashHackHandlerCallback", "DOS_PROOF: remote crash msg: %s", new Object[] { localObject1 });
        if (((String)localObject1).contains("did not then call Service.startForeground()"))
        {
          i = ((String)localObject1).indexOf("ServiceRecord{");
          if (i >= 0)
          {
            localObject1 = ((String)localObject1).substring(i).split(" +");
            if (localObject1.length >= 3)
            {
              localObject2 = localObject1[2];
              localObject1 = localObject2;
              if (((String)localObject2).endsWith("}")) {
                localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
              }
              localObject1 = ComponentName.unflattenFromString(((String)localObject1).trim());
              if (acBp.contains(((ComponentName)localObject1).getClassName()))
              {
                i.g("WxSplash.SplashHackHandlerCallback", "DOS_PROOF: DOS related to '%s' was avoided.", new Object[] { ((ComponentName)localObject1).getClassName() });
                AppMethodBeat.o(40678);
                return true;
              }
            }
          }
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      label752:
      break label248;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.splash.k
 * JD-Core Version:    0.7.0.1
 */