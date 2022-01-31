package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmk
  extends com.tencent.mm.bv.a
{
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134435);
    if (paramInt == 0)
    {
      AppMethodBeat.o(134435);
      return 0;
    }
    if (paramInt == 1)
    {
      AppMethodBeat.o(134435);
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
      AppMethodBeat.o(134435);
      return 0;
    }
    if (paramInt == 3)
    {
      ((Integer)paramVarArgs[2]).intValue();
      AppMethodBeat.o(134435);
      return -1;
    }
    AppMethodBeat.o(134435);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmk
 * JD-Core Version:    0.7.0.1
 */