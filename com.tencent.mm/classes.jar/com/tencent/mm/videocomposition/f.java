package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TextureInfo;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/TrackRenderInfo;", "", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "texture", "Lcom/tencent/tav/coremedia/TextureInfo;", "(Lcom/tencent/mm/videocomposition/CompositionTrack;Lcom/tencent/tav/coremedia/TextureInfo;)V", "getTexture", "()Lcom/tencent/tav/coremedia/TextureInfo;", "setTexture", "(Lcom/tencent/tav/coremedia/TextureInfo;)V", "getTrack", "()Lcom/tencent/mm/videocomposition/CompositionTrack;", "setTrack", "(Lcom/tencent/mm/videocomposition/CompositionTrack;)V", "video_composition_release"})
public final class f
{
  public b Nng;
  public TextureInfo texture;
  
  public f(b paramb, TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(247961);
    this.Nng = paramb;
    this.texture = paramTextureInfo;
    AppMethodBeat.o(247961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.f
 * JD-Core Version:    0.7.0.1
 */