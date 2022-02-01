package com.tencent.mm.plugin.thumbplayer.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.j.d;

@Metadata(d1={""}, d2={"TAG", "", "random", "Lkotlin/random/Random;", "getRandom", "()Lkotlin/random/Random;", "plugin-thumbplayer_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final String TAG;
  private static final kotlin.j.c uiQ;
  
  static
  {
    AppMethodBeat.i(272183);
    TAG = "MicroMsg.CdnImageLoader";
    uiQ = d.BG(Util.currentTicks());
    AppMethodBeat.o(272183);
  }
  
  public static final kotlin.j.c hKB()
  {
    return uiQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.downloader.c
 * JD-Core Version:    0.7.0.1
 */