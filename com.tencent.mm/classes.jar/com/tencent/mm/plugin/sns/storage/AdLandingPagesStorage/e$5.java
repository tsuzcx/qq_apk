package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class e$5
  implements c.a
{
  e$5(c.a parama, String paramString) {}
  
  public final void Oq(String paramString)
  {
    y.i("MicroMsg.AdLandingPageDownloadFileHelper", " download success big file for %s", new Object[] { this.val$url });
    ai.d(new e.5.3(this, paramString));
  }
  
  public final void cu(String paramString, int paramInt)
  {
    ai.d(new e.5.1(this, paramString, paramInt));
  }
  
  public final void uv(String paramString)
  {
    y.e("MicroMsg.AdLandingPageDownloadFileHelper", " download error for big file %s", new Object[] { this.val$url });
    ai.d(new e.5.2(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.5
 * JD-Core Version:    0.7.0.1
 */