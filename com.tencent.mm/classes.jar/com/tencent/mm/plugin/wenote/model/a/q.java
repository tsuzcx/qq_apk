package com.tencent.mm.plugin.wenote.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class q
  implements Serializable
{
  public boolean QHj = false;
  public long QHk = -1L;
  public long QHl = -1L;
  public String QHm = "";
  public String QHn = "";
  public int QHo = 0;
  public int QHp = 0;
  public boolean wIg = false;
  
  public final String hdu()
  {
    AppMethodBeat.i(30377);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("topIsOpenFromSession=").append(this.QHj).append(" topLocalId=").append(this.QHk).append(" topMsgId=").append(this.QHl).append(" topTitle=").append(this.QHm).append(" topNoteXml=").append(this.QHn).append(" topLastPosition=").append(this.QHo).append(" topLastOffset=").append(this.QHp);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(30377);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.a.q
 * JD-Core Version:    0.7.0.1
 */