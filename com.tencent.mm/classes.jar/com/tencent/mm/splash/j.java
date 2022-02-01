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
  public static int IFk = 113;
  public static int IFl = 114;
  public static int IFm = 115;
  public static int IFn = 116;
  public static int IFo = 121;
  public static int IFp = 122;
  public static int IFq = 126;
  public static int IFr = 145;
  private static boolean IFs = false;
  private static Runnable IFt;
  private static boolean IFv = false;
  public static int LAUNCH_ACTIVITY = 100;
  private boolean IFu = false;
  private Context mContext;
  Handler.Callback wKq;
  
  public j(Context paramContext, Handler.Callback paramCallback)
  {
    this.mContext = paramContext;
    this.wKq = paramCallback;
  }
  
  public static void aC(Runnable paramRunnable)
  {
    IFs = true;
    IFt = paramRunnable;
  }
  
  public static boolean frw()
  {
    return IFv;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(40678);
    if (this.IFu)
    {
      h.b("WxSplash.SplashHackHandlerCallback", "found a infinite call loop", new Object[0]);
      AppMethodBeat.o(40678);
      return false;
    }
    IFv = false;
    h.b("WxSplash.SplashHackHandlerCallback", "before handleMessage %s, splash %s, pending early %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(h.frj()), Boolean.valueOf(h.frk()) });
    if ((IFs) && (paramMessage.what == 987654321))
    {
      if (IFt != null)
      {
        h.b("WxSplash.SplashHackHandlerCallback", "verify hack received.", new Object[0]);
        IFt.run();
      }
      AppMethodBeat.o(40678);
      return true;
    }
    Object localObject;
    if ((h.frj()) && (!h.frk()))
    {
      h.b("WxSplash.SplashHackHandlerCallback", "handleMessage %s, splash %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(h.frj()) });
      if ((paramMessage.what == IFk) || (paramMessage.what == IFl) || (paramMessage.what == IFm) || (paramMessage.what == IFn) || (paramMessage.what == IFo) || (paramMessage.what == IFp) || (paramMessage.what == IFr))
      {
        localObject = Message.obtain();
        ((Message)localObject).copyFrom(paramMessage);
        h.IEJ.add(localObject);
        if (h.IEN != null) {
          h.IEN.MH();
        }
        AppMethodBeat.o(40678);
        return true;
      }
    }
    if ((paramMessage.what == IFq) || ((Build.VERSION.SDK_INT == 28) && (paramMessage.what == 160)))
    {
      if (h.IEO.size() > 0) {
        IFv = true;
      }
      h.b("WxSplash.SplashHackHandlerCallback", "received a RELAUNCH_ACTIVITY message, with %s splash activity", new Object[] { Integer.valueOf(h.IEO.size()) });
      localObject = paramMessage.obj;
      if (!d.lC(25)) {}
    }
    try
    {
      if (l.IFE == null)
      {
        Field localField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("mPreserveWindow");
        localField.setAccessible(true);
        l.IFE = localField;
      }
      h.b("WxSplash.SplashHackHandlerCallback", "preserveWindow is %s, will set false", new Object[] { Boolean.valueOf(((Boolean)l.IFE.get(localObject)).booleanValue()) });
      l.IFE.set(localObject, Boolean.FALSE);
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
    if (this.wKq != null)
    {
      this.IFu = true;
      bool = this.wKq.handleMessage(paramMessage);
      this.IFu = false;
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