package com.tencent.mm.plugin.wenote.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class q
  implements Serializable
{
  public boolean ESe = false;
  public long ESf = -1L;
  public long ESg = -1L;
  public String ESh = "";
  public String ESi = "";
  public int ESj = 0;
  public int ESk = 0;
  public boolean rCw = false;
  
  public final String faB()
  {
    AppMethodBeat.i(30377);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("topIsOpenFromSession=").append(this.ESe).append(" topLocalId=").append(this.ESf).append(" topMsgId=").append(this.ESg).append(" topTitle=").append(this.ESh).append(" topNoteXml=").append(this.ESi).append(" topLastPosition=").append(this.ESj).append(" topLastOffset=").append(this.ESk);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(30377);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.a.q
 * JD-Core Version:    0.7.0.1
 */