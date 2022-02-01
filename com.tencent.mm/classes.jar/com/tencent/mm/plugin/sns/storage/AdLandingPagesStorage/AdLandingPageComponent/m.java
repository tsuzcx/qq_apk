package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends p
{
  public String koP;
  public String koY;
  public String koZ;
  public String kpa;
  public String kpb;
  public String pis;
  public String yiD;
  public int yiE;
  
  public final String toString()
  {
    AppMethodBeat.i(96316);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("userName:").append(this.pis).append(", appId:").append(this.yiD).append(", busId:").append(this.koY).append(", sessionFrom:").append(this.koP).append(", showMessageCard:").append(this.yiE).append(", sendMessageTitle:").append(this.koZ).append(", sendMessageImg:").append(this.kpb).append(", sendMessagePath:").append(this.kpa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96316);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m
 * JD-Core Version:    0.7.0.1
 */