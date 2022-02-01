package com.tencent.mm.wexnet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/Options;", "", "numThreads", "", "cachePath", "", "(ILjava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Options
{
  public String cachePath;
  public int numThreads;
  
  public Options(int paramInt, String paramString)
  {
    AppMethodBeat.i(231554);
    this.numThreads = paramInt;
    this.cachePath = paramString;
    AppMethodBeat.o(231554);
  }
  
  public final int component1()
  {
    return this.numThreads;
  }
  
  public final String component2()
  {
    return this.cachePath;
  }
  
  public final Options copy(int paramInt, String paramString)
  {
    AppMethodBeat.i(231574);
    s.u(paramString, "cachePath");
    paramString = new Options(paramInt, paramString);
    AppMethodBeat.o(231574);
    return paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(231588);
    if (this == paramObject)
    {
      AppMethodBeat.o(231588);
      return true;
    }
    if (!(paramObject instanceof Options))
    {
      AppMethodBeat.o(231588);
      return false;
    }
    paramObject = (Options)paramObject;
    if (this.numThreads != paramObject.numThreads)
    {
      AppMethodBeat.o(231588);
      return false;
    }
    if (!s.p(this.cachePath, paramObject.cachePath))
    {
      AppMethodBeat.o(231588);
      return false;
    }
    AppMethodBeat.o(231588);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(231583);
    int i = this.numThreads;
    int j = this.cachePath.hashCode();
    AppMethodBeat.o(231583);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(231581);
    String str = "Options(numThreads=" + this.numThreads + ", cachePath=" + this.cachePath + ')';
    AppMethodBeat.o(231581);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wexnet.Options
 * JD-Core Version:    0.7.0.1
 */