package com.tencent.mm.plugin.textstatus.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatusLike;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-textstatus_release"})
public final class b
  extends com.tencent.mm.plugin.textstatus.h.b
{
  private static final IAutoDBItem.MAutoDBInfo FZC;
  private static final int FZE = 0;
  private static final int FZF = 1;
  public static final a FZG;
  
  static
  {
    AppMethodBeat.i(216252);
    FZG = new a((byte)0);
    FZC = com.tencent.mm.plugin.textstatus.h.b.ajs();
    FZF = 1;
    AppMethodBeat.o(216252);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(216251);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = FZC;
    p.g(localMAutoDBInfo, "_dbInfo");
    AppMethodBeat.o(216251);
    return localMAutoDBInfo;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike$Companion;", "", "()V", "ACTION_TYPE_LIKE", "", "getACTION_TYPE_LIKE", "()I", "ACTION_TYPE_UNLIKE", "getACTION_TYPE_UNLIKE", "TAG", "", "_dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "get_dbInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.f.b
 * JD-Core Version:    0.7.0.1
 */