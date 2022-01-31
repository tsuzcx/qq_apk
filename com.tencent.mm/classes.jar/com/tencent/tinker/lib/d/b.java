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
  private static boolean BsE = false;
  protected final Context context;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void a(File paramFile, SharePatchInfo paramSharePatchInfo, String paramString)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchVersionCheckFail: patch version exist. path: %s, version: %s", new Object[] { paramFile.getAbsolutePath(), paramString });
  }
  
  public void a(File paramFile1, File paramFile2, String paramString, int paramInt)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchTypeExtractFail: file extract fail type: %s, path: %s, extractTo: %s, filename: %s", new Object[] { ShareTinkerInternals.Th(paramInt), paramFile1.getPath(), paramFile2.getPath(), paramString });
    com.tencent.tinker.lib.e.a.jo(this.context).ai(paramFile1);
  }
  
  public void a(File paramFile, String paramString1, String paramString2)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchInfoCorrupted: patch info is corrupted. old: %s, new: %s", new Object[] { paramString1, paramString2 });
    com.tencent.tinker.lib.e.a.jo(this.context).bIo();
  }
  
  public void a(File paramFile, Throwable paramThrowable)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchException: patch exception path: %s, throwable: %s", new Object[] { paramFile.getAbsolutePath(), paramThrowable.getMessage() });
    com.tencent.tinker.lib.f.a.e("Tinker.DefaultPatchReporter", "tinker patch exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
    com.tencent.tinker.lib.f.a.printErrStackTrace("Tinker.DefaultPatchReporter", paramThrowable, "tinker patch exception", new Object[0]);
    com.tencent.tinker.lib.e.a.jo(this.context).tinkerFlags = 0;
    com.tencent.tinker.lib.e.a.jo(this.context).ai(paramFile);
  }
  
  public void a(File paramFile, List<File> paramList, Throwable paramThrowable)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchDexOptFail: dex opt fail path: %s, dex size: %d", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramList.size()) });
    com.tencent.tinker.lib.f.a.printErrStackTrace("Tinker.DefaultPatchReporter", paramThrowable, "onPatchDexOptFail:", new Object[0]);
    if ((paramThrowable.getMessage().contains("checkDexOptExist failed")) || (paramThrowable.getMessage().contains("checkDexOptFormat failed")))
    {
      BsE = true;
      paramFile = paramList.iterator();
    }
    while (paramFile.hasNext())
    {
      SharePatchFileUtil.aq((File)paramFile.next());
      continue;
      com.tencent.tinker.lib.e.a.jo(this.context).ai(paramFile);
    }
  }
  
  public void a(File paramFile, boolean paramBoolean, long paramLong)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchResult: patch all result path: %s, success: %b, cost: %d", new Object[] { paramFile.getAbsolutePath(), Boolean.valueOf(paramBoolean), Long.valueOf(paramLong) });
    if (!BsE)
    {
      paramFile = c.jt(this.context);
      if (paramFile.Btr) {
        break label65;
      }
      com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchServiceResult retry disabled, just return", new Object[0]);
    }
    label65:
    while (!paramFile.Btt.exists()) {
      return;
    }
    SharePatchFileUtil.aq(paramFile.Btt);
  }
  
  public void ac(Intent paramIntent)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchServiceStart: patch service start", new Object[0]);
    BsE = false;
    c localc = c.jt(this.context);
    if (!localc.Btr)
    {
      com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry disabled, just return", new Object[0]);
      return;
    }
    if (paramIntent == null)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatchRetry", "onPatchServiceStart intent is null, just return", new Object[0]);
      return;
    }
    paramIntent = TinkerPatchService.aZ(paramIntent);
    if (paramIntent == null)
    {
      com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch path is null, just return", new Object[0]);
      return;
    }
    File localFile = new File(paramIntent);
    String str = SharePatchFileUtil.q(localFile);
    if (str == null)
    {
      com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch md5 is null, just return", new Object[0]);
      return;
    }
    if (localc.Bts.exists())
    {
      paramIntent = c.a.ak(localc.Bts);
      if ((paramIntent.cqq == null) || (paramIntent.Btv == null) || (!str.equals(paramIntent.cqq)))
      {
        localc.aj(localFile);
        paramIntent.cqq = str;
        paramIntent.Btv = "1";
      }
    }
    for (;;)
    {
      c.a.a(localc.Bts, paramIntent);
      return;
      int i = Integer.parseInt(paramIntent.Btv);
      if (i >= localc.Btu)
      {
        SharePatchFileUtil.aq(localc.Btt);
        com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry more than max count, delete retry info file!", new Object[0]);
        return;
      }
      paramIntent.Btv = String.valueOf(i + 1);
      continue;
      localc.aj(localFile);
      paramIntent = new c.a(str, "1");
    }
  }
  
  public void e(File paramFile, int paramInt)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchPackageCheckFail: package check failed. path: %s, code: %d", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramInt) });
    if ((paramInt == -3) || (paramInt == -4) || (paramInt == -8)) {
      com.tencent.tinker.lib.e.a.jo(this.context).ai(paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tinker.lib.d.b
 * JD-Core Version:    0.7.0.1
 */