package com.tencent.xweb.xwalk.a;

import java.io.File;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

final class e$1
  implements b
{
  public final void a(f.c paramc)
  {
    Object localObject = paramc.mFilePath;
    if (localObject == null)
    {
      XWalkInitializer.addXWalkInitializeLog("parse config failed ,path is empty");
      localObject = null;
    }
    while (localObject == null)
    {
      com.tencent.xweb.util.e.it(35L);
      com.tencent.xweb.util.e.cTd();
      com.tencent.xweb.util.e.bp(15123, "0,180801," + paramc.xnx + "," + paramc.mNetWorkType + "," + paramc.mRetryTimes + "," + paramc.xny + "," + paramc.mTotalSize);
      XWalkEnvironment.addXWalkInitializeLog("ConfigParser failed ");
      return;
      localObject = new File((String)localObject);
      if (!((File)localObject).exists())
      {
        XWalkInitializer.addXWalkInitializeLog("parse config failed ,file not exist");
        localObject = null;
      }
      else
      {
        localObject = a.i((File)localObject, a.a((File)localObject, (int)((File)localObject).length(), "<Versions>"));
      }
    }
    try
    {
      com.tencent.xweb.a.a(((a.a)localObject).xmQ, ((a.a)localObject).xmO);
      XWalkEnvironment.addXWalkInitializeLog("doFetchUpdateConfigNew onTaskSucceed!!");
      com.tencent.xweb.util.e.iy(paramc.xny);
      com.tencent.xweb.util.e.bp(15123, ((a.a)localObject).xmO + ",180801," + paramc.xnx + "," + paramc.mNetWorkType + "," + paramc.mRetryTimes + "," + paramc.xny + "," + paramc.mTotalSize + "," + e.access$000());
      c.cTK();
      e.c(c.a((a.a)localObject));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        XWalkEnvironment.addXWalkInitializeLog("apply cmds failed , " + localException.getMessage());
      }
    }
  }
  
  public final void b(f.c paramc)
  {
    com.tencent.xweb.util.e.it(35L);
    com.tencent.xweb.util.e.cTd();
    com.tencent.xweb.util.e.bp(15123, "0,180801," + paramc.xnx + "," + paramc.mNetWorkType + "," + paramc.mRetryTimes + "," + paramc.xny + "," + paramc.mTotalSize + "," + e.access$000());
    XWalkEnvironment.addXWalkInitializeLog("get config onTaskFailed ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a.e.1
 * JD-Core Version:    0.7.0.1
 */