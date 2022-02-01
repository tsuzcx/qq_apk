package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajj
  extends com.tencent.mm.bw.a
{
  public long LsT;
  public String LsU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214288);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.LsT);
      if (this.LsU != null) {
        paramVarArgs.e(2, this.LsU);
      }
      AppMethodBeat.o(214288);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.LsT) + 0;
      paramInt = i;
      if (this.LsU != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LsU);
      }
      AppMethodBeat.o(214288);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(214288);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ajj localajj = (ajj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(214288);
        return -1;
      case 1: 
        localajj.LsT = locala.UbS.zl();
        AppMethodBeat.o(214288);
        return 0;
      }
      localajj.LsU = locala.UbS.readString();
      AppMethodBeat.o(214288);
      return 0;
    }
    AppMethodBeat.o(214288);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajj
 * JD-Core Version:    0.7.0.1
 */