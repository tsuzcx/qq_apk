package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TextureInfo;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/TrackRenderInfo;", "", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "texture", "Lcom/tencent/tav/coremedia/TextureInfo;", "(Lcom/tencent/mm/videocomposition/CompositionTrack;Lcom/tencent/tav/coremedia/TextureInfo;)V", "getTexture", "()Lcom/tencent/tav/coremedia/TextureInfo;", "setTexture", "(Lcom/tencent/tav/coremedia/TextureInfo;)V", "getTrack", "()Lcom/tencent/mm/videocomposition/CompositionTrack;", "setTrack", "(Lcom/tencent/mm/videocomposition/CompositionTrack;)V", "video_composition_release"})
public final class j
{
  public d GzA;
  public TextureInfo texture;
  
  public j(d paramd, TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(216758);
    this.GzA = paramd;
    this.texture = paramTextureInfo;
    AppMethodBeat.o(216758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.videocomposition.j
 * JD-Core Version:    0.7.0.1
 */