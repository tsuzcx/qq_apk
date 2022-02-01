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
  private static a KqR;
  public static boolean sInstalled = false;
  public final File KqS;
  final com.tencent.tinker.lib.b.b KqT;
  public final c KqU;
  public final com.tencent.tinker.lib.d.d KqV;
  public final File KqW;
  public final File KqX;
  public final boolean KqY;
  public d KqZ;
  public boolean Kra = false;
  public final Context context;
  public int tinkerFlags;
  final boolean tinkerLoadVerifyFlag;
  public final boolean zmI;
  
  private a(Context paramContext, int paramInt, c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.context = paramContext;
    this.KqT = paramb;
    this.KqU = paramc;
    this.KqV = paramd;
    this.tinkerFlags = paramInt;
    this.KqS = paramFile1;
    this.KqW = paramFile2;
    this.KqX = paramFile3;
    this.zmI = paramBoolean1;
    this.tinkerLoadVerifyFlag = paramBoolean3;
    this.KqY = paramBoolean2;
  }
  
  public static void a(a parama)
  {
    if (KqR != null) {
      throw new TinkerRuntimeException("Tinker instance is already set.");
    }
    KqR = parama;
  }
  
  private void aTS(String paramString)
  {
    if ((this.KqS == null) || (paramString == null)) {
      return;
    }
    SharePatchFileUtil.deleteDir(this.KqS.getAbsolutePath() + "/" + paramString);
  }
  
  public static a kX(Context paramContext)
  {
    if (!sInstalled) {
      throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }
    try
    {
      if (KqR == null) {
        KqR = new a(paramContext).fHk();
      }
      return KqR;
    }
    finally {}
  }
  
  public final void ab(File paramFile)
  {
    if ((this.KqS == null) || (paramFile == null) || (!paramFile.exists())) {
      return;
    }
    aTS(SharePatchFileUtil.getPatchVersionDirectory(SharePatchFileUtil.getMD5(paramFile)));
  }
  
  public final void cTr()
  {
    if (this.KqS == null) {}
    File localFile1;
    File localFile2;
    SharePatchInfo localSharePatchInfo;
    do
    {
      return;
      localFile1 = SharePatchFileUtil.getPatchInfoFile(this.KqS.getAbsolutePath());
      if (!localFile1.exists())
      {
        ShareTinkerLog.w("Tinker.Tinker", "try to clean patch while patch info file does not exist.", new Object[0]);
        return;
      }
      localFile2 = SharePatchFileUtil.getPatchInfoLockFile(this.KqS.getAbsolutePath());
      localSharePatchInfo = SharePatchInfo.readAndCheckPropertyWithLock(localFile1, localFile2);
    } while (localSharePatchInfo == null);
    localSharePatchInfo.isRemoveNewVersion = true;
    SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, localSharePatchInfo, localFile2);
  }
  
  public static final class a
  {
    private File KqS;
    public com.tencent.tinker.lib.b.b KqT;
    public c KqU;
    public com.tencent.tinker.lib.d.d KqV;
    private File KqW;
    private File KqX;
    private final boolean Krb;
    private final boolean Krc;
    public Boolean Krd;
    private final Context context;
    public int status = -1;
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        throw new TinkerRuntimeException("Context must not be null.");
      }
      this.context = paramContext;
      this.Krb = com.tencent.tinker.lib.util.b.isInMainProcess(paramContext);
      this.Krc = com.tencent.tinker.lib.util.b.lb(paramContext);
      this.KqS = SharePatchFileUtil.getPatchDirectory(paramContext);
      if (this.KqS == null)
      {
        ShareTinkerLog.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
        return;
      }
      this.KqW = SharePatchFileUtil.getPatchInfoFile(this.KqS.getAbsolutePath());
      this.KqX = SharePatchFileUtil.getPatchInfoLockFile(this.KqS.getAbsolutePath());
      ShareTinkerLog.w("Tinker.Tinker", "tinker patch directory: %s", new Object[] { this.KqS });
    }
    
    public final a fHk()
    {
      if (this.status == -1) {
        this.status = 15;
      }
      if (this.KqU == null) {
        this.KqU = new com.tencent.tinker.lib.d.a(this.context);
      }
      if (this.KqV == null) {
        this.KqV = new com.tencent.tinker.lib.d.b(this.context);
      }
      if (this.KqT == null) {
        this.KqT = new com.tencent.tinker.lib.b.a(this.context);
      }
      if (this.Krd == null) {
        this.Krd = Boolean.FALSE;
      }
      return new a(this.context, this.status, this.KqU, this.KqV, this.KqT, this.KqS, this.KqW, this.KqX, this.Krb, this.Krc, this.Krd.booleanValue(), (byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.lib.e.a
 * JD-Core Version:    0.7.0.1
 */