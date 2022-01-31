package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends l
{
  public String hKu;
  public String loD;
  public String rsb;
  public int rsc;
  public String sessionFrom;
  
  public final String toString()
  {
    AppMethodBeat.i(145296);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("userName:").append(this.loD).append(", appId:").append(this.rsb).append(", busId:").append(this.hKu).append(", sessionFrom:").append(this.sessionFrom);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(145296);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k
 * JD-Core Version:    0.7.0.1
 */