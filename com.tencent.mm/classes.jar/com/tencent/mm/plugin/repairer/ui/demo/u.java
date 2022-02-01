package com.tencent.mm.plugin.repairer.ui.demo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ey;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/LiveMainDemoDBInfo;", "Lcom/tencent/mm/autogen/table/BaseLiveDemoDBInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends ey
{
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(278595);
    getClass();
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = ey.aJm();
    s.s(localMAutoDBInfo, "initAutoDBInfo(this.javaClass)");
    AppMethodBeat.o(278595);
    return localMAutoDBInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.u
 * JD-Core Version:    0.7.0.1
 */