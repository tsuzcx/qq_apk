package com.tencent.mm.plugin.vlog.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/MultiEditStatus;", "", "(Ljava/lang/String;I)V", "DEFAULT", "GLOBAL_EDIT", "SINGLE_EDIT", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b
{
  static
  {
    AppMethodBeat.i(281564);
    Ufa = new b("DEFAULT", 0);
    Ufb = new b("GLOBAL_EDIT", 1);
    Ufc = new b("SINGLE_EDIT", 2);
    Ufd = new b[] { Ufa, Ufb, Ufc };
    AppMethodBeat.o(281564);
  }
  
  private b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.b
 * JD-Core Version:    0.7.0.1
 */