package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpa
  extends com.tencent.mm.bw.a
{
  public boolean Htd;
  public String Hte;
  public LinkedList<Integer> Mvb;
  
  public cpa()
  {
    AppMethodBeat.i(91541);
    this.Mvb = new LinkedList();
    AppMethodBeat.o(91541);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91542);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.Htd);
      if (this.Hte != null) {
        paramVarArgs.e(2, this.Hte);
      }
      paramVarArgs.e(3, 2, this.Mvb);
      AppMethodBeat.o(91542);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0;
      paramInt = i;
      if (this.Hte != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Hte);
      }
      i = g.a.a.a.c(3, 2, this.Mvb);
      AppMethodBeat.o(91542);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Mvb.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91542);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cpa localcpa = (cpa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91542);
        return -1;
      case 1: 
        localcpa.Htd = locala.UbS.yZ();
        AppMethodBeat.o(91542);
        return 0;
      case 2: 
        localcpa.Hte = locala.UbS.readString();
        AppMethodBeat.o(91542);
        return 0;
      }
      localcpa.Mvb.add(Integer.valueOf(locala.UbS.zi()));
      AppMethodBeat.o(91542);
      return 0;
    }
    AppMethodBeat.o(91542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpa
 * JD-Core Version:    0.7.0.1
 */