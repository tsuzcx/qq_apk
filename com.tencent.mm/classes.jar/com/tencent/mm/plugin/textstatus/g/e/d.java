package com.tencent.mm.plugin.textstatus.g.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.i.c;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;", "Lcom/tencent/mm/plugin/textstatus/storage/BaseTextStatusReference;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getTopicInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusTopicInfo;", "Companion", "plugin-textstatus_release"})
public final class d
  extends c
{
  private static final IAutoDBItem.MAutoDBInfo MDR;
  public static final d.a MEa;
  
  static
  {
    AppMethodBeat.i(236062);
    MEa = new d.a((byte)0);
    MDR = c.aoY();
    AppMethodBeat.o(236062);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(236058);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = MDR;
    p.j(localMAutoDBInfo, "_dbInfo");
    AppMethodBeat.o(236058);
    return localMAutoDBInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.e.d
 * JD-Core Version:    0.7.0.1
 */