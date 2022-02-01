package com.tencent.mm.plugin.wenote.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class q
  implements Serializable
{
  public boolean JHR = false;
  public long JHS = -1L;
  public long JHT = -1L;
  public String JHU = "";
  public String JHV = "";
  public int JHW = 0;
  public int JHX = 0;
  public boolean tcb = false;
  
  public final String gjG()
  {
    AppMethodBeat.i(30377);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("topIsOpenFromSession=").append(this.JHR).append(" topLocalId=").append(this.JHS).append(" topMsgId=").append(this.JHT).append(" topTitle=").append(this.JHU).append(" topNoteXml=").append(this.JHV).append(" topLastPosition=").append(this.JHW).append(" topLastOffset=").append(this.JHX);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(30377);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.a.q
 * JD-Core Version:    0.7.0.1
 */