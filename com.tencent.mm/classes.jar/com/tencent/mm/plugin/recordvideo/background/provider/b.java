package com.tencent.mm.plugin.recordvideo.background.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.iy;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProviderInfo;", "Lcom/tencent/mm/autogen/table/BaseWeseeProviderInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends iy
{
  private static final String[] INDEX_CREATE;
  public static final b.a NGj;
  private static final IAutoDBItem.MAutoDBInfo nVV;
  private static final String ptT;
  
  static
  {
    AppMethodBeat.i(75340);
    NGj = new b.a((byte)0);
    nVV = iy.aJm();
    ptT = "WeseeProviderInfo";
    INDEX_CREATE = iy.INDEX_CREATE;
    AppMethodBeat.o(75340);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(75339);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = nVV;
    s.s(localMAutoDBInfo, "INFO");
    AppMethodBeat.o(75339);
    return localMAutoDBInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.b
 * JD-Core Version:    0.7.0.1
 */