package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.btz;
import java.util.LinkedList;
import java.util.List;

public final class m
{
  public String dlj;
  public List<btz> list;
  public int xNy;
  
  public m()
  {
    AppMethodBeat.i(95086);
    this.list = new LinkedList();
    AppMethodBeat.o(95086);
  }
  
  public m(btz parambtz)
  {
    AppMethodBeat.i(95087);
    this.list = new LinkedList();
    this.list.add(parambtz);
    AppMethodBeat.o(95087);
  }
  
  public m(List<btz> paramList)
  {
    AppMethodBeat.i(95088);
    this.list = new LinkedList();
    this.list = paramList;
    AppMethodBeat.o(95088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.m
 * JD-Core Version:    0.7.0.1
 */