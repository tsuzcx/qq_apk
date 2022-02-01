package com.tencent.mm.plugin.taskbar.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgLogImpl;", "Lcom/tencent/mm/dynamicbackground/util/DynamicBgLog$LogImp;", "()V", "d", "", "tag", "", "log", "e", "i", "v", "w", "plugin-taskbar_release"})
public final class d
  implements c.a
{
  public static final d Mqz;
  
  static
  {
    AppMethodBeat.i(214948);
    Mqz = new d();
    AppMethodBeat.o(214948);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214945);
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(214945);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214938);
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(214938);
  }
  
  public final void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214944);
    Log.v(paramString1, paramString2);
    AppMethodBeat.o(214944);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(214942);
    Log.w(paramString1, paramString2);
    AppMethodBeat.o(214942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a.d
 * JD-Core Version:    0.7.0.1
 */