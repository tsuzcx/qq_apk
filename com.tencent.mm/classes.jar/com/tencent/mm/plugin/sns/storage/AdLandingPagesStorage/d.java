package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.File;

public final class d
  extends b
{
  private final String fileName;
  private final String filePath;
  private final int fileType;
  private final String xhv;
  private final a xhw;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    AppMethodBeat.i(187507);
    com.tencent.mm.vfs.i.aMF(paramString2);
    this.url = paramString1;
    this.xhv = paramString2;
    this.fileName = paramString3;
    this.filePath = (paramString2 + paramString3);
    this.fileType = paramInt;
    this.xhw = parama;
    AppMethodBeat.o(187507);
  }
  
  private String dxl()
  {
    AppMethodBeat.i(97289);
    try
    {
      AdLandingPagesProxy.getInstance().downloadLandingPagesCDNFile(this.xhv, this.fileName, this.url, this.fileType, new AdLandingPagesProxy.g()
      {
        public final void dsA()
        {
          AppMethodBeat.i(97285);
          d.this.apD(d.a(d.this));
          if (d.b(d.this) != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97283);
                d.b(d.this).dsA();
                AppMethodBeat.o(97283);
              }
            });
          }
          AppMethodBeat.o(97285);
        }
        
        public final void dsB()
        {
          AppMethodBeat.i(97286);
          if (d.b(d.this) != null) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97284);
                d.b(d.this).apm(d.a(d.this));
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
        ad.i("MicroMsg.AdLandingPageDownloadCDNFileTask", "maybe wrong download scene, res[%s], stack[%s]", new Object[] { this.url, bt.m(localException) });
        apD(this.filePath);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97287);
            d.b(d.this).dsA();
            AppMethodBeat.o(97287);
          }
        });
      }
    }
  }
  
  protected final void apD(String paramString)
  {
    AppMethodBeat.i(187508);
    int i = 0;
    String str = "0";
    for (;;)
    {
      try
      {
        File localFile = new File(paramString);
        if ((localFile.isFile()) && (localFile.exists()))
        {
          paramString = "1";
          if (localFile.delete())
          {
            i = 1;
            ad.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, succ");
            com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.wAN, paramString, this.fileType, i, "cdn");
            AppMethodBeat.o(187508);
            return;
          }
          ad.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, failed");
          continue;
        }
        ad.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, file not exists");
      }
      catch (Throwable paramString)
      {
        ad.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, exp=" + paramString.toString());
        AppMethodBeat.o(187508);
        return;
      }
      paramString = str;
    }
  }
  
  public static abstract interface a
  {
    public abstract void apm(String paramString);
    
    public abstract void dsA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d
 * JD-Core Version:    0.7.0.1
 */