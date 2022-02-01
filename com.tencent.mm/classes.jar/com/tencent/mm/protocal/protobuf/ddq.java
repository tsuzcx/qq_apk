package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddq
  extends com.tencent.mm.bx.a
{
  public int aaJe;
  public int aaJf;
  public int aaJg;
  public int aalV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152617);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aalV);
      paramVarArgs.bS(2, this.aaJe);
      paramVarArgs.bS(3, this.aaJf);
      paramVarArgs.bS(4, this.aaJg);
      AppMethodBeat.o(152617);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aalV);
      int i = i.a.a.b.b.a.cJ(2, this.aaJe);
      int j = i.a.a.b.b.a.cJ(3, this.aaJf);
      int k = i.a.a.b.b.a.cJ(4, this.aaJg);
      AppMethodBeat.o(152617);
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
      AppMethodBeat.o(152617);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ddq localddq = (ddq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152617);
        return -1;
      case 1: 
        localddq.aalV = locala.ajGk.aar();
        AppMethodBeat.o(152617);
        return 0;
      case 2: 
        localddq.aaJe = locala.ajGk.aar();
        AppMethodBeat.o(152617);
        return 0;
      case 3: 
        localddq.aaJf = locala.ajGk.aar();
        AppMethodBeat.o(152617);
        return 0;
      }
      localddq.aaJg = locala.ajGk.aar();
      AppMethodBeat.o(152617);
      return 0;
    }
    AppMethodBeat.o(152617);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddq
 * JD-Core Version:    0.7.0.1
 */