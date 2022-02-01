package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCacheKey;", "", "songInfoBase64", "", "(Ljava/lang/String;)V", "getSongInfoBase64", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-mv_release"})
public final class k
{
  private final String GbY;
  
  public k(String paramString)
  {
    AppMethodBeat.i(230152);
    this.GbY = paramString;
    AppMethodBeat.o(230152);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(230158);
    if (this != paramObject)
    {
      if ((paramObject instanceof k))
      {
        paramObject = (k)paramObject;
        if (!p.h(this.GbY, paramObject.GbY)) {}
      }
    }
    else
    {
      AppMethodBeat.o(230158);
      return true;
    }
    AppMethodBeat.o(230158);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(230155);
    String str = this.GbY;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(230155);
      return i;
    }
    AppMethodBeat.o(230155);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(230153);
    String str = "MusicMvRecommendListCacheKey(songInfoBase64=" + this.GbY + ")";
    AppMethodBeat.o(230153);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.k
 * JD-Core Version:    0.7.0.1
 */