package com.tencent.tinker.lib.e;

import android.content.Context;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;

public class a
{
  private static a BsK;
  public static boolean BsL = false;
  public final File BsM;
  final com.tencent.tinker.lib.b.b BsN;
  public final c BsO;
  public final com.tencent.tinker.lib.d.d BsP;
  public final File BsQ;
  public final File BsR;
  public final boolean BsS;
  public d BsT;
  public boolean BsU = false;
  public final Context context;
  public final boolean snC;
  public int tinkerFlags;
  final boolean tinkerLoadVerifyFlag;
  
  private a(Context paramContext, int paramInt, c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.context = paramContext;
    this.BsN = paramb;
    this.BsO = paramc;
    this.BsP = paramd;
    this.tinkerFlags = paramInt;
    this.BsM = paramFile1;
    this.BsQ = paramFile2;
    this.BsR = paramFile3;
    this.snC = paramBoolean1;
    this.tinkerLoadVerifyFlag = paramBoolean3;
    this.BsS = paramBoolean2;
  }
  
  public static void a(a parama)
  {
    if (BsK != null) {
      throw new TinkerRuntimeException("Tinker instance is already set.");
    }
    BsK = parama;
  }
  
  private void awT(String paramString)
  {
    if ((this.BsM == null) || (paramString == null)) {
      return;
    }
    SharePatchFileUtil.cO(this.BsM.getAbsolutePath() + "/" + paramString);
  }
  
  public static a jo(Context paramContext)
  {
    if (!BsL) {
      throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }
    try
    {
      if (BsK == null) {
        BsK = new a(paramContext).dWx();
      }
      return BsK;
    }
    finally {}
  }
  
  public final void ai(File paramFile)
  {
    if ((this.BsM == null) || (paramFile == null) || (!paramFile.exists())) {
      return;
    }
    awT(SharePatchFileUtil.axb(SharePatchFileUtil.q(paramFile)));
  }
  
  public final void bIo()
  {
    if (this.BsM == null) {}
    File localFile1;
    File localFile2;
    SharePatchInfo localSharePatchInfo;
    do
    {
      return;
      localFile1 = SharePatchFileUtil.awZ(this.BsM.getAbsolutePath());
      if (!localFile1.exists())
      {
        com.tencent.tinker.lib.f.a.w("Tinker.Tinker", "try to clean patch while patch info file does not exist.", new Object[0]);
        return;
      }
      localFile2 = SharePatchFileUtil.axa(this.BsM.getAbsolutePath());
      localSharePatchInfo = SharePatchInfo.l(localFile1, localFile2);
    } while (localSharePatchInfo == null);
    localSharePatchInfo.BvX = true;
    SharePatchInfo.a(localFile1, localSharePatchInfo, localFile2);
  }
  
  public static final class a
  {
    private File BsM;
    public com.tencent.tinker.lib.b.b BsN;
    public c BsO;
    public com.tencent.tinker.lib.d.d BsP;
    private File BsQ;
    private File BsR;
    private final boolean BsV;
    private final boolean BsW;
    public Boolean BsX;
    private final Context context;
    public int status = -1;
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        throw new TinkerRuntimeException("Context must not be null.");
      }
      this.context = paramContext;
      this.BsV = com.tencent.tinker.lib.f.b.jH(paramContext);
      this.BsW = com.tencent.tinker.lib.f.b.js(paramContext);
      this.BsM = SharePatchFileUtil.jy(paramContext);
      if (this.BsM == null)
      {
        com.tencent.tinker.lib.f.a.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
        return;
      }
      this.BsQ = SharePatchFileUtil.awZ(this.BsM.getAbsolutePath());
      this.BsR = SharePatchFileUtil.axa(this.BsM.getAbsolutePath());
      com.tencent.tinker.lib.f.a.w("Tinker.Tinker", "tinker patch directory: %s", new Object[] { this.BsM });
    }
    
    public final a dWx()
    {
      if (this.status == -1) {
        this.status = 7;
      }
      if (this.BsO == null) {
        this.BsO = new com.tencent.tinker.lib.d.a(this.context);
      }
      if (this.BsP == null) {
        this.BsP = new com.tencent.tinker.lib.d.b(this.context);
      }
      if (this.BsN == null) {
        this.BsN = new com.tencent.tinker.lib.b.a(this.context);
      }
      if (this.BsX == null) {
        this.BsX = Boolean.FALSE;
      }
      return new a(this.context, this.status, this.BsO, this.BsP, this.BsN, this.BsM, this.BsQ, this.BsR, this.BsV, this.BsW, this.BsX.booleanValue(), (byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.lib.e.a
 * JD-Core Version:    0.7.0.1
 */