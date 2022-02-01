package com.tencent.mm.plugin.repairer.ui.demo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ek;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/demo/LiveMainDemoDBInfo;", "Lcom/tencent/mm/autogen/table/BaseLiveDemoDBInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "ui-repairer_release"})
public final class i
  extends ek
{
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(226988);
    getClass();
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = ek.aoY();
    p.j(localMAutoDBInfo, "initAutoDBInfo(this.javaClass)");
    AppMethodBeat.o(226988);
    return localMAutoDBInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.i
 * JD-Core Version:    0.7.0.1
 */