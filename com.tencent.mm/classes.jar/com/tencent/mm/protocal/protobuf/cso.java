package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cso
  extends com.tencent.mm.bw.a
{
  public int FEN;
  public int Timestamp;
  public int fZz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117906);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FEN);
      paramVarArgs.aR(2, this.Timestamp);
      paramVarArgs.aR(3, this.fZz);
      AppMethodBeat.o(117906);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FEN);
      int i = f.a.a.b.b.a.bx(2, this.Timestamp);
      int j = f.a.a.b.b.a.bx(3, this.fZz);
      AppMethodBeat.o(117906);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117906);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cso localcso = (cso)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117906);
        return -1;
      case 1: 
        localcso.FEN = locala.LVo.xF();
        AppMethodBeat.o(117906);
        return 0;
      case 2: 
        localcso.Timestamp = locala.LVo.xF();
        AppMethodBeat.o(117906);
        return 0;
      }
      localcso.fZz = locala.LVo.xF();
      AppMethodBeat.o(117906);
      return 0;
    }
    AppMethodBeat.o(117906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cso
 * JD-Core Version:    0.7.0.1
 */