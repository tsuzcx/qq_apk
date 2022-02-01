package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;

public final class d
  extends b
{
  private final String fileName;
  private final String filePath;
  private final int fileType;
  private final String zLw;
  private final a zLx;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    AppMethodBeat.i(198106);
    com.tencent.mm.vfs.i.aYg(paramString2);
    this.url = paramString1;
    this.zLw = paramString2;
    this.fileName = paramString3;
    this.filePath = (paramString2 + paramString3);
    this.fileType = paramInt;
    this.zLx = parama;
    AppMethodBeat.o(198106);
  }
  
  private String dYa()
  {
    AppMethodBeat.i(97289);
    try
    {
      AdLandingPagesProxy.getInstance().downloadLandingPagesCDNFile(this.zLw, this.fileName, this.url, this.fileType, new AdLandingPagesProxy.g()
      {
        public final void dRX()
        {
          AppMethodBeat.i(97285);
          String str = ay.iR(aj.getContext());
          ad.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "onDownloadError, netType=" + str + ", url=" + d.this.url);
          d.this.azN(d.a(d.this));
          if (d.b(d.this) != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97283);
                d.b(d.this).dRX();
                AppMethodBeat.o(97283);
              }
            });
          }
          AppMethodBeat.o(97285);
        }
        
        public final void dTm()
        {
          AppMethodBeat.i(97286);
          if (d.b(d.this) != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97284);
                d.b(d.this).axG(d.a(d.this));
                AppMethodBeat.o(97284);
              }
            });
          }
          AppMethodBeat.o(97286);
        }
      });
      AppMethodBeat.o(97289);
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = ay.iR(aj.getContext());
        ad.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "doInBackground exp, netType=" + str + ", exp=" + localException.toString() + ", url=" + this.url);
        azN(this.filePath);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97287);
            d.b(d.this).dRX();
            AppMethodBeat.o(97287);
          }
        });
      }
    }
  }
  
  protected final void azN(String paramString)
  {
    AppMethodBeat.i(198107);
    int i = 0;
    String str = "0";
    for (;;)
    {
      try
      {
        if (com.tencent.mm.vfs.i.fv(paramString))
        {
          str = "1";
          if (com.tencent.mm.vfs.i.deleteFile(paramString))
          {
            i = 1;
            ad.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, succ");
            paramString = str;
            str = ay.iR(aj.getContext());
            com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.zda, paramString, this.fileType, i, "cdn|".concat(String.valueOf(str)));
            AppMethodBeat.o(198107);
            return;
          }
          ad.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, failed");
          paramString = str;
          continue;
        }
        ad.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, file not exists");
      }
      catch (Throwable paramString)
      {
        ad.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, exp=" + paramString.toString());
        AppMethodBeat.o(198107);
        return;
      }
      paramString = str;
    }
  }
  
  public static abstract interface a
  {
    public abstract void axG(String paramString);
    
    public abstract void dRX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d
 * JD-Core Version:    0.7.0.1
 */