package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agg
  extends com.tencent.mm.bw.a
{
  public long bpc;
  public long start;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200140);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.start);
      paramVarArgs.aZ(2, this.bpc);
      AppMethodBeat.o(200140);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.start);
      int i = f.a.a.b.b.a.p(2, this.bpc);
      AppMethodBeat.o(200140);
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
      AppMethodBeat.o(200140);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      agg localagg = (agg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(200140);
        return -1;
      case 1: 
        localagg.start = locala.OmT.zd();
        AppMethodBeat.o(200140);
        return 0;
      }
      localagg.bpc = locala.OmT.zd();
      AppMethodBeat.o(200140);
      return 0;
    }
    AppMethodBeat.o(200140);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agg
 * JD-Core Version:    0.7.0.1
 */