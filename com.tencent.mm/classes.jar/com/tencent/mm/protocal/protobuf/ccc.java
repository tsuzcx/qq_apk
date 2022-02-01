package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccc
  extends com.tencent.mm.bx.a
{
  public String DUR;
  public int aalv;
  public boolean akkT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258018);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aalv);
      if (this.DUR != null) {
        paramVarArgs.g(2, this.DUR);
      }
      paramVarArgs.di(3, this.akkT);
      AppMethodBeat.o(258018);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.aalv) + 0;
      paramInt = i;
      if (this.DUR != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.DUR);
      }
      i = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(258018);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258018);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ccc localccc = (ccc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258018);
        return -1;
      case 1: 
        localccc.aalv = locala.ajGk.aar();
        AppMethodBeat.o(258018);
        return 0;
      case 2: 
        localccc.DUR = locala.ajGk.readString();
        AppMethodBeat.o(258018);
        return 0;
      }
      localccc.akkT = locala.ajGk.aai();
      AppMethodBeat.o(258018);
      return 0;
    }
    AppMethodBeat.o(258018);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccc
 * JD-Core Version:    0.7.0.1
 */