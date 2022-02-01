package com.tencent.mm.plugin.sns.ad.landingpage.helper.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.yb;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public volatile boolean PUG;
  
  public static a hbd()
  {
    AppMethodBeat.i(310808);
    try
    {
      a locala = new a();
      AppMethodBeat.o(310808);
      return locala;
    }
    finally
    {
      Log.d("SnsAd.VideoCompletionHelper", "new instance failed!");
      AppMethodBeat.o(310808);
    }
    return null;
  }
  
  public final void hbe()
  {
    AppMethodBeat.i(310823);
    Log.d("SnsAd.VideoCompletionHelper", "sendMessage video is called");
    if (this.PUG) {
      new yb().publish();
    }
    this.PUG = false;
    AppMethodBeat.o(310823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.c.a
 * JD-Core Version:    0.7.0.1
 */