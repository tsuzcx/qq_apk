package com.tencent.tinker.lib.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.lib.f.c.a;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class b
  implements d
{
  private static boolean wVZ = false;
  protected final Context context;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void J(Intent paramIntent)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchServiceStart: patch service start", new Object[0]);
    wVZ = false;
    c localc = c.hS(this.context);
    if (!localc.wWO)
    {
      com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry disabled, just return", new Object[0]);
      return;
    }
    if (paramIntent == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatchRetry", "onPatchServiceStart intent is null, just return", new Object[0]);
      return;
    }
    paramIntent = TinkerPatchService.ax(paramIntent);
    if (paramIntent == null)
    {
      com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch path is null, just return", new Object[0]);
      return;
    }
    File localFile = new File(paramIntent);
    String str = SharePatchFileUtil.ai(localFile);
    if (str == null)
    {
      com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch md5 is null, just return", new Object[0]);
      return;
    }
    if (localc.wWP.exists())
    {
      paramIntent = c.a.ab(localc.wWP);
      if ((paramIntent.bIW == null) || (paramIntent.wWS == null) || (!str.equals(paramIntent.bIW)))
      {
        localc.aa(localFile);
        paramIntent.bIW = str;
        paramIntent.wWS = "1";
      }
    }
    for (;;)
    {
      c.a.a(localc.wWP, paramIntent);
      return;
      int i = Integer.parseInt(paramIntent.wWS);
      if (i >= localc.wWR)
      {
        SharePatchFileUtil.ah(localc.wWQ);
        com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry more than max count, delete retry info file!", new Object[0]);
        return;
      }
      paramIntent.wWS = String.valueOf(i + 1);
      continue;
      localc.aa(localFile);
      paramIntent = new c.a(str, "1");
    }
  }
  
  public void a(File paramFile, SharePatchInfo paramSharePatchInfo, String paramString)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchVersionCheckFail: patch version exist. path: %s, version: %s", new Object[] { paramFile.getAbsolutePath(), paramString });
  }
  
  public void a(File paramFile1, File paramFile2, String paramString, int paramInt)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchTypeExtractFail: file extract fail type: %s, path: %s, extractTo: %s, filename: %s", new Object[] { ShareTinkerInternals.Kn(paramInt), paramFile1.getPath(), paramFile2.getPath(), paramString });
    com.tencent.tinker.lib.e.a.hN(this.context).Z(paramFile1);
  }
  
  public void a(File paramFile, String paramString1, String paramString2)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchInfoCorrupted: patch info is corrupted. old: %s, new: %s", new Object[] { paramString1, paramString2 });
    com.tencent.tinker.lib.e.a.hN(this.context).bbj();
  }
  
  public void a(File paramFile, Throwable paramThrowable)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchException: patch exception path: %s, throwable: %s", new Object[] { paramFile.getAbsolutePath(), paramThrowable.getMessage() });
    com.tencent.tinker.lib.f.a.e("Tinker.DefaultPatchReporter", "tinker patch exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
    com.tencent.tinker.lib.f.a.printErrStackTrace("Tinker.DefaultPatchReporter", paramThrowable, "tinker patch exception", new Object[0]);
    com.tencent.tinker.lib.e.a.hN(this.context).tinkerFlags = 0;
    com.tencent.tinker.lib.e.a.hN(this.context).Z(paramFile);
  }
  
  public void a(File paramFile, List<File> paramList, Throwable paramThrowable)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchDexOptFail: dex opt fail path: %s, dex size: %d", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramList.size()) });
    com.tencent.tinker.lib.f.a.printErrStackTrace("Tinker.DefaultPatchReporter", paramThrowable, "onPatchDexOptFail:", new Object[0]);
    if ((paramThrowable.getMessage().contains("checkDexOptExist failed")) || (paramThrowable.getMessage().contains("checkDexOptFormat failed")))
    {
      wVZ = true;
      paramFile = paramList.iterator();
    }
    while (paramFile.hasNext())
    {
      SharePatchFileUtil.ah((File)paramFile.next());
      continue;
      com.tencent.tinker.lib.e.a.hN(this.context).Z(paramFile);
    }
  }
  
  public void a(File paramFile, boolean paramBoolean, long paramLong)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchResult: patch all result path: %s, success: %b, cost: %d", new Object[] { paramFile.getAbsolutePath(), Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    if (!wVZ)
    {
      paramFile = c.hS(this.context);
      if (paramFile.wWO) {
        break label65;
      }
      com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchServiceResult retry disabled, just return", new Object[0]);
    }
    label65:
    while (!paramFile.wWQ.exists()) {
      return;
    }
    SharePatchFileUtil.ah(paramFile.wWQ);
  }
  
  public void d(File paramFile, int paramInt)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchPackageCheckFail: package check failed. path: %s, code: %d", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramInt) });
    if ((paramInt == -3) || (paramInt == -4) || (paramInt == -8)) {
      com.tencent.tinker.lib.e.a.hN(this.context).Z(paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tinker.lib.d.b
 * JD-Core Version:    0.7.0.1
 */