package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cnb;
import java.util.LinkedList;
import java.util.List;

public final class n
{
  public int DEs;
  public String dPI;
  public List<cnb> list;
  
  public n()
  {
    AppMethodBeat.i(95086);
    this.list = new LinkedList();
    AppMethodBeat.o(95086);
  }
  
  public n(cnb paramcnb)
  {
    AppMethodBeat.i(95087);
    this.list = new LinkedList();
    this.list.add(paramcnb);
    AppMethodBeat.o(95087);
  }
  
  public n(List<cnb> paramList)
  {
    AppMethodBeat.i(95088);
    this.list = new LinkedList();
    this.list = paramList;
    AppMethodBeat.o(95088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.n
 * JD-Core Version:    0.7.0.1
 */