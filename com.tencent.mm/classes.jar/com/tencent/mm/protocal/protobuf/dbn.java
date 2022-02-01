package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbn
  extends com.tencent.mm.bw.a
{
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50097);
    if (paramInt == 0)
    {
      AppMethodBeat.o(50097);
      return 0;
    }
    if (paramInt == 1)
    {
      AppMethodBeat.o(50097);
      return 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(50097);
      return 0;
    }
    if (paramInt == 3)
    {
      ((Integer)paramVarArgs[2]).intValue();
      AppMethodBeat.o(50097);
      return -1;
    }
    AppMethodBeat.o(50097);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbn
 * JD-Core Version:    0.7.0.1
 */