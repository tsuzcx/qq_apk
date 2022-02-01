package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/VLogCompositionThumbGenerator$Companion;", "", "()V", "DefaultMaxImageSize", "", "TAG", "", "thumbCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "Landroid/graphics/Bitmap;", "clearCache", "", "fromVLogComposition", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionThumbGenerator;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "fromVLogCompositionTrack", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "plugin-vlog_release"})
public final class t$a
{
  public static t f(r paramr)
  {
    AppMethodBeat.i(207604);
    k.h(paramr, "composition");
    paramr = new t(paramr.buildSource(), String.valueOf(paramr.hashCode()), (byte)0);
    AppMethodBeat.o(207604);
    return paramr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.t.a
 * JD-Core Version:    0.7.0.1
 */