package com.tencent.mm.plugin.textstatus.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.a.c;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/download/TextStatusImage;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "toString", "uniqueValue", "plugin-textstatus_release"})
public final class b
  implements c
{
  private final String url;
  
  public b(String paramString)
  {
    AppMethodBeat.i(232091);
    this.url = paramString;
    AppMethodBeat.o(232091);
  }
  
  public final String aBv()
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