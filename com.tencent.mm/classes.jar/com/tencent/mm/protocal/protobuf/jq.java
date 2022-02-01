package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class jq
  extends com.tencent.mm.cd.a
{
  public int CNe;
  public int CqR;
  public LinkedList<String> RPk;
  public b RPl;
  public int lpw;
  
  public jq()
  {
    AppMethodBeat.i(104755);
    this.RPk = new LinkedList();
    this.CNe = 0;
    AppMethodBeat.o(104755);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104756);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CqR);
      paramVarArgs.aY(2, this.lpw);
      paramVarArgs.e(3, 1, this.RPk);
      paramVarArgs.aY(4, this.CNe);
      if (this.RPl != null) {
        paramVarArgs.c(5, this.RPl);
      }
      AppMethodBeat.o(104756);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CqR) + 0 + g.a.a.b.b.a.bM(2, this.lpw) + g.a.a.a.c(3, 1, this.RPk) + g.a.a.b.b.a.bM(4, this.CNe);
      paramInt = i;
      if (this.RPl != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.RPl);
      }
      AppMethodBeat.o(104756);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RPk.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(104756);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      jq localjq = (jq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104756);
        return -1;
      case 1: 
        localjq.CqR = locala.abFh.AK();
        AppMethodBeat.o(104756);
        return 0;
      case 2: 
        localjq.lpw = locala.abFh.AK();
        AppMethodBeat.o(104756);
        return 0;
      case 3: 
        localjq.RPk.add(locala.abFh.readString());
        AppMethodBeat.o(104756);
        return 0;
      case 4: 
        localjq.CNe = locala.abFh.AK();
        AppMethodBeat.o(104756);
        return 0;
      }
      localjq.RPl = locala.abFh.iUw();
      AppMethodBeat.o(104756);
      return 0;
    }
    AppMethodBeat.o(104756);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jq
 * JD-Core Version:    0.7.0.1
 */