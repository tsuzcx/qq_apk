package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;

final class e$1$1
  implements Runnable
{
  e$1$1(e.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(36879);
    LinkedHashMap localLinkedHashMap = e.b(this.roY.roX);
    e.a(this.roY.roX, this.roY.roW);
    localLinkedHashMap.clear();
    AppMethodBeat.o(36879);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.e.1.1
 * JD-Core Version:    0.7.0.1
 */