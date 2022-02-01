package com.tencent.mm.plugin.taskbar.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.a.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/dynamicbackground/DynamicBgLogImpl;", "Lcom/tencent/mm/dynamicbackground/util/DynamicBgLog$LogImp;", "()V", "d", "", "tag", "", "log", "e", "i", "v", "w", "plugin-taskbar_release"})
public final class d
  implements c.a
{
  public static final d FVe;
  
  static
  {
    AppMethodBeat.i(238477);
    FVe = new d();
    AppMethodBeat.o(238477);
  }
  
  public final void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238476);
    Log.d(paramString1, paramString2);
    AppMethodBeat.o(238476);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238475);
    Log.e(paramString1, paramString2);
    AppMethodBeat.o(238475);
  }
  
  public final void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238472);
    Log.i(paramString1, paramString2);
    AppMethodBeat.o(238472);
  }
  
  public final void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238474);
    Log.v(paramString1, paramString2);
    AppMethodBeat.o(238474);
  }
  
  public final void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238473);
    Log.w(paramString1, paramString2);
    AppMethodBeat.o(238473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.a.d
 * JD-Core Version:    0.7.0.1
 */