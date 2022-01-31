package com.tencent.mm.xlog.app;

import android.os.Looper;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

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
    AppMethodBeat.i(59243);
    setup = false;
    xlog = new Xlog();
    hasInit = false;
    AppMethodBeat.o(59243);
  }
  
  public static void keep_setupXLog(boolean paramBoolean, String paramString1, String paramString2, Integer paramInteger, Boolean paramBoolean1, Boolean paramBoolean2, String paramString3)
  {
    AppMethodBeat.i(59242);
    if (!hasInit)
    {
      PlatformComm.init(ah.getContext(), new ak(Looper.getMainLooper()));
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
      AppMethodBeat.o(59242);
      return;
    }
    if (setup)
    {
      AppMethodBeat.o(59242);
      return;
    }
    setup = true;
    k.a(a.AZA, XLogSetup.class.getClassLoader());
    ab.a(xlog);
    appendIsSync.booleanValue();
    Xlog.setConsoleLogOpen(isLogcatOpen.booleanValue());
    if (toolsLevel == null)
    {
      Xlog.AppenderOpen(2, 0, cachePath, logPath, nameprefix, 3);
      LogLogic.initIPxxLogInfo();
      AppMethodBeat.o(59242);
      return;
    }
    Xlog.AppenderOpen(toolsLevel.intValue(), 1, cachePath, logPath, nameprefix, 0);
    AppMethodBeat.o(59242);
  }
  
  public static void realSetupXlog()
  {
    AppMethodBeat.i(59241);
    keep_setupXLog(true, cachePath, logPath, toolsLevel, appendIsSync, isLogcatOpen, nameprefix);
    AppMethodBeat.o(59241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.xlog.app.XLogSetup
 * JD-Core Version:    0.7.0.1
 */