package com.tencent.xweb.xwalk.updater;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

public final class d
  implements XWalkInitializer.XWalkInitListener, XWalkUpdater.XWalkBackgroundUpdateListener
{
  public static boolean IVT = true;
  private static boolean IVU = false;
  private static d IVV;
  XWalkInitializer IUv;
  XWalkUpdater IUw;
  Context mContext;
  
  private d(Context paramContext)
  {
    AppMethodBeat.i(154564);
    this.mContext = paramContext;
    this.IUv = new XWalkInitializer(this, paramContext);
    this.IUw = new XWalkUpdater(this, paramContext);
    AppMethodBeat.o(154564);
  }
  
  public static boolean isXWalkReady()
  {
    AppMethodBeat.i(154569);
    if ((!IVU) || (IVV == null))
    {
      AppMethodBeat.o(154569);
      return false;
    }
    boolean bool = IVV.IUv.isXWalkReady();
    AppMethodBeat.o(154569);
    return bool;
  }
  
  public static boolean lf(Context paramContext)
  {
    AppMethodBeat.i(154570);
    if (IVU)
    {
      boolean bool = IVU;
      AppMethodBeat.o(154570);
      return bool;
    }
    IVU = true;
    IVV = new d(paramContext);
    XWalkEnvironment.init(paramContext);
    if (XWalkEnvironment.isDownloadMode())
    {
      paramContext = IVV;
      if (!IVT)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("UpdaterCheckType", "0");
        new e(paramContext.IUw, localHashMap).execute(new String[0]);
      }
      if (paramContext.IUv.tryInitSync())
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
    e.ftJ();
    AppMethodBeat.o(154566);
  }
  
  public final void onXWalkUpdateCompleted()
  {
    AppMethodBeat.i(154568);
    e.ftK();
    AppMethodBeat.o(154568);
  }
  
  public final void onXWalkUpdateFailed(int paramInt)
  {
    AppMethodBeat.i(154567);
    e.adv(paramInt);
    AppMethodBeat.o(154567);
  }
  
  public final void onXWalkUpdateProgress(int paramInt) {}
  
  public final void onXWalkUpdateStarted()
  {
    AppMethodBeat.i(154565);
    e.ftI();
    AppMethodBeat.o(154565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.d
 * JD-Core Version:    0.7.0.1
 */