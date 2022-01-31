package com.tencent.tinker.lib.d;

import android.content.Context;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.f.c.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class a
  implements c
{
  public final Context context;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void a(File paramFile, int paramInt)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch load Reporter onLoadFileMd5Mismatch: patch file md5 mismatch file: %s, fileType: %d", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramInt) });
    cQF();
  }
  
  public void a(File paramFile, int paramInt, long paramLong)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadResult: patch load result, path:%s, code: %d, cost: %dms", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramInt), Long.valueOf(paramLong) });
  }
  
  public void a(File paramFile, int paramInt, boolean paramBoolean)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType: %d, isDirectory: %b", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (paramInt == 4)
    {
      cQG();
      return;
    }
    cQF();
  }
  
  public void a(String paramString1, String paramString2, File paramFile)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchInfoCorrupted: patch info file damage: %s, from version: %s to version: %s", new Object[] { paramFile.getAbsolutePath(), paramString1, paramString2 });
    cQF();
  }
  
  public void a(String paramString1, String paramString2, File paramFile, String paramString3)
  {
    int i = 0;
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchVersionChanged: patch version change from " + paramString1 + " to " + paramString2, new Object[0]);
    if ((paramString1 == null) || (paramString2 == null)) {
      break label45;
    }
    label45:
    while ((paramString1.equals(paramString2)) || (!com.tencent.tinker.lib.e.a.hN(this.context).prD)) {
      return;
    }
    paramString1 = com.tencent.tinker.lib.f.c.hS(this.context);
    if (!paramString1.wWO) {
      com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry disabled, just return", new Object[0]);
    }
    for (;;)
    {
      paramString1 = paramFile.listFiles();
      if (paramString1 == null) {
        break;
      }
      int j = paramString1.length;
      while (i < j)
      {
        paramString2 = paramString1[i];
        paramFile = paramString2.getName();
        if ((paramString2.isDirectory()) && (!paramFile.equals(paramString3))) {
          SharePatchFileUtil.k(paramString2);
        }
        i += 1;
      }
      break label45;
      if (!paramString1.wWP.exists())
      {
        com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry file is not exist, just return", new Object[0]);
      }
      else if (paramString2 == null)
      {
        com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck md5 is null, just return", new Object[0]);
      }
      else
      {
        c.a locala = c.a.ab(paramString1.wWP);
        if (paramString2.equals(locala.bIW))
        {
          com.tencent.tinker.lib.f.a.i("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck, reset max check to 1", new Object[0]);
          locala.wWS = "1";
          c.a.a(paramString1.wWP, locala);
        }
      }
    }
  }
  
  public void a(Throwable paramThrowable, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      com.tencent.tinker.lib.f.a.e("Tinker.DefaultLoadReporter", "tinker load exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
      com.tencent.tinker.lib.f.a.printErrStackTrace("Tinker.DefaultLoadReporter", paramThrowable, "tinker load exception", new Object[0]);
      com.tencent.tinker.lib.e.a.hN(this.context).tinkerFlags = 0;
      cQF();
      return;
      if (paramThrowable.getMessage().contains("checkDexInstall failed")) {
        com.tencent.tinker.lib.f.a.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: tinker dex check fail:" + paramThrowable.getMessage(), new Object[0]);
      }
      for (;;)
      {
        ShareTinkerInternals.ic(this.context);
        com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "dex exception disable tinker forever with sp", new Object[0]);
        break;
        com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load dex exception: %s", new Object[] { paramThrowable });
      }
      if (paramThrowable.getMessage().contains("checkResInstall failed")) {
        com.tencent.tinker.lib.f.a.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: tinker res check fail:" + paramThrowable.getMessage(), new Object[0]);
      }
      for (;;)
      {
        ShareTinkerInternals.ic(this.context);
        com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "res exception disable tinker forever with sp", new Object[0]);
        break;
        com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load resource exception: %s", new Object[] { paramThrowable });
      }
      com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load unCatch exception: %s", new Object[] { paramThrowable });
      ShareTinkerInternals.ic(this.context);
      com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "unCaught exception disable tinker forever with sp", new Object[0]);
      String str = SharePatchFileUtil.ia(this.context);
      if (!ShareTinkerInternals.bl(str))
      {
        SharePatchFileUtil.ah(SharePatchFileUtil.hZ(this.context));
        com.tencent.tinker.lib.f.a.e("Tinker.DefaultLoadReporter", "tinker uncaught real exception:" + str, new Object[0]);
        continue;
        com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load unknown exception: %s", new Object[] { paramThrowable });
      }
    }
  }
  
  public void b(int paramInt, Throwable paramThrowable)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", new Object[] { Integer.valueOf(paramInt), paramThrowable });
    switch (paramInt)
    {
    }
    for (;;)
    {
      cQG();
      return;
      com.tencent.tinker.lib.f.a.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
      continue;
      com.tencent.tinker.lib.f.a.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
      continue;
      com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret ok", new Object[0]);
    }
  }
  
  public void b(File paramFile, int paramInt)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPackageCheckFail: load patch package check fail file path: %s, errorCode: %d", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramInt) });
    cQF();
  }
  
  public void c(File paramFile, int paramInt)
  {
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchListenerReceiveFail: patch receive fail: %s, code: %d", new Object[] { paramFile.getAbsolutePath(), Integer.valueOf(paramInt) });
  }
  
  public final void cQF()
  {
    com.tencent.tinker.lib.e.a locala = com.tencent.tinker.lib.e.a.hN(this.context);
    if (locala.prD)
    {
      Object localObject = locala.wWq;
      if (((d)localObject).wWx)
      {
        localObject = ((d)localObject).patchInfo;
        if ((localObject != null) && (!ShareTinkerInternals.bl(((SharePatchInfo)localObject).wZr)))
        {
          com.tencent.tinker.lib.f.a.w("Tinker.DefaultLoadReporter", "checkAndCleanPatch, oldVersion %s is not null, try kill all other process", new Object[] { ((SharePatchInfo)localObject).wZr });
          ShareTinkerInternals.ig(this.context);
        }
      }
    }
    locala.bbj();
  }
  
  public final boolean cQG()
  {
    Object localObject = com.tencent.tinker.lib.e.a.hN(this.context);
    if (!((com.tencent.tinker.lib.e.a)localObject).prD) {}
    do
    {
      return false;
      localObject = ((com.tencent.tinker.lib.e.a)localObject).wWq.wWB;
    } while ((localObject == null) || (!com.tencent.tinker.lib.f.c.hS(this.context).age(SharePatchFileUtil.ai((File)localObject))));
    com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "try to repair oat file on patch process", new Object[0]);
    com.tencent.tinker.lib.e.c.bR(this.context, ((File)localObject).getAbsolutePath());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.lib.d.a
 * JD-Core Version:    0.7.0.1
 */