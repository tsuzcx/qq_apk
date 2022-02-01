package com.tencent.mm.plugin.recordvideo.background.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hh;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProviderInfo;", "Lcom/tencent/mm/autogen/table/BaseWeseeProviderInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-recordvideo_release"})
public final class b
  extends hh
{
  private static final String[] INDEX_CREATE;
  private static final String TABLE = "WeseeProviderInfo";
  private static final c.a hEe;
  public static final a xwC;
  
  static
  {
    AppMethodBeat.i(75340);
    xwC = new a((byte)0);
    hEe = hh.Vv();
    TABLE = "WeseeProviderInfo";
    INDEX_CREATE = hh.INDEX_CREATE;
    AppMethodBeat.o(75340);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(75339);
    c.a locala = hEe;
    p.g(locala, "INFO");
    AppMethodBeat.o(75339);
    return locala;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProviderInfo$Companion;", "", "()V", "INDEX_CREATE", "", "", "kotlin.jvm.PlatformType", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getINFO", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "TABLE", "getTABLE", "()Ljava/lang/String;", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.b
 * JD-Core Version:    0.7.0.1
 */