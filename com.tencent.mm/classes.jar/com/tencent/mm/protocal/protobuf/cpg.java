package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpg
  extends com.tencent.mm.bv.a
{
  public int csV;
  public String csW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127738);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.csV);
      if (this.csW != null) {
        paramVarArgs.e(2, this.csW);
      }
      AppMethodBeat.o(127738);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.csV) + 0;
      paramInt = i;
      if (this.csW != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.csW);
      }
      AppMethodBeat.o(127738);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(127738);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cpg localcpg = (cpg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127738);
        return -1;
      case 1: 
        localcpg.csV = locala.CLY.sl();
        AppMethodBeat.o(127738);
        return 0;
      }
      localcpg.csW = locala.CLY.readString();
      AppMethodBeat.o(127738);
      return 0;
    }
    AppMethodBeat.o(127738);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpg
 * JD-Core Version:    0.7.0.1
 */