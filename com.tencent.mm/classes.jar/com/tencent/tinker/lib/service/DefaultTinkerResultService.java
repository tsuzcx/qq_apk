package com.tencent.tinker.lib.service;

import android.os.Process;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.f.b;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

public class DefaultTinkerResultService
  extends AbstractResultService
{
  public static void X(File paramFile)
  {
    if (!SharePatchFileUtil.isLegalFile(paramFile)) {}
    Object localObject;
    do
    {
      return;
      ShareTinkerLog.w("Tinker.DefaultTinkerResultService", "deleteRawPatchFile rawFile path: %s", new Object[] { paramFile.getPath() });
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
      localObject = ((File)localObject).getParentFile();
    } while ((((File)localObject).getName().equals("tinker")) || (((File)localObject).getName().equals("wc_tinker_dir")));
    SharePatchFileUtil.safeDeleteFile(paramFile);
  }
  
  public void a(a parama)
  {
    if (parama == null) {
      ShareTinkerLog.e("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received null result!!!!", new Object[0]);
    }
    do
    {
      return;
      ShareTinkerLog.i("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received a result:%s ", new Object[] { parama.toString() });
      b.mj(getApplicationContext());
    } while (!parama.isSuccess);
    X(new File(parama.ZMu));
    if (b(parama))
    {
      Process.killProcess(Process.myPid());
      return;
    }
    ShareTinkerLog.i("Tinker.DefaultTinkerResultService", "I have already install the newly patch version!", new Object[0]);
  }
  
  public final boolean b(a parama)
  {
    Object localObject = com.tencent.tinker.lib.e.a.mi(getApplicationContext());
    if (((com.tencent.tinker.lib.e.a)localObject).ZML)
    {
      localObject = ((com.tencent.tinker.lib.e.a)localObject).ZMK;
      if (localObject != null)
      {
        localObject = ((d)localObject).ZMP;
        if ((parama.ZMx != null) && (parama.ZMx.equals(localObject))) {
          return false;
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.lib.service.DefaultTinkerResultService
 * JD-Core Version:    0.7.0.1
 */