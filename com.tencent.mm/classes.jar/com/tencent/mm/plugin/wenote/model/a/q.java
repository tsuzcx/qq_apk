package com.tencent.mm.plugin.wenote.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class q
  implements Serializable
{
  public boolean CVL = false;
  public long CVM = -1L;
  public long CVN = -1L;
  public String CVO = "";
  public String CVP = "";
  public int CVQ = 0;
  public int CVR = 0;
  public boolean qKi = false;
  
  public final String eHW()
  {
    AppMethodBeat.i(30377);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("topIsOpenFromSession=").append(this.CVL).append(" topLocalId=").append(this.CVM).append(" topMsgId=").append(this.CVN).append(" topTitle=").append(this.CVO).append(" topNoteXml=").append(this.CVP).append(" topLastPosition=").append(this.CVQ).append(" topLastOffset=").append(this.CVR);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(30377);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.a.q
 * JD-Core Version:    0.7.0.1
 */