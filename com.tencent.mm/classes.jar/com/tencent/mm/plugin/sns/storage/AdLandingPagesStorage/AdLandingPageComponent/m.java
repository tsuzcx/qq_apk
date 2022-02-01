package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends p
{
  public String kJP;
  public String kJY;
  public String kJZ;
  public String kKa;
  public String kKb;
  public String pLS;
  public String zyL;
  public int zyM;
  
  public final String toString()
  {
    AppMethodBeat.i(96316);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("userName:").append(this.pLS).append(", appId:").append(this.zyL).append(", busId:").append(this.kJY).append(", sessionFrom:").append(this.kJP).append(", showMessageCard:").append(this.zyM).append(", sendMessageTitle:").append(this.kJZ).append(", sendMessageImg:").append(this.kKb).append(", sendMessagePath:").append(this.kKa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96316);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m
 * JD-Core Version:    0.7.0.1
 */