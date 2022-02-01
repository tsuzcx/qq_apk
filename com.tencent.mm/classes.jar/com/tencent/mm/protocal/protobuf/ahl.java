package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahl
  extends com.tencent.mm.bx.a
{
  public int pSt;
  public String pSu;
  public String pSv;
  public String pSw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43088);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.pSt);
      if (this.pSu != null) {
        paramVarArgs.g(2, this.pSu);
      }
      if (this.pSv != null) {
        paramVarArgs.g(3, this.pSv);
      }
      if (this.pSw != null) {
        paramVarArgs.g(4, this.pSw);
      }
      AppMethodBeat.o(43088);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.pSt) + 0;
      paramInt = i;
      if (this.pSu != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.pSu);
      }
      i = paramInt;
      if (this.pSv != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.pSv);
      }
      paramInt = i;
      if (this.pSw != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.pSw);
      }
      AppMethodBeat.o(43088);
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
      AppMethodBeat.o(43088);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ahl localahl = (ahl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43088);
        return -1;
      case 1: 
        localahl.pSt = locala.ajGk.aar();
        AppMethodBeat.o(43088);
        return 0;
      case 2: 
        localahl.pSu = locala.ajGk.readString();
        AppMethodBeat.o(43088);
        return 0;
      case 3: 
        localahl.pSv = locala.ajGk.readString();
        AppMethodBeat.o(43088);
        return 0;
      }
      localahl.pSw = locala.ajGk.readString();
      AppMethodBeat.o(43088);
      return 0;
    }
    AppMethodBeat.o(43088);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahl
 * JD-Core Version:    0.7.0.1
 */