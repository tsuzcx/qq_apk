package com.tencent.mm.plugin.textstatus.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/download/TextStatusImage;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "toString", "uniqueValue", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements c
{
  private final String url;
  
  public b(String paramString)
  {
    AppMethodBeat.i(289653);
    this.url = paramString;
    AppMethodBeat.o(289653);
  }
  
  public final String aUt()
  {
    return this.url;
  }
  
  public final String toString()
  {
    return this.url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.c.b
 * JD-Core Version:    0.7.0.1
 */