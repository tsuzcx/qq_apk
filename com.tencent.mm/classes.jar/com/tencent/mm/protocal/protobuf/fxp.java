package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fxp
  extends com.tencent.mm.bx.a
{
  public int aaOD;
  public int aaOF;
  public int aaOG;
  public int aaON;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258047);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaOD);
      paramVarArgs.bS(2, this.aaOF);
      paramVarArgs.bS(3, this.aaOG);
      paramVarArgs.bS(4, this.aaON);
      AppMethodBeat.o(258047);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaOD);
      int i = i.a.a.b.b.a.cJ(2, this.aaOF);
      int j = i.a.a.b.b.a.cJ(3, this.aaOG);
      int k = i.a.a.b.b.a.cJ(4, this.aaON);
      AppMethodBeat.o(258047);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258047);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fxp localfxp = (fxp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258047);
        return -1;
      case 1: 
        localfxp.aaOD = locala.ajGk.aar();
        AppMethodBeat.o(258047);
        return 0;
      case 2: 
        localfxp.aaOF = locala.ajGk.aar();
        AppMethodBeat.o(258047);
        return 0;
      case 3: 
        localfxp.aaOG = locala.ajGk.aar();
        AppMethodBeat.o(258047);
        return 0;
      }
      localfxp.aaON = locala.ajGk.aar();
      AppMethodBeat.o(258047);
      return 0;
    }
    AppMethodBeat.o(258047);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxp
 * JD-Core Version:    0.7.0.1
 */