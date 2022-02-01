package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends q
{
  public String DYj;
  public int DYk;
  public String businessId;
  public String lRW;
  public String lSf;
  public String lSg;
  public String lSh;
  public String weappUserName;
  
  public final String toString()
  {
    AppMethodBeat.i(96316);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("userName:").append(this.weappUserName).append(", appId:").append(this.DYj).append(", busId:").append(this.businessId).append(", sessionFrom:").append(this.lRW).append(", showMessageCard:").append(this.DYk).append(", sendMessageTitle:").append(this.lSf).append(", sendMessageImg:").append(this.lSh).append(", sendMessagePath:").append(this.lSg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96316);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n
 * JD-Core Version:    0.7.0.1
 */