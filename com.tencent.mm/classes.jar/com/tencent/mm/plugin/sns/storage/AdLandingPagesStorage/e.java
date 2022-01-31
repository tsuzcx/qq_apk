package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  public static void a(String paramString1, final String paramString2, boolean paramBoolean, int paramInt, f.a parama)
  {
    if (!bk.bl(paramString2))
    {
      if (com.tencent.mm.vfs.e.bK(paramString2))
      {
        y.i("MicroMsg.AdLandingPageDownloadFileHelper", "small file %s is already exists", new Object[] { paramString2 });
        ai.d(new Runnable()
        {
          public final void run()
          {
            this.oKn.Op(paramString2);
          }
        });
        return;
      }
      new f(paramString1, paramString2, paramBoolean, paramInt, 0, new e.2(parama, paramString1)).execute(new Void[0]);
      return;
    }
    ai.d(new Runnable()
    {
      public final void run()
      {
        this.oKn.bCF();
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e
 * JD-Core Version:    0.7.0.1
 */