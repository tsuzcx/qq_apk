package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.plugin.welab.d.a.a;
import com.tencent.mm.sdk.e.j;

final class PluginWelab$2
  implements h.d
{
  PluginWelab$2(PluginWelab paramPluginWelab) {}
  
  public final String[] getSQLs()
  {
    AppMethodBeat.i(80517);
    String str = j.getCreateSQLs(a.info, "LabAppInfo");
    AppMethodBeat.o(80517);
    return new String[] { str };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.PluginWelab.2
 * JD-Core Version:    0.7.0.1
 */