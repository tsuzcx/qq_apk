package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends r
{
  public String KlC;
  public int KlD;
  public String businessId;
  public String oOB;
  public String oOK;
  public String oOL;
  public String oOM;
  public String uMJ;
  
  public final String toString()
  {
    AppMethodBeat.i(96316);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("userName:").append(this.uMJ).append(", appId:").append(this.KlC).append(", busId:").append(this.businessId).append(", sessionFrom:").append(this.oOB).append(", showMessageCard:").append(this.KlD).append(", sendMessageTitle:").append(this.oOK).append(", sendMessageImg:").append(this.oOM).append(", sendMessagePath:").append(this.oOL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96316);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o
 * JD-Core Version:    0.7.0.1
 */