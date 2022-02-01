package com.tencent.mm.plugin.multitask.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "", "(Ljava/lang/String;I)V", "MODE_SHOW_SINGLE_SCENE", "MODE_SHOW_MULTI_SCENE", "MODE_SHOW_SNAPSHOT_SCENE", "MODE_NONE", "plugin-multitask_release"})
public enum a$b
{
  static
  {
    AppMethodBeat.i(247579);
    b localb1 = new b("MODE_SHOW_SINGLE_SCENE", 0);
    FHW = localb1;
    b localb2 = new b("MODE_SHOW_MULTI_SCENE", 1);
    FHX = localb2;
    b localb3 = new b("MODE_SHOW_SNAPSHOT_SCENE", 2);
    FHY = localb3;
    b localb4 = new b("MODE_NONE", 3);
    FHZ = localb4;
    FIa = new b[] { localb1, localb2, localb3, localb4 };
    AppMethodBeat.o(247579);
  }
  
  private a$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.a.b
 * JD-Core Version:    0.7.0.1
 */