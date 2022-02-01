package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TextureInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/TrackRenderInfo;", "", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "texture", "Lcom/tencent/tav/coremedia/TextureInfo;", "(Lcom/tencent/mm/videocomposition/CompositionTrack;Lcom/tencent/tav/coremedia/TextureInfo;)V", "getTexture", "()Lcom/tencent/tav/coremedia/TextureInfo;", "setTexture", "(Lcom/tencent/tav/coremedia/TextureInfo;)V", "getTrack", "()Lcom/tencent/mm/videocomposition/CompositionTrack;", "setTrack", "(Lcom/tencent/mm/videocomposition/CompositionTrack;)V", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class f
{
  public b UaI;
  public TextureInfo texture;
  
  public f(b paramb, TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(233467);
    this.UaI = paramb;
    this.texture = paramTextureInfo;
    AppMethodBeat.o(233467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.videocomposition.f
 * JD-Core Version:    0.7.0.1
 */