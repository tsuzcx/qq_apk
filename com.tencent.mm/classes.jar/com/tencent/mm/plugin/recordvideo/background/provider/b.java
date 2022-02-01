package com.tencent.mm.plugin.recordvideo.background.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hu;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProviderInfo;", "Lcom/tencent/mm/autogen/table/BaseWeseeProviderInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-recordvideo_release"})
public final class b
  extends hu
{
  public static final a BMF;
  private static final String[] INDEX_CREATE;
  private static final String TABLE = "WeseeProviderInfo";
  private static final IAutoDBItem.MAutoDBInfo iBg;
  
  static
  {
    AppMethodBeat.i(75340);
    BMF = new a((byte)0);
    iBg = hu.ajs();
    TABLE = "WeseeProviderInfo";
    INDEX_CREATE = hu.INDEX_CREATE;
    AppMethodBeat.o(75340);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(75339);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = iBg;
    p.g(localMAutoDBInfo, "INFO");
    AppMethodBeat.o(75339);
    return localMAutoDBInfo;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProviderInfo$Companion;", "", "()V", "INDEX_CREATE", "", "", "kotlin.jvm.PlatformType", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "INFO", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getINFO", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "TABLE", "getTABLE", "()Ljava/lang/String;", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.b
 * JD-Core Version:    0.7.0.1
 */