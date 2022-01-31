package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwg
  extends com.tencent.mm.bv.a
{
  public long yeu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48988);
    if (paramInt == 0)
    {
      ((e.a.a.c.a)paramVarArgs[0]).am(1, this.yeu);
      AppMethodBeat.o(48988);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.yeu);
      AppMethodBeat.o(48988);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(48988);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cwg localcwg = (cwg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(48988);
        return -1;
      }
      localcwg.yeu = locala.CLY.sm();
      AppMethodBeat.o(48988);
      return 0;
    }
    AppMethodBeat.o(48988);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwg
 * JD-Core Version:    0.7.0.1
 */