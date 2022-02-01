package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class df
  extends com.tencent.mm.bx.a
{
  public int YFt;
  public int YFu;
  public int YFv;
  public int YFw;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127429);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YFt);
      paramVarArgs.bS(2, this.vhJ);
      paramVarArgs.bS(3, this.YFu);
      paramVarArgs.bS(4, this.YFv);
      paramVarArgs.bS(5, this.YFw);
      AppMethodBeat.o(127429);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.YFt);
      int i = i.a.a.b.b.a.cJ(2, this.vhJ);
      int j = i.a.a.b.b.a.cJ(3, this.YFu);
      int k = i.a.a.b.b.a.cJ(4, this.YFv);
      int m = i.a.a.b.b.a.cJ(5, this.YFw);
      AppMethodBeat.o(127429);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(127429);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      df localdf = (df)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127429);
        return -1;
      case 1: 
        localdf.YFt = locala.ajGk.aar();
        AppMethodBeat.o(127429);
        return 0;
      case 2: 
        localdf.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(127429);
        return 0;
      case 3: 
        localdf.YFu = locala.ajGk.aar();
        AppMethodBeat.o(127429);
        return 0;
      case 4: 
        localdf.YFv = locala.ajGk.aar();
        AppMethodBeat.o(127429);
        return 0;
      }
      localdf.YFw = locala.ajGk.aar();
      AppMethodBeat.o(127429);
      return 0;
    }
    AppMethodBeat.o(127429);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.df
 * JD-Core Version:    0.7.0.1
 */