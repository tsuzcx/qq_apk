package com.tencent.mm.plugin.webview.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.s.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends s
{
  private List<s.a> kNQ;
  public long startTime;
  
  public d()
  {
    AppMethodBeat.i(10144);
    this.kNQ = new LinkedList();
    this.startTime = 0L;
    AppMethodBeat.o(10144);
  }
  
  public final void dhe()
  {
    AppMethodBeat.i(10145);
    if (bo.es(this.kNQ))
    {
      AppMethodBeat.o(10145);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.kNQ.iterator();
    while (localIterator.hasNext())
    {
      s.a locala = (s.a)localIterator.next();
      localStringBuilder.append("[");
      localStringBuilder.append(locala.key);
      localStringBuilder.append(": ");
      localStringBuilder.append(locala.time);
      if (locala.time > this.startTime) {
        localStringBuilder.append(", ").append(locala.time - this.startTime);
      }
      if (!bo.isNullOrNil(locala.detail)) {
        localStringBuilder.append(", ").append(locala.detail);
      }
      localStringBuilder.append("] ");
    }
    ab.i("MicroMsg.WebViewPerformanceHelper", "webview Performance: %s", new Object[] { localStringBuilder.toString() });
    this.kNQ.clear();
    AppMethodBeat.o(10145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.f.d
 * JD-Core Version:    0.7.0.1
 */