package com.tencent.tinker.lib.f;

import android.content.Context;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;
import java.io.IOException;

public final class c
{
  private static c wWN;
  private Context context = null;
  public boolean wWO = true;
  public File wWP = null;
  public File wWQ = null;
  public int wWR = 5;
  
  private c(Context paramContext)
  {
    this.context = paramContext;
    this.wWP = new File(SharePatchFileUtil.hY(paramContext), "patch.retry");
    this.wWQ = new File(SharePatchFileUtil.hY(paramContext), "temp.apk");
  }
  
  public static c hS(Context paramContext)
  {
    if (wWN == null) {
      wWN = new c(paramContext);
    }
    return wWN;
  }
  
  public final void aa(File paramFile)
  {
    if (paramFile.getAbsolutePath().equals(this.wWQ.getAbsolutePath())) {
      return;
    }
    a.w("Tinker.UpgradePatchRetry", "try copy file: %s to %s", new Object[] { paramFile.getAbsolutePath(), this.wWQ.getAbsolutePath() });
    try
    {
      SharePatchFileUtil.j(paramFile, this.wWQ);
      return;
    }
    catch (IOException localIOException)
    {
      a.e("Tinker.UpgradePatchRetry", "fail to copy file: %s to %s", new Object[] { paramFile.getAbsolutePath(), this.wWQ.getAbsolutePath() });
    }
  }
  
  public final boolean age(String paramString)
  {
    if (!this.wWO) {
      a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry disabled, just return", new Object[0]);
    }
    int i;
    do
    {
      c.a locala;
      do
      {
        return true;
        if (!this.wWP.exists())
        {
          a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry file is not exist, just return", new Object[0]);
          return true;
        }
        if (paramString == null)
        {
          a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck md5 is null, just return", new Object[0]);
          return true;
        }
        locala = c.a.ab(this.wWP);
      } while (!paramString.equals(locala.bIW));
      i = Integer.parseInt(locala.wWS);
    } while (i < this.wWR);
    a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck, retry count %d must exceed than max retry count", new Object[] { Integer.valueOf(i) });
    SharePatchFileUtil.ah(this.wWQ);
    return false;
  }
  
  public final boolean cQJ()
  {
    if (!this.wWO)
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry disabled, just return", new Object[0]);
      return false;
    }
    if (!com.tencent.tinker.lib.e.a.hN(this.context).prD)
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
      return false;
    }
    if (!this.wWP.exists())
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry info not exist, just return", new Object[0]);
      return false;
    }
    if (b.hP(this.context))
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad tinker service is running, just return", new Object[0]);
      return false;
    }
    String str = this.wWQ.getAbsolutePath();
    if ((str == null) || (!new File(str).exists()))
    {
      a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is not exist, just return", new Object[] { str });
      return false;
    }
    a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is exist, retry to patch", new Object[] { str });
    com.tencent.tinker.lib.e.c.bR(this.context, str);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tinker.lib.f.c
 * JD-Core Version:    0.7.0.1
 */