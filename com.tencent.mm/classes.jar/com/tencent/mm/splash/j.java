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
  public static int IkZ = 113;
  public static int Ila = 114;
  public static int Ilb = 115;
  public static int Ilc = 116;
  public static int Ild = 121;
  public static int Ile = 122;
  public static int Ilf = 126;
  public static int Ilg = 145;
  private static boolean Ilh = false;
  private static Runnable Ili;
  private static boolean Ilk = false;
  public static int LAUNCH_ACTIVITY = 100;
  private boolean Ilj = false;
  private Context mContext;
  Handler.Callback wuG;
  
  public j(Context paramContext, Handler.Callback paramCallback)
  {
    this.mContext = paramContext;
    this.wuG = paramCallback;
  }
  
  public static void aE(Runnable paramRunnable)
  {
    Ilh = true;
    Ili = paramRunnable;
  }
  
  public static boolean fnD()
  {
    return Ilk;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(40678);
    if (this.Ilj)
    {
      h.b("WxSplash.SplashHackHandlerCallback", "found a infinite call loop", new Object[0]);
      AppMethodBeat.o(40678);
      return false;
    }
    Ilk = false;
    h.b("WxSplash.SplashHackHandlerCallback", "before handleMessage %s, splash %s, pending early %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(h.fnq()), Boolean.valueOf(h.fnr()) });
    if ((Ilh) && (paramMessage.what == 987654321))
    {
      if (Ili != null)
      {
        h.b("WxSplash.SplashHackHandlerCallback", "verify hack received.", new Object[0]);
        Ili.run();
      }
      AppMethodBeat.o(40678);
      return true;
    }
    Object localObject;
    if ((h.fnq()) && (!h.fnr()))
    {
      h.b("WxSplash.SplashHackHandlerCallback", "handleMessage %s, splash %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(h.fnq()) });
      if ((paramMessage.what == IkZ) || (paramMessage.what == Ila) || (paramMessage.what == Ilb) || (paramMessage.what == Ilc) || (paramMessage.what == Ild) || (paramMessage.what == Ile) || (paramMessage.what == Ilg))
      {
        localObject = Message.obtain();
        ((Message)localObject).copyFrom(paramMessage);
        h.Iky.add(localObject);
        if (h.IkC != null) {
          h.IkC.MM();
        }
        AppMethodBeat.o(40678);
        return true;
      }
    }
    if ((paramMessage.what == Ilf) || ((Build.VERSION.SDK_INT == 28) && (paramMessage.what == 160)))
    {
      if (h.IkD.size() > 0) {
        Ilk = true;
      }
      h.b("WxSplash.SplashHackHandlerCallback", "received a RELAUNCH_ACTIVITY message, with %s splash activity", new Object[] { Integer.valueOf(h.IkD.size()) });
      localObject = paramMessage.obj;
      if (!d.lA(25)) {}
    }
    try
    {
      if (l.Ilt == null)
      {
        Field localField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("mPreserveWindow");
        localField.setAccessible(true);
        l.Ilt = localField;
      }
      h.b("WxSplash.SplashHackHandlerCallback", "preserveWindow is %s, will set false", new Object[] { Boolean.valueOf(((Boolean)l.Ilt.get(localObject)).booleanValue()) });
      l.Ilt.set(localObject, Boolean.FALSE);
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
    if (this.wuG != null)
    {
      this.Ilj = true;
      bool = this.wuG.handleMessage(paramMessage);
      this.Ilj = false;
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