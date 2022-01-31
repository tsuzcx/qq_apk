package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bcs;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  public List<bcs> list;
  public String ohe;
  public int rbj;
  
  public e()
  {
    AppMethodBeat.i(35796);
    this.list = new LinkedList();
    AppMethodBeat.o(35796);
  }
  
  public e(bcs parambcs)
  {
    AppMethodBeat.i(35797);
    this.list = new LinkedList();
    this.list.add(parambcs);
    AppMethodBeat.o(35797);
  }
  
  public e(List<bcs> paramList)
  {
    AppMethodBeat.i(35798);
    this.list = new LinkedList();
    this.list = paramList;
    AppMethodBeat.o(35798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.e
 * JD-Core Version:    0.7.0.1
 */