package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pj
  extends com.tencent.mm.bx.a
{
  public int FKA;
  public int FKB;
  public int FKz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103204);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FKz);
      paramVarArgs.aS(2, this.FKA);
      paramVarArgs.aS(3, this.FKB);
      AppMethodBeat.o(103204);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FKz);
      int i = f.a.a.b.b.a.bz(2, this.FKA);
      int j = f.a.a.b.b.a.bz(3, this.FKB);
      AppMethodBeat.o(103204);
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
      AppMethodBeat.o(103204);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      pj localpj = (pj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(103204);
        return -1;
      case 1: 
        localpj.FKz = locala.NPN.zc();
        AppMethodBeat.o(103204);
        return 0;
      case 2: 
        localpj.FKA = locala.NPN.zc();
        AppMethodBeat.o(103204);
        return 0;
      }
      localpj.FKB = locala.NPN.zc();
      AppMethodBeat.o(103204);
      return 0;
    }
    AppMethodBeat.o(103204);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pj
 * JD-Core Version:    0.7.0.1
 */