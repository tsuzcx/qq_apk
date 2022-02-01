package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fxe
  extends com.tencent.mm.bx.a
{
  public int abMC;
  public int abMD;
  public int abME;
  public int abMF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258082);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abMC);
      paramVarArgs.bS(2, this.abMD);
      paramVarArgs.bS(3, this.abME);
      paramVarArgs.bS(4, this.abMF);
      AppMethodBeat.o(258082);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abMC);
      int i = i.a.a.b.b.a.cJ(2, this.abMD);
      int j = i.a.a.b.b.a.cJ(3, this.abME);
      int k = i.a.a.b.b.a.cJ(4, this.abMF);
      AppMethodBeat.o(258082);
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
      AppMethodBeat.o(258082);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fxe localfxe = (fxe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258082);
        return -1;
      case 1: 
        localfxe.abMC = locala.ajGk.aar();
        AppMethodBeat.o(258082);
        return 0;
      case 2: 
        localfxe.abMD = locala.ajGk.aar();
        AppMethodBeat.o(258082);
        return 0;
      case 3: 
        localfxe.abME = locala.ajGk.aar();
        AppMethodBeat.o(258082);
        return 0;
      }
      localfxe.abMF = locala.ajGk.aar();
      AppMethodBeat.o(258082);
      return 0;
    }
    AppMethodBeat.o(258082);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fxe
 * JD-Core Version:    0.7.0.1
 */