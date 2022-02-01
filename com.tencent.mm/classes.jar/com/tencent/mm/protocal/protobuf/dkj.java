package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkj
  extends com.tencent.mm.bw.a
{
  public long HRo;
  public int HSg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118457);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.HRo);
      paramVarArgs.aS(2, this.HSg);
      AppMethodBeat.o(118457);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.HRo);
      int i = f.a.a.b.b.a.bz(2, this.HSg);
      AppMethodBeat.o(118457);
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
      AppMethodBeat.o(118457);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dkj localdkj = (dkj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118457);
        return -1;
      case 1: 
        localdkj.HRo = locala.OmT.zd();
        AppMethodBeat.o(118457);
        return 0;
      }
      localdkj.HSg = locala.OmT.zc();
      AppMethodBeat.o(118457);
      return 0;
    }
    AppMethodBeat.o(118457);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkj
 * JD-Core Version:    0.7.0.1
 */