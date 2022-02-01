package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adt
  extends com.tencent.mm.bx.a
{
  public int Gch;
  public int Gci;
  public String info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125721);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gch);
      paramVarArgs.aS(2, this.Gci);
      if (this.info != null) {
        paramVarArgs.d(3, this.info);
      }
      AppMethodBeat.o(125721);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Gch) + 0 + f.a.a.b.b.a.bz(2, this.Gci);
      paramInt = i;
      if (this.info != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.info);
      }
      AppMethodBeat.o(125721);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125721);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      adt localadt = (adt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125721);
        return -1;
      case 1: 
        localadt.Gch = locala.NPN.zc();
        AppMethodBeat.o(125721);
        return 0;
      case 2: 
        localadt.Gci = locala.NPN.zc();
        AppMethodBeat.o(125721);
        return 0;
      }
      localadt.info = locala.NPN.readString();
      AppMethodBeat.o(125721);
      return 0;
    }
    AppMethodBeat.o(125721);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adt
 * JD-Core Version:    0.7.0.1
 */