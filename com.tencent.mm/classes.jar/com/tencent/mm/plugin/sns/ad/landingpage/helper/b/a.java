package com.tencent.mm.plugin.sns.ad.landingpage.helper.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public volatile boolean yXA;
  
  public static a dRv()
  {
    AppMethodBeat.i(197596);
    try
    {
      a locala = new a();
      AppMethodBeat.o(197596);
      return locala;
    }
    catch (Throwable localThrowable)
    {
      ad.d("SnsAd.VideoCompletionHelper", "new instance failed!");
      AppMethodBeat.o(197596);
    }
    return null;
  }
  
  public final void sendMessage()
  {
    AppMethodBeat.i(197597);
    ad.d("SnsAd.VideoCompletionHelper", "sendMessage video is called");
    if (this.yXA) {
      com.tencent.mm.sdk.b.a.IbL.l(new uc());
    }
    this.yXA = false;
    AppMethodBeat.o(197597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a
 * JD-Core Version:    0.7.0.1
 */