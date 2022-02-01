package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwd
  extends com.tencent.mm.bw.a
{
  public int FQd;
  public long commentId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169084);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FQd);
      paramVarArgs.aZ(2, this.commentId);
      AppMethodBeat.o(169084);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FQd);
      int i = f.a.a.b.b.a.p(2, this.commentId);
      AppMethodBeat.o(169084);
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
      AppMethodBeat.o(169084);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bwd localbwd = (bwd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169084);
        return -1;
      case 1: 
        localbwd.FQd = locala.OmT.zc();
        AppMethodBeat.o(169084);
        return 0;
      }
      localbwd.commentId = locala.OmT.zd();
      AppMethodBeat.o(169084);
      return 0;
    }
    AppMethodBeat.o(169084);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwd
 * JD-Core Version:    0.7.0.1
 */