package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends r
{
  public String QJJ;
  public int QJK;
  public String businessId;
  public String rSA;
  public String rSr;
  public String rSy;
  public String rSz;
  public String xVm;
  
  public final String toString()
  {
    AppMethodBeat.i(96316);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("userName:").append(this.xVm).append(", appId:").append(this.QJJ).append(", busId:").append(this.businessId).append(", sessionFrom:").append(this.rSr).append(", showMessageCard:").append(this.QJK).append(", sendMessageTitle:").append(this.rSy).append(", sendMessageImg:").append(this.rSA).append(", sendMessagePath:").append(this.rSz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96316);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o
 * JD-Core Version:    0.7.0.1
 */