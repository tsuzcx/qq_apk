package com.tencent.mm.plugin.textstatus.f.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.h.c;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusUserNameMap;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatusUserNameMap;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-textstatus_release"})
public final class e
  extends c
{
  private static final IAutoDBItem.MAutoDBInfo FZC;
  public static final a FZM;
  
  static
  {
    AppMethodBeat.i(216287);
    FZM = new a((byte)0);
    FZC = c.ajs();
    AppMethodBeat.o(216287);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(216286);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = FZC;
    p.g(localMAutoDBInfo, "_dbInfo");
    AppMethodBeat.o(216286);
    return localMAutoDBInfo;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusUserNameMap$Companion;", "", "()V", "TAG", "", "_dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "get_dbInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.f.e
 * JD-Core Version:    0.7.0.1
 */