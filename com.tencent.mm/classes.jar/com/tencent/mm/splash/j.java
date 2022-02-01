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
  public static int FbN = 113;
  public static int FbO = 114;
  public static int FbP = 115;
  public static int FbQ = 116;
  public static int FbR = 121;
  public static int FbS = 122;
  public static int FbT = 126;
  public static int FbU = 145;
  private static boolean FbV = false;
  private static Runnable FbW;
  private static boolean FbY = false;
  public static int LAUNCH_ACTIVITY = 100;
  private boolean FbX = false;
  private Context mContext;
  Handler.Callback ugp;
  
  public j(Context paramContext, Handler.Callback paramCallback)
  {
    this.mContext = paramContext;
    this.ugp = paramCallback;
  }
  
  public static void aD(Runnable paramRunnable)
  {
    FbV = true;
    FbW = paramRunnable;
  }
  
  public static boolean eIx()
  {
    return FbY;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(40678);
    if (this.FbX)
    {
      h.b("WxSplash.SplashHackHandlerCallback", "found a infinite call loop", new Object[0]);
      AppMethodBeat.o(40678);
      return true;
    }
    FbY = false;
    h.b("WxSplash.SplashHackHandlerCallback", "before handleMessage %s, splash %s, pending early %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(h.eIk()), Boolean.valueOf(h.eIl()) });
    if ((FbV) && (paramMessage.what == 987654321))
    {
      if (FbW != null)
      {
        h.b("WxSplash.SplashHackHandlerCallback", "verify hack received.", new Object[0]);
        FbW.run();
      }
      AppMethodBeat.o(40678);
      return true;
    }
    Object localObject;
    if ((h.eIk()) && (!h.eIl()))
    {
      h.b("WxSplash.SplashHackHandlerCallback", "handleMessage %s, splash %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(h.eIk()) });
      if ((paramMessage.what == FbN) || (paramMessage.what == FbO) || (paramMessage.what == FbP) || (paramMessage.what == FbQ) || (paramMessage.what == FbR) || (paramMessage.what == FbS) || (paramMessage.what == FbU))
      {
        localObject = Message.obtain();
        ((Message)localObject).copyFrom(paramMessage);
        h.Fbn.add(localObject);
        if (h.Fbr != null) {
          h.Fbr.Lg();
        }
        AppMethodBeat.o(40678);
        return true;
      }
    }
    if ((paramMessage.what == FbT) || ((Build.VERSION.SDK_INT == 28) && (paramMessage.what == 160)))
    {
      if (h.Fbs.size() > 0) {
        FbY = true;
      }
      h.b("WxSplash.SplashHackHandlerCallback", "received a RELAUNCH_ACTIVITY message, with %s splash activity", new Object[] { Integer.valueOf(h.Fbs.size()) });
      localObject = paramMessage.obj;
      if (!d.lh(25)) {}
    }
    try
    {
      if (l.Fch == null)
      {
        Field localField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("mPreserveWindow");
        localField.setAccessible(true);
        l.Fch = localField;
      }
      h.b("WxSplash.SplashHackHandlerCallback", "preserveWindow is %s, will set false", new Object[] { Boolean.valueOf(((Boolean)l.Fch.get(localObject)).booleanValue()) });
      l.Fch.set(localObject, Boolean.FALSE);
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
    if (this.ugp != null)
    {
      this.FbX = true;
      bool = this.ugp.handleMessage(paramMessage);
      this.FbX = false;
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