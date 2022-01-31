package com.tencent.tinker.lib.e;

import android.content.Context;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public class a
{
  private static a wWh;
  public static boolean wWi = false;
  public final Context context;
  public final boolean prD;
  public int tinkerFlags;
  final boolean tinkerLoadVerifyFlag;
  public final File wWj;
  final com.tencent.tinker.lib.b.b wWk;
  public final c wWl;
  public final com.tencent.tinker.lib.d.d wWm;
  public final File wWn;
  public final File wWo;
  public final boolean wWp;
  public d wWq;
  public boolean wWr = false;
  
  private a(Context paramContext, int paramInt, c paramc, com.tencent.tinker.lib.d.d paramd, com.tencent.tinker.lib.b.b paramb, File paramFile1, File paramFile2, File paramFile3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.context = paramContext;
    this.wWk = paramb;
    this.wWl = paramc;
    this.wWm = paramd;
    this.tinkerFlags = paramInt;
    this.wWj = paramFile1;
    this.wWn = paramFile2;
    this.wWo = paramFile3;
    this.prD = paramBoolean1;
    this.tinkerLoadVerifyFlag = paramBoolean3;
    this.wWp = paramBoolean2;
  }
  
  public static void a(a parama)
  {
    if (wWh != null) {
      throw new TinkerRuntimeException("Tinker instance is already set.");
    }
    wWh = parama;
  }
  
  public static a hN(Context paramContext)
  {
    if (!wWi) {
      throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }
    try
    {
      if (wWh == null) {
        wWh = new a(paramContext).cQI();
      }
      return wWh;
    }
    finally {}
  }
  
  public final void Z(File paramFile)
  {
    if ((this.wWj == null) || (paramFile == null) || (!paramFile.exists())) {}
    do
    {
      return;
      paramFile = SharePatchFileUtil.agk(SharePatchFileUtil.ai(paramFile));
    } while ((this.wWj == null) || (paramFile == null));
    SharePatchFileUtil.bL(this.wWj.getAbsolutePath() + "/" + paramFile);
  }
  
  public final void bbj()
  {
    if (this.wWj == null) {
      return;
    }
    if (this.wWr) {
      com.tencent.tinker.lib.f.a.e("Tinker.Tinker", "it is not safety to clean patch when tinker is loaded, you should kill all your process after clean!", new Object[0]);
    }
    SharePatchFileUtil.k(this.wWj);
  }
  
  public static final class a
  {
    private final Context context;
    public int status = -1;
    private File wWj;
    public com.tencent.tinker.lib.b.b wWk;
    public c wWl;
    public com.tencent.tinker.lib.d.d wWm;
    private File wWn;
    private File wWo;
    private final boolean wWs;
    private final boolean wWt;
    public Boolean wWu;
    
    public a(Context paramContext)
    {
      if (paramContext == null) {
        throw new TinkerRuntimeException("Context must not be null.");
      }
      this.context = paramContext;
      this.wWs = com.tencent.tinker.lib.f.b.ie(paramContext);
      this.wWt = com.tencent.tinker.lib.f.b.hR(paramContext);
      this.wWj = SharePatchFileUtil.hX(paramContext);
      if (this.wWj == null)
      {
        com.tencent.tinker.lib.f.a.e("Tinker.Tinker", "patchDirectory is null!", new Object[0]);
        return;
      }
      this.wWn = SharePatchFileUtil.agi(this.wWj.getAbsolutePath());
      this.wWo = SharePatchFileUtil.agj(this.wWj.getAbsolutePath());
      com.tencent.tinker.lib.f.a.w("Tinker.Tinker", "tinker patch directory: %s", new Object[] { this.wWj });
    }
    
    public final a cQI()
    {
      if (this.status == -1) {
        this.status = 7;
      }
      if (this.wWl == null) {
        this.wWl = new com.tencent.tinker.lib.d.a(this.context);
      }
      if (this.wWm == null) {
        this.wWm = new com.tencent.tinker.lib.d.b(this.context);
      }
      if (this.wWk == null) {
        this.wWk = new com.tencent.tinker.lib.b.a(this.context);
      }
      if (this.wWu == null) {
        this.wWu = Boolean.valueOf(false);
      }
      return new a(this.context, this.status, this.wWl, this.wWm, this.wWk, this.wWj, this.wWn, this.wWo, this.wWs, this.wWt, this.wWu.booleanValue(), (byte)0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.lib.e.a
 * JD-Core Version:    0.7.0.1
 */