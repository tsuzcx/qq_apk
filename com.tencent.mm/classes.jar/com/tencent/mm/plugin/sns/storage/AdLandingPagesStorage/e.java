package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.l;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.vfs.y;

public final class e
  extends c
{
  private final String QWW;
  private final a QWX;
  private final String fileName;
  private final String filePath;
  private final int fileType;
  
  public e(String paramString1, String paramString2, String paramString3, int paramInt, a parama)
  {
    AppMethodBeat.i(306743);
    y.bDX(paramString2);
    this.url = paramString1;
    this.QWW = paramString2;
    this.fileName = paramString3;
    this.filePath = (paramString2 + paramString3);
    this.fileType = paramInt;
    this.QWX = parama;
    AppMethodBeat.o(306743);
  }
  
  private String hkA()
  {
    AppMethodBeat.i(97289);
    try
    {
      AdLandingPagesProxy.getInstance().downloadLandingPagesCDNFile(this.QWW, this.fileName, this.url, this.fileType, new AdLandingPagesProxy.f()
      {
        public final void gZN()
        {
          AppMethodBeat.i(97285);
          String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
          Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "onDownloadError, netType=" + str + ", url=" + e.this.url);
          e.this.aZy(e.a(e.this));
          if (e.b(e.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97283);
                e.b(e.this).gZN();
                AppMethodBeat.o(97283);
              }
            });
          }
          AppMethodBeat.o(97285);
        }
        
        public final void hfw()
        {
          AppMethodBeat.i(97286);
          if (e.b(e.this) != null) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97284);
                e.b(e.this).aWn(e.a(e.this));
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
        aZy(this.filePath);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97287);
            e.b(e.this).gZN();
            AppMethodBeat.o(97287);
          }
        });
      }
    }
  }
  
  protected final void aZy(String paramString)
  {
    AppMethodBeat.i(306759);
    int i = 0;
    String str = "0";
    for (;;)
    {
      try
      {
        if (y.ZC(paramString))
        {
          str = "1";
          if (y.deleteFile(paramString))
          {
            i = 1;
            Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, succ");
            paramString = str;
            str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
            l.a(l.Qno, paramString, this.fileType, i, "cdn|".concat(String.valueOf(str)));
            AppMethodBeat.o(306759);
            return;
          }
          Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, failed");
          paramString = str;
          continue;
        }
        Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, file not exists");
      }
      finally
      {
        Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, exp=" + paramString.toString());
        AppMethodBeat.o(306759);
        return;
      }
      paramString = str;
    }
  }
  
  public static abstract interface a
  {
    public abstract void aWn(String paramString);
    
    public abstract void gZN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e
 * JD-Core Version:    0.7.0.1
 */