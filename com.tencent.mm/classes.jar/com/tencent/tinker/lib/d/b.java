package com.tencent.tinker.lib.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.lib.f.d.a;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class b
  implements d
{
  private static boolean ahRv = false;
  protected final Context context;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void a(File paramFile, SharePatchInfo paramSharePatchInfo, String paramString)
  {
    ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchVersionCheckFail: patch version exist. path: %s, version: %s", new Object[] { paramFile.getAbsolutePath(), paramString });
  }
  
  public void a(File paramFile1, File paramFile2, String paramString, int paramInt)
  {
    ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchTypeExtractFail: file extract fail type: %s, path: %s, extractTo: %s, filename: %s", new Object[] { ShareTinkerInternals.getTypeString(paramInt), paramFile1.getPath(), paramFile2.getPath(), paramString });
    a.oy(this.context).ac(paramFile1);
  }
  
  public void a(File paramFile, Throwable paramThrowable)
  {
    ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchException: patch exception path: %s, throwable: %s", new Object[] { paramFile.getAbsolutePath(), paramThrowable.getMessage() });
    ShareTinkerLog.e("Tinker.DefaultPatchReporter", "tinker patch exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
    ShareTinkerLog.printErrStackTrace("Tinker.DefaultPatchReporter", paramThrowable, "tinker patch exception", new Object[0]);
    a.oy(this.context).tinkerFlags = 0;
    a.oy(this.context).ac(paramFile);
  }
  
  public void a(File paramFile, List<File> paramList, Throwable paramThrowable)
  {
    ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchDexOptFail: dex opt fail path: %s, dex size: %d", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramList.size()) });
    ShareTinkerLog.printErrStackTrace("Tinker.DefaultPatchReporter", paramThrowable, "onPatchDexOptFail:", new Object[0]);
    if ((paramThrowable.getMessage().contains("checkDexOptExist failed")) || (paramThrowable.getMessage().contains("checkDexOptFormat failed")))
    {
      ahRv = true;
      paramFile = paramList.iterator();
    }
    while (paramFile.hasNext())
    {
      SharePatchFileUtil.safeDeleteFile((File)paramFile.next());
      continue;
      a.oy(this.context).ac(paramFile);
    }
  }
  
  public void a(File paramFile, boolean paramBoolean, long paramLong)
  {
    ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchResult: patch all result path: %s, success: %b, cost: %d", new Object[] { paramFile.getAbsolutePath(), Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    if (!ahRv)
    {
      paramFile = com.tencent.tinker.lib.f.d.oD(this.context);
      if (paramFile.ahSg) {
        break label65;
      }
      ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceResult retry disabled, just return", new Object[0]);
    }
    label65:
    while (!paramFile.ahSi.exists()) {
      return;
    }
    SharePatchFileUtil.safeDeleteFile(paramFile.ahSi);
  }
  
  public void aW(Intent paramIntent)
  {
    ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchServiceStart: patch service start", new Object[0]);
    ahRv = false;
    com.tencent.tinker.lib.f.d locald = com.tencent.tinker.lib.f.d.oD(this.context);
    if (!locald.ahSg)
    {
      ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry disabled, just return", new Object[0]);
      return;
    }
    if (paramIntent == null)
    {
      ShareTinkerLog.e("Tinker.UpgradePatchRetry", "onPatchServiceStart intent is null, just return", new Object[0]);
      return;
    }
    paramIntent = TinkerPatchService.ct(paramIntent);
    if (paramIntent == null)
    {
      ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch path is null, just return", new Object[0]);
      return;
    }
    File localFile = new File(paramIntent);
    String str = SharePatchFileUtil.getMD5(localFile);
    if (str == null)
    {
      ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch md5 is null, just return", new Object[0]);
      return;
    }
    if (locald.ahSh.exists())
    {
      paramIntent = d.a.ae(locald.ahSh);
      if ((paramIntent.md5 == null) || (paramIntent.ahSj == null) || (!str.equals(paramIntent.md5)))
      {
        locald.ad(localFile);
        paramIntent.md5 = str;
        paramIntent.ahSj = "1";
      }
    }
    for (;;)
    {
      d.a.a(locald.ahSh, paramIntent);
      return;
      int i = Integer.parseInt(paramIntent.ahSj);
      if (i >= locald.Jmi)
      {
        SharePatchFileUtil.safeDeleteFile(locald.ahSi);
        ShareTinkerLog.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry more than max count, delete retry info file!", new Object[0]);
        return;
      }
      paramIntent.ahSj = String.valueOf(i + 1);
      continue;
      locald.ad(localFile);
      paramIntent = new d.a(str, "1");
    }
  }
  
  public void b(File paramFile, String paramString1, String paramString2)
  {
    ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchInfoCorrupted: patch info is corrupted. old: %s, new: %s", new Object[] { paramString1, paramString2 });
    a.oy(this.context).fQd();
  }
  
  public void h(File paramFile, int paramInt)
  {
    ShareTinkerLog.i("Tinker.DefaultPatchReporter", "patchReporter onPatchPackageCheckFail: package check failed. path: %s, code: %d", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramInt) });
    if ((paramInt == -3) || (paramInt == -4) || (paramInt == -8)) {
      a.oy(this.context).ac(paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.d.b
 * JD-Core Version:    0.7.0.1
 */