package com.tencent.mm.plugin.wenote.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class q
  implements Serializable
{
  public boolean muU = false;
  public int vxA = 0;
  public boolean vxu = false;
  public long vxv = -1L;
  public long vxw = -1L;
  public String vxx = "";
  public String vxy = "";
  public int vxz = 0;
  
  public final String dhS()
  {
    AppMethodBeat.i(26684);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("topIsOpenFromSession=").append(this.vxu).append(" topLocalId=").append(this.vxv).append(" topMsgId=").append(this.vxw).append(" topTitle=").append(this.vxx).append(" topNoteXml=").append(this.vxy).append(" topLastPosition=").append(this.vxz).append(" topLastOffset=").append(this.vxA);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(26684);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.a.q
 * JD-Core Version:    0.7.0.1
 */