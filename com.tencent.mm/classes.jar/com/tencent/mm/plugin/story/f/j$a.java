package com.tencent.mm.plugin.story.f;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class j$a
  implements Runnable
{
  j$a(j paramj, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(109641);
    if (((f)j.h(this.sCm).get(this.sBp)).sBG != 2) {
      j.i(this.sCm).add(Integer.valueOf(this.sBp));
    }
    int i = this.sBp + 1;
    if (i < j.d(this.sCm).size())
    {
      j.i(this.sCm).add(Integer.valueOf(i));
      j.j(this.sCm);
    }
    AppMethodBeat.o(109641);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.j.a
 * JD-Core Version:    0.7.0.1
 */