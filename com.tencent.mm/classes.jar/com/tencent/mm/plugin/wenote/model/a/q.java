package com.tencent.mm.plugin.wenote.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class q
  implements Serializable
{
  public boolean BDF = false;
  public long BDG = -1L;
  public long BDH = -1L;
  public String BDI = "";
  public String BDJ = "";
  public int BDK = 0;
  public int BDL = 0;
  public boolean qbC = false;
  
  public final String esD()
  {
    AppMethodBeat.i(30377);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("topIsOpenFromSession=").append(this.BDF).append(" topLocalId=").append(this.BDG).append(" topMsgId=").append(this.BDH).append(" topTitle=").append(this.BDI).append(" topNoteXml=").append(this.BDJ).append(" topLastPosition=").append(this.BDK).append(" topLastOffset=").append(this.BDL);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(30377);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.a.q
 * JD-Core Version:    0.7.0.1
 */