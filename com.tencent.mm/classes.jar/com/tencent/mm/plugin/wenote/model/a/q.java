package com.tencent.mm.plugin.wenote.model.a;

import java.io.Serializable;

public final class q
  implements Serializable
{
  public boolean kay = false;
  public boolean rGL = false;
  public long rGM = -1L;
  public long rGN = -1L;
  public String rGO = "";
  public String rGP = "";
  public int rGQ = 0;
  public int rGR = 0;
  
  public final String chC()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("topIsOpenFromSession=").append(this.rGL).append(" topLocalId=").append(this.rGM).append(" topMsgId=").append(this.rGN).append(" topTitle=").append(this.rGO).append(" topNoteXml=").append(this.rGP).append(" topLastPosition=").append(this.rGQ).append(" topLastOffset=").append(this.rGR);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.a.q
 * JD-Core Version:    0.7.0.1
 */