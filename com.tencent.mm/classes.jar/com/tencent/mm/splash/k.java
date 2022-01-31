package com.tencent.mm.splash;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mm.compatible.util.d;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Set;

final class k
  implements Handler.Callback
{
  public static int umg = 100;
  public static int umh = 113;
  public static int umi = 114;
  public static int umj = 115;
  public static int umk = 116;
  public static int uml = 121;
  public static int umm = 122;
  public static int umn = 126;
  public static int umo = 145;
  private static boolean ump = false;
  private static Runnable umq;
  private static boolean ums = false;
  private Context mContext;
  Handler.Callback mHG;
  private boolean umr = false;
  
  public k(Context paramContext, Handler.Callback paramCallback)
  {
    this.mContext = paramContext;
    this.mHG = paramCallback;
  }
  
  public static void ag(Runnable paramRunnable)
  {
    ump = true;
    umq = paramRunnable;
  }
  
  public static boolean ctl()
  {
    return ums;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    if (this.umr)
    {
      i.c("WxSplash.SplashHackHandlerCallback", "found a infinite call loop", new Object[0]);
      return true;
    }
    ums = false;
    i.c("WxSplash.SplashHackHandlerCallback", "before handleMessage %s, splash %s, pending early %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(i.csW()), Boolean.valueOf(i.csX()) });
    if ((ump) && (paramMessage.what == 987654321))
    {
      if (umq != null)
      {
        i.c("WxSplash.SplashHackHandlerCallback", "verify hack received.", new Object[0]);
        umq.run();
      }
      return true;
    }
    Object localObject;
    if ((i.csW()) && (!i.csX()))
    {
      i.c("WxSplash.SplashHackHandlerCallback", "handleMessage %s, splash %s", new Object[] { Integer.valueOf(paramMessage.what), Boolean.valueOf(i.csW()) });
      if ((paramMessage.what == umh) || (paramMessage.what == umi) || (paramMessage.what == umj) || (paramMessage.what == umk) || (paramMessage.what == uml) || (paramMessage.what == umm) || (paramMessage.what == umo))
      {
        localObject = Message.obtain();
        ((Message)localObject).copyFrom(paramMessage);
        i.ulF.add(localObject);
        if (i.ulK != null) {
          i.ulK.tg();
        }
        return true;
      }
    }
    if (paramMessage.what == umn)
    {
      if (i.ulL.size() > 0) {
        ums = true;
      }
      i.c("WxSplash.SplashHackHandlerCallback", "received a RELAUNCH_ACTIVITY message, with %s splash activity", new Object[] { Integer.valueOf(i.ulL.size()) });
      localObject = paramMessage.obj;
      if (!d.gH(25)) {}
    }
    try
    {
      if (m.umB == null)
      {
        Field localField = Class.forName("android.app.ActivityThread$ActivityClientRecord").getDeclaredField("mPreserveWindow");
        localField.setAccessible(true);
        m.umB = localField;
      }
      i.c("WxSplash.SplashHackHandlerCallback", "preserveWindow is %s, will set false", new Object[] { Boolean.valueOf(((Boolean)m.umB.get(localObject)).booleanValue()) });
      m.umB.set(localObject, Boolean.valueOf(false));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        i.a(localException, "");
      }
    }
    if (this.mHG != null)
    {
      this.umr = true;
      bool = this.mHG.handleMessage(paramMessage);
      this.umr = false;
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.k
 * JD-Core Version:    0.7.0.1
 */