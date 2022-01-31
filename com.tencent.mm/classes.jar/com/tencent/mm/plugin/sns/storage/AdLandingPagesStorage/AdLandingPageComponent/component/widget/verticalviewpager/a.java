package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  implements b
{
  b.a ibL;
  String qAL = "";
  
  public final void a(b.a parama)
  {
    this.ibL = parama;
  }
  
  public final void er(String paramString)
  {
    AppMethodBeat.i(37501);
    ab.i("MicroMsg.AdLandingOnlineVideoProxy", "%s, stop stream[%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
    if (this.qAL.equals(paramString)) {
      AdLandingPagesProxy.getInstance().stopDownloadLandingPageVideo(paramString);
    }
    AppMethodBeat.o(37501);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37503);
    ab.i("MicroMsg.AdLandingOnlineVideoProxy", "%s, check video data available[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.qAL.equals(paramString))
    {
      boolean bool = AdLandingPagesProxy.getInstance().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(37503);
      return bool;
    }
    AppMethodBeat.o(37503);
    return false;
  }
  
  public final void r(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(37500);
    this.qAL = paramString1;
    ab.i("MicroMsg.AdLandingOnlineVideoProxy", "%s start http stream[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString3, paramString2 });
    AdLandingPagesProxy.getInstance().downloadLandingPageVideo(paramString1, paramString3, paramString2, new a.a(this, (byte)0));
    AppMethodBeat.o(37500);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37502);
    ab.d("MicroMsg.AdLandingOnlineVideoProxy", "%s, request video data[%s, %s, %s]", new Object[] { Integer.valueOf(hashCode()), paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.qAL.equals(paramString)) {
      AdLandingPagesProxy.getInstance().requestVideoData(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(37502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a
 * JD-Core Version:    0.7.0.1
 */