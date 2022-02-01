package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsp;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"dump", "", "Lcom/tencent/mm/protocal/protobuf/MMSPRRecommendedMusicFeedback;", "plugin-recordvideo_release"})
public final class d
{
  public static final String a(bsp parambsp)
  {
    AppMethodBeat.i(169931);
    k.h(parambsp, "$this$dump");
    parambsp = parambsp.Fhx + ' ' + parambsp.Fhy + ' ' + parambsp.Fhz + ' ' + parambsp.FhA;
    AppMethodBeat.o(169931);
    return parambsp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.audio.d
 * JD-Core Version:    0.7.0.1
 */