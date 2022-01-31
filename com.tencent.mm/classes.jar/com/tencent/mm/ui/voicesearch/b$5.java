package com.tencent.mm.ui.voicesearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class b$5
  implements Runnable
{
  b$5(b paramb, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(35331);
    if (b.a(this.ABH) == null) {
      b.a(this.ABH, new ArrayList());
    }
    b.a(this.ABH).clear();
    b.a(this.ABH).addAll(this.ieO);
    b.a(this.ABH).add("officialaccounts");
    b.a(this.ABH).add("helper_entry");
    AppMethodBeat.o(35331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b.5
 * JD-Core Version:    0.7.0.1
 */