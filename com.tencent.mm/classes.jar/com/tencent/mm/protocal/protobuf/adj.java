package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adj
  extends com.tencent.mm.cd.a
{
  public long SoR;
  public int SpD;
  public String SpN;
  public LinkedList<String> SpO;
  
  public adj()
  {
    AppMethodBeat.i(203731);
    this.SpO = new LinkedList();
    AppMethodBeat.o(203731);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203740);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.SoR);
      if (this.SpN != null) {
        paramVarArgs.f(2, this.SpN);
      }
      paramVarArgs.e(3, 1, this.SpO);
      paramVarArgs.aY(4, this.SpD);
      AppMethodBeat.o(203740);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.SoR) + 0;
      paramInt = i;
      if (this.SpN != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SpN);
      }
      i = g.a.a.a.c(3, 1, this.SpO);
      int j = g.a.a.b.b.a.bM(4, this.SpD);
      AppMethodBeat.o(203740);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SpO.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(203740);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      adj localadj = (adj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203740);
        return -1;
      case 1: 
        localadj.SoR = locala.abFh.AN();
        AppMethodBeat.o(203740);
        return 0;
      case 2: 
        localadj.SpN = locala.abFh.readString();
        AppMethodBeat.o(203740);
        return 0;
      case 3: 
        localadj.SpO.add(locala.abFh.readString());
        AppMethodBeat.o(203740);
        return 0;
      }
      localadj.SpD = locala.abFh.AK();
      AppMethodBeat.o(203740);
      return 0;
    }
    AppMethodBeat.o(203740);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adj
 * JD-Core Version:    0.7.0.1
 */