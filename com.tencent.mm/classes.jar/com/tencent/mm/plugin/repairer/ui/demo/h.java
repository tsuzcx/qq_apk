package com.tencent.mm.plugin.repairer.ui.demo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ek;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/demo/LiveDemoDBInfo;", "Lcom/tencent/mm/autogen/table/BaseLiveDemoDBInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "ui-repairer_release"})
public final class h
  extends ek
{
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(226584);
    getClass();
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = ek.aoY();
    p.j(localMAutoDBInfo, "initAutoDBInfo(this.javaClass)");
    AppMethodBeat.o(226584);
    return localMAutoDBInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.h
 * JD-Core Version:    0.7.0.1
 */