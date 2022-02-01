package com.tencent.mm.plugin.sns.ad.landingpage.helper.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public volatile boolean zoc;
  
  public static a dUT()
  {
    AppMethodBeat.i(219057);
    try
    {
      a locala = new a();
      AppMethodBeat.o(219057);
      return locala;
    }
    catch (Throwable localThrowable)
    {
      ae.d("SnsAd.VideoCompletionHelper", "new instance failed!");
      AppMethodBeat.o(219057);
    }
    return null;
  }
  
  public final void sendMessage()
  {
    AppMethodBeat.i(219058);
    ae.d("SnsAd.VideoCompletionHelper", "sendMessage video is called");
    if (this.zoc) {
      com.tencent.mm.sdk.b.a.IvT.l(new ug());
    }
    this.zoc = false;
    AppMethodBeat.o(219058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a
 * JD-Core Version:    0.7.0.1
 */