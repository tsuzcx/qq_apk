package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class d
  extends b
{
  private final String fileName;
  private final String filePath;
  private final String rBS;
  private final a rBT;
  
  public d(String paramString1, String paramString2, String paramString3, a parama)
  {
    AppMethodBeat.i(37691);
    e.um(paramString2);
    this.url = paramString1;
    this.rBS = paramString2;
    this.fileName = paramString3;
    this.filePath = (paramString2 + "/" + paramString3);
    this.rBT = parama;
    AppMethodBeat.o(37691);
  }
  
  private String crU()
  {
    AppMethodBeat.i(37692);
    try
    {
      AdLandingPagesProxy.getInstance().downloadLandingPagesImage(this.rBS, this.fileName, this.url, new d.1(this));
      AppMethodBeat.o(37692);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.i("MicroMsg.AdLandingPageDownloadCDNFileTask", "maybe wrong download scene, res[%s], stack[%s]", new Object[] { this.url, bo.l(localException) });
        al.d(new d.2(this));
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void abi(String paramString);
    
    public abstract void coe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d
 * JD-Core Version:    0.7.0.1
 */