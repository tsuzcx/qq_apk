package com.tencent.mm.plugin.wenote.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class q
  implements Serializable
{
  public boolean EzI = false;
  public long EzJ = -1L;
  public long EzK = -1L;
  public String EzL = "";
  public String EzM = "";
  public int EzN = 0;
  public int EzO = 0;
  public boolean ruk = false;
  
  public final String eWP()
  {
    AppMethodBeat.i(30377);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("topIsOpenFromSession=").append(this.EzI).append(" topLocalId=").append(this.EzJ).append(" topMsgId=").append(this.EzK).append(" topTitle=").append(this.EzL).append(" topNoteXml=").append(this.EzM).append(" topLastPosition=").append(this.EzN).append(" topLastOffset=").append(this.EzO);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(30377);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.a.q
 * JD-Core Version:    0.7.0.1
 */