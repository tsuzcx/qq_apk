package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lb
  extends com.tencent.mm.bw.a
{
  public int FUA;
  public int FVG;
  public int FVH;
  public int FVI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32145);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FUA);
      paramVarArgs.aS(2, this.FVG);
      paramVarArgs.aS(3, this.FVH);
      paramVarArgs.aS(4, this.FVI);
      AppMethodBeat.o(32145);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FUA);
      int i = f.a.a.b.b.a.bz(2, this.FVG);
      int j = f.a.a.b.b.a.bz(3, this.FVH);
      int k = f.a.a.b.b.a.bz(4, this.FVI);
      AppMethodBeat.o(32145);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32145);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      lb locallb = (lb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32145);
        return -1;
      case 1: 
        locallb.FUA = locala.OmT.zc();
        AppMethodBeat.o(32145);
        return 0;
      case 2: 
        locallb.FVG = locala.OmT.zc();
        AppMethodBeat.o(32145);
        return 0;
      case 3: 
        locallb.FVH = locala.OmT.zc();
        AppMethodBeat.o(32145);
        return 0;
      }
      locallb.FVI = locala.OmT.zc();
      AppMethodBeat.o(32145);
      return 0;
    }
    AppMethodBeat.o(32145);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lb
 * JD-Core Version:    0.7.0.1
 */