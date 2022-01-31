package com.tencent.mm.plugin.topstory.ui.video.fs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class d$1
  implements Runnable
{
  d$1(d paramd, List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(1873);
    Object localObject1 = this.tkf.thM.cJs();
    int i = ((n)localObject1).cKc();
    ab.i("MicroMsg.TopStory.TopStoryFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.tiV.size()) });
    List localList = this.tiV;
    try
    {
      if (!bo.es(localList)) {
        ((n)localObject1).cKb().addAll(localList);
      }
      localObject1 = this.tkf;
      ((d)localObject1).bR(i + ((d)localObject1).getHeadersCount());
      AppMethodBeat.o(1873);
      return;
    }
    finally
    {
      AppMethodBeat.o(1873);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.d.1
 * JD-Core Version:    0.7.0.1
 */