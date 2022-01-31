package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awk
  extends com.tencent.mm.bv.a
{
  public int key;
  public int length;
  public long xlU;
  public int xlV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28535);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.key);
      paramVarArgs.am(2, this.xlU);
      paramVarArgs.aO(3, this.length);
      paramVarArgs.aO(4, this.xlV);
      AppMethodBeat.o(28535);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.key);
      int i = e.a.a.b.b.a.p(2, this.xlU);
      int j = e.a.a.b.b.a.bl(3, this.length);
      int k = e.a.a.b.b.a.bl(4, this.xlV);
      AppMethodBeat.o(28535);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28535);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      awk localawk = (awk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28535);
        return -1;
      case 1: 
        localawk.key = locala.CLY.sl();
        AppMethodBeat.o(28535);
        return 0;
      case 2: 
        localawk.xlU = locala.CLY.sm();
        AppMethodBeat.o(28535);
        return 0;
      case 3: 
        localawk.length = locala.CLY.sl();
        AppMethodBeat.o(28535);
        return 0;
      }
      localawk.xlV = locala.CLY.sl();
      AppMethodBeat.o(28535);
      return 0;
    }
    AppMethodBeat.o(28535);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awk
 * JD-Core Version:    0.7.0.1
 */