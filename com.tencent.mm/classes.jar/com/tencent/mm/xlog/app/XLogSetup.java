package com.tencent.mm.xlog.app;

import android.os.Looper;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public class XLogSetup
{
  public static Boolean appendIsSync;
  public static String cachePath;
  public static boolean hasInit = false;
  public static Boolean isLogcatOpen;
  public static String logPath;
  public static String nameprefix;
  private static boolean setup = false;
  public static Integer toolsLevel;
  public static Xlog xlog = new Xlog();
  
  public static void keep_setupXLog(boolean paramBoolean, String paramString1, String paramString2, Integer paramInteger, Boolean paramBoolean1, Boolean paramBoolean2, String paramString3)
  {
    if (!hasInit)
    {
      PlatformComm.init(ae.getContext(), new ah(Looper.getMainLooper()));
      hasInit = true;
    }
    cachePath = paramString1;
    logPath = paramString2;
    toolsLevel = paramInteger;
    appendIsSync = paramBoolean1;
    isLogcatOpen = paramBoolean2;
    nameprefix = paramString3;
    if (!paramBoolean) {}
    while (setup) {
      return;
    }
    setup = true;
    k.b(a.wDj, XLogSetup.class.getClassLoader());
    y.a(xlog);
    appendIsSync.booleanValue();
    Xlog.setConsoleLogOpen(isLogcatOpen.booleanValue());
    if (toolsLevel == null)
    {
      Xlog.AppenderOpen(2, 0, cachePath, logPath, nameprefix, 3);
      LogLogic.initIPxxLogInfo();
      return;
    }
    Xlog.AppenderOpen(toolsLevel.intValue(), 1, cachePath, logPath, nameprefix, 0);
  }
  
  public static void realSetupXlog()
  {
    keep_setupXLog(true, cachePath, logPath, toolsLevel, appendIsSync, isLogcatOpen, nameprefix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.xlog.app.XLogSetup
 * JD-Core Version:    0.7.0.1
 */