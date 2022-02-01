package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aid
  extends com.tencent.mm.bw.a
{
  public int GxQ;
  public int gvx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32195);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.gvx);
      paramVarArgs.aS(2, this.GxQ);
      AppMethodBeat.o(32195);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.gvx);
      int i = f.a.a.b.b.a.bz(2, this.GxQ);
      AppMethodBeat.o(32195);
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
      AppMethodBeat.o(32195);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aid localaid = (aid)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32195);
        return -1;
      case 1: 
        localaid.gvx = locala.OmT.zc();
        AppMethodBeat.o(32195);
        return 0;
      }
      localaid.GxQ = locala.OmT.zc();
      AppMethodBeat.o(32195);
      return 0;
    }
    AppMethodBeat.o(32195);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aid
 * JD-Core Version:    0.7.0.1
 */