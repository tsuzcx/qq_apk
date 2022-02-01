package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.vfs.u;

public final class d
  extends b
{
  private final String Kyc;
  private final a Kyd;
  private final String fileName;
  private final String filePath;
  private final int fileType;
  
  public d(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    AppMethodBeat.i(269394);
    u.bBD(paramString2);
    this.url = paramString1;
    this.Kyc = paramString2;
    this.fileName = paramString3;
    this.filePath = (paramString2 + paramString3);
    this.fileType = paramInt;
    this.Kyd = parama;
    AppMethodBeat.o(269394);
  }
  
  private String fSp()
  {
    AppMethodBeat.i(97289);
    try
    {
      AdLandingPagesProxy.getInstance().downloadLandingPagesCDNFile(this.Kyc, this.fileName, this.url, this.fileType, new AdLandingPagesProxy.f()
      {
        public final void fJV()
        {
          AppMethodBeat.i(97285);
          String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
          Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "onDownloadError, netType=" + str + ", url=" + d.this.url);
          d.this.baX(d.a(d.this));
          if (d.b(d.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97283);
                d.b(d.this).fJV();
                AppMethodBeat.o(97283);
              }
            });
          }
          AppMethodBeat.o(97285);
        }
        
        public final void fNL()
        {
          AppMethodBeat.i(97286);
          if (d.b(d.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97284);
                d.b(d.this).aYs(d.a(d.this));
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
        baX(this.filePath);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97287);
            d.b(d.this).fJV();
            AppMethodBeat.o(97287);
          }
        });
      }
    }
  }
  
  protected final void baX(String paramString)
  {
    AppMethodBeat.i(269399);
    int i = 0;
    String str = "0";
    for (;;)
    {
      try
      {
        if (u.agG(paramString))
        {
          str = "1";
          if (u.deleteFile(paramString))
          {
            i = 1;
            Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, succ");
            paramString = str;
            str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
            l.a(l.JQJ, paramString, this.fileType, i, "cdn|".concat(String.valueOf(str)));
            AppMethodBeat.o(269399);
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
        AppMethodBeat.o(269399);
        return;
      }
      paramString = str;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aYs(String paramString);
    
    public abstract void fJV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d
 * JD-Core Version:    0.7.0.1
 */