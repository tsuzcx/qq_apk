package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agn
  extends com.tencent.mm.bx.a
{
  public String ZbX;
  public int ZpJ;
  public String mdE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259428);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZbX != null) {
        paramVarArgs.g(1, this.ZbX);
      }
      if (this.mdE != null) {
        paramVarArgs.g(2, this.mdE);
      }
      paramVarArgs.bS(3, this.ZpJ);
      AppMethodBeat.o(259428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZbX == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZbX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mdE != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.mdE);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.ZpJ);
      AppMethodBeat.o(259428);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259428);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        agn localagn = (agn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259428);
          return -1;
        case 1: 
          localagn.ZbX = locala.ajGk.readString();
          AppMethodBeat.o(259428);
          return 0;
        case 2: 
          localagn.mdE = locala.ajGk.readString();
          AppMethodBeat.o(259428);
          return 0;
        }
        localagn.ZpJ = locala.ajGk.aar();
        AppMethodBeat.o(259428);
        return 0;
      }
      AppMethodBeat.o(259428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agn
 * JD-Core Version:    0.7.0.1
 */