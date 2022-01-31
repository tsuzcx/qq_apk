package com.tencent.ttpic.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;

class LoadStickerItemManager3D$1
  implements FilenameFilter
{
  LoadStickerItemManager3D$1(LoadStickerItemManager3D paramLoadStickerItemManager3D) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    AppMethodBeat.i(81819);
    if ((paramString.endsWith(".png")) || (paramString.endsWith(".jpg")))
    {
      AppMethodBeat.o(81819);
      return true;
    }
    AppMethodBeat.o(81819);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadStickerItemManager3D.1
 * JD-Core Version:    0.7.0.1
 */