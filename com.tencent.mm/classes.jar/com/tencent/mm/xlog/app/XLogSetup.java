package com.tencent.mm.xlog.app;

import android.os.Looper;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;

public class XLogSetup
{
  public static Boolean appendIsSync;
  public static String cachePath;
  public static boolean hasInit;
  public static Boolean isLogcatOpen;
  public static String logPath;
  public static String nameprefix;
  private static boolean setup;
  public static Integer toolsLevel;
  public static Xlog xlog;
  
  static
  {
    AppMethodBeat.i(133558);
    setup = false;
    xlog = new Xlog();
    hasInit = false;
    AppMethodBeat.o(133558);
  }
  
  public static void keep_setupXLog(boolean paramBoolean, String paramString1, String paramString2, Integer paramInteger, Boolean paramBoolean1, Boolean paramBoolean2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(133557);
    if (!hasInit)
    {
      PlatformComm.init(aj.getContext(), new ap(Looper.getMainLooper()));
      hasInit = true;
    }
    cachePath = paramString1;
    logPath = paramString2;
    toolsLevel = paramInteger;
    appendIsSync = paramBoolean1;
    isLogcatOpen = paramBoolean2;
    nameprefix = paramString3;
    if (!paramBoolean)
    {
      AppMethodBeat.o(133557);
      return;
    }
    if (setup)
    {
      AppMethodBeat.o(133557);
      return;
    }
    setup = true;
    paramString1 = a.LBF;
    XLogSetup.class.getClassLoader();
    j.vr(paramString1);
    ad.a(xlog);
    ad.setConsoleLogOpen(isLogcatOpen.booleanValue());
    if (toolsLevel == null)
    {
      ad.appenderOpen(2, 0, cachePath, logPath, nameprefix, 3);
      LogLogic.initIPxxLogInfo();
      AppMethodBeat.o(133557);
      return;
    }
    if (paramBoolean1.booleanValue()) {}
    for (;;)
    {
      ad.appenderOpen(toolsLevel.intValue(), i, cachePath, logPath, nameprefix, 0);
      AppMethodBeat.o(133557);
      return;
      i = 0;
    }
  }
  
  public static void realSetupXlog()
  {
    AppMethodBeat.i(133556);
    keep_setupXLog(true, cachePath, logPath, toolsLevel, appendIsSync, isLogcatOpen, nameprefix);
    AppMethodBeat.o(133556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.xlog.app.XLogSetup
 * JD-Core Version:    0.7.0.1
 */