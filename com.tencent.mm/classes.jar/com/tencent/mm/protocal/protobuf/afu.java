package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afu
  extends com.tencent.mm.bw.a
{
  public long Gwc;
  public long Gwd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91440);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.Gwc);
      paramVarArgs.aZ(2, this.Gwd);
      AppMethodBeat.o(91440);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.Gwc);
      int i = f.a.a.b.b.a.p(2, this.Gwd);
      AppMethodBeat.o(91440);
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
      AppMethodBeat.o(91440);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      afu localafu = (afu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91440);
        return -1;
      case 1: 
        localafu.Gwc = locala.OmT.zd();
        AppMethodBeat.o(91440);
        return 0;
      }
      localafu.Gwd = locala.OmT.zd();
      AppMethodBeat.o(91440);
      return 0;
    }
    AppMethodBeat.o(91440);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afu
 * JD-Core Version:    0.7.0.1
 */