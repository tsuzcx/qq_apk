package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends r
{
  public int KlE;
  public int KlF;
  public long KlG;
  public String jDL;
  public String nTp;
  
  public final String toString()
  {
    AppMethodBeat.i(96317);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("[sid:").append(this.KlE).append(", compId:").append(this.KlF).append(", aid:").append(this.KlG).append(", traceId:").append(this.nTp).append(", uxinfo:").append(this.jDL).append("]");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96317);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p
 * JD-Core Version:    0.7.0.1
 */