package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "filename", "", "accept"})
final class FileSelectorUI$m$b
  implements w
{
  public static final b Kve;
  
  static
  {
    AppMethodBeat.i(231108);
    Kve = new b();
    AppMethodBeat.o(231108);
  }
  
  public final boolean accept(o paramo, String paramString)
  {
    AppMethodBeat.i(231107);
    p.h(paramString, "filename");
    if (!n.J(paramString, ".", false))
    {
      AppMethodBeat.o(231107);
      return true;
    }
    AppMethodBeat.o(231107);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.m.b
 * JD-Core Version:    0.7.0.1
 */