package com.tencent.xweb.xwalk.b;

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
  public static boolean BLh = true;
  private static boolean BLi = false;
  private static e BLj;
  XWalkInitializer BKk;
  XWalkUpdater BKl;
  Context mContext;
  
  private e(Context paramContext)
  {
    AppMethodBeat.i(85472);
    this.mContext = paramContext;
    this.BKk = new XWalkInitializer(this, paramContext);
    this.BKl = new XWalkUpdater(this, paramContext);
    AppMethodBeat.o(85472);
  }
  
  public static boolean isXWalkReady()
  {
    AppMethodBeat.i(85477);
    if ((!BLi) || (BLj == null))
    {
      AppMethodBeat.o(85477);
      return false;
    }
    boolean bool = BLj.BKk.isXWalkReady();
    AppMethodBeat.o(85477);
    return bool;
  }
  
  public static boolean jY(Context paramContext)
  {
    AppMethodBeat.i(85478);
    if (BLi)
    {
      boolean bool = BLi;
      AppMethodBeat.o(85478);
      return bool;
    }
    BLi = true;
    BLj = new e(paramContext);
    XWalkEnvironment.init(paramContext);
    if (XWalkEnvironment.isDownloadMode())
    {
      paramContext = BLj;
      if (!BLh)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("UpdaterCheckType", "0");
        new f(paramContext.BKl, localHashMap).execute(new String[0]);
      }
      if (paramContext.BKk.tryInitSync())
      {
        XWalkInitializer.addXWalkInitializeLog("initSync Sucsess");
        AppMethodBeat.o(85478);
        return true;
      }
      AppMethodBeat.o(85478);
      return false;
    }
    AppMethodBeat.o(85478);
    return false;
  }
  
  public final void onXWalkInitCancelled() {}
  
  public final void onXWalkInitCompleted() {}
  
  public final void onXWalkInitFailed() {}
  
  public final void onXWalkInitStarted() {}
  
  public final void onXWalkUpdateCancelled()
  {
    AppMethodBeat.i(85474);
    f.eaH();
    AppMethodBeat.o(85474);
  }
  
  public final void onXWalkUpdateCompleted()
  {
    AppMethodBeat.i(85476);
    f.eaI();
    AppMethodBeat.o(85476);
  }
  
  public final void onXWalkUpdateFailed(int paramInt)
  {
    AppMethodBeat.i(85475);
    f.TN(paramInt);
    AppMethodBeat.o(85475);
  }
  
  public final void onXWalkUpdateProgress(int paramInt) {}
  
  public final void onXWalkUpdateStarted()
  {
    AppMethodBeat.i(85473);
    f.eaG();
    AppMethodBeat.o(85473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.e
 * JD-Core Version:    0.7.0.1
 */