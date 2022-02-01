package com.tencent.xweb.xwalk.updater;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

public final class e
  implements XWalkInitializer.XWalkInitListener, XWalkUpdater.XWalkBackgroundUpdateListener
{
  public static boolean MWi = true;
  private static boolean MWj = false;
  private static e MWk;
  XWalkInitializer MUB;
  XWalkUpdater MUC;
  Context mContext;
  
  private e(Context paramContext)
  {
    AppMethodBeat.i(154564);
    this.mContext = paramContext;
    this.MUB = new XWalkInitializer(this, paramContext);
    this.MUC = new XWalkUpdater(this, paramContext);
    AppMethodBeat.o(154564);
  }
  
  public static boolean isXWalkReady()
  {
    AppMethodBeat.i(154569);
    if ((!MWj) || (MWk == null))
    {
      AppMethodBeat.o(154569);
      return false;
    }
    boolean bool = MWk.MUB.isXWalkReady();
    AppMethodBeat.o(154569);
    return bool;
  }
  
  public static boolean lL(Context paramContext)
  {
    AppMethodBeat.i(154570);
    if (MWj)
    {
      boolean bool = MWj;
      AppMethodBeat.o(154570);
      return bool;
    }
    MWj = true;
    MWk = new e(paramContext);
    XWalkEnvironment.init(paramContext);
    if (XWalkEnvironment.isDownloadMode())
    {
      paramContext = MWk;
      if (!MWi)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("UpdaterCheckType", "0");
        new f(paramContext.MUC, localHashMap).execute(new String[0]);
      }
      if (paramContext.MUB.tryInitSync())
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
    f.git();
    AppMethodBeat.o(154566);
  }
  
  public final void onXWalkUpdateCompleted(Scheduler paramScheduler)
  {
    AppMethodBeat.i(207624);
    f.a(paramScheduler);
    AppMethodBeat.o(207624);
  }
  
  public final void onXWalkUpdateFailed(int paramInt, Scheduler paramScheduler)
  {
    AppMethodBeat.i(207623);
    f.a(paramInt, paramScheduler);
    AppMethodBeat.o(207623);
  }
  
  public final void onXWalkUpdateProgress(int paramInt) {}
  
  public final void onXWalkUpdateStarted()
  {
    AppMethodBeat.i(154565);
    f.gis();
    AppMethodBeat.o(154565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.e
 * JD-Core Version:    0.7.0.1
 */