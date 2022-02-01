package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwg
  extends com.tencent.mm.bw.a
{
  public int Fih;
  public int HHi;
  public int HHk;
  public int Hzh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152672);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hzh);
      paramVarArgs.aS(2, this.HHk);
      paramVarArgs.aS(3, this.HHi);
      paramVarArgs.aS(4, this.Fih);
      AppMethodBeat.o(152672);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Hzh);
      int i = f.a.a.b.b.a.bz(2, this.HHk);
      int j = f.a.a.b.b.a.bz(3, this.HHi);
      int k = f.a.a.b.b.a.bz(4, this.Fih);
      AppMethodBeat.o(152672);
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
      AppMethodBeat.o(152672);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cwg localcwg = (cwg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152672);
        return -1;
      case 1: 
        localcwg.Hzh = locala.OmT.zc();
        AppMethodBeat.o(152672);
        return 0;
      case 2: 
        localcwg.HHk = locala.OmT.zc();
        AppMethodBeat.o(152672);
        return 0;
      case 3: 
        localcwg.HHi = locala.OmT.zc();
        AppMethodBeat.o(152672);
        return 0;
      }
      localcwg.Fih = locala.OmT.zc();
      AppMethodBeat.o(152672);
      return 0;
    }
    AppMethodBeat.o(152672);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwg
 * JD-Core Version:    0.7.0.1
 */