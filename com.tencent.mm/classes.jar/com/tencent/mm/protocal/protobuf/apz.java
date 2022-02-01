package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apz
  extends com.tencent.mm.bx.a
{
  public long ID;
  public String IGU;
  public int Zxs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155404);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ID);
      if (this.IGU != null) {
        paramVarArgs.g(2, this.IGU);
      }
      paramVarArgs.bS(3, this.Zxs);
      AppMethodBeat.o(155404);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.ID) + 0;
      paramInt = i;
      if (this.IGU != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGU);
      }
      i = i.a.a.b.b.a.cJ(3, this.Zxs);
      AppMethodBeat.o(155404);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(155404);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      apz localapz = (apz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155404);
        return -1;
      case 1: 
        localapz.ID = locala.ajGk.aaw();
        AppMethodBeat.o(155404);
        return 0;
      case 2: 
        localapz.IGU = locala.ajGk.readString();
        AppMethodBeat.o(155404);
        return 0;
      }
      localapz.Zxs = locala.ajGk.aar();
      AppMethodBeat.o(155404);
      return 0;
    }
    AppMethodBeat.o(155404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apz
 * JD-Core Version:    0.7.0.1
 */