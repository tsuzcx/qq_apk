package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ayy
  extends com.tencent.mm.bv.a
{
  public int qsk;
  public String qsu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60040);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.qsk);
      if (this.qsu != null) {
        paramVarArgs.e(2, this.qsu);
      }
      AppMethodBeat.o(60040);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.qsk) + 0;
      paramInt = i;
      if (this.qsu != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.qsu);
      }
      AppMethodBeat.o(60040);
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
      AppMethodBeat.o(60040);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ayy localayy = (ayy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(60040);
        return -1;
      case 1: 
        localayy.qsk = locala.CLY.sl();
        AppMethodBeat.o(60040);
        return 0;
      }
      localayy.qsu = locala.CLY.readString();
      AppMethodBeat.o(60040);
      return 0;
    }
    AppMethodBeat.o(60040);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayy
 * JD-Core Version:    0.7.0.1
 */