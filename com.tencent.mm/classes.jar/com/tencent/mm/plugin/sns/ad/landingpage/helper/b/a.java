package com.tencent.mm.plugin.sns.ad.landingpage.helper.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ve;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public volatile boolean Duo;
  
  public static a eXm()
  {
    AppMethodBeat.i(202028);
    try
    {
      a locala = new a();
      AppMethodBeat.o(202028);
      return locala;
    }
    catch (Throwable localThrowable)
    {
      Log.d("SnsAd.VideoCompletionHelper", "new instance failed!");
      AppMethodBeat.o(202028);
    }
    return null;
  }
  
  public final void sendMessage()
  {
    AppMethodBeat.i(202029);
    Log.d("SnsAd.VideoCompletionHelper", "sendMessage video is called");
    if (this.Duo) {
      EventCenter.instance.publish(new ve());
    }
    this.Duo = false;
    AppMethodBeat.o(202029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.landingpage.helper.b.a
 * JD-Core Version:    0.7.0.1
 */