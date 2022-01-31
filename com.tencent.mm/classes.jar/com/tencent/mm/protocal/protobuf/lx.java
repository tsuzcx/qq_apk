package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lx
  extends com.tencent.mm.bv.a
{
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151385);
    if (paramInt == 0)
    {
      AppMethodBeat.o(151385);
      return 0;
    }
    if (paramInt == 1)
    {
      AppMethodBeat.o(151385);
      return 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(151385);
      return 0;
    }
    if (paramInt == 3)
    {
      ((Integer)paramVarArgs[2]).intValue();
      AppMethodBeat.o(151385);
      return -1;
    }
    AppMethodBeat.o(151385);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lx
 * JD-Core Version:    0.7.0.1
 */