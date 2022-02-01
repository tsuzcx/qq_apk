package com.tencent.mm.plugin.taskbar.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgLogImpl;", "Lcom/tencent/mm/dynamicbackground/util/DynamicBgLog$LogImp;", "()V", "d", "", "tag", "", "log", "e", "i", "v", "w", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements c.a
{
  public static final d STL;
  
  static
  {
    AppMethodBeat.i(264128);
    STL = new d();
    AppMethodBeat.o(264128);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(264160);
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(264160);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(264137);
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(264137);
  }
  
  public final void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(264152);
    Log.v(paramString1, paramString2);
    AppMethodBeat.o(264152);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(264144);
    Log.w(paramString1, paramString2);
    AppMethodBeat.o(264144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a.d
 * JD-Core Version:    0.7.0.1
 */