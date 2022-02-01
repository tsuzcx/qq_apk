package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djl
  extends com.tencent.mm.bw.a
{
  public int kyd;
  public int phB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116817);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.phB);
      paramVarArgs.aS(2, this.kyd);
      AppMethodBeat.o(116817);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.phB);
      int i = f.a.a.b.b.a.bz(2, this.kyd);
      AppMethodBeat.o(116817);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(116817);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      djl localdjl = (djl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116817);
        return -1;
      case 1: 
        localdjl.phB = locala.OmT.zc();
        AppMethodBeat.o(116817);
        return 0;
      }
      localdjl.kyd = locala.OmT.zc();
      AppMethodBeat.o(116817);
      return 0;
    }
    AppMethodBeat.o(116817);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djl
 * JD-Core Version:    0.7.0.1
 */