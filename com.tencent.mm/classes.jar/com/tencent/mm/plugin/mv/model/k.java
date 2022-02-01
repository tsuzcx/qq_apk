package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCacheKey;", "", "songInfoBase64", "", "(Ljava/lang/String;)V", "getSongInfoBase64", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  private final String LXI;
  
  public k(String paramString)
  {
    AppMethodBeat.i(286044);
    this.LXI = paramString;
    AppMethodBeat.o(286044);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(286058);
    if (this == paramObject)
    {
      AppMethodBeat.o(286058);
      return true;
    }
    if (!(paramObject instanceof k))
    {
      AppMethodBeat.o(286058);
      return false;
    }
    paramObject = (k)paramObject;
    if (!s.p(this.LXI, paramObject.LXI))
    {
      AppMethodBeat.o(286058);
      return false;
    }
    AppMethodBeat.o(286058);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(286053);
    int i = this.LXI.hashCode();
    AppMethodBeat.o(286053);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(286050);
    String str = "MusicMvRecommendListCacheKey(songInfoBase64=" + this.LXI + ')';
    AppMethodBeat.o(286050);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.k
 * JD-Core Version:    0.7.0.1
 */