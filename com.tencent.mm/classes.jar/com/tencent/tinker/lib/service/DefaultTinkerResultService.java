package com.tencent.tinker.lib.service;

import android.os.Process;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.f.b;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public class DefaultTinkerResultService
  extends AbstractResultService
{
  public static void W(File paramFile)
  {
    if (!SharePatchFileUtil.isLegalFile(paramFile)) {}
    Object localObject;
    do
    {
      return;
      com.tencent.tinker.lib.f.a.w("Tinker.DefaultTinkerResultService", "deleteRawPatchFile rawFile path: %s", new Object[] { paramFile.getPath() });
      localObject = paramFile.getName();
      if ((!((String)localObject).startsWith("patch-")) || (!((String)localObject).endsWith(".apk")))
      {
        SharePatchFileUtil.safeDeleteFile(paramFile);
        return;
      }
      localObject = paramFile.getParentFile();
      if (!((File)localObject).getName().startsWith("patch-"))
      {
        SharePatchFileUtil.safeDeleteFile(paramFile);
        return;
      }
    } while (((File)localObject).getParentFile().getName().equals("tinker"));
    SharePatchFileUtil.safeDeleteFile(paramFile);
  }
  
  public void a(a parama)
  {
    if (parama == null) {
      com.tencent.tinker.lib.f.a.e("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received null result!!!!", new Object[0]);
    }
    do
    {
      return;
      com.tencent.tinker.lib.f.a.i("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received a result:%s ", new Object[] { parama.toString() });
      b.kJ(getApplicationContext());
    } while (!parama.dhg);
    W(new File(parama.IEC));
    if (b(parama))
    {
      Process.killProcess(Process.myPid());
      return;
    }
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultTinkerResultService", "I have already install the newly patch version!", new Object[0]);
  }
  
  public final boolean b(a parama)
  {
    Object localObject = com.tencent.tinker.lib.e.a.kI(getApplicationContext());
    if (((com.tencent.tinker.lib.e.a)localObject).IER)
    {
      localObject = ((com.tencent.tinker.lib.e.a)localObject).IEQ;
      if (localObject != null)
      {
        localObject = ((d)localObject).IEV;
        if ((parama.IED != null) && (parama.IED.equals(localObject))) {
          return false;
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.lib.service.DefaultTinkerResultService
 * JD-Core Version:    0.7.0.1
 */