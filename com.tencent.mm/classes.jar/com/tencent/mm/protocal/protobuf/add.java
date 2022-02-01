package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class add
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> SpC;
  public int SpD;
  public boolean SpE;
  public int SpF;
  public String SpG;
  
  public add()
  {
    AppMethodBeat.i(203626);
    this.SpC = new LinkedList();
    AppMethodBeat.o(203626);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203636);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.SpC);
      paramVarArgs.aY(2, this.SpD);
      paramVarArgs.co(3, this.SpE);
      paramVarArgs.aY(4, this.SpF);
      if (this.SpG != null) {
        paramVarArgs.f(5, this.SpG);
      }
      AppMethodBeat.o(203636);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.a.c(1, 1, this.SpC) + 0 + g.a.a.b.b.a.bM(2, this.SpD) + (g.a.a.b.b.a.gL(3) + 1) + g.a.a.b.b.a.bM(4, this.SpF);
      paramInt = i;
      if (this.SpG != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.SpG);
      }
      AppMethodBeat.o(203636);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SpC.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(203636);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      add localadd = (add)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203636);
        return -1;
      case 1: 
        localadd.SpC.add(locala.abFh.readString());
        AppMethodBeat.o(203636);
        return 0;
      case 2: 
        localadd.SpD = locala.abFh.AK();
        AppMethodBeat.o(203636);
        return 0;
      case 3: 
        localadd.SpE = locala.abFh.AB();
        AppMethodBeat.o(203636);
        return 0;
      case 4: 
        localadd.SpF = locala.abFh.AK();
        AppMethodBeat.o(203636);
        return 0;
      }
      localadd.SpG = locala.abFh.readString();
      AppMethodBeat.o(203636);
      return 0;
    }
    AppMethodBeat.o(203636);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.add
 * JD-Core Version:    0.7.0.1
 */