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
  public static boolean Mzd = true;
  private static boolean Mze = false;
  private static e Mzf;
  XWalkInitializer Mxx;
  XWalkUpdater Mxy;
  Context mContext;
  
  private e(Context paramContext)
  {
    AppMethodBeat.i(154564);
    this.mContext = paramContext;
    this.Mxx = new XWalkInitializer(this, paramContext);
    this.Mxy = new XWalkUpdater(this, paramContext);
    AppMethodBeat.o(154564);
  }
  
  public static boolean isXWalkReady()
  {
    AppMethodBeat.i(154569);
    if ((!Mze) || (Mzf == null))
    {
      AppMethodBeat.o(154569);
      return false;
    }
    boolean bool = Mzf.Mxx.isXWalkReady();
    AppMethodBeat.o(154569);
    return bool;
  }
  
  public static boolean lF(Context paramContext)
  {
    AppMethodBeat.i(154570);
    if (Mze)
    {
      boolean bool = Mze;
      AppMethodBeat.o(154570);
      return bool;
    }
    Mze = true;
    Mzf = new e(paramContext);
    XWalkEnvironment.init(paramContext);
    if (XWalkEnvironment.isDownloadMode())
    {
      paramContext = Mzf;
      if (!Mzd)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("UpdaterCheckType", "0");
        new f(paramContext.Mxy, localHashMap).execute(new String[0]);
      }
      if (paramContext.Mxx.tryInitSync())
      {
        XWalkInitializer.addXWalkInitializeLog("initSync Sucsess");
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
    f.gdR();
    AppMethodBeat.o(154566);
  }
  
  public final void onXWalkUpdateCompleted()
  {
    AppMethodBeat.i(154568);
    f.gdS();
    AppMethodBeat.o(154568);
  }
  
  public final void onXWalkUpdateFailed(int paramInt)
  {
    AppMethodBeat.i(154567);
    f.aiR(paramInt);
    AppMethodBeat.o(154567);
  }
  
  public final void onXWalkUpdateProgress(int paramInt) {}
  
  public final void onXWalkUpdateStarted()
  {
    AppMethodBeat.i(154565);
    f.gdQ();
    AppMethodBeat.o(154565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.e
 * JD-Core Version:    0.7.0.1
 */