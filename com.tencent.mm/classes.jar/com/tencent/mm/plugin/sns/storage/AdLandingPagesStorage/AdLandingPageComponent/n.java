package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends p
{
  public String jyU;
  public String xID;
  public int yiF;
  public int yiG;
  public long yiH;
  
  public final String toString()
  {
    AppMethodBeat.i(96317);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("[sid:").append(this.yiF).append(", compId:").append(this.yiG).append(", aid:").append(this.yiH).append(", traceId:").append(this.jyU).append(", uxinfo:").append(this.xID).append("]");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96317);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n
 * JD-Core Version:    0.7.0.1
 */