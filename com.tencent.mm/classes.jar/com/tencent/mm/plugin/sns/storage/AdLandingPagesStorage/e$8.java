package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class e$8
  implements d.a
{
  e$8(f.a parama, String paramString1, String paramString2) {}
  
  public final void Op(String paramString)
  {
    y.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for cdn file %s, path %s", new Object[] { this.val$url, paramString });
    ai.d(new e.8.2(this));
  }
  
  public final void bCF()
  {
    y.i("MicroMsg.AdLandingPageDownloadFileHelper", " download error for cdn file %s", new Object[] { this.val$url });
    ai.d(new e.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.8
 * JD-Core Version:    0.7.0.1
 */