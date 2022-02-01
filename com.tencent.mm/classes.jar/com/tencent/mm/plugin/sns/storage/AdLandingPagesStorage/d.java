package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;

public final class d
  extends b
{
  private final String fileName;
  private final String filePath;
  private final int fileType;
  private final String yuj;
  private final a yuk;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    AppMethodBeat.i(200312);
    com.tencent.mm.vfs.i.aSh(paramString2);
    this.url = paramString1;
    this.yuj = paramString2;
    this.fileName = paramString3;
    this.filePath = (paramString2 + paramString3);
    this.fileType = paramInt;
    this.yuk = parama;
    AppMethodBeat.o(200312);
  }
  
  private String dLK()
  {
    AppMethodBeat.i(97289);
    try
    {
      AdLandingPagesProxy.getInstance().downloadLandingPagesCDNFile(this.yuj, this.fileName, this.url, this.fileType, new AdLandingPagesProxy.g()
      {
        public final void dFD()
        {
          AppMethodBeat.i(97285);
          String str = ax.iH(ai.getContext());
          ac.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "onDownloadError, netType=" + str + ", url=" + d.this.url);
          d.this.auG(d.a(d.this));
          if (d.b(d.this) != null) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97283);
                d.b(d.this).dFD();
                AppMethodBeat.o(97283);
              }
            });
          }
          AppMethodBeat.o(97285);
        }
        
        public final void dGZ()
        {
          AppMethodBeat.i(97286);
          if (d.b(d.this) != null) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97284);
                d.b(d.this).asD(d.a(d.this));
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
        String str = ax.iH(ai.getContext());
        ac.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "doInBackground exp, netType=" + str + ", exp=" + localException.toString() + ", url=" + this.url);
        auG(this.filePath);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97287);
            d.b(d.this).dFD();
            AppMethodBeat.o(97287);
          }
        });
      }
    }
  }
  
  protected final void auG(String paramString)
  {
    AppMethodBeat.i(200313);
    int i = 0;
    String str = "0";
    for (;;)
    {
      try
      {
        if (com.tencent.mm.vfs.i.eA(paramString))
        {
          str = "1";
          if (com.tencent.mm.vfs.i.deleteFile(paramString))
          {
            i = 1;
            ac.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, succ");
            paramString = str;
            str = ax.iH(ai.getContext());
            com.tencent.mm.plugin.sns.data.i.b(com.tencent.mm.plugin.sns.data.i.xNh, paramString, this.fileType, i, "cdn|".concat(String.valueOf(str)));
            AppMethodBeat.o(200313);
            return;
          }
          ac.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, failed");
          paramString = str;
          continue;
        }
        ac.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, file not exists");
      }
      catch (Throwable paramString)
      {
        ac.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, exp=" + paramString.toString());
        AppMethodBeat.o(200313);
        return;
      }
      paramString = str;
    }
  }
  
  public static abstract interface a
  {
    public abstract void asD(String paramString);
    
    public abstract void dFD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d
 * JD-Core Version:    0.7.0.1
 */