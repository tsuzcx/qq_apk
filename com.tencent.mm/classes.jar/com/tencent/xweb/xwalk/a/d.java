package com.tencent.xweb.xwalk.a;

import android.content.Context;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

public final class d
  implements XWalkInitializer.XWalkInitListener, XWalkUpdater.XWalkBackgroundUpdateListener
{
  public static boolean xnl = true;
  private static boolean xnm = false;
  private static d xnn;
  Context mContext;
  XWalkInitializer xmp;
  XWalkUpdater xmq;
  
  private d(Context paramContext)
  {
    this.mContext = paramContext;
    this.xmp = new XWalkInitializer(this, paramContext);
    this.xmq = new XWalkUpdater(this, paramContext);
  }
  
  public static boolean ir(Context paramContext)
  {
    if (xnm) {
      return xnm;
    }
    xnm = true;
    xnn = new d(paramContext);
    XWalkEnvironment.init(paramContext);
    if (XWalkEnvironment.isDownloadMode())
    {
      paramContext = xnn;
      if (!xnl)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("UpdaterCheckType", "0");
        new e(paramContext.xmq, localHashMap).execute(new String[0]);
      }
      if (paramContext.xmp.tryInitSync())
      {
        XWalkInitializer.addXWalkInitializeLog("initSync Sucsess");
        return true;
      }
      return false;
    }
    return false;
  }
  
  public static boolean isXWalkReady()
  {
    if ((!xnm) || (xnn == null)) {
      return false;
    }
    return xnn.xmp.isXWalkReady();
  }
  
  public final void onXWalkInitCancelled() {}
  
  public final void onXWalkInitCompleted() {}
  
  public final void onXWalkInitFailed() {}
  
  public final void onXWalkInitStarted() {}
  
  public final void onXWalkUpdateCancelled() {}
  
  public final void onXWalkUpdateCompleted() {}
  
  public final void onXWalkUpdateFailed(int paramInt)
  {
    e.KK(paramInt);
  }
  
  public final void onXWalkUpdateProgress(int paramInt) {}
  
  public final void onXWalkUpdateStarted() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.d
 * JD-Core Version:    0.7.0.1
 */