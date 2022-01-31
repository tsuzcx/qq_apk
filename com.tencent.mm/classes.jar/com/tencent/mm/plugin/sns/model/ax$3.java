package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Set;

final class ax$3
  implements Runnable
{
  ax$3(ax paramax, int paramInt, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(36684);
    if (ag.coN())
    {
      ab.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
      AppMethodBeat.o(36684);
      return;
    }
    Iterator localIterator = ax.c(this.riW).iterator();
    while (localIterator.hasNext())
    {
      ax.a locala = (ax.a)localIterator.next();
      if (locala != null) {
        locala.af(this.riX, this.fCf);
      }
    }
    AppMethodBeat.o(36684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ax.3
 * JD-Core Version:    0.7.0.1
 */