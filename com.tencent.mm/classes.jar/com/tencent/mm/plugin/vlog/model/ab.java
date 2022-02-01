package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/TransitionType;", "", "(Ljava/lang/String;I)V", "NONE", "FADE", "plugin-vlog_release"})
public enum ab
{
  static
  {
    AppMethodBeat.i(110931);
    ab localab1 = new ab("NONE", 0);
    Gzk = localab1;
    ab localab2 = new ab("FADE", 1);
    Gzl = localab2;
    Gzm = new ab[] { localab1, localab2 };
    AppMethodBeat.o(110931);
  }
  
  private ab() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ab
 * JD-Core Version:    0.7.0.1
 */