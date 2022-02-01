package com.tencent.mm.plugin.taskbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/TaskBarLogic;", "", "()V", "getCoverImgPath", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "id", "plugin-taskbar_release"})
public final class f
{
  public static final f FSa;
  
  static
  {
    AppMethodBeat.i(238422);
    FSa = new f();
    AppMethodBeat.o(238422);
  }
  
  public static String aGJ(String paramString)
  {
    AppMethodBeat.i(238421);
    p.h(paramString, "id");
    StringBuilder localStringBuilder = new StringBuilder();
    g localg = g.FSd;
    paramString = g.fut() + paramString;
    AppMethodBeat.o(238421);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.f
 * JD-Core Version:    0.7.0.1
 */