package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class a
  implements b
{
  b.a osD;
  String rTR = "";
  
  public final void a(b.a parama)
  {
    this.osD = parama;
  }
  
  public final void fy(String paramString)
  {
    AppMethodBeat.i(96963);
    ad.i("MicroMsg.AdLandingOnlineVideoProxy", "%s, stop stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (this.rTR.equals(paramString)) {
      AdLandingPagesProxy.getInstance().stopDownloadLandingPageVideo(paramString);
    }
    AppMethodBeat.o(96963);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96965);
    ad.i("MicroMsg.AdLandingOnlineVideoProxy", "%s, check video data available[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.rTR.equals(paramString))
    {
      boolean bool = AdLandingPagesProxy.getInstance().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(96965);
      return bool;
    }
    AppMethodBeat.o(96965);
    return false;
  }
  
  public final void q(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96962);
    this.rTR = paramString1;
    ad.i("MicroMsg.AdLandingOnlineVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString3, paramString2 });
    AdLandingPagesProxy.getInstance().downloadLandingPageVideo(paramString1, paramString3, paramString2, new a((byte)0));
    AppMethodBeat.o(96962);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96964);
    ad.d("MicroMsg.AdLandingOnlineVideoProxy", "%s, request video data[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.rTR.equals(paramString)) {
      AdLandingPagesProxy.getInstance().requestVideoData(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(96964);
  }
  
  final class a
    implements h.a
  {
    private a() {}
    
    public final void a(final String paramString, final int paramInt, d paramd)
    {
      AppMethodBeat.i(96961);
      if ((a.this.osD != null) && (a.this.rTR.equals(paramString))) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96957);
            h.vKh.dB(955, 31);
            a.this.osD.am(paramString, paramInt);
            AppMethodBeat.o(96957);
          }
        });
      }
      AppMethodBeat.o(96961);
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(201278);
      if ((a.this.osD != null) && (a.this.rTR.equals(paramString1))) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96954);
            h.vKh.dB(955, 27);
            a.this.osD.Bl(paramLong1);
            AppMethodBeat.o(96954);
          }
        });
      }
      AppMethodBeat.o(201278);
    }
    
    public final void k(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(96960);
      if ((a.this.osD != null) && (a.this.rTR.equals(paramString))) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96956);
            a.this.osD.k(paramString, paramLong1, this.rTo);
            AppMethodBeat.o(96956);
          }
        });
      }
      AppMethodBeat.o(96960);
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(96959);
      if ((a.this.osD != null) && (a.this.rTR.equals(paramString))) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96955);
            h.vKh.dB(955, 29);
            a.this.osD.onDataAvailable(paramString, paramLong1, this.knN);
            AppMethodBeat.o(96955);
          }
        });
      }
      AppMethodBeat.o(96959);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a
 * JD-Core Version:    0.7.0.1
 */