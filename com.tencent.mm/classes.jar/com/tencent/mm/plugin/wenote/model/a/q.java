package com.tencent.mm.plugin.wenote.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class q
  implements Serializable
{
  public boolean Aeu = false;
  public boolean XAH = false;
  public long XAI = -1L;
  public long XAJ = -1L;
  public String XAK = "";
  public String XAL = "";
  public int XAM = 0;
  public int XAN = 0;
  
  public final String iEb()
  {
    AppMethodBeat.i(30377);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("topIsOpenFromSession=").append(this.XAH).append(" topLocalId=").append(this.XAI).append(" topMsgId=").append(this.XAJ).append(" topTitle=").append(this.XAK).append(" topNoteXml=").append(this.XAL).append(" topLastPosition=").append(this.XAM).append(" topLastOffset=").append(this.XAN);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(30377);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.a.q
 * JD-Core Version:    0.7.0.1
 */