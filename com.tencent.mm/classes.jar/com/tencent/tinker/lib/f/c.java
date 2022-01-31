package com.tencent.tinker.lib.f;

import android.content.Context;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.io.IOException;

public final class c
{
  private static c Btq;
  public boolean Btr = true;
  public File Bts = null;
  public File Btt = null;
  public int Btu = 20;
  private Context context = null;
  
  private c(Context paramContext)
  {
    this.context = paramContext;
    this.Bts = new File(SharePatchFileUtil.jz(paramContext), "patch.retry");
    this.Btt = new File(SharePatchFileUtil.jz(paramContext), "temp.apk");
  }
  
  public static c jt(Context paramContext)
  {
    if (Btq == null) {
      Btq = new c(paramContext);
    }
    return Btq;
  }
  
  public final void aj(File paramFile)
  {
    if (paramFile.getAbsolutePath().equals(this.Btt.getAbsolutePath())) {
      return;
    }
    a.w("Tinker.UpgradePatchRetry", "try copy file: %s to %s", new Object[] { paramFile.getAbsolutePath(), this.Btt.getAbsolutePath() });
    try
    {
      SharePatchFileUtil.j(paramFile, this.Btt);
      return;
    }
    catch (IOException localIOException)
    {
      a.e("Tinker.UpgradePatchRetry", "fail to copy file: %s to %s", new Object[] { paramFile.getAbsolutePath(), this.Btt.getAbsolutePath() });
    }
  }
  
  public final boolean awU(String paramString)
  {
    if (!this.Btr) {
      a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry disabled, just return", new Object[0]);
    }
    int i;
    do
    {
      c.a locala;
      do
      {
        return true;
        if (!this.Bts.exists())
        {
          a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry file is not exist, just return", new Object[0]);
          return true;
        }
        if (paramString == null)
        {
          a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck md5 is null, just return", new Object[0]);
          return true;
        }
        locala = c.a.ak(this.Bts);
      } while (!paramString.equals(locala.cqq));
      i = Integer.parseInt(locala.Btv);
    } while (i < this.Btu);
    a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck, retry count %d must exceed than max retry count", new Object[] { Integer.valueOf(i) });
    SharePatchFileUtil.aq(this.Btt);
    return false;
  }
  
  public final boolean awV(String paramString)
  {
    if (!this.Btr) {
      a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry disabled, just return", new Object[0]);
    }
    c.a locala;
    do
    {
      return true;
      if (!this.Bts.exists())
      {
        a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry file is not exist, just return", new Object[0]);
        return true;
      }
      if (paramString == null)
      {
        a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck md5 is null, just return", new Object[0]);
        return true;
      }
      locala = c.a.ak(this.Bts);
    } while (!paramString.equals(locala.cqq));
    a.i("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck, reset max check to 1", new Object[0]);
    locala.Btv = "1";
    c.a.a(this.Bts, locala);
    return true;
  }
  
  public final boolean dWy()
  {
    if (!this.Btr)
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry disabled, just return", new Object[0]);
      return false;
    }
    if (!com.tencent.tinker.lib.e.a.jo(this.context).snC)
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
      return false;
    }
    if (!this.Bts.exists())
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry info not exist, just return", new Object[0]);
      return false;
    }
    if (b.jq(this.context))
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad tinker service is running, just return", new Object[0]);
      return false;
    }
    String str = this.Btt.getAbsolutePath();
    if ((str == null) || (!new File(str).exists()))
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is not exist, just return", new Object[] { str });
      return false;
    }
    a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is exist, retry to patch", new Object[] { str });
    com.tencent.tinker.lib.e.c.ce(this.context, str);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.lib.f.c
 * JD-Core Version:    0.7.0.1
 */