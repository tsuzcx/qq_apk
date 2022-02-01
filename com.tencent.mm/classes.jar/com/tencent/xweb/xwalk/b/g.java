package com.tencent.xweb.xwalk.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.xwalk.XWalkUpdater;
import com.tencent.xweb.xwalk.XWalkUpdater.f;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;

public final class g
  implements XWalkUpdater.f, XWalkInitializer.XWalkInitListener
{
  public static boolean aalf = true;
  private static boolean aalg = false;
  private static g aalh;
  XWalkInitializer aajA;
  XWalkUpdater aajB;
  Context mContext;
  
  private g(Context paramContext)
  {
    AppMethodBeat.i(154564);
    this.mContext = paramContext;
    this.aajA = new XWalkInitializer(this, paramContext);
    this.aajB = new XWalkUpdater(this, paramContext);
    AppMethodBeat.o(154564);
  }
  
  public static boolean isXWalkReady()
  {
    AppMethodBeat.i(154569);
    if ((!aalg) || (aalh == null))
    {
      AppMethodBeat.o(154569);
      return false;
    }
    boolean bool = aalh.aajA.isXWalkReady();
    AppMethodBeat.o(154569);
    return bool;
  }
  
  public static boolean mH(Context paramContext)
  {
    AppMethodBeat.i(154570);
    if (aalg)
    {
      boolean bool = aalg;
      AppMethodBeat.o(154570);
      return bool;
    }
    aalg = true;
    aalh = new g(paramContext);
    XWalkEnvironment.init(paramContext);
    if (XWalkEnvironment.isDownloadMode())
    {
      paramContext = aalh;
      if (!aalf)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("UpdaterCheckType", "0");
        new h(paramContext.aajB, localHashMap).execute(new String[0]);
      }
      if (paramContext.aajA.tryInitSync())
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
  
  public final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(204560);
    h.b(paramInt, paramc);
    AppMethodBeat.o(204560);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(204561);
    h.b(paramc);
    AppMethodBeat.o(204561);
  }
  
  public final void aCS(int paramInt) {}
  
  public final void iyN()
  {
    AppMethodBeat.i(154565);
    h.izP();
    AppMethodBeat.o(154565);
  }
  
  public final void iyO()
  {
    AppMethodBeat.i(154566);
    h.izQ();
    AppMethodBeat.o(154566);
  }
  
  public final void onXWalkInitCancelled() {}
  
  public final void onXWalkInitCompleted() {}
  
  public final void onXWalkInitFailed() {}
  
  public final void onXWalkInitStarted() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.g
 * JD-Core Version:    0.7.0.1
 */