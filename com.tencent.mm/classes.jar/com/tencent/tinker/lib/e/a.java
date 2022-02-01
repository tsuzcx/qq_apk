package com.tencent.tinker.lib.e;

import android.content.Context;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

public class a
{
  private static a ZMC;
  public static boolean sInstalled = false;
  public final boolean LvD;
  public final File ZMD;
  final com.tencent.tinker.lib.b.b ZME;
  public final c ZMF;
  public final com.tencent.tinker.lib.d.d ZMG;
  public final File ZMH;
  public final File ZMI;
  public final boolean ZMJ;
  public d ZMK;
  public boolean ZML = false;
  public final Context context;
  public int tinkerFlags;
  final boolean tinkerLoadVerifyFlag;
  
  private a(Context paramContext, int paramInt, c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.context = paramContext;
    this.ZME = paramb;
    this.ZMF = paramc;
    this.ZMG = paramd;
    this.tinkerFlags = paramInt;
    this.ZMD = paramFile1;
    this.ZMH = paramFile2;
    this.ZMI = paramFile3;
    this.LvD = paramBoolean1;
    this.tinkerLoadVerifyFlag = paramBoolean3;
    this.ZMJ = paramBoolean2;
  }
  
  public static void a(a parama)
  {
    if (ZMC != null) {
      throw new TinkerRuntimeException("Tinker instance is already set.");
    }
    ZMC = parama;
  }
  
  private void bDG(String paramString)
  {
    if ((this.ZMD == null) || (paramString == null)) {
      return;
    }
    SharePatchFileUtil.deleteDir(this.ZMD.getAbsolutePath() + "/" + paramString);
  }
  
  public static a mi(Context paramContext)
  {
    if (!sInstalled) {
      throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }
    try
    {
      if (ZMC == null) {
        ZMC = new a(paramContext).isJ();
      }
      return ZMC;
    }
    finally {}
  }
  
  public final void Y(File paramFile)
  {
    if ((this.ZMD == null) || (paramFile == null) || (!paramFile.exists())) {
      return;
    }
    bDG(SharePatchFileUtil.getPatchVersionDirectory(SharePatchFileUtil.getMD5(paramFile)));
  }
  
  public final void eIk()
  {
    if (this.ZMD == null) {}
    File localFile1;
    File localFile2;
    SharePatchInfo localSharePatchInfo;
    do
    {
      return;
      localFile1 = SharePatchFileUtil.getPatchInfoFile(this.ZMD.getAbsolutePath());
      if (!localFile1.exists())
      {
        ShareTinkerLog.w("Tinker.Tinker", "try to clean patch while patch info file does not exist.", new Object[0]);
        return;
      }
      localFile2 = SharePatchFileUtil.getPatchInfoLockFile(this.ZMD.getAbsolutePath());
      localSharePatchInfo = SharePatchInfo.readAndCheckPropertyWithLock(localFile1, localFile2);
    } while (localSharePatchInfo == null);
    localSharePatchInfo.isRemoveNewVersion = true;
    SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, localSharePatchInfo, localFile2);
  }
  
  public final d isE()
  {
    return this.ZMK;
  }
  
  public final boolean isF()
  {
    return this.ZML;
  }
  
  public final File isG()
  {
    return this.ZMH;
  }
  
  public final File isH()
  {
    return this.ZMI;
  }
  
  public final com.tencent.tinker.lib.b.b isI()
  {
    return this.ZME;
  }
  
  public static final class a
  {
    private File ZMD;
    public com.tencent.tinker.lib.b.b ZME;
    public c ZMF;
    public com.tencent.tinker.lib.d.d ZMG;
    private File ZMH;
    private File ZMI;
    private final boolean ZMM;
    private final boolean ZMN;
    public Boolean ZMO;
    private final Context context;
    public int status = -1;
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        throw new TinkerRuntimeException("Context must not be null.");
      }
      this.context = paramContext;
      this.ZMM = com.tencent.tinker.lib.f.b.isInMainProcess(paramContext);
      this.ZMN = com.tencent.tinker.lib.f.b.mm(paramContext);
      this.ZMD = SharePatchFileUtil.getPatchDirectory(paramContext);
      if (this.ZMD == null)
      {
        ShareTinkerLog.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
        return;
      }
      this.ZMH = SharePatchFileUtil.getPatchInfoFile(this.ZMD.getAbsolutePath());
      this.ZMI = SharePatchFileUtil.getPatchInfoLockFile(this.ZMD.getAbsolutePath());
      ShareTinkerLog.w("Tinker.Tinker", "tinker patch directory: %s", new Object[] { this.ZMD });
    }
    
    public final a isJ()
    {
      if (this.status == -1) {
        this.status = 15;
      }
      if (this.ZMF == null) {
        this.ZMF = new com.tencent.tinker.lib.d.a(this.context);
      }
      if (this.ZMG == null) {
        this.ZMG = new com.tencent.tinker.lib.d.b(this.context);
      }
      if (this.ZME == null) {
        this.ZME = new com.tencent.tinker.lib.b.a(this.context);
      }
      if (this.ZMO == null) {
        this.ZMO = Boolean.FALSE;
      }
      return new a(this.context, this.status, this.ZMF, this.ZMG, this.ZME, this.ZMD, this.ZMH, this.ZMI, this.ZMM, this.ZMN, this.ZMO.booleanValue(), (byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.lib.e.a
 * JD-Core Version:    0.7.0.1
 */