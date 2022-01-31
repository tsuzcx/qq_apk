package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ced
  extends com.tencent.mm.bv.a
{
  public int xOD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94580);
    if (paramInt == 0)
    {
      ((e.a.a.c.a)paramVarArgs[0]).aO(1, this.xOD);
      AppMethodBeat.o(94580);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xOD);
      AppMethodBeat.o(94580);
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
      AppMethodBeat.o(94580);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ced localced = (ced)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(94580);
        return -1;
      }
      localced.xOD = locala.CLY.sl();
      AppMethodBeat.o(94580);
      return 0;
    }
    AppMethodBeat.o(94580);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ced
 * JD-Core Version:    0.7.0.1
 */