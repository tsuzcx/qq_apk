package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fzj
  extends com.tencent.mm.bx.a
{
  public int abWG;
  public String abWK;
  public int oOu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32501);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abWG);
      paramVarArgs.bS(2, this.oOu);
      if (this.abWK != null) {
        paramVarArgs.g(3, this.abWK);
      }
      AppMethodBeat.o(32501);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abWG) + 0 + i.a.a.b.b.a.cJ(2, this.oOu);
      paramInt = i;
      if (this.abWK != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abWK);
      }
      AppMethodBeat.o(32501);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32501);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fzj localfzj = (fzj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32501);
        return -1;
      case 1: 
        localfzj.abWG = locala.ajGk.aar();
        AppMethodBeat.o(32501);
        return 0;
      case 2: 
        localfzj.oOu = locala.ajGk.aar();
        AppMethodBeat.o(32501);
        return 0;
      }
      localfzj.abWK = locala.ajGk.readString();
      AppMethodBeat.o(32501);
      return 0;
    }
    AppMethodBeat.o(32501);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzj
 * JD-Core Version:    0.7.0.1
 */