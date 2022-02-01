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
  private static a MgS;
  public static boolean sInstalled = false;
  public final boolean AEC;
  public final File MgT;
  final com.tencent.tinker.lib.b.b MgU;
  public final c MgV;
  public final com.tencent.tinker.lib.d.d MgW;
  public final File MgX;
  public final File MgY;
  public final boolean MgZ;
  public d Mha;
  public boolean Mhb = false;
  public final Context context;
  public int tinkerFlags;
  final boolean tinkerLoadVerifyFlag;
  
  private a(Context paramContext, int paramInt, c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.context = paramContext;
    this.MgU = paramb;
    this.MgV = paramc;
    this.MgW = paramd;
    this.tinkerFlags = paramInt;
    this.MgT = paramFile1;
    this.MgX = paramFile2;
    this.MgY = paramFile3;
    this.AEC = paramBoolean1;
    this.tinkerLoadVerifyFlag = paramBoolean3;
    this.MgZ = paramBoolean2;
  }
  
  public static void a(a parama)
  {
    if (MgS != null) {
      throw new TinkerRuntimeException("Tinker instance is already set.");
    }
    MgS = parama;
  }
  
  private void aZQ(String paramString)
  {
    if ((this.MgT == null) || (paramString == null)) {
      return;
    }
    SharePatchFileUtil.deleteDir(this.MgT.getAbsolutePath() + "/" + paramString);
  }
  
  public static a lk(Context paramContext)
  {
    if (!sInstalled) {
      throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }
    try
    {
      if (MgS == null) {
        MgS = new a(paramContext).fYB();
      }
      return MgS;
    }
    finally {}
  }
  
  public final void ad(File paramFile)
  {
    if ((this.MgT == null) || (paramFile == null) || (!paramFile.exists())) {
      return;
    }
    aZQ(SharePatchFileUtil.getPatchVersionDirectory(SharePatchFileUtil.getMD5(paramFile)));
  }
  
  public final void dcB()
  {
    if (this.MgT == null) {}
    File localFile1;
    File localFile2;
    SharePatchInfo localSharePatchInfo;
    do
    {
      return;
      localFile1 = SharePatchFileUtil.getPatchInfoFile(this.MgT.getAbsolutePath());
      if (!localFile1.exists())
      {
        ShareTinkerLog.w("Tinker.Tinker", "try to clean patch while patch info file does not exist.", new Object[0]);
        return;
      }
      localFile2 = SharePatchFileUtil.getPatchInfoLockFile(this.MgT.getAbsolutePath());
      localSharePatchInfo = SharePatchInfo.readAndCheckPropertyWithLock(localFile1, localFile2);
    } while (localSharePatchInfo == null);
    localSharePatchInfo.isRemoveNewVersion = true;
    SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, localSharePatchInfo, localFile2);
  }
  
  public final com.tencent.tinker.lib.b.b fYA()
  {
    return this.MgU;
  }
  
  public final d fYw()
  {
    return this.Mha;
  }
  
  public final boolean fYx()
  {
    return this.Mhb;
  }
  
  public final File fYy()
  {
    return this.MgX;
  }
  
  public final File fYz()
  {
    return this.MgY;
  }
  
  public static final class a
  {
    private File MgT;
    public com.tencent.tinker.lib.b.b MgU;
    public c MgV;
    public com.tencent.tinker.lib.d.d MgW;
    private File MgX;
    private File MgY;
    private final boolean Mhc;
    private final boolean Mhd;
    public Boolean Mhe;
    private final Context context;
    public int status = -1;
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        throw new TinkerRuntimeException("Context must not be null.");
      }
      this.context = paramContext;
      this.Mhc = com.tencent.tinker.lib.util.b.isInMainProcess(paramContext);
      this.Mhd = com.tencent.tinker.lib.util.b.lo(paramContext);
      this.MgT = SharePatchFileUtil.getPatchDirectory(paramContext);
      if (this.MgT == null)
      {
        ShareTinkerLog.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
        return;
      }
      this.MgX = SharePatchFileUtil.getPatchInfoFile(this.MgT.getAbsolutePath());
      this.MgY = SharePatchFileUtil.getPatchInfoLockFile(this.MgT.getAbsolutePath());
      ShareTinkerLog.w("Tinker.Tinker", "tinker patch directory: %s", new Object[] { this.MgT });
    }
    
    public final a fYB()
    {
      if (this.status == -1) {
        this.status = 15;
      }
      if (this.MgV == null) {
        this.MgV = new com.tencent.tinker.lib.d.a(this.context);
      }
      if (this.MgW == null) {
        this.MgW = new com.tencent.tinker.lib.d.b(this.context);
      }
      if (this.MgU == null) {
        this.MgU = new com.tencent.tinker.lib.b.a(this.context);
      }
      if (this.Mhe == null) {
        this.Mhe = Boolean.FALSE;
      }
      return new a(this.context, this.status, this.MgV, this.MgW, this.MgU, this.MgT, this.MgX, this.MgY, this.Mhc, this.Mhd, this.Mhe.booleanValue(), (byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.e.a
 * JD-Core Version:    0.7.0.1
 */