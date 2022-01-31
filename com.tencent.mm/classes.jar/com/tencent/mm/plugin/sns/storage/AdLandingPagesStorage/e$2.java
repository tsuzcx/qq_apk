package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  implements f.a
{
  e$2(f.a parama, String paramString) {}
  
  public final void Op(String paramString)
  {
    y.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success for small file %s", new Object[] { this.val$url });
    ai.d(new e.2.3(this, paramString));
  }
  
  public final void bCF()
  {
    y.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for small file %s", new Object[] { this.val$url });
    ai.d(new e.2.2(this));
  }
  
  public final void bFl()
  {
    ai.d(new e.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.2
 * JD-Core Version:    0.7.0.1
 */