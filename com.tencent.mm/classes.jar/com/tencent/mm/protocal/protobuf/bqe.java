package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqe
  extends com.tencent.mm.bw.a
{
  public long bbs;
  public long bbt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110902);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.bbs);
      paramVarArgs.aZ(2, this.bbt);
      AppMethodBeat.o(110902);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.bbs);
      int i = f.a.a.b.b.a.p(2, this.bbt);
      AppMethodBeat.o(110902);
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
      AppMethodBeat.o(110902);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bqe localbqe = (bqe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110902);
        return -1;
      case 1: 
        localbqe.bbs = locala.OmT.zd();
        AppMethodBeat.o(110902);
        return 0;
      }
      localbqe.bbt = locala.OmT.zd();
      AppMethodBeat.o(110902);
      return 0;
    }
    AppMethodBeat.o(110902);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqe
 * JD-Core Version:    0.7.0.1
 */