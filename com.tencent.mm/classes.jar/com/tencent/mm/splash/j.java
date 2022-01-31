package com.tencent.mm.splash;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Set;

final class j
  implements Handler.Callback
{
  public static int yvM = 100;
  public static int yvN = 113;
  public static int yvO = 114;
  public static int yvP = 115;
  public static int yvQ = 116;
  public static int yvR = 121;
  public static int yvS = 122;
  public static int yvT = 126;
  public static int yvU = 145;
  private static boolean yvV = false;
  private static Runnable yvW;
  private static boolean yvY = false;
  private Context mContext;
  Handler.Callback phM;
  private boolean yvX = false;
  
  public j(Context paramContext, Handler.Callback paramCallback)
  {
    this.mContext = paramContext;
    this.phM = paramCallback;
  }
  
  public static void au(Runnable paramRunnable)
  {
    yvV = true;
    yvW = paramRunnable;
  }
  
  public static boolean dvI()
  {
    return yvY;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(114884);
    if (this.yvX)
    {
      h.c("WxSplash.SplashHackHandlerCallback", "found a infinite call loop", new Object[0]);
      AppMethodBeat.o(114884);
      return true;
    }
    yvY = false;
    h.c("WxSplash.SplashHackHandlerCallback", "before handleMessage %s, splash %s, pending early %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(h.dvu()), Boolean.valueOf(h.dvv()) });
    if ((yvV) && (paramMessage.what == 987654321))
    {
      if (yvW != null)
      {
        h.c("WxSplash.SplashHackHandlerCallback", "verify hack received.", new Object[0]);
        yvW.run();
      }
      AppMethodBeat.o(114884);
      return true;
    }
    Object localObject;
    if ((h.dvu()) && (!h.dvv()))
    {
      h.c("WxSplash.SplashHackHandlerCallback", "handleMessage %s, splash %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(h.dvu()) });
      if ((paramMessage.what == yvN) || (paramMessage.what == yvO) || (paramMessage.what == yvP) || (paramMessage.what == yvQ) || (paramMessage.what == yvR) || (paramMessage.what == yvS) || (paramMessage.what == yvU))
      {
        localObject = Message.obtain();
        ((Message)localObject).copyFrom(paramMessage);
        h.yvk.add(localObject);
        if (h.yvp != null) {
          h.yvp.BK();
        }
        AppMethodBeat.o(114884);
        return true;
      }
    }
    if ((paramMessage.what == yvT) || ((Build.VERSION.SDK_INT == 28) && (paramMessage.what == 160)))
    {
      if (h.yvq.size() > 0) {
        yvY = true;
      }
      h.c("WxSplash.SplashHackHandlerCallback", "received a RELAUNCH_ACTIVITY message, with %s splash activity", new Object[] { Integer.valueOf(h.yvq.size()) });
      localObject = paramMessage.obj;
      if (!d.iU(25)) {}
    }
    try
    {
      if (l.ywh == null)
      {
        Field localField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("mPreserveWindow");
        localField.setAccessible(true);
        l.ywh = localField;
      }
      h.c("WxSplash.SplashHackHandlerCallback", "preserveWindow is %s, will set false", new Object[] { Boolean.valueOf(((Boolean)l.ywh.get(localObject)).booleanValue()) });
      l.ywh.set(localObject, Boolean.FALSE);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        h.a(localException, "");
      }
      AppMethodBeat.o(114884);
    }
    if (this.phM != null)
    {
      this.yvX = true;
      bool = this.phM.handleMessage(paramMessage);
      this.yvX = false;
      AppMethodBeat.o(114884);
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.j
 * JD-Core Version:    0.7.0.1
 */