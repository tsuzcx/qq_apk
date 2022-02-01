package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class fec
  extends com.tencent.mm.bx.a
{
  public int abDG;
  public int abDH;
  public int abDI;
  public int abDJ;
  public int abDK;
  public LinkedList<Integer> abDL;
  
  public fec()
  {
    AppMethodBeat.i(258514);
    this.abDL = new LinkedList();
    AppMethodBeat.o(258514);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258519);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abDG);
      paramVarArgs.bS(2, this.abDH);
      paramVarArgs.bS(3, this.abDI);
      paramVarArgs.bS(4, this.abDJ);
      paramVarArgs.bS(5, this.abDK);
      paramVarArgs.f(6, 2, this.abDL);
      AppMethodBeat.o(258519);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abDG);
      int i = i.a.a.b.b.a.cJ(2, this.abDH);
      int j = i.a.a.b.b.a.cJ(3, this.abDI);
      int k = i.a.a.b.b.a.cJ(4, this.abDJ);
      int m = i.a.a.b.b.a.cJ(5, this.abDK);
      int n = i.a.a.a.d(6, 2, this.abDL);
      AppMethodBeat.o(258519);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abDL.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258519);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fec localfec = (fec)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258519);
        return -1;
      case 1: 
        localfec.abDG = locala.ajGk.aar();
        AppMethodBeat.o(258519);
        return 0;
      case 2: 
        localfec.abDH = locala.ajGk.aar();
        AppMethodBeat.o(258519);
        return 0;
      case 3: 
        localfec.abDI = locala.ajGk.aar();
        AppMethodBeat.o(258519);
        return 0;
      case 4: 
        localfec.abDJ = locala.ajGk.aar();
        AppMethodBeat.o(258519);
        return 0;
      case 5: 
        localfec.abDK = locala.ajGk.aar();
        AppMethodBeat.o(258519);
        return 0;
      }
      localfec.abDL = new i.a.a.a.a(locala.ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
      AppMethodBeat.o(258519);
      return 0;
    }
    AppMethodBeat.o(258519);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fec
 * JD-Core Version:    0.7.0.1
 */