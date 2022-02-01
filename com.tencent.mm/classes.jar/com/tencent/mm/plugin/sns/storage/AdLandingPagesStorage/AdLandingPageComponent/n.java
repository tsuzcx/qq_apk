package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends p
{
  public String jWi;
  public int zQm;
  public int zQn;
  public long zQo;
  public String zot;
  
  public final String toString()
  {
    AppMethodBeat.i(96317);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("[sid:").append(this.zQm).append(", compId:").append(this.zQn).append(", aid:").append(this.zQo).append(", traceId:").append(this.jWi).append(", uxinfo:").append(this.zot).append("]");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96317);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n
 * JD-Core Version:    0.7.0.1
 */