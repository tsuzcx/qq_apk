package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.vfs.s;

public final class d
  extends b
{
  private final String EkT;
  private final a EkU;
  private final String fileName;
  private final String filePath;
  private final int fileType;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    AppMethodBeat.i(203151);
    s.boN(paramString2);
    this.url = paramString1;
    this.EkT = paramString2;
    this.fileName = paramString3;
    this.filePath = (paramString2 + paramString3);
    this.fileType = paramInt;
    this.EkU = parama;
    AppMethodBeat.o(203151);
  }
  
  private String fev()
  {
    AppMethodBeat.i(97289);
    try
    {
      AdLandingPagesProxy.getInstance().downloadLandingPagesCDNFile(this.EkT, this.fileName, this.url, this.fileType, new AdLandingPagesProxy.g()
      {
        public final void eWO()
        {
          AppMethodBeat.i(97285);
          String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
          Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "onDownloadError, netType=" + str + ", url=" + d.this.url);
          d.this.aPY(d.a(d.this));
          if (d.b(d.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97283);
                d.b(d.this).eWO();
                AppMethodBeat.o(97283);
              }
            });
          }
          AppMethodBeat.o(97285);
        }
        
        public final void eZU()
        {
          AppMethodBeat.i(97286);
          if (d.b(d.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97284);
                d.b(d.this).aNH(d.a(d.this));
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
        String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
        Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "doInBackground exp, netType=" + str + ", exp=" + localException.toString() + ", url=" + this.url);
        aPY(this.filePath);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97287);
            d.b(d.this).eWO();
            AppMethodBeat.o(97287);
          }
        });
      }
    }
  }
  
  protected final void aPY(String paramString)
  {
    AppMethodBeat.i(203152);
    int i = 0;
    String str = "0";
    for (;;)
    {
      try
      {
        if (s.YS(paramString))
        {
          str = "1";
          if (s.deleteFile(paramString))
          {
            i = 1;
            Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, succ");
            paramString = str;
            str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
            j.b(j.DEa, paramString, this.fileType, i, "cdn|".concat(String.valueOf(str)));
            AppMethodBeat.o(203152);
            return;
          }
          Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, failed");
          paramString = str;
          continue;
        }
        Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, file not exists");
      }
      catch (Throwable paramString)
      {
        Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, exp=" + paramString.toString());
        AppMethodBeat.o(203152);
        return;
      }
      paramString = str;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aNH(String paramString);
    
    public abstract void eWO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d
 * JD-Core Version:    0.7.0.1
 */