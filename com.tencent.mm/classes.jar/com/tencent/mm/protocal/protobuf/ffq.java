package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ffq
  extends com.tencent.mm.bw.a
{
  public long UtZ;
  public boolean Uua;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258522);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.UtZ);
      paramVarArgs.cc(2, this.Uua);
      AppMethodBeat.o(258522);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.UtZ);
      int i = g.a.a.b.b.a.fS(2);
      AppMethodBeat.o(258522);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(258522);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ffq localffq = (ffq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258522);
        return -1;
      case 1: 
        localffq.UtZ = locala.UbS.zl();
        AppMethodBeat.o(258522);
        return 0;
      }
      localffq.Uua = locala.UbS.yZ();
      AppMethodBeat.o(258522);
      return 0;
    }
    AppMethodBeat.o(258522);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffq
 * JD-Core Version:    0.7.0.1
 */