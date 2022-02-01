package com.tencent.mm.plugin.recordvideo.background.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gt;
import com.tencent.mm.sdk.e.c.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProviderInfo;", "Lcom/tencent/mm/autogen/table/BaseWeseeProviderInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-recordvideo_release"})
public final class b
  extends gt
{
  private static final String[] INDEX_CREATE;
  private static final String TABLE = "WeseeProviderInfo";
  private static final c.a gLr;
  public static final a vga;
  
  static
  {
    AppMethodBeat.i(75340);
    vga = new a((byte)0);
    gLr = gt.So();
    TABLE = "WeseeProviderInfo";
    INDEX_CREATE = gt.INDEX_CREATE;
    AppMethodBeat.o(75340);
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(75339);
    c.a locala = gLr;
    k.g(locala, "INFO");
    AppMethodBeat.o(75339);
    return locala;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProviderInfo$Companion;", "", "()V", "INDEX_CREATE", "", "", "kotlin.jvm.PlatformType", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getINFO", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "TABLE", "getTABLE", "()Ljava/lang/String;", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.b
 * JD-Core Version:    0.7.0.1
 */