package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ai;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.h;
import java.io.File;

public class XWalkUpdater$LibUpdateConfig
  extends XWalkUpdater.EmbededUpdateConfig
{
  public XWalkUpdater$LibUpdateConfig(int paramInt, String paramString1, String paramString2)
  {
    super(paramInt, paramString1, paramString2);
  }
  
  public boolean copyPackageToLocal(String paramString1, String paramString2)
  {
    AppMethodBeat.i(207396);
    Object localObject = ai.hti();
    paramString1 = (String)localObject + File.separator + paramString1;
    localObject = new File(paramString1);
    File localFile = new File(getDownloadPath());
    if (localFile.exists())
    {
      if (d.oi(localFile.getAbsolutePath(), paramString2))
      {
        XWalkEnvironment.addXWalkInitializeLog("lib_installer", " already have file and md5 matched");
        AppMethodBeat.o(207396);
        return true;
      }
      XWalkEnvironment.addXWalkInitializeLog("lib_installer", " already have file but md5 not matched");
      localFile.delete();
    }
    if (!((File)localObject).exists())
    {
      h.s(903L, 129L, 1L);
      XWalkEnvironment.addXWalkInitializeLog("lib_installer", " src file not find:".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(207396);
      return false;
    }
    if (!d.oi(((File)localObject).getAbsolutePath(), paramString2))
    {
      h.s(903L, 130L, 1L);
      XWalkEnvironment.addXWalkInitializeLog("lib_installer", " src file MD5 not match");
    }
    if (!c.g((File)localObject, localFile))
    {
      h.s(903L, 131L, 1L);
      XWalkEnvironment.addXWalkInitializeLog("lib_installer", " copy file failed");
      AppMethodBeat.o(207396);
      return false;
    }
    AppMethodBeat.o(207396);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.LibUpdateConfig
 * JD-Core Version:    0.7.0.1
 */