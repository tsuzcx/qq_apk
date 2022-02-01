package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alh
  extends com.tencent.mm.bw.a
{
  public int GDA = 0;
  public long endTime = 0L;
  public long startTime = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.startTime);
      paramVarArgs.aZ(2, this.endTime);
      paramVarArgs.aS(3, this.GDA);
      AppMethodBeat.o(122489);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.startTime);
      int i = f.a.a.b.b.a.p(2, this.endTime);
      int j = f.a.a.b.b.a.bz(3, this.GDA);
      AppMethodBeat.o(122489);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(122489);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      alh localalh = (alh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122489);
        return -1;
      case 1: 
        localalh.startTime = locala.OmT.zd();
        AppMethodBeat.o(122489);
        return 0;
      case 2: 
        localalh.endTime = locala.OmT.zd();
        AppMethodBeat.o(122489);
        return 0;
      }
      localalh.GDA = locala.OmT.zc();
      AppMethodBeat.o(122489);
      return 0;
    }
    AppMethodBeat.o(122489);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alh
 * JD-Core Version:    0.7.0.1
 */