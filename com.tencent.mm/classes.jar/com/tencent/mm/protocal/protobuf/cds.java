package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cds
  extends com.tencent.mm.bw.a
{
  public int HqF;
  public long HqG;
  public long HqH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117883);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HqF);
      paramVarArgs.aZ(2, this.HqG);
      paramVarArgs.aZ(3, this.HqH);
      AppMethodBeat.o(117883);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HqF);
      int i = f.a.a.b.b.a.p(2, this.HqG);
      int j = f.a.a.b.b.a.p(3, this.HqH);
      AppMethodBeat.o(117883);
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
      AppMethodBeat.o(117883);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cds localcds = (cds)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117883);
        return -1;
      case 1: 
        localcds.HqF = locala.OmT.zc();
        AppMethodBeat.o(117883);
        return 0;
      case 2: 
        localcds.HqG = locala.OmT.zd();
        AppMethodBeat.o(117883);
        return 0;
      }
      localcds.HqH = locala.OmT.zd();
      AppMethodBeat.o(117883);
      return 0;
    }
    AppMethodBeat.o(117883);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cds
 * JD-Core Version:    0.7.0.1
 */