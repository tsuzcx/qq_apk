package com.tencent.mm.plugin.wepkg.model;

import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class e$1$1
  implements Runnable
{
  e$1$1(e.1 param1, String paramString) {}
  
  public final void run()
  {
    int i = 0;
    Object localObject1 = d.Vp(this.rPv.rOZ);
    String str = "";
    Object localObject2 = f.Vj(this.rPv.rOZ);
    if (localObject2 != null) {
      str = ((WepkgVersion)localObject2).version;
    }
    y.i("MicroMsg.Wepkg.WepkgManager", "clear all local wepkg, pkgid:%s, currVersion:%s, usedVersion:%s", new Object[] { this.rPv.rOZ, str, this.rPa });
    try
    {
      if ((bk.bl(this.rPa)) && (bk.bl(str)))
      {
        e.Vh((String)localObject1);
        return;
      }
      localObject2 = new File((String)localObject1);
      if ((!((File)localObject2).exists()) || (((File)localObject2).isFile())) {
        return;
      }
      localObject1 = ((File)localObject2).listFiles();
      if ((localObject1 == null) || (localObject1.length == 0))
      {
        ((File)localObject2).delete();
        return;
      }
    }
    catch (Exception localException)
    {
      y.i("MicroMsg.Wepkg.WepkgManager", "clearLocalWepkg err:" + localException.getMessage());
      return;
    }
    int j = localObject1.length;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (((File)localObject2).isFile()) {
        ((File)localObject2).delete();
      }
      if ((((File)localObject2).isDirectory()) && (!((File)localObject2).getName().equalsIgnoreCase(this.rPa)) && (!((File)localObject2).getName().equalsIgnoreCase(localException)))
      {
        y.i("MicroMsg.Wepkg.WepkgManager", "delete local path:%s", new Object[] { ((File)localObject2).getAbsolutePath() });
        e.Vh(((File)localObject2).getAbsolutePath());
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.e.1.1
 * JD-Core Version:    0.7.0.1
 */