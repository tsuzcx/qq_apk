package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhc
  extends com.tencent.mm.bw.a
{
  public int FNv;
  public int HOf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125803);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FNv);
      paramVarArgs.aS(2, this.HOf);
      AppMethodBeat.o(125803);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FNv);
      int i = f.a.a.b.b.a.bz(2, this.HOf);
      AppMethodBeat.o(125803);
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
      AppMethodBeat.o(125803);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dhc localdhc = (dhc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125803);
        return -1;
      case 1: 
        localdhc.FNv = locala.OmT.zc();
        AppMethodBeat.o(125803);
        return 0;
      }
      localdhc.HOf = locala.OmT.zc();
      AppMethodBeat.o(125803);
      return 0;
    }
    AppMethodBeat.o(125803);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhc
 * JD-Core Version:    0.7.0.1
 */