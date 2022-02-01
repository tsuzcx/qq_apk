package com.tencent.mm.plugin.recordvideo.background.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gx;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProviderInfo;", "Lcom/tencent/mm/autogen/table/BaseWeseeProviderInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-recordvideo_release"})
public final class b
  extends gx
{
  private static final String[] INDEX_CREATE;
  private static final String TABLE = "WeseeProviderInfo";
  private static final c.a hlR;
  public static final b.a woM;
  
  static
  {
    AppMethodBeat.i(75340);
    woM = new b.a((byte)0);
    hlR = gx.Th();
    TABLE = "WeseeProviderInfo";
    INDEX_CREATE = gx.INDEX_CREATE;
    AppMethodBeat.o(75340);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(75339);
    c.a locala = hlR;
    k.g(locala, "INFO");
    AppMethodBeat.o(75339);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.b
 * JD-Core Version:    0.7.0.1
 */