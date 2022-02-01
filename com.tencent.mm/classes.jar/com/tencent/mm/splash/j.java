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
  public static int LAUNCH_ACTIVITY = 100;
  public static int NMd = 113;
  public static int NMe = 114;
  public static int NMf = 115;
  public static int NMg = 116;
  public static int NMh = 121;
  public static int NMi = 122;
  public static int NMj = 126;
  public static int NMk = 145;
  private static boolean NMl = false;
  private static Runnable NMm;
  private static boolean NMo = false;
  Handler.Callback AFR;
  private boolean NMn = false;
  private Context mContext;
  
  public j(Context paramContext, Handler.Callback paramCallback)
  {
    this.mContext = paramContext;
    this.AFR = paramCallback;
  }
  
  public static void aH(Runnable paramRunnable)
  {
    NMl = true;
    NMm = paramRunnable;
  }
  
  public static boolean gyw()
  {
    return NMo;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(40678);
    if (this.NMn)
    {
      h.c("WxSplash.SplashHackHandlerCallback", "found a infinite call loop", new Object[0]);
      AppMethodBeat.o(40678);
      return false;
    }
    NMo = false;
    h.c("WxSplash.SplashHackHandlerCallback", "before handleMessage %s, splash %s, pending early %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(h.gyj()), Boolean.valueOf(h.gyk()) });
    if ((NMl) && (paramMessage.what == 987654321))
    {
      if (NMm != null)
      {
        h.c("WxSplash.SplashHackHandlerCallback", "verify hack received.", new Object[0]);
        NMm.run();
      }
      AppMethodBeat.o(40678);
      return true;
    }
    Object localObject;
    if ((h.gyj()) && (!h.gyk()))
    {
      h.c("WxSplash.SplashHackHandlerCallback", "handleMessage %s, splash %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(h.gyj()) });
      if ((paramMessage.what == NMd) || (paramMessage.what == NMe) || (paramMessage.what == NMf) || (paramMessage.what == NMg) || (paramMessage.what == NMh) || (paramMessage.what == NMi) || (paramMessage.what == NMk))
      {
        localObject = Message.obtain();
        ((Message)localObject).copyFrom(paramMessage);
        h.NLC.add(localObject);
        if (h.NLG != null) {
          h.NLG.WU();
        }
        AppMethodBeat.o(40678);
        return true;
      }
    }
    if ((paramMessage.what == NMj) || ((Build.VERSION.SDK_INT == 28) && (paramMessage.what == 160)))
    {
      if (h.NLH.size() > 0) {
        NMo = true;
      }
      h.c("WxSplash.SplashHackHandlerCallback", "received a RELAUNCH_ACTIVITY message, with %s splash activity", new Object[] { Integer.valueOf(h.NLH.size()) });
      localObject = paramMessage.obj;
      if (!d.oF(25)) {}
    }
    try
    {
      if (l.NMw == null)
      {
        Field localField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("mPreserveWindow");
        localField.setAccessible(true);
        l.NMw = localField;
      }
      h.c("WxSplash.SplashHackHandlerCallback", "preserveWindow is %s, will set false", new Object[] { Boolean.valueOf(((Boolean)l.NMw.get(localObject)).booleanValue()) });
      l.NMw.set(localObject, Boolean.FALSE);
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
    if (this.AFR != null)
    {
      this.NMn = true;
      bool = this.AFR.handleMessage(paramMessage);
      this.NMn = false;
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