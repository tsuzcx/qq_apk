package com.tencent.mm.plugin.textstatus.g.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.i.d;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusUserNameMap;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatusUserNameMap;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-textstatus_release"})
public final class g
  extends d
{
  private static final IAutoDBItem.MAutoDBInfo MDR;
  public static final a MEf;
  
  static
  {
    AppMethodBeat.i(237688);
    MEf = new a((byte)0);
    MDR = d.aoY();
    AppMethodBeat.o(237688);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(237686);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = MDR;
    p.j(localMAutoDBInfo, "_dbInfo");
    AppMethodBeat.o(237686);
    return localMAutoDBInfo;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusUserNameMap$Companion;", "", "()V", "TAG", "", "_dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "get_dbInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.e.g
 * JD-Core Version:    0.7.0.1
 */