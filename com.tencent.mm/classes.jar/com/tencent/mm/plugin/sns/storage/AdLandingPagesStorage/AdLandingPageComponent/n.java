package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends p
{
  public String jSR;
  public String yXS;
  public int zyN;
  public int zyO;
  public long zyP;
  
  public final String toString()
  {
    AppMethodBeat.i(96317);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("[sid:").append(this.zyN).append(", compId:").append(this.zyO).append(", aid:").append(this.zyP).append(", traceId:").append(this.jSR).append(", uxinfo:").append(this.yXS).append("]");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96317);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n
 * JD-Core Version:    0.7.0.1
 */