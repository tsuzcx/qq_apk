package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.y;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

final class e$1
  implements Runnable
{
  e$1(e parame, LinkedHashMap paramLinkedHashMap) {}
  
  public final void run()
  {
    AppMethodBeat.i(36880);
    long l = bo.yB();
    int j = this.roW.size();
    if (j >= e.a(this.roX))
    {
      int k = e.a(this.roX);
      Iterator localIterator = this.roW.keySet().iterator();
      int i = 0;
      while ((localIterator.hasNext()) && (i < j - k))
      {
        localIterator.next();
        localIterator.remove();
        i += 1;
      }
      al.d(new e.1.1(this));
    }
    e.c(this.roX).set(6, this.roW);
    ab.i("MicroMsg.SnsReportHelper", "save exposure feed id for cgi [%d] oriSize[%d] cost[%d]", new Object[] { Integer.valueOf(this.roW.size()), Integer.valueOf(j), Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(36880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.e.1
 * JD-Core Version:    0.7.0.1
 */