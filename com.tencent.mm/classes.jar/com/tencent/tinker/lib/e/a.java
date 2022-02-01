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
  private static a MDP;
  public static boolean sInstalled = false;
  public final boolean AWf;
  public final File MDQ;
  final com.tencent.tinker.lib.b.b MDR;
  public final c MDS;
  public final com.tencent.tinker.lib.d.d MDT;
  public final File MDU;
  public final File MDV;
  public final boolean MDW;
  public d MDX;
  public boolean MDY = false;
  public final Context context;
  public int tinkerFlags;
  final boolean tinkerLoadVerifyFlag;
  
  private a(Context paramContext, int paramInt, c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.context = paramContext;
    this.MDR = paramb;
    this.MDS = paramc;
    this.MDT = paramd;
    this.tinkerFlags = paramInt;
    this.MDQ = paramFile1;
    this.MDU = paramFile2;
    this.MDV = paramFile3;
    this.AWf = paramBoolean1;
    this.tinkerLoadVerifyFlag = paramBoolean3;
    this.MDW = paramBoolean2;
  }
  
  public static void a(a parama)
  {
    if (MDP != null) {
      throw new TinkerRuntimeException("Tinker instance is already set.");
    }
    MDP = parama;
  }
  
  private void bbt(String paramString)
  {
    if ((this.MDQ == null) || (paramString == null)) {
      return;
    }
    SharePatchFileUtil.deleteDir(this.MDQ.getAbsolutePath() + "/" + paramString);
  }
  
  public static a lq(Context paramContext)
  {
    if (!sInstalled) {
      throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }
    try
    {
      if (MDP == null) {
        MDP = new a(paramContext).gda();
      }
      return MDP;
    }
    finally {}
  }
  
  public final void ac(File paramFile)
  {
    if ((this.MDQ == null) || (paramFile == null) || (!paramFile.exists())) {
      return;
    }
    bbt(SharePatchFileUtil.getPatchVersionDirectory(SharePatchFileUtil.getMD5(paramFile)));
  }
  
  public final void dft()
  {
    if (this.MDQ == null) {}
    File localFile1;
    File localFile2;
    SharePatchInfo localSharePatchInfo;
    do
    {
      return;
      localFile1 = SharePatchFileUtil.getPatchInfoFile(this.MDQ.getAbsolutePath());
      if (!localFile1.exists())
      {
        ShareTinkerLog.w("Tinker.Tinker", "try to clean patch while patch info file does not exist.", new Object[0]);
        return;
      }
      localFile2 = SharePatchFileUtil.getPatchInfoLockFile(this.MDQ.getAbsolutePath());
      localSharePatchInfo = SharePatchInfo.readAndCheckPropertyWithLock(localFile1, localFile2);
    } while (localSharePatchInfo == null);
    localSharePatchInfo.isRemoveNewVersion = true;
    SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, localSharePatchInfo, localFile2);
  }
  
  public final d gcV()
  {
    return this.MDX;
  }
  
  public final boolean gcW()
  {
    return this.MDY;
  }
  
  public final File gcX()
  {
    return this.MDU;
  }
  
  public final File gcY()
  {
    return this.MDV;
  }
  
  public final com.tencent.tinker.lib.b.b gcZ()
  {
    return this.MDR;
  }
  
  public static final class a
  {
    private File MDQ;
    public com.tencent.tinker.lib.b.b MDR;
    public c MDS;
    public com.tencent.tinker.lib.d.d MDT;
    private File MDU;
    private File MDV;
    private final boolean MDZ;
    private final boolean MEa;
    public Boolean MEb;
    private final Context context;
    public int status = -1;
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        throw new TinkerRuntimeException("Context must not be null.");
      }
      this.context = paramContext;
      this.MDZ = com.tencent.tinker.lib.util.b.isInMainProcess(paramContext);
      this.MEa = com.tencent.tinker.lib.util.b.lu(paramContext);
      this.MDQ = SharePatchFileUtil.getPatchDirectory(paramContext);
      if (this.MDQ == null)
      {
        ShareTinkerLog.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
        return;
      }
      this.MDU = SharePatchFileUtil.getPatchInfoFile(this.MDQ.getAbsolutePath());
      this.MDV = SharePatchFileUtil.getPatchInfoLockFile(this.MDQ.getAbsolutePath());
      ShareTinkerLog.w("Tinker.Tinker", "tinker patch directory: %s", new Object[] { this.MDQ });
    }
    
    public final a gda()
    {
      if (this.status == -1) {
        this.status = 15;
      }
      if (this.MDS == null) {
        this.MDS = new com.tencent.tinker.lib.d.a(this.context);
      }
      if (this.MDT == null) {
        this.MDT = new com.tencent.tinker.lib.d.b(this.context);
      }
      if (this.MDR == null) {
        this.MDR = new com.tencent.tinker.lib.b.a(this.context);
      }
      if (this.MEb == null) {
        this.MEb = Boolean.FALSE;
      }
      return new a(this.context, this.status, this.MDS, this.MDT, this.MDR, this.MDQ, this.MDU, this.MDV, this.MDZ, this.MEa, this.MEb.booleanValue(), (byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.e.a
 * JD-Core Version:    0.7.0.1
 */