package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;

final class a$4
  implements Runnable
{
  a$4(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(36064);
    j.crY().f("adId", this.rcU, "adxml", 1);
    AppMethodBeat.o(36064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.4
 * JD-Core Version:    0.7.0.1
 */