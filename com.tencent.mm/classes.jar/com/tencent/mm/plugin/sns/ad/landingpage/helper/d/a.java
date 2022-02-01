package com.tencent.mm.plugin.sns.ad.landingpage.helper.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.wi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public volatile boolean JDG;
  
  public static a fKN()
  {
    AppMethodBeat.i(263826);
    try
    {
      a locala = new a();
      AppMethodBeat.o(263826);
      return locala;
    }
    catch (Throwable localThrowable)
    {
      Log.d("SnsAd.VideoCompletionHelper", "new instance failed!");
      AppMethodBeat.o(263826);
    }
    return null;
  }
  
  public final void sendMessage()
  {
    AppMethodBeat.i(263827);
    Log.d("SnsAd.VideoCompletionHelper", "sendMessage video is called");
    if (this.JDG) {
      EventCenter.instance.publish(new wi());
    }
    this.JDG = false;
    AppMethodBeat.o(263827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.d.a
 * JD-Core Version:    0.7.0.1
 */