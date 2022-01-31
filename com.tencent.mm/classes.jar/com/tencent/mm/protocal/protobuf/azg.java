package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class azg
  extends com.tencent.mm.bv.a
{
  public int wzE;
  public int xoD;
  public String xoE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80637);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xoD);
      if (this.xoE != null) {
        paramVarArgs.e(2, this.xoE);
      }
      paramVarArgs.aO(3, this.wzE);
      AppMethodBeat.o(80637);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xoD) + 0;
      paramInt = i;
      if (this.xoE != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xoE);
      }
      i = e.a.a.b.b.a.bl(3, this.wzE);
      AppMethodBeat.o(80637);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(80637);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      azg localazg = (azg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(80637);
        return -1;
      case 1: 
        localazg.xoD = locala.CLY.sl();
        AppMethodBeat.o(80637);
        return 0;
      case 2: 
        localazg.xoE = locala.CLY.readString();
        AppMethodBeat.o(80637);
        return 0;
      }
      localazg.wzE = locala.CLY.sl();
      AppMethodBeat.o(80637);
      return 0;
    }
    AppMethodBeat.o(80637);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azg
 * JD-Core Version:    0.7.0.1
 */