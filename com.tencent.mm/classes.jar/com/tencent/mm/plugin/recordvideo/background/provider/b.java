package com.tencent.mm.plugin.recordvideo.background.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hi;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProviderInfo;", "Lcom/tencent/mm/autogen/table/BaseWeseeProviderInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-recordvideo_release"})
public final class b
  extends hi
{
  private static final String[] INDEX_CREATE;
  private static final String TABLE = "WeseeProviderInfo";
  private static final c.a hGW;
  public static final b.a xMz;
  
  static
  {
    AppMethodBeat.i(75340);
    xMz = new b.a((byte)0);
    hGW = hi.VD();
    TABLE = "WeseeProviderInfo";
    INDEX_CREATE = hi.INDEX_CREATE;
    AppMethodBeat.o(75340);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(75339);
    c.a locala = hGW;
    p.g(locala, "INFO");
    AppMethodBeat.o(75339);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.b
 * JD-Core Version:    0.7.0.1
 */