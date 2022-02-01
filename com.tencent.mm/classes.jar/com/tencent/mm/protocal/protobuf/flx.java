package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class flx
  extends com.tencent.mm.bx.a
{
  public int abMm;
  public String abMn;
  public int abmN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32466);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abMm);
      paramVarArgs.bS(2, this.abmN);
      if (this.abMn != null) {
        paramVarArgs.g(3, this.abMn);
      }
      AppMethodBeat.o(32466);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abMm) + 0 + i.a.a.b.b.a.cJ(2, this.abmN);
      paramInt = i;
      if (this.abMn != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abMn);
      }
      AppMethodBeat.o(32466);
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
      AppMethodBeat.o(32466);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      flx localflx = (flx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32466);
        return -1;
      case 1: 
        localflx.abMm = locala.ajGk.aar();
        AppMethodBeat.o(32466);
        return 0;
      case 2: 
        localflx.abmN = locala.ajGk.aar();
        AppMethodBeat.o(32466);
        return 0;
      }
      localflx.abMn = locala.ajGk.readString();
      AppMethodBeat.o(32466);
      return 0;
    }
    AppMethodBeat.o(32466);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flx
 * JD-Core Version:    0.7.0.1
 */