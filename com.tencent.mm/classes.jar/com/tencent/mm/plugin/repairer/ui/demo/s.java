package com.tencent.mm.plugin.repairer.ui.demo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ey;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.IndexSql;
import com.tencent.mm.sdk.storage.sql.IndexSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/LiveDemoDBInfo;", "Lcom/tencent/mm/autogen/table/BaseLiveDemoDBInfo;", "()V", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getIndexCreateSQL", "", "", "()[Ljava/lang/String;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends ey
{
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(278593);
    getClass();
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = ey.aJm();
    kotlin.g.b.s.s(localMAutoDBInfo, "initAutoDBInfo(this.javaClass)");
    AppMethodBeat.o(278593);
    return localMAutoDBInfo;
  }
  
  public final String[] getIndexCreateSQL()
  {
    AppMethodBeat.i(278605);
    String str = ey.TABLE.index("Test").on(p.listOf(ey.kkd)).log("MicroMsg.RepairerLiveDBDemoUI").build().toSql();
    AppMethodBeat.o(278605);
    return new String[] { str };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.s
 * JD-Core Version:    0.7.0.1
 */