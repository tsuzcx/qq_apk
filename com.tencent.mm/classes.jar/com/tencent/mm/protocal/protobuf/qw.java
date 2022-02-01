package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class qw
  extends com.tencent.mm.bw.a
{
  public long GeW;
  public b GeX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43084);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.GeW);
      if (this.GeX != null) {
        paramVarArgs.c(2, this.GeX);
      }
      AppMethodBeat.o(43084);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.GeW) + 0;
      paramInt = i;
      if (this.GeX != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.GeX);
      }
      AppMethodBeat.o(43084);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(43084);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      qw localqw = (qw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43084);
        return -1;
      case 1: 
        localqw.GeW = locala.OmT.zd();
        AppMethodBeat.o(43084);
        return 0;
      }
      localqw.GeX = locala.OmT.gCk();
      AppMethodBeat.o(43084);
      return 0;
    }
    AppMethodBeat.o(43084);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qw
 * JD-Core Version:    0.7.0.1
 */