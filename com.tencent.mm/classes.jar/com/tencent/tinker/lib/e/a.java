package com.tencent.tinker.lib.e;

import android.content.Context;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;

public class a
{
  private static a IEI;
  public static boolean sInstalled = false;
  public final File IEJ;
  final com.tencent.tinker.lib.b.b IEK;
  public final c IEL;
  public final com.tencent.tinker.lib.d.d IEM;
  public final File IEN;
  public final File IEO;
  public final boolean IEP;
  public d IEQ;
  public boolean IER = false;
  public final Context context;
  public int tinkerFlags;
  final boolean tinkerLoadVerifyFlag;
  public final boolean xZI;
  
  private a(Context paramContext, int paramInt, c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.context = paramContext;
    this.IEK = paramb;
    this.IEL = paramc;
    this.IEM = paramd;
    this.tinkerFlags = paramInt;
    this.IEJ = paramFile1;
    this.IEN = paramFile2;
    this.IEO = paramFile3;
    this.xZI = paramBoolean1;
    this.tinkerLoadVerifyFlag = paramBoolean3;
    this.IEP = paramBoolean2;
  }
  
  public static void a(a parama)
  {
    if (IEI != null) {
      throw new TinkerRuntimeException("Tinker instance is already set.");
    }
    IEI = parama;
  }
  
  private void aOh(String paramString)
  {
    if ((this.IEJ == null) || (paramString == null)) {
      return;
    }
    SharePatchFileUtil.deleteDir(this.IEJ.getAbsolutePath() + "/" + paramString);
  }
  
  public static a kI(Context paramContext)
  {
    if (!sInstalled) {
      throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }
    try
    {
      if (IEI == null) {
        IEI = new a(paramContext).fpc();
      }
      return IEI;
    }
    finally {}
  }
  
  public final void X(File paramFile)
  {
    if ((this.IEJ == null) || (paramFile == null) || (!paramFile.exists())) {
      return;
    }
    aOh(SharePatchFileUtil.getPatchVersionDirectory(SharePatchFileUtil.getMD5(paramFile)));
  }
  
  public final void cGh()
  {
    if (this.IEJ == null) {}
    File localFile1;
    File localFile2;
    SharePatchInfo localSharePatchInfo;
    do
    {
      return;
      localFile1 = SharePatchFileUtil.getPatchInfoFile(this.IEJ.getAbsolutePath());
      if (!localFile1.exists())
      {
        com.tencent.tinker.lib.f.a.w("Tinker.Tinker", "try to clean patch while patch info file does not exist.", new Object[0]);
        return;
      }
      localFile2 = SharePatchFileUtil.getPatchInfoLockFile(this.IEJ.getAbsolutePath());
      localSharePatchInfo = SharePatchInfo.readAndCheckPropertyWithLock(localFile1, localFile2);
    } while (localSharePatchInfo == null);
    localSharePatchInfo.isRemoveNewVersion = true;
    SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, localSharePatchInfo, localFile2);
  }
  
  public static final class a
  {
    private File IEJ;
    public com.tencent.tinker.lib.b.b IEK;
    public c IEL;
    public com.tencent.tinker.lib.d.d IEM;
    private File IEN;
    private File IEO;
    private final boolean IES;
    private final boolean IET;
    public Boolean IEU;
    private final Context context;
    public int status = -1;
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        throw new TinkerRuntimeException("Context must not be null.");
      }
      this.context = paramContext;
      this.IES = com.tencent.tinker.lib.f.b.isInMainProcess(paramContext);
      this.IET = com.tencent.tinker.lib.f.b.kM(paramContext);
      this.IEJ = SharePatchFileUtil.getPatchDirectory(paramContext);
      if (this.IEJ == null)
      {
        com.tencent.tinker.lib.f.a.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
        return;
      }
      this.IEN = SharePatchFileUtil.getPatchInfoFile(this.IEJ.getAbsolutePath());
      this.IEO = SharePatchFileUtil.getPatchInfoLockFile(this.IEJ.getAbsolutePath());
      com.tencent.tinker.lib.f.a.w("Tinker.Tinker", "tinker patch directory: %s", new Object[] { this.IEJ });
    }
    
    public final a fpc()
    {
      if (this.status == -1) {
        this.status = 15;
      }
      if (this.IEL == null) {
        this.IEL = new com.tencent.tinker.lib.d.a(this.context);
      }
      if (this.IEM == null) {
        this.IEM = new com.tencent.tinker.lib.d.b(this.context);
      }
      if (this.IEK == null) {
        this.IEK = new com.tencent.tinker.lib.b.a(this.context);
      }
      if (this.IEU == null) {
        this.IEU = Boolean.FALSE;
      }
      return new a(this.context, this.status, this.IEL, this.IEM, this.IEK, this.IEJ, this.IEN, this.IEO, this.IES, this.IET, this.IEU.booleanValue(), (byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tinker.lib.e.a
 * JD-Core Version:    0.7.0.1
 */