package com.tencent.mm.plugin.vlog.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/MultiEditStatus;", "", "(Ljava/lang/String;I)V", "DEFAULT", "GLOBAL_EDIT", "SINGLE_EDIT", "plugin-vlog_release"})
public enum b
{
  static
  {
    AppMethodBeat.i(191459);
    b localb1 = new b("DEFAULT", 0);
    CbI = localb1;
    b localb2 = new b("GLOBAL_EDIT", 1);
    CbJ = localb2;
    b localb3 = new b("SINGLE_EDIT", 2);
    CbK = localb3;
    CbL = new b[] { localb1, localb2, localb3 };
    AppMethodBeat.o(191459);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.b
 * JD-Core Version:    0.7.0.1
 */