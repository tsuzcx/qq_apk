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

final class k
  implements Handler.Callback
{
  public static int LAUNCH_ACTIVITY = 100;
  public static int UZN = 113;
  public static int UZO = 114;
  public static int UZP = 115;
  public static int UZQ = 116;
  public static int UZR = 121;
  public static int UZS = 122;
  public static int UZT = 126;
  public static int UZU = 145;
  private static boolean UZV = false;
  private static Runnable UZW;
  private static boolean UZY = false;
  Handler.Callback Gza;
  private boolean UZX = false;
  private Context mContext;
  
  public k(Context paramContext, Handler.Callback paramCallback)
  {
    this.mContext = paramContext;
    this.Gza = paramCallback;
  }
  
  public static void aN(Runnable paramRunnable)
  {
    UZV = true;
    UZW = paramRunnable;
  }
  
  public static boolean huw()
  {
    return UZY;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(40678);
    if (this.UZX)
    {
      i.g("WxSplash.SplashHackHandlerCallback", "found a infinite call loop", new Object[0]);
      AppMethodBeat.o(40678);
      return false;
    }
    UZY = false;
    i.g("WxSplash.SplashHackHandlerCallback", "before handleMessage %s, splash %s, pending early %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(i.huj()), Boolean.valueOf(i.huk()) });
    if ((UZV) && (paramMessage.what == 987654321))
    {
      if (UZW != null)
      {
        i.g("WxSplash.SplashHackHandlerCallback", "verify hack received.", new Object[0]);
        UZW.run();
      }
      AppMethodBeat.o(40678);
      return true;
    }
    Object localObject;
    if ((i.huj()) && (!i.huk()))
    {
      i.g("WxSplash.SplashHackHandlerCallback", "handleMessage %s, splash %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(i.huj()) });
      if ((paramMessage.what == UZN) || (paramMessage.what == UZO) || (paramMessage.what == UZP) || (paramMessage.what == UZQ) || (paramMessage.what == UZR) || (paramMessage.what == UZS) || (paramMessage.what == UZU))
      {
        localObject = Message.obtain();
        ((Message)localObject).copyFrom(paramMessage);
        i.UZm.add(localObject);
        if (i.UZq != null) {
          i.UZq.abx();
        }
        AppMethodBeat.o(40678);
        return true;
      }
    }
    if ((paramMessage.what == UZT) || ((Build.VERSION.SDK_INT == 28) && (paramMessage.what == 160)))
    {
      if (i.UZr.size() > 0) {
        UZY = true;
      }
      i.g("WxSplash.SplashHackHandlerCallback", "received a RELAUNCH_ACTIVITY message, with %s splash activity", new Object[] { Integer.valueOf(i.UZr.size()) });
      localObject = paramMessage.obj;
      if (!d.qX(25)) {}
    }
    try
    {
      if (m.Vag == null)
      {
        Field localField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("mPreserveWindow");
        localField.setAccessible(true);
        m.Vag = localField;
      }
      i.g("WxSplash.SplashHackHandlerCallback", "preserveWindow is %s, will set false", new Object[] { Boolean.valueOf(((Boolean)m.Vag.get(localObject)).booleanValue()) });
      m.Vag.set(localObject, Boolean.FALSE);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        i.a(localException, "");
      }
      AppMethodBeat.o(40678);
    }
    if (this.Gza != null)
    {
      this.UZX = true;
      bool = this.Gza.handleMessage(paramMessage);
      this.UZX = false;
      AppMethodBeat.o(40678);
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.splash.k
 * JD-Core Version:    0.7.0.1
 */