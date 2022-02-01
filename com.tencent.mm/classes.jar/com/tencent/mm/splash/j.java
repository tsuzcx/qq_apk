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
  public static int Gzf = 113;
  public static int Gzg = 114;
  public static int Gzh = 115;
  public static int Gzi = 116;
  public static int Gzj = 121;
  public static int Gzk = 122;
  public static int Gzl = 126;
  public static int Gzm = 145;
  private static boolean Gzn = false;
  private static Runnable Gzo;
  private static boolean Gzq = false;
  public static int LAUNCH_ACTIVITY = 100;
  private boolean Gzp = false;
  private Context mContext;
  Handler.Callback vpo;
  
  public j(Context paramContext, Handler.Callback paramCallback)
  {
    this.mContext = paramContext;
    this.vpo = paramCallback;
  }
  
  public static void aF(Runnable paramRunnable)
  {
    Gzn = true;
    Gzo = paramRunnable;
  }
  
  public static boolean eXT()
  {
    return Gzq;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(40678);
    if (this.Gzp)
    {
      h.b("WxSplash.SplashHackHandlerCallback", "found a infinite call loop", new Object[0]);
      AppMethodBeat.o(40678);
      return false;
    }
    Gzq = false;
    h.b("WxSplash.SplashHackHandlerCallback", "before handleMessage %s, splash %s, pending early %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(h.eXG()), Boolean.valueOf(h.eXH()) });
    if ((Gzn) && (paramMessage.what == 987654321))
    {
      if (Gzo != null)
      {
        h.b("WxSplash.SplashHackHandlerCallback", "verify hack received.", new Object[0]);
        Gzo.run();
      }
      AppMethodBeat.o(40678);
      return true;
    }
    Object localObject;
    if ((h.eXG()) && (!h.eXH()))
    {
      h.b("WxSplash.SplashHackHandlerCallback", "handleMessage %s, splash %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(h.eXG()) });
      if ((paramMessage.what == Gzf) || (paramMessage.what == Gzg) || (paramMessage.what == Gzh) || (paramMessage.what == Gzi) || (paramMessage.what == Gzj) || (paramMessage.what == Gzk) || (paramMessage.what == Gzm))
      {
        localObject = Message.obtain();
        ((Message)localObject).copyFrom(paramMessage);
        h.GyE.add(localObject);
        if (h.GyI != null) {
          h.GyI.Le();
        }
        AppMethodBeat.o(40678);
        return true;
      }
    }
    if ((paramMessage.what == Gzl) || ((Build.VERSION.SDK_INT == 28) && (paramMessage.what == 160)))
    {
      if (h.GyJ.size() > 0) {
        Gzq = true;
      }
      h.b("WxSplash.SplashHackHandlerCallback", "received a RELAUNCH_ACTIVITY message, with %s splash activity", new Object[] { Integer.valueOf(h.GyJ.size()) });
      localObject = paramMessage.obj;
      if (!d.lb(25)) {}
    }
    try
    {
      if (l.Gzz == null)
      {
        Field localField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("mPreserveWindow");
        localField.setAccessible(true);
        l.Gzz = localField;
      }
      h.b("WxSplash.SplashHackHandlerCallback", "preserveWindow is %s, will set false", new Object[] { Boolean.valueOf(((Boolean)l.Gzz.get(localObject)).booleanValue()) });
      l.Gzz.set(localObject, Boolean.FALSE);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        h.a(localException, "");
      }
      AppMethodBeat.o(40678);
    }
    if (this.vpo != null)
    {
      this.Gzp = true;
      bool = this.vpo.handleMessage(paramMessage);
      this.Gzp = false;
      AppMethodBeat.o(40678);
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.j
 * JD-Core Version:    0.7.0.1
 */