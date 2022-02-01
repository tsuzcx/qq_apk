package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends p
{
  public String kNe;
  public String kNn;
  public String kNo;
  public String kNp;
  public String kNq;
  public String pSx;
  public String zQk;
  public int zQl;
  
  public final String toString()
  {
    AppMethodBeat.i(96316);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("userName:").append(this.pSx).append(", appId:").append(this.zQk).append(", busId:").append(this.kNn).append(", sessionFrom:").append(this.kNe).append(", showMessageCard:").append(this.zQl).append(", sendMessageTitle:").append(this.kNo).append(", sendMessageImg:").append(this.kNq).append(", sendMessagePath:").append(this.kNp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(96316);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m
 * JD-Core Version:    0.7.0.1
 */