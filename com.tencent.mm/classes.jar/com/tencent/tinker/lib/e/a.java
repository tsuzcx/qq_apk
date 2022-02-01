package com.tencent.tinker.lib.e;

import android.content.Context;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

public class a
{
  private static a ahRE;
  static boolean sInstalled = false;
  public final File ahRF;
  public final com.tencent.tinker.lib.b.b ahRG;
  public final com.tencent.tinker.lib.d.c ahRH;
  public final com.tencent.tinker.lib.d.d ahRI;
  public final File ahRJ;
  public final File ahRK;
  public final boolean ahRL;
  public d ahRM;
  public boolean ahRN = false;
  final Context context;
  public final boolean rgc;
  public int tinkerFlags;
  final boolean tinkerLoadVerifyFlag;
  
  private a(Context paramContext, int paramInt, com.tencent.tinker.lib.d.c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.context = paramContext;
    this.ahRG = paramb;
    this.ahRH = paramc;
    this.ahRI = paramd;
    this.tinkerFlags = paramInt;
    this.ahRF = paramFile1;
    this.ahRJ = paramFile2;
    this.ahRK = paramFile3;
    this.rgc = paramBoolean1;
    this.tinkerLoadVerifyFlag = paramBoolean3;
    this.ahRL = paramBoolean2;
  }
  
  public static void a(a parama)
  {
    if (ahRE != null) {
      throw new TinkerRuntimeException("Tinker instance is already set.");
    }
    ahRE = parama;
  }
  
  private void bGm(String paramString)
  {
    if ((this.ahRF == null) || (paramString == null)) {
      return;
    }
    SharePatchFileUtil.deleteDir(this.ahRF.getAbsolutePath() + "/" + paramString);
  }
  
  public static a oy(Context paramContext)
  {
    if (!sInstalled) {
      throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }
    try
    {
      if (ahRE == null) {
        ahRE = new a(paramContext).kcg();
      }
      return ahRE;
    }
    finally {}
  }
  
  public final void ac(File paramFile)
  {
    if ((this.ahRF == null) || (paramFile == null) || (!paramFile.exists())) {
      return;
    }
    bGm(SharePatchFileUtil.getPatchVersionDirectory(SharePatchFileUtil.getMD5(paramFile)));
  }
  
  public final void fQd()
  {
    if (this.ahRF == null) {}
    File localFile1;
    File localFile2;
    SharePatchInfo localSharePatchInfo;
    do
    {
      return;
      localFile1 = SharePatchFileUtil.getPatchInfoFile(this.ahRF.getAbsolutePath());
      if (!localFile1.exists())
      {
        ShareTinkerLog.printErrStackTrace("Tinker.Tinker", new Throwable(), "try to clean patch while patch info file does not exist.", new Object[0]);
        return;
      }
      localFile2 = SharePatchFileUtil.getPatchInfoLockFile(this.ahRF.getAbsolutePath());
      localSharePatchInfo = SharePatchInfo.readAndCheckPropertyWithLock(localFile1, localFile2);
    } while (localSharePatchInfo == null);
    localSharePatchInfo.isRemoveNewVersion = true;
    SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, localSharePatchInfo, localFile2);
  }
  
  public final boolean isMainProcess()
  {
    return this.rgc;
  }
  
  public final d kce()
  {
    return this.ahRM;
  }
  
  public final boolean kcf()
  {
    return ShareTinkerInternals.isTinkerEnabled(this.tinkerFlags);
  }
  
  public static final class a
  {
    private File ahRF;
    com.tencent.tinker.lib.b.b ahRG;
    com.tencent.tinker.lib.d.c ahRH;
    com.tencent.tinker.lib.d.d ahRI;
    private File ahRJ;
    private File ahRK;
    private final boolean ahRO;
    private final boolean ahRP;
    Boolean ahRQ;
    private final Context context;
    int status = -1;
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        throw new TinkerRuntimeException("Context must not be null.");
      }
      this.context = paramContext;
      this.ahRO = com.tencent.tinker.lib.f.c.isInMainProcess(paramContext);
      this.ahRP = com.tencent.tinker.lib.f.c.oC(paramContext);
      this.ahRF = SharePatchFileUtil.getPatchDirectory(paramContext);
      if (this.ahRF == null)
      {
        ShareTinkerLog.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
        return;
      }
      this.ahRJ = SharePatchFileUtil.getPatchInfoFile(this.ahRF.getAbsolutePath());
      this.ahRK = SharePatchFileUtil.getPatchInfoLockFile(this.ahRF.getAbsolutePath());
      ShareTinkerLog.w("Tinker.Tinker", "tinker patch directory: %s", new Object[] { this.ahRF });
    }
    
    public final a kcg()
    {
      if (this.status == -1) {
        this.status = 15;
      }
      if (this.ahRH == null) {
        this.ahRH = new com.tencent.tinker.lib.d.a(this.context);
      }
      if (this.ahRI == null) {
        this.ahRI = new com.tencent.tinker.lib.d.b(this.context);
      }
      if (this.ahRG == null) {
        this.ahRG = new com.tencent.tinker.lib.b.a(this.context);
      }
      if (this.ahRQ == null) {
        this.ahRQ = Boolean.FALSE;
      }
      return new a(this.context, this.status, this.ahRH, this.ahRI, this.ahRG, this.ahRF, this.ahRJ, this.ahRK, this.ahRO, this.ahRP, this.ahRQ.booleanValue(), (byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.lib.e.a
 * JD-Core Version:    0.7.0.1
 */