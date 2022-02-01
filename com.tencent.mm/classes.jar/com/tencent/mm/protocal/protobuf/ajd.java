package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajd
  extends com.tencent.mm.bx.a
{
  public int ZqV;
  public int ZqW;
  public String hZn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125721);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZqV);
      paramVarArgs.bS(2, this.ZqW);
      if (this.hZn != null) {
        paramVarArgs.g(3, this.hZn);
      }
      AppMethodBeat.o(125721);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.ZqV) + 0 + i.a.a.b.b.a.cJ(2, this.ZqW);
      paramInt = i;
      if (this.hZn != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.hZn);
      }
      AppMethodBeat.o(125721);
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
      AppMethodBeat.o(125721);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ajd localajd = (ajd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125721);
        return -1;
      case 1: 
        localajd.ZqV = locala.ajGk.aar();
        AppMethodBeat.o(125721);
        return 0;
      case 2: 
        localajd.ZqW = locala.ajGk.aar();
        AppMethodBeat.o(125721);
        return 0;
      }
      localajd.hZn = locala.ajGk.readString();
      AppMethodBeat.o(125721);
      return 0;
    }
    AppMethodBeat.o(125721);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajd
 * JD-Core Version:    0.7.0.1
 */