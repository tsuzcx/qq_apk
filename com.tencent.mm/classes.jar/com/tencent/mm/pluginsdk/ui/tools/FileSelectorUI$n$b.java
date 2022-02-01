package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.z;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "filename", "", "accept"})
final class FileSelectorUI$n$b
  implements z
{
  public static final b Rwp;
  
  static
  {
    AppMethodBeat.i(226257);
    Rwp = new b();
    AppMethodBeat.o(226257);
  }
  
  public final boolean accept(q paramq, String paramString)
  {
    AppMethodBeat.i(226256);
    p.k(paramString, "filename");
    if (!n.M(paramString, ".", false))
    {
      AppMethodBeat.o(226256);
      return true;
    }
    AppMethodBeat.o(226256);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.n.b
 * JD-Core Version:    0.7.0.1
 */