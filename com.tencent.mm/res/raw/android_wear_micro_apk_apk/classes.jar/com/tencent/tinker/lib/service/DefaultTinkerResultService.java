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
      com.tencent.tinker.lib.e.c.E(getApplicationContext());
    } while (!parama.ajJ);
    c(new File(parama.ajK));
    if (b(parama))
    {
      Process.killProcess(Process.myPid());
      return;
    }
    com.tencent.tinker.lib.e.a.c("Tinker.DefaultTinkerResultService", "I have already install the newly patch version!", new Object[0]);
  }
  
  public final boolean b(a parama)
  {
    Object localObject = com.tencent.tinker.lib.d.a.D(getApplicationContext());
    if (((com.tencent.tinker.lib.d.a)localObject).ob())
    {
      localObject = ((com.tencent.tinker.lib.d.a)localObject).nY();
      if (localObject != null)
      {
        localObject = ((com.tencent.tinker.lib.d.c)localObject).akh;
        if ((parama.ajM != null) && (parama.ajM.equals(localObject))) {
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