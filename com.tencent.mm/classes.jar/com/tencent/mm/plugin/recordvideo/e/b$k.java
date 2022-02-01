package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class b$k
  implements Runnable
{
  public static final k LpT;
  
  static
  {
    AppMethodBeat.i(204328);
    LpT = new k();
    AppMethodBeat.o(204328);
  }
  
  public final void run()
  {
    AppMethodBeat.i(204327);
    Object localObject1 = b.vtE;
    localObject1 = b.fYx().decodeStringSet("media_file_delete_set", (Set)new HashSet());
    k.g(localObject1, "set");
    Object localObject2 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      i.deleteFile((String)((Iterator)localObject2).next());
    }
    ((Set)localObject1).clear();
    localObject2 = b.vtE;
    b.fYx().encode("media_timing_delete_set", (Set)localObject1);
    AppMethodBeat.o(204327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.k
 * JD-Core Version:    0.7.0.1
 */