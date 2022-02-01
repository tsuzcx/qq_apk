package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.vfs.o;

public final class d
  extends b
{
  private final String AcD;
  private final a AcE;
  private final String fileName;
  private final String filePath;
  private final int fileType;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    AppMethodBeat.i(219620);
    o.aZI(paramString2);
    this.url = paramString1;
    this.AcD = paramString2;
    this.fileName = paramString3;
    this.filePath = (paramString2 + paramString3);
    this.fileType = paramInt;
    this.AcE = parama;
    AppMethodBeat.o(219620);
  }
  
  private String ebE()
  {
    AppMethodBeat.i(97289);
    try
    {
      AdLandingPagesProxy.getInstance().downloadLandingPagesCDNFile(this.AcD, this.fileName, this.url, this.fileType, new AdLandingPagesProxy.g()
      {
        public final void dVv()
        {
          AppMethodBeat.i(97285);
          String str = az.iW(ak.getContext());
          ae.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "onDownloadError, netType=" + str + ", url=" + d.this.url);
          d.this.aBe(d.a(d.this));
          if (d.b(d.this) != null) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97283);
                d.b(d.this).dVv();
                AppMethodBeat.o(97283);
              }
            });
          }
          AppMethodBeat.o(97285);
        }
        
        public final void dWM()
        {
          AppMethodBeat.i(97286);
          if (d.b(d.this) != null) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97284);
                d.b(d.this).ayY(d.a(d.this));
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
        String str = az.iW(ak.getContext());
        ae.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "doInBackground exp, netType=" + str + ", exp=" + localException.toString() + ", url=" + this.url);
        aBe(this.filePath);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97287);
            d.b(d.this).dVv();
            AppMethodBeat.o(97287);
          }
        });
      }
    }
  }
  
  protected final void aBe(String paramString)
  {
    AppMethodBeat.i(219621);
    int i = 0;
    String str = "0";
    for (;;)
    {
      try
      {
        if (o.fB(paramString))
        {
          str = "1";
          if (o.deleteFile(paramString))
          {
            i = 1;
            ae.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, succ");
            paramString = str;
            str = az.iW(ak.getContext());
            j.b(j.ztQ, paramString, this.fileType, i, "cdn|".concat(String.valueOf(str)));
            AppMethodBeat.o(219621);
            return;
          }
          ae.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, failed");
          paramString = str;
          continue;
        }
        ae.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, file not exists");
      }
      catch (Throwable paramString)
      {
        ae.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, exp=" + paramString.toString());
        AppMethodBeat.o(219621);
        return;
      }
      paramString = str;
    }
  }
  
  public static abstract interface a
  {
    public abstract void ayY(String paramString);
    
    public abstract void dVv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d
 * JD-Core Version:    0.7.0.1
 */