package com.tencent.mm.plugin.multitask.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "", "(Ljava/lang/String;I)V", "MODE_SHOW_SINGLE_SCENE", "MODE_SHOW_MULTI_SCENE", "MODE_SHOW_SNAPSHOT_SCENE", "MODE_NONE", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum a$b
{
  static
  {
    AppMethodBeat.i(304136);
    LDp = new b("MODE_SHOW_SINGLE_SCENE", 0);
    LDq = new b("MODE_SHOW_MULTI_SCENE", 1);
    LDr = new b("MODE_SHOW_SNAPSHOT_SCENE", 2);
    LDs = new b("MODE_NONE", 3);
    LDt = new b[] { LDp, LDq, LDr, LDs };
    AppMethodBeat.o(304136);
  }
  
  private a$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.a.b
 * JD-Core Version:    0.7.0.1
 */