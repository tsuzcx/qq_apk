package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j;

final class a$2
  implements Runnable
{
  a$2(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(36062);
    j.crY().f("adId", this.rcS, "adxml", 0);
    AppMethodBeat.o(36062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.2
 * JD-Core Version:    0.7.0.1
 */