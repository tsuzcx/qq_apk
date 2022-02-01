package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends q
{
  public int DYl;
  public int DYm;
  public long DYn;
  public String gTk;
  public String kZe;
  
  public final String toString()
  {
    AppMethodBeat.i(96317);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("[sid:").append(this.DYl).append(", compId:").append(this.DYm).append(", aid:").append(this.DYn).append(", traceId:").append(this.kZe).append(", uxinfo:").append(this.gTk).append("]");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96317);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o
 * JD-Core Version:    0.7.0.1
 */