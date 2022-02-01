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
  private static a SjR;
  public static boolean sInstalled = false;
  public final boolean FgY;
  public final File SjS;
  final com.tencent.tinker.lib.b.b SjT;
  public final c SjU;
  public final com.tencent.tinker.lib.d.d SjV;
  public final File SjW;
  public final File SjX;
  public final boolean SjY;
  public d SjZ;
  public boolean Ska = false;
  public final Context context;
  public int tinkerFlags;
  final boolean tinkerLoadVerifyFlag;
  
  private a(Context paramContext, int paramInt, c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.context = paramContext;
    this.SjT = paramb;
    this.SjU = paramc;
    this.SjV = paramd;
    this.tinkerFlags = paramInt;
    this.SjS = paramFile1;
    this.SjW = paramFile2;
    this.SjX = paramFile3;
    this.FgY = paramBoolean1;
    this.tinkerLoadVerifyFlag = paramBoolean3;
    this.SjY = paramBoolean2;
  }
  
  public static void a(a parama)
  {
    if (SjR != null) {
      throw new TinkerRuntimeException("Tinker instance is already set.");
    }
    SjR = parama;
  }
  
  private void bqJ(String paramString)
  {
    if ((this.SjS == null) || (paramString == null)) {
      return;
    }
    SharePatchFileUtil.deleteDir(this.SjS.getAbsolutePath() + "/" + paramString);
  }
  
  public static a lk(Context paramContext)
  {
    if (!sInstalled) {
      throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }
    try
    {
      if (SjR == null) {
        SjR = new a(paramContext).hpi();
      }
      return SjR;
    }
    finally {}
  }
  
  public final void ae(File paramFile)
  {
    if ((this.SjS == null) || (paramFile == null) || (!paramFile.exists())) {
      return;
    }
    bqJ(SharePatchFileUtil.getPatchVersionDirectory(SharePatchFileUtil.getMD5(paramFile)));
  }
  
  public final void dZn()
  {
    if (this.SjS == null) {}
    File localFile1;
    File localFile2;
    SharePatchInfo localSharePatchInfo;
    do
    {
      return;
      localFile1 = SharePatchFileUtil.getPatchInfoFile(this.SjS.getAbsolutePath());
      if (!localFile1.exists())
      {
        ShareTinkerLog.w("Tinker.Tinker", "try to clean patch while patch info file does not exist.", new Object[0]);
        return;
      }
      localFile2 = SharePatchFileUtil.getPatchInfoLockFile(this.SjS.getAbsolutePath());
      localSharePatchInfo = SharePatchInfo.readAndCheckPropertyWithLock(localFile1, localFile2);
    } while (localSharePatchInfo == null);
    localSharePatchInfo.isRemoveNewVersion = true;
    SharePatchInfo.rewritePatchInfoFileWithLock(localFile1, localSharePatchInfo, localFile2);
  }
  
  public final d hpd()
  {
    return this.SjZ;
  }
  
  public final boolean hpe()
  {
    return this.Ska;
  }
  
  public final File hpf()
  {
    return this.SjW;
  }
  
  public final File hpg()
  {
    return this.SjX;
  }
  
  public final com.tencent.tinker.lib.b.b hph()
  {
    return this.SjT;
  }
  
  public static final class a
  {
    private File SjS;
    public com.tencent.tinker.lib.b.b SjT;
    public c SjU;
    public com.tencent.tinker.lib.d.d SjV;
    private File SjW;
    private File SjX;
    private final boolean Skb;
    private final boolean Skc;
    public Boolean Skd;
    private final Context context;
    public int status = -1;
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        throw new TinkerRuntimeException("Context must not be null.");
      }
      this.context = paramContext;
      this.Skb = com.tencent.tinker.lib.f.b.isInMainProcess(paramContext);
      this.Skc = com.tencent.tinker.lib.f.b.lo(paramContext);
      this.SjS = SharePatchFileUtil.getPatchDirectory(paramContext);
      if (this.SjS == null)
      {
        ShareTinkerLog.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
        return;
      }
      this.SjW = SharePatchFileUtil.getPatchInfoFile(this.SjS.getAbsolutePath());
      this.SjX = SharePatchFileUtil.getPatchInfoLockFile(this.SjS.getAbsolutePath());
      ShareTinkerLog.w("Tinker.Tinker", "tinker patch directory: %s", new Object[] { this.SjS });
    }
    
    public final a hpi()
    {
      if (this.status == -1) {
        this.status = 15;
      }
      if (this.SjU == null) {
        this.SjU = new com.tencent.tinker.lib.d.a(this.context);
      }
      if (this.SjV == null) {
        this.SjV = new com.tencent.tinker.lib.d.b(this.context);
      }
      if (this.SjT == null) {
        this.SjT = new com.tencent.tinker.lib.b.a(this.context);
      }
      if (this.Skd == null) {
        this.Skd = Boolean.FALSE;
      }
      return new a(this.context, this.status, this.SjU, this.SjV, this.SjT, this.SjS, this.SjW, this.SjX, this.Skb, this.Skc, this.Skd.booleanValue(), (byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.lib.e.a
 * JD-Core Version:    0.7.0.1
 */