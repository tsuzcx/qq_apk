package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

public final class d
  extends b
{
  private final String fileName;
  private final String filePath;
  private final String oKj;
  private final a oKk;
  
  public d(String paramString1, String paramString2, String paramString3, a parama)
  {
    e.nb(paramString2);
    this.url = paramString1;
    this.oKj = paramString2;
    this.fileName = paramString3;
    this.filePath = (paramString2 + "/" + paramString3);
    this.oKk = parama;
  }
  
  private String baK()
  {
    try
    {
      AdLandingPagesProxy.getInstance().downloadLandingPagesImage(this.oKj, this.fileName, this.url, new d.1(this));
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.i("MicroMsg.AdLandingPageDownloadCDNFileTask", "maybe wrong download scene, res[%s], stack[%s]", new Object[] { this.url, bk.j(localException) });
        ai.d(new d.2(this));
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Op(String paramString);
    
    public abstract void bCF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d
 * JD-Core Version:    0.7.0.1
 */