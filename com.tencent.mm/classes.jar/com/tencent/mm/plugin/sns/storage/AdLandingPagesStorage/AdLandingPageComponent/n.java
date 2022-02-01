package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends p
{
  public String iYE;
  public int wVR;
  public int wVS;
  public long wVT;
  public String wxc;
  
  public final String toString()
  {
    AppMethodBeat.i(96317);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("[sid:").append(this.wVR).append(", compId:").append(this.wVS).append(", aid:").append(this.wVT).append(", traceId:").append(this.iYE).append(", uxinfo:").append(this.wxc).append("]");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96317);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n
 * JD-Core Version:    0.7.0.1
 */