package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TextureInfo;
import d.l;

@l(gfx={1, 1, 15}, gfy={""}, gfz={"Lcom/tencent/mm/videocomposition/TrackRenderInfo;", "", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "texture", "Lcom/tencent/tav/coremedia/TextureInfo;", "(Lcom/tencent/mm/videocomposition/CompositionTrack;Lcom/tencent/tav/coremedia/TextureInfo;)V", "getTexture", "()Lcom/tencent/tav/coremedia/TextureInfo;", "setTexture", "(Lcom/tencent/tav/coremedia/TextureInfo;)V", "getTrack", "()Lcom/tencent/mm/videocomposition/CompositionTrack;", "setTrack", "(Lcom/tencent/mm/videocomposition/CompositionTrack;)V", "video_composition_release"})
public final class f
{
  public b BGw;
  public TextureInfo texture;
  
  public f(b paramb, TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(220829);
    this.BGw = paramb;
    this.texture = paramTextureInfo;
    AppMethodBeat.o(220829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.f
 * JD-Core Version:    0.7.0.1
 */