package com.tencent.tinker.lib.service;

import android.os.Process;
import com.tencent.tinker.loader.a.f;
import java.io.File;

public class DefaultTinkerResultService
  extends AbstractResultService
{
  public static void c(File paramFile)
  {
    if (!f.j(paramFile)) {}
    Object localObject;
    do
    {
      return;
      com.tencent.tinker.lib.e.a.b("Tinker.DefaultTinkerResultService", "deleteRawPatchFile rawFile path: %s", new Object[] { paramFile.getPath() });
      localObject = paramFile.getName();
      if ((!((String)localObject).startsWith("patch-")) || (!((String)localObject).endsWith(".apk")))
      {
        f.l(paramFile);
        return;
      }
      localObject = paramFile.getParentFile();
      if (!((File)localObject).getName().startsWith("patch-"))
      {
        f.l(paramFile);
        return;
      }
    } while (((File)localObject).getParentFile().getName().equals("tinker"));
    f.l(paramFile);
  }
  
  public void a(a parama)
  {
    if (parama == null) {
      com.tencent.tinker.lib.e.a.a("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received null result!!!!", new Object[0]);
    }
    do
    {
      return;
      com.tencent.tinker.lib.e.a.c("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received a result:%s ", new Object[] { parama.toString() });
      com.tencent.tinker.lib.e.c.F(getApplicationContext());
    } while (!parama.anl);
    c(new File(parama.anm));
    if (b(parama))
    {
      Process.killProcess(Process.myPid());
      return;
    }
    com.tencent.tinker.lib.e.a.c("Tinker.DefaultTinkerResultService", "I have already install the newly patch version!", new Object[0]);
  }
  
  public final boolean b(a parama)
  {
    Object localObject = com.tencent.tinker.lib.d.a.E(getApplicationContext());
    if (((com.tencent.tinker.lib.d.a)localObject).oO())
    {
      localObject = ((com.tencent.tinker.lib.d.a)localObject).oL();
      if (localObject != null)
      {
        localObject = ((com.tencent.tinker.lib.d.c)localObject).anG;
        if ((parama.ann != null) && (parama.ann.equals(localObject))) {
          return false;
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.service.DefaultTinkerResultService
 * JD-Core Version:    0.7.0.1
 */