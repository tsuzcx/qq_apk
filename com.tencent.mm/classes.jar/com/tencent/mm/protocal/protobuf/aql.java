package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aql
  extends com.tencent.mm.bx.a
{
  public int Gox;
  public int Goy;
  public int Goz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184204);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gox);
      paramVarArgs.aS(2, this.Goy);
      paramVarArgs.aS(3, this.Goz);
      AppMethodBeat.o(184204);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Gox);
      int i = f.a.a.b.b.a.bz(2, this.Goy);
      int j = f.a.a.b.b.a.bz(3, this.Goz);
      AppMethodBeat.o(184204);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(184204);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aql localaql = (aql)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184204);
        return -1;
      case 1: 
        localaql.Gox = locala.NPN.zc();
        AppMethodBeat.o(184204);
        return 0;
      case 2: 
        localaql.Goy = locala.NPN.zc();
        AppMethodBeat.o(184204);
        return 0;
      }
      localaql.Goz = locala.NPN.zc();
      AppMethodBeat.o(184204);
      return 0;
    }
    AppMethodBeat.o(184204);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aql
 * JD-Core Version:    0.7.0.1
 */