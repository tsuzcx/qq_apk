package com.tencent.xweb.xwalk.updater;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

public final class f
  implements XWalkInitializer.XWalkInitListener, XWalkUpdater.XWalkBackgroundUpdateListener
{
  public static boolean SJn = true;
  private static boolean SJo = false;
  private static f SJp;
  XWalkInitializer SHI;
  XWalkUpdater SHJ;
  Context mContext;
  
  private f(Context paramContext)
  {
    AppMethodBeat.i(154564);
    this.mContext = paramContext;
    this.SHI = new XWalkInitializer(this, paramContext);
    this.SHJ = new XWalkUpdater(this, paramContext);
    AppMethodBeat.o(154564);
  }
  
  public static boolean isXWalkReady()
  {
    AppMethodBeat.i(154569);
    if ((!SJo) || (SJp == null))
    {
      AppMethodBeat.o(154569);
      return false;
    }
    boolean bool = SJp.SHI.isXWalkReady();
    AppMethodBeat.o(154569);
    return bool;
  }
  
  public static boolean lK(Context paramContext)
  {
    AppMethodBeat.i(154570);
    if (SJo)
    {
      boolean bool = SJo;
      AppMethodBeat.o(154570);
      return bool;
    }
    SJo = true;
    SJp = new f(paramContext);
    XWalkEnvironment.init(paramContext);
    if (XWalkEnvironment.isDownloadMode())
    {
      paramContext = SJp;
      if (!SJn)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("UpdaterCheckType", "0");
        new g(paramContext.SHJ, localHashMap).execute(new String[0]);
      }
      if (paramContext.SHI.tryInitSync())
      {
        AppMethodBeat.o(154570);
        return true;
      }
      AppMethodBeat.o(154570);
      return false;
    }
    AppMethodBeat.o(154570);
    return false;
  }
  
  public final void onXWalkInitCancelled() {}
  
  public final void onXWalkInitCompleted() {}
  
  public final void onXWalkInitFailed() {}
  
  public final void onXWalkInitStarted() {}
  
  public final void onXWalkUpdateCancelled()
  {
    AppMethodBeat.i(154566);
    g.hvT();
    AppMethodBeat.o(154566);
  }
  
  public final void onXWalkUpdateCompleted(Scheduler paramScheduler)
  {
    AppMethodBeat.i(207360);
    g.a(paramScheduler);
    AppMethodBeat.o(207360);
  }
  
  public final void onXWalkUpdateFailed(int paramInt, Scheduler paramScheduler)
  {
    AppMethodBeat.i(207359);
    g.a(paramInt, paramScheduler);
    AppMethodBeat.o(207359);
  }
  
  public final void onXWalkUpdateProgress(int paramInt) {}
  
  public final void onXWalkUpdateStarted()
  {
    AppMethodBeat.i(154565);
    g.hvS();
    AppMethodBeat.o(154565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.f
 * JD-Core Version:    0.7.0.1
 */