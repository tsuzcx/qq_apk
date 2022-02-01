package com.tencent.mm.plugin.multitask.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "", "(Ljava/lang/String;I)V", "MODE_SHOW_SINGLE_SCENE", "MODE_SHOW_MULTI_SCENE", "MODE_SHOW_SNAPSHOT_SCENE", "MODE_NONE", "plugin-multitask_release"})
public enum a$b
{
  static
  {
    AppMethodBeat.i(200645);
    b localb1 = new b("MODE_SHOW_SINGLE_SCENE", 0);
    Acg = localb1;
    b localb2 = new b("MODE_SHOW_MULTI_SCENE", 1);
    Ach = localb2;
    b localb3 = new b("MODE_SHOW_SNAPSHOT_SCENE", 2);
    Aci = localb3;
    b localb4 = new b("MODE_NONE", 3);
    Acj = localb4;
    Ack = new b[] { localb1, localb2, localb3, localb4 };
    AppMethodBeat.o(200645);
  }
  
  private a$b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.a.b
 * JD-Core Version:    0.7.0.1
 */