package com.tencent.mm.plugin.sns.ad.landingpage.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.g.h.a;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class a
  implements f
{
  private String IBe = "";
  private f.a xFC;
  
  public final void a(f.a parama)
  {
    this.xFC = parama;
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310862);
    Log.i("MicroMsg.AdLandingGeneralVideoProxy", "%s, check video data available[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.IBe.equals(paramString))
    {
      boolean bool = AdLandingPagesProxy.getInstance().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(310862);
      return bool;
    }
    AppMethodBeat.o(310862);
    return false;
  }
  
  public final void js(String paramString)
  {
    AppMethodBeat.i(310832);
    Log.i("MicroMsg.AdLandingGeneralVideoProxy", "%s, stop stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (this.IBe.equals(paramString)) {
      AdLandingPagesProxy.getInstance().stopDownloadLandingPageVideo(paramString);
    }
    AppMethodBeat.o(310832);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310851);
    Log.d("MicroMsg.AdLandingGeneralVideoProxy", "%s, request video data[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.IBe.equals(paramString)) {
      AdLandingPagesProxy.getInstance().requestVideoData(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(310851);
  }
  
  public final void w(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(310822);
    this.IBe = paramString1;
    Log.i("MicroMsg.AdLandingGeneralVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString3, paramString2 });
    AdLandingPagesProxy.getInstance().downloadLandingPageVideo(paramString1, paramString3, paramString2, 1, false, -1, new a((byte)0));
    AppMethodBeat.o(310822);
  }
  
  final class a
    implements h.a
  {
    private a() {}
    
    public final void a(final String paramString, final int paramInt, d paramd)
    {
      AppMethodBeat.i(310820);
      if ((a.a(a.this) != null) && (a.b(a.this).equals(paramString))) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(310802);
            h.OAn.kJ(955, 31);
            a.a(a.this).bb(paramString, paramInt);
            AppMethodBeat.o(310802);
          }
        });
      }
      AppMethodBeat.o(310820);
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(310809);
      if ((a.a(a.this) != null) && (a.b(a.this).equals(paramString1))) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(310803);
            h.OAn.kJ(955, 27);
            a.a(a.this).jb(paramLong1);
            AppMethodBeat.o(310803);
          }
        });
      }
      AppMethodBeat.o(310809);
    }
    
    public final void h(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(310816);
      if ((a.a(a.this) != null) && (a.b(a.this).equals(paramString))) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(310804);
            a.a(a.this).h(paramString, paramLong1, this.IAr);
            AppMethodBeat.o(310804);
          }
        });
      }
      AppMethodBeat.o(310816);
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(310812);
      if ((a.a(a.this) != null) && (a.b(a.this).equals(paramString))) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(310801);
            h.OAn.kJ(955, 29);
            a.a(a.this).onDataAvailable(paramString, paramLong1, this.IBh);
            AppMethodBeat.o(310801);
          }
        });
      }
      AppMethodBeat.o(310812);
    }
    
    public final void onM3U8Ready(String paramString1, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.c.a
 * JD-Core Version:    0.7.0.1
 */