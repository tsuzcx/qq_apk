package com.tencent.mm.plugin.wepkg.model;

import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    Object localObject1 = new File(com.tencent.mm.plugin.wepkg.utils.b.OBJECT_ROOT_DIR_PATH);
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory())) {}
    for (;;)
    {
      return;
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length != 0))
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2 != null)
          {
            String str = localObject2.getName();
            if (f.Vj(str) == null)
            {
              e.Vh(localObject2.getAbsolutePath());
              y.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean dirty wepkg: %s", new Object[] { str });
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.b.2
 * JD-Core Version:    0.7.0.1
 */