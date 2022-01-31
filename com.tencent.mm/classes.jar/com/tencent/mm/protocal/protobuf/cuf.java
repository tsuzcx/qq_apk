package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cuf
  extends com.tencent.mm.bv.a
{
  public long ycX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102412);
    if (paramInt == 0)
    {
      ((e.a.a.c.a)paramVarArgs[0]).am(1, this.ycX);
      AppMethodBeat.o(102412);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.ycX);
      AppMethodBeat.o(102412);
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
      AppMethodBeat.o(102412);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cuf localcuf = (cuf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(102412);
        return -1;
      }
      localcuf.ycX = locala.CLY.sm();
      AppMethodBeat.o(102412);
      return 0;
    }
    AppMethodBeat.o(102412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuf
 * JD-Core Version:    0.7.0.1
 */