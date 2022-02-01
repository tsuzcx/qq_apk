package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

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
    AppMethodBeat.i(96965);
    Log.i("MicroMsg.AdLandingOnlineVideoProxy", "%s, check video data available[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.IBe.equals(paramString))
    {
      boolean bool = AdLandingPagesProxy.getInstance().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(96965);
      return bool;
    }
    AppMethodBeat.o(96965);
    return false;
  }
  
  public final void js(String paramString)
  {
    AppMethodBeat.i(96963);
    Log.i("MicroMsg.AdLandingOnlineVideoProxy", "%s, stop stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (this.IBe.equals(paramString)) {
      AdLandingPagesProxy.getInstance().stopDownloadLandingPageVideo(paramString);
    }
    AppMethodBeat.o(96963);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96964);
    Log.d("MicroMsg.AdLandingOnlineVideoProxy", "%s, request video data[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.IBe.equals(paramString)) {
      AdLandingPagesProxy.getInstance().requestVideoData(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(96964);
  }
  
  public final void w(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(96962);
    this.IBe = paramString1;
    Log.i("MicroMsg.AdLandingOnlineVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString3, paramString2 });
    AdLandingPagesProxy.getInstance().downloadLandingPageVideo(paramString1, paramString3, paramString2, 0, false, -1, new a((byte)0));
    AppMethodBeat.o(96962);
  }
  
  final class a
    implements h.a
  {
    private a() {}
    
    public final void a(final String paramString, final int paramInt, d paramd)
    {
      AppMethodBeat.i(96961);
      if ((a.a(a.this) != null) && (a.b(a.this).equals(paramString))) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96957);
            h.OAn.kJ(955, 31);
            a.a(a.this).bb(paramString, paramInt);
            AppMethodBeat.o(96957);
          }
        });
      }
      AppMethodBeat.o(96961);
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(307289);
      if ((a.a(a.this) != null) && (a.b(a.this).equals(paramString1))) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96954);
            h.OAn.kJ(955, 27);
            a.a(a.this).jb(paramLong1);
            AppMethodBeat.o(96954);
          }
        });
      }
      AppMethodBeat.o(307289);
    }
    
    public final void h(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(96960);
      if ((a.a(a.this) != null) && (a.b(a.this).equals(paramString))) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96956);
            a.a(a.this).h(paramString, paramLong1, this.IAr);
            AppMethodBeat.o(96956);
          }
        });
      }
      AppMethodBeat.o(96960);
    }
    
    public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(96959);
      if ((a.a(a.this) != null) && (a.b(a.this).equals(paramString))) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(96955);
            h.OAn.kJ(955, 29);
            a.a(a.this).onDataAvailable(paramString, paramLong1, this.IBh);
            AppMethodBeat.o(96955);
          }
        });
      }
      AppMethodBeat.o(96959);
    }
    
    public final void onM3U8Ready(String paramString1, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a
 * JD-Core Version:    0.7.0.1
 */