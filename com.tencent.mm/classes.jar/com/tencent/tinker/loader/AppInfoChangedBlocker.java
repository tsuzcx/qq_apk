package com.tencent.tinker.loader;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.reflect.Field;

public final class AppInfoChangedBlocker
{
  private static final String TAG = "Tinker.AppInfoChangedBlocker";
  
  private static Handler fetchMHObject(Context paramContext)
  {
    paramContext = ShareReflectUtil.getActivityThread(paramContext, null);
    return (Handler)ShareReflectUtil.findField(paramContext, "mH").get(paramContext);
  }
  
  private static void interceptHandler(Handler paramHandler)
  {
    Field localField = ShareReflectUtil.findField(Handler.class, "mCallback");
    Handler.Callback localCallback = (Handler.Callback)localField.get(paramHandler);
    if (!(localCallback instanceof HackerCallback))
    {
      localField.set(paramHandler, new HackerCallback(localCallback, paramHandler.getClass()));
      return;
    }
    ShareTinkerLog.w("Tinker.AppInfoChangedBlocker", "Already intercepted, skip rest logic.", new Object[0]);
  }
  
  public static boolean tryStart(Application paramApplication)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return true;
    }
    try
    {
      ShareTinkerLog.i("Tinker.AppInfoChangedBlocker", "tryStart called.", new Object[0]);
      interceptHandler(fetchMHObject(paramApplication));
      ShareTinkerLog.i("Tinker.AppInfoChangedBlocker", "tryStart done.", new Object[0]);
      return true;
    }
    finally
    {
      ShareTinkerLog.e("Tinker.AppInfoChangedBlocker", "AppInfoChangedBlocker start failed, simply ignore.", new Object[] { paramApplication });
    }
    return false;
  }
  
  static class HackerCallback
    implements Handler.Callback
  {
    private final int APPLICATION_INFO_CHANGED;
    private Handler.Callback origin;
    
    HackerCallback(Handler.Callback paramCallback, Class paramClass)
    {
      this.origin = paramCallback;
      try
      {
        i = ShareReflectUtil.findField(paramClass, "APPLICATION_INFO_CHANGED").getInt(null);
        this.APPLICATION_INFO_CHANGED = i;
        return;
      }
      finally
      {
        for (;;)
        {
          int i = 156;
        }
      }
    }
    
    private boolean hackMessage(Message paramMessage)
    {
      boolean bool = false;
      if (paramMessage.what == this.APPLICATION_INFO_CHANGED)
      {
        ShareTinkerLog.w("Tinker.AppInfoChangedBlocker", "Suicide now.", new Object[0]);
        Process.killProcess(Process.myPid());
        bool = true;
      }
      return bool;
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      boolean bool = false;
      if (hackMessage(paramMessage)) {
        bool = true;
      }
      while (this.origin == null) {
        return bool;
      }
      return this.origin.handleMessage(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.AppInfoChangedBlocker
 * JD-Core Version:    0.7.0.1
 */