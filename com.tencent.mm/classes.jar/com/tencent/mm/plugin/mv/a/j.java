package com.tencent.mm.plugin.mv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCacheKey;", "", "songInfoBase64", "", "(Ljava/lang/String;)V", "getSongInfoBase64", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-mv_release"})
public final class j
{
  private final String Aqk;
  
  public j(String paramString)
  {
    AppMethodBeat.i(256806);
    this.Aqk = paramString;
    AppMethodBeat.o(256806);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(256809);
    if (this != paramObject)
    {
      if ((paramObject instanceof j))
      {
        paramObject = (j)paramObject;
        if (!p.j(this.Aqk, paramObject.Aqk)) {}
      }
    }
    else
    {
      AppMethodBeat.o(256809);
      return true;
    }
    AppMethodBeat.o(256809);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(256808);
    String str = this.Aqk;
    if (str != null)
    {
      int i = str.hashCode();
      AppMethodBeat.o(256808);
      return i;
    }
    AppMethodBeat.o(256808);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(256807);
    String str = "MusicMvRecommendListCacheKey(songInfoBase64=" + this.Aqk + ")";
    AppMethodBeat.o(256807);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.j
 * JD-Core Version:    0.7.0.1
 */