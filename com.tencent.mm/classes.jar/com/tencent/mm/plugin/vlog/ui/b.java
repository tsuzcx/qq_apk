package com.tencent.mm.plugin.vlog.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/MultiEditStatus;", "", "(Ljava/lang/String;I)V", "DEFAULT", "GLOBAL_EDIT", "SINGLE_EDIT", "plugin-vlog_release"})
public enum b
{
  static
  {
    AppMethodBeat.i(190943);
    b localb1 = new b("DEFAULT", 0);
    GDA = localb1;
    b localb2 = new b("GLOBAL_EDIT", 1);
    GDB = localb2;
    b localb3 = new b("SINGLE_EDIT", 2);
    GDC = localb3;
    GDD = new b[] { localb1, localb2, localb3 };
    AppMethodBeat.o(190943);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.b
 * JD-Core Version:    0.7.0.1
 */