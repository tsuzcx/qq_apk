package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dmz;
import java.util.LinkedList;
import java.util.List;

public final class p
{
  public int QnY;
  public String hOG;
  public List<dmz> list;
  
  public p()
  {
    AppMethodBeat.i(95086);
    this.list = new LinkedList();
    AppMethodBeat.o(95086);
  }
  
  public p(dmz paramdmz)
  {
    AppMethodBeat.i(95087);
    this.list = new LinkedList();
    this.list.add(paramdmz);
    AppMethodBeat.o(95087);
  }
  
  public p(List<dmz> paramList)
  {
    AppMethodBeat.i(95088);
    this.list = new LinkedList();
    this.list = paramList;
    AppMethodBeat.o(95088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.p
 * JD-Core Version:    0.7.0.1
 */