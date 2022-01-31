package com.tencent.mm.plugin.story.model;

import a.a.e;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.b;
import java.util.Comparator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
public final class i$a$a
  implements Runnable
{
  public static final a suK;
  
  static
  {
    AppMethodBeat.i(109036);
    suK = new a();
    AppMethodBeat.o(109036);
  }
  
  public final void run()
  {
    AppMethodBeat.i(109035);
    Object localObject1 = i.suJ;
    localObject1 = new b(i.cAu()).dQL();
    if (localObject1 != null)
    {
      if (localObject1.length > 1) {
        e.a((Object[])localObject1, (Comparator)new i.a.a.a());
      }
      int k = localObject1.length;
      int j = 0;
      int i = 0;
      while (j < k)
      {
        Object localObject2 = localObject1[j];
        if (i >= 20) {
          localObject2.delete();
        }
        j += 1;
        i += 1;
      }
    }
    AppMethodBeat.o(109035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.i.a.a
 * JD-Core Version:    0.7.0.1
 */