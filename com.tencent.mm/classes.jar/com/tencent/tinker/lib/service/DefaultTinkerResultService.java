package com.tencent.tinker.lib.service;

import android.os.Process;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

public class DefaultTinkerResultService
  extends AbstractResultService
{
  public static void ab(File paramFile)
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
  
  public final boolean a(a parama)
  {
    Object localObject = com.tencent.tinker.lib.e.a.oy(getApplicationContext());
    if (((com.tencent.tinker.lib.e.a)localObject).ahRN)
    {
      localObject = ((com.tencent.tinker.lib.e.a)localObject).ahRM;
      if (localObject != null)
      {
        localObject = ((d)localObject).ahRR;
        if ((parama.ahRz != null) && (parama.ahRz.equals(localObject))) {
          return false;
        }
      }
    }
    return true;
  }
  
  public void onPatchResult(a parama)
  {
    if (parama == null) {
      ShareTinkerLog.e("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received null result!!!!", new Object[0]);
    }
    do
    {
      return;
      ShareTinkerLog.i("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received a result:%s ", new Object[] { parama.toString() });
      c.oz(getApplicationContext());
    } while (!parama.isSuccess);
    ab(new File(parama.ahRw));
    if (a(parama))
    {
      Process.killProcess(Process.myPid());
      return;
    }
    ShareTinkerLog.i("Tinker.DefaultTinkerResultService", "I have already install the newly patch version!", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.service.DefaultTinkerResultService
 * JD-Core Version:    0.7.0.1
 */